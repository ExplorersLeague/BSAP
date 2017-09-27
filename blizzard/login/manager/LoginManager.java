package com.blizzard.login.manager;

import android.content.Context;
import android.content.Intent;
import com.blizzard.login.config.BgsLoginConfig;
import com.blizzard.login.config.LoginOverridesConfig;
import com.blizzard.login.config.LoginOverridesConfig.Builder;
import com.blizzard.login.config.LoginUIConfig;
import com.blizzard.login.config.LoginUIConfig.Builder;
import com.blizzard.login.constants.Urls;
import com.blizzard.login.logger.Logger;
import com.blizzard.login.provider.BgsLoginProvider;
import com.blizzard.login.provider.CookieProvider;
import com.blizzard.login.provider.CookieProvider.WhiteList;
import com.blizzard.login.provider.HeadlessAccountProvider;
import com.blizzard.login.ui.WebViewLoginActivity.IntentBuilder;

public class LoginManager
{
  private static final String TAG = LoginManager.class.getSimpleName();
  private String appName;
  private BgsLoginConfig bgsLoginConfig;
  private BgsLoginProvider bgsLoginProvider;
  private final Context context;
  private HeadlessAccountProvider headlessAccountProvider;
  private LoginOverridesConfig loginOverridesConfig;
  private LoginType loginType;
  private LoginUIConfig loginUiConfig;
  
  private LoginManager(Builder paramBuilder)
  {
    this.context = paramBuilder.context;
    this.appName = paramBuilder.appName;
    this.loginType = paramBuilder.loginType;
    this.bgsLoginConfig = paramBuilder.bgsLoginConfig;
    if ((paramBuilder.loginType == LoginType.BGS) && (paramBuilder.bgsLoginConfig == null)) {
      throw new IllegalArgumentException("BgsLoginConfig must be provided for BGS login type");
    }
    if (paramBuilder.loginOverridesConfig != null)
    {
      this.loginOverridesConfig = paramBuilder.loginOverridesConfig;
      if (paramBuilder.loginUiConfig == null) {
        break label119;
      }
    }
    label119:
    for (this.loginUiConfig = paramBuilder.loginUiConfig;; this.loginUiConfig = new LoginUIConfig.Builder().build())
    {
      init();
      return;
      this.loginOverridesConfig = new LoginOverridesConfig.Builder(this.appName).build();
      break;
    }
  }
  
  public static void clearCookies(Context paramContext)
  {
    Logger.info(TAG, "clearCookies");
    CookieProvider.clearCookies(paramContext, null);
  }
  
  public static void clearCookies(Context paramContext, String paramString)
  {
    Logger.info(TAG, "clearCookies urls=" + paramString);
    CookieProvider.clearCookies(paramContext, createWhiteLists(paramString));
  }
  
  public static void clearCookies(Context paramContext, CookieProvider.WhiteList[] paramArrayOfWhiteList)
  {
    Logger.info(TAG, "clearCookies");
    CookieProvider.clearCookies(paramContext, paramArrayOfWhiteList);
  }
  
  private static CookieProvider.WhiteList[] createWhiteLists(String paramString)
  {
    paramString = Urls.fromString(paramString);
    if (paramString != null) {}
    CookieProvider.WhiteList[] arrayOfWhiteList;
    for (int i = paramString.length;; i = 0)
    {
      arrayOfWhiteList = new CookieProvider.WhiteList[i];
      i = 0;
      while (i < arrayOfWhiteList.length)
      {
        arrayOfWhiteList[i = new CookieProvider.WhiteList()
        {
          public String getDomain()
          {
            return this.val$url;
          }
          
          public String[] getWhiteList()
          {
            return CookieProvider.COOKIE_WHITELIST;
          }
        };
        i += 1;
      }
    }
    return arrayOfWhiteList;
  }
  
  private void init()
  {
    switch (this.loginType)
    {
    default: 
      return;
    case ???: 
      setupHeadlessAccountProvider();
      return;
    }
    setupBgsLoginProvider();
  }
  
  private void setupBgsLoginProvider()
  {
    this.bgsLoginProvider = new BgsLoginProvider(this.context, this.loginUiConfig, this.loginOverridesConfig, this.bgsLoginConfig);
  }
  
  private void setupHeadlessAccountProvider()
  {
    this.headlessAccountProvider = new HeadlessAccountProvider(this.context, this.appName, this.loginOverridesConfig);
  }
  
  private void startWebLogin()
  {
    Logger.info(TAG, "startWebLogin");
    Intent localIntent = new WebViewLoginActivity.IntentBuilder().context(this.context).loginOverridesConfig(this.loginOverridesConfig).loginUiConfig(this.loginUiConfig).build();
    this.context.startActivity(localIntent);
  }
  
  public void cancel()
  {
    Logger.info(TAG, "cancel");
    switch (this.loginType)
    {
    default: 
      return;
    }
    this.bgsLoginProvider.cancelLogin();
  }
  
  public void start()
  {
    Logger.info(TAG, "start");
    switch (this.loginType)
    {
    default: 
      return;
    case ???: 
      startWebLogin();
      return;
    case ???: 
      this.headlessAccountProvider.startLogin();
      return;
    }
    this.bgsLoginProvider.startLogin();
  }
  
  public static class Builder
  {
    private String appName;
    private BgsLoginConfig bgsLoginConfig;
    private Context context;
    private LoginOverridesConfig loginOverridesConfig;
    private LoginType loginType;
    private LoginUIConfig loginUiConfig;
    
    public Builder(Context paramContext, String paramString, LoginType paramLoginType)
    {
      this.context = paramContext;
      this.appName = paramString;
      this.loginType = paramLoginType;
      if (paramContext == null) {
        throw new IllegalArgumentException("context cannot be null");
      }
      if (paramString == null) {
        throw new IllegalArgumentException("appName cannot be null");
      }
      if (paramLoginType == null) {
        throw new IllegalArgumentException("loginType cannot be null");
      }
    }
    
    public LoginManager build()
    {
      return new LoginManager(this, null);
    }
    
    public Builder setBgsLoginConfig(BgsLoginConfig paramBgsLoginConfig)
    {
      this.bgsLoginConfig = paramBgsLoginConfig;
      return this;
    }
    
    public Builder setLoginOverridesConfig(LoginOverridesConfig paramLoginOverridesConfig)
    {
      this.loginOverridesConfig = paramLoginOverridesConfig;
      return this;
    }
    
    public Builder setLoginUIConfig(LoginUIConfig paramLoginUIConfig)
    {
      this.loginUiConfig = paramLoginUIConfig;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/manager/LoginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */