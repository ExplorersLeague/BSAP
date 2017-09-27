package com.blizzard.messenger.ui.welcome;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blizzard.messenger.databinding.RequestPermissionsActivityBinding;
import com.blizzard.messenger.ui.SplashActivity;
import com.blizzard.messenger.utils.PermissionUtils;
import com.google.firebase.perf.metrics.AppStartTrace;

public class RequestPermissionsActivity
  extends AppCompatActivity
{
  private void askForNeteasePermissions()
  {
    if (!PermissionUtils.hasNeteasePermissions(this))
    {
      PermissionUtils.requestNeteasePermissions(this);
      return;
    }
    startLoginAttempt();
  }
  
  private void startLoginAttempt()
  {
    startActivity(SplashActivity.newIntent(this, true));
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.welcome.RequestPermissionsActivity");
    super.onCreate(paramBundle);
    paramBundle = (RequestPermissionsActivityBinding)DataBindingUtil.setContentView(this, 2130968695);
    paramBundle.askMeLaterTextView.setOnClickListener(RequestPermissionsActivity..Lambda.1.lambdaFactory$(this));
    paramBundle.enablePushLinearLayout.setOnClickListener(RequestPermissionsActivity..Lambda.2.lambdaFactory$(this));
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    startLoginAttempt();
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.welcome.RequestPermissionsActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.welcome.RequestPermissionsActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/welcome/RequestPermissionsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */