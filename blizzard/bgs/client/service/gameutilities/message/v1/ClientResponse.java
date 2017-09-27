package com.blizzard.bgs.client.service.gameutilities.message.v1;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.service.base.Attribute;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ClientResponse
{
  @Required
  @Expose
  @SerializedName("attribute")
  private List<Attribute> attributes = new ArrayList();
  
  public ClientResponse(Collection<Attribute> paramCollection)
  {
    addAttributes(paramCollection);
  }
  
  public ClientResponse(Attribute... paramVarArgs)
  {
    addAttributes(paramVarArgs);
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
  
  public List<Attribute> getAttributes()
  {
    return this.attributes;
  }
  
  public String toString()
  {
    return "ClientResponse{attributes=" + this.attributes + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/gameutilities/message/v1/ClientResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */