package com.blizzard.messenger.ui.friends.management;

import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FindFriendsActivity_MembersInjector
  implements MembersInjector<FindFriendsActivity>
{
  private final Provider<ProfileModel> profileModelProvider;
  private final Provider<SuggestedFriendsModel> suggestedFriendsModelProvider;
  
  static
  {
    if (!FindFriendsActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FindFriendsActivity_MembersInjector(Provider<SuggestedFriendsModel> paramProvider, Provider<ProfileModel> paramProvider1)
  {
    assert (paramProvider != null);
    this.suggestedFriendsModelProvider = paramProvider;
    assert (paramProvider1 != null);
    this.profileModelProvider = paramProvider1;
  }
  
  public static MembersInjector<FindFriendsActivity> create(Provider<SuggestedFriendsModel> paramProvider, Provider<ProfileModel> paramProvider1)
  {
    return new FindFriendsActivity_MembersInjector(paramProvider, paramProvider1);
  }
  
  public static void injectProfileModel(FindFriendsActivity paramFindFriendsActivity, Provider<ProfileModel> paramProvider)
  {
    paramFindFriendsActivity.profileModel = ((ProfileModel)paramProvider.get());
  }
  
  public static void injectSuggestedFriendsModel(FindFriendsActivity paramFindFriendsActivity, Provider<SuggestedFriendsModel> paramProvider)
  {
    paramFindFriendsActivity.suggestedFriendsModel = ((SuggestedFriendsModel)paramProvider.get());
  }
  
  public void injectMembers(FindFriendsActivity paramFindFriendsActivity)
  {
    if (paramFindFriendsActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramFindFriendsActivity.suggestedFriendsModel = ((SuggestedFriendsModel)this.suggestedFriendsModelProvider.get());
    paramFindFriendsActivity.profileModel = ((ProfileModel)this.profileModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/FindFriendsActivity_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */