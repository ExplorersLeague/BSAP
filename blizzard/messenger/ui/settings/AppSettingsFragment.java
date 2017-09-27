package com.blizzard.messenger.ui.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.SwitchPreferenceCompat;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.settings.Settings;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import com.blizzard.messenger.helper.SettingsHelper;
import com.blizzard.messenger.ui.base.BasePreferenceFragment;
import javax.inject.Inject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class AppSettingsFragment
  extends BasePreferenceFragment
{
  private CompositeSubscription allSubscriptions;
  private ListPreference hideOfflineListPreference;
  @Inject
  SettingsModel settingsModel;
  
  public static AppSettingsFragment getInstance()
  {
    return new AppSettingsFragment();
  }
  
  private void onSettingsUpdated(@Nullable Settings paramSettings)
  {
    boolean bool = false;
    Object localObject = getString(2131362166);
    localObject = (SwitchPreferenceCompat)getPreferenceScreen().findPreference((CharSequence)localObject);
    if (paramSettings != null)
    {
      ((SwitchPreferenceCompat)localObject).setChecked(this.settingsModel.getSettings().isMatureLangaugeFiltered());
      if (!this.settingsModel.getSettings().isHideMatureLanguageFilter()) {
        bool = true;
      }
      ((SwitchPreferenceCompat)localObject).setVisible(bool);
      return;
    }
    ((SwitchPreferenceCompat)localObject).setChecked(false);
    ((SwitchPreferenceCompat)localObject).setVisible(false);
  }
  
  private void updateHideOfflineSummary(Integer paramInteger)
  {
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 0: 
      this.hideOfflineListPreference.setSummary(getString(2131361937));
      return;
    case 1: 
      this.hideOfflineListPreference.setSummary(getString(2131361940));
      return;
    }
    this.hideOfflineListPreference.setSummary(getString(2131361941));
  }
  
  private void updateTheme(Void paramVoid)
  {
    getActivity().recreate();
  }
  
  public void onCreatePreferences(Bundle paramBundle, String paramString)
  {
    ((MessengerApplication)getActivity().getApplication()).getModelComponent().inject(this);
    addPreferencesFromResource(2131230722);
    super.onCreatePreferences(paramBundle, paramString);
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
  }
  
  public void onResume()
  {
    super.onResume();
    this.allSubscriptions = new CompositeSubscription();
    this.allSubscriptions.add(getSettingsHelper().onThemeChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(AppSettingsFragment..Lambda.1.lambdaFactory$(this)));
    this.allSubscriptions.add(this.settingsModel.onSettingsUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(AppSettingsFragment..Lambda.2.lambdaFactory$(this)));
    this.allSubscriptions.add(getSettingsHelper().onHideOfflineValueChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(AppSettingsFragment..Lambda.3.lambdaFactory$(this), AppSettingsFragment..Lambda.4.lambdaFactory$()));
    String str = getString(2131362170);
    this.hideOfflineListPreference = ((ListPreference)getPreferenceScreen().findPreference(str));
    updateHideOfflineSummary(Integer.valueOf(this.hideOfflineListPreference.getValue()));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/AppSettingsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */