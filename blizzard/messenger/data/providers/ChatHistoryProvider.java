package com.blizzard.messenger.data.providers;

import android.support.annotation.NonNull;
import android.util.Log;
import com.blizzard.messenger.data.listeners.ConnectionCreationListener;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.utils.ChatUtils;
import com.blizzard.messenger.data.utils.JIDUtils;
import com.blizzard.messenger.data.utils.TransactionManager;
import com.blizzard.messenger.data.xmpp.iq.ActiveChatMessagesIQ;
import com.blizzard.messenger.data.xmpp.iq.ChatHistoryIQ;
import com.blizzard.messenger.data.xmpp.iq.ConversationAcknowledgementIQ;
import com.blizzard.messenger.data.xmpp.iq.RequestChatHistoryIQ.Builder;
import com.blizzard.messenger.data.xmpp.model.Conversation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.subjects.PublishSubject;

public class ChatHistoryProvider
{
  private static final String TAG = ChatHistoryProvider.class.getSimpleName();
  private final TransactionManager<Void, String> acknowledgementRequests = new TransactionManager(ChatHistoryProvider..Lambda.3.lambdaFactory$(this));
  private final PublishSubject<List<TextChatMessage>> activeMessagesSubject = PublishSubject.create();
  private final TransactionManager<List<TextChatMessage>, Void> activeRequests = new TransactionManager(ChatHistoryProvider..Lambda.2.lambdaFactory$(this));
  private final PublishSubject<List<TextChatMessage>> chatHistorySubject = PublishSubject.create();
  private XMPPConnection connection;
  private final PublishSubject<String> conversationSeenSubject = PublishSubject.create();
  private final PublishSubject<String> conversationUnseenSubject = PublishSubject.create();
  private final TransactionManager<List<TextChatMessage>, String> historyRequests = new TransactionManager(ChatHistoryProvider..Lambda.1.lambdaFactory$(this));
  
  public ChatHistoryProvider()
  {
    ConnectionCreationListener.onConnectionCreated().subscribe(ChatHistoryProvider..Lambda.4.lambdaFactory$(this));
  }
  
  private static boolean isConversationSeen(@NonNull Conversation paramConversation)
  {
    return paramConversation.getLastCheckedAt() >= paramConversation.getLastMessageReceivedAt();
  }
  
  private void processAcknowledgementPacket(Stanza paramStanza)
  {
    Log.d(TAG, "processAcknowledgementPacket stanzaId=" + paramStanza.getStanzaId());
    String str = (String)this.acknowledgementRequests.getContext(paramStanza.getStanzaId());
    if (this.acknowledgementRequests.completeTransaction(paramStanza, null)) {
      this.conversationSeenSubject.onNext(str);
    }
  }
  
  private void processActiveMessagesPacket(ActiveChatMessagesIQ paramActiveChatMessagesIQ)
  {
    Log.d(TAG, "processActiveMessagesPacket stanzaId=" + paramActiveChatMessagesIQ.getStanzaId());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramActiveChatMessagesIQ.getConversations().iterator();
    while (localIterator1.hasNext())
    {
      Conversation localConversation = (Conversation)localIterator1.next();
      String str = localConversation.getFriendJid();
      Iterator localIterator2 = localConversation.getMessages().iterator();
      while (localIterator2.hasNext())
      {
        Message localMessage = (Message)localIterator2.next();
        localArrayList.add(ChatUtils.toTextChatMessage(localMessage, str.equals(localMessage.getTo()), "com.blizzard.messenger.ACTIVE"));
      }
      updateSeenConversations(localConversation);
    }
    if (this.activeRequests.completeTransaction(paramActiveChatMessagesIQ, localArrayList)) {
      this.activeMessagesSubject.onNext(localArrayList);
    }
  }
  
  private void processChatHistoryPacket(ChatHistoryIQ paramChatHistoryIQ)
  {
    Log.d(TAG, "processChatHistoryPacket stanzaId=" + paramChatHistoryIQ.getStanzaId());
    ArrayList localArrayList = new ArrayList();
    Conversation localConversation = paramChatHistoryIQ.getConversation();
    if (localConversation != null)
    {
      String str = localConversation.getFriendJid();
      Iterator localIterator = localConversation.getMessages().iterator();
      while (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        localArrayList.add(ChatUtils.toTextChatMessage(localMessage, str.equals(localMessage.getTo()), "com.blizzard.messenger.HISTORY"));
      }
      updateSeenConversations(localConversation);
    }
    if (this.historyRequests.completeTransaction(paramChatHistoryIQ, localArrayList)) {
      this.chatHistorySubject.onNext(localArrayList);
    }
  }
  
  /* Error */
  private void updateSeenConversations(@NonNull Conversation paramConversation)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 185	com/blizzard/messenger/data/xmpp/model/Conversation:getFriendJid	()Ljava/lang/String;
    //   6: invokestatic 229	com/blizzard/messenger/data/utils/JIDUtils:getLocal	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_2
    //   10: aload_1
    //   11: invokestatic 231	com/blizzard/messenger/data/providers/ChatHistoryProvider:isConversationSeen	(Lcom/blizzard/messenger/data/xmpp/model/Conversation;)Z
    //   14: ifeq +14 -> 28
    //   17: aload_0
    //   18: getfield 71	com/blizzard/messenger/data/providers/ChatHistoryProvider:conversationSeenSubject	Lrx/subjects/PublishSubject;
    //   21: aload_2
    //   22: invokevirtual 154	rx/subjects/PublishSubject:onNext	(Ljava/lang/Object;)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 73	com/blizzard/messenger/data/providers/ChatHistoryProvider:conversationUnseenSubject	Lrx/subjects/PublishSubject;
    //   32: aload_2
    //   33: invokevirtual 154	rx/subjects/PublishSubject:onNext	(Ljava/lang/Object;)V
    //   36: goto -11 -> 25
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ChatHistoryProvider
    //   0	44	1	paramConversation	Conversation
    //   9	24	2	str	String
    // Exception table:
    //   from	to	target	type
    //   2	25	39	finally
    //   28	36	39	finally
  }
  
  public Completable acknowledgeConversationSeen(@NonNull String paramString)
  {
    ConversationAcknowledgementIQ localConversationAcknowledgementIQ = new ConversationAcknowledgementIQ(JIDUtils.buildJID(this.connection, paramString));
    return this.acknowledgementRequests.startTransaction(localConversationAcknowledgementIQ, paramString).toCompletable();
  }
  
  public Observable<TextChatMessage> getChatHistory(String paramString, int paramInt, double paramDouble, long paramLong)
  {
    Object localObject = JIDUtils.buildJID(this.connection, paramString);
    localObject = new RequestChatHistoryIQ.Builder().friendJid((String)localObject).limit(paramInt).before(paramDouble).after(paramLong).build();
    return this.historyRequests.startTransaction((Stanza)localObject, paramString).toObservable().flatMapIterable(ChatHistoryProvider..Lambda.5.lambdaFactory$());
  }
  
  public Observable<TextChatMessage> getLatestMessages()
  {
    ActiveChatMessagesIQ localActiveChatMessagesIQ = new ActiveChatMessagesIQ();
    return this.activeRequests.startTransaction(localActiveChatMessagesIQ, null).toObservable().flatMapIterable(ChatHistoryProvider..Lambda.7.lambdaFactory$());
  }
  
  public Observable<TextChatMessage> onChatHistoryReceived()
  {
    return this.chatHistorySubject.flatMapIterable(ChatHistoryProvider..Lambda.6.lambdaFactory$());
  }
  
  public Observable<String> onConversationSeen()
  {
    return this.conversationSeenSubject;
  }
  
  public Observable<String> onConversationUnseen()
  {
    return this.conversationUnseenSubject;
  }
  
  public Observable<TextChatMessage> onLatestMessagesReceived()
  {
    return this.activeMessagesSubject.flatMapIterable(ChatHistoryProvider..Lambda.8.lambdaFactory$());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/ChatHistoryProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */