package com.blizzard.messenger.ui.settings;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceManager;
import com.blizzard.messenger.ui.base.BasePreferenceFragment;

public class SupportFragment
  extends BasePreferenceFragment
{
  public static SupportFragment getInstance()
  {
    return new SupportFragment();
  }
  
  public void onCreatePreferences(Bundle paramBundle, String paramString)
  {
    addPreferencesFromResource(2131230726);
    super.onCreatePreferences(paramBundle, paramString);
    getPreferenceManager().findPreference(getString(2131362167)).setOnPreferenceClickListener(this);
    getPreferenceManager().findPreference(getString(2131362168)).setOnPreferenceClickListener(this);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/SupportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */