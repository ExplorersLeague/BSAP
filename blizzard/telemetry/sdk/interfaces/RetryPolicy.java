package com.blizzard.telemetry.sdk.interfaces;

public abstract interface RetryPolicy
{
  public abstract Long getNextRetryTime(int paramInt);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/interfaces/RetryPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */