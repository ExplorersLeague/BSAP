package com.blizzard.messenger.data.xmpp.iq;

import android.support.annotation.NonNull;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class ReportFriendIQ
  extends IQ
{
  private static final String ATTR_JID = "jid";
  private static final String CHILD_ELEMENT_NAME = "query";
  private static final String ELEMENT_BLOCK = "block";
  private static final String ELEMENT_ITEM = "item";
  private static final String ELEMENT_REPORT = "report";
  private static final String ELEMENT_TEXT = "text";
  private static final String NAMESPACE = "blz:reporting";
  private static final String REPORT_TYPE_BATTLETAG = "battletag";
  private static final String REPORT_TYPE_HARASSMENT = "harassment";
  private static final String REPORT_TYPE_SPAM = "spam";
  private final boolean blockUser;
  private final String id;
  private final String reportType;
  private final String userText;
  
  public ReportFriendIQ(@NonNull String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super("query", "blz:reporting");
    this.id = paramString1;
    this.reportType = paramString2;
    this.userText = paramString3;
    this.blockUser = paramBoolean;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    paramIQChildElementXmlStringBuilder.halfOpenElement("item");
    paramIQChildElementXmlStringBuilder.attribute("jid", this.id);
    paramIQChildElementXmlStringBuilder.closeEmptyElement();
    if (this.blockUser) {
      paramIQChildElementXmlStringBuilder.emptyElement("block");
    }
    paramIQChildElementXmlStringBuilder.halfOpenElement("report");
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    String str = this.reportType;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramIQChildElementXmlStringBuilder.emptyElement("spam");
      }
      break;
    }
    for (;;)
    {
      paramIQChildElementXmlStringBuilder.element("text", this.userText);
      paramIQChildElementXmlStringBuilder.closeElement("report");
      return paramIQChildElementXmlStringBuilder;
      if (!str.equals("com.blizzard.messenger.reporttype.HARASSMENT")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("com.blizzard.messenger.reporttype.INAPPROPRIATE_NAME")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("com.blizzard.messenger.reporttype.SPAM")) {
        break;
      }
      i = 2;
      break;
      paramIQChildElementXmlStringBuilder.emptyElement("harassment");
      continue;
      paramIQChildElementXmlStringBuilder.emptyElement("battletag");
      continue;
      paramIQChildElementXmlStringBuilder.emptyElement("spam");
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/ReportFriendIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */