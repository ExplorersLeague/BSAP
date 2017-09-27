package com.blizzard.messenger.data.model.push;

import android.support.annotation.Nullable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PushNotificationModel
{
  private static final String TAG = PushNotificationModel.class.getSimpleName();
  private Set<Integer> friendRequestNotificationSet = new HashSet();
  private Map<String, List<Integer>> whisperNotificationMap = new HashMap();
  
  public void clearFriendRequestNotifications()
  {
    this.friendRequestNotificationSet.clear();
  }
  
  public void clearWhisperNotifications(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.whisperNotificationMap.put(paramString, null);
  }
  
  public Set<Integer> getFriendRequestNotifications()
  {
    return this.friendRequestNotificationSet;
  }
  
  @Nullable
  public List<Integer> getWhisperNotificationIds(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (List)this.whisperNotificationMap.get(paramString);
  }
  
  public void storeFriendRequestPushNotification(int paramInt)
  {
    Log.w(TAG, "storeFriendRequestNotification()");
    this.friendRequestNotificationSet.add(Integer.valueOf(paramInt));
  }
  
  public void storeWhisperPushNotification(String paramString, int paramInt)
  {
    List localList = (List)this.whisperNotificationMap.get(paramString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(Integer.valueOf(paramInt));
    this.whisperNotificationMap.put(paramString, localObject);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/push/PushNotificationModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */