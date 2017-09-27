package com.blizzard.bgs.client.service.connection.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisconnectRequest
{
  @Required
  @Expose
  @SerializedName("error_code")
  Integer errorCode;
  
  public DisconnectRequest(Integer paramInteger)
  {
    this.errorCode = paramInteger;
  }
  
  public Integer getErrorCode()
  {
    return this.errorCode;
  }
  
  public void setErrorCode(Integer paramInteger)
  {
    this.errorCode = paramInteger;
  }
  
  public String toString()
  {
    return "DisconnectRequest{errorCode=" + this.errorCode + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/connection/message/v1/DisconnectRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */