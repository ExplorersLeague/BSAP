package com.blizzard.messenger.data.model.chat;

public class UnfurlChatMessage
  extends ChatMessage
{
  private final String imageUrl;
  private final int index;
  private final String sourceMessageId;
  private final String url = "";
  private final String urlDescription = "";
  private final String urlTitle = "";
  
  public UnfurlChatMessage(ChatMessage paramChatMessage, int paramInt)
  {
    super(paramChatMessage.getConversationId(), createMessageId(), paramChatMessage.getTimestamp(), paramChatMessage.isMine());
    this.sourceMessageId = paramChatMessage.getMessageId();
    this.index = paramInt;
    this.imageUrl = "";
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getSourceMessageId()
  {
    return this.sourceMessageId;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public String getUrlDescription()
  {
    return this.urlDescription;
  }
  
  public String getUrlTitle()
  {
    return this.urlTitle;
  }
  
  public String toString()
  {
    return "UnfurlChatMessage{url='" + this.url + '\'' + ", urlTitle='" + this.urlTitle + '\'' + ", urlDescription='" + this.urlDescription + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", sourceMessageId='" + this.sourceMessageId + '\'' + ", index=" + this.index + "} " + super.toString();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/chat/UnfurlChatMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */