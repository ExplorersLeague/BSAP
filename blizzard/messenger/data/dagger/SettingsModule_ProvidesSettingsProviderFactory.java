package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.SettingsProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SettingsModule_ProvidesSettingsProviderFactory
  implements Factory<SettingsProvider>
{
  private final SettingsModule module;
  
  static
  {
    if (!SettingsModule_ProvidesSettingsProviderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SettingsModule_ProvidesSettingsProviderFactory(SettingsModule paramSettingsModule)
  {
    assert (paramSettingsModule != null);
    this.module = paramSettingsModule;
  }
  
  public static Factory<SettingsProvider> create(SettingsModule paramSettingsModule)
  {
    return new SettingsModule_ProvidesSettingsProviderFactory(paramSettingsModule);
  }
  
  public SettingsProvider get()
  {
    return (SettingsProvider)Preconditions.checkNotNull(this.module.providesSettingsProvider(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/SettingsModule_ProvidesSettingsProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */