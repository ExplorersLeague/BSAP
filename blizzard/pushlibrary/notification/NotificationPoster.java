package com.blizzard.pushlibrary.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Action.Builder;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInput.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.pushlibrary.BlizzardPush;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class NotificationPoster
{
  public static final String ACTION_BUTTON = "com.blizzard.pushlibrary.notification.BUTTON";
  public static final String ACTION_DEEPLINK = "com.blizzard.pushlibrary.notification.DEEPLINK";
  public static final String ACTION_NOTIFICATION_POSTED = "com.blizzard.pushlibrary.notification.NOTIFICATION_POSTED";
  public static final String EXTRA_NOTIFICATION_ID = "com.blizzard.pushlibrary.notification.NOTIFICATION_ID";
  public static final String KEY_BUTTON_ID = "com.blizzard.pushlibrary.button_id";
  public static final String MESSAGE_KEY_CATEGORY = "category";
  public static final String MESSAGE_KEY_DEEPLINK = "deeplink";
  public static final String MESSAGE_KEY_ID = "messageId";
  public static final String MESSAGE_KEY_TITLE = "title";
  protected static final String NOTIFICATION_COLOR_METADATA_KEY = "com.blizzard.pushlibrary.notification_color";
  private static final String NOTIFICATION_ICON_METADATA_KEY = "com.blizzard.pushlibrary.notification_icon";
  private static final String TAG = NotificationPoster.class.getSimpleName();
  protected static final HashSet<String> recentMessageIds = new HashSet();
  private Context mContext;
  
  public NotificationPoster(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private String getApplicationName()
  {
    String str3 = "";
    PackageManager localPackageManager = this.mContext.getPackageManager();
    String str1 = str3;
    if (localPackageManager != null) {}
    try
    {
      ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(this.mContext.getPackageName(), 0);
      str1 = str3;
      if (localApplicationInfo != null) {
        str1 = (String)localPackageManager.getApplicationLabel(localApplicationInfo);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        String str2 = str3;
      }
    }
    if (str1 != null) {
      return str1;
    }
    return "";
  }
  
  private PendingIntent getDeeplinkServicePendingIntent(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.blizzard.pushlibrary.notification.DEEPLINK");
    localIntent.setPackage(this.mContext.getPackageName());
    localIntent.putExtras(paramBundle);
    return PendingIntent.getService(this.mContext, 0, localIntent, 134217728);
  }
  
  private PendingIntent getDefaultActivityPendingIntent(Bundle paramBundle)
  {
    Object localObject = this.mContext.getPackageName();
    localObject = this.mContext.getPackageManager().getLaunchIntentForPackage((String)localObject);
    ((Intent)localObject).putExtras(paramBundle);
    return PendingIntent.getActivity(this.mContext, 0, (Intent)localObject, 0);
  }
  
  private int getNotificationIcon()
  {
    int i = 0;
    int m = 0;
    int k = 0;
    Object localObject = this.mContext.getPackageManager();
    int j = i;
    if (localObject != null) {
      j = m;
    }
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo(this.mContext.getPackageName(), 128);
      j = i;
      if (localObject != null)
      {
        i = k;
        j = m;
        if (Build.VERSION.SDK_INT >= 21)
        {
          j = m;
          Bundle localBundle = ((ApplicationInfo)localObject).metaData;
          i = k;
          if (localBundle != null)
          {
            j = m;
            i = localBundle.getInt("com.blizzard.pushlibrary.notification_icon");
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          i = ((ApplicationInfo)localObject).icon;
          j = i;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.e(TAG, "Could not get notification icon");
        localNameNotFoundException.printStackTrace();
      }
    }
    if (j == 0) {
      Log.e(TAG, "No notification icon found, cannot show notification!");
    }
    return j;
  }
  
  public static Bundle getRemoteInput(Intent paramIntent)
  {
    return RemoteInput.getResultsFromIntent(paramIntent);
  }
  
  public static CharSequence getRemoteInputText(String paramString, Intent paramIntent)
  {
    paramIntent = RemoteInput.getResultsFromIntent(paramIntent);
    if (paramIntent != null) {
      return paramIntent.getCharSequence(paramString);
    }
    return null;
  }
  
  private boolean messageContainsCategory(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("category"));
  }
  
  private boolean messageContainsDeeplink(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("deeplink"));
  }
  
  private void postNotificationIntent(Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.blizzard.pushlibrary.notification.NOTIFICATION_POSTED");
    paramBundle.putInt("com.blizzard.pushlibrary.notification.NOTIFICATION_ID", paramInt);
    localIntent.setPackage(this.mContext.getPackageName());
    localIntent.putExtras(paramBundle);
    this.mContext.startService(localIntent);
  }
  
  protected void addCategoryCustomizations(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    Object localObject1 = BlizzardPush.getNotificationCategories();
    if (localObject1 != null)
    {
      Log.d(TAG, "found notification categories, attempting to match current notification");
      if (messageContainsCategory(paramBundle))
      {
        localObject1 = (NotificationCategory)((HashMap)localObject1).get(paramBundle.getString("category"));
        if (localObject1 != null)
        {
          if (((NotificationCategory)localObject1).getActions() != null)
          {
            Iterator localIterator = ((NotificationCategory)localObject1).getActions().iterator();
            while (localIterator.hasNext())
            {
              NotificationAction localNotificationAction = (NotificationAction)localIterator.next();
              Object localObject2;
              if (localNotificationAction.getNotificationIntent() == null)
              {
                localObject2 = getActionButtonServicePendingIntent(localNotificationAction, paramBundle);
                paramBuilder.addAction(localNotificationAction.getIcon(), localNotificationAction.getTitle(), (PendingIntent)localObject2);
              }
              else
              {
                Object localObject3 = localNotificationAction.getNotificationIntent();
                localObject2 = new RemoteInput.Builder(((NotificationIntent)localObject3).getResultKey()).setLabel(((NotificationIntent)localObject3).getLabel()).build();
                localObject3 = ((NotificationIntent)localObject3).getIntent();
                ((Intent)localObject3).putExtras(paramBundle);
                localObject3 = PendingIntent.getBroadcast(this.mContext.getApplicationContext(), 0, (Intent)localObject3, 134217728);
                paramBuilder.addAction(new NotificationCompat.Action.Builder(localNotificationAction.getIcon(), localNotificationAction.getTitle(), (PendingIntent)localObject3).addRemoteInput((RemoteInput)localObject2).setAllowGeneratedReplies(true).build());
              }
            }
          }
          if (((NotificationCategory)localObject1).getSoundFileResId() != 0)
          {
            paramBundle = this.mContext.getResources().getResourceEntryName(((NotificationCategory)localObject1).getSoundFileResId());
            paramBuilder.setSound(Uri.parse("android.resource://" + this.mContext.getPackageName() + "/raw/" + paramBundle));
            paramBuilder.setDefaults(6);
          }
          paramBuilder.setPriority(((NotificationCategory)localObject1).getPriority());
        }
      }
    }
  }
  
  public void cancelAllNotifications()
  {
    ((NotificationManager)this.mContext.getSystemService("notification")).cancelAll();
  }
  
  public void cancelNotification(int paramInt)
  {
    ((NotificationManager)this.mContext.getSystemService("notification")).cancel(paramInt);
  }
  
  protected PendingIntent getActionButtonServicePendingIntent(NotificationAction paramNotificationAction, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.blizzard.pushlibrary.notification.BUTTON");
    localIntent.setPackage(this.mContext.getPackageName());
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("com.blizzard.pushlibrary.button_id", paramNotificationAction.getOnClickId());
    return PendingIntent.getService(this.mContext, paramNotificationAction.getOnClickId(), localIntent, 134217728);
  }
  
  @Nullable
  protected Bundle getManifestMetadata()
  {
    Object localObject = this.mContext.getPackageManager();
    if (localObject != null) {
      try
      {
        localObject = ((PackageManager)localObject).getApplicationInfo(this.mContext.getPackageName(), 128);
        if (localObject != null)
        {
          localObject = ((ApplicationInfo)localObject).metaData;
          return (Bundle)localObject;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    return null;
  }
  
  protected int getNotificationColor()
  {
    int j = -11033857;
    Bundle localBundle = getManifestMetadata();
    int i = j;
    if (localBundle != null)
    {
      int k = localBundle.getInt("com.blizzard.pushlibrary.notification_color");
      i = j;
      if (k != 0) {
        i = this.mContext.getResources().getColor(k);
      }
    }
    return i;
  }
  
  protected boolean isDuplicateOrNoneMessageId(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("messageId");
      if (TextUtils.isEmpty(paramBundle))
      {
        Log.w(TAG, "No message ID found, suppressing notification");
        return true;
      }
      if (recentMessageIds.contains(paramBundle))
      {
        Log.w(TAG, "Duplicate message ID found, suppressing notification.");
        return true;
      }
      recentMessageIds.add(paramBundle);
      return false;
    }
    Log.w(TAG, "No bundle found for notification, suppressing notification");
    return true;
  }
  
  public void postNotification(String paramString, Bundle paramBundle)
  {
    if (isDuplicateOrNoneMessageId(paramBundle)) {
      return;
    }
    int i = Integer.valueOf(paramBundle.getString("messageId")).intValue();
    if (messageContainsDeeplink(paramBundle)) {}
    for (PendingIntent localPendingIntent = getDeeplinkServicePendingIntent(paramBundle);; localPendingIntent = getDefaultActivityPendingIntent(paramBundle))
    {
      Object localObject2 = paramBundle.getString("title");
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = getApplicationName();
      }
      localObject2 = (NotificationManager)this.mContext.getSystemService("notification");
      paramString = new NotificationCompat.Builder(this.mContext).setSmallIcon(getNotificationIcon()).setColor(getNotificationColor()).setStyle(new NotificationCompat.BigTextStyle().bigText(paramString)).setContentTitle((CharSequence)localObject1).setContentText(paramString).setDefaults(-1).setAutoCancel(true);
      addCategoryCustomizations(paramString, paramBundle);
      paramString.setContentIntent(localPendingIntent);
      ((NotificationManager)localObject2).notify(this.mContext.getPackageName(), i, paramString.build());
      postNotificationIntent(paramBundle, i);
      return;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/notification/NotificationPoster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */