package com.blizzard.messenger.data.model.chat;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public class TextChatMessage
  extends ChatMessage
{
  private final String body;
  private final String receiver;
  private final String sender;
  private String type;
  
  public TextChatMessage()
  {
    super(null, null, 0.0D, false);
    this.body = null;
    this.sender = null;
    this.receiver = null;
  }
  
  private TextChatMessage(Builder paramBuilder)
  {
    super(paramBuilder.conversationId, getMessageId(paramBuilder), paramBuilder.timestamp, paramBuilder.isMine);
    this.body = paramBuilder.body;
    this.sender = paramBuilder.sender;
    this.receiver = paramBuilder.receiver;
    this.type = paramBuilder.type;
  }
  
  private static String getMessageId(Builder paramBuilder)
  {
    if (TextUtils.isEmpty(paramBuilder.messageId)) {
      return paramBuilder.conversationId + '-' + paramBuilder.sender + '-' + paramBuilder.receiver + '-' + paramBuilder.timestamp;
    }
    return paramBuilder.messageId;
  }
  
  public String getBody()
  {
    return this.body;
  }
  
  public String getLocal()
  {
    if (isMine()) {
      return this.sender;
    }
    return this.receiver;
  }
  
  public String getReceiver()
  {
    return this.receiver;
  }
  
  public String getRemote()
  {
    if (isMine()) {
      return this.receiver;
    }
    return this.sender;
  }
  
  public String getSender()
  {
    return this.sender;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public Builder newBuilder()
  {
    return new Builder().conversationId(getConversationId()).messageId(getMessageId()).timestamp(getTimestamp()).isMine(isMine()).body(this.body).sender(this.sender).receiver(this.receiver).type(this.type);
  }
  
  public String toString()
  {
    return "TextChatMessage{body='" + this.body + '\'' + ", sender='" + this.sender + '\'' + ", receiver='" + this.receiver + '\'' + ", type='" + this.type + '\'' + "} " + super.toString();
  }
  
  public static class Builder
  {
    private String body;
    private String conversationId;
    private boolean isMine;
    private String messageId;
    private String receiver;
    private String sender;
    private double timestamp;
    private String type;
    
    public Builder body(@NonNull String paramString)
    {
      this.body = paramString;
      return this;
    }
    
    public TextChatMessage build()
    {
      return new TextChatMessage(this, null);
    }
    
    public Builder conversationId(@NonNull String paramString)
    {
      this.conversationId = paramString;
      return this;
    }
    
    public Builder isMine(boolean paramBoolean)
    {
      this.isMine = paramBoolean;
      return this;
    }
    
    public Builder messageId(@NonNull String paramString)
    {
      this.messageId = paramString;
      return this;
    }
    
    public Builder receiver(@NonNull String paramString)
    {
      this.receiver = paramString;
      return this;
    }
    
    public Builder sender(@NonNull String paramString)
    {
      this.sender = paramString;
      return this;
    }
    
    public Builder timestamp(double paramDouble)
    {
      this.timestamp = paramDouble;
      return this;
    }
    
    public Builder type(String paramString)
    {
      this.type = paramString;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/chat/TextChatMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */