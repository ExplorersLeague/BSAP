package com.blizzard.messenger.data.providers;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import com.blizzard.bgs.client.service.authentication.message.v1.LogonResult;
import com.blizzard.bgs.client.service.base.AccountEntityId;
import com.blizzard.login.bgs.BgsClientInfo;
import com.blizzard.login.region.RegionInfo;
import com.blizzard.login.region.RegionInfo.Builder;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.Single;

public class BgsAuthProvider
{
  private static final String TAG = BgsAuthProvider.class.getSimpleName();
  private static final int XMPP_PORT = 5222;
  private Builder builder;
  
  private BgsAuthProvider(Builder paramBuilder)
  {
    this.builder = paramBuilder;
  }
  
  private static Credentials getCachedCredentials(Context paramContext)
  {
    paramContext = SharedPrefsUtils.getBgsAuthCredentials(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      paramContext = null;
    }
    Credentials localCredentials;
    do
    {
      return paramContext;
      localCredentials = Credentials.fromJson(paramContext);
      paramContext = localCredentials;
    } while (localCredentials.isValid());
    return null;
  }
  
  private List<RegionInfo> getDevRegionInfo()
  {
    ArrayList localArrayList = new ArrayList();
    RegionInfo localRegionInfo1 = new RegionInfo.Builder().regionCode(95).displayName("DEV-2").serverUrl("wss://dev2.bgs.battle.net:1119").subProtocol("jsonrpc.aurora.v1.31.battle.net").build();
    RegionInfo localRegionInfo2 = new RegionInfo.Builder().regionCode(101).displayName("DEV-3").serverUrl("wss://dev3-bn-front01.battle.net:1119").subProtocol("jsonrpc.aurora.v1.31.battle.net").build();
    RegionInfo localRegionInfo3 = new RegionInfo.Builder().regionCode(96).displayName("ST-21 (US)").serverUrl("wss://st21.bgs.battle.net:1119").subProtocol("jsonrpc.aurora.v1.31.battle.net").build();
    RegionInfo localRegionInfo4 = new RegionInfo.Builder().regionCode(97).displayName("ST-22 (EU)").serverUrl("wss://st22.bgs.battle.net:1119").subProtocol("jsonrpc.aurora.v1.31.battle.net").build();
    RegionInfo localRegionInfo5 = new RegionInfo.Builder().regionCode(98).displayName("ST-23 (KR)").serverUrl("wss://st23.bgs.battle.net:1119").subProtocol("jsonrpc.aurora.v1.31.battle.net").build();
    RegionInfo localRegionInfo6 = new RegionInfo.Builder().regionCode(99).displayName("ST-25 (CN)").serverUrl("wss://st25.bgs.battle.net:1119").subProtocol("jsonrpc.aurora.v1.31.battle.net").build();
    localArrayList.add(localRegionInfo1);
    localArrayList.add(localRegionInfo2);
    localArrayList.add(localRegionInfo3);
    localArrayList.add(localRegionInfo4);
    localArrayList.add(localRegionInfo5);
    localArrayList.add(localRegionInfo6);
    return localArrayList;
  }
  
  private Credentials newCredentials(BgsClientInfo paramBgsClientInfo)
  {
    long l = paramBgsClientInfo.getUserProperties().getAccountId().getAccountId();
    Object localObject = paramBgsClientInfo.getClientResponse();
    paramBgsClientInfo = (String)((Map)localObject).get("xmpp_host");
    if (TextUtils.isEmpty(paramBgsClientInfo)) {
      throw new IllegalArgumentException("Empty XMPP server URL");
    }
    String str = (String)((Map)localObject).get("session");
    if (TextUtils.isEmpty(str)) {
      throw new IllegalArgumentException("Empty XMPP session token");
    }
    localObject = (String)((Map)localObject).get("utility_host");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      throw new IllegalArgumentException("Empty utility server URL");
    }
    return new Credentials(l, paramBgsClientInfo, 5222, str, (String)localObject, null);
  }
  
  private static Single<Credentials> setCachedCredentials(Context paramContext, Credentials paramCredentials)
  {
    SharedPrefsUtils.setBgsAuthCredentials(paramContext, paramCredentials.toJson());
    return Single.just(paramCredentials);
  }
  
  public Single<Credentials> authenticate(Configuration paramConfiguration)
  {
    Credentials localCredentials = getCachedCredentials(paramConfiguration.context);
    if ((localCredentials != null) && (!paramConfiguration.startInErrorState)) {
      return Single.just(localCredentials).doOnSuccess(BgsAuthProvider..Lambda.1.lambdaFactory$());
    }
    return Single.fromEmitter(BgsAuthProvider..Lambda.2.lambdaFactory$(this, paramConfiguration)).map(BgsAuthProvider..Lambda.3.lambdaFactory$(this)).flatMap(BgsAuthProvider..Lambda.4.lambdaFactory$(paramConfiguration));
  }
  
  public static class Builder
  {
    String bgsAppLocale;
    String bgsAppName;
    String bgsAppPlatform;
    boolean showDeveloperRegions;
    int webAuthActionBarTextColor;
    int webAuthActionBarTitle;
    String webAuthAppName;
    int webAuthBackgroundImage;
    int webAuthErrorLayout;
    int webAuthLoadingLayout;
    int webAuthPrimaryColor;
    int webAuthPrimaryDarkColor;
    
    public Builder bgsAppLocale(String paramString)
    {
      this.bgsAppLocale = paramString;
      return this;
    }
    
    public Builder bgsAppName(String paramString)
    {
      this.bgsAppName = paramString;
      return this;
    }
    
    public Builder bgsAppPlatform(String paramString)
    {
      this.bgsAppPlatform = paramString;
      return this;
    }
    
    public BgsAuthProvider build()
    {
      return new BgsAuthProvider(this, null);
    }
    
    public Builder showDeveloperRegions(boolean paramBoolean)
    {
      this.showDeveloperRegions = paramBoolean;
      return this;
    }
    
    public Builder webAuthActionBarTextColor(@ColorRes int paramInt)
    {
      this.webAuthActionBarTextColor = paramInt;
      return this;
    }
    
    public Builder webAuthActionBarTitle(@StringRes int paramInt)
    {
      this.webAuthActionBarTitle = paramInt;
      return this;
    }
    
    public Builder webAuthAppName(String paramString)
    {
      this.webAuthAppName = paramString;
      return this;
    }
    
    public Builder webAuthBackgroundImage(@DrawableRes int paramInt)
    {
      this.webAuthBackgroundImage = paramInt;
      return this;
    }
    
    public Builder webAuthErrorLayout(@LayoutRes int paramInt)
    {
      this.webAuthErrorLayout = paramInt;
      return this;
    }
    
    public Builder webAuthLoadingLayout(@LayoutRes int paramInt)
    {
      this.webAuthLoadingLayout = paramInt;
      return this;
    }
    
    public Builder webAuthPrimaryColor(@ColorRes int paramInt)
    {
      this.webAuthPrimaryColor = paramInt;
      return this;
    }
    
    public Builder webAuthPrimaryDarkColor(@ColorRes int paramInt)
    {
      this.webAuthPrimaryDarkColor = paramInt;
      return this;
    }
  }
  
  public static class Configuration
  {
    private Context context;
    private boolean handleError;
    private boolean handleWebAuthChallenge;
    private boolean startInErrorState;
    
    private Configuration(Builder paramBuilder)
    {
      this.context = paramBuilder.context;
      this.startInErrorState = paramBuilder.startInErrorState;
      this.handleWebAuthChallenge = paramBuilder.handleWebAuthChallenge;
      this.handleError = paramBuilder.handleError;
    }
    
    public Context getContext()
    {
      return this.context;
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
      private Context context;
      private boolean handleError;
      private boolean handleWebAuthChallenge;
      private boolean startInErrorState;
      
      public BgsAuthProvider.Configuration build()
      {
        return new BgsAuthProvider.Configuration(this, null);
      }
      
      public Builder context(Context paramContext)
      {
        this.context = paramContext;
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
    }
  }
  
  public static final class Credentials
  {
    private final long bgsAccountId;
    private final String utilityHost;
    private final String xmppServerHost;
    private final int xmppServerPort;
    private final String xmppSessionToken;
    
    private Credentials(long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      this.bgsAccountId = paramLong;
      this.xmppServerHost = paramString1;
      this.xmppServerPort = paramInt;
      this.xmppSessionToken = paramString2;
      this.utilityHost = paramString3;
    }
    
    public static Credentials fromJson(@NonNull String paramString)
    {
      return (Credentials)new Gson().fromJson(paramString, Credentials.class);
    }
    
    public static String toJson(@NonNull Credentials paramCredentials)
    {
      return new Gson().toJson(paramCredentials);
    }
    
    public String getAuthenticationText()
    {
      return this.xmppSessionToken + "\000" + this.utilityHost;
    }
    
    public long getBgsAccountId()
    {
      return this.bgsAccountId;
    }
    
    public String getUtilityHost()
    {
      return this.utilityHost;
    }
    
    public String getXmppServerHost()
    {
      return this.xmppServerHost;
    }
    
    public int getXmppServerPort()
    {
      return this.xmppServerPort;
    }
    
    public String getXmppSessionToken()
    {
      return this.xmppSessionToken;
    }
    
    public boolean isValid()
    {
      if (this.bgsAccountId == 0L) {}
      while ((TextUtils.isEmpty(this.xmppServerHost)) || (this.xmppServerPort == 0) || (TextUtils.isEmpty(this.xmppSessionToken)) || (TextUtils.isEmpty(this.utilityHost))) {
        return false;
      }
      return true;
    }
    
    public String toJson()
    {
      return toJson(this);
    }
    
    public String toString()
    {
      return "Credentials{bgsAccountId=" + this.bgsAccountId + ", xmppServerHost='" + this.xmppServerHost + '\'' + ", xmppServerPort=" + this.xmppServerPort + ", xmppSessionToken='" + this.xmppSessionToken + '\'' + ", utilityHost='" + this.utilityHost + '\'' + '}';
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/BgsAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */