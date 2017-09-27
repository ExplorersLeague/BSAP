package com.blizzard.messenger.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.text.TextUtils;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.databinding.ChatActivityBinding;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.ui.friends.FriendProfileDialogFragment;
import com.blizzard.messenger.utils.ColorUtils;
import com.blizzard.messenger.utils.PresenceUtils;
import com.blizzard.messenger.utils.StringUtils;
import com.blizzard.messenger.utils.ViewUtils;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class ConversationActivity
  extends BaseActivity
{
  private static final String EXTRA_CONVERSATION_ID = "com.blizzard.messenger.chat.CONVERSATION_ID";
  public static final String EXTRA_ENTER_TRANSITION_DONE = "com.blizzard.messenger.chat.ENTER_TRANSITION_DONE";
  public static final String INTENT_FILTER_TRANSITION_RECEIVER = "com.blizzard.messenger.chat.INTENT_FILTER_TRANSITION_RECEIVER";
  private static final String TAG = ConversationActivity.class.getSimpleName();
  private View actionBarView;
  private CompositeSubscription allSubscriptions;
  private TextView battletagTextView;
  private ChatActivityBinding binding;
  private String conversationId;
  @Inject
  FriendsModel friendsModel;
  private ImageView gameIconImageView;
  private ImageView presenceIconImageView;
  private TextView richPresenceTextView;
  
  private void initConversationFragment()
  {
    this.conversationId = getIntent().getExtras().getString("com.blizzard.messenger.chat.CONVERSATION_ID");
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    ConversationFragment localConversationFragment = ConversationFragment.newInstance(this.conversationId);
    localFragmentTransaction.replace(this.binding.content.getId(), localConversationFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public static Intent newIntent(@NonNull Context paramContext, @NonNull String paramString)
  {
    paramContext = new Intent(paramContext, ConversationActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.blizzard.messenger.chat.CONVERSATION_ID", paramString);
    paramContext.putExtras(localBundle);
    return paramContext;
  }
  
  private void setupCustomActionBarView()
  {
    this.actionBarView = getLayoutInflater().inflate(2130968617, null);
    this.gameIconImageView = ((ImageView)this.actionBarView.findViewById(2131820737));
    this.presenceIconImageView = ((ImageView)this.actionBarView.findViewById(2131820778));
    this.battletagTextView = ((TextView)this.actionBarView.findViewById(2131820741));
    this.richPresenceTextView = ((TextView)this.actionBarView.findViewById(2131820744));
  }
  
  private void setupToolbar()
  {
    setStatusBarColor(ColorUtils.getColorPrimaryDark(this));
    setSupportActionBar(this.binding.toolbar);
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setDisplayOptions(16);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    setupCustomActionBarView();
    updateActionBar(this.friendsModel.findFriendById(this.conversationId));
  }
  
  private void setupWindowTransitions()
  {
    Slide localSlide = (Slide)TransitionInflater.from(this).inflateTransition(2131165184);
    localSlide.addListener(new Transition.TransitionListener()
    {
      public void onTransitionCancel(Transition paramAnonymousTransition) {}
      
      public void onTransitionEnd(Transition paramAnonymousTransition)
      {
        paramAnonymousTransition = new Intent("com.blizzard.messenger.chat.INTENT_FILTER_TRANSITION_RECEIVER");
        paramAnonymousTransition.putExtra("com.blizzard.messenger.chat.ENTER_TRANSITION_DONE", true);
        LocalBroadcastManager.getInstance(ConversationActivity.this).sendBroadcast(paramAnonymousTransition);
      }
      
      public void onTransitionPause(Transition paramAnonymousTransition)
      {
        paramAnonymousTransition = new Intent("com.blizzard.messenger.chat.INTENT_FILTER_TRANSITION_RECEIVER");
        paramAnonymousTransition.putExtra("com.blizzard.messenger.chat.ENTER_TRANSITION_DONE", true);
        LocalBroadcastManager.getInstance(ConversationActivity.this).sendBroadcast(paramAnonymousTransition);
      }
      
      public void onTransitionResume(Transition paramAnonymousTransition) {}
      
      public void onTransitionStart(Transition paramAnonymousTransition) {}
    });
    getWindow().setEnterTransition(localSlide);
    localSlide = (Slide)TransitionInflater.from(this).inflateTransition(2131165185);
    getWindow().setExitTransition(localSlide);
  }
  
  private void showFriendProfileDialog()
  {
    if (this.friendsModel.findFriendById(this.conversationId) != null)
    {
      FragmentManager localFragmentManager = getSupportFragmentManager();
      FriendProfileDialogFragment localFriendProfileDialogFragment = FriendProfileDialogFragment.newInstance(this.conversationId);
      localFriendProfileDialogFragment.onFriendRequestSent().subscribe(ConversationActivity..Lambda.5.lambdaFactory$(this));
      localFriendProfileDialogFragment.onFriendUpgradeSent().subscribe(ConversationActivity..Lambda.6.lambdaFactory$(this));
      localFriendProfileDialogFragment.onFriendRemoveSent().subscribe(ConversationActivity..Lambda.7.lambdaFactory$(this));
      localFriendProfileDialogFragment.onFriendBlockSent().subscribe(ConversationActivity..Lambda.8.lambdaFactory$(this));
      localFragmentManager.beginTransaction().add(localFriendProfileDialogFragment, "FriendProfileDialogFragment").commitAllowingStateLoss();
      return;
    }
    ViewUtils.showUnavailableActionMessage(this);
  }
  
  private void showNetworkAvailability(String paramString)
  {
    boolean bool = paramString.equals("com.blizzard.messenger.CONNECTED");
    if ((bool) && (this.binding.noNetworkTextView.getVisibility() == 0)) {
      this.binding.noNetworkTextView.setVisibility(8);
    }
    while ((bool) || (this.binding.noNetworkTextView.getVisibility() != 8)) {
      return;
    }
    this.binding.noNetworkTextView.setVisibility(0);
  }
  
  private void updateActionBar(Friend paramFriend)
  {
    String str;
    label107:
    int i;
    if (paramFriend != null)
    {
      Log.d(TAG, paramFriend.toString());
      str = StringUtils.getBattleTagName(paramFriend.getBattleTag());
      if (!TextUtils.isEmpty(paramFriend.getFullName()))
      {
        this.battletagTextView.setText(str + " (" + paramFriend.getFullName() + ")");
        if ((TextUtils.isEmpty(paramFriend.getRichPresence())) || (paramFriend.getGame().equals("App"))) {
          break label184;
        }
        this.richPresenceTextView.setText(paramFriend.getRichPresence());
        i = PresenceUtils.getPresenceStatusIconResId(paramFriend.getStatus());
        if (i == 0) {
          break label201;
        }
        this.presenceIconImageView.setImageResource(i);
        label127:
        i = PresenceUtils.getGameIconResId(paramFriend.getGame());
        if (i != 0) {
          Picasso.with(this).load(i).into(this.gameIconImageView);
        }
        if (getSupportActionBar() == null) {
          break label214;
        }
        getSupportActionBar().setCustomView(this.actionBarView);
      }
    }
    label184:
    label201:
    label214:
    do
    {
      return;
      this.battletagTextView.setText(str);
      break;
      str = PresenceUtils.getPresenceUiString(this, paramFriend);
      this.richPresenceTextView.setText(str);
      break label107;
      this.presenceIconImageView.setImageResource(2130837712);
      break label127;
      Log.e(TAG, "Support action bar is null");
      return;
      this.battletagTextView.setText(getString(2131362062));
      this.richPresenceTextView.setText(PresenceUtils.getPresenceStatusStringResId(5));
      this.presenceIconImageView.setImageResource(2130837712);
      i = PresenceUtils.getGameIconResId("App");
      Picasso.with(this).load(i).into(this.gameIconImageView);
    } while (getSupportActionBar() == null);
    getSupportActionBar().setCustomView(this.actionBarView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.chat.ConversationActivity");
    super.onCreate(paramBundle);
    setShowSnackbar(false);
    this.binding = ((ChatActivityBinding)DataBindingUtil.setContentView(this, 2130968609));
    ((MessengerApplication)getApplication()).getModelComponent().inject(this);
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    initConversationFragment();
    setupWindowTransitions();
    setupToolbar();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131886081, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      finishAfterTransition();
      return true;
      showFriendProfileDialog();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
    MessengerProvider.getInstance().resetVisibleConversationId(this.conversationId);
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.chat.ConversationActivity");
    super.onResume();
    this.allSubscriptions = new CompositeSubscription();
    this.allSubscriptions.add(MessengerProvider.getInstance().onConnectionStateChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationActivity..Lambda.1.lambdaFactory$(this)));
    this.allSubscriptions.add(this.friendsModel.onFriendUpdated().filter(ConversationActivity..Lambda.2.lambdaFactory$(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationActivity..Lambda.3.lambdaFactory$(this), ConversationActivity..Lambda.4.lambdaFactory$()));
    MessengerProvider.getInstance().setVisibleConversationId(this.conversationId);
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.chat.ConversationActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/chat/ConversationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */