package com.blizzard.login.provider;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.blizzard.bgs.client.exception.WebAuthUrlChallenge;
import com.blizzard.login.bgs.BgsClient;
import com.blizzard.login.bgs.BgsClient.Builder;
import com.blizzard.login.bgs.BgsClientInfo;
import com.blizzard.login.config.BgsLoginConfig;
import com.blizzard.login.config.LoginOverridesConfig;
import com.blizzard.login.config.LoginUIConfig;
import com.blizzard.login.constants.Urls;
import com.blizzard.login.logger.Logger;
import com.blizzard.login.region.RegionInfo;
import com.blizzard.login.ui.WebViewLoginActivity.IntentBuilder;
import rx.Single;
import rx.SingleEmitter;
import rx.Subscription;

public class BgsLoginProvider
{
  private static final String TAG = BgsLoginProvider.class.getSimpleName();
  private String authToken;
  private BgsClient bgsClient;
  private final BgsLoginConfig bgsLoginConfig;
  private Subscription bgsLoginSubscription;
  private final Context context;
  private final LoginOverridesConfig loginOverridesConfig;
  private final LoginUIConfig loginUiConfig;
  private RegionInfo regionInfo;
  private RegionInfoReceiver regionInfoReceiver;
  private WebAuthTokenReceiver webAuthTokenReceiver;
  
  public BgsLoginProvider(Context paramContext, LoginUIConfig paramLoginUIConfig, LoginOverridesConfig paramLoginOverridesConfig, BgsLoginConfig paramBgsLoginConfig)
  {
    this.context = paramContext;
    this.loginUiConfig = paramLoginUIConfig;
    this.loginOverridesConfig = paramLoginOverridesConfig;
    this.bgsLoginConfig = paramBgsLoginConfig;
    this.authToken = paramBgsLoginConfig.getAuthToken();
    this.bgsClient = new BgsClient.Builder().context(paramContext).authConfig(paramBgsLoginConfig.getAuthConfig()).timeout(paramBgsLoginConfig.getTimeout()).build();
    this.regionInfo = new RegionInfoProvider(paramContext, paramLoginOverridesConfig).getSelectedRegionInfo();
    setupReceivers();
    paramBgsLoginConfig.getEmitter().setCancellation(BgsLoginProvider..Lambda.1.lambdaFactory$(this));
  }
  
  private void onBgsLoginError(Throwable paramThrowable)
  {
    Logger.info(TAG, "onBgsLoginError throwable=" + paramThrowable, paramThrowable);
    teardownSubscription();
    boolean bool = paramThrowable instanceof WebAuthUrlChallenge;
    if ((bool) && (this.bgsLoginConfig.isHandleWebAuthChallenge()))
    {
      startWebAuth(((WebAuthUrlChallenge)paramThrowable).getUrl());
      return;
    }
    if ((!bool) && (this.bgsLoginConfig.isHandleError()))
    {
      startWebAuth(Urls.getErrorUrl());
      return;
    }
    this.bgsLoginConfig.getEmitter().onError(paramThrowable);
  }
  
  private void onBgsLoginSuccess(BgsClientInfo paramBgsClientInfo)
  {
    Logger.info(TAG, "onBgsLoginSuccess");
    teardownSubscription();
    teardownReceivers();
    this.bgsLoginConfig.getEmitter().onSuccess(paramBgsClientInfo);
  }
  
  private void setupReceivers()
  {
    this.webAuthTokenReceiver = new WebAuthTokenReceiver();
    this.context.registerReceiver(this.webAuthTokenReceiver, new IntentFilter("com.blizzard.loginsdk.OAUTH_TOKEN"));
    this.regionInfoReceiver = new RegionInfoReceiver();
    this.context.registerReceiver(this.regionInfoReceiver, new IntentFilter("com.blizzard.loginsdk.REGION_INFO"));
  }
  
  private void startLogin(boolean paramBoolean)
  {
    Logger.info(TAG, "startLogin errorState=" + paramBoolean + ", token=" + this.authToken + ", url=" + this.regionInfo.getServerUrl());
    teardownSubscription();
    if (paramBoolean)
    {
      startWebAuth(Urls.getErrorUrl());
      return;
    }
    this.bgsLoginSubscription = this.bgsClient.getBgsClientInfo(this.regionInfo, this.authToken).subscribe(BgsLoginProvider..Lambda.2.lambdaFactory$(this), BgsLoginProvider..Lambda.3.lambdaFactory$(this));
  }
  
  private void startWebAuth(String paramString)
  {
    this.loginOverridesConfig.setLoginUrl(paramString);
    this.loginOverridesConfig.setSelectedRegion(this.regionInfo.getRegionCode());
    Logger.info(TAG, "startWebAuth url=" + paramString + ", selectedRegion=" + this.regionInfo.getRegionCode());
    paramString = new WebViewLoginActivity.IntentBuilder().context(this.context).loginOverridesConfig(this.loginOverridesConfig).loginUiConfig(this.loginUiConfig).bgsAuthConfig(this.bgsLoginConfig.getAuthConfig()).bgsAuthTimeout(this.bgsLoginConfig.getTimeout()).build();
    if ((this.context instanceof Activity))
    {
      ((Activity)this.context).startActivityForResult(paramString, 10001);
      return;
    }
    paramString.addFlags(paramString.getFlags() | 0x10000000);
    this.context.startActivity(paramString);
  }
  
  private void teardownReceivers()
  {
    this.context.unregisterReceiver(this.webAuthTokenReceiver);
    this.context.unregisterReceiver(this.regionInfoReceiver);
  }
  
  private void teardownSubscription()
  {
    if (this.bgsLoginSubscription != null)
    {
      this.bgsLoginSubscription.unsubscribe();
      this.bgsLoginSubscription = null;
    }
  }
  
  public void cancelLogin()
  {
    Logger.info(TAG, "cancelLogin");
    teardownSubscription();
    teardownReceivers();
  }
  
  public void startLogin()
  {
    startLogin(this.bgsLoginConfig.isStartInErrorState());
  }
  
  public class RegionInfoReceiver
    extends BroadcastReceiver
  {
    public RegionInfoReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      BgsLoginProvider.access$302(BgsLoginProvider.this, (RegionInfo)paramIntent.getParcelableExtra("com.blizzard.loginsdk.REGION_INFO"));
      BgsLoginProvider.access$002(BgsLoginProvider.this, null);
      Logger.debug(BgsLoginProvider.TAG, "Region info received: " + BgsLoginProvider.this.regionInfo);
    }
  }
  
  public class WebAuthTokenReceiver
    extends BroadcastReceiver
  {
    public WebAuthTokenReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      BgsLoginProvider.access$002(BgsLoginProvider.this, paramIntent.getStringExtra("com.blizzard.loginsdk.OAUTH_TOKEN"));
      Logger.debug(BgsLoginProvider.TAG, "Auth token received: " + BgsLoginProvider.this.authToken);
      BgsLoginProvider.this.startLogin(false);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/provider/BgsLoginProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */