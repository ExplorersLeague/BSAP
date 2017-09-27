package com.blizzard.login.config;

import com.blizzard.bgs.client.service.authentication.AuthenticationConfig;
import com.blizzard.login.bgs.BgsClientInfo;
import rx.SingleEmitter;

public class BgsLoginConfig
{
  private AuthenticationConfig authConfig;
  private String authToken;
  private SingleEmitter<BgsClientInfo> emitter;
  private boolean handleError;
  private boolean handleWebAuthChallenge;
  private boolean startInErrorState;
  private int timeout;
  
  private BgsLoginConfig(Builder paramBuilder)
  {
    if (paramBuilder.authConfig == null) {
      throw new IllegalArgumentException("authConfig cannot be null");
    }
    if (paramBuilder.emitter == null) {
      throw new IllegalArgumentException("emitter cannot be null");
    }
    if (paramBuilder.timeout != 0) {}
    for (int i = paramBuilder.timeout;; i = 10000)
    {
      this.timeout = i;
      this.authConfig = paramBuilder.authConfig;
      this.authToken = paramBuilder.authToken;
      this.emitter = paramBuilder.emitter;
      this.startInErrorState = paramBuilder.startInErrorState;
      this.handleWebAuthChallenge = paramBuilder.handleWebAuthChallenge;
      this.handleError = paramBuilder.handleError;
      return;
    }
  }
  
  public AuthenticationConfig getAuthConfig()
  {
    return this.authConfig;
  }
  
  public String getAuthToken()
  {
    return this.authToken;
  }
  
  public SingleEmitter<BgsClientInfo> getEmitter()
  {
    return this.emitter;
  }
  
  public int getTimeout()
  {
    return this.timeout;
  }
  
  public boolean isHandleError()
  {
    return this.handleError;
  }
  
  public boolean isHandleWebAuthChallenge()
  {
    return this.handleWebAuthChallenge;
  }
  
  public boolean isStartInErrorState()
  {
    return this.startInErrorState;
  }
  
  public static class Builder
  {
    private AuthenticationConfig authConfig;
    private String authToken;
    private SingleEmitter<BgsClientInfo> emitter;
    private boolean handleError;
    private boolean handleWebAuthChallenge;
    private boolean startInErrorState;
    private int timeout;
    
    public Builder authConfig(AuthenticationConfig paramAuthenticationConfig)
    {
      this.authConfig = paramAuthenticationConfig;
      return this;
    }
    
    public Builder authToken(String paramString)
    {
      this.authToken = paramString;
      return this;
    }
    
    public BgsLoginConfig build()
    {
      return new BgsLoginConfig(this, null);
    }
    
    public Builder emitter(SingleEmitter<BgsClientInfo> paramSingleEmitter)
    {
      this.emitter = paramSingleEmitter;
      return this;
    }
    
    public Builder handleError(boolean paramBoolean)
    {
      this.handleError = paramBoolean;
      return this;
    }
    
    public Builder handleWebAuthChallenge(boolean paramBoolean)
    {
      this.handleWebAuthChallenge = paramBoolean;
      return this;
    }
    
    public Builder startInErrorState(boolean paramBoolean)
    {
      this.startInErrorState = paramBoolean;
      return this;
    }
    
    public Builder timeout(int paramInt)
    {
      this.timeout = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/config/BgsLoginConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */