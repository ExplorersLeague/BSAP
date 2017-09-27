package com.blizzard.telemetry.proto.standard.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface TcpQualitySampleOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getAddress4();
  
  public abstract ByteString getAddress4Bytes();
  
  public abstract String getAddress6();
  
  public abstract ByteString getAddress6Bytes();
  
  public abstract long getBytesReceived();
  
  public abstract long getBytesSent();
  
  public abstract int getMessagesReceived();
  
  public abstract int getMessagesSent();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract TcpQualitySample.Metric getPingMs();
  
  public abstract int getPort();
  
  public abstract float getSampleTimeMs();
  
  public abstract long getSessionId();
  
  public abstract TcpQualitySample.Metric getTimeSincePrevMessageMs();
  
  public abstract boolean hasAddress4();
  
  public abstract boolean hasAddress6();
  
  public abstract boolean hasBytesReceived();
  
  public abstract boolean hasBytesSent();
  
  public abstract boolean hasMessagesReceived();
  
  public abstract boolean hasMessagesSent();
  
  public abstract boolean hasName();
  
  public abstract boolean hasPingMs();
  
  public abstract boolean hasPort();
  
  public abstract boolean hasSampleTimeMs();
  
  public abstract boolean hasSessionId();
  
  public abstract boolean hasTimeSincePrevMessageMs();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/network/TcpQualitySampleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */