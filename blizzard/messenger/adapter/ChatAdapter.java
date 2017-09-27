package com.blizzard.messenger.adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blizzard.messenger.data.model.chat.ChatMessage;
import com.blizzard.messenger.data.model.chat.QualifiedMessageId;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.chat.UnfurlChatMessage;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.model.ChatErrorOption;
import com.blizzard.messenger.model.ChatViewModel;
import com.blizzard.messenger.model.DateMessage;
import com.blizzard.messenger.telemetry.Telemetry;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.subjects.PublishSubject;

public class ChatAdapter
  extends RecyclerView.Adapter<MessageViewHolder>
{
  public static final int ITEM_TYPE_DATE = 0;
  public static final int ITEM_TYPE_TEXT = 1;
  public static final int ITEM_TYPE_TYPING = 3;
  public static final int ITEM_TYPE_UNFURL = 2;
  private final Context context;
  private final PublishSubject<ChatErrorOption> sendErrorOptionClickedSubject = PublishSubject.create();
  private final PublishSubject<TextChatMessage> textMessageClickedSubject = PublishSubject.create();
  private final PublishSubject<String> textMessageLinkClickedSubject = PublishSubject.create();
  private final PublishSubject<TextChatMessage> textMessageLongClickedSubject = PublishSubject.create();
  private final PublishSubject<TextChatMessage> textMessageUpdatedSubject = PublishSubject.create();
  private TextToSpeech textToSpeech;
  private final Map<String, Boolean> toggleStates = new HashMap();
  private boolean typing = false;
  private final PublishSubject<UnfurlChatMessage> unfurlMessageClickedSubject = PublishSubject.create();
  private final PublishSubject<UnfurlChatMessage> unfurlMessageShareClickedSubject = PublishSubject.create();
  private final ChatViewModel viewModel = new ChatViewModel();
  
  public ChatAdapter(Context paramContext)
  {
    this.context = paramContext;
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    if (SharedPrefsUtils.isTextToSpeechEnabled(paramContext))
    {
      this.textToSpeech = new TextToSpeech(paramContext, ChatAdapter..Lambda.1.lambdaFactory$(this));
      this.textMessageClickedSubject.subscribe(ChatAdapter..Lambda.2.lambdaFactory$(this));
    }
    this.textMessageClickedSubject.subscribe(ChatAdapter..Lambda.3.lambdaFactory$(this));
    this.textMessageUpdatedSubject.subscribe(ChatAdapter..Lambda.4.lambdaFactory$(this));
  }
  
  private boolean getToggleState(String paramString)
  {
    paramString = (Boolean)this.toggleStates.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  private void moveToggleState(String paramString1, String paramString2)
  {
    paramString1 = (Boolean)this.toggleStates.remove(paramString1);
    if (paramString1 != null) {
      this.toggleStates.put(paramString2, paramString1);
    }
  }
  
  private void notifyChatMessageAdded(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      notifyItemRangeInserted(paramInt1, paramInt2);
      if (paramInt1 > 0) {
        notifyItemChanged(paramInt1 - 1);
      }
      if (paramInt1 + paramInt2 < this.viewModel.getChatMessageCount()) {
        notifyItemChanged(paramInt1 + paramInt2);
      }
    }
  }
  
  private void notifyChatMessageRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      notifyItemRangeRemoved(paramInt1, paramInt2);
      if (paramInt1 > 0) {
        notifyItemChanged(paramInt1 - 1);
      }
      if (paramInt1 < this.viewModel.getChatMessageCount()) {
        notifyItemChanged(paramInt1);
      }
    }
  }
  
  private void removeToggleState(String paramString)
  {
    this.toggleStates.remove(paramString);
  }
  
  private void updateToggleState(String paramString)
  {
    Map localMap = this.toggleStates;
    if (!getToggleState(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      localMap.put(paramString, Boolean.valueOf(bool));
      return;
    }
  }
  
  public void addChatMessage(ChatMessage paramChatMessage)
  {
    Pair localPair = this.viewModel.addChatMessage(paramChatMessage);
    notifyChatMessageAdded(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    if ((((Integer)localPair.first).intValue() >= 0) && ((paramChatMessage instanceof UnfurlChatMessage))) {
      Telemetry.unfurlLinkDisplayed(((UnfurlChatMessage)paramChatMessage).getUrl());
    }
  }
  
  public void clear()
  {
    if (this.viewModel.getChatMessageCount() > 0)
    {
      this.viewModel.clearChatMessages();
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    int j = this.viewModel.getChatMessageCount();
    if (this.typing) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.viewModel.getChatMessageCount())
    {
      ChatMessage localChatMessage = this.viewModel.getChatMessage(paramInt);
      if ((localChatMessage instanceof DateMessage)) {
        return 0;
      }
      if ((localChatMessage instanceof TextChatMessage)) {
        return 1;
      }
      if ((localChatMessage instanceof UnfurlChatMessage)) {
        return 2;
      }
    }
    else if (this.typing)
    {
      return 3;
    }
    return -1;
  }
  
  public void onBindViewHolder(MessageViewHolder paramMessageViewHolder, int paramInt)
  {
    if (paramInt < this.viewModel.getChatMessageCount())
    {
      localChatMessage = this.viewModel.getChatMessage(paramInt);
      if (localChatMessage != null) {
        paramMessageViewHolder.setupView(new MessageViewHolder.ViewSetup().chatMessage(localChatMessage).previousChatMessage(this.viewModel.getChatMessage(paramInt - 1)).nextChatMessage(this.viewModel.getChatMessage(paramInt + 1)).toggled(getToggleState(localChatMessage.getMessageId())));
      }
    }
    while (!this.typing)
    {
      ChatMessage localChatMessage;
      return;
    }
    paramMessageViewHolder.setupView(new MessageViewHolder.ViewSetup());
  }
  
  public MessageViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new DateMessageViewHolder(LayoutInflater.from(this.context).inflate(2130968618, paramViewGroup, false));
    case 1: 
      paramViewGroup = LayoutInflater.from(this.context).inflate(2130968610, paramViewGroup, false);
      return new TextMessageViewHolder.Builder().context(this.context).itemView(paramViewGroup).updatedObserver(this.textMessageUpdatedSubject).clickedObserver(this.textMessageClickedSubject).linkClickedObserver(this.textMessageLinkClickedSubject).longClickedObserver(this.textMessageLongClickedSubject).errorMenuClickedObserver(this.sendErrorOptionClickedSubject).build();
    case 2: 
      paramViewGroup = LayoutInflater.from(this.context).inflate(2130968612, paramViewGroup, false);
      return new UnfurlMessageViewHolder.Builder().context(this.context).itemView(paramViewGroup).clickedObserver(this.unfurlMessageClickedSubject).shareClickedObserver(this.unfurlMessageShareClickedSubject).build();
    }
    paramViewGroup = LayoutInflater.from(this.context).inflate(2130968611, paramViewGroup, false);
    return new TypingMessageViewHolder(this.context, paramViewGroup);
  }
  
  public Observable<ChatErrorOption> onSendErrorOptionClicked()
  {
    return this.sendErrorOptionClickedSubject;
  }
  
  public Observable<String> onTextLinkClicked()
  {
    return this.textMessageLinkClickedSubject;
  }
  
  public Observable<TextChatMessage> onTextLongClicked()
  {
    return this.textMessageLongClickedSubject;
  }
  
  public Observable<UnfurlChatMessage> onUnfurlClicked()
  {
    return this.unfurlMessageClickedSubject;
  }
  
  public Observable<UnfurlChatMessage> onUnfurlShareClicked()
  {
    return this.unfurlMessageShareClickedSubject;
  }
  
  public void onViewAttachedToWindow(MessageViewHolder paramMessageViewHolder)
  {
    paramMessageViewHolder.onViewShow();
  }
  
  public void onViewDetachedFromWindow(MessageViewHolder paramMessageViewHolder)
  {
    paramMessageViewHolder.onViewHide();
  }
  
  public void removeChatMessage(QualifiedMessageId paramQualifiedMessageId)
  {
    Pair localPair = this.viewModel.removeChatMessage(paramQualifiedMessageId);
    notifyChatMessageRemoved(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    if (((Integer)localPair.first).intValue() >= 0) {
      removeToggleState(paramQualifiedMessageId.getMessageId());
    }
  }
  
  public void replaceChatMessage(QualifiedMessageId paramQualifiedMessageId, ChatMessage paramChatMessage)
  {
    moveToggleState(paramQualifiedMessageId.getMessageId(), paramChatMessage.getMessageId());
    paramQualifiedMessageId = this.viewModel.removeChatMessage(paramQualifiedMessageId);
    Pair localPair = this.viewModel.addChatMessage(paramChatMessage);
    if (((Integer)paramQualifiedMessageId.first).equals(localPair.first)) {
      if (((Integer)paramQualifiedMessageId.first).intValue() >= 0) {
        notifyItemRangeChanged(((Integer)paramQualifiedMessageId.first).intValue(), Math.max(((Integer)paramQualifiedMessageId.second).intValue(), ((Integer)localPair.second).intValue()));
      }
    }
    for (;;)
    {
      if ((((Integer)localPair.first).intValue() >= 0) && ((paramChatMessage instanceof UnfurlChatMessage))) {
        Telemetry.unfurlLinkDisplayed(((UnfurlChatMessage)paramChatMessage).getUrl());
      }
      return;
      notifyChatMessageRemoved(((Integer)paramQualifiedMessageId.first).intValue(), ((Integer)paramQualifiedMessageId.second).intValue());
      notifyChatMessageAdded(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    }
  }
  
  public void setTyping(boolean paramBoolean)
  {
    if (this.typing != paramBoolean)
    {
      this.typing = paramBoolean;
      if (paramBoolean) {
        notifyItemInserted(this.viewModel.getChatMessageCount());
      }
    }
    else
    {
      return;
    }
    notifyItemRemoved(this.viewModel.getChatMessageCount());
  }
  
  public void shutdownTts()
  {
    if (this.textToSpeech != null)
    {
      this.textToSpeech.stop();
      this.textToSpeech.shutdown();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/ChatAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */