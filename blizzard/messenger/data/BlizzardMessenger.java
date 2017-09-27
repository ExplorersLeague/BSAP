package com.blizzard.messenger.data;

import android.content.Context;
import com.blizzard.messenger.data.dagger.DaggerHelper;
import com.blizzard.messenger.data.dagger.MessengerSDKComponent;
import com.blizzard.messenger.data.datastores.ChatHistoryDatastore;
import com.blizzard.messenger.data.datastores.UnsentChatTextDatastore;
import com.blizzard.messenger.data.listeners.SettingsUpdateListener;
import com.blizzard.messenger.data.providers.BgsAuthProvider;
import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import com.blizzard.messenger.data.providers.ConnectionProvider;
import com.blizzard.messenger.data.providers.ConversationProvider;
import com.blizzard.messenger.data.providers.FriendsProvider;
import com.blizzard.messenger.data.providers.PresenceProvider;
import com.blizzard.messenger.data.providers.ProfileProvider;
import com.blizzard.messenger.data.providers.PushNotificationProvider;
import com.blizzard.messenger.data.providers.SettingsProvider;
import com.blizzard.messenger.data.providers.SuggestedFriendsProvider;
import com.blizzard.messenger.data.providers.UnfurlMessageProvider;
import com.blizzard.messenger.data.utils.ProviderManagerUtils;
import com.orm.SugarContext;
import javax.inject.Inject;

public final class BlizzardMessenger
{
  private BgsAuthProvider bgsAuthProvider;
  @Inject
  ChatHistoryDatastore chatHistoryDatastore;
  @Inject
  ChatHistoryProvider chatHistoryProvider;
  @Inject
  ConnectionProvider connectionProvider;
  @Inject
  ConversationProvider conversationProvider;
  @Inject
  FriendsProvider friendsProvider;
  @Inject
  PresenceProvider presenceProvider;
  @Inject
  ProfileProvider profileProvider;
  @Inject
  PushNotificationProvider pushNotificationProvider;
  @Inject
  SettingsProvider settingsProvider;
  @Inject
  SuggestedFriendsProvider suggestedFriendsProvider;
  private UnfurlMessageProvider unfurlMessageProvider;
  private UnsentChatTextDatastore unsentChatTextDatastore;
  
  private BlizzardMessenger(Builder paramBuilder)
  {
    initialize(paramBuilder);
  }
  
  private void initialize(Builder paramBuilder)
  {
    SugarContext.init(paramBuilder.context);
    this.bgsAuthProvider = paramBuilder.bgsAuthProvider;
    this.unfurlMessageProvider = new UnfurlMessageProvider();
    this.unsentChatTextDatastore = new UnsentChatTextDatastore();
    paramBuilder = DaggerHelper.getInstance();
    paramBuilder.initialize();
    paramBuilder.getMessengerSDKComponent().inject(this);
    ProviderManagerUtils.setupProviderManager();
    this.unfurlMessageProvider.setProvider(this.conversationProvider);
    this.unsentChatTextDatastore.setProvider(this.conversationProvider);
  }
  
  public BgsAuthProvider getBgsAuthProvider()
  {
    return this.bgsAuthProvider;
  }
  
  public ChatHistoryDatastore getChatHistoryDatastore()
  {
    return this.chatHistoryDatastore;
  }
  
  public ChatHistoryProvider getChatHistoryProvider()
  {
    return this.chatHistoryProvider;
  }
  
  public ConnectionProvider getConnectionProvider()
  {
    return this.connectionProvider;
  }
  
  public ConversationProvider getConversationProvider()
  {
    return this.conversationProvider;
  }
  
  public FriendsProvider getFriendsProvider()
  {
    return this.friendsProvider;
  }
  
  public PresenceProvider getPresenceProvider()
  {
    return this.presenceProvider;
  }
  
  public ProfileProvider getProfileProvider()
  {
    return this.profileProvider;
  }
  
  public PushNotificationProvider getPushNotificationProvider()
  {
    return this.pushNotificationProvider;
  }
  
  public SettingsProvider getSettingsProvider()
  {
    return this.settingsProvider;
  }
  
  public SuggestedFriendsProvider getSuggestedFriendsProvider()
  {
    return this.suggestedFriendsProvider;
  }
  
  public UnfurlMessageProvider getUnfurlMessageProvider()
  {
    return this.unfurlMessageProvider;
  }
  
  public UnsentChatTextDatastore getUnsentChatTextDatastore()
  {
    return this.unsentChatTextDatastore;
  }
  
  public void terminate() {}
  
  public static class Builder
  {
    private BgsAuthProvider bgsAuthProvider;
    private final Context context;
    private SettingsUpdateListener settingsUpdateListener;
    
    public Builder(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public BlizzardMessenger build()
    {
      return new BlizzardMessenger(this, null);
    }
    
    public Builder setBgsAuthProvider(BgsAuthProvider paramBgsAuthProvider)
    {
      this.bgsAuthProvider = paramBgsAuthProvider;
      return this;
    }
    
    public Builder setSettingsUpdateListener(SettingsUpdateListener paramSettingsUpdateListener)
    {
      this.settingsUpdateListener = paramSettingsUpdateListener;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/BlizzardMessenger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */