package com.blizzard.messenger.ui.common;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

public class SmoothAppBarBehavior
  extends AppBarLayout.Behavior
{
  private static final int MAX_NEGATIVE_FLING_VELOCITY = -5000;
  private Context context;
  private boolean isScrollingUp;
  
  public SmoothAppBarBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public boolean onNestedFling(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int j = -ViewConfiguration.get(this.context).getScaledMinimumFlingVelocity();
    float f;
    if ((paramFloat2 <= 0.0F) || (this.isScrollingUp))
    {
      f = paramFloat2;
      if (paramFloat2 < 0.0F)
      {
        f = paramFloat2;
        if (!this.isScrollingUp) {}
      }
    }
    else
    {
      f = paramFloat2 * -1.0F;
    }
    boolean bool = paramBoolean;
    int i;
    if (!this.isScrollingUp)
    {
      bool = paramBoolean;
      if ((paramView instanceof RecyclerView))
      {
        LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((RecyclerView)paramView).getLayoutManager();
        if ((localLinearLayoutManager == null) || (localLinearLayoutManager.findFirstCompletelyVisibleItemPosition() != 0)) {
          break label131;
        }
        i = 1;
        if (f >= -5000.0F) {
          break label137;
        }
        bool = false;
      }
    }
    for (;;)
    {
      return super.onNestedFling(paramCoordinatorLayout, paramAppBarLayout, paramView, paramFloat1, f, bool);
      label131:
      i = 0;
      break;
      label137:
      bool = paramBoolean;
      if (i != 0)
      {
        bool = paramBoolean;
        if (f < j) {
          bool = false;
        }
      }
    }
  }
  
  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    super.onNestedPreScroll(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt);
    if (paramInt2 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isScrollingUp = bool;
      return;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/common/SmoothAppBarBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */