package com.blizzard.messenger.data.model.murky;

import com.google.gson.annotations.SerializedName;

public class Identity
{
  @SerializedName("battleTag")
  private String battletag;
  
  public String getBattletag()
  {
    return this.battletag;
  }
  
  public void setBattletag(String paramString)
  {
    this.battletag = paramString;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/murky/Identity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */