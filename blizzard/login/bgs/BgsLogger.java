package com.blizzard.login.bgs;

class BgsLogger
  implements com.blizzard.bgs.client.log.Logger
{
  public static BgsLogger INSTANCE = new BgsLogger();
  
  public void log(String paramString1, String paramString2, String paramString3)
  {
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        com.blizzard.login.logger.Logger.debug(paramString2, paramString3);
        return;
        if (paramString1.equals("INFO"))
        {
          i = 0;
          continue;
          if (paramString1.equals("WARN"))
          {
            i = 1;
            continue;
            if (paramString1.equals("ERROR")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    com.blizzard.login.logger.Logger.info(paramString2, paramString3);
    return;
    com.blizzard.login.logger.Logger.warn(paramString2, paramString3);
    return;
    com.blizzard.login.logger.Logger.error(paramString2, paramString3);
  }
  
  public void log(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        com.blizzard.login.logger.Logger.debug(paramString2, paramString3, paramThrowable);
        return;
        if (paramString1.equals("INFO"))
        {
          i = 0;
          continue;
          if (paramString1.equals("WARN"))
          {
            i = 1;
            continue;
            if (paramString1.equals("ERROR")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    com.blizzard.login.logger.Logger.info(paramString2, paramString3, paramThrowable);
    return;
    com.blizzard.login.logger.Logger.warn(paramString2, paramString3, paramThrowable);
    return;
    com.blizzard.login.logger.Logger.error(paramString2, paramString3, paramThrowable);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/bgs/BgsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */