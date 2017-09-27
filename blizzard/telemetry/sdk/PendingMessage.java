package com.blizzard.telemetry.sdk;

import com.blizzard.telemetry.proto.Context;
import com.blizzard.telemetry.proto.Context.Builder;
import com.blizzard.telemetry.proto.Envelope;
import com.blizzard.telemetry.proto.Envelope.Builder;
import com.google.protobuf.ByteString;
import java.io.PrintStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class PendingMessage
{
  private static AtomicLong nextId = new AtomicLong();
  private Envelope envelope = null;
  private long id = nextId.incrementAndGet();
  private EnqueueOptions options = null;
  private long queueTime = 0L;
  private Map<String, String> requestHeadersMap = new HashMap();
  private int retryCount = 0;
  private long sendTime = 0L;
  
  private String getStringHeader(String paramString)
  {
    return (String)this.requestHeadersMap.get(paramString);
  }
  
  public Request buildRequest()
  {
    ByteString localByteString = this.envelope.toByteString();
    return new Request().setMethod("POST").setRequestHeaders(this.requestHeadersMap).setRequestHeader("Content-Length", String.valueOf(localByteString.size())).setBody(localByteString);
  }
  
  public Request buildRequest(String paramString)
  {
    return buildRequest().setUri(paramString);
  }
  
  public Request buildRequest(URI paramURI)
  {
    return buildRequest().setUri(paramURI);
  }
  
  public void dump()
  {
    dump(null);
  }
  
  public void dump(String paramString)
  {
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    paramString = (String)localObject1;
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
    System.out.format("debug: %s.id        ='%d'\r\n", new Object[] { paramString, Long.valueOf(id()) });
    System.out.format("debug: %s.retryCount='%d'\r\n", new Object[] { paramString, Integer.valueOf(getRetryCount()) });
    System.out.format("debug: %s.queueTime ='%d'\r\n", new Object[] { paramString, Long.valueOf(getQueueTime()) });
    System.out.format("debug: %s.sendTime  ='%d'\r\n", new Object[] { paramString, Long.valueOf(getSendTime()) });
    Object localObject2 = System.out;
    if (getEnvelope() == null)
    {
      localObject1 = "null";
      ((PrintStream)localObject2).format("debug: %s.envelope  ='%s'\r\n", new Object[] { paramString, localObject1 });
      localObject2 = System.out;
      if (getOptions() != null) {
        break label368;
      }
    }
    label368:
    for (localObject1 = "null";; localObject1 = getOptions().toString())
    {
      ((PrintStream)localObject2).format("debug: %s.options   ='%s'\r\n", new Object[] { paramString, localObject1 });
      System.out.format("debug: %s.headers#%d\r\n", new Object[] { paramString, Integer.valueOf(getRequestHeaders().size()) });
      localObject1 = getRequestHeaders().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        System.out.format("debug: %s.header[%s]='%s'\r\n", new Object[] { paramString, localObject2, getRequestHeaders().get(localObject2) });
      }
      localObject1 = getEnvelope().toString();
      break;
    }
  }
  
  public Context getContext()
  {
    return (Context)((Context.Builder)this.envelope.getContext().toBuilder()).build();
  }
  
  public Envelope getEnvelope()
  {
    return this.envelope;
  }
  
  public String getMessageName()
  {
    return this.envelope.getMessageName();
  }
  
  public EnqueueOptions getOptions()
  {
    return this.options;
  }
  
  public String getPackageMessageName()
  {
    return getPackageName() + "/" + getMessageName();
  }
  
  public String getPackageName()
  {
    return this.envelope.getPackageName();
  }
  
  public long getQueueTime()
  {
    return this.queueTime;
  }
  
  public String getRequestHeader(String paramString)
  {
    return getStringHeader(paramString);
  }
  
  public String getRequestHeader(String paramString1, String paramString2)
  {
    String str = getStringHeader(paramString1);
    if (str != null)
    {
      paramString1 = str;
      if (!str.isEmpty()) {}
    }
    else
    {
      paramString1 = paramString2;
    }
    return paramString1;
  }
  
  public Map<String, String> getRequestHeaders()
  {
    return this.requestHeadersMap;
  }
  
  public int getRetryCount()
  {
    return this.retryCount;
  }
  
  public long getSendTime()
  {
    return this.sendTime;
  }
  
  public ByteString getSerializedMessage()
  {
    return ByteString.copyFrom(this.envelope.getContents().toByteArray());
  }
  
  public boolean hasRequestHeaders()
  {
    return !this.requestHeadersMap.isEmpty();
  }
  
  public int hashCode()
  {
    return new Long(this.id).hashCode();
  }
  
  public long id()
  {
    return this.id;
  }
  
  public PendingMessage setEnvelope(Envelope paramEnvelope)
  {
    if (paramEnvelope == null) {}
    for (paramEnvelope = Envelope.newBuilder();; paramEnvelope = (Envelope.Builder)paramEnvelope.toBuilder())
    {
      this.envelope = ((Envelope)paramEnvelope.build());
      return this;
    }
  }
  
  public PendingMessage setOptions(EnqueueOptions paramEnqueueOptions)
  {
    this.options = paramEnqueueOptions;
    return this;
  }
  
  public PendingMessage setQueueTime(long paramLong)
  {
    this.queueTime = paramLong;
    return this;
  }
  
  public PendingMessage setRequestHeader(String paramString, Double paramDouble)
  {
    this.requestHeadersMap.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public PendingMessage setRequestHeader(String paramString, Integer paramInteger)
  {
    this.requestHeadersMap.put(paramString, String.valueOf(paramInteger));
    return this;
  }
  
  public PendingMessage setRequestHeader(String paramString1, String paramString2)
  {
    this.requestHeadersMap.put(paramString1, paramString2);
    return this;
  }
  
  public PendingMessage setRetryCount(int paramInt)
  {
    this.retryCount = paramInt;
    return this;
  }
  
  public PendingMessage setSendTime(long paramLong)
  {
    this.sendTime = paramLong;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/PendingMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */