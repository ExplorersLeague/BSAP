package com.blizzard.messenger.dagger;

import com.blizzard.messenger.data.model.settings.SettingsModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModelModule_ProvideSettingsModelFactory
  implements Factory<SettingsModel>
{
  private final ModelModule module;
  
  static
  {
    if (!ModelModule_ProvideSettingsModelFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ModelModule_ProvideSettingsModelFactory(ModelModule paramModelModule)
  {
    assert (paramModelModule != null);
    this.module = paramModelModule;
  }
  
  public static Factory<SettingsModel> create(ModelModule paramModelModule)
  {
    return new ModelModule_ProvideSettingsModelFactory(paramModelModule);
  }
  
  public SettingsModel get()
  {
    return (SettingsModel)Preconditions.checkNotNull(this.module.provideSettingsModel(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/ModelModule_ProvideSettingsModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */