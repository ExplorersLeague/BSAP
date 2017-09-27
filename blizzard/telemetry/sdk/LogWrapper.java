package com.blizzard.telemetry.sdk;

import com.blizzard.telemetry.sdk.interfaces.Logger;
import com.blizzard.telemetry.sdk.interfaces.Logger.LogLevel;
import java.text.MessageFormat;

public class LogWrapper
  implements Logger
{
  private String component;
  private Logger logger;
  
  public LogWrapper()
  {
    this.component = "";
    this.logger = null;
  }
  
  public LogWrapper(Logger paramLogger)
  {
    this.component = "";
    this.logger = null;
    if (paramLogger != null) {
      this.logger = paramLogger.newLogger(this.component, paramLogger.getLogLevel());
    }
  }
  
  public LogWrapper(Class<?> paramClass, Logger paramLogger)
  {
    this.component = paramClass.getName();
    this.logger = null;
    if (paramLogger != null) {
      this.logger = paramLogger.newLogger(this.component, paramLogger.getLogLevel());
    }
  }
  
  public LogWrapper(String paramString, Logger paramLogger)
  {
    this.component = paramString;
    this.logger = null;
    if (paramLogger != null) {
      this.logger = paramLogger.newLogger(this.component, paramLogger.getLogLevel());
    }
  }
  
  public static LogWrapper NullLogger(Class<?> paramClass)
  {
    return new LogWrapper(paramClass, null);
  }
  
  public static LogWrapper NullLogger(String paramString)
  {
    return new LogWrapper(paramString, null);
  }
  
  public Logger Log(Logger.LogLevel paramLogLevel, String paramString)
  {
    if (this.logger != null) {
      this.logger.Log(paramLogLevel, paramString);
    }
    return this;
  }
  
  public Logger Log(Logger.LogLevel paramLogLevel, String paramString, Object... paramVarArgs)
  {
    if (this.logger != null) {
      this.logger.Log(paramLogLevel, MessageFormat.format(paramString, paramVarArgs));
    }
    return this;
  }
  
  public Logger LogDebug(String paramString)
  {
    if (this.logger != null) {
      this.logger.LogDebug(paramString);
    }
    return this;
  }
  
  public Logger LogDebug(String paramString, Object... paramVarArgs)
  {
    if (this.logger != null) {
      this.logger.LogDebug(MessageFormat.format(paramString, paramVarArgs));
    }
    return this;
  }
  
  public Logger LogError(String paramString)
  {
    if (this.logger != null) {
      this.logger.LogError(paramString);
    }
    return this;
  }
  
  public Logger LogError(String paramString, Object... paramVarArgs)
  {
    if (this.logger != null) {
      this.logger.LogError(MessageFormat.format(paramString, paramVarArgs));
    }
    return this;
  }
  
  public Logger LogFatal(String paramString)
  {
    if (this.logger != null) {
      this.logger.LogFatal(paramString);
    }
    return this;
  }
  
  public Logger LogFatal(String paramString, Object... paramVarArgs)
  {
    if (this.logger != null) {
      this.logger.LogFatal(MessageFormat.format(paramString, paramVarArgs));
    }
    return this;
  }
  
  public Logger LogInfo(String paramString)
  {
    if (this.logger != null) {
      this.logger.LogInfo(paramString);
    }
    return this;
  }
  
  public Logger LogInfo(String paramString, Object... paramVarArgs)
  {
    if (this.logger != null) {
      this.logger.LogInfo(MessageFormat.format(paramString, paramVarArgs));
    }
    return this;
  }
  
  public Logger LogWarn(String paramString)
  {
    if (this.logger != null) {
      this.logger.LogWarn(paramString);
    }
    return this;
  }
  
  public Logger LogWarn(String paramString, Object... paramVarArgs)
  {
    if (this.logger != null) {
      this.logger.LogWarn(MessageFormat.format(paramString, paramVarArgs));
    }
    return this;
  }
  
  public Logger.LogLevel getLogLevel()
  {
    if (this.logger != null) {
      return this.logger.getLogLevel();
    }
    return Logger.LogLevel.LOGNONE;
  }
  
  public Logger getLogger()
  {
    return this.logger;
  }
  
  public Logger initialize(Class<?> paramClass)
  {
    if (this.logger != null) {
      this.logger.initialize(paramClass);
    }
    return this;
  }
  
  public Logger initialize(String paramString)
  {
    if (this.logger != null) {
      this.logger.initialize(paramString);
    }
    return this;
  }
  
  public Logger newLogger(Class<?> paramClass, Logger.LogLevel paramLogLevel)
  {
    if (this.logger == null) {
      return NullLogger(paramClass);
    }
    return new LogWrapper(paramClass, this.logger.newLogger(paramClass, paramLogLevel));
  }
  
  public Logger newLogger(String paramString, Logger.LogLevel paramLogLevel)
  {
    if (this.logger == null) {
      return NullLogger(paramString);
    }
    return new LogWrapper(paramString, this.logger.newLogger(paramString, paramLogLevel));
  }
  
  public Logger setLogLevel(Logger.LogLevel paramLogLevel)
  {
    Object localObject = this;
    if (this.logger != null) {
      localObject = this.logger.setLogLevel(paramLogLevel);
    }
    return (Logger)localObject;
  }
  
  public Logger setLogger(Logger paramLogger)
  {
    this.logger = paramLogger;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/LogWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */