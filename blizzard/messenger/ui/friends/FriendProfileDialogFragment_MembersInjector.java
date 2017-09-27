package com.blizzard.messenger.ui.friends;

import com.blizzard.messenger.data.model.friends.FriendsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FriendProfileDialogFragment_MembersInjector
  implements MembersInjector<FriendProfileDialogFragment>
{
  private final Provider<FriendsModel> friendsModelProvider;
  
  static
  {
    if (!FriendProfileDialogFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FriendProfileDialogFragment_MembersInjector(Provider<FriendsModel> paramProvider)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
  }
  
  public static MembersInjector<FriendProfileDialogFragment> create(Provider<FriendsModel> paramProvider)
  {
    return new FriendProfileDialogFragment_MembersInjector(paramProvider);
  }
  
  public static void injectFriendsModel(FriendProfileDialogFragment paramFriendProfileDialogFragment, Provider<FriendsModel> paramProvider)
  {
    paramFriendProfileDialogFragment.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public void injectMembers(FriendProfileDialogFragment paramFriendProfileDialogFragment)
  {
    if (paramFriendProfileDialogFragment == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramFriendProfileDialogFragment.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/FriendProfileDialogFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */