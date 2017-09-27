package com.blizzard.messenger.data.utils;

import android.text.TextUtils;
import android.util.Log;
import com.blizzard.messenger.data.listeners.ConnectionErrorListener;
import com.blizzard.messenger.data.listeners.SettingsUpdateListener;

public class ErrorUtils
{
  private static final String TAG = ErrorUtils.class.getSimpleName();
  
  public static void handleError(Exception paramException, ConnectionErrorListener paramConnectionErrorListener)
  {
    Log.w(TAG, paramException.getMessage());
    paramException.printStackTrace();
    if (paramConnectionErrorListener != null) {
      paramConnectionErrorListener.onConnectionError(paramException);
    }
  }
  
  public static void handleError(Exception paramException, SettingsUpdateListener paramSettingsUpdateListener)
  {
    Log.w(TAG, paramException.getMessage());
    if (paramSettingsUpdateListener != null) {
      paramSettingsUpdateListener.onSettingUpdateFailed(paramException.getMessage());
    }
  }
  
  public static void handleError(Throwable paramThrowable)
  {
    if (!TextUtils.isEmpty(paramThrowable.getMessage()))
    {
      Log.w(TAG, paramThrowable.getMessage());
      paramThrowable.printStackTrace();
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/ErrorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */