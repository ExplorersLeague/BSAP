package com.blizzard.messenger.data.model.profile;

import android.support.annotation.NonNull;

public final class ProfileAccount
{
  private final String battleTag;
  private final String fullName;
  
  private ProfileAccount(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.battleTag = paramString1;
    this.fullName = paramString2;
  }
  
  public static ProfileAccount fromBattleTagAndFullName(@NonNull String paramString1, @NonNull String paramString2)
  {
    return new ProfileAccount(paramString1, paramString2);
  }
  
  public String getBattleTag()
  {
    return this.battleTag;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/profile/ProfileAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */