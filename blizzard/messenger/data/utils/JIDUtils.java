package com.blizzard.messenger.data.utils;

import org.jivesoftware.smack.XMPPConnection;
import org.jxmpp.util.XmppStringUtils;

public class JIDUtils
{
  public static String buildJID(XMPPConnection paramXMPPConnection, String paramString)
  {
    return XmppStringUtils.completeJidFrom(paramString, paramXMPPConnection.getServiceName(), "Android");
  }
  
  public static String getLocal(String paramString)
  {
    return XmppStringUtils.parseLocalpart(paramString);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/JIDUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */