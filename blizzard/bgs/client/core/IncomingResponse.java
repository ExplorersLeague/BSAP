package com.blizzard.bgs.client.core;

public abstract interface IncomingResponse
{
  public abstract void checkStatus();
  
  public abstract ResponseHeader getHeader();
  
  public abstract BgsMessage getMessage();
  
  public abstract boolean targets(int paramInt);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/IncomingResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */