package com.blizzard.messenger.data.providers;

import com.blizzard.messenger.data.listeners.ConnectionCreationListener;
import com.blizzard.messenger.data.push.PushRegistration;
import com.blizzard.messenger.data.utils.ErrorUtils;
import com.blizzard.messenger.data.xmpp.iq.PushEnrollmentIQ;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ.Type;
import rx.Completable;
import rx.Observable;

public class PushNotificationProvider
{
  private static final String TAG = PushNotificationProvider.class.getSimpleName();
  private XMPPConnection connection;
  
  public PushNotificationProvider()
  {
    ConnectionCreationListener.onConnectionCreated().subscribe(PushNotificationProvider..Lambda.1.lambdaFactory$(this));
  }
  
  public Completable deregisterForPushNotifications(PushRegistration paramPushRegistration)
  {
    return Completable.create(PushNotificationProvider..Lambda.2.lambdaFactory$(this, paramPushRegistration)).timeout(30000L, TimeUnit.MILLISECONDS);
  }
  
  public void registerForPushNotifications(PushRegistration paramPushRegistration)
  {
    paramPushRegistration = new PushEnrollmentIQ(paramPushRegistration);
    paramPushRegistration.setType(IQ.Type.set);
    try
    {
      if (this.connection != null) {
        this.connection.sendStanza(paramPushRegistration);
      }
      return;
    }
    catch (SmackException.NotConnectedException paramPushRegistration)
    {
      ErrorUtils.handleError(paramPushRegistration);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/PushNotificationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */