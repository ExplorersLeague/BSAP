package com.blizzard.telemetry.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface EnvelopeOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract ByteString getContents();
  
  public abstract Context getContext();
  
  public abstract Envelope.FlowInfo getFlow();
  
  public abstract String getMessageName();
  
  public abstract ByteString getMessageNameBytes();
  
  public abstract String getPackageName();
  
  public abstract ByteString getPackageNameBytes();
  
  public abstract boolean hasContents();
  
  public abstract boolean hasContext();
  
  public abstract boolean hasFlow();
  
  public abstract boolean hasMessageName();
  
  public abstract boolean hasPackageName();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/EnvelopeOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */