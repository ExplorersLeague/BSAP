package com.blizzard.telemetry.sdk.interfaces;

import com.blizzard.telemetry.proto.Context;
import com.blizzard.telemetry.sdk.EnqueueOptions;
import com.blizzard.telemetry.sdk.PackageMessageNamePair;
import com.blizzard.telemetry.sdk.PendingMessage;
import com.blizzard.telemetry.sdk.RateLimitWindow;
import com.blizzard.telemetry.sdk.Response;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import com.blizzard.telemetry.sdk.TelemetryStatistics;
import com.blizzard.telemetry.sdk.tools.BiConsumer;
import com.blizzard.telemetry.sdk.tools.Clock;
import com.blizzard.telemetry.sdk.tools.Consumer;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.io.Closeable;
import java.util.concurrent.Future;

public abstract interface Telemetry
  extends Closeable
{
  public abstract Future<Void> complete();
  
  public abstract boolean enqueue(MessageLite paramMessageLite);
  
  public abstract boolean enqueue(MessageLite paramMessageLite, EnqueueOptions paramEnqueueOptions);
  
  public abstract boolean enqueue(String paramString1, String paramString2, ByteString paramByteString);
  
  public abstract boolean enqueue(String paramString1, String paramString2, ByteString paramByteString, EnqueueOptions paramEnqueueOptions);
  
  public abstract Context getDefaultContext();
  
  public abstract PackageMessageNamePair getPackageMessageNamePair(MessageLite paramMessageLite)
    throws IllegalArgumentException;
  
  public abstract PackageMessageNamePair getPackageMessageNamePair(Class<?> paramClass)
    throws IllegalArgumentException;
  
  public abstract PackageMessageNamePair getPackageMessageNamePair(String paramString)
    throws IllegalArgumentException;
  
  public abstract int getPendingRequestCount();
  
  public abstract Platform getPlatform();
  
  public abstract int getQueueCount();
  
  public abstract RateLimitWindow getRateLimitWindow();
  
  public abstract TelemetryStatistics getStatistics();
  
  public abstract void initialize();
  
  public abstract void initialize(TelemetryOptions paramTelemetryOptions);
  
  public abstract boolean isInitialized();
  
  public abstract boolean isServiceAvailable();
  
  public abstract void onFailedRequest(BiConsumer<PendingMessage, Response> paramBiConsumer);
  
  public abstract void onQueueOverflow(Consumer<PendingMessage> paramConsumer);
  
  public abstract void onSuccessfulRequest(BiConsumer<PendingMessage, Response> paramBiConsumer);
  
  public abstract void registerMessageNames(MessageLite paramMessageLite, String paramString1, String paramString2)
    throws IllegalArgumentException;
  
  public abstract void registerMessageNames(Class<?> paramClass, String paramString1, String paramString2)
    throws IllegalArgumentException;
  
  public abstract void registerMessageNames(String paramString1, String paramString2, String paramString3)
    throws IllegalArgumentException;
  
  public abstract void resume();
  
  public abstract void setClock(Clock paramClock);
  
  public abstract void setDefaultContext(Context paramContext);
  
  public abstract void suspend();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/interfaces/Telemetry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */