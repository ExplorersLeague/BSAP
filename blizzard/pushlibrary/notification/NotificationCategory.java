package com.blizzard.pushlibrary.notification;

import java.util.ArrayList;

public class NotificationCategory
{
  private final ArrayList<NotificationAction> actions;
  private final String category;
  private int priority = 0;
  private int soundFileResId;
  
  public NotificationCategory(String paramString, ArrayList<NotificationAction> paramArrayList, int paramInt)
  {
    this.category = paramString;
    this.actions = paramArrayList;
    this.priority = paramInt;
  }
  
  public NotificationCategory(String paramString, ArrayList<NotificationAction> paramArrayList, int paramInt1, int paramInt2)
  {
    this(paramString, paramArrayList, paramInt2);
    this.soundFileResId = paramInt1;
  }
  
  public ArrayList<NotificationAction> getActions()
  {
    return this.actions;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public int getSoundFileResId()
  {
    return this.soundFileResId;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/notification/NotificationCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */