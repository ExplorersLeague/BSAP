package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ChatHistoryModule_ProvidesChatHistoryProviderFactory
  implements Factory<ChatHistoryProvider>
{
  private final ChatHistoryModule module;
  
  static
  {
    if (!ChatHistoryModule_ProvidesChatHistoryProviderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ChatHistoryModule_ProvidesChatHistoryProviderFactory(ChatHistoryModule paramChatHistoryModule)
  {
    assert (paramChatHistoryModule != null);
    this.module = paramChatHistoryModule;
  }
  
  public static Factory<ChatHistoryProvider> create(ChatHistoryModule paramChatHistoryModule)
  {
    return new ChatHistoryModule_ProvidesChatHistoryProviderFactory(paramChatHistoryModule);
  }
  
  public ChatHistoryProvider get()
  {
    return (ChatHistoryProvider)Preconditions.checkNotNull(this.module.providesChatHistoryProvider(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/ChatHistoryModule_ProvidesChatHistoryProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */