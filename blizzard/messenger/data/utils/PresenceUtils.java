package com.blizzard.messenger.data.utils;

import android.support.annotation.NonNull;

public final class PresenceUtils
{
  private static final String PRESENCE_AWAY = "AWAY";
  private static final String PRESENCE_BUSY = "BUSY";
  private static final String PRESENCE_OFFLINE = "OFFLINE";
  private static final String PRESENCE_ONLINE = "ONLINE";
  
  public static int getPresenceStatus(@NonNull String paramString)
  {
    if (paramString == null) {
      return 5;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      case 3: 
      default: 
        return 5;
      case 0: 
        return 3;
        if (paramString.equals("AWAY"))
        {
          i = 0;
          continue;
          if (paramString.equals("BUSY"))
          {
            i = 1;
            continue;
            if (paramString.equals("ONLINE"))
            {
              i = 2;
              continue;
              if (paramString.equals("OFFLINE")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return 4;
    return 1;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/PresenceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */