package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UpdateFriendNoteActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final TextView counterTextView;
  public final TextView deleteNoteTextView;
  public final EditText friendNoteEditText;
  public final TextInputLayout friendNoteTextInputLayout;
  private long mDirtyFlags = -1L;
  private final LinearLayout mboundView0;
  public final TextView saveTextView;
  public final Toolbar toolbar;
  
  static
  {
    sViewsWithIds.put(2131820684, 1);
    sViewsWithIds.put(2131820884, 2);
    sViewsWithIds.put(2131820885, 3);
    sViewsWithIds.put(2131820886, 4);
    sViewsWithIds.put(2131820887, 5);
    sViewsWithIds.put(2131820888, 6);
  }
  
  public UpdateFriendNoteActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 7, sIncludes, sViewsWithIds);
    this.counterTextView = ((TextView)paramDataBindingComponent[4]);
    this.deleteNoteTextView = ((TextView)paramDataBindingComponent[5]);
    this.friendNoteEditText = ((EditText)paramDataBindingComponent[3]);
    this.friendNoteTextInputLayout = ((TextInputLayout)paramDataBindingComponent[2]);
    this.mboundView0 = ((LinearLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.saveTextView = ((TextView)paramDataBindingComponent[6]);
    this.toolbar = ((Toolbar)paramDataBindingComponent[1]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static UpdateFriendNoteActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static UpdateFriendNoteActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/update_friend_note_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new UpdateFriendNoteActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static UpdateFriendNoteActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static UpdateFriendNoteActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968712, null, false), paramDataBindingComponent);
  }
  
  public static UpdateFriendNoteActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static UpdateFriendNoteActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (UpdateFriendNoteActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968712, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/UpdateFriendNoteActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */