package com.blizzard.messenger.data.xmpp.extension;

import android.util.Log;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jivesoftware.smackx.forward.provider.ForwardedProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class CarbonExtension
  implements ExtensionElement
{
  public static final String ELEMENT = "sent";
  public static final String NAMESPACE = "urn:xmpp:carbons:2";
  public static final String TAG = CarbonExtension.class.getSimpleName();
  private static final ForwardedProvider forwardedProvider = new ForwardedProvider();
  private final Forwarded forwarded;
  
  private CarbonExtension(Forwarded paramForwarded)
  {
    this.forwarded = paramForwarded;
  }
  
  public String getElementName()
  {
    return "sent";
  }
  
  public Forwarded getForwarded()
  {
    return this.forwarded;
  }
  
  public String getNamespace()
  {
    return "urn:xmpp:carbons:2";
  }
  
  public XmlStringBuilder toXML()
  {
    XmlStringBuilder localXmlStringBuilder = new XmlStringBuilder(this);
    localXmlStringBuilder.rightAngleBracket();
    localXmlStringBuilder.optElement(this.forwarded);
    localXmlStringBuilder.closeElement(this);
    return localXmlStringBuilder;
  }
  
  public static class Provider
    extends ExtensionElementProvider<CarbonExtension>
  {
    public CarbonExtension parse(XmlPullParser paramXmlPullParser, int paramInt)
      throws XmlPullParserException, IOException, SmackException
    {
      if (paramXmlPullParser.getEventType() != 2)
      {
        Log.e(CarbonExtension.TAG, "Error parsing conversation: not at start tag");
        return null;
      }
      if (!paramXmlPullParser.getName().equals("sent"))
      {
        Log.e(CarbonExtension.TAG, "Error parsing carbon: incorrect element");
        return null;
      }
      Forwarded localForwarded = null;
      do
      {
        for (;;)
        {
          switch (paramXmlPullParser.next())
          {
          }
        }
        String str = paramXmlPullParser.getName();
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            localForwarded = (Forwarded)CarbonExtension.forwardedProvider.parse(paramXmlPullParser);
            break;
            if (str.equals("forwarded")) {
              i = 0;
            }
            break;
          }
        }
      } while (paramXmlPullParser.getDepth() != paramInt);
      return new CarbonExtension(localForwarded, null);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/extension/CarbonExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */