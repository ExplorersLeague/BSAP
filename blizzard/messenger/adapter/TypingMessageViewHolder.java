package com.blizzard.messenger.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;

public final class TypingMessageViewHolder
  extends MessageViewHolder
{
  private final Context context;
  private final LottieAnimationView typingImageView;
  
  public TypingMessageViewHolder(@NonNull Context paramContext, @NonNull View paramView)
  {
    super(paramView);
    this.context = paramContext;
    this.typingImageView = ((LottieAnimationView)paramView.findViewById(2131820718));
  }
  
  public void onViewHide()
  {
    this.typingImageView.cancelAnimation();
  }
  
  public void onViewShow()
  {
    this.typingImageView.playAnimation();
  }
  
  public void setupView(MessageViewHolder.ViewSetup paramViewSetup)
  {
    this.typingImageView.playAnimation();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/TypingMessageViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */