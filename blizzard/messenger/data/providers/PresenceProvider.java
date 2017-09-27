package com.blizzard.messenger.data.providers;

import android.support.annotation.NonNull;
import com.blizzard.messenger.data.listeners.ConnectionCreationListener;
import com.blizzard.messenger.data.model.friends.FriendPresence;
import com.blizzard.messenger.data.model.presence.BlizzardPresence;
import com.blizzard.messenger.data.model.presence.BlizzardPresence.Builder;
import com.blizzard.messenger.data.utils.JIDUtils;
import com.blizzard.messenger.data.utils.PresenceUtils;
import com.blizzard.messenger.data.utils.SortingUtils;
import com.blizzard.messenger.data.xmpp.extension.PresenceExtension;
import com.blizzard.messenger.data.xmpp.model.GameAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;
import rx.Completable;
import rx.Observable;
import rx.subjects.PublishSubject;

public class PresenceProvider
{
  private XMPPConnection connection;
  private final PublishSubject<BlizzardPresence> friendPresenceSubject = PublishSubject.create();
  private final PublishSubject<BlizzardPresence> selfPresenceSubject = PublishSubject.create();
  private boolean testFailResponses = false;
  private boolean testTimeoutResponses = false;
  
  public PresenceProvider()
  {
    ConnectionCreationListener.onConnectionCreated().subscribe(PresenceProvider..Lambda.1.lambdaFactory$(this));
  }
  
  private void addPresence(@NonNull PresenceExtension paramPresenceExtension, boolean paramBoolean)
  {
    BlizzardPresence.Builder localBuilder = new BlizzardPresence.Builder(JIDUtils.getLocal(paramPresenceExtension.getFrom()));
    localBuilder.setLastOnline(Double.valueOf(paramPresenceExtension.getLastOnline()));
    localBuilder.setGame("None");
    localBuilder.setStatus(Integer.valueOf(PresenceUtils.getPresenceStatus(paramPresenceExtension.getStatus())));
    Object localObject1 = paramPresenceExtension.getGameAccounts();
    ArrayList localArrayList;
    Object localObject2;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localArrayList = new ArrayList();
      localObject2 = null;
      localObject1 = null;
      Iterator localIterator = paramPresenceExtension.getGameAccounts().iterator();
      while (localIterator.hasNext())
      {
        GameAccount localGameAccount = (GameAccount)localIterator.next();
        if (FriendPresence.isValidGame(localGameAccount.getName()))
        {
          String str = FriendPresence.toGame(localGameAccount.getName());
          if (FriendPresence.isGame(str)) {
            localArrayList.add(localGameAccount);
          } else if (FriendPresence.isDesktop(str)) {
            localObject2 = localGameAccount;
          } else if (FriendPresence.isMobile(str)) {
            localObject1 = localGameAccount;
          }
        }
      }
      if (localArrayList.isEmpty()) {
        break label339;
      }
      if (localArrayList.size() <= 1) {
        break label319;
      }
      Collections.sort(localArrayList, PresenceProvider..Lambda.2.lambdaFactory$());
      updateBuilderWithGameAccount(localBuilder, (GameAccount)localArrayList.get(0));
    }
    for (;;)
    {
      if (!paramPresenceExtension.getStatus().equals("ONLINE")) {
        localBuilder.setStatus(Integer.valueOf(PresenceUtils.getPresenceStatus(paramPresenceExtension.getStatus())));
      }
      if ((PresenceUtils.getPresenceStatus(paramPresenceExtension.getStatus()) == 3) && (localBuilder.getAwayTime().doubleValue() == 0.0D)) {
        localBuilder.setAwayTime(Double.valueOf(paramPresenceExtension.getAwayTime()));
      }
      paramPresenceExtension = localBuilder.build();
      if (!paramBoolean) {
        break;
      }
      this.selfPresenceSubject.onNext(paramPresenceExtension);
      return;
      label319:
      updateBuilderWithGameAccount(localBuilder, (GameAccount)localArrayList.get(0));
      continue;
      label339:
      if ((localObject2 != null) && (localObject1 != null))
      {
        if (((GameAccount)localObject2).getStatus() == 1) {
          updateBuilderWithGameAccount(localBuilder, (GameAccount)localObject2);
        } else if (((GameAccount)localObject2).getStatus() == 3) {
          if (((GameAccount)localObject1).getStatus() == 1) {
            updateBuilderWithGameAccount(localBuilder, (GameAccount)localObject1);
          } else {
            updateBuilderWithGameAccount(localBuilder, (GameAccount)localObject2);
          }
        }
      }
      else if (localObject2 != null) {
        updateBuilderWithGameAccount(localBuilder, (GameAccount)localObject2);
      } else if (localObject1 != null) {
        updateBuilderWithGameAccount(localBuilder, (GameAccount)localObject1);
      }
    }
    this.friendPresenceSubject.onNext(paramPresenceExtension);
  }
  
  private void processPresenceStanza(Presence paramPresence)
  {
    PresenceExtension localPresenceExtension;
    if ((paramPresence.getType() != Presence.Type.error) && (paramPresence.getError() == null))
    {
      localPresenceExtension = (PresenceExtension)paramPresence.getExtension("blz", "blz:presence");
      if (localPresenceExtension != null)
      {
        localPresenceExtension.setFrom(paramPresence.getFrom());
        localPresenceExtension.setTo(paramPresence.getTo());
        localPresenceExtension.setType(paramPresence.getType());
        if (!JIDUtils.getLocal(paramPresence.getFrom()).equals(JIDUtils.getLocal(paramPresence.getTo()))) {
          break label84;
        }
        addPresence(localPresenceExtension, true);
      }
    }
    return;
    label84:
    addPresence(localPresenceExtension, false);
  }
  
  private Completable sendPresence(Presence paramPresence)
  {
    return Completable.create(PresenceProvider..Lambda.3.lambdaFactory$(this, paramPresence));
  }
  
  private void updateBuilderWithGameAccount(BlizzardPresence.Builder paramBuilder, GameAccount paramGameAccount)
  {
    paramBuilder.setLastOnline(Double.valueOf(paramGameAccount.getLastOnline()));
    paramBuilder.setGame(FriendPresence.toGame(paramGameAccount.getName()));
    paramBuilder.setRichPresence(paramGameAccount.getRichPresence());
    paramBuilder.setAwayTime(Double.valueOf(paramGameAccount.getAwayTime()));
    if (paramGameAccount.getStatus() == 3)
    {
      if (SortingUtils.isIdle(paramGameAccount.getAwayTime()))
      {
        paramBuilder.setStatus(Integer.valueOf(1));
        return;
      }
      paramBuilder.setStatus(Integer.valueOf(3));
      return;
    }
    paramBuilder.setStatus(Integer.valueOf(paramGameAccount.getStatus()));
  }
  
  public Observable<Observable<BlizzardPresence>> onFriendPresenceReceived()
  {
    return this.friendPresenceSubject.window(200L, TimeUnit.MILLISECONDS, 100);
  }
  
  public Observable<BlizzardPresence> onSelfPresenceReceived()
  {
    return this.selfPresenceSubject;
  }
  
  public Completable sendPresence()
  {
    if (this.testFailResponses) {
      return Completable.error(new RuntimeException("Simulated Error"));
    }
    if (this.testTimeoutResponses) {
      return Completable.never().timeout(30000L, TimeUnit.MILLISECONDS);
    }
    return sendPresence(new Presence(Presence.Type.available)).concatWith(this.selfPresenceSubject.take(1).toCompletable()).timeout(30000L, TimeUnit.MILLISECONDS);
  }
  
  public Completable setPresenceStatus(int paramInt)
  {
    if (this.testFailResponses) {
      return Completable.error(new RuntimeException("Simulated Error"));
    }
    if (this.testTimeoutResponses) {
      return Completable.never().timeout(30000L, TimeUnit.MILLISECONDS);
    }
    Presence localPresence = new Presence(Presence.Type.available);
    localPresence.addExtension(new PresenceExtension(paramInt));
    return sendPresence(localPresence).concatWith(this.selfPresenceSubject.take(1).toCompletable().timeout(30000L, TimeUnit.MILLISECONDS));
  }
  
  public void setTestFailResponses(boolean paramBoolean)
  {
    this.testFailResponses = paramBoolean;
  }
  
  public void setTestTimeoutResponses(boolean paramBoolean)
  {
    this.testTimeoutResponses = paramBoolean;
  }
  
  public void suspendPresence()
  {
    if (this.connection != null) {}
    try
    {
      Presence localPresence = new Presence(Presence.Type.unavailable);
      this.connection.sendStanza(localPresence);
      return;
    }
    catch (SmackException.NotConnectedException localNotConnectedException) {}
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/PresenceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */