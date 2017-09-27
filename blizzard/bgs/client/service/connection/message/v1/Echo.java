package com.blizzard.bgs.client.service.connection.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Echo
{
  @Expose
  @SerializedName("payload")
  private String payload;
  @Required
  @Expose
  @SerializedName("time")
  private Long time;
  
  public String getPayload()
  {
    return this.payload;
  }
  
  public long getTime()
  {
    return this.time.longValue();
  }
  
  public String toString()
  {
    return "Echo{time=" + this.time + ", payload='" + this.payload + '\'' + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/connection/message/v1/Echo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */