package com.blizzard.messenger.data.providers;

import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.chat.UnfurlChatMessage;
import rx.Observable;
import rx.subjects.PublishSubject;

public class UnfurlMessageProvider
{
  private static final String TAG = UnfurlMessageProvider.class.getSimpleName();
  private final PublishSubject<UnfurlChatMessage> unfurlMessageCreatedSubject = PublishSubject.create();
  
  public Observable<UnfurlChatMessage> onUnfurlMessageCreated()
  {
    return this.unfurlMessageCreatedSubject;
  }
  
  public void setProvider(ConversationProvider paramConversationProvider)
  {
    paramConversationProvider.onMessageCreated().subscribe(UnfurlMessageProvider..Lambda.1.lambdaFactory$(this));
  }
  
  public void unfurlTextMessage(TextChatMessage paramTextChatMessage) {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/UnfurlMessageProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */