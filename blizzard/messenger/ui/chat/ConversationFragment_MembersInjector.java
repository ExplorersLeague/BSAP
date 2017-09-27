package com.blizzard.messenger.ui.chat;

import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ConversationFragment_MembersInjector
  implements MembersInjector<ConversationFragment>
{
  private final Provider<FriendsModel> friendsModelProvider;
  private final Provider<ProfileModel> profileModelProvider;
  private final Provider<UnseenConversationModel> unseenConversationModelProvider;
  
  static
  {
    if (!ConversationFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ConversationFragment_MembersInjector(Provider<FriendsModel> paramProvider, Provider<ProfileModel> paramProvider1, Provider<UnseenConversationModel> paramProvider2)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
    assert (paramProvider1 != null);
    this.profileModelProvider = paramProvider1;
    assert (paramProvider2 != null);
    this.unseenConversationModelProvider = paramProvider2;
  }
  
  public static MembersInjector<ConversationFragment> create(Provider<FriendsModel> paramProvider, Provider<ProfileModel> paramProvider1, Provider<UnseenConversationModel> paramProvider2)
  {
    return new ConversationFragment_MembersInjector(paramProvider, paramProvider1, paramProvider2);
  }
  
  public static void injectFriendsModel(ConversationFragment paramConversationFragment, Provider<FriendsModel> paramProvider)
  {
    paramConversationFragment.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public static void injectProfileModel(ConversationFragment paramConversationFragment, Provider<ProfileModel> paramProvider)
  {
    paramConversationFragment.profileModel = ((ProfileModel)paramProvider.get());
  }
  
  public static void injectUnseenConversationModel(ConversationFragment paramConversationFragment, Provider<UnseenConversationModel> paramProvider)
  {
    paramConversationFragment.unseenConversationModel = ((UnseenConversationModel)paramProvider.get());
  }
  
  public void injectMembers(ConversationFragment paramConversationFragment)
  {
    if (paramConversationFragment == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramConversationFragment.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
    paramConversationFragment.profileModel = ((ProfileModel)this.profileModelProvider.get());
    paramConversationFragment.unseenConversationModel = ((UnseenConversationModel)this.unseenConversationModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/chat/ConversationFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */