package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final AppBarLayout appBarLayout;
  private long mDirtyFlags = -1L;
  private final CoordinatorLayout mboundView0;
  public final TextView noNetworkTextView;
  public final TabLayout tabs;
  public final Toolbar toolbar;
  public final ViewPager viewPager;
  
  static
  {
    sViewsWithIds.put(2131820766, 1);
    sViewsWithIds.put(2131820684, 2);
    sViewsWithIds.put(2131820818, 3);
    sViewsWithIds.put(2131820707, 4);
    sViewsWithIds.put(2131820819, 5);
  }
  
  public MainActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 6, sIncludes, sViewsWithIds);
    this.appBarLayout = ((AppBarLayout)paramDataBindingComponent[1]);
    this.mboundView0 = ((CoordinatorLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.noNetworkTextView = ((TextView)paramDataBindingComponent[4]);
    this.tabs = ((TabLayout)paramDataBindingComponent[3]);
    this.toolbar = ((Toolbar)paramDataBindingComponent[2]);
    this.viewPager = ((ViewPager)paramDataBindingComponent[5]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static MainActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static MainActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/main_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new MainActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static MainActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static MainActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968656, null, false), paramDataBindingComponent);
  }
  
  public static MainActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static MainActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (MainActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968656, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/MainActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */