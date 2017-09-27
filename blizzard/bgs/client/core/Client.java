package com.blizzard.bgs.client.core;

import com.blizzard.bgs.client.log.Logger;
import com.blizzard.bgs.client.service.base.RequestId;
import com.blizzard.bgs.client.websocket.WebSocketSession;
import rx.Observable;

public class Client
  implements Logger
{
  private final Observable<IncomingRequest> requests;
  private final Observable<IncomingResponse> responses;
  private final Observable<BgsMessage> rxMessages;
  private final WebSocketSession session;
  private final Observable<BgsMessage> txMessages;
  
  public Client(WebSocketSession paramWebSocketSession)
  {
    this.session = paramWebSocketSession;
    this.rxMessages = BgsMessages.from(this, paramWebSocketSession.getRxMessages());
    this.txMessages = BgsMessages.from(this, paramWebSocketSession.getTxMessages());
    this.requests = IncomingMessages.filterRequest(this.rxMessages);
    this.responses = IncomingMessages.filterResponse(this.rxMessages);
  }
  
  public void emitError(Throwable paramThrowable)
  {
    this.session.emitError(paramThrowable);
  }
  
  public Observable<IncomingRequest> getRequests()
  {
    return this.requests;
  }
  
  public Observable<IncomingResponse> getResponses()
  {
    return this.responses;
  }
  
  public Observable<BgsMessage> getRxMessages()
  {
    return this.rxMessages;
  }
  
  public Observable<BgsMessage> getTxMessages()
  {
    return this.txMessages;
  }
  
  public String getUrl()
  {
    return this.session.getUrl();
  }
  
  public void log(String paramString1, String paramString2, String paramString3)
  {
    this.session.log(paramString1, paramString2, paramString3);
  }
  
  public void log(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    this.session.log(paramString1, paramString2, paramString3, paramThrowable);
  }
  
  public Observable<IncomingResponse> send(RequestHeader paramRequestHeader, Object paramObject)
  {
    Observable localObservable = this.responses.filter(Client..Lambda.1.lambdaFactory$(paramRequestHeader));
    this.session.send(JsonParser.toJsonString(paramRequestHeader, paramObject));
    return localObservable;
  }
  
  public Observable<IncomingResponse> send(RequestId paramRequestId, Object paramObject)
  {
    return send(new RequestHeader(paramRequestId), paramObject);
  }
  
  public void send(ResponseHeader paramResponseHeader, Object paramObject)
  {
    this.session.send(JsonParser.toJsonString(paramResponseHeader, paramObject));
  }
  
  public void shutdown(String paramString)
  {
    this.session.close(paramString);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */