package com.blizzard.messenger.ui.friends.management;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.LayoutParams;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.blizzard.messenger.adapter.SuggestedFriendListAdapter;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriend;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.databinding.FindFriendsActivityBinding;
import com.blizzard.messenger.databinding.FindFriendsHeaderBinding;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.ui.friends.QRBottomSheetFragment;
import com.blizzard.messenger.ui.friends.qr.ScanQRCodeActivity;
import com.blizzard.messenger.ui.friends.qr.ShowQRCodeActivity;
import com.blizzard.messenger.utils.AnimUtils;
import com.blizzard.messenger.utils.PermissionUtils;
import com.blizzard.messenger.utils.ViewUtils;
import com.blizzard.messenger.views.dialog.FriendRequestDialogFragment;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class FindFriendsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final String TAG = FindFriendsActivity.class.getSimpleName();
  private CompositeSubscription allSubscriptions;
  private FindFriendsActivityBinding binding;
  private boolean emptyViewShown = true;
  @Inject
  ProfileModel profileModel;
  private SuggestedFriendListAdapter suggestedFriendListAdapter;
  @Inject
  SuggestedFriendsModel suggestedFriendsModel;
  
  private void handleAcceptClicked(@NonNull SuggestedFriend paramSuggestedFriend)
  {
    paramSuggestedFriend = FriendRequestDialogFragment.newSendInstance(paramSuggestedFriend.getBattleTag(), "BattleTag");
    paramSuggestedFriend.onFriendRequestSent().subscribe(FindFriendsActivity..Lambda.8.lambdaFactory$(this));
    paramSuggestedFriend.show(getSupportFragmentManager(), "FriendRequestDialogFragment");
  }
  
  private void scanCode(Void paramVoid)
  {
    PermissionUtils.requestPermission(this, 500, "android.permission.CAMERA").subscribeOn(AndroidSchedulers.mainThread()).subscribe(FindFriendsActivity..Lambda.7.lambdaFactory$(this));
  }
  
  private void scanCodeActivity(String paramString)
  {
    startActivity(new Intent(this, ScanQRCodeActivity.class));
  }
  
  private void setupRecyclerView()
  {
    Object localObject = new LinearLayoutManager(this)
    {
      public boolean canScrollVertically()
      {
        return !FindFriendsActivity.this.emptyViewShown;
      }
    };
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.binding.recyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.binding.recyclerView.setHasFixedSize(true);
    localObject = new DividerItemDecoration(this, ((LinearLayoutManager)localObject).getOrientation());
    ((DividerItemDecoration)localObject).setDrawable(ContextCompat.getDrawable(this, 2130837739));
    this.binding.recyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    this.suggestedFriendListAdapter = new SuggestedFriendListAdapter(this);
    this.binding.recyclerView.setAdapter(this.suggestedFriendListAdapter);
    this.binding.recyclerView.setLayoutAnimation(AnimUtils.getRecyclerViewAnimationController());
  }
  
  private void showActionSheet()
  {
    QRBottomSheetFragment localQRBottomSheetFragment = new QRBottomSheetFragment();
    localQRBottomSheetFragment.onScanCodeClicked().subscribeOn(AndroidSchedulers.mainThread()).subscribe(FindFriendsActivity..Lambda.5.lambdaFactory$(this));
    localQRBottomSheetFragment.onShowCodeClicked().subscribeOn(AndroidSchedulers.mainThread()).subscribe(FindFriendsActivity..Lambda.6.lambdaFactory$(this));
    localQRBottomSheetFragment.show(getSupportFragmentManager(), localQRBottomSheetFragment.getTag());
  }
  
  private void showCameraPermissionDeniedActivity()
  {
    startActivity(new Intent(this, CameraPermissionDeniedActivity.class));
  }
  
  private void showCode(Void paramVoid)
  {
    startActivity(new Intent(this, ShowQRCodeActivity.class));
  }
  
  private void showEmptyFriends()
  {
    Log.d(TAG, "showEmptyFriends");
    this.binding.header.headerLayout.setVisibility(8);
    showEmptySuggestedFriends();
  }
  
  private void showEmptySuggestedFriends()
  {
    this.binding.recyclerView.setVisibility(8);
    this.binding.emptyLayout.setVisibility(0);
  }
  
  private void showLoadedFriends(@NonNull List<SuggestedFriend> paramList)
  {
    AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)this.binding.collapsingToolbarLayout.getLayoutParams();
    if (this.emptyViewShown) {
      localLayoutParams.setScrollFlags(16);
    }
    for (;;)
    {
      this.binding.collapsingToolbarLayout.setLayoutParams(localLayoutParams);
      paramList = new ArrayList(paramList);
      Collections.sort(paramList, new SuggestedFriendsComparator(null));
      this.suggestedFriendListAdapter.setSuggestedFriends(Collections.unmodifiableList(paramList));
      showSuggestionsHeader();
      showSuggestedFriendsList();
      return;
      localLayoutParams.setScrollFlags(3);
    }
  }
  
  private void showLoadingFriends()
  {
    Log.d(TAG, "showLoadingFriends");
    showProgressHeader();
    showSuggestedFriendsList();
  }
  
  private void showProgressHeader()
  {
    Log.d(TAG, "showProgressHeader");
    this.binding.header.headerLayout.setVisibility(0);
    if (this.binding.header.spinnerImageView.getVisibility() == 8)
    {
      AnimUtils.fadeIn(this.binding.header.spinnerImageView);
      AnimUtils.textFadeAnimation(this.binding.header.headerTextView, getString(2131362019));
    }
  }
  
  private void showSuggestedFriendsList()
  {
    this.binding.recyclerView.setVisibility(0);
    this.binding.emptyLayout.setVisibility(8);
  }
  
  private void showSuggestionsHeader()
  {
    Log.d(TAG, "showSuggestionsHeader");
    this.binding.header.headerLayout.setVisibility(0);
    if (this.binding.header.spinnerImageView.getVisibility() == 0)
    {
      AnimUtils.fadeOut(this.binding.header.spinnerImageView);
      AnimUtils.textFadeAnimation(this.binding.header.headerTextView, getString(2131362061));
    }
  }
  
  private void updateSuggestedFriends(@NonNull List<SuggestedFriend> paramList)
  {
    Log.d(TAG, "showLoadedFriends");
    this.emptyViewShown = paramList.isEmpty();
    if (this.emptyViewShown)
    {
      showEmptyFriends();
      return;
    }
    showLoadedFriends(paramList);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131820771: 
      startActivity(new Intent(this, AddFriendActivity.class));
      return;
    }
    showActionSheet();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.friends.management.FindFriendsActivity");
    super.onCreate(paramBundle);
    this.binding = ((FindFriendsActivityBinding)DataBindingUtil.setContentView(this, 2130968638));
    this.binding.toolbar.setTitle(2131361876);
    setSupportActionBar(this.binding.toolbar);
    setDisplayHomeAsUpEnabled(true);
    ((MessengerApplication)getApplication()).getModelComponent().inject(this);
    setupRecyclerView();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    NavUtils.navigateUpFromSameTask(this);
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (PermissionUtils.isPermissionGranted(paramInt, paramArrayOfString, paramArrayOfInt))
    {
      scanCodeActivity(null);
      return;
    }
    showCameraPermissionDeniedActivity();
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.friends.management.FindFriendsActivity");
    super.onResume();
    this.binding.header.addByIdLayout.setOnClickListener(this);
    this.binding.header.addByCodeLayout.setOnClickListener(this);
    if (!this.suggestedFriendsModel.hasValue())
    {
      showLoadingFriends();
      ViewUtils.reportError(this, MessengerProvider.getInstance().retrieveSuggestedFriends(20));
    }
    this.allSubscriptions = new CompositeSubscription();
    this.allSubscriptions.add(this.suggestedFriendListAdapter.onAcceptClicked().observeOn(AndroidSchedulers.mainThread()).subscribe(FindFriendsActivity..Lambda.1.lambdaFactory$(this), FindFriendsActivity..Lambda.2.lambdaFactory$()));
    this.allSubscriptions.add(this.suggestedFriendsModel.onSuggestedFriendsUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(FindFriendsActivity..Lambda.3.lambdaFactory$(this)));
    this.binding.appBarLayout.addOnOffsetChangedListener(FindFriendsActivity..Lambda.4.lambdaFactory$(this));
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.friends.management.FindFriendsActivity");
    super.onStart();
  }
  
  private class SuggestedFriendsComparator
    implements Comparator<SuggestedFriend>
  {
    private SuggestedFriendsComparator() {}
    
    public int compare(@NonNull SuggestedFriend paramSuggestedFriend1, @NonNull SuggestedFriend paramSuggestedFriend2)
    {
      if (paramSuggestedFriend1.getMutualFriends().size() != paramSuggestedFriend2.getMutualFriends().size()) {
        return -Integer.compare(paramSuggestedFriend1.getMutualFriends().size(), paramSuggestedFriend2.getMutualFriends().size());
      }
      return paramSuggestedFriend1.getBattleTag().compareToIgnoreCase(paramSuggestedFriend2.getBattleTag());
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/FindFriendsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */