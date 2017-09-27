package com.blizzard.messenger.helper;

import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SettingsHelper_MembersInjector
  implements MembersInjector<SettingsHelper>
{
  private final Provider<FriendsModel> friendsModelProvider;
  private final Provider<SettingsModel> settingsModelProvider;
  
  static
  {
    if (!SettingsHelper_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SettingsHelper_MembersInjector(Provider<SettingsModel> paramProvider, Provider<FriendsModel> paramProvider1)
  {
    assert (paramProvider != null);
    this.settingsModelProvider = paramProvider;
    assert (paramProvider1 != null);
    this.friendsModelProvider = paramProvider1;
  }
  
  public static MembersInjector<SettingsHelper> create(Provider<SettingsModel> paramProvider, Provider<FriendsModel> paramProvider1)
  {
    return new SettingsHelper_MembersInjector(paramProvider, paramProvider1);
  }
  
  public static void injectFriendsModel(SettingsHelper paramSettingsHelper, Provider<FriendsModel> paramProvider)
  {
    paramSettingsHelper.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public static void injectSettingsModel(SettingsHelper paramSettingsHelper, Provider<SettingsModel> paramProvider)
  {
    paramSettingsHelper.settingsModel = ((SettingsModel)paramProvider.get());
  }
  
  public void injectMembers(SettingsHelper paramSettingsHelper)
  {
    if (paramSettingsHelper == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramSettingsHelper.settingsModel = ((SettingsModel)this.settingsModelProvider.get());
    paramSettingsHelper.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/helper/SettingsHelper_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */