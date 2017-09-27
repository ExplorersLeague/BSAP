package com.blizzard.messenger.ui.base;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.helper.SettingsHelper;
import com.blizzard.messenger.utils.AnalyticsUtils;

public class BasePreferenceFragment
  extends PreferenceFragmentCompat
  implements Preference.OnPreferenceClickListener
{
  private SharedPreferences.OnSharedPreferenceChangeListener listener;
  private SettingsHelper settingsHelper;
  private SharedPreferences sharedPreferences;
  
  private void handlePreferenceClick(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramString.equals(getString(2131362170)))
    {
      this.settingsHelper.updateHideOfflineFriendsRules(Integer.valueOf(paramSharedPreferences.getString(paramString, "1")).intValue());
      return;
    }
    this.settingsHelper.updatePreference(paramString, paramSharedPreferences.getBoolean(paramString, true));
  }
  
  protected SettingsHelper getSettingsHelper()
  {
    return this.settingsHelper;
  }
  
  public void onCreatePreferences(Bundle paramBundle, String paramString)
  {
    this.settingsHelper = new SettingsHelper(getActivity());
    this.sharedPreferences = getPreferenceScreen().getSharedPreferences();
    if (SharedPrefsUtils.isLightThemeEnabled(getContext())) {
      getActivity().setTheme(2131558663);
    }
    AnalyticsUtils.trackScreenView(((MessengerApplication)getActivity().getApplication()).getDefaultTracker(), getActivity(), getClass().getSimpleName());
  }
  
  public void onPause()
  {
    super.onPause();
    this.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.listener);
    this.listener = null;
  }
  
  public boolean onPreferenceClick(Preference paramPreference)
  {
    handlePreferenceClick(this.sharedPreferences, paramPreference.getKey());
    return true;
  }
  
  public void onResume()
  {
    super.onResume();
    this.listener = BasePreferenceFragment..Lambda.1.lambdaFactory$(this);
    this.sharedPreferences.registerOnSharedPreferenceChangeListener(this.listener);
    setDivider(new ColorDrawable(0));
    setDividerHeight(0);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/base/BasePreferenceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */