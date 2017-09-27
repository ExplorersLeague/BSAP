package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.SuggestedFriendsProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class SuggestedFriendsModule
{
  private SuggestedFriendsProvider suggestedFriendsProvider = new SuggestedFriendsProvider();
  
  @Provides
  @Singleton
  SuggestedFriendsProvider provideSuggestedFriendsProvider()
  {
    return this.suggestedFriendsProvider;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/SuggestedFriendsModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */