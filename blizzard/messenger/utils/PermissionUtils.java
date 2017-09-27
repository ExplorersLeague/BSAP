package com.blizzard.messenger.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import com.blizzard.messenger.ui.settings.PermissionRationaleDialogFragment;
import rx.Completable;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class PermissionUtils
{
  private static String[] NETEASE_PERMISSIONS = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  public static final int REQUEST_CAMERA_PERMISSIONS = 500;
  public static final int REQUEST_NETEASE_PERMISSIONS = 900;
  
  public static boolean hasNeteasePermissions(Context paramContext)
  {
    return hasPermissions(paramContext, NETEASE_PERMISSIONS);
  }
  
  private static boolean hasPermissions(Context paramContext, String... paramVarArgs)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext != null) && (paramVarArgs != null))
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        if (ActivityCompat.checkSelfPermission(paramContext, paramVarArgs[i]) != 0) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static boolean isPermissionGranted(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 500) {
      paramInt = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (paramInt < paramArrayOfString.length)
      {
        if (!"android.permission.CAMERA".equals(paramArrayOfString[paramInt])) {
          break label48;
        }
        bool1 = bool2;
        if (paramArrayOfInt[paramInt] == 0) {
          bool1 = true;
        }
      }
      return bool1;
      label48:
      paramInt += 1;
    }
  }
  
  public static void requestNeteasePermissions(Activity paramActivity)
  {
    ActivityCompat.requestPermissions(paramActivity, NETEASE_PERMISSIONS, 900);
  }
  
  public static Observable<String> requestPermission(@NonNull FragmentActivity paramFragmentActivity, int paramInt, @NonNull String paramString)
  {
    BehaviorSubject localBehaviorSubject = BehaviorSubject.create();
    if (ContextCompat.checkSelfPermission(paramFragmentActivity, paramString) != 0)
    {
      if (ActivityCompat.shouldShowRequestPermissionRationale(paramFragmentActivity, paramString))
      {
        PermissionRationaleDialogFragment localPermissionRationaleDialogFragment = PermissionRationaleDialogFragment.newInstance();
        localPermissionRationaleDialogFragment.onAccepted().subscribe(PermissionUtils..Lambda.1.lambdaFactory$(paramFragmentActivity, paramString, paramInt));
        localPermissionRationaleDialogFragment.show(paramFragmentActivity.getSupportFragmentManager(), "PermissionRationaleDialogFragment");
        return localBehaviorSubject;
      }
      ActivityCompat.requestPermissions(paramFragmentActivity, new String[] { paramString }, paramInt);
      return localBehaviorSubject;
    }
    localBehaviorSubject.onNext(paramString);
    return localBehaviorSubject;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/PermissionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */