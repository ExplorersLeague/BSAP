package com.blizzard.messenger.data.model.friends.suggestions;

public class MutualFriend
{
  private final String accountId;
  private final String battleTag;
  private final String fullName;
  
  private MutualFriend(Builder paramBuilder)
  {
    this.accountId = paramBuilder.accountId;
    this.battleTag = paramBuilder.battleTag;
    this.fullName = paramBuilder.fullName;
  }
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public String getBattleTag()
  {
    return this.battleTag;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public static class Builder
  {
    private String accountId;
    private String battleTag;
    private String fullName;
    
    public MutualFriend build()
    {
      return new MutualFriend(this, null);
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
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/friends/suggestions/MutualFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */