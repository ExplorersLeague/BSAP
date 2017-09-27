package com.blizzard.pushlibrary.adm;

import android.content.Context;
import android.util.Log;
import com.amazon.device.messaging.ADM;
import com.blizzard.pushlibrary.BlizzardPush;
import com.blizzard.pushlibrary.BlizzardRegistration;
import com.blizzard.pushlibrary.BuildConfig;
import com.blizzard.pushlibrary.rest.model.Authentication;

public class ADMRegistrationHelper
{
  private static final String TAG = ADMRegistrationHelper.class.getSimpleName();
  protected static Authentication authentication;
  
  public static void clearAuthentication()
  {
    authentication = null;
  }
  
  public static void doRegistrationInBackground(Context paramContext, String paramString1, String paramString2)
  {
    ADM localADM = new ADM(paramContext);
    if (localADM.getRegistrationId() == null)
    {
      if (BuildConfig.DEBUG) {
        Log.d(TAG, "Registering with ADM (no previous registration found)");
      }
      setAuthentication(paramString1, paramString2);
      localADM.startRegister();
    }
    while (!BlizzardPush.getNeedBPNSSync(paramContext)) {
      return;
    }
    if (BuildConfig.DEBUG) {
      Log.d(TAG, "Updating ADM registration config with BPNS");
    }
    new BlizzardRegistration(paramContext, "ADM", localADM.getRegistrationId(), paramString1, paramString2).sendRegistrationToBlizzard();
  }
  
  public static Authentication getAuthentication()
  {
    return authentication;
  }
  
  public static void setAuthentication(String paramString1, String paramString2)
  {
    authentication = new Authentication(paramString1, paramString2);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/adm/ADMRegistrationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */