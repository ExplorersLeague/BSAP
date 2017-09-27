package com.blizzard.messenger.data.security;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.X509TrustManager;

public class ConnectionTrustManager
  implements X509TrustManager
{
  private final X509Certificate[] caChain;
  
  public ConnectionTrustManager(X509Certificate[] paramArrayOfX509Certificate)
  {
    this.caChain = paramArrayOfX509Certificate;
  }
  
  @SuppressLint({"TrustAllX509TrustManager"})
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    if ((this.caChain == null) || (this.caChain.length == 0)) {}
    do
    {
      return;
      if (TextUtils.isEmpty(paramString)) {
        throw new CertificateException("Invalid server authentication type");
      }
      int j = paramArrayOfX509Certificate.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfX509Certificate[i].checkValidity();
        i += 1;
      }
    } while (Arrays.equals(this.caChain, paramArrayOfX509Certificate));
    throw new CertificateException("Invalid server certificate chain");
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/security/ConnectionTrustManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */