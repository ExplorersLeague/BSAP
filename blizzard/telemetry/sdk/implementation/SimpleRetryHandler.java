package com.blizzard.telemetry.sdk.implementation;

import com.blizzard.telemetry.sdk.PendingMessage;
import com.blizzard.telemetry.sdk.Response;
import com.blizzard.telemetry.sdk.interfaces.RetryHandler;
import com.blizzard.telemetry.sdk.interfaces.RetryPolicy;
import com.blizzard.telemetry.sdk.tools.Clock;
import com.blizzard.telemetry.sdk.tools.Consumer;
import com.blizzard.telemetry.sdk.tools.EventHandler;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleRetryHandler
  implements RetryHandler
{
  private Clock clock = Clock.systemUTC();
  private AtomicInteger queueSize = new AtomicInteger();
  private RetryPolicy retryPolicy = new ExponentialBackoffRetryPolicy();
  private EventHandler<PendingMessage> retryRequest = new EventHandler();
  
  public SimpleRetryHandler()
  {
    this.queueSize.set(0);
  }
  
  private void raiseRetryRequest(PendingMessage paramPendingMessage)
  {
    this.retryRequest.newEvent(paramPendingMessage);
  }
  
  public void complete() {}
  
  public int getQueueCount()
  {
    return this.queueSize.get();
  }
  
  public void onRetryEvent(Consumer<PendingMessage> paramConsumer)
  {
    this.retryRequest.addListener(paramConsumer);
  }
  
  public boolean queueForRetry(final PendingMessage paramPendingMessage)
    throws IllegalStateException
  {
    if (this.retryPolicy == null) {
      throw new IllegalStateException("Call setRetryPolicy before calling queueForRetry.");
    }
    final int i = paramPendingMessage.getRetryCount();
    final Long localLong = this.retryPolicy.getNextRetryTime(i);
    if (localLong == null) {
      return false;
    }
    this.queueSize.incrementAndGet();
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Thread.sleep(1L);
          paramPendingMessage.setRetryCount(i + 1).setSendTime(SimpleRetryHandler.this.clock.millis() + localLong.longValue());
          SimpleRetryHandler.this.raiseRetryRequest(paramPendingMessage);
          SimpleRetryHandler.this.queueSize.decrementAndGet();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }).start();
    return true;
  }
  
  public void setRetryPolicy(RetryPolicy paramRetryPolicy)
  {
    this.retryPolicy = paramRetryPolicy;
  }
  
  public boolean shouldRetry(Response paramResponse)
  {
    if (paramResponse == null) {}
    while (((paramResponse.getCode().intValue() >= 500) && (paramResponse.getCode().intValue() < 600)) || (paramResponse.getCode().intValue() <= 199) || (paramResponse.getCode().intValue() >= 600) || (paramResponse.hasException())) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/SimpleRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */