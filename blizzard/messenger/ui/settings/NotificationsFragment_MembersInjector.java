package com.blizzard.messenger.ui.settings;

import com.blizzard.messenger.data.model.settings.SettingsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class NotificationsFragment_MembersInjector
  implements MembersInjector<NotificationsFragment>
{
  private final Provider<SettingsModel> settingsModelProvider;
  
  static
  {
    if (!NotificationsFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public NotificationsFragment_MembersInjector(Provider<SettingsModel> paramProvider)
  {
    assert (paramProvider != null);
    this.settingsModelProvider = paramProvider;
  }
  
  public static MembersInjector<NotificationsFragment> create(Provider<SettingsModel> paramProvider)
  {
    return new NotificationsFragment_MembersInjector(paramProvider);
  }
  
  public static void injectSettingsModel(NotificationsFragment paramNotificationsFragment, Provider<SettingsModel> paramProvider)
  {
    paramNotificationsFragment.settingsModel = ((SettingsModel)paramProvider.get());
  }
  
  public void injectMembers(NotificationsFragment paramNotificationsFragment)
  {
    if (paramNotificationsFragment == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramNotificationsFragment.settingsModel = ((SettingsModel)this.settingsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/NotificationsFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */