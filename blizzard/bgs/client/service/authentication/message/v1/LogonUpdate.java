package com.blizzard.bgs.client.service.authentication.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogonUpdate
{
  @Required
  @Expose
  @SerializedName("error_code")
  private Integer errorCode;
  
  public LogonUpdate(int paramInt)
  {
    this.errorCode = Integer.valueOf(paramInt);
  }
  
  public int getErrorCode()
  {
    return this.errorCode.intValue();
  }
  
  public String toString()
  {
    return "LogonUpdate{errorCode=" + this.errorCode + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/authentication/message/v1/LogonUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */