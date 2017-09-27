package com.blizzard.messenger.dagger;

import com.blizzard.messenger.data.model.chat.NewestMessageModel;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.data.model.push.PushNotificationModel;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ModelModule
{
  private final FriendRequestModel friendRequestModel;
  private final FriendsModel friendsModel;
  private final NewestMessageModel newestMessageModel;
  private final ProfileModel profileModel;
  private final PushNotificationModel pushNotificationModel;
  private final SettingsModel settingsModel;
  private final SuggestedFriendsModel suggestedFriendsModel;
  private final UnseenConversationModel unseenConversationModel;
  
  public ModelModule(FriendsModel paramFriendsModel, FriendRequestModel paramFriendRequestModel, ProfileModel paramProfileModel, NewestMessageModel paramNewestMessageModel, UnseenConversationModel paramUnseenConversationModel, SettingsModel paramSettingsModel, SuggestedFriendsModel paramSuggestedFriendsModel, PushNotificationModel paramPushNotificationModel)
  {
    this.friendsModel = paramFriendsModel;
    this.friendRequestModel = paramFriendRequestModel;
    this.profileModel = paramProfileModel;
    this.newestMessageModel = paramNewestMessageModel;
    this.unseenConversationModel = paramUnseenConversationModel;
    this.settingsModel = paramSettingsModel;
    this.suggestedFriendsModel = paramSuggestedFriendsModel;
    this.pushNotificationModel = paramPushNotificationModel;
  }
  
  @Provides
  @Singleton
  FriendRequestModel provideFriendRequestModel()
  {
    return this.friendRequestModel;
  }
  
  @Provides
  @Singleton
  FriendsModel provideFriendsModel()
  {
    return this.friendsModel;
  }
  
  @Provides
  @Singleton
  NewestMessageModel provideMessageExtentsModel()
  {
    return this.newestMessageModel;
  }
  
  @Provides
  @Singleton
  ProfileModel provideProfileModel()
  {
    return this.profileModel;
  }
  
  @Provides
  @Singleton
  PushNotificationModel providePushNotificationModel()
  {
    return this.pushNotificationModel;
  }
  
  @Provides
  @Singleton
  UnseenConversationModel provideSeenConversationModel()
  {
    return this.unseenConversationModel;
  }
  
  @Provides
  @Singleton
  SettingsModel provideSettingsModel()
  {
    return this.settingsModel;
  }
  
  @Provides
  @Singleton
  SuggestedFriendsModel provideSuggestedFriendsModel()
  {
    return this.suggestedFriendsModel;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/ModelModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */