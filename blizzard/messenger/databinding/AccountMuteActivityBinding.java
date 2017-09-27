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
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AccountMuteActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final ImageView avatarImageView;
  public final LinearLayout buttonLinearLayout;
  public final TextView buttonTextView;
  public final TextView errorHelpTextView;
  private long mDirtyFlags = -1L;
  private final RelativeLayout mboundView0;
  
  static
  {
    sViewsWithIds.put(2131820690, 1);
    sViewsWithIds.put(2131820691, 2);
    sViewsWithIds.put(2131820692, 3);
    sViewsWithIds.put(2131820693, 4);
  }
  
  public AccountMuteActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 5, sIncludes, sViewsWithIds);
    this.avatarImageView = ((ImageView)paramDataBindingComponent[1]);
    this.buttonLinearLayout = ((LinearLayout)paramDataBindingComponent[3]);
    this.buttonTextView = ((TextView)paramDataBindingComponent[4]);
    this.errorHelpTextView = ((TextView)paramDataBindingComponent[2]);
    this.mboundView0 = ((RelativeLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static AccountMuteActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static AccountMuteActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/account_mute_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new AccountMuteActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static AccountMuteActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static AccountMuteActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968604, null, false), paramDataBindingComponent);
  }
  
  public static AccountMuteActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static AccountMuteActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (AccountMuteActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968604, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/AccountMuteActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */