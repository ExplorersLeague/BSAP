package com.blizzard.messenger.data.utils;

import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;

public class CertificateUtils
{
  public static X509Certificate[] getCertificateChain(InputStream paramInputStream)
    throws CertificateException
  {
    Object localObject = CertificateFactory.getInstance("X.509").generateCertificates(paramInputStream);
    paramInputStream = new X509Certificate[((Collection)localObject).size()];
    int i = 0;
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Certificate localCertificate = (Certificate)((Iterator)localObject).next();
      if (!(localCertificate instanceof X509Certificate)) {
        throw new IllegalArgumentException("Certificate is not a valid X.509 certificate");
      }
      paramInputStream[i] = ((X509Certificate)localCertificate);
      i += 1;
    }
    return paramInputStream;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/CertificateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */