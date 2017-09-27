package com.blizzard.messenger.dagger;

import android.support.annotation.NonNull;
import com.blizzard.messenger.utils.ApplicationMonitor;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class AppModule
{
  private final ApplicationMonitor applicationMonitor;
  
  public AppModule(@NonNull ApplicationMonitor paramApplicationMonitor)
  {
    this.applicationMonitor = paramApplicationMonitor;
  }
  
  @Provides
  @Singleton
  ApplicationMonitor provideApplicationMonitor()
  {
    return this.applicationMonitor;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/AppModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */