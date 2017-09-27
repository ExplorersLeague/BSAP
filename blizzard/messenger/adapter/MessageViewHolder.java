package com.blizzard.messenger.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.blizzard.messenger.data.model.chat.ChatMessage;

public abstract class MessageViewHolder
  extends RecyclerView.ViewHolder
{
  public MessageViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public void onViewHide() {}
  
  public void onViewShow() {}
  
  public void setupView(ViewSetup paramViewSetup) {}
  
  public static class ViewSetup
  {
    protected ChatMessage chatMessage;
    protected ChatMessage nextChatMessage;
    protected ChatMessage previousChatMessage;
    protected boolean toggled;
    
    public ViewSetup chatMessage(ChatMessage paramChatMessage)
    {
      this.chatMessage = paramChatMessage;
      return this;
    }
    
    public ViewSetup nextChatMessage(ChatMessage paramChatMessage)
    {
      this.nextChatMessage = paramChatMessage;
      return this;
    }
    
    public ViewSetup previousChatMessage(ChatMessage paramChatMessage)
    {
      this.previousChatMessage = paramChatMessage;
      return this;
    }
    
    public ViewSetup toggled(boolean paramBoolean)
    {
      this.toggled = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/MessageViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */