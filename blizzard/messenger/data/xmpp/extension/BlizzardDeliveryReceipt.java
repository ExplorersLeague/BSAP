package com.blizzard.messenger.data.xmpp.extension;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class BlizzardDeliveryReceipt
  implements ExtensionElement
{
  private static final String ATTR_BGS_ID = "bgsId";
  private static final String ATTR_ID = "id";
  private static final String ATTR_TIMESTAMP = "ts";
  public static final String ELEMENT = "meta";
  public static final String NAMESPACE = "blz:receipts";
  public static final String TAG = BlizzardDeliveryReceipt.class.getSimpleName();
  private String bgsId;
  private String id;
  private double timestamp;
  
  private BlizzardDeliveryReceipt(Builder paramBuilder)
  {
    this.id = paramBuilder.id;
    this.bgsId = paramBuilder.bgsId;
    this.timestamp = paramBuilder.timestamp;
  }
  
  public static BlizzardDeliveryReceipt from(Message paramMessage)
  {
    return (BlizzardDeliveryReceipt)paramMessage.getExtension("meta", "blz:receipts");
  }
  
  public String getBgsId()
  {
    return this.bgsId;
  }
  
  public String getElementName()
  {
    return "meta";
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getNamespace()
  {
    return "blz:receipts";
  }
  
  public double getTimestamp()
  {
    return this.timestamp;
  }
  
  public XmlStringBuilder toXML()
  {
    XmlStringBuilder localXmlStringBuilder = new XmlStringBuilder(this);
    localXmlStringBuilder.optAttribute("id", this.id);
    localXmlStringBuilder.optAttribute("bgsId", this.bgsId);
    localXmlStringBuilder.attribute("bgsId", String.valueOf(this.timestamp));
    localXmlStringBuilder.closeEmptyElement();
    return localXmlStringBuilder;
  }
  
  public static class Builder
  {
    private String bgsId;
    private String id;
    private double timestamp;
    
    public Builder bgsId(String paramString)
    {
      this.bgsId = paramString;
      return this;
    }
    
    public BlizzardDeliveryReceipt build()
    {
      return new BlizzardDeliveryReceipt(this, null);
    }
    
    public Builder id(String paramString)
    {
      this.id = paramString;
      return this;
    }
    
    public Builder timestamp(double paramDouble)
    {
      this.timestamp = paramDouble;
      return this;
    }
  }
  
  public static class Provider
    extends ExtensionElementProvider<BlizzardDeliveryReceipt>
  {
    public BlizzardDeliveryReceipt parse(XmlPullParser paramXmlPullParser, int paramInt)
      throws XmlPullParserException, IOException, SmackException
    {
      if (paramXmlPullParser.getEventType() != 2)
      {
        Log.e(BlizzardDeliveryReceipt.TAG, "Error parsing Blizzard delivery receipt: not at start tag");
        return null;
      }
      if (!paramXmlPullParser.getName().equals("meta"))
      {
        Log.e(BlizzardDeliveryReceipt.TAG, "Error parsing Blizzard delivery receipt: incorrect element");
        return null;
      }
      BlizzardDeliveryReceipt.Builder localBuilder = new BlizzardDeliveryReceipt.Builder().id(paramXmlPullParser.getAttributeValue("", "id")).bgsId(paramXmlPullParser.getAttributeValue("", "bgsId"));
      paramXmlPullParser = paramXmlPullParser.getAttributeValue("", "ts");
      if (!TextUtils.isEmpty(paramXmlPullParser)) {
        localBuilder.timestamp(Double.valueOf(paramXmlPullParser).doubleValue());
      }
      return localBuilder.build();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/extension/BlizzardDeliveryReceipt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */