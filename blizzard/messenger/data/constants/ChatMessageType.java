package com.blizzard.messenger.data.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ChatMessageType
{
  public static final String ACTIVE = "com.blizzard.messenger.ACTIVE";
  public static final String FAILED_SEND = "com.blizzard.messenger.SEND_FAILED";
  public static final String HISTORY = "com.blizzard.messenger.HISTORY";
  public static final String RECEIVED = "com.blizzard.messenger.RECEIVED";
  public static final String SENT = "com.blizzard.messenger.SENT";
  public static final String UNSENT = "com.blizzard.messenger.UNSENT";
  public final String state;
  
  public ChatMessageType(String paramString)
  {
    this.state = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChatMessageTypeDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/constants/ChatMessageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */