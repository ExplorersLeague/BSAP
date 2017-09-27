package com.blizzard.messenger.data.model.presence;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class BlizzardPresence
{
  private static final long DEFAULT_AWAY_TIME = 0L;
  private static final String DEFAULT_GAME = "None";
  private static final long DEFAULT_LAST_ONLINE = 0L;
  private static final String DEFAULT_RICH_PRESENCE = "";
  private static final int DEFAULT_STATUS = 5;
  private final double awayTime;
  private final String friendId;
  private final String game;
  private final double lastOnline;
  private final String richPresence;
  private final int status;
  
  private BlizzardPresence(@NonNull Builder paramBuilder)
  {
    this.friendId = paramBuilder.friendId;
    if (paramBuilder.status != null)
    {
      this.status = paramBuilder.status.intValue();
      if (paramBuilder.game == null) {
        break label105;
      }
      this.game = paramBuilder.game;
      label45:
      if (paramBuilder.awayTime == null) {
        break label114;
      }
      this.awayTime = paramBuilder.awayTime.doubleValue();
      label63:
      if (paramBuilder.lastOnline == null) {
        break label122;
      }
    }
    label105:
    label114:
    label122:
    for (this.lastOnline = paramBuilder.lastOnline.doubleValue();; this.lastOnline = 0.0D)
    {
      if (paramBuilder.richPresence == null) {
        break label130;
      }
      this.richPresence = paramBuilder.richPresence;
      return;
      this.status = 5;
      break;
      this.game = "None";
      break label45;
      this.awayTime = 0.0D;
      break label63;
    }
    label130:
    this.richPresence = "";
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BlizzardPresence)) {}
    do
    {
      return false;
      paramObject = (BlizzardPresence)paramObject;
    } while ((!this.friendId.equals(((BlizzardPresence)paramObject).friendId)) || (this.status != ((BlizzardPresence)paramObject).status) || (!this.game.equals(((BlizzardPresence)paramObject).game)) || (Double.compare(this.awayTime, ((BlizzardPresence)paramObject).awayTime) != 0) || (Double.compare(this.lastOnline, ((BlizzardPresence)paramObject).lastOnline) != 0) || (!this.richPresence.equals(((BlizzardPresence)paramObject).richPresence)));
    return true;
  }
  
  public double getAwayTime()
  {
    return this.awayTime;
  }
  
  public String getFriendId()
  {
    return this.friendId;
  }
  
  public String getGame()
  {
    return this.game;
  }
  
  public double getLastOnline()
  {
    return this.lastOnline;
  }
  
  public String getRichPresence()
  {
    return this.richPresence;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public final int hashCode()
  {
    return (((((this.friendId.hashCode() + 629) * 37 + this.status) * 37 + this.game.hashCode()) * 37 + Double.valueOf(this.awayTime).hashCode()) * 37 + Double.valueOf(this.lastOnline).hashCode()) * 37 + this.richPresence.hashCode();
  }
  
  public String toString()
  {
    String str = "" + " Friend ID: " + this.friendId;
    str = str + " Status Int: " + this.status;
    str = str + " Game: " + this.game;
    str = str + " Away Time: " + this.awayTime;
    str = str + " Last Online: " + this.lastOnline;
    return str + " Rich Presence: " + this.richPresence;
  }
  
  public static final class Builder
  {
    private Double awayTime;
    private final String friendId;
    private String game;
    private Double lastOnline;
    private String richPresence;
    private Integer status;
    
    public Builder(@NonNull String paramString)
    {
      this.friendId = paramString;
    }
    
    public BlizzardPresence build()
    {
      return new BlizzardPresence(this, null);
    }
    
    public Double getAwayTime()
    {
      return this.awayTime;
    }
    
    public Builder setAwayTime(@Nullable Double paramDouble)
    {
      this.awayTime = paramDouble;
      return this;
    }
    
    public Builder setGame(@Nullable String paramString)
    {
      this.game = paramString;
      return this;
    }
    
    public Builder setLastOnline(@Nullable Double paramDouble)
    {
      this.lastOnline = paramDouble;
      return this;
    }
    
    public Builder setRichPresence(@Nullable String paramString)
    {
      this.richPresence = paramString;
      return this;
    }
    
    public Builder setStatus(Integer paramInteger)
    {
      this.status = paramInteger;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/presence/BlizzardPresence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */