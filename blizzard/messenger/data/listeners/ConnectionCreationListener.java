package com.blizzard.messenger.data.listeners;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class ConnectionCreationListener
{
  private static final BehaviorSubject<XMPPConnection> connectionCreatedSubject = ;
  
  static
  {
    BehaviorSubject localBehaviorSubject = connectionCreatedSubject;
    localBehaviorSubject.getClass();
    XMPPConnectionRegistry.addConnectionCreationListener(ConnectionCreationListener..Lambda.1.lambdaFactory$(localBehaviorSubject));
  }
  
  public static Observable<XMPPConnection> onConnectionCreated()
  {
    return connectionCreatedSubject;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/listeners/ConnectionCreationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */