package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatTextView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

public class ProfileFragmentBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = new ViewDataBinding.IncludedLayouts(22);
  private static final SparseIntArray sViewsWithIds;
  public final ProfileSettingRowNoIconBinding about;
  public final ProfileSettingRowBinding accessibility;
  public final ProfileSettingRowBinding appSettings;
  public final AppCompatTextView appearingOfflineBar;
  public final ImageView avatarBackgroundImageView;
  public final ProfileSettingRowNoIconBinding developerSettings;
  public final ProfileSettingRowBinding deviceSettings;
  public final TextView logOut;
  private long mDirtyFlags = -1L;
  private final NestedScrollView mboundView0;
  private final LinearLayout mboundView1;
  public final LinearLayout metadataLinearLayout;
  public final AppCompatTextView nameTextView;
  public final ProfileSettingRowBinding notifications;
  public final ImageView presenceGameImageView;
  public final ImageView presenceStatusImageView;
  public final LottieAnimationView statusAwayImageView;
  public final LinearLayout statusAwayLinearLayout;
  public final LottieAnimationView statusBusyImageView;
  public final LinearLayout statusBusyLinearLayout;
  public final LottieAnimationView statusOnlineImageView;
  public final LinearLayout statusOnlineLinearLayout;
  public final ProfileSettingRowNoIconBinding support;
  
  static
  {
    sIncludes.setIncludes(1, new String[] { "profile_setting_row", "profile_setting_row", "profile_setting_row", "profile_setting_row", "profile_setting_row_no_icon", "profile_setting_row_no_icon", "profile_setting_row_no_icon" }, new int[] { 2, 3, 4, 5, 6, 7, 8 }, new int[] { 2130968690, 2130968690, 2130968690, 2130968690, 2130968691, 2130968691, 2130968691 });
    sViewsWithIds = new SparseIntArray();
    sViewsWithIds.put(2131820783, 9);
    sViewsWithIds.put(2131820725, 10);
    sViewsWithIds.put(2131820784, 11);
    sViewsWithIds.put(2131820737, 12);
    sViewsWithIds.put(2131820778, 13);
    sViewsWithIds.put(2131820798, 14);
    sViewsWithIds.put(2131820849, 15);
    sViewsWithIds.put(2131820850, 16);
    sViewsWithIds.put(2131820851, 17);
    sViewsWithIds.put(2131820852, 18);
    sViewsWithIds.put(2131820853, 19);
    sViewsWithIds.put(2131820854, 20);
    sViewsWithIds.put(2131820862, 21);
  }
  
  public ProfileFragmentBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 7);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 22, sIncludes, sViewsWithIds);
    this.about = ((ProfileSettingRowNoIconBinding)paramDataBindingComponent[8]);
    setContainedBinding(this.about);
    this.accessibility = ((ProfileSettingRowBinding)paramDataBindingComponent[3]);
    setContainedBinding(this.accessibility);
    this.appSettings = ((ProfileSettingRowBinding)paramDataBindingComponent[4]);
    setContainedBinding(this.appSettings);
    this.appearingOfflineBar = ((AppCompatTextView)paramDataBindingComponent[10]);
    this.avatarBackgroundImageView = ((ImageView)paramDataBindingComponent[11]);
    this.developerSettings = ((ProfileSettingRowNoIconBinding)paramDataBindingComponent[6]);
    setContainedBinding(this.developerSettings);
    this.deviceSettings = ((ProfileSettingRowBinding)paramDataBindingComponent[5]);
    setContainedBinding(this.deviceSettings);
    this.logOut = ((TextView)paramDataBindingComponent[21]);
    this.mboundView0 = ((NestedScrollView)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    this.mboundView1 = ((LinearLayout)paramDataBindingComponent[1]);
    this.mboundView1.setTag(null);
    this.metadataLinearLayout = ((LinearLayout)paramDataBindingComponent[9]);
    this.nameTextView = ((AppCompatTextView)paramDataBindingComponent[14]);
    this.notifications = ((ProfileSettingRowBinding)paramDataBindingComponent[2]);
    setContainedBinding(this.notifications);
    this.presenceGameImageView = ((ImageView)paramDataBindingComponent[12]);
    this.presenceStatusImageView = ((ImageView)paramDataBindingComponent[13]);
    this.statusAwayImageView = ((LottieAnimationView)paramDataBindingComponent[18]);
    this.statusAwayLinearLayout = ((LinearLayout)paramDataBindingComponent[17]);
    this.statusBusyImageView = ((LottieAnimationView)paramDataBindingComponent[20]);
    this.statusBusyLinearLayout = ((LinearLayout)paramDataBindingComponent[19]);
    this.statusOnlineImageView = ((LottieAnimationView)paramDataBindingComponent[16]);
    this.statusOnlineLinearLayout = ((LinearLayout)paramDataBindingComponent[15]);
    this.support = ((ProfileSettingRowNoIconBinding)paramDataBindingComponent[7]);
    setContainedBinding(this.support);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static ProfileFragmentBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static ProfileFragmentBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/profile_fragment_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new ProfileFragmentBinding(paramDataBindingComponent, paramView);
  }
  
  public static ProfileFragmentBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static ProfileFragmentBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968689, null, false), paramDataBindingComponent);
  }
  
  public static ProfileFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static ProfileFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (ProfileFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968689, paramViewGroup, paramBoolean, paramDataBindingComponent);
  }
  
  private boolean onChangeAbout(ProfileSettingRowNoIconBinding paramProfileSettingRowNoIconBinding, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      this.mDirtyFlags |= 0x20;
      return true;
    }
    finally {}
  }
  
  private boolean onChangeAccessibility(ProfileSettingRowBinding paramProfileSettingRowBinding, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      this.mDirtyFlags |= 0x10;
      return true;
    }
    finally {}
  }
  
  private boolean onChangeAppSettings(ProfileSettingRowBinding paramProfileSettingRowBinding, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      this.mDirtyFlags |= 0x40;
      return true;
    }
    finally {}
  }
  
  private boolean onChangeDeveloperSettings(ProfileSettingRowNoIconBinding paramProfileSettingRowNoIconBinding, int paramInt)
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
  
  private boolean onChangeDeviceSettings(ProfileSettingRowBinding paramProfileSettingRowBinding, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      this.mDirtyFlags |= 0x8;
      return true;
    }
    finally {}
  }
  
  private boolean onChangeNotifications(ProfileSettingRowBinding paramProfileSettingRowBinding, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      this.mDirtyFlags |= 0x4;
      return true;
    }
    finally {}
  }
  
  private boolean onChangeSupport(ProfileSettingRowNoIconBinding paramProfileSettingRowNoIconBinding, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      this.mDirtyFlags |= 0x2;
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
      executeBindingsOn(this.notifications);
      executeBindingsOn(this.accessibility);
      executeBindingsOn(this.appSettings);
      executeBindingsOn(this.deviceSettings);
      executeBindingsOn(this.developerSettings);
      executeBindingsOn(this.support);
      executeBindingsOn(this.about);
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
      if ((!this.notifications.hasPendingBindings()) && (!this.accessibility.hasPendingBindings()) && (!this.appSettings.hasPendingBindings()) && (!this.deviceSettings.hasPendingBindings()) && (!this.developerSettings.hasPendingBindings()) && (!this.support.hasPendingBindings()) && (!this.about.hasPendingBindings())) {
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
      this.mDirtyFlags = 128L;
      this.notifications.invalidateAll();
      this.accessibility.invalidateAll();
      this.appSettings.invalidateAll();
      this.deviceSettings.invalidateAll();
      this.developerSettings.invalidateAll();
      this.support.invalidateAll();
      this.about.invalidateAll();
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
    case 0: 
      return onChangeDeveloperSettings((ProfileSettingRowNoIconBinding)paramObject, paramInt2);
    case 1: 
      return onChangeSupport((ProfileSettingRowNoIconBinding)paramObject, paramInt2);
    case 2: 
      return onChangeNotifications((ProfileSettingRowBinding)paramObject, paramInt2);
    case 3: 
      return onChangeDeviceSettings((ProfileSettingRowBinding)paramObject, paramInt2);
    case 4: 
      return onChangeAccessibility((ProfileSettingRowBinding)paramObject, paramInt2);
    case 5: 
      return onChangeAbout((ProfileSettingRowNoIconBinding)paramObject, paramInt2);
    }
    return onChangeAppSettings((ProfileSettingRowBinding)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, Object paramObject)
  {
    return false;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/ProfileFragmentBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */