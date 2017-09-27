package com.blizzard.messenger.utils;

import android.util.Log;
import com.blizzard.messenger.model.ExceptionText;
import org.jivesoftware.smack.SmackException.ConnectionException;

public class ExceptionUtils
{
  private static final String TAG = ExceptionUtils.class.getSimpleName();
  
  public static ExceptionText getExceptionText(Throwable paramThrowable)
  {
    Log.w(TAG, paramThrowable.getClass().toString());
    paramThrowable.printStackTrace();
    if ((paramThrowable instanceof SmackException.ConnectionException)) {
      return new ExceptionText(2131361916, 2131361915);
    }
    return new ExceptionText(2131361907, 2131361906);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/ExceptionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */