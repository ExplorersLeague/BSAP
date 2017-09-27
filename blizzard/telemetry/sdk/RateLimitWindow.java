package com.blizzard.telemetry.sdk;

import com.blizzard.telemetry.sdk.tools.Clock;
import com.blizzard.telemetry.sdk.tools.Function;

public class RateLimitWindow
{
  public static final int FUDGE_FACTOR_MS = 100;
  private static final LogWrapper LOGGER = LogWrapper.NullLogger(RateLimitWindow.class);
  private Clock clock = Clock.systemUTC();
  private boolean enabled;
  private boolean rateLimitWindowKnown;
  private Integer remainingRequestsAllowedInWindow;
  private int requestLimitPerWindow;
  private int unknownSent;
  private Function<Long, Boolean> waiter;
  private double windowResetTimestamp;
  
  public RateLimitWindow()
  {
    this(true);
  }
  
  public RateLimitWindow(boolean paramBoolean)
  {
    enable(paramBoolean);
    this.waiter = new Function()
    {
      public Boolean apply(Long paramAnonymousLong)
      {
        try
        {
          Thread.sleep(paramAnonymousLong.longValue());
          return Boolean.valueOf(true);
        }
        catch (InterruptedException paramAnonymousLong)
        {
          Thread.currentThread().interrupt();
        }
        return Boolean.valueOf(false);
      }
    };
  }
  
  /* Error */
  public void calculateWindowIfNecessary(Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/blizzard/telemetry/sdk/RateLimitWindow:enabled	Z
    //   6: ifeq +92 -> 98
    //   9: aload_0
    //   10: getfield 64	com/blizzard/telemetry/sdk/RateLimitWindow:rateLimitWindowKnown	Z
    //   13: ifne +85 -> 98
    //   16: aload_1
    //   17: invokevirtual 70	com/blizzard/telemetry/sdk/Response:getRateLimit	()Ljava/lang/Integer;
    //   20: astore 4
    //   22: aload 4
    //   24: ifnull +74 -> 98
    //   27: aload_0
    //   28: aload 4
    //   30: invokevirtual 76	java/lang/Integer:intValue	()I
    //   33: putfield 78	com/blizzard/telemetry/sdk/RateLimitWindow:requestLimitPerWindow	I
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 80	com/blizzard/telemetry/sdk/RateLimitWindow:remainingRequestsAllowedInWindow	Ljava/lang/Integer;
    //   41: aload_1
    //   42: invokevirtual 84	com/blizzard/telemetry/sdk/Response:getRateLimitReset	()Ljava/lang/Double;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +54 -> 101
    //   50: aload_1
    //   51: invokevirtual 90	java/lang/Double:doubleValue	()D
    //   54: dstore_2
    //   55: aload_0
    //   56: dload_2
    //   57: putfield 92	com/blizzard/telemetry/sdk/RateLimitWindow:windowResetTimestamp	D
    //   60: getstatic 35	com/blizzard/telemetry/sdk/RateLimitWindow:LOGGER	Lcom/blizzard/telemetry/sdk/LogWrapper;
    //   63: ldc 94
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: getfield 92	com/blizzard/telemetry/sdk/RateLimitWindow:windowResetTimestamp	D
    //   75: invokestatic 98	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_0
    //   82: getfield 78	com/blizzard/telemetry/sdk/RateLimitWindow:requestLimitPerWindow	I
    //   85: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokevirtual 105	com/blizzard/telemetry/sdk/LogWrapper:LogInfo	(Ljava/lang/String;[Ljava/lang/Object;)Lcom/blizzard/telemetry/sdk/interfaces/Logger;
    //   92: pop
    //   93: aload_0
    //   94: iconst_1
    //   95: putfield 64	com/blizzard/telemetry/sdk/RateLimitWindow:rateLimitWindowKnown	Z
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: dconst_0
    //   102: dstore_2
    //   103: goto -48 -> 55
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	RateLimitWindow
    //   0	111	1	paramResponse	Response
    //   54	49	2	d	double
    //   20	9	4	localInteger	Integer
    // Exception table:
    //   from	to	target	type
    //   2	22	106	finally
    //   27	46	106	finally
    //   50	55	106	finally
    //   55	98	106	finally
  }
  
  void customWaiter(Function<Long, Boolean> paramFunction)
  {
    this.waiter = paramFunction;
  }
  
  public final void enable(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public Integer getRemainingRequestsForWindow()
  {
    return this.remainingRequestsAllowedInWindow;
  }
  
  public int getRequestLimitPerWindow()
  {
    return this.requestLimitPerWindow;
  }
  
  public double getResetTimestampForWindow()
  {
    return this.windowResetTimestamp;
  }
  
  public void incrementAndWaitIfNecessary()
  {
    if (incrementRequestCount()) {
      waitForNextWindow();
    }
  }
  
  public boolean incrementRequestCount()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.enabled)
    {
      if (!this.rateLimitWindowKnown) {
        break label83;
      }
      if (this.remainingRequestsAllowedInWindow == null)
      {
        this.remainingRequestsAllowedInWindow = Integer.valueOf(this.requestLimitPerWindow - this.unknownSent);
        this.unknownSent = 0;
      }
      Integer localInteger = this.remainingRequestsAllowedInWindow;
      this.remainingRequestsAllowedInWindow = Integer.valueOf(this.remainingRequestsAllowedInWindow.intValue() - 1);
      bool1 = bool2;
      if (this.remainingRequestsAllowedInWindow.intValue() < 0) {
        bool1 = true;
      }
    }
    return bool1;
    label83:
    this.unknownSent += 1;
    return false;
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public boolean rateLimitIsKnown()
  {
    return this.rateLimitWindowKnown;
  }
  
  public void resetWindow()
  {
    this.rateLimitWindowKnown = false;
  }
  
  public void setClock(Clock paramClock)
  {
    if (paramClock != null) {
      this.clock = paramClock;
    }
  }
  
  public void waitForNextWindow()
  {
    if ((this.enabled) && (this.rateLimitWindowKnown))
    {
      long l = this.clock.millis() - this.clock.toInstant(this.windowResetTimestamp);
      if (l <= 0L) {
        break label71;
      }
      if (((Boolean)this.waiter.apply(Long.valueOf(100L + l))).booleanValue()) {
        resetWindow();
      }
    }
    return;
    label71:
    resetWindow();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/RateLimitWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */