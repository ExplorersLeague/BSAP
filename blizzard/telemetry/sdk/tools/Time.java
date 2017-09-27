package com.blizzard.telemetry.sdk.tools;

import java.util.Date;

public class Time
{
  private static Long fixedInstant = null;
  
  public static Long instant()
  {
    if (fixedInstant != null) {}
    for (long l = fixedInstant.longValue();; l = new Date().getTime()) {
      return Long.valueOf(l);
    }
  }
  
  public static double now()
  {
    return toUnixTime(instant());
  }
  
  public static String rfc1123(long paramLong)
  {
    return new Date(paramLong).toString();
  }
  
  public static void setFixedClockUtc(Long paramLong)
  {
    fixedInstant = paramLong;
  }
  
  public static Long toInstant(double paramDouble)
  {
    return Long.valueOf((1000.0D * paramDouble));
  }
  
  public static double toPreciseSeconds(Long paramLong)
  {
    return paramLong.longValue() / 1000.0D;
  }
  
  public static double toUnixTime(Long paramLong)
  {
    return paramLong.longValue() / 1000.0D;
  }
  
  public static void useDefaultClock()
  {
    fixedInstant = null;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/tools/Time.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */