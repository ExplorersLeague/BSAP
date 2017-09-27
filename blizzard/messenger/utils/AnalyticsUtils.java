package com.blizzard.messenger.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;

public class AnalyticsUtils
{
  private static String getAnalyticsScreenName(Context paramContext)
  {
    return getAnalyticsScreenName(paramContext, null);
  }
  
  private static String getAnalyticsScreenName(Context paramContext, String paramString)
  {
    Resources localResources = paramContext.getResources();
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "ga_screen_" + ((Activity)paramContext).getClass().getSimpleName();; paramString = "ga_screen_" + paramString)
    {
      int i = localResources.getIdentifier(paramString, "string", paramContext.getPackageName());
      if (i == 0) {
        break;
      }
      return localResources.getString(i);
    }
    return null;
  }
  
  private static void sendScreenView(Tracker paramTracker, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramTracker.setScreenName(paramString);
      paramTracker.send(new HitBuilders.ScreenViewBuilder().build());
      return;
    }
    throw new IllegalArgumentException("This activity is not being tracked");
  }
  
  public static void trackScreenView(Tracker paramTracker, Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      sendScreenView(paramTracker, getAnalyticsScreenName(paramContext));
    }
  }
  
  public static void trackScreenView(Tracker paramTracker, Context paramContext, String paramString)
  {
    sendScreenView(paramTracker, getAnalyticsScreenName(paramContext, paramString));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/AnalyticsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */