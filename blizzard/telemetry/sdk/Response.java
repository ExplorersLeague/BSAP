package com.blizzard.telemetry.sdk;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Response
{
  private int code = 0;
  private Throwable exception = null;
  private String message;
  private long requestDurationMs = 0L;
  private Map<String, String> responseHeadersMap = new HashMap();
  
  public Response(int paramInt)
  {
    setCode(paramInt);
  }
  
  public Response(Throwable paramThrowable)
  {
    setException(paramThrowable);
  }
  
  private Double getDoubleHeader(String paramString)
  {
    paramString = getStringHeader(paramString);
    if (paramString != null) {
      return Double.valueOf(Double.parseDouble(paramString));
    }
    return null;
  }
  
  private Integer getIntHeader(String paramString)
  {
    paramString = getStringHeader(paramString);
    if (paramString != null) {
      return Integer.valueOf(Integer.parseInt(paramString));
    }
    return null;
  }
  
  private String getStringHeader(String paramString)
  {
    return (String)this.responseHeadersMap.get(paramString);
  }
  
  public Response addResponseHeader(String paramString1, String paramString2)
  {
    return setResponseHeader(paramString1, paramString2);
  }
  
  public void dump()
  {
    dump("");
  }
  
  public void dump(String paramString)
  {
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    paramString = (String)localObject1;
    Object localObject2;
    if (!((String)localObject1).isEmpty())
    {
      localObject2 = localObject1;
      if (((String)localObject1).endsWith(":")) {
        localObject2 = (String)localObject1 + " ";
      }
      paramString = (String)localObject2;
      if (!((String)localObject2).endsWith(": ")) {
        paramString = (String)localObject2 + ": ";
      }
    }
    System.out.format("debug: %s.code     ='%d'\r\n", new Object[] { paramString, getCode() });
    System.out.format("debug: %s.duration ='%d' ms\r\n", new Object[] { paramString, Long.valueOf(getRequestDurationMs()) });
    if (hasException()) {
      System.out.format("debug: %s.exception='%s: %s'\r\n", new Object[] { paramString, getException().getClass().getSimpleName(), getException().getMessage() });
    }
    if (getResponseHeaders() != null)
    {
      System.out.format("debug: %s.headers#%d\r\n", new Object[] { paramString, Integer.valueOf(getResponseHeaders().size()) });
      localObject1 = getResponseHeaders().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        System.out.format("debug: %s.header[%s]='%s'\r\n", new Object[] { paramString, localObject2, getResponseHeaders().get(localObject2) });
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    int i;
    label43:
    int j;
    label199:
    label202:
    label204:
    label225:
    label234:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (Response.class.isAssignableFrom(paramObject.getClass()))
          {
            paramObject = (Response)paramObject;
            if (this.code == ((Response)paramObject).code)
            {
              if (this.responseHeadersMap == null)
              {
                i = 1;
                if (((Response)paramObject).responseHeadersMap != null) {
                  break label199;
                }
              }
              for (j = 1;; j = 0)
              {
                if (i != j) {
                  break label202;
                }
                if ((this.responseHeadersMap == null) || (((Response)paramObject).responseHeadersMap == null)) {
                  break label204;
                }
                if ((!this.responseHeadersMap.keySet().containsAll(((Response)paramObject).responseHeadersMap.keySet())) || (!((Response)paramObject).responseHeadersMap.keySet().containsAll(this.responseHeadersMap.keySet()))) {
                  break;
                }
                Iterator localIterator = this.responseHeadersMap.keySet().iterator();
                String str;
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  str = (String)localIterator.next();
                } while (((String)this.responseHeadersMap.get(str)).equals(((Response)paramObject).responseHeadersMap.get(str)));
                return false;
                i = 0;
                break label43;
              }
            }
          }
        }
      } while (this.requestDurationMs != ((Response)paramObject).requestDurationMs);
      if (this.exception != null) {
        break;
      }
      i = 1;
      if (((Response)paramObject).exception != null) {
        break label294;
      }
      j = 1;
      if ((i != j) || ((this.exception != null) && (((Response)paramObject).exception != null) && (!this.exception.getMessage().equals(((Response)paramObject).exception.getMessage())))) {
        break label297;
      }
      if (this.message != null) {
        break label299;
      }
    } while (((Response)paramObject).message != null);
    label294:
    label297:
    label299:
    while (this.message.equals(((Response)paramObject).message))
    {
      return true;
      i = 0;
      break label225;
      j = 0;
      break label234;
      break;
    }
    return false;
  }
  
  public Integer getCode()
  {
    return Integer.valueOf(this.code);
  }
  
  public Throwable getException()
  {
    return this.exception;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public Integer getRateLimit()
  {
    return getIntHeader("X-Rate-Limit-Limit");
  }
  
  public Double getRateLimitReset()
  {
    return getDoubleHeader("X-Rate-Limit-Reset");
  }
  
  public long getRequestDurationMs()
  {
    return this.requestDurationMs;
  }
  
  public Map<String, String> getResponseHeaders()
  {
    return this.responseHeadersMap;
  }
  
  public String getSessionId()
  {
    return getStringHeader("Telemetry-SessionId");
  }
  
  public String getSourceId()
  {
    return getStringHeader("Telemetry-SourceId");
  }
  
  public boolean hasException()
  {
    return this.exception != null;
  }
  
  public boolean hasMessage()
  {
    return this.message != null;
  }
  
  public boolean hasResponseHeaders()
  {
    return !this.responseHeadersMap.isEmpty();
  }
  
  public Response setCode(int paramInt)
  {
    this.code = paramInt;
    return this;
  }
  
  public Response setException(Throwable paramThrowable)
  {
    this.exception = paramThrowable;
    return this;
  }
  
  public Response setMessage(String paramString)
  {
    this.message = paramString;
    return this;
  }
  
  public Response setRequestDurationMs(long paramLong)
  {
    this.requestDurationMs = paramLong;
    return this;
  }
  
  public Response setResponseHeader(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      this.responseHeadersMap.remove(paramString1);
      return this;
    }
    this.responseHeadersMap.put(paramString1, paramString2);
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */