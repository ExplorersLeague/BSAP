package com.blizzard.telemetry.sdk;

import com.blizzard.telemetry.sdk.interfaces.Logger.LogLevel;
import java.text.MessageFormat;
import org.slf4j.LoggerFactory;

public class Slf4jLogger
  implements com.blizzard.telemetry.sdk.interfaces.Logger
{
  private Logger.LogLevel level;
  org.slf4j.Logger logger;
  
  public Slf4jLogger()
  {
    this.level = Logger.LogLevel.LOGWARN;
  }
  
  public Slf4jLogger(Logger.LogLevel paramLogLevel)
  {
    this.level = paramLogLevel;
  }
  
  public Slf4jLogger(Class<?> paramClass, Logger.LogLevel paramLogLevel)
  {
    this.level = paramLogLevel;
    initialize(paramClass);
  }
  
  public Slf4jLogger(String paramString, Logger.LogLevel paramLogLevel)
  {
    this.level = paramLogLevel;
    initialize(paramString);
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger Log(Logger.LogLevel paramLogLevel, String paramString)
  {
    switch (paramLogLevel)
    {
    default: 
      return this;
    case ???: 
      LogDebug(paramString);
      return this;
    case ???: 
      LogInfo(paramString);
      return this;
    case ???: 
      LogWarn(paramString);
      return this;
    case ???: 
      LogError(paramString);
      return this;
    }
    LogFatal(paramString);
    return this;
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger Log(Logger.LogLevel paramLogLevel, String paramString, Object... paramVarArgs)
  {
    return Log(paramLogLevel, MessageFormat.format(paramString, paramVarArgs));
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogDebug(String paramString)
  {
    if ((Logger.LogLevel.LOGDEBUG.compareTo(this.level) >= 0) && (this.logger != null)) {
      this.logger.debug(paramString);
    }
    return this;
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogDebug(String paramString, Object... paramVarArgs)
  {
    return LogDebug(MessageFormat.format(paramString, paramVarArgs));
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogError(String paramString)
  {
    if ((Logger.LogLevel.LOGERROR.compareTo(this.level) >= 0) && (this.logger != null)) {
      this.logger.error(paramString);
    }
    return this;
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogError(String paramString, Object... paramVarArgs)
  {
    return LogError(MessageFormat.format(paramString, paramVarArgs));
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogFatal(String paramString)
  {
    if ((Logger.LogLevel.LOGFATAL.compareTo(this.level) >= 0) && (this.logger != null)) {
      this.logger.error(paramString);
    }
    return this;
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogFatal(String paramString, Object... paramVarArgs)
  {
    return LogFatal(MessageFormat.format(paramString, paramVarArgs));
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogInfo(String paramString)
  {
    if ((Logger.LogLevel.LOGINFO.compareTo(this.level) >= 0) && (this.logger != null)) {
      this.logger.info(paramString);
    }
    return this;
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogInfo(String paramString, Object... paramVarArgs)
  {
    return LogInfo(MessageFormat.format(paramString, paramVarArgs));
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogWarn(String paramString)
  {
    if ((Logger.LogLevel.LOGWARN.compareTo(this.level) >= 0) && (this.logger != null)) {
      this.logger.warn(paramString);
    }
    return this;
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger LogWarn(String paramString, Object... paramVarArgs)
  {
    return LogWarn(MessageFormat.format(paramString, paramVarArgs));
  }
  
  public Logger.LogLevel getLogLevel()
  {
    return this.level;
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger initialize(Class<?> paramClass)
  {
    this.logger = LoggerFactory.getLogger(paramClass);
    return this;
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger initialize(String paramString)
  {
    this.logger = LoggerFactory.getLogger(paramString);
    return this;
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger newLogger(Class<?> paramClass, Logger.LogLevel paramLogLevel)
  {
    return new Slf4jLogger(paramClass, paramLogLevel);
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger newLogger(String paramString, Logger.LogLevel paramLogLevel)
  {
    return new Slf4jLogger(paramString, paramLogLevel);
  }
  
  public com.blizzard.telemetry.sdk.interfaces.Logger setLogLevel(Logger.LogLevel paramLogLevel)
  {
    this.level = paramLogLevel;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/Slf4jLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */