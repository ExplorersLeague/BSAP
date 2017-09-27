package com.blizzard.telemetry.sdk.tools;

import java.util.Date;

public class Clock
{
  private ClockTimeSource innerClock;
  
  Clock(ClockTimeSource paramClockTimeSource)
  {
    this.innerClock = paramClockTimeSource;
  }
  
  public static Clock fixed(long paramLong)
  {
    return new Clock(new FixedClock(paramLong));
  }
  
  public static Clock systemUTC()
  {
    return new Clock(new SystemClock());
  }
  
  public Long instant()
  {
    return Long.valueOf(millis());
  }
  
  public long millis()
  {
    return this.innerClock.millis();
  }
  
  public double now()
  {
    return toUnixTime(Long.valueOf(millis()));
  }
  
  public String rfc1123(long paramLong)
  {
    return new Date(paramLong).toString();
  }
  
  public long toInstant(double paramDouble)
  {
    return (1000.0D * paramDouble);
  }
  
  public double toUnixTime(Long paramLong)
  {
    return paramLong.longValue() / 1000.0D;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/tools/Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */