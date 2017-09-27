package com.blizzard.messenger.data.datastores;

import android.support.v4.util.Pair;
import android.util.Log;
import com.blizzard.messenger.data.model.chat.ChatMessage;
import com.blizzard.messenger.data.model.chat.HiddenConversation;
import com.blizzard.messenger.data.model.chat.QualifiedMessageId;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.providers.ChatHistoryProvider;
import com.blizzard.messenger.data.providers.ConversationProvider;
import com.orm.query.Condition;
import com.orm.query.Select;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Completable;
import rx.Emitter.BackpressureMode;
import rx.Observable;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class ChatHistoryDatastore
{
  private static final String FIELD_CONVERSATION_ID = "conversation_id";
  private static final String FIELD_MESSAGE_ID = "message_id";
  private static final String FIELD_TIMESTAMP = "timestamp";
  private static final long MESSAGE_LIFETIME = TimeUnit.DAYS.toMillis(28L);
  private static final String TAG = ChatHistoryDatastore.class.getSimpleName();
  private static final String WHERE_CONVERSATION_ID_EQUALS = "conversation_id = ?";
  private final Map<String, Double> hiddenConversations = new HashMap();
  
  private void doDeleteConversation(String paramString)
  {
    Log.v(TAG, "doDeleteConversation conversationId=" + paramString);
    TextChatMessage.deleteAll(TextChatMessage.class, "conversation_id = ?", new String[] { paramString });
  }
  
  private void doDeleteConversations()
  {
    Log.v(TAG, "doDeleteConversations");
    TextChatMessage.deleteAll(TextChatMessage.class);
    HiddenConversation.deleteAll(HiddenConversation.class);
    this.hiddenConversations.clear();
  }
  
  private void doDeleteHiddenConversation(String paramString)
  {
    Log.v(TAG, "doDeleteHiddenConversation conversationId=" + paramString);
    synchronized (this.hiddenConversations)
    {
      this.hiddenConversations.remove(paramString);
      HiddenConversation.deleteAll(HiddenConversation.class, "conversation_id = ?", new String[] { paramString });
      return;
    }
  }
  
  private void doDeleteMessage(QualifiedMessageId paramQualifiedMessageId)
  {
    Log.v(TAG, "doDeleteMessage qualifiedMessageId=" + paramQualifiedMessageId);
    paramQualifiedMessageId = findMessage(paramQualifiedMessageId);
    if (paramQualifiedMessageId != null) {
      paramQualifiedMessageId.delete();
    }
  }
  
  private void doHideConversation(TextChatMessage arg1)
  {
    String str = ???.getConversationId();
    double d = ???.getTimestamp();
    Log.v(TAG, "doHideConversation conversationId=" + str + ", timestamp=" + d);
    synchronized (this.hiddenConversations)
    {
      this.hiddenConversations.put(str, Double.valueOf(d));
      new HiddenConversation(str, d).save();
      return;
    }
  }
  
  private void doMessageSent(Pair<QualifiedMessageId, TextChatMessage> paramPair)
  {
    Log.v(TAG, "doMessageSent qualifiedMessageId=" + paramPair.first + ", message=" + paramPair.second);
    TextChatMessage localTextChatMessage = findMessage((QualifiedMessageId)paramPair.first);
    if (localTextChatMessage != null)
    {
      ((TextChatMessage)paramPair.second).setId(localTextChatMessage.getId());
      ((TextChatMessage)paramPair.second).save();
    }
  }
  
  private void doSaveMessage(TextChatMessage paramTextChatMessage)
  {
    Log.v(TAG, "doSaveMessage textMessage=" + paramTextChatMessage);
    if (findMessage(paramTextChatMessage.getQualifiedMessageId()) == null) {
      paramTextChatMessage.save();
    }
  }
  
  private TextChatMessage findMessage(QualifiedMessageId paramQualifiedMessageId)
  {
    Log.v(TAG, "findMessage qualifiedMessageId=" + paramQualifiedMessageId);
    return (TextChatMessage)Select.from(TextChatMessage.class).where(new Condition[] { Condition.prop("conversation_id").eq(paramQualifiedMessageId.getConversationId()) }).and(new Condition[] { Condition.prop("message_id").eq(paramQualifiedMessageId.getMessageId()) }).limit("1").first();
  }
  
  private List<String> getHiddenConversationIds()
  {
    synchronized (this.hiddenConversations)
    {
      ArrayList localArrayList = new ArrayList(this.hiddenConversations.keySet());
      return localArrayList;
    }
  }
  
  private boolean isConversationVisible(TextChatMessage paramTextChatMessage)
  {
    Object localObject = paramTextChatMessage.getConversationId();
    synchronized (this.hiddenConversations)
    {
      localObject = (Double)this.hiddenConversations.get(localObject);
      if (localObject == null) {
        return true;
      }
    }
    if (((Double)localObject).doubleValue() < paramTextChatMessage.getTimestamp())
    {
      doDeleteHiddenConversation(paramTextChatMessage.getConversationId());
      return true;
    }
    return false;
  }
  
  private void populateHiddenConversations()
  {
    try
    {
      synchronized (this.hiddenConversations)
      {
        Iterator localIterator = HiddenConversation.listAll(HiddenConversation.class).iterator();
        if (localIterator.hasNext())
        {
          HiddenConversation localHiddenConversation = (HiddenConversation)localIterator.next();
          this.hiddenConversations.put(localHiddenConversation.getConversationId(), Double.valueOf(localHiddenConversation.getLastTimestamp()));
        }
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e(TAG, "populateHiddenConversations error", localRuntimeException);
      return;
    }
  }
  
  private void pruneChatHistory()
  {
    try
    {
      TextChatMessage.deleteAll(TextChatMessage.class, "timestamp <= ?", new String[] { String.valueOf(ChatMessage.createTimestamp() - MESSAGE_LIFETIME) });
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e(TAG, "pruneChatHistory error", localRuntimeException);
    }
  }
  
  private <T> Observable<T> query(Class<T> paramClass, String paramString)
  {
    return Observable.create(ChatHistoryDatastore..Lambda.17.lambdaFactory$(paramClass, paramString), Emitter.BackpressureMode.BUFFER);
  }
  
  private Completable run(Action0 paramAction0)
  {
    return Completable.create(ChatHistoryDatastore..Lambda.18.lambdaFactory$(paramAction0));
  }
  
  private <T> Observable<T> select(Select<T> paramSelect)
  {
    return Observable.create(ChatHistoryDatastore..Lambda.16.lambdaFactory$(paramSelect), Emitter.BackpressureMode.BUFFER);
  }
  
  public Completable deleteChatHistory(String paramString)
  {
    Log.v(TAG, "deleteChatHistory conversationId=" + paramString);
    return run(ChatHistoryDatastore..Lambda.10.lambdaFactory$(this, paramString));
  }
  
  public Observable<TextChatMessage> getChatHistory(String paramString)
  {
    Log.v(TAG, "getChatHistory conversationId=" + paramString);
    return select(Select.from(TextChatMessage.class).where(new Condition[] { Condition.prop("conversation_id").eq(paramString) }).orderBy("timestamp"));
  }
  
  public Observable<String> getHiddenConversations()
  {
    Log.d(TAG, "getHiddenConversations");
    return Observable.create(ChatHistoryDatastore..Lambda.15.lambdaFactory$(this), Emitter.BackpressureMode.BUFFER);
  }
  
  public Observable<TextChatMessage> getNewestMessage(String paramString)
  {
    Log.d(TAG, "getNewestMessage conversationId=" + paramString);
    return select(Select.from(TextChatMessage.class).where(new Condition[] { Condition.prop("conversation_id").eq(paramString) }).orderBy("timestamp DESC").limit("1")).filter(ChatHistoryDatastore..Lambda.14.lambdaFactory$(this));
  }
  
  public Observable<TextChatMessage> getNewestMessages()
  {
    Log.v(TAG, "getNewestMessages");
    return query(TextChatMessage.class, "select * from text_chat_message where timestamp = (select max(timestamp) from text_chat_message as t where t.conversation_id = text_chat_message.conversation_id);").filter(ChatHistoryDatastore..Lambda.12.lambdaFactory$(this));
  }
  
  public Observable<TextChatMessage> getOldestMessage(String paramString)
  {
    Log.d(TAG, "getOldestMessage conversationId=" + paramString);
    return select(Select.from(TextChatMessage.class).where(new Condition[] { Condition.prop("conversation_id").eq(paramString) }).orderBy("timestamp").limit("1")).filter(ChatHistoryDatastore..Lambda.13.lambdaFactory$(this));
  }
  
  public Observable<TextChatMessage> getOldestMessages()
  {
    Log.v(TAG, "getOldestMessages");
    return query(TextChatMessage.class, "select * from text_chat_message where timestamp = (select min(timestamp) from text_chat_message as t where t.conversation_id = text_chat_message.conversation_id);").filter(ChatHistoryDatastore..Lambda.11.lambdaFactory$(this));
  }
  
  public Completable initializeDatastore()
  {
    return run(ChatHistoryDatastore..Lambda.1.lambdaFactory$(this));
  }
  
  public void setChatHistoryProvider(ChatHistoryProvider paramChatHistoryProvider)
  {
    Log.d(TAG, "setChatHistoryProvider");
    paramChatHistoryProvider.onChatHistoryReceived().observeOn(Schedulers.io()).subscribe(ChatHistoryDatastore..Lambda.2.lambdaFactory$(this));
    paramChatHistoryProvider.onLatestMessagesReceived().observeOn(Schedulers.io()).subscribe(ChatHistoryDatastore..Lambda.3.lambdaFactory$(this));
  }
  
  public void setConversationProvider(ConversationProvider paramConversationProvider)
  {
    Log.d(TAG, "setConversationProvider");
    paramConversationProvider.onConversationsDeleted().observeOn(Schedulers.io()).subscribe(ChatHistoryDatastore..Lambda.4.lambdaFactory$(this));
    paramConversationProvider.onConversationHidden().observeOn(Schedulers.io()).flatMap(ChatHistoryDatastore..Lambda.5.lambdaFactory$(this)).subscribe(ChatHistoryDatastore..Lambda.6.lambdaFactory$(this));
    paramConversationProvider.onMessageCreated().observeOn(Schedulers.io()).subscribe(ChatHistoryDatastore..Lambda.7.lambdaFactory$(this));
    paramConversationProvider.onMessageDeleted().observeOn(Schedulers.io()).subscribe(ChatHistoryDatastore..Lambda.8.lambdaFactory$(this));
    paramConversationProvider.onMessageSent().observeOn(Schedulers.io()).subscribe(ChatHistoryDatastore..Lambda.9.lambdaFactory$(this));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/datastores/ChatHistoryDatastore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */