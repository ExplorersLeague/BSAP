package com.blizzard.pushlibrary.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.pushlibrary.BlizzardPush;
import com.blizzard.pushlibrary.BlizzardRegistration;
import com.blizzard.pushlibrary.BuildConfig;
import com.blizzard.pushlibrary.PushConfig;
import com.blizzard.pushlibrary.RegistrationHelper;
import com.blizzard.pushlibrary.receiver.PackageReplacedReceiver;
import com.blizzard.services.push.model.Platform;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

public class GcmRegisterIntentService
  extends IntentService
{
  private static final String TAG = GcmRegisterIntentService.class.getSimpleName();
  
  public GcmRegisterIntentService()
  {
    super("GcmRegisterIntentService");
  }
  
  private String registerWithGCM(PushConfig paramPushConfig, String paramString1, String paramString2)
  {
    String str2 = "";
    Object localObject = str2;
    try
    {
      GoogleCloudMessaging localGoogleCloudMessaging = GoogleCloudMessaging.getInstance(this);
      String str1 = str2;
      if (localGoogleCloudMessaging != null)
      {
        localObject = str2;
        str1 = localGoogleCloudMessaging.register(new String[] { paramPushConfig.getSenderId() });
      }
      if (str1 != null)
      {
        localObject = str1;
        if (!str1.isEmpty())
        {
          localObject = str1;
          RegistrationHelper.storeRegistrationIdandAppVersion(this, str1);
          localObject = str1;
          sendRegistrationToBlizzard(str1, paramString1, paramString2);
        }
      }
      return str1;
    }
    catch (IOException paramPushConfig)
    {
      Log.e(TAG, "Error registering with GCM: " + paramPushConfig.getMessage());
    }
    return (String)localObject;
  }
  
  private void sendRegistrationToBlizzard(String paramString1, String paramString2, String paramString3)
  {
    new BlizzardRegistration(this, "GCM", paramString1, paramString2, paramString3).sendRegistrationToBlizzard();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    PushConfig localPushConfig = BlizzardPush.getPushConfigFromPreferences(this);
    String str2 = paramIntent.getExtras().getString("auth_region");
    String str3 = paramIntent.getExtras().getString("auth_token");
    String str1;
    if (RegistrationHelper.shouldRegister(this))
    {
      if (BuildConfig.DEBUG) {
        Log.d(TAG, "Registering with GCM");
      }
      str1 = registerWithGCM(localPushConfig, str2, str3);
      if ((localPushConfig != null) && (!TextUtils.isEmpty(localPushConfig.getSNSAppName()))) {
        break label104;
      }
      RegistrationHelper.notifyPushTokenUpdated(this, str1, Platform.GCM);
    }
    for (;;)
    {
      PackageReplacedReceiver.completeWakefulIntent(paramIntent);
      return;
      str1 = RegistrationHelper.getSavedRegistrationId(this);
      sendRegistrationToBlizzard(str1, str2, str3);
      break;
      label104:
      RegistrationHelper.notifyPushTokenUpdated(this, str1, Platform.GCM);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/service/GcmRegisterIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */