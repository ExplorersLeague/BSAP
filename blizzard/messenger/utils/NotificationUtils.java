package com.blizzard.messenger.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.friends.FriendRequest;
import com.blizzard.messenger.data.push.PushRegistration.Builder;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.helper.NotificationHelper;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.receivers.MessageReplyReceiver;
import com.blizzard.pushlibrary.BlizzardPush;
import com.blizzard.pushlibrary.notification.NotificationAction;
import com.blizzard.pushlibrary.notification.NotificationCategory;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Completable;
import rx.Observable;

public class NotificationUtils
{
  private static final String GCM_PRODUCT_ID = "19663045051";
  private static final String NETEASE_PRODUCT_KEY = "ad2f8f895ff64effa6fe72cc6fa61343";
  private static final String TAG = NotificationUtils.class.getSimpleName();
  private static final String TEST_LOCALE = "enUS";
  
  private static HashMap<String, NotificationCategory> buildNotificationCategories(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new NotificationAction(101, 2130837718, paramContext.getString(2131361868), MessageReplyReceiver.getReplyMessageIntent(paramContext)));
    }
    for (paramContext = new NotificationCategory("Whisper", (ArrayList)localObject, 2131296256, 1);; paramContext = new NotificationCategory("Whisper", null, 2131296256, 1))
    {
      localObject = new NotificationCategory("FriendRequest", null, 2131296256, 0);
      localHashMap.put(paramContext.getCategory(), paramContext);
      localHashMap.put(((NotificationCategory)localObject).getCategory(), localObject);
      return localHashMap;
    }
  }
  
  public static Completable deregisterForPush(Context paramContext)
  {
    String str1 = SharedPrefsUtils.getPushNotificationToken(paramContext);
    String str2 = SharedPrefsUtils.getPushNotificationPlatform(paramContext);
    if (!TextUtils.isEmpty(str1))
    {
      paramContext = new PushRegistration.Builder("social", "", str2).setAuthToken(SharedPrefsUtils.getWebAuthToken(paramContext)).setLocale("enUS").setOldToken(str1).build();
      return MessengerProvider.getInstance().deregisterForPushNotifications(paramContext);
    }
    return Completable.complete();
  }
  
  public static void handleActionButtonClick(int paramInt, Bundle paramBundle)
  {
    Log.w(TAG, "handleActionButtonClick()");
  }
  
  public static void handleDeeplink(Context paramContext, String paramString, Bundle paramBundle)
  {
    new NotificationHelper(paramContext).handleDeeplink(paramString, paramBundle);
  }
  
  public static void handleFriendRequestDeeplink(Context paramContext)
  {
    new NotificationHelper(paramContext).handleFriendRequestDeeplink();
  }
  
  public static void handlePostedNotification(Context paramContext, Bundle paramBundle)
  {
    new NotificationHelper(paramContext).handlePostedNotification(paramBundle);
  }
  
  public static void handleWhisperDeeplink(Context paramContext, Bundle paramBundle)
  {
    new NotificationHelper(paramContext).handleWhisperDeeplink(paramBundle);
  }
  
  public static boolean hasDeepLink(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    return paramBundle.containsKey("com.blizzard.messenger.DEEPLINK_TYPE");
  }
  
  public static void onPushTokenReceived(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Log.w(TAG, "onPushTokenReceived()");
    if (MessengerProvider.getInstance().isConnected())
    {
      registerPushTokenWithBPNS(paramContext, paramString1, paramString2, paramString3);
      return;
    }
    MessengerProvider.getInstance().onLoginStateChanged().subscribe(NotificationUtils..Lambda.1.lambdaFactory$(paramContext, paramString1, paramString2, paramString3), NotificationUtils..Lambda.2.lambdaFactory$());
  }
  
  public static void registerForNeteasePush(Context paramContext)
  {
    BlizzardPush.setNotificationCategories(buildNotificationCategories(paramContext));
    com.blizzard.pushlibrary.netease.NetEaseRegistrationHelper.forceNetEase = true;
    BlizzardPush.initialize(paramContext, "ad2f8f895ff64effa6fe72cc6fa61343");
  }
  
  public static void registerForPush(Context paramContext)
  {
    setNotificationCategories(paramContext);
    BlizzardPush.initialize(paramContext, "19663045051");
  }
  
  private static void registerPushTokenWithBPNS(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPrefsUtils.setPushNotificationToken(paramContext, paramString1);
    SharedPrefsUtils.setPushNotificationPlatform(paramContext, paramString3);
    if (!TextUtils.isEmpty(SharedPrefsUtils.getWebAuthToken(paramContext)))
    {
      paramContext = new PushRegistration.Builder("social", paramString1, paramString3).setAuthToken(SharedPrefsUtils.getWebAuthToken(paramContext)).setLocale("enUS").setOldToken(paramString2).build();
      MessengerProvider.getInstance().registerForPushNotifications(paramContext);
    }
  }
  
  public static void setNotificationCategories(Context paramContext)
  {
    BlizzardPush.setNotificationCategories(buildNotificationCategories(paramContext));
  }
  
  public static void showLocalFriendRequestNotification(Context paramContext, FriendRequest paramFriendRequest)
  {
    new NotificationHelper(paramContext).showLocalFriendRequestNotification(paramFriendRequest);
  }
  
  public static void showLocalWhisperNotification(Context paramContext, TextChatMessage paramTextChatMessage, String paramString)
  {
    new NotificationHelper(paramContext).showLocalWhisperNotification(paramTextChatMessage, paramString);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/NotificationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */