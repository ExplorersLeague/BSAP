package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AddFriendActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final ImageView backgroundImageView;
  public final AppCompatEditText friendNameEditText;
  public final TextInputLayout friendNameTextInputLayout;
  public final TextView helpTextView;
  private long mDirtyFlags = -1L;
  private final RelativeLayout mboundView0;
  public final Toolbar toolbar;
  
  static
  {
    sViewsWithIds.put(2131820700, 1);
    sViewsWithIds.put(2131820684, 2);
    sViewsWithIds.put(2131820701, 3);
    sViewsWithIds.put(2131820702, 4);
    sViewsWithIds.put(2131820703, 5);
  }
  
  public AddFriendActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 6, sIncludes, sViewsWithIds);
    this.backgroundImageView = ((ImageView)paramDataBindingComponent[1]);
    this.friendNameEditText = ((AppCompatEditText)paramDataBindingComponent[4]);
    this.friendNameTextInputLayout = ((TextInputLayout)paramDataBindingComponent[3]);
    this.helpTextView = ((TextView)paramDataBindingComponent[5]);
    this.mboundView0 = ((RelativeLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.toolbar = ((Toolbar)paramDataBindingComponent[2]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static AddFriendActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static AddFriendActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/add_friend_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new AddFriendActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static AddFriendActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static AddFriendActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968606, null, false), paramDataBindingComponent);
  }
  
  public static AddFriendActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static AddFriendActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (AddFriendActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968606, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/AddFriendActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */