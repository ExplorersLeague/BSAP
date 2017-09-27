package com.blizzard.pushlibrary.netease;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.pushlibrary.BlizzardRegistration;
import com.blizzard.pushlibrary.RegistrationHelper;
import com.blizzard.pushlibrary.exception.RegistrationException;
import com.blizzard.pushlibrary.util.LogUtils;
import com.blizzard.pushlibrary.util.PreferenceUtils;
import com.blizzard.services.push.model.Platform;
import com.netease.pushservice.core.ServiceManager;
import com.netease.pushservice.event.Error;
import com.netease.pushservice.event.Event;
import com.netease.pushservice.event.EventHandler;
import com.netease.pushservice.event.EventType;
import com.netease.pushservice.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class NetEaseRegistrationHelper
{
  private static final int ERROR_CODE_NETEASE_PREVIOUS_REGISTRATION = 440;
  private static final String NETEASE_BLIZZARD_HOST = "blizzard.push.126.net";
  private static final int NETEASE_BLIZZARD_PORT = 6006;
  private static final String NETEASE_REGISTRATION_ID_PREF = "netease_registration_id";
  private static final String TAG = LogUtils.generateLogTag(NetEaseRegistrationHelper.class);
  public static boolean forceNetEase = false;
  
  private static String getNetEaseRegistrationId(Context paramContext)
  {
    return PreferenceUtils.loadFromPreferences(paramContext, "netease_registration_id");
  }
  
  public static void register(Context paramContext, final String paramString1, final String paramString2)
  {
    ServiceManager localServiceManager = ServiceManager.getInstance();
    localServiceManager.init("blizzard.push.126.net", 6006, paramContext);
    localServiceManager.startService(paramContext);
    String str3 = localServiceManager.getProperty("NETEASE_DOMAIN");
    final String str2 = localServiceManager.getProperty("NETEASE_PRODUCT_VERSION");
    String str4 = localServiceManager.getProperty("NETEASE_PRODUCT_KEY");
    if (TextUtils.isEmpty(str3)) {
      throw new RegistrationException("Domain is required for NetEase registration. Is the meta-data NETEASE_DOMAIN added to your AndroidManifest.xml?");
    }
    if (TextUtils.isEmpty(str4)) {
      throw new RegistrationException("Product Key is required for NetEase registration. Is the meta-data NETEASE_PRODUCT_KEY added to your AndroidManifest.xml?");
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0.0.6";
    }
    ServiceManager.setLoggerLevel(1);
    str2 = Utils.generateUUID(paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("oldDeviceId", str2);
    Log.i(TAG, "Starting netease registration...");
    Log.i(TAG, "Domain : " + str3 + " Product Key: " + str4 + " Product Version: " + str1);
    localServiceManager.register(paramContext, str3, str4, str1, localHashMap, new EventHandler()
    {
      public void processEvent(Event paramAnonymousEvent)
      {
        if (paramAnonymousEvent.isSuccess())
        {
          Log.i(NetEaseRegistrationHelper.TAG, "Netease Registration Successful");
          Log.i(NetEaseRegistrationHelper.TAG, "Storing Netease Registration Id");
          NetEaseRegistrationHelper.saveNetEaseRegistrationId(this.val$context, str2);
          RegistrationHelper.notifyPushTokenUpdated(this.val$context, str2, Platform.NETEASE_ANDROID);
          if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
            NetEaseRegistrationHelper.sendNetEaseRegistrationToBPNS(this.val$context, str2, paramString1, paramString2);
          }
        }
        do
        {
          return;
          Log.i(NetEaseRegistrationHelper.TAG, "No auth token or region, BPNS override for self registration enabled");
          return;
          Log.i(NetEaseRegistrationHelper.TAG, "Netease Registration Failed");
          Log.i(NetEaseRegistrationHelper.TAG, paramAnonymousEvent.getError().getErrorDes());
          Log.i(NetEaseRegistrationHelper.TAG, String.valueOf(paramAnonymousEvent.getError().getErrorType()));
          Log.i(NetEaseRegistrationHelper.TAG, paramAnonymousEvent.getMsg().toString());
        } while (paramAnonymousEvent.getError().getErrorType() != 440);
        RegistrationHelper.notifyPushTokenUpdated(this.val$context, str2, Platform.NETEASE_ANDROID);
      }
    });
    localServiceManager.addEventHandler(paramContext, EventType.SERVICE_CONNECT, new EventHandler()
    {
      public void processEvent(Event paramAnonymousEvent)
      {
        Log.i(NetEaseRegistrationHelper.TAG, "Netease Server Connection Successful");
      }
    });
    localServiceManager.addEventHandler(paramContext, EventType.SERVICE_DISCONNECT, new EventHandler()
    {
      public void processEvent(Event paramAnonymousEvent)
      {
        Log.i(NetEaseRegistrationHelper.TAG, "Netease Server Connection Destroyed");
      }
    });
    if (!TextUtils.isEmpty(getNetEaseRegistrationId(paramContext)))
    {
      RegistrationHelper.notifyPushTokenUpdated(paramContext, getNetEaseRegistrationId(paramContext), Platform.NETEASE_ANDROID);
      sendNetEaseRegistrationToBPNS(paramContext, str2, paramString1, paramString2);
    }
  }
  
  private static void saveNetEaseRegistrationId(Context paramContext, String paramString)
  {
    PreferenceUtils.saveToPreferences(paramContext, "netease_registration_id", paramString);
  }
  
  private static void sendNetEaseRegistrationToBPNS(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    new BlizzardRegistration(paramContext, "NETEASE_ANDROID", paramString1, paramString2, paramString3).sendRegistrationToBlizzard();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/netease/NetEaseRegistrationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */