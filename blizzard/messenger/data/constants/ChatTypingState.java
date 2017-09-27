package com.blizzard.messenger.data.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ChatTypingState
{
  public static final String ACTIVE = "com.blizzard.messenger.ACTIVE";
  public static final String COMPOSING = "com.blizzard.messenger.COMPOSING";
  public static final String GONE = "com.blizzard.messenger.GONE";
  public static final String INACTIVE = "com.blizzard.messenger.INACTIVE";
  public static final String PAUSED = "com.blizzard.messenger.PAUSED";
  public final String chatStatus;
  
  public ChatTypingState(String paramString)
  {
    this.chatStatus = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChatStateDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/constants/ChatTypingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */