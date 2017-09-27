package com.blizzard.messenger.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blizzard.messenger.views.dialog.MessengerDialogFragment;
import rx.Completable;
import rx.android.schedulers.AndroidSchedulers;

public class ViewUtils
{
  public static float convertDpToPixel(float paramFloat, Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F * paramFloat;
  }
  
  public static DividerItemDecoration getDivider(Context paramContext, int paramInt)
  {
    DividerItemDecoration localDividerItemDecoration = new DividerItemDecoration(paramContext, paramInt);
    localDividerItemDecoration.setDrawable(ContextCompat.getDrawable(paramContext, 2130837739));
    return localDividerItemDecoration;
  }
  
  public static View getEmptyView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130968636, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131820763);
    TextView localTextView1 = (TextView)localView.findViewById(2131820691);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131820692);
    TextView localTextView2 = (TextView)localView.findViewById(2131820693);
    if (paramInt1 != 0)
    {
      localImageView.setImageResource(paramInt1);
      if (paramInt2 == 0) {
        break label132;
      }
      localImageView.setContentDescription(paramContext.getString(paramInt2));
      label89:
      if (paramInt3 == 0) {
        break label142;
      }
      localTextView1.setText(paramContext.getString(paramInt3));
    }
    for (;;)
    {
      if (paramInt4 == 0) {
        break label152;
      }
      localTextView2.setText(paramContext.getString(paramInt4));
      return localView;
      localImageView.setVisibility(8);
      break;
      label132:
      localImageView.setVisibility(8);
      break label89;
      label142:
      localTextView1.setVisibility(8);
    }
    label152:
    localLinearLayout.setVisibility(8);
    return localView;
  }
  
  public static MessengerDialogFragment getErrorFragment(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("PositiveButton", paramString3);
    localBundle.putString("NegativeButton", paramString4);
    localBundle.putString("Message", paramString2);
    localBundle.putString("Title", paramString1);
    return MessengerDialogFragment.newInstance(localBundle);
  }
  
  public static void hideKeyboard(Activity paramActivity)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    View localView2 = paramActivity.getCurrentFocus();
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = new View(paramActivity);
    }
    localInputMethodManager.hideSoftInputFromWindow(localView1.getWindowToken(), 0);
  }
  
  public static void reportError(@NonNull Activity paramActivity, @NonNull Completable paramCompletable)
  {
    ToastMaster localToastMaster = new ToastMaster(paramActivity);
    paramActivity = paramActivity.getString(2131361917);
    paramCompletable.observeOn(AndroidSchedulers.mainThread()).subscribe(ViewUtils..Lambda.3.lambdaFactory$(), ViewUtils..Lambda.4.lambdaFactory$(localToastMaster, paramActivity));
  }
  
  public static void reportSuccessOrFailure(@NonNull Activity paramActivity, @NonNull Completable paramCompletable, @NonNull String paramString)
  {
    ToastMaster localToastMaster = new ToastMaster(paramActivity);
    paramActivity = paramActivity.getString(2131361917);
    paramCompletable.observeOn(AndroidSchedulers.mainThread()).subscribe(ViewUtils..Lambda.1.lambdaFactory$(localToastMaster, paramString), ViewUtils..Lambda.2.lambdaFactory$(localToastMaster, paramActivity));
  }
  
  public static void showSnackbar(Context paramContext, View paramView, String paramString)
  {
    paramView = Snackbar.make(paramView, paramString, -1);
    paramView.getView().setBackgroundColor(ColorUtils.getColorPrimary(paramContext));
    paramView.show();
  }
  
  public static void showUnavailableActionMessage(@NonNull FragmentActivity paramFragmentActivity)
  {
    MessengerDialogFragment localMessengerDialogFragment = getErrorFragment(paramFragmentActivity.getString(2131361905), paramFragmentActivity.getString(2131361904), null, null);
    if (localMessengerDialogFragment != null)
    {
      paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
      paramFragmentActivity.add(localMessengerDialogFragment, "ErrorFragment");
      paramFragmentActivity.commitAllowingStateLoss();
    }
  }
  
  public static void tintMenuIcon(Context paramContext, MenuItem paramMenuItem, @ColorRes int paramInt)
  {
    Drawable localDrawable = DrawableCompat.wrap(paramMenuItem.getIcon());
    DrawableCompat.setTint(localDrawable, paramContext.getResources().getColor(paramInt));
    paramMenuItem.setIcon(localDrawable);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */