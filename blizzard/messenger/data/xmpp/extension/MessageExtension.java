package com.blizzard.messenger.data.xmpp.extension;

import android.text.TextUtils;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MessageExtension
  implements ExtensionElement
{
  public static final String ELEMENT = "meta";
  public static final String NAMESPACE = "blz:message:meta";
  private static final String TAG_ID = "id";
  private static final String TAG_TIMESTAMP = "ts";
  private String messageId;
  private double timestamp;
  
  private MessageExtension(Builder paramBuilder)
  {
    this.timestamp = paramBuilder.timestamp.doubleValue();
    this.messageId = paramBuilder.messageId;
  }
  
  public String getElementName()
  {
    return "meta";
  }
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public String getNamespace()
  {
    return "blz:message:meta";
  }
  
  public double getTimestamp()
  {
    return this.timestamp;
  }
  
  public XmlStringBuilder toXML()
  {
    XmlStringBuilder localXmlStringBuilder = new XmlStringBuilder(this);
    localXmlStringBuilder.rightAngleBracket();
    localXmlStringBuilder.element("ts", String.valueOf(this.timestamp));
    if (!TextUtils.isEmpty(this.messageId)) {
      localXmlStringBuilder.element("id", this.messageId);
    }
    localXmlStringBuilder.closeElement(this);
    return localXmlStringBuilder;
  }
  
  public static class Builder
  {
    private String messageId;
    private Double timestamp;
    
    public MessageExtension build()
    {
      return new MessageExtension(this, null);
    }
    
    public Builder messageId(String paramString)
    {
      this.messageId = paramString;
      return this;
    }
    
    public Builder timestamp(double paramDouble)
    {
      this.timestamp = Double.valueOf(paramDouble);
      return this;
    }
  }
  
  public static class Provider
    extends ExtensionElementProvider<MessageExtension>
  {
    public MessageExtension parse(XmlPullParser paramXmlPullParser, int paramInt)
      throws XmlPullParserException, IOException, SmackException
    {
      double d = 0.0D;
      Object localObject = null;
      String str1 = "";
      int i = 0;
      while (i == 0) {
        switch (paramXmlPullParser.next())
        {
        default: 
          break;
        case 3: 
          String str2 = paramXmlPullParser.getName();
          paramInt = -1;
          switch (str2.hashCode())
          {
          }
          for (;;)
          {
            switch (paramInt)
            {
            default: 
              break;
            case 0: 
              i = 1;
              break;
              if (str2.equals("meta"))
              {
                paramInt = 0;
                continue;
                if (str2.equals("ts"))
                {
                  paramInt = 1;
                  continue;
                  if (str2.equals("id")) {
                    paramInt = 2;
                  }
                }
              }
              break;
            }
          }
          d = Double.valueOf(str1).doubleValue();
          continue;
          localObject = str1;
          break;
        case 4: 
          str1 = paramXmlPullParser.getText();
        }
      }
      return new MessageExtension.Builder().timestamp(d).messageId((String)localObject).build();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/extension/MessageExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */