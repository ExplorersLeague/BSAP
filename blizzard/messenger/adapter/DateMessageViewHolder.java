package com.blizzard.messenger.adapter;

import android.view.View;
import android.widget.TextView;
import com.blizzard.messenger.data.model.chat.ChatMessage;
import com.blizzard.messenger.utils.StringUtils;

class DateMessageViewHolder
  extends MessageViewHolder
{
  private final TextView dateTextView;
  
  DateMessageViewHolder(View paramView)
  {
    super(paramView);
    this.dateTextView = ((TextView)paramView.findViewById(2131820745));
  }
  
  public void setupView(MessageViewHolder.ViewSetup paramViewSetup)
  {
    this.dateTextView.setText(StringUtils.getChatMessageHeaderTimestamp(this.dateTextView.getContext(), paramViewSetup.chatMessage.getTimestamp()));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/DateMessageViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */