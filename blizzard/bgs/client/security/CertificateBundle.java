package com.blizzard.bgs.client.security;

import java.security.cert.X509Certificate;
import java.util.List;

public abstract interface CertificateBundle
{
  public abstract List<CertificatePin> getCertificateWhitelist();
  
  public abstract long getCreationTimestamp();
  
  public abstract List<X509Certificate> getRootCertificates();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/security/CertificateBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */