package com.blizzard.messenger.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.blizzard.messenger.data.model.chat.UnfurlChatMessage;
import com.blizzard.messenger.utils.ColorUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import rx.Observer;

public class UnfurlMessageViewHolder
  extends MessageViewHolder
{
  private final LinearLayout bubbleLayout;
  private final RelativeLayout chatControlsLayout;
  private final Observer<UnfurlChatMessage> clickedObserver;
  private final Context context;
  private final TextView linkDescriptionTextView;
  private final LinearLayout linkMetadataLinearLayout;
  private final ImageView linkPreviewImageView;
  private final TextView linkTitleTextView;
  private final RelativeLayout parentLinearLayout;
  private final Observer<UnfurlChatMessage> shareClickedObserver;
  private final ImageView shareImageView;
  private final LinearLayout wrapperLinearLayout;
  
  private UnfurlMessageViewHolder(Builder paramBuilder)
  {
    super(paramBuilder.itemView);
    this.context = paramBuilder.context;
    this.clickedObserver = paramBuilder.clickedObserver;
    this.shareClickedObserver = paramBuilder.shareClickedObserver;
    this.linkPreviewImageView = ((ImageView)this.itemView.findViewById(2131820721));
    this.shareImageView = ((ImageView)this.itemView.findViewById(2131820719));
    this.chatControlsLayout = ((RelativeLayout)this.itemView.findViewById(2131820709));
    this.bubbleLayout = ((LinearLayout)this.itemView.findViewById(2131820713));
    this.linkMetadataLinearLayout = ((LinearLayout)this.itemView.findViewById(2131820720));
    this.wrapperLinearLayout = ((LinearLayout)this.itemView.findViewById(2131820710));
    this.parentLinearLayout = ((RelativeLayout)this.itemView.findViewById(2131820566));
    this.linkDescriptionTextView = ((TextView)this.itemView.findViewById(2131820723));
    this.linkTitleTextView = ((TextView)this.itemView.findViewById(2131820722));
  }
  
  private void setupMyChatBubble()
  {
    this.parentLinearLayout.setGravity(8388613);
    Object localObject = this.wrapperLinearLayout.getLayoutParams();
    localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
    ((RelativeLayout.LayoutParams)localObject).addRule(17, this.chatControlsLayout.getId());
    this.wrapperLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.chatControlsLayout.getLayoutParams();
    localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
    this.chatControlsLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.bubbleLayout.setBackgroundResource(ColorUtils.getChatBubbleMineNoTail(this.context));
    this.linkDescriptionTextView.setTextColor(ColorUtils.getTextColorConversationMine(this.context));
    this.linkTitleTextView.setTextColor(ColorUtils.getTextColorConversationMine(this.context));
  }
  
  private void setupRecipientChatBubble()
  {
    this.parentLinearLayout.setGravity(8388611);
    Object localObject = this.chatControlsLayout.getLayoutParams();
    localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
    ((RelativeLayout.LayoutParams)localObject).addRule(17, this.wrapperLinearLayout.getId());
    this.chatControlsLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.wrapperLinearLayout.getLayoutParams();
    localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
    this.wrapperLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.bubbleLayout.setBackgroundResource(ColorUtils.getChatBubbleRecipientNoTail(this.context));
    this.linkTitleTextView.setTextColor(ColorUtils.getTextColorConversationRecipient(this.context));
    this.linkDescriptionTextView.setTextColor(ColorUtils.getTextColorConversationRecipient(this.context));
  }
  
  public void setupView(MessageViewHolder.ViewSetup paramViewSetup)
  {
    paramViewSetup = (UnfurlChatMessage)paramViewSetup.chatMessage;
    if (paramViewSetup.getImageUrl() != null)
    {
      this.linkPreviewImageView.setVisibility(0);
      Picasso.with(this.context).load(paramViewSetup.getImageUrl()).into(this.linkPreviewImageView);
      if (paramViewSetup.getUrlTitle() == null) {
        break label144;
      }
      this.linkTitleTextView.setVisibility(0);
      this.linkTitleTextView.setText(paramViewSetup.getUrlTitle());
      label70:
      if (paramViewSetup.getUrlDescription() == null) {
        break label156;
      }
      this.linkDescriptionTextView.setVisibility(0);
      this.linkDescriptionTextView.setText(paramViewSetup.getUrlDescription());
      label96:
      if (!paramViewSetup.isMine()) {
        break label168;
      }
      setupMyChatBubble();
    }
    for (;;)
    {
      this.bubbleLayout.setOnClickListener(UnfurlMessageViewHolder..Lambda.1.lambdaFactory$(this, paramViewSetup));
      this.shareImageView.setOnClickListener(UnfurlMessageViewHolder..Lambda.2.lambdaFactory$(this, paramViewSetup));
      return;
      this.linkPreviewImageView.setVisibility(8);
      break;
      label144:
      this.linkTitleTextView.setVisibility(8);
      break label70;
      label156:
      this.linkDescriptionTextView.setVisibility(8);
      break label96;
      label168:
      setupRecipientChatBubble();
    }
  }
  
  public static class Builder
  {
    private Observer<UnfurlChatMessage> clickedObserver;
    private Context context;
    private View itemView;
    private Observer<UnfurlChatMessage> shareClickedObserver;
    
    public UnfurlMessageViewHolder build()
    {
      return new UnfurlMessageViewHolder(this, null);
    }
    
    public Builder clickedObserver(Observer<UnfurlChatMessage> paramObserver)
    {
      this.clickedObserver = paramObserver;
      return this;
    }
    
    public Builder context(Context paramContext)
    {
      this.context = paramContext;
      return this;
    }
    
    public Builder itemView(View paramView)
    {
      this.itemView = paramView;
      return this;
    }
    
    public Builder shareClickedObserver(Observer<UnfurlChatMessage> paramObserver)
    {
      this.shareClickedObserver = paramObserver;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/UnfurlMessageViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */