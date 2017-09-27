package com.blizzard.bgs.client.log;

public abstract interface Logger
{
  public static final String DEBUG = "DEBUG";
  public static final String ERROR = "ERROR";
  public static final String INFO = "INFO";
  public static final Logger NULL = new Logger()
  {
    public void log(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
    
    public void log(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Throwable paramAnonymousThrowable) {}
  };
  public static final String WARN = "WARN";
  
  public abstract void log(String paramString1, String paramString2, String paramString3);
  
  public abstract void log(String paramString1, String paramString2, String paramString3, Throwable paramThrowable);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/log/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */