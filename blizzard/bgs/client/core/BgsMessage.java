package com.blizzard.bgs.client.core;

import com.google.gson.JsonObject;

public abstract interface BgsMessage
{
  public abstract JsonObject getBody();
  
  public abstract <Body> Body getBody(Class<Body> paramClass);
  
  public abstract Client getClient();
  
  public abstract JsonObject getHeader();
  
  public abstract <Header> Header getHeader(Class<Header> paramClass);
  
  public abstract String getRaw();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/BgsMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */