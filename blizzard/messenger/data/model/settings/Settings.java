package com.blizzard.messenger.data.model.settings;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Settings
{
  private static final boolean DEFAULT_ACCOUNT_MUTE = false;
  private static final boolean DEFAULT_FILTER_MATURE_LANGUAGE = true;
  private static final boolean DEFAULT_HIDE_MATURE_LANGUAGE_FILTER = true;
  private static final String DEFAULT_LOCALE = "en_US";
  private static final boolean DEFAULT_PUSH_NOTIFICATIONS_FRIEND_REQUESTS = true;
  private static final boolean DEFAULT_PUSH_NOTIFICATIONS_WHISPERS = true;
  private static final boolean DEFAULT_REAL_ID_DISABLED = true;
  private final boolean accountMute;
  private final boolean filterMatureLanguage;
  private final boolean hideMatureLanguageFilter;
  private final String locale;
  private final boolean pushNotificationsFriendRequests;
  private final boolean pushNotificationsWhispers;
  private final boolean realIdDisabled;
  
  private Settings(@NonNull Builder paramBuilder)
  {
    if (paramBuilder.accountMute != null)
    {
      this.accountMute = paramBuilder.accountMute.booleanValue();
      if (paramBuilder.filterMatureLanguage == null) {
        break label136;
      }
      this.filterMatureLanguage = paramBuilder.filterMatureLanguage.booleanValue();
      label40:
      if (paramBuilder.matureLanguageFilterHidden == null) {
        break label144;
      }
      this.hideMatureLanguageFilter = paramBuilder.matureLanguageFilterHidden.booleanValue();
      label58:
      if (paramBuilder.realIdDisabled == null) {
        break label152;
      }
      this.realIdDisabled = paramBuilder.realIdDisabled.booleanValue();
      label76:
      if (paramBuilder.locale == null) {
        break label160;
      }
      this.locale = paramBuilder.locale;
      label91:
      if (paramBuilder.pushNotificationsWhispers == null) {
        break label169;
      }
    }
    label136:
    label144:
    label152:
    label160:
    label169:
    for (this.pushNotificationsWhispers = paramBuilder.pushNotificationsWhispers.booleanValue();; this.pushNotificationsWhispers = true)
    {
      if (paramBuilder.pushNotificationsFriendRequests == null) {
        break label177;
      }
      this.pushNotificationsFriendRequests = paramBuilder.pushNotificationsFriendRequests.booleanValue();
      return;
      this.accountMute = false;
      break;
      this.filterMatureLanguage = true;
      break label40;
      this.hideMatureLanguageFilter = true;
      break label58;
      this.realIdDisabled = true;
      break label76;
      this.locale = "en_US";
      break label91;
    }
    label177:
    this.pushNotificationsFriendRequests = true;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public boolean isAccountMute()
  {
    return this.accountMute;
  }
  
  public boolean isFriendRequestNotificationsEnabled()
  {
    return this.pushNotificationsFriendRequests;
  }
  
  public boolean isHideMatureLanguageFilter()
  {
    return this.hideMatureLanguageFilter;
  }
  
  public boolean isMatureLangaugeFiltered()
  {
    return this.filterMatureLanguage;
  }
  
  public boolean isRealIdDisabled()
  {
    return this.realIdDisabled;
  }
  
  public boolean isWhisperNotificationsEnabled()
  {
    return this.pushNotificationsWhispers;
  }
  
  public String toString()
  {
    String str = "" + " Account Muted: " + this.accountMute;
    str = str + " Filter Mature Language: " + this.filterMatureLanguage;
    str = str + " Mature Language Filter Hidden: " + this.hideMatureLanguageFilter;
    str = str + " Locale: " + this.locale;
    str = str + " Real ID Disabled: " + this.realIdDisabled;
    str = str + " Whisper Notifications: " + this.pushNotificationsWhispers;
    return str + " Friend Request Notifications: " + this.pushNotificationsFriendRequests;
  }
  
  public static class Builder
  {
    private Boolean accountMute;
    private Boolean filterMatureLanguage;
    private String locale;
    private Boolean matureLanguageFilterHidden;
    private Boolean pushNotificationsFriendRequests;
    private Boolean pushNotificationsWhispers;
    private Boolean realIdDisabled;
    
    public Builder() {}
    
    public Builder(@NonNull Settings paramSettings)
    {
      this.accountMute = Boolean.valueOf(paramSettings.accountMute);
      this.filterMatureLanguage = Boolean.valueOf(paramSettings.filterMatureLanguage);
      this.matureLanguageFilterHidden = Boolean.valueOf(paramSettings.hideMatureLanguageFilter);
      this.realIdDisabled = Boolean.valueOf(paramSettings.realIdDisabled);
      this.locale = paramSettings.locale;
      this.pushNotificationsFriendRequests = Boolean.valueOf(paramSettings.pushNotificationsFriendRequests);
      this.pushNotificationsWhispers = Boolean.valueOf(paramSettings.pushNotificationsWhispers);
    }
    
    public Settings build()
    {
      return new Settings(this, null);
    }
    
    public Builder setAccountMute(@Nullable Boolean paramBoolean)
    {
      this.accountMute = paramBoolean;
      return this;
    }
    
    public Builder setFilterMatureLanguage(@Nullable Boolean paramBoolean)
    {
      this.filterMatureLanguage = paramBoolean;
      return this;
    }
    
    public Builder setFriendRequestNotificationsEnabled(@Nullable Boolean paramBoolean)
    {
      this.pushNotificationsFriendRequests = paramBoolean;
      return this;
    }
    
    public Builder setLocale(@Nullable String paramString)
    {
      this.locale = paramString;
      return this;
    }
    
    public Builder setMatureLanguageFilterHidden(@Nullable Boolean paramBoolean)
    {
      this.matureLanguageFilterHidden = paramBoolean;
      return this;
    }
    
    public Builder setRealIdDisabled(@Nullable Boolean paramBoolean)
    {
      this.realIdDisabled = paramBoolean;
      return this;
    }
    
    public Builder setWhisperNotificationsEnabled(@Nullable Boolean paramBoolean)
    {
      this.pushNotificationsWhispers = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/settings/Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */