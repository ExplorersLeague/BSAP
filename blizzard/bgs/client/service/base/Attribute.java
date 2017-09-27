package com.blizzard.bgs.client.service.base;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attribute
{
  @Required
  @Expose
  @SerializedName("name")
  private String name;
  @Required
  @Expose
  @SerializedName("value")
  private Variant value;
  
  public Attribute(String paramString, Variant paramVariant)
  {
    this.name = paramString;
    this.value = paramVariant;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Attribute)paramObject;
      if (this.name != null)
      {
        if (this.name.equals(((Attribute)paramObject).name)) {}
      }
      else {
        while (((Attribute)paramObject).name != null) {
          return false;
        }
      }
      if (this.value != null) {
        return this.value.equals(((Attribute)paramObject).value);
      }
    } while (((Attribute)paramObject).value == null);
    return false;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Variant getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.name != null) {}
    for (int i = this.name.hashCode();; i = 0)
    {
      if (this.value != null) {
        j = this.value.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setValue(Variant paramVariant)
  {
    this.value = paramVariant;
  }
  
  public String toString()
  {
    return "Attribute{name='" + this.name + '\'' + ", value=" + this.value + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/base/Attribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */