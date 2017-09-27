package com.blizzard.pushlibrary.adm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.amazon.device.messaging.ADMMessageReceiver;
import com.blizzard.pushlibrary.BlizzardRegistration;
import com.blizzard.pushlibrary.notification.NotificationPoster;

public class ADMMessageHandler
  extends ADMMessageHandlerBase
{
  private static final String TAG = ADMMessageHandler.class.getSimpleName();
  
  public ADMMessageHandler()
  {
    super(ADMMessageHandler.class.getName());
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  protected void onMessage(Intent paramIntent)
  {
    Log.i(TAG, "ADM onMessage: received a message");
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (!paramIntent.isEmpty()))
    {
      String str = paramIntent.getString("default");
      if ((str != null) && (!str.isEmpty())) {
        new NotificationPoster(this).postNotification(str, paramIntent);
      }
    }
  }
  
  protected void onRegistered(String paramString)
  {
    Log.i(TAG, "onRegistered: " + paramString);
    new BlizzardRegistration(this, "ADM", paramString, ADMRegistrationHelper.getAuthentication()).sendRegistrationToBlizzard();
    ADMRegistrationHelper.clearAuthentication();
  }
  
  protected void onRegistrationError(String paramString)
  {
    Log.e(TAG, "onRegistrationError: " + paramString);
    ADMRegistrationHelper.clearAuthentication();
  }
  
  protected void onUnregistered(String paramString)
  {
    Log.i(TAG, "onUnRegistered: " + paramString);
  }
  
  public static class MessageAlertReceiver
    extends ADMMessageReceiver
  {
    public MessageAlertReceiver()
    {
      super();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/adm/ADMMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */