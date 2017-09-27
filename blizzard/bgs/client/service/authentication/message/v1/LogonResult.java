package com.blizzard.bgs.client.service.authentication.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.service.base.AccountEntityId;
import com.blizzard.bgs.client.service.base.GameAccountEntityId;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class LogonResult
{
  @Required
  @Expose
  @SerializedName("account_id")
  private AccountEntityId accountId;
  @Required
  @Expose
  @SerializedName("available_region")
  private List<Integer> availableRegions = new ArrayList();
  @Required
  @Expose
  @SerializedName("battle_tag")
  private String battleTag;
  @Required
  @Expose
  @SerializedName("connected_region")
  private Integer connectedRegion;
  @Required
  @Expose
  @SerializedName("email")
  private String email;
  @Required
  @Expose
  @SerializedName("error_code")
  private Integer errorCode;
  @Required
  @Expose
  @SerializedName("game_account_id")
  private List<GameAccountEntityId> gameAccountIds = new ArrayList();
  @Required
  @Expose
  @SerializedName("geoip_country")
  private String geoIpCountry;
  @Required
  @Expose
  @SerializedName("session_key")
  private String sessionKey;
  
  public LogonResult(int paramInt)
  {
    this.errorCode = Integer.valueOf(paramInt);
  }
  
  public AccountEntityId getAccountId()
  {
    return this.accountId;
  }
  
  public List<Integer> getAvailableRegions()
  {
    return this.availableRegions;
  }
  
  public String getBattleTag()
  {
    return this.battleTag;
  }
  
  public int getConnectedRegion()
  {
    return this.connectedRegion.intValue();
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public int getErrorCode()
  {
    return this.errorCode.intValue();
  }
  
  public List<GameAccountEntityId> getGameAccountIds()
  {
    return this.gameAccountIds;
  }
  
  public String getGeoIpCountry()
  {
    return this.geoIpCountry;
  }
  
  public String getSessionKey()
  {
    return this.sessionKey;
  }
  
  public String toString()
  {
    return "LogonResult{errorCode=" + this.errorCode + ", accountId=" + this.accountId + ", gameAccountIds=" + this.gameAccountIds + ", email='" + this.email + '\'' + ", availableRegions=" + this.availableRegions + ", connectedRegion=" + this.connectedRegion + ", battleTag='" + this.battleTag + '\'' + ", geoIpCountry='" + this.geoIpCountry + '\'' + ", sessionKey='" + this.sessionKey + '\'' + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/authentication/message/v1/LogonResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */