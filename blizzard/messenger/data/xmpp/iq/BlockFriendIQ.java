package com.blizzard.messenger.data.xmpp.iq;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class BlockFriendIQ
  extends IQ
{
  private static final String ATTR_JID = "jid";
  private static final String CHILD_ELEMENT_NAME = "query";
  private static final String ELEMENT_BLOCK = "block";
  private static final String ELEMENT_ITEM = "item";
  private static final String NAMESPACE = "blz:reporting";
  private final String id;
  
  public BlockFriendIQ(String paramString)
  {
    super("query", "blz:reporting");
    this.id = paramString;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    paramIQChildElementXmlStringBuilder.halfOpenElement("item");
    paramIQChildElementXmlStringBuilder.attribute("jid", this.id);
    paramIQChildElementXmlStringBuilder.closeEmptyElement();
    paramIQChildElementXmlStringBuilder.emptyElement("block");
    return paramIQChildElementXmlStringBuilder;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/BlockFriendIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */