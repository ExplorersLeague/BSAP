package com.blizzard.messenger.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class HideOfflineType
{
  public static final int ALL = 0;
  public static final int GREATER_THAN_THIRTY_DAYS = 1;
  public static final int NONE = -1;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HideOfflineTypeDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/constants/HideOfflineType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */