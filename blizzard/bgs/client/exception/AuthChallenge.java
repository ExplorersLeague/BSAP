package com.blizzard.bgs.client.exception;

public class AuthChallenge
  extends RuntimeException
{
  private String type;
  
  public AuthChallenge(String paramString1, String paramString2)
  {
    super(paramString1);
    this.type = paramString2;
  }
  
  String getType()
  {
    return this.type;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/exception/AuthChallenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */