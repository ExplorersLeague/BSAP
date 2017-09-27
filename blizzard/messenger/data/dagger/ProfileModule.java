package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.ProfileProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ProfileModule
{
  private ProfileProvider profileProvider = new ProfileProvider();
  
  @Provides
  @Singleton
  ProfileProvider provideProfileProvider()
  {
    return this.profileProvider;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/ProfileModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */