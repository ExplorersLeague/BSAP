package com.blizzard.messenger.data.xmpp.iq;

import com.blizzard.messenger.data.xmpp.model.Conversation;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class ChatHistoryIQ
  extends IQ
{
  public static final String ELEMENT = "query";
  public static final String NAMESPACE = "blz:convo:history";
  private Conversation conversation;
  
  public ChatHistoryIQ()
  {
    super("query", "blz:convo:history");
  }
  
  public Conversation getConversation()
  {
    return this.conversation;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    if (this.conversation != null) {
      paramIQChildElementXmlStringBuilder.append(this.conversation.toXML());
    }
    return paramIQChildElementXmlStringBuilder;
  }
  
  public void setConversation(Conversation paramConversation)
  {
    this.conversation = paramConversation;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/ChatHistoryIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */