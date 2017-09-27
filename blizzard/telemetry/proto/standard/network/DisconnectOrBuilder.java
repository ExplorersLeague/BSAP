package com.blizzard.telemetry.proto.standard.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface DisconnectOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getAddress4();
  
  public abstract ByteString getAddress4Bytes();
  
  public abstract String getAddress6();
  
  public abstract ByteString getAddress6Bytes();
  
  public abstract String getDescription();
  
  public abstract ByteString getDescriptionBytes();
  
  public abstract long getDurationMs();
  
  public abstract String getHost();
  
  public abstract ByteString getHostBytes();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract int getPort();
  
  public abstract Disconnect.Reason getReason();
  
  public abstract boolean hasAddress4();
  
  public abstract boolean hasAddress6();
  
  public abstract boolean hasDescription();
  
  public abstract boolean hasDurationMs();
  
  public abstract boolean hasHost();
  
  public abstract boolean hasName();
  
  public abstract boolean hasPort();
  
  public abstract boolean hasReason();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/network/DisconnectOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */