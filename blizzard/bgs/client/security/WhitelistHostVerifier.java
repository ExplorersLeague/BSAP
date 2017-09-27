package com.blizzard.bgs.client.security;

import com.blizzard.bgs.client.log.Logger;
import java.io.IOException;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.cert.CertificateEncodingException;
import javax.security.cert.X509Certificate;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.ByteString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509CertificateStructure;

public class WhitelistHostVerifier
  implements HostnameVerifier
{
  private static final String TAG = WhitelistHostVerifier.class.getSimpleName();
  private final List<CertificatePin> certificatePins;
  private final Logger logger;
  
  public WhitelistHostVerifier(Logger paramLogger, List<CertificatePin> paramList)
  {
    if (paramLogger == null) {
      throw new IllegalArgumentException("logger cannot be null");
    }
    if (paramList == null) {
      throw new IllegalArgumentException("certificatePins cannot be null");
    }
    this.logger = paramLogger;
    this.certificatePins = paramList;
  }
  
  private String[] getNames(X509Certificate paramX509Certificate)
  {
    paramX509Certificate = paramX509Certificate.getSubjectDN();
    String[] arrayOfString;
    int i;
    int m;
    int j;
    if ((paramX509Certificate instanceof X500Name))
    {
      paramX509Certificate = (X500Name)paramX509Certificate;
      paramX509Certificate = paramX509Certificate.getRDNs(BCStyle.CN);
      arrayOfString = new String[paramX509Certificate.length];
      i = 0;
      m = paramX509Certificate.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= m) {
        break label121;
      }
      AttributeTypeAndValue[] arrayOfAttributeTypeAndValue = paramX509Certificate[j].getTypesAndValues();
      int n = arrayOfAttributeTypeAndValue.length;
      int k = 0;
      for (;;)
      {
        if (k < n)
        {
          arrayOfString[i] = IETFUtils.valueToString(arrayOfAttributeTypeAndValue[k].getValue());
          k += 1;
          i += 1;
          continue;
          paramX509Certificate = new X500Name(paramX509Certificate.getName());
          break;
        }
      }
      j += 1;
    }
    label121:
    return arrayOfString;
  }
  
  private boolean hashMatches(X509Certificate paramX509Certificate, String paramString)
  {
    try
    {
      boolean bool = paramString.equals(ByteString.of(X509CertificateStructure.getInstance(ASN1Sequence.fromByteArray(paramX509Certificate.getEncoded())).getSubjectPublicKeyInfo().getPublicKeyData().getBytes()).sha256().hex().toUpperCase());
      if (bool) {
        return true;
      }
    }
    catch (CertificateEncodingException paramString)
    {
      this.logger.log("ERROR", TAG, "Error encoding certificate " + paramX509Certificate, paramString);
      return false;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
  }
  
  private boolean isPinned(String paramString, SSLSession paramSSLSession)
  {
    for (;;)
    {
      int i;
      try
      {
        paramSSLSession = paramSSLSession.getPeerCertificateChain();
        if ((paramSSLSession == null) || (paramSSLSession.length == 0))
        {
          this.logger.log("ERROR", TAG, "Peer " + paramString + "has no certificate chain");
          return false;
        }
        paramSSLSession = paramSSLSession[0];
        Iterator localIterator = this.certificatePins.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        CertificatePin localCertificatePin = (CertificatePin)localIterator.next();
        String[] arrayOfString = getNames(paramSSLSession);
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        if ((nameMatches(arrayOfString[i], localCertificatePin.getPattern())) && (hashMatches(paramSSLSession, localCertificatePin.getHash())))
        {
          this.logger.log("DEBUG", TAG, "Found certificate match for host " + paramString);
          return true;
        }
      }
      catch (SSLPeerUnverifiedException paramSSLSession)
      {
        this.logger.log("ERROR", TAG, "Cannot get certificate chain from peer " + paramString, paramSSLSession);
        return false;
      }
      i += 1;
    }
    this.logger.log("INFO", TAG, "No match found for host " + paramString);
    return false;
  }
  
  private boolean nameMatches(String paramString1, String paramString2)
  {
    return paramString1.equals(paramString2);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    if (!OkHostnameVerifier.INSTANCE.verify(paramString, paramSSLSession)) {
      return false;
    }
    return isPinned(paramString, paramSSLSession);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/security/WhitelistHostVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */