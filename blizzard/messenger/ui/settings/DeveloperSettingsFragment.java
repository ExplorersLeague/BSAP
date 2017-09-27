package com.blizzard.messenger.ui.settings;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceManager;
import com.blizzard.messenger.ui.base.BasePreferenceFragment;

public class DeveloperSettingsFragment
  extends BasePreferenceFragment
{
  public static DeveloperSettingsFragment getInstance()
  {
    return new DeveloperSettingsFragment();
  }
  
  public void onCreatePreferences(Bundle paramBundle, String paramString)
  {
    addPreferencesFromResource(2131230723);
    super.onCreatePreferences(paramBundle, paramString);
    getPreferenceManager().findPreference(getString(2131362181)).setOnPreferenceClickListener(this);
    getPreferenceManager().findPreference(getString(2131362182)).setOnPreferenceClickListener(this);
    getPreferenceManager().findPreference(getString(2131362176)).setOnPreferenceClickListener(this);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/DeveloperSettingsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */