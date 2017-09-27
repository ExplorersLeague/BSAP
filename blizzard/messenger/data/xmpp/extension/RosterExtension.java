package com.blizzard.messenger.data.xmpp.extension;

import android.util.Log;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class RosterExtension
  implements ExtensionElement
{
  public static final String ELEMENT = "meta";
  public static final String NAMESPACE = "blz:roster:item:meta";
  private static final String TAG = RosterExtension.class.getSimpleName();
  private String fullName;
  private String invitationId;
  private String lastOnline;
  private String note;
  
  private RosterExtension(Builder paramBuilder)
  {
    this.fullName = paramBuilder.fullName;
    this.invitationId = paramBuilder.invitationId;
    this.lastOnline = paramBuilder.lastOnline;
    this.note = paramBuilder.note;
  }
  
  public String getElementName()
  {
    return "meta";
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public String getInvitationId()
  {
    return this.invitationId;
  }
  
  public String getLastOnline()
  {
    return this.lastOnline;
  }
  
  public String getNamespace()
  {
    return "blz:roster:item:meta";
  }
  
  public String getNote()
  {
    return this.note;
  }
  
  public String toString()
  {
    String str = "" + "Full Name : " + this.fullName;
    str = str + " Invitation Id: " + this.invitationId;
    str = str + " Last Online: " + this.lastOnline;
    return str + " Note: " + this.note;
  }
  
  public CharSequence toXML()
  {
    return null;
  }
  
  public static class Builder
  {
    private String fullName;
    private String invitationId;
    private String lastOnline;
    private String note;
    
    public RosterExtension build()
    {
      return new RosterExtension(this, null);
    }
    
    Builder setFullName(String paramString)
    {
      this.fullName = paramString;
      return this;
    }
    
    Builder setInvitationId(String paramString)
    {
      this.invitationId = paramString;
      return this;
    }
    
    Builder setLastOnline(String paramString)
    {
      this.lastOnline = paramString;
      return this;
    }
    
    Builder setNote(String paramString)
    {
      this.note = paramString;
      return this;
    }
  }
  
  public static class Provider
    extends ExtensionElementProvider<RosterExtension>
  {
    private static final String TAG_FULL_NAME = "fullName";
    private static final String TAG_INVITATION_ID = "invitationId";
    private static final String TAG_LAST_ONLINE = "lastOnline";
    private static final String TAG_NOTE = "note";
    
    public RosterExtension parse(XmlPullParser paramXmlPullParser, int paramInt)
      throws XmlPullParserException, IOException, SmackException
    {
      if (paramXmlPullParser.getEventType() != 2)
      {
        Log.e(RosterExtension.TAG, "Error parsing conversation: not at start tag");
        return null;
      }
      if (!paramXmlPullParser.getName().equals("meta"))
      {
        Log.e(RosterExtension.TAG, "Error parsing roster extension: incorrect element");
        return null;
      }
      Object localObject2 = null;
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject1 = null;
      int i = 0;
      String str = "";
      while (i == 0)
      {
        int j = paramXmlPullParser.next();
        if (j == 3)
        {
          Object localObject5;
          Object localObject8;
          Object localObject7;
          Object localObject6;
          if ("fullName".equals(paramXmlPullParser.getName()))
          {
            localObject5 = str;
            localObject8 = localObject1;
            localObject7 = localObject2;
            localObject6 = localObject3;
          }
          for (;;)
          {
            localObject4 = localObject5;
            localObject3 = localObject6;
            localObject2 = localObject7;
            localObject1 = localObject8;
            if (paramXmlPullParser.getDepth() != paramInt) {
              break;
            }
            i = 1;
            localObject4 = localObject5;
            localObject3 = localObject6;
            localObject2 = localObject7;
            localObject1 = localObject8;
            break;
            if ("invitationId".equals(paramXmlPullParser.getName()))
            {
              localObject6 = str;
              localObject5 = localObject4;
              localObject7 = localObject2;
              localObject8 = localObject1;
            }
            else if ("lastOnline".equals(paramXmlPullParser.getName()))
            {
              localObject7 = str;
              localObject5 = localObject4;
              localObject6 = localObject3;
              localObject8 = localObject1;
            }
            else
            {
              localObject5 = localObject4;
              localObject6 = localObject3;
              localObject7 = localObject2;
              localObject8 = localObject1;
              if ("note".equals(paramXmlPullParser.getName()))
              {
                localObject8 = str;
                localObject5 = localObject4;
                localObject6 = localObject3;
                localObject7 = localObject2;
              }
            }
          }
        }
        if (j == 4) {
          str = paramXmlPullParser.getText();
        }
      }
      return new RosterExtension.Builder().setFullName((String)localObject4).setInvitationId((String)localObject3).setLastOnline((String)localObject2).setNote((String)localObject1).build();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/extension/RosterExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */