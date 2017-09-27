package com.blizzard.messenger.data.xmpp.iq;

import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriend;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class ViewFriendsIQ
  extends IQ
{
  public static final String ELEMENT = "query";
  private static final String ELEMENT_FRIEND_ACCOUNT_ID = "friendAccountId";
  public static final String NAMESPACE = "blz:fof";
  private String friendAccountId;
  private List<SuggestedFriend> friendsOfFriendsList;
  
  private ViewFriendsIQ(Builder paramBuilder)
  {
    super("query", "blz:fof");
    this.friendAccountId = paramBuilder.friendAccountId;
    this.friendsOfFriendsList = paramBuilder.friendsOfFriendsList;
  }
  
  public ViewFriendsIQ(String paramString)
  {
    super("query", "blz:fof");
    this.friendAccountId = paramString;
  }
  
  public String getFriendAccountId()
  {
    return this.friendAccountId;
  }
  
  public List<SuggestedFriend> getFriendsOfFriends()
  {
    return this.friendsOfFriendsList;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    paramIQChildElementXmlStringBuilder.element("friendAccountId", this.friendAccountId);
    return paramIQChildElementXmlStringBuilder;
  }
  
  public static class Builder
  {
    private final String friendAccountId;
    private List<SuggestedFriend> friendsOfFriendsList;
    
    public Builder(String paramString)
    {
      this.friendAccountId = paramString;
    }
    
    public ViewFriendsIQ build()
    {
      return new ViewFriendsIQ(this, null);
    }
    
    public Builder setFriendsOfFriends(List<SuggestedFriend> paramList)
    {
      this.friendsOfFriendsList = paramList;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/ViewFriendsIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */