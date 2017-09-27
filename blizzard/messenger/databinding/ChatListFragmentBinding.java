package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ChatListFragmentBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final AppCompatTextView appearingOfflineBar;
  public final RelativeLayout coordinatorLayout;
  public final LinearLayout emptyLayout;
  private long mDirtyFlags = -1L;
  private final LinearLayout mboundView0;
  public final RecyclerView recyclerView;
  
  static
  {
    sViewsWithIds.put(2131820725, 1);
    sViewsWithIds.put(2131820734, 2);
    sViewsWithIds.put(2131820735, 3);
    sViewsWithIds.put(2131820728, 4);
  }
  
  public ChatListFragmentBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 5, sIncludes, sViewsWithIds);
    this.appearingOfflineBar = ((AppCompatTextView)paramDataBindingComponent[1]);
    this.coordinatorLayout = ((RelativeLayout)paramDataBindingComponent[2]);
    this.emptyLayout = ((LinearLayout)paramDataBindingComponent[4]);
    this.mboundView0 = ((LinearLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.recyclerView = ((RecyclerView)paramDataBindingComponent[3]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static ChatListFragmentBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static ChatListFragmentBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/chat_list_fragment_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new ChatListFragmentBinding(paramDataBindingComponent, paramView);
  }
  
  public static ChatListFragmentBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static ChatListFragmentBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968614, null, false), paramDataBindingComponent);
  }
  
  public static ChatListFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static ChatListFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (ChatListFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968614, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/ChatListFragmentBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */