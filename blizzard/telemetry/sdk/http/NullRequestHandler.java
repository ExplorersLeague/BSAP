package com.blizzard.telemetry.sdk.http;

import com.blizzard.telemetry.sdk.LogWrapper;
import com.blizzard.telemetry.sdk.Request;
import com.blizzard.telemetry.sdk.Response;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import com.blizzard.telemetry.sdk.implementation.RequestHandlerBase;
import com.blizzard.telemetry.sdk.interfaces.RequestHandler;
import com.blizzard.telemetry.sdk.tools.FutureCallback;

public class NullRequestHandler
  extends RequestHandlerBase
{
  public void close()
  {
    this.LOGGER.LogInfo("NullRequestHandler: closing");
  }
  
  public void doSendAsync(Request paramRequest, FutureCallback<Response> paramFutureCallback)
  {
    this.LOGGER.LogInfo("NullRequestHandler: instant success: 200");
    paramFutureCallback.onSuccess(new Response(200));
  }
  
  public Response doSendSync(Request paramRequest)
  {
    this.LOGGER.LogInfo("NullRequestHandler: instant success: 200");
    return new Response(200);
  }
  
  public RequestHandler initialize(TelemetryOptions paramTelemetryOptions)
  {
    super.initialize(paramTelemetryOptions);
    this.LOGGER = new LogWrapper(NullRequestHandler.class, paramTelemetryOptions.getLogger());
    return this;
  }
  
  public boolean isInitialized()
  {
    return super.isInitialized();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/http/NullRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */