package com.blizzard.messenger.ui.friends.management;

import com.blizzard.messenger.data.model.friends.FriendsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ReportUserActivity_MembersInjector
  implements MembersInjector<ReportUserActivity>
{
  private final Provider<FriendsModel> friendsModelProvider;
  
  static
  {
    if (!ReportUserActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReportUserActivity_MembersInjector(Provider<FriendsModel> paramProvider)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
  }
  
  public static MembersInjector<ReportUserActivity> create(Provider<FriendsModel> paramProvider)
  {
    return new ReportUserActivity_MembersInjector(paramProvider);
  }
  
  public static void injectFriendsModel(ReportUserActivity paramReportUserActivity, Provider<FriendsModel> paramProvider)
  {
    paramReportUserActivity.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public void injectMembers(ReportUserActivity paramReportUserActivity)
  {
    if (paramReportUserActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramReportUserActivity.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/ReportUserActivity_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */