package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.ProfileProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ProfileModule_ProvideProfileProviderFactory
  implements Factory<ProfileProvider>
{
  private final ProfileModule module;
  
  static
  {
    if (!ProfileModule_ProvideProfileProviderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ProfileModule_ProvideProfileProviderFactory(ProfileModule paramProfileModule)
  {
    assert (paramProfileModule != null);
    this.module = paramProfileModule;
  }
  
  public static Factory<ProfileProvider> create(ProfileModule paramProfileModule)
  {
    return new ProfileModule_ProvideProfileProviderFactory(paramProfileModule);
  }
  
  public ProfileProvider get()
  {
    return (ProfileProvider)Preconditions.checkNotNull(this.module.provideProfileProvider(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/ProfileModule_ProvideProfileProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */