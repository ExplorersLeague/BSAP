package com.blizzard.pushlibrary.util;

import android.util.Log;

public class LogUtils
{
  private static final String TAG = generateLogTag(LogUtils.class);
  
  public static String generateLogTag(Class paramClass)
  {
    if (paramClass != null) {
      return "BlizzardPush - " + paramClass.getSimpleName();
    }
    Log.e(TAG, "Could not generate log tag, class is null");
    return "BlizzardPush";
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/util/LogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */