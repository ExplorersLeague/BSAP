package com.blizzard.bgs.client.websocket;

import okio.ByteString;

public abstract interface WebSocketMessage
{
  public static final int TYPE_BINARY = 2;
  public static final int TYPE_TEXT = 1;
  
  public abstract ByteString getBinary();
  
  public abstract WebSocketSession getSession();
  
  public abstract String getText();
  
  public abstract int getType();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/websocket/WebSocketMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */