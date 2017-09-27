package com.blizzard.telemetry.proto.standard.process;

import com.google.protobuf.MessageLiteOrBuilder;

public abstract interface FinishOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract int getExitCode();
  
  public abstract int getPid();
  
  public abstract boolean hasExitCode();
  
  public abstract boolean hasPid();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/process/FinishOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */