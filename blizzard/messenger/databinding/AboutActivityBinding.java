package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AboutActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final TextView appVersionTextView;
  public final TextView copyrightTextView;
  private long mDirtyFlags = -1L;
  private final RelativeLayout mboundView0;
  public final TextView openSourceLicensesTextView;
  public final TextView privacyPolicyTextView;
  public final TextView termsOfServiceTextView;
  public final Toolbar toolbar;
  
  static
  {
    sViewsWithIds.put(2131820684, 1);
    sViewsWithIds.put(2131820685, 2);
    sViewsWithIds.put(2131820686, 3);
    sViewsWithIds.put(2131820687, 4);
    sViewsWithIds.put(2131820688, 5);
    sViewsWithIds.put(2131820689, 6);
  }
  
  public AboutActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 7, sIncludes, sViewsWithIds);
    this.appVersionTextView = ((TextView)paramDataBindingComponent[2]);
    this.copyrightTextView = ((TextView)paramDataBindingComponent[6]);
    this.mboundView0 = ((RelativeLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.openSourceLicensesTextView = ((TextView)paramDataBindingComponent[5]);
    this.privacyPolicyTextView = ((TextView)paramDataBindingComponent[3]);
    this.termsOfServiceTextView = ((TextView)paramDataBindingComponent[4]);
    this.toolbar = ((Toolbar)paramDataBindingComponent[1]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static AboutActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static AboutActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/about_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new AboutActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static AboutActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static AboutActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968603, null, false), paramDataBindingComponent);
  }
  
  public static AboutActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static AboutActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (AboutActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968603, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/AboutActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */