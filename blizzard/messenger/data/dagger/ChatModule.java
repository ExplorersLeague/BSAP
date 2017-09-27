package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.ConversationProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ChatModule
{
  private ConversationProvider conversationProvider = new ConversationProvider();
  
  @Provides
  @Singleton
  ConversationProvider providesConversationManager()
  {
    return this.conversationProvider;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/ChatModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */