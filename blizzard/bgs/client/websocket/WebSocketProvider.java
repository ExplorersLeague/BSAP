package com.blizzard.bgs.client.websocket;

import com.blizzard.bgs.client.exception.DisconnectException;
import com.blizzard.bgs.client.log.Logger;
import com.blizzard.bgs.client.security.CertificateBundle;
import com.blizzard.bgs.client.security.WhitelistHostVerifier;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.ByteString;
import rx.Emitter.BackpressureMode;
import rx.Observable;
import rx.Observer;
import rx.subjects.PublishSubject;

public class WebSocketProvider
{
  private static final int CLOSE_NORMAL_CODE = 1000;
  private static final String TAG = WebSocketProvider.class.getSimpleName();
  private final OkHttpClient httpClient;
  private final Request httpRequest;
  private final Logger logger;
  private final String subProtocol;
  private final String url;
  
  private WebSocketProvider(Builder paramBuilder)
  {
    if (paramBuilder.url == null) {
      throw new IllegalArgumentException("url cannot be null");
    }
    if (paramBuilder.logger != null)
    {
      localObject = paramBuilder.logger;
      this.logger = ((Logger)localObject);
      this.url = paramBuilder.url;
      if (paramBuilder.subProtocol == null) {
        break label170;
      }
    }
    label170:
    for (Object localObject = paramBuilder.subProtocol;; localObject = "jsonrpc.aurora.v1.31.battle.net")
    {
      this.subProtocol = ((String)localObject);
      this.httpClient = new OkHttpClient.Builder().hostnameVerifier(newHostnameVerifier(paramBuilder.certificateBundle)).connectTimeout(paramBuilder.connectTimeout, TimeUnit.MILLISECONDS).readTimeout(paramBuilder.readTimeout, TimeUnit.MILLISECONDS).writeTimeout(paramBuilder.writeTimeout, TimeUnit.MILLISECONDS).pingInterval(paramBuilder.keepAliveInterval, TimeUnit.MILLISECONDS).build();
      this.httpRequest = new Request.Builder().addHeader("Sec-WebSocket-Protocol", this.subProtocol).url(paramBuilder.url).build();
      return;
      localObject = Logger.NULL;
      break;
    }
  }
  
  private void doClose(WebSocket paramWebSocket, AtomicBoolean paramAtomicBoolean)
  {
    paramAtomicBoolean.set(true);
    paramWebSocket.close(1000, "unsubscribed");
  }
  
  private HostnameVerifier newHostnameVerifier(CertificateBundle paramCertificateBundle)
  {
    if ((paramCertificateBundle == null) || (paramCertificateBundle.getCertificateWhitelist() == null) || (paramCertificateBundle.getCertificateWhitelist().isEmpty())) {
      return OkHostnameVerifier.INSTANCE;
    }
    return new WhitelistHostVerifier(this.logger, paramCertificateBundle.getCertificateWhitelist());
  }
  
  private WebSocketListener newListener(final Observer<WebSocketSession> paramObserver, final AtomicBoolean paramAtomicBoolean)
  {
    new WebSocketListener()
    {
      PublishSubject<WebSocketMessage> rxMessages = PublishSubject.create();
      WebSocketSession session;
      PublishSubject<WebSocketMessage> txMessages = PublishSubject.create();
      
      public void onClosed(WebSocket paramAnonymousWebSocket, int paramAnonymousInt, String paramAnonymousString)
      {
        WebSocketProvider.this.logger.log("DEBUG", WebSocketProvider.TAG, "closed: code=" + paramAnonymousInt + ", reason=" + paramAnonymousString);
        paramAtomicBoolean.set(false);
        this.rxMessages.onCompleted();
        this.txMessages.onCompleted();
        paramObserver.onCompleted();
      }
      
      public void onClosing(WebSocket paramAnonymousWebSocket, int paramAnonymousInt, String paramAnonymousString)
      {
        WebSocketProvider.this.logger.log("DEBUG", WebSocketProvider.TAG, "closing: code=" + paramAnonymousInt + ", reason=" + paramAnonymousString);
        paramAtomicBoolean.set(true);
        this.rxMessages.onCompleted();
        this.txMessages.onCompleted();
        paramObserver.onCompleted();
      }
      
      public void onFailure(WebSocket paramAnonymousWebSocket, Throwable paramAnonymousThrowable, Response paramAnonymousResponse)
      {
        if (!paramAtomicBoolean.get())
        {
          WebSocketProvider.this.logger.log("DEBUG", WebSocketProvider.TAG, "error: response=" + paramAnonymousResponse, paramAnonymousThrowable);
          paramAnonymousWebSocket = new DisconnectException("Socket error: " + paramAnonymousThrowable, paramAnonymousThrowable);
          this.rxMessages.onError(paramAnonymousWebSocket);
          this.txMessages.onError(paramAnonymousWebSocket);
          paramObserver.onError(paramAnonymousWebSocket);
        }
      }
      
      public void onMessage(WebSocket paramAnonymousWebSocket, String paramAnonymousString)
      {
        WebSocketProvider.this.logger.log("DEBUG", WebSocketProvider.TAG, "text message received: " + paramAnonymousString);
        if (this.rxMessages.hasObservers()) {
          this.rxMessages.onNext(WebSocketProvider.this.newMessage(this.session, 1, paramAnonymousString, null));
        }
      }
      
      public void onMessage(WebSocket paramAnonymousWebSocket, ByteString paramAnonymousByteString)
      {
        WebSocketProvider.this.logger.log("DEBUG", WebSocketProvider.TAG, "binary message received: " + paramAnonymousByteString);
        this.rxMessages.onNext(WebSocketProvider.this.newMessage(this.session, 2, null, paramAnonymousByteString));
      }
      
      public void onOpen(WebSocket paramAnonymousWebSocket, Response paramAnonymousResponse)
      {
        WebSocketProvider.this.logger.log("DEBUG", WebSocketProvider.TAG, "opened: " + paramAnonymousResponse);
        paramAtomicBoolean.set(false);
        this.session = WebSocketProvider.this.newSession(paramAnonymousWebSocket, paramObserver, this.rxMessages, this.txMessages);
        paramObserver.onNext(this.session);
      }
    };
  }
  
  private WebSocketMessage newMessage(final WebSocketSession paramWebSocketSession, final int paramInt, final String paramString, final ByteString paramByteString)
  {
    new WebSocketMessage()
    {
      public ByteString getBinary()
      {
        return paramByteString;
      }
      
      public WebSocketSession getSession()
      {
        return paramWebSocketSession;
      }
      
      public String getText()
      {
        return paramString;
      }
      
      public int getType()
      {
        return paramInt;
      }
    };
  }
  
  private WebSocketSession newSession(final WebSocket paramWebSocket, final Observer<WebSocketSession> paramObserver, final PublishSubject<WebSocketMessage> paramPublishSubject1, final PublishSubject<WebSocketMessage> paramPublishSubject2)
  {
    new WebSocketSession()
    {
      public void close(String paramAnonymousString)
      {
        if (paramWebSocket.close(1000, paramAnonymousString)) {
          WebSocketProvider.this.logger.log("DEBUG", WebSocketProvider.TAG, "close requested, reason=" + paramAnonymousString);
        }
      }
      
      public void emitError(Throwable paramAnonymousThrowable)
      {
        paramPublishSubject1.onError(paramAnonymousThrowable);
        paramPublishSubject2.onError(paramAnonymousThrowable);
        paramObserver.onError(paramAnonymousThrowable);
      }
      
      public Observable<WebSocketMessage> getRxMessages()
      {
        return paramPublishSubject1;
      }
      
      public String getSubProtocol()
      {
        return WebSocketProvider.this.subProtocol;
      }
      
      public Observable<WebSocketMessage> getTxMessages()
      {
        return paramPublishSubject2;
      }
      
      public String getUrl()
      {
        return WebSocketProvider.this.url;
      }
      
      public void log(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        WebSocketProvider.this.logger.log(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
      }
      
      public void log(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Throwable paramAnonymousThrowable)
      {
        WebSocketProvider.this.logger.log(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousThrowable);
      }
      
      public void send(String paramAnonymousString)
      {
        if (paramWebSocket.send(paramAnonymousString))
        {
          WebSocketProvider.this.logger.log("DEBUG", WebSocketProvider.TAG, "queued text message for sending: " + paramAnonymousString);
          if (paramPublishSubject2.hasObservers()) {
            paramPublishSubject2.onNext(WebSocketProvider.this.newMessage(this, 1, paramAnonymousString, null));
          }
          return;
        }
        WebSocketProvider.this.logger.log("ERROR", WebSocketProvider.TAG, "failed to queue text message for send: " + paramAnonymousString);
      }
      
      public void send(ByteString paramAnonymousByteString)
      {
        if (paramWebSocket.send(paramAnonymousByteString))
        {
          WebSocketProvider.this.logger.log("DEBUG", WebSocketProvider.TAG, "queued binary message for send: " + paramAnonymousByteString);
          if (paramPublishSubject2.hasObservers()) {
            paramPublishSubject2.onNext(WebSocketProvider.this.newMessage(this, 2, null, paramAnonymousByteString));
          }
          return;
        }
        WebSocketProvider.this.logger.log("ERROR", WebSocketProvider.TAG, "failed to queue binary message for send: " + paramAnonymousByteString);
      }
    };
  }
  
  public Observable<WebSocketSession> getSession()
  {
    return Observable.create(WebSocketProvider..Lambda.1.lambdaFactory$(this), Emitter.BackpressureMode.BUFFER);
  }
  
  public static class Builder
  {
    CertificateBundle certificateBundle;
    int connectTimeout;
    int keepAliveInterval;
    Logger logger;
    int readTimeout;
    String subProtocol;
    String url;
    int writeTimeout;
    
    public WebSocketProvider build()
    {
      return new WebSocketProvider(this, null);
    }
    
    public Builder certificateBundle(CertificateBundle paramCertificateBundle)
    {
      this.certificateBundle = paramCertificateBundle;
      return this;
    }
    
    public Builder connectTimeout(int paramInt)
    {
      this.connectTimeout = paramInt;
      return this;
    }
    
    public Builder keepAliveInterval(int paramInt)
    {
      this.keepAliveInterval = paramInt;
      return this;
    }
    
    public Builder logger(Logger paramLogger)
    {
      this.logger = paramLogger;
      return this;
    }
    
    public Builder readTimeout(int paramInt)
    {
      this.readTimeout = paramInt;
      return this;
    }
    
    public Builder subProtocol(String paramString)
    {
      this.subProtocol = paramString;
      return this;
    }
    
    public Builder url(String paramString)
    {
      this.url = paramString;
      return this;
    }
    
    public Builder writeTimeout(int paramInt)
    {
      this.writeTimeout = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/websocket/WebSocketProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */