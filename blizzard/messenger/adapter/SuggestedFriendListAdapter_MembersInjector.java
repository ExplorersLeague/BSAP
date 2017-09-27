package com.blizzard.messenger.adapter;

import com.blizzard.messenger.data.model.friends.FriendsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SuggestedFriendListAdapter_MembersInjector
  implements MembersInjector<SuggestedFriendListAdapter>
{
  private final Provider<FriendsModel> friendsModelProvider;
  
  static
  {
    if (!SuggestedFriendListAdapter_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SuggestedFriendListAdapter_MembersInjector(Provider<FriendsModel> paramProvider)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
  }
  
  public static MembersInjector<SuggestedFriendListAdapter> create(Provider<FriendsModel> paramProvider)
  {
    return new SuggestedFriendListAdapter_MembersInjector(paramProvider);
  }
  
  public static void injectFriendsModel(SuggestedFriendListAdapter paramSuggestedFriendListAdapter, Provider<FriendsModel> paramProvider)
  {
    paramSuggestedFriendListAdapter.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public void injectMembers(SuggestedFriendListAdapter paramSuggestedFriendListAdapter)
  {
    if (paramSuggestedFriendListAdapter == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramSuggestedFriendListAdapter.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/SuggestedFriendListAdapter_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */