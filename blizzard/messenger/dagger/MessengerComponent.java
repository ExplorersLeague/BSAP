package com.blizzard.messenger.dagger;

import com.blizzard.messenger.adapter.SuggestedFriendListAdapter;
import com.blizzard.messenger.helper.NotificationHelper;
import com.blizzard.messenger.helper.SettingsHelper;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.receivers.LocaleChangedReceiver;
import com.blizzard.messenger.ui.chat.ChatListFragment;
import com.blizzard.messenger.ui.chat.ChooseFriendActivity;
import com.blizzard.messenger.ui.chat.ConversationActivity;
import com.blizzard.messenger.ui.chat.ConversationFragment;
import com.blizzard.messenger.ui.friends.FriendProfileDialogFragment;
import com.blizzard.messenger.ui.friends.FriendsListFragment;
import com.blizzard.messenger.ui.friends.ViewFriendsActivity;
import com.blizzard.messenger.ui.friends.management.FindFriendsActivity;
import com.blizzard.messenger.ui.friends.management.FriendRequestListFragment;
import com.blizzard.messenger.ui.friends.management.ReportUserActivity;
import com.blizzard.messenger.ui.friends.management.UpdateFriendNoteActivity;
import com.blizzard.messenger.ui.friends.qr.ShowQRCodeActivity;
import com.blizzard.messenger.ui.main.MainActivity;
import com.blizzard.messenger.ui.profile.ProfileFragment;
import com.blizzard.messenger.ui.settings.AppSettingsFragment;
import com.blizzard.messenger.ui.settings.NotificationsFragment;
import com.blizzard.messenger.views.dialog.FriendRequestDialogFragment;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules={AppModule.class, ModelModule.class})
@Singleton
public abstract interface MessengerComponent
{
  public abstract void inject(SuggestedFriendListAdapter paramSuggestedFriendListAdapter);
  
  public abstract void inject(NotificationHelper paramNotificationHelper);
  
  public abstract void inject(SettingsHelper paramSettingsHelper);
  
  public abstract void inject(MessengerProvider paramMessengerProvider);
  
  public abstract void inject(LocaleChangedReceiver paramLocaleChangedReceiver);
  
  public abstract void inject(ChatListFragment paramChatListFragment);
  
  public abstract void inject(ChooseFriendActivity paramChooseFriendActivity);
  
  public abstract void inject(ConversationActivity paramConversationActivity);
  
  public abstract void inject(ConversationFragment paramConversationFragment);
  
  public abstract void inject(FriendProfileDialogFragment paramFriendProfileDialogFragment);
  
  public abstract void inject(FriendsListFragment paramFriendsListFragment);
  
  public abstract void inject(ViewFriendsActivity paramViewFriendsActivity);
  
  public abstract void inject(FindFriendsActivity paramFindFriendsActivity);
  
  public abstract void inject(FriendRequestListFragment paramFriendRequestListFragment);
  
  public abstract void inject(ReportUserActivity paramReportUserActivity);
  
  public abstract void inject(UpdateFriendNoteActivity paramUpdateFriendNoteActivity);
  
  public abstract void inject(ShowQRCodeActivity paramShowQRCodeActivity);
  
  public abstract void inject(MainActivity paramMainActivity);
  
  public abstract void inject(ProfileFragment paramProfileFragment);
  
  public abstract void inject(AppSettingsFragment paramAppSettingsFragment);
  
  public abstract void inject(NotificationsFragment paramNotificationsFragment);
  
  public abstract void inject(FriendRequestDialogFragment paramFriendRequestDialogFragment);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/MessengerComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */