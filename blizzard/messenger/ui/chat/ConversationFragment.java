package com.blizzard.messenger.ui.chat;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blizzard.messenger.adapter.ChatAdapter;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.chat.ChatMessage;
import com.blizzard.messenger.data.model.chat.ChatModel;
import com.blizzard.messenger.data.model.chat.QualifiedMessageId;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.chat.UnfurlChatMessage;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.profile.Profile;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.databinding.ChatFragmentBinding;
import com.blizzard.messenger.helper.NotificationHelper;
import com.blizzard.messenger.model.ChatErrorOption;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.common.KeyboardAwareEditText;
import com.blizzard.messenger.utils.ColorUtils;
import com.blizzard.messenger.utils.StringUtils;
import com.blizzard.messenger.utils.ViewUtils;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;
import com.jakewharton.rxbinding.widget.RxTextView;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

public class ConversationFragment
  extends Fragment
  implements View.OnClickListener
{
  private static final int DEBOUNCE_TIME_MS = 100;
  private static final int EMPTY_VIEW_TAG = 1;
  private static final String EXTRA_CONVERSATION_ID = "conversationId";
  private static final int FAB_TRANSITION_TIME_MS = 150;
  private static final int MIN_UNSEEN_MESSAGES = 5;
  private static final String TAG = ConversationFragment.class.getSimpleName();
  private static final int TRANSITION_TIME_MS = 300;
  private CompositeSubscription allSubscriptions;
  private ChatFragmentBinding binding;
  private final BehaviorSubject<Boolean> bottomOfViewSubject = BehaviorSubject.create(Boolean.valueOf(true));
  private boolean canLoadMore = true;
  private final PublishSubject<Boolean> canSendSubject = PublishSubject.create();
  private ChatAdapter chatAdapter;
  ChatModel chatModel;
  private Subscription composingTimeoutSubscription;
  private String conversationId;
  @Inject
  FriendsModel friendsModel;
  private boolean isLoading = false;
  private boolean isTyping = false;
  private final BehaviorSubject<Boolean> lastItemsVisibleSubject = BehaviorSubject.create(Boolean.valueOf(true));
  private MediaPlayer mediaPlayer;
  LinearLayoutManager messageLayoutManager;
  @Inject
  ProfileModel profileModel;
  private MessengerProvider provider;
  private Subscription scrollBarSubscription;
  private final PublishSubject<Boolean> topOfViewSubject = PublishSubject.create();
  @Inject
  UnseenConversationModel unseenConversationModel;
  
  private void acknowledgeSeenMessage()
  {
    ViewUtils.reportError(getActivity(), this.provider.acknowledgeConversationSeen(this.conversationId));
  }
  
  private void addChatMessage(ChatMessage paramChatMessage)
  {
    this.chatAdapter.addChatMessage(paramChatMessage);
    if (((Boolean)this.bottomOfViewSubject.getValue()).booleanValue()) {
      scrollToBottom();
    }
    for (;;)
    {
      checkEmptyView();
      return;
      this.lastItemsVisibleSubject.onNext(Boolean.valueOf(lastMessagesVisible()));
    }
  }
  
  private void animateFabActive()
  {
    this.binding.sendMessageButton.hide();
    this.allSubscriptions.add(Completable.timer(150L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.49.lambdaFactory$(this)));
  }
  
  private void animateFabInactive()
  {
    this.binding.sendMessageButton.hide();
    this.allSubscriptions.add(Completable.timer(150L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.50.lambdaFactory$(this)));
  }
  
  private boolean atBottomOfView()
  {
    return this.messageLayoutManager.findLastCompletelyVisibleItemPosition() >= this.chatAdapter.getItemCount() - 1;
  }
  
  private boolean atTopOfView()
  {
    return this.messageLayoutManager.findFirstCompletelyVisibleItemPosition() == 0;
  }
  
  private void checkEmptyView()
  {
    if (this.chatAdapter.getItemCount() > 0)
    {
      this.binding.messagesListView.setVisibility(0);
      this.binding.emptyLayout.setVisibility(8);
      return;
    }
    this.binding.messagesListView.setVisibility(8);
    this.binding.emptyLayout.setVisibility(0);
  }
  
  private void clearChatMessages(String paramString)
  {
    this.chatAdapter.clear();
  }
  
  private void copyMessageText(TextChatMessage paramTextChatMessage)
  {
    StringUtils.copyToClipboard(getActivity(), paramTextChatMessage.getBody());
    ViewUtils.showSnackbar(getContext(), this.binding.getRoot(), getString(2131361952));
  }
  
  private void deleteMessage(ChatMessage paramChatMessage)
  {
    MessengerProvider.getInstance().deleteChatMessage(paramChatMessage.getQualifiedMessageId());
  }
  
  private void handleSendErrorOption(ChatErrorOption paramChatErrorOption)
  {
    String str = paramChatErrorOption.getType();
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (str.equals("com.blizzard.messenger.options.RESEND"))
        {
          i = 0;
          continue;
          if (str.equals("com.blizzard.messenger.options.COPY"))
          {
            i = 1;
            continue;
            if (str.equals("com.blizzard.messenger.options.HIDE")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    resendMessage(paramChatErrorOption.getTextMessage());
    deleteMessage(paramChatErrorOption.getTextMessage());
    return;
    copyMessageText(paramChatErrorOption.getTextMessage());
    return;
    deleteMessage(paramChatErrorOption.getTextMessage());
  }
  
  private void initHistory()
  {
    if ((this.chatAdapter.getItemCount() == 0) || (this.binding.messagesListView.findViewHolderForAdapterPosition(0) != null)) {
      updateHistory();
    }
  }
  
  private boolean lastMessagesVisible()
  {
    return this.messageLayoutManager.findLastVisibleItemPosition() >= this.chatAdapter.getItemCount() - 5;
  }
  
  public static ConversationFragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("conversationId", paramString);
    paramString = new ConversationFragment();
    paramString.setArguments(localBundle);
    return paramString;
  }
  
  private void openLink(String paramString)
  {
    new CustomTabsIntent.Builder().setShowTitle(true).setToolbarColor(ColorUtils.getColorPrimary(getContext())).build().launchUrl(getContext(), Uri.parse(paramString));
  }
  
  private void openUnfurlLink(UnfurlChatMessage paramUnfurlChatMessage)
  {
    if (!paramUnfurlChatMessage.isMine())
    {
      Telemetry.unfurlLinkClicked(paramUnfurlChatMessage.getUrl());
      openLink(paramUnfurlChatMessage.getUrl());
    }
  }
  
  private void removeChatMessage(QualifiedMessageId paramQualifiedMessageId)
  {
    this.chatAdapter.removeChatMessage(paramQualifiedMessageId);
    checkEmptyView();
  }
  
  private void resendMessage(TextChatMessage paramTextChatMessage)
  {
    this.allSubscriptions.add(this.provider.sendWhisper(this.conversationId, paramTextChatMessage.getBody()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.46.lambdaFactory$(), ConversationFragment..Lambda.47.lambdaFactory$()));
  }
  
  private void scrollToBottom()
  {
    if (this.binding.messagesListView.getAdapter().getItemCount() > 0) {
      this.binding.messagesListView.smoothScrollToPosition(this.binding.messagesListView.getAdapter().getItemCount() - 1);
    }
  }
  
  private void sendMessage()
  {
    Object localObject = this.binding.messageEditText.getText().toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      do
      {
        return;
        if (this.friendsModel.findFriendById(this.conversationId) == null) {
          break;
        }
        this.binding.messageEditText.setText("");
      } while (TextUtils.isEmpty(((String)localObject).trim()));
      if (SharedPrefsUtils.isSoundEnabled(getContext())) {
        this.mediaPlayer.start();
      }
      this.allSubscriptions.add(this.provider.sendWhisper(this.conversationId, (String)localObject).toCompletable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.44.lambdaFactory$(this), ConversationFragment..Lambda.45.lambdaFactory$()));
      return;
      localObject = ViewUtils.getErrorFragment(getString(2131361905), getString(2131361904), null, null);
    } while (localObject == null);
    FragmentTransaction localFragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.add((Fragment)localObject, "ErrorFragment");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void setFabActive(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      animateFabActive();
      return;
    }
    animateFabInactive();
  }
  
  private void setMessageSent(Pair<QualifiedMessageId, TextChatMessage> paramPair)
  {
    this.chatAdapter.replaceChatMessage((QualifiedMessageId)paramPair.first, (ChatMessage)paramPair.second);
    if (((TextChatMessage)paramPair.second).equals("com.blizzard.messenger.SENT")) {
      Telemetry.whisperSent(this.conversationId);
    }
    for (;;)
    {
      scrollToBottom();
      return;
      if (((TextChatMessage)paramPair.second).equals("com.blizzard.messenger.SEND_FAILED")) {
        Telemetry.whisperSendFailed(this.conversationId);
      }
    }
  }
  
  private void setScrollButtonVisibility(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.binding.scrollToBottomLinearLayout.getAlpha() == 1.0F))
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this.binding.scrollToBottomLinearLayout, "alpha", new float[] { 1.0F, 0.0F });
      this.binding.scrollToBottomLinearLayout.setClickable(false);
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setInterpolator(new LinearInterpolator());
      localObjectAnimator.start();
    }
    while ((!paramBoolean) || (this.binding.scrollToBottomLinearLayout.getAlpha() != 0.0F)) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.binding.scrollToBottomLinearLayout, "alpha", new float[] { 0.0F, 1.0F });
    this.binding.scrollToBottomLinearLayout.setClickable(true);
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.start();
  }
  
  private void setupChatListeners()
  {
    this.binding.messageEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        PublishSubject localPublishSubject = ConversationFragment.this.canSendSubject;
        if (paramAnonymousEditable.length() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          localPublishSubject.onNext(Boolean.valueOf(bool));
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.binding.messageEditText.onKeyboardOpen().filter(ConversationFragment..Lambda.42.lambdaFactory$()).subscribe(ConversationFragment..Lambda.43.lambdaFactory$(this));
  }
  
  private void setupChatModel()
  {
    this.chatModel = this.provider.createChatModel(this.conversationId);
  }
  
  private void setupEmptyView()
  {
    View localView = ViewUtils.getEmptyView(getActivity(), 2130837682, 2131361847, 2131361909, 0);
    localView.setTag(Integer.valueOf(1));
    this.binding.emptyLayout.addView(localView);
  }
  
  private void setupFriend()
  {
    Friend localFriend = this.friendsModel.findFriendById(this.conversationId);
    if (localFriend != null) {
      updateFriend(localFriend);
    }
  }
  
  private void setupRecyclerView()
  {
    this.messageLayoutManager = new LinearLayoutManager(getActivity());
    this.messageLayoutManager.setOrientation(1);
    this.messageLayoutManager.setStackFromEnd(true);
    this.binding.messagesListView.setLayoutManager(this.messageLayoutManager);
    this.chatAdapter = new ChatAdapter(getActivity());
    this.binding.messagesListView.setAdapter(this.chatAdapter);
    this.binding.messagesListView.getItemAnimator().setChangeDuration(0L);
    this.binding.messagesListView.setVerticalScrollBarEnabled(false);
    this.binding.messagesListView.addOnScrollListener(new RecyclerView.OnScrollListener()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        if (ConversationFragment.this.scrollBarSubscription != null)
        {
          ConversationFragment.this.scrollBarSubscription.unsubscribe();
          ConversationFragment.access$102(ConversationFragment.this, null);
        }
        switch (paramAnonymousInt)
        {
        default: 
          ConversationFragment.this.binding.messagesListView.setVerticalScrollBarEnabled(false);
          return;
        }
        ConversationFragment.access$102(ConversationFragment.this, Completable.timer(250L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).doOnUnsubscribe(ConversationFragment.2..Lambda.1.lambdaFactory$(this)).subscribe(ConversationFragment.2..Lambda.2.lambdaFactory$(this)));
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ConversationFragment.this.topOfViewSubject.onNext(Boolean.valueOf(ConversationFragment.this.atTopOfView()));
        ConversationFragment.this.bottomOfViewSubject.onNext(Boolean.valueOf(ConversationFragment.this.atBottomOfView()));
        ConversationFragment.this.lastItemsVisibleSubject.onNext(Boolean.valueOf(ConversationFragment.this.lastMessagesVisible()));
      }
    });
  }
  
  private void shareUnfurlLink(UnfurlChatMessage paramUnfurlChatMessage)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.TEXT", paramUnfurlChatMessage.getUrl());
    localIntent.setType("text/plain");
    this.binding.bottomSheet.showWithSheetView(new IntentPickerSheetView(getActivity(), localIntent, getString(2131362037), ConversationFragment..Lambda.48.lambdaFactory$(this, paramUnfurlChatMessage, localIntent)));
  }
  
  private void showComposingTextView(Pair<String, String> paramPair)
  {
    String str = (String)paramPair.first;
    paramPair = (String)paramPair.second;
    if (this.conversationId.equals(str))
    {
      if (this.composingTimeoutSubscription != null)
      {
        this.composingTimeoutSubscription.unsubscribe();
        this.composingTimeoutSubscription = null;
      }
      if (!paramPair.equals("com.blizzard.messenger.ACTIVE")) {
        break label87;
      }
      this.chatAdapter.setTyping(false);
      if (((Boolean)this.bottomOfViewSubject.getValue()).booleanValue()) {
        scrollToBottom();
      }
    }
    label87:
    while (!paramPair.equals("com.blizzard.messenger.COMPOSING")) {
      return;
    }
    this.chatAdapter.setTyping(true);
    if (((Boolean)this.bottomOfViewSubject.getValue()).booleanValue()) {
      scrollToBottom();
    }
    this.composingTimeoutSubscription = Observable.timer(7000L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.61.lambdaFactory$(this));
  }
  
  private void startedTyping()
  {
    if (!this.isTyping)
    {
      this.isTyping = true;
      this.allSubscriptions.add(this.provider.setChatState(this.conversationId, "com.blizzard.messenger.COMPOSING").subscribeOn(Schedulers.io()).subscribe(ConversationFragment..Lambda.51.lambdaFactory$(), ConversationFragment..Lambda.52.lambdaFactory$()));
    }
  }
  
  private void stoppedTyping()
  {
    if (this.isTyping)
    {
      this.isTyping = false;
      this.allSubscriptions.add(this.provider.setChatState(this.conversationId, "com.blizzard.messenger.ACTIVE").subscribeOn(Schedulers.io()).subscribe(ConversationFragment..Lambda.53.lambdaFactory$(), ConversationFragment..Lambda.54.lambdaFactory$()));
    }
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
  
  private void updateEmptyView(Friend paramFriend)
  {
    View localView = this.binding.emptyLayout.findViewWithTag(Integer.valueOf(1));
    if (localView != null) {
      if (TextUtils.isEmpty(paramFriend.getFullName())) {
        break label65;
      }
    }
    label65:
    for (paramFriend = paramFriend.getFullName();; paramFriend = paramFriend.getBattleTag())
    {
      paramFriend = getString(2131361909, new Object[] { paramFriend });
      ((TextView)localView.findViewById(2131820691)).setText(paramFriend);
      return;
    }
  }
  
  private void updateFriend(@NonNull Friend paramFriend)
  {
    updateEmptyView(paramFriend);
  }
  
  private void updateHistory()
  {
    if ((!this.isLoading) && (this.canLoadMore))
    {
      this.isLoading = true;
      Subscription localSubscription = Completable.timer(2000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.55.lambdaFactory$(this));
      this.allSubscriptions.add(this.provider.getOldestMessageFromDatastore(this.conversationId).map(ConversationFragment..Lambda.56.lambdaFactory$()).flatMap(ConversationFragment..Lambda.57.lambdaFactory$(this)).toCompletable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnUnsubscribe(ConversationFragment..Lambda.58.lambdaFactory$(this, localSubscription)).subscribe(ConversationFragment..Lambda.59.lambdaFactory$(), ConversationFragment..Lambda.60.lambdaFactory$()));
      this.allSubscriptions.add(localSubscription);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    scrollToBottom();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((MessengerApplication)getActivity().getApplicationContext()).getModelComponent().inject(this);
    this.provider = MessengerProvider.getInstance();
    this.conversationId = getArguments().getString("conversationId");
    this.mediaPlayer = MediaPlayer.create(getContext(), 2131296258);
    setupChatModel();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.binding = ((ChatFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968613, paramViewGroup, false));
    this.binding.sendMessageButton.setEnabled(false);
    this.binding.sendMessageButton.setOnClickListener(ConversationFragment..Lambda.1.lambdaFactory$(this));
    this.binding.scrollToBottomLinearLayout.setOnClickListener(this);
    this.binding.scrollToBottomLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        ConversationFragment.this.binding.scrollToBottomLinearLayout.setAlpha(0.0F);
        ConversationFragment.this.binding.scrollToBottomLinearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    });
    setupRecyclerView();
    setupEmptyView();
    this.chatAdapter.onTextLinkClicked().subscribe(ConversationFragment..Lambda.2.lambdaFactory$(this));
    this.chatAdapter.onTextLongClicked().subscribe(ConversationFragment..Lambda.3.lambdaFactory$(this));
    this.chatAdapter.onUnfurlClicked().subscribe(ConversationFragment..Lambda.4.lambdaFactory$(this));
    this.chatAdapter.onUnfurlShareClicked().subscribe(ConversationFragment..Lambda.5.lambdaFactory$(this));
    this.chatAdapter.onSendErrorOptionClicked().subscribe(ConversationFragment..Lambda.6.lambdaFactory$(this));
    setupChatListeners();
    return this.binding.getRoot();
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
    if (this.scrollBarSubscription != null)
    {
      this.scrollBarSubscription.unsubscribe();
      this.scrollBarSubscription = null;
    }
    if (this.chatAdapter != null) {
      this.chatAdapter.shutdownTts();
    }
    ViewUtils.hideKeyboard(getActivity());
    String str = this.binding.messageEditText.getText().toString();
    Log.d(TAG, "Text To Save: " + str);
    if (!TextUtils.isEmpty(str))
    {
      this.provider.saveUnsentChatText(this.conversationId, str).subscribeOn(Schedulers.io()).doOnSubscribe(ConversationFragment..Lambda.38.lambdaFactory$()).doOnCompleted(ConversationFragment..Lambda.39.lambdaFactory$()).subscribe(ConversationFragment..Lambda.40.lambdaFactory$(), ConversationFragment..Lambda.41.lambdaFactory$()).unsubscribe();
      return;
    }
    Log.d(TAG, "No text to save, deleting unsent chat text");
    this.provider.deleteUnsentChatText(this.conversationId);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!TextUtils.isEmpty(this.conversationId)) {
      new NotificationHelper(getContext()).dismissWhisperNotifications(this.conversationId);
    }
    this.allSubscriptions = new CompositeSubscription();
    Object localObject1 = this.allSubscriptions;
    Observable localObservable = this.provider.getChatHistoryFromDatastore(this.conversationId);
    Object localObject2 = this.provider;
    localObject2.getClass();
    ((CompositeSubscription)localObject1).add(localObservable.doOnNext(ConversationFragment..Lambda.7.lambdaFactory$((MessengerProvider)localObject2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.8.lambdaFactory$(this), ConversationFragment..Lambda.9.lambdaFactory$(), ConversationFragment..Lambda.10.lambdaFactory$(this)));
    localObject1 = this.allSubscriptions;
    localObservable = this.provider.loadUnsentChatText(this.conversationId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    localObject2 = this.binding.messageEditText;
    localObject2.getClass();
    ((CompositeSubscription)localObject1).add(localObservable.subscribe(ConversationFragment..Lambda.11.lambdaFactory$((KeyboardAwareEditText)localObject2), ConversationFragment..Lambda.12.lambdaFactory$(), ConversationFragment..Lambda.13.lambdaFactory$()));
    this.allSubscriptions.add(this.chatModel.onCleared().observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.14.lambdaFactory$(this), ConversationFragment..Lambda.15.lambdaFactory$()));
    this.allSubscriptions.add(this.chatModel.onMessageAdded().observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.16.lambdaFactory$(this), ConversationFragment..Lambda.17.lambdaFactory$()));
    this.allSubscriptions.add(this.chatModel.onMessageRemoved().observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.18.lambdaFactory$(this), ConversationFragment..Lambda.19.lambdaFactory$()));
    this.allSubscriptions.add(this.chatModel.onMessageSent().observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.20.lambdaFactory$(this), ConversationFragment..Lambda.21.lambdaFactory$()));
    this.allSubscriptions.add(this.profileModel.onProfileUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.22.lambdaFactory$(this)));
    this.allSubscriptions.add(this.friendsModel.onFriendUpdated().filter(ConversationFragment..Lambda.23.lambdaFactory$(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.24.lambdaFactory$(this), ConversationFragment..Lambda.25.lambdaFactory$()));
    this.allSubscriptions.add(this.unseenConversationModel.onConversationUnseen(this.conversationId).subscribeOn(Schedulers.io()).filter(ConversationFragment..Lambda.26.lambdaFactory$()).subscribe(ConversationFragment..Lambda.27.lambdaFactory$(this), ConversationFragment..Lambda.28.lambdaFactory$()));
    this.allSubscriptions.add(this.provider.onChatStateChanged().subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.29.lambdaFactory$(this), ConversationFragment..Lambda.30.lambdaFactory$()));
    setupFriend();
    checkEmptyView();
    localObject1 = RxTextView.textChanges(this.binding.messageEditText).filter(ConversationFragment..Lambda.31.lambdaFactory$());
    this.allSubscriptions.add(((Observable)localObject1).debounce(1000L, TimeUnit.MILLISECONDS).subscribe(ConversationFragment..Lambda.32.lambdaFactory$(this)));
    this.allSubscriptions.add(((Observable)localObject1).subscribe(ConversationFragment..Lambda.33.lambdaFactory$(this)));
    this.allSubscriptions.add(this.topOfViewSubject.distinctUntilChanged().filter(ConversationFragment..Lambda.34.lambdaFactory$()).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.35.lambdaFactory$(this)));
    this.allSubscriptions.add(this.lastItemsVisibleSubject.distinctUntilChanged().debounce(100L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.36.lambdaFactory$(this)));
    this.allSubscriptions.add(this.canSendSubject.startWith(Boolean.valueOf(false)).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(ConversationFragment..Lambda.37.lambdaFactory$(this)));
    Telemetry.whisperChatCreated(this.conversationId);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/chat/ConversationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */