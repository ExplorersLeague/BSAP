package com.blizzard.bgs.client.service.authentication;

import com.blizzard.bgs.client.core.ClientContainer;
import com.blizzard.bgs.client.service.authentication.message.v1.LogonResult;
import com.blizzard.bgs.client.service.base.Attribute;
import com.blizzard.bgs.client.service.connection.Connection;
import com.blizzard.bgs.client.service.gameutilities.message.v1.ClientRequest;
import java.util.List;
import rx.Observable;

public abstract interface User
  extends ClientContainer
{
  public abstract Connection getConnection();
  
  public abstract LogonResult getProperties();
  
  public abstract Observable<List<Attribute>> sendClientRequest(ClientRequest paramClientRequest);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/authentication/User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */