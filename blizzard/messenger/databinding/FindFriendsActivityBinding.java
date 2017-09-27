package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FindFriendsActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = new ViewDataBinding.IncludedLayouts(8);
  private static final SparseIntArray sViewsWithIds;
  public final AppBarLayout appBarLayout;
  public final CollapsingToolbarLayout collapsingToolbarLayout;
  public final LinearLayout contentLayout;
  public final LinearLayout emptyLayout;
  public final FindFriendsHeaderBinding header;
  private long mDirtyFlags = -1L;
  private final CoordinatorLayout mboundView0;
  public final RecyclerView recyclerView;
  public final Toolbar toolbar;
  
  static
  {
    sIncludes.setIncludes(1, new String[] { "find_friends_header" }, new int[] { 2 }, new int[] { 2130968639 });
    sViewsWithIds = new SparseIntArray();
    sViewsWithIds.put(2131820766, 3);
    sViewsWithIds.put(2131820684, 4);
    sViewsWithIds.put(2131820769, 5);
    sViewsWithIds.put(2131820728, 6);
    sViewsWithIds.put(2131820735, 7);
  }
  
  public FindFriendsActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 1);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 8, sIncludes, sViewsWithIds);
    this.appBarLayout = ((AppBarLayout)paramDataBindingComponent[3]);
    this.collapsingToolbarLayout = ((CollapsingToolbarLayout)paramDataBindingComponent[1]);
    this.collapsingToolbarLayout.setTag(null);
    this.contentLayout = ((LinearLayout)paramDataBindingComponent[5]);
    this.emptyLayout = ((LinearLayout)paramDataBindingComponent[6]);
    this.header = ((FindFriendsHeaderBinding)paramDataBindingComponent[2]);
    setContainedBinding(this.header);
    this.mboundView0 = ((CoordinatorLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.recyclerView = ((RecyclerView)paramDataBindingComponent[7]);
    this.toolbar = ((Toolbar)paramDataBindingComponent[4]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static FindFriendsActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static FindFriendsActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/find_friends_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new FindFriendsActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static FindFriendsActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static FindFriendsActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968638, null, false), paramDataBindingComponent);
  }
  
  public static FindFriendsActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static FindFriendsActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (FindFriendsActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968638, paramViewGroup, paramBoolean, paramDataBindingComponent);
  }
  
  private boolean onChangeHeader(FindFriendsHeaderBinding paramFindFriendsHeaderBinding, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      this.mDirtyFlags |= 1L;
      return true;
    }
    finally {}
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.mDirtyFlags;
      this.mDirtyFlags = 0L;
      executeBindingsOn(this.header);
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      if (this.mDirtyFlags != 0L) {
        return true;
      }
      if (!this.header.hasPendingBindings()) {
        return false;
      }
    }
    finally {}
    return true;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.mDirtyFlags = 2L;
      this.header.invalidateAll();
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    }
    return onChangeHeader((FindFriendsHeaderBinding)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, Object paramObject)
  {
    return false;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/FindFriendsActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */