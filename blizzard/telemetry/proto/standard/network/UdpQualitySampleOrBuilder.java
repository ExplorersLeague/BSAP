package com.blizzard.telemetry.proto.standard.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface UdpQualitySampleOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getAddress4();
  
  public abstract ByteString getAddress4Bytes();
  
  public abstract String getAddress6();
  
  public abstract ByteString getAddress6Bytes();
  
  public abstract float getBandwidthDownBps();
  
  public abstract float getBandwidthUpBps();
  
  public abstract long getBytesReceived();
  
  public abstract long getBytesSent();
  
  public abstract float getFixedInterpolationDelayMs();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract int getOutOfOrderOrDuplicatePacketsReceived();
  
  public abstract int getPacketsLostReceive();
  
  public abstract int getPacketsLostSend();
  
  public abstract int getPacketsReceived();
  
  public abstract int getPacketsSent();
  
  public abstract UdpQualitySample.Metric getPingMs();
  
  public abstract int getPort();
  
  public abstract float getRoundtripTimeSmoothedMs();
  
  public abstract float getRoundtripTimeVarianceEstimate();
  
  public abstract float getSampleTimeMs();
  
  public abstract long getSessionId();
  
  public abstract UdpQualitySample.Metric getTimeSincePrevPacketMs();
  
  public abstract boolean hasAddress4();
  
  public abstract boolean hasAddress6();
  
  public abstract boolean hasBandwidthDownBps();
  
  public abstract boolean hasBandwidthUpBps();
  
  public abstract boolean hasBytesReceived();
  
  public abstract boolean hasBytesSent();
  
  public abstract boolean hasFixedInterpolationDelayMs();
  
  public abstract boolean hasName();
  
  public abstract boolean hasOutOfOrderOrDuplicatePacketsReceived();
  
  public abstract boolean hasPacketsLostReceive();
  
  public abstract boolean hasPacketsLostSend();
  
  public abstract boolean hasPacketsReceived();
  
  public abstract boolean hasPacketsSent();
  
  public abstract boolean hasPingMs();
  
  public abstract boolean hasPort();
  
  public abstract boolean hasRoundtripTimeSmoothedMs();
  
  public abstract boolean hasRoundtripTimeVarianceEstimate();
  
  public abstract boolean hasSampleTimeMs();
  
  public abstract boolean hasSessionId();
  
  public abstract boolean hasTimeSincePrevPacketMs();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/network/UdpQualitySampleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */