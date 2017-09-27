package com.blizzard.messenger.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LoginStateType
{
  public static final String LOGGED_IN = "com.blizzard.messenger.LOGGED_IN";
  public static final String LOGGED_OUT = "com.blizzard.messenger.LOGGED_OUT";
  public static final String LOGGING_IN = "com.blizzard.messenger.LOGGING_IN";
  public static final String LOGGING_OUT = "com.blizzard.messenger.LOGGING_OUT";
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LoginStateTypeDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/constants/LoginStateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */