package com.blizzard.messenger.data.xmpp.iq;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class RetrieveSettingsIQ
  extends IQ
{
  public static final String ELEMENT = "query";
  public static final String NAMESPACE = "blz:settings";
  private boolean accountMute;
  private boolean filterMatureLanguage;
  private boolean filterMatureLanguageHidden;
  private String locale;
  private boolean pushNotificationsFriendRequests;
  private boolean pushNotificationsWhispers;
  private boolean realIdDisabled;
  
  public RetrieveSettingsIQ()
  {
    super("query", "blz:settings");
  }
  
  private RetrieveSettingsIQ(Builder paramBuilder)
  {
    super("query", "blz:settings");
    this.accountMute = paramBuilder.accountMute;
    this.filterMatureLanguage = paramBuilder.filterMatureLanguage;
    this.filterMatureLanguageHidden = paramBuilder.filterMatureLanguageHidden;
    this.locale = paramBuilder.locale;
    this.pushNotificationsWhispers = paramBuilder.pushNotificationsWhispers;
    this.pushNotificationsFriendRequests = paramBuilder.pushNotificationsFriendRequests;
    this.realIdDisabled = paramBuilder.realIdDisabled;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    return paramIQChildElementXmlStringBuilder;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public boolean isAccountMuted()
  {
    return this.accountMute;
  }
  
  public boolean isFilterMatureLanguageHidden()
  {
    return this.filterMatureLanguageHidden;
  }
  
  public boolean isFriendRequestNotificationsEnabled()
  {
    return this.pushNotificationsFriendRequests;
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
  
  public static class Builder
  {
    private boolean accountMute;
    private boolean filterMatureLanguage;
    private boolean filterMatureLanguageHidden;
    private String locale;
    private boolean pushNotificationsFriendRequests;
    private boolean pushNotificationsWhispers;
    private boolean realIdDisabled;
    
    public RetrieveSettingsIQ build()
    {
      return new RetrieveSettingsIQ(this, null);
    }
    
    public Builder setAccountMute(boolean paramBoolean)
    {
      this.accountMute = paramBoolean;
      return this;
    }
    
    public Builder setFilterMatureLanguage(boolean paramBoolean)
    {
      this.filterMatureLanguage = paramBoolean;
      return this;
    }
    
    public Builder setFilterMatureLanguageHidden(boolean paramBoolean)
    {
      this.filterMatureLanguageHidden = paramBoolean;
      return this;
    }
    
    public Builder setFriendRequestNotificationsEnabled(boolean paramBoolean)
    {
      this.pushNotificationsFriendRequests = paramBoolean;
      return this;
    }
    
    public Builder setLocale(String paramString)
    {
      this.locale = paramString;
      return this;
    }
    
    public Builder setRealIdDisabled(boolean paramBoolean)
    {
      this.realIdDisabled = paramBoolean;
      return this;
    }
    
    public Builder setWhisperNotificationsEnabled(boolean paramBoolean)
    {
      this.pushNotificationsWhispers = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/RetrieveSettingsIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */