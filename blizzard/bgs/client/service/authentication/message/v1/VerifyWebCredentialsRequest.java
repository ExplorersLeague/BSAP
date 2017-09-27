package com.blizzard.bgs.client.service.authentication.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.core.Base64;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyWebCredentialsRequest
{
  @Required
  @Expose
  @SerializedName("web_credentials")
  private String webCredentials;
  
  public VerifyWebCredentialsRequest(String paramString)
  {
    this.webCredentials = Base64.encode(paramString);
  }
  
  public String toString()
  {
    return "VerifyWebCredentialsRequest{webCredentials='" + Base64.decodeToString(this.webCredentials) + '\'' + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/authentication/message/v1/VerifyWebCredentialsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */