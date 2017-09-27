package com.blizzard.pushlibrary.receiver;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.blizzard.pushlibrary.BlizzardPush;
import com.blizzard.pushlibrary.BuildConfig;
import com.blizzard.pushlibrary.service.GcmRegisterIntentService;

public class PackageReplacedReceiver
  extends WakefulBroadcastReceiver
{
  private static final String TAG = PackageReplacedReceiver.class.getSimpleName();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null) && ("android.intent.action.MY_PACKAGE_REPLACED".equals(paramIntent.getAction())))
    {
      if (BuildConfig.DEBUG) {
        Log.d(TAG, "Received package updated broadcast");
      }
      if (BlizzardPush.playServicesExists(paramContext)) {
        startWakefulService(paramContext, new Intent(paramContext, GcmRegisterIntentService.class));
      }
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/receiver/PackageReplacedReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */