package com.blizzard.messenger.dagger;

import com.blizzard.messenger.data.model.push.PushNotificationModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModelModule_ProvidePushNotificationModelFactory
  implements Factory<PushNotificationModel>
{
  private final ModelModule module;
  
  static
  {
    if (!ModelModule_ProvidePushNotificationModelFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ModelModule_ProvidePushNotificationModelFactory(ModelModule paramModelModule)
  {
    assert (paramModelModule != null);
    this.module = paramModelModule;
  }
  
  public static Factory<PushNotificationModel> create(ModelModule paramModelModule)
  {
    return new ModelModule_ProvidePushNotificationModelFactory(paramModelModule);
  }
  
  public PushNotificationModel get()
  {
    return (PushNotificationModel)Preconditions.checkNotNull(this.module.providePushNotificationModel(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/ModelModule_ProvidePushNotificationModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */