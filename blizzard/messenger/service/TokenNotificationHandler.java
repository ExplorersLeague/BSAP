package com.blizzard.messenger.service;

import android.os.Bundle;
import com.blizzard.messenger.utils.NotificationUtils;
import com.blizzard.pushlibrary.service.NotificationEventHandlerBase;

public class TokenNotificationHandler
  extends NotificationEventHandlerBase
{
  public void onDeeplinkClicked(String paramString, Bundle paramBundle)
  {
    NotificationUtils.handleDeeplink(getApplicationContext(), paramString, paramBundle);
  }
  
  public void onNotificationPosted(Bundle paramBundle)
  {
    NotificationUtils.handlePostedNotification(getApplicationContext(), paramBundle);
  }
  
  public void onReceiveActionButtonClicked(int paramInt, Bundle paramBundle)
  {
    NotificationUtils.handleActionButtonClick(paramInt, paramBundle);
  }
  
  public void onReceivePushToken(String paramString1, String paramString2, String paramString3)
  {
    NotificationUtils.onPushTokenReceived(getApplicationContext(), paramString1, paramString2, paramString3);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/service/TokenNotificationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */