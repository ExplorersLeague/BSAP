package com.blizzard.messenger.data.xmpp.iq;

import android.support.annotation.NonNull;
import com.blizzard.messenger.data.model.friends.FriendRequest;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class FriendManagementIQ
  extends IQ
{
  private static final String CHILD_ELEMENT_NAME = "query";
  private static final String ELEMENT_ACTION = "action";
  private static final String ELEMENT_INVITATION_ID = "invitationId";
  private static final String ELEMENT_RELATION = "relation";
  private static final String ELEMENT_TARGET = "target";
  private static final String NAMESPACE = "blz:friend:management";
  private final Action action;
  private final String id;
  private final String invitationId;
  private final String relation;
  
  public FriendManagementIQ(FriendRequest paramFriendRequest, Action paramAction)
  {
    super("query", "blz:friend:management");
    this.id = paramFriendRequest.getFullName();
    this.invitationId = paramFriendRequest.getInvitationId();
    if (paramFriendRequest.getAssociation().equals("Email")) {}
    for (this.relation = "realId";; this.relation = "battleTag")
    {
      this.action = paramAction;
      return;
    }
  }
  
  public FriendManagementIQ(String paramString1, @NonNull String paramString2, Action paramAction)
  {
    super("query", "blz:friend:management");
    this.id = paramString1;
    this.invitationId = null;
    this.action = paramAction;
    if (paramString2.equals("Email"))
    {
      this.relation = "realId";
      return;
    }
    this.relation = "battleTag";
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    switch (this.action)
    {
    default: 
      return paramIQChildElementXmlStringBuilder;
    case ???: 
      paramIQChildElementXmlStringBuilder.element("invitationId", this.invitationId);
      paramIQChildElementXmlStringBuilder.element("relation", this.relation);
      paramIQChildElementXmlStringBuilder.element("action", "accept");
      return paramIQChildElementXmlStringBuilder;
    case ???: 
      paramIQChildElementXmlStringBuilder.element("invitationId", this.invitationId);
      paramIQChildElementXmlStringBuilder.element("relation", this.relation);
      paramIQChildElementXmlStringBuilder.element("action", "decline");
      return paramIQChildElementXmlStringBuilder;
    case ???: 
      paramIQChildElementXmlStringBuilder.element("target", this.id);
      paramIQChildElementXmlStringBuilder.element("relation", this.relation);
      paramIQChildElementXmlStringBuilder.element("action", "invite");
      return paramIQChildElementXmlStringBuilder;
    case ???: 
      paramIQChildElementXmlStringBuilder.element("target", this.id);
      paramIQChildElementXmlStringBuilder.element("relation", this.relation);
      paramIQChildElementXmlStringBuilder.element("action", "upgrade");
      return paramIQChildElementXmlStringBuilder;
    }
    paramIQChildElementXmlStringBuilder.element("invitationId", this.invitationId);
    paramIQChildElementXmlStringBuilder.element("relation", this.relation);
    paramIQChildElementXmlStringBuilder.element("action", "ignore");
    return paramIQChildElementXmlStringBuilder;
  }
  
  public static enum Action
  {
    ACCEPT,  DECLINE,  IGNORE,  INVITE,  UPGRADE;
    
    private Action() {}
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/FriendManagementIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */