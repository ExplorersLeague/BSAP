package com.blizzard.messenger.data.xmpp.provider;

import com.blizzard.messenger.data.xmpp.iq.ChatHistoryIQ;
import com.blizzard.messenger.data.xmpp.model.Conversation;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ChatHistoryPacketProvider
  extends IQProvider<ChatHistoryIQ>
{
  private static final String TAG_QUERY = "query";
  
  public ChatHistoryIQ parse(XmlPullParser paramXmlPullParser, int paramInt)
    throws XmlPullParserException, IOException, SmackException
  {
    ChatHistoryIQ localChatHistoryIQ = new ChatHistoryIQ();
    for (;;)
    {
      switch (paramXmlPullParser.next())
      {
      }
    }
    Object localObject = paramXmlPullParser.getName();
    switch (((String)localObject).hashCode())
    {
    }
    label72:
    for (paramInt = -1;; paramInt = 0) {
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        localObject = Conversation.parse(paramXmlPullParser);
        if (localObject == null) {
          break;
        }
        localChatHistoryIQ.setConversation((Conversation)localObject);
        break;
        if (!((String)localObject).equals("conversation")) {
          break label72;
        }
      }
    }
    localObject = paramXmlPullParser.getName();
    switch (((String)localObject).hashCode())
    {
    }
    label160:
    for (paramInt = -1;; paramInt = 0) {
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        return localChatHistoryIQ;
        if (!((String)localObject).equals("query")) {
          break label160;
        }
      }
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/provider/ChatHistoryPacketProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */