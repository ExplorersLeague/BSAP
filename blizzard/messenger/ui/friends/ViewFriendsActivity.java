package com.blizzard.messenger.ui.friends;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blizzard.messenger.adapter.SuggestedFriendListAdapter;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriend;
import com.blizzard.messenger.data.providers.SuggestedFriendsProvider;
import com.blizzard.messenger.databinding.ViewFriendsActivityBinding;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.utils.ColorUtils;
import com.blizzard.messenger.views.dialog.FriendRequestDialogFragment;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class ViewFriendsActivity
  extends BaseActivity
{
  public static final String EXTRA_FRIEND_ACCOUNT_ID = "com.blizzard.messenger.FRIEND_ACCOUNT_ID";
  public static final String EXTRA_FRIEND_NAME = "com.blizzard.messenger.FRIEND_NAME";
  private CompositeSubscription allSubscriptions = new CompositeSubscription();
  private ViewFriendsActivityBinding binding;
  private String filter;
  @Inject
  FriendsModel friendsModel;
  private List<SuggestedFriend> friendsOfFriends;
  private SuggestedFriendListAdapter suggestedFriendListAdapter;
  
  private static boolean friendMatchesFilter(SuggestedFriend paramSuggestedFriend, @NonNull String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramSuggestedFriend == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramSuggestedFriend.getBattleTag().toLowerCase().contains(paramString.toLowerCase()));
      if (TextUtils.isEmpty(paramSuggestedFriend.getFullName())) {
        break;
      }
      bool1 = bool2;
    } while (paramSuggestedFriend.getFullName().toLowerCase().contains(paramString.toLowerCase()));
    return false;
  }
  
  private void handleAcceptClicked(@NonNull SuggestedFriend paramSuggestedFriend)
  {
    paramSuggestedFriend = FriendRequestDialogFragment.newSendInstance(paramSuggestedFriend.getBattleTag(), "BattleTag");
    paramSuggestedFriend.onFriendRequestSent().subscribe(ViewFriendsActivity..Lambda.5.lambdaFactory$(this));
    paramSuggestedFriend.show(getSupportFragmentManager(), "FriendRequestDialogFragment");
  }
  
  public static Intent newIntent(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2)
  {
    paramContext = new Intent(paramContext, ViewFriendsActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.blizzard.messenger.FRIEND_ACCOUNT_ID", paramString1);
    localBundle.putString("com.blizzard.messenger.FRIEND_NAME", paramString2);
    paramContext.putExtras(localBundle);
    return paramContext;
  }
  
  private void retrieveFriendsOfFriends()
  {
    Object localObject = getIntent().getExtras();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("com.blizzard.messenger.FRIEND_ACCOUNT_ID");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        SuggestedFriendsProvider localSuggestedFriendsProvider = MessengerProvider.getInstance().getSuggestedFriendsProvider();
        this.allSubscriptions.add(localSuggestedFriendsProvider.retrieveFriendsOfFriends((String)localObject).observeOn(AndroidSchedulers.mainThread()).subscribe(ViewFriendsActivity..Lambda.3.lambdaFactory$(this), ViewFriendsActivity..Lambda.4.lambdaFactory$()));
      }
    }
  }
  
  private void setupRecyclerView()
  {
    this.suggestedFriendListAdapter = new SuggestedFriendListAdapter(this);
    this.allSubscriptions.add(this.suggestedFriendListAdapter.onAcceptClicked().observeOn(AndroidSchedulers.mainThread()).subscribe(ViewFriendsActivity..Lambda.1.lambdaFactory$(this), ViewFriendsActivity..Lambda.2.lambdaFactory$()));
    Object localObject = new LinearLayoutManager(this)
    {
      public boolean canScrollVertically()
      {
        return true;
      }
    };
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.binding.recyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.binding.recyclerView.setHasFixedSize(true);
    localObject = new DividerItemDecoration(this, ((LinearLayoutManager)localObject).getOrientation());
    ((DividerItemDecoration)localObject).setDrawable(ContextCompat.getDrawable(this, 2130837739));
    this.binding.recyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    this.binding.recyclerView.setAdapter(this.suggestedFriendListAdapter);
  }
  
  private void showFriendsOfFriends()
  {
    if (!TextUtils.isEmpty(this.filter))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.friendsOfFriends.iterator();
      while (localIterator.hasNext())
      {
        SuggestedFriend localSuggestedFriend = (SuggestedFriend)localIterator.next();
        if (friendMatchesFilter(localSuggestedFriend, this.filter)) {
          localArrayList.add(localSuggestedFriend);
        }
      }
      if (localArrayList.size() > 0)
      {
        this.binding.noResultsFoundTextView.setVisibility(8);
        this.binding.recyclerView.setVisibility(0);
        this.binding.emptyLayout.setVisibility(8);
      }
      for (;;)
      {
        sortFriendsOfFriends();
        this.suggestedFriendListAdapter.setSuggestedFriends(localArrayList);
        return;
        this.binding.noResultsFoundTextView.setVisibility(0);
        this.binding.recyclerView.setVisibility(8);
        this.binding.emptyLayout.setVisibility(8);
      }
    }
    if ((this.friendsOfFriends != null) && (this.friendsOfFriends.size() > 0))
    {
      this.binding.noResultsFoundTextView.setVisibility(8);
      this.binding.emptyLayout.setVisibility(8);
      this.binding.recyclerView.setVisibility(0);
      sortFriendsOfFriends();
    }
    for (;;)
    {
      this.suggestedFriendListAdapter.setSuggestedFriends(this.friendsOfFriends);
      return;
      this.binding.noResultsFoundTextView.setVisibility(8);
      this.binding.recyclerView.setVisibility(8);
      this.binding.emptyLayout.setVisibility(0);
    }
  }
  
  private void sortFriendsOfFriends()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.friendsOfFriends.iterator();
    while (localIterator.hasNext())
    {
      SuggestedFriend localSuggestedFriend = (SuggestedFriend)localIterator.next();
      if (!TextUtils.isEmpty(localSuggestedFriend.getBattleTag())) {
        localArrayList.add(localSuggestedFriend);
      }
    }
    Collections.sort(localArrayList, new FriendsOfFriendsComparator(null));
    this.friendsOfFriends = localArrayList;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.friends.ViewFriendsActivity");
    super.onCreate(paramBundle);
    ((MessengerApplication)getApplication()).getModelComponent().inject(this);
    this.binding = ((ViewFriendsActivityBinding)DataBindingUtil.setContentView(this, 2130968713));
    setSupportActionBar(this.binding.toolbar);
    paramBundle = getIntent().getExtras().getString("com.blizzard.messenger.FRIEND_NAME");
    this.binding.errorTextView.setText(String.format(getString(2131361914), new Object[] { paramBundle }));
    setTitle(String.format(getString(2131361934), new Object[] { paramBundle }));
    setDisplayHomeAsUpEnabled(true);
    setupRecyclerView();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131886088, paramMenu);
    Object localObject = paramMenu.findItem(2131820908);
    ((MenuItem)localObject).setOnMenuItemClickListener(ViewFriendsActivity..Lambda.6.lambdaFactory$());
    localObject = (SearchView)((MenuItem)localObject).getActionView();
    ((SearchView)localObject).setQueryHint(getString(2131362026));
    EditText localEditText = (EditText)((SearchView)localObject).findViewById(2131820678);
    localEditText.setTextColor(ColorUtils.getTextColorActionBarTitle(this));
    localEditText.setHintTextColor(ColorUtils.getTextColorActionBarTitle(this));
    ((SearchView)localObject).setOnQueryTextListener(new SearchView.OnQueryTextListener()
    {
      public boolean onQueryTextChange(String paramAnonymousString)
      {
        ViewFriendsActivity.access$102(ViewFriendsActivity.this, paramAnonymousString);
        ViewFriendsActivity.this.showFriendsOfFriends();
        return true;
      }
      
      public boolean onQueryTextSubmit(String paramAnonymousString)
      {
        return false;
      }
    });
    return super.onCreateOptionsMenu(paramMenu);
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
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.friends.ViewFriendsActivity");
    super.onResume();
    this.allSubscriptions = new CompositeSubscription();
    retrieveFriendsOfFriends();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.friends.ViewFriendsActivity");
    super.onStart();
  }
  
  private class FriendsOfFriendsComparator
    implements Comparator<SuggestedFriend>
  {
    private FriendsOfFriendsComparator() {}
    
    public int compare(@NonNull SuggestedFriend paramSuggestedFriend1, @NonNull SuggestedFriend paramSuggestedFriend2)
    {
      Friend localFriend1 = ViewFriendsActivity.this.friendsModel.findFriendById(paramSuggestedFriend1.getAccountId());
      Friend localFriend2 = ViewFriendsActivity.this.friendsModel.findFriendById(paramSuggestedFriend2.getAccountId());
      if ((localFriend1 != null) && (localFriend2 == null)) {
        return -1;
      }
      if ((localFriend1 == null) && (localFriend2 != null)) {
        return 1;
      }
      return paramSuggestedFriend1.getBattleTag().compareToIgnoreCase(paramSuggestedFriend2.getBattleTag());
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/ViewFriendsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */