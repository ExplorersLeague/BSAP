package com.blizzard.telemetry.sdk.tools;

import com.blizzard.telemetry.sdk.LogWrapper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventHandler<E>
{
  private static final LogWrapper LOGGER = LogWrapper.NullLogger(EventHandler.class);
  private List<Consumer<E>> listeners = new CopyOnWriteArrayList();
  
  public void addListener(Consumer<E> paramConsumer)
  {
    this.listeners.add(paramConsumer);
  }
  
  public void newEvent(E paramE)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      Consumer localConsumer = (Consumer)localIterator.next();
      try
      {
        localConsumer.accept(paramE);
      }
      catch (Exception localException)
      {
        LOGGER.LogWarn("Event listenener threw an exception! " + localException.getMessage());
      }
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/tools/EventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */