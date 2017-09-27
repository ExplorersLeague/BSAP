package com.blizzard.bgs.client.service.gameutilities;

import com.blizzard.bgs.client.core.BgsMessage;
import com.blizzard.bgs.client.core.Client;
import com.blizzard.bgs.client.core.IncomingResponse;
import com.blizzard.bgs.client.service.authentication.User;
import com.blizzard.bgs.client.service.base.Attribute;
import com.blizzard.bgs.client.service.base.RequestId;
import com.blizzard.bgs.client.service.base.ServiceId;
import com.blizzard.bgs.client.service.gameutilities.message.v1.ClientRequest;
import com.blizzard.bgs.client.service.gameutilities.message.v1.ClientResponse;
import java.util.List;
import rx.Observable;

public class GameUtilitiesService
{
  private static final int CLIENT_REQUEST_METHOD_ID = 1;
  private static final RequestId CLIENT_REQUEST_REQUEST_ID = new RequestId(SERVICE_ID, 1);
  private static final ServiceId SERVICE_ID;
  private static final String TAG = GameUtilitiesService.class.getSimpleName();
  
  static
  {
    SERVICE_ID = new ServiceId("bnet.protocol.game_utilities.GameUtilities", 0);
  }
  
  public static Observable<List<Attribute>> sendClientRequest(User paramUser, ClientRequest paramClientRequest)
  {
    return paramUser.getClient().send(CLIENT_REQUEST_REQUEST_ID, paramClientRequest).map(GameUtilitiesService..Lambda.1.lambdaFactory$(paramUser)).doOnError(GameUtilitiesService..Lambda.2.lambdaFactory$(paramUser));
  }
  
  private static List<Attribute> toResponseAttributes(User paramUser, IncomingResponse paramIncomingResponse)
  {
    paramIncomingResponse.checkStatus();
    paramIncomingResponse = (ClientResponse)paramIncomingResponse.getMessage().getBody(ClientResponse.class);
    paramUser.getClient().log("DEBUG", TAG, "ClientResponse: " + paramIncomingResponse);
    return paramIncomingResponse.getAttributes();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/gameutilities/GameUtilitiesService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */