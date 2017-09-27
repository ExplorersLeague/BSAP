package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RequestPermissionsActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final TextView askMeLaterTextView;
  public final TextView enablePushDescriptionTextView;
  public final ImageView enablePushImageView;
  public final LinearLayout enablePushLinearLayout;
  public final TextView enablePushTitleTextView;
  private long mDirtyFlags = -1L;
  private final ConstraintLayout mboundView0;
  
  static
  {
    sViewsWithIds.put(2131820873, 1);
    sViewsWithIds.put(2131820875, 2);
    sViewsWithIds.put(2131820876, 3);
    sViewsWithIds.put(2131820874, 4);
    sViewsWithIds.put(2131820877, 5);
  }
  
  public RequestPermissionsActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 6, sIncludes, sViewsWithIds);
    this.askMeLaterTextView = ((TextView)paramDataBindingComponent[5]);
    this.enablePushDescriptionTextView = ((TextView)paramDataBindingComponent[3]);
    this.enablePushImageView = ((ImageView)paramDataBindingComponent[1]);
    this.enablePushLinearLayout = ((LinearLayout)paramDataBindingComponent[4]);
    this.enablePushTitleTextView = ((TextView)paramDataBindingComponent[2]);
    this.mboundView0 = ((ConstraintLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static RequestPermissionsActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static RequestPermissionsActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/request_permissions_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new RequestPermissionsActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static RequestPermissionsActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static RequestPermissionsActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968695, null, false), paramDataBindingComponent);
  }
  
  public static RequestPermissionsActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static RequestPermissionsActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (RequestPermissionsActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968695, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/RequestPermissionsActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */