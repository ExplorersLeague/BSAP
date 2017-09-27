package com.blizzard.messenger.data.utils;

import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.chat.TextChatMessage.Builder;
import com.blizzard.messenger.data.xmpp.extension.BlizzardDeliveryReceipt;
import com.blizzard.messenger.data.xmpp.extension.MessageExtension;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.chatstates.ChatState;

public class ChatUtils
{
  public static ChatState getChatState(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
        if (paramString.equals("com.blizzard.messenger.ACTIVE"))
        {
          i = 0;
          continue;
          if (paramString.equals("com.blizzard.messenger.COMPOSING"))
          {
            i = 1;
            continue;
            if (paramString.equals("com.blizzard.messenger.GONE"))
            {
              i = 2;
              continue;
              if (paramString.equals("com.blizzard.messenger.INACTIVE"))
              {
                i = 3;
                continue;
                if (paramString.equals("com.blizzard.messenger.PAUSED")) {
                  i = 4;
                }
              }
            }
          }
        }
        break;
      }
    }
    return ChatState.active;
    return ChatState.composing;
    return ChatState.gone;
    return ChatState.inactive;
    return ChatState.paused;
  }
  
  public static String getChatTypingState(ChatState paramChatState)
  {
    if (paramChatState == ChatState.active) {
      return "com.blizzard.messenger.ACTIVE";
    }
    if (paramChatState == ChatState.composing) {
      return "com.blizzard.messenger.COMPOSING";
    }
    if (paramChatState == ChatState.gone) {
      return "com.blizzard.messenger.GONE";
    }
    if (paramChatState == ChatState.inactive) {
      return "com.blizzard.messenger.INACTIVE";
    }
    if (paramChatState == ChatState.paused) {
      return "com.blizzard.messenger.PAUSED";
    }
    return null;
  }
  
  public static TextChatMessage toTextChatMessage(TextChatMessage paramTextChatMessage, BlizzardDeliveryReceipt paramBlizzardDeliveryReceipt)
  {
    return paramTextChatMessage.newBuilder().messageId(paramBlizzardDeliveryReceipt.getBgsId()).timestamp(paramBlizzardDeliveryReceipt.getTimestamp()).type("com.blizzard.messenger.SENT").build();
  }
  
  public static TextChatMessage toTextChatMessage(Message paramMessage, boolean paramBoolean, String paramString)
  {
    Object localObject = (MessageExtension)paramMessage.getExtension("meta", "blz:message:meta");
    if (localObject != null)
    {
      String str2 = JIDUtils.getLocal(paramMessage.getFrom());
      String str3 = JIDUtils.getLocal(paramMessage.getTo());
      if (paramBoolean) {}
      for (String str1 = str3;; str1 = str2)
      {
        double d = ((MessageExtension)localObject).getTimestamp();
        localObject = ((MessageExtension)localObject).getMessageId();
        return new TextChatMessage.Builder().conversationId(str1).messageId((String)localObject).timestamp(d).body(paramMessage.getBody()).sender(str2).receiver(str3).isMine(paramBoolean).type(paramString).build();
      }
    }
    return null;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/ChatUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */