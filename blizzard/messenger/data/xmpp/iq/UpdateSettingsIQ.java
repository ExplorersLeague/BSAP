package com.blizzard.messenger.data.xmpp.iq;

import android.support.annotation.NonNull;
import com.blizzard.messenger.data.model.settings.Settings;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class UpdateSettingsIQ
  extends IQ
{
  private final Settings settings;
  
  public UpdateSettingsIQ(@NonNull Settings paramSettings)
  {
    super("query", "blz:settings");
    this.settings = paramSettings;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(@NonNull IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    paramIQChildElementXmlStringBuilder.append("<settings>");
    paramIQChildElementXmlStringBuilder.append("<readWrite>");
    paramIQChildElementXmlStringBuilder.append(String.format("<locale>%s</locale>", new Object[] { this.settings.getLocale() }));
    paramIQChildElementXmlStringBuilder.append(String.format("<filterMatureLanguage>%s</filterMatureLanguage>", new Object[] { Boolean.valueOf(this.settings.isMatureLangaugeFiltered()) }));
    paramIQChildElementXmlStringBuilder.append("<pushNotifications>");
    paramIQChildElementXmlStringBuilder.append(String.format("<whispers>%s</whispers>", new Object[] { Boolean.valueOf(this.settings.isWhisperNotificationsEnabled()) }));
    paramIQChildElementXmlStringBuilder.append(String.format("<friendRequests>%s</friendRequests>", new Object[] { Boolean.valueOf(this.settings.isFriendRequestNotificationsEnabled()) }));
    paramIQChildElementXmlStringBuilder.append("</pushNotifications>");
    paramIQChildElementXmlStringBuilder.append("</readWrite>");
    paramIQChildElementXmlStringBuilder.append("</settings>");
    return paramIQChildElementXmlStringBuilder;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/UpdateSettingsIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */