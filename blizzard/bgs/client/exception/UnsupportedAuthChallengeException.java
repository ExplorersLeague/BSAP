package com.blizzard.bgs.client.exception;

public class UnsupportedAuthChallengeException
  extends RuntimeException
{
  String type;
  
  public UnsupportedAuthChallengeException(String paramString1, String paramString2)
  {
    super(paramString1);
    this.type = paramString2;
  }
  
  public String getType()
  {
    return this.type;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/exception/UnsupportedAuthChallengeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */