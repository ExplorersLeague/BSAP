package com.blizzard.pushlibrary.notification;

public class NotificationAction
{
  protected int icon;
  private final NotificationIntent notificationIntent;
  protected int onClickId;
  protected CharSequence title;
  
  public NotificationAction(int paramInt1, int paramInt2, CharSequence paramCharSequence, NotificationIntent paramNotificationIntent)
  {
    this.onClickId = paramInt1;
    this.icon = paramInt2;
    this.title = paramCharSequence;
    this.notificationIntent = paramNotificationIntent;
  }
  
  public int getIcon()
  {
    return this.icon;
  }
  
  public NotificationIntent getNotificationIntent()
  {
    return this.notificationIntent;
  }
  
  public int getOnClickId()
  {
    return this.onClickId;
  }
  
  public CharSequence getTitle()
  {
    return this.title;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/notification/NotificationAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */