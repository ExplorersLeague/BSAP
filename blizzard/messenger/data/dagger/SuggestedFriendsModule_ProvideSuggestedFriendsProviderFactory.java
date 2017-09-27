package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.SuggestedFriendsProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SuggestedFriendsModule_ProvideSuggestedFriendsProviderFactory
  implements Factory<SuggestedFriendsProvider>
{
  private final SuggestedFriendsModule module;
  
  static
  {
    if (!SuggestedFriendsModule_ProvideSuggestedFriendsProviderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SuggestedFriendsModule_ProvideSuggestedFriendsProviderFactory(SuggestedFriendsModule paramSuggestedFriendsModule)
  {
    assert (paramSuggestedFriendsModule != null);
    this.module = paramSuggestedFriendsModule;
  }
  
  public static Factory<SuggestedFriendsProvider> create(SuggestedFriendsModule paramSuggestedFriendsModule)
  {
    return new SuggestedFriendsModule_ProvideSuggestedFriendsProviderFactory(paramSuggestedFriendsModule);
  }
  
  public SuggestedFriendsProvider get()
  {
    return (SuggestedFriendsProvider)Preconditions.checkNotNull(this.module.provideSuggestedFriendsProvider(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/SuggestedFriendsModule_ProvideSuggestedFriendsProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */