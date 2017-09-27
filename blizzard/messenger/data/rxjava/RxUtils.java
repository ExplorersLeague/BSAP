package com.blizzard.messenger.data.rxjava;

import android.support.annotation.NonNull;
import rx.Observable;

public final class RxUtils
{
  public static <T> Observable<T> filterAttributeForId(@NonNull AttributeStream<T> paramAttributeStream, @NonNull String paramString)
  {
    Observable localObservable = paramAttributeStream.observable.filter(RxUtils..Lambda.1.lambdaFactory$(paramString)).map(RxUtils..Lambda.2.lambdaFactory$()).distinctUntilChanged();
    paramString = localObservable;
    if (paramAttributeStream.hasDefault()) {
      paramString = localObservable.startWith(paramAttributeStream.defaultValue);
    }
    return paramString;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/rxjava/RxUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */