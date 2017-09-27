package com.blizzard.messenger.data.xmpp.sasl;

import com.blizzard.messenger.data.providers.BgsAuthProvider.Credentials;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.sasl.SASLMechanism;

public class BgsSASLMechanism
  extends SASLMechanism
{
  private static final String NAME = "BLIZZARD-SOCIAL";
  private BgsAuthProvider.Credentials credentials;
  
  public BgsSASLMechanism(BgsAuthProvider.Credentials paramCredentials)
  {
    this.credentials = paramCredentials;
  }
  
  public void authenticateInternal(CallbackHandler paramCallbackHandler)
    throws SmackException
  {}
  
  public void checkIfSuccessfulOrThrow()
    throws SmackException
  {}
  
  protected byte[] getAuthenticationText()
    throws SmackException
  {
    return this.credentials.getAuthenticationText().getBytes();
  }
  
  public String getName()
  {
    return "BLIZZARD-SOCIAL";
  }
  
  public int getPriority()
  {
    return 5;
  }
  
  protected SASLMechanism newInstance()
  {
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/sasl/BgsSASLMechanism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */