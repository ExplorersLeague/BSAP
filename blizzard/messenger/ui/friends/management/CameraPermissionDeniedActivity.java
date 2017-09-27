package com.blizzard.messenger.ui.friends.management;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.blizzard.messenger.databinding.CameraPermissionDeniedActivityBinding;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.google.firebase.perf.metrics.AppStartTrace;

public class CameraPermissionDeniedActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.friends.management.CameraPermissionDeniedActivity");
    super.onCreate(paramBundle);
    ((CameraPermissionDeniedActivityBinding)DataBindingUtil.setContentView(this, 2130968608)).appPermissionsLayout.setOnClickListener(CameraPermissionDeniedActivity..Lambda.1.lambdaFactory$(this));
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.friends.management.CameraPermissionDeniedActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.friends.management.CameraPermissionDeniedActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/CameraPermissionDeniedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */