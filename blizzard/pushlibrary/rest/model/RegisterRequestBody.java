package com.blizzard.pushlibrary.rest.model;

public class RegisterRequestBody
{
  String appAccountId;
  String applicationName;
  Authentication authentication;
  String locale;
  String platform;
  String platformToken;
  String region;
  
  public RegisterRequestBody(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.applicationName = paramString1;
    this.platform = paramString2;
    this.platformToken = paramString3;
    this.region = paramString4;
    this.locale = paramString5;
    if ((paramString6 != null) && (!paramString6.isEmpty()) && (paramString7 != null) && (!paramString7.isEmpty()))
    {
      this.authentication = new Authentication(paramString6, paramString7);
      this.appAccountId = paramString8;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/rest/model/RegisterRequestBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */