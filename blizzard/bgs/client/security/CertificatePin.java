package com.blizzard.bgs.client.security;

public abstract interface CertificatePin
{
  public abstract String getHash();
  
  public abstract String getPattern();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/security/CertificatePin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */