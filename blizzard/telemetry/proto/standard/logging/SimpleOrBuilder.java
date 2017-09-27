package com.blizzard.telemetry.proto.standard.logging;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface SimpleOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getMessage();
  
  public abstract ByteString getMessageBytes();
  
  public abstract int getSeverity();
  
  public abstract String getSeverityName();
  
  public abstract ByteString getSeverityNameBytes();
  
  public abstract boolean hasMessage();
  
  public abstract boolean hasSeverity();
  
  public abstract boolean hasSeverityName();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/logging/SimpleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */