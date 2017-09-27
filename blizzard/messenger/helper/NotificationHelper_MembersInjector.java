package com.blizzard.messenger.helper;

import com.blizzard.messenger.data.model.push.PushNotificationModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class NotificationHelper_MembersInjector
  implements MembersInjector<NotificationHelper>
{
  private final Provider<PushNotificationModel> pushNotificationModelProvider;
  
  static
  {
    if (!NotificationHelper_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public NotificationHelper_MembersInjector(Provider<PushNotificationModel> paramProvider)
  {
    assert (paramProvider != null);
    this.pushNotificationModelProvider = paramProvider;
  }
  
  public static MembersInjector<NotificationHelper> create(Provider<PushNotificationModel> paramProvider)
  {
    return new NotificationHelper_MembersInjector(paramProvider);
  }
  
  public static void injectPushNotificationModel(NotificationHelper paramNotificationHelper, Provider<PushNotificationModel> paramProvider)
  {
    paramNotificationHelper.pushNotificationModel = ((PushNotificationModel)paramProvider.get());
  }
  
  public void injectMembers(NotificationHelper paramNotificationHelper)
  {
    if (paramNotificationHelper == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramNotificationHelper.pushNotificationModel = ((PushNotificationModel)this.pushNotificationModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/helper/NotificationHelper_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */