package com.blizzard.telemetry.sdk.implementation;

import com.blizzard.telemetry.sdk.EnqueueOptions;
import com.blizzard.telemetry.sdk.LogWrapper;
import com.blizzard.telemetry.sdk.PendingMessage;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

public class PriorityRequestQueue
{
  protected LogWrapper LOGGER = LogWrapper.NullLogger(PriorityRequestQueue.class);
  private ConcurrentSkipListSet<PendingMessage> queue;
  Comparator<PendingMessage> requestComparator = new Comparator()
  {
    public int compare(PendingMessage paramAnonymousPendingMessage1, PendingMessage paramAnonymousPendingMessage2)
    {
      if ((paramAnonymousPendingMessage1 == null) && (paramAnonymousPendingMessage2 == null)) {
        return 0;
      }
      if (paramAnonymousPendingMessage1 == null) {
        return -1;
      }
      if (paramAnonymousPendingMessage2 == null) {
        return 1;
      }
      EnqueueOptions localEnqueueOptions1 = paramAnonymousPendingMessage1.getOptions();
      EnqueueOptions localEnqueueOptions2 = paramAnonymousPendingMessage2.getOptions();
      int i;
      if (localEnqueueOptions1 == null)
      {
        i = 0;
        if (localEnqueueOptions2 != null) {
          break label69;
        }
      }
      label69:
      for (int j = 0;; j = localEnqueueOptions2.getPriority())
      {
        if (i == j) {
          break label79;
        }
        return i - j;
        i = localEnqueueOptions1.getPriority();
        break;
      }
      label79:
      if ((paramAnonymousPendingMessage1.getRetryCount() > 0) || (paramAnonymousPendingMessage2.getRetryCount() > 0))
      {
        l1 = paramAnonymousPendingMessage1.getSendTime();
        l2 = paramAnonymousPendingMessage2.getSendTime();
        if (l1 != l2)
        {
          if (l1 < l2) {
            return -1;
          }
          return 1;
        }
      }
      long l1 = paramAnonymousPendingMessage1.getQueueTime();
      long l2 = paramAnonymousPendingMessage2.getQueueTime();
      if (l1 != l2)
      {
        if (l1 < l2) {
          return -1;
        }
        return 1;
      }
      if (paramAnonymousPendingMessage1.id() < paramAnonymousPendingMessage2.id()) {
        return -1;
      }
      if (paramAnonymousPendingMessage1.id() > paramAnonymousPendingMessage2.id()) {
        return 1;
      }
      return 0;
    }
  };
  
  public PriorityRequestQueue()
  {
    this.queue = new ConcurrentSkipListSet(this.requestComparator);
  }
  
  public PriorityRequestQueue(Comparator<PendingMessage> paramComparator)
  {
    this.queue = new ConcurrentSkipListSet(paramComparator);
  }
  
  public boolean add(PendingMessage paramPendingMessage)
  {
    if (paramPendingMessage == null)
    {
      this.LOGGER.LogInfo("Request i={0}[p={1}, t={2}] {3}. QueueCount={4}.", new Object[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0), "null", Integer.valueOf(size()) });
      return false;
    }
    Object localObject = paramPendingMessage.getOptions();
    int i;
    long l1;
    long l2;
    boolean bool;
    if (localObject == null)
    {
      i = 0;
      l1 = paramPendingMessage.getQueueTime();
      l2 = paramPendingMessage.id();
      bool = this.queue.add(paramPendingMessage);
      localObject = this.LOGGER;
      if (!bool) {
        break label164;
      }
    }
    label164:
    for (paramPendingMessage = "enqueued";; paramPendingMessage = "duplicate")
    {
      ((LogWrapper)localObject).LogInfo("Request i={0}[p={1}, t={2}] {3}. QueueCount={4}.", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Long.valueOf(l1), paramPendingMessage, Integer.valueOf(size()) });
      return bool;
      i = ((EnqueueOptions)localObject).getPriority();
      break;
    }
  }
  
  public void dump()
  {
    dump("");
  }
  
  public void dump(String paramString)
  {
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    paramString = (String)localObject1;
    if (!((String)localObject1).isEmpty())
    {
      localObject2 = localObject1;
      if (((String)localObject1).endsWith(":")) {
        localObject2 = (String)localObject1 + " ";
      }
      paramString = (String)localObject2;
      if (!((String)localObject2).endsWith(": ")) {
        paramString = (String)localObject2 + ": ";
      }
    }
    this.LOGGER.LogInfo("{0}QueueCount={1}.", new Object[] { paramString, Integer.valueOf(size()) });
    int i = 0;
    Object localObject2 = this.queue.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      PendingMessage localPendingMessage = (PendingMessage)((Iterator)localObject2).next();
      label161:
      int j;
      label168:
      long l1;
      label176:
      long l2;
      label184:
      LogWrapper localLogWrapper;
      if (localPendingMessage == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label268;
        }
        j = 0;
        if (localPendingMessage != null) {
          break label277;
        }
        l1 = 0L;
        if (localPendingMessage != null) {
          break label287;
        }
        l2 = 0L;
        localLogWrapper = this.LOGGER;
        if (localPendingMessage != null) {
          break label297;
        }
      }
      label268:
      label277:
      label287:
      label297:
      for (localObject1 = "null";; localObject1 = "in-queued")
      {
        localLogWrapper.LogInfo("{0}Request[{1}] i={2}[p={3}, t={4}] {5}.", new Object[] { paramString, Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j), Long.valueOf(l1), localObject1 });
        i += 1;
        break;
        localObject1 = localPendingMessage.getOptions();
        break label161;
        j = ((EnqueueOptions)localObject1).getPriority();
        break label168;
        l1 = localPendingMessage.getQueueTime();
        break label176;
        l2 = localPendingMessage.id();
        break label184;
      }
    }
  }
  
  public PendingMessage first()
  {
    PendingMessage localPendingMessage = (PendingMessage)this.queue.first();
    EnqueueOptions localEnqueueOptions = localPendingMessage.getOptions();
    if (localEnqueueOptions == null) {}
    for (int i = 0;; i = localEnqueueOptions.getPriority())
    {
      long l1 = localPendingMessage.getQueueTime();
      long l2 = localPendingMessage.id();
      this.LOGGER.LogInfo("Request i={0}[p={1}, t={2}] peeked. QueueCount={3}.", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(size()) });
      return localPendingMessage;
    }
  }
  
  public void initialize(TelemetryOptions paramTelemetryOptions)
  {
    if (paramTelemetryOptions != null) {
      this.LOGGER = new LogWrapper(PriorityRequestQueue.class, paramTelemetryOptions.getLogger());
    }
    while (this.LOGGER != null) {
      return;
    }
    this.LOGGER = LogWrapper.NullLogger(PriorityRequestQueue.class);
  }
  
  public Iterator<PendingMessage> iterator()
  {
    return this.queue.iterator();
  }
  
  public PendingMessage pollFirst()
  {
    return (PendingMessage)this.queue.pollFirst();
  }
  
  public int size()
  {
    return this.queue.size();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/PriorityRequestQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */