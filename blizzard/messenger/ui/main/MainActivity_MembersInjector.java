package com.blizzard.messenger.ui.main;

import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector
  implements MembersInjector<MainActivity>
{
  private final Provider<FriendRequestModel> friendRequestModelProvider;
  private final Provider<FriendsModel> friendsModelProvider;
  private final Provider<UnseenConversationModel> unseenConversationModelProvider;
  
  static
  {
    if (!MainActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public MainActivity_MembersInjector(Provider<FriendsModel> paramProvider, Provider<FriendRequestModel> paramProvider1, Provider<UnseenConversationModel> paramProvider2)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
    assert (paramProvider1 != null);
    this.friendRequestModelProvider = paramProvider1;
    assert (paramProvider2 != null);
    this.unseenConversationModelProvider = paramProvider2;
  }
  
  public static MembersInjector<MainActivity> create(Provider<FriendsModel> paramProvider, Provider<FriendRequestModel> paramProvider1, Provider<UnseenConversationModel> paramProvider2)
  {
    return new MainActivity_MembersInjector(paramProvider, paramProvider1, paramProvider2);
  }
  
  public static void injectFriendRequestModel(MainActivity paramMainActivity, Provider<FriendRequestModel> paramProvider)
  {
    paramMainActivity.friendRequestModel = ((FriendRequestModel)paramProvider.get());
  }
  
  public static void injectFriendsModel(MainActivity paramMainActivity, Provider<FriendsModel> paramProvider)
  {
    paramMainActivity.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public static void injectUnseenConversationModel(MainActivity paramMainActivity, Provider<UnseenConversationModel> paramProvider)
  {
    paramMainActivity.unseenConversationModel = ((UnseenConversationModel)paramProvider.get());
  }
  
  public void injectMembers(MainActivity paramMainActivity)
  {
    if (paramMainActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramMainActivity.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
    paramMainActivity.friendRequestModel = ((FriendRequestModel)this.friendRequestModelProvider.get());
    paramMainActivity.unseenConversationModel = ((UnseenConversationModel)this.unseenConversationModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/main/MainActivity_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */