package com.blizzard.bgs.client.service.connection.message.v1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectRequest
{
  @Expose
  @SerializedName("use_bindless_rpc")
  private boolean useBindlessRpc = true;
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/connection/message/v1/ConnectRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */