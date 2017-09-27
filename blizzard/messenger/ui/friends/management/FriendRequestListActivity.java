package com.blizzard.messenger.ui.friends.management;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.blizzard.messenger.databinding.FriendRequestListActivityBinding;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.utils.ColorUtils;
import com.google.firebase.perf.metrics.AppStartTrace;

public final class FriendRequestListActivity
  extends BaseActivity
{
  public static Intent newIntent(@NonNull Context paramContext)
  {
    return new Intent(paramContext, FriendRequestListActivity.class);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.friends.management.FriendRequestListActivity");
    super.onCreate(paramBundle);
    setStatusBarColor(ColorUtils.getColorPrimaryDark(this));
    paramBundle = (FriendRequestListActivityBinding)DataBindingUtil.setContentView(this, 2130968643);
    setSupportActionBar(paramBundle.toolbar);
    setTitle(getResources().getString(2131361930));
    setDisplayHomeAsUpEnabled(true);
    setHomeButtonEnabled(true);
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(paramBundle.content.getId(), FriendRequestListFragment.newInstance());
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      navigateUp();
    }
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.friends.management.FriendRequestListActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.friends.management.FriendRequestListActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/FriendRequestListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */