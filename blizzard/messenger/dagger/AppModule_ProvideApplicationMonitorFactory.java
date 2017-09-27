package com.blizzard.messenger.dagger;

import com.blizzard.messenger.utils.ApplicationMonitor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideApplicationMonitorFactory
  implements Factory<ApplicationMonitor>
{
  private final AppModule module;
  
  static
  {
    if (!AppModule_ProvideApplicationMonitorFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public AppModule_ProvideApplicationMonitorFactory(AppModule paramAppModule)
  {
    assert (paramAppModule != null);
    this.module = paramAppModule;
  }
  
  public static Factory<ApplicationMonitor> create(AppModule paramAppModule)
  {
    return new AppModule_ProvideApplicationMonitorFactory(paramAppModule);
  }
  
  public ApplicationMonitor get()
  {
    return (ApplicationMonitor)Preconditions.checkNotNull(this.module.provideApplicationMonitor(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/dagger/AppModule_ProvideApplicationMonitorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */