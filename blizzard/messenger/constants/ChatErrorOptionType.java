package com.blizzard.messenger.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ChatErrorOptionType
{
  public static final String COPY = "com.blizzard.messenger.options.COPY";
  public static final String DELETE = "com.blizzard.messenger.options.HIDE";
  public static final String RESEND = "com.blizzard.messenger.options.RESEND";
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChatErrorOptionDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/constants/ChatErrorOptionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */