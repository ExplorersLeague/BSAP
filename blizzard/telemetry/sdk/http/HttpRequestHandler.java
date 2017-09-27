package com.blizzard.telemetry.sdk.http;

import com.blizzard.telemetry.sdk.LogWrapper;
import com.blizzard.telemetry.sdk.Request;
import com.blizzard.telemetry.sdk.TelemetryOptions;
import com.blizzard.telemetry.sdk.implementation.RequestHandlerBase;
import com.blizzard.telemetry.sdk.interfaces.RequestHandler;
import com.blizzard.telemetry.sdk.tools.Clock;
import com.blizzard.telemetry.sdk.tools.FutureCallback;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.protobuf.ByteString;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.AsyncHttpClientConfig.Builder;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpRequestHandler
  extends RequestHandlerBase
{
  private AsyncHttpClient httpClient;
  private URI telemetryIngestUri;
  
  private static com.blizzard.telemetry.sdk.Response buildResponse(com.ning.http.client.Response paramResponse)
    throws IOException
  {
    com.blizzard.telemetry.sdk.Response localResponse = new com.blizzard.telemetry.sdk.Response(paramResponse.getStatusCode());
    Iterator localIterator = paramResponse.getHeaders().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      Object localObject = paramResponse.getHeaders().get(str3);
      String str1 = "";
      String str2 = str1;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          str2 = str1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          String str4 = (String)((Iterator)localObject).next();
          str2 = str1;
          if (!str1.isEmpty()) {
            str2 = str1 + ", ";
          }
          str1 = str2 + str4;
        }
      }
      localResponse.addResponseHeader(str3, str2);
    }
    localResponse.setMessage(paramResponse.getResponseBody());
    return localResponse;
  }
  
  private static com.blizzard.telemetry.sdk.Response buildResponse(InputStream paramInputStream)
    throws IOException
  {
    com.blizzard.telemetry.sdk.Response localResponse = new com.blizzard.telemetry.sdk.Response(200);
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = System.getProperty("line.separator");
    for (;;)
    {
      String str2 = paramInputStream.readLine();
      if (str2 == null) {
        break;
      }
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
    }
    paramInputStream.close();
    localResponse.setMessage(localStringBuilder.toString());
    return localResponse;
  }
  
  private void setBody(AsyncHttpClient.BoundRequestBuilder paramBoundRequestBuilder, Request paramRequest)
    throws IOException
  {
    String str2 = paramRequest.getRequestHeader("Content-Type");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.isEmpty()) {}
    }
    else
    {
      str1 = "application/octet-stream";
    }
    paramRequest = paramRequest.getBody().toByteArray();
    paramBoundRequestBuilder.setHeader("Content-Length", String.valueOf(paramRequest.length));
    paramBoundRequestBuilder.setHeader("Content-Type", str1);
    paramBoundRequestBuilder.setBody(paramRequest);
  }
  
  private void setHttpHeaders(AsyncHttpClient.BoundRequestBuilder paramBoundRequestBuilder, Request paramRequest)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Iterator localIterator = paramRequest.getRequestHeaders().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str != "Content-Length") && (str != "Content-Type") && (str != "Date") && (str != "Host"))
      {
        if (str == "User-Agent") {
          localBoolean = Boolean.valueOf(true);
        }
        paramBoundRequestBuilder.addHeader(str, (String)paramRequest.getRequestHeaders().get(str));
      }
    }
    if (!localBoolean.booleanValue()) {
      paramBoundRequestBuilder.addHeader("User-Agent", "telemetry-sdk-java/2.0");
    }
  }
  
  public void close()
  {
    if (this.httpClient != null)
    {
      this.httpClient.close();
      this.httpClient = null;
    }
  }
  
  public void doSendAsync(Request paramRequest, final FutureCallback<com.blizzard.telemetry.sdk.Response> paramFutureCallback)
  {
    try
    {
      if (this.httpClient == null) {
        throw new IllegalStateException("call RequestHandler.initialize(options) first!");
      }
    }
    catch (Exception paramRequest)
    {
      this.LOGGER.LogInfo("doSendAsync: exception: {0}: {1}", new Object[] { paramRequest.getClass().getSimpleName(), paramRequest.getMessage() });
      paramFutureCallback.onFailure(paramRequest);
      return;
    }
    if (paramFutureCallback == null) {
      throw new IllegalArgumentException("'callback' may not be null");
    }
    if (paramRequest.getUri() == null)
    {
      paramRequest.setUri(this.telemetryIngestUri);
      paramRequest.setMethod("POST");
    }
    Object localObject2 = paramRequest.getUri();
    Object localObject3 = new StringBuilder().append(((URI)localObject2).getHost());
    if (((URI)localObject2).getPort() != 0) {}
    for (Object localObject1 = ":" + String.valueOf(((URI)localObject2).getPort());; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      this.LOGGER.LogInfo("doSendAsync([{0} -> {1}], ...)", new Object[] { paramRequest.getMethod(), localObject2 });
      if (paramRequest.getMethod() == "POST") {}
      for (localObject1 = this.httpClient.preparePost(((URI)localObject2).toString());; localObject1 = this.httpClient.prepareGet(((URI)localObject2).toString()))
      {
        setBody((AsyncHttpClient.BoundRequestBuilder)localObject1, paramRequest);
        setHttpHeaders((AsyncHttpClient.BoundRequestBuilder)localObject1, paramRequest);
        ((AsyncHttpClient.BoundRequestBuilder)localObject1).addHeader("Host", (String)localObject3);
        localObject2 = getOptions().getClock();
        paramRequest = (Request)localObject2;
        if (localObject2 == null) {
          paramRequest = Clock.systemUTC();
        }
        ((AsyncHttpClient.BoundRequestBuilder)localObject1).setHeader("Date", paramRequest.rfc1123(paramRequest.millis()));
        this.httpClient.executeRequest(((AsyncHttpClient.BoundRequestBuilder)localObject1).build(), new AsyncCompletionHandler()
        {
          public Void onCompleted(com.ning.http.client.Response paramAnonymousResponse)
            throws Exception
          {
            try
            {
              paramAnonymousResponse = HttpRequestHandler.buildResponse(paramAnonymousResponse);
              HttpRequestHandler.this.LOGGER.LogInfo("doSendAsync.onCompleted: success: {0}", new Object[] { paramAnonymousResponse.getCode() });
              paramFutureCallback.onSuccess(paramAnonymousResponse);
              return null;
            }
            catch (Exception paramAnonymousResponse)
            {
              for (;;)
              {
                HttpRequestHandler.this.LOGGER.LogInfo("doSendAsync.onCompleted: exception: {0}: {1}", new Object[] { paramAnonymousResponse.getClass().getSimpleName(), paramAnonymousResponse.getMessage() });
                paramFutureCallback.onFailure(paramAnonymousResponse);
              }
            }
          }
          
          public void onThrowable(Throwable paramAnonymousThrowable)
          {
            super.onThrowable(paramAnonymousThrowable);
            HttpRequestHandler.this.LOGGER.LogInfo("doSendAsync.onThrowable: exception: {0}", new Object[] { paramAnonymousThrowable.getMessage() });
            paramFutureCallback.onFailure(paramAnonymousThrowable);
          }
        });
        return;
        if (paramRequest.getMethod() != "GET") {
          break;
        }
      }
      throw new IllegalArgumentException("The request.method is unknown: '" + paramRequest.getMethod() + "'");
    }
  }
  
  public com.blizzard.telemetry.sdk.Response doSendSync(Request paramRequest)
  {
    try
    {
      if (this.httpClient == null)
      {
        this.LOGGER.LogInfo("doSendSync: exception: IllegalStateException: call RequestHandler.initialize(options) first!");
        throw new IllegalStateException("call RequestHandler.initialize(options) first!");
      }
    }
    catch (Exception paramRequest)
    {
      this.LOGGER.LogInfo("doSendSync: exception: {0}: {1}", new Object[] { paramRequest.getClass().getSimpleName(), paramRequest.getMessage() });
      return new com.blizzard.telemetry.sdk.Response(paramRequest);
    }
    if (paramRequest.getUri() == null)
    {
      paramRequest.setUri(this.telemetryIngestUri);
      paramRequest.setMethod("POST");
    }
    Object localObject = paramRequest.getUri();
    URLConnection localURLConnection = (URLConnection)FirebasePerfUrlConnection.instrument(new URL(paramRequest.getUri().toString()).openConnection());
    this.LOGGER.LogInfo("urlConnection.type='" + localURLConnection.getClass().getSimpleName() + "'");
    localURLConnection.setRequestProperty("Content-Language", "en-US");
    localURLConnection.setUseCaches(false);
    this.LOGGER.LogInfo("doSendSync([{0} -> {1}])", new Object[] { paramRequest.getMethod(), localObject });
    if ((paramRequest.hasBody()) && (paramRequest.getBody().size() > 0))
    {
      this.LOGGER.LogInfo("doSendSync: adding {} body bytes", new Object[] { Integer.valueOf(paramRequest.getBody().size()) });
      localURLConnection.setRequestProperty("Content-Length", Integer.toString(paramRequest.getBody().size()));
      localURLConnection.setDoOutput(true);
      localObject = new DataOutputStream(localURLConnection.getOutputStream());
      ((DataOutputStream)localObject).write(paramRequest.getBody().toByteArray());
      ((DataOutputStream)localObject).close();
    }
    paramRequest = buildResponse(localURLConnection.getInputStream());
    return paramRequest;
  }
  
  public RequestHandler initialize(TelemetryOptions paramTelemetryOptions)
  {
    if (this.httpClient != null)
    {
      this.LOGGER.LogError("Call close() before calling initialize() a second time.");
      return this;
    }
    super.initialize(paramTelemetryOptions);
    this.LOGGER = new LogWrapper(HttpRequestHandler.class, paramTelemetryOptions.getLogger());
    this.httpClient = new AsyncHttpClient(new AsyncHttpClientConfig.Builder().setAllowPoolingConnections(true).setFollowRedirect(false).setMaxConnectionsPerHost(paramTelemetryOptions.getMaxConcurrentRequests()).build());
    this.LOGGER.LogInfo(".maxConcurrentRequests={0}.", new Object[] { Integer.valueOf(paramTelemetryOptions.getMaxConcurrentRequests()) });
    this.telemetryIngestUri = URI.create(paramTelemetryOptions.getIngestUrl());
    this.LOGGER.LogInfo(".telemetryIngestUri={0}", new Object[] { this.telemetryIngestUri });
    return this;
  }
  
  public boolean isInitialized()
  {
    return (super.isInitialized()) && (this.httpClient != null);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/http/HttpRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */