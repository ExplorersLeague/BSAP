package com.blizzard.messenger.exceptions;

public class AccountMutedException
  extends RuntimeException
{
  public AccountMutedException() {}
  
  public AccountMutedException(String paramString)
  {
    super(paramString);
  }
  
  public AccountMutedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/exceptions/AccountMutedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */