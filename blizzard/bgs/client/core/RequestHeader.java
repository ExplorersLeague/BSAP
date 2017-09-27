package com.blizzard.bgs.client.core;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.service.base.RequestId;
import com.blizzard.bgs.client.service.base.ServiceId;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestHeader
  extends RequestId
{
  private static final AtomicInteger nextToken = new AtomicInteger(1);
  @Required
  @Expose
  @SerializedName("token")
  Integer token;
  
  public RequestHeader(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this(paramInt1, paramInt2, paramInt3, paramString, nextToken.getAndIncrement());
  }
  
  public RequestHeader(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramString);
    this.token = Integer.valueOf(paramInt4);
  }
  
  public RequestHeader(RequestId paramRequestId)
  {
    this(paramRequestId.getServiceId(), paramRequestId.getServiceHash(), paramRequestId.getMethodId(), paramRequestId.getObjectId());
  }
  
  public RequestHeader(ServiceId paramServiceId, int paramInt, String paramString)
  {
    this(paramServiceId.getServiceId(), paramServiceId.getServiceHash(), paramInt, paramString);
  }
  
  public int getToken()
  {
    return this.token.intValue();
  }
  
  public String toString()
  {
    return "RequestHeader{requestId=" + super.toString() + ", token=" + this.token + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/RequestHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */