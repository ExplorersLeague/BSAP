package com.blizzard.messenger.listeners;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import rx.Observable;
import rx.subjects.PublishSubject;

public class NavigationPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private final PublishSubject<Integer> onPageSelected = PublishSubject.create();
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public Observable<Integer> onPageSelected()
  {
    return this.onPageSelected;
  }
  
  public void onPageSelected(int paramInt)
  {
    this.onPageSelected.onNext(Integer.valueOf(paramInt));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/listeners/NavigationPageChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */