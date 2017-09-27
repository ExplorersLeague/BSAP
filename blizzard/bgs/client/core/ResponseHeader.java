package com.blizzard.bgs.client.core;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseHeader
{
  @Required
  @Expose
  @SerializedName("service_id")
  private Integer serviceId = Integer.valueOf(254);
  @Required
  @Expose
  @SerializedName("status")
  private Integer status;
  @Required
  @Expose
  @SerializedName("token")
  private Integer token;
  
  public ResponseHeader(int paramInt)
  {
    this(paramInt, 0);
  }
  
  public ResponseHeader(int paramInt1, int paramInt2)
  {
    this.token = Integer.valueOf(paramInt1);
    this.status = Integer.valueOf(paramInt2);
  }
  
  public ResponseHeader(RequestHeader paramRequestHeader)
  {
    this(paramRequestHeader, 0);
  }
  
  public ResponseHeader(RequestHeader paramRequestHeader, int paramInt)
  {
    this(paramRequestHeader.getToken(), paramInt);
  }
  
  public boolean failed()
  {
    return !succeeded();
  }
  
  public int getServiceId()
  {
    return this.serviceId.intValue();
  }
  
  public int getStatus()
  {
    return this.status.intValue();
  }
  
  public int getToken()
  {
    return this.token.intValue();
  }
  
  public boolean succeeded()
  {
    return this.status.intValue() == 0;
  }
  
  public String toString()
  {
    return "ResponseHeader{serviceId=" + this.serviceId + ", token=" + this.token + ", status=" + this.status + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/ResponseHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */