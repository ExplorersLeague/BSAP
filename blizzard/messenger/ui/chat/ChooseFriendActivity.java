package com.blizzard.messenger.ui.chat;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.databinding.ChooseFriendActivityBinding;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.ui.friends.FriendsListFragment;
import com.google.firebase.perf.metrics.AppStartTrace;

public class ChooseFriendActivity
  extends BaseActivity
{
  private ChooseFriendActivityBinding binding;
  
  private void initialize()
  {
    this.binding = ((ChooseFriendActivityBinding)DataBindingUtil.setContentView(this, 2130968616));
    ((MessengerApplication)getApplication()).getModelComponent().inject(this);
    setupActionBar();
    FriendsListFragment localFriendsListFragment = FriendsListFragment.newInstance(true);
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(this.binding.content.getId(), localFriendsListFragment, "FriendsListFragment");
    localFragmentTransaction.commit();
  }
  
  private void setupActionBar()
  {
    setSupportActionBar(this.binding.toolbar);
    setTitle(getString(2131362039));
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.chat.ChooseFriendActivity");
    super.onCreate(paramBundle);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    navigateUp();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.chat.ChooseFriendActivity");
    super.onResume();
    initialize();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.chat.ChooseFriendActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/chat/ChooseFriendActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */