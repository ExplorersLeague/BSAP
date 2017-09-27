package com.blizzard.messenger.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.blizzard.messenger.ui.welcome.WelcomeFragmentOne;
import com.blizzard.messenger.ui.welcome.WelcomeFragmentThree;
import com.blizzard.messenger.ui.welcome.WelcomeFragmentTwo;

public class WelcomeFragmentAdapter
  extends FragmentStatePagerAdapter
{
  private static final int PAGE_COUNT = 3;
  
  public WelcomeFragmentAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return 3;
  }
  
  public Fragment getItem(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return WelcomeFragmentOne.newInstance();
    case 1: 
      return WelcomeFragmentTwo.newInstance();
    }
    return WelcomeFragmentThree.newInstance();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/WelcomeFragmentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */