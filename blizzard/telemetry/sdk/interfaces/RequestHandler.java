package com.blizzard.telemetry.sdk.interfaces;

import com.blizzard.telemetry.sdk.Request;
import com.blizzard.telemetry.sdk.Response;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import com.blizzard.telemetry.sdk.tools.FutureCallback;
import java.io.Closeable;

public abstract interface RequestHandler
  extends Closeable
{
  public abstract void close();
  
  public abstract int getPendingRequestCount();
  
  public abstract RequestHandler initialize(TelemetryOptions paramTelemetryOptions);
  
  public abstract boolean isInitialized();
  
  public abstract Response sendRequest(Request paramRequest);
  
  public abstract void sendRequest(Request paramRequest, FutureCallback<Response> paramFutureCallback);
  
  public abstract void waitForNoPendingRequests()
    throws InterruptedException;
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/interfaces/RequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */