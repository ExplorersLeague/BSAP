package com.blizzard.messenger.data.model.friends;

import android.support.annotation.NonNull;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class FriendPresence
{
  public static final String GAME_DESTINY_2 = "DST2";
  public static final String GAME_DIABLO_3 = "D3";
  public static final String GAME_HEARTHSTONE = "WTCG";
  public static final String GAME_HEROES_OF_THE_STORM = "Hero";
  public static final String GAME_LAUNCHER = "App";
  public static final String GAME_MOBILE = "BSAp";
  public static final String GAME_NONE = "None";
  public static final String GAME_OVERWATCH = "Pro";
  public static final String GAME_STARCRAFT_2 = "S2";
  public static final String GAME_STARCRAFT_HD = "S1";
  public static final String GAME_WORLD_OF_WARCRAFT = "WoW";
  public static final int STATUS_AVAILABLE = 1;
  public static final int STATUS_AWAY = 3;
  public static final int STATUS_BUSY = 4;
  public static final int STATUS_OFFLINE = 5;
  
  public static boolean isDesktop(@NonNull String paramString)
  {
    return paramString.equals("App");
  }
  
  public static boolean isGame(@NonNull String paramString)
  {
    boolean bool = false;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid game: " + paramString);
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
    bool = true;
    return bool;
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
  }
  
  public static boolean isMobile(@NonNull String paramString)
  {
    return paramString.equals("BSAp");
  }
  
  public static boolean isValidGame(@NonNull String paramString)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = false;
      }
      return bool;
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
    }
  }
  
  public static boolean isValidStatus(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return false;
    }
    return true;
  }
  
  public static String toGame(@NonNull String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid game: " + paramString);
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
    return "None";
    return "DST2";
    return "D3";
    return "WTCG";
    return "Hero";
    return "App";
    return "BSAp";
    return "Pro";
    return "S1";
    return "S2";
    return "WoW";
  }
  
  public static int toStatus(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      throw new IllegalArgumentException("Invalid status: " + paramInt);
    case 1: 
      return 1;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Game {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Status {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/friends/FriendPresence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */