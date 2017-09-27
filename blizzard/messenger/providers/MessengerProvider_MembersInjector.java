package com.blizzard.messenger.providers;

import com.blizzard.messenger.data.model.chat.NewestMessageModel;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import com.blizzard.messenger.utils.ApplicationMonitor;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MessengerProvider_MembersInjector
  implements MembersInjector<MessengerProvider>
{
  private final Provider<ApplicationMonitor> applicationMonitorProvider;
  private final Provider<FriendRequestModel> friendRequestModelProvider;
  private final Provider<FriendsModel> friendsModelProvider;
  private final Provider<NewestMessageModel> newestMessageModelProvider;
  private final Provider<ProfileModel> profileModelProvider;
  private final Provider<SettingsModel> settingsModelProvider;
  private final Provider<SuggestedFriendsModel> suggestedFriendsModelProvider;
  private final Provider<UnseenConversationModel> unseenConversationModelProvider;
  
  static
  {
    if (!MessengerProvider_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public MessengerProvider_MembersInjector(Provider<ApplicationMonitor> paramProvider, Provider<FriendsModel> paramProvider1, Provider<FriendRequestModel> paramProvider2, Provider<NewestMessageModel> paramProvider3, Provider<ProfileModel> paramProvider4, Provider<UnseenConversationModel> paramProvider5, Provider<SettingsModel> paramProvider6, Provider<SuggestedFriendsModel> paramProvider7)
  {
    assert (paramProvider != null);
    this.applicationMonitorProvider = paramProvider;
    assert (paramProvider1 != null);
    this.friendsModelProvider = paramProvider1;
    assert (paramProvider2 != null);
    this.friendRequestModelProvider = paramProvider2;
    assert (paramProvider3 != null);
    this.newestMessageModelProvider = paramProvider3;
    assert (paramProvider4 != null);
    this.profileModelProvider = paramProvider4;
    assert (paramProvider5 != null);
    this.unseenConversationModelProvider = paramProvider5;
    assert (paramProvider6 != null);
    this.settingsModelProvider = paramProvider6;
    assert (paramProvider7 != null);
    this.suggestedFriendsModelProvider = paramProvider7;
  }
  
  public static MembersInjector<MessengerProvider> create(Provider<ApplicationMonitor> paramProvider, Provider<FriendsModel> paramProvider1, Provider<FriendRequestModel> paramProvider2, Provider<NewestMessageModel> paramProvider3, Provider<ProfileModel> paramProvider4, Provider<UnseenConversationModel> paramProvider5, Provider<SettingsModel> paramProvider6, Provider<SuggestedFriendsModel> paramProvider7)
  {
    return new MessengerProvider_MembersInjector(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7);
  }
  
  public static void injectApplicationMonitor(MessengerProvider paramMessengerProvider, Provider<ApplicationMonitor> paramProvider)
  {
    paramMessengerProvider.applicationMonitor = ((ApplicationMonitor)paramProvider.get());
  }
  
  public static void injectFriendRequestModel(MessengerProvider paramMessengerProvider, Provider<FriendRequestModel> paramProvider)
  {
    paramMessengerProvider.friendRequestModel = ((FriendRequestModel)paramProvider.get());
  }
  
  public static void injectFriendsModel(MessengerProvider paramMessengerProvider, Provider<FriendsModel> paramProvider)
  {
    paramMessengerProvider.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public static void injectNewestMessageModel(MessengerProvider paramMessengerProvider, Provider<NewestMessageModel> paramProvider)
  {
    paramMessengerProvider.newestMessageModel = ((NewestMessageModel)paramProvider.get());
  }
  
  public static void injectProfileModel(MessengerProvider paramMessengerProvider, Provider<ProfileModel> paramProvider)
  {
    paramMessengerProvider.profileModel = ((ProfileModel)paramProvider.get());
  }
  
  public static void injectSettingsModel(MessengerProvider paramMessengerProvider, Provider<SettingsModel> paramProvider)
  {
    paramMessengerProvider.settingsModel = ((SettingsModel)paramProvider.get());
  }
  
  public static void injectSuggestedFriendsModel(MessengerProvider paramMessengerProvider, Provider<SuggestedFriendsModel> paramProvider)
  {
    paramMessengerProvider.suggestedFriendsModel = ((SuggestedFriendsModel)paramProvider.get());
  }
  
  public static void injectUnseenConversationModel(MessengerProvider paramMessengerProvider, Provider<UnseenConversationModel> paramProvider)
  {
    paramMessengerProvider.unseenConversationModel = ((UnseenConversationModel)paramProvider.get());
  }
  
  public void injectMembers(MessengerProvider paramMessengerProvider)
  {
    if (paramMessengerProvider == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramMessengerProvider.applicationMonitor = ((ApplicationMonitor)this.applicationMonitorProvider.get());
    paramMessengerProvider.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
    paramMessengerProvider.friendRequestModel = ((FriendRequestModel)this.friendRequestModelProvider.get());
    paramMessengerProvider.newestMessageModel = ((NewestMessageModel)this.newestMessageModelProvider.get());
    paramMessengerProvider.profileModel = ((ProfileModel)this.profileModelProvider.get());
    paramMessengerProvider.unseenConversationModel = ((UnseenConversationModel)this.unseenConversationModelProvider.get());
    paramMessengerProvider.settingsModel = ((SettingsModel)this.settingsModelProvider.get());
    paramMessengerProvider.suggestedFriendsModel = ((SuggestedFriendsModel)this.suggestedFriendsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/providers/MessengerProvider_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */