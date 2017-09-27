package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.FriendsProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FriendsModule_ProvideFriendsProviderFactory
  implements Factory<FriendsProvider>
{
  private final FriendsModule module;
  
  static
  {
    if (!FriendsModule_ProvideFriendsProviderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FriendsModule_ProvideFriendsProviderFactory(FriendsModule paramFriendsModule)
  {
    assert (paramFriendsModule != null);
    this.module = paramFriendsModule;
  }
  
  public static Factory<FriendsProvider> create(FriendsModule paramFriendsModule)
  {
    return new FriendsModule_ProvideFriendsProviderFactory(paramFriendsModule);
  }
  
  public FriendsProvider get()
  {
    return (FriendsProvider)Preconditions.checkNotNull(this.module.provideFriendsProvider(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/FriendsModule_ProvideFriendsProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */