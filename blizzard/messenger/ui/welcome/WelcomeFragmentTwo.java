package com.blizzard.messenger.ui.welcome;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.blizzard.messenger.databinding.WelcomeFragmentTwoBinding;
import com.blizzard.messenger.ui.base.BaseFragment;

public class WelcomeFragmentTwo
  extends BaseFragment
{
  private WelcomeFragmentTwoBinding binding;
  private boolean hasAnimated = false;
  
  public static WelcomeFragmentTwo newInstance()
  {
    return new WelcomeFragmentTwo();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.binding = ((WelcomeFragmentTwoBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968717, paramViewGroup, false));
    return this.binding.getRoot();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (!this.hasAnimated))
    {
      this.hasAnimated = true;
      this.binding.welcomeImageView.playAnimation();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/welcome/WelcomeFragmentTwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */