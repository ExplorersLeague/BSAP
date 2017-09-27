package com.blizzard.pushlibrary;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.pushlibrary.adm.ADMRegistrationHelper;
import com.blizzard.pushlibrary.netease.NetEaseRegistrationHelper;
import com.blizzard.pushlibrary.notification.NotificationCategory;
import com.blizzard.pushlibrary.notification.NotificationPoster;
import com.blizzard.pushlibrary.rest.BlizzardPushApiService;
import com.blizzard.pushlibrary.rest.model.LogoutRequestBody;
import com.blizzard.pushlibrary.rest.model.LogoutResponse;
import com.blizzard.services.push.model.Platform;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.HashMap;
import java.util.Random;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class BlizzardPush
{
  public static final String PREF_KEY_ACCOUNT_ID = "accountId";
  public static final String PREF_KEY_ACCOUNT_REGION = "accountRegion";
  public static final String PREF_KEY_APP_ACCOUNT_ID = "appAccountId";
  public static final String PREF_KEY_GCM_SENDER_ID = "gcm_sender_id";
  public static final String PREF_KEY_LOCALE = "locale";
  public static final String PREF_KEY_NEED_BPNS_SYNC = "need_bpns_sync";
  public static final String PREF_KEY_REGION = "region";
  public static final String PREF_KEY_SNS_APP_NAME = "sns_app_name";
  private static final String TAG = BlizzardPush.class.getSimpleName();
  protected static HashMap<String, NotificationCategory> notificationCategories;
  public static final String prefs_filename = "com.blizzard.pushlibrary.prefs";
  
  private static boolean ADMExists()
  {
    try
    {
      Class.forName("com.amazon.device.messaging.ADM");
      if (BuildConfig.DEBUG) {
        Log.d(TAG, "ADM exists");
      }
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.i(TAG, "ADM does not exist");
    }
    return false;
  }
  
  public static void cancelAllNotifications(Context paramContext)
  {
    Log.d(TAG, "cancelAllNotifications");
    new NotificationPoster(paramContext).cancelAllNotifications();
  }
  
  public static void cancelNotification(Context paramContext, int paramInt)
  {
    Log.d(TAG, "cancelNotification ID: " + paramInt);
    new NotificationPoster(paramContext).cancelNotification(paramInt);
  }
  
  public static void clearNeedBPNSSync(Context paramContext)
  {
    if (paramContext != null) {
      setNeedBPNSSync(paramContext, false);
    }
  }
  
  public static void clearRegistration(Context paramContext)
  {
    if (BuildConfig.DEBUG) {
      Log.d(TAG, "Clearing registration id!");
    }
    if (paramContext == null)
    {
      Log.e(TAG, "Context is null, exiting");
      return;
    }
    RegistrationHelper.storeRegistrationIdandAppVersion(paramContext, "");
  }
  
  public static BnetAccount getBnetAccountFromPreferences(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0);
      return new BnetAccount(paramContext.getString("accountRegion", null), Long.valueOf(paramContext.getLong("accountId", 0L)));
    }
    Log.e(TAG, "Could not retrieve config from preferences: null context, returning default BnetAccount");
    return new BnetAccount();
  }
  
  public static boolean getNeedBPNSSync(Context paramContext)
  {
    boolean bool = false;
    if (paramContext != null) {
      bool = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).getBoolean("need_bpns_sync", true);
    }
    return bool;
  }
  
  @Nullable
  public static HashMap<String, NotificationCategory> getNotificationCategories()
  {
    return notificationCategories;
  }
  
  public static Platform getPlatform(Context paramContext)
  {
    if (NetEaseRegistrationHelper.forceNetEase) {
      return Platform.NETEASE_ANDROID;
    }
    if (playServicesExists(paramContext)) {
      return Platform.GCM;
    }
    if (ADMExists()) {
      return Platform.ADM;
    }
    return Platform.NETEASE_ANDROID;
  }
  
  public static PushConfig getPushConfigFromPreferences(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0);
      return new PushConfig(paramContext.getString("sns_app_name", ""), paramContext.getString("gcm_sender_id", ""), paramContext.getString("region", ""), paramContext.getString("locale", ""), paramContext.getString("appAccountId", ""));
    }
    Log.e(TAG, "Could not retrieve config from preferences: null context, returning empty PushConfig");
    return new PushConfig();
  }
  
  private static int getRandomMessageId()
  {
    return new Random().nextInt(1000000) + 1;
  }
  
  public static void handleBnetAccountChange(Context paramContext, BnetAccount paramBnetAccount)
  {
    if (!paramBnetAccount.equals(getBnetAccountFromPreferences(paramContext)))
    {
      if (BuildConfig.DEBUG) {
        Log.d(TAG, "BnetAccount changed");
      }
      saveBnetAccountToPreferences(paramContext, paramBnetAccount);
    }
  }
  
  public static void handleConfigChange(Context paramContext, PushConfig paramPushConfig)
  {
    handleConfigChange(paramContext, paramPushConfig, true);
  }
  
  public static void handleConfigChange(Context paramContext, PushConfig paramPushConfig, boolean paramBoolean)
  {
    if (!paramPushConfig.equals(getPushConfigFromPreferences(paramContext)))
    {
      if (BuildConfig.DEBUG) {
        Log.d(TAG, "Configuration changed, setting need_bpns_sync pref true");
      }
      savePushConfigToPreferences(paramContext, paramPushConfig);
      if (paramBoolean) {
        latchNeedBPNSSync(paramContext);
      }
    }
  }
  
  public static void initialize(Context paramContext, String paramString)
  {
    initialize(paramContext, null, paramString, null, null);
  }
  
  public static void initialize(Context paramContext, String paramString1, String paramString2)
  {
    initialize(paramContext, paramString1, paramString2, null, null);
  }
  
  public static void initialize(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    initialize(paramContext, paramString1, paramString2, paramString3, paramString4, null, null, null);
  }
  
  public static void initialize(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (BuildConfig.DEBUG) {
      Log.d(TAG, "Initializing push");
    }
    if (paramContext == null)
    {
      Log.e(TAG, "Context is null, exiting");
      return;
    }
    paramContext = paramContext.getApplicationContext();
    handleConfigChange(paramContext, new PushConfig(paramString1, paramString2, paramString3, paramString4, paramString7));
    if ((getBnetAccountFromPreferences(paramContext).isClear()) && (!TextUtils.isEmpty(paramString5)) && (!TextUtils.isEmpty(paramString6))) {
      latchNeedBPNSSync(paramContext);
    }
    switch (getPlatform(paramContext))
    {
    default: 
      Log.e(TAG, "Unhandled platform");
      return;
    case ???: 
      NetEaseRegistrationHelper.register(paramContext, paramString5, paramString6);
      return;
    case ???: 
      RegistrationHelper.doRegistrationInService(paramContext, paramString5, paramString6);
      return;
    }
    ADMRegistrationHelper.doRegistrationInBackground(paramContext, paramString5, paramString6);
  }
  
  public static void latchNeedBPNSSync(Context paramContext)
  {
    if ((paramContext != null) && (!getNeedBPNSSync(paramContext))) {
      setNeedBPNSSync(paramContext, true);
    }
  }
  
  public static void logout(Context paramContext, String paramString1, String paramString2)
  {
    if (BuildConfig.DEBUG) {
      Log.d(TAG, "Logout targeted push");
    }
    if (paramContext == null)
    {
      Log.e(TAG, "Context is null, exiting");
      return;
    }
    Object localObject = new HttpLoggingInterceptor();
    ((HttpLoggingInterceptor)localObject).setLevel(HttpLoggingInterceptor.Level.BASIC);
    localObject = new OkHttpClient.Builder().addInterceptor((Interceptor)localObject).build();
    localObject = (BlizzardPushApiService)new Retrofit.Builder().baseUrl("https://us.battle.net").client((OkHttpClient)localObject).addConverterFactory(GsonConverterFactory.create()).build().create(BlizzardPushApiService.class);
    paramContext = paramContext.getApplicationContext();
    handleBnetAccountChange(paramContext, new BnetAccount());
    PushConfig localPushConfig = getPushConfigFromPreferences(paramContext);
    localPushConfig.clearAccount();
    handleConfigChange(paramContext, localPushConfig, false);
    ((BlizzardPushApiService)localObject).logout(new LogoutRequestBody(localPushConfig.getSNSAppName(), getPlatform(paramContext).name(), RegistrationHelper.getSavedRegistrationId(paramContext), paramString1, paramString2), new Callback()
    {
      public void onFailure(Call<LogoutResponse> paramAnonymousCall, Throwable paramAnonymousThrowable)
      {
        Log.e(BlizzardPush.TAG, "BPNS logout API/network error: " + paramAnonymousThrowable.getMessage());
      }
      
      public void onResponse(Call<LogoutResponse> paramAnonymousCall, Response<LogoutResponse> paramAnonymousResponse)
      {
        if ((paramAnonymousResponse.body() != null) && (((LogoutResponse)paramAnonymousResponse.body()).error == null))
        {
          Log.d(BlizzardPush.TAG, "BPNS logout success");
          return;
        }
        Log.e(BlizzardPush.TAG, "BPNS logout API error");
      }
    });
  }
  
  public static boolean playServicesExists(Context paramContext)
  {
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0)
    {
      Log.i(TAG, "Play Services does not exist");
      return false;
    }
    Log.i(TAG, "Play Services exists");
    return true;
  }
  
  static void saveBnetAccountToPreferences(Context paramContext, BnetAccount paramBnetAccount)
  {
    if ((paramContext != null) && (paramBnetAccount != null))
    {
      paramContext = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).edit();
      paramContext.putString("accountRegion", paramBnetAccount.getAccountRegion());
      if (paramBnetAccount.getAccountId() != null) {}
      for (long l = paramBnetAccount.getAccountId().longValue();; l = 0L)
      {
        paramContext.putLong("accountId", l);
        paramContext.commit();
        return;
      }
    }
    Log.e(TAG, "Could not save config to preferences: null values");
  }
  
  static void savePushConfigToPreferences(Context paramContext, PushConfig paramPushConfig)
  {
    if ((paramContext != null) && (paramPushConfig != null))
    {
      paramContext = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).edit();
      paramContext.putString("sns_app_name", paramPushConfig.getSNSAppName());
      paramContext.putString("gcm_sender_id", paramPushConfig.getSenderId());
      paramContext.putString("region", paramPushConfig.getRegion());
      paramContext.putString("locale", paramPushConfig.getLocale());
      paramContext.putString("appAccountId", paramPushConfig.getAppAccountId());
      paramContext.commit();
      return;
    }
    Log.e(TAG, "Could not save config to preferences: null values");
  }
  
  private static void setNeedBPNSSync(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("com.blizzard.pushlibrary.prefs", 0).edit();
      paramContext.putBoolean("need_bpns_sync", paramBoolean);
      paramContext.commit();
      return;
    }
    Log.e(TAG, "Could not save to preferences: null context");
  }
  
  public static void setNotificationCategories(HashMap<String, NotificationCategory> paramHashMap)
  {
    notificationCategories = paramHashMap;
    Log.d(TAG, "setNotificationCategoriesReceived - " + paramHashMap);
  }
  
  public static void showLocalNotification(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramContext = new NotificationPoster(paramContext);
    paramBundle.putString("messageId", String.valueOf(getRandomMessageId()));
    paramContext.postNotification(paramString, paramBundle);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/BlizzardPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */