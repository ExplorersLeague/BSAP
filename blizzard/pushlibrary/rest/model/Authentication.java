package com.blizzard.pushlibrary.rest.model;

public class Authentication
{
  protected String region;
  protected String token;
  
  public Authentication(String paramString1, String paramString2)
  {
    this.region = paramString1;
    this.token = paramString2;
  }
  
  public String getRegion()
  {
    return this.region;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setRegion(String paramString)
  {
    this.region = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/rest/model/Authentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */