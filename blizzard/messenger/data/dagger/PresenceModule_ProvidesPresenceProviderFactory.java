package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.PresenceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class PresenceModule_ProvidesPresenceProviderFactory
  implements Factory<PresenceProvider>
{
  private final PresenceModule module;
  
  static
  {
    if (!PresenceModule_ProvidesPresenceProviderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PresenceModule_ProvidesPresenceProviderFactory(PresenceModule paramPresenceModule)
  {
    assert (paramPresenceModule != null);
    this.module = paramPresenceModule;
  }
  
  public static Factory<PresenceProvider> create(PresenceModule paramPresenceModule)
  {
    return new PresenceModule_ProvidesPresenceProviderFactory(paramPresenceModule);
  }
  
  public PresenceProvider get()
  {
    return (PresenceProvider)Preconditions.checkNotNull(this.module.providesPresenceProvider(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/PresenceModule_ProvidesPresenceProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */