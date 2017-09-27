package com.blizzard.bgs.client.service.base;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.core.Hash;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceId
{
  @Expose
  @SerializedName("service_hash")
  Integer serviceHash = Integer.valueOf(0);
  @Required
  @Expose
  @SerializedName("service_id")
  Integer serviceId;
  
  public ServiceId(int paramInt1, int paramInt2)
  {
    this.serviceId = Integer.valueOf(paramInt1);
    this.serviceHash = Integer.valueOf(paramInt2);
  }
  
  public ServiceId(String paramString, int paramInt)
  {
    this(paramInt, Hash.getHash(paramString));
  }
  
  public ServiceId asServiceId()
  {
    return new ServiceId(this.serviceId.intValue(), this.serviceHash.intValue());
  }
  
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
      paramObject = (ServiceId)paramObject;
      if (this.serviceHash == null) {
        break;
      }
      bool1 = bool2;
    } while (!this.serviceHash.equals(((ServiceId)paramObject).serviceHash));
    while (((ServiceId)paramObject).serviceHash == null) {
      return this.serviceId.equals(((ServiceId)paramObject).serviceId);
    }
    return false;
  }
  
  public int getServiceHash()
  {
    return this.serviceHash.intValue();
  }
  
  public int getServiceId()
  {
    return this.serviceId.intValue();
  }
  
  public int hashCode()
  {
    if (this.serviceHash != null) {}
    for (int i = this.serviceHash.hashCode();; i = 0) {
      return i * 31 + this.serviceId.hashCode();
    }
  }
  
  public String toString()
  {
    return "ServiceId{serviceId=" + this.serviceId + ", serviceHash=" + this.serviceHash + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/base/ServiceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */