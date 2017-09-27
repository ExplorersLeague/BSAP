package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.BlizzardMessenger;
import com.blizzard.messenger.data.BlizzardMessenger_MembersInjector;
import com.blizzard.messenger.data.datastores.ChatHistoryDatastore;
import com.blizzard.messenger.data.model.chat.ChatModel;
import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import com.blizzard.messenger.data.providers.ConnectionProvider;
import com.blizzard.messenger.data.providers.ConversationProvider;
import com.blizzard.messenger.data.providers.FriendsProvider;
import com.blizzard.messenger.data.providers.PresenceProvider;
import com.blizzard.messenger.data.providers.ProfileProvider;
import com.blizzard.messenger.data.providers.PushNotificationProvider;
import com.blizzard.messenger.data.providers.SettingsProvider;
import com.blizzard.messenger.data.providers.SuggestedFriendsProvider;
import com.blizzard.messenger.data.xmpp.provider.ProfilePacketProvider;
import com.blizzard.messenger.data.xmpp.provider.SettingsPacketProvider;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerMessengerSDKComponent
  implements MessengerSDKComponent
{
  private MembersInjector<BlizzardMessenger> blizzardMessengerMembersInjector;
  private Provider<FriendsProvider> provideFriendsProvider;
  private Provider<ProfileProvider> provideProfileProvider;
  private Provider<PushNotificationProvider> providePushNotificationProvider;
  private Provider<SuggestedFriendsProvider> provideSuggestedFriendsProvider;
  private Provider<ChatHistoryDatastore> providesChatHistoryDatastoreProvider;
  private Provider<ChatHistoryProvider> providesChatHistoryProvider;
  private Provider<ConnectionProvider> providesConnectionManagerProvider;
  private Provider<ConversationProvider> providesConversationManagerProvider;
  private Provider<PresenceProvider> providesPresenceProvider;
  private Provider<SettingsProvider> providesSettingsProvider;
  
  static
  {
    if (!DaggerMessengerSDKComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerMessengerSDKComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    initialize(paramBuilder);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static MessengerSDKComponent create()
  {
    return builder().build();
  }
  
  private void initialize(Builder paramBuilder)
  {
    this.providesConversationManagerProvider = DoubleCheck.provider(ChatModule_ProvidesConversationManagerFactory.create(paramBuilder.chatModule));
    this.providesConnectionManagerProvider = DoubleCheck.provider(ConnectionModule_ProvidesConnectionManagerFactory.create(paramBuilder.connectionModule));
    this.provideFriendsProvider = DoubleCheck.provider(FriendsModule_ProvideFriendsProviderFactory.create(paramBuilder.friendsModule));
    this.providesChatHistoryDatastoreProvider = DoubleCheck.provider(ChatHistoryModule_ProvidesChatHistoryDatastoreFactory.create(paramBuilder.chatHistoryModule));
    this.providesSettingsProvider = DoubleCheck.provider(SettingsModule_ProvidesSettingsProviderFactory.create(paramBuilder.settingsModule));
    this.providePushNotificationProvider = DoubleCheck.provider(PushNotificationModule_ProvidePushNotificationProviderFactory.create(paramBuilder.pushNotificationModule));
    this.provideProfileProvider = DoubleCheck.provider(ProfileModule_ProvideProfileProviderFactory.create(paramBuilder.profileModule));
    this.providesPresenceProvider = DoubleCheck.provider(PresenceModule_ProvidesPresenceProviderFactory.create(paramBuilder.presenceModule));
    this.provideSuggestedFriendsProvider = DoubleCheck.provider(SuggestedFriendsModule_ProvideSuggestedFriendsProviderFactory.create(paramBuilder.suggestedFriendsModule));
    this.providesChatHistoryProvider = DoubleCheck.provider(ChatHistoryModule_ProvidesChatHistoryProviderFactory.create(paramBuilder.chatHistoryModule));
    this.blizzardMessengerMembersInjector = BlizzardMessenger_MembersInjector.create(this.providesConversationManagerProvider, this.providesConnectionManagerProvider, this.provideFriendsProvider, this.providesChatHistoryDatastoreProvider, this.providesSettingsProvider, this.providePushNotificationProvider, this.provideProfileProvider, this.providesPresenceProvider, this.provideSuggestedFriendsProvider, this.providesChatHistoryProvider);
  }
  
  public void inject(BlizzardMessenger paramBlizzardMessenger)
  {
    this.blizzardMessengerMembersInjector.injectMembers(paramBlizzardMessenger);
  }
  
  public void inject(ChatModel paramChatModel)
  {
    MembersInjectors.noOp().injectMembers(paramChatModel);
  }
  
  public void inject(ConversationProvider paramConversationProvider)
  {
    MembersInjectors.noOp().injectMembers(paramConversationProvider);
  }
  
  public void inject(ProfilePacketProvider paramProfilePacketProvider)
  {
    MembersInjectors.noOp().injectMembers(paramProfilePacketProvider);
  }
  
  public void inject(SettingsPacketProvider paramSettingsPacketProvider)
  {
    MembersInjectors.noOp().injectMembers(paramSettingsPacketProvider);
  }
  
  public static final class Builder
  {
    private ChatHistoryModule chatHistoryModule;
    private ChatModule chatModule;
    private ConnectionModule connectionModule;
    private FriendsModule friendsModule;
    private PresenceModule presenceModule;
    private ProfileModule profileModule;
    private PushNotificationModule pushNotificationModule;
    private SettingsModule settingsModule;
    private SuggestedFriendsModule suggestedFriendsModule;
    
    public MessengerSDKComponent build()
    {
      if (this.chatModule == null) {
        this.chatModule = new ChatModule();
      }
      if (this.connectionModule == null) {
        this.connectionModule = new ConnectionModule();
      }
      if (this.friendsModule == null) {
        this.friendsModule = new FriendsModule();
      }
      if (this.chatHistoryModule == null) {
        this.chatHistoryModule = new ChatHistoryModule();
      }
      if (this.settingsModule == null) {
        this.settingsModule = new SettingsModule();
      }
      if (this.pushNotificationModule == null) {
        this.pushNotificationModule = new PushNotificationModule();
      }
      if (this.profileModule == null) {
        this.profileModule = new ProfileModule();
      }
      if (this.presenceModule == null) {
        this.presenceModule = new PresenceModule();
      }
      if (this.suggestedFriendsModule == null) {
        this.suggestedFriendsModule = new SuggestedFriendsModule();
      }
      return new DaggerMessengerSDKComponent(this, null);
    }
    
    public Builder chatHistoryModule(ChatHistoryModule paramChatHistoryModule)
    {
      this.chatHistoryModule = ((ChatHistoryModule)Preconditions.checkNotNull(paramChatHistoryModule));
      return this;
    }
    
    public Builder chatModule(ChatModule paramChatModule)
    {
      this.chatModule = ((ChatModule)Preconditions.checkNotNull(paramChatModule));
      return this;
    }
    
    public Builder connectionModule(ConnectionModule paramConnectionModule)
    {
      this.connectionModule = ((ConnectionModule)Preconditions.checkNotNull(paramConnectionModule));
      return this;
    }
    
    public Builder friendsModule(FriendsModule paramFriendsModule)
    {
      this.friendsModule = ((FriendsModule)Preconditions.checkNotNull(paramFriendsModule));
      return this;
    }
    
    public Builder presenceModule(PresenceModule paramPresenceModule)
    {
      this.presenceModule = ((PresenceModule)Preconditions.checkNotNull(paramPresenceModule));
      return this;
    }
    
    public Builder profileModule(ProfileModule paramProfileModule)
    {
      this.profileModule = ((ProfileModule)Preconditions.checkNotNull(paramProfileModule));
      return this;
    }
    
    public Builder pushNotificationModule(PushNotificationModule paramPushNotificationModule)
    {
      this.pushNotificationModule = ((PushNotificationModule)Preconditions.checkNotNull(paramPushNotificationModule));
      return this;
    }
    
    public Builder settingsModule(SettingsModule paramSettingsModule)
    {
      this.settingsModule = ((SettingsModule)Preconditions.checkNotNull(paramSettingsModule));
      return this;
    }
    
    public Builder suggestedFriendsModule(SuggestedFriendsModule paramSuggestedFriendsModule)
    {
      this.suggestedFriendsModule = ((SuggestedFriendsModule)Preconditions.checkNotNull(paramSuggestedFriendsModule));
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/DaggerMessengerSDKComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */