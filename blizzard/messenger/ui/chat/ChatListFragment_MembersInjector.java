package com.blizzard.messenger.ui.chat;

import com.blizzard.messenger.data.model.chat.NewestMessageModel;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ChatListFragment_MembersInjector
  implements MembersInjector<ChatListFragment>
{
  private final Provider<FriendsModel> friendsModelProvider;
  private final Provider<NewestMessageModel> newestMessageModelProvider;
  private final Provider<ProfileModel> profileModelProvider;
  private final Provider<UnseenConversationModel> unseenConversationModelProvider;
  
  static
  {
    if (!ChatListFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ChatListFragment_MembersInjector(Provider<FriendsModel> paramProvider, Provider<NewestMessageModel> paramProvider1, Provider<ProfileModel> paramProvider2, Provider<UnseenConversationModel> paramProvider3)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
    assert (paramProvider1 != null);
    this.newestMessageModelProvider = paramProvider1;
    assert (paramProvider2 != null);
    this.profileModelProvider = paramProvider2;
    assert (paramProvider3 != null);
    this.unseenConversationModelProvider = paramProvider3;
  }
  
  public static MembersInjector<ChatListFragment> create(Provider<FriendsModel> paramProvider, Provider<NewestMessageModel> paramProvider1, Provider<ProfileModel> paramProvider2, Provider<UnseenConversationModel> paramProvider3)
  {
    return new ChatListFragment_MembersInjector(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }
  
  public static void injectFriendsModel(ChatListFragment paramChatListFragment, Provider<FriendsModel> paramProvider)
  {
    paramChatListFragment.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public static void injectNewestMessageModel(ChatListFragment paramChatListFragment, Provider<NewestMessageModel> paramProvider)
  {
    paramChatListFragment.newestMessageModel = ((NewestMessageModel)paramProvider.get());
  }
  
  public static void injectProfileModel(ChatListFragment paramChatListFragment, Provider<ProfileModel> paramProvider)
  {
    paramChatListFragment.profileModel = ((ProfileModel)paramProvider.get());
  }
  
  public static void injectUnseenConversationModel(ChatListFragment paramChatListFragment, Provider<UnseenConversationModel> paramProvider)
  {
    paramChatListFragment.unseenConversationModel = ((UnseenConversationModel)paramProvider.get());
  }
  
  public void injectMembers(ChatListFragment paramChatListFragment)
  {
    if (paramChatListFragment == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramChatListFragment.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
    paramChatListFragment.newestMessageModel = ((NewestMessageModel)this.newestMessageModelProvider.get());
    paramChatListFragment.profileModel = ((ProfileModel)this.profileModelProvider.get());
    paramChatListFragment.unseenConversationModel = ((UnseenConversationModel)this.unseenConversationModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/chat/ChatListFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */