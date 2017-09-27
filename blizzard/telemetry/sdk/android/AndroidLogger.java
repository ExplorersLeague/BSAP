package com.blizzard.telemetry.sdk.android;

import android.util.Log;
import com.blizzard.telemetry.sdk.interfaces.Logger;
import com.blizzard.telemetry.sdk.interfaces.Logger.LogLevel;
import java.util.Locale;

public class AndroidLogger
  implements Logger
{
  private String component;
  private Logger.LogLevel level;
  
  public AndroidLogger(Class<?> paramClass, Logger.LogLevel paramLogLevel)
  {
    initialize(paramClass);
    this.level = paramLogLevel;
  }
  
  public AndroidLogger(String paramString, Logger.LogLevel paramLogLevel)
  {
    initialize(paramString);
    this.level = paramLogLevel;
  }
  
  public Logger Log(Logger.LogLevel paramLogLevel, String paramString)
  {
    switch (paramLogLevel)
    {
    default: 
      return this;
    case ???: 
      Log.d(this.component, paramString);
      return this;
    case ???: 
      Log.i(this.component, paramString);
      return this;
    case ???: 
      Log.w(this.component, paramString);
      return this;
    case ???: 
      Log.e(this.component, paramString);
      return this;
    }
    Log.e(this.component, paramString);
    return this;
  }
  
  public Logger Log(Logger.LogLevel paramLogLevel, String paramString, Object... paramVarArgs)
  {
    return Log(paramLogLevel, String.format(Locale.getDefault(), paramString, paramVarArgs));
  }
  
  public Logger LogDebug(String paramString)
  {
    if (this.level.compareTo(Logger.LogLevel.LOGDEBUG) >= 0) {
      Log(Logger.LogLevel.LOGDEBUG, paramString);
    }
    return this;
  }
  
  public Logger LogDebug(String paramString, Object... paramVarArgs)
  {
    return LogDebug(String.format(Locale.getDefault(), paramString, paramVarArgs));
  }
  
  public Logger LogError(String paramString)
  {
    if (this.level.compareTo(Logger.LogLevel.LOGERROR) >= 0) {
      Log(Logger.LogLevel.LOGERROR, paramString);
    }
    return this;
  }
  
  public Logger LogError(String paramString, Object... paramVarArgs)
  {
    return LogError(String.format(Locale.getDefault(), paramString, paramVarArgs));
  }
  
  public Logger LogFatal(String paramString)
  {
    if (this.level.compareTo(Logger.LogLevel.LOGFATAL) >= 0) {
      Log(Logger.LogLevel.LOGFATAL, paramString);
    }
    return this;
  }
  
  public Logger LogFatal(String paramString, Object... paramVarArgs)
  {
    return LogFatal(String.format(Locale.getDefault(), paramString, paramVarArgs));
  }
  
  public Logger LogInfo(String paramString)
  {
    if (this.level.compareTo(Logger.LogLevel.LOGINFO) >= 0) {
      Log(Logger.LogLevel.LOGINFO, paramString);
    }
    return this;
  }
  
  public Logger LogInfo(String paramString, Object... paramVarArgs)
  {
    return LogInfo(String.format(Locale.getDefault(), paramString, paramVarArgs));
  }
  
  public Logger LogWarn(String paramString)
  {
    if (this.level.compareTo(Logger.LogLevel.LOGWARN) >= 0) {
      Log(Logger.LogLevel.LOGWARN, paramString);
    }
    return this;
  }
  
  public Logger LogWarn(String paramString, Object... paramVarArgs)
  {
    return LogWarn(String.format(Locale.getDefault(), paramString, paramVarArgs));
  }
  
  public Logger.LogLevel getLogLevel()
  {
    return this.level;
  }
  
  public Logger initialize(Class<?> paramClass)
  {
    this.component = paramClass.getSimpleName();
    this.level = Logger.LogLevel.LOGWARN;
    return this;
  }
  
  public Logger initialize(String paramString)
  {
    this.component = paramString;
    this.level = Logger.LogLevel.LOGWARN;
    return this;
  }
  
  public Logger newLogger(Class<?> paramClass, Logger.LogLevel paramLogLevel)
  {
    return new AndroidLogger(paramClass, paramLogLevel);
  }
  
  public Logger newLogger(String paramString, Logger.LogLevel paramLogLevel)
  {
    return new AndroidLogger(paramString, paramLogLevel);
  }
  
  public Logger setLogLevel(Logger.LogLevel paramLogLevel)
  {
    this.level = paramLogLevel;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/android/AndroidLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */