package com.blizzard.messenger.data.xmpp.iq;

import com.blizzard.messenger.data.xmpp.model.Conversation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class ActiveChatMessagesIQ
  extends IQ
{
  public static final String ELEMENT = "query";
  public static final String NAMESPACE = "blz:convo:active";
  private final List<Conversation> conversations = new ArrayList();
  
  public ActiveChatMessagesIQ()
  {
    super("query", "blz:convo:active");
  }
  
  public void addConversation(Conversation paramConversation)
  {
    this.conversations.add(paramConversation);
  }
  
  public List<Conversation> getConversations()
  {
    return this.conversations;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    Iterator localIterator = this.conversations.iterator();
    while (localIterator.hasNext()) {
      paramIQChildElementXmlStringBuilder.append(((Conversation)localIterator.next()).toXML());
    }
    return paramIQChildElementXmlStringBuilder;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/ActiveChatMessagesIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */