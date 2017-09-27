package com.blizzard.messenger.data.providers;

import com.blizzard.messenger.data.listeners.ConnectionCreationListener;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriend;
import com.blizzard.messenger.data.utils.TransactionManager;
import com.blizzard.messenger.data.xmpp.iq.GetSuggestedFriendsIQ;
import com.blizzard.messenger.data.xmpp.iq.ViewFriendsIQ;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ.Type;
import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.subjects.PublishSubject;

public class SuggestedFriendsProvider
{
  private XMPPConnection connection;
  private final PublishSubject<List<SuggestedFriend>> friendsOfFriendsSubject = PublishSubject.create();
  private TransactionManager<List<SuggestedFriend>, Void> sentFriendsOfFriends = new TransactionManager(SuggestedFriendsProvider..Lambda.2.lambdaFactory$(this));
  private TransactionManager<List<SuggestedFriend>, Void> sentSuggestedFriends = new TransactionManager(SuggestedFriendsProvider..Lambda.1.lambdaFactory$(this));
  private final PublishSubject<Void> suggestedFriendsClearedSubject = PublishSubject.create();
  private final PublishSubject<List<SuggestedFriend>> suggestedFriendsSubject = PublishSubject.create();
  
  public SuggestedFriendsProvider()
  {
    ConnectionCreationListener.onConnectionCreated().subscribe(SuggestedFriendsProvider..Lambda.3.lambdaFactory$(this));
  }
  
  private void addSuggestedFriends(GetSuggestedFriendsIQ paramGetSuggestedFriendsIQ)
  {
    this.sentSuggestedFriends.completeTransaction(paramGetSuggestedFriendsIQ, paramGetSuggestedFriendsIQ.getSuggestedFriends());
    this.suggestedFriendsSubject.onNext(Collections.unmodifiableList(paramGetSuggestedFriendsIQ.getSuggestedFriends()));
  }
  
  private void broadcastFriendsOfFriends(ViewFriendsIQ paramViewFriendsIQ)
  {
    List localList = paramViewFriendsIQ.getFriendsOfFriends();
    this.sentFriendsOfFriends.completeTransaction(paramViewFriendsIQ, localList);
    this.friendsOfFriendsSubject.onNext(localList);
  }
  
  public void clearSuggestedFriends()
  {
    this.suggestedFriendsClearedSubject.onNext(null);
  }
  
  public Observable<List<SuggestedFriend>> onFriendsOfFriendsReceived()
  {
    return this.friendsOfFriendsSubject;
  }
  
  public Observable<Void> onSuggestedFriendsCleared()
  {
    return this.suggestedFriendsClearedSubject;
  }
  
  public Observable<List<SuggestedFriend>> onSuggestedFriendsReceived()
  {
    return this.suggestedFriendsSubject;
  }
  
  public Single<List<SuggestedFriend>> retrieveFriendsOfFriends(String paramString)
  {
    paramString = new ViewFriendsIQ(paramString);
    paramString.setType(IQ.Type.get);
    return this.sentFriendsOfFriends.startTransaction(paramString, null);
  }
  
  public Completable retrieveSuggestedFriends(int paramInt)
  {
    GetSuggestedFriendsIQ localGetSuggestedFriendsIQ = new GetSuggestedFriendsIQ(paramInt);
    localGetSuggestedFriendsIQ.setType(IQ.Type.get);
    return this.sentSuggestedFriends.startTransaction(localGetSuggestedFriendsIQ, null).toCompletable();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/SuggestedFriendsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */