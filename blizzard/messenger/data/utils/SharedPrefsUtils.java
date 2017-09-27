package com.blizzard.messenger.data.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPrefsUtils
{
  private static final int DEFAULT_REGION_CODE = -1;
  private static final String PREFS_LOCAL_ONLY = "com.blizzard.messenger.local_preferences";
  private static final String PREF_BGS_AUTH_CREDENTIALS = "com.blizzard.messenger.BGS_AUTH_CREDENTIALS";
  private static final String PREF_BGS_REGION_CODE = "com.blizzard.messenger.BGS_REGION_CODE";
  private static final String PREF_CURRENT_PAGE = "com.blizzard.messenger.CURRENT_PAGE";
  private static final String PREF_DID_THEME_CHANGE = "com.blizzard.messenger.DID_THEME_CHANGE";
  private static final String PREF_ENABLE_SOUNDS = "com.blizzard.messenger.ENABLE_SOUNDS";
  private static final String PREF_ENABLE_TEXT_TO_SPEECH = "com.blizzard.messenger.ENABLE_TEXT_TO_SPEECH";
  private static final String PREF_PUSH_NOTIFICATION_PLATFORM = "com.blizzard.messenger.PUSH_NOTIFICATION_PLATFORM";
  private static final String PREF_PUSH_NOTIFICATION_TOKEN = "com.blizzard.messenger.PUSH_NOTIFICATION_TOKEN";
  private static final String PREF_SORT_BY_ACTIVITY = "com.blizzard.messenger.SORT_BY_GAME";
  private static final String PREF_SORT_GROUP_FAVORITES = "com.blizzard.messenger.SORT_GROUP_FAVORITES";
  private static final String PREF_SORT_HIDE_OFFLINE = "com.blizzard.messenger.SORT_HIDE_OFFLINE";
  private static final String PREF_SORT_SHOW_BATTLETAG_AND_REAL_ID = "com.blizzard.messenger.SORT_SHOW_BATTLETAG_AND_REAL_ID";
  private static final String PREF_USE_LIGHT_THEME = "com.blizzard.messenger.USE_LIGHT_THEME";
  private static final String PREF_WEB_AUTH_TOKEN = "com.blizzard.messenger.WEB_AUTH_TOKEN";
  private static final String PREF_WEB_AUTH_URLS = "com.blizzard.messenger.WEB_AUTH_URL";
  
  public static void clear(Context paramContext)
  {
    getLocalEditor(paramContext).clear().apply();
    getLocalEditor(paramContext).clear().apply();
  }
  
  public static boolean didThemeChange(Context paramContext)
  {
    return getLocalPrefs(paramContext).getBoolean("com.blizzard.messenger.DID_THEME_CHANGE", false);
  }
  
  public static String getBgsAuthCredentials(Context paramContext)
  {
    return getLocalPrefs(paramContext).getString("com.blizzard.messenger.BGS_AUTH_CREDENTIALS", null);
  }
  
  public static int getBgsRegionCode(Context paramContext)
  {
    try
    {
      int i = getLocalPrefs(paramContext).getInt("com.blizzard.messenger.BGS_REGION_CODE", -1);
      return i;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static int getCurrentPage(Context paramContext)
  {
    return getLocalPrefs(paramContext).getInt("com.blizzard.messenger.CURRENT_PAGE", 0);
  }
  
  private static SharedPreferences.Editor getLocalEditor(Context paramContext)
  {
    return getLocalPrefs(paramContext).edit();
  }
  
  public static SharedPreferences getLocalPrefs(Context paramContext)
  {
    return paramContext.getApplicationContext().getSharedPreferences("com.blizzard.messenger.local_preferences", 0);
  }
  
  public static String getPushNotificationPlatform(Context paramContext)
  {
    return getLocalPrefs(paramContext).getString("com.blizzard.messenger.PUSH_NOTIFICATION_PLATFORM", null);
  }
  
  public static String getPushNotificationToken(Context paramContext)
  {
    return getLocalPrefs(paramContext).getString("com.blizzard.messenger.PUSH_NOTIFICATION_TOKEN", null);
  }
  
  public static String getWebAuthToken(Context paramContext)
  {
    return getLocalPrefs(paramContext).getString("com.blizzard.messenger.WEB_AUTH_TOKEN", null);
  }
  
  public static String getWebAuthUrls(Context paramContext)
  {
    return getLocalPrefs(paramContext).getString("com.blizzard.messenger.WEB_AUTH_URL", null);
  }
  
  public static boolean isLightThemeEnabled(Context paramContext)
  {
    return getLocalPrefs(paramContext).getBoolean("com.blizzard.messenger.USE_LIGHT_THEME", false);
  }
  
  public static boolean isSortedByActivity(Context paramContext)
  {
    return getLocalPrefs(paramContext).getBoolean("com.blizzard.messenger.SORT_BY_GAME", true);
  }
  
  public static boolean isSortedShowingBattleTagAndRealId(Context paramContext)
  {
    return getLocalPrefs(paramContext).getBoolean("com.blizzard.messenger.SORT_SHOW_BATTLETAG_AND_REAL_ID", true);
  }
  
  public static boolean isSortedWithGroupedFavorites(Context paramContext)
  {
    return getLocalPrefs(paramContext).getBoolean("com.blizzard.messenger.SORT_GROUP_FAVORITES", true);
  }
  
  public static int isSortedWithOfflineHidden(Context paramContext)
  {
    return getLocalPrefs(paramContext).getInt("com.blizzard.messenger.SORT_HIDE_OFFLINE", -1);
  }
  
  public static boolean isSoundEnabled(Context paramContext)
  {
    return getLocalPrefs(paramContext).getBoolean("com.blizzard.messenger.ENABLE_SOUNDS", true);
  }
  
  public static boolean isTextToSpeechEnabled(Context paramContext)
  {
    return getLocalPrefs(paramContext).getBoolean("com.blizzard.messenger.ENABLE_TEXT_TO_SPEECH", false);
  }
  
  public static void setBgsAuthCredentials(Context paramContext, String paramString)
  {
    try
    {
      getLocalEditor(paramContext).putString("com.blizzard.messenger.BGS_AUTH_CREDENTIALS", paramString).apply();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setBgsRegionCode(Context paramContext, int paramInt)
  {
    try
    {
      getLocalEditor(paramContext).putInt("com.blizzard.messenger.BGS_REGION_CODE", paramInt).apply();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setCurrentPage(Context paramContext, int paramInt)
  {
    getLocalEditor(paramContext).putInt("com.blizzard.messenger.CURRENT_PAGE", paramInt).apply();
  }
  
  public static void setLightThemeEnabled(Context paramContext, boolean paramBoolean)
  {
    getLocalEditor(paramContext).putBoolean("com.blizzard.messenger.USE_LIGHT_THEME", false).apply();
    setThemeChanged(paramContext, false);
  }
  
  public static void setPushNotificationPlatform(Context paramContext, String paramString)
  {
    getLocalEditor(paramContext).putString("com.blizzard.messenger.PUSH_NOTIFICATION_PLATFORM", paramString).apply();
  }
  
  public static void setPushNotificationToken(Context paramContext, String paramString)
  {
    getLocalEditor(paramContext).putString("com.blizzard.messenger.PUSH_NOTIFICATION_TOKEN", paramString).apply();
  }
  
  public static void setSortByActivity(Context paramContext, boolean paramBoolean)
  {
    getLocalEditor(paramContext).putBoolean("com.blizzard.messenger.SORT_BY_GAME", paramBoolean).apply();
  }
  
  public static void setSortGroupFavorites(Context paramContext, boolean paramBoolean)
  {
    getLocalEditor(paramContext).putBoolean("com.blizzard.messenger.SORT_GROUP_FAVORITES", paramBoolean).apply();
  }
  
  public static void setSortHideOffline(Context paramContext, int paramInt)
  {
    getLocalEditor(paramContext).putInt("com.blizzard.messenger.SORT_HIDE_OFFLINE", paramInt).apply();
  }
  
  public static void setSortShowBattleTagAndRealId(Context paramContext, boolean paramBoolean)
  {
    getLocalEditor(paramContext).putBoolean("com.blizzard.messenger.SORT_SHOW_BATTLETAG_AND_REAL_ID", paramBoolean).apply();
  }
  
  public static void setSoundsEnabled(Context paramContext, boolean paramBoolean)
  {
    try
    {
      getLocalEditor(paramContext).putBoolean("com.blizzard.messenger.ENABLE_SOUNDS", paramBoolean).apply();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setTextToSpeechEnabled(Context paramContext, boolean paramBoolean)
  {
    try
    {
      getLocalEditor(paramContext).putBoolean("com.blizzard.messenger.ENABLE_TEXT_TO_SPEECH", paramBoolean).apply();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setThemeChanged(Context paramContext, boolean paramBoolean)
  {
    getLocalEditor(paramContext).putBoolean("com.blizzard.messenger.DID_THEME_CHANGE", paramBoolean).apply();
  }
  
  public static void setWebAuthToken(Context paramContext, String paramString)
  {
    try
    {
      getLocalEditor(paramContext).putString("com.blizzard.messenger.WEB_AUTH_TOKEN", paramString).apply();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setWebAuthUrls(Context paramContext, String paramString)
  {
    try
    {
      getLocalEditor(paramContext).putString("com.blizzard.messenger.WEB_AUTH_URL", paramString).apply();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/SharedPrefsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */