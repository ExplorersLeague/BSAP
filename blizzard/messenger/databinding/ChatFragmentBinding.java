package com.blizzard.messenger.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blizzard.messenger.ui.common.KeyboardAwareEditText;
import com.flipboard.bottomsheet.BottomSheetLayout;

public class ChatFragmentBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final AppCompatTextView appearingOfflineBar;
  public final BottomSheetLayout bottomSheet;
  public final View chatDivider;
  public final RelativeLayout content;
  public final LinearLayout emptyLayout;
  private long mDirtyFlags = -1L;
  public final KeyboardAwareEditText messageEditText;
  public final LinearLayout messageInputLinearLayout;
  public final RecyclerView messagesListView;
  public final LinearLayout parent;
  public final LinearLayout scrollToBottomLinearLayout;
  public final FloatingActionButton sendMessageButton;
  public final LinearLayout syncingBanner;
  
  static
  {
    sViewsWithIds.put(2131820566, 1);
    sViewsWithIds.put(2131820725, 2);
    sViewsWithIds.put(2131820708, 3);
    sViewsWithIds.put(2131820726, 4);
    sViewsWithIds.put(2131820728, 5);
    sViewsWithIds.put(2131820729, 6);
    sViewsWithIds.put(2131820727, 7);
    sViewsWithIds.put(2131820730, 8);
    sViewsWithIds.put(2131820731, 9);
    sViewsWithIds.put(2131820732, 10);
    sViewsWithIds.put(2131820733, 11);
  }
  
  public ChatFragmentBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 12, sIncludes, sViewsWithIds);
    this.appearingOfflineBar = ((AppCompatTextView)paramDataBindingComponent[2]);
    this.bottomSheet = ((BottomSheetLayout)paramDataBindingComponent[0]);
    this.bottomSheet.setTag(null);
    this.chatDivider = ((View)paramDataBindingComponent[8]);
    this.content = ((RelativeLayout)paramDataBindingComponent[3]);
    this.emptyLayout = ((LinearLayout)paramDataBindingComponent[5]);
    this.messageEditText = ((KeyboardAwareEditText)paramDataBindingComponent[10]);
    this.messageInputLinearLayout = ((LinearLayout)paramDataBindingComponent[9]);
    this.messagesListView = ((RecyclerView)paramDataBindingComponent[4]);
    this.parent = ((LinearLayout)paramDataBindingComponent[1]);
    this.scrollToBottomLinearLayout = ((LinearLayout)paramDataBindingComponent[6]);
    this.sendMessageButton = ((FloatingActionButton)paramDataBindingComponent[11]);
    this.syncingBanner = ((LinearLayout)paramDataBindingComponent[7]);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static ChatFragmentBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static ChatFragmentBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/chat_fragment_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new ChatFragmentBinding(paramDataBindingComponent, paramView);
  }
  
  public static ChatFragmentBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static ChatFragmentBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968613, null, false), paramDataBindingComponent);
  }
  
  public static ChatFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static ChatFragmentBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (ChatFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968613, paramViewGroup, paramBoolean, paramDataBindingComponent);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/databinding/ChatFragmentBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */