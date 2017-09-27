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
import com.airbnb.lottie.LottieAnimationView;

public class FindFriendsHeaderBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final LinearLayout addByCodeLayout;
  public final LinearLayout addByIdLayout;
  public final LinearLayout addByLinearLayout;
  public final ImageView backgroundImageView;
  public final LinearLayout headerLayout;
  public final TextView headerTextView;
  private long mDirtyFlags = -1L;
  private final RelativeLayout mboundView0;
  public final LottieAnimationView spinnerImageView;
  
  static
  {
    sViewsWithIds.put(2131820700, 1);
    sViewsWithIds.put(2131820770, 2);
    sViewsWithIds.put(2131820771, 3);
    sViewsWithIds.put(2131820772, 4);
    sViewsWithIds.put(2131820773, 5);
    sViewsWithIds.put(2131820774, 6);
    sViewsWithIds.put(2131820775, 7);
  }
  
  public FindFriendsHeaderBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 8, sIncludes, sViewsWithIds);
    this.addByCodeLayout = ((LinearLayout)paramDataBindingComponent[4]);
    this.addByIdLayout = ((LinearLayout)paramDataBindingComponent[3]);
    this.addByLinearLayout = ((LinearLayout)paramDataBindingComponent[2]);
    this.backgroundImageView = ((ImageView)paramDataBindingComponent[1]);
    this.headerLayout = ((LinearLayout)paramDataBindingComponent[5]);
    this.headerTextView = ((TextView)paramDataBindingComponent[7]);
    this.mboundView0 = ((RelativeLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.spinnerImageView = ((LottieAnimationView)paramDataBindingComponent[6]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static FindFriendsHeaderBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static FindFriendsHeaderBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/find_friends_header_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new FindFriendsHeaderBinding(paramDataBindingComponent, paramView);
  }
  
  public static FindFriendsHeaderBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static FindFriendsHeaderBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968639, null, false), paramDataBindingComponent);
  }
  
  public static FindFriendsHeaderBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static FindFriendsHeaderBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (FindFriendsHeaderBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968639, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/FindFriendsHeaderBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */