package com.blizzard.bgs.client.core;

import com.blizzard.bgs.client.websocket.WebSocketMessage;
import com.google.gson.JsonObject;
import rx.Observable;

public class BgsMessages
{
  public static Observable<BgsMessage> from(Client paramClient, Observable<WebSocketMessage> paramObservable)
  {
    return paramObservable.map(BgsMessages..Lambda.1.lambdaFactory$(paramClient));
  }
  
  public static BgsMessage toBgsMessage(final Client paramClient, WebSocketMessage paramWebSocketMessage)
  {
    paramWebSocketMessage = JsonParser.toJsonString(paramWebSocketMessage);
    new BgsMessage()
    {
      public JsonObject getBody()
      {
        return this.val$jsonMessage[1];
      }
      
      public <Body> Body getBody(Class<Body> paramAnonymousClass)
      {
        return (Body)JsonParser.toObject(this.val$jsonMessage[1], paramAnonymousClass);
      }
      
      public Client getClient()
      {
        return paramClient;
      }
      
      public JsonObject getHeader()
      {
        return this.val$jsonMessage[0];
      }
      
      public <Header> Header getHeader(Class<Header> paramAnonymousClass)
      {
        return (Header)JsonParser.toObject(this.val$jsonMessage[0], paramAnonymousClass);
      }
      
      public String getRaw()
      {
        return this.val$raw;
      }
    };
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/BgsMessages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */