package com.blizzard.bgs.client.security;

import java.io.InputStream;
import rx.Single;

public class CertificateBundleFactory
{
  public static Single<CertificateBundle> create(InputStream paramInputStream)
  {
    return CertificateBundleJsonParser.parse(paramInputStream);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/security/CertificateBundleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */