package com.blizzard.pushlibrary.unity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.blizzard.pushlibrary.service.NotificationEventHandlerBase;
import com.unity3d.player.UnityPlayer;

public class NotificationEventHandlerUnity
  extends NotificationEventHandlerBase
{
  public void onDeeplinkClicked(String paramString, Bundle paramBundle)
  {
    Log.d("PushSample", "Got deeplink: " + paramString);
    paramBundle = getPackageName();
    startActivity(getPackageManager().getLaunchIntentForPackage(paramBundle));
    UnityPlayer.UnitySendMessage("BLPushManager", "DidReceiveDeeplinkURL", paramString);
  }
  
  public void onNotificationPosted(Bundle paramBundle) {}
  
  public void onReceiveActionButtonClicked(int paramInt, Bundle paramBundle) {}
  
  public void onReceivePushToken(String paramString1, String paramString2, String paramString3)
  {
    Log.d("PushSample", "Got token update: " + paramString1 + "\nPrev token: " + paramString2 + "\nfrom platform: " + paramString3);
    UnityPlayer.UnitySendMessage("BLPushManager", "DidReceiveRegistrationToken", paramString1);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/unity/NotificationEventHandlerUnity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */