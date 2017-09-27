package com.blizzard.messenger.data.model.friends;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.blizzard.messenger.data.model.presence.BlizzardPresence;

public class Friend
  implements Parcelable
{
  public static final Parcelable.Creator<Friend> CREATOR = new Parcelable.Creator()
  {
    public Friend createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Friend(paramAnonymousParcel);
    }
    
    public Friend[] newArray(int paramAnonymousInt)
    {
      return new Friend[paramAnonymousInt];
    }
  };
  private final double awayTime;
  private final String battleTag;
  private final boolean favorite;
  private final String fullName;
  private final String game;
  private final String id;
  private String lastOnline;
  private final String note;
  private final String richPresence;
  private final int status;
  
  protected Friend(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.favorite = bool;
      this.battleTag = paramParcel.readString();
      this.fullName = paramParcel.readString();
      this.note = paramParcel.readString();
      this.status = FriendPresence.toStatus(paramParcel.readInt());
      this.lastOnline = paramParcel.readString();
      this.game = FriendPresence.toGame(paramParcel.readString());
      this.richPresence = paramParcel.readString();
      this.awayTime = paramParcel.readDouble();
      return;
    }
  }
  
  private Friend(@NonNull Builder paramBuilder)
  {
    this.id = paramBuilder.id;
    this.battleTag = paramBuilder.battleTag;
    this.fullName = paramBuilder.fullName;
    this.favorite = paramBuilder.favorite;
    this.note = paramBuilder.note;
    this.lastOnline = paramBuilder.lastOnline;
    this.status = paramBuilder.status;
    this.game = paramBuilder.game;
    this.richPresence = paramBuilder.richPresence;
    this.awayTime = paramBuilder.awayTime;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Friend)) {}
    do
    {
      return false;
      paramObject = (Friend)paramObject;
    } while ((!this.id.equals(((Friend)paramObject).id)) || (!this.battleTag.equals(((Friend)paramObject).battleTag)) || (!this.fullName.equals(((Friend)paramObject).fullName)) || (this.favorite != ((Friend)paramObject).favorite) || (!this.note.equals(((Friend)paramObject).note)) || (!this.lastOnline.equals(((Friend)paramObject).lastOnline)) || (this.status != ((Friend)paramObject).status) || (!this.game.equals(((Friend)paramObject).game)) || (!this.richPresence.equals(((Friend)paramObject).richPresence)) || (this.awayTime != ((Friend)paramObject).awayTime));
    return true;
  }
  
  public double getAwayTime()
  {
    return this.awayTime;
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
  
  public String getId()
  {
    return this.id;
  }
  
  public String getLastOnline()
  {
    return this.lastOnline;
  }
  
  public String getNote()
  {
    return this.note;
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
    int j = this.id.hashCode();
    int k = this.battleTag.hashCode();
    int m = this.fullName.hashCode();
    if (this.favorite) {}
    for (int i = 1;; i = 0) {
      return (((((((((j + 629) * 37 + k) * 37 + m) * 37 + i) * 37 + this.note.hashCode()) * 37 + this.lastOnline.hashCode()) * 37 + this.status) * 37 + this.game.hashCode()) * 37 + this.richPresence.hashCode()) * 37 + Double.valueOf(this.awayTime).hashCode();
    }
  }
  
  public boolean isFavorite()
  {
    return this.favorite;
  }
  
  public boolean isInGame()
  {
    return (!TextUtils.isEmpty(this.game)) && (FriendPresence.isGame(this.game));
  }
  
  public boolean isOnline()
  {
    return this.status != 5;
  }
  
  public final String toString()
  {
    String str = "" + "id: " + this.id;
    str = str + " battleTag: " + this.battleTag;
    str = str + " fullName: " + this.fullName;
    str = str + " isFavorite: " + this.favorite;
    str = str + " note: " + this.note;
    str = str + " lastOnline: " + this.lastOnline;
    str = str + " status: " + this.status;
    str = str + " game: " + this.game;
    str = str + " rich presence: " + this.richPresence;
    return str + " awayTime: " + this.awayTime;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    if (this.favorite) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.battleTag);
      paramParcel.writeString(this.fullName);
      paramParcel.writeString(this.note);
      paramParcel.writeInt(this.status);
      paramParcel.writeString(this.lastOnline);
      paramParcel.writeString(this.game);
      paramParcel.writeString(this.richPresence);
      paramParcel.writeDouble(this.awayTime);
      return;
    }
  }
  
  public static class Builder
  {
    private double awayTime;
    private final String battleTag;
    private final boolean favorite;
    private final String fullName;
    private String game = "None";
    private final String id;
    private String lastOnline;
    private final String note;
    private String richPresence;
    private int status = 5;
    
    public Builder(@NonNull FriendAccount paramFriendAccount)
    {
      this.id = paramFriendAccount.getId();
      this.battleTag = paramFriendAccount.getBattleTag();
      this.fullName = paramFriendAccount.getFullName();
      this.note = paramFriendAccount.getNote();
      this.favorite = paramFriendAccount.isFavorite();
    }
    
    public Friend build()
    {
      return new Friend(this, null);
    }
    
    public Builder setPresence(@NonNull BlizzardPresence paramBlizzardPresence)
    {
      this.status = paramBlizzardPresence.getStatus();
      this.game = paramBlizzardPresence.getGame();
      this.lastOnline = String.valueOf(paramBlizzardPresence.getLastOnline());
      this.richPresence = paramBlizzardPresence.getRichPresence();
      this.awayTime = paramBlizzardPresence.getAwayTime();
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/friends/Friend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */