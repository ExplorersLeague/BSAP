package com.blizzard.messenger.helper;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.util.Log;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import com.blizzard.messenger.data.providers.SettingsProvider;
import com.blizzard.messenger.data.utils.BgsLocaleUtils;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.utils.ColorUtils;
import java.util.Locale;
import javax.inject.Inject;
import rx.Observable;
import rx.Single;
import rx.subjects.PublishSubject;

public class SettingsHelper
{
  private static final String TAG = SettingsHelper.class.getSimpleName();
  private final Context context;
  @Inject
  FriendsModel friendsModel;
  private final PublishSubject<Void> logoutClickedSubject = PublishSubject.create();
  private final PublishSubject<Integer> offlineChangedSubject = PublishSubject.create();
  private final Resources res;
  @Inject
  SettingsModel settingsModel;
  private final SettingsProvider settingsProvider;
  private final PublishSubject<Void> themeChangedSubject = PublishSubject.create();
  
  public SettingsHelper(@NonNull Context paramContext)
  {
    this.context = paramContext;
    this.res = paramContext.getResources();
    this.settingsProvider = MessengerProvider.getInstance().getSettingsProvider();
    ((MessengerApplication)paramContext.getApplicationContext()).getModelComponent().inject(this);
  }
  
  private void setQuickSuspendPresence(boolean paramBoolean)
  {
    MessengerProvider.getInstance().debugSetQuickSuspendPresence(paramBoolean);
  }
  
  private void setTestFailResponses(boolean paramBoolean)
  {
    MessengerProvider.getInstance().debugSetTestFailResponses(paramBoolean);
  }
  
  private void setTestTimeoutResponses(boolean paramBoolean)
  {
    MessengerProvider.getInstance().debugSetTestTimoutResponses(paramBoolean);
  }
  
  private void showChromeCustomTab(String paramString)
  {
    CustomTabsIntent.Builder localBuilder = new CustomTabsIntent.Builder();
    localBuilder.setShowTitle(true);
    localBuilder.setToolbarColor(ColorUtils.getColorPrimary(this.context));
    localBuilder.build().launchUrl(this.context, Uri.parse(paramString));
  }
  
  private void updateFilterMatureLanguage(boolean paramBoolean)
  {
    this.settingsProvider.setFilterMatureLanguage(this.settingsModel.getSettings(), paramBoolean).doOnSubscribe(SettingsHelper..Lambda.1.lambdaFactory$()).subscribe(SettingsHelper..Lambda.2.lambdaFactory$(paramBoolean), SettingsHelper..Lambda.3.lambdaFactory$());
  }
  
  private void updateFriendRequestNotifications(boolean paramBoolean)
  {
    this.settingsProvider.setFriendRequestNotificationsEnabled(this.settingsModel.getSettings(), paramBoolean).doOnSubscribe(SettingsHelper..Lambda.4.lambdaFactory$()).subscribe(SettingsHelper..Lambda.5.lambdaFactory$(paramBoolean), SettingsHelper..Lambda.6.lambdaFactory$());
  }
  
  private void updateLightTheme(boolean paramBoolean)
  {
    Log.w("SettingsHelper", "updateLightTheme " + paramBoolean);
    SharedPrefsUtils.setLightThemeEnabled(this.context, paramBoolean);
    Telemetry.settingsCurrentThemeUpdated(paramBoolean);
    this.themeChangedSubject.onNext(null);
  }
  
  private void updateSortingRules(String paramString, boolean paramBoolean)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      this.friendsModel.resortFriends();
      return;
      if (!paramString.equals("com.blizzard.messenger.GROUP_FAVORITES")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("com.blizzard.messenger.SHOW_BATTLETAG_AND_REALID")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("com.blizzard.messenger.SORT_BY_ACTIVITY")) {
        break;
      }
      i = 2;
      break;
      SharedPrefsUtils.setSortGroupFavorites(this.context, paramBoolean);
      Telemetry.settingsFriendsListGroupFavoritesUpdated(paramBoolean);
      continue;
      SharedPrefsUtils.setSortShowBattleTagAndRealId(this.context, paramBoolean);
      Telemetry.settingsFriendsListShowBtagRealIdUpdated(paramBoolean);
      continue;
      SharedPrefsUtils.setSortByActivity(this.context, paramBoolean);
      Telemetry.settingsFriendsListSortByActivityUpdated(paramBoolean);
    }
  }
  
  private void updateSounds(boolean paramBoolean)
  {
    SharedPrefsUtils.setSoundsEnabled(this.context, paramBoolean);
    Telemetry.settingsSoundsUpdated(paramBoolean);
  }
  
  private void updateTextToSpeech(boolean paramBoolean)
  {
    SharedPrefsUtils.setTextToSpeechEnabled(this.context, paramBoolean);
    Telemetry.settingsTextToSpeechUpdated(paramBoolean);
  }
  
  private void updateWhisperNotifications(boolean paramBoolean)
  {
    this.settingsProvider.setWhisperNotificationsEnabled(this.settingsModel.getSettings(), paramBoolean).doOnSubscribe(SettingsHelper..Lambda.7.lambdaFactory$()).subscribe(SettingsHelper..Lambda.8.lambdaFactory$(paramBoolean), SettingsHelper..Lambda.9.lambdaFactory$());
  }
  
  public Observable<Integer> onHideOfflineValueChanged()
  {
    return this.offlineChangedSubject;
  }
  
  public Observable<Void> onThemeChanged()
  {
    return this.themeChangedSubject;
  }
  
  public void showPrivacyPolicy(Context paramContext)
  {
    showChromeCustomTab(paramContext.getString(2131361995));
  }
  
  public void showTermsOfService(Context paramContext)
  {
    showChromeCustomTab(paramContext.getString(2131362059));
  }
  
  public void updateHideOfflineFriendsRules(int paramInt)
  {
    SharedPrefsUtils.setSortHideOffline(this.context, paramInt);
    Telemetry.settingsHideOfflineFriendsUpdated(paramInt);
    this.offlineChangedSubject.onNext(Integer.valueOf(paramInt));
  }
  
  public void updateLocale()
  {
    SettingsProvider localSettingsProvider = MessengerProvider.getInstance().getSettingsProvider();
    String str = BgsLocaleUtils.getMappedLocale(Locale.getDefault());
    str = str.substring(0, 2) + "_" + str.substring(2, str.length());
    localSettingsProvider.setLocale(this.settingsModel.getSettings(), str).doOnSubscribe(SettingsHelper..Lambda.10.lambdaFactory$()).doOnSuccess(SettingsHelper..Lambda.11.lambdaFactory$()).subscribe(SettingsHelper..Lambda.12.lambdaFactory$(), SettingsHelper..Lambda.13.lambdaFactory$());
  }
  
  public void updatePreference(@NonNull String paramString, boolean paramBoolean)
  {
    if (paramString.equals(this.res.getString(2131362173))) {
      updateFriendRequestNotifications(paramBoolean);
    }
    do
    {
      return;
      if (paramString.equals(this.res.getString(2131362174)))
      {
        updateWhisperNotifications(paramBoolean);
        return;
      }
      if (paramString.equals(this.res.getString(2131362180)))
      {
        updateSounds(paramBoolean);
        return;
      }
      if (paramString.equals(this.res.getString(2131362166)))
      {
        updateFilterMatureLanguage(paramBoolean);
        return;
      }
      if (paramString.equals(this.res.getString(2131362167)))
      {
        showChromeCustomTab(this.context.getString(2131361919));
        return;
      }
      if (paramString.equals(this.res.getString(2131362168)))
      {
        showChromeCustomTab(this.context.getString(2131362056));
        return;
      }
      if (paramString.equals(this.context.getString(2131362181)))
      {
        setTestFailResponses(paramBoolean);
        return;
      }
      if (paramString.equals(this.context.getString(2131362182)))
      {
        setTestTimeoutResponses(paramBoolean);
        return;
      }
      if (paramString.equals(this.context.getString(2131362176)))
      {
        setQuickSuspendPresence(paramBoolean);
        return;
      }
      if (paramString.equals(this.res.getString(2131362172)))
      {
        this.logoutClickedSubject.onNext(null);
        return;
      }
      if (paramString.equals(this.res.getString(2131362183)))
      {
        updateTextToSpeech(paramBoolean);
        return;
      }
      if (paramString.equals(this.res.getString(2131362171)))
      {
        updateLightTheme(paramBoolean);
        return;
      }
      if (paramString.equals(this.context.getString(2131362179)))
      {
        updateSortingRules("com.blizzard.messenger.SHOW_BATTLETAG_AND_REALID", paramBoolean);
        return;
      }
      if (paramString.equals(this.context.getString(2131362177)))
      {
        updateSortingRules("com.blizzard.messenger.SORT_BY_ACTIVITY", paramBoolean);
        return;
      }
    } while (!paramString.equals(this.context.getString(2131362178)));
    updateSortingRules("com.blizzard.messenger.GROUP_FAVORITES", paramBoolean);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/helper/SettingsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */