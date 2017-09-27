package com.blizzard.messenger.views.dialog;

import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FriendRequestDialogFragment_MembersInjector
  implements MembersInjector<FriendRequestDialogFragment>
{
  private final Provider<FriendsModel> friendsModelProvider;
  private final Provider<ProfileModel> profileModelProvider;
  
  static
  {
    if (!FriendRequestDialogFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FriendRequestDialogFragment_MembersInjector(Provider<FriendsModel> paramProvider, Provider<ProfileModel> paramProvider1)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
    assert (paramProvider1 != null);
    this.profileModelProvider = paramProvider1;
  }
  
  public static MembersInjector<FriendRequestDialogFragment> create(Provider<FriendsModel> paramProvider, Provider<ProfileModel> paramProvider1)
  {
    return new FriendRequestDialogFragment_MembersInjector(paramProvider, paramProvider1);
  }
  
  public static void injectFriendsModel(FriendRequestDialogFragment paramFriendRequestDialogFragment, Provider<FriendsModel> paramProvider)
  {
    paramFriendRequestDialogFragment.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public static void injectProfileModel(FriendRequestDialogFragment paramFriendRequestDialogFragment, Provider<ProfileModel> paramProvider)
  {
    paramFriendRequestDialogFragment.profileModel = ((ProfileModel)paramProvider.get());
  }
  
  public void injectMembers(FriendRequestDialogFragment paramFriendRequestDialogFragment)
  {
    if (paramFriendRequestDialogFragment == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramFriendRequestDialogFragment.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
    paramFriendRequestDialogFragment.profileModel = ((ProfileModel)this.profileModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/views/dialog/FriendRequestDialogFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */