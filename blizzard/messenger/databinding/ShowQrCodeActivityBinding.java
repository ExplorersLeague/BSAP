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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShowQrCodeActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final ImageView backgroundImageView;
  private long mDirtyFlags = -1L;
  private final RelativeLayout mboundView0;
  public final TextView nameTextView;
  public final ImageView qrCodeImageView;
  public final Toolbar toolbar;
  
  static
  {
    sViewsWithIds.put(2131820700, 1);
    sViewsWithIds.put(2131820684, 2);
    sViewsWithIds.put(2131820880, 3);
    sViewsWithIds.put(2131820798, 4);
  }
  
  public ShowQrCodeActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 5, sIncludes, sViewsWithIds);
    this.backgroundImageView = ((ImageView)paramDataBindingComponent[1]);
    this.mboundView0 = ((RelativeLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.nameTextView = ((TextView)paramDataBindingComponent[4]);
    this.qrCodeImageView = ((ImageView)paramDataBindingComponent[3]);
    this.toolbar = ((Toolbar)paramDataBindingComponent[2]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static ShowQrCodeActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static ShowQrCodeActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/show_qr_code_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new ShowQrCodeActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static ShowQrCodeActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static ShowQrCodeActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968707, null, false), paramDataBindingComponent);
  }
  
  public static ShowQrCodeActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static ShowQrCodeActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (ShowQrCodeActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968707, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/ShowQrCodeActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */