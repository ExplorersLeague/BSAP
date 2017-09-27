package com.blizzard.bgs.client.service.connection.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisconnectNotification
{
  @Required
  @Expose
  @SerializedName("error_code")
  private Integer errorCode;
  @Expose
  @SerializedName("reason")
  private String reason;
  
  public DisconnectNotification(int paramInt, String paramString)
  {
    this.errorCode = Integer.valueOf(paramInt);
    this.reason = paramString;
  }
  
  public int getErrorCode()
  {
    return this.errorCode.intValue();
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public String toString()
  {
    return "DisconnectNotification{errorCode=" + this.errorCode + ", reason='" + this.reason + '\'' + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/connection/message/v1/DisconnectNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */