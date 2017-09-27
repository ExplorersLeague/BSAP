package com.blizzard.bgs.client.security;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.core.RequiredTypeAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import rx.Single;

class CertificateBundleJsonParser
{
  private static final String BUNDLE_MODULE_NAME = "Blizzard Certificate Bundle";
  private static final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().registerTypeAdapterFactory(new RequiredTypeAdapterFactory()).create();
  
  static Single<CertificateBundle> parse(InputStream paramInputStream)
  {
    return Single.create(CertificateBundleJsonParser..Lambda.1.lambdaFactory$(paramInputStream));
  }
  
  private static class BundleDef
  {
    @Required
    @Expose
    @SerializedName("Created")
    private Long createdTimestamp;
    @Required
    @Expose
    @SerializedName("SigningCertificates")
    private List<CertificateBundleJsonParser.RawCertificate> rootCertificates = new ArrayList();
    @Required
    @Expose
    @SerializedName("PublicKeys")
    private List<CertificateBundleJsonParser.UriKeyPair> whitelist;
  }
  
  private static class RawCertificate
  {
    @Required
    @Expose
    @SerializedName("RawData")
    private String rawData;
  }
  
  private static class UriKeyPair
  {
    @Required
    @Expose
    @SerializedName("ShaHashPublicKeyInfo")
    private String publicKeyHash;
    @Required
    @Expose
    @SerializedName("Uri")
    private String uri;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/security/CertificateBundleJsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */