package com.blizzard.bgs.client.service.base;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestId
  extends ServiceId
{
  @Required
  @Expose
  @SerializedName("method_id")
  Integer methodId;
  @Expose
  @SerializedName("object_id")
  String objectId;
  
  public RequestId(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, null);
  }
  
  public RequestId(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(paramInt1, paramInt2);
    this.methodId = Integer.valueOf(paramInt3);
    this.objectId = paramString;
  }
  
  public RequestId(ServiceId paramServiceId, int paramInt)
  {
    this(paramServiceId.getServiceId(), paramServiceId.getServiceHash(), paramInt);
  }
  
  public RequestId(ServiceId paramServiceId, int paramInt, String paramString)
  {
    this(paramServiceId.getServiceId(), paramServiceId.getServiceHash(), paramInt, paramString);
  }
  
  public RequestId asRequestId()
  {
    return new RequestId(asServiceId(), this.methodId.intValue(), this.objectId);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
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
          do
          {
            return bool1;
            bool1 = bool3;
          } while (paramObject == null);
          bool1 = bool3;
        } while (getClass() != paramObject.getClass());
        bool1 = bool3;
      } while (!super.equals(paramObject));
      paramObject = (RequestId)paramObject;
      bool1 = bool3;
    } while (!this.methodId.equals(((RequestId)paramObject).methodId));
    if (this.objectId != null) {
      bool1 = this.objectId.equals(((RequestId)paramObject).objectId);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (((RequestId)paramObject).objectId != null) {
        bool1 = false;
      }
    }
  }
  
  public int getMethodId()
  {
    return this.methodId.intValue();
  }
  
  public String getObjectId()
  {
    return this.objectId;
  }
  
  public int hashCode()
  {
    int j = super.hashCode();
    int k = this.methodId.hashCode();
    if (this.objectId != null) {}
    for (int i = this.objectId.hashCode();; i = 0) {
      return (j * 31 + k) * 31 + i;
    }
  }
  
  public String toString()
  {
    return "RequestId{serviceId=" + super.toString() + ", methodId=" + this.methodId + ", objectId='" + this.objectId + '\'' + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/base/RequestId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */