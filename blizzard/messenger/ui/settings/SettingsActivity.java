package com.blizzard.messenger.ui.settings;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.databinding.SettingsActivityBinding;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.ui.main.MainActivity;
import com.blizzard.messenger.utils.ColorUtils;
import com.google.firebase.perf.metrics.AppStartTrace;

public class SettingsActivity
  extends BaseActivity
{
  public static final String EXTRA_SETTING_TYPE = "com.blizzard.messenger.EXTRA_SETTING_TYPE";
  public static final String TYPE_ACCESSIBILITY = "Accessibility";
  public static final String TYPE_APP_SETTINGS = "AppSettings";
  public static final String TYPE_DEVELOPER_SETTINGS = "DeveloperSettings";
  public static final String TYPE_NOTIFICATIONS = "Notifications";
  public static final String TYPE_SUPPORT = "Support";
  private SettingsActivityBinding binding;
  
  private void checkForThemeChange()
  {
    if (SharedPrefsUtils.didThemeChange(this))
    {
      SharedPrefsUtils.setThemeChanged(this, false);
      Intent localIntent = new Intent(this, MainActivity.class);
      localIntent.setFlags(268468224);
      startActivity(localIntent);
      return;
    }
    finish();
  }
  
  public void onBackPressed()
  {
    checkForThemeChange();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.settings.SettingsActivity");
    super.onCreate(paramBundle);
    this.binding = ((SettingsActivityBinding)DataBindingUtil.setContentView(this, 2130968701));
    this.binding.toolbar.setTitleTextColor(ColorUtils.getTextColorActionBarTitle(this));
    setSupportActionBar(this.binding.toolbar);
    setTitle(getString(2131361957));
    setDisplayHomeAsUpEnabled(true);
    setHomeButtonEnabled(true);
    paramBundle = getIntent().getExtras().getString("com.blizzard.messenger.EXTRA_SETTING_TYPE");
    int i = -1;
    Object localObject;
    switch (paramBundle.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        localObject = null;
        paramBundle = null;
      }
      break;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setTitle((CharSequence)localObject);
      }
      if (paramBundle != null) {
        getSupportFragmentManager().beginTransaction().replace(this.binding.content.getId(), paramBundle).commit();
      }
      return;
      if (!paramBundle.equals("Accessibility")) {
        break;
      }
      i = 0;
      break;
      if (!paramBundle.equals("DeveloperSettings")) {
        break;
      }
      i = 1;
      break;
      if (!paramBundle.equals("AppSettings")) {
        break;
      }
      i = 2;
      break;
      if (!paramBundle.equals("Notifications")) {
        break;
      }
      i = 3;
      break;
      if (!paramBundle.equals("Support")) {
        break;
      }
      i = 4;
      break;
      localObject = getString(2131362030);
      paramBundle = AccessibilityFragment.getInstance();
      continue;
      localObject = "Developer Settings";
      paramBundle = DeveloperSettingsFragment.getInstance();
      continue;
      localObject = getString(2131362032);
      paramBundle = AppSettingsFragment.getInstance();
      continue;
      localObject = getString(2131362035);
      paramBundle = NotificationsFragment.getInstance();
      continue;
      localObject = getString(2131362036);
      paramBundle = SupportFragment.getInstance();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      checkForThemeChange();
    }
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.settings.SettingsActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.settings.SettingsActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/SettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */