package com.blizzard.bgs.client.service.challenge.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.core.Base64;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChallengeExternalRequest
{
  @Required
  @Expose
  @SerializedName("payload")
  private String payload;
  @Required
  @Expose
  @SerializedName("payload_type")
  private String payloadType;
  @Expose
  @SerializedName("request_token")
  private String requestToken;
  
  public ChallengeExternalRequest(String paramString1, String paramString2, String paramString3)
  {
    this.requestToken = paramString1;
    this.payloadType = paramString2;
    this.payload = paramString3;
  }
  
  public String getDecodedPayload()
  {
    return Base64.decodeToString(this.payload);
  }
  
  public String getPayload()
  {
    return this.payload;
  }
  
  public String getPayloadType()
  {
    return this.payloadType;
  }
  
  public String getRequestToken()
  {
    return this.requestToken;
  }
  
  public String toString()
  {
    String str2 = getDecodedPayload();
    String str1 = str2;
    if (str2 == null) {
      str1 = this.payload;
    }
    return "ChallengeExternalRequest{requestToken='" + this.requestToken + '\'' + ", payloadType='" + this.payloadType + '\'' + ", payload='" + str1 + '\'' + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/challenge/message/v1/ChallengeExternalRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */