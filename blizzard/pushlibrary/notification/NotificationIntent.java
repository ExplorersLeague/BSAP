package com.blizzard.pushlibrary.notification;

import android.content.Intent;

public class NotificationIntent
{
  private Intent intent;
  private String label;
  private String resultKey;
  
  public NotificationIntent(Intent paramIntent, String paramString1, String paramString2)
  {
    this.intent = paramIntent;
    this.resultKey = paramString1;
    this.label = paramString2;
  }
  
  public Intent getIntent()
  {
    return this.intent;
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public String getResultKey()
  {
    return this.resultKey;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/notification/NotificationIntent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */