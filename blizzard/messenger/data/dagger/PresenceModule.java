package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.PresenceProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
class PresenceModule
{
  private PresenceProvider presenceProvider = new PresenceProvider();
  
  @Provides
  @Singleton
  PresenceProvider providesPresenceProvider()
  {
    return this.presenceProvider;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/PresenceModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */