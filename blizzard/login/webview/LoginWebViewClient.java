package com.blizzard.login.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.blizzard.login.R.color;
import com.blizzard.login.config.LoginOverridesConfig;
import com.blizzard.login.constants.Urls;
import com.blizzard.login.listener.ChromeCustomTabListener;
import com.blizzard.login.listener.WebLoginListener;
import com.blizzard.login.logger.Logger;
import com.blizzard.login.provider.CookieProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginWebViewClient
  extends WebViewClient
{
  private static final String COOKIE_BNET_GUEST_ID = "bnet.guest.id";
  private static final String HEADER_DEVICE_ID = "Device-Id";
  private static final String PARAMETER_AUTH_TOKEN = "ST";
  private static final String TAG = LoginWebViewClient.class.getSimpleName();
  private static final String URL_HOST_BAM_RELEASE = "bam-release-us.web.blizzard.net";
  private static final String URL_SCHEME_EXTERNAL_PREFIX = "external-";
  private String androidId;
  private ChromeCustomTabListener chromeCustomTabListener;
  private Context context;
  private int loadCounter;
  private List<String> loadedUrls = new ArrayList();
  private WebLoginListener loginListener;
  private String loginSchemeHeader;
  private int toolbarColor;
  
  public LoginWebViewClient(Context paramContext, LoginOverridesConfig paramLoginOverridesConfig)
  {
    this.context = paramContext;
    this.androidId = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    this.loginSchemeHeader = paramLoginOverridesConfig.getExternalLoginScheme();
    this.toolbarColor = paramContext.getResources().getColor(R.color.color_primary_blizzcon);
    if ((paramContext instanceof ChromeCustomTabListener)) {
      this.chromeCustomTabListener = ((ChromeCustomTabListener)paramContext);
    }
    if ((paramContext instanceof WebLoginListener)) {
      this.loginListener = ((WebLoginListener)paramContext);
    }
  }
  
  private void handleError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Logger.error(TAG, "handleError errorCode=" + paramInt + ", description=" + paramString1 + ", url=" + paramString2);
    this.loadCounter = 0;
    this.loadedUrls.clear();
    if (this.loginListener != null) {
      this.loginListener.onLoginError(paramInt, paramString1, paramString2);
    }
  }
  
  private boolean handleUrl(WebView paramWebView, String paramString)
  {
    Logger.info(TAG, "handleUrl url=" + paramString);
    this.loadCounter += 1;
    this.loadedUrls.add(paramString);
    if (Uri.parse(paramString).getScheme().startsWith("external-"))
    {
      loadExternalLink(paramString);
      return true;
    }
    if (Urls.isLocalHostUrl(paramString))
    {
      retrieveOAuthToken(paramString);
      retrieveHeadlessAccountId();
      return true;
    }
    if (Urls.isBlizzardLoginUrl(paramString))
    {
      startBlizzardLogin(paramString);
      return true;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("External-Login-Scheme", this.loginSchemeHeader);
    localHashMap.put("Device-Id", this.androidId);
    paramWebView.loadUrl(paramString, localHashMap);
    return false;
  }
  
  private void loadExternalLink(String paramString)
  {
    Logger.info(TAG, "loadExternalLink url=" + paramString);
    loadInCustomTab(paramString.replaceFirst("external-", ""));
  }
  
  private void loadInCustomTab(String paramString)
  {
    Logger.info(TAG, "loadInCustomTab url=" + paramString);
    new CustomTabsIntent.Builder().setToolbarColor(this.toolbarColor).build().launchUrl(this.context, Uri.parse(paramString));
    if (this.chromeCustomTabListener != null) {
      this.chromeCustomTabListener.onChromeCustomTabStarted(paramString);
    }
  }
  
  private void retrieveHeadlessAccountId()
  {
    Logger.info(TAG, "retrieveHeadlessAccountId");
    String str = CookieProvider.getCookie("https://bam-release-us.web.blizzard.net/account/creation/landing", "bnet.guest.id");
    if ((str != null) && (this.loginListener != null)) {
      this.loginListener.onHeadlessAccountIdFound(str);
    }
  }
  
  private void retrieveOAuthToken(String paramString)
  {
    Logger.info(TAG, "retrieveOauthToken");
    paramString = Uri.parse(paramString).getQueryParameter("ST");
    if (this.loginListener != null) {
      this.loginListener.onLoginCompleted(paramString);
    }
  }
  
  private void startBlizzardLogin(String paramString)
  {
    Logger.info(TAG, "startBlizzardLogin url=" + paramString);
    loadInCustomTab(paramString.replace("blizzard-login", "https"));
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.loginListener != null) {
      this.loginListener.onUrlLoaded(paramString);
    }
    int i = this.loadCounter - 1;
    this.loadCounter = i;
    if ((i == 0) && (this.loginListener != null)) {
      this.loginListener.onLoginPageLoaded(paramString);
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramWebView.evaluateJavascript("javascript:(function() {    var nodeList = document.getElementsByTagName('a');    var index;    for (index=0; index<nodeList.length; index++) {        var node = nodeList[index];        var rel = node.getAttribute('rel');        if (rel === 'external') {           var href=node.getAttribute('href').trim();           node.setAttribute('href','external-'.concat(href));        }    }})();", null);
      return;
    }
    paramWebView.loadUrl("javascript:(function() {    var nodeList = document.getElementsByTagName('a');    var index;    for (index=0; index<nodeList.length; index++) {        var node = nodeList[index];        var rel = node.getAttribute('rel');        if (rel === 'external') {           var href=node.getAttribute('href').trim();           node.setAttribute('href','external-'.concat(href));        }    }})();");
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (this.loadCounter == 0)
    {
      this.loadedUrls.clear();
      this.loadCounter = 1;
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    handleError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  @TargetApi(23)
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    handleError(paramWebView, paramWebResourceError.getErrorCode(), paramWebResourceError.getDescription().toString(), paramWebResourceRequest.getUrl().toString());
  }
  
  @TargetApi(23)
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    handleError(paramWebView, paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceRequest.getUrl().toString());
  }
  
  @TargetApi(21)
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return handleUrl(paramWebView, paramWebResourceRequest.getUrl().toString());
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return handleUrl(paramWebView, paramString);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/webview/LoginWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */