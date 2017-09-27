package com.blizzard.pushlibrary.receiver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.blizzard.pushlibrary.BuildConfig;
import com.blizzard.pushlibrary.service.GcmIntentService;

public class GcmBroadcastReceiver
  extends WakefulBroadcastReceiver
{
  private static final String TAG = GcmBroadcastReceiver.class.getSimpleName();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null))
    {
      if (BuildConfig.DEBUG) {
        Log.d(TAG, "Received broadcast");
      }
      startWakefulService(paramContext, paramIntent.setComponent(new ComponentName(paramContext.getPackageName(), GcmIntentService.class.getName())));
      setResultCode(-1);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/receiver/GcmBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */