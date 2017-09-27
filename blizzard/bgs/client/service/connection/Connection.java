package com.blizzard.bgs.client.service.connection;

import com.blizzard.bgs.client.core.ClientContainer;
import com.blizzard.bgs.client.service.authentication.AuthenticationConfig;
import com.blizzard.bgs.client.service.authentication.User;
import com.blizzard.bgs.client.service.connection.message.v1.ConnectResponse;
import rx.Observable;

public abstract interface Connection
  extends ClientContainer
{
  public abstract ConnectResponse getProperties();
  
  public abstract Observable<User> logon(AuthenticationConfig paramAuthenticationConfig, String paramString);
  
  public abstract Observable<User> verifyWebCredentials(String paramString);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/connection/Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */