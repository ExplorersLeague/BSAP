package com.blizzard.messenger.constants;

import android.content.Context;
import android.content.res.Resources;

public class AppConstants
{
  public static final String APP_NAME = "bsap";
  public static final String BGS_APP_NAME = "BSAp";
  public static final String BGS_APP_PLATFORM = "And";
  public static final int CHAT_HISTORY_FETCH_LIMIT = 25;
  public static final long CHAT_TYPING_INDICATOR_TIMEOUT_MS = 7000L;
  public static final boolean CHINA_BUILD = false;
  public static final long CLICK_THROTTLE_MS = 300L;
  public static final long CONNECT_RETRY_DELAY_MS = 10000L;
  public static final String INTENT_ACTION_ADD_FRIEND = "com.blizzard.messenger.ADD_FRIEND";
  public static final String INTENT_ACTION_NOTIFICATION_FRIEND_REQUEST = "com.blizzard.messenger.ACTION_NOTIFICATION_FRIEND_REQUEST";
  public static final String INTENT_ACTION_NOTIFICATION_WHISPER = "com.blizzard.messenger.ACTION_NOTIFICATION_WHISPER";
  public static final String INTENT_ACTION_SCAN_QR_CODE = "com.blizzard.messenger.SCAN_QR_CODE";
  public static final String INTENT_ACTION_SHOW_QR_CODE = "com.blizzard.messenger.SHOW_QR_CODE";
  public static final String INTENT_FILTER_LOGIN_RESTART = "com.blizzard.messenger.LOGIN_RESTART";
  public static final long LOGIN_BUSY_DELAY_MS = 20000L;
  public static final long LOGIN_RETRY_DELAY_MS = 5000L;
  public static final long SCROLL_BUTTON_DELAY_MS = 250L;
  public static final long SENDING_MESSAGE_DELAY = 2000L;
  public static final int SUGGESTED_FRIENDS_LIMIT = 20;
  public static final String TELEMETRY_PACKAGE_NAME = "Blizzard.Telemetry.Messenger";
  public static final long UNSENT_MESSAGE_DELAY = 10000L;
  public static final long UPDATE_HISTORY_DELAY_MS = 2000L;
  public static final String XMPP_CERT_PATH = "cacerts/xmpp_server_chain.pem";
  
  public static String getFormattedVersion(Context paramContext)
  {
    int i = paramContext.getResources().getInteger(2131492877);
    int j = paramContext.getResources().getInteger(2131492878);
    return Integer.valueOf(i).toString() + "." + Integer.valueOf(j).toString();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/constants/AppConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */