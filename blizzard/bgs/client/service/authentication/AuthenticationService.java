package com.blizzard.bgs.client.service.authentication;

import com.blizzard.bgs.client.core.BgsMessage;
import com.blizzard.bgs.client.core.Client;
import com.blizzard.bgs.client.core.IncomingRequest;
import com.blizzard.bgs.client.exception.BgsException;
import com.blizzard.bgs.client.service.authentication.message.v1.LogonRequest;
import com.blizzard.bgs.client.service.authentication.message.v1.LogonResult;
import com.blizzard.bgs.client.service.authentication.message.v1.LogonUpdate;
import com.blizzard.bgs.client.service.authentication.message.v1.VerifyWebCredentialsRequest;
import com.blizzard.bgs.client.service.base.Attribute;
import com.blizzard.bgs.client.service.base.RequestId;
import com.blizzard.bgs.client.service.base.ServiceId;
import com.blizzard.bgs.client.service.challenge.ChallengeNotifyService;
import com.blizzard.bgs.client.service.connection.Connection;
import com.blizzard.bgs.client.service.gameutilities.GameUtilitiesService;
import com.blizzard.bgs.client.service.gameutilities.message.v1.ClientRequest;
import java.util.List;
import rx.Observable;

public class AuthenticationService
{
  private static final ServiceId CLIENT_SERVICE_ID;
  private static final int LOGON_REQUEST_METHOD_ID = 1;
  private static final RequestId LOGON_REQUEST_REQUEST_ID;
  private static final int LOGON_RESULT_METHOD_ID = 5;
  private static final RequestId LOGON_RESULT_REQUEST_ID = new RequestId(CLIENT_SERVICE_ID, 5);
  private static final int LOGON_UPDATE_METHOD_ID = 10;
  private static final RequestId LOGON_UPDATE_REQUEST_ID;
  private static final ServiceId SERVER_SERVICE_ID;
  private static final String TAG = AuthenticationService.class.getSimpleName();
  private static final int VERIFY_METHOD_ID = 7;
  private static final RequestId VERIFY_REQUEST_ID = new RequestId(SERVER_SERVICE_ID, 7);
  
  static
  {
    SERVER_SERVICE_ID = new ServiceId("bnet.protocol.authentication.AuthenticationServer", 0);
    CLIENT_SERVICE_ID = new ServiceId("bnet.protocol.authentication.AuthenticationClient", 0);
    LOGON_REQUEST_REQUEST_ID = new RequestId(SERVER_SERVICE_ID, 1);
    LOGON_UPDATE_REQUEST_ID = new RequestId(CLIENT_SERVICE_ID, 10);
  }
  
  private static void checkErrors(IncomingRequest paramIncomingRequest)
  {
    ChallengeNotifyService.checkChallenge(paramIncomingRequest);
    checkLogon(paramIncomingRequest);
  }
  
  private static void checkLogon(IncomingRequest paramIncomingRequest)
  {
    int i;
    if (paramIncomingRequest.targets(LOGON_UPDATE_REQUEST_ID))
    {
      i = ((LogonUpdate)paramIncomingRequest.getMessage().getBody(LogonUpdate.class)).getErrorCode();
      if (i != 0) {
        throw new BgsException("LogonUpdate failure " + i, i);
      }
    }
    else if (paramIncomingRequest.targets(LOGON_RESULT_REQUEST_ID))
    {
      i = ((LogonResult)paramIncomingRequest.getMessage().getBody(LogonResult.class)).getErrorCode();
      if (i != 0) {
        throw new BgsException("LogonResult failure " + i, i);
      }
    }
  }
  
  public static Observable<User> logon(Connection paramConnection, AuthenticationConfig paramAuthenticationConfig, String paramString)
  {
    return startLogon(paramConnection, LOGON_REQUEST_REQUEST_ID, new LogonRequest(paramAuthenticationConfig, paramString));
  }
  
  private static Observable<User> startLogon(Connection paramConnection, RequestId paramRequestId, Object paramObject)
  {
    paramRequestId = paramConnection.getClient().send(paramRequestId, paramObject).map(AuthenticationService..Lambda.1.lambdaFactory$()).filter(AuthenticationService..Lambda.2.lambdaFactory$()).doOnError(AuthenticationService..Lambda.3.lambdaFactory$(paramConnection));
    return paramConnection.getClient().getRequests().doOnNext(AuthenticationService..Lambda.4.lambdaFactory$()).filter(AuthenticationService..Lambda.5.lambdaFactory$()).mergeWith(paramRequestId).map(AuthenticationService..Lambda.6.lambdaFactory$(paramConnection)).doOnError(AuthenticationService..Lambda.7.lambdaFactory$(paramConnection));
  }
  
  private static User toUser(final Connection paramConnection, IncomingRequest paramIncomingRequest)
  {
    new User()
    {
      public Client getClient()
      {
        return paramConnection.getClient();
      }
      
      public Connection getConnection()
      {
        return paramConnection;
      }
      
      public LogonResult getProperties()
      {
        return this.val$logonResult;
      }
      
      public Observable<List<Attribute>> sendClientRequest(ClientRequest paramAnonymousClientRequest)
      {
        return GameUtilitiesService.sendClientRequest(this, paramAnonymousClientRequest);
      }
      
      public String toString()
      {
        return "User{" + this.val$logonResult.getBattleTag() + '}';
      }
    };
  }
  
  public static Observable<User> verifyWebCredentials(Connection paramConnection, String paramString)
  {
    return startLogon(paramConnection, VERIFY_REQUEST_ID, new VerifyWebCredentialsRequest(paramString));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/authentication/AuthenticationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */