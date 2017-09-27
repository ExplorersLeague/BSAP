package com.blizzard.messenger.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ChatOptionType
{
  public static final String HIDE = "com.blizzard.messenger.options.HIDE";
  public static final String MESSAGE = "com.blizzard.messenger.options.MESSAGE";
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChatOptionDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/constants/ChatOptionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */