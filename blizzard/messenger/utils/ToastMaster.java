package com.blizzard.messenger.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.blizzard.messenger.providers.MessengerProvider;
import java.lang.ref.WeakReference;

public final class ToastMaster
{
  @Nullable
  private static volatile WeakReference<Toast> lastToast = null;
  private final Context context;
  private final View errorView;
  private final View infoView;
  
  public ToastMaster(@NonNull Activity paramActivity)
  {
    this.context = paramActivity.getApplicationContext();
    this.infoView = paramActivity.getLayoutInflater().inflate(2130968649, (ViewGroup)paramActivity.findViewById(2131820764));
    this.errorView = paramActivity.getLayoutInflater().inflate(2130968637, (ViewGroup)paramActivity.findViewById(2131820764));
  }
  
  public static void cancel()
  {
    Toast localToast = getLastToast();
    if (localToast != null)
    {
      localToast.cancel();
      setLastToast(null);
    }
  }
  
  private static Toast getLastToast()
  {
    if (lastToast == null) {
      return null;
    }
    return (Toast)lastToast.get();
  }
  
  private static void setLastToast(@Nullable Toast paramToast)
  {
    lastToast = new WeakReference(paramToast);
  }
  
  private void showCustomToast(@NonNull View paramView, int paramInt, @NonNull String paramString)
  {
    if (MessengerProvider.getInstance().isAppSuspended()) {
      return;
    }
    cancel();
    ((TextView)paramView.findViewById(paramInt)).setText(paramString);
    paramString = new Toast(this.context);
    paramString.setGravity(17, 0, 0);
    paramString.setDuration(1);
    paramString.setView(paramView);
    paramString.show();
    setLastToast(paramString);
  }
  
  public void showErrorToast(@NonNull String paramString)
  {
    showCustomToast(this.errorView, 2131820765, paramString);
  }
  
  public void showInfoToast(@NonNull String paramString)
  {
    showCustomToast(this.infoView, 2131820765, paramString);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/ToastMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */