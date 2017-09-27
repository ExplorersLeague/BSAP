package com.blizzard.bgs.client.exception;

public class RequiredFieldNullException
  extends InvalidBgsMessageException
{
  public RequiredFieldNullException(String paramString)
  {
    super(paramString);
  }
  
  public RequiredFieldNullException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/exception/RequiredFieldNullException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */