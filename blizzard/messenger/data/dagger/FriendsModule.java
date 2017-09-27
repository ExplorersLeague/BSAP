package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.FriendsProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class FriendsModule
{
  private FriendsProvider friendsProvider = new FriendsProvider();
  
  @Provides
  @Singleton
  FriendsProvider provideFriendsProvider()
  {
    return this.friendsProvider;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/FriendsModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */