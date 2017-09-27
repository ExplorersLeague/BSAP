package com.blizzard.bgs.client.exception;

public class BgsException
  extends RuntimeException
{
  private final int errorCode;
  
  public BgsException(String paramString, int paramInt)
  {
    super(paramString);
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/exception/BgsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */