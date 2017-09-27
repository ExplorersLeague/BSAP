package com.blizzard.bgs.client.service.challenge;

import com.blizzard.bgs.client.core.BgsMessage;
import com.blizzard.bgs.client.core.IncomingRequest;
import com.blizzard.bgs.client.exception.UnsupportedAuthChallengeException;
import com.blizzard.bgs.client.exception.WebAuthUrlChallenge;
import com.blizzard.bgs.client.service.base.RequestId;
import com.blizzard.bgs.client.service.base.ServiceId;
import com.blizzard.bgs.client.service.challenge.message.v1.ChallengeExternalRequest;

public class ChallengeNotifyService
{
  private static final int CER_METHOD_ID = 3;
  private static final RequestId CER_REQUEST_ID = new RequestId(SERVICE_ID, 3);
  private static final ServiceId SERVICE_ID = new ServiceId("bnet.protocol.challenge.ChallengeNotify", 0);
  
  public static void checkChallenge(IncomingRequest paramIncomingRequest)
  {
    if (paramIncomingRequest.targets(CER_REQUEST_ID))
    {
      Object localObject = (ChallengeExternalRequest)paramIncomingRequest.getMessage().getBody(ChallengeExternalRequest.class);
      paramIncomingRequest = ((ChallengeExternalRequest)localObject).getPayloadType();
      if (paramIncomingRequest.equals("web_auth_url"))
      {
        localObject = ((ChallengeExternalRequest)localObject).getDecodedPayload();
        throw new WebAuthUrlChallenge("Web auth challenge issued: url='" + (String)localObject + '\'', paramIncomingRequest, (String)localObject);
      }
      throw new UnsupportedAuthChallengeException("Unsupported auth challenge: type='" + paramIncomingRequest + '\'', paramIncomingRequest);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/challenge/ChallengeNotifyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */