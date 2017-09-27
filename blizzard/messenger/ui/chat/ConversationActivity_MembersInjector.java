package com.blizzard.messenger.ui.chat;

import com.blizzard.messenger.data.model.friends.FriendsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ConversationActivity_MembersInjector
  implements MembersInjector<ConversationActivity>
{
  private final Provider<FriendsModel> friendsModelProvider;
  
  static
  {
    if (!ConversationActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ConversationActivity_MembersInjector(Provider<FriendsModel> paramProvider)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
  }
  
  public static MembersInjector<ConversationActivity> create(Provider<FriendsModel> paramProvider)
  {
    return new ConversationActivity_MembersInjector(paramProvider);
  }
  
  public static void injectFriendsModel(ConversationActivity paramConversationActivity, Provider<FriendsModel> paramProvider)
  {
    paramConversationActivity.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public void injectMembers(ConversationActivity paramConversationActivity)
  {
    if (paramConversationActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramConversationActivity.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/chat/ConversationActivity_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */