package com.blizzard.messenger.dagger;

import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModelModule_ProvideSeenConversationModelFactory
  implements Factory<UnseenConversationModel>
{
  private final ModelModule module;
  
  static
  {
    if (!ModelModule_ProvideSeenConversationModelFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ModelModule_ProvideSeenConversationModelFactory(ModelModule paramModelModule)
  {
    assert (paramModelModule != null);
    this.module = paramModelModule;
  }
  
  public static Factory<UnseenConversationModel> create(ModelModule paramModelModule)
  {
    return new ModelModule_ProvideSeenConversationModelFactory(paramModelModule);
  }
  
  public UnseenConversationModel get()
  {
    return (UnseenConversationModel)Preconditions.checkNotNull(this.module.provideSeenConversationModel(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/ModelModule_ProvideSeenConversationModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */