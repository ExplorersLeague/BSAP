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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FriendsListFragmentBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final ImageView addFriendIcon;
  public final AppCompatTextView appearingOfflineBar;
  public final LinearLayout emptyLayout;
  public final LinearLayout friendRequestBar;
  private long mDirtyFlags = -1L;
  private final LinearLayout mboundView0;
  public final TextView noResultsFoundTextView;
  public final AppCompatTextView pendingRequestsCountText;
  public final RecyclerView recyclerView;
  
  static
  {
    sViewsWithIds.put(2131820725, 1);
    sViewsWithIds.put(2131820802, 2);
    sViewsWithIds.put(2131820803, 3);
    sViewsWithIds.put(2131820804, 4);
    sViewsWithIds.put(2131820805, 5);
    sViewsWithIds.put(2131820735, 6);
    sViewsWithIds.put(2131820728, 7);
  }
  
  public FriendsListFragmentBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 8, sIncludes, sViewsWithIds);
    this.addFriendIcon = ((ImageView)paramDataBindingComponent[3]);
    this.appearingOfflineBar = ((AppCompatTextView)paramDataBindingComponent[1]);
    this.emptyLayout = ((LinearLayout)paramDataBindingComponent[7]);
    this.friendRequestBar = ((LinearLayout)paramDataBindingComponent[2]);
    this.mboundView0 = ((LinearLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.noResultsFoundTextView = ((TextView)paramDataBindingComponent[5]);
    this.pendingRequestsCountText = ((AppCompatTextView)paramDataBindingComponent[4]);
    this.recyclerView = ((RecyclerView)paramDataBindingComponent[6]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static FriendsListFragmentBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static FriendsListFragmentBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/friends_list_fragment_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new FriendsListFragmentBinding(paramDataBindingComponent, paramView);
  }
  
  public static FriendsListFragmentBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static FriendsListFragmentBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968647, null, false), paramDataBindingComponent);
  }
  
  public static FriendsListFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static FriendsListFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (FriendsListFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968647, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/FriendsListFragmentBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */