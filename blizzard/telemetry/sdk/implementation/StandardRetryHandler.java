package com.blizzard.telemetry.sdk.implementation;

import com.blizzard.telemetry.sdk.PendingMessage;
import com.blizzard.telemetry.sdk.Response;
import com.blizzard.telemetry.sdk.interfaces.RetryHandler;
import com.blizzard.telemetry.sdk.interfaces.RetryPolicy;
import com.blizzard.telemetry.sdk.tools.Clock;
import com.blizzard.telemetry.sdk.tools.Consumer;
import com.blizzard.telemetry.sdk.tools.EventHandler;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import net.jodah.expiringmap.ExpirationListener;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import net.jodah.expiringmap.ExpiringMap.Builder;

public class StandardRetryHandler
  implements RetryHandler
{
  private Clock clock = Clock.systemUTC();
  private volatile boolean completionRequested = false;
  private final Lock lock = new ReentrantLock();
  private ExpiringMap<UUID, PendingMessage> memoryCache;
  private RetryPolicy retryPolicy;
  private EventHandler<PendingMessage> retryRequest;
  
  public StandardRetryHandler()
  {
    this.memoryCache = ExpiringMap.builder().variableExpiration().build();
    this.memoryCache.addExpirationListener(new ExpirationListener()
    {
      public void expired(UUID paramAnonymousUUID, PendingMessage paramAnonymousPendingMessage)
      {
        StandardRetryHandler.this.raiseRetryRequest(paramAnonymousPendingMessage);
      }
    });
    this.retryRequest = new EventHandler();
    this.retryPolicy = new ExponentialBackoffRetryPolicy();
  }
  
  StandardRetryHandler(ExpiringMap<UUID, PendingMessage> paramExpiringMap)
  {
    this.memoryCache = paramExpiringMap;
    paramExpiringMap.addExpirationListener(new ExpirationListener()
    {
      public void expired(UUID paramAnonymousUUID, PendingMessage paramAnonymousPendingMessage)
      {
        StandardRetryHandler.this.raiseRetryRequest(paramAnonymousPendingMessage);
      }
    });
    this.retryRequest = new EventHandler();
    this.retryPolicy = new ExponentialBackoffRetryPolicy();
  }
  
  private void raiseRetryRequest(PendingMessage paramPendingMessage)
  {
    this.retryRequest.newEvent(paramPendingMessage);
  }
  
  public void complete()
  {
    this.completionRequested = true;
    this.lock.lock();
    try
    {
      Iterator localIterator = this.memoryCache.entrySet().iterator();
      while (localIterator.hasNext())
      {
        raiseRetryRequest((PendingMessage)((Map.Entry)localIterator.next()).getValue());
        localIterator.remove();
      }
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public int getPendingRetryCount()
  {
    return this.memoryCache.size();
  }
  
  public int getQueueCount()
  {
    return this.memoryCache.size();
  }
  
  public void onRetryEvent(Consumer<PendingMessage> paramConsumer)
  {
    this.retryRequest.addListener(paramConsumer);
  }
  
  public boolean queueForRetry(PendingMessage paramPendingMessage)
    throws IllegalStateException
  {
    if (this.retryPolicy == null) {
      throw new IllegalStateException("Call setRetryPolicy before calling queueForRetry.");
    }
    int i = paramPendingMessage.getRetryCount();
    Long localLong = this.retryPolicy.getNextRetryTime(i);
    if (localLong == null) {
      return false;
    }
    this.lock.lock();
    try
    {
      if (this.completionRequested)
      {
        if (i == 0)
        {
          paramPendingMessage.setRetryCount(i + 1).setSendTime(this.clock.millis() + localLong.longValue());
          raiseRetryRequest(paramPendingMessage);
          return true;
        }
        return false;
      }
      this.memoryCache.put(UUID.randomUUID(), paramPendingMessage, ExpirationPolicy.CREATED, localLong.longValue(), TimeUnit.MILLISECONDS);
      return true;
    }
    finally
    {
      this.lock.unlock();
    }
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/StandardRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */