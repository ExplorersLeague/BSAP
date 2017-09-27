package com.blizzard.messenger.data;

import com.blizzard.messenger.data.datastores.ChatHistoryDatastore;
import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import com.blizzard.messenger.data.providers.ConnectionProvider;
import com.blizzard.messenger.data.providers.ConversationProvider;
import com.blizzard.messenger.data.providers.FriendsProvider;
import com.blizzard.messenger.data.providers.PresenceProvider;
import com.blizzard.messenger.data.providers.ProfileProvider;
import com.blizzard.messenger.data.providers.PushNotificationProvider;
import com.blizzard.messenger.data.providers.SettingsProvider;
import com.blizzard.messenger.data.providers.SuggestedFriendsProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BlizzardMessenger_MembersInjector
  implements MembersInjector<BlizzardMessenger>
{
  private final Provider<ChatHistoryDatastore> chatHistoryDatastoreProvider;
  private final Provider<ChatHistoryProvider> chatHistoryProvider;
  private final Provider<ConnectionProvider> connectionProvider;
  private final Provider<ConversationProvider> conversationProvider;
  private final Provider<FriendsProvider> friendsProvider;
  private final Provider<PresenceProvider> presenceProvider;
  private final Provider<ProfileProvider> profileProvider;
  private final Provider<PushNotificationProvider> pushNotificationProvider;
  private final Provider<SettingsProvider> settingsProvider;
  private final Provider<SuggestedFriendsProvider> suggestedFriendsProvider;
  
  static
  {
    if (!BlizzardMessenger_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public BlizzardMessenger_MembersInjector(Provider<ConversationProvider> paramProvider, Provider<ConnectionProvider> paramProvider1, Provider<FriendsProvider> paramProvider2, Provider<ChatHistoryDatastore> paramProvider3, Provider<SettingsProvider> paramProvider4, Provider<PushNotificationProvider> paramProvider5, Provider<ProfileProvider> paramProvider6, Provider<PresenceProvider> paramProvider7, Provider<SuggestedFriendsProvider> paramProvider8, Provider<ChatHistoryProvider> paramProvider9)
  {
    assert (paramProvider != null);
    this.conversationProvider = paramProvider;
    assert (paramProvider1 != null);
    this.connectionProvider = paramProvider1;
    assert (paramProvider2 != null);
    this.friendsProvider = paramProvider2;
    assert (paramProvider3 != null);
    this.chatHistoryDatastoreProvider = paramProvider3;
    assert (paramProvider4 != null);
    this.settingsProvider = paramProvider4;
    assert (paramProvider5 != null);
    this.pushNotificationProvider = paramProvider5;
    assert (paramProvider6 != null);
    this.profileProvider = paramProvider6;
    assert (paramProvider7 != null);
    this.presenceProvider = paramProvider7;
    assert (paramProvider8 != null);
    this.suggestedFriendsProvider = paramProvider8;
    assert (paramProvider9 != null);
    this.chatHistoryProvider = paramProvider9;
  }
  
  public static MembersInjector<BlizzardMessenger> create(Provider<ConversationProvider> paramProvider, Provider<ConnectionProvider> paramProvider1, Provider<FriendsProvider> paramProvider2, Provider<ChatHistoryDatastore> paramProvider3, Provider<SettingsProvider> paramProvider4, Provider<PushNotificationProvider> paramProvider5, Provider<ProfileProvider> paramProvider6, Provider<PresenceProvider> paramProvider7, Provider<SuggestedFriendsProvider> paramProvider8, Provider<ChatHistoryProvider> paramProvider9)
  {
    return new BlizzardMessenger_MembersInjector(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9);
  }
  
  public static void injectChatHistoryDatastore(BlizzardMessenger paramBlizzardMessenger, Provider<ChatHistoryDatastore> paramProvider)
  {
    paramBlizzardMessenger.chatHistoryDatastore = ((ChatHistoryDatastore)paramProvider.get());
  }
  
  public static void injectChatHistoryProvider(BlizzardMessenger paramBlizzardMessenger, Provider<ChatHistoryProvider> paramProvider)
  {
    paramBlizzardMessenger.chatHistoryProvider = ((ChatHistoryProvider)paramProvider.get());
  }
  
  public static void injectConnectionProvider(BlizzardMessenger paramBlizzardMessenger, Provider<ConnectionProvider> paramProvider)
  {
    paramBlizzardMessenger.connectionProvider = ((ConnectionProvider)paramProvider.get());
  }
  
  public static void injectConversationProvider(BlizzardMessenger paramBlizzardMessenger, Provider<ConversationProvider> paramProvider)
  {
    paramBlizzardMessenger.conversationProvider = ((ConversationProvider)paramProvider.get());
  }
  
  public static void injectFriendsProvider(BlizzardMessenger paramBlizzardMessenger, Provider<FriendsProvider> paramProvider)
  {
    paramBlizzardMessenger.friendsProvider = ((FriendsProvider)paramProvider.get());
  }
  
  public static void injectPresenceProvider(BlizzardMessenger paramBlizzardMessenger, Provider<PresenceProvider> paramProvider)
  {
    paramBlizzardMessenger.presenceProvider = ((PresenceProvider)paramProvider.get());
  }
  
  public static void injectProfileProvider(BlizzardMessenger paramBlizzardMessenger, Provider<ProfileProvider> paramProvider)
  {
    paramBlizzardMessenger.profileProvider = ((ProfileProvider)paramProvider.get());
  }
  
  public static void injectPushNotificationProvider(BlizzardMessenger paramBlizzardMessenger, Provider<PushNotificationProvider> paramProvider)
  {
    paramBlizzardMessenger.pushNotificationProvider = ((PushNotificationProvider)paramProvider.get());
  }
  
  public static void injectSettingsProvider(BlizzardMessenger paramBlizzardMessenger, Provider<SettingsProvider> paramProvider)
  {
    paramBlizzardMessenger.settingsProvider = ((SettingsProvider)paramProvider.get());
  }
  
  public static void injectSuggestedFriendsProvider(BlizzardMessenger paramBlizzardMessenger, Provider<SuggestedFriendsProvider> paramProvider)
  {
    paramBlizzardMessenger.suggestedFriendsProvider = ((SuggestedFriendsProvider)paramProvider.get());
  }
  
  public void injectMembers(BlizzardMessenger paramBlizzardMessenger)
  {
    if (paramBlizzardMessenger == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramBlizzardMessenger.conversationProvider = ((ConversationProvider)this.conversationProvider.get());
    paramBlizzardMessenger.connectionProvider = ((ConnectionProvider)this.connectionProvider.get());
    paramBlizzardMessenger.friendsProvider = ((FriendsProvider)this.friendsProvider.get());
    paramBlizzardMessenger.chatHistoryDatastore = ((ChatHistoryDatastore)this.chatHistoryDatastoreProvider.get());
    paramBlizzardMessenger.settingsProvider = ((SettingsProvider)this.settingsProvider.get());
    paramBlizzardMessenger.pushNotificationProvider = ((PushNotificationProvider)this.pushNotificationProvider.get());
    paramBlizzardMessenger.profileProvider = ((ProfileProvider)this.profileProvider.get());
    paramBlizzardMessenger.presenceProvider = ((PresenceProvider)this.presenceProvider.get());
    paramBlizzardMessenger.suggestedFriendsProvider = ((SuggestedFriendsProvider)this.suggestedFriendsProvider.get());
    paramBlizzardMessenger.chatHistoryProvider = ((ChatHistoryProvider)this.chatHistoryProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/BlizzardMessenger_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */