package com.blizzard.messenger.ui.error;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.blizzard.messenger.databinding.AccountMuteActivityBinding;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.ui.welcome.WelcomeActivity;
import com.google.firebase.perf.metrics.AppStartTrace;

public class AccountMuteActivity
  extends BaseActivity
{
  private static final String TAG = AccountMuteActivity.class.getSimpleName();
  
  private void showWelcomeScreens()
  {
    Intent localIntent = new Intent(this, WelcomeActivity.class);
    localIntent.setFlags(268468224);
    startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.error.AccountMuteActivity");
    super.onCreate(paramBundle);
    ((AccountMuteActivityBinding)DataBindingUtil.setContentView(this, 2130968604)).buttonLinearLayout.setOnClickListener(AccountMuteActivity..Lambda.1.lambdaFactory$(this));
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.error.AccountMuteActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.error.AccountMuteActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/error/AccountMuteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */