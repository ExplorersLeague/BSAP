package com.blizzard.telemetry.sdk;

import com.blizzard.telemetry.proto.Context;

public class EnqueueOptions
{
  public static final int DEFAULT_PRIORITY = 0;
  private Context context = null;
  private int priority = 0;
  
  public static EnqueueOptions defaults()
  {
    return new EnqueueOptions();
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public EnqueueOptions setContext(Context paramContext)
  {
    this.context = paramContext;
    return this;
  }
  
  public EnqueueOptions setPriority(int paramInt)
  {
    this.priority = paramInt;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/EnqueueOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */