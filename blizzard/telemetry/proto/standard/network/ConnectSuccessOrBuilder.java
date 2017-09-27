package com.blizzard.telemetry.proto.standard.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface ConnectSuccessOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getAddress4();
  
  public abstract ByteString getAddress4Bytes();
  
  public abstract String getAddress6();
  
  public abstract ByteString getAddress6Bytes();
  
  public abstract String getHost();
  
  public abstract ByteString getHostBytes();
  
  public abstract int getLatencyMs();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract int getPort();
  
  public abstract boolean hasAddress4();
  
  public abstract boolean hasAddress6();
  
  public abstract boolean hasHost();
  
  public abstract boolean hasLatencyMs();
  
  public abstract boolean hasName();
  
  public abstract boolean hasPort();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/network/ConnectSuccessOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */