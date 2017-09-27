package com.blizzard.messenger.data.model.profile;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.blizzard.messenger.data.model.presence.BlizzardPresence;
import com.blizzard.messenger.data.providers.PresenceProvider;
import com.blizzard.messenger.data.providers.ProfileProvider;
import com.blizzard.messenger.data.xmpp.iq.SimpleProfileIQ;
import rx.Observable;
import rx.subjects.PublishSubject;

public class ProfileModel
{
  private BlizzardPresence blizzardPresence;
  private Profile profile;
  private ProfileAccount profileAccount;
  private final PublishSubject<Profile> profileSubject = PublishSubject.create();
  
  @Nullable
  private Profile buildProfile()
  {
    if (this.profileAccount == null) {
      return null;
    }
    return new Profile.Builder(this.profileAccount).setPresence(this.blizzardPresence).build();
  }
  
  private void updateAccount(@NonNull SimpleProfileIQ paramSimpleProfileIQ)
  {
    try
    {
      this.profileAccount = ProfileAccount.fromBattleTagAndFullName(paramSimpleProfileIQ.getBattleTag(), paramSimpleProfileIQ.getFullName());
      this.profile = buildProfile();
      this.profileSubject.onNext(this.profile);
      return;
    }
    finally
    {
      paramSimpleProfileIQ = finally;
      throw paramSimpleProfileIQ;
    }
  }
  
  private void updatePresence(@NonNull BlizzardPresence paramBlizzardPresence)
  {
    try
    {
      this.blizzardPresence = paramBlizzardPresence;
      this.profile = buildProfile();
      this.profileSubject.onNext(this.profile);
      return;
    }
    finally
    {
      paramBlizzardPresence = finally;
      throw paramBlizzardPresence;
    }
  }
  
  public Observable<Profile> onProfileUpdated()
  {
    if (this.profile != null) {
      return Observable.just(this.profile).concatWith(this.profileSubject).distinctUntilChanged().onBackpressureLatest();
    }
    return this.profileSubject.distinctUntilChanged().onBackpressureLatest();
  }
  
  public void setPresenceProvider(@NonNull PresenceProvider paramPresenceProvider)
  {
    paramPresenceProvider.onSelfPresenceReceived().subscribe(ProfileModel..Lambda.3.lambdaFactory$(this), ProfileModel..Lambda.4.lambdaFactory$());
  }
  
  public void setProfileProvider(@NonNull ProfileProvider paramProfileProvider)
  {
    paramProfileProvider.onProfileIQRetrieved().subscribe(ProfileModel..Lambda.1.lambdaFactory$(this), ProfileModel..Lambda.2.lambdaFactory$());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/profile/ProfileModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */