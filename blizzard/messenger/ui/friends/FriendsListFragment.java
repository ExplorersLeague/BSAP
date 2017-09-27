package com.blizzard.messenger.ui.friends;

import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blizzard.messenger.adapter.FriendsAdapter;
import com.blizzard.messenger.adapter.FriendsAdapter.FriendOption;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.profile.Profile;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.databinding.FriendsListFragmentBinding;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.base.BaseFragment;
import com.blizzard.messenger.ui.chat.ConversationActivity;
import com.blizzard.messenger.ui.friends.management.FindFriendsActivity;
import com.blizzard.messenger.utils.AnimUtils;
import com.blizzard.messenger.utils.ColorUtils;
import com.blizzard.messenger.utils.StringUtils;
import com.blizzard.messenger.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.observables.BlockingObservable;
import rx.subscriptions.CompositeSubscription;

public class FriendsListFragment
  extends BaseFragment
{
  private static final String EXTRA_IS_STARTING_CONVERSATION = "com.blizzard.messenger.IS_STARTING_CONVERSATION";
  private static final String TAG = FriendsListFragment.class.getSimpleName();
  private CompositeSubscription allSubscriptions;
  private FriendsListFragmentBinding binding;
  private BroadcastReceiver conversationActivityTransitionReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getBooleanExtra("com.blizzard.messenger.chat.ENTER_TRANSITION_DONE", false)) && (FriendsListFragment.this.getActivity() != null) && (!FriendsListFragment.this.getActivity().isFinishing())) {
        FriendsListFragment.this.getActivity().finish();
      }
    }
  };
  private int currentVisiblePosition = -1;
  private String filter;
  @Inject
  FriendRequestModel friendRequestModel;
  private FriendsAdapter friendsAdapter;
  private List<Friend> friendsList = new ArrayList();
  @Inject
  FriendsModel friendsModel;
  private boolean isStartingConversation;
  @Inject
  ProfileModel profileModel;
  
  private void findFriends()
  {
    startActivity(new Intent(getActivity(), FindFriendsActivity.class));
  }
  
  private static boolean friendMatchesFilter(@Nullable Friend paramFriend, @NonNull String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramFriend == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (TextUtils.isEmpty(paramString));
        bool1 = bool2;
      } while (paramFriend.getBattleTag().toLowerCase().contains(paramString.toLowerCase()));
      if (TextUtils.isEmpty(paramFriend.getFullName())) {
        break;
      }
      bool1 = bool2;
    } while (paramFriend.getFullName().toLowerCase().contains(paramString.toLowerCase()));
    return false;
  }
  
  private List<Friend> getAllOnlineFriends()
  {
    return (List)Observable.from(this.friendsList).filter(getFriendFilter(SharedPrefsUtils.isSortedWithOfflineHidden(getContext()))).toList().toBlocking().single();
  }
  
  private static Func1<Friend, Boolean> getFriendFilter(int paramInt)
  {
    if (paramInt == 0) {
      return FriendsListFragment..Lambda.17.lambdaFactory$();
    }
    if (paramInt == 1) {
      return FriendsListFragment..Lambda.18.lambdaFactory$();
    }
    return FriendsListFragment..Lambda.19.lambdaFactory$();
  }
  
  public static FriendsListFragment newInstance(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.blizzard.messenger.IS_STARTING_CONVERSATION", paramBoolean);
    FriendsListFragment localFriendsListFragment = new FriendsListFragment();
    localFriendsListFragment.setArguments(localBundle);
    return localFriendsListFragment;
  }
  
  private void selectOption(@NonNull FriendsAdapter.FriendOption paramFriendOption)
  {
    String str = paramFriendOption.getType();
    paramFriendOption = paramFriendOption.getFriend();
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      Telemetry.friendContextMenuActionTaken(paramFriendOption.getId(), str);
      return;
      if (!str.equals("com.blizzard.messenger.options.VIEW_PROFILE")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("com.blizzard.messenger.options.MESSAGE")) {
        break;
      }
      i = 1;
      break;
      showFriendProfileDialog(paramFriendOption);
      continue;
      startConversation(paramFriendOption);
    }
  }
  
  private void setupEmptyView()
  {
    View localView = ViewUtils.getEmptyView(getActivity(), 2130837695, 2131361849, 2131361913, 2131361912);
    localView.findViewById(2131820692).setOnClickListener(FriendsListFragment..Lambda.10.lambdaFactory$(this));
    this.binding.emptyLayout.addView(localView);
  }
  
  private void setupRecyclerView()
  {
    Object localObject = new LinearLayoutManager(getActivity());
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.binding.recyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    FragmentActivity localFragmentActivity = getActivity();
    if (!this.isStartingConversation) {}
    for (boolean bool = true;; bool = false)
    {
      this.friendsAdapter = new FriendsAdapter(localFragmentActivity, bool);
      this.friendsAdapter.setHasStableIds(true);
      this.binding.recyclerView.setHasFixedSize(true);
      localObject = new DividerItemDecoration(this.binding.recyclerView.getContext(), ((LinearLayoutManager)localObject).getOrientation());
      ((DividerItemDecoration)localObject).setDrawable(ContextCompat.getDrawable(getActivity(), 2130837739));
      this.binding.recyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
      this.binding.recyclerView.setAdapter(this.friendsAdapter);
      this.binding.recyclerView.setLayoutAnimation(AnimUtils.getRecyclerViewAnimationController());
      return;
    }
  }
  
  private void showFriendProfileDialog(@NonNull Friend paramFriend)
  {
    FragmentManager localFragmentManager = getActivity().getSupportFragmentManager();
    paramFriend = FriendProfileDialogFragment.newInstance(paramFriend.getId());
    paramFriend.onFriendRequestSent().subscribe(FriendsListFragment..Lambda.11.lambdaFactory$(this));
    paramFriend.onFriendUpgradeSent().subscribe(FriendsListFragment..Lambda.12.lambdaFactory$(this));
    paramFriend.onFriendRemoveSent().subscribe(FriendsListFragment..Lambda.13.lambdaFactory$(this));
    paramFriend.onFriendBlockSent().subscribe(FriendsListFragment..Lambda.14.lambdaFactory$(this));
    paramFriend.show(localFragmentManager, "FriendProfileDialogFragment");
  }
  
  private void startConversation(@NonNull Friend paramFriend)
  {
    if (this.isStartingConversation) {
      LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.conversationActivityTransitionReceiver, new IntentFilter("com.blizzard.messenger.chat.INTENT_FILTER_TRANSITION_RECEIVER"));
    }
    startActivity(ConversationActivity.newIntent(getActivity(), paramFriend.getId()), ActivityOptions.makeSceneTransitionAnimation(getActivity(), new Pair[0]).toBundle());
  }
  
  private void updateAppearOffline(@NonNull Profile paramProfile)
  {
    if (paramProfile.getStatus() == 5)
    {
      this.binding.appearingOfflineBar.setVisibility(0);
      return;
    }
    this.binding.appearingOfflineBar.setVisibility(8);
  }
  
  private void updateEmptyLayoutVisibility()
  {
    if ((TextUtils.isEmpty(this.filter)) && (this.friendsList.isEmpty()))
    {
      this.binding.emptyLayout.setVisibility(0);
      return;
    }
    this.binding.emptyLayout.setVisibility(8);
  }
  
  private void updateFilteredFriends()
  {
    List localList = (List)Observable.from(getAllOnlineFriends()).filter(FriendsListFragment..Lambda.16.lambdaFactory$(this)).toList().toBlocking().single();
    updateEmptyLayoutVisibility();
    updateNoResultsFoundVisibility(localList);
    this.friendsAdapter.setFriends(localList);
    if (this.currentVisiblePosition != -1)
    {
      this.binding.recyclerView.getLayoutManager().scrollToPosition(this.currentVisiblePosition);
      this.currentVisiblePosition = -1;
    }
  }
  
  private void updateFriendRequestCount(int paramInt)
  {
    if (paramInt > 0)
    {
      this.binding.friendRequestBar.setVisibility(0);
      this.binding.pendingRequestsCountText.setText(Integer.toString(paramInt));
      return;
    }
    this.binding.friendRequestBar.setVisibility(8);
  }
  
  private void updateFriends(@NonNull List<Friend> paramList)
  {
    this.friendsList = paramList;
    updateFilteredFriends();
  }
  
  private void updateNoResultsFoundVisibility(List<Friend> paramList)
  {
    if ((!TextUtils.isEmpty(this.filter)) && (paramList.isEmpty()))
    {
      this.binding.noResultsFoundTextView.setVisibility(0);
      return;
    }
    this.binding.noResultsFoundTextView.setVisibility(8);
  }
  
  private static boolean wasFriendRecentlyOnline(@NonNull Friend paramFriend)
  {
    return (paramFriend.isOnline()) || (!StringUtils.isOfflineLongerThanThirtyDays(paramFriend.getLastOnline()));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    paramBundle = (MessengerApplication)getActivity().getApplication();
    if (paramBundle.getModelComponent() != null) {
      paramBundle.getModelComponent().inject(this);
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131886085, paramMenu);
    paramMenuInflater = paramMenu.findItem(2131820908);
    paramMenuInflater.setOnMenuItemClickListener(FriendsListFragment..Lambda.15.lambdaFactory$());
    if (this.isStartingConversation) {
      paramMenu.findItem(2131820909).setVisible(false);
    }
    paramMenu = (SearchView)paramMenuInflater.getActionView();
    paramMenu.setQueryHint(getString(2131362026));
    paramMenuInflater = (EditText)paramMenu.findViewById(2131820678);
    paramMenuInflater.setTextColor(ColorUtils.getTextColorActionBarTitle(getContext()));
    paramMenuInflater.setHintTextColor(ColorUtils.getTextColorActionBarTitle(getContext()));
    paramMenu.setOnQueryTextListener(new SearchView.OnQueryTextListener()
    {
      public boolean onQueryTextChange(String paramAnonymousString)
      {
        Log.i(FriendsListFragment.TAG, "onQueryTextChange");
        FriendsListFragment.access$102(FriendsListFragment.this, paramAnonymousString);
        FriendsListFragment.this.updateFilteredFriends();
        return true;
      }
      
      public boolean onQueryTextSubmit(String paramAnonymousString)
      {
        return false;
      }
    });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.binding = ((FriendsListFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968647, paramViewGroup, false));
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null) {
      this.isStartingConversation = paramLayoutInflater.getBoolean("com.blizzard.messenger.IS_STARTING_CONVERSATION");
    }
    setupRecyclerView();
    setupEmptyView();
    this.friendsAdapter.onFriendClicked().throttleFirst(300L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(FriendsListFragment..Lambda.1.lambdaFactory$(this), FriendsListFragment..Lambda.2.lambdaFactory$());
    this.friendsAdapter.onFriendOptionClicked().subscribe(FriendsListFragment..Lambda.3.lambdaFactory$(this), FriendsListFragment..Lambda.4.lambdaFactory$());
    this.binding.friendRequestBar.setOnClickListener(FriendsListFragment..Lambda.5.lambdaFactory$(this));
    return this.binding.getRoot();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.conversationActivityTransitionReceiver);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      findFriends();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
    this.currentVisiblePosition = ((LinearLayoutManager)this.binding.recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    this.friendsAdapter.closePopup();
  }
  
  public void onResume()
  {
    super.onResume();
    this.allSubscriptions = new CompositeSubscription();
    this.allSubscriptions.add(this.friendsModel.onFriendsListUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(FriendsListFragment..Lambda.6.lambdaFactory$(this), FriendsListFragment..Lambda.7.lambdaFactory$()));
    if (!this.isStartingConversation) {
      this.allSubscriptions.add(this.friendRequestModel.onFriendRequestsUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(FriendsListFragment..Lambda.8.lambdaFactory$(this)));
    }
    this.allSubscriptions.add(this.profileModel.onProfileUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(FriendsListFragment..Lambda.9.lambdaFactory$(this)));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/FriendsListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */