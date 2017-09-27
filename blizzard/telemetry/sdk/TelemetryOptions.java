package com.blizzard.telemetry.sdk;

import com.blizzard.telemetry.proto.Context;
import com.blizzard.telemetry.proto.Context.Builder;
import com.blizzard.telemetry.proto.Context.HostInfo;
import com.blizzard.telemetry.proto.Context.HostInfo.Builder;
import com.blizzard.telemetry.proto.Context.ProgramInfo;
import com.blizzard.telemetry.proto.Context.ProgramInfo.Builder;
import com.blizzard.telemetry.sdk.interfaces.Logger;
import com.blizzard.telemetry.sdk.interfaces.Platform;
import com.blizzard.telemetry.sdk.interfaces.RequestHandler;
import com.blizzard.telemetry.sdk.tools.Clock;
import java.io.PrintStream;

public class TelemetryOptions
{
  public static final int DEFAULT_BATCH_TIMEOUT = 5000;
  public static final int DEFAULT_MAX_BATCH_SIZE = 5;
  public static final int DEFAULT_MAX_CONCURRENT_REQUESTS = 10;
  public static final int DEFAULT_MAX_QUEUE_SIZE = 2000000;
  public static final int DEFAULT_MIN_BATCH_SIZE = 2;
  public static final int INFINITE_QUEUE_SIZE = 0;
  private boolean autoEnqueueProcessStartFinish = true;
  private int batchTimeout = 5000;
  private Clock clock;
  private String customHost = "";
  private int customPort = 0;
  private Context defaultContext = (Context)Context.newBuilder().setProgram((Context.ProgramInfo)Context.ProgramInfo.newBuilder().build()).setHost((Context.HostInfo)Context.HostInfo.newBuilder().build()).build();
  private boolean dontSendMoreWhenRetrying = true;
  private boolean enableRateLimiting = false;
  private boolean enableRetry = true;
  private boolean isClient = false;
  private Logger logger = null;
  private int maxBatchSize = 5;
  private int maxConcurrentRequests = 10;
  private int maxQueueSize = 2000000;
  private int minBatchSize = 2;
  private Platform platform;
  private RequestHandler requestHandler = null;
  private TelemetryTarget target = TelemetryTarget.QA;
  
  private static TelemetryOptions createDefaults(String paramString1, String paramString2, String paramString3)
  {
    Object localObject2;
    Object localObject4;
    Object localObject1;
    Object localObject3;
    int i;
    if ((paramString2 != null) && (!paramString2.isEmpty()) && (paramString3 != null))
    {
      localObject2 = paramString2;
      localObject4 = paramString3;
      if (!paramString3.isEmpty()) {}
    }
    else
    {
      localObject2 = "";
      localObject1 = "";
      localObject3 = new SecurityManager()
      {
        public Class<?>[] getCallingClasses()
        {
          return getClassContext();
        }
      }.getCallingClasses();
      if (localObject3 != null)
      {
        localObject4 = localObject3[0].getPackage().getName();
        i = 2;
      }
    }
    for (;;)
    {
      localObject1 = "";
      localObject2 = "";
      if (i < localObject3.length)
      {
        localObject1 = localObject3[i].getPackage();
        localObject2 = ((Package)localObject1).getName();
        localObject1 = ((Package)localObject1).getImplementationVersion();
        if ((localObject2 == null) || (((String)localObject2).isEmpty()) || (((String)localObject2).equals(localObject4))) {}
      }
      else
      {
        if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
          System.err.println("TelemetryOptions.default() can't deduce calling package.");
        }
        if (paramString2 != null)
        {
          localObject3 = paramString2;
          if (!paramString2.isEmpty()) {}
        }
        else
        {
          localObject3 = localObject2;
        }
        if (paramString3 != null)
        {
          localObject2 = localObject3;
          localObject4 = paramString3;
          if (!paramString3.isEmpty()) {}
        }
        else
        {
          localObject4 = localObject1;
          localObject2 = localObject3;
        }
        return new TelemetryOptions().setProgramDetails(paramString1, (String)localObject2, (String)localObject4);
      }
      i += 1;
    }
  }
  
  public static TelemetryOptions defaults()
  {
    return createDefaults("", "", "");
  }
  
  public static TelemetryOptions defaults(String paramString)
  {
    return createDefaults(paramString, "", "");
  }
  
  public static TelemetryOptions defaults(String paramString1, String paramString2)
  {
    return createDefaults(paramString1, paramString2, "");
  }
  
  public static TelemetryOptions defaults(String paramString1, String paramString2, String paramString3)
  {
    return createDefaults(paramString1, paramString2, paramString3);
  }
  
  public TelemetryOptions addHostTag(String paramString)
  {
    Context.Builder localBuilder;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (this.defaultContext != null) {
        break label72;
      }
      localBuilder = Context.newBuilder();
      if ((localBuilder.hasHost()) && (localBuilder.getHost() != null)) {
        break label86;
      }
    }
    label72:
    label86:
    for (Context.HostInfo.Builder localBuilder1 = Context.HostInfo.newBuilder();; localBuilder1 = (Context.HostInfo.Builder)localBuilder.getHost().toBuilder())
    {
      localBuilder1.addTag(paramString);
      localBuilder.setHost((Context.HostInfo)localBuilder1.build());
      setDefaultContext((Context)localBuilder.build());
      return this;
      localBuilder = (Context.Builder)this.defaultContext.toBuilder();
      break;
    }
  }
  
  public TelemetryOptions addHostTags(Iterable<String> paramIterable)
  {
    Context.Builder localBuilder;
    if (paramIterable != null)
    {
      if (this.defaultContext != null) {
        break label65;
      }
      localBuilder = Context.newBuilder();
      if ((localBuilder.hasHost()) && (localBuilder.getHost() != null)) {
        break label79;
      }
    }
    label65:
    label79:
    for (Context.HostInfo.Builder localBuilder1 = Context.HostInfo.newBuilder();; localBuilder1 = (Context.HostInfo.Builder)localBuilder.getHost().toBuilder())
    {
      localBuilder1.addAllTag(paramIterable);
      localBuilder.setHost((Context.HostInfo)localBuilder1.build());
      setDefaultContext((Context)localBuilder.build());
      return this;
      localBuilder = (Context.Builder)this.defaultContext.toBuilder();
      break;
    }
  }
  
  public boolean autoEnqueueProcessStartFinish()
  {
    return this.autoEnqueueProcessStartFinish;
  }
  
  public TelemetryOptions clone()
  {
    TelemetryOptions localTelemetryOptions = new TelemetryOptions();
    localTelemetryOptions.logger = this.logger;
    localTelemetryOptions.isClient = this.isClient;
    localTelemetryOptions.maxBatchSize = this.maxBatchSize;
    localTelemetryOptions.minBatchSize = this.minBatchSize;
    localTelemetryOptions.batchTimeout = this.batchTimeout;
    localTelemetryOptions.dontSendMoreWhenRetrying = this.dontSendMoreWhenRetrying;
    localTelemetryOptions.target = this.target;
    localTelemetryOptions.customHost = this.customHost;
    localTelemetryOptions.customPort = this.customPort;
    localTelemetryOptions.autoEnqueueProcessStartFinish = this.autoEnqueueProcessStartFinish;
    localTelemetryOptions.enableRetry = this.enableRetry;
    localTelemetryOptions.enableRateLimiting = this.enableRateLimiting;
    localTelemetryOptions.maxConcurrentRequests = this.maxConcurrentRequests;
    localTelemetryOptions.maxQueueSize = this.maxQueueSize;
    if (this.defaultContext == null) {}
    for (Context localContext = (Context)Context.newBuilder().setProgram((Context.ProgramInfo)Context.ProgramInfo.newBuilder().build()).setHost((Context.HostInfo)Context.HostInfo.newBuilder().build()).build();; localContext = (Context)((Context.Builder)this.defaultContext.toBuilder()).build())
    {
      localTelemetryOptions.defaultContext = localContext;
      localTelemetryOptions.requestHandler = this.requestHandler;
      localTelemetryOptions.platform = this.platform;
      localTelemetryOptions.clock = this.clock;
      return localTelemetryOptions;
    }
  }
  
  public boolean dontSendMoreWhenRetrying()
  {
    return this.dontSendMoreWhenRetrying;
  }
  
  public TelemetryOptions enableRateLimiting(boolean paramBoolean)
  {
    this.enableRateLimiting = paramBoolean;
    return this;
  }
  
  public TelemetryOptions enableRetry(boolean paramBoolean)
  {
    this.enableRetry = paramBoolean;
    return this;
  }
  
  public int getBatchTimeout()
  {
    return this.batchTimeout;
  }
  
  public Clock getClock()
  {
    if (this.clock == null) {
      return Clock.systemUTC();
    }
    return this.clock;
  }
  
  public String getCustomHost()
  {
    return this.customHost;
  }
  
  public int getCustomPort()
  {
    return this.customPort;
  }
  
  public Context getDefaultContext()
  {
    return this.defaultContext;
  }
  
  public String getIngestUrl()
  {
    Object localObject1 = "";
    Object localObject2;
    if ((this.customHost != null) && (!this.customHost.isEmpty()))
    {
      localObject1 = this.customHost;
      localObject2 = localObject1;
      if (!((String)localObject1).contains("://")) {
        localObject2 = "http://" + (String)localObject1;
      }
      localObject1 = localObject2;
      if (this.customPort != 0) {
        localObject1 = (String)localObject2 + ":" + String.valueOf(this.customPort);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith("/data")) {
        localObject2 = (String)localObject1 + "/data";
      }
      return (String)localObject2;
      if (this.customPort != 0) {
        localObject1 = "http://tdk-instance.battle.net:" + String.valueOf(this.customPort);
      } else {
        switch (this.target)
        {
        default: 
          break;
        case ???: 
          localObject1 = "https://telemetry-in-qa.battle.net/data";
          break;
        case ???: 
          localObject1 = "https://telemetry-in.battle.net/data";
          break;
        case ???: 
          localObject1 = "http://localhost:8000/data";
          break;
        case ???: 
          localObject1 = "http://tdk-instance.battle.net";
          if (this.customPort != 0) {
            localObject1 = "http://tdk-instance.battle.net" + ":" + String.valueOf(this.customPort);
          }
          break;
        }
      }
    }
  }
  
  public Logger getLogger()
  {
    return this.logger;
  }
  
  public int getMaxBatchSize()
  {
    return this.maxBatchSize;
  }
  
  public int getMaxConcurrentRequests()
  {
    return this.maxConcurrentRequests;
  }
  
  public int getMaxQueueSize()
  {
    return this.maxQueueSize;
  }
  
  public int getMinBatchSize()
  {
    return this.minBatchSize;
  }
  
  public Platform getPlatform()
  {
    return this.platform;
  }
  
  public RequestHandler getRequestHandler()
  {
    return this.requestHandler;
  }
  
  public TelemetryTarget getTarget()
  {
    return this.target;
  }
  
  public TelemetryOptions injectClock(Clock paramClock)
  {
    return setClock(paramClock);
  }
  
  public TelemetryOptions injectPlatform(Platform paramPlatform)
  {
    return setPlatform(paramPlatform);
  }
  
  public TelemetryOptions injectRequestHandler(RequestHandler paramRequestHandler)
  {
    return setRequestHandler(paramRequestHandler);
  }
  
  public boolean isClient()
  {
    return this.isClient;
  }
  
  public boolean isRateLimitingEnabled()
  {
    return this.enableRateLimiting;
  }
  
  public boolean isRetryEnabled()
  {
    return this.enableRetry;
  }
  
  public TelemetryOptions setAutoEnqueueProcessStartFinish(boolean paramBoolean)
  {
    this.autoEnqueueProcessStartFinish = paramBoolean;
    return this;
  }
  
  public TelemetryOptions setBatchTimeout(int paramInt)
  {
    this.batchTimeout = paramInt;
    return this;
  }
  
  public TelemetryOptions setClock(Clock paramClock)
  {
    this.clock = paramClock;
    return this;
  }
  
  public TelemetryOptions setCustomHost(String paramString)
  {
    this.customHost = paramString;
    return this;
  }
  
  public TelemetryOptions setCustomPort(int paramInt)
  {
    this.customPort = paramInt;
    return this;
  }
  
  public TelemetryOptions setDefaultContext(Context paramContext)
  {
    this.defaultContext = ((Context)Context.newBuilder(paramContext).build());
    return this;
  }
  
  public TelemetryOptions setDontSendMoreWhenRetrying(boolean paramBoolean)
  {
    this.dontSendMoreWhenRetrying = paramBoolean;
    return this;
  }
  
  public TelemetryOptions setIsClient(boolean paramBoolean)
  {
    this.isClient = paramBoolean;
    return this;
  }
  
  public TelemetryOptions setLogger(Logger paramLogger)
  {
    this.logger = paramLogger;
    return this;
  }
  
  public TelemetryOptions setMaxBatchSize(int paramInt)
  {
    this.maxBatchSize = paramInt;
    return this;
  }
  
  public TelemetryOptions setMaxConcurrentRequests(int paramInt)
  {
    this.maxConcurrentRequests = paramInt;
    return this;
  }
  
  public TelemetryOptions setMaxQueueSize(int paramInt)
  {
    this.maxQueueSize = paramInt;
    return this;
  }
  
  public TelemetryOptions setMinBatchSize(int paramInt)
  {
    this.maxBatchSize = paramInt;
    return this;
  }
  
  public TelemetryOptions setPlatform(Platform paramPlatform)
  {
    this.platform = paramPlatform;
    return this;
  }
  
  public TelemetryOptions setProgramDetails(String paramString1, String paramString2, String paramString3)
  {
    Context.Builder localBuilder;
    if (((paramString1 != null) && (!paramString1.isEmpty())) || ((paramString2 != null) && (!paramString2.isEmpty())) || ((paramString3 != null) && (!paramString3.isEmpty())))
    {
      if (this.defaultContext != null) {
        break label149;
      }
      localBuilder = Context.newBuilder();
      if ((localBuilder.hasProgram()) && (localBuilder.getProgram() != null)) {
        break label164;
      }
    }
    label149:
    label164:
    for (Context.ProgramInfo.Builder localBuilder1 = Context.ProgramInfo.newBuilder();; localBuilder1 = (Context.ProgramInfo.Builder)localBuilder.getProgram().toBuilder())
    {
      if ((paramString1 != null) && (!paramString1.isEmpty())) {
        localBuilder1.setId(paramString1);
      }
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        localBuilder1.setName(paramString2);
      }
      if ((paramString3 != null) && (!paramString3.isEmpty())) {
        localBuilder1.setVersion(paramString3);
      }
      localBuilder.setProgram((Context.ProgramInfo)localBuilder1.build());
      setDefaultContext((Context)localBuilder.build());
      return this;
      localBuilder = (Context.Builder)this.defaultContext.toBuilder();
      break;
    }
  }
  
  public TelemetryOptions setProgramId(String paramString)
  {
    Context.Builder localBuilder;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (this.defaultContext != null) {
        break label72;
      }
      localBuilder = Context.newBuilder();
      if ((localBuilder.hasProgram()) && (localBuilder.getProgram() != null)) {
        break label86;
      }
    }
    label72:
    label86:
    for (Context.ProgramInfo.Builder localBuilder1 = Context.ProgramInfo.newBuilder();; localBuilder1 = (Context.ProgramInfo.Builder)localBuilder.getProgram().toBuilder())
    {
      localBuilder1.setId(paramString);
      localBuilder.setProgram((Context.ProgramInfo)localBuilder1.build());
      setDefaultContext((Context)localBuilder.build());
      return this;
      localBuilder = (Context.Builder)this.defaultContext.toBuilder();
      break;
    }
  }
  
  public TelemetryOptions setProgramName(String paramString)
  {
    Context.Builder localBuilder;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (this.defaultContext != null) {
        break label72;
      }
      localBuilder = Context.newBuilder();
      if ((localBuilder.hasProgram()) && (localBuilder.getProgram() != null)) {
        break label86;
      }
    }
    label72:
    label86:
    for (Context.ProgramInfo.Builder localBuilder1 = Context.ProgramInfo.newBuilder();; localBuilder1 = (Context.ProgramInfo.Builder)localBuilder.getProgram().toBuilder())
    {
      localBuilder1.setName(paramString);
      localBuilder.setProgram((Context.ProgramInfo)localBuilder1.build());
      setDefaultContext((Context)localBuilder.build());
      return this;
      localBuilder = (Context.Builder)this.defaultContext.toBuilder();
      break;
    }
  }
  
  public TelemetryOptions setProgramVersion(String paramString)
  {
    Context.Builder localBuilder;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (this.defaultContext != null) {
        break label72;
      }
      localBuilder = Context.newBuilder();
      if ((localBuilder.hasProgram()) && (localBuilder.getProgram() != null)) {
        break label86;
      }
    }
    label72:
    label86:
    for (Context.ProgramInfo.Builder localBuilder1 = Context.ProgramInfo.newBuilder();; localBuilder1 = (Context.ProgramInfo.Builder)localBuilder.getProgram().toBuilder())
    {
      localBuilder1.setVersion(paramString);
      localBuilder.setProgram((Context.ProgramInfo)localBuilder1.build());
      setDefaultContext((Context)localBuilder.build());
      return this;
      localBuilder = (Context.Builder)this.defaultContext.toBuilder();
      break;
    }
  }
  
  public TelemetryOptions setRequestHandler(RequestHandler paramRequestHandler)
  {
    this.requestHandler = paramRequestHandler;
    return this;
  }
  
  public TelemetryOptions setTarget(TelemetryTarget paramTelemetryTarget)
  {
    this.target = paramTelemetryTarget;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/TelemetryOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */