package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.SettingsProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class SettingsModule
{
  private SettingsProvider settingsProvider = new SettingsProvider();
  
  @Provides
  @Singleton
  SettingsProvider providesSettingsProvider()
  {
    return this.settingsProvider;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/SettingsModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */