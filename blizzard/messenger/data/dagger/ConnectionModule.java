package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.ConnectionProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ConnectionModule
{
  private ConnectionProvider connectionProvider = new ConnectionProvider();
  
  @Provides
  @Singleton
  ConnectionProvider providesConnectionManager()
  {
    return this.connectionProvider;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/ConnectionModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */