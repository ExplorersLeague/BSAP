package com.blizzard.bgs.client.service.authentication.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.core.Base64;
import com.blizzard.bgs.client.service.authentication.AuthenticationConfig;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogonRequest
{
  @Required
  @Expose
  @SerializedName("version")
  private String bgsVersion;
  @Required
  @Expose
  @SerializedName("web_client_verification")
  private Boolean isWebClientVerification;
  @Required
  @Expose
  @SerializedName("locale")
  private String locale;
  @Required
  @Expose
  @SerializedName("platform")
  private String platform;
  @Required
  @Expose
  @SerializedName("program")
  private String programId;
  @Required
  @Expose
  @SerializedName("application_version")
  private Integer programVersion;
  @Expose
  @SerializedName("cached_web_credentials")
  private String token;
  
  public LogonRequest(AuthenticationConfig paramAuthenticationConfig, String paramString)
  {
    this.programId = paramAuthenticationConfig.getProgramId();
    this.platform = paramAuthenticationConfig.getPlatform();
    this.bgsVersion = paramAuthenticationConfig.getBgsVersion();
    this.programVersion = Integer.valueOf(paramAuthenticationConfig.getProgramVersion());
    this.locale = paramAuthenticationConfig.getLocale();
    this.isWebClientVerification = Boolean.valueOf(true);
    this.token = Base64.encode(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("LogonRequest{programId='").append(this.programId).append('\'').append(", platform='").append(this.platform).append('\'').append(", locale='").append(this.locale).append('\'').append(", bgsVersion='").append(this.bgsVersion).append('\'').append(", programVersion=").append(this.programVersion).append(", isWebClientVerification=").append(this.isWebClientVerification).append(", token=");
    if (this.token != null) {}
    for (String str = "present";; str = "absent") {
      return str + '}';
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/authentication/message/v1/LogonRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */