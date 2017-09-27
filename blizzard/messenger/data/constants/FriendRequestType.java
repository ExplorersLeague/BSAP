package com.blizzard.messenger.data.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FriendRequestType
{
  public static final String FRIEND_REQUEST_TYPE_ADD = "add";
  public static final String FRIEND_REQUEST_TYPE_UPGRADE = "upgrade";
  public final String friendRequestType;
  
  public FriendRequestType(String paramString)
  {
    this.friendRequestType = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FriendRequestTypeDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/constants/FriendRequestType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */