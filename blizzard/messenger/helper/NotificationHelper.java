package com.blizzard.messenger.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.text.TextUtils;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.friends.FriendRequest;
import com.blizzard.messenger.data.model.push.PushNotificationModel;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.SplashActivity;
import com.blizzard.messenger.ui.chat.ConversationActivity;
import com.blizzard.messenger.ui.friends.management.FriendRequestListActivity;
import com.blizzard.pushlibrary.BlizzardPush;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

public final class NotificationHelper
{
  public static final String CATEGORY_FRIEND_REQUEST = "FriendRequest";
  public static final String CATEGORY_WHISPER = "Whisper";
  private static final String EXTRA_CATEGORY = "category";
  public static final String EXTRA_DEEPLINK_TYPE = "com.blizzard.messenger.DEEPLINK_TYPE";
  private static final String EXTRA_IS_IN_APP_NOTIFICATION = "is_in_app_notification";
  private static final String EXTRA_SENDER_ACCOUNT_ID = "sender_account_id";
  private static final String EXTRA_SENDER_ID = "com.blizzard.messenger.SENDER_ID";
  private Context context;
  @Inject
  PushNotificationModel pushNotificationModel;
  
  public NotificationHelper(Context paramContext)
  {
    this.context = paramContext;
    ((MessengerApplication)paramContext.getApplicationContext()).getModelComponent().inject(this);
  }
  
  public void dismissFriendRequestNotifications()
  {
    Object localObject = this.pushNotificationModel.getFriendRequestNotifications();
    NotificationManagerCompat localNotificationManagerCompat = NotificationManagerCompat.from(this.context);
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (localInteger != null) {
          localNotificationManagerCompat.cancel(this.context.getPackageName(), localInteger.intValue());
        }
      }
      this.pushNotificationModel.clearFriendRequestNotifications();
    }
  }
  
  public void dismissWhisperNotifications(String paramString)
  {
    Object localObject = this.pushNotificationModel.getWhisperNotificationIds(paramString);
    NotificationManagerCompat localNotificationManagerCompat = NotificationManagerCompat.from(this.context);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (localInteger != null) {
          localNotificationManagerCompat.cancel(this.context.getPackageName(), localInteger.intValue());
        }
      }
      this.pushNotificationModel.clearWhisperNotifications(paramString);
    }
  }
  
  public void handleDeeplink(String paramString, Bundle paramBundle)
  {
    boolean bool1 = MessengerProvider.getInstance().isConnected();
    boolean bool2;
    if ((paramString.equals("Whisper")) || (paramString.equals("FriendRequest")))
    {
      bool2 = paramBundle.getBoolean("is_in_app_notification");
      if (!paramString.equals("Whisper")) {
        break label148;
      }
      str = paramBundle.getString("sender_account_id");
      Telemetry.notificationWhisperClicked(str, bool2);
      if (!bool1) {
        break label83;
      }
      paramString = new Bundle();
      paramString.putString("com.blizzard.messenger.SENDER_ID", str);
      handleWhisperDeeplink(paramString);
    }
    label83:
    label148:
    while (!paramString.equals("FriendRequest"))
    {
      String str;
      return;
      Intent localIntent = SplashActivity.newIntent(this.context, false, "com.blizzard.messenger.ACTION_NOTIFICATION_WHISPER");
      localIntent.addFlags(268435456);
      paramBundle = localIntent.getExtras();
      paramString = paramBundle;
      if (paramBundle == null) {
        paramString = new Bundle();
      }
      paramString.putString("com.blizzard.messenger.SENDER_ID", str);
      localIntent.putExtras(paramString);
      this.context.startActivity(localIntent);
      return;
    }
    Telemetry.notificationFriendRequestClicked(bool2);
    if (bool1)
    {
      handleFriendRequestDeeplink();
      return;
    }
    paramString = SplashActivity.newIntent(this.context, false, "com.blizzard.messenger.ACTION_NOTIFICATION_FRIEND_REQUEST");
    paramString.addFlags(268435456);
    this.context.startActivity(paramString);
  }
  
  public void handleFriendRequestDeeplink()
  {
    Intent localIntent = FriendRequestListActivity.newIntent(this.context);
    localIntent.addFlags(268435456);
    TaskStackBuilder.create(this.context).addNextIntentWithParentStack(localIntent).startActivities();
  }
  
  public void handlePostedNotification(Bundle paramBundle)
  {
    int i = paramBundle.getInt("com.blizzard.pushlibrary.notification.NOTIFICATION_ID");
    String str = paramBundle.getString("sender_account_id");
    paramBundle = paramBundle.getString("category");
    if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equalsIgnoreCase("Whisper")) && (!TextUtils.isEmpty(str))) {
      this.pushNotificationModel.storeWhisperPushNotification(str, i);
    }
    while ((TextUtils.isEmpty(paramBundle)) || (!paramBundle.equalsIgnoreCase("FriendRequest"))) {
      return;
    }
    this.pushNotificationModel.storeFriendRequestPushNotification(i);
  }
  
  public void handleWhisperDeeplink(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("com.blizzard.messenger.SENDER_ID");
    if (TextUtils.isEmpty(paramBundle)) {
      throw new IllegalArgumentException("Missing sender ID");
    }
    paramBundle = ConversationActivity.newIntent(this.context, paramBundle);
    paramBundle.addFlags(268435456);
    TaskStackBuilder.create(this.context).addNextIntentWithParentStack(paramBundle).startActivities();
  }
  
  public void showLocalFriendRequestNotification(FriendRequest paramFriendRequest)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("category", "FriendRequest");
    localBundle.putString("deeplink", "FriendRequest");
    boolean bool;
    if (!MessengerProvider.getInstance().isAppSuspended())
    {
      bool = true;
      localBundle.putBoolean("is_in_app_notification", bool);
      if (TextUtils.isEmpty(paramFriendRequest.getFullName())) {
        break label94;
      }
    }
    label94:
    for (paramFriendRequest = paramFriendRequest.getFullName();; paramFriendRequest = paramFriendRequest.getBattletag())
    {
      paramFriendRequest = String.format(this.context.getString(2131361936), new Object[] { paramFriendRequest });
      BlizzardPush.showLocalNotification(this.context, paramFriendRequest, localBundle);
      return;
      bool = false;
      break;
    }
  }
  
  public void showLocalWhisperNotification(TextChatMessage paramTextChatMessage, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("category", "Whisper");
    localBundle.putString("title", paramString);
    if (!MessengerProvider.getInstance().isAppSuspended()) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_in_app_notification", bool);
      localBundle.putString("deeplink", "Whisper");
      localBundle.putString("sender_account_id", paramTextChatMessage.getConversationId());
      BlizzardPush.showLocalNotification(this.context, paramTextChatMessage.getBody(), localBundle);
      return;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/helper/NotificationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */