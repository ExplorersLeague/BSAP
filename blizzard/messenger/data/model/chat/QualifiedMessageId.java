package com.blizzard.messenger.data.model.chat;

import android.support.annotation.NonNull;

public class QualifiedMessageId
{
  private final String conversationId;
  private final String messageId;
  
  public QualifiedMessageId(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.conversationId = paramString1;
    this.messageId = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (QualifiedMessageId)paramObject;
      bool1 = bool2;
    } while (!this.conversationId.equals(((QualifiedMessageId)paramObject).conversationId));
    return this.messageId.equals(((QualifiedMessageId)paramObject).messageId);
  }
  
  public String getConversationId()
  {
    return this.conversationId;
  }
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public int hashCode()
  {
    return this.conversationId.hashCode() * 31 + this.messageId.hashCode();
  }
  
  public String toString()
  {
    return "QualifiedMessageId{conversationId='" + this.conversationId + '\'' + ", messageId='" + this.messageId + '\'' + '}';
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/chat/QualifiedMessageId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */