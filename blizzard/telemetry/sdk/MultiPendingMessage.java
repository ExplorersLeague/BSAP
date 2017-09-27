package com.blizzard.telemetry.sdk;

import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MultiPendingMessage
{
  private ArrayList<PendingMessage> list_ = new ArrayList();
  private Map<String, String> requestHeadersMap = new HashMap();
  
  public MultiPendingMessage() {}
  
  public MultiPendingMessage(PendingMessage paramPendingMessage)
  {
    this.list_.add(paramPendingMessage);
  }
  
  private String getStringHeader(String paramString)
  {
    return (String)this.requestHeadersMap.get(paramString);
  }
  
  public void addRequest(PendingMessage paramPendingMessage)
  {
    synchronized (this.list_)
    {
      this.list_.add(paramPendingMessage);
      return;
    }
  }
  
  public Request buildRequest()
  {
    if (this.list_.size() == 1) {
      return ((PendingMessage)this.list_.get(0)).buildRequest();
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.requestHeadersMap.keySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localHashMap.put(localObject2, this.requestHeadersMap.get(localObject2));
    }
    localHashMap.put("Content-Type", "multipart/mixed; boundary=\"" + "blizzard.telemetry" + "\"");
    if (!localHashMap.containsKey("User-Agent")) {
      localHashMap.put("User-Agent", "com.blizzard.telemetry.sdk.java/2.0");
    }
    localObject1 = new ByteArrayOutputStream();
    try
    {
      localObject2 = this.list_.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (PendingMessage)((Iterator)localObject2).next();
        try
        {
          localObject3 = ((PendingMessage)localObject3).buildRequest().setRequestHeader("Content-Type", "application/octet-stream").build(false);
          ((ByteArrayOutputStream)localObject1).write(("\r\n--" + "blizzard.telemetry" + "\r\n").getBytes("ASCII"));
          ((ByteArrayOutputStream)localObject1).write((byte[])localObject3, 0, localObject3.length);
        }
        catch (Exception localException2)
        {
          System.err.println("exception: MultiPendingMessage.buildRequest: building inner message body: " + localException2.getMessage());
        }
        continue;
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
      }
    }
    catch (Exception localException1)
    {
      System.err.println("exception: MultiPendingMessage.buildRequest: building outer message body: " + localException1.getMessage());
    }
    for (;;)
    {
      return new Request().setMethod("POST").setRequestHeaders(localHashMap).setRequestHeader("Content-Length", String.valueOf(localObject1.length)).setBody(ByteString.copyFrom((byte[])localObject1));
      ((ByteArrayOutputStream)localObject1).write(("\r\n--" + "blizzard.telemetry" + "--\r\n").getBytes("ASCII"));
    }
  }
  
  public Request buildRequest(String paramString)
  {
    return buildRequest().setUri(paramString);
  }
  
  public Request buildRequest(URI paramURI)
  {
    return buildRequest().setUri(paramURI);
  }
  
  public int count()
  {
    synchronized (this.list_)
    {
      int i = this.list_.size();
      return i;
    }
  }
  
  public PendingMessage get(int paramInt)
  {
    ArrayList localArrayList = this.list_;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < this.list_.size())
      {
        PendingMessage localPendingMessage = (PendingMessage)this.list_.get(paramInt);
        return localPendingMessage;
      }
      return null;
    }
    finally {}
  }
  
  public Iterator<PendingMessage> getIterator()
  {
    return this.list_.iterator();
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
  
  public boolean hasRequestHeaders()
  {
    return !this.requestHeadersMap.isEmpty();
  }
  
  public MultiPendingMessage setRequestHeader(String paramString, Double paramDouble)
  {
    this.requestHeadersMap.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public MultiPendingMessage setRequestHeader(String paramString, Integer paramInteger)
  {
    this.requestHeadersMap.put(paramString, String.valueOf(paramInteger));
    return this;
  }
  
  public MultiPendingMessage setRequestHeader(String paramString1, String paramString2)
  {
    this.requestHeadersMap.put(paramString1, paramString2);
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/MultiPendingMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */