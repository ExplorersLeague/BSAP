package com.blizzard.bgs.client.core;

import com.blizzard.bgs.client.service.base.RequestId;
import com.blizzard.bgs.client.service.base.ServiceId;

public abstract interface IncomingRequest
{
  public abstract RequestHeader getHeader();
  
  public abstract BgsMessage getMessage();
  
  public abstract boolean targets(RequestId paramRequestId);
  
  public abstract boolean targets(ServiceId paramServiceId);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/IncomingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */