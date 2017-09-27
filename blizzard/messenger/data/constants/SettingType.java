package com.blizzard.messenger.data.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SettingType
{
  public static final String FILTER_MATURE_LANGUAGE = "filterMatureLanguage";
  public static final String FILTER_MATURE_LANGUAGE_HIDDEN = "filterMatureLanguageHidden";
  public static final String LOCALE = "locale";
  public static final String NOTIFICATIONS_FRIEND_REQUESTS = "friendRequests";
  public static final String NOTIFICATIONS_WHISPER = "whispers";
  public final String settingType;
  
  public SettingType(String paramString)
  {
    this.settingType = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SettingTypeDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/constants/SettingType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */