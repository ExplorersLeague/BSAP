package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SendFriendRequestOptionBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final TextView battletagTextView;
  private long mDirtyFlags = -1L;
  private final LinearLayout mboundView0;
  public final TextView realIdTextView;
  
  static
  {
    sViewsWithIds.put(2131820741, 1);
    sViewsWithIds.put(2131820742, 2);
  }
  
  public SendFriendRequestOptionBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 3, sIncludes, sViewsWithIds);
    this.battletagTextView = ((TextView)paramDataBindingComponent[1]);
    this.mboundView0 = ((LinearLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.realIdTextView = ((TextView)paramDataBindingComponent[2]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static SendFriendRequestOptionBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static SendFriendRequestOptionBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/send_friend_request_option_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new SendFriendRequestOptionBinding(paramDataBindingComponent, paramView);
  }
  
  public static SendFriendRequestOptionBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static SendFriendRequestOptionBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968700, null, false), paramDataBindingComponent);
  }
  
  public static SendFriendRequestOptionBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static SendFriendRequestOptionBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (SendFriendRequestOptionBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968700, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/SendFriendRequestOptionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */