package com.blizzard.messenger.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blizzard.messenger.adapter.NavigationPagerAdapter;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.databinding.MainActivityBinding;
import com.blizzard.messenger.listeners.NavigationPageChangeListener;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import rx.Completable;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity
  extends BaseActivity
{
  private static final int PAGE_CONVERSATIONS = 1;
  private static final int PAGE_DEFAULT = 0;
  private static final int PAGE_FRIENDS = 0;
  private static final int PAGE_PROFILE = 2;
  private static final String TAG = MainActivity.class.getSimpleName();
  private static final String VIEW_PAGER_CURRENT_PAGE = "ViewPagerCurrentPage";
  private CompositeSubscription allSubscriptions;
  private MainActivityBinding binding;
  private int currentPage = 0;
  @Inject
  FriendRequestModel friendRequestModel;
  @Inject
  FriendsModel friendsModel;
  private Subscription noNetworkSubscription;
  private int onlineCount;
  private NavigationPageChangeListener pageChangeListener = new NavigationPageChangeListener();
  @Inject
  UnseenConversationModel unseenConversationModel;
  
  private void getOnlineFriendCount(List<Friend> paramList)
  {
    this.onlineCount = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Friend)paramList.next()).getStatus() != 5) {
        this.onlineCount += 1;
      }
    }
    updateTitle();
  }
  
  private View getTabBadgeIcon(int paramInt)
  {
    return this.binding.tabs.getTabAt(paramInt).getCustomView().findViewById(2131820883);
  }
  
  private void initializeTab(int paramInt1, int paramInt2)
  {
    TabLayout.Tab localTab = this.binding.tabs.getTabAt(paramInt1);
    localTab.setCustomView(2130968711);
    ((ImageView)localTab.getCustomView().findViewById(2131820882)).setImageResource(paramInt2);
  }
  
  public static Intent newIntent(@NonNull Context paramContext)
  {
    return new Intent(paramContext, MainActivity.class);
  }
  
  private void onPageSelected(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.currentPage = paramInt;
      updateTitle();
      this.binding.appBarLayout.setExpanded(true);
      return;
      updateFriendsBadge(false);
      continue;
      updateConversationsBadge(false);
    }
  }
  
  private void setupTabIcons()
  {
    initializeTab(0, 2130837732);
    initializeTab(1, 2130837731);
    initializeTab(2, 2130837733);
  }
  
  private void setupViewPager()
  {
    this.binding.viewPager.setAdapter(new NavigationPagerAdapter(getSupportFragmentManager()));
    this.binding.tabs.setupWithViewPager(this.binding.viewPager);
    this.binding.viewPager.addOnPageChangeListener(this.pageChangeListener);
  }
  
  private void showNetworkAvailability(String paramString)
  {
    boolean bool = paramString.equals("com.blizzard.messenger.CONNECTED");
    if (this.noNetworkSubscription != null)
    {
      this.noNetworkSubscription.unsubscribe();
      this.noNetworkSubscription = null;
    }
    if ((bool) && (this.binding.noNetworkTextView.getVisibility() == 0)) {
      this.binding.noNetworkTextView.setVisibility(8);
    }
    while ((bool) || (this.binding.noNetworkTextView.getVisibility() != 8)) {
      return;
    }
    this.noNetworkSubscription = Completable.timer(3000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(MainActivity..Lambda.8.lambdaFactory$(this));
  }
  
  private void updateConversationsBadge(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.currentPage != 1))
    {
      getTabBadgeIcon(1).setVisibility(0);
      return;
    }
    getTabBadgeIcon(1).setVisibility(4);
  }
  
  private void updateFriendsBadge(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.currentPage != 0))
    {
      getTabBadgeIcon(0).setVisibility(0);
      return;
    }
    getTabBadgeIcon(0).setVisibility(4);
  }
  
  private void updateTitle()
  {
    if (this.currentPage == 0)
    {
      setTitle(String.format(getResources().getString(2131361933), new Object[] { Integer.valueOf(this.onlineCount) }));
      return;
    }
    if (this.currentPage == 1)
    {
      setTitle(getString(2131362060));
      return;
    }
    if (this.currentPage == 2)
    {
      setTitle(getString(2131361996));
      return;
    }
    setTitle("");
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    MessengerProvider.getInstance().disconnect();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.main.MainActivity");
    super.onCreate(paramBundle);
    setShowSnackbar(false);
    this.binding = ((MainActivityBinding)DataBindingUtil.setContentView(this, 2130968656));
    setSupportActionBar(this.binding.toolbar);
    paramBundle = (MessengerApplication)getApplication();
    if (paramBundle.getModelComponent() != null) {
      paramBundle.getModelComponent().inject(this);
    }
    SharedPrefsUtils.setCurrentPage(this, 0);
    setupViewPager();
    setupTabIcons();
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
    if (this.noNetworkSubscription != null)
    {
      this.noNetworkSubscription.unsubscribe();
      this.noNetworkSubscription = null;
    }
    SharedPrefsUtils.setCurrentPage(this, this.currentPage);
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.main.MainActivity");
    super.onResume();
    this.allSubscriptions = new CompositeSubscription();
    this.allSubscriptions.add(this.friendRequestModel.onFriendRequestAdded().observeOn(AndroidSchedulers.mainThread()).subscribe(MainActivity..Lambda.1.lambdaFactory$(this)));
    this.allSubscriptions.add(this.unseenConversationModel.onAllConversationsSeen().observeOn(AndroidSchedulers.mainThread()).subscribe(MainActivity..Lambda.2.lambdaFactory$(this)));
    this.allSubscriptions.add(this.friendsModel.onFriendsListUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(MainActivity..Lambda.3.lambdaFactory$(this), MainActivity..Lambda.4.lambdaFactory$()));
    this.allSubscriptions.add(this.pageChangeListener.onPageSelected().distinctUntilChanged().onBackpressureLatest().observeOn(AndroidSchedulers.mainThread()).subscribe(MainActivity..Lambda.5.lambdaFactory$(this), MainActivity..Lambda.6.lambdaFactory$()));
    this.allSubscriptions.add(MessengerProvider.getInstance().onConnectionStateChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(MainActivity..Lambda.7.lambdaFactory$(this)));
    this.currentPage = SharedPrefsUtils.getCurrentPage(this);
    this.binding.viewPager.setCurrentItem(this.currentPage);
    onPageSelected(this.currentPage);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Log.w(TAG, "onSaveInstanceState()");
    paramBundle.putInt("ViewPagerCurrentPage", this.binding.viewPager.getCurrentItem());
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.main.MainActivity");
    super.onStart();
  }
  
  public void trackScreen() {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/main/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */