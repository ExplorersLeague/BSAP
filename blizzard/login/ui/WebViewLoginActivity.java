package com.blizzard.login.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.blizzard.bgs.client.service.authentication.AuthenticationConfig;
import com.blizzard.login.R.id;
import com.blizzard.login.R.layout;
import com.blizzard.login.bgs.BgsClient;
import com.blizzard.login.bgs.BgsClient.Builder;
import com.blizzard.login.config.LoginOverridesConfig;
import com.blizzard.login.config.LoginUIConfig;
import com.blizzard.login.config.LoginUIConfig.Builder;
import com.blizzard.login.constants.Urls;
import com.blizzard.login.listener.ChromeCustomTabListener;
import com.blizzard.login.listener.WebLoginListener;
import com.blizzard.login.logger.Logger;
import com.blizzard.login.provider.CookieProvider;
import com.blizzard.login.provider.RegionInfoProvider;
import com.blizzard.login.region.RegionInfo;
import com.blizzard.login.webview.LoginWebViewClient;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.Single;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class WebViewLoginActivity
  extends AppCompatActivity
  implements WebLoginListener, ChromeCustomTabListener, AdapterView.OnItemSelectedListener
{
  public static final String EXTERNAL_LOGIN_SCHEME_HEADER = "External-Login-Scheme";
  private static final String EXTRA_BGS_AUTH_CONFIG = "com.blizzard.loginsdk.EXTRA_BGS_AUTH_CONFIG";
  private static final String EXTRA_BGS_AUTH_TIMEOUT = "com.blizzard.loginsdk.EXTRA_BGS_AUTH_TIMEOUT";
  private static final String EXTRA_LOGIN_OVERRIDES_CONFIG = "com.blizzard.loginsdk.EXTRA_LOGIN_OVERRIDES_CONFIG";
  private static final String EXTRA_LOGIN_UI_CONFIG = "com.blizzard.loginsdk.EXTRA_LOGIN_UI_CONFIG";
  private static final String TAG = WebViewLoginActivity.class.getSimpleName();
  private BgsClient bgsClient;
  private Subscription bgsClientSubscription;
  private RelativeLayout errorLayout;
  private final Map<String, String> extraHeaders = new HashMap();
  private Set<String> loadedUrls = new HashSet();
  private RelativeLayout loadingLayout;
  private LoginOverridesConfig loginOverridesConfig;
  private LoginUIConfig loginUiConfig;
  private RegionInfo regionInfo;
  private RegionInfoProvider regionInfoProvider;
  private Spinner regionPicker;
  private RelativeLayout regionPickerLayout;
  private Toolbar toolbar;
  private WebView webView;
  private RelativeLayout webViewLayout;
  
  private void finishCanceled(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("com.blizzard.loginsdk.REGION_INFO", this.regionInfo);
    setResult(paramInt, localIntent);
    finish();
  }
  
  private void finishOk(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("com.blizzard.loginsdk.OAUTH_TOKEN", paramString);
    localIntent.putExtra("com.blizzard.loginsdk.REGION_INFO", this.regionInfo);
    setResult(-1, localIntent);
    finish();
  }
  
  private void handleError()
  {
    Logger.info(TAG, "handleError");
    showErrorView();
    CookieProvider.clearCookies(this, null);
  }
  
  private void initViews()
  {
    this.webViewLayout = ((RelativeLayout)findViewById(R.id.web_view_layout));
    this.toolbar = ((Toolbar)findViewById(R.id.toolbar));
    this.regionPickerLayout = ((RelativeLayout)findViewById(R.id.region_picker_layout));
    this.regionPicker = ((Spinner)findViewById(R.id.region_picker));
    this.webView = ((WebView)findViewById(R.id.web_view));
    this.errorLayout = ((RelativeLayout)findViewById(R.id.error_layout));
    this.loadingLayout = ((RelativeLayout)findViewById(R.id.loading_layout));
  }
  
  private void installErrorClickHandler(View paramView, @IdRes int paramInt, View.OnClickListener paramOnClickListener)
  {
    paramView = paramView.findViewById(paramInt);
    if (paramView != null) {
      paramView.setOnClickListener(paramOnClickListener);
    }
  }
  
  private boolean isRedirect()
  {
    Uri localUri = getIntent().getData();
    return (localUri != null) && (localUri.toString().contains("localhost"));
  }
  
  private void loadUrl(String paramString)
  {
    Logger.info(TAG, "loadUrl url=" + paramString);
    showLoadingView();
    this.webView.loadUrl(paramString, this.extraHeaders);
  }
  
  private void refreshWebView()
  {
    Bundle localBundle = getIntent().getExtras();
    this.loginOverridesConfig = ((LoginOverridesConfig)localBundle.getParcelable("com.blizzard.loginsdk.EXTRA_LOGIN_OVERRIDES_CONFIG"));
    this.loginUiConfig = ((LoginUIConfig)localBundle.getParcelable("com.blizzard.loginsdk.EXTRA_LOGIN_UI_CONFIG"));
    if (this.loginUiConfig == null) {
      this.loginUiConfig = new LoginUIConfig.Builder().build();
    }
    String str = localBundle.getString("com.blizzard.loginsdk.EXTRA_BGS_AUTH_CONFIG");
    if (str != null) {}
    for (this.bgsClient = new BgsClient.Builder().context(this).authConfig(AuthenticationConfig.from(str)).timeout(localBundle.getInt("com.blizzard.loginsdk.EXTRA_BGS_AUTH_TIMEOUT")).build();; this.bgsClient = null)
    {
      this.extraHeaders.clear();
      this.extraHeaders.put("External-Login-Scheme", this.loginOverridesConfig.getExternalLoginScheme());
      initViews();
      updateActionBar();
      updateRegionPicker();
      updateWebView();
      updateErrorView();
      updateLoadingView();
      if (!Urls.isErrorUrl(this.loginOverridesConfig.getLoginUrl())) {
        break;
      }
      handleError();
      return;
    }
    loadUrl(this.loginOverridesConfig.getLoginUrl());
  }
  
  private void retrieveAuthTokenFromRedirect()
  {
    onLoginCompleted(getIntent().getData().getQueryParameter("ST"));
  }
  
  private void setBackground(View paramView, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      paramView.setBackgroundColor(0);
      paramView.setBackground(paramDrawable);
    }
  }
  
  private void showErrorView()
  {
    this.webViewLayout.setVisibility(8);
    this.errorLayout.setVisibility(0);
    this.loadingLayout.setVisibility(8);
  }
  
  private void showLoadingView()
  {
    this.webViewLayout.setVisibility(0);
    this.errorLayout.setVisibility(8);
    this.loadingLayout.setVisibility(0);
  }
  
  private void showWebView()
  {
    this.webViewLayout.setVisibility(0);
    this.errorLayout.setVisibility(8);
    this.loadingLayout.setVisibility(8);
  }
  
  private void updateActionBar()
  {
    setSupportActionBar(this.toolbar);
    Object localObject = getSupportActionBar();
    if (localObject != null)
    {
      ((ActionBar)localObject).setDisplayHomeAsUpEnabled(true);
      ((ActionBar)localObject).setBackgroundDrawable(new ColorDrawable(this.loginUiConfig.getColorPrimary(this)));
      ((ActionBar)localObject).setTitle(this.loginUiConfig.getActionBarTitle(this));
      int i = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
      if (i != 0)
      {
        localObject = (TextView)findViewById(i);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(this.loginUiConfig.getActionBarTextColor(this));
        }
      }
    }
    updateWindowFlags();
  }
  
  private void updateErrorView()
  {
    View localView = this.loginUiConfig.loadErrorLayout(this, this.errorLayout);
    installErrorClickHandler(localView, R.id.login_error_close_view, WebViewLoginActivity..Lambda.1.lambdaFactory$(this));
    installErrorClickHandler(localView, R.id.login_error_retry_view, WebViewLoginActivity..Lambda.4.lambdaFactory$(this));
  }
  
  private void updateLoadingView()
  {
    this.loginUiConfig.loadLoadingLayout(this, this.loadingLayout);
  }
  
  private void updateRegionPicker()
  {
    this.regionPickerLayout.setBackgroundColor(this.loginUiConfig.getColorPrimary(this));
    this.regionPicker.setPopupBackgroundDrawable(new ColorDrawable(this.loginUiConfig.getColorPrimary(this)));
    this.regionPicker.setOnItemSelectedListener(this);
    Object localObject1 = this.regionPicker;
    if (this.loginOverridesConfig.isRegionPickerHidden()) {}
    for (int i = 8;; i = 0)
    {
      ((Spinner)localObject1).setVisibility(i);
      this.regionInfoProvider = new RegionInfoProvider(this, this.loginOverridesConfig);
      this.regionInfo = this.regionInfoProvider.getSelectedRegionInfo();
      Object localObject2 = this.regionInfoProvider.getRegionInfoList();
      localObject1 = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(new RegionDisplay((RegionInfo)((Iterator)localObject2).next()));
      }
    }
    localObject1 = new ArrayAdapter(this, R.layout.region_picker, (List)localObject1);
    ((ArrayAdapter)localObject1).setDropDownViewResource(R.layout.region_picker_dropdown_item);
    this.regionPicker.setAdapter((SpinnerAdapter)localObject1);
    i = 0;
    for (;;)
    {
      if (i < ((ArrayAdapter)localObject1).getCount())
      {
        if (((RegionDisplay)((ArrayAdapter)localObject1).getItem(i)).regionInfo.getRegionCode() == this.regionInfo.getRegionCode()) {
          this.regionPicker.setSelection(i, true);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  private void updateWebView()
  {
    this.webView.setWebViewClient(new LoginWebViewClient(this, this.loginOverridesConfig));
    this.webView.setBackgroundColor(0);
    WebSettings localWebSettings = this.webView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setDomStorageEnabled(true);
    setBackground(this.webViewLayout, this.loginUiConfig.getBackground(this));
    CookieProvider.setAcceptCookies(this.webView, true);
  }
  
  private void updateWindowFlags()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.clearFlags(67108864);
      localWindow.addFlags(Integer.MIN_VALUE);
      localWindow.setStatusBarColor(this.loginUiConfig.getColorPrimaryDark(this));
    }
  }
  
  void cancelGetBgsUrl()
  {
    if (this.bgsClientSubscription != null)
    {
      this.bgsClientSubscription.unsubscribe();
      this.bgsClientSubscription = null;
    }
  }
  
  void getBgsUrl(RegionInfo paramRegionInfo)
  {
    cancelGetBgsUrl();
    if (this.bgsClient != null)
    {
      showLoadingView();
      this.bgsClientSubscription = this.bgsClient.getBgsWebAuthUrl(paramRegionInfo).observeOn(AndroidSchedulers.mainThread()).subscribe(WebViewLoginActivity..Lambda.5.lambdaFactory$(this), WebViewLoginActivity..Lambda.6.lambdaFactory$(this));
    }
  }
  
  public void onChromeCustomTabStarted(String paramString)
  {
    Logger.info(TAG, "onChromeCustomTabStarted url=" + paramString);
    if (Urls.isFacebookLoginUrl(paramString)) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.login.ui.WebViewLoginActivity");
    Logger.info(TAG, "onCreate");
    getWindow().addFlags(8192);
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_login);
    refreshWebView();
  }
  
  public void onDestroy()
  {
    Logger.info(TAG, "onDestroy");
    super.onDestroy();
    cancelGetBgsUrl();
  }
  
  public void onHeadlessAccountIdFound(String paramString)
  {
    Logger.info(TAG, "onHeadlessAccountIdFound accountId=" + paramString);
    Intent localIntent = new Intent();
    localIntent.setAction("com.blizzard.loginsdk.HEADLESS_ACCOUNT_ID");
    localIntent.putExtra("com.blizzard.loginsdk.HEADLESS_ACCOUNT_ID", paramString);
    sendBroadcast(localIntent);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (RegionDisplay)paramAdapterView.getItemAtPosition(paramInt);
    if (paramAdapterView != null)
    {
      paramAdapterView = paramAdapterView.regionInfo;
      if (paramAdapterView.getRegionCode() != this.regionInfo.getRegionCode())
      {
        Logger.info(TAG, "onRegionSelected regionInfo=" + this.regionInfo);
        this.regionInfo = paramAdapterView;
        paramAdapterView = new Intent();
        paramAdapterView.setAction("com.blizzard.loginsdk.REGION_INFO");
        paramAdapterView.putExtra("com.blizzard.loginsdk.REGION_INFO", this.regionInfo);
        sendBroadcast(paramAdapterView);
        getBgsUrl(this.regionInfo);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {}
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if (this.webView.canGoBack()) {
      this.webView.goBack();
    }
    for (;;)
    {
      return true;
      finish();
    }
  }
  
  public void onLoginCompleted(String paramString)
  {
    Logger.info(TAG, "onLoginCompleted oauthToken=" + paramString);
    Intent localIntent = new Intent();
    localIntent.setAction("com.blizzard.loginsdk.OAUTH_TOKEN");
    localIntent.putExtra("com.blizzard.loginsdk.OAUTH_TOKEN", paramString);
    localIntent.putExtra("com.blizzard.loginsdk.WEB_AUTH_URLS", Urls.toString(this.loadedUrls));
    sendBroadcast(localIntent);
    finishOk(paramString);
  }
  
  public void onLoginError(int paramInt, String paramString1, String paramString2)
  {
    Logger.info(TAG, "onLoginError errorCode=" + paramInt + ", description=" + paramString1 + ", url=" + paramString2);
    if (paramInt == 400) {
      return;
    }
    handleError();
  }
  
  public void onLoginPageLoaded(String paramString)
  {
    Logger.info(TAG, "onLoginPageLoaded url=" + paramString);
    showWebView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Logger.info(TAG, "onNewIntent");
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    refreshWebView();
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finishCanceled(0);
    return true;
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.login.ui.WebViewLoginActivity");
    Logger.info(TAG, "onResume");
    super.onResume();
    if (isRedirect()) {
      retrieveAuthTokenFromRedirect();
    }
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.login.ui.WebViewLoginActivity");
    super.onStart();
  }
  
  public void onUrlLoaded(String paramString)
  {
    Logger.info(TAG, "onUrlLoaded url=" + paramString);
    this.loadedUrls.add(paramString.split("\\?")[0]);
  }
  
  public static class IntentBuilder
  {
    AuthenticationConfig bgsAuthConfig;
    int bgsAuthTimeout;
    Context context;
    LoginOverridesConfig loginOverridesConfig;
    LoginUIConfig loginUiConfig;
    
    public IntentBuilder bgsAuthConfig(AuthenticationConfig paramAuthenticationConfig)
    {
      this.bgsAuthConfig = paramAuthenticationConfig;
      return this;
    }
    
    public IntentBuilder bgsAuthTimeout(int paramInt)
    {
      this.bgsAuthTimeout = paramInt;
      return this;
    }
    
    public Intent build()
    {
      if (this.context == null) {
        throw new IllegalArgumentException("context cannot be null");
      }
      if (this.loginOverridesConfig == null) {
        throw new IllegalArgumentException("loginOverridesConfig cannot be null");
      }
      Intent localIntent = new Intent(this.context, WebViewLoginActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("com.blizzard.loginsdk.EXTRA_LOGIN_OVERRIDES_CONFIG", this.loginOverridesConfig);
      if (this.loginUiConfig != null) {
        localBundle.putParcelable("com.blizzard.loginsdk.EXTRA_LOGIN_UI_CONFIG", this.loginUiConfig);
      }
      if (this.bgsAuthConfig != null)
      {
        localBundle.putString("com.blizzard.loginsdk.EXTRA_BGS_AUTH_CONFIG", this.bgsAuthConfig.toString());
        localBundle.putInt("com.blizzard.loginsdk.EXTRA_BGS_AUTH_TIMEOUT", this.bgsAuthTimeout);
      }
      if (!localBundle.isEmpty()) {
        localIntent.putExtras(localBundle);
      }
      localIntent.addFlags(67108864);
      return localIntent;
    }
    
    public IntentBuilder context(Context paramContext)
    {
      this.context = paramContext;
      return this;
    }
    
    public IntentBuilder loginOverridesConfig(LoginOverridesConfig paramLoginOverridesConfig)
    {
      this.loginOverridesConfig = paramLoginOverridesConfig;
      return this;
    }
    
    public IntentBuilder loginUiConfig(LoginUIConfig paramLoginUIConfig)
    {
      this.loginUiConfig = paramLoginUIConfig;
      return this;
    }
  }
  
  private static class RegionDisplay
  {
    RegionInfo regionInfo;
    
    RegionDisplay(RegionInfo paramRegionInfo)
    {
      this.regionInfo = paramRegionInfo;
    }
    
    public String toString()
    {
      return this.regionInfo.getDisplayName();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/ui/WebViewLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */