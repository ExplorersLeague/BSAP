package com.blizzard.messenger.data.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.blizzard.messenger.data.model.friends.Friend;

public class SortingUtils
{
  private static final String TAG = SortingUtils.class.getSimpleName();
  private static final int THIRTY_MINUTES_IN_MILLIS = 1800000;
  
  private static int getGameSortPosition(String paramString)
  {
    int j = 0;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        j = 8;
      case 0: 
        return j;
        if (paramString.equals("DST2"))
        {
          i = 0;
          continue;
          if (paramString.equals("D3"))
          {
            i = 1;
            continue;
            if (paramString.equals("WTCG"))
            {
              i = 2;
              continue;
              if (paramString.equals("Hero"))
              {
                i = 3;
                continue;
                if (paramString.equals("Pro"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("S1"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("S2"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("WoW")) {
                        i = 7;
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
    return 1;
    return 2;
    return 3;
    return 4;
    return 5;
    return 6;
    return 7;
  }
  
  public static boolean isIdle(double paramDouble)
  {
    return System.currentTimeMillis() - paramDouble < 1800000.0D;
  }
  
  private static int sortByBattleTagAndRealId(Friend paramFriend1, Friend paramFriend2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String str1 = paramFriend1.getFullName();
      String str2 = paramFriend2.getFullName();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        return str1.compareToIgnoreCase(str2);
      }
      if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
        return str1.compareToIgnoreCase(paramFriend2.getBattleTag());
      }
      if ((TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        return paramFriend1.getBattleTag().compareToIgnoreCase(str2);
      }
      return paramFriend1.getBattleTag().compareToIgnoreCase(paramFriend2.getBattleTag());
    }
    return paramFriend1.getBattleTag().compareToIgnoreCase(paramFriend2.getBattleTag());
  }
  
  private static int sortByFavorite(Friend paramFriend1, Friend paramFriend2, boolean paramBoolean)
  {
    if ((paramFriend1.isFavorite()) && (!paramFriend2.isFavorite())) {
      return -1;
    }
    if ((!paramFriend1.isFavorite()) && (paramFriend2.isFavorite())) {
      return 1;
    }
    return sortByBattleTagAndRealId(paramFriend1, paramFriend2, paramBoolean);
  }
  
  public static int sortFriends(Context paramContext, @NonNull Friend paramFriend1, @NonNull Friend paramFriend2)
  {
    boolean bool1 = SharedPrefsUtils.isSortedShowingBattleTagAndRealId(paramContext);
    boolean bool2 = SharedPrefsUtils.isSortedByActivity(paramContext);
    boolean bool3 = SharedPrefsUtils.isSortedWithGroupedFavorites(paramContext);
    if (!bool2)
    {
      if (bool3) {
        return sortByFavorite(paramFriend1, paramFriend2, bool1);
      }
      return sortByBattleTagAndRealId(paramFriend1, paramFriend2, bool1);
    }
    if (bool3)
    {
      if ((paramFriend1.isFavorite()) && (!paramFriend2.isFavorite())) {
        return -1;
      }
      if ((!paramFriend1.isFavorite()) && (paramFriend2.isFavorite())) {
        return 1;
      }
    }
    int i;
    int j;
    if ((paramFriend1.isInGame()) && (paramFriend2.isInGame()))
    {
      i = getGameSortPosition(paramFriend1.getGame());
      j = getGameSortPosition(paramFriend2.getGame());
      if (i > j) {
        return 1;
      }
      if (i == j) {
        return sortByBattleTagAndRealId(paramFriend1, paramFriend2, bool1);
      }
      return -1;
    }
    if ((paramFriend1.isInGame()) && (!paramFriend2.isInGame())) {
      return -1;
    }
    if ((!paramFriend1.isInGame()) && (paramFriend2.isInGame())) {
      return 1;
    }
    label205:
    int k;
    label216:
    int m;
    label227:
    int n;
    if ((paramFriend1.getStatus() == 1) || (paramFriend1.getStatus() == 4))
    {
      i = 1;
      if ((paramFriend2.getStatus() != 1) && (paramFriend2.getStatus() != 4)) {
        break label291;
      }
      j = 1;
      if (paramFriend1.getStatus() != 3) {
        break label297;
      }
      k = 1;
      if (paramFriend2.getStatus() != 3) {
        break label303;
      }
      m = 1;
      if (paramFriend1.getStatus() != 5) {
        break label309;
      }
      n = 1;
      label238:
      if (paramFriend2.getStatus() != 5) {
        break label315;
      }
    }
    label291:
    label297:
    label303:
    label309:
    label315:
    for (int i1 = 1;; i1 = 0)
    {
      if (((i == 0) || (j == 0)) && ((k == 0) || (m == 0)) && ((n == 0) || (i1 == 0))) {
        break label321;
      }
      return sortByBattleTagAndRealId(paramFriend1, paramFriend2, bool1);
      i = 0;
      break;
      j = 0;
      break label205;
      k = 0;
      break label216;
      m = 0;
      break label227;
      n = 0;
      break label238;
    }
    label321:
    if ((paramFriend1.getStatus() != 5) && (paramFriend2.getStatus() == 5)) {
      return -1;
    }
    if ((paramFriend1.getStatus() == 5) && (paramFriend2.getStatus() != 5)) {
      return 1;
    }
    if ((paramFriend1.getStatus() != 3) && (paramFriend2.getStatus() == 3)) {
      return -1;
    }
    if ((paramFriend1.getStatus() == 3) && (paramFriend2.getStatus() != 3)) {
      return 1;
    }
    return sortByBattleTagAndRealId(paramFriend1, paramFriend2, bool1);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/SortingUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */