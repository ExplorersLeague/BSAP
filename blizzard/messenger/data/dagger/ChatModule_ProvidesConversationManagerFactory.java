package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.ConversationProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ChatModule_ProvidesConversationManagerFactory
  implements Factory<ConversationProvider>
{
  private final ChatModule module;
  
  static
  {
    if (!ChatModule_ProvidesConversationManagerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ChatModule_ProvidesConversationManagerFactory(ChatModule paramChatModule)
  {
    assert (paramChatModule != null);
    this.module = paramChatModule;
  }
  
  public static Factory<ConversationProvider> create(ChatModule paramChatModule)
  {
    return new ChatModule_ProvidesConversationManagerFactory(paramChatModule);
  }
  
  public ConversationProvider get()
  {
    return (ConversationProvider)Preconditions.checkNotNull(this.module.providesConversationManager(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/ChatModule_ProvidesConversationManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */