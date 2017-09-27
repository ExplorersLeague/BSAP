package com.blizzard.messenger.data.xmpp.iq;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class RequestChatHistoryIQ
  extends IQ
{
  public static final String ELEMENT = "query";
  public static final String NAMESPACE = "blz:convo:history";
  public static final String TAG_AFTER = "after";
  public static final String TAG_BEFORE = "before";
  public static final String TAG_FRIENDJID = "friendJid";
  public static final String TAG_LIMIT = "limit";
  private long after;
  private double before;
  private String friendJid;
  private int limit;
  
  private RequestChatHistoryIQ(Builder paramBuilder)
  {
    super("query", "blz:convo:history");
    this.friendJid = paramBuilder.friendJid;
    this.limit = paramBuilder.limit;
    this.before = paramBuilder.before;
    this.after = paramBuilder.after;
  }
  
  public long getAfter()
  {
    return this.after;
  }
  
  public double getBefore()
  {
    return this.before;
  }
  
  public String getFriendId()
  {
    return this.friendJid;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket().element("friendJid", this.friendJid).optElement("before", String.valueOf(this.before)).optElement("after", String.valueOf(this.after)).optIntElement("limit", this.limit);
    return paramIQChildElementXmlStringBuilder;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public static class Builder
  {
    private long after;
    private double before;
    private String friendJid;
    private int limit;
    
    public Builder after(long paramLong)
    {
      this.after = paramLong;
      return this;
    }
    
    public Builder before(double paramDouble)
    {
      this.before = paramDouble;
      return this;
    }
    
    public RequestChatHistoryIQ build()
    {
      return new RequestChatHistoryIQ(this, null);
    }
    
    public Builder friendJid(String paramString)
    {
      this.friendJid = paramString;
      return this;
    }
    
    public Builder limit(int paramInt)
    {
      this.limit = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/RequestChatHistoryIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */