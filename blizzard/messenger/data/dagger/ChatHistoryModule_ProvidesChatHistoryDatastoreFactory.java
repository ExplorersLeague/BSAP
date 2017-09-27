package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.datastores.ChatHistoryDatastore;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ChatHistoryModule_ProvidesChatHistoryDatastoreFactory
  implements Factory<ChatHistoryDatastore>
{
  private final ChatHistoryModule module;
  
  static
  {
    if (!ChatHistoryModule_ProvidesChatHistoryDatastoreFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ChatHistoryModule_ProvidesChatHistoryDatastoreFactory(ChatHistoryModule paramChatHistoryModule)
  {
    assert (paramChatHistoryModule != null);
    this.module = paramChatHistoryModule;
  }
  
  public static Factory<ChatHistoryDatastore> create(ChatHistoryModule paramChatHistoryModule)
  {
    return new ChatHistoryModule_ProvidesChatHistoryDatastoreFactory(paramChatHistoryModule);
  }
  
  public ChatHistoryDatastore get()
  {
    return (ChatHistoryDatastore)Preconditions.checkNotNull(this.module.providesChatHistoryDatastore(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/ChatHistoryModule_ProvidesChatHistoryDatastoreFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */