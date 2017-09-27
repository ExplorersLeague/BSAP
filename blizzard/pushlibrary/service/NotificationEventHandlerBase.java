package com.blizzard.pushlibrary.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;

public abstract class NotificationEventHandlerBase
  extends IntentService
{
  public static final String ACTION_RECEIVE_PUSH_TOKEN = "com.blizzard.pushlibrary.registration.RECEIVE_TOKEN";
  public static final String EXTRA_KEY_PLATFORM = "com.blizzard.pushlibrary.platform";
  public static final String EXTRA_KEY_PREV_TOKEN = "com.blizzard.pushlibrary.prevToken";
  public static final String EXTRA_KEY_PUSH_TOKEN = "com.blizzard.pushlibrary.pushToken";
  
  public NotificationEventHandlerBase()
  {
    super(NotificationEventHandlerBase.class.getSimpleName());
  }
  
  public abstract void onDeeplinkClicked(String paramString, Bundle paramBundle);
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Bundle localBundle = paramIntent.getExtras();
      if (("com.blizzard.pushlibrary.notification.DEEPLINK".equals(paramIntent.getAction())) && (localBundle != null) && (localBundle.containsKey("deeplink"))) {
        onDeeplinkClicked(localBundle.getString("deeplink"), localBundle);
      }
      if (("com.blizzard.pushlibrary.registration.RECEIVE_TOKEN".equals(paramIntent.getAction())) && (localBundle != null) && (localBundle.containsKey("com.blizzard.pushlibrary.pushToken")) && (localBundle.containsKey("com.blizzard.pushlibrary.platform")) && (localBundle.containsKey("com.blizzard.pushlibrary.prevToken"))) {
        onReceivePushToken(localBundle.getString("com.blizzard.pushlibrary.pushToken"), localBundle.getString("com.blizzard.pushlibrary.prevToken"), localBundle.getString("com.blizzard.pushlibrary.platform"));
      }
      if (("com.blizzard.pushlibrary.notification.BUTTON".equals(paramIntent.getAction())) && (localBundle != null) && (localBundle.containsKey("com.blizzard.pushlibrary.button_id")))
      {
        onReceiveActionButtonClicked(localBundle.getInt("com.blizzard.pushlibrary.button_id"), localBundle);
        NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
        int i = localBundle.getInt("com.blizzard.pushlibrary.notification.NOTIFICATION_ID");
        if (i > 0) {
          localNotificationManager.cancel(i);
        }
      }
      if (("com.blizzard.pushlibrary.notification.NOTIFICATION_POSTED".equals(paramIntent.getAction())) && (localBundle != null)) {
        onNotificationPosted(localBundle);
      }
    }
  }
  
  public abstract void onNotificationPosted(Bundle paramBundle);
  
  public abstract void onReceiveActionButtonClicked(int paramInt, Bundle paramBundle);
  
  public abstract void onReceivePushToken(String paramString1, String paramString2, String paramString3);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/service/NotificationEventHandlerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */