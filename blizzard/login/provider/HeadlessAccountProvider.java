package com.blizzard.login.provider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.blizzard.login.config.LoginOverridesConfig;
import com.blizzard.login.ui.WebViewLoginActivity.IntentBuilder;

public class HeadlessAccountProvider
{
  private static final String TAG = HeadlessAccountProvider.class.getSimpleName();
  private final String appName;
  private final Context context;
  private final LoginOverridesConfig loginOverridesConfig;
  
  public HeadlessAccountProvider(Context paramContext, String paramString, LoginOverridesConfig paramLoginOverridesConfig)
  {
    this.appName = paramString;
    this.context = paramContext;
    this.loginOverridesConfig = paramLoginOverridesConfig;
    setupDefaultNydusUrl();
  }
  
  private void setupDefaultNydusUrl()
  {
    Log.w(TAG, "setupDefaultNydusUrl()");
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https").authority("nydus-qa.web.blizzard.net").appendPath(this.appName).appendPath("enUS").appendPath("client-mobile").appendPath("account").appendPath("landing").appendQueryParameter("targetRegion", "US");
    this.loginOverridesConfig.setLoginUrl(localBuilder.build().toString());
  }
  
  public void startLogin()
  {
    Intent localIntent = new WebViewLoginActivity.IntentBuilder().context(this.context).loginOverridesConfig(this.loginOverridesConfig).build();
    this.context.startActivity(localIntent);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/provider/HeadlessAccountProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */