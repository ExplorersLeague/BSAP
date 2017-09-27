package com.blizzard.messenger.ui.chat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blizzard.messenger.adapter.ChatListAdapter;
import com.blizzard.messenger.adapter.ChatListAdapter.ChatOption;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.chat.NewestMessageModel;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.profile.Profile;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.databinding.ChatListFragmentBinding;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.base.BaseFragment;
import com.blizzard.messenger.utils.ViewUtils;
import com.blizzard.messenger.views.dialog.MessengerDialogFragment;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ChatListFragment
  extends BaseFragment
{
  private CompositeSubscription allSubscriptions;
  private ChatListFragmentBinding binding;
  private ChatListAdapter chatListAdapter;
  private int currentVisiblePosition = -1;
  @Inject
  FriendsModel friendsModel;
  private final Handler handler = new Handler();
  @Inject
  NewestMessageModel newestMessageModel;
  @Inject
  ProfileModel profileModel;
  private MessengerProvider provider;
  private final Runnable refresher = new Runnable()
  {
    public void run()
    {
      ChatListFragment.this.chatListAdapter.notifyDataSetChanged();
      ChatListFragment.this.handler.postDelayed(ChatListFragment.this.refresher, 60000L);
    }
  };
  @Inject
  UnseenConversationModel unseenConversationModel;
  
  private void checkForEmptyView()
  {
    if (this.chatListAdapter != null)
    {
      if ((this.chatListAdapter.getItemCount() != 0) || (this.binding.emptyLayout.getVisibility() != 8)) {
        break label109;
      }
      if (this.binding.emptyLayout.findViewWithTag(Integer.valueOf(0)) == null)
      {
        localView = ViewUtils.getEmptyView(getActivity(), 2130837684, 2131361848, 2131361911, 2131361910);
        localView.findViewById(2131820692).setOnClickListener(ChatListFragment..Lambda.4.lambdaFactory$(this));
        localView.setTag(Integer.valueOf(0));
        this.binding.emptyLayout.addView(localView);
      }
      this.binding.emptyLayout.setVisibility(0);
    }
    label109:
    while ((this.chatListAdapter.getItemCount() <= 0) || (this.binding.emptyLayout.getVisibility() != 0))
    {
      View localView;
      return;
    }
    this.binding.emptyLayout.setVisibility(8);
  }
  
  private void hideConversation(String paramString)
  {
    MessengerProvider.getInstance().hideConversation(paramString);
    Telemetry.whisperChatDeleted(paramString);
  }
  
  private void optionSelected(ChatListAdapter.ChatOption paramChatOption)
  {
    if (paramChatOption.getType().equals("com.blizzard.messenger.options.MESSAGE")) {
      startConversation(paramChatOption.getConversationId());
    }
    while (!paramChatOption.getType().equals("com.blizzard.messenger.options.HIDE")) {
      return;
    }
    showHideConversationDialog(paramChatOption.getConversationId());
  }
  
  private void setupRecyclerView()
  {
    Object localObject = new LinearLayoutManager(getActivity());
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.binding.recyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.binding.recyclerView.setHasFixedSize(true);
    localObject = new DividerItemDecoration(this.binding.recyclerView.getContext(), ((LinearLayoutManager)localObject).getOrientation());
    ((DividerItemDecoration)localObject).setDrawable(ContextCompat.getDrawable(getActivity(), 2130837739));
    this.binding.recyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    this.binding.recyclerView.setAdapter(this.chatListAdapter);
  }
  
  private void showHideConversationDialog(String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("PositiveButton", getString(2131362079));
    ((Bundle)localObject).putString("NegativeButton", getString(2131361958));
    ((Bundle)localObject).putString("Message", getString(2131361938));
    ((Bundle)localObject).putString("Title", getString(2131361939));
    localObject = MessengerDialogFragment.newInstance((Bundle)localObject);
    if (localObject != null)
    {
      ((MessengerDialogFragment)localObject).onPositiveButtonClicked().observeOn(AndroidSchedulers.mainThread()).subscribe(ChatListFragment..Lambda.16.lambdaFactory$(this, paramString));
      paramString = getActivity().getSupportFragmentManager().beginTransaction();
      paramString.add((Fragment)localObject, "DeleteConversationFragment");
      paramString.commitAllowingStateLoss();
    }
  }
  
  private void startConversation(String paramString)
  {
    if (paramString != null) {
      startActivity(ConversationActivity.newIntent(getActivity(), paramString), ActivityOptions.makeSceneTransitionAnimation(getActivity(), new Pair[0]).toBundle());
    }
  }
  
  private void startNewConversation()
  {
    startActivity(new Intent(getActivity(), ChooseFriendActivity.class));
  }
  
  private void startPeriodicUpdate()
  {
    if (!this.handler.hasMessages(0)) {
      this.handler.post(this.refresher);
    }
  }
  
  private void stopPeriodicUpdate()
  {
    this.handler.removeCallbacks(this.refresher);
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((MessengerApplication)getActivity().getApplicationContext()).getModelComponent().inject(this);
    this.provider = MessengerProvider.getInstance();
    setHasOptionsMenu(true);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131886080, paramMenu);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.binding = ((ChatListFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968614, paramViewGroup, false));
    setupRecyclerView();
    if (this.newestMessageModel != null)
    {
      paramLayoutInflater = this.newestMessageModel.getNewestMessages();
      this.chatListAdapter = new ChatListAdapter(getActivity(), this.unseenConversationModel, paramLayoutInflater, this.friendsModel.getFriends());
      this.binding.recyclerView.setAdapter(this.chatListAdapter);
      checkForEmptyView();
      this.chatListAdapter.onConversationClicked().throttleFirst(300L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(ChatListFragment..Lambda.1.lambdaFactory$(this), ChatListFragment..Lambda.2.lambdaFactory$());
      this.chatListAdapter.onOptionSelected().subscribe(ChatListFragment..Lambda.3.lambdaFactory$(this));
    }
    return this.binding.getRoot();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      startNewConversation();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    stopPeriodicUpdate();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
    this.currentVisiblePosition = ((LinearLayoutManager)this.binding.recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    this.chatListAdapter.closePopup();
  }
  
  public void onResume()
  {
    super.onResume();
    checkForEmptyView();
    startPeriodicUpdate();
    this.allSubscriptions = new CompositeSubscription();
    CompositeSubscription localCompositeSubscription = this.allSubscriptions;
    Observable localObservable = this.friendsModel.onFriendsListUpdated().observeOn(AndroidSchedulers.mainThread());
    ChatListAdapter localChatListAdapter = this.chatListAdapter;
    localChatListAdapter.getClass();
    localCompositeSubscription.add(localObservable.subscribe(ChatListFragment..Lambda.5.lambdaFactory$(localChatListAdapter), ChatListFragment..Lambda.6.lambdaFactory$()));
    this.allSubscriptions.add(this.newestMessageModel.onNewestMessageChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(ChatListFragment..Lambda.7.lambdaFactory$(this), ChatListFragment..Lambda.8.lambdaFactory$()));
    this.allSubscriptions.add(this.newestMessageModel.onConversationRemoved().observeOn(AndroidSchedulers.mainThread()).subscribe(ChatListFragment..Lambda.9.lambdaFactory$(this), ChatListFragment..Lambda.10.lambdaFactory$()));
    this.allSubscriptions.add(this.provider.getHiddenConversations().observeOn(AndroidSchedulers.mainThread()).subscribe(ChatListFragment..Lambda.11.lambdaFactory$(this), ChatListFragment..Lambda.12.lambdaFactory$()));
    this.allSubscriptions.add(this.provider.getLatestMessagesFromDatastore().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(ChatListFragment..Lambda.13.lambdaFactory$(this), ChatListFragment..Lambda.14.lambdaFactory$()));
    this.allSubscriptions.add(this.profileModel.onProfileUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(ChatListFragment..Lambda.15.lambdaFactory$(this)));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/chat/ChatListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */