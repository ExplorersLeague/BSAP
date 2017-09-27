package com.blizzard.telemetry.sdk.implementation;

import com.blizzard.telemetry.proto.Context;
import com.blizzard.telemetry.proto.Context.Builder;
import com.blizzard.telemetry.proto.Context.HostInfo;
import com.blizzard.telemetry.proto.Context.HostInfo.Builder;
import com.blizzard.telemetry.proto.Context.ProgramInfo;
import com.blizzard.telemetry.proto.Context.ProgramInfo.Builder;
import com.blizzard.telemetry.proto.Context.ProgramInfo.SdkInfo;
import com.blizzard.telemetry.proto.Context.ProgramInfo.SdkInfo.Builder;
import com.blizzard.telemetry.proto.Envelope;
import com.blizzard.telemetry.proto.Envelope.Builder;
import com.blizzard.telemetry.proto.standard.Alert;
import com.blizzard.telemetry.proto.standard.network.ConnectFail;
import com.blizzard.telemetry.proto.standard.network.ConnectSuccess;
import com.blizzard.telemetry.proto.standard.network.Disconnect;
import com.blizzard.telemetry.proto.standard.network.TcpQualitySample;
import com.blizzard.telemetry.proto.standard.network.UdpQualitySample;
import com.blizzard.telemetry.proto.standard.process.Finish;
import com.blizzard.telemetry.proto.standard.process.Finish.Builder;
import com.blizzard.telemetry.proto.standard.process.Start;
import com.blizzard.telemetry.proto.standard.process.Start.Builder;
import com.blizzard.telemetry.sdk.EnqueueOptions;
import com.blizzard.telemetry.sdk.LogWrapper;
import com.blizzard.telemetry.sdk.MultiPendingMessage;
import com.blizzard.telemetry.sdk.PackageMessageNamePair;
import com.blizzard.telemetry.sdk.PendingMessage;
import com.blizzard.telemetry.sdk.RateLimitWindow;
import com.blizzard.telemetry.sdk.Request;
import com.blizzard.telemetry.sdk.Response;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import com.blizzard.telemetry.sdk.TelemetryStatistics;
import com.blizzard.telemetry.sdk.interfaces.Platform;
import com.blizzard.telemetry.sdk.interfaces.RequestHandler;
import com.blizzard.telemetry.sdk.interfaces.RetryHandler;
import com.blizzard.telemetry.sdk.interfaces.Telemetry;
import com.blizzard.telemetry.sdk.interfaces.TelemetryQueueProcessor;
import com.blizzard.telemetry.sdk.tools.BiConsumer;
import com.blizzard.telemetry.sdk.tools.BiEventHandler;
import com.blizzard.telemetry.sdk.tools.Clock;
import com.blizzard.telemetry.sdk.tools.Consumer;
import com.blizzard.telemetry.sdk.tools.EventHandler;
import com.blizzard.telemetry.sdk.tools.FutureCallback;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class TelemetryService
  implements Telemetry
{
  private static final String standardProtoPackage = "com.blizzard.telemetry.proto.standard";
  protected LogWrapper LOGGER = LogWrapper.NullLogger(TelemetryService.class);
  private Clock clock = Clock.systemUTC();
  private final long durationBetweenQueueOverflowLogMessages = 1000L;
  private boolean initialized = false;
  private Long lastQueueOverflowTimestamp;
  private Map<String, PackageMessageNamePair> messageNames = new HashMap();
  private TelemetryOptions options;
  private Platform platform;
  private EventHandler<PendingMessage> queueOverflow = new EventHandler();
  private AtomicLong queueOverflowEventsSinceLastLog = new AtomicLong();
  private TelemetryQueueProcessor queueProcessor;
  private RateLimitWindow rateLimitWindow;
  private BiEventHandler<PendingMessage, Response> requestFailed = new BiEventHandler();
  private RequestHandler requestHandler;
  private BiEventHandler<PendingMessage, Response> requestSucceeded = new BiEventHandler();
  private RetryHandler retryHandler;
  private TelemetryStatistics stats;
  private String userAgent;
  
  public TelemetryService()
  {
    this(null, new TelemetryQueueProcessorImpl(null), new SimpleRetryHandler());
  }
  
  public TelemetryService(RequestHandler paramRequestHandler)
  {
    this(paramRequestHandler, new TelemetryQueueProcessorImpl(paramRequestHandler), new SimpleRetryHandler());
  }
  
  public TelemetryService(RequestHandler paramRequestHandler, TelemetryQueueProcessor paramTelemetryQueueProcessor, RetryHandler paramRetryHandler)
  {
    this.requestHandler = paramRequestHandler;
    this.queueProcessor = paramTelemetryQueueProcessor;
    this.retryHandler = paramRetryHandler;
    this.rateLimitWindow = new RateLimitWindow();
  }
  
  private boolean canAutoRegister(Class<?> paramClass)
  {
    return (paramClass != null) && (packageNameFromClass(paramClass).startsWith("Blizzard.Telemetry."));
  }
  
  private String packageNameFromClass(Class<?> paramClass)
  {
    String str1 = paramClass.getName();
    String str2 = paramClass.getSimpleName();
    str1 = str1.replace("com.blizzard.telemetry.", "Blizzard.Telemetry.").replace("Blizzard.Telemetry.proto.", "Blizzard.Telemetry.").replace(".standard.", ".Standard.").replace(".logging.", ".Logging.").replace(".network.", ".Network.").replace(".process.", ".Process.");
    paramClass = str1;
    if (str1.endsWith("." + str2)) {
      paramClass = str1.substring(0, str1.length() - (str2.length() + 1));
    }
    return paramClass;
  }
  
  private void raiseFailed(PendingMessage paramPendingMessage, Response paramResponse)
    throws IllegalArgumentException
  {
    if (paramPendingMessage == null) {
      throw new IllegalArgumentException("raiseFailed: but 'pendingMessage' is null.");
    }
    if (paramResponse == null) {
      throw new IllegalArgumentException("raiseFailed: but 'response' is null.");
    }
    synchronized (this.stats)
    {
      this.stats.setMessagesFailed(this.stats.getMessagesFailed() + 1);
      this.stats.incrementVerbMessage("Failed", paramPendingMessage.getPackageMessageName());
      this.requestFailed.newEvent(paramPendingMessage, paramResponse);
      return;
    }
  }
  
  private void raiseFailed(PendingMessage paramPendingMessage, Throwable paramThrowable)
    throws IllegalArgumentException
  {
    if (paramPendingMessage == null) {
      throw new IllegalArgumentException("raiseFailed: but 'pendingMessage' is null.");
    }
    if (paramThrowable == null) {
      throw new IllegalArgumentException("raiseFailed: but 'e' is null.");
    }
    raiseFailed(paramPendingMessage, new Response(paramThrowable));
  }
  
  private void raiseQueueOverflow(PendingMessage paramPendingMessage)
  {
    if ((this.lastQueueOverflowTimestamp == null) || (this.clock.millis() - this.lastQueueOverflowTimestamp.longValue() > 1000L))
    {
      this.LOGGER.LogWarn("Queue Overflow: Request.{0} dropped! QueueCount={1}/{2}, PendingRequestCount={3}/{4}.", new Object[] { Long.valueOf(paramPendingMessage.id()), Integer.valueOf(getQueueCount()), Integer.valueOf(this.options.getMaxQueueSize()), Integer.valueOf(getPendingRequestCount()), Integer.valueOf(this.options.getMaxConcurrentRequests()) });
      if (this.queueOverflowEventsSinceLastLog.get() > 0L) {
        this.LOGGER.LogWarn("Queue Overflow: {0} messages have been dropped since the last Queue Overflow message was logged.", new Object[] { Long.valueOf(this.queueOverflowEventsSinceLastLog.get()) });
      }
      this.lastQueueOverflowTimestamp = Long.valueOf(this.clock.millis());
      this.queueOverflowEventsSinceLastLog.set(0L);
    }
    for (;;)
    {
      this.queueOverflow.newEvent(paramPendingMessage);
      return;
      this.queueOverflowEventsSinceLastLog.incrementAndGet();
    }
  }
  
  private void raiseSucceeded(PendingMessage paramPendingMessage, Response paramResponse)
    throws IllegalArgumentException
  {
    if (paramPendingMessage == null) {
      throw new IllegalArgumentException("raiseSucceeded: but 'pendingMessage' is null.");
    }
    if (paramResponse == null) {
      throw new IllegalArgumentException("raiseSucceeded: but 'response' is null.");
    }
    synchronized (this.stats)
    {
      this.stats.setMessagesSent(this.stats.getMessagesSent() + 1);
      this.stats.incrementVerbMessage("Sent", paramPendingMessage.getPackageMessageName());
      this.requestSucceeded.newEvent(paramPendingMessage, paramResponse);
      return;
    }
  }
  
  private Consumer<MultiPendingMessage> sendMultiMessageConsumer()
  {
    new Consumer()
    {
      public void accept(final MultiPendingMessage paramAnonymousMultiPendingMessage)
      {
        TelemetryService.this.LOGGER.LogInfo("consuming multiPendingMessage with {0} inner PendingMessage(s)", new Object[] { Integer.valueOf(paramAnonymousMultiPendingMessage.count()) });
        ??? = new ArrayList();
        for (;;)
        {
          try
          {
            TelemetryService.this.rateLimitWindow.incrementAndWaitIfNecessary();
            i = 0;
            if (i < paramAnonymousMultiPendingMessage.count())
            {
              ??? = paramAnonymousMultiPendingMessage.get(i);
              TelemetryService.this.LOGGER.LogInfo("inner: {0}: {1}", new Object[] { Long.valueOf(((PendingMessage)???).id()), ((PendingMessage)???).getPackageMessageName() });
              ((List)???).add(Integer.valueOf((int)((PendingMessage)???).id()));
              ((PendingMessage)???).setRequestHeader("User-Agent", TelemetryService.this.userAgent);
              ((PendingMessage)???).setEnvelope((Envelope)((Envelope.Builder)((PendingMessage)???).getEnvelope().toBuilder()).setContext((Context)((Context.Builder)((PendingMessage)???).getEnvelope().getContext().toBuilder()).setTimeOffset(TelemetryService.this.clock.millis() - ((PendingMessage)???).getEnvelope().getContext().getSourceTime()).setRetryCount(((PendingMessage)???).getRetryCount()).build()).build());
              i += 1;
              continue;
            }
            paramAnonymousMultiPendingMessage.setRequestHeader("User-Agent", TelemetryService.this.userAgent);
          }
          catch (Exception localException)
          {
            int i;
            final long l;
            TelemetryService.this.LOGGER.LogWarn("Exception while sending a multiRequest with {0} to the RequestHandler. EX: {1}", new Object[] { ???, localException.getMessage() });
            localException.printStackTrace();
            synchronized (TelemetryService.this.stats)
            {
              TelemetryService.this.stats.setRequestsFailed(TelemetryService.this.stats.getRequestsFailed() + 1);
              ??? = new Response(localException);
              i = 0;
              if (i >= paramAnonymousMultiPendingMessage.count()) {
                continue;
              }
              TelemetryService.this.raiseFailed(paramAnonymousMultiPendingMessage.get(i), (Response)???);
              i += 1;
            }
          }
          synchronized (TelemetryService.this.stats)
          {
            TelemetryService.this.stats.setRequests(TelemetryService.this.stats.getRequests() + 1);
            l = TelemetryService.this.clock.millis();
            TelemetryService.this.requestHandler.sendRequest(paramAnonymousMultiPendingMessage.buildRequest().setUri(TelemetryService.this.options.getIngestUrl()), new FutureCallback()
            {
              public void onFailure(Throwable paramAnonymous2Throwable)
              {
                TelemetryService.this.LOGGER.LogInfo("onFailure response to multiRequest with {0} - {1}", new Object[] { paramAnonymousMultiPendingMessage, paramAnonymous2Throwable.getMessage() });
                synchronized (TelemetryService.this.stats)
                {
                  TelemetryService.this.stats.setRequestsFailed(TelemetryService.this.stats.getRequestsFailed() + 1);
                  int i = 0;
                  if (i < this.val$multiRequest.count())
                  {
                    TelemetryService.this.raiseFailed(this.val$multiRequest.get(i), paramAnonymous2Throwable);
                    i += 1;
                  }
                }
              }
              
              public void onSuccess(Response paramAnonymous2Response)
              {
                if (paramAnonymous2Response == null) {
                  onFailure(new IllegalArgumentException("onSuccess(null)"));
                }
                for (;;)
                {
                  return;
                  TelemetryService.this.LOGGER.LogInfo("FutureCallback.onSuccess(...);");
                  paramAnonymous2Response.setRequestDurationMs(TelemetryService.this.clock.millis() - l);
                  int i;
                  if (((paramAnonymous2Response.getCode().intValue() >= 400) && (paramAnonymous2Response.getCode().intValue() <= 499)) || (paramAnonymous2Response.getCode().intValue() >= 600)) {
                    i = 1;
                  }
                  for (;;)
                  {
                    boolean bool;
                    int j;
                    if (((paramAnonymous2Response.getCode().intValue() >= 500) && (paramAnonymous2Response.getCode().intValue() <= 599)) || (paramAnonymous2Response.getCode().intValue() <= 199))
                    {
                      bool = true;
                      TelemetryService.this.LOGGER.LogInfo("onSuccess({0}) response to multiRequest with {1}", new Object[] { paramAnonymous2Response.getCode(), paramAnonymousMultiPendingMessage });
                      TelemetryService.this.LOGGER.LogInfo(".isRetryEnabled={0} .shouldRetry(response)={1}={2}", new Object[] { Boolean.valueOf(TelemetryService.this.options.isRetryEnabled()), Boolean.valueOf(TelemetryService.this.retryHandler.shouldRetry(paramAnonymous2Response)), Boolean.valueOf(bool) });
                      if ((TelemetryService.this.options.isRetryEnabled()) && (TelemetryService.this.retryHandler.shouldRetry(paramAnonymous2Response)))
                      {
                        TelemetryService.this.LOGGER.LogInfo("ReQueuing {0} request(s) for retry.{1}", new Object[] { Integer.valueOf(this.val$multiRequest.count()), paramAnonymousMultiPendingMessage });
                        j = 0;
                        label320:
                        if (j >= this.val$multiRequest.count()) {}
                      }
                    }
                    else
                    {
                      try
                      {
                        TelemetryService.this.retryHandler.queueForRetry(this.val$multiRequest.get(j));
                        j += 1;
                        break label320;
                        i = 0;
                        continue;
                        bool = false;
                      }
                      catch (IllegalStateException localIllegalStateException)
                      {
                        for (;;)
                        {
                          TelemetryService.this.LOGGER.LogError("Error queuing request for later retry! {0}", new Object[] { localIllegalStateException });
                          TelemetryService.this.raiseFailed(this.val$multiRequest.get(j), paramAnonymous2Response.setException(localIllegalStateException));
                        }
                      }
                    }
                  }
                  if (i == 0) {
                    try
                    {
                      TelemetryService.this.processHeaders(paramAnonymous2Response);
                    }
                    catch (Exception localException)
                    {
                      synchronized (TelemetryService.this.stats)
                      {
                        TelemetryService.this.stats.setRequestsSucceeded(TelemetryService.this.stats.getRequestsSucceeded() + 1);
                        i = 0;
                        while (i < this.val$multiRequest.count())
                        {
                          TelemetryService.this.raiseSucceeded(this.val$multiRequest.get(i), paramAnonymous2Response);
                          i += 1;
                        }
                        localException = localException;
                        TelemetryService.this.LOGGER.LogError("Error processing the headers in the response to a batched request! {0}", new Object[] { localException });
                      }
                    }
                  }
                  synchronized (TelemetryService.this.stats)
                  {
                    TelemetryService.this.stats.setRequestsFailed(TelemetryService.this.stats.getRequestsFailed() + 1);
                    i = 0;
                    if (i >= this.val$multiRequest.count()) {
                      continue;
                    }
                    TelemetryService.this.raiseFailed(this.val$multiRequest.get(i), paramAnonymous2Response);
                    i += 1;
                  }
                }
              }
            });
            return;
          }
        }
      }
    };
  }
  
  protected boolean CheckRequiredContextFields(Context paramContext)
    throws IllegalArgumentException
  {
    if (paramContext == null)
    {
      this.LOGGER.LogError("CheckRequiredContextFields: argument 'context' is null");
      throw new IllegalArgumentException("CheckRequiredContextFields: argument 'context' is null");
    }
    if ((!paramContext.hasSessionId()) || (paramContext.getSessionId().isEmpty()))
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.SessionId' is null or empty");
      return false;
    }
    if (!paramContext.hasProgram())
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Program' is null");
      return false;
    }
    if ((!paramContext.getProgram().hasId()) || (paramContext.getProgram().getId().isEmpty()))
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Program.Id' is null or empty");
      return false;
    }
    if ((!paramContext.getProgram().hasName()) || (paramContext.getProgram().getName().isEmpty()))
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Program.Name' is null or empty");
      return false;
    }
    if ((!paramContext.getProgram().hasVersion()) || (paramContext.getProgram().getVersion().isEmpty()))
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Program.Version' is null or empty");
      return false;
    }
    if (!paramContext.getProgram().hasSdk())
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Program.Sdk' is null");
      return false;
    }
    if ((!paramContext.getProgram().getSdk().hasName()) || (paramContext.getProgram().getSdk().getName().isEmpty()))
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Program.Sdk.Name' is null or empty");
      return false;
    }
    if ((!paramContext.getProgram().getSdk().hasVersion()) || (paramContext.getProgram().getSdk().getVersion().isEmpty()))
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Program.Sdk.Version' is null or empty");
      return false;
    }
    if (!paramContext.hasHost())
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Host' is null");
      return false;
    }
    if ((!paramContext.getHost().hasId()) || (paramContext.getHost().getId().isEmpty()))
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Host.Id' is null or empty");
      return false;
    }
    if ((!paramContext.getHost().hasType()) || (paramContext.getHost().getType().isEmpty()))
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Host.Type' is null or empty");
      return false;
    }
    if ((!paramContext.getHost().hasPlatform()) || (paramContext.getHost().getPlatform().isEmpty()))
    {
      this.LOGGER.LogError("CheckContextRequiredFields: argument 'context.Host.Platform' is null or empty");
      return false;
    }
    return true;
  }
  
  protected Context SetRequiredContextFields(Context paramContext)
    throws IllegalStateException, IllegalArgumentException
  {
    if (this.options == null) {
      throw new IllegalStateException("SetRequiredContextFields: argument 'options' is null");
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("SetRequiredContextFields: argument 'context' is null");
    }
    Object localObject2 = this.platform.sdkName();
    Object localObject3 = this.platform.sdkVersion();
    Object localObject6;
    Object localObject5;
    Object localObject1;
    if ((localObject2 != null) && (!((String)localObject2).isEmpty()) && (localObject3 != null))
    {
      localObject6 = localObject2;
      localObject5 = localObject3;
      if (!((String)localObject3).isEmpty()) {}
    }
    else
    {
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((String)localObject2).isEmpty()) {}
      }
      else
      {
        localObject1 = "telemetry-sdk-" + this.platform.platformName();
      }
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (!((String)localObject3).isEmpty()) {}
      }
      else
      {
        localObject2 = "2.0";
      }
      System.err.println("warning: Platform failed to find SDK details, use '" + (String)localObject1 + "'+'" + (String)localObject2 + "'");
      localObject5 = localObject2;
      localObject6 = localObject1;
    }
    Context.Builder localBuilder = (Context.Builder)paramContext.toBuilder();
    Object localObject4 = "";
    localObject3 = "";
    int i;
    if ((!localBuilder.hasProgram()) || (localBuilder.getProgram() == null) || (!localBuilder.getProgram().hasName()) || (localBuilder.getProgram().getName() == null) || (localBuilder.getProgram().getName().isEmpty()) || (!localBuilder.getProgram().hasVersion()) || (localBuilder.getProgram().getVersion() == null) || (localBuilder.getProgram().getVersion().isEmpty()))
    {
      Class[] arrayOfClass = new SecurityManager()
      {
        public Class<?>[] getCallingClasses()
        {
          return getClassContext();
        }
      }.getCallingClasses();
      localObject2 = localObject4;
      localObject1 = localObject3;
      if (arrayOfClass != null)
      {
        String str = arrayOfClass[0].getPackage().getName();
        i = 2;
        localObject2 = localObject4;
        localObject1 = localObject3;
        if (i < arrayOfClass.length)
        {
          localObject2 = localObject4;
          localObject1 = localObject3;
          if (arrayOfClass[i] == null) {
            break label1288;
          }
          localObject2 = localObject4;
          localObject1 = localObject3;
          if (arrayOfClass[i].getPackage() == null) {
            break label1288;
          }
          localObject2 = localObject4;
          localObject1 = localObject3;
          if (arrayOfClass[i].getPackage().getName() == null) {
            break label1288;
          }
          localObject2 = localObject4;
          localObject1 = localObject3;
          if (arrayOfClass[i].getPackage().getName().isEmpty()) {
            break label1288;
          }
          localObject2 = arrayOfClass[i].getPackage().getName();
          localObject1 = arrayOfClass[i].getPackage().getImplementationVersion();
          if (((String)localObject2).equals(str)) {
            break label1279;
          }
        }
      }
      if (!localBuilder.hasProgram()) {
        break label1302;
      }
      localObject3 = (Context.ProgramInfo.Builder)localBuilder.getProgram().toBuilder();
      label494:
      if (((!localBuilder.getProgram().hasName()) || (localBuilder.getProgram().getName() == null) || (localBuilder.getProgram().getName().isEmpty())) && (localObject2 != null) && (!((String)localObject2).isEmpty())) {
        ((Context.ProgramInfo.Builder)localObject3).setName((String)localObject2);
      }
      if (((!localBuilder.getProgram().hasVersion()) || (localBuilder.getProgram().getVersion() == null) || (localBuilder.getProgram().getVersion().isEmpty())) && (localObject1 != null) && (!((String)localObject1).isEmpty())) {
        ((Context.ProgramInfo.Builder)localObject3).setVersion((String)localObject1);
      }
      if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
        System.err.println("warning: SecurityManager.getCallingClasses() did NOT return caller to SDK.");
      }
      localBuilder.setProgram((Context.ProgramInfo)((Context.ProgramInfo.Builder)localObject3).build());
    }
    else
    {
      if ((!localBuilder.getProgram().hasSdk()) || (localBuilder.getProgram().getSdk() == null) || (!localBuilder.getProgram().getSdk().hasName()) || (localBuilder.getProgram().getSdk().getName().isEmpty()) || (!localBuilder.getProgram().getSdk().hasVersion()) || (localBuilder.getProgram().getSdk().getVersion().isEmpty()))
      {
        if (!localBuilder.getProgram().hasSdk()) {
          break label1310;
        }
        localObject1 = (Context.ProgramInfo.SdkInfo.Builder)localBuilder.getProgram().getSdk().toBuilder();
        label751:
        if (((!localBuilder.getProgram().getSdk().hasName()) || (localBuilder.getProgram().getSdk().getName().isEmpty())) && (localObject6 != null) && (!((String)localObject6).isEmpty())) {
          ((Context.ProgramInfo.SdkInfo.Builder)localObject1).setName((String)localObject6);
        }
        if (((!localBuilder.getProgram().getSdk().hasVersion()) || (localBuilder.getProgram().getSdk().getVersion().isEmpty())) && (localObject5 != null) && (!((String)localObject5).isEmpty())) {
          ((Context.ProgramInfo.SdkInfo.Builder)localObject1).setVersion((String)localObject5);
        }
        localBuilder.setProgram((Context.ProgramInfo)((Context.ProgramInfo.Builder)paramContext.getProgram().toBuilder()).setSdk((Context.ProgramInfo.SdkInfo)((Context.ProgramInfo.SdkInfo.Builder)localObject1).build()).build());
      }
      if ((!localBuilder.hasSessionId()) || (localBuilder.getSessionId() == null) || (localBuilder.getSessionId().isEmpty())) {
        localBuilder.setSessionId(UUID.randomUUID().toString());
      }
      if (!paramContext.hasHost()) {
        break label1317;
      }
      paramContext = (Context.HostInfo.Builder)paramContext.getHost().toBuilder();
      label942:
      if (!this.options.isClient()) {
        break label1324;
      }
      localObject1 = "client";
      label956:
      paramContext.setType((String)localObject1);
      if ((!this.options.isClient()) && ((!paramContext.hasName()) || (paramContext.getName() == null) || (paramContext.getName().isEmpty()))) {
        paramContext.setName(this.platform.getHostName());
      }
      if ((!paramContext.hasId()) || (paramContext.getId() == null) || (paramContext.getId().isEmpty()))
      {
        if (!this.options.isClient()) {
          break label1331;
        }
        paramContext.setId(this.platform.getDeviceId());
      }
    }
    for (;;)
    {
      if ((!this.options.isClient()) && ((!paramContext.hasSite()) || (paramContext.getSite() == null) || (paramContext.getSite().isEmpty())))
      {
        localObject1 = paramContext.getName();
        if ((localObject1 != null) && (!((String)localObject1).isEmpty()) && (((String)localObject1).contains("-")))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).indexOf('-'));
          if (!((String)localObject1).isEmpty()) {
            paramContext.setSite((String)localObject1);
          }
        }
      }
      if ((!paramContext.hasPlatform()) || (paramContext.getPlatform() == null) || (paramContext.getPlatform().isEmpty())) {
        paramContext.setPlatform(this.platform.platformName());
      }
      if ((!paramContext.hasOsName()) || (paramContext.getOsName() == null) || (paramContext.getOsName().isEmpty())) {
        paramContext.setOsName(Platform.systemType);
      }
      if ((!paramContext.hasOsVersion()) || (paramContext.getOsVersion() == null) || (paramContext.getOsVersion().isEmpty())) {
        paramContext.setOsVersion(Platform.systemVersion);
      }
      localBuilder.setHost((Context.HostInfo)paramContext.build());
      localBuilder.clearSourceTime().clearTimeOffset().clearRetryCount();
      return (Context)localBuilder.build();
      label1279:
      localObject2 = "";
      localObject1 = "";
      label1288:
      i += 1;
      localObject4 = localObject2;
      localObject3 = localObject1;
      break;
      label1302:
      localObject3 = Context.ProgramInfo.newBuilder();
      break label494;
      label1310:
      localObject1 = Context.ProgramInfo.SdkInfo.newBuilder();
      break label751;
      label1317:
      paramContext = Context.HostInfo.newBuilder();
      break label942;
      label1324:
      localObject1 = "server";
      break label956;
      label1331:
      paramContext.setId(paramContext.getName());
    }
  }
  
  public void close()
  {
    this.queueProcessor.close();
    this.requestHandler.close();
    this.initialized = false;
  }
  
  public Future<Void> complete()
  {
    if (!this.queueProcessor.isCompletionRequested())
    {
      if (this.options == null) {
        break label96;
      }
      if (this.options.autoEnqueueProcessStartFinish()) {
        enqueue(Finish.newBuilder().setPid(this.platform.getProcessId()).setExitCode(0).build());
      }
      if (this.options.isRetryEnabled()) {
        this.retryHandler.complete();
      }
    }
    for (;;)
    {
      this.LOGGER.LogInfo("Entering completion mode.");
      return this.queueProcessor.complete();
      label96:
      this.LOGGER.LogWarn("Completing without ever initializeing!");
    }
  }
  
  protected Envelope createEnvelope(String paramString1, String paramString2, ByteString paramByteString, EnqueueOptions paramEnqueueOptions)
    throws IllegalStateException, IllegalArgumentException
  {
    if (!this.initialized) {
      throw new IllegalStateException("createEnvelope: Telemetry must be initialized before use");
    }
    if (this.options == null) {
      throw new IllegalStateException("createEnvelope: argument 'this.options' is null");
    }
    if (this.options.getDefaultContext() == null) {
      throw new IllegalStateException("createEnvelope: argument 'this.options.getDefaultContext()' is null");
    }
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      throw new IllegalArgumentException("createEnvelope: but 'packageName' is null or empty.");
    }
    if ((paramString2 == null) || (paramString2.isEmpty())) {
      throw new IllegalArgumentException("createEnvelope: but 'messageName' is null or empty.");
    }
    if (paramByteString == null) {
      throw new IllegalArgumentException("createEnvelope: but 'serializedMessage' is null.");
    }
    Context.Builder localBuilder = Context.newBuilder();
    localBuilder.mergeFrom(this.options.getDefaultContext());
    if ((paramEnqueueOptions != null) && (paramEnqueueOptions.getContext() != null)) {
      localBuilder.mergeFrom(paramEnqueueOptions.getContext());
    }
    localBuilder.setSessionId(this.options.getDefaultContext().getSessionId());
    if (localBuilder.getSourceTime() == 0L) {
      localBuilder.setSourceTime(this.clock.millis());
    }
    localBuilder.setTimeOffset(this.clock.millis() - localBuilder.getSourceTime());
    this.LOGGER.LogDebug("envelope: {0} / {1}, #{2}, ...", new Object[] { paramString1, paramString2, Integer.valueOf(paramByteString.size()) });
    return (Envelope)Envelope.newBuilder().setPackageName(paramString1).setMessageName(paramString2).setContext((Context)localBuilder.build()).setContents(paramByteString).build();
  }
  
  protected Envelope createEnvelope(String paramString1, String paramString2, MessageLite paramMessageLite, EnqueueOptions paramEnqueueOptions)
    throws IllegalArgumentException
  {
    if (paramMessageLite == null) {
      throw new IllegalArgumentException("createEnvelope: but 'message' is null.");
    }
    return createEnvelope(paramString1, paramString2, paramMessageLite.toByteString(), paramEnqueueOptions);
  }
  
  public PendingMessage createPendingMessage(MessageLite paramMessageLite)
    throws IllegalArgumentException
  {
    if (paramMessageLite == null) {
      throw new IllegalArgumentException("enqueue: argument 'message' is null");
    }
    return createPendingMessage(paramMessageLite, EnqueueOptions.defaults());
  }
  
  public PendingMessage createPendingMessage(MessageLite paramMessageLite, EnqueueOptions paramEnqueueOptions)
    throws IllegalArgumentException
  {
    if (paramMessageLite == null) {
      throw new IllegalArgumentException("enqueue: argument 'message' is null");
    }
    if (paramEnqueueOptions == null) {
      throw new IllegalArgumentException("enqueue: argument 'options' is null");
    }
    PackageMessageNamePair localPackageMessageNamePair = getPackageMessageNamePair(paramMessageLite);
    return createPendingMessage(localPackageMessageNamePair.getPackageName(), localPackageMessageNamePair.getMessageName(), paramMessageLite.toByteString(), paramEnqueueOptions);
  }
  
  public PendingMessage createPendingMessage(String paramString1, String paramString2, ByteString paramByteString, EnqueueOptions paramEnqueueOptions)
    throws IllegalStateException, IllegalArgumentException
  {
    if (paramByteString == null) {
      throw new IllegalArgumentException("createEnvelope: but 'serializedMessage' is null.");
    }
    if (this.options == null) {
      throw new IllegalStateException("createRequest: argument 'this.options' is null");
    }
    if (this.options.getDefaultContext() == null) {
      throw new IllegalStateException("createRequest: argument 'this.options.getDefaultContext()' is null");
    }
    return new PendingMessage().setOptions(paramEnqueueOptions).setEnvelope(createEnvelope(paramString1, paramString2, paramByteString, paramEnqueueOptions));
  }
  
  public PendingMessage createPendingMessage(String paramString1, String paramString2, MessageLite paramMessageLite)
    throws IllegalArgumentException
  {
    if (paramMessageLite == null) {
      throw new IllegalArgumentException("enqueue: argument 'message' is null");
    }
    return createPendingMessage(paramString1, paramString2, paramMessageLite.toByteString(), EnqueueOptions.defaults());
  }
  
  public PendingMessage createPendingMessage(String paramString1, String paramString2, MessageLite paramMessageLite, EnqueueOptions paramEnqueueOptions)
    throws IllegalArgumentException
  {
    if (paramMessageLite == null) {
      throw new IllegalArgumentException("enqueue: argument 'message' is null");
    }
    if (paramEnqueueOptions == null) {
      throw new IllegalArgumentException("enqueue: argument 'options' is null");
    }
    return createPendingMessage(paramString1, paramString2, paramMessageLite.toByteString(), paramEnqueueOptions);
  }
  
  public boolean enqueue(MessageLite paramMessageLite)
  {
    return enqueue(paramMessageLite, EnqueueOptions.defaults());
  }
  
  public boolean enqueue(MessageLite paramMessageLite, EnqueueOptions paramEnqueueOptions)
    throws IllegalArgumentException
  {
    if (paramMessageLite == null) {
      throw new IllegalArgumentException("enqueue: argument 'message' is null");
    }
    if (paramEnqueueOptions == null) {
      throw new IllegalArgumentException("enqueue: argument 'options' is null");
    }
    PackageMessageNamePair localPackageMessageNamePair = getPackageMessageNamePair(paramMessageLite);
    return enqueuePendingMessage(createPendingMessage(localPackageMessageNamePair.getPackageName(), localPackageMessageNamePair.getMessageName(), paramMessageLite.toByteString(), paramEnqueueOptions));
  }
  
  public boolean enqueue(String paramString1, String paramString2, ByteString paramByteString)
  {
    return enqueue(paramString1, paramString2, paramByteString, EnqueueOptions.defaults());
  }
  
  public boolean enqueue(String paramString1, String paramString2, ByteString paramByteString, EnqueueOptions paramEnqueueOptions)
  {
    return enqueuePendingMessage(createPendingMessage(paramString1, paramString2, paramByteString, paramEnqueueOptions));
  }
  
  public boolean enqueuePendingMessage(PendingMessage paramPendingMessage)
  {
    return enqueuePendingMessage(paramPendingMessage, EnqueueOptions.defaults());
  }
  
  public boolean enqueuePendingMessage(PendingMessage arg1, EnqueueOptions paramEnqueueOptions)
    throws IllegalStateException, IllegalArgumentException
  {
    if (!this.initialized) {
      throw new IllegalStateException("enqueue: Telemetry must be initialized before use");
    }
    if (??? == null) {
      throw new IllegalArgumentException("enqueue: argument 'pendingMessage' is null");
    }
    if (???.getEnvelope() == null) {
      throw new IllegalArgumentException("enqueue: argument 'pendingMessage.getEnvelope()' is null");
    }
    if ((???.getPackageName() == null) || (???.getPackageName().isEmpty())) {
      throw new IllegalArgumentException("enqueue: argument 'pendingMessage.getEnvelope().getPackageName()' is null or empty");
    }
    if ((???.getMessageName() == null) || (???.getMessageName().isEmpty())) {
      throw new IllegalArgumentException("enqueue: argument 'pendingMessage.getEnvelope().getMessageName()' is null or empty");
    }
    if (???.getEnvelope().getContext() == null) {
      throw new IllegalArgumentException("enqueue: argument 'pendingMessage.getEnvelope().getContext()' is null");
    }
    if (???.getEnvelope().getContents() == null) {
      throw new IllegalArgumentException("enqueue: argument 'pendingMessage.getEnvelope().getContents()' is null");
    }
    if (paramEnqueueOptions != null) {
      ???.setOptions(paramEnqueueOptions);
    }
    paramEnqueueOptions = ???.getPackageMessageName();
    if (this.queueProcessor.isCompletionRequested())
    {
      this.LOGGER.LogWarn("Calls to enqueue during shutdown drops the message.");
      synchronized (this.stats)
      {
        this.stats.setMessagesDropped(this.stats.getMessagesDropped() + 1);
        this.stats.incrementVerbMessage("Dropped", paramEnqueueOptions);
        return false;
      }
    }
    this.LOGGER.LogInfo("Enqueue Request.{0} == {1}, #{2}", new Object[] { Long.valueOf(???.id()), paramEnqueueOptions, Integer.valueOf(???.getSerializedMessage().size()) });
    if ((this.queueProcessor.getQueueCount() >= this.options.getMaxQueueSize()) && (this.options.getMaxQueueSize() != 0))
    {
      if (shouldIgnoreRequestOnQueueOverflow(???))
      {
        this.LOGGER.LogWarn("Overflow Event: Request.{0} QueueCount={1}/{2}, PendingRequestCount={3}/{4}.", new Object[] { Long.valueOf(???.id()), Integer.valueOf(getQueueCount()), Integer.valueOf(this.options.getMaxQueueSize()), Integer.valueOf(getPendingRequestCount()), Integer.valueOf(this.options.getMaxConcurrentRequests()) });
        synchronized (this.stats)
        {
          this.stats.setMessagesDropped(this.stats.getMessagesDropped() + 1);
          this.stats.incrementVerbMessage("Dropped", paramEnqueueOptions);
          raiseQueueOverflow(???);
          return false;
        }
      }
      this.LOGGER.LogWarn("Overflow Ignored: Request.{0} QueueCount={1}/{2}, PendingRequestCount={3}/{4}.", new Object[] { Long.valueOf(???.id()), Integer.valueOf(getQueueCount()), Integer.valueOf(this.options.getMaxQueueSize()), Integer.valueOf(getPendingRequestCount()), Integer.valueOf(this.options.getMaxConcurrentRequests()) });
    }
    this.queueProcessor.addToQueue(???);
    return true;
  }
  
  public Collection<Class<?>> getClassesForPackage(String paramString)
    throws Exception
  {
    String str = paramString.replace(".", "/");
    paramString = Thread.currentThread().getContextClassLoader();
    Object localObject2 = new HashSet();
    int i;
    Object localObject3;
    while (paramString != null)
    {
      if ((paramString instanceof URLClassLoader))
      {
        localObject1 = ((URLClassLoader)paramString).getURLs();
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject1[i];
          if (((URL)localObject3).getFile().endsWith(".jar")) {
            ((Set)localObject2).add(localObject3);
          }
          i += 1;
        }
      }
      paramString = paramString.getParent();
    }
    Object localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = new JarInputStream(FirebasePerfUrlConnection.openStream((URL)((Iterator)localObject2).next()));
      for (paramString = ((JarInputStream)localObject3).getNextJarEntry(); paramString != null; paramString = ((JarInputStream)localObject3).getNextJarEntry())
      {
        paramString = paramString.getName();
        i = paramString.lastIndexOf("/");
        if ((i > 0) && (paramString.endsWith(".class")) && (paramString.substring(0, i).startsWith(str))) {
          ((Set)localObject1).add(Class.forName(paramString.substring(0, paramString.length() - 6).replace("/", ".")));
        }
      }
      ((JarInputStream)localObject3).close();
    }
    return (Collection<Class<?>>)localObject1;
  }
  
  public Context getDefaultContext()
  {
    if (this.options == null) {
      this.options = new TelemetryOptions();
    }
    if (this.options.getDefaultContext() == null) {
      this.options.setDefaultContext(SetRequiredContextFields((Context)Context.newBuilder().build()));
    }
    return this.options.getDefaultContext();
  }
  
  public PackageMessageNamePair getPackageMessageNamePair(MessageLite paramMessageLite)
    throws IllegalArgumentException
  {
    if (paramMessageLite == null) {
      throw new IllegalArgumentException("'message' may not be null");
    }
    if (!this.messageNames.containsKey(paramMessageLite.getClass().getName()))
    {
      if (!paramMessageLite.getClass().getName().startsWith("com.blizzard.telemetry.proto.standard.")) {
        break label74;
      }
      this.LOGGER.LogError("registerStandardMessages wasn't called before enqueue?");
      registerStandardMessages();
    }
    for (;;)
    {
      return getPackageMessageNamePair(paramMessageLite.getClass());
      label74:
      if (!canAutoRegister(paramMessageLite.getClass())) {
        break;
      }
      this.LOGGER.LogWarn("call registerMessageNames(" + paramMessageLite.getClass().getSimpleName() + ", 'packageName', 'messageName') before you enqueue");
      registerMessageNames(paramMessageLite, null, null);
    }
    throw new IllegalArgumentException("call registerMessageNames(" + paramMessageLite.getClass().getSimpleName() + ", 'packageName', 'messageName') before you enqueue");
  }
  
  public PackageMessageNamePair getPackageMessageNamePair(Class<?> paramClass)
    throws IllegalArgumentException
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("'messageClass' may not be null");
    }
    if (!this.messageNames.containsKey(paramClass.getName()))
    {
      if (!paramClass.getName().startsWith("com.blizzard.telemetry.proto.standard.")) {
        break label68;
      }
      this.LOGGER.LogError("registerStandardMessages wasn't called before enqueue?");
      registerStandardMessages();
    }
    for (;;)
    {
      return getPackageMessageNamePair(paramClass.getName());
      label68:
      if (!canAutoRegister(paramClass)) {
        break;
      }
      this.LOGGER.LogWarn("call registerMessageNames(" + paramClass.getSimpleName() + ", 'packageName', 'messageName') before you enqueue");
      registerMessageNames(paramClass, null, null);
    }
    throw new IllegalArgumentException("call registerMessageNames(" + paramClass.getSimpleName() + ".class, 'packageName', 'messageName') before you enqueue");
  }
  
  public PackageMessageNamePair getPackageMessageNamePair(String paramString)
    throws IllegalArgumentException
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("'className' may not be null or empty");
    }
    if (!this.messageNames.containsKey(paramString))
    {
      if (paramString.startsWith("com.blizzard.telemetry.proto.standard."))
      {
        this.LOGGER.LogError("registerStandardMessages wasn't called before enqueue?");
        registerStandardMessages();
      }
    }
    else {
      return (PackageMessageNamePair)this.messageNames.get(paramString);
    }
    throw new IllegalArgumentException("call registerMessageNames('" + paramString + "', 'packageName', 'messageName') before you enqueue");
  }
  
  public int getPendingRequestCount()
  {
    return this.requestHandler.getPendingRequestCount();
  }
  
  public Platform getPlatform()
  {
    return this.platform;
  }
  
  public int getQueueCount()
  {
    return this.queueProcessor.getQueueCount();
  }
  
  long getQueueOverflowEventsSinceLastLog()
  {
    return this.queueOverflowEventsSinceLastLog.get();
  }
  
  public TelemetryQueueProcessor getQueueProcessor()
  {
    return this.queueProcessor;
  }
  
  public RateLimitWindow getRateLimitWindow()
  {
    return this.rateLimitWindow;
  }
  
  public RequestHandler getRequestHandler()
  {
    return this.requestHandler;
  }
  
  public RetryHandler getRetryHandler()
  {
    return this.retryHandler;
  }
  
  public TelemetryStatistics getStatistics()
  {
    synchronized (this.stats)
    {
      TelemetryStatistics localTelemetryStatistics2 = TelemetryStatistics.clone(this.stats).setMessagesEnqueued(this.queueProcessor.getQueueCount()).setMessagesPending(this.requestHandler.getPendingRequestCount()).setMessagesRetrying(this.retryHandler.getQueueCount());
      return localTelemetryStatistics2;
    }
  }
  
  public void initialize()
  {
    initialize(TelemetryOptions.defaults());
  }
  
  public void initialize(TelemetryOptions paramTelemetryOptions)
    throws IllegalStateException
  {
    if (this.initialized) {
      throw new IllegalStateException("initialize: Already initialized");
    }
    if (paramTelemetryOptions == null) {
      throw new IllegalStateException("initialize: argument 'options' is null");
    }
    this.LOGGER = new LogWrapper(TelemetryService.class, paramTelemetryOptions.getLogger());
    this.LOGGER.LogInfo("initialize(...)");
    this.stats = new TelemetryStatistics();
    initializeInternal(paramTelemetryOptions);
    this.userAgent = (Platform.systemType + "/" + Platform.systemVersion + " " + this.platform.sdkName() + "/" + this.platform.sdkVersion());
    if (!this.requestHandler.isInitialized()) {
      this.requestHandler.initialize(this.options);
    }
    if (!this.queueProcessor.isInitialized()) {
      this.queueProcessor.initialize(this.options, sendMultiMessageConsumer());
    }
    if (this.options.isRetryEnabled()) {
      this.retryHandler.onRetryEvent(new Consumer()
      {
        public void accept(PendingMessage paramAnonymousPendingMessage)
        {
          TelemetryService.this.onRetryRequest(paramAnonymousPendingMessage);
        }
      });
    }
    this.rateLimitWindow.enable(this.options.isRateLimitingEnabled());
    this.initialized = true;
    this.LOGGER.LogInfo("Initialized. SessionId={0}, EnableRetry={1}, MaxConcurrentRequests={2}.", new Object[] { this.options.getDefaultContext().getSessionId(), Boolean.valueOf(this.options.isRetryEnabled()), Integer.valueOf(this.options.getMaxConcurrentRequests()) });
    this.LOGGER.LogInfo("Initialized. Program={0} / {1}, SDK={2} / {3}.", new Object[] { this.options.getDefaultContext().getProgram().getName(), this.options.getDefaultContext().getProgram().getVersion(), this.options.getDefaultContext().getProgram().getSdk().getName(), this.options.getDefaultContext().getProgram().getSdk().getVersion() });
    if (this.options.autoEnqueueProcessStartFinish()) {
      enqueue(Start.newBuilder().setPid(this.platform.getProcessId()).build());
    }
  }
  
  protected void initializeInternal(TelemetryOptions paramTelemetryOptions)
    throws IllegalStateException
  {
    if (paramTelemetryOptions == null) {
      throw new IllegalStateException("initializeInternal: argument 'options' is null");
    }
    if (paramTelemetryOptions.getDefaultContext() == null)
    {
      this.LOGGER.LogWarn("initialize(...): argument 'options.getDefaultContext()' is null");
      paramTelemetryOptions.setDefaultContext((Context)Context.newBuilder().setProgram((Context.ProgramInfo)Context.ProgramInfo.newBuilder().setSdk((Context.ProgramInfo.SdkInfo)Context.ProgramInfo.SdkInfo.newBuilder().build()).build()).setHost((Context.HostInfo)Context.HostInfo.newBuilder().build()).build());
    }
    this.options = paramTelemetryOptions.clone();
    if (this.options.getClock() != null)
    {
      this.LOGGER.LogInfo("Clock injected: using provided Clock");
      this.clock = this.options.getClock();
      this.platform = this.options.getPlatform();
      if (this.platform != null) {
        break label233;
      }
      this.LOGGER.LogInfo("no Platform injected: using: StandardPlatform");
      this.platform = new StandardPlatform();
      label163:
      if (this.options.getRequestHandler() == null) {
        break label273;
      }
      this.LOGGER.LogInfo("RequestHandler injected: using provided RequestHandler");
      this.requestHandler = this.options.getRequestHandler();
    }
    for (;;)
    {
      this.options.setDefaultContext(SetRequiredContextFields(this.options.getDefaultContext()));
      registerStandardMessages();
      return;
      this.LOGGER.LogInfo("no Clock injected: using system Clock");
      break;
      label233:
      this.LOGGER.LogInfo("Platform injected: using: " + this.platform.getClass().getSimpleName());
      break label163;
      label273:
      this.LOGGER.LogInfo("no RequestHandler injected: using RequestHandler provided in constructor");
    }
  }
  
  public boolean isInitialized()
  {
    return (this.initialized) && (this.options != null) && (this.requestHandler != null) && (this.requestHandler.isInitialized()) && (this.retryHandler != null) && (this.queueProcessor != null) && (this.queueProcessor.isInitialized());
  }
  
  public boolean isServiceAvailable()
  {
    boolean bool2 = false;
    Object localObject = new Request().setMethod("GET").setUri(this.options.getIngestUrl().replaceAll("data", "health"));
    try
    {
      localObject = this.requestHandler.sendRequest((Request)localObject);
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (!((Response)localObject).hasException())
        {
          bool1 = bool2;
          if (200 <= ((Response)localObject).getCode().intValue())
          {
            int i = ((Response)localObject).getCode().intValue();
            bool1 = bool2;
            if (i <= 299) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      this.LOGGER.LogError("isServiceAvailable: exception: " + localException.getMessage());
    }
    return false;
  }
  
  public void onFailedRequest(BiConsumer<PendingMessage, Response> paramBiConsumer)
    throws IllegalArgumentException
  {
    if (paramBiConsumer == null) {
      throw new IllegalArgumentException("onFailedRequest: argument 'listener' is null");
    }
    this.requestFailed.addListener(paramBiConsumer);
  }
  
  public void onQueueOverflow(Consumer<PendingMessage> paramConsumer)
    throws IllegalArgumentException
  {
    if (paramConsumer == null) {
      throw new IllegalArgumentException("onQueueOverflow: argument 'listener' is null");
    }
    this.queueOverflow.addListener(paramConsumer);
  }
  
  void onRetryRequest(PendingMessage paramPendingMessage)
    throws IllegalArgumentException
  {
    if (paramPendingMessage == null) {
      throw new IllegalArgumentException("onRetryRequest: but 'pendingMessage' is null.");
    }
    this.LOGGER.LogInfo("Retry Request.{0} RetryCount={1}, QueueCount={2}, PendingRequestCount={3}.", new Object[] { Long.valueOf(paramPendingMessage.id()), Integer.valueOf(paramPendingMessage.getRetryCount()), Integer.valueOf(getQueueCount()), Integer.valueOf(getPendingRequestCount()) });
    synchronized (this.stats)
    {
      this.stats.setMessagesRetried(this.stats.getMessagesRetried() + 1);
      this.stats.incrementVerbMessage("Retried", paramPendingMessage.getPackageMessageName());
      this.queueProcessor.addToQueue(paramPendingMessage);
      return;
    }
  }
  
  public void onSuccessfulRequest(BiConsumer<PendingMessage, Response> paramBiConsumer)
    throws IllegalArgumentException
  {
    if (paramBiConsumer == null) {
      throw new IllegalArgumentException("onSuccessfulRequest: argument 'listener' is null");
    }
    this.requestSucceeded.addListener(paramBiConsumer);
  }
  
  public void processHeaders(Response paramResponse)
    throws IllegalArgumentException
  {
    if (paramResponse == null) {
      throw new IllegalArgumentException("processHeaders: but 'response' is null.");
    }
    String str;
    if ((!this.options.getDefaultContext().hasSessionId()) || (this.options.getDefaultContext().getSessionId().isEmpty()))
    {
      this.LOGGER.LogWarn("Sent message without sessionId.");
      str = paramResponse.getSessionId();
      if ((str != null) && (!str.isEmpty())) {
        break label91;
      }
      this.LOGGER.LogWarn("Response does not contain a session id!");
    }
    for (;;)
    {
      this.rateLimitWindow.calculateWindowIfNecessary(paramResponse);
      return;
      label91:
      this.LOGGER.LogWarn("Setting sessionId from response '{0}'", new Object[] { str });
      this.options.setDefaultContext((Context)((Context.Builder)this.options.getDefaultContext().toBuilder()).setSessionId(str).build());
    }
  }
  
  public void registerMessageNames(MessageLite paramMessageLite, String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    if (paramMessageLite == null) {
      throw new IllegalArgumentException("message may not be null");
    }
    Object localObject;
    String str2;
    if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramString2 != null))
    {
      localObject = paramString1;
      str2 = paramString2;
      if (!paramString2.isEmpty()) {}
    }
    else
    {
      String str1;
      if (paramString1 != null)
      {
        str1 = paramString1;
        if (!paramString1.isEmpty()) {}
      }
      else
      {
        str1 = packageNameFromClass(paramMessageLite.getClass());
      }
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (!paramString2.isEmpty()) {}
      }
      else
      {
        paramString1 = paramMessageLite.getClass().getSimpleName();
      }
      localObject = str1;
      str2 = paramString1;
      if (str1.startsWith("Blizzard.Telemetry."))
      {
        registerMessageNames(paramMessageLite.getClass().getName(), str1, paramString1);
        return;
      }
    }
    this.LOGGER.LogInfo("registerMessageNames(msg: " + paramMessageLite.getClass().getName() + ", '" + (String)localObject + "', '" + str2 + "')");
    registerMessageNames(paramMessageLite.getClass().getName(), (String)localObject, str2);
  }
  
  public void registerMessageNames(Class<?> paramClass, String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("messageClass may not be null");
    }
    Object localObject;
    String str2;
    if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramString2 != null))
    {
      localObject = paramString1;
      str2 = paramString2;
      if (!paramString2.isEmpty()) {}
    }
    else
    {
      String str1;
      if (paramString1 != null)
      {
        str1 = paramString1;
        if (!paramString1.isEmpty()) {}
      }
      else
      {
        str1 = packageNameFromClass(paramClass);
      }
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (!paramString2.isEmpty()) {}
      }
      else
      {
        paramString1 = paramClass.getSimpleName();
      }
      localObject = str1;
      str2 = paramString1;
      if (str1.startsWith("Blizzard.Telemetry."))
      {
        registerMessageNames(paramClass.getName(), str1, paramString1);
        return;
      }
    }
    this.LOGGER.LogInfo("registerMessageNames(cls: " + paramClass.getName() + ", '" + (String)localObject + "', '" + str2 + "')");
    registerMessageNames(paramClass.getName(), (String)localObject, str2);
  }
  
  public void registerMessageNames(String paramString1, String paramString2, String paramString3)
    throws IllegalArgumentException
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new IllegalArgumentException("className may not be null or empty");
    }
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      throw new IllegalArgumentException("packageName may not be null or empty");
    }
    if ((paramString3 == null) || (paramString3.length() == 0)) {
      throw new IllegalArgumentException("messageName may not be null or empty");
    }
    String str = paramString2;
    if (paramString2.endsWith("." + paramString3)) {
      str = paramString2.substring(0, paramString2.length() - (paramString3.length() + 1));
    }
    if (this.messageNames.containsKey(paramString1))
    {
      paramString2 = (PackageMessageNamePair)this.messageNames.get(paramString1);
      if ((!paramString2.getPackageName().equals(str)) || (!paramString2.getMessageName().equals(paramString3))) {
        throw new IllegalArgumentException("'" + paramString1 + "' is already registered as '" + paramString2.getPackageName() + "' / '" + paramString2.getMessageName() + "'");
      }
      this.LOGGER.LogInfo("registerMessageNames('" + paramString1 + "', '" + str + "', '" + paramString3 + "') IGNORE DUPLICATE!");
      return;
    }
    this.LOGGER.LogInfo("registerMessageNames('" + paramString1 + "', '" + str + "', '" + paramString3 + "')");
    this.messageNames.put(paramString1, new PackageMessageNamePair(str, paramString3));
  }
  
  public void registerStandardMessages()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = getClassesForPackage("com.blizzard.telemetry.proto.standard");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
      }
      this.LOGGER.LogError("registerStandardMessages: failed to find any classes via getClassesForPackage('com.blizzard.telemetry.proto.standard')");
      registerMessageNames(Alert.class, "Blizzard.Telemetry.Standard", "Alert");
      registerMessageNames(ConnectFail.class, "Blizzard.Telemetry.Standard.Network", "ConnectFail");
      registerMessageNames(ConnectSuccess.class, "Blizzard.Telemetry.Standard.Network", "ConnectSuccess");
      registerMessageNames(Disconnect.class, "Blizzard.Telemetry.Standard.Network", "Disconnect");
      registerMessageNames(TcpQualitySample.class, "Blizzard.Telemetry.Standard.Network", "TcpQualitySample");
      registerMessageNames(UdpQualitySample.class, "Blizzard.Telemetry.Standard.Network", "UdpQualitySample");
      registerMessageNames(Finish.class, "Blizzard.Telemetry.Standard.Process", "Finish");
      registerMessageNames(Start.class, "Blizzard.Telemetry.Standard.Process", "Start");
    }
    if ((localObject1 != null) && (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        String str = ((Class)localObject2).getName();
        if ((!str.contains("$")) && (!str.endsWith("Builder")) && (!str.endsWith("OuterClass"))) {
          registerMessageNames((Class)localObject2, packageNameFromClass((Class)localObject2), ((Class)localObject2).getSimpleName());
        }
      }
    }
  }
  
  public void resume()
  {
    this.queueProcessor.resume();
  }
  
  public void setClock(Clock paramClock)
  {
    if (paramClock != null) {}
    for (;;)
    {
      this.clock = paramClock;
      return;
      paramClock = Clock.systemUTC();
    }
  }
  
  public void setDefaultContext(Context paramContext)
    throws IllegalArgumentException
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("setDefaultContext: argument 'context' is null");
    }
    Context localContext = paramContext;
    if (!CheckRequiredContextFields(paramContext)) {
      localContext = SetRequiredContextFields(paramContext);
    }
    this.options.setDefaultContext(localContext);
  }
  
  protected boolean shouldIgnoreRequestOnQueueOverflow(PendingMessage paramPendingMessage)
  {
    return true;
  }
  
  public void suspend()
  {
    this.queueProcessor.suspend();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/TelemetryService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */