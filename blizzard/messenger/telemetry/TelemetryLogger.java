package com.blizzard.messenger.telemetry;

import android.util.Log;
import com.blizzard.telemetry.sdk.interfaces.Logger;
import com.blizzard.telemetry.sdk.interfaces.Logger.LogLevel;
import java.util.Locale;

class TelemetryLogger
  implements Logger
{
  private Logger.LogLevel logLevel;
  private String tag;
  
  public TelemetryLogger(Class<?> paramClass, Logger.LogLevel paramLogLevel)
  {
    initialize(paramClass);
    this.logLevel = paramLogLevel;
  }
  
  private TelemetryLogger(String paramString, Logger.LogLevel paramLogLevel)
  {
    initialize(paramString);
    this.logLevel = paramLogLevel;
  }
  
  private boolean shouldLog(Logger.LogLevel paramLogLevel)
  {
    return paramLogLevel.compareTo(this.logLevel) > 0;
  }
  
  public Logger Log(Logger.LogLevel paramLogLevel, String paramString)
  {
    if (shouldLog(paramLogLevel)) {}
    switch (paramLogLevel)
    {
    default: 
      return this;
    case ???: 
      Log.d(this.tag, paramString);
      return this;
    case ???: 
      Log.i(this.tag, paramString);
      return this;
    case ???: 
      Log.w(this.tag, paramString);
      return this;
    }
    Log.e(this.tag, paramString);
    return this;
  }
  
  public Logger Log(Logger.LogLevel paramLogLevel, String paramString, Object... paramVarArgs)
  {
    return Log(paramLogLevel, String.format(Locale.getDefault(), paramString, paramVarArgs));
  }
  
  public Logger LogDebug(String paramString)
  {
    return Log(Logger.LogLevel.LOGDEBUG, paramString);
  }
  
  public Logger LogDebug(String paramString, Object... paramVarArgs)
  {
    return Log(Logger.LogLevel.LOGDEBUG, paramString, paramVarArgs);
  }
  
  public Logger LogError(String paramString)
  {
    return Log(Logger.LogLevel.LOGERROR, paramString);
  }
  
  public Logger LogError(String paramString, Object... paramVarArgs)
  {
    return Log(Logger.LogLevel.LOGERROR, paramString, paramVarArgs);
  }
  
  public Logger LogFatal(String paramString)
  {
    return Log(Logger.LogLevel.LOGFATAL, paramString);
  }
  
  public Logger LogFatal(String paramString, Object... paramVarArgs)
  {
    return Log(Logger.LogLevel.LOGFATAL, paramString, paramVarArgs);
  }
  
  public Logger LogInfo(String paramString)
  {
    return Log(Logger.LogLevel.LOGINFO, paramString);
  }
  
  public Logger LogInfo(String paramString, Object... paramVarArgs)
  {
    return Log(Logger.LogLevel.LOGINFO, paramString, paramVarArgs);
  }
  
  public Logger LogWarn(String paramString)
  {
    return Log(Logger.LogLevel.LOGWARN, paramString);
  }
  
  public Logger LogWarn(String paramString, Object... paramVarArgs)
  {
    return Log(Logger.LogLevel.LOGWARN, paramString, paramVarArgs);
  }
  
  public Logger.LogLevel getLogLevel()
  {
    return this.logLevel;
  }
  
  public Logger initialize(Class<?> paramClass)
  {
    this.tag = paramClass.getSimpleName();
    return this;
  }
  
  public Logger initialize(String paramString)
  {
    this.tag = paramString;
    return this;
  }
  
  public Logger newLogger(Class<?> paramClass, Logger.LogLevel paramLogLevel)
  {
    return new TelemetryLogger(paramClass, paramLogLevel);
  }
  
  public Logger newLogger(String paramString, Logger.LogLevel paramLogLevel)
  {
    return new TelemetryLogger(paramString, paramLogLevel);
  }
  
  public Logger setLogLevel(Logger.LogLevel paramLogLevel)
  {
    this.logLevel = paramLogLevel;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/telemetry/TelemetryLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */