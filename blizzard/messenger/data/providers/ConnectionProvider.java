package com.blizzard.messenger.data.providers;

import android.util.Log;
import com.blizzard.messenger.data.listeners.ConnectivityListener;
import com.blizzard.messenger.data.xmpp.iq.LogoutIQ;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.ping.PingFailedListener;
import org.jivesoftware.smackx.ping.PingManager;
import rx.Completable;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

public class ConnectionProvider
  implements PingFailedListener, ConnectionListener
{
  private static final String TAG = ConnectionProvider.class.getSimpleName();
  private X509Certificate[] certificates;
  private BehaviorSubject<Boolean> connectedSubject = BehaviorSubject.create(Boolean.valueOf(false));
  private XMPPTCPConnection connection;
  
  public ConnectionProvider()
  {
    ConnectivityListener.onNetworkAvailabilityChanged().filter(ConnectionProvider..Lambda.1.lambdaFactory$(this)).observeOn(Schedulers.io()).subscribe(ConnectionProvider..Lambda.2.lambdaFactory$(this));
  }
  
  private void teardown()
  {
    Log.d(TAG, "teardown started");
    PingManager.getInstanceFor(this.connection).setPingInterval(-1);
    this.connection.instantShutdown();
    updateConnectedState(false);
    Log.d(TAG, "teardown completed");
  }
  
  private void updateConnectedState(boolean paramBoolean)
  {
    Log.d(TAG, "updateConnectedState isConnected=" + paramBoolean);
    this.connectedSubject.onNext(Boolean.valueOf(paramBoolean));
  }
  
  public void authenticated(XMPPConnection paramXMPPConnection, boolean paramBoolean) {}
  
  public Completable connect(BgsAuthProvider.Credentials paramCredentials)
  {
    if (isConnected())
    {
      Log.d(TAG, "connect - already connected");
      return Completable.complete();
    }
    return Completable.create(ConnectionProvider..Lambda.3.lambdaFactory$(this, paramCredentials)).timeout(30000L, TimeUnit.MILLISECONDS);
  }
  
  public void connected(XMPPConnection paramXMPPConnection) {}
  
  public void connectionClosed()
  {
    Log.d(TAG, "connection gracefully closed");
    teardown();
  }
  
  public void connectionClosedOnError(Exception paramException)
  {
    Log.e(TAG, "connection terminated with error: " + paramException.getMessage());
    teardown();
  }
  
  public Completable disconnect()
  {
    if (!isConnected())
    {
      Log.d(TAG, "disconnect - already disconnected");
      return Completable.complete();
    }
    return Completable.create(ConnectionProvider..Lambda.4.lambdaFactory$(this));
  }
  
  public boolean isConnected()
  {
    return ((Boolean)this.connectedSubject.getValue()).booleanValue();
  }
  
  public Completable logout()
  {
    if (!isConnected())
    {
      Log.d(TAG, "logout - already disconnected");
      return Completable.complete();
    }
    Log.d(TAG, "logout started");
    try
    {
      this.connection.sendStanza(new LogoutIQ());
      updateConnectedState(false);
      Log.d(TAG, "logout completed");
      return Completable.complete();
    }
    catch (SmackException.NotConnectedException localNotConnectedException)
    {
      Completable localCompletable = Completable.error(localNotConnectedException);
      return localCompletable;
    }
    finally
    {
      updateConnectedState(false);
    }
  }
  
  public Observable<Boolean> onConnectionStateChanged()
  {
    return this.connectedSubject.onBackpressureLatest().distinctUntilChanged();
  }
  
  public void pingFailed()
  {
    Log.e(TAG, "ping failed");
    teardown();
  }
  
  public void reconnectingIn(int paramInt) {}
  
  public void reconnectionFailed(Exception paramException) {}
  
  public void reconnectionSuccessful() {}
  
  public void setServerCertificateChain(X509Certificate[] paramArrayOfX509Certificate)
  {
    this.certificates = paramArrayOfX509Certificate;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/ConnectionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */