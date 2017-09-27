package com.blizzard.telemetry.sdk.interfaces;

import com.blizzard.telemetry.sdk.PendingMessage;
import com.blizzard.telemetry.sdk.Response;
import com.blizzard.telemetry.sdk.tools.Consumer;

public abstract interface RetryHandler
{
  public abstract void complete();
  
  public abstract int getQueueCount();
  
  public abstract void onRetryEvent(Consumer<PendingMessage> paramConsumer);
  
  public abstract boolean queueForRetry(PendingMessage paramPendingMessage);
  
  public abstract void setRetryPolicy(RetryPolicy paramRetryPolicy);
  
  public abstract boolean shouldRetry(Response paramResponse);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/interfaces/RetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */