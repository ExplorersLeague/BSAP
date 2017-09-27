package com.blizzard.telemetry.sdk.interfaces;

import com.blizzard.telemetry.sdk.MultiPendingMessage;
import com.blizzard.telemetry.sdk.PendingMessage;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import com.blizzard.telemetry.sdk.tools.Consumer;
import java.io.Closeable;
import java.util.concurrent.Future;

public abstract interface TelemetryQueueProcessor
  extends Closeable
{
  public abstract boolean addToQueue(PendingMessage paramPendingMessage)
    throws IllegalArgumentException;
  
  public abstract void close();
  
  public abstract Future<Void> complete();
  
  public abstract int getQueueCount();
  
  public abstract void initialize(TelemetryOptions paramTelemetryOptions, Consumer<MultiPendingMessage> paramConsumer);
  
  public abstract boolean isCompletionRequested();
  
  public abstract boolean isInitialized();
  
  public abstract void resume();
  
  public abstract void suspend();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/interfaces/TelemetryQueueProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */