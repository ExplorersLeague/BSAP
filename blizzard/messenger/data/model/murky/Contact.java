package com.blizzard.messenger.data.model.murky;

import com.google.gson.annotations.SerializedName;

public class Contact
{
  @SerializedName("firstName")
  private String firstName;
  @SerializedName("lastName")
  private String lastName;
  
  public String getFirstName()
  {
    return this.firstName;
  }
  
  public String getLastName()
  {
    return this.lastName;
  }
  
  public void setFirstName(String paramString)
  {
    this.firstName = paramString;
  }
  
  public void setLastName(String paramString)
  {
    this.lastName = paramString;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/murky/Contact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */