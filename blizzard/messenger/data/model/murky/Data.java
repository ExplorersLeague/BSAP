package com.blizzard.messenger.data.model.murky;

import com.google.gson.annotations.SerializedName;

public class Data
{
  @SerializedName("contact")
  private Contact contact;
  @SerializedName("identity")
  private Identity identity;
  
  public Contact getContact()
  {
    return this.contact;
  }
  
  public Identity getIdentity()
  {
    return this.identity;
  }
  
  public void setContact(Contact paramContact)
  {
    this.contact = paramContact;
  }
  
  public void setIdentity(Identity paramIdentity)
  {
    this.identity = paramIdentity;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/murky/Data.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */