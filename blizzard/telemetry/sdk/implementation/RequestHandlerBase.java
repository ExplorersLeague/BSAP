package com.blizzard.telemetry.sdk.implementation;

import com.blizzard.telemetry.sdk.LogWrapper;
import com.blizzard.telemetry.sdk.Request;
import com.blizzard.telemetry.sdk.Response;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import com.blizzard.telemetry.sdk.interfaces.RequestHandler;
import com.blizzard.telemetry.sdk.tools.FutureCallback;
import java.net.URI;
import java.util.concurrent.Semaphore;

public abstract class RequestHandlerBase
  implements RequestHandler
{
  protected LogWrapper LOGGER = LogWrapper.NullLogger(RequestHandlerBase.class);
  private Semaphore concurrentSemaphore;
  protected TelemetryOptions options;
  
  protected void decrementPending()
  {
    this.LOGGER.LogInfo("Decrement pending...");
    this.concurrentSemaphore.release();
  }
  
  public abstract void doSendAsync(Request paramRequest, FutureCallback<Response> paramFutureCallback);
  
  public abstract Response doSendSync(Request paramRequest);
  
  public TelemetryOptions getOptions()
  {
    return this.options;
  }
  
  public int getPendingRequestCount()
  {
    if (this.options == null)
    {
      this.LOGGER.LogWarn("Not yet initialized!");
      return 0;
    }
    return this.options.getMaxConcurrentRequests() - this.concurrentSemaphore.availablePermits();
  }
  
  protected void incrementPending()
    throws InterruptedException
  {
    this.LOGGER.LogInfo("Increment pending... available: {0}", new Object[] { Integer.valueOf(this.concurrentSemaphore.availablePermits()) });
    this.concurrentSemaphore.acquire();
  }
  
  public RequestHandler initialize(TelemetryOptions paramTelemetryOptions)
  {
    this.options = paramTelemetryOptions.clone();
    this.LOGGER = new LogWrapper(getClass(), paramTelemetryOptions.getLogger());
    this.concurrentSemaphore = new Semaphore(paramTelemetryOptions.getMaxConcurrentRequests());
    this.LOGGER.LogInfo("initialize(...)");
    return this;
  }
  
  public boolean isInitialized()
  {
    return this.concurrentSemaphore != null;
  }
  
  /* Error */
  public Response sendRequest(Request paramRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:LOGGER	Lcom/blizzard/telemetry/sdk/LogWrapper;
    //   4: ldc 110
    //   6: invokevirtual 34	com/blizzard/telemetry/sdk/LogWrapper:LogInfo	(Ljava/lang/String;)Lcom/blizzard/telemetry/sdk/interfaces/Logger;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 112	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:incrementPending	()V
    //   14: aload_1
    //   15: invokevirtual 118	com/blizzard/telemetry/sdk/Request:getUri	()Ljava/net/URI;
    //   18: ifnonnull +28 -> 46
    //   21: aload_0
    //   22: getfield 26	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:LOGGER	Lcom/blizzard/telemetry/sdk/LogWrapper;
    //   25: ldc 120
    //   27: invokevirtual 56	com/blizzard/telemetry/sdk/LogWrapper:LogWarn	(Ljava/lang/String;)Lcom/blizzard/telemetry/sdk/interfaces/Logger;
    //   30: pop
    //   31: aload_1
    //   32: aload_0
    //   33: getfield 49	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:options	Lcom/blizzard/telemetry/sdk/TelemetryOptions;
    //   36: invokevirtual 124	com/blizzard/telemetry/sdk/TelemetryOptions:getIngestUrl	()Ljava/lang/String;
    //   39: invokestatic 130	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
    //   42: invokevirtual 134	com/blizzard/telemetry/sdk/Request:setUri	(Ljava/net/URI;)Lcom/blizzard/telemetry/sdk/Request;
    //   45: pop
    //   46: aload_0
    //   47: getfield 26	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:LOGGER	Lcom/blizzard/telemetry/sdk/LogWrapper;
    //   50: new 136	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   57: ldc -117
    //   59: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   66: invokevirtual 148	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   69: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 34	com/blizzard/telemetry/sdk/LogWrapper:LogInfo	(Ljava/lang/String;)Lcom/blizzard/telemetry/sdk/interfaces/Logger;
    //   78: pop
    //   79: aload_0
    //   80: getfield 26	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:LOGGER	Lcom/blizzard/telemetry/sdk/LogWrapper;
    //   83: ldc -103
    //   85: invokevirtual 34	com/blizzard/telemetry/sdk/LogWrapper:LogInfo	(Ljava/lang/String;)Lcom/blizzard/telemetry/sdk/interfaces/Logger;
    //   88: pop
    //   89: aload_0
    //   90: aload_1
    //   91: invokevirtual 155	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:doSendSync	(Lcom/blizzard/telemetry/sdk/Request;)Lcom/blizzard/telemetry/sdk/Response;
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 26	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:LOGGER	Lcom/blizzard/telemetry/sdk/LogWrapper;
    //   99: ldc -99
    //   101: invokevirtual 34	com/blizzard/telemetry/sdk/LogWrapper:LogInfo	(Ljava/lang/String;)Lcom/blizzard/telemetry/sdk/interfaces/Logger;
    //   104: pop
    //   105: aload_0
    //   106: invokevirtual 159	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:decrementPending	()V
    //   109: aload_1
    //   110: areturn
    //   111: astore_1
    //   112: new 161	com/blizzard/telemetry/sdk/Response
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 164	com/blizzard/telemetry/sdk/Response:<init>	(Ljava/lang/Throwable;)V
    //   120: areturn
    //   121: astore_1
    //   122: aload_0
    //   123: getfield 26	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:LOGGER	Lcom/blizzard/telemetry/sdk/LogWrapper;
    //   126: ldc -90
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_1
    //   135: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   138: invokevirtual 148	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: aload_1
    //   145: invokevirtual 169	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   148: aastore
    //   149: invokevirtual 78	com/blizzard/telemetry/sdk/LogWrapper:LogInfo	(Ljava/lang/String;[Ljava/lang/Object;)Lcom/blizzard/telemetry/sdk/interfaces/Logger;
    //   152: pop
    //   153: new 161	com/blizzard/telemetry/sdk/Response
    //   156: dup
    //   157: aload_1
    //   158: invokespecial 164	com/blizzard/telemetry/sdk/Response:<init>	(Ljava/lang/Throwable;)V
    //   161: astore_1
    //   162: aload_0
    //   163: invokevirtual 159	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:decrementPending	()V
    //   166: aload_1
    //   167: areturn
    //   168: astore_1
    //   169: aload_0
    //   170: invokevirtual 159	com/blizzard/telemetry/sdk/implementation/RequestHandlerBase:decrementPending	()V
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	RequestHandlerBase
    //   0	175	1	paramRequest	Request
    // Exception table:
    //   from	to	target	type
    //   10	14	111	java/lang/InterruptedException
    //   79	105	121	java/lang/Exception
    //   79	105	168	finally
    //   122	162	168	finally
  }
  
  public void sendRequest(Request paramRequest, final FutureCallback<Response> paramFutureCallback)
  {
    this.LOGGER.LogInfo("sendRequest(..., ...)");
    try
    {
      incrementPending();
      if (paramRequest.getUri() == null)
      {
        this.LOGGER.LogWarn("sendRequest(..., ...): request had no URI set!");
        paramRequest.setUri(URI.create(this.options.getIngestUrl()));
      }
      this.LOGGER.LogInfo("calling doSendAsync(..., ...)");
      doSendAsync(paramRequest, new FutureCallback()
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          RequestHandlerBase.this.LOGGER.LogInfo("doSendAsync(..., ...).onFailure(...)");
          try
          {
            paramFutureCallback.onFailure(paramAnonymousThrowable);
            return;
          }
          finally
          {
            RequestHandlerBase.this.decrementPending();
          }
        }
        
        public void onSuccess(Response paramAnonymousResponse)
        {
          RequestHandlerBase.this.LOGGER.LogInfo("doSendAsync(..., ...).onSuccess(...)");
          try
          {
            paramFutureCallback.onSuccess(paramAnonymousResponse);
            return;
          }
          finally
          {
            RequestHandlerBase.this.decrementPending();
          }
        }
      });
      return;
    }
    catch (InterruptedException paramRequest)
    {
      paramFutureCallback.onFailure(paramRequest);
    }
  }
  
  public void waitForNoPendingRequests()
    throws InterruptedException
  {
    if (this.options != null)
    {
      this.LOGGER.LogInfo("acquiring {0} permits!", new Object[] { Integer.valueOf(this.options.getMaxConcurrentRequests()) });
      this.concurrentSemaphore.acquire(this.options.getMaxConcurrentRequests());
      this.LOGGER.LogInfo("releasing {0} permits!", new Object[] { Integer.valueOf(this.options.getMaxConcurrentRequests()) });
      this.concurrentSemaphore.release(this.options.getMaxConcurrentRequests());
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/RequestHandlerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */