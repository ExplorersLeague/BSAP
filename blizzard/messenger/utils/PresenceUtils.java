package com.blizzard.messenger.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.blizzard.messenger.data.model.friends.Friend;

public final class PresenceUtils
{
  private static String getFriendPresenceString(@NonNull Context paramContext, @NonNull Friend paramFriend)
  {
    int i = paramFriend.getStatus();
    if ((i == 1) || (i == 4)) {
      return paramContext.getString(getPresenceStatusStringResId(i));
    }
    if (i == 3) {
      return String.format(paramContext.getString(2131362042), new Object[] { StringUtils.getOfflineTime(paramContext, String.valueOf(paramFriend.getAwayTime())) });
    }
    return String.format(paramContext.getString(2131362045), new Object[] { StringUtils.getOfflineTime(paramContext, paramFriend.getLastOnline()) });
  }
  
  public static int getGameBackgroundResId(@NonNull String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      case 0: 
      case 5: 
      case 6: 
      default: 
        return 2130837614;
        if (paramString.equals("None"))
        {
          i = 0;
          continue;
          if (paramString.equals("DST2"))
          {
            i = 1;
            continue;
            if (paramString.equals("D3"))
            {
              i = 2;
              continue;
              if (paramString.equals("WTCG"))
              {
                i = 3;
                continue;
                if (paramString.equals("Hero"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("App"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("BSAp"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("Pro"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("S1"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("S2"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("WoW")) {
                              i = 10;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return 2130837615;
    return 2130837613;
    return 2130837618;
    return 2130837617;
    return 2130837619;
    return 2130837620;
    return 2130837621;
    return 2130837622;
  }
  
  public static int getGameIconResId(@NonNull String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      case 0: 
      case 5: 
      case 6: 
      default: 
        return 2130837594;
        if (paramString.equals("None"))
        {
          i = 0;
          continue;
          if (paramString.equals("DST2"))
          {
            i = 1;
            continue;
            if (paramString.equals("D3"))
            {
              i = 2;
              continue;
              if (paramString.equals("WTCG"))
              {
                i = 3;
                continue;
                if (paramString.equals("Hero"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("App"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("BSAp"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("Pro"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("S1"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("S2"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("WoW")) {
                              i = 10;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return 2130837595;
    return 2130837593;
    return 2130837597;
    return 2130837596;
    return 2130837598;
    return 2130837599;
    return 2130837600;
    return 2130837601;
  }
  
  public static int getPresenceStatusIconResId(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      throw new IllegalArgumentException();
    case 1: 
      return 2130837709;
    case 3: 
      return 2130837710;
    case 4: 
      return 2130837711;
    }
    return 2130837712;
  }
  
  public static int getPresenceStatusStringResId(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      throw new IllegalArgumentException("Invalid presence status: " + paramInt);
    case 1: 
      return 2131362046;
    case 3: 
      return 2131362041;
    case 4: 
      return 2131362043;
    }
    return 2131362044;
  }
  
  public static String getPresenceUiString(@NonNull Context paramContext, @NonNull Friend paramFriend)
  {
    String str = paramFriend.getGame();
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        if (TextUtils.isEmpty(paramFriend.getRichPresence())) {
          break label128;
        }
        return paramFriend.getRichPresence();
        if (str.equals("App"))
        {
          i = 0;
          continue;
          if (str.equals("BSAp")) {
            i = 1;
          }
        }
        break;
      }
    }
    return getFriendPresenceString(paramContext, paramFriend);
    if (paramFriend.getStatus() == 1) {
      return paramFriend.getRichPresence();
    }
    return getFriendPresenceString(paramContext, paramFriend);
    label128:
    return getFriendPresenceString(paramContext, paramFriend);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/PresenceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */