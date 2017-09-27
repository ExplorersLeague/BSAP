package com.blizzard.messenger.data.xmpp.iq;

import android.support.annotation.NonNull;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;
import org.jivesoftware.smack.packet.IQ.Type;

public final class ConversationAcknowledgementIQ
  extends IQ
{
  public static final String ELEMENT = "query";
  private static final String ELEMENT_FRIEND_JID = "friendJid";
  public static final String NAMESPACE = "blz:convo:ack";
  public final String id;
  
  public ConversationAcknowledgementIQ(@NonNull String paramString)
  {
    super("query", "blz:convo:ack");
    this.id = paramString;
    setType(IQ.Type.set);
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    paramIQChildElementXmlStringBuilder.element("friendJid", this.id);
    return paramIQChildElementXmlStringBuilder;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/ConversationAcknowledgementIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */