package com.blizzard.messenger.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class User
  implements Parcelable
{
  public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator()
  {
    public User createFromParcel(Parcel paramAnonymousParcel)
    {
      return new User(paramAnonymousParcel);
    }
    
    public User[] newArray(int paramAnonymousInt)
    {
      return new User[paramAnonymousInt];
    }
  };
  @SerializedName("battletag")
  String battletag;
  @SerializedName("email")
  String email;
  @SerializedName("id")
  int id;
  @SerializedName("name")
  String name;
  
  public User() {}
  
  protected User(Parcel paramParcel)
  {
    this.battletag = paramParcel.readString();
    this.email = paramParcel.readString();
    this.id = paramParcel.readInt();
    this.name = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBattletag()
  {
    return this.battletag;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setBattletag(String paramString)
  {
    this.battletag = paramString;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.battletag);
    paramParcel.writeString(this.email);
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.name);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */