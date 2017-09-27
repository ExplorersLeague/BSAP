package com.blizzard.telemetry.sdk.implementation;

import com.blizzard.telemetry.sdk.interfaces.RetryPolicy;

public class ExponentialBackoffRetryPolicy
  implements RetryPolicy
{
  private static final int[] RETRY_TIMES_IN_MINUTES = { 1, 2, 4, 8, 15, 30, 60 };
  
  public Long getNextRetryTime(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < RETRY_TIMES_IN_MINUTES.length)) {
      return new Long(RETRY_TIMES_IN_MINUTES[paramInt] * 60000);
    }
    return null;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/ExponentialBackoffRetryPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */