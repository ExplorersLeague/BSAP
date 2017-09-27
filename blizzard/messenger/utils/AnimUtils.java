package com.blizzard.messenger.utils;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

public class AnimUtils
{
  public static void fadeIn(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.1F, 1.0F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.val$v.setAlpha(0.1F);
        this.val$v.setVisibility(0);
      }
    });
    localObjectAnimator.start();
  }
  
  public static void fadeOut(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.1F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        this.val$v.setVisibility(8);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localObjectAnimator.start();
  }
  
  public static LayoutAnimationController getRecyclerViewAnimationController()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(300L);
    localAnimationSet.addAnimation(localAlphaAnimation);
    return new LayoutAnimationController(localAnimationSet, 0.2F);
  }
  
  public static void rollViewDown(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getLayoutParams().height = 0;
    paramView.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    localValueAnimator.setDuration(paramInt2);
    localValueAnimator.addUpdateListener(AnimUtils..Lambda.1.lambdaFactory$(paramView));
    localValueAnimator.start();
  }
  
  public static void rollViewUp(View paramView, int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramView.getHeight(), 0 });
    localValueAnimator.setDuration(paramInt);
    localValueAnimator.addUpdateListener(AnimUtils..Lambda.2.lambdaFactory$(paramView));
    localValueAnimator.start();
  }
  
  public static void setViewDown(View paramView, int paramInt)
  {
    paramView.setVisibility(0);
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  public static void textFadeAnimation(TextView paramTextView, final String paramString)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramTextView, "alpha", new float[] { 1.0F, 0.1F });
    localObjectAnimator1.setDuration(300L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramTextView, "alpha", new float[] { 0.1F, 1.0F });
    localObjectAnimator2.setDuration(300L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator2).after(localObjectAnimator1);
    localObjectAnimator1.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        this.val$textView.setText(paramString);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localAnimatorSet.start();
  }
  
  public static void toggleViewRoll(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getVisibility() == 0)
    {
      rollViewUp(paramView, paramInt2);
      return;
    }
    rollViewDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/AnimUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */