package com.blizzard.bgs.client.core;

import com.blizzard.bgs.client.exception.BgsException;
import com.blizzard.bgs.client.service.base.RequestId;
import com.blizzard.bgs.client.service.base.ServiceId;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import rx.Observable;

public class IncomingMessages
{
  public static Observable<IncomingRequest> filterRequest(Observable<BgsMessage> paramObservable)
  {
    return paramObservable.map(IncomingMessages..Lambda.1.lambdaFactory$()).filter(IncomingMessages..Lambda.2.lambdaFactory$());
  }
  
  public static Observable<IncomingResponse> filterResponse(Observable<BgsMessage> paramObservable)
  {
    return paramObservable.map(IncomingMessages..Lambda.3.lambdaFactory$()).filter(IncomingMessages..Lambda.4.lambdaFactory$());
  }
  
  public static boolean isRequest(BgsMessage paramBgsMessage)
  {
    paramBgsMessage = paramBgsMessage.getHeader();
    return (paramBgsMessage != null) && (!isResponseHeader(paramBgsMessage));
  }
  
  public static boolean isResponse(BgsMessage paramBgsMessage)
  {
    paramBgsMessage = paramBgsMessage.getHeader();
    return (paramBgsMessage != null) && (isResponseHeader(paramBgsMessage));
  }
  
  private static boolean isResponseHeader(JsonObject paramJsonObject)
  {
    return paramJsonObject.get("service_id").getAsInt() == 254;
  }
  
  public static IncomingRequest toRequest(final BgsMessage paramBgsMessage)
  {
    if (!isRequest(paramBgsMessage)) {
      return null;
    }
    new IncomingRequest()
    {
      public RequestHeader getHeader()
      {
        return this.val$header;
      }
      
      public BgsMessage getMessage()
      {
        return paramBgsMessage;
      }
      
      public boolean targets(RequestId paramAnonymousRequestId)
      {
        return paramAnonymousRequestId.equals(this.val$header.asRequestId());
      }
      
      public boolean targets(ServiceId paramAnonymousServiceId)
      {
        return paramAnonymousServiceId.equals(this.val$header.asServiceId());
      }
    };
  }
  
  public static IncomingResponse toResponse(final BgsMessage paramBgsMessage)
  {
    if (!isResponse(paramBgsMessage)) {
      return null;
    }
    new IncomingResponse()
    {
      public void checkStatus()
      {
        if (this.val$header.failed()) {
          throw new BgsException("Response failure " + this.val$header.getStatus(), this.val$header.getStatus());
        }
      }
      
      public ResponseHeader getHeader()
      {
        return this.val$header;
      }
      
      public BgsMessage getMessage()
      {
        return paramBgsMessage;
      }
      
      public boolean targets(int paramAnonymousInt)
      {
        return paramAnonymousInt == this.val$header.getToken();
      }
    };
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/IncomingMessages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */