package com.blizzard.messenger.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FriendOptionType
{
  public static final String MESSAGE = "com.blizzard.messenger.options.MESSAGE";
  public static final String VIEW_PROFILE = "com.blizzard.messenger.options.VIEW_PROFILE";
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FriendOptionDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/constants/FriendOptionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */