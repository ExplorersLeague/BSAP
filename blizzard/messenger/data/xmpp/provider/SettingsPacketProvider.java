package com.blizzard.messenger.data.xmpp.provider;

import com.blizzard.messenger.data.xmpp.iq.RetrieveSettingsIQ;
import com.blizzard.messenger.data.xmpp.iq.RetrieveSettingsIQ.Builder;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SettingsPacketProvider
  extends IQProvider<RetrieveSettingsIQ>
{
  private static final String ATTRIBUTE_FILTER_MATURE_LANGUGAGE = "hidden";
  private static final String ELEMENT_ACCOUNT_MUTE = "accountMute";
  private static final String ELEMENT_FILTER_MATURE_LANGUAGE = "filterMatureLanguage";
  private static final String ELEMENT_LOCALE = "locale";
  private static final String ELEMENT_NOTIFICATIONS_FRIEND_REQUESTS = "friendRequests";
  private static final String ELEMENT_NOTIFICATIONS_WHISPERS = "whispers";
  private static final String ELEMENT_REAL_ID_DISABLED = "realIdDisabled";
  private static final String ELEMENT_SETTINGS = "settings";
  
  public RetrieveSettingsIQ parse(XmlPullParser paramXmlPullParser, int paramInt)
    throws XmlPullParserException, IOException, SmackException
  {
    boolean bool5 = false;
    boolean bool4 = true;
    boolean bool6 = false;
    boolean bool1 = false;
    Object localObject = "";
    boolean bool2 = true;
    boolean bool3 = true;
    String str = "";
    paramInt = 0;
    while (paramInt == 0)
    {
      int i = paramXmlPullParser.next();
      boolean bool7 = bool6;
      if (i == 2)
      {
        bool7 = bool6;
        if ("filterMatureLanguage".equals(paramXmlPullParser.getName())) {
          bool7 = Boolean.valueOf(paramXmlPullParser.getAttributeValue("", "hidden")).booleanValue();
        }
      }
      if (i == 3)
      {
        if ("accountMute".equals(paramXmlPullParser.getName()))
        {
          bool5 = Boolean.valueOf(str).booleanValue();
          bool6 = bool7;
        }
        else if ("filterMatureLanguage".equals(paramXmlPullParser.getName()))
        {
          bool4 = Boolean.valueOf(str).booleanValue();
          bool6 = bool7;
        }
        else if ("locale".equals(paramXmlPullParser.getName()))
        {
          localObject = str;
          bool6 = bool7;
        }
        else if ("friendRequests".equals(paramXmlPullParser.getName()))
        {
          bool3 = Boolean.valueOf(str).booleanValue();
          bool6 = bool7;
        }
        else if ("whispers".equals(paramXmlPullParser.getName()))
        {
          bool2 = Boolean.valueOf(str).booleanValue();
          bool6 = bool7;
        }
        else if ("realIdDisabled".equals(paramXmlPullParser.getName()))
        {
          bool1 = Boolean.valueOf(str).booleanValue();
          bool6 = bool7;
        }
        else
        {
          bool6 = bool7;
          if ("settings".equals(paramXmlPullParser.getName()))
          {
            paramInt = 1;
            bool6 = bool7;
          }
        }
      }
      else
      {
        bool6 = bool7;
        if (i == 4)
        {
          str = paramXmlPullParser.getText();
          bool6 = bool7;
        }
      }
    }
    paramXmlPullParser = new RetrieveSettingsIQ.Builder();
    paramXmlPullParser.setAccountMute(bool5);
    paramXmlPullParser.setFilterMatureLanguage(bool4);
    paramXmlPullParser.setFilterMatureLanguageHidden(bool6);
    paramXmlPullParser.setRealIdDisabled(bool1);
    paramXmlPullParser.setLocale((String)localObject);
    paramXmlPullParser.setWhisperNotificationsEnabled(bool2);
    paramXmlPullParser.setFriendRequestNotificationsEnabled(bool3);
    return paramXmlPullParser.build();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/provider/SettingsPacketProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */