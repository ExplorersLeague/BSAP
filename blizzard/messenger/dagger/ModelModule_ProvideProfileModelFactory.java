package com.blizzard.messenger.dagger;

import com.blizzard.messenger.data.model.profile.ProfileModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModelModule_ProvideProfileModelFactory
  implements Factory<ProfileModel>
{
  private final ModelModule module;
  
  static
  {
    if (!ModelModule_ProvideProfileModelFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ModelModule_ProvideProfileModelFactory(ModelModule paramModelModule)
  {
    assert (paramModelModule != null);
    this.module = paramModelModule;
  }
  
  public static Factory<ProfileModel> create(ModelModule paramModelModule)
  {
    return new ModelModule_ProvideProfileModelFactory(paramModelModule);
  }
  
  public ProfileModel get()
  {
    return (ProfileModel)Preconditions.checkNotNull(this.module.provideProfileModel(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/ModelModule_ProvideProfileModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */