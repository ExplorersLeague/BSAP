package com.blizzard.messenger.ui.welcome;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.blizzard.messenger.databinding.WelcomeFragmentOneBinding;
import com.blizzard.messenger.ui.base.BaseFragment;

public class WelcomeFragmentOne
  extends BaseFragment
{
  private WelcomeFragmentOneBinding binding;
  
  public static WelcomeFragmentOne newInstance()
  {
    return new WelcomeFragmentOne();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.binding = ((WelcomeFragmentOneBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968715, paramViewGroup, false));
    return this.binding.getRoot();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.binding != null)
    {
      this.binding.welcomeImageView.loop(true);
      this.binding.welcomeImageView.playAnimation();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/welcome/WelcomeFragmentOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */