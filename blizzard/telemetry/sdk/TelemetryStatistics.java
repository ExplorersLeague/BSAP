package com.blizzard.telemetry.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TelemetryStatistics
{
  private Map<String, Map<String, Integer>> details = new HashMap();
  private int messagesDropped = 0;
  private int messagesEnqueued = 0;
  private int messagesFailed = 0;
  private int messagesPending = 0;
  private int messagesRetried = 0;
  private int messagesRetrying = 0;
  private int messagesSent = 0;
  private int requests = 0;
  private int requestsFailed = 0;
  private int requestsSucceeded = 0;
  
  public TelemetryStatistics()
  {
    this.details.clear();
  }
  
  public static TelemetryStatistics clone(TelemetryStatistics paramTelemetryStatistics)
  {
    return new TelemetryStatistics().setMessagesDropped(paramTelemetryStatistics.getMessagesDropped()).setMessagesEnqueued(paramTelemetryStatistics.getMessagesEnqueued()).setMessagesFailed(paramTelemetryStatistics.getMessagesFailed()).setMessagesPending(paramTelemetryStatistics.getMessagesPending()).setMessagesRetried(paramTelemetryStatistics.getMessagesRetried()).setMessagesRetrying(paramTelemetryStatistics.getMessagesRetrying()).setMessagesSent(paramTelemetryStatistics.getMessagesSent()).setRequests(paramTelemetryStatistics.getRequests()).setRequestsFailed(paramTelemetryStatistics.getRequestsFailed()).setRequestsSucceeded(paramTelemetryStatistics.getRequestsSucceeded()).setDetails(paramTelemetryStatistics.getDetails());
  }
  
  public int countVerb(String paramString)
  {
    int j = 0;
    int i = 0;
    paramString = (Map)this.details.get(paramString);
    if (paramString != null)
    {
      Iterator localIterator = paramString.keySet().iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i += ((Integer)paramString.get((String)localIterator.next())).intValue();
      }
    }
    return j;
  }
  
  public int countVerbMessage(String paramString1, String paramString2)
  {
    int j = 0;
    paramString1 = (Map)this.details.get(paramString1);
    int i = j;
    if (paramString1 != null)
    {
      paramString1 = (Integer)paramString1.get(paramString2);
      i = j;
      if (paramString1 != null) {
        i = paramString1.intValue();
      }
    }
    return i;
  }
  
  public Map<String, Integer> getCountsNamedByVerb(String paramString)
  {
    return (Map)this.details.get(paramString);
  }
  
  public Map<String, Map<String, Integer>> getDetails()
  {
    return this.details;
  }
  
  public int getMessagesDropped()
  {
    return this.messagesDropped;
  }
  
  public int getMessagesEnqueued()
  {
    return this.messagesEnqueued;
  }
  
  public int getMessagesFailed()
  {
    return this.messagesFailed;
  }
  
  public int getMessagesPending()
  {
    return this.messagesPending;
  }
  
  public int getMessagesRetried()
  {
    return this.messagesRetried;
  }
  
  public int getMessagesRetrying()
  {
    return this.messagesRetrying;
  }
  
  public int getMessagesSent()
  {
    return this.messagesSent;
  }
  
  public int getRequests()
  {
    return this.requests;
  }
  
  public int getRequestsFailed()
  {
    return this.requestsFailed;
  }
  
  public int getRequestsSucceeded()
  {
    return this.requestsSucceeded;
  }
  
  public TelemetryStatistics incrementVerbMessage(String paramString1, String paramString2)
  {
    Object localObject2 = (Map)this.details.get(paramString1);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashMap();
    }
    Integer localInteger = (Integer)((Map)localObject1).get(paramString2);
    localObject2 = localInteger;
    if (localInteger == null) {
      localObject2 = Integer.valueOf(0);
    }
    ((Map)localObject1).put(paramString2, Integer.valueOf(((Integer)localObject2).intValue() + 1));
    this.details.put(paramString1, localObject1);
    return this;
  }
  
  public TelemetryStatistics setDetails(Map<String, Map<String, Integer>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        Map localMap = (Map)paramMap.get(str1);
        Object localObject2 = (Map)localHashMap.get(str1);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new HashMap();
        }
        localObject2 = localMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str2 = (String)((Iterator)localObject2).next();
          ((Map)localObject1).put(str2, localMap.get(str2));
        }
        localHashMap.put(str1, localObject1);
      }
    }
    this.details = localHashMap;
    return this;
  }
  
  public TelemetryStatistics setMessagesDropped(int paramInt)
  {
    this.messagesDropped = paramInt;
    return this;
  }
  
  public TelemetryStatistics setMessagesEnqueued(int paramInt)
  {
    this.messagesEnqueued = paramInt;
    return this;
  }
  
  public TelemetryStatistics setMessagesFailed(int paramInt)
  {
    this.messagesFailed = paramInt;
    return this;
  }
  
  public TelemetryStatistics setMessagesPending(int paramInt)
  {
    this.messagesPending = paramInt;
    return this;
  }
  
  public TelemetryStatistics setMessagesRetried(int paramInt)
  {
    this.messagesRetried = paramInt;
    return this;
  }
  
  public TelemetryStatistics setMessagesRetrying(int paramInt)
  {
    this.messagesRetrying = paramInt;
    return this;
  }
  
  public TelemetryStatistics setMessagesSent(int paramInt)
  {
    this.messagesSent = paramInt;
    return this;
  }
  
  public TelemetryStatistics setRequests(int paramInt)
  {
    this.requests = paramInt;
    return this;
  }
  
  public TelemetryStatistics setRequestsFailed(int paramInt)
  {
    this.requestsFailed = paramInt;
    return this;
  }
  
  public TelemetryStatistics setRequestsSucceeded(int paramInt)
  {
    this.requestsSucceeded = paramInt;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/TelemetryStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */