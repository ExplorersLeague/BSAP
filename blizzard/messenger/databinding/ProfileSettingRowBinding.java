package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileSettingRowBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final ImageView externalLinkImageView;
  public final ImageView imageView;
  private long mDirtyFlags = -1L;
  public final LinearLayout parent;
  public final TextView titleTextView;
  
  static
  {
    sViewsWithIds.put(2131820863, 1);
    sViewsWithIds.put(2131820864, 2);
    sViewsWithIds.put(2131820865, 3);
  }
  
  public ProfileSettingRowBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 4, sIncludes, sViewsWithIds);
    this.externalLinkImageView = ((ImageView)paramDataBindingComponent[3]);
    this.imageView = ((ImageView)paramDataBindingComponent[1]);
    this.parent = ((LinearLayout)paramDataBindingComponent[0]);
    this.parent.setTag(null);
    this.titleTextView = ((TextView)paramDataBindingComponent[2]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static ProfileSettingRowBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static ProfileSettingRowBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/profile_setting_row_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new ProfileSettingRowBinding(paramDataBindingComponent, paramView);
  }
  
  public static ProfileSettingRowBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static ProfileSettingRowBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968690, null, false), paramDataBindingComponent);
  }
  
  public static ProfileSettingRowBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static ProfileSettingRowBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (ProfileSettingRowBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968690, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/ProfileSettingRowBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */