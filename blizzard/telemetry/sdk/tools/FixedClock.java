package com.blizzard.telemetry.sdk.tools;

class FixedClock
  implements ClockTimeSource
{
  private long instant;
  
  public FixedClock(long paramLong)
  {
    this.instant = paramLong;
  }
  
  public long millis()
  {
    return this.instant;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/tools/FixedClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */