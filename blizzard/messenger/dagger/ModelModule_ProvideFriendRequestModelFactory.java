package com.blizzard.messenger.dagger;

import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModelModule_ProvideFriendRequestModelFactory
  implements Factory<FriendRequestModel>
{
  private final ModelModule module;
  
  static
  {
    if (!ModelModule_ProvideFriendRequestModelFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ModelModule_ProvideFriendRequestModelFactory(ModelModule paramModelModule)
  {
    assert (paramModelModule != null);
    this.module = paramModelModule;
  }
  
  public static Factory<FriendRequestModel> create(ModelModule paramModelModule)
  {
    return new ModelModule_ProvideFriendRequestModelFactory(paramModelModule);
  }
  
  public FriendRequestModel get()
  {
    return (FriendRequestModel)Preconditions.checkNotNull(this.module.provideFriendRequestModel(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/ModelModule_ProvideFriendRequestModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */