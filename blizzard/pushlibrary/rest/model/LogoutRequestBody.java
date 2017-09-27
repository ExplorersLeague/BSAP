package com.blizzard.pushlibrary.rest.model;

public class LogoutRequestBody
{
  String applicationName;
  Authentication authentication;
  String platform;
  String platformToken;
  
  public LogoutRequestBody(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.applicationName = paramString1;
    this.platform = paramString2;
    this.platformToken = paramString3;
    if ((paramString4 != null) && (!paramString4.isEmpty()) && (paramString5 != null) && (!paramString5.isEmpty())) {
      this.authentication = new Authentication(paramString4, paramString5);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/rest/model/LogoutRequestBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */