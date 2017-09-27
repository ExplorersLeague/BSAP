package com.blizzard.messenger.data.xmpp.provider;

import android.text.TextUtils;
import android.util.Log;
import com.blizzard.messenger.data.xmpp.extension.RosterExtension.Provider;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.packet.RosterPacket.Item;
import org.jivesoftware.smack.roster.packet.RosterPacket.ItemStatus;
import org.jivesoftware.smack.roster.packet.RosterPacket.ItemType;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class BlizzardRosterPacketProvider
  extends IQProvider<RosterPacket>
{
  private static final String ATTRIBUTE_ASK = "ask";
  private static final String ATTRIBUTE_JID = "jid";
  private static final String ATTRIBUTE_NAME = "name";
  private static final String ATTRIBUTE_SUBSCRIPTION = "subscription";
  private static final String ATTRIBUTE_VERSION = "ver";
  private static final String TAG = BlizzardRosterPacketProvider.class.getSimpleName();
  private static final String TAG_GROUP = "group";
  private static final String TAG_ITEM = "item";
  private static final String TAG_QUERY = "query";
  
  public RosterPacket parse(XmlPullParser paramXmlPullParser, int paramInt)
    throws XmlPullParserException, IOException, SmackException
  {
    if (paramXmlPullParser.getEventType() != 2)
    {
      Log.e(TAG, "Error parsing conversation: not at start tag");
      return null;
    }
    if (!paramXmlPullParser.getName().equals("query"))
    {
      Log.e(TAG, "Error parsing roster: incorrect element");
      return null;
    }
    RosterPacket localRosterPacket = new RosterPacket();
    Object localObject1 = null;
    localRosterPacket.setVersion(paramXmlPullParser.getAttributeValue("", "ver"));
    RosterExtension.Provider localProvider = new RosterExtension.Provider();
    for (;;)
    {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 2: 
        localObject2 = paramXmlPullParser.getName();
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            localRosterPacket.addExtension((ExtensionElement)localProvider.parse(paramXmlPullParser));
            break;
            if (((String)localObject2).equals("meta"))
            {
              i = 0;
              continue;
              if (((String)localObject2).equals("item"))
              {
                i = 1;
                continue;
                if (((String)localObject2).equals("group")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        localObject2 = paramXmlPullParser.getAttributeValue("", "jid");
        String str = paramXmlPullParser.getAttributeValue("", "name");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new RosterPacket.Item((String)localObject2, str);
          ((RosterPacket.Item)localObject2).setItemStatus(RosterPacket.ItemStatus.fromString(paramXmlPullParser.getAttributeValue("", "ask")));
          localObject1 = paramXmlPullParser.getAttributeValue("", "subscription");
          if (localObject1 != null) {}
          for (;;)
          {
            ((RosterPacket.Item)localObject2).setItemType(RosterPacket.ItemType.valueOf((String)localObject1));
            localObject1 = localObject2;
            break;
            localObject1 = "none";
          }
          localObject2 = paramXmlPullParser.nextText();
          if ((localObject2 != null) && (((String)localObject2).trim().length() > 0) && (localObject1 != null)) {
            ((RosterPacket.Item)localObject1).addGroupName((String)localObject2);
          }
        }
        break;
      }
    }
    Object localObject2 = paramXmlPullParser.getName();
    int i = -1;
    switch (((String)localObject2).hashCode())
    {
    default: 
      label432:
      switch (i)
      {
      }
      break;
    }
    while (paramXmlPullParser.getDepth() == paramInt)
    {
      return localRosterPacket;
      if (!((String)localObject2).equals("item")) {
        break label432;
      }
      i = 0;
      break label432;
      if (localObject1 != null) {
        localRosterPacket.addRosterItem((RosterPacket.Item)localObject1);
      }
      localObject1 = null;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/provider/BlizzardRosterPacketProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */