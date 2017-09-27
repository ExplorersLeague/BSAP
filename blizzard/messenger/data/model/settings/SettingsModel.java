package com.blizzard.messenger.data.model.settings;

import android.support.annotation.NonNull;
import com.blizzard.messenger.data.providers.SettingsProvider;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class SettingsModel
{
  private Settings settings;
  private final PublishSubject<Settings> settingsUpdatedSubject = PublishSubject.create();
  
  private void updateSettings(@NonNull Settings paramSettings)
  {
    this.settings = paramSettings;
    this.settingsUpdatedSubject.onNext(paramSettings);
  }
  
  public Settings getSettings()
  {
    return this.settings;
  }
  
  public Observable<Settings> onSettingsUpdated()
  {
    return Observable.just(this.settings).concatWith(this.settingsUpdatedSubject);
  }
  
  public void setSettingsProvider(@NonNull SettingsProvider paramSettingsProvider)
  {
    paramSettingsProvider.onSettingsReceived().observeOn(Schedulers.io()).subscribe(SettingsModel..Lambda.1.lambdaFactory$(this), SettingsModel..Lambda.4.lambdaFactory$());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/settings/SettingsModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */