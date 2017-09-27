package com.blizzard.messenger.data.model.chat;

import android.support.annotation.NonNull;
import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import com.blizzard.messenger.data.providers.ConversationProvider;
import java.util.HashSet;
import java.util.Set;
import rx.Observable;
import rx.subjects.PublishSubject;

public final class UnseenConversationModel
{
  private final PublishSubject<Boolean> allConversationsSeenSubject = PublishSubject.create();
  private final PublishSubject<String> conversationSeenSubject = PublishSubject.create();
  private final PublishSubject<String> conversationUnseenSubject = PublishSubject.create();
  private final Set<String> unseenConversations = new HashSet();
  
  public void clear()
  {
    this.unseenConversations.clear();
  }
  
  public Observable<Boolean> onAllConversationsSeen()
  {
    return Observable.just(Boolean.valueOf(this.unseenConversations.isEmpty())).concatWith(this.allConversationsSeenSubject).onBackpressureLatest();
  }
  
  public Observable<Boolean> onConversationUnseen(@NonNull String paramString)
  {
    Observable localObservable = this.conversationSeenSubject.filter(UnseenConversationModel..Lambda.8.lambdaFactory$(paramString)).map(UnseenConversationModel..Lambda.9.lambdaFactory$());
    paramString = Observable.from(this.unseenConversations).concatWith(this.conversationUnseenSubject).filter(UnseenConversationModel..Lambda.10.lambdaFactory$(paramString)).map(UnseenConversationModel..Lambda.11.lambdaFactory$());
    return Observable.just(Boolean.FALSE).concatWith(Observable.merge(localObservable, paramString)).onBackpressureLatest();
  }
  
  public void setProviders(@NonNull ChatHistoryProvider paramChatHistoryProvider, @NonNull ConversationProvider paramConversationProvider)
  {
    paramChatHistoryProvider.onConversationUnseen().subscribe(this.conversationUnseenSubject);
    paramConversationProvider.onMessageCreated().filter(UnseenConversationModel..Lambda.1.lambdaFactory$()).map(UnseenConversationModel..Lambda.2.lambdaFactory$()).subscribe(this.conversationUnseenSubject);
    paramChatHistoryProvider.onConversationSeen().subscribe(this.conversationSeenSubject);
    paramConversationProvider.onConversationHidden().subscribe(this.conversationSeenSubject);
    paramConversationProvider.onConversationsDeleted().flatMapIterable(UnseenConversationModel..Lambda.3.lambdaFactory$(this)).subscribe(this.conversationSeenSubject);
    paramChatHistoryProvider = this.conversationUnseenSubject;
    paramConversationProvider = this.unseenConversations;
    paramConversationProvider.getClass();
    paramChatHistoryProvider.map(UnseenConversationModel..Lambda.4.lambdaFactory$(paramConversationProvider)).subscribe(UnseenConversationModel..Lambda.5.lambdaFactory$(this));
    paramChatHistoryProvider = this.conversationSeenSubject;
    paramConversationProvider = this.unseenConversations;
    paramConversationProvider.getClass();
    paramChatHistoryProvider.map(UnseenConversationModel..Lambda.6.lambdaFactory$(paramConversationProvider)).subscribe(UnseenConversationModel..Lambda.7.lambdaFactory$(this));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/chat/UnseenConversationModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */