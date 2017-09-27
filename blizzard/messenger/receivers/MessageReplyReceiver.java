package com.blizzard.messenger.receivers;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.pushlibrary.notification.NotificationIntent;
import com.blizzard.pushlibrary.notification.NotificationPoster;
import java.util.Iterator;
import java.util.Set;
import rx.Completable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MessageReplyReceiver
  extends BroadcastReceiver
{
  private static final String INTENT_ACTION_REPLY = "com.blizzard.messenger.INTENT_ACTION_REPLY";
  private static final String KEY_REPLY = "com.blizzard.messenger.KEY_REPLY";
  private static final String TAG = MessageReplyReceiver.class.getSimpleName();
  
  private void cancelNotification(Context paramContext, int paramInt)
  {
    Log.e(TAG, "cancelNotification()");
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(paramContext.getPackageName(), paramInt);
  }
  
  public static NotificationIntent getReplyMessageIntent(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, MessageReplyReceiver.class);
    localIntent.setAction("com.blizzard.messenger.INTENT_ACTION_REPLY");
    return new NotificationIntent(localIntent, "com.blizzard.messenger.KEY_REPLY", paramContext.getString(2131361868));
  }
  
  private void sendWhisper(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    MessengerProvider.getInstance().sendWhisper(paramString1, paramString2).subscribeOn(Schedulers.io()).subscribe(MessageReplyReceiver..Lambda.3.lambdaFactory$(this, paramString1, paramContext, paramInt), MessageReplyReceiver..Lambda.4.lambdaFactory$());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d(TAG, "onReceive");
    CharSequence localCharSequence;
    Object localObject;
    int i;
    if ("com.blizzard.messenger.INTENT_ACTION_REPLY".equals(paramIntent.getAction()))
    {
      localCharSequence = NotificationPoster.getRemoteInputText("com.blizzard.messenger.KEY_REPLY", paramIntent);
      if (!TextUtils.isEmpty(localCharSequence.toString()))
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null)
        {
          localObject = paramIntent.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            Log.d("Bundle Debug", str + " = \"" + paramIntent.get(str) + "\"");
          }
          localObject = paramIntent.getString("sender_account_id");
          i = Integer.valueOf(paramIntent.getString("messageId")).intValue();
          Log.e(TAG, "notificationId: " + i);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (MessengerProvider.getInstance().isConnected()) {
              break label232;
            }
            MessengerProvider.getInstance().login(paramContext.getApplicationContext(), false).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(MessageReplyReceiver..Lambda.1.lambdaFactory$(this, paramContext, (String)localObject, localCharSequence, i), MessageReplyReceiver..Lambda.2.lambdaFactory$());
          }
        }
      }
    }
    return;
    label232:
    sendWhisper(paramContext, (String)localObject, localCharSequence.toString(), i);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/receivers/MessageReplyReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */