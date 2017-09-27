package com.blizzard.bgs.client.service.gameutilities.message.v1;

import com.blizzard.bgs.client.service.base.AccountEntityId;
import com.blizzard.bgs.client.service.base.Attribute;
import com.blizzard.bgs.client.service.base.ClientInfo;
import com.blizzard.bgs.client.service.base.GameAccountEntityId;
import com.blizzard.bgs.client.service.base.ProcessId;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ClientRequest
{
  @Expose
  @SerializedName("account_id")
  private AccountEntityId accountId;
  @Expose
  @SerializedName("attribute")
  private List<Attribute> attributes;
  @Expose
  @SerializedName("client_info")
  private ClientInfo clientInfo;
  @Expose
  @SerializedName("game_account_id")
  private GameAccountEntityId gameAccountId;
  @Expose
  @SerializedName("program")
  private Integer programId;
  @Expose
  @SerializedName("host")
  private ProcessId serverId;
  
  public ClientRequest()
  {
    this.attributes = new ArrayList();
  }
  
  public ClientRequest(Collection<Attribute> paramCollection)
  {
    this.attributes = new ArrayList(paramCollection);
  }
  
  public ClientRequest(Attribute... paramVarArgs)
  {
    this.attributes = Arrays.asList(paramVarArgs);
  }
  
  public void addAttribute(Attribute paramAttribute)
  {
    this.attributes.add(paramAttribute);
  }
  
  public void addAttributes(Collection<Attribute> paramCollection)
  {
    this.attributes.addAll(paramCollection);
  }
  
  public void addAttributes(Attribute... paramVarArgs)
  {
    this.attributes.addAll(Arrays.asList(paramVarArgs));
  }
  
  public AccountEntityId getAccountId()
  {
    return this.accountId;
  }
  
  public List<Attribute> getAttributes()
  {
    return this.attributes;
  }
  
  public ClientInfo getClientInfo()
  {
    return this.clientInfo;
  }
  
  public GameAccountEntityId getGameAccountId()
  {
    return this.gameAccountId;
  }
  
  public Integer getProgramId()
  {
    return this.programId;
  }
  
  public ProcessId getServerId()
  {
    return this.serverId;
  }
  
  public void setAccountId(AccountEntityId paramAccountEntityId)
  {
    this.accountId = paramAccountEntityId;
  }
  
  public void setClientInfo(ClientInfo paramClientInfo)
  {
    this.clientInfo = paramClientInfo;
  }
  
  public void setGameAccountId(GameAccountEntityId paramGameAccountEntityId)
  {
    this.gameAccountId = paramGameAccountEntityId;
  }
  
  public void setProgramId(Integer paramInteger)
  {
    this.programId = paramInteger;
  }
  
  public void setServerId(ProcessId paramProcessId)
  {
    this.serverId = paramProcessId;
  }
  
  public String toString()
  {
    return "ClientRequest{attributes=" + this.attributes + ", serverId=" + this.serverId + ", accountId=" + this.accountId + ", gameAccountId=" + this.gameAccountId + ", programId=" + this.programId + ", clientInfo=" + this.clientInfo + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/gameutilities/message/v1/ClientRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */