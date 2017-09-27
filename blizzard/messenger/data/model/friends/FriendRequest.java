package com.blizzard.messenger.data.model.friends;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class FriendRequest
  implements Parcelable
{
  public static final String ASSOCATION_BATTLETAG = "BattleTag";
  public static final String ASSOCIATION_EMAIL = "Email";
  public static final Parcelable.Creator<FriendRequest> CREATOR = new Parcelable.Creator()
  {
    public FriendRequest createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FriendRequest(paramAnonymousParcel);
    }
    
    public FriendRequest[] newArray(int paramAnonymousInt)
    {
      return new FriendRequest[paramAnonymousInt];
    }
  };
  private final String accountId;
  private final String association;
  private final String battletag;
  private final String fullName;
  private final String invitationId;
  private final String requestType;
  
  protected FriendRequest(Parcel paramParcel)
  {
    this.invitationId = paramParcel.readString();
    this.accountId = paramParcel.readString();
    this.requestType = paramParcel.readString();
    this.battletag = paramParcel.readString();
    this.fullName = paramParcel.readString();
    this.association = toAssociation(paramParcel.readString());
  }
  
  private FriendRequest(Builder paramBuilder)
  {
    this.invitationId = paramBuilder.invitationId;
    this.accountId = paramBuilder.accountId;
    this.requestType = paramBuilder.requestType;
    this.battletag = paramBuilder.battletag;
    this.fullName = paramBuilder.fullName;
    this.association = paramBuilder.association;
  }
  
  public static String toAssociation(@NonNull String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid association: " + paramString);
        if (paramString.equals("BattleTag"))
        {
          i = 0;
          continue;
          if (paramString.equals("Email")) {
            i = 1;
          }
        }
        break;
      }
    }
    return "BattleTag";
    return "Email";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public String getAssociation()
  {
    return this.association;
  }
  
  public String getBattletag()
  {
    return this.battletag;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public String getInvitationId()
  {
    return this.invitationId;
  }
  
  public String getRequestType()
  {
    return this.requestType;
  }
  
  public final int hashCode()
  {
    return this.invitationId.hashCode();
  }
  
  public final String toString()
  {
    return String.format("accountId: %1$s fullName: %2$s association: %3$s requestType: %4$s", new Object[] { this.invitationId, this.fullName, this.association, this.requestType });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.invitationId);
    paramParcel.writeString(this.accountId);
    paramParcel.writeString(this.requestType);
    paramParcel.writeString(this.battletag);
    paramParcel.writeString(this.fullName);
    paramParcel.writeString(this.association);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Association {}
  
  public static class Builder
  {
    private final String accountId;
    private String association;
    private String battletag;
    private String fullName;
    private final String invitationId;
    private final String requestType;
    
    static
    {
      if (!FriendRequest.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public Builder(@NonNull FriendRequest paramFriendRequest)
    {
      this.invitationId = paramFriendRequest.getInvitationId();
      this.accountId = paramFriendRequest.getAccountId();
      this.requestType = paramFriendRequest.getRequestType();
      this.battletag = paramFriendRequest.getBattletag();
      this.fullName = paramFriendRequest.getFullName();
      this.association = paramFriendRequest.getAssociation();
    }
    
    public Builder(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
    {
      assert (paramString1 != null);
      assert (paramString2 != null);
      assert (paramString3 != null);
      this.invitationId = paramString2;
      this.accountId = paramString1;
      this.requestType = paramString3;
    }
    
    public FriendRequest build()
    {
      return new FriendRequest(this, null);
    }
    
    public Builder setAssociation(String paramString)
    {
      this.association = paramString;
      return this;
    }
    
    public Builder setBattletag(String paramString)
    {
      this.battletag = paramString;
      return this;
    }
    
    public Builder setFullName(String paramString)
    {
      this.fullName = paramString;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/friends/FriendRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */