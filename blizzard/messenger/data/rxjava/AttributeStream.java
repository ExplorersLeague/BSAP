package com.blizzard.messenger.data.rxjava;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import rx.Observable;

public final class AttributeStream<T>
{
  @Nullable
  public final T defaultValue;
  public final Observable<Pair<String, T>> observable;
  
  private AttributeStream(@NonNull Observable<Pair<String, T>> paramObservable, @Nullable T paramT)
  {
    this.observable = paramObservable;
    this.defaultValue = paramT;
  }
  
  public static <T1> AttributeStream<T1> fromObservable(@NonNull Observable<Pair<String, T1>> paramObservable)
  {
    return new AttributeStream(paramObservable, null);
  }
  
  public static <T1> AttributeStream<T1> fromObservableWithDefault(@NonNull Observable<Pair<String, T1>> paramObservable, @NonNull T1 paramT1)
  {
    return new AttributeStream(paramObservable, paramT1);
  }
  
  public boolean hasDefault()
  {
    return this.defaultValue != null;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/rxjava/AttributeStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */