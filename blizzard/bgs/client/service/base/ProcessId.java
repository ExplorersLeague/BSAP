package com.blizzard.bgs.client.service.base;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProcessId
{
  @Required
  @Expose
  @SerializedName("epoch")
  private Integer epoch;
  @Required
  @Expose
  @SerializedName("label")
  private Integer label;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (ProcessId)paramObject;
      bool1 = bool2;
    } while (!this.label.equals(((ProcessId)paramObject).label));
    return this.epoch.equals(((ProcessId)paramObject).epoch);
  }
  
  public int getEpoch()
  {
    return this.epoch.intValue();
  }
  
  public int getLabel()
  {
    return this.label.intValue();
  }
  
  public int hashCode()
  {
    return this.label.hashCode() * 31 + this.epoch.hashCode();
  }
  
  public boolean isStatic()
  {
    return this.label.intValue() < 0;
  }
  
  public String toString()
  {
    return "ProcessId{label=" + this.label + ", epoch=" + this.epoch + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/base/ProcessId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */