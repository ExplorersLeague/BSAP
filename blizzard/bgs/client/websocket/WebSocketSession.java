package com.blizzard.bgs.client.websocket;

import com.blizzard.bgs.client.log.Logger;
import okio.ByteString;
import rx.Observable;

public abstract interface WebSocketSession
  extends Logger
{
  public abstract void close(String paramString);
  
  public abstract void emitError(Throwable paramThrowable);
  
  public abstract Observable<WebSocketMessage> getRxMessages();
  
  public abstract String getSubProtocol();
  
  public abstract Observable<WebSocketMessage> getTxMessages();
  
  public abstract String getUrl();
  
  public abstract void send(String paramString);
  
  public abstract void send(ByteString paramByteString);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/websocket/WebSocketSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */