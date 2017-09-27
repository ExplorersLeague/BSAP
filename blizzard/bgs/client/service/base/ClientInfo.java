package com.blizzard.bgs.client.service.base;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientInfo
{
  @Required
  @Expose
  @SerializedName("client_address")
  String clientIp;
  @Required
  @Expose
  @SerializedName("privileged_network")
  Boolean privilegedNetwork;
  
  public ClientInfo(String paramString, Boolean paramBoolean)
  {
    this.clientIp = paramString;
    this.privilegedNetwork = paramBoolean;
  }
  
  public String getClientIp()
  {
    return this.clientIp;
  }
  
  public Boolean getPrivilegedNetwork()
  {
    return this.privilegedNetwork;
  }
  
  public void setClientIp(String paramString)
  {
    this.clientIp = paramString;
  }
  
  public void setPrivilegedNetwork(Boolean paramBoolean)
  {
    this.privilegedNetwork = paramBoolean;
  }
  
  public String toString()
  {
    return "ClientInfo{clientIp='" + this.clientIp + '\'' + ", privilegedNetwork=" + this.privilegedNetwork + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/base/ClientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */