package com.blizzard.messenger.model;

import com.blizzard.messenger.data.model.chat.ChatMessage;

public class DateMessage
  extends ChatMessage
{
  DateMessage(ChatMessage paramChatMessage, long paramLong)
  {
    super(paramChatMessage.getConversationId(), createMessageId(), paramLong, paramChatMessage.isMine());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/model/DateMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */