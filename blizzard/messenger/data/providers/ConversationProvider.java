package com.blizzard.messenger.data.providers;

import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.messenger.data.listeners.ConnectionCreationListener;
import com.blizzard.messenger.data.model.chat.ChatMessage;
import com.blizzard.messenger.data.model.chat.QualifiedMessageId;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.chat.TextChatMessage.Builder;
import com.blizzard.messenger.data.utils.ChatUtils;
import com.blizzard.messenger.data.utils.JIDUtils;
import com.blizzard.messenger.data.utils.StringFormatUtils;
import com.blizzard.messenger.data.utils.TransactionManager;
import com.blizzard.messenger.data.xmpp.extension.BlizzardDeliveryReceipt;
import com.blizzard.messenger.data.xmpp.extension.CarbonExtension;
import com.blizzard.messenger.data.xmpp.extension.MessageExtension.Builder;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Type;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.chatstates.ChatState;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.jivesoftware.smackx.receipts.ReceiptReceivedListener;
import rx.Observable;
import rx.Single;
import rx.subjects.PublishSubject;

public class ConversationProvider
  implements ChatManagerListener, ChatMessageListener, ReceiptReceivedListener
{
  private static final String TAG = ConversationProvider.class.getSimpleName();
  private ChatManager chatManager;
  private final PublishSubject<Pair<String, String>> chatStateChangedSubject = PublishSubject.create();
  private XMPPConnection connection;
  private final PublishSubject<String> conversationHiddenSubject = PublishSubject.create();
  private final PublishSubject<Void> conversationsDeletedSubject = PublishSubject.create();
  private final PublishSubject<TextChatMessage> messageCreatedSubject = PublishSubject.create();
  private final PublishSubject<QualifiedMessageId> messageDeletedSubject = PublishSubject.create();
  private final PublishSubject<Pair<QualifiedMessageId, TextChatMessage>> messageSentSubject = PublishSubject.create();
  private Chat outgoingChat;
  private final TransactionManager<String, String> sentChatStates = new TransactionManager(ConversationProvider..Lambda.3.lambdaFactory$(this));
  private final TransactionManager<TextChatMessage, TextChatMessage> sentMessages = new TransactionManager(ConversationProvider..Lambda.1.lambdaFactory$(this), ConversationProvider..Lambda.2.lambdaFactory$(this));
  
  public ConversationProvider()
  {
    ConnectionCreationListener.onConnectionCreated().subscribe(ConversationProvider..Lambda.4.lambdaFactory$(this));
  }
  
  private TextChatMessage handleMessageError(Throwable paramThrowable, String paramString, Stanza paramStanza, TextChatMessage paramTextChatMessage)
  {
    paramThrowable = paramTextChatMessage.newBuilder().type("com.blizzard.messenger.SEND_FAILED").build();
    this.messageSentSubject.onNext(Pair.create(paramTextChatMessage.getQualifiedMessageId(), paramThrowable));
    return null;
  }
  
  private void processCarbon(Message paramMessage)
  {
    paramMessage = (CarbonExtension)paramMessage.getExtension("urn:xmpp:carbons:2");
    if ((paramMessage != null) && (paramMessage.getForwarded() != null) && ((paramMessage.getForwarded().getForwardedPacket() instanceof Message)))
    {
      paramMessage = ChatUtils.toTextChatMessage((Message)paramMessage.getForwarded().getForwardedPacket(), true, "com.blizzard.messenger.SENT");
      this.messageCreatedSubject.onNext(paramMessage);
    }
  }
  
  private void processChatError(Message paramMessage)
  {
    this.sentMessages.completeTransaction(paramMessage, null);
  }
  
  private void processChatMessage(Message paramMessage)
  {
    if (!TextUtils.isEmpty(paramMessage.getBody()))
    {
      paramMessage = ChatUtils.toTextChatMessage(paramMessage, false, "com.blizzard.messenger.RECEIVED");
      this.messageCreatedSubject.onNext(paramMessage);
    }
  }
  
  private void processChatMessageReceipt(Stanza paramStanza, BlizzardDeliveryReceipt paramBlizzardDeliveryReceipt)
  {
    TextChatMessage localTextChatMessage = (TextChatMessage)this.sentMessages.getContext(paramBlizzardDeliveryReceipt.getId());
    if (localTextChatMessage != null)
    {
      localTextChatMessage = ChatUtils.toTextChatMessage(localTextChatMessage, paramBlizzardDeliveryReceipt);
      if (this.sentMessages.completeTransaction(paramBlizzardDeliveryReceipt.getId(), paramStanza, localTextChatMessage)) {
        this.messageSentSubject.onNext(Pair.create(new QualifiedMessageId(localTextChatMessage.getConversationId(), paramBlizzardDeliveryReceipt.getId()), localTextChatMessage));
      }
    }
  }
  
  private void processChatState(Chat paramChat, Message paramMessage)
  {
    paramMessage = paramMessage.getExtension("http://jabber.org/protocol/chatstates");
    if (paramMessage != null)
    {
      paramMessage = ChatUtils.getChatTypingState(ChatState.valueOf(paramMessage.getElementName()));
      paramChat = JIDUtils.getLocal(paramChat.getParticipant());
      this.chatStateChangedSubject.onNext(new Pair(paramChat, paramMessage));
    }
  }
  
  private void processChatStateReceipt(Stanza paramStanza, BlizzardDeliveryReceipt paramBlizzardDeliveryReceipt)
  {
    String str = (String)this.sentChatStates.getContext(paramBlizzardDeliveryReceipt.getId());
    if (str != null) {
      this.sentChatStates.completeTransaction(paramBlizzardDeliveryReceipt.getId(), paramStanza, str);
    }
  }
  
  private void sendChatStateStanza(Stanza paramStanza, String paramString)
    throws SmackException
  {
    this.outgoingChat.sendMessage((Message)paramStanza);
    this.sentChatStates.completeTransaction(paramStanza, paramString);
  }
  
  private void sendMessageStanza(Stanza paramStanza, TextChatMessage paramTextChatMessage)
    throws Exception
  {
    this.outgoingChat.sendMessage((Message)paramStanza);
  }
  
  private void setOutgoingChat(String paramString)
  {
    paramString = JIDUtils.buildJID(this.connection, paramString);
    if ((this.outgoingChat == null) || (!this.outgoingChat.getParticipant().equals(paramString))) {
      this.outgoingChat = this.chatManager.createChat(paramString, this);
    }
  }
  
  public void chatCreated(Chat paramChat, boolean paramBoolean)
  {
    paramChat.addMessageListener(this);
  }
  
  public void deleteConversations()
  {
    this.conversationsDeletedSubject.onNext(null);
  }
  
  public void deleteMessage(QualifiedMessageId paramQualifiedMessageId)
  {
    this.messageDeletedSubject.onNext(paramQualifiedMessageId);
  }
  
  public void hideConversation(String paramString)
  {
    this.conversationHiddenSubject.onNext(paramString);
  }
  
  public Observable<Pair<String, String>> onChatStateChanged()
  {
    return this.chatStateChangedSubject;
  }
  
  public Observable<String> onConversationHidden()
  {
    return this.conversationHiddenSubject;
  }
  
  public Observable<Void> onConversationsDeleted()
  {
    return this.conversationsDeletedSubject;
  }
  
  public Observable<TextChatMessage> onMessageCreated()
  {
    return this.messageCreatedSubject;
  }
  
  public Observable<QualifiedMessageId> onMessageDeleted()
  {
    return this.messageDeletedSubject;
  }
  
  public Observable<Pair<QualifiedMessageId, TextChatMessage>> onMessageSent()
  {
    return this.messageSentSubject;
  }
  
  public void onReceiptReceived(String paramString1, String paramString2, String paramString3, Stanza paramStanza)
  {
    Log.d(TAG, "onReceiptReceived: fromJid=" + paramString1 + ", toJid=" + paramString2 + ", receiptId=" + paramString3);
    paramString1 = BlizzardDeliveryReceipt.from((Message)paramStanza);
    if (paramString1 != null)
    {
      processChatMessageReceipt(paramStanza, paramString1);
      processChatStateReceipt(paramStanza, paramString1);
    }
  }
  
  public void processMessage(Chat paramChat, Message paramMessage)
  {
    processChatState(paramChat, paramMessage);
    processCarbon(paramMessage);
    switch (paramMessage.getType())
    {
    default: 
      return;
    case ???: 
    case ???: 
      processChatMessage(paramMessage);
      return;
    }
    processChatError(paramMessage);
  }
  
  public Single<TextChatMessage> sendWhisper(String paramString1, String paramString2)
  {
    setOutgoingChat(paramString1);
    paramString2 = StringFormatUtils.formatMessageBody(paramString2);
    paramString1 = new TextChatMessage.Builder().conversationId(paramString1).timestamp(ChatMessage.createTimestamp()).sender(JIDUtils.getLocal(this.connection.getUser())).receiver(paramString1).body(paramString2).isMine(true).type("com.blizzard.messenger.UNSENT").build();
    paramString2 = new Message();
    paramString2.setType(Message.Type.chat);
    paramString2.setBody(paramString1.getBody());
    paramString2.setStanzaId(paramString1.getMessageId());
    paramString2.addExtension(new MessageExtension.Builder().timestamp(paramString1.getTimestamp()).build());
    paramString2.addExtension(new DeliveryReceiptRequest());
    this.messageCreatedSubject.onNext(paramString1);
    return this.sentMessages.startTransaction(paramString2, paramString1);
  }
  
  public Single<String> setChatState(String paramString1, String paramString2)
  {
    setOutgoingChat(paramString1);
    paramString1 = new Message();
    paramString1.addExtension(new ChatStateExtension(ChatUtils.getChatState(paramString2)));
    paramString1.addExtension(new DeliveryReceiptRequest());
    return this.sentChatStates.startTransaction(paramString1, paramString2);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/ConversationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */