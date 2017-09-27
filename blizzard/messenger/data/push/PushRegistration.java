package com.blizzard.messenger.data.push;

import android.support.annotation.NonNull;

public class PushRegistration
{
  private String applicationId;
  private String authToken;
  private String locale;
  private String newToken;
  private String oldToken;
  private String platform;
  
  private PushRegistration(Builder paramBuilder)
  {
    this.applicationId = paramBuilder.applicationId;
    this.authToken = paramBuilder.authToken;
    this.locale = paramBuilder.locale;
    this.newToken = paramBuilder.newToken;
    this.oldToken = paramBuilder.oldToken;
    this.platform = paramBuilder.platform;
  }
  
  public String getApplicationId()
  {
    return this.applicationId;
  }
  
  public String getAuthToken()
  {
    return this.authToken;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getNewToken()
  {
    return this.newToken;
  }
  
  public String getOldToken()
  {
    return this.oldToken;
  }
  
  public String getPlatform()
  {
    return this.platform;
  }
  
  public String toString()
  {
    String str = "" + "Application ID: " + this.applicationId;
    str = str + " Auth Token: " + this.authToken;
    str = str + " Locale: " + this.locale;
    str = str + " New Token: " + this.newToken;
    str = str + " Old Token: " + this.oldToken;
    return str + " Platform: " + this.platform;
  }
  
  public static class Builder
  {
    private String applicationId;
    private String authToken;
    private String locale;
    private String newToken;
    private String oldToken;
    private String platform;
    
    public Builder(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
    {
      this.applicationId = paramString1;
      this.newToken = paramString2;
      this.platform = paramString3;
    }
    
    public PushRegistration build()
    {
      return new PushRegistration(this, null);
    }
    
    public Builder setAuthToken(String paramString)
    {
      this.authToken = paramString;
      return this;
    }
    
    public Builder setLocale(String paramString)
    {
      this.locale = paramString;
      return this;
    }
    
    public Builder setOldToken(String paramString)
    {
      this.oldToken = paramString;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/push/PushRegistration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */