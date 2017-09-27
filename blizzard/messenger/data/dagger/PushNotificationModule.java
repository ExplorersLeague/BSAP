package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.PushNotificationProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class PushNotificationModule
{
  private PushNotificationProvider pushNotificationProvider = new PushNotificationProvider();
  
  @Provides
  @Singleton
  PushNotificationProvider providePushNotificationProvider()
  {
    return this.pushNotificationProvider;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/PushNotificationModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */