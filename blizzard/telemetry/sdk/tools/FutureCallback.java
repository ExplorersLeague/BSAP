package com.blizzard.telemetry.sdk.tools;

public abstract interface FutureCallback<V>
{
  public abstract void onFailure(Throwable paramThrowable);
  
  public abstract void onSuccess(V paramV);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/tools/FutureCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */