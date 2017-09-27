package com.blizzard.messenger.data.providers;

import android.util.Log;
import com.blizzard.messenger.data.listeners.ConnectionCreationListener;
import com.blizzard.messenger.data.utils.TransactionManager;
import com.blizzard.messenger.data.xmpp.iq.SimpleProfileIQ;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ.Type;
import rx.Observable;
import rx.Single;
import rx.subjects.PublishSubject;

public class ProfileProvider
{
  private static final String TAG = ProfileProvider.class.getSimpleName();
  private XMPPConnection connection;
  private final PublishSubject<SimpleProfileIQ> profileFoundSubject = PublishSubject.create();
  private final TransactionManager<SimpleProfileIQ, Void> profileRequests = new TransactionManager(ProfileProvider..Lambda.1.lambdaFactory$(this));
  
  public ProfileProvider()
  {
    ConnectionCreationListener.onConnectionCreated().subscribe(ProfileProvider..Lambda.2.lambdaFactory$(this));
  }
  
  private void processProfilePacket(SimpleProfileIQ paramSimpleProfileIQ)
  {
    Log.d(TAG, "processProfilePacket stanzaId=" + paramSimpleProfileIQ.getStanzaId());
    if (this.profileRequests.completeTransaction(paramSimpleProfileIQ, paramSimpleProfileIQ)) {
      this.profileFoundSubject.onNext(paramSimpleProfileIQ);
    }
  }
  
  public Observable<SimpleProfileIQ> onProfileIQRetrieved()
  {
    return this.profileFoundSubject;
  }
  
  public Single<SimpleProfileIQ> retrieveProfile()
  {
    SimpleProfileIQ localSimpleProfileIQ = new SimpleProfileIQ();
    localSimpleProfileIQ.setType(IQ.Type.get);
    return this.profileRequests.startTransaction(localSimpleProfileIQ, null);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/ProfileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */