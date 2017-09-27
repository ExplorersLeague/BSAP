package com.blizzard.messenger.data.listeners;

public abstract interface ConnectionErrorListener
{
  public abstract void onAuthenticationError(Exception paramException);
  
  public abstract void onConnectionError(Exception paramException);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/listeners/ConnectionErrorListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */