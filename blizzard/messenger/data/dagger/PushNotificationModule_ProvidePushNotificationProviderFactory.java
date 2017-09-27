package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.PushNotificationProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class PushNotificationModule_ProvidePushNotificationProviderFactory
  implements Factory<PushNotificationProvider>
{
  private final PushNotificationModule module;
  
  static
  {
    if (!PushNotificationModule_ProvidePushNotificationProviderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PushNotificationModule_ProvidePushNotificationProviderFactory(PushNotificationModule paramPushNotificationModule)
  {
    assert (paramPushNotificationModule != null);
    this.module = paramPushNotificationModule;
  }
  
  public static Factory<PushNotificationProvider> create(PushNotificationModule paramPushNotificationModule)
  {
    return new PushNotificationModule_ProvidePushNotificationProviderFactory(paramPushNotificationModule);
  }
  
  public PushNotificationProvider get()
  {
    return (PushNotificationProvider)Preconditions.checkNotNull(this.module.providePushNotificationProvider(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/PushNotificationModule_ProvidePushNotificationProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */