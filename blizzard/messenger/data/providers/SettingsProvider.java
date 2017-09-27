package com.blizzard.messenger.data.providers;

import android.support.annotation.NonNull;
import android.util.Log;
import com.blizzard.messenger.data.listeners.ConnectionCreationListener;
import com.blizzard.messenger.data.model.settings.Settings;
import com.blizzard.messenger.data.model.settings.Settings.Builder;
import com.blizzard.messenger.data.utils.TransactionManager;
import com.blizzard.messenger.data.xmpp.iq.RetrieveSettingsIQ;
import com.blizzard.messenger.data.xmpp.iq.UpdateSettingsIQ;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ.Type;
import rx.Observable;
import rx.Single;
import rx.subjects.PublishSubject;

public final class SettingsProvider
{
  private static final String TAG = SettingsProvider.class.getSimpleName();
  private XMPPConnection connection;
  private final TransactionManager<Settings, Void> settingsRequests = new TransactionManager(SettingsProvider..Lambda.1.lambdaFactory$(this));
  private final PublishSubject<Settings> settingsSubject = PublishSubject.create();
  
  public SettingsProvider()
  {
    ConnectionCreationListener.onConnectionCreated().subscribe(SettingsProvider..Lambda.2.lambdaFactory$(this));
  }
  
  private void processSettingsPacket(RetrieveSettingsIQ paramRetrieveSettingsIQ)
  {
    if (paramRetrieveSettingsIQ != null)
    {
      Log.d(TAG, "processSettingsPacket stanzaId=" + paramRetrieveSettingsIQ.getStanzaId());
      Settings localSettings = new Settings.Builder().setAccountMute(Boolean.valueOf(paramRetrieveSettingsIQ.isAccountMuted())).setFilterMatureLanguage(Boolean.valueOf(paramRetrieveSettingsIQ.isMatureLangaugeFiltered())).setMatureLanguageFilterHidden(Boolean.valueOf(paramRetrieveSettingsIQ.isFilterMatureLanguageHidden())).setFriendRequestNotificationsEnabled(Boolean.valueOf(paramRetrieveSettingsIQ.isFriendRequestNotificationsEnabled())).setLocale(paramRetrieveSettingsIQ.getLocale()).setRealIdDisabled(Boolean.valueOf(paramRetrieveSettingsIQ.isRealIdDisabled())).setWhisperNotificationsEnabled(Boolean.valueOf(paramRetrieveSettingsIQ.isWhisperNotificationsEnabled())).build();
      this.settingsRequests.completeTransaction(paramRetrieveSettingsIQ, localSettings);
      this.settingsSubject.onNext(localSettings);
    }
  }
  
  private Single<Settings> sendSettings(@NonNull Settings paramSettings)
  {
    paramSettings = new UpdateSettingsIQ(paramSettings);
    paramSettings.setType(IQ.Type.set);
    return this.settingsRequests.startTransaction(paramSettings, null);
  }
  
  public Observable<Settings> onSettingsReceived()
  {
    return this.settingsSubject;
  }
  
  public Single<Settings> retrieveSettings()
  {
    RetrieveSettingsIQ localRetrieveSettingsIQ = new RetrieveSettingsIQ();
    localRetrieveSettingsIQ.setType(IQ.Type.get);
    return this.settingsRequests.startTransaction(localRetrieveSettingsIQ, null);
  }
  
  public Single<Settings> setFilterMatureLanguage(@NonNull Settings paramSettings, boolean paramBoolean)
  {
    paramSettings = new Settings.Builder(paramSettings);
    paramSettings.setFilterMatureLanguage(Boolean.valueOf(paramBoolean));
    return sendSettings(paramSettings.build());
  }
  
  public Single<Settings> setFriendRequestNotificationsEnabled(@NonNull Settings paramSettings, boolean paramBoolean)
  {
    paramSettings = new Settings.Builder(paramSettings);
    paramSettings.setFriendRequestNotificationsEnabled(Boolean.valueOf(paramBoolean));
    return sendSettings(paramSettings.build());
  }
  
  public Single<Settings> setLocale(@NonNull Settings paramSettings, @NonNull String paramString)
  {
    paramSettings = new Settings.Builder(paramSettings);
    paramSettings.setLocale(paramString);
    return sendSettings(paramSettings.build());
  }
  
  public Single<Settings> setWhisperNotificationsEnabled(@NonNull Settings paramSettings, boolean paramBoolean)
  {
    paramSettings = new Settings.Builder(paramSettings);
    paramSettings.setWhisperNotificationsEnabled(Boolean.valueOf(paramBoolean));
    return sendSettings(paramSettings.build());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/providers/SettingsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */