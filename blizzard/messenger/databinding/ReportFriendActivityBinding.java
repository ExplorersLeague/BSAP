package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class ReportFriendActivityBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final SwitchCompat blockSwitch;
  private long mDirtyFlags = -1L;
  private final LinearLayout mboundView0;
  public final TextView reasonDescriptionTextView;
  public final AppCompatEditText reportEditText;
  public final TextInputLayout reportTextInputLayout;
  public final TextView reportTitleTextView;
  public final TextView reportTypePrompt;
  public final Spinner reportTypeSpinner;
  public final Toolbar toolbar;
  
  static
  {
    sViewsWithIds.put(2131820684, 1);
    sViewsWithIds.put(2131820866, 2);
    sViewsWithIds.put(2131820867, 3);
    sViewsWithIds.put(2131820868, 4);
    sViewsWithIds.put(2131820870, 5);
    sViewsWithIds.put(2131820869, 6);
    sViewsWithIds.put(2131820871, 7);
    sViewsWithIds.put(2131820872, 8);
  }
  
  public ReportFriendActivityBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 9, sIncludes, sViewsWithIds);
    this.blockSwitch = ((SwitchCompat)paramDataBindingComponent[6]);
    this.mboundView0 = ((LinearLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.reasonDescriptionTextView = ((TextView)paramDataBindingComponent[4]);
    this.reportEditText = ((AppCompatEditText)paramDataBindingComponent[8]);
    this.reportTextInputLayout = ((TextInputLayout)paramDataBindingComponent[7]);
    this.reportTitleTextView = ((TextView)paramDataBindingComponent[5]);
    this.reportTypePrompt = ((TextView)paramDataBindingComponent[2]);
    this.reportTypeSpinner = ((Spinner)paramDataBindingComponent[3]);
    this.toolbar = ((Toolbar)paramDataBindingComponent[1]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static ReportFriendActivityBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static ReportFriendActivityBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/report_friend_activity_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new ReportFriendActivityBinding(paramDataBindingComponent, paramView);
  }
  
  public static ReportFriendActivityBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static ReportFriendActivityBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968694, null, false), paramDataBindingComponent);
  }
  
  public static ReportFriendActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static ReportFriendActivityBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (ReportFriendActivityBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968694, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/ReportFriendActivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */