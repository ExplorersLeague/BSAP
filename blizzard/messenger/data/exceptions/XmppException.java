package com.blizzard.messenger.data.exceptions;

import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.packet.XMPPError.Condition;

public class XmppException
  extends RuntimeException
{
  private final XMPPError error;
  
  public XmppException(String paramString, XMPPError paramXMPPError)
  {
    super(paramString);
    this.error = paramXMPPError;
  }
  
  public XmppException(String paramString, XMPPError paramXMPPError, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.error = paramXMPPError;
  }
  
  public XmppException(XMPPError paramXMPPError)
  {
    this.error = paramXMPPError;
  }
  
  public String getCondition()
  {
    return this.error.getCondition().toString();
  }
  
  public XMPPError getError()
  {
    return this.error;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/exceptions/XmppException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */