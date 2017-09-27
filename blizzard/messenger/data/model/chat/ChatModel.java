package com.blizzard.messenger.data.model.chat;

import android.support.v4.util.Pair;
import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import com.blizzard.messenger.data.providers.ConversationProvider;
import com.blizzard.messenger.data.providers.UnfurlMessageProvider;
import rx.Observable;

public final class ChatModel
{
  private Observable<ChatMessage> activeMessageAddedObservable;
  private Observable<String> conversationClearedObservable;
  private final String conversationId;
  private Observable<ChatMessage> historyMessageAddedObservable;
  private Observable<ChatMessage> liveMessageAddedObservable;
  private Observable<QualifiedMessageId> messageRemovedObservable;
  private Observable<Pair<QualifiedMessageId, TextChatMessage>> messageSentObservable;
  private Observable<ChatMessage> unfurlMessageAddedObservable;
  
  public ChatModel(String paramString)
  {
    this.conversationId = paramString;
  }
  
  public Observable<String> onCleared()
  {
    return this.conversationClearedObservable;
  }
  
  public Observable<ChatMessage> onMessageAdded()
  {
    return Observable.merge(this.liveMessageAddedObservable, this.historyMessageAddedObservable, this.activeMessageAddedObservable, this.unfurlMessageAddedObservable);
  }
  
  public Observable<QualifiedMessageId> onMessageRemoved()
  {
    return this.messageRemovedObservable;
  }
  
  public Observable<Pair<QualifiedMessageId, TextChatMessage>> onMessageSent()
  {
    return this.messageSentObservable;
  }
  
  public void setChatHistoryProvider(ChatHistoryProvider paramChatHistoryProvider)
  {
    this.historyMessageAddedObservable = paramChatHistoryProvider.onChatHistoryReceived().filter(ChatModel..Lambda.1.lambdaFactory$(this)).cast(ChatMessage.class);
    this.activeMessageAddedObservable = paramChatHistoryProvider.onLatestMessagesReceived().filter(ChatModel..Lambda.2.lambdaFactory$(this)).cast(ChatMessage.class);
  }
  
  public void setConversationProvider(ConversationProvider paramConversationProvider)
  {
    this.liveMessageAddedObservable = paramConversationProvider.onMessageCreated().filter(ChatModel..Lambda.3.lambdaFactory$(this)).cast(ChatMessage.class);
    this.messageRemovedObservable = paramConversationProvider.onMessageDeleted().filter(ChatModel..Lambda.4.lambdaFactory$(this));
    this.conversationClearedObservable = paramConversationProvider.onConversationsDeleted().map(ChatModel..Lambda.5.lambdaFactory$(this)).mergeWith(paramConversationProvider.onConversationHidden().filter(ChatModel..Lambda.6.lambdaFactory$(this)));
    this.messageSentObservable = paramConversationProvider.onMessageSent().filter(ChatModel..Lambda.7.lambdaFactory$(this));
  }
  
  public void setUnfurlMessageProvider(UnfurlMessageProvider paramUnfurlMessageProvider)
  {
    this.unfurlMessageAddedObservable = paramUnfurlMessageProvider.onUnfurlMessageCreated().filter(ChatModel..Lambda.8.lambdaFactory$(this)).cast(ChatMessage.class);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/chat/ChatModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */