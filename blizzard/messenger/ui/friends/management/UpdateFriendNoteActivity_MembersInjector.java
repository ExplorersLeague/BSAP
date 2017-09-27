package com.blizzard.messenger.ui.friends.management;

import com.blizzard.messenger.data.model.friends.FriendsModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class UpdateFriendNoteActivity_MembersInjector
  implements MembersInjector<UpdateFriendNoteActivity>
{
  private final Provider<FriendsModel> friendsModelProvider;
  
  static
  {
    if (!UpdateFriendNoteActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UpdateFriendNoteActivity_MembersInjector(Provider<FriendsModel> paramProvider)
  {
    assert (paramProvider != null);
    this.friendsModelProvider = paramProvider;
  }
  
  public static MembersInjector<UpdateFriendNoteActivity> create(Provider<FriendsModel> paramProvider)
  {
    return new UpdateFriendNoteActivity_MembersInjector(paramProvider);
  }
  
  public static void injectFriendsModel(UpdateFriendNoteActivity paramUpdateFriendNoteActivity, Provider<FriendsModel> paramProvider)
  {
    paramUpdateFriendNoteActivity.friendsModel = ((FriendsModel)paramProvider.get());
  }
  
  public void injectMembers(UpdateFriendNoteActivity paramUpdateFriendNoteActivity)
  {
    if (paramUpdateFriendNoteActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramUpdateFriendNoteActivity.friendsModel = ((FriendsModel)this.friendsModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/UpdateFriendNoteActivity_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */