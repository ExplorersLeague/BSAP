package com.blizzard.messenger.data.xmpp.extension;

import org.jivesoftware.smack.packet.ExtensionElement;

public final class LogoutExtension
  implements ExtensionElement
{
  public static final String ELEMENT = "logout";
  public static final String NAMESPACE = "blz:logout";
  
  public String getElementName()
  {
    return "logout";
  }
  
  public String getNamespace()
  {
    return "blz:logout";
  }
  
  public CharSequence toXML()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("<%s xmlns='%s'/>", new Object[] { "logout", "blz:logout" }));
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/extension/LogoutExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */