package com.blizzard.messenger.ui.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.blizzard.messenger.databinding.LoginQueueActivityBinding;
import com.google.firebase.perf.metrics.AppStartTrace;

public class LoginQueueActivity
  extends AppCompatActivity
{
  private static final String TAG = LoginQueueActivity.class.getSimpleName();
  LoginQueueActivityBinding binding;
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.login.LoginQueueActivity");
    super.onCreate(paramBundle);
    this.binding = ((LoginQueueActivityBinding)DataBindingUtil.setContentView(this, 2130968655));
    this.binding.toolbar.setTitle(2131361944);
    setSupportActionBar(this.binding.toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    finish();
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.login.LoginQueueActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.login.LoginQueueActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/login/LoginQueueActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */