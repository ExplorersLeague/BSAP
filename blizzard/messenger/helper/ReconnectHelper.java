package com.blizzard.messenger.helper;

import android.app.Activity;
import android.util.Log;
import com.blizzard.messenger.data.listeners.ConnectivityListener;
import com.blizzard.messenger.providers.MessengerProvider;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

public class ReconnectHelper
{
  private static final String TAG = ReconnectHelper.class.getSimpleName();
  private final Activity activity;
  private CompositeSubscription allSubscriptions;
  private PublishSubject<String> onLoginRequiredSubject = PublishSubject.create();
  private final MessengerProvider provider;
  
  public ReconnectHelper(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.provider = MessengerProvider.getInstance();
  }
  
  private void addReconnect()
  {
    this.allSubscriptions.add(this.provider.onConnectionStateChanged().map(ReconnectHelper..Lambda.1.lambdaFactory$(this)).doOnNext(ReconnectHelper..Lambda.2.lambdaFactory$(this)).distinctUntilChanged().filter(ReconnectHelper..Lambda.3.lambdaFactory$()).flatMapCompletable(ReconnectHelper..Lambda.4.lambdaFactory$(this)).retryWhen(ReconnectHelper..Lambda.5.lambdaFactory$(this)).subscribe());
  }
  
  private void addRelog()
  {
    this.allSubscriptions.add(ConnectivityListener.onNetworkAvailabilityChanged().filter(ReconnectHelper..Lambda.6.lambdaFactory$(this)).onBackpressureLatest().subscribe(ReconnectHelper..Lambda.7.lambdaFactory$(this)));
  }
  
  private static Observable<Long> backoffCeiling()
  {
    return Observable.just(Long.valueOf(10000L)).repeat();
  }
  
  private static Observable<Long> initialBackoffSeries()
  {
    return Observable.range(0, toSecsExponent(10000L)).map(ReconnectHelper..Lambda.11.lambdaFactory$());
  }
  
  private Observable<Long> onErrorBackoff(Observable<? extends Throwable> paramObservable)
  {
    return paramObservable.zipWith(initialBackoffSeries().concatWith(backoffCeiling()), ReconnectHelper..Lambda.8.lambdaFactory$()).doOnNext(ReconnectHelper..Lambda.9.lambdaFactory$()).flatMap(ReconnectHelper..Lambda.10.lambdaFactory$());
  }
  
  private static long toMillis(int paramInt)
  {
    return TimeUnit.SECONDS.toMillis(1L) * Math.pow(2.0D, paramInt);
  }
  
  private static int toSecsExponent(long paramLong)
  {
    return (int)(Math.log(TimeUnit.MILLISECONDS.toSeconds(paramLong)) / Math.log(2.0D)) + 1;
  }
  
  public Observable<String> onLoginRequired()
  {
    return this.onLoginRequiredSubject;
  }
  
  public void start()
  {
    Log.d(TAG, "start");
    if (this.allSubscriptions == null)
    {
      this.allSubscriptions = new CompositeSubscription();
      addReconnect();
      addRelog();
    }
  }
  
  public void stop()
  {
    Log.d(TAG, "stop");
    if (this.allSubscriptions != null)
    {
      this.allSubscriptions.unsubscribe();
      this.allSubscriptions = null;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/helper/ReconnectHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */