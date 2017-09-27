package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.datastores.ChatHistoryDatastore;
import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ChatHistoryModule
{
  private ChatHistoryDatastore chatHistoryDatastore = new ChatHistoryDatastore();
  private ChatHistoryProvider chatHistoryProvider = new ChatHistoryProvider();
  
  @Provides
  @Singleton
  ChatHistoryDatastore providesChatHistoryDatastore()
  {
    return this.chatHistoryDatastore;
  }
  
  @Provides
  @Singleton
  ChatHistoryProvider providesChatHistoryProvider()
  {
    return this.chatHistoryProvider;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/ChatHistoryModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */