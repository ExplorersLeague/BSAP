package com.blizzard.messenger.adapter;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blizzard.messenger.data.model.chat.ChatMessage;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.model.ChatErrorOption;
import com.blizzard.messenger.model.DateMessage;
import com.blizzard.messenger.utils.AnimUtils;
import com.blizzard.messenger.utils.ColorUtils;
import com.blizzard.messenger.utils.StringUtils;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class TextMessageViewHolder
  extends MessageViewHolder
{
  private final LinearLayout bubbleLayout;
  private final RelativeLayout chatControlsLayout;
  private final Observer<TextChatMessage> clickedObserver;
  private final Context context;
  private final Observer<ChatErrorOption> errorMenuClickedObserver;
  private final Observer<String> linkClickedObserver;
  private final Observer<TextChatMessage> longClickedObserver;
  private final TextView messageTextView;
  private final LinearLayout messageTimestampLayout;
  private final TextView messageTimestampTextView;
  private final RelativeLayout parentLinearLayout;
  private final ImageView sendErrorImageView;
  private final LottieAnimationView sendingImageView;
  private Subscription sub;
  private final Observer<TextChatMessage> updatedObserver;
  private final LinearLayout wrapperLinearLayout;
  
  private TextMessageViewHolder(Builder paramBuilder)
  {
    super(paramBuilder.itemView);
    this.context = paramBuilder.context;
    this.updatedObserver = paramBuilder.updatedObserver;
    this.clickedObserver = paramBuilder.clickedObserver;
    this.linkClickedObserver = paramBuilder.linkClickedObserver;
    this.longClickedObserver = paramBuilder.longClickedObserver;
    this.errorMenuClickedObserver = paramBuilder.errorMenuClickedObserver;
    this.sendingImageView = ((LottieAnimationView)this.itemView.findViewById(2131820712));
    this.sendErrorImageView = ((ImageView)this.itemView.findViewById(2131820711));
    this.chatControlsLayout = ((RelativeLayout)this.itemView.findViewById(2131820709));
    this.bubbleLayout = ((LinearLayout)this.itemView.findViewById(2131820713));
    this.wrapperLinearLayout = ((LinearLayout)this.itemView.findViewById(2131820710));
    this.parentLinearLayout = ((RelativeLayout)this.itemView.findViewById(2131820566));
    this.messageTimestampLayout = ((LinearLayout)this.itemView.findViewById(2131820715));
    this.messageTextView = ((TextView)this.itemView.findViewById(2131820714));
    this.messageTimestampTextView = ((TextView)this.itemView.findViewById(2131820716));
  }
  
  private void onSendErrorClicked(View paramView, TextChatMessage paramTextChatMessage)
  {
    paramView = new PopupMenu(this.context, paramView);
    paramView.inflate(2131886086);
    paramView.setOnMenuItemClickListener(TextMessageViewHolder..Lambda.7.lambdaFactory$(this, paramTextChatMessage));
    paramView.show();
  }
  
  private void setupChatControls(TextChatMessage paramTextChatMessage)
  {
    String str = paramTextChatMessage.getType();
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        this.sendingImageView.setVisibility(8);
        this.sendErrorImageView.setVisibility(8);
        updateSendingAnimation();
        return;
        if (str.equals("com.blizzard.messenger.UNSENT"))
        {
          i = 0;
          continue;
          if (str.equals("com.blizzard.messenger.SEND_FAILED")) {
            i = 1;
          }
        }
        break;
      }
    }
    updateSendingState(paramTextChatMessage);
    return;
    this.sendingImageView.setVisibility(8);
    this.sendErrorImageView.setVisibility(0);
    updateSendingAnimation();
  }
  
  private void setupMyChatBubble(MessageViewHolder.ViewSetup paramViewSetup)
  {
    this.parentLinearLayout.setGravity(8388613);
    int i;
    if ((paramViewSetup.previousChatMessage == null) || ((paramViewSetup.previousChatMessage instanceof DateMessage)) || (!paramViewSetup.previousChatMessage.isMine()))
    {
      i = 1;
      if (i == 0) {
        break label152;
      }
      this.bubbleLayout.setBackgroundResource(ColorUtils.getChatBubbleMine(this.context));
    }
    for (;;)
    {
      paramViewSetup = (RelativeLayout.LayoutParams)this.wrapperLinearLayout.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.messageTimestampLayout.getLayoutParams();
      paramViewSetup.addRule(21);
      paramViewSetup.removeRule(20);
      localLayoutParams.addRule(21);
      localLayoutParams.removeRule(20);
      this.wrapperLinearLayout.setLayoutParams(paramViewSetup);
      this.messageTimestampLayout.setLayoutParams(localLayoutParams);
      this.messageTextView.setTextColor(ColorUtils.getTextColorConversationMine(this.context));
      this.messageTextView.setLinkTextColor(ColorUtils.getTextColorConversationMine(this.context));
      return;
      i = 0;
      break;
      label152:
      this.bubbleLayout.setBackgroundResource(ColorUtils.getChatBubbleMineNoTail(this.context));
    }
  }
  
  private void setupRecipientChatBubble(MessageViewHolder.ViewSetup paramViewSetup)
  {
    this.parentLinearLayout.setGravity(8388611);
    this.wrapperLinearLayout.setGravity(8388611);
    this.messageTimestampTextView.setGravity(8388611);
    int i;
    if ((paramViewSetup.previousChatMessage == null) || ((paramViewSetup.previousChatMessage instanceof DateMessage)) || (paramViewSetup.previousChatMessage.isMine()))
    {
      i = 1;
      if (i == 0) {
        break label154;
      }
      this.bubbleLayout.setBackgroundResource(ColorUtils.getChatBubbleRecipient(this.context));
    }
    for (;;)
    {
      paramViewSetup = (RelativeLayout.LayoutParams)this.wrapperLinearLayout.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.messageTimestampLayout.getLayoutParams();
      paramViewSetup.addRule(20);
      paramViewSetup.removeRule(21);
      localLayoutParams.addRule(20);
      localLayoutParams.removeRule(21);
      this.messageTextView.setTextColor(ColorUtils.getTextColorConversationRecipient(this.context));
      this.messageTextView.setLinkTextColor(ColorUtils.getTextColorConversationRecipient(this.context));
      return;
      i = 0;
      break;
      label154:
      this.bubbleLayout.setBackgroundResource(ColorUtils.getChatBubbleRecipientNoTail(this.context));
    }
  }
  
  private void setupTimestampView(TextChatMessage paramTextChatMessage, MessageViewHolder.ViewSetup paramViewSetup)
  {
    LinearLayout localLinearLayout = this.messageTimestampLayout;
    if (paramViewSetup.toggled) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      this.messageTimestampTextView.setText(StringUtils.getChatMessageTimestamp(this.context, paramTextChatMessage.getTimestamp()));
      return;
    }
  }
  
  private void toggleTimestampView()
  {
    AnimUtils.toggleViewRoll(this.messageTimestampLayout, 50, 300);
  }
  
  private void updateSendingAnimation()
  {
    int i;
    if (this.sendingImageView.getVisibility() == 0)
    {
      i = 1;
      if ((i == 0) || (this.sendingImageView.isAnimating())) {
        break label39;
      }
      this.sendingImageView.playAnimation();
    }
    label39:
    while ((i != 0) || (!this.sendingImageView.isAnimating()))
    {
      return;
      i = 0;
      break;
    }
    this.sendingImageView.cancelAnimation();
  }
  
  private void updateSendingState(TextChatMessage paramTextChatMessage)
  {
    long l = ChatMessage.createTimestamp();
    double d2 = 2000.0D + paramTextChatMessage.getTimestamp();
    double d3 = 10000.0D + paramTextChatMessage.getTimestamp();
    double d1 = 0.0D;
    if (l >= d3)
    {
      this.sendingImageView.setVisibility(8);
      this.sendErrorImageView.setVisibility(0);
    }
    for (;;)
    {
      updateSendingAnimation();
      if ((d1 > 0.0D) && (this.sub == null)) {
        this.sub = Observable.timer(Double.valueOf(d1).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).retry().subscribe(TextMessageViewHolder..Lambda.6.lambdaFactory$(this, paramTextChatMessage));
      }
      return;
      if (l >= d2)
      {
        d1 = d3 - l;
        this.sendingImageView.setVisibility(0);
        this.sendErrorImageView.setVisibility(8);
      }
      else
      {
        d1 = d2 - l;
        this.sendErrorImageView.setVisibility(8);
        this.sendingImageView.setVisibility(8);
      }
    }
  }
  
  public void onViewHide()
  {
    if (this.sub != null) {
      this.sub.unsubscribe();
    }
  }
  
  public void setupView(MessageViewHolder.ViewSetup paramViewSetup)
  {
    TextChatMessage localTextChatMessage = (TextChatMessage)paramViewSetup.chatMessage;
    this.messageTextView.setVisibility(0);
    this.messageTextView.setText(localTextChatMessage.getBody());
    if (localTextChatMessage.isMine()) {
      setupMyChatBubble(paramViewSetup);
    }
    for (;;)
    {
      setupTimestampView(localTextChatMessage, paramViewSetup);
      setupChatControls(localTextChatMessage);
      this.sendErrorImageView.setOnClickListener(TextMessageViewHolder..Lambda.1.lambdaFactory$(this, localTextChatMessage));
      this.messageTextView.setMovementMethod(new LinkMovementMethod()
      {
        public boolean onTouchEvent(TextView paramAnonymousTextView, Spannable paramAnonymousSpannable, MotionEvent paramAnonymousMotionEvent)
        {
          boolean bool = true;
          if (paramAnonymousMotionEvent.getAction() != 1) {
            bool = super.onTouchEvent(paramAnonymousTextView, paramAnonymousSpannable, paramAnonymousMotionEvent);
          }
          do
          {
            return bool;
            int i = (int)paramAnonymousMotionEvent.getX();
            int j = (int)paramAnonymousMotionEvent.getY();
            int k = paramAnonymousTextView.getTotalPaddingLeft();
            int m = paramAnonymousTextView.getTotalPaddingTop();
            int n = paramAnonymousTextView.getScrollX();
            int i1 = paramAnonymousTextView.getScrollY();
            paramAnonymousTextView = paramAnonymousTextView.getLayout();
            i = paramAnonymousTextView.getOffsetForHorizontal(paramAnonymousTextView.getLineForVertical(j - m + i1), i - k + n);
            paramAnonymousTextView = (URLSpan[])paramAnonymousSpannable.getSpans(i, i, URLSpan.class);
          } while (paramAnonymousTextView.length == 0);
          TextMessageViewHolder.this.linkClickedObserver.onNext(paramAnonymousTextView[0].getURL());
          return true;
        }
      });
      this.messageTextView.setOnClickListener(TextMessageViewHolder..Lambda.2.lambdaFactory$(this, localTextChatMessage));
      this.bubbleLayout.setOnClickListener(TextMessageViewHolder..Lambda.3.lambdaFactory$(this, localTextChatMessage));
      this.bubbleLayout.setOnLongClickListener(TextMessageViewHolder..Lambda.4.lambdaFactory$(this, localTextChatMessage));
      this.messageTextView.setOnLongClickListener(TextMessageViewHolder..Lambda.5.lambdaFactory$(this, localTextChatMessage));
      return;
      setupRecipientChatBubble(paramViewSetup);
    }
  }
  
  public static class Builder
  {
    private Observer<TextChatMessage> clickedObserver;
    private Context context;
    private Observer<ChatErrorOption> errorMenuClickedObserver;
    private View itemView;
    private Observer<String> linkClickedObserver;
    private Observer<TextChatMessage> longClickedObserver;
    private Observer<TextChatMessage> updatedObserver;
    
    public TextMessageViewHolder build()
    {
      return new TextMessageViewHolder(this, null);
    }
    
    public Builder clickedObserver(Observer<TextChatMessage> paramObserver)
    {
      this.clickedObserver = paramObserver;
      return this;
    }
    
    public Builder context(Context paramContext)
    {
      this.context = paramContext;
      return this;
    }
    
    public Builder errorMenuClickedObserver(Observer<ChatErrorOption> paramObserver)
    {
      this.errorMenuClickedObserver = paramObserver;
      return this;
    }
    
    public Builder itemView(View paramView)
    {
      this.itemView = paramView;
      return this;
    }
    
    public Builder linkClickedObserver(Observer<String> paramObserver)
    {
      this.linkClickedObserver = paramObserver;
      return this;
    }
    
    public Builder longClickedObserver(Observer<TextChatMessage> paramObserver)
    {
      this.longClickedObserver = paramObserver;
      return this;
    }
    
    public Builder updatedObserver(Observer<TextChatMessage> paramObserver)
    {
      this.updatedObserver = paramObserver;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/TextMessageViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */