package com.blizzard.messenger.telemetry;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;
import com.blizzard.messenger.constants.AppConstants;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.proto.auth.LoginFailedClasses.LoginFailed;
import com.blizzard.messenger.proto.auth.LoginFailedClasses.LoginFailed.Builder;
import com.blizzard.messenger.proto.auth.LoginStartedClasses.LoginStarted;
import com.blizzard.messenger.proto.auth.LoginStartedClasses.LoginStarted.Builder;
import com.blizzard.messenger.proto.auth.LoginSucceededClasses.LoginSucceeded;
import com.blizzard.messenger.proto.auth.LoginSucceededClasses.LoginSucceeded.Builder;
import com.blizzard.messenger.proto.auth.LogoutClasses.Logout;
import com.blizzard.messenger.proto.auth.LogoutClasses.Logout.Builder;
import com.blizzard.messenger.proto.chat.UnfurlLinkClickedClasses.UnfurlLinkClicked;
import com.blizzard.messenger.proto.chat.UnfurlLinkClickedClasses.UnfurlLinkClicked.Builder;
import com.blizzard.messenger.proto.chat.UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed;
import com.blizzard.messenger.proto.chat.UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed.Builder;
import com.blizzard.messenger.proto.chat.UnfurlLinkSharedClasses.UnfurlLinkShared;
import com.blizzard.messenger.proto.chat.UnfurlLinkSharedClasses.UnfurlLinkShared.Builder;
import com.blizzard.messenger.proto.chat.WhisperChatCreatedClasses.WhisperChatCreated;
import com.blizzard.messenger.proto.chat.WhisperChatCreatedClasses.WhisperChatCreated.Builder;
import com.blizzard.messenger.proto.chat.WhisperChatDeletedClasses.WhisperChatDeleted;
import com.blizzard.messenger.proto.chat.WhisperChatDeletedClasses.WhisperChatDeleted.Builder;
import com.blizzard.messenger.proto.chat.WhisperSendFailedClasses.WhisperSendFailed;
import com.blizzard.messenger.proto.chat.WhisperSendFailedClasses.WhisperSendFailed.Builder;
import com.blizzard.messenger.proto.chat.WhisperSentClasses.WhisperSent;
import com.blizzard.messenger.proto.chat.WhisperSentClasses.WhisperSent.Builder;
import com.blizzard.messenger.proto.flow.AppMainLaunchedClasses.AppMainLaunched;
import com.blizzard.messenger.proto.flow.AppMainLaunchedClasses.AppMainLaunched.Builder;
import com.blizzard.messenger.proto.friends.FriendContextMenuActionTakenClasses.FriendContextMenuActionTaken;
import com.blizzard.messenger.proto.friends.FriendContextMenuActionTakenClasses.FriendContextMenuActionTaken.Builder;
import com.blizzard.messenger.proto.friends.FriendContextMenuInvokedClasses.FriendContextMenuInvoked;
import com.blizzard.messenger.proto.friends.FriendContextMenuInvokedClasses.FriendContextMenuInvoked.Builder;
import com.blizzard.messenger.proto.friends.FriendFavoritedClasses.FriendFavorited;
import com.blizzard.messenger.proto.friends.FriendFavoritedClasses.FriendFavorited.Builder;
import com.blizzard.messenger.proto.friends.FriendNoteRemovedClasses.FriendNoteRemoved;
import com.blizzard.messenger.proto.friends.FriendNoteRemovedClasses.FriendNoteRemoved.Builder;
import com.blizzard.messenger.proto.friends.FriendNoteUpdatedClasses.FriendNoteUpdated;
import com.blizzard.messenger.proto.friends.FriendNoteUpdatedClasses.FriendNoteUpdated.Builder;
import com.blizzard.messenger.proto.friends.FriendRemovedClasses.FriendRemoved;
import com.blizzard.messenger.proto.friends.FriendRemovedClasses.FriendRemoved.Builder;
import com.blizzard.messenger.proto.friends.FriendRequestAcceptedClasses.FriendRequestAccepted;
import com.blizzard.messenger.proto.friends.FriendRequestAcceptedClasses.FriendRequestAccepted.Builder;
import com.blizzard.messenger.proto.friends.FriendRequestDeclinedClasses.FriendRequestDeclined;
import com.blizzard.messenger.proto.friends.FriendRequestDeclinedClasses.FriendRequestDeclined.Builder;
import com.blizzard.messenger.proto.friends.FriendRequestSentClasses.FriendRequestSent;
import com.blizzard.messenger.proto.friends.FriendRequestSentClasses.FriendRequestSent.Builder;
import com.blizzard.messenger.proto.friends.FriendSearchInvokedClasses.FriendSearchInvoked;
import com.blizzard.messenger.proto.friends.FriendSearchInvokedClasses.FriendSearchInvoked.Builder;
import com.blizzard.messenger.proto.friends.FriendUnfavoritedClasses.FriendUnfavorited;
import com.blizzard.messenger.proto.friends.FriendUnfavoritedClasses.FriendUnfavorited.Builder;
import com.blizzard.messenger.proto.friends.FriendUpgradedClasses.FriendUpgraded;
import com.blizzard.messenger.proto.friends.FriendUpgradedClasses.FriendUpgraded.Builder;
import com.blizzard.messenger.proto.notification.NotificationFriendRequestClickedClasses.NotificationFriendRequestClicked;
import com.blizzard.messenger.proto.notification.NotificationFriendRequestClickedClasses.NotificationFriendRequestClicked.Builder;
import com.blizzard.messenger.proto.notification.NotificationWhisperClickedClasses.NotificationWhisperClicked;
import com.blizzard.messenger.proto.notification.NotificationWhisperClickedClasses.NotificationWhisperClicked.Builder;
import com.blizzard.messenger.proto.notification.NotificationWhisperRepliedClasses.NotificationWhisperReplied;
import com.blizzard.messenger.proto.notification.NotificationWhisperRepliedClasses.NotificationWhisperReplied.Builder;
import com.blizzard.messenger.proto.profile.LogoutSelectedClasses.LogoutSelected;
import com.blizzard.messenger.proto.profile.LogoutSelectedClasses.LogoutSelected.Builder;
import com.blizzard.messenger.proto.profile.StatusChangedClasses.StatusChanged;
import com.blizzard.messenger.proto.profile.StatusChangedClasses.StatusChanged.Builder;
import com.blizzard.messenger.proto.settings.SettingsCurrentThemeUpdatedClasses.SettingsCurrentThemeUpdated;
import com.blizzard.messenger.proto.settings.SettingsCurrentThemeUpdatedClasses.SettingsCurrentThemeUpdated.Builder;
import com.blizzard.messenger.proto.settings.SettingsFriendRequestNotificationsUpdatedClasses.SettingsFriendRequestNotificationsUpdated;
import com.blizzard.messenger.proto.settings.SettingsFriendRequestNotificationsUpdatedClasses.SettingsFriendRequestNotificationsUpdated.Builder;
import com.blizzard.messenger.proto.settings.SettingsFriendsListGroupFavoritesUpdatedClasses.SettingsFriendsListGroupFavoritesUpdated;
import com.blizzard.messenger.proto.settings.SettingsFriendsListGroupFavoritesUpdatedClasses.SettingsFriendsListGroupFavoritesUpdated.Builder;
import com.blizzard.messenger.proto.settings.SettingsFriendsListShowBtagRealIdUpdatedClasses.SettingsFriendsListShowBtagRealIdUpdated;
import com.blizzard.messenger.proto.settings.SettingsFriendsListShowBtagRealIdUpdatedClasses.SettingsFriendsListShowBtagRealIdUpdated.Builder;
import com.blizzard.messenger.proto.settings.SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdated;
import com.blizzard.messenger.proto.settings.SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdated.Builder;
import com.blizzard.messenger.proto.settings.SettingsHideFriendsRealIdUpdatedClasses.SettingsHideFriendsRealIdUpdated;
import com.blizzard.messenger.proto.settings.SettingsHideOfflineFriendsUpdatedClasses.SettingsHideOfflineFriendsUpdated;
import com.blizzard.messenger.proto.settings.SettingsHideOfflineFriendsUpdatedClasses.SettingsHideOfflineFriendsUpdated.Builder;
import com.blizzard.messenger.proto.settings.SettingsMatureLanguageFilterUpdatedClasses.SettingsMatureLanguageFilterUpdated;
import com.blizzard.messenger.proto.settings.SettingsMatureLanguageFilterUpdatedClasses.SettingsMatureLanguageFilterUpdated.Builder;
import com.blizzard.messenger.proto.settings.SettingsSoundsUpdatedClasses.SettingsSoundsUpdated;
import com.blizzard.messenger.proto.settings.SettingsSoundsUpdatedClasses.SettingsSoundsUpdated.Builder;
import com.blizzard.messenger.proto.settings.SettingsTextToSpeechUpdatedClasses.SettingsTextToSpeechUpdated;
import com.blizzard.messenger.proto.settings.SettingsTextToSpeechUpdatedClasses.SettingsTextToSpeechUpdated.Builder;
import com.blizzard.messenger.proto.settings.SettingsWhisperNotificationsUpdatedClasses.SettingsWhisperNotificationsUpdated;
import com.blizzard.messenger.proto.settings.SettingsWhisperNotificationsUpdatedClasses.SettingsWhisperNotificationsUpdated.Builder;
import com.blizzard.messenger.proto.users.UserBlockedClasses.UserBlocked;
import com.blizzard.messenger.proto.users.UserBlockedClasses.UserBlocked.Builder;
import com.blizzard.messenger.proto.users.UserReportedClasses.UserReported;
import com.blizzard.messenger.proto.users.UserReportedClasses.UserReported.Builder;
import com.blizzard.telemetry.proto.Context.Builder;
import com.blizzard.telemetry.proto.Context.ProgramInfo;
import com.blizzard.telemetry.proto.Context.ProgramInfo.SdkInfo;
import com.blizzard.telemetry.proto.standard.process.Finish;
import com.blizzard.telemetry.proto.standard.process.Finish.Builder;
import com.blizzard.telemetry.proto.standard.process.Start;
import com.blizzard.telemetry.proto.standard.process.Start.Builder;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import com.blizzard.telemetry.sdk.TelemetryTarget;
import com.blizzard.telemetry.sdk.android.AndroidPlatform;
import com.blizzard.telemetry.sdk.android.AndroidRequestHandler;
import com.blizzard.telemetry.sdk.implementation.TelemetryService;
import com.blizzard.telemetry.sdk.interfaces.Logger.LogLevel;
import java.util.concurrent.Future;

public final class Telemetry
{
  private static final String TAG = Telemetry.class.getSimpleName();
  private static long startTime;
  private static TelemetryService telemetryService;
  
  public static void appMainLaunched(long paramLong, boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(AppMainLaunchedClasses.AppMainLaunched.newBuilder().setElapsedTime(paramLong).setUserInteracted(paramBoolean).build());
  }
  
  private static void checkTelemetryService()
  {
    if (telemetryService == null) {
      throw new IllegalStateException("Telemetry service not initialized");
    }
  }
  
  public static void clearBnetAccountId()
  {
    telemetryService.setDefaultContext((com.blizzard.telemetry.proto.Context)((Context.Builder)telemetryService.getDefaultContext().toBuilder()).clearBnetId().build());
  }
  
  public static void friendContextMenuActionTaken(String paramString1, String paramString2)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendContextMenuActionTakenClasses.FriendContextMenuActionTaken.newBuilder().setFriendId(paramString1).setAction(paramString2).build());
  }
  
  public static void friendContextMenuInvoked(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendContextMenuInvokedClasses.FriendContextMenuInvoked.newBuilder().setFriendId(paramString).build());
  }
  
  public static void friendFavorited(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendFavoritedClasses.FriendFavorited.newBuilder().setFriendId(paramString).build());
  }
  
  public static void friendNoteRemoved(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendNoteRemovedClasses.FriendNoteRemoved.newBuilder().setFriendId(paramString).build());
  }
  
  public static void friendNoteUpdated(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendNoteUpdatedClasses.FriendNoteUpdated.newBuilder().setFriendId(paramString).build());
  }
  
  public static void friendRemoved(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendRemovedClasses.FriendRemoved.newBuilder().setFriendId(paramString).build());
  }
  
  public static void friendRequestAccepted(String paramString1, String paramString2)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendRequestAcceptedClasses.FriendRequestAccepted.newBuilder().setFriendId(paramString1).setAcceptLevel(paramString2).build());
  }
  
  public static void friendRequestDeclined(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendRequestDeclinedClasses.FriendRequestDeclined.newBuilder().setFriendId(paramString).build());
  }
  
  public static void friendRequestSent(String paramString1, String paramString2)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendRequestSentClasses.FriendRequestSent.newBuilder().setFriendId(paramString1).setRequestLevel(paramString2).build());
  }
  
  public static void friendSearchInvoked()
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendSearchInvokedClasses.FriendSearchInvoked.newBuilder().build());
  }
  
  public static void friendUnfavorited(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendUnfavoritedClasses.FriendUnfavorited.newBuilder().setFriendId(paramString).build());
  }
  
  public static void friendUpgraded(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(FriendUpgradedClasses.FriendUpgraded.newBuilder().setFriendId(paramString).build());
  }
  
  public static long getStartTime()
  {
    return startTime;
  }
  
  public static void initialize(android.content.Context paramContext)
  {
    if (telemetryService == null)
    {
      Log.d(TAG, "Starting telemetry...");
      startTime = System.currentTimeMillis();
      Object localObject = SharedPrefsUtils.getLocalPrefs(paramContext);
      localObject = TelemetryOptions.defaults().setPlatform(new AndroidPlatform((SharedPreferences)localObject, paramContext.getApplicationContext())).setLogger(new TelemetryLogger(Telemetry.class, Logger.LogLevel.LOGWARN)).setRequestHandler(new AndroidRequestHandler()).setIsClient(true).setMaxBatchSize(5).setMaxConcurrentRequests(10).addHostTag("development_build").setTarget(TelemetryTarget.valueOf("PRODUCTION")).setCustomPort(0);
      ((TelemetryOptions)localObject).setProgramDetails("bsap", paramContext.getResources().getString(2131361882), AppConstants.getFormattedVersion(paramContext));
      telemetryService = new TelemetryService();
      telemetryService.initialize((TelemetryOptions)localObject);
      registerMessage(LoginStartedClasses.LoginStarted.class);
      registerMessage(LoginSucceededClasses.LoginSucceeded.class);
      registerMessage(LoginFailedClasses.LoginFailed.class);
      registerMessage(LogoutClasses.Logout.class);
      registerMessage(WhisperChatCreatedClasses.WhisperChatCreated.class);
      registerMessage(WhisperChatDeletedClasses.WhisperChatDeleted.class);
      registerMessage(WhisperSentClasses.WhisperSent.class);
      registerMessage(UnfurlLinkClickedClasses.UnfurlLinkClicked.class);
      registerMessage(UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed.class);
      registerMessage(UnfurlLinkSharedClasses.UnfurlLinkShared.class);
      registerMessage(FriendSearchInvokedClasses.FriendSearchInvoked.class);
      registerMessage(FriendFavoritedClasses.FriendFavorited.class);
      registerMessage(FriendUnfavoritedClasses.FriendUnfavorited.class);
      registerMessage(FriendUpgradedClasses.FriendUpgraded.class);
      registerMessage(FriendNoteUpdatedClasses.FriendNoteUpdated.class);
      registerMessage(FriendNoteRemovedClasses.FriendNoteRemoved.class);
      registerMessage(FriendRequestSentClasses.FriendRequestSent.class);
      registerMessage(FriendRequestAcceptedClasses.FriendRequestAccepted.class);
      registerMessage(FriendRequestDeclinedClasses.FriendRequestDeclined.class);
      registerMessage(FriendRemovedClasses.FriendRemoved.class);
      registerMessage(FriendContextMenuInvokedClasses.FriendContextMenuInvoked.class);
      registerMessage(FriendContextMenuActionTakenClasses.FriendContextMenuActionTaken.class);
      registerMessage(LogoutSelectedClasses.LogoutSelected.class);
      registerMessage(StatusChangedClasses.StatusChanged.class);
      registerMessage(NotificationWhisperClickedClasses.NotificationWhisperClicked.class);
      registerMessage(NotificationFriendRequestClickedClasses.NotificationFriendRequestClicked.class);
      registerMessage(NotificationWhisperRepliedClasses.NotificationWhisperReplied.class);
      registerMessage(SettingsCurrentThemeUpdatedClasses.SettingsCurrentThemeUpdated.class);
      registerMessage(SettingsFriendsListGroupFavoritesUpdatedClasses.SettingsFriendsListGroupFavoritesUpdated.class);
      registerMessage(SettingsFriendsListShowBtagRealIdUpdatedClasses.SettingsFriendsListShowBtagRealIdUpdated.class);
      registerMessage(SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdated.class);
      registerMessage(SettingsFriendRequestNotificationsUpdatedClasses.SettingsFriendRequestNotificationsUpdated.class);
      registerMessage(SettingsHideFriendsRealIdUpdatedClasses.SettingsHideFriendsRealIdUpdated.class);
      registerMessage(SettingsHideOfflineFriendsUpdatedClasses.SettingsHideOfflineFriendsUpdated.class);
      registerMessage(SettingsMatureLanguageFilterUpdatedClasses.SettingsMatureLanguageFilterUpdated.class);
      registerMessage(SettingsSoundsUpdatedClasses.SettingsSoundsUpdated.class);
      registerMessage(SettingsTextToSpeechUpdatedClasses.SettingsTextToSpeechUpdated.class);
      registerMessage(SettingsWhisperNotificationsUpdatedClasses.SettingsWhisperNotificationsUpdated.class);
      registerMessage(WhisperSendFailedClasses.WhisperSendFailed.class);
      registerMessage(AppMainLaunchedClasses.AppMainLaunched.class);
      registerMessage(UserBlockedClasses.UserBlocked.class);
      registerMessage(UserReportedClasses.UserReported.class);
      Log.d(TAG, "SDK: '" + telemetryService.getDefaultContext().getProgram().getSdk().getName() + "' + '" + telemetryService.getDefaultContext().getProgram().getSdk().getVersion() + "'");
    }
  }
  
  public static void loginFailed()
  {
    checkTelemetryService();
    telemetryService.enqueue(LoginFailedClasses.LoginFailed.newBuilder().build());
  }
  
  public static void loginStarted()
  {
    checkTelemetryService();
    telemetryService.enqueue(LoginStartedClasses.LoginStarted.newBuilder().build());
  }
  
  public static void loginSucceeded()
  {
    checkTelemetryService();
    telemetryService.enqueue(LoginSucceededClasses.LoginSucceeded.newBuilder().build());
  }
  
  public static void logout(long paramLong)
  {
    checkTelemetryService();
    telemetryService.enqueue(LogoutClasses.Logout.newBuilder().setElapsedTime(paramLong).build());
  }
  
  public static void notificationFriendRequestClicked(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(NotificationFriendRequestClickedClasses.NotificationFriendRequestClicked.newBuilder().setIsInApp(paramBoolean).build());
  }
  
  public static void notificationWhisperClicked(String paramString, boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(NotificationWhisperClickedClasses.NotificationWhisperClicked.newBuilder().setFriendId(paramString).setIsInApp(paramBoolean).build());
  }
  
  public static void notificationWhisperReplied(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(NotificationWhisperRepliedClasses.NotificationWhisperReplied.newBuilder().setFriendId(paramString).build());
  }
  
  public static void profileLogoutSelected()
  {
    checkTelemetryService();
    telemetryService.enqueue(LogoutSelectedClasses.LogoutSelected.newBuilder().build());
  }
  
  public static void profileStatusChanged(int paramInt)
  {
    checkTelemetryService();
    telemetryService.enqueue(StatusChangedClasses.StatusChanged.newBuilder().setStatus(paramInt).build());
  }
  
  public static void programFinished()
  {
    checkTelemetryService();
    telemetryService.enqueue(Finish.newBuilder().build());
  }
  
  public static void programStarted()
  {
    checkTelemetryService();
    telemetryService.enqueue(Start.newBuilder().build());
  }
  
  private static void registerMessage(Class paramClass)
  {
    telemetryService.registerMessageNames(paramClass, "Blizzard.Telemetry.Messenger", paramClass.getSimpleName());
  }
  
  public static void setBnetAccountId(long paramLong)
  {
    telemetryService.setDefaultContext((com.blizzard.telemetry.proto.Context)((Context.Builder)telemetryService.getDefaultContext().toBuilder()).setBnetId(paramLong).build());
  }
  
  public static void settingsCurrentThemeUpdated(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(SettingsCurrentThemeUpdatedClasses.SettingsCurrentThemeUpdated.newBuilder().setLightThemeEnabled(paramBoolean).build());
  }
  
  public static void settingsFriendRequestNotificationsUpdated(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(SettingsFriendRequestNotificationsUpdatedClasses.SettingsFriendRequestNotificationsUpdated.newBuilder().setFriendRequestNotificationsEnabled(paramBoolean).build());
  }
  
  public static void settingsFriendsListGroupFavoritesUpdated(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(SettingsFriendsListGroupFavoritesUpdatedClasses.SettingsFriendsListGroupFavoritesUpdated.newBuilder().setGroupingEnabled(paramBoolean).build());
  }
  
  public static void settingsFriendsListShowBtagRealIdUpdated(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(SettingsFriendsListShowBtagRealIdUpdatedClasses.SettingsFriendsListShowBtagRealIdUpdated.newBuilder().setShowEnabled(paramBoolean).build());
  }
  
  public static void settingsFriendsListSortByActivityUpdated(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdated.newBuilder().setSortEnabled(paramBoolean).build());
  }
  
  public static void settingsHideOfflineFriendsUpdated(int paramInt)
  {
    checkTelemetryService();
    String str = "unknown";
    switch (paramInt)
    {
    }
    for (;;)
    {
      telemetryService.enqueue(SettingsHideOfflineFriendsUpdatedClasses.SettingsHideOfflineFriendsUpdated.newBuilder().setHideCriterion(str).build());
      return;
      str = "all";
      continue;
      str = "elapsed_time";
      continue;
      str = "none";
    }
  }
  
  public static void settingsMatureLanguageFilterUpdated(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(SettingsMatureLanguageFilterUpdatedClasses.SettingsMatureLanguageFilterUpdated.newBuilder().setMatureLanguageFilterEnabled(paramBoolean).build());
  }
  
  public static void settingsSoundsUpdated(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(SettingsSoundsUpdatedClasses.SettingsSoundsUpdated.newBuilder().setSoundsEnabled(paramBoolean).build());
  }
  
  public static void settingsTextToSpeechUpdated(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(SettingsTextToSpeechUpdatedClasses.SettingsTextToSpeechUpdated.newBuilder().setTextToSpeechEnabled(paramBoolean).build());
  }
  
  public static void settingsWhisperNotificationsUpdated(boolean paramBoolean)
  {
    checkTelemetryService();
    telemetryService.enqueue(SettingsWhisperNotificationsUpdatedClasses.SettingsWhisperNotificationsUpdated.newBuilder().setWhisperNotificationsEnabled(paramBoolean).build());
  }
  
  public static void terminate()
  {
    if (telemetryService == null) {
      throw new IllegalStateException("Telemetry not initialized");
    }
    Log.d(TAG, "Terminating telemetry...");
    try
    {
      telemetryService.resume();
      telemetryService.complete().get();
      return;
    }
    catch (Exception localException)
    {
      Log.i(TAG, "Telemetry completion error", localException);
      return;
    }
    finally
    {
      telemetryService.close();
      telemetryService = null;
    }
  }
  
  public static void unfurlLinkClicked(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(UnfurlLinkClickedClasses.UnfurlLinkClicked.newBuilder().setUrl(paramString).build());
  }
  
  public static void unfurlLinkDisplayed(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed.newBuilder().setUrl(paramString).build());
  }
  
  public static void unfurlLinkShared(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(UnfurlLinkSharedClasses.UnfurlLinkShared.newBuilder().setUrl(paramString).build());
  }
  
  public static void userBlocked(String paramString1, String paramString2)
  {
    checkTelemetryService();
    telemetryService.enqueue(UserBlockedClasses.UserBlocked.newBuilder().setUserId(paramString1).setUiContext(paramString2).build());
  }
  
  public static void userReported(String paramString1, String paramString2)
  {
    checkTelemetryService();
    telemetryService.enqueue(UserReportedClasses.UserReported.newBuilder().setUserId(paramString1).setUiContext(paramString2).build());
  }
  
  public static void whisperChatCreated(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(WhisperChatCreatedClasses.WhisperChatCreated.newBuilder().setFriendId(paramString).build());
  }
  
  public static void whisperChatDeleted(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(WhisperChatDeletedClasses.WhisperChatDeleted.newBuilder().setFriendId(paramString).build());
  }
  
  public static void whisperSendFailed(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(WhisperSendFailedClasses.WhisperSendFailed.newBuilder().setFriendId(paramString).build());
  }
  
  public static void whisperSent(String paramString)
  {
    checkTelemetryService();
    telemetryService.enqueue(WhisperSentClasses.WhisperSent.newBuilder().setFriendId(paramString).build());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/telemetry/Telemetry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */