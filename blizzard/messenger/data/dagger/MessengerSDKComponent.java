package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.BlizzardMessenger;
import com.blizzard.messenger.data.model.chat.ChatModel;
import com.blizzard.messenger.data.providers.ConversationProvider;
import com.blizzard.messenger.data.xmpp.provider.ProfilePacketProvider;
import com.blizzard.messenger.data.xmpp.provider.SettingsPacketProvider;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules={FriendsModule.class, ConnectionModule.class, ChatModule.class, ChatHistoryModule.class, SettingsModule.class, PushNotificationModule.class, ProfileModule.class, PresenceModule.class, SuggestedFriendsModule.class})
@Singleton
public abstract interface MessengerSDKComponent
{
  public abstract void inject(BlizzardMessenger paramBlizzardMessenger);
  
  public abstract void inject(ChatModel paramChatModel);
  
  public abstract void inject(ConversationProvider paramConversationProvider);
  
  public abstract void inject(ProfilePacketProvider paramProfilePacketProvider);
  
  public abstract void inject(SettingsPacketProvider paramSettingsPacketProvider);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/MessengerSDKComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */