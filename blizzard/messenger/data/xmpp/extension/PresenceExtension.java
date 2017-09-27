package com.blizzard.messenger.data.xmpp.extension;

import com.blizzard.messenger.data.utils.PresenceUtils;
import com.blizzard.messenger.data.xmpp.model.GameAccount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Presence.Type;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class PresenceExtension
  implements ExtensionElement
{
  public static final String ELEMENT = "blz";
  public static final String NAMESPACE = "blz:presence";
  private static final String PRESENCE_AWAY = "AWAY";
  private static final String PRESENCE_BUSY = "BUSY";
  private static final String PRESENCE_OFFLINE = "OFFLINE";
  private static final String PRESENCE_ONLINE = "ONLINE";
  private double awayTime;
  private String from;
  private List<GameAccount> gameAccounts;
  private double lastOnline;
  private String status;
  private String to;
  private Presence.Type type;
  
  public PresenceExtension(int paramInt)
  {
    this.status = getPresenceStatusString(paramInt);
  }
  
  private PresenceExtension(Builder paramBuilder)
  {
    this.status = paramBuilder.status;
    this.lastOnline = paramBuilder.lastOnline;
    this.awayTime = paramBuilder.awayTime;
    this.gameAccounts = paramBuilder.gameAccounts;
  }
  
  public static String getPresenceStatusString(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return null;
    case 3: 
      return "AWAY";
    case 1: 
      return "ONLINE";
    case 4: 
      return "BUSY";
    }
    return "OFFLINE";
  }
  
  public double getAwayTime()
  {
    return this.awayTime;
  }
  
  public String getElementName()
  {
    return "blz";
  }
  
  public String getFrom()
  {
    return this.from;
  }
  
  public List<GameAccount> getGameAccounts()
  {
    return this.gameAccounts;
  }
  
  public double getLastOnline()
  {
    return this.lastOnline;
  }
  
  public String getNamespace()
  {
    return "blz:presence";
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public String getTo()
  {
    return this.to;
  }
  
  public Presence.Type getType()
  {
    return this.type;
  }
  
  public void setFrom(String paramString)
  {
    this.from = paramString;
  }
  
  public void setTo(String paramString)
  {
    this.to = paramString;
  }
  
  public void setType(Presence.Type paramType)
  {
    this.type = paramType;
  }
  
  public String toString()
  {
    String str = "" + "To: " + this.to;
    str = str + " From: " + this.from;
    str = str + " Status: " + this.status;
    str = str + " Type: " + this.type.toString();
    str = str + " Last Online: " + this.lastOnline;
    str = str + " Away Time: " + this.awayTime;
    Iterator localIterator = this.gameAccounts.iterator();
    while (localIterator.hasNext())
    {
      GameAccount localGameAccount = (GameAccount)localIterator.next();
      str = str + "\n" + localGameAccount.toString();
    }
    return str;
  }
  
  public CharSequence toXML()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("<%s xmlns='%s'>", new Object[] { "blz", "blz:presence" }));
    localStringBuilder.append(String.format("<status>%s</status>", new Object[] { this.status }));
    localStringBuilder.append("</blz>");
    return localStringBuilder.toString();
  }
  
  public static class Builder
  {
    private double awayTime;
    private String from;
    private List<GameAccount> gameAccounts;
    private double lastOnline;
    private String status;
    private String to;
    private String type;
    
    public PresenceExtension build()
    {
      return new PresenceExtension(this, null);
    }
    
    public Builder setAwayTime(double paramDouble)
    {
      this.awayTime = paramDouble;
      return this;
    }
    
    public Builder setGameAccounts(List<GameAccount> paramList)
    {
      this.gameAccounts = paramList;
      return this;
    }
    
    public Builder setLastOnline(double paramDouble)
    {
      this.lastOnline = paramDouble;
      return this;
    }
    
    public Builder setStatus(String paramString)
    {
      this.status = paramString;
      return this;
    }
  }
  
  public static class Provider
    extends ExtensionElementProvider<PresenceExtension>
  {
    private static final String TAG_AWAY_TIME = "awayTime";
    private static final String TAG_BLZ = "blz";
    private static final String TAG_GAME_ACCOUNT = "gameAccount";
    private static final String TAG_GAME_ACCOUNT_NAME = "gameAccountName";
    private static final String TAG_LAST_ONLINE = "lastOnline";
    private static final String TAG_RICH_PRESENCE = "richPresence";
    private static final String TAG_RICH_PRESENCE_TIME = "richPresenceTime";
    private static final String TAG_STATUS = "status";
    
    public PresenceExtension parse(XmlPullParser paramXmlPullParser, int paramInt)
      throws XmlPullParserException, IOException, SmackException
    {
      Object localObject = "";
      double d1 = 0.0D;
      double d2 = 0.0D;
      ArrayList localArrayList = new ArrayList();
      GameAccount localGameAccount = null;
      String str = "";
      paramInt = 0;
      while (paramInt == 0)
      {
        int i = paramXmlPullParser.next();
        if (i == 2)
        {
          if ("gameAccount".equals(paramXmlPullParser.getName())) {
            localGameAccount = new GameAccount();
          }
        }
        else if (i == 3)
        {
          if ("status".equals(paramXmlPullParser.getName()))
          {
            if (localGameAccount != null) {
              localGameAccount.setStatus(PresenceUtils.getPresenceStatus(str));
            } else {
              localObject = str;
            }
          }
          else if ("blz".equals(paramXmlPullParser.getName()))
          {
            paramInt = 1;
          }
          else if ("awayTime".equals(paramXmlPullParser.getName()))
          {
            if (localGameAccount != null) {
              localGameAccount.setAwayTime(Double.valueOf(str).doubleValue());
            } else {
              d2 = Double.valueOf(str).doubleValue();
            }
          }
          else if ("lastOnline".equals(paramXmlPullParser.getName()))
          {
            if (localGameAccount != null) {
              localGameAccount.setLastOnline(Double.valueOf(str).doubleValue());
            } else {
              d1 = Double.valueOf(str).doubleValue();
            }
          }
          else if ("richPresence".equals(paramXmlPullParser.getName()))
          {
            if (localGameAccount != null) {
              localGameAccount.setRichPresence(str.trim());
            }
          }
          else if ("richPresenceTime".equals(paramXmlPullParser.getName()))
          {
            if (localGameAccount != null) {
              localGameAccount.setRichPresenceTime(Double.valueOf(str).doubleValue());
            }
          }
          else if ("gameAccountName".equals(paramXmlPullParser.getName()))
          {
            if (localGameAccount != null) {
              localGameAccount.setName(str);
            }
          }
          else if ("gameAccount".equals(paramXmlPullParser.getName()))
          {
            localArrayList.add(localGameAccount);
            localGameAccount = null;
          }
        }
        else if (i == 4) {
          str = paramXmlPullParser.getText();
        }
      }
      paramXmlPullParser = new PresenceExtension.Builder();
      paramXmlPullParser.setStatus((String)localObject);
      paramXmlPullParser.setLastOnline(d1);
      paramXmlPullParser.setAwayTime(d2);
      paramXmlPullParser.setGameAccounts(localArrayList);
      return paramXmlPullParser.build();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/extension/PresenceExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */