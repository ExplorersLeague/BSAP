package com.blizzard.telemetry.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface ContextOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract long getAccount();
  
  public abstract long getBnetId();
  
  public abstract Context.HostInfo getHost();
  
  public abstract Context.ProgramInfo getProgram();
  
  public abstract int getRetryCount();
  
  public abstract String getSessionId();
  
  public abstract ByteString getSessionIdBytes();
  
  public abstract long getSourceTime();
  
  public abstract long getTimeOffset();
  
  public abstract Context.TraceInfo getTrace();
  
  public abstract boolean hasAccount();
  
  public abstract boolean hasBnetId();
  
  public abstract boolean hasHost();
  
  public abstract boolean hasProgram();
  
  public abstract boolean hasRetryCount();
  
  public abstract boolean hasSessionId();
  
  public abstract boolean hasSourceTime();
  
  public abstract boolean hasTimeOffset();
  
  public abstract boolean hasTrace();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/ContextOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */