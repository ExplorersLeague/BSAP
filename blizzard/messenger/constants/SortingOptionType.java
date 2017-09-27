package com.blizzard.messenger.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SortingOptionType
{
  public static final String GROUP_FAVORITES = "com.blizzard.messenger.GROUP_FAVORITES";
  public static final String SHOW_BATTLETAG_AND_REAL_ID = "com.blizzard.messenger.SHOW_BATTLETAG_AND_REALID";
  public static final String SORT_BY_ACTIVITY = "com.blizzard.messenger.SORT_BY_ACTIVITY";
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SortingOptionTypeDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/constants/SortingOptionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */