package com.blizzard.messenger.data.model.chat;

import com.orm.SugarRecord;

public class HiddenConversation
  extends SugarRecord
{
  private String conversationId;
  private double lastTimestamp;
  
  public HiddenConversation() {}
  
  public HiddenConversation(String paramString, double paramDouble)
  {
    this.conversationId = paramString;
    this.lastTimestamp = paramDouble;
  }
  
  public String getConversationId()
  {
    return this.conversationId;
  }
  
  public double getLastTimestamp()
  {
    return this.lastTimestamp;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/chat/HiddenConversation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */