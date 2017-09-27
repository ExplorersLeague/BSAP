package com.blizzard.messenger.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.annotation.NonNull;
import rx.Observable;
import rx.subjects.PublishSubject;

public final class ApplicationMonitor
{
  private int activitiesStarted;
  private int activitiesStopped;
  private final PublishSubject<Void> appSuspendedSubject = PublishSubject.create();
  private final PublishSubject<Void> appUnsuspendedSubject = PublishSubject.create();
  private boolean suspended = false;
  
  public ApplicationMonitor(@NonNull Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
    {
      public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public void onActivityDestroyed(Activity paramAnonymousActivity) {}
      
      public void onActivityPaused(Activity paramAnonymousActivity) {}
      
      public void onActivityResumed(Activity paramAnonymousActivity) {}
      
      public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public void onActivityStarted(Activity paramAnonymousActivity)
      {
        ApplicationMonitor.access$004(ApplicationMonitor.this);
        if ((ApplicationMonitor.this.activitiesStarted - ApplicationMonitor.this.activitiesStopped == 1) && (ApplicationMonitor.this.suspended))
        {
          ApplicationMonitor.access$202(ApplicationMonitor.this, false);
          ApplicationMonitor.this.appUnsuspendedSubject.onNext(null);
        }
      }
      
      public void onActivityStopped(Activity paramAnonymousActivity)
      {
        ApplicationMonitor.access$104(ApplicationMonitor.this);
        if ((ApplicationMonitor.this.activitiesStarted - ApplicationMonitor.this.activitiesStopped == 0) && (!ApplicationMonitor.this.suspended))
        {
          ApplicationMonitor.access$202(ApplicationMonitor.this, true);
          ApplicationMonitor.this.appSuspendedSubject.onNext(null);
        }
      }
    });
  }
  
  public boolean isAppSuspended()
  {
    return this.suspended;
  }
  
  public Observable<Void> onAppSuspended()
  {
    return this.appSuspendedSubject;
  }
  
  public Observable<Void> onAppUnsuspended()
  {
    return this.appUnsuspendedSubject;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/ApplicationMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */