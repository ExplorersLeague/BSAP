package com.blizzard.messenger.data.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ConnectionStateType
{
  public static final String CONNECTED = "com.blizzard.messenger.CONNECTED";
  public static final String CONNECTING = "com.blizzard.messenger.CONNECTING";
  public static final String DISCONNECTED = "com.blizzard.messenger.DISCONNECTED";
  public static final String DISCONNECTING = "com.blizzard.messenger.DISCONNECTING";
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ConnectionStateTypeDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/constants/ConnectionStateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */