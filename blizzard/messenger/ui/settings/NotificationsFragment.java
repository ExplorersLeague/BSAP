package com.blizzard.messenger.ui.settings;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.SwitchPreferenceCompat;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.settings.Settings;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import com.blizzard.messenger.ui.base.BasePreferenceFragment;
import javax.inject.Inject;

public class NotificationsFragment
  extends BasePreferenceFragment
{
  @Inject
  SettingsModel settingsModel;
  
  public static NotificationsFragment getInstance()
  {
    return new NotificationsFragment();
  }
  
  private void initialize()
  {
    String str = getString(2131362174);
    Object localObject = getString(2131362173);
    localObject = (SwitchPreferenceCompat)getPreferenceScreen().findPreference((CharSequence)localObject);
    ((SwitchPreferenceCompat)getPreferenceScreen().findPreference(str)).setChecked(this.settingsModel.getSettings().isWhisperNotificationsEnabled());
    ((SwitchPreferenceCompat)localObject).setChecked(this.settingsModel.getSettings().isFriendRequestNotificationsEnabled());
  }
  
  public void onCreatePreferences(Bundle paramBundle, String paramString)
  {
    ((MessengerApplication)getActivity().getApplication()).getModelComponent().inject(this);
    addPreferencesFromResource(2131230725);
    super.onCreatePreferences(paramBundle, paramString);
    initialize();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/NotificationsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */