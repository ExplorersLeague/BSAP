package com.blizzard.messenger.data.utils;

import com.blizzard.messenger.data.providers.BgsAuthProvider.Credentials;
import com.blizzard.messenger.data.security.ConnectionTrustManager;
import com.blizzard.messenger.data.xmpp.sasl.BgsSASLMechanism;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.compression.Java7ZlibInputOutputStream;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration.Builder;

public class ConnectionUtils
{
  static
  {
    SmackConfiguration.DEBUG = true;
    SmackConfiguration.addCompressionHandler(new Java7ZlibInputOutputStream());
    SmackConfiguration.setDefaultPacketReplyTimeout(30000);
  }
  
  public static XMPPTCPConnection buildConnection(X509Certificate[] paramArrayOfX509Certificate, BgsAuthProvider.Credentials paramCredentials)
  {
    paramArrayOfX509Certificate = new XMPPTCPConnection(((XMPPTCPConnectionConfiguration.Builder)((XMPPTCPConnectionConfiguration.Builder)((XMPPTCPConnectionConfiguration.Builder)((XMPPTCPConnectionConfiguration.Builder)((XMPPTCPConnectionConfiguration.Builder)((XMPPTCPConnectionConfiguration.Builder)((XMPPTCPConnectionConfiguration.Builder)((XMPPTCPConnectionConfiguration.Builder)XMPPTCPConnectionConfiguration.builder().setCompressionEnabled(true).setSecurityMode(ConnectionConfiguration.SecurityMode.required)).setUsernameAndPassword("1", "1")).setServiceName(paramCredentials.getXmppServerHost())).setHost(paramCredentials.getXmppServerHost())).setPort(paramCredentials.getXmppServerPort())).setResource("")).setSendPresence(false)).setCustomSSLContext(newSslContext(paramArrayOfX509Certificate))).build());
    SASLAuthentication.unregisterSASLMechanism(BgsSASLMechanism.class.getName());
    SASLAuthentication.registerSASLMechanism(new BgsSASLMechanism(paramCredentials).instanceForAuthentication(paramArrayOfX509Certificate));
    return paramArrayOfX509Certificate;
  }
  
  private static SSLContext newSslContext(X509Certificate[] paramArrayOfX509Certificate)
  {
    try
    {
      paramArrayOfX509Certificate = new ConnectionTrustManager(paramArrayOfX509Certificate);
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { paramArrayOfX509Certificate }, localSecureRandom);
      return localSSLContext;
    }
    catch (NoSuchAlgorithmException paramArrayOfX509Certificate)
    {
      throw new IllegalStateException("Cannot create XMPP SSL context", paramArrayOfX509Certificate);
    }
    catch (KeyManagementException paramArrayOfX509Certificate)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/ConnectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */