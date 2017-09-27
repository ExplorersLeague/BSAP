package com.blizzard.login.logger;

import android.util.Log;

public class Logger
{
  public static void debug(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public static void debug(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void error(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public static void error(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void info(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public static void info(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void verbose(String paramString1, String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public static void verbose(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static void warn(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public static void warn(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/logger/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */