package com.blizzard.messenger.data.model.chat;

import com.orm.SugarRecord;
import java.util.UUID;

public abstract class ChatMessage
  extends SugarRecord
{
  private final String conversationId;
  private final boolean isMine;
  private final String messageId;
  private final double timestamp;
  
  public ChatMessage(ChatMessage paramChatMessage)
  {
    this(paramChatMessage.conversationId, paramChatMessage.messageId, paramChatMessage.timestamp, paramChatMessage.isMine);
  }
  
  public ChatMessage(String paramString1, String paramString2, double paramDouble, boolean paramBoolean)
  {
    this.conversationId = paramString1;
    this.messageId = paramString2;
    this.timestamp = paramDouble;
    this.isMine = paramBoolean;
  }
  
  public static String createMessageId()
  {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  
  public static long createTimestamp()
  {
    return System.currentTimeMillis();
  }
  
  public String getConversationId()
  {
    return this.conversationId;
  }
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public QualifiedMessageId getQualifiedMessageId()
  {
    return new QualifiedMessageId(this.conversationId, this.messageId);
  }
  
  public double getTimestamp()
  {
    return this.timestamp;
  }
  
  public boolean isMine()
  {
    return this.isMine;
  }
  
  public String toString()
  {
    return "ChatMessage{conversationId='" + this.conversationId + '\'' + ", messageId='" + this.messageId + '\'' + ", timestamp=" + this.timestamp + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/chat/ChatMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */