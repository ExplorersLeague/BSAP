package com.blizzard.messenger.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;

public class WebAuthTokenReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.blizzard.loginsdk.OAUTH_TOKEN");
    if (str != null) {
      SharedPrefsUtils.setWebAuthToken(paramContext, str);
    }
    paramIntent = paramIntent.getStringExtra("com.blizzard.loginsdk.WEB_AUTH_URLS");
    if (paramIntent != null) {
      SharedPrefsUtils.setWebAuthUrls(paramContext, paramIntent);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/receivers/WebAuthTokenReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */