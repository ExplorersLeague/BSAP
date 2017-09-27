package com.blizzard.messenger.data.xmpp.provider;

import com.blizzard.messenger.data.xmpp.iq.SimpleProfileIQ;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ProfilePacketProvider
  extends IQProvider<SimpleProfileIQ>
{
  private static final String ATTR_BATTLETAG = "battleTag";
  private static final String ATTR_FULL_NAME = "fullName";
  private static final String ATTR_QUERY = "query";
  
  public SimpleProfileIQ parse(XmlPullParser paramXmlPullParser, int paramInt)
    throws XmlPullParserException, IOException, SmackException
  {
    SimpleProfileIQ localSimpleProfileIQ = new SimpleProfileIQ();
    Object localObject2 = "";
    Object localObject1 = "";
    String str = "";
    paramInt = 0;
    while (paramInt == 0)
    {
      int i = paramXmlPullParser.next();
      if (i == 3)
      {
        if ("battleTag".equals(paramXmlPullParser.getName())) {
          localObject2 = str;
        } else if ("fullName".equals(paramXmlPullParser.getName())) {
          localObject1 = str;
        } else if ("query".equals(paramXmlPullParser.getName())) {
          paramInt = 1;
        }
      }
      else if (i == 4) {
        str = paramXmlPullParser.getText();
      }
    }
    localSimpleProfileIQ.setBattleTag((String)localObject2);
    localSimpleProfileIQ.setFullName((String)localObject1);
    return localSimpleProfileIQ;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/provider/ProfilePacketProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */