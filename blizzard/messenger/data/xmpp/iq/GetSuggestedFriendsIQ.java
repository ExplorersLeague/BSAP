package com.blizzard.messenger.data.xmpp.iq;

import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriend;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class GetSuggestedFriendsIQ
  extends IQ
{
  public static final String ELEMENT = "query";
  private static final String ELEMENT_LIMIT = "limit";
  public static final String NAMESPACE = "blz:suggested:friends";
  private int limit;
  private List<SuggestedFriend> suggestedFriends;
  
  public GetSuggestedFriendsIQ()
  {
    super("query", "blz:suggested:friends");
  }
  
  public GetSuggestedFriendsIQ(int paramInt)
  {
    super("query", "blz:suggested:friends");
    this.limit = paramInt;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    paramIQChildElementXmlStringBuilder.element("limit", String.valueOf(this.limit));
    return paramIQChildElementXmlStringBuilder;
  }
  
  public List<SuggestedFriend> getSuggestedFriends()
  {
    return this.suggestedFriends;
  }
  
  public void setSuggestedFriends(List<SuggestedFriend> paramList)
  {
    this.suggestedFriends = paramList;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/GetSuggestedFriendsIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */