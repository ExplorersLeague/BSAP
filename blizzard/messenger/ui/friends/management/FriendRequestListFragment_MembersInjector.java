package com.blizzard.messenger.ui.friends.management;

import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FriendRequestListFragment_MembersInjector
  implements MembersInjector<FriendRequestListFragment>
{
  private final Provider<FriendRequestModel> friendRequestModelProvider;
  
  static
  {
    if (!FriendRequestListFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FriendRequestListFragment_MembersInjector(Provider<FriendRequestModel> paramProvider)
  {
    assert (paramProvider != null);
    this.friendRequestModelProvider = paramProvider;
  }
  
  public static MembersInjector<FriendRequestListFragment> create(Provider<FriendRequestModel> paramProvider)
  {
    return new FriendRequestListFragment_MembersInjector(paramProvider);
  }
  
  public static void injectFriendRequestModel(FriendRequestListFragment paramFriendRequestListFragment, Provider<FriendRequestModel> paramProvider)
  {
    paramFriendRequestListFragment.friendRequestModel = ((FriendRequestModel)paramProvider.get());
  }
  
  public void injectMembers(FriendRequestListFragment paramFriendRequestListFragment)
  {
    if (paramFriendRequestListFragment == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramFriendRequestListFragment.friendRequestModel = ((FriendRequestModel)this.friendRequestModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/FriendRequestListFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */