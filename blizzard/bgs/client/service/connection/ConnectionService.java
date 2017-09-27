package com.blizzard.bgs.client.service.connection;

import com.blizzard.bgs.client.core.BgsMessage;
import com.blizzard.bgs.client.core.Client;
import com.blizzard.bgs.client.core.IncomingRequest;
import com.blizzard.bgs.client.core.IncomingResponse;
import com.blizzard.bgs.client.core.RequestHeader;
import com.blizzard.bgs.client.core.ResponseHeader;
import com.blizzard.bgs.client.exception.DisconnectException;
import com.blizzard.bgs.client.service.authentication.AuthenticationConfig;
import com.blizzard.bgs.client.service.authentication.AuthenticationService;
import com.blizzard.bgs.client.service.authentication.User;
import com.blizzard.bgs.client.service.base.RequestId;
import com.blizzard.bgs.client.service.base.ServiceId;
import com.blizzard.bgs.client.service.connection.message.v1.ConnectRequest;
import com.blizzard.bgs.client.service.connection.message.v1.ConnectResponse;
import com.blizzard.bgs.client.service.connection.message.v1.DisconnectNotification;
import com.blizzard.bgs.client.service.connection.message.v1.Echo;
import rx.Observable;

public class ConnectionService
{
  private static final int CONNECT_METHOD_ID = 1;
  private static final ConnectRequest CONNECT_REQUEST_BODY = new ConnectRequest();
  private static final RequestId CONNECT_REQUEST_ID;
  private static final int DISCONNECT_METHOD_ID = 7;
  private static final int DISCONNECT_NOTIFY_METHOD_ID = 4;
  private static final RequestId DISCONNECT_REQUEST_ID = new RequestId(SERVICE_ID, 7);
  private static final int ECHO_METHOD_ID = 3;
  private static final ServiceId SERVICE_ID;
  private static final String TAG = ConnectionService.class.getSimpleName();
  
  static
  {
    SERVICE_ID = new ServiceId("bnet.protocol.connection.ConnectionService", 0);
    CONNECT_REQUEST_ID = new RequestId(SERVICE_ID, 1);
  }
  
  public static Observable<Connection> connect(Client paramClient)
  {
    Observable localObservable = paramClient.send(CONNECT_REQUEST_ID, CONNECT_REQUEST_BODY).map(ConnectionService..Lambda.1.lambdaFactory$(paramClient)).doOnError(ConnectionService..Lambda.2.lambdaFactory$(paramClient));
    return paramClient.getRequests().filter(ConnectionService..Lambda.3.lambdaFactory$()).doOnNext(ConnectionService..Lambda.4.lambdaFactory$()).map(ConnectionService..Lambda.5.lambdaFactory$()).filter(ConnectionService..Lambda.6.lambdaFactory$()).mergeWith(localObservable);
  }
  
  private static void handleRequest(IncomingRequest paramIncomingRequest)
  {
    switch (paramIncomingRequest.getHeader().getMethodId())
    {
    default: 
      return;
    case 3: 
      localObject = (Echo)paramIncomingRequest.getMessage().getBody(Echo.class);
      paramIncomingRequest.getMessage().getClient().send(new ResponseHeader(paramIncomingRequest.getHeader()), localObject);
      return;
    }
    Object localObject = (DisconnectNotification)paramIncomingRequest.getMessage().getBody(DisconnectNotification.class);
    paramIncomingRequest.getMessage().getClient().emitError(new DisconnectException("Disconnect requested by server: " + ((DisconnectNotification)localObject).getReason() + " (error code " + ((DisconnectNotification)localObject).getErrorCode() + ")"));
  }
  
  private static Connection toConnection(final Client paramClient, IncomingResponse paramIncomingResponse)
  {
    paramIncomingResponse.checkStatus();
    paramClient.log("DEBUG", TAG, "Creating connection");
    new Connection()
    {
      public Client getClient()
      {
        return paramClient;
      }
      
      public ConnectResponse getProperties()
      {
        return this.val$connectResponse;
      }
      
      public Observable<User> logon(AuthenticationConfig paramAnonymousAuthenticationConfig, String paramAnonymousString)
      {
        return AuthenticationService.logon(this, paramAnonymousAuthenticationConfig, paramAnonymousString);
      }
      
      public String toString()
      {
        return "Connection{" + this.val$connectResponse.getClientId() + '}';
      }
      
      public Observable<User> verifyWebCredentials(String paramAnonymousString)
      {
        return AuthenticationService.verifyWebCredentials(this, paramAnonymousString);
      }
    };
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/connection/ConnectionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */