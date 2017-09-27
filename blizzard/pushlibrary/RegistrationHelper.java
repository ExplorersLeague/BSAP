package com.blizzard.pushlibrary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.pushlibrary.service.GcmRegisterIntentService;
import com.blizzard.services.push.model.Platform;

public class RegistrationHelper
{
  static final String APP_VERSION_PREF = "app_version";
  public static final String AUTH_REGION = "auth_region";
  public static final String AUTH_TOKEN = "auth_token";
  private static final String PREV_REGISTRATION_ID_PREF = "previous_registration_id";
  private static final String REGISTRATION_ID_PREF = "registration_id";
  private static final String TAG = RegistrationHelper.class.getSimpleName();
  
  public static void doRegistrationInService(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent(paramContext, GcmRegisterIntentService.class);
      localIntent.putExtra("auth_region", paramString1);
      localIntent.putExtra("auth_token", paramString2);
      paramContext.startService(localIntent);
    }
  }
  
  private static int getCurrentAppVersion(Context paramContext)
  {
    int j = 0;
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i = j;
    if (localPackageManager != null) {}
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      i = j;
      if (paramContext != null) {
        i = paramContext.versionCode;
      }
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf(TAG, "Could not get app version.");
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  private static int getSavedAppVersion(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).getInt("app_version", Integer.MIN_VALUE);
    }
    Log.e(TAG, "Could not get saved app version, context is null, returning min value");
    return Integer.MIN_VALUE;
  }
  
  public static String getSavedPreviousRegistrationId(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).getString("previous_registration_id", "");
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext;
      }
    }
    return "";
  }
  
  public static String getSavedRegistrationId(Context paramContext)
  {
    if (paramContext != null)
    {
      String str = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).getString("registration_id", "");
      if ((str == null) || (str.isEmpty()))
      {
        if (BuildConfig.DEBUG) {
          Log.d(TAG, "no saved registration id");
        }
        paramContext = "";
      }
      do
      {
        return paramContext;
        paramContext = str;
      } while (!BuildConfig.DEBUG);
      Log.d(TAG, "Found previously saved registration ID: " + str);
      return str;
    }
    Log.e(TAG, "Could not get registration id: context is null, returning empty");
    return "";
  }
  
  public static void notifyPushTokenUpdated(Context paramContext, String paramString, Platform paramPlatform)
  {
    Log.i(TAG, "notifyPushTokenUpdated()");
    Log.i(TAG, "Push Token: " + paramString + " Platform: " + paramPlatform);
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.blizzard.pushlibrary.registration.RECEIVE_TOKEN");
      localIntent.setPackage(paramContext.getPackageName());
      localIntent.putExtra("com.blizzard.pushlibrary.pushToken", paramString);
      localIntent.putExtra("com.blizzard.pushlibrary.platform", paramPlatform.name());
      localIntent.putExtra("com.blizzard.pushlibrary.prevToken", getSavedPreviousRegistrationId(paramContext));
      paramContext.startService(localIntent);
    }
  }
  
  protected static void saveCurrentRegistrationAsPrevious(Context paramContext, SharedPreferences.Editor paramEditor)
  {
    paramContext = getSavedRegistrationId(paramContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      paramEditor.putString("previous_registration_id", paramContext);
      paramEditor.commit();
    }
  }
  
  public static boolean shouldRegister(Context paramContext)
  {
    String str = getSavedRegistrationId(paramContext);
    if ((str == null) || (str.isEmpty())) {
      return true;
    }
    if (getSavedAppVersion(paramContext) != getCurrentAppVersion(paramContext))
    {
      Log.i(TAG, "App version changed");
      return true;
    }
    return false;
  }
  
  public static void storeRegistrationIdandAppVersion(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).edit();
      saveCurrentRegistrationAsPrevious(paramContext, localEditor);
      localEditor.putString("registration_id", paramString);
      int i = getCurrentAppVersion(paramContext);
      localEditor.putInt("app_version", i);
      localEditor.commit();
      Log.i(TAG, "Stored new registration ID on App version : " + i + " , id=" + paramString);
      return;
    }
    Log.e(TAG, "Could not store registration, context is null");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/RegistrationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */