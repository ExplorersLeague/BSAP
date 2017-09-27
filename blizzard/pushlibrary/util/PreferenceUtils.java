package com.blizzard.pushlibrary.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class PreferenceUtils
{
  private static final String TAG = LogUtils.generateLogTag(PreferenceUtils.class);
  
  public static String loadFromPreferences(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).getString(paramString, "");
    }
    Log.e(TAG, "Could not load from preferences, context is null");
    return "";
  }
  
  public static void saveToPreferences(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).edit();
      paramContext.putString(paramString1, paramString2);
      paramContext.commit();
      return;
    }
    Log.e(TAG, "Could not save to preferences: null context");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/util/PreferenceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */