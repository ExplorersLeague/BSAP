package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import me.relex.circleindicator.CircleIndicator;

public class WelcomeActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final CircleIndicator indicator;
  public final LinearLayout loginLinearLayout;
  public final ImageView logo;
  private long mDirtyFlags = -1L;
  private final ConstraintLayout mboundView0;
  public final TextureView videoView;
  public final ViewPager viewPager;
  
  static
  {
    sViewsWithIds.put(2131820891, 1);
    sViewsWithIds.put(2131820892, 2);
    sViewsWithIds.put(2131820819, 3);
    sViewsWithIds.put(2131820893, 4);
    sViewsWithIds.put(2131820894, 5);
  }
  
  public WelcomeActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 6, sIncludes, sViewsWithIds);
    this.indicator = ((CircleIndicator)paramDataBindingComponent[4]);
    this.loginLinearLayout = ((LinearLayout)paramDataBindingComponent[5]);
    this.logo = ((ImageView)paramDataBindingComponent[2]);
    this.mboundView0 = ((ConstraintLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.videoView = ((TextureView)paramDataBindingComponent[1]);
    this.viewPager = ((ViewPager)paramDataBindingComponent[3]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static WelcomeActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static WelcomeActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/welcome_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new WelcomeActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static WelcomeActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static WelcomeActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968714, null, false), paramDataBindingComponent);
  }
  
  public static WelcomeActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static WelcomeActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (WelcomeActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968714, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/WelcomeActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */