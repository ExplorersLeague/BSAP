package com.blizzard.bgs.client.service.authentication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthenticationConfig
{
  private static final Character DELIM = Character.valueOf(':');
  private static final String FIELD = "\\s*([^" + DELIM + "]*)\\s*";
  private static final Pattern PATTERN = Pattern.compile(FIELD + DELIM + FIELD + DELIM + FIELD + DELIM + FIELD + DELIM + FIELD);
  private String bgsVersion;
  private String locale;
  private String platform;
  private String programId;
  private int programVersion;
  
  private AuthenticationConfig(Builder paramBuilder)
  {
    if (paramBuilder.programId == null) {
      throw new IllegalArgumentException("programId cannot be null");
    }
    if (paramBuilder.platform == null) {
      throw new IllegalArgumentException("platform cannot be null");
    }
    if (paramBuilder.locale == null) {
      throw new IllegalArgumentException("locale cannot be null");
    }
    if (paramBuilder.bgsVersion == null) {
      throw new IllegalArgumentException("bgsVersion cannot be null");
    }
    this.programId = paramBuilder.programId;
    this.platform = paramBuilder.platform;
    this.locale = paramBuilder.locale;
    this.bgsVersion = paramBuilder.bgsVersion;
    this.programVersion = paramBuilder.programVersion;
  }
  
  public static AuthenticationConfig from(String paramString)
  {
    paramString = PATTERN.matcher(paramString);
    if (paramString.matches())
    {
      Builder localBuilder = new Builder().programId(paramString.group(1)).platform(paramString.group(2)).locale(paramString.group(3)).bgsVersion(paramString.group(4));
      if (paramString.group(5).isEmpty()) {}
      for (int i = 0;; i = Integer.valueOf(paramString.group(5)).intValue()) {
        return localBuilder.programVersion(i).build();
      }
    }
    return null;
  }
  
  public String getBgsVersion()
  {
    return this.bgsVersion;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getPlatform()
  {
    return this.platform;
  }
  
  public String getProgramId()
  {
    return this.programId;
  }
  
  public int getProgramVersion()
  {
    return this.programVersion;
  }
  
  public String toString()
  {
    return this.programId + DELIM + this.platform + DELIM + this.locale + DELIM + this.bgsVersion + DELIM + this.programVersion;
  }
  
  public static class Builder
  {
    private String bgsVersion = "jsonrpc.aurora.v1.31.battle.net";
    private String locale;
    private String platform;
    private String programId;
    private int programVersion;
    
    public Builder bgsVersion(String paramString)
    {
      this.bgsVersion = paramString;
      return this;
    }
    
    public AuthenticationConfig build()
    {
      return new AuthenticationConfig(this, null);
    }
    
    public Builder locale(String paramString)
    {
      this.locale = paramString;
      return this;
    }
    
    public Builder platform(String paramString)
    {
      this.platform = paramString;
      return this;
    }
    
    public Builder programId(String paramString)
    {
      this.programId = paramString;
      return this;
    }
    
    public Builder programVersion(int paramInt)
    {
      this.programVersion = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/authentication/AuthenticationConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */