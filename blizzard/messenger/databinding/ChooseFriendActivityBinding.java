package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ChooseFriendActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final LinearLayout content;
  public final CoordinatorLayout coordinatorLayout;
  private long mDirtyFlags = -1L;
  private final LinearLayout mboundView0;
  public final Toolbar toolbar;
  
  static
  {
    sViewsWithIds.put(2131820684, 1);
    sViewsWithIds.put(2131820734, 2);
    sViewsWithIds.put(2131820708, 3);
  }
  
  public ChooseFriendActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 4, sIncludes, sViewsWithIds);
    this.content = ((LinearLayout)paramDataBindingComponent[3]);
    this.coordinatorLayout = ((CoordinatorLayout)paramDataBindingComponent[2]);
    this.mboundView0 = ((LinearLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.toolbar = ((Toolbar)paramDataBindingComponent[1]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static ChooseFriendActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static ChooseFriendActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/choose_friend_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new ChooseFriendActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static ChooseFriendActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static ChooseFriendActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968616, null, false), paramDataBindingComponent);
  }
  
  public static ChooseFriendActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static ChooseFriendActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (ChooseFriendActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968616, paramViewGroup, paramBoolean, paramDataBindingComponent);
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.mDirtyFlags;
      this.mDirtyFlags = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.mDirtyFlags != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.mDirtyFlags = 1L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    return false;
  }
  
  public boolean setVariable(int paramInt, Object paramObject)
  {
    return false;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/ChooseFriendActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */