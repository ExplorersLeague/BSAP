package com.blizzard.bgs.client.exception;

public class WebAuthUrlChallenge
  extends AuthChallenge
{
  private String url;
  
  public WebAuthUrlChallenge(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2);
    this.url = paramString3;
  }
  
  public String getUrl()
  {
    return this.url;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/exception/WebAuthUrlChallenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */