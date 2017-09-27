package com.blizzard.messenger.model;

import android.support.v4.util.Pair;
import android.util.Log;
import com.blizzard.messenger.data.model.chat.ChatMessage;
import com.blizzard.messenger.data.model.chat.QualifiedMessageId;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.chat.UnfurlChatMessage;
import com.blizzard.messenger.utils.DateUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChatViewModel
{
  private static final String TAG = ChatViewModel.class.getSimpleName();
  private final ChatMessageSort chatMessageSort = new ChatMessageSort(null);
  private final List<ChatMessage> messages = new ArrayList();
  
  public Pair<Integer, Integer> addChatMessage(ChatMessage paramChatMessage)
  {
    int i = Collections.binarySearch(this.messages, paramChatMessage, this.chatMessageSort);
    if (i >= 0)
    {
      Log.e(TAG, "addChatMessage found duplicate ChatMessages:\n" + paramChatMessage + "\n" + this.messages.get(i));
      return new Pair(Integer.valueOf(-1), Integer.valueOf(0));
    }
    int j = -i - 1;
    i = 1;
    this.messages.add(j, paramChatMessage);
    long l2 = DateUtils.getEpochTimeForDay(paramChatMessage.getTimestamp());
    if (j == 0) {}
    for (long l1 = 0L;; l1 = DateUtils.getEpochTimeForDay(((ChatMessage)this.messages.get(j - 1)).getTimestamp()))
    {
      if (DateUtils.isDifferentDay(l1, l2))
      {
        i = 1 + 1;
        this.messages.add(j, new DateMessage(paramChatMessage, l2));
      }
      return new Pair(Integer.valueOf(j), Integer.valueOf(i));
    }
  }
  
  public void clearChatMessages()
  {
    this.messages.clear();
  }
  
  public ChatMessage getChatMessage(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.messages.size())) {
      return null;
    }
    return (ChatMessage)this.messages.get(paramInt);
  }
  
  public int getChatMessageCount()
  {
    return this.messages.size();
  }
  
  public int getChatMessageIndex(ChatMessage paramChatMessage)
  {
    return this.messages.indexOf(paramChatMessage);
  }
  
  public Pair<Integer, Integer> removeChatMessage(QualifiedMessageId paramQualifiedMessageId)
  {
    int i = this.messages.size() - 1;
    while (i >= 0)
    {
      ChatMessage localChatMessage = (ChatMessage)this.messages.get(i);
      if (localChatMessage.getMessageId().equals(paramQualifiedMessageId.getMessageId()))
      {
        this.messages.remove(i);
        int k = 1;
        int j = 1;
        int m = i;
        if ((localChatMessage instanceof TextChatMessage))
        {
          while ((i < this.messages.size()) && ((this.messages.get(i) instanceof UnfurlChatMessage)))
          {
            this.messages.remove(i);
            j += 1;
          }
          k = j;
          m = i;
          if (i > 0)
          {
            k = j;
            m = i;
            if ((this.messages.get(i - 1) instanceof DateMessage)) {
              if (i != this.messages.size())
              {
                k = j;
                m = i;
                if (!(this.messages.get(i) instanceof DateMessage)) {}
              }
              else
              {
                m = i - 1;
                this.messages.remove(m);
                k = j + 1;
              }
            }
          }
        }
        return new Pair(Integer.valueOf(m), Integer.valueOf(k));
      }
      i -= 1;
    }
    return new Pair(Integer.valueOf(-1), Integer.valueOf(0));
  }
  
  private static class ChatMessageSort
    implements Comparator<ChatMessage>
  {
    public int compare(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
    {
      int i = -1;
      int j = Double.compare(paramChatMessage1.getTimestamp(), paramChatMessage2.getTimestamp());
      if (j != 0) {
        i = j;
      }
      do
      {
        return i;
        if (!(paramChatMessage1 instanceof DateMessage)) {
          break;
        }
      } while (!(paramChatMessage2 instanceof DateMessage));
      do
      {
        do
        {
          do
          {
            return paramChatMessage1.getMessageId().compareTo(paramChatMessage2.getMessageId());
            if (!(paramChatMessage1 instanceof TextChatMessage)) {
              break;
            }
            if ((paramChatMessage2 instanceof DateMessage)) {
              return 1;
            }
          } while (!(paramChatMessage2 instanceof UnfurlChatMessage));
          paramChatMessage2 = (UnfurlChatMessage)paramChatMessage2;
          if (paramChatMessage1.getMessageId().compareTo(paramChatMessage2.getSourceMessageId()) <= 0) {
            break;
          }
          return 1;
        } while (!(paramChatMessage1 instanceof UnfurlChatMessage));
        if ((paramChatMessage2 instanceof DateMessage)) {
          return 1;
        }
        UnfurlChatMessage localUnfurlChatMessage1 = (UnfurlChatMessage)paramChatMessage1;
        if ((paramChatMessage2 instanceof TextChatMessage))
        {
          if (localUnfurlChatMessage1.getSourceMessageId().compareTo(paramChatMessage2.getMessageId()) < 0) {
            break;
          }
          return 1;
        }
        UnfurlChatMessage localUnfurlChatMessage2 = (UnfurlChatMessage)paramChatMessage2;
        i = localUnfurlChatMessage1.getSourceMessageId().compareTo(localUnfurlChatMessage2.getSourceMessageId());
        if (i != 0) {
          return i;
        }
        i = Integer.compare(localUnfurlChatMessage1.getIndex(), localUnfurlChatMessage2.getIndex());
      } while (i == 0);
      return i;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/model/ChatViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */