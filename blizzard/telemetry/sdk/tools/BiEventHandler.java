package com.blizzard.telemetry.sdk.tools;

import com.blizzard.telemetry.sdk.LogWrapper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BiEventHandler<I, O>
{
  private static final LogWrapper LOGGER = LogWrapper.NullLogger(BiEventHandler.class);
  private List<BiConsumer<I, O>> listeners = new CopyOnWriteArrayList();
  
  public void addListener(BiConsumer<I, O> paramBiConsumer)
  {
    this.listeners.add(paramBiConsumer);
  }
  
  public void newEvent(I paramI, O paramO)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      BiConsumer localBiConsumer = (BiConsumer)localIterator.next();
      try
      {
        localBiConsumer.accept(paramI, paramO);
      }
      catch (Exception localException)
      {
        LOGGER.LogWarn("Event listenener threw an exception! " + localException.getMessage());
      }
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/tools/BiEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */