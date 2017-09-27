package com.blizzard.messenger.data.providers;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.messenger.data.listeners.ConnectionCreationListener;
import com.blizzard.messenger.data.model.friends.FriendAccount;
import com.blizzard.messenger.data.model.friends.FriendAccount.Builder;
import com.blizzard.messenger.data.model.friends.FriendRequest;
import com.blizzard.messenger.data.model.friends.FriendRequest.Builder;
import com.blizzard.messenger.data.utils.JIDUtils;
import com.blizzard.messenger.data.xmpp.extension.RosterExtension;
import com.blizzard.messenger.data.xmpp.impl.IncomingStanzaInterceptor;
import com.blizzard.messenger.data.xmpp.iq.AddFriendNoteIQ;
import com.blizzard.messenger.data.xmpp.iq.BlockFriendIQ;
import com.blizzard.messenger.data.xmpp.iq.FriendManagementIQ;
import com.blizzard.messenger.data.xmpp.iq.FriendManagementIQ.Action;
import com.blizzard.messenger.data.xmpp.iq.ReportFriendIQ;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.SmackException.NoResponseException;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException.XMPPErrorException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler.Mode;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.Type;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.roster.RosterGroup;
import org.jivesoftware.smack.roster.RosterListener;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.packet.RosterPacket.Item;
import org.jivesoftware.smack.roster.packet.RosterPacket.ItemStatus;
import org.jivesoftware.smack.roster.packet.RosterPacket.ItemType;
import rx.Completable;
import rx.Observable;
import rx.subjects.PublishSubject;

public final class FriendsProvider
  implements RosterListener
{
  private static final String ROSTER_GROUP_FAVORITE = "favorite";
  private static final String TAG = FriendsProvider.class.getSimpleName();
  private XMPPConnection connection;
  private final PublishSubject<String> friendAccountDeletedSubject = PublishSubject.create();
  private final PublishSubject<List<FriendAccount>> friendAccountUpdatedSubject = PublishSubject.create();
  private final PublishSubject<String> friendRequestDeletedSubject = PublishSubject.create();
  private final PublishSubject<FriendRequest> friendRequestReceivedSubject = PublishSubject.create();
  private final PublishSubject<FriendRequest> friendRequestWhileForegroundedSubject = PublishSubject.create();
  private final PublishSubject<Void> friendRequestsClearedSubject = PublishSubject.create();
  private final PublishSubject<Void> friendsClearedSubject = PublishSubject.create();
  private Roster roster;
  private IQRequestHandler rosterIqHandler;
  private boolean testFailResponses = false;
  private boolean testTimeoutResponses = false;
  
  public FriendsProvider()
  {
    ConnectionCreationListener.onConnectionCreated().subscribe(FriendsProvider..Lambda.1.lambdaFactory$(this));
  }
  
  private void addFriendRequestInvitation(@NonNull RosterPacket.Item paramItem, @NonNull RosterExtension paramRosterExtension, boolean paramBoolean)
  {
    Log.d(TAG, paramRosterExtension.toString());
    String str1 = paramRosterExtension.getInvitationId();
    String str2 = JIDUtils.getLocal(paramItem.getUser());
    Object localObject2 = null;
    Object localObject1;
    if ((paramItem.getItemStatus() == RosterPacket.ItemStatus.subscribe) && (paramItem.getItemType() == RosterPacket.ItemType.both))
    {
      localObject1 = "upgrade";
      localObject1 = new FriendRequest.Builder(str2, str1, (String)localObject1);
      ((FriendRequest.Builder)localObject1).setBattletag(paramItem.getName());
      ((FriendRequest.Builder)localObject1).setFullName(paramRosterExtension.getFullName());
      if (TextUtils.isEmpty(paramRosterExtension.getFullName())) {
        break label168;
      }
      ((FriendRequest.Builder)localObject1).setAssociation("Email");
    }
    for (;;)
    {
      paramItem = ((FriendRequest.Builder)localObject1).build();
      this.friendRequestReceivedSubject.onNext(paramItem);
      if (paramBoolean) {
        this.friendRequestWhileForegroundedSubject.onNext(paramItem);
      }
      return;
      localObject1 = localObject2;
      if (paramItem.getItemStatus() != RosterPacket.ItemStatus.subscribe) {
        break;
      }
      localObject1 = localObject2;
      if (paramItem.getItemType() != RosterPacket.ItemType.none) {
        break;
      }
      localObject1 = "add";
      break;
      label168:
      ((FriendRequest.Builder)localObject1).setAssociation("BattleTag");
    }
  }
  
  private void doUpdateFavorite(@NonNull String paramString, boolean paramBoolean)
    throws SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.XMPPErrorException
  {
    if (this.testFailResponses) {
      throw new RuntimeException("Simulated Error");
    }
    RosterGroup localRosterGroup = getFavoritesRosterGroup();
    paramString = JIDUtils.buildJID(this.connection, paramString);
    RosterEntry localRosterEntry = this.roster.getEntry(paramString);
    if (paramBoolean) {
      if (localRosterGroup.getEntry(paramString) == null) {
        localRosterGroup.addEntry(localRosterEntry);
      }
    }
    while (localRosterGroup.getEntry(paramString) == null) {
      return;
    }
    localRosterGroup.removeEntry(localRosterEntry);
  }
  
  private RosterGroup getFavoritesRosterGroup()
  {
    RosterGroup localRosterGroup2 = this.roster.getGroup("favorite");
    RosterGroup localRosterGroup1 = localRosterGroup2;
    if (localRosterGroup2 == null) {
      localRosterGroup1 = this.roster.createGroup("favorite");
    }
    return localRosterGroup1;
  }
  
  private FriendAccount getFriendAccount(@NonNull RosterPacket.Item paramItem, @NonNull RosterExtension paramRosterExtension)
  {
    Object localObject = JIDUtils.getLocal(paramItem.getUser());
    String str = paramItem.getName();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {
      return null;
    }
    localObject = new FriendAccount.Builder((String)localObject, str);
    if ((!TextUtils.isEmpty(paramRosterExtension.getNote())) && (!TextUtils.isEmpty(paramRosterExtension.getNote().trim())))
    {
      ((FriendAccount.Builder)localObject).setNote(paramRosterExtension.getNote());
      if (!paramItem.getGroupNames().contains("favorite")) {
        break label127;
      }
      ((FriendAccount.Builder)localObject).setFavorite(true);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramRosterExtension.getFullName())) {
        ((FriendAccount.Builder)localObject).setFullName(paramRosterExtension.getFullName());
      }
      return ((FriendAccount.Builder)localObject).build();
      ((FriendAccount.Builder)localObject).setNote(null);
      break;
      label127:
      ((FriendAccount.Builder)localObject).setFavorite(false);
    }
  }
  
  private void processRosterPacket(RosterPacket paramRosterPacket, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.rosterIqHandler.handleIQRequest(paramRosterPacket);
    }
    List localList = paramRosterPacket.getRosterItems();
    paramRosterPacket = paramRosterPacket.getExtensions();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (RosterPacket.Item)localList.get(i);
      RosterExtension localRosterExtension = (RosterExtension)paramRosterPacket.get(i);
      String str = JIDUtils.getLocal(((RosterPacket.Item)localObject).getUser());
      if (!TextUtils.isEmpty(localRosterExtension.getInvitationId()))
      {
        addFriendRequestInvitation((RosterPacket.Item)localObject, localRosterExtension, paramBoolean);
        label103:
        if (!((RosterPacket.Item)localObject).getItemType().equals(RosterPacket.ItemType.both)) {
          break label161;
        }
        localObject = getFriendAccount((RosterPacket.Item)localObject, localRosterExtension);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this.friendRequestDeletedSubject.onNext(str);
        break label103;
        label161:
        if (((RosterPacket.Item)localObject).getItemType().equals(RosterPacket.ItemType.remove)) {
          this.friendAccountDeletedSubject.onNext(str);
        }
      }
    }
    this.friendAccountUpdatedSubject.onNext(localArrayList);
  }
  
  public Completable acceptFriendRequest(@NonNull FriendRequest paramFriendRequest)
  {
    Log.w(TAG, paramFriendRequest.toString());
    FriendManagementIQ localFriendManagementIQ = new FriendManagementIQ(paramFriendRequest, FriendManagementIQ.Action.ACCEPT);
    localFriendManagementIQ.setType(IQ.Type.set);
    return Completable.defer(FriendsProvider..Lambda.9.lambdaFactory$(this, localFriendManagementIQ, IncomingStanzaInterceptor.listenForResponse(localFriendManagementIQ, this.connection).doOnCompleted(FriendsProvider..Lambda.8.lambdaFactory$(this, paramFriendRequest))));
  }
  
  public Completable addFriend(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString1 = new FriendManagementIQ(paramString1, paramString2, FriendManagementIQ.Action.INVITE);
    paramString1.setType(IQ.Type.set);
    return Completable.defer(FriendsProvider..Lambda.3.lambdaFactory$(this, paramString1, IncomingStanzaInterceptor.listenForResponse(paramString1, this.connection)));
  }
  
  public Completable blockFriend(@NonNull String paramString)
  {
    paramString = new BlockFriendIQ(JIDUtils.buildJID(this.connection, paramString));
    paramString.setType(IQ.Type.set);
    return Completable.defer(FriendsProvider..Lambda.6.lambdaFactory$(this, paramString, IncomingStanzaInterceptor.listenForResponse(paramString, this.connection)));
  }
  
  public void clearFriendRequests()
  {
    this.friendRequestsClearedSubject.onNext(null);
  }
  
  public void clearFriends()
  {
    this.friendsClearedSubject.onNext(null);
  }
  
  public Completable declineFriendRequest(@NonNull FriendRequest paramFriendRequest)
  {
    FriendManagementIQ localFriendManagementIQ = new FriendManagementIQ(paramFriendRequest, FriendManagementIQ.Action.DECLINE);
    localFriendManagementIQ.setType(IQ.Type.set);
    return Completable.defer(FriendsProvider..Lambda.11.lambdaFactory$(this, localFriendManagementIQ, IncomingStanzaInterceptor.listenForResponse(localFriendManagementIQ, this.connection).doOnCompleted(FriendsProvider..Lambda.10.lambdaFactory$(this, paramFriendRequest))));
  }
  
  public void entriesAdded(@NonNull Collection<String> paramCollection)
  {
    Log.w(TAG, "entriesAdded");
    entriesUpdated(paramCollection);
  }
  
  public void entriesDeleted(@NonNull Collection<String> paramCollection)
  {
    Log.w(TAG, "entriesDeleted");
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = JIDUtils.getLocal((String)paramCollection.next());
      this.friendAccountDeletedSubject.onNext(str);
    }
  }
  
  public void entriesUpdated(@NonNull Collection<String> paramCollection)
  {
    Log.w(TAG, "entriesUpdated");
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (this.roster.getEntry(str).getType() == RosterPacket.ItemType.remove)
      {
        str = JIDUtils.getLocal(str);
        this.friendAccountDeletedSubject.onNext(str);
      }
    }
  }
  
  public Completable ignoreFriendRequest(@NonNull FriendRequest paramFriendRequest)
  {
    FriendManagementIQ localFriendManagementIQ = new FriendManagementIQ(paramFriendRequest, FriendManagementIQ.Action.IGNORE);
    localFriendManagementIQ.setType(IQ.Type.set);
    return Completable.defer(FriendsProvider..Lambda.13.lambdaFactory$(this, localFriendManagementIQ, IncomingStanzaInterceptor.listenForResponse(localFriendManagementIQ, this.connection).doOnCompleted(FriendsProvider..Lambda.12.lambdaFactory$(this, paramFriendRequest))));
  }
  
  public Observable<String> onFriendAccountDeleted()
  {
    return this.friendAccountDeletedSubject;
  }
  
  public Observable<List<FriendAccount>> onFriendAccountUpdated()
  {
    return this.friendAccountUpdatedSubject;
  }
  
  public Observable<String> onFriendRequestDeleted()
  {
    return this.friendRequestDeletedSubject;
  }
  
  public Observable<FriendRequest> onFriendRequestReceived()
  {
    return this.friendRequestReceivedSubject;
  }
  
  public Observable<FriendRequest> onFriendRequestReceivedWhileForegrounded()
  {
    return this.friendRequestWhileForegroundedSubject;
  }
  
  public Observable<Void> onFriendRequestsCleared()
  {
    return this.friendRequestsClearedSubject;
  }
  
  public Observable<Void> onFriendsCleared()
  {
    return this.friendsClearedSubject;
  }
  
  public void presenceChanged(@NonNull Presence paramPresence) {}
  
  public Completable removeFriend(@NonNull String paramString)
  {
    Object localObject = JIDUtils.buildJID(this.connection, paramString);
    RosterEntry localRosterEntry = this.roster.getEntry((String)localObject);
    if (localRosterEntry == null) {
      return Completable.complete();
    }
    paramString = new RosterPacket();
    paramString.setType(IQ.Type.set);
    localObject = new RosterPacket.Item((String)localObject, localRosterEntry.getName());
    ((RosterPacket.Item)localObject).setItemType(RosterPacket.ItemType.remove);
    paramString.addRosterItem((RosterPacket.Item)localObject);
    return Completable.defer(FriendsProvider..Lambda.5.lambdaFactory$(this, paramString, IncomingStanzaInterceptor.listenForResponse(paramString, this.connection)));
  }
  
  public Completable reportFriend(@NonNull String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramString1 = new ReportFriendIQ(JIDUtils.buildJID(this.connection, paramString1), paramString2, paramString3, paramBoolean);
    paramString1.setType(IQ.Type.set);
    return Completable.defer(FriendsProvider..Lambda.7.lambdaFactory$(this, paramString1, IncomingStanzaInterceptor.listenForResponse(paramString1, this.connection)));
  }
  
  public Completable retrieveFriends()
  {
    return Completable.create(FriendsProvider..Lambda.2.lambdaFactory$(this)).timeout(30000L, TimeUnit.MILLISECONDS);
  }
  
  public Completable setFavoriteStatus(@NonNull String paramString, boolean paramBoolean)
  {
    if (this.testTimeoutResponses) {
      return Completable.never().timeout(30000L, TimeUnit.MILLISECONDS);
    }
    return Completable.defer(FriendsProvider..Lambda.14.lambdaFactory$(this, paramString, paramBoolean));
  }
  
  public void setTestFailResponses(boolean paramBoolean)
  {
    this.testFailResponses = paramBoolean;
  }
  
  public void setTestTimeoutResponses(boolean paramBoolean)
  {
    this.testTimeoutResponses = paramBoolean;
  }
  
  public Completable updateFriendNote(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString1 = new AddFriendNoteIQ(JIDUtils.buildJID(this.connection, paramString1), paramString2);
    paramString1.setType(IQ.Type.set);
    return Completable.defer(FriendsProvider..Lambda.15.lambdaFactory$(this, paramString1, IncomingStanzaInterceptor.listenForResponse(paramString1, this.connection)));
  }
  
  public Completable upgradeFriend(@NonNull String paramString)
  {
    paramString = JIDUtils.buildJID(this.connection, paramString);
    paramString = this.roster.getEntry(paramString);
    if (paramString == null) {
      throw new RuntimeException("Friend not found!");
    }
    paramString = new FriendManagementIQ(paramString.getName(), "Email", FriendManagementIQ.Action.UPGRADE);
    paramString.setType(IQ.Type.set);
    return Completable.defer(FriendsProvider..Lambda.4.lambdaFactory$(this, paramString, IncomingStanzaInterceptor.listenForResponse(paramString, this.connection)));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/FriendsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */