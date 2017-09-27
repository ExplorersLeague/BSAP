package com.blizzard.messenger.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FriendTabType
{
  private static final String FAVORITES = "com.blizzard.messenger.FRIEND_TYPE_FAVORITES";
  private static final String ONLINE = "com.blizzard.messenger.FRIEND_TYPE_ONLINE";
  private static final String SUGGESTED = "com.blizzard.messenger.FRIEND_TYPE_SUGGESTED";
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FriendTabTypeDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/constants/FriendTabType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */