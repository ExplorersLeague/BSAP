package com.blizzard.messenger.ui.friends;

import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FriendsListFragment_MembersInjector
  implements MembersInjector<FriendsListFragment>
{
  private final Provider<FriendRequestModel> friendRequestModelProvider;
  private final Provider<FriendsModel> friendsModelProvider;
  private final Provider<ProfileModel> profileModelProvider;
  
  static
  {
    if (!FriendsListFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FriendsListFragment_MembersInjector(Provider<FriendsModel> paramProvider, Provider<FriendRequestModel> paramProvider1, Provider<ProfileModel> paramProvider2)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
    assert (paramProvider1 != null);
    this.friendRequestModelProvider = paramProvider1;
    assert (paramProvider2 != null);
    this.profileModelProvider = paramProvider2;
  }
  
  public static MembersInjector<FriendsListFragment> create(Provider<FriendsModel> paramProvider, Provider<FriendRequestModel> paramProvider1, Provider<ProfileModel> paramProvider2)
  {
    return new FriendsListFragment_MembersInjector(paramProvider, paramProvider1, paramProvider2);
  }
  
  public static void injectFriendRequestModel(FriendsListFragment paramFriendsListFragment, Provider<FriendRequestModel> paramProvider)
  {
    paramFriendsListFragment.friendRequestModel = ((FriendRequestModel)paramProvider.get());
  }
  
  public static void injectFriendsModel(FriendsListFragment paramFriendsListFragment, Provider<FriendsModel> paramProvider)
  {
    paramFriendsListFragment.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public static void injectProfileModel(FriendsListFragment paramFriendsListFragment, Provider<ProfileModel> paramProvider)
  {
    paramFriendsListFragment.profileModel = ((ProfileModel)paramProvider.get());
  }
  
  public void injectMembers(FriendsListFragment paramFriendsListFragment)
  {
    if (paramFriendsListFragment == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramFriendsListFragment.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
    paramFriendsListFragment.friendRequestModel = ((FriendRequestModel)this.friendRequestModelProvider.get());
    paramFriendsListFragment.profileModel = ((ProfileModel)this.profileModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/FriendsListFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */