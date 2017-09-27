package com.blizzard.messenger.data.dagger;

import com.blizzard.messenger.data.providers.ConnectionProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ConnectionModule_ProvidesConnectionManagerFactory
  implements Factory<ConnectionProvider>
{
  private final ConnectionModule module;
  
  static
  {
    if (!ConnectionModule_ProvidesConnectionManagerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ConnectionModule_ProvidesConnectionManagerFactory(ConnectionModule paramConnectionModule)
  {
    assert (paramConnectionModule != null);
    this.module = paramConnectionModule;
  }
  
  public static Factory<ConnectionProvider> create(ConnectionModule paramConnectionModule)
  {
    return new ConnectionModule_ProvidesConnectionManagerFactory(paramConnectionModule);
  }
  
  public ConnectionProvider get()
  {
    return (ConnectionProvider)Preconditions.checkNotNull(this.module.providesConnectionManager(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/ConnectionModule_ProvidesConnectionManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */