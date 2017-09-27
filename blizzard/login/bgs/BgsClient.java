package com.blizzard.login.bgs;

import android.content.Context;
import com.blizzard.bgs.client.exception.WebAuthUrlChallenge;
import com.blizzard.bgs.client.security.CertificateBundle;
import com.blizzard.bgs.client.service.authentication.AuthenticationConfig;
import com.blizzard.bgs.client.service.authentication.User;
import com.blizzard.bgs.client.service.authentication.message.v1.LogonResult;
import com.blizzard.bgs.client.service.base.Attribute;
import com.blizzard.bgs.client.service.base.EntityId;
import com.blizzard.bgs.client.service.base.Variant;
import com.blizzard.bgs.client.service.gameutilities.message.v1.ClientRequest;
import com.blizzard.bgs.client.websocket.WebSocketProvider;
import com.blizzard.bgs.client.websocket.WebSocketProvider.Builder;
import com.blizzard.login.region.RegionInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Single;
import rx.exceptions.Exceptions;

public class BgsClient
{
  private final AuthenticationConfig authConfig;
  private final Context context;
  private final int timeout;
  
  private BgsClient(Builder paramBuilder)
  {
    if (paramBuilder.context == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    if (paramBuilder.authConfig == null) {
      throw new IllegalArgumentException("authConfig cannot be null");
    }
    this.context = paramBuilder.context;
    this.authConfig = paramBuilder.authConfig;
    if (paramBuilder.timeout != 0)
    {
      this.timeout = paramBuilder.timeout;
      return;
    }
    this.timeout = 10000;
  }
  
  private Observable<?> checkForCertificateLoad(Observable<? extends Throwable> paramObservable)
  {
    return paramObservable.flatMap(BgsClient..Lambda.12.lambdaFactory$(this));
  }
  
  private Single<User> getUser(RegionInfo paramRegionInfo, String paramString, CertificateBundle paramCertificateBundle)
  {
    return new WebSocketProvider.Builder().logger(BgsLogger.INSTANCE).url(paramRegionInfo.getServerUrl()).connectTimeout(this.timeout).readTimeout(this.timeout).writeTimeout(this.timeout).subProtocol(paramRegionInfo.getSubProtocol()).certificateBundle(paramCertificateBundle).build().getSession().map(BgsClient..Lambda.9.lambdaFactory$()).flatMap(BgsClient..Lambda.10.lambdaFactory$()).flatMap(BgsClient..Lambda.11.lambdaFactory$(this, paramString)).first().toSingle();
  }
  
  private BgsClientInfo newClientInfo(final User paramUser, List<Attribute> paramList)
  {
    final HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Attribute localAttribute = (Attribute)paramList.next();
      localHashMap.put(localAttribute.getName(), localAttribute.getValue().toString());
    }
    new BgsClientInfo()
    {
      public Map<String, String> getClientResponse()
      {
        return localHashMap;
      }
      
      public LogonResult getUserProperties()
      {
        return paramUser.getProperties();
      }
    };
  }
  
  private ClientRequest newClientRequest(User paramUser)
  {
    paramUser = paramUser.getProperties();
    return new ClientRequest(new Attribute[] { new Attribute("session_key", Variant.fromBlob(paramUser.getSessionKey())), new Attribute("platform", Variant.fromString(this.authConfig.getPlatform())), new Attribute("locale", Variant.fromString(this.authConfig.getLocale())), new Attribute("game_account", Variant.fromEntityId((EntityId)paramUser.getGameAccountIds().get(0))) });
  }
  
  private String toUrl(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof WebAuthUrlChallenge)) {
      return ((WebAuthUrlChallenge)paramThrowable).getUrl();
    }
    throw Exceptions.propagate(paramThrowable);
  }
  
  public Single<BgsClientInfo> getBgsClientInfo(RegionInfo paramRegionInfo, String paramString)
  {
    return BundleFileManager.loadBundle(this.context).flatMap(BgsClient..Lambda.1.lambdaFactory$(this, paramRegionInfo, paramString)).flatMap(BgsClient..Lambda.2.lambdaFactory$(this)).timeout(this.timeout, TimeUnit.MILLISECONDS).retryWhen(BgsClient..Lambda.3.lambdaFactory$(this));
  }
  
  public Single<String> getBgsWebAuthUrl(RegionInfo paramRegionInfo)
  {
    return BundleFileManager.loadBundle(this.context).flatMap(BgsClient..Lambda.4.lambdaFactory$(this, paramRegionInfo)).map(BgsClient..Lambda.5.lambdaFactory$()).onErrorReturn(BgsClient..Lambda.6.lambdaFactory$()).map(BgsClient..Lambda.7.lambdaFactory$(this)).timeout(this.timeout, TimeUnit.MILLISECONDS).retryWhen(BgsClient..Lambda.8.lambdaFactory$(this));
  }
  
  public static class Builder
  {
    private AuthenticationConfig authConfig;
    private Context context;
    private int timeout;
    
    public Builder authConfig(AuthenticationConfig paramAuthenticationConfig)
    {
      this.authConfig = paramAuthenticationConfig;
      return this;
    }
    
    public BgsClient build()
    {
      return new BgsClient(this, null);
    }
    
    public Builder context(Context paramContext)
    {
      this.context = paramContext;
      return this;
    }
    
    public Builder timeout(int paramInt)
    {
      this.timeout = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/bgs/BgsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */