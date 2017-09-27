package com.blizzard.messenger.dagger;

import com.blizzard.messenger.adapter.SuggestedFriendListAdapter;
import com.blizzard.messenger.adapter.SuggestedFriendListAdapter_MembersInjector;
import com.blizzard.messenger.data.model.chat.NewestMessageModel;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.data.model.push.PushNotificationModel;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import com.blizzard.messenger.helper.NotificationHelper;
import com.blizzard.messenger.helper.NotificationHelper_MembersInjector;
import com.blizzard.messenger.helper.SettingsHelper;
import com.blizzard.messenger.helper.SettingsHelper_MembersInjector;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.providers.MessengerProvider_MembersInjector;
import com.blizzard.messenger.receivers.LocaleChangedReceiver;
import com.blizzard.messenger.receivers.LocaleChangedReceiver_MembersInjector;
import com.blizzard.messenger.ui.chat.ChatListFragment;
import com.blizzard.messenger.ui.chat.ChatListFragment_MembersInjector;
import com.blizzard.messenger.ui.chat.ChooseFriendActivity;
import com.blizzard.messenger.ui.chat.ConversationActivity;
import com.blizzard.messenger.ui.chat.ConversationActivity_MembersInjector;
import com.blizzard.messenger.ui.chat.ConversationFragment;
import com.blizzard.messenger.ui.chat.ConversationFragment_MembersInjector;
import com.blizzard.messenger.ui.friends.FriendProfileDialogFragment;
import com.blizzard.messenger.ui.friends.FriendProfileDialogFragment_MembersInjector;
import com.blizzard.messenger.ui.friends.FriendsListFragment;
import com.blizzard.messenger.ui.friends.FriendsListFragment_MembersInjector;
import com.blizzard.messenger.ui.friends.ViewFriendsActivity;
import com.blizzard.messenger.ui.friends.ViewFriendsActivity_MembersInjector;
import com.blizzard.messenger.ui.friends.management.FindFriendsActivity;
import com.blizzard.messenger.ui.friends.management.FindFriendsActivity_MembersInjector;
import com.blizzard.messenger.ui.friends.management.FriendRequestListFragment;
import com.blizzard.messenger.ui.friends.management.FriendRequestListFragment_MembersInjector;
import com.blizzard.messenger.ui.friends.management.ReportUserActivity;
import com.blizzard.messenger.ui.friends.management.ReportUserActivity_MembersInjector;
import com.blizzard.messenger.ui.friends.management.UpdateFriendNoteActivity;
import com.blizzard.messenger.ui.friends.management.UpdateFriendNoteActivity_MembersInjector;
import com.blizzard.messenger.ui.friends.qr.ShowQRCodeActivity;
import com.blizzard.messenger.ui.friends.qr.ShowQRCodeActivity_MembersInjector;
import com.blizzard.messenger.ui.main.MainActivity;
import com.blizzard.messenger.ui.main.MainActivity_MembersInjector;
import com.blizzard.messenger.ui.profile.ProfileFragment;
import com.blizzard.messenger.ui.profile.ProfileFragment_MembersInjector;
import com.blizzard.messenger.ui.settings.AppSettingsFragment;
import com.blizzard.messenger.ui.settings.AppSettingsFragment_MembersInjector;
import com.blizzard.messenger.ui.settings.NotificationsFragment;
import com.blizzard.messenger.ui.settings.NotificationsFragment_MembersInjector;
import com.blizzard.messenger.utils.ApplicationMonitor;
import com.blizzard.messenger.views.dialog.FriendRequestDialogFragment;
import com.blizzard.messenger.views.dialog.FriendRequestDialogFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerMessengerComponent
  implements MessengerComponent
{
  private MembersInjector<AppSettingsFragment> appSettingsFragmentMembersInjector;
  private MembersInjector<ChatListFragment> chatListFragmentMembersInjector;
  private MembersInjector<ConversationActivity> conversationActivityMembersInjector;
  private MembersInjector<ConversationFragment> conversationFragmentMembersInjector;
  private MembersInjector<FindFriendsActivity> findFriendsActivityMembersInjector;
  private MembersInjector<FriendProfileDialogFragment> friendProfileDialogFragmentMembersInjector;
  private MembersInjector<FriendRequestDialogFragment> friendRequestDialogFragmentMembersInjector;
  private MembersInjector<FriendRequestListFragment> friendRequestListFragmentMembersInjector;
  private MembersInjector<FriendsListFragment> friendsListFragmentMembersInjector;
  private MembersInjector<LocaleChangedReceiver> localeChangedReceiverMembersInjector;
  private MembersInjector<MainActivity> mainActivityMembersInjector;
  private MembersInjector<MessengerProvider> messengerProviderMembersInjector;
  private MembersInjector<NotificationHelper> notificationHelperMembersInjector;
  private MembersInjector<NotificationsFragment> notificationsFragmentMembersInjector;
  private MembersInjector<ProfileFragment> profileFragmentMembersInjector;
  private Provider<ApplicationMonitor> provideApplicationMonitorProvider;
  private Provider<FriendRequestModel> provideFriendRequestModelProvider;
  private Provider<FriendsModel> provideFriendsModelProvider;
  private Provider<NewestMessageModel> provideMessageExtentsModelProvider;
  private Provider<ProfileModel> provideProfileModelProvider;
  private Provider<PushNotificationModel> providePushNotificationModelProvider;
  private Provider<UnseenConversationModel> provideSeenConversationModelProvider;
  private Provider<SettingsModel> provideSettingsModelProvider;
  private Provider<SuggestedFriendsModel> provideSuggestedFriendsModelProvider;
  private MembersInjector<ReportUserActivity> reportUserActivityMembersInjector;
  private MembersInjector<SettingsHelper> settingsHelperMembersInjector;
  private MembersInjector<ShowQRCodeActivity> showQRCodeActivityMembersInjector;
  private MembersInjector<SuggestedFriendListAdapter> suggestedFriendListAdapterMembersInjector;
  private MembersInjector<UpdateFriendNoteActivity> updateFriendNoteActivityMembersInjector;
  private MembersInjector<ViewFriendsActivity> viewFriendsActivityMembersInjector;
  
  static
  {
    if (!DaggerMessengerComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerMessengerComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    initialize(paramBuilder);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private void initialize(Builder paramBuilder)
  {
    this.provideSettingsModelProvider = DoubleCheck.provider(ModelModule_ProvideSettingsModelFactory.create(paramBuilder.modelModule));
    this.appSettingsFragmentMembersInjector = AppSettingsFragment_MembersInjector.create(this.provideSettingsModelProvider);
    this.provideFriendsModelProvider = DoubleCheck.provider(ModelModule_ProvideFriendsModelFactory.create(paramBuilder.modelModule));
    this.provideMessageExtentsModelProvider = DoubleCheck.provider(ModelModule_ProvideMessageExtentsModelFactory.create(paramBuilder.modelModule));
    this.provideProfileModelProvider = DoubleCheck.provider(ModelModule_ProvideProfileModelFactory.create(paramBuilder.modelModule));
    this.provideSeenConversationModelProvider = DoubleCheck.provider(ModelModule_ProvideSeenConversationModelFactory.create(paramBuilder.modelModule));
    this.chatListFragmentMembersInjector = ChatListFragment_MembersInjector.create(this.provideFriendsModelProvider, this.provideMessageExtentsModelProvider, this.provideProfileModelProvider, this.provideSeenConversationModelProvider);
    this.conversationActivityMembersInjector = ConversationActivity_MembersInjector.create(this.provideFriendsModelProvider);
    this.conversationFragmentMembersInjector = ConversationFragment_MembersInjector.create(this.provideFriendsModelProvider, this.provideProfileModelProvider, this.provideSeenConversationModelProvider);
    this.provideApplicationMonitorProvider = DoubleCheck.provider(AppModule_ProvideApplicationMonitorFactory.create(paramBuilder.appModule));
    this.provideFriendRequestModelProvider = DoubleCheck.provider(ModelModule_ProvideFriendRequestModelFactory.create(paramBuilder.modelModule));
    this.provideSuggestedFriendsModelProvider = DoubleCheck.provider(ModelModule_ProvideSuggestedFriendsModelFactory.create(paramBuilder.modelModule));
    this.messengerProviderMembersInjector = MessengerProvider_MembersInjector.create(this.provideApplicationMonitorProvider, this.provideFriendsModelProvider, this.provideFriendRequestModelProvider, this.provideMessageExtentsModelProvider, this.provideProfileModelProvider, this.provideSeenConversationModelProvider, this.provideSettingsModelProvider, this.provideSuggestedFriendsModelProvider);
    this.findFriendsActivityMembersInjector = FindFriendsActivity_MembersInjector.create(this.provideSuggestedFriendsModelProvider, this.provideProfileModelProvider);
    this.friendsListFragmentMembersInjector = FriendsListFragment_MembersInjector.create(this.provideFriendsModelProvider, this.provideFriendRequestModelProvider, this.provideProfileModelProvider);
    this.friendProfileDialogFragmentMembersInjector = FriendProfileDialogFragment_MembersInjector.create(this.provideFriendsModelProvider);
    this.friendRequestDialogFragmentMembersInjector = FriendRequestDialogFragment_MembersInjector.create(this.provideFriendsModelProvider, this.provideProfileModelProvider);
    this.friendRequestListFragmentMembersInjector = FriendRequestListFragment_MembersInjector.create(this.provideFriendRequestModelProvider);
    this.localeChangedReceiverMembersInjector = LocaleChangedReceiver_MembersInjector.create(this.provideSettingsModelProvider);
    this.notificationsFragmentMembersInjector = NotificationsFragment_MembersInjector.create(this.provideSettingsModelProvider);
    this.providePushNotificationModelProvider = DoubleCheck.provider(ModelModule_ProvidePushNotificationModelFactory.create(paramBuilder.modelModule));
    this.notificationHelperMembersInjector = NotificationHelper_MembersInjector.create(this.providePushNotificationModelProvider);
    this.mainActivityMembersInjector = MainActivity_MembersInjector.create(this.provideFriendsModelProvider, this.provideFriendRequestModelProvider, this.provideSeenConversationModelProvider);
    this.profileFragmentMembersInjector = ProfileFragment_MembersInjector.create(this.provideProfileModelProvider);
    this.reportUserActivityMembersInjector = ReportUserActivity_MembersInjector.create(this.provideFriendsModelProvider);
    this.settingsHelperMembersInjector = SettingsHelper_MembersInjector.create(this.provideSettingsModelProvider, this.provideFriendsModelProvider);
    this.showQRCodeActivityMembersInjector = ShowQRCodeActivity_MembersInjector.create(this.provideProfileModelProvider);
    this.suggestedFriendListAdapterMembersInjector = SuggestedFriendListAdapter_MembersInjector.create(this.provideFriendsModelProvider);
    this.updateFriendNoteActivityMembersInjector = UpdateFriendNoteActivity_MembersInjector.create(this.provideFriendsModelProvider);
    this.viewFriendsActivityMembersInjector = ViewFriendsActivity_MembersInjector.create(this.provideFriendsModelProvider);
  }
  
  public void inject(SuggestedFriendListAdapter paramSuggestedFriendListAdapter)
  {
    this.suggestedFriendListAdapterMembersInjector.injectMembers(paramSuggestedFriendListAdapter);
  }
  
  public void inject(NotificationHelper paramNotificationHelper)
  {
    this.notificationHelperMembersInjector.injectMembers(paramNotificationHelper);
  }
  
  public void inject(SettingsHelper paramSettingsHelper)
  {
    this.settingsHelperMembersInjector.injectMembers(paramSettingsHelper);
  }
  
  public void inject(MessengerProvider paramMessengerProvider)
  {
    this.messengerProviderMembersInjector.injectMembers(paramMessengerProvider);
  }
  
  public void inject(LocaleChangedReceiver paramLocaleChangedReceiver)
  {
    this.localeChangedReceiverMembersInjector.injectMembers(paramLocaleChangedReceiver);
  }
  
  public void inject(ChatListFragment paramChatListFragment)
  {
    this.chatListFragmentMembersInjector.injectMembers(paramChatListFragment);
  }
  
  public void inject(ChooseFriendActivity paramChooseFriendActivity)
  {
    MembersInjectors.noOp().injectMembers(paramChooseFriendActivity);
  }
  
  public void inject(ConversationActivity paramConversationActivity)
  {
    this.conversationActivityMembersInjector.injectMembers(paramConversationActivity);
  }
  
  public void inject(ConversationFragment paramConversationFragment)
  {
    this.conversationFragmentMembersInjector.injectMembers(paramConversationFragment);
  }
  
  public void inject(FriendProfileDialogFragment paramFriendProfileDialogFragment)
  {
    this.friendProfileDialogFragmentMembersInjector.injectMembers(paramFriendProfileDialogFragment);
  }
  
  public void inject(FriendsListFragment paramFriendsListFragment)
  {
    this.friendsListFragmentMembersInjector.injectMembers(paramFriendsListFragment);
  }
  
  public void inject(ViewFriendsActivity paramViewFriendsActivity)
  {
    this.viewFriendsActivityMembersInjector.injectMembers(paramViewFriendsActivity);
  }
  
  public void inject(FindFriendsActivity paramFindFriendsActivity)
  {
    this.findFriendsActivityMembersInjector.injectMembers(paramFindFriendsActivity);
  }
  
  public void inject(FriendRequestListFragment paramFriendRequestListFragment)
  {
    this.friendRequestListFragmentMembersInjector.injectMembers(paramFriendRequestListFragment);
  }
  
  public void inject(ReportUserActivity paramReportUserActivity)
  {
    this.reportUserActivityMembersInjector.injectMembers(paramReportUserActivity);
  }
  
  public void inject(UpdateFriendNoteActivity paramUpdateFriendNoteActivity)
  {
    this.updateFriendNoteActivityMembersInjector.injectMembers(paramUpdateFriendNoteActivity);
  }
  
  public void inject(ShowQRCodeActivity paramShowQRCodeActivity)
  {
    this.showQRCodeActivityMembersInjector.injectMembers(paramShowQRCodeActivity);
  }
  
  public void inject(MainActivity paramMainActivity)
  {
    this.mainActivityMembersInjector.injectMembers(paramMainActivity);
  }
  
  public void inject(ProfileFragment paramProfileFragment)
  {
    this.profileFragmentMembersInjector.injectMembers(paramProfileFragment);
  }
  
  public void inject(AppSettingsFragment paramAppSettingsFragment)
  {
    this.appSettingsFragmentMembersInjector.injectMembers(paramAppSettingsFragment);
  }
  
  public void inject(NotificationsFragment paramNotificationsFragment)
  {
    this.notificationsFragmentMembersInjector.injectMembers(paramNotificationsFragment);
  }
  
  public void inject(FriendRequestDialogFragment paramFriendRequestDialogFragment)
  {
    this.friendRequestDialogFragmentMembersInjector.injectMembers(paramFriendRequestDialogFragment);
  }
  
  public static final class Builder
  {
    private AppModule appModule;
    private ModelModule modelModule;
    
    public Builder appModule(AppModule paramAppModule)
    {
      this.appModule = ((AppModule)Preconditions.checkNotNull(paramAppModule));
      return this;
    }
    
    public MessengerComponent build()
    {
      if (this.modelModule == null) {
        throw new IllegalStateException(ModelModule.class.getCanonicalName() + " must be set");
      }
      if (this.appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerMessengerComponent(this, null);
    }
    
    public Builder modelModule(ModelModule paramModelModule)
    {
      this.modelModule = ((ModelModule)Preconditions.checkNotNull(paramModelModule));
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/DaggerMessengerComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */