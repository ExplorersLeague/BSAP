package com.blizzard.messenger.data.model.friends;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.blizzard.messenger.data.model.presence.BlizzardPresence;
import com.blizzard.messenger.data.providers.FriendsProvider;
import com.blizzard.messenger.data.providers.PresenceProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.observables.BlockingObservable;
import rx.subjects.PublishSubject;

public final class FriendsModel
{
  private final Context context;
  private final Map<String, FriendAccount> friendAccountMap = new HashMap();
  private final PublishSubject<Friend> friendAddedSubject = PublishSubject.create();
  private final PublishSubject<Friend> friendRemovedSubject = PublishSubject.create();
  private final PublishSubject<Friend> friendSubject = PublishSubject.create();
  private List<Friend> friends = Collections.unmodifiableList(Collections.emptyList());
  private final PublishSubject<List<Friend>> friendsListSubject = PublishSubject.create();
  private final Map<String, BlizzardPresence> presenceMap = new HashMap();
  
  public FriendsModel(@NonNull Context paramContext)
  {
    this.context = paramContext;
    this.friendSubject.subscribe(FriendsModel..Lambda.1.lambdaFactory$(this));
  }
  
  @Nullable
  private Friend buildFriend(@NonNull String paramString)
  {
    Object localObject = (FriendAccount)this.friendAccountMap.get(paramString);
    if (localObject == null) {
      return null;
    }
    localObject = new Friend.Builder((FriendAccount)localObject);
    paramString = (BlizzardPresence)this.presenceMap.get(paramString);
    if (paramString != null) {
      ((Friend.Builder)localObject).setPresence(paramString);
    }
    return ((Friend.Builder)localObject).build();
  }
  
  private void clearFriends()
  {
    this.friendAccountMap.clear();
    this.presenceMap.clear();
    this.friends = Collections.emptyList();
    this.friendsListSubject.onNext(this.friends);
  }
  
  private void deleteFriend(@NonNull String paramString)
  {
    try
    {
      this.friendAccountMap.remove(paramString);
      this.presenceMap.remove(paramString);
      Friend localFriend = findFriendById(paramString);
      if (localFriend != null)
      {
        this.friends = ((List)Observable.from(this.friends).filter(FriendsModel..Lambda.12.lambdaFactory$(paramString)).toList().toBlocking().single());
        this.friendRemovedSubject.onNext(localFriend);
        this.friendsListSubject.onNext(Collections.unmodifiableList(this.friends));
      }
      return;
    }
    finally {}
  }
  
  private void updateFriend(@NonNull Friend paramFriend)
  {
    if (findFriendById(paramFriend.getId()) == null) {}
    for (int i = 1;; i = 0)
    {
      this.friends = Collections.unmodifiableList((List)Observable.from(this.friends).filter(FriendsModel..Lambda.13.lambdaFactory$(paramFriend)).concatWith(Observable.just(paramFriend)).toSortedList(FriendsModel..Lambda.14.lambdaFactory$(this)).toBlocking().single());
      if (i != 0) {
        this.friendAddedSubject.onNext(paramFriend);
      }
      this.friendsListSubject.onNext(this.friends);
      return;
    }
  }
  
  private void updateFriendAccount(@NonNull FriendAccount paramFriendAccount)
  {
    try
    {
      this.friendAccountMap.put(paramFriendAccount.getId(), paramFriendAccount);
      paramFriendAccount = buildFriend(paramFriendAccount.getId());
      if (paramFriendAccount != null) {
        this.friendSubject.onNext(paramFriendAccount);
      }
      return;
    }
    finally {}
  }
  
  private void updateFriendAccounts(@NonNull List<FriendAccount> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      updateFriendAccount((FriendAccount)paramList.next());
    }
  }
  
  private void updatePresence(@NonNull BlizzardPresence paramBlizzardPresence)
  {
    try
    {
      this.presenceMap.put(paramBlizzardPresence.getFriendId(), paramBlizzardPresence);
      paramBlizzardPresence = buildFriend(paramBlizzardPresence.getFriendId());
      if (paramBlizzardPresence != null) {
        this.friendSubject.onNext(paramBlizzardPresence);
      }
      return;
    }
    finally {}
  }
  
  public Friend findFriendById(@NonNull String paramString)
  {
    return (Friend)Observable.from(this.friends).filter(FriendsModel..Lambda.10.lambdaFactory$(paramString)).firstOrDefault(null).toBlocking().single();
  }
  
  public List<Friend> getFriends()
  {
    return this.friends;
  }
  
  public Observable<Friend> onFriendAdded()
  {
    return this.friendAddedSubject.onBackpressureBuffer(200L);
  }
  
  public Observable<Friend> onFriendRemoved()
  {
    return this.friendRemovedSubject.onBackpressureBuffer(200L);
  }
  
  public Observable<Friend> onFriendUpdated()
  {
    return this.friendSubject;
  }
  
  public Observable<List<Friend>> onFriendsListUpdated()
  {
    return Observable.just(Collections.unmodifiableList(this.friends)).concatWith(this.friendsListSubject).onBackpressureLatest();
  }
  
  public void resortFriends()
  {
    this.friends = ((List)Observable.from(this.friends).toSortedList(FriendsModel..Lambda.11.lambdaFactory$(this)).toBlocking().single());
    this.friendsListSubject.onNext(Collections.unmodifiableList(this.friends));
  }
  
  public void setAccountProvider(@NonNull FriendsProvider paramFriendsProvider)
  {
    paramFriendsProvider.onFriendAccountUpdated().subscribe(FriendsModel..Lambda.2.lambdaFactory$(this), FriendsModel..Lambda.3.lambdaFactory$());
    paramFriendsProvider.onFriendAccountDeleted().subscribe(FriendsModel..Lambda.4.lambdaFactory$(this), FriendsModel..Lambda.5.lambdaFactory$());
    paramFriendsProvider.onFriendsCleared().subscribe(FriendsModel..Lambda.6.lambdaFactory$(this));
  }
  
  public void setPresenceProvider(@NonNull PresenceProvider paramPresenceProvider)
  {
    paramPresenceProvider.onFriendPresenceReceived().flatMap(FriendsModel..Lambda.7.lambdaFactory$()).subscribe(FriendsModel..Lambda.8.lambdaFactory$(this), FriendsModel..Lambda.9.lambdaFactory$());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/friends/FriendsModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */