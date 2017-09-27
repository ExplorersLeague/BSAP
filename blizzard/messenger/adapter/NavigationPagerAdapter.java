package com.blizzard.messenger.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.blizzard.messenger.ui.chat.ChatListFragment;
import com.blizzard.messenger.ui.friends.FriendsListFragment;
import com.blizzard.messenger.ui.profile.ProfileFragment;

public class NavigationPagerAdapter
  extends FragmentPagerAdapter
{
  public NavigationPagerAdapter(FragmentManager paramFragmentManager)
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
      return FriendsListFragment.newInstance(false);
    case 1: 
      return new ChatListFragment();
    }
    return new ProfileFragment();
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return null;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/NavigationPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */