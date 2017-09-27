package com.blizzard.messenger.data.xmpp.iq;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class SimpleProfileIQ
  extends IQ
{
  public static final String ELEMENT = "query";
  public static final String NAMESPACE = "blz:profile:simple";
  private String battleTag;
  private String fullName;
  
  public SimpleProfileIQ()
  {
    super("query", "blz:profile:simple");
  }
  
  public String getBattleTag()
  {
    return this.battleTag;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    return paramIQChildElementXmlStringBuilder;
  }
  
  public void setBattleTag(String paramString)
  {
    this.battleTag = paramString;
  }
  
  public void setFullName(String paramString)
  {
    this.fullName = paramString;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/SimpleProfileIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */