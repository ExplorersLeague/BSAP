package com.blizzard.messenger.data.listeners;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class ConnectivityListener
{
  private static final String TAG = ConnectivityListener.class.getSimpleName();
  private static final BehaviorSubject<Boolean> networkAvailableSubject = BehaviorSubject.create(Boolean.valueOf(false));
  
  public static void initialize(Context paramContext)
  {
    Log.d(TAG, "initialize");
    update(paramContext);
    paramContext.getApplicationContext().registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        Log.d(ConnectivityListener.TAG, "onReceive");
        ConnectivityListener.networkAvailableSubject.onNext(Boolean.valueOf(ConnectivityListener.isNetworkAvailable(paramAnonymousContext)));
      }
    }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public static boolean isNetworkAvailable()
  {
    Log.d(TAG, "isNetworkAvailable " + networkAvailableSubject.getValue());
    return ((Boolean)networkAvailableSubject.getValue()).booleanValue();
  }
  
  private static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null) {
      Log.d(TAG, "isNetworkAvailable(Context) isConnected=" + paramContext.isConnected() + ", networkInfo=" + paramContext);
    }
    while ((paramContext != null) && (paramContext.isConnected()))
    {
      return true;
      Log.d(TAG, "isNetworkAvailable(Context) isConnected=false, networkInfo=null");
    }
    return false;
  }
  
  public static Observable<Boolean> onNetworkAvailabilityChanged()
  {
    Log.d(TAG, "onNetworkAvailabilityChanged");
    return networkAvailableSubject.onBackpressureLatest().distinctUntilChanged();
  }
  
  public static void update(Context paramContext)
  {
    Log.d(TAG, "update");
    networkAvailableSubject.onNext(Boolean.valueOf(isNetworkAvailable(paramContext)));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/listeners/ConnectivityListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */