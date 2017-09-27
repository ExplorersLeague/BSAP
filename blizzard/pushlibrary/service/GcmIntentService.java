package com.blizzard.pushlibrary.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.blizzard.pushlibrary.notification.NotificationPoster;
import com.blizzard.pushlibrary.receiver.GcmBroadcastReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;

public class GcmIntentService
  extends IntentService
{
  private static final String NOTIFICATION_ICON_METADATA_KEY = "com.blizzard.pushlibrary.notification_icon";
  private static final int NOTIFICATION_ID = 1;
  private static final String TAG = GcmIntentService.class.getSimpleName();
  private NotificationManager mNotificationManager;
  
  public GcmIntentService()
  {
    super("GcmIntentService");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str = GoogleCloudMessaging.getInstance(this).getMessageType(paramIntent);
    if ((localBundle != null) && (!localBundle.isEmpty()))
    {
      if (!"send_error".equals(str)) {
        break label69;
      }
      Log.e(TAG, "Send error: " + localBundle.toString());
    }
    for (;;)
    {
      GcmBroadcastReceiver.completeWakefulIntent(paramIntent);
      return;
      label69:
      if ("deleted_messages".equals(str))
      {
        Log.e(TAG, "Deleted messages on server: " + localBundle.toString());
      }
      else if ("gcm".equals(str))
      {
        str = localBundle.getString("default");
        if ((str != null) && (!str.isEmpty())) {
          new NotificationPoster(this).postNotification(str, localBundle);
        }
        Log.i(TAG, "Received message: " + localBundle.toString());
      }
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/service/GcmIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */