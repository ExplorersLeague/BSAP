package com.blizzard.messenger.model;

import com.blizzard.messenger.data.model.chat.TextChatMessage;

public class ChatErrorOption
{
  private final TextChatMessage textMessage;
  private final String type;
  
  public ChatErrorOption(TextChatMessage paramTextChatMessage, String paramString)
  {
    this.textMessage = paramTextChatMessage;
    this.type = paramString;
  }
  
  public TextChatMessage getTextMessage()
  {
    return this.textMessage;
  }
  
  public String getType()
  {
    return this.type;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/model/ChatErrorOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */