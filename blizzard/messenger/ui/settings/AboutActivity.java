package com.blizzard.messenger.ui.settings;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.databinding.AboutActivityBinding;
import com.blizzard.messenger.helper.SettingsHelper;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.utils.ColorUtils;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.util.Calendar;

public class AboutActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private SettingsHelper settingsHelper;
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131820686: 
      this.settingsHelper.showPrivacyPolicy(this);
      return;
    case 2131820687: 
      this.settingsHelper.showTermsOfService(this);
      return;
    }
    startActivity(new Intent(this, LicensesActivity.class));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.settings.AboutActivity");
    super.onCreate(paramBundle);
    paramBundle = (AboutActivityBinding)DataBindingUtil.setContentView(this, 2130968603);
    paramBundle.toolbar.setTitleTextColor(ColorUtils.getTextColorActionBarTitle(this));
    if (SharedPrefsUtils.isLightThemeEnabled(this)) {
      paramBundle.toolbar.setPopupTheme(2131558668);
    }
    for (;;)
    {
      setSupportActionBar(paramBundle.toolbar);
      setTitle(getString(2131361830));
      setDisplayHomeAsUpEnabled(true);
      setHomeButtonEnabled(true);
      paramBundle.appVersionTextView.setText(String.format(getString(2131361883), new Object[] { "1.0.0.12" }) + " (" + 10012 + ")");
      paramBundle.copyrightTextView.setText(String.format(getString(2131361889), new Object[] { String.valueOf(Calendar.getInstance().get(1)) }));
      paramBundle.privacyPolicyTextView.setOnClickListener(this);
      paramBundle.termsOfServiceTextView.setOnClickListener(this);
      paramBundle.openSourceLicensesTextView.setOnClickListener(this);
      this.settingsHelper = new SettingsHelper(this);
      return;
      paramBundle.toolbar.setPopupTheme(2131558667);
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
      finish();
    }
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.settings.AboutActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.settings.AboutActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/AboutActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */