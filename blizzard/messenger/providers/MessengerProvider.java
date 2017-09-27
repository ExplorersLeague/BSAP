package com.blizzard.messenger.providers;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.login.manager.LoginManager;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.BlizzardMessenger;
import com.blizzard.messenger.data.BlizzardMessenger.Builder;
import com.blizzard.messenger.data.datastores.ChatHistoryDatastore;
import com.blizzard.messenger.data.datastores.UnsentChatTextDatastore;
import com.blizzard.messenger.data.model.chat.ChatModel;
import com.blizzard.messenger.data.model.chat.NewestMessageModel;
import com.blizzard.messenger.data.model.chat.QualifiedMessageId;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.chat.UnfurlChatMessage;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.data.model.friends.FriendRequest;
import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.data.model.settings.Settings;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import com.blizzard.messenger.data.providers.BgsAuthProvider;
import com.blizzard.messenger.data.providers.BgsAuthProvider.Builder;
import com.blizzard.messenger.data.providers.BgsAuthProvider.Configuration;
import com.blizzard.messenger.data.providers.BgsAuthProvider.Configuration.Builder;
import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import com.blizzard.messenger.data.providers.ConnectionProvider;
import com.blizzard.messenger.data.providers.ConversationProvider;
import com.blizzard.messenger.data.providers.FriendsProvider;
import com.blizzard.messenger.data.providers.PresenceProvider;
import com.blizzard.messenger.data.providers.ProfileProvider;
import com.blizzard.messenger.data.providers.PushNotificationProvider;
import com.blizzard.messenger.data.providers.SettingsProvider;
import com.blizzard.messenger.data.providers.SuggestedFriendsProvider;
import com.blizzard.messenger.data.providers.UnfurlMessageProvider;
import com.blizzard.messenger.data.push.PushRegistration;
import com.blizzard.messenger.data.utils.BgsLocaleUtils;
import com.blizzard.messenger.data.utils.CertificateUtils;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.data.xmpp.impl.IncomingStanzaInterceptor;
import com.blizzard.messenger.data.xmpp.iq.SimpleProfileIQ;
import com.blizzard.messenger.exceptions.AccountMutedException;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.utils.ApplicationMonitor;
import com.blizzard.messenger.utils.NotificationUtils;
import com.blizzard.messenger.utils.StringUtils;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Locale;
import javax.inject.Inject;
import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

public class MessengerProvider
{
  private static final String TAG = MessengerProvider.class.getSimpleName();
  private static MessengerProvider instance;
  @Inject
  ApplicationMonitor applicationMonitor;
  private BgsAuthProvider bgsAuthProvider;
  private BlizzardMessenger blizzardMessenger;
  private ChatHistoryDatastore chatHistoryDatastore;
  private ChatHistoryProvider chatHistoryProvider;
  private ConnectionProvider connectionProvider;
  private BehaviorSubject<String> connectionStateSubject = BehaviorSubject.create("com.blizzard.messenger.DISCONNECTED");
  private ConversationProvider conversationProvider;
  @Inject
  FriendRequestModel friendRequestModel;
  @Inject
  FriendsModel friendsModel;
  private FriendsProvider friendsProvider;
  private BehaviorSubject<String> loginStateSubject = BehaviorSubject.create("com.blizzard.messenger.LOGGED_OUT");
  @Inject
  NewestMessageModel newestMessageModel;
  private PresenceProvider presenceProvider;
  @Inject
  ProfileModel profileModel;
  private ProfileProvider profileProvider;
  private PushNotificationProvider pushNotificationProvider;
  private boolean quickSuspendPresence = false;
  @Inject
  SettingsModel settingsModel;
  private SettingsProvider settingsProvider;
  @Inject
  SuggestedFriendsModel suggestedFriendsModel;
  private SuggestedFriendsProvider suggestedFriendsProvider;
  private UnfurlMessageProvider unfurlMessageProvider;
  @Inject
  UnseenConversationModel unseenConversationModel;
  private UnsentChatTextDatastore unsentChatTextDatastore;
  private String visibleConversationId = "";
  
  private void clearUserCaches()
  {
    this.conversationProvider.deleteConversations();
    this.friendsProvider.clearFriends();
    this.friendsProvider.clearFriendRequests();
    this.suggestedFriendsProvider.clearSuggestedFriends();
    this.unseenConversationModel.clear();
  }
  
  private Completable connect(BgsAuthProvider.Configuration paramConfiguration)
  {
    return Completable.concat(new Completable[] { Completable.complete().doOnSubscribe(MessengerProvider..Lambda.24.lambdaFactory$(this)), this.bgsAuthProvider.authenticate(paramConfiguration).doOnSubscribe(MessengerProvider..Lambda.25.lambdaFactory$()).doOnSuccess(MessengerProvider..Lambda.26.lambdaFactory$()).doOnSuccess(MessengerProvider..Lambda.27.lambdaFactory$()).doOnError(MessengerProvider..Lambda.28.lambdaFactory$()).flatMapCompletable(MessengerProvider..Lambda.29.lambdaFactory$(this, paramConfiguration)).retry(MessengerProvider..Lambda.30.lambdaFactory$()), this.chatHistoryDatastore.initializeDatastore().doOnSubscribe(MessengerProvider..Lambda.31.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.32.lambdaFactory$()), this.profileProvider.retrieveProfile().toCompletable().doOnSubscribe(MessengerProvider..Lambda.33.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.34.lambdaFactory$()).doOnError(MessengerProvider..Lambda.35.lambdaFactory$()), this.settingsProvider.retrieveSettings().flatMapCompletable(MessengerProvider..Lambda.36.lambdaFactory$(this)).doOnSubscribe(MessengerProvider..Lambda.37.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.38.lambdaFactory$()).doOnError(MessengerProvider..Lambda.39.lambdaFactory$()), this.friendsProvider.retrieveFriends().doOnSubscribe(MessengerProvider..Lambda.40.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.41.lambdaFactory$()).doOnError(MessengerProvider..Lambda.42.lambdaFactory$()), this.chatHistoryProvider.getLatestMessages().flatMapCompletable(MessengerProvider..Lambda.43.lambdaFactory$(this)).toCompletable().doOnSubscribe(MessengerProvider..Lambda.44.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.45.lambdaFactory$()).doOnError(MessengerProvider..Lambda.46.lambdaFactory$()), this.presenceProvider.sendPresence().doOnSubscribe(MessengerProvider..Lambda.47.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.48.lambdaFactory$()).doOnError(MessengerProvider..Lambda.49.lambdaFactory$()) }).doOnCompleted(MessengerProvider..Lambda.50.lambdaFactory$(this)).doOnError(MessengerProvider..Lambda.51.lambdaFactory$(this)).doOnUnsubscribe(MessengerProvider..Lambda.52.lambdaFactory$(this));
  }
  
  private void disconnectIfConnecting()
  {
    if (getConnectionState().equals("com.blizzard.messenger.CONNECTING")) {
      this.connectionStateSubject.onNext("com.blizzard.messenger.DISCONNECTED");
    }
  }
  
  private void doPushRegistration(Context paramContext)
  {
    NotificationUtils.registerForPush(paramContext);
  }
  
  private Completable errorIfAccountMuted(Settings paramSettings)
  {
    if (paramSettings.isAccountMute()) {
      return Completable.error(new AccountMutedException());
    }
    return Completable.complete();
  }
  
  private Completable evaluateLatestMessage(TextChatMessage paramTextChatMessage)
  {
    return this.chatHistoryDatastore.getNewestMessage(paramTextChatMessage.getConversationId()).filter(MessengerProvider..Lambda.67.lambdaFactory$(paramTextChatMessage)).flatMapCompletable(MessengerProvider..Lambda.68.lambdaFactory$(this)).toCompletable();
  }
  
  private static X509Certificate[] getCaCerts(Context paramContext)
  {
    try
    {
      paramContext = CertificateUtils.getCertificateChain(paramContext.getAssets().open("cacerts/xmpp_server_chain.pem"));
      return paramContext;
    }
    catch (CertificateException paramContext)
    {
      throw new IllegalStateException("Cannot load messenger server SSL certificate chain", paramContext);
    }
    catch (IOException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static MessengerProvider getInstance()
  {
    if (instance == null) {
      instance = new MessengerProvider();
    }
    return instance;
  }
  
  private void handleAppSuspended()
  {
    disconnect().subscribeOn(Schedulers.io()).subscribe(MessengerProvider..Lambda.65.lambdaFactory$(), MessengerProvider..Lambda.66.lambdaFactory$());
  }
  
  private Completable logout(Context paramContext)
  {
    return Completable.concat(new Completable[] { Completable.complete().doOnSubscribe(MessengerProvider..Lambda.53.lambdaFactory$(this)), NotificationUtils.deregisterForPush(paramContext).doOnSubscribe(MessengerProvider..Lambda.54.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.55.lambdaFactory$()).doOnError(MessengerProvider..Lambda.56.lambdaFactory$()), this.connectionProvider.logout().doOnSubscribe(MessengerProvider..Lambda.57.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.58.lambdaFactory$()).doOnError(MessengerProvider..Lambda.59.lambdaFactory$()), this.connectionProvider.disconnect().doOnSubscribe(MessengerProvider..Lambda.60.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.61.lambdaFactory$()).doOnError(MessengerProvider..Lambda.62.lambdaFactory$()) }).doOnCompleted(MessengerProvider..Lambda.63.lambdaFactory$(this, paramContext)).doOnError(MessengerProvider..Lambda.64.lambdaFactory$(this));
  }
  
  private void showAccountMuteDialog(Context paramContext) {}
  
  private void showLocalWhisperNotification(@NonNull Context paramContext, @NonNull TextChatMessage paramTextChatMessage)
  {
    if (!this.settingsModel.getSettings().isWhisperNotificationsEnabled()) {}
    do
    {
      do
      {
        return;
      } while ((paramTextChatMessage.getSender() == null) || (TextUtils.isEmpty(paramTextChatMessage.getSender())) || (paramTextChatMessage.isMine()) || (paramTextChatMessage.getSender().equals(this.visibleConversationId)));
      localObject = this.friendsModel.findFriendById(paramTextChatMessage.getSender());
    } while (localObject == null);
    if (!TextUtils.isEmpty(((Friend)localObject).getFullName())) {}
    for (Object localObject = StringUtils.getBattleTagName(((Friend)localObject).getBattleTag()) + " (" + ((Friend)localObject).getFullName() + ")";; localObject = StringUtils.getBattleTagName(((Friend)localObject).getBattleTag()))
    {
      NotificationUtils.showLocalWhisperNotification(paramContext, paramTextChatMessage, (String)localObject);
      return;
    }
  }
  
  public Completable acceptFriendRequest(@NonNull FriendRequest paramFriendRequest)
  {
    return this.friendsProvider.acceptFriendRequest(paramFriendRequest);
  }
  
  public Completable acknowledgeConversationSeen(@NonNull String paramString)
  {
    return this.chatHistoryProvider.acknowledgeConversationSeen(paramString);
  }
  
  public Completable addFriend(@NonNull String paramString1, @NonNull String paramString2)
  {
    Telemetry.friendRequestSent(paramString1, paramString2);
    return this.friendsProvider.addFriend(paramString1, paramString2);
  }
  
  public Completable attemptLogout(Context paramContext)
  {
    this.loginStateSubject.onNext("com.blizzard.messenger.LOGGING_OUT");
    return logout(paramContext).doOnSubscribe(MessengerProvider..Lambda.15.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.16.lambdaFactory$(this)).doOnCompleted(MessengerProvider..Lambda.17.lambdaFactory$()).doOnError(MessengerProvider..Lambda.18.lambdaFactory$(this));
  }
  
  public Completable blockFriend(@NonNull String paramString)
  {
    return this.friendsProvider.blockFriend(paramString);
  }
  
  public void clearAuthState(Context paramContext)
  {
    SharedPrefsUtils.setWebAuthToken(paramContext, "");
    SharedPrefsUtils.setBgsAuthCredentials(paramContext, "");
  }
  
  public void clearCookies(Context paramContext)
  {
    String str = SharedPrefsUtils.getWebAuthUrls(paramContext);
    SharedPrefsUtils.setWebAuthUrls(paramContext, "");
    LoginManager.clearCookies(paramContext, str);
  }
  
  public void clearSuggestedFriends()
  {
    this.suggestedFriendsProvider.clearSuggestedFriends();
  }
  
  public ChatModel createChatModel(String paramString)
  {
    paramString = new ChatModel(paramString);
    paramString.setConversationProvider(this.conversationProvider);
    paramString.setChatHistoryProvider(this.chatHistoryProvider);
    paramString.setUnfurlMessageProvider(this.unfurlMessageProvider);
    return paramString;
  }
  
  public void debugSetQuickSuspendPresence(boolean paramBoolean)
  {
    this.quickSuspendPresence = paramBoolean;
  }
  
  public void debugSetTestFailResponses(boolean paramBoolean)
  {
    IncomingStanzaInterceptor.setTestFailResponses(paramBoolean);
    this.friendsProvider.setTestFailResponses(paramBoolean);
    this.presenceProvider.setTestFailResponses(paramBoolean);
  }
  
  public void debugSetTestTimoutResponses(boolean paramBoolean)
  {
    IncomingStanzaInterceptor.setTestTimeoutResponses(paramBoolean);
    this.friendsProvider.setTestTimeoutResponses(paramBoolean);
    this.presenceProvider.setTestTimeoutResponses(paramBoolean);
  }
  
  public Completable declineFriendRequest(@NonNull FriendRequest paramFriendRequest)
  {
    return this.friendsProvider.declineFriendRequest(paramFriendRequest);
  }
  
  public void deleteChatMessage(QualifiedMessageId paramQualifiedMessageId)
  {
    this.conversationProvider.deleteMessage(paramQualifiedMessageId);
  }
  
  public void deleteUnsentChatText(String paramString)
  {
    this.unsentChatTextDatastore.deleteUnsentText(paramString);
  }
  
  public Completable deregisterForPushNotifications(PushRegistration paramPushRegistration)
  {
    return this.pushNotificationProvider.deregisterForPushNotifications(paramPushRegistration);
  }
  
  public Completable disconnect()
  {
    return Completable.concat(new Completable[] { Completable.complete().doOnSubscribe(MessengerProvider..Lambda.19.lambdaFactory$(this)), this.connectionProvider.disconnect().doOnSubscribe(MessengerProvider..Lambda.20.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.21.lambdaFactory$()).doOnError(MessengerProvider..Lambda.22.lambdaFactory$()) }).doOnUnsubscribe(MessengerProvider..Lambda.23.lambdaFactory$(this));
  }
  
  public Observable<TextChatMessage> getChatHistoryFromDatastore(String paramString)
  {
    return this.chatHistoryDatastore.getChatHistory(paramString);
  }
  
  public Observable<TextChatMessage> getChatHistoryFromServer(String paramString, int paramInt, double paramDouble, long paramLong)
  {
    return this.chatHistoryProvider.getChatHistory(paramString, paramInt, paramDouble, paramLong);
  }
  
  public String getConnectionState()
  {
    return (String)this.connectionStateSubject.getValue();
  }
  
  public Observable<String> getHiddenConversations()
  {
    return this.chatHistoryDatastore.getHiddenConversations();
  }
  
  public Observable<TextChatMessage> getLatestMessagesFromDatastore()
  {
    return this.chatHistoryDatastore.getNewestMessages();
  }
  
  public String getLoginState()
  {
    return (String)this.loginStateSubject.getValue();
  }
  
  public Observable<TextChatMessage> getOldestMessageFromDatastore(String paramString)
  {
    return this.chatHistoryDatastore.getOldestMessage(paramString);
  }
  
  public SettingsProvider getSettingsProvider()
  {
    return this.settingsProvider;
  }
  
  public SuggestedFriendsProvider getSuggestedFriendsProvider()
  {
    return this.suggestedFriendsProvider;
  }
  
  public void hideConversation(String paramString)
  {
    this.conversationProvider.hideConversation(paramString);
  }
  
  public void initialize(Context paramContext)
  {
    ((MessengerApplication)paramContext.getApplicationContext()).getModelComponent().inject(this);
    Locale localLocale = Locale.getDefault();
    this.bgsAuthProvider = new BgsAuthProvider.Builder().bgsAppName("BSAp").bgsAppPlatform("And").bgsAppLocale(BgsLocaleUtils.getMappedLocale(localLocale)).webAuthAppName("bsap").webAuthPrimaryColor(2131689491).webAuthPrimaryDarkColor(2131689492).webAuthActionBarTitle(2131361944).webAuthBackgroundImage(2130837610).webAuthActionBarTextColor(2131689499).webAuthErrorLayout(2130968653).webAuthLoadingLayout(2130968654).showDeveloperRegions(false).build();
    this.blizzardMessenger = new BlizzardMessenger.Builder(paramContext).setBgsAuthProvider(this.bgsAuthProvider).build();
    this.chatHistoryDatastore = this.blizzardMessenger.getChatHistoryDatastore();
    this.unsentChatTextDatastore = this.blizzardMessenger.getUnsentChatTextDatastore();
    this.connectionProvider = this.blizzardMessenger.getConnectionProvider();
    this.conversationProvider = this.blizzardMessenger.getConversationProvider();
    this.friendsProvider = this.blizzardMessenger.getFriendsProvider();
    this.settingsProvider = this.blizzardMessenger.getSettingsProvider();
    this.presenceProvider = this.blizzardMessenger.getPresenceProvider();
    this.profileProvider = this.blizzardMessenger.getProfileProvider();
    this.pushNotificationProvider = this.blizzardMessenger.getPushNotificationProvider();
    this.unfurlMessageProvider = this.blizzardMessenger.getUnfurlMessageProvider();
    this.suggestedFriendsProvider = this.blizzardMessenger.getSuggestedFriendsProvider();
    this.chatHistoryProvider = this.blizzardMessenger.getChatHistoryProvider();
    this.friendsModel.setAccountProvider(this.friendsProvider);
    this.friendsModel.setPresenceProvider(this.presenceProvider);
    this.friendRequestModel.setFriendsProvider(this.friendsProvider);
    this.profileModel.setPresenceProvider(this.presenceProvider);
    this.profileModel.setProfileProvider(this.profileProvider);
    this.settingsModel.setSettingsProvider(this.settingsProvider);
    this.suggestedFriendsModel.setSuggestedFriendsProvider(this.suggestedFriendsProvider);
    this.suggestedFriendsModel.setFriendsModel(this.friendsModel);
    this.connectionProvider.setServerCertificateChain(getCaCerts(paramContext));
    this.connectionProvider.onConnectionStateChanged().filter(MessengerProvider..Lambda.1.lambdaFactory$()).subscribe(MessengerProvider..Lambda.2.lambdaFactory$(this));
    this.conversationProvider.onMessageCreated().observeOn(AndroidSchedulers.mainThread()).subscribe(MessengerProvider..Lambda.3.lambdaFactory$(this, paramContext), MessengerProvider..Lambda.4.lambdaFactory$());
    this.friendsProvider.onFriendRequestReceivedWhileForegrounded().observeOn(AndroidSchedulers.mainThread()).subscribe(MessengerProvider..Lambda.5.lambdaFactory$(paramContext), MessengerProvider..Lambda.6.lambdaFactory$());
    this.newestMessageModel.setConversationProvider(this.conversationProvider);
    this.newestMessageModel.setChatHistoryProvider(this.chatHistoryProvider);
    this.newestMessageModel.setChatHistoryDatastore(this.chatHistoryDatastore);
    this.chatHistoryDatastore.setConversationProvider(this.conversationProvider);
    this.chatHistoryDatastore.setChatHistoryProvider(this.chatHistoryProvider);
    this.unseenConversationModel.setProviders(this.chatHistoryProvider, this.conversationProvider);
    this.applicationMonitor.onAppSuspended().subscribe(MessengerProvider..Lambda.7.lambdaFactory$(this));
    this.applicationMonitor.onAppSuspended().subscribe(MessengerProvider..Lambda.8.lambdaFactory$());
  }
  
  public boolean isAppSuspended()
  {
    return this.applicationMonitor.isAppSuspended();
  }
  
  public boolean isConnected()
  {
    return getConnectionState().equals("com.blizzard.messenger.CONNECTED");
  }
  
  public boolean isDisconnected()
  {
    return getConnectionState().equals("com.blizzard.messenger.DISCONNECTED");
  }
  
  public boolean isLoggedIn()
  {
    return getLoginState().equals("com.blizzard.messenger.LOGGED_IN");
  }
  
  public Observable<String> loadUnsentChatText(String paramString)
  {
    return this.unsentChatTextDatastore.getUnsentChatText(paramString);
  }
  
  public Completable login(Context paramContext)
  {
    return login(paramContext, false);
  }
  
  public Completable login(Context paramContext, boolean paramBoolean)
  {
    Log.d(TAG, "login startInErrorState=" + paramBoolean);
    this.loginStateSubject.onNext("com.blizzard.messenger.LOGGING_IN");
    return connect(new BgsAuthProvider.Configuration.Builder().context(paramContext).startInErrorState(paramBoolean).handleWebAuthChallenge(true).handleError(false).build()).doOnSubscribe(MessengerProvider..Lambda.9.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.10.lambdaFactory$(this)).doOnCompleted(MessengerProvider..Lambda.11.lambdaFactory$()).doOnCompleted(MessengerProvider..Lambda.12.lambdaFactory$(this, paramContext)).doOnError(MessengerProvider..Lambda.13.lambdaFactory$(this)).doOnError(MessengerProvider..Lambda.14.lambdaFactory$());
  }
  
  public Completable loginWithError(Context paramContext)
  {
    return login(paramContext, true);
  }
  
  public Observable<Pair<String, String>> onChatStateChanged()
  {
    return this.conversationProvider.onChatStateChanged();
  }
  
  public Observable<String> onConnectionStateChanged()
  {
    return this.connectionStateSubject.onBackpressureLatest().distinctUntilChanged();
  }
  
  public Observable<String> onLoginStateChanged()
  {
    return this.loginStateSubject.onBackpressureLatest().distinctUntilChanged();
  }
  
  public Completable reconnect(Context paramContext)
  {
    return connect(new BgsAuthProvider.Configuration.Builder().context(paramContext).startInErrorState(false).handleWebAuthChallenge(true).handleError(false).build());
  }
  
  public void registerForPushNotifications(PushRegistration paramPushRegistration)
  {
    this.pushNotificationProvider.registerForPushNotifications(paramPushRegistration);
  }
  
  public Completable removeFriend(@NonNull String paramString)
  {
    return this.friendsProvider.removeFriend(paramString);
  }
  
  public Completable reportFriend(@NonNull String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return this.friendsProvider.reportFriend(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void resetVisibleConversationId(@NonNull String paramString)
  {
    if (paramString.equals(this.visibleConversationId)) {
      this.visibleConversationId = "";
    }
  }
  
  public Single<SimpleProfileIQ> retrieveProfile()
  {
    return this.profileProvider.retrieveProfile();
  }
  
  public Completable retrieveSuggestedFriends(int paramInt)
  {
    return this.suggestedFriendsProvider.retrieveSuggestedFriends(paramInt);
  }
  
  public Completable saveUnsentChatText(String paramString1, String paramString2)
  {
    Log.d(TAG, "saveUnsentChatText: " + paramString1 + " " + paramString2);
    return this.unsentChatTextDatastore.setUnsentChatText(paramString1, paramString2);
  }
  
  public Completable sendPresence()
  {
    return this.presenceProvider.sendPresence();
  }
  
  public Single<TextChatMessage> sendWhisper(String paramString1, String paramString2)
  {
    return this.conversationProvider.sendWhisper(paramString1, paramString2);
  }
  
  public Single<String> setChatState(String paramString1, String paramString2)
  {
    return this.conversationProvider.setChatState(paramString1, paramString2);
  }
  
  public Completable setFavoriteStatus(@NonNull String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      Telemetry.friendFavorited(paramString);
    }
    for (;;)
    {
      return this.friendsProvider.setFavoriteStatus(paramString, paramBoolean);
      Telemetry.friendUnfavorited(paramString);
    }
  }
  
  public Completable setPresenceStatus(int paramInt)
  {
    return this.presenceProvider.setPresenceStatus(paramInt);
  }
  
  public void setVisibleConversationId(@NonNull String paramString)
  {
    this.visibleConversationId = paramString;
  }
  
  public void terminate()
  {
    this.blizzardMessenger.terminate();
  }
  
  public Observable<UnfurlChatMessage> unfurlTextMessage(TextChatMessage paramTextChatMessage)
  {
    this.unfurlMessageProvider.unfurlTextMessage(paramTextChatMessage);
    return this.unfurlMessageProvider.onUnfurlMessageCreated();
  }
  
  public Completable updateFriendNote(@NonNull String paramString1, @NonNull String paramString2)
  {
    return this.friendsProvider.updateFriendNote(paramString1, paramString2);
  }
  
  public Completable upgradeFriend(@NonNull String paramString)
  {
    return this.friendsProvider.upgradeFriend(paramString);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/providers/MessengerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */