package com.blizzard.messenger.ui.settings;

import com.blizzard.messenger.data.model.settings.SettingsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AppSettingsFragment_MembersInjector
  implements MembersInjector<AppSettingsFragment>
{
  private final Provider<SettingsModel> settingsModelProvider;
  
  static
  {
    if (!AppSettingsFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public AppSettingsFragment_MembersInjector(Provider<SettingsModel> paramProvider)
  {
    assert (paramProvider != null);
    this.settingsModelProvider = paramProvider;
  }
  
  public static MembersInjector<AppSettingsFragment> create(Provider<SettingsModel> paramProvider)
  {
    return new AppSettingsFragment_MembersInjector(paramProvider);
  }
  
  public static void injectSettingsModel(AppSettingsFragment paramAppSettingsFragment, Provider<SettingsModel> paramProvider)
  {
    paramAppSettingsFragment.settingsModel = ((SettingsModel)paramProvider.get());
  }
  
  public void injectMembers(AppSettingsFragment paramAppSettingsFragment)
  {
    if (paramAppSettingsFragment == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramAppSettingsFragment.settingsModel = ((SettingsModel)this.settingsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/AppSettingsFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */