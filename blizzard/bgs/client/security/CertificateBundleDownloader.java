package com.blizzard.bgs.client.security;

import com.blizzard.bgs.client.exception.SslCertificateException;
import com.blizzard.bgs.client.log.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.Single;
import rx.SingleEmitter;

public class CertificateBundleDownloader
{
  private static String TAG = CertificateBundleDownloader.class.getSimpleName();
  private final OkHttpClient httpClient;
  private final Request httpRequest;
  private final Logger logger;
  private final String url;
  
  private CertificateBundleDownloader(Builder paramBuilder)
  {
    if (paramBuilder.logger != null)
    {
      localObject = paramBuilder.logger;
      this.logger = ((Logger)localObject);
      if (paramBuilder.url == null) {
        break label103;
      }
    }
    label103:
    for (Object localObject = paramBuilder.url;; localObject = "http://nydus.battle.net/Bnet/zxx/client/bgs-key-fingerprint")
    {
      this.url = ((String)localObject);
      this.httpClient = new OkHttpClient.Builder().connectTimeout(paramBuilder.timeout, TimeUnit.MILLISECONDS).readTimeout(paramBuilder.timeout, TimeUnit.MILLISECONDS).build();
      this.httpRequest = new Request.Builder().url(this.url).build();
      return;
      localObject = Logger.NULL;
      break;
    }
  }
  
  private void handleError(SingleEmitter<InputStream> paramSingleEmitter, Exception paramException)
  {
    this.logger.log("ERROR", TAG, "Request exception", paramException);
    paramSingleEmitter.onError(paramException);
  }
  
  private void handleResponse(SingleEmitter<InputStream> paramSingleEmitter, Response paramResponse)
  {
    if (!paramResponse.isSuccessful())
    {
      this.logger.log("ERROR", TAG, "Request failed, code=" + paramResponse.code());
      paramSingleEmitter.onError(new SslCertificateException("Certificate download failed, code=" + paramResponse.code()));
      return;
    }
    paramSingleEmitter.onSuccess(paramResponse.body().byteStream());
  }
  
  public Single<InputStream> downloadCertificateBundle()
  {
    return Single.fromEmitter(CertificateBundleDownloader..Lambda.1.lambdaFactory$(this));
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public static class Builder
  {
    Logger logger;
    int timeout;
    String url;
    
    public CertificateBundleDownloader build()
    {
      return new CertificateBundleDownloader(this, null);
    }
    
    public Builder logger(Logger paramLogger)
    {
      this.logger = paramLogger;
      return this;
    }
    
    public Builder timeout(int paramInt)
    {
      this.timeout = paramInt;
      return this;
    }
    
    public Builder url(String paramString)
    {
      this.url = paramString;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/security/CertificateBundleDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */