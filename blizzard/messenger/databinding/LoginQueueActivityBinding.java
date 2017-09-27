package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

public class LoginQueueActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final AppBarLayout appBarLayout;
  public final TextView loginQueueBodyText;
  public final LottieAnimationView loginQueueIcon;
  public final RelativeLayout loginQueueLayout;
  public final TextView loginQueueTitleText;
  private long mDirtyFlags = -1L;
  public final Toolbar toolbar;
  
  static
  {
    sViewsWithIds.put(2131820766, 1);
    sViewsWithIds.put(2131820684, 2);
    sViewsWithIds.put(2131820815, 3);
    sViewsWithIds.put(2131820816, 4);
    sViewsWithIds.put(2131820817, 5);
  }
  
  public LoginQueueActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 6, sIncludes, sViewsWithIds);
    this.appBarLayout = ((AppBarLayout)paramDataBindingComponent[1]);
    this.loginQueueBodyText = ((TextView)paramDataBindingComponent[4]);
    this.loginQueueIcon = ((LottieAnimationView)paramDataBindingComponent[5]);
    this.loginQueueLayout = ((RelativeLayout)paramDataBindingComponent[0]);
    this.loginQueueLayout.setTag(null);
    this.loginQueueTitleText = ((TextView)paramDataBindingComponent[3]);
    this.toolbar = ((Toolbar)paramDataBindingComponent[2]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static LoginQueueActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static LoginQueueActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/login_queue_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new LoginQueueActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static LoginQueueActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static LoginQueueActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968655, null, false), paramDataBindingComponent);
  }
  
  public static LoginQueueActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static LoginQueueActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (LoginQueueActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968655, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/LoginQueueActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */