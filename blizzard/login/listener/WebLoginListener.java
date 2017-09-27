package com.blizzard.login.listener;

public abstract interface WebLoginListener
{
  public abstract void onHeadlessAccountIdFound(String paramString);
  
  public abstract void onLoginCompleted(String paramString);
  
  public abstract void onLoginError(int paramInt, String paramString1, String paramString2);
  
  public abstract void onLoginPageLoaded(String paramString);
  
  public abstract void onUrlLoaded(String paramString);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/listener/WebLoginListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */