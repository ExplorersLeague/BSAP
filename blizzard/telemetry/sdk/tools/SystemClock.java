package com.blizzard.telemetry.sdk.tools;

import java.util.Date;

class SystemClock
  implements ClockTimeSource
{
  public long millis()
  {
    return new Date().getTime();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/tools/SystemClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */