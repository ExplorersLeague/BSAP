package com.blizzard.bgs.client.service.connection.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.service.base.ProcessId;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectResponse
{
  @Required
  @Expose
  @SerializedName("client_id")
  private ProcessId clientId;
  @Required
  @Expose
  @SerializedName("server_id")
  private ProcessId serverId;
  @Required
  @Expose
  @SerializedName("server_time")
  private Long serverTime;
  
  public ProcessId getClientId()
  {
    return this.clientId;
  }
  
  public ProcessId getServerId()
  {
    return this.serverId;
  }
  
  public Long getServerTime()
  {
    return this.serverTime;
  }
  
  public String toString()
  {
    return "ConnectResponse{serverId=" + this.serverId + ", clientId=" + this.clientId + ", serverTime=" + this.serverTime + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/connection/message/v1/ConnectResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */