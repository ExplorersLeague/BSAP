package com.blizzard.messenger.dagger;

import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriendsModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModelModule_ProvideSuggestedFriendsModelFactory
  implements Factory<SuggestedFriendsModel>
{
  private final ModelModule module;
  
  static
  {
    if (!ModelModule_ProvideSuggestedFriendsModelFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ModelModule_ProvideSuggestedFriendsModelFactory(ModelModule paramModelModule)
  {
    assert (paramModelModule != null);
    this.module = paramModelModule;
  }
  
  public static Factory<SuggestedFriendsModel> create(ModelModule paramModelModule)
  {
    return new ModelModule_ProvideSuggestedFriendsModelFactory(paramModelModule);
  }
  
  public SuggestedFriendsModel get()
  {
    return (SuggestedFriendsModel)Preconditions.checkNotNull(this.module.provideSuggestedFriendsModel(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/ModelModule_ProvideSuggestedFriendsModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */