package com.blizzard.messenger.dagger;

import com.blizzard.messenger.data.model.friends.FriendsModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModelModule_ProvideFriendsModelFactory
  implements Factory<FriendsModel>
{
  private final ModelModule module;
  
  static
  {
    if (!ModelModule_ProvideFriendsModelFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ModelModule_ProvideFriendsModelFactory(ModelModule paramModelModule)
  {
    assert (paramModelModule != null);
    this.module = paramModelModule;
  }
  
  public static Factory<FriendsModel> create(ModelModule paramModelModule)
  {
    return new ModelModule_ProvideFriendsModelFactory(paramModelModule);
  }
  
  public FriendsModel get()
  {
    return (FriendsModel)Preconditions.checkNotNull(this.module.provideFriendsModel(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/ModelModule_ProvideFriendsModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */