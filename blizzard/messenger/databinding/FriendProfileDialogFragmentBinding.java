package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class FriendProfileDialogFragmentBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final ImageView avatarBackgroundImageView;
  public final AppCompatTextView battletagTextView;
  public final ImageView friendFavoriteImageView;
  public final ImageView friendNoteImageView;
  public final LinearLayout friendNoteLinearLayout;
  public final AppCompatTextView friendNoteTextView;
  public final AppCompatImageButton friendOptionsImageView;
  private long mDirtyFlags = -1L;
  public final ImageView mainActionImageView;
  public final LinearLayout mainActionLinearLayout;
  public final AppCompatTextView mainActionTextView;
  private final ScrollView mboundView0;
  public final LinearLayout metadataLinearLayout;
  public final ImageView presenceGameImageView;
  public final ImageView presenceStatusImageView;
  public final AppCompatTextView presenceTextView;
  public final AppCompatTextView realIdTextView;
  
  static
  {
    sViewsWithIds.put(2131820783, 1);
    sViewsWithIds.put(2131820784, 2);
    sViewsWithIds.put(2131820779, 3);
    sViewsWithIds.put(2131820737, 4);
    sViewsWithIds.put(2131820778, 5);
    sViewsWithIds.put(2131820741, 6);
    sViewsWithIds.put(2131820742, 7);
    sViewsWithIds.put(2131820782, 8);
    sViewsWithIds.put(2131820785, 9);
    sViewsWithIds.put(2131820786, 10);
    sViewsWithIds.put(2131820787, 11);
    sViewsWithIds.put(2131820788, 12);
    sViewsWithIds.put(2131820781, 13);
    sViewsWithIds.put(2131820789, 14);
    sViewsWithIds.put(2131820790, 15);
  }
  
  public FriendProfileDialogFragmentBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 16, sIncludes, sViewsWithIds);
    this.avatarBackgroundImageView = ((ImageView)paramDataBindingComponent[2]);
    this.battletagTextView = ((AppCompatTextView)paramDataBindingComponent[6]);
    this.friendFavoriteImageView = ((ImageView)paramDataBindingComponent[12]);
    this.friendNoteImageView = ((ImageView)paramDataBindingComponent[13]);
    this.friendNoteLinearLayout = ((LinearLayout)paramDataBindingComponent[14]);
    this.friendNoteTextView = ((AppCompatTextView)paramDataBindingComponent[15]);
    this.friendOptionsImageView = ((AppCompatImageButton)paramDataBindingComponent[3]);
    this.mainActionImageView = ((ImageView)paramDataBindingComponent[10]);
    this.mainActionLinearLayout = ((LinearLayout)paramDataBindingComponent[9]);
    this.mainActionTextView = ((AppCompatTextView)paramDataBindingComponent[11]);
    this.mboundView0 = ((ScrollView)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.metadataLinearLayout = ((LinearLayout)paramDataBindingComponent[1]);
    this.presenceGameImageView = ((ImageView)paramDataBindingComponent[4]);
    this.presenceStatusImageView = ((ImageView)paramDataBindingComponent[5]);
    this.presenceTextView = ((AppCompatTextView)paramDataBindingComponent[8]);
    this.realIdTextView = ((AppCompatTextView)paramDataBindingComponent[7]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static FriendProfileDialogFragmentBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static FriendProfileDialogFragmentBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/friend_profile_dialog_fragment_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new FriendProfileDialogFragmentBinding(paramDataBindingComponent, paramView);
  }
  
  public static FriendProfileDialogFragmentBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static FriendProfileDialogFragmentBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968641, null, false), paramDataBindingComponent);
  }
  
  public static FriendProfileDialogFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static FriendProfileDialogFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (FriendProfileDialogFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968641, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/FriendProfileDialogFragmentBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */