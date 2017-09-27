package com.blizzard.messenger.ui.friends;

import com.blizzard.messenger.data.model.friends.FriendsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ViewFriendsActivity_MembersInjector
  implements MembersInjector<ViewFriendsActivity>
{
  private final Provider<FriendsModel> friendsModelProvider;
  
  static
  {
    if (!ViewFriendsActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ViewFriendsActivity_MembersInjector(Provider<FriendsModel> paramProvider)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
  }
  
  public static MembersInjector<ViewFriendsActivity> create(Provider<FriendsModel> paramProvider)
  {
    return new ViewFriendsActivity_MembersInjector(paramProvider);
  }
  
  public static void injectFriendsModel(ViewFriendsActivity paramViewFriendsActivity, Provider<FriendsModel> paramProvider)
  {
    paramViewFriendsActivity.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public void injectMembers(ViewFriendsActivity paramViewFriendsActivity)
  {
    if (paramViewFriendsActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramViewFriendsActivity.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/ViewFriendsActivity_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */