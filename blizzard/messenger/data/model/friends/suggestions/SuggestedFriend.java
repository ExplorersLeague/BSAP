package com.blizzard.messenger.data.model.friends.suggestions;

import java.util.List;

public class SuggestedFriend
{
  private final String accountId;
  private final String battleTag;
  private final String fullName;
  private final List<MutualFriend> mutualFriends;
  private final String relation;
  
  private SuggestedFriend(Builder paramBuilder)
  {
    this.accountId = paramBuilder.accountId;
    this.fullName = paramBuilder.fullName;
    this.battleTag = paramBuilder.battleTag;
    this.relation = paramBuilder.relation;
    this.mutualFriends = paramBuilder.mutualFriends;
  }
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public String getBattleTag()
  {
    return this.battleTag.trim();
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public List<MutualFriend> getMutualFriends()
  {
    return this.mutualFriends;
  }
  
  public String getRelation()
  {
    return this.relation;
  }
  
  public String toString()
  {
    String str = "" + "Account ID: " + this.accountId;
    str = str + " Full Name: " + this.fullName;
    str = str + " BattleTag: " + this.battleTag;
    return str + " Relation: " + this.relation;
  }
  
  public static class Builder
  {
    private String accountId;
    private String battleTag;
    private String fullName;
    private List<MutualFriend> mutualFriends;
    private String relation;
    
    public SuggestedFriend build()
    {
      return new SuggestedFriend(this, null);
    }
    
    public Builder setAccountId(String paramString)
    {
      this.accountId = paramString;
      return this;
    }
    
    public Builder setBattleTag(String paramString)
    {
      this.battleTag = paramString;
      return this;
    }
    
    public Builder setFullName(String paramString)
    {
      this.fullName = paramString;
      return this;
    }
    
    public Builder setMutualFriends(List<MutualFriend> paramList)
    {
      this.mutualFriends = paramList;
      return this;
    }
    
    public Builder setRelation(String paramString)
    {
      this.relation = paramString;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/friends/suggestions/SuggestedFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */