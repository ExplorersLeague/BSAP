package com.blizzard.messenger.receivers;

import com.blizzard.messenger.data.model.settings.SettingsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LocaleChangedReceiver_MembersInjector
  implements MembersInjector<LocaleChangedReceiver>
{
  private final Provider<SettingsModel> settingsModelProvider;
  
  static
  {
    if (!LocaleChangedReceiver_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public LocaleChangedReceiver_MembersInjector(Provider<SettingsModel> paramProvider)
  {
    assert (paramProvider != null);
    this.settingsModelProvider = paramProvider;
  }
  
  public static MembersInjector<LocaleChangedReceiver> create(Provider<SettingsModel> paramProvider)
  {
    return new LocaleChangedReceiver_MembersInjector(paramProvider);
  }
  
  public static void injectSettingsModel(LocaleChangedReceiver paramLocaleChangedReceiver, Provider<SettingsModel> paramProvider)
  {
    paramLocaleChangedReceiver.settingsModel = ((SettingsModel)paramProvider.get());
  }
  
  public void injectMembers(LocaleChangedReceiver paramLocaleChangedReceiver)
  {
    if (paramLocaleChangedReceiver == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramLocaleChangedReceiver.settingsModel = ((SettingsModel)this.settingsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/receivers/LocaleChangedReceiver_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */