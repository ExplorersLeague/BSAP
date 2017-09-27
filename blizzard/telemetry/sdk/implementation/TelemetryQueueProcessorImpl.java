package com.blizzard.telemetry.sdk.implementation;

import com.blizzard.telemetry.sdk.LogWrapper;
import com.blizzard.telemetry.sdk.MultiPendingMessage;
import com.blizzard.telemetry.sdk.PendingMessage;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import com.blizzard.telemetry.sdk.interfaces.RequestHandler;
import com.blizzard.telemetry.sdk.interfaces.TelemetryQueueProcessor;
import com.blizzard.telemetry.sdk.tools.Clock;
import com.blizzard.telemetry.sdk.tools.Consumer;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TelemetryQueueProcessorImpl
  implements TelemetryQueueProcessor
{
  protected LogWrapper LOGGER = LogWrapper.NullLogger(TelemetryQueueProcessorImpl.class);
  private Clock clock = Clock.systemUTC();
  private Future<Void> completionFuture;
  private volatile boolean completionRequested;
  private ExecutorService executor;
  private final Condition hasMessages = this.lock.newCondition();
  private Condition isResumed = this.lock.newCondition();
  private final ReentrantLock lock = new ReentrantLock();
  private TelemetryOptions options;
  private PriorityRequestQueue queue = new PriorityRequestQueue();
  private AtomicInteger queueSize = new AtomicInteger();
  private RequestHandler requestHandler;
  private Consumer<MultiPendingMessage> sendMultiMessageConsumer;
  private volatile boolean suspended = false;
  
  public TelemetryQueueProcessorImpl(RequestHandler paramRequestHandler)
  {
    this.requestHandler = paramRequestHandler;
  }
  
  private void drainQueue()
  {
    this.LOGGER.LogInfo("drainQueue() : begun");
    try
    {
      this.lock.lockInterruptibly();
      if (Thread.interrupted())
      {
        this.LOGGER.LogInfo("Background task interrupted. QueueCount={0}, PendingRequestCount={1}.", new Object[] { Integer.valueOf(getQueueCount()), Integer.valueOf(this.requestHandler.getPendingRequestCount()) });
        this.lock.unlock();
        this.LOGGER.LogInfo("drainQueue() : done!");
        return;
      }
      if (this.suspended)
      {
        this.LOGGER.LogInfo("Waiting to be resumed...");
        this.isResumed.await();
      }
      long l = this.clock.millis();
      MultiPendingMessage localMultiPendingMessage = new MultiPendingMessage();
      Iterator localIterator = this.queue.iterator();
      PendingMessage localPendingMessage;
      if (localIterator.hasNext())
      {
        localPendingMessage = (PendingMessage)localIterator.next();
        if ((this.completionRequested) || (localPendingMessage.getSendTime() >= l)) {
          localMultiPendingMessage.addRequest(localPendingMessage);
        }
      }
      for (;;)
      {
        if ((localIterator.hasNext()) && (localMultiPendingMessage.count() < this.options.getMaxBatchSize()))
        {
          localPendingMessage = (PendingMessage)localIterator.next();
          if ((this.completionRequested) || (localPendingMessage.getRetryCount() <= 0) || (localPendingMessage.getSendTime() >= l)) {}
        }
        else
        {
          if (localMultiPendingMessage.count() != 0) {
            break label490;
          }
          if (!this.completionRequested) {
            break label451;
          }
          this.LOGGER.LogInfo("Background task in completion mode. Ending. QueueCount={0}, PendingRequestCount={1}.", new Object[] { Integer.valueOf(getQueueCount()), Integer.valueOf(this.requestHandler.getPendingRequestCount()) });
          this.LOGGER.LogInfo("Background task waiting until there are no more pending requests...");
          this.lock.unlock();
          this.requestHandler.waitForNoPendingRequests();
          this.LOGGER.LogInfo("Background task successfully waited until there are no more pending requests.");
          this.lock.lock();
          if (this.queueSize.get() != 0) {
            break label451;
          }
          this.LOGGER.LogInfo("Background task successfully waited for empty queue.");
          this.lock.unlock();
          break;
        }
        if ((this.completionRequested) || (localPendingMessage.getSendTime() >= l)) {
          localMultiPendingMessage.addRequest(localPendingMessage);
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        this.LOGGER.LogInfo("Background task interrupted. QueueCount={0}, PendingRequestCount={1}.", new Object[] { Integer.valueOf(getQueueCount()), Integer.valueOf(this.requestHandler.getPendingRequestCount()) });
        Thread.currentThread().interrupt();
        this.lock.unlock();
      }
      label451:
      if (this.queueSize.get() == 0)
      {
        this.LOGGER.LogInfo("Queue is empty, waiting for messages...");
        this.hasMessages.await();
      }
      for (;;)
      {
        this.lock.unlock();
        break;
        label490:
        this.LOGGER.LogInfo("Batch Message holds={0}.", new Object[] { Integer.valueOf(localInterruptedException.count()) });
        this.sendMultiMessageConsumer.accept(localInterruptedException);
        int i = 0;
        while (i < localInterruptedException.count())
        {
          this.queue.pollFirst();
          this.queueSize.decrementAndGet();
          i += 1;
        }
      }
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private static void signalCondition(Lock paramLock, Condition paramCondition)
  {
    paramLock.lock();
    try
    {
      paramCondition.signal();
      return;
    }
    finally
    {
      paramLock.unlock();
    }
  }
  
  private void signalHasMessages()
  {
    this.LOGGER.LogInfo("Signaling that messages are available...");
    signalCondition(this.lock, this.hasMessages);
  }
  
  private void signalResumed()
  {
    this.suspended = false;
    signalCondition(this.lock, this.isResumed);
  }
  
  public boolean addToQueue(PendingMessage paramPendingMessage)
    throws IllegalArgumentException
  {
    if (paramPendingMessage == null)
    {
      this.LOGGER.LogError("Request null. QueueCount={0}, PendingRequestCount={1}.", new Object[] { Integer.valueOf(this.queueSize.get()), Integer.valueOf(this.requestHandler.getPendingRequestCount()) });
      throw new IllegalArgumentException("'request' may not be null.");
    }
    if ((paramPendingMessage.getQueueTime() == 0L) || (paramPendingMessage.getSendTime() == 0L))
    {
      long l = this.clock.millis();
      paramPendingMessage.setQueueTime(l).setSendTime(this.options.getBatchTimeout() + l);
    }
    if (!this.queue.add(paramPendingMessage))
    {
      this.LOGGER.LogError("Request {0} duplicate. QueueCount={1}, PendingRequestCount={2}.", new Object[] { Long.valueOf(paramPendingMessage.id()), Integer.valueOf(this.queueSize.get()), Integer.valueOf(this.requestHandler.getPendingRequestCount()) });
      return false;
    }
    if (this.queueSize.getAndIncrement() == 0) {
      signalHasMessages();
    }
    return true;
  }
  
  public void close()
  {
    this.LOGGER.LogInfo("Closing...");
    if (this.completionFuture != null)
    {
      this.LOGGER.LogInfo("...completionFuture.cancel(true)");
      this.completionFuture.cancel(true);
    }
    if (this.executor != null)
    {
      this.LOGGER.LogInfo("...executor.shutdown()");
      this.executor.shutdown();
      this.executor = null;
    }
    this.LOGGER.LogInfo("...closed!");
  }
  
  public Future<Void> complete()
  {
    if (!this.completionRequested) {}
    try
    {
      this.LOGGER.LogInfo("locking for: Completion request...");
      this.lock.lock();
      this.LOGGER.LogInfo("Completion requested...");
      this.completionRequested = true;
      if (this.suspended)
      {
        System.err.println("warning: resuming suspended worker thread...");
        this.LOGGER.LogWarn("resuming suspended worker thread...");
        resume();
      }
      signalHasMessages();
      this.LOGGER.LogInfo("Entering completion mode.  QueueCount={0}, PendingRequestCount={1}.", new Object[] { Integer.valueOf(getQueueCount()), Integer.valueOf(this.requestHandler.getPendingRequestCount()) });
      this.LOGGER.LogInfo("unlocking for: completion request...");
      this.lock.unlock();
      if (this.completionFuture == null)
      {
        System.err.println("error: complete() without prior initialize(), expect NullPointerException.");
        this.LOGGER.LogError("complete() without prior initialize(), expect NullPointerException.");
      }
      return this.completionFuture;
    }
    finally
    {
      this.LOGGER.LogInfo("unlocking for: completion request...");
      this.lock.unlock();
    }
  }
  
  public int getQueueCount()
  {
    return this.queueSize.get();
  }
  
  public void initialize(TelemetryOptions paramTelemetryOptions, Consumer<MultiPendingMessage> paramConsumer)
  {
    if (paramTelemetryOptions == null) {
      throw new IllegalArgumentException("'options' may not be null.");
    }
    this.options = paramTelemetryOptions.clone();
    this.LOGGER = new LogWrapper(TelemetryQueueProcessorImpl.class, paramTelemetryOptions.getLogger());
    this.LOGGER.LogInfo("initialize(...)");
    if (paramTelemetryOptions.getRequestHandler() != null) {
      this.requestHandler = paramTelemetryOptions.getRequestHandler();
    }
    if (paramTelemetryOptions.getClock() != null) {
      this.clock = paramTelemetryOptions.getClock();
    }
    this.queue.initialize(paramTelemetryOptions);
    this.executor = Executors.newFixedThreadPool(1, new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = Executors.defaultThreadFactory().newThread(paramAnonymousRunnable);
        paramAnonymousRunnable.setDaemon(true);
        return paramAnonymousRunnable;
      }
    });
    this.sendMultiMessageConsumer = paramConsumer;
    this.completionRequested = false;
    this.completionFuture = this.executor.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        Thread.currentThread().setName("drainQueue() thread");
        TelemetryQueueProcessorImpl.this.LOGGER.LogInfo("completionFuture: draining Queue:  QueueCount={0}, PendingRequestCount={1}.", new Object[] { Integer.valueOf(TelemetryQueueProcessorImpl.this.getQueueCount()), Integer.valueOf(TelemetryQueueProcessorImpl.this.requestHandler.getPendingRequestCount()) });
        TelemetryQueueProcessorImpl.this.drainQueue();
        TelemetryQueueProcessorImpl.this.LOGGER.LogInfo("completionFuture: drained Queue:  QueueCount={0}, PendingRequestCount={1}.", new Object[] { Integer.valueOf(TelemetryQueueProcessorImpl.this.getQueueCount()), Integer.valueOf(TelemetryQueueProcessorImpl.this.requestHandler.getPendingRequestCount()) });
        return null;
      }
    });
  }
  
  public boolean isCompletionRequested()
  {
    return this.completionRequested;
  }
  
  public boolean isInitialized()
  {
    return (this.options != null) && (this.requestHandler != null) && (this.sendMultiMessageConsumer != null) && (this.executor != null);
  }
  
  public PendingMessage pollFirst()
  {
    this.LOGGER.LogInfo("Request {0} first. QueueCount={1}, PendingRequestCount={2}.", new Object[] { Long.valueOf(this.queue.first().id()), Integer.valueOf(this.queueSize.get()), Integer.valueOf(this.requestHandler.getPendingRequestCount()) });
    return this.queue.pollFirst();
  }
  
  public void resume()
  {
    this.LOGGER.LogInfo("Resuming.  QueueCount={0}, PendingRequestCount={1}.", new Object[] { Integer.valueOf(getQueueCount()), Integer.valueOf(this.requestHandler.getPendingRequestCount()) });
    signalResumed();
  }
  
  public void suspend()
  {
    this.suspended = true;
    this.LOGGER.LogInfo("Suspended.  QueueCount={0}, PendingRequestCount={1}.", new Object[] { Integer.valueOf(getQueueCount()), Integer.valueOf(this.requestHandler.getPendingRequestCount()) });
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/TelemetryQueueProcessorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */