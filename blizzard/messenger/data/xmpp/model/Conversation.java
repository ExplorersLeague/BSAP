package com.blizzard.messenger.data.xmpp.model;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class Conversation
{
  private static final String ATTR_FRIEND_JID = "friendJid";
  private static final String ATTR_LAST_CHECKED_AT = "lastCheckedAt";
  private static final String ATTR_LAST_MESSAGE_RECD_AT = "lastMessageReceivedAt";
  public static final String ELEMENT = "conversation";
  public static final String TAG = Conversation.class.getSimpleName();
  private String friendJid;
  private double lastCheckedAt;
  private double lastMessageReceivedAt;
  private final List<Message> messages = new ArrayList();
  
  public static Conversation parse(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException, SmackException
  {
    if (paramXmlPullParser.getEventType() != 2)
    {
      Log.e(TAG, "Error parsing conversation: not at start tag");
      return null;
    }
    if (!paramXmlPullParser.getName().equals("conversation"))
    {
      Log.e(TAG, "Error parsing conversation: incorrect element");
      return null;
    }
    int j = paramXmlPullParser.getDepth();
    Conversation localConversation = new Conversation();
    localConversation.setFriendJid(paramXmlPullParser.getAttributeValue("", "friendJid"));
    Object localObject = paramXmlPullParser.getAttributeValue("", "lastMessageReceivedAt");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localConversation.setLastMessageReceivedAt(Double.valueOf((String)localObject).doubleValue());
    }
    localObject = paramXmlPullParser.getAttributeValue("", "lastCheckedAt");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localConversation.setLastCheckedAt(Double.valueOf((String)localObject).doubleValue());
    }
    do
    {
      for (;;)
      {
        switch (paramXmlPullParser.next())
        {
        }
      }
      localObject = paramXmlPullParser.getName();
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          localObject = PacketParserUtils.parseMessage(paramXmlPullParser);
          if (localObject == null) {
            break;
          }
          localConversation.addMessage((Message)localObject);
          break;
          if (((String)localObject).equals("message")) {
            i = 0;
          }
          break;
        }
      }
    } while (paramXmlPullParser.getDepth() != j);
    return localConversation;
  }
  
  public void addMessage(Message paramMessage)
  {
    this.messages.add(paramMessage);
  }
  
  public String getFriendJid()
  {
    return this.friendJid;
  }
  
  public double getLastCheckedAt()
  {
    return this.lastCheckedAt;
  }
  
  public double getLastMessageReceivedAt()
  {
    return this.lastMessageReceivedAt;
  }
  
  public List<Message> getMessages()
  {
    return this.messages;
  }
  
  public void setFriendJid(String paramString)
  {
    this.friendJid = paramString;
  }
  
  public void setLastCheckedAt(double paramDouble)
  {
    this.lastCheckedAt = paramDouble;
  }
  
  public void setLastMessageReceivedAt(double paramDouble)
  {
    this.lastMessageReceivedAt = paramDouble;
  }
  
  public String toString()
  {
    return "Conversation{friendJid='" + this.friendJid + '\'' + ", lastMessageReceivedAt=" + this.lastMessageReceivedAt + ", lastCheckedAt=" + this.lastCheckedAt + ", messageCount=" + this.messages.size() + '}';
  }
  
  public XmlStringBuilder toXML()
  {
    XmlStringBuilder localXmlStringBuilder = new XmlStringBuilder().halfOpenElement("conversation").attribute("friendJid", this.friendJid).optAttribute("lastMessageReceivedAt", String.valueOf(this.lastMessageReceivedAt)).optAttribute("lastCheckedAt", String.valueOf(this.lastCheckedAt)).rightAngleBracket();
    Iterator localIterator = this.messages.iterator();
    while (localIterator.hasNext()) {
      localXmlStringBuilder.append(((Message)localIterator.next()).toXML());
    }
    localXmlStringBuilder.closeElement("conversation");
    return localXmlStringBuilder;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/model/Conversation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */