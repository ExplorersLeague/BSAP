package com.blizzard.messenger.data.model.profile;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.blizzard.messenger.data.model.presence.BlizzardPresence;

public class Profile
{
  private static final String DEFAULT_GAME = "None";
  private static final int DEFAULT_STATUS = 5;
  private final String battleTag;
  private final String fullName;
  private final String game;
  private final int status;
  
  private Profile(@NonNull Builder paramBuilder)
  {
    this.battleTag = paramBuilder.battleTag;
    this.fullName = paramBuilder.fullName;
    if (paramBuilder.status != null) {}
    for (this.status = paramBuilder.status.intValue(); paramBuilder.game != null; this.status = 5)
    {
      this.game = paramBuilder.game;
      return;
    }
    this.game = "None";
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Profile)) {}
    do
    {
      return false;
      paramObject = (Profile)paramObject;
    } while ((!this.battleTag.equals(((Profile)paramObject).battleTag)) || (!this.fullName.equals(((Profile)paramObject).fullName)) || (this.status != ((Profile)paramObject).status) || (!this.game.equals(((Profile)paramObject).game)));
    return true;
  }
  
  public String getBattleTag()
  {
    return this.battleTag;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public String getGame()
  {
    return this.game;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public final int hashCode()
  {
    return (((this.battleTag.hashCode() + 629) * 37 + this.fullName.hashCode()) * 37 + this.status) * 37 + this.game.hashCode();
  }
  
  public String toString()
  {
    String str = "" + "fullName: " + this.fullName;
    str = str + " battleTag: " + this.battleTag;
    str = str + " status: " + this.status;
    return str + " game: " + this.game;
  }
  
  public static final class Builder
  {
    private final String battleTag;
    private final String fullName;
    private String game = "None";
    private Integer status;
    
    public Builder(@NonNull ProfileAccount paramProfileAccount)
    {
      this.battleTag = paramProfileAccount.getBattleTag();
      this.fullName = paramProfileAccount.getFullName();
    }
    
    public Profile build()
    {
      return new Profile(this, null);
    }
    
    public Builder setPresence(@Nullable BlizzardPresence paramBlizzardPresence)
    {
      if (paramBlizzardPresence != null)
      {
        this.status = Integer.valueOf(paramBlizzardPresence.getStatus());
        this.game = paramBlizzardPresence.getGame();
        return this;
      }
      this.status = null;
      this.game = null;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/profile/Profile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */