package com.blizzard.telemetry.sdk;

import com.blizzard.telemetry.sdk.tools.Clock;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Request
{
  private ByteString body = null;
  private String method = "GET";
  private Map<String, String> requestHeadersMap = new HashMap();
  private URI uri = null;
  private String version = "HTTP/1.1";
  
  public Request addRequestHeaders(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.requestHeadersMap.put(str, paramMap.get(str));
      }
    }
    return this;
  }
  
  public byte[] build()
    throws Exception
  {
    return build(true);
  }
  
  public byte[] build(boolean paramBoolean)
    throws Exception
  {
    if ((this.uri == null) && (paramBoolean)) {
      throw new IllegalStateException("uri==null and includeFirstLines==true; call .setUri() before calling .build()");
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (paramBoolean)
    {
      localObject2 = this.uri.getPath();
      localObject1 = localObject2;
      if (this.uri.getQuery() != null)
      {
        localObject1 = localObject2;
        if (!this.uri.getQuery().isEmpty()) {
          localObject1 = (String)localObject2 + this.uri.getQuery();
        }
      }
      localByteArrayOutputStream.write(String.format("%1$s %2$s %3$s\r\n", new Object[] { this.method, localObject1, this.version }).getBytes("ASCII"));
      localObject2 = this.uri.getHost();
      localObject1 = localObject2;
      if (this.uri.getPort() != 0) {
        localObject1 = (String)localObject2 + ":" + String.valueOf(this.uri.getPort());
      }
      if (!this.requestHeadersMap.containsKey("User-Agent")) {
        this.requestHeadersMap.put("User-Agent", "blizzard.telemetry.sdk.java/2.0");
      }
      this.requestHeadersMap.put("Host", localObject1);
      localObject1 = Clock.systemUTC();
      this.requestHeadersMap.put("Date", ((Clock)localObject1).rfc1123(((Clock)localObject1).millis()));
    }
    Object localObject2 = this.requestHeadersMap;
    if ((this.body == null) || (this.body.isEmpty())) {}
    for (Object localObject1 = "0";; localObject1 = String.valueOf(this.body.size()))
    {
      ((Map)localObject2).put("Content-Length", localObject1);
      localObject1 = this.requestHeadersMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localByteArrayOutputStream.write(String.format("%1$s: %2$s\r\n", new Object[] { localObject2, this.requestHeadersMap.get(localObject2) }).getBytes("ASCII"));
      }
    }
    localByteArrayOutputStream.write("\r\n".getBytes("ASCII"));
    if ((this.body != null) && (!this.body.isEmpty())) {
      localByteArrayOutputStream.write(this.body.toByteArray());
    }
    return localByteArrayOutputStream.toByteArray();
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
    System.out.format("debug: %s.method ='%s'\r\n", new Object[] { paramString, getMethod() });
    System.out.format("debug: %s.version='%s'\r\n", new Object[] { paramString, getVersion() });
    System.out.format("debug: %s.uri    ='%s'\r\n", new Object[] { paramString, getUri() });
    System.out.format("debug: %s.headers#%d\r\n", new Object[] { paramString, Integer.valueOf(getRequestHeaders().size()) });
    localObject1 = getRequestHeaders().keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      System.out.format("debug: %s.header[%s]='%s'\r\n", new Object[] { paramString, localObject2, getRequestHeaders().get(localObject2) });
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    label37:
    label51:
    label65:
    label74:
    label241:
    label257:
    label273:
    label278:
    label281:
    label283:
    do
    {
      for (;;)
      {
        return false;
        if (Request.class.isAssignableFrom(paramObject.getClass()))
        {
          paramObject = (Request)paramObject;
          int i;
          if (this.method == null)
          {
            if (((Request)paramObject).method != null) {
              continue;
            }
            if (this.version != null) {
              break label241;
            }
            if (((Request)paramObject).version != null) {
              continue;
            }
            if (this.uri != null) {
              break label257;
            }
            if (((Request)paramObject).uri != null) {
              continue;
            }
            if (this.requestHeadersMap != null) {
              break label273;
            }
            i = 1;
            if (((Request)paramObject).requestHeadersMap != null) {
              break label278;
            }
          }
          for (int j = 1;; j = 0)
          {
            if (i != j) {
              break label281;
            }
            if ((this.requestHeadersMap == null) || (((Request)paramObject).requestHeadersMap == null)) {
              break label283;
            }
            if ((!this.requestHeadersMap.keySet().containsAll(((Request)paramObject).requestHeadersMap.keySet())) || (!((Request)paramObject).requestHeadersMap.keySet().containsAll(this.requestHeadersMap.keySet()))) {
              break;
            }
            Iterator localIterator = this.requestHeadersMap.keySet().iterator();
            String str;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              str = (String)localIterator.next();
            } while (((String)this.requestHeadersMap.get(str)).equals(((Request)paramObject).requestHeadersMap.get(str)));
            return false;
            if (this.method.equals(((Request)paramObject).method)) {
              break label37;
            }
            return false;
            if (this.version.equals(((Request)paramObject).version)) {
              break label51;
            }
            return false;
            if (this.uri.equals(((Request)paramObject).uri)) {
              break label65;
            }
            return false;
            i = 0;
            break label74;
          }
        }
      }
      if (this.body != null) {
        break;
      }
    } while (((Request)paramObject).body != null);
    while (this.body.equals(((Request)paramObject).body)) {
      return true;
    }
    return false;
  }
  
  public ByteString getBody()
  {
    return this.body;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public String getRequestHeader(String paramString)
  {
    String str = (String)this.requestHeadersMap.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public Map<String, String> getRequestHeaders()
  {
    return this.requestHeadersMap;
  }
  
  public URI getUri()
  {
    return this.uri;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public boolean hasBody()
  {
    return this.body != null;
  }
  
  public boolean hasRequestHeaders()
  {
    return !this.requestHeadersMap.isEmpty();
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int j;
    if (this.method != null)
    {
      i = this.method.hashCode();
      if (this.version == null) {
        break label93;
      }
      j = this.version.hashCode();
      label33:
      if (this.requestHeadersMap == null) {
        break label98;
      }
    }
    label93:
    label98:
    for (int k = this.requestHeadersMap.hashCode();; k = 0)
    {
      if (this.body != null) {
        m = this.body.hashCode();
      }
      return (((i + 329) * 47 + j) * 47 + k) * 47 + m;
      i = 0;
      break;
      j = 0;
      break label33;
    }
  }
  
  public Request setBody(ByteString paramByteString)
  {
    this.body = paramByteString;
    return this;
  }
  
  public Request setMethod(String paramString)
  {
    this.method = paramString;
    return this;
  }
  
  public Request setRequestHeader(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      this.requestHeadersMap.remove(paramString1);
      return this;
    }
    this.requestHeadersMap.put(paramString1, paramString2);
    return this;
  }
  
  public Request setRequestHeaders(Map<String, String> paramMap)
  {
    this.requestHeadersMap.clear();
    return addRequestHeaders(paramMap);
  }
  
  public Request setUri(String paramString)
  {
    return setUri(URI.create(paramString));
  }
  
  public Request setUri(URI paramURI)
  {
    this.uri = paramURI;
    return this;
  }
  
  public Request setVersion(String paramString)
  {
    this.version = paramString;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */