package com.blizzard.messenger.data.model.friends;

public class FriendAccount
{
  private final String battleTag;
  private final boolean favorite;
  private final String fullName;
  private final String id;
  private final String note;
  
  private FriendAccount(Builder paramBuilder)
  {
    this.id = paramBuilder.id;
    this.battleTag = paramBuilder.battleTag;
    this.fullName = paramBuilder.fullName;
    this.favorite = paramBuilder.favorite;
    this.note = paramBuilder.note;
  }
  
  public String getBattleTag()
  {
    return this.battleTag;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getNote()
  {
    return this.note;
  }
  
  public boolean isFavorite()
  {
    return this.favorite;
  }
  
  public String toString()
  {
    String str = "" + "ID: " + this.id;
    str = str + " battleTag: " + this.battleTag;
    str = str + " fullName: " + this.fullName;
    str = str + " favorite: " + this.favorite;
    return str + " note: " + this.note;
  }
  
  public static class Builder
  {
    private final String battleTag;
    private boolean favorite;
    private String fullName;
    private final String id;
    private String note;
    
    public Builder(String paramString1, String paramString2)
    {
      this.id = paramString1;
      this.battleTag = paramString2;
    }
    
    public FriendAccount build()
    {
      return new FriendAccount(this, null);
    }
    
    public Builder setFavorite(boolean paramBoolean)
    {
      this.favorite = paramBoolean;
      return this;
    }
    
    public Builder setFullName(String paramString)
    {
      this.fullName = paramString;
      return this;
    }
    
    public Builder setNote(String paramString)
    {
      this.note = paramString;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/friends/FriendAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */