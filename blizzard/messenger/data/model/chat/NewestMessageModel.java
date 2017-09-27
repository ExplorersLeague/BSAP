package com.blizzard.messenger.data.model.chat;

import com.blizzard.messenger.data.datastores.ChatHistoryDatastore;
import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import com.blizzard.messenger.data.providers.ConversationProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class NewestMessageModel
{
  private ChatHistoryDatastore chatHistoryDatastore;
  private final PublishSubject<String> conversationRemovedSubject = PublishSubject.create();
  private final PublishSubject<TextChatMessage> newestMessageChangedSubject = PublishSubject.create();
  private final Map<String, TextChatMessage> newestMessages = new HashMap();
  
  private void addMessage(TextChatMessage paramTextChatMessage)
  {
    String str = paramTextChatMessage.getConversationId();
    TextChatMessage localTextChatMessage = (TextChatMessage)this.newestMessages.get(str);
    if ((localTextChatMessage == null) || (localTextChatMessage.getTimestamp() < paramTextChatMessage.getTimestamp()))
    {
      this.newestMessages.put(str, paramTextChatMessage);
      this.newestMessageChangedSubject.onNext(paramTextChatMessage);
    }
  }
  
  private void clear()
  {
    Object localObject = new ArrayList(this.newestMessages.keySet());
    this.newestMessages.clear();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.conversationRemovedSubject.onNext(str);
    }
  }
  
  private void removeConversation(String paramString)
  {
    this.newestMessages.remove(paramString);
    this.conversationRemovedSubject.onNext(paramString);
  }
  
  private void removeMessage(QualifiedMessageId paramQualifiedMessageId)
  {
    String str = paramQualifiedMessageId.getConversationId();
    paramQualifiedMessageId = paramQualifiedMessageId.getMessageId();
    TextChatMessage localTextChatMessage = (TextChatMessage)this.newestMessages.get(str);
    if ((localTextChatMessage != null) && (localTextChatMessage.getMessageId().equals(paramQualifiedMessageId)))
    {
      this.newestMessages.remove(str);
      this.chatHistoryDatastore.getNewestMessage(str).subscribeOn(Schedulers.io()).subscribe(NewestMessageModel..Lambda.7.lambdaFactory$(this), NewestMessageModel..Lambda.8.lambdaFactory$());
    }
  }
  
  public List<TextChatMessage> getNewestMessages()
  {
    return new ArrayList(this.newestMessages.values());
  }
  
  public Observable<String> onConversationRemoved()
  {
    return this.conversationRemovedSubject;
  }
  
  public Observable<TextChatMessage> onNewestMessageChanged()
  {
    return this.newestMessageChangedSubject;
  }
  
  public void setChatHistoryDatastore(ChatHistoryDatastore paramChatHistoryDatastore)
  {
    this.chatHistoryDatastore = paramChatHistoryDatastore;
    this.chatHistoryDatastore.getNewestMessages().observeOn(Schedulers.io()).subscribe(NewestMessageModel..Lambda.1.lambdaFactory$(this));
  }
  
  public void setChatHistoryProvider(ChatHistoryProvider paramChatHistoryProvider)
  {
    paramChatHistoryProvider.onLatestMessagesReceived().observeOn(Schedulers.io()).subscribe(NewestMessageModel..Lambda.2.lambdaFactory$(this));
  }
  
  public void setConversationProvider(ConversationProvider paramConversationProvider)
  {
    paramConversationProvider.onConversationsDeleted().observeOn(Schedulers.io()).subscribe(NewestMessageModel..Lambda.3.lambdaFactory$(this));
    paramConversationProvider.onConversationHidden().observeOn(Schedulers.io()).subscribe(NewestMessageModel..Lambda.4.lambdaFactory$(this));
    paramConversationProvider.onMessageCreated().observeOn(Schedulers.io()).subscribe(NewestMessageModel..Lambda.5.lambdaFactory$(this));
    paramConversationProvider.onMessageDeleted().observeOn(Schedulers.io()).subscribe(NewestMessageModel..Lambda.6.lambdaFactory$(this));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/chat/NewestMessageModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */