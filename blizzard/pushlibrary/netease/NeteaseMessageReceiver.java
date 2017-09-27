package com.blizzard.pushlibrary.netease;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.pushlibrary.notification.NotificationPoster;
import com.blizzard.pushlibrary.util.LogUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NeteaseMessageReceiver
  extends BroadcastReceiver
{
  private static final String FIELD_CONTENT = "content";
  private static final String FIELD_SUMMARY = "summary";
  private static final String FIELD_TITLE = "title";
  private static final String KEY_MESSAGE_ID = "messageId";
  private static final String KEY_TIMESTAMP = "timestamp";
  private static final String KEY_TYPE = "type";
  private static final String OBJECT_MESSAGE = "message";
  private static final String TAG = LogUtils.generateLogTag(NeteaseMessageReceiver.class);
  
  private void addInnerJsonMessageContent(String paramString, Bundle paramBundle)
    throws JSONException
  {
    paramString = new JSONObject(paramString.replace("\\", ""));
    Iterator localIterator = paramString.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramString.get(str);
      if ((localObject instanceof Integer))
      {
        paramBundle.putInt(str, ((Integer)localObject).intValue());
      }
      else if ((localObject instanceof Double))
      {
        paramBundle.putDouble(str, ((Double)localObject).doubleValue());
      }
      else if ((localObject instanceof Long))
      {
        paramBundle.putLong(str, ((Long)localObject).longValue());
      }
      else if ((localObject instanceof String))
      {
        paramBundle.putString(str, (String)localObject);
      }
      else if ((localObject instanceof Boolean))
      {
        paramBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
      }
      else if (((localObject instanceof JSONObject)) && (paramString.has("content")))
      {
        str = paramString.getString("content");
        if (!TextUtils.isEmpty(str)) {
          addInnerJsonMessageContent(str, paramBundle);
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("message");
      Log.i(TAG, "Received message: " + paramIntent);
      try
      {
        JSONArray localJSONArray = new JSONArray(paramIntent);
        int i = 0;
        while (i < localJSONArray.length())
        {
          Bundle localBundle = new Bundle();
          paramIntent = null;
          Object localObject1 = null;
          Object localObject2 = localJSONArray.getJSONObject(i);
          localBundle.putString("timestamp", ((JSONObject)localObject2).getString("timestamp"));
          localBundle.putString("type", ((JSONObject)localObject2).getString("type"));
          Object localObject3 = ((JSONObject)localObject2).getJSONObject("message");
          if (localObject3 != null)
          {
            localObject2 = ((JSONObject)localObject3).getString("summary");
            String str = ((JSONObject)localObject3).getString("title");
            paramIntent = (Intent)localObject2;
            localObject1 = str;
            if (((JSONObject)localObject3).has("content"))
            {
              localObject3 = ((JSONObject)localObject3).getString("content");
              paramIntent = (Intent)localObject2;
              localObject1 = str;
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                addInnerJsonMessageContent((String)localObject3, localBundle);
                localObject1 = str;
                paramIntent = (Intent)localObject2;
              }
            }
          }
          localBundle.putString("summary", paramIntent);
          localBundle.putString("title", (String)localObject1);
          if (!TextUtils.isEmpty(paramIntent))
          {
            if (localBundle.containsKey("id")) {
              localBundle.putString("messageId", localBundle.getString("id"));
            }
            new NotificationPoster(paramContext).postNotification(paramIntent, localBundle);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramContext)
      {
        Log.e(TAG, "Message parsing failed");
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/netease/NeteaseMessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */