package com.blizzard.messenger.dagger;

import com.blizzard.messenger.data.model.chat.NewestMessageModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModelModule_ProvideMessageExtentsModelFactory
  implements Factory<NewestMessageModel>
{
  private final ModelModule module;
  
  static
  {
    if (!ModelModule_ProvideMessageExtentsModelFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ModelModule_ProvideMessageExtentsModelFactory(ModelModule paramModelModule)
  {
    assert (paramModelModule != null);
    this.module = paramModelModule;
  }
  
  public static Factory<NewestMessageModel> create(ModelModule paramModelModule)
  {
    return new ModelModule_ProvideMessageExtentsModelFactory(paramModelModule);
  }
  
  public NewestMessageModel get()
  {
    return (NewestMessageModel)Preconditions.checkNotNull(this.module.provideMessageExtentsModel(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/ModelModule_ProvideMessageExtentsModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */