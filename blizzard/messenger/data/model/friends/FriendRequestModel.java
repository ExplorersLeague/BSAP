package com.blizzard.messenger.data.model.friends;

import android.support.annotation.NonNull;
import com.blizzard.messenger.data.providers.FriendsProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.subjects.PublishSubject;

public final class FriendRequestModel
{
  private Observable<FriendRequest> friendRequestAddedObservable;
  private Observable<String> friendRequestRemovedObservable;
  private final Map<String, FriendRequest> friendRequests = new HashMap();
  private final PublishSubject<List<FriendRequest>> friendRequestsUpdatedSubject = PublishSubject.create();
  
  private void addFriendRequest(@NonNull FriendRequest paramFriendRequest)
  {
    try
    {
      if (!this.friendRequests.containsKey(paramFriendRequest.getAccountId()))
      {
        this.friendRequests.put(paramFriendRequest.getAccountId(), paramFriendRequest);
        this.friendRequestsUpdatedSubject.onNext(getFriendRequests());
      }
      return;
    }
    finally
    {
      paramFriendRequest = finally;
      throw paramFriendRequest;
    }
  }
  
  private void clearFriendRequests()
  {
    this.friendRequests.clear();
    this.friendRequestsUpdatedSubject.onNext(Collections.EMPTY_LIST);
  }
  
  private void deleteFriendRequest(@NonNull String paramString)
  {
    try
    {
      if (this.friendRequests.containsKey(paramString))
      {
        this.friendRequests.remove(paramString);
        this.friendRequestsUpdatedSubject.onNext(getFriendRequests());
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public List<FriendRequest> getFriendRequests()
  {
    return new ArrayList(this.friendRequests.values());
  }
  
  public Observable<FriendRequest> onFriendRequestAdded()
  {
    return this.friendRequestAddedObservable;
  }
  
  public Observable<List<FriendRequest>> onFriendRequestsUpdated()
  {
    return Observable.just(getFriendRequests()).concatWith(this.friendRequestsUpdatedSubject).distinctUntilChanged();
  }
  
  public void setFriendsProvider(@NonNull FriendsProvider paramFriendsProvider)
  {
    this.friendRequestAddedObservable = paramFriendsProvider.onFriendRequestReceived();
    this.friendRequestRemovedObservable = paramFriendsProvider.onFriendRequestDeleted();
    this.friendRequestAddedObservable.subscribe(FriendRequestModel..Lambda.1.lambdaFactory$(this), FriendRequestModel..Lambda.2.lambdaFactory$());
    this.friendRequestRemovedObservable.subscribe(FriendRequestModel..Lambda.3.lambdaFactory$(this), FriendRequestModel..Lambda.4.lambdaFactory$());
    paramFriendsProvider.onFriendRequestsCleared().subscribe(FriendRequestModel..Lambda.5.lambdaFactory$(this));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/friends/FriendRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */