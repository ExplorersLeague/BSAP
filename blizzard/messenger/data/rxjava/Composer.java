package com.blizzard.messenger.data.rxjava;

import android.support.annotation.NonNull;
import rx.Observable;

public final class Composer
{
  public static abstract class V3
  {
    public static <T0, T1, T2, R> Observable<R> composeFromAttributes(@NonNull Observable<String> paramObservable, @NonNull AttributeStream<T0> paramAttributeStream, @NonNull AttributeStream<T1> paramAttributeStream1, @NonNull AttributeStream<T2> paramAttributeStream2, @NonNull Factory<T0, T1, T2, R> paramFactory)
    {
      return paramObservable.distinctUntilChanged().groupBy(Composer.V3..Lambda.1.lambdaFactory$()).map(Composer.V3..Lambda.2.lambdaFactory$()).flatMap(Composer.V3..Lambda.3.lambdaFactory$(paramAttributeStream, paramAttributeStream1, paramAttributeStream2, paramFactory));
    }
    
    @FunctionalInterface
    public static abstract interface Factory<T0, T1, T2, R>
    {
      public abstract R create(String paramString, T0 paramT0, T1 paramT1, T2 paramT2);
    }
  }
  
  public static abstract class V4
  {
    public static <T0, T1, T2, T3, R> Observable<R> composeFromAttributes(@NonNull Observable<String> paramObservable, @NonNull AttributeStream<T0> paramAttributeStream, @NonNull AttributeStream<T1> paramAttributeStream1, @NonNull AttributeStream<T2> paramAttributeStream2, @NonNull AttributeStream<T3> paramAttributeStream3, @NonNull Factory<T0, T1, T2, T3, R> paramFactory)
    {
      return paramObservable.distinctUntilChanged().groupBy(Composer.V4..Lambda.1.lambdaFactory$()).map(Composer.V4..Lambda.2.lambdaFactory$()).flatMap(Composer.V4..Lambda.3.lambdaFactory$(paramAttributeStream, paramAttributeStream1, paramAttributeStream2, paramAttributeStream3, paramFactory));
    }
    
    @FunctionalInterface
    public static abstract interface Factory<T0, T1, T2, T3, R>
    {
      public abstract R create(String paramString, T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3);
    }
  }
  
  public static abstract class V5
  {
    public static <T0, T1, T2, T3, T4, R> Observable<R> composeFromAttributes(@NonNull Observable<String> paramObservable, @NonNull AttributeStream<T0> paramAttributeStream, @NonNull AttributeStream<T1> paramAttributeStream1, @NonNull AttributeStream<T2> paramAttributeStream2, @NonNull AttributeStream<T3> paramAttributeStream3, @NonNull AttributeStream<T4> paramAttributeStream4, @NonNull Factory<T0, T1, T2, T3, T4, R> paramFactory)
    {
      return paramObservable.distinctUntilChanged().groupBy(Composer.V5..Lambda.1.lambdaFactory$()).map(Composer.V5..Lambda.2.lambdaFactory$()).flatMap(Composer.V5..Lambda.3.lambdaFactory$(paramAttributeStream, paramAttributeStream1, paramAttributeStream2, paramAttributeStream3, paramAttributeStream4, paramFactory));
    }
    
    @FunctionalInterface
    public static abstract interface Factory<T0, T1, T2, T3, T4, R>
    {
      public abstract R create(String paramString, T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4);
    }
  }
  
  public static abstract class V6
  {
    public static <T0, T1, T2, T3, T4, T5, R> Observable<R> composeFromAttributes(@NonNull Observable<String> paramObservable, @NonNull AttributeStream<T0> paramAttributeStream, @NonNull AttributeStream<T1> paramAttributeStream1, @NonNull AttributeStream<T2> paramAttributeStream2, @NonNull AttributeStream<T3> paramAttributeStream3, @NonNull AttributeStream<T4> paramAttributeStream4, @NonNull AttributeStream<T5> paramAttributeStream5, @NonNull Factory<T0, T1, T2, T3, T4, T5, R> paramFactory)
    {
      return paramObservable.distinctUntilChanged().groupBy(Composer.V6..Lambda.1.lambdaFactory$()).map(Composer.V6..Lambda.2.lambdaFactory$()).flatMap(Composer.V6..Lambda.3.lambdaFactory$(paramAttributeStream, paramAttributeStream1, paramAttributeStream2, paramAttributeStream3, paramAttributeStream4, paramAttributeStream5, paramFactory));
    }
    
    @FunctionalInterface
    public static abstract interface Factory<T0, T1, T2, T3, T4, T5, R>
    {
      public abstract R create(String paramString, T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5);
    }
  }
  
  public static abstract class V7
  {
    public static <T0, T1, T2, T3, T4, T5, T6, R> Observable<R> composeFromAttributes(@NonNull Observable<String> paramObservable, @NonNull AttributeStream<T0> paramAttributeStream, @NonNull AttributeStream<T1> paramAttributeStream1, @NonNull AttributeStream<T2> paramAttributeStream2, @NonNull AttributeStream<T3> paramAttributeStream3, @NonNull AttributeStream<T4> paramAttributeStream4, @NonNull AttributeStream<T5> paramAttributeStream5, @NonNull AttributeStream<T6> paramAttributeStream6, @NonNull Factory<T0, T1, T2, T3, T4, T5, T6, R> paramFactory)
    {
      return paramObservable.distinctUntilChanged().groupBy(Composer.V7..Lambda.1.lambdaFactory$()).map(Composer.V7..Lambda.2.lambdaFactory$()).flatMap(Composer.V7..Lambda.3.lambdaFactory$(paramAttributeStream, paramAttributeStream1, paramAttributeStream2, paramAttributeStream3, paramAttributeStream4, paramAttributeStream5, paramAttributeStream6, paramFactory));
    }
    
    @FunctionalInterface
    public static abstract interface Factory<T0, T1, T2, T3, T4, T5, T6, R>
    {
      public abstract R create(String paramString, T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5, T6 paramT6);
    }
  }
  
  public static abstract class V8
  {
    public static <T0, T1, T2, T3, T4, T5, T6, T7, R> Observable<R> composeFromAttributes(@NonNull Observable<String> paramObservable, @NonNull AttributeStream<T0> paramAttributeStream, @NonNull AttributeStream<T1> paramAttributeStream1, @NonNull AttributeStream<T2> paramAttributeStream2, @NonNull AttributeStream<T3> paramAttributeStream3, @NonNull AttributeStream<T4> paramAttributeStream4, @NonNull AttributeStream<T5> paramAttributeStream5, @NonNull AttributeStream<T6> paramAttributeStream6, @NonNull AttributeStream<T7> paramAttributeStream7, @NonNull Factory<T0, T1, T2, T3, T4, T5, T6, T7, R> paramFactory)
    {
      return paramObservable.distinctUntilChanged().onBackpressureBuffer(500L).groupBy(Composer.V8..Lambda.1.lambdaFactory$()).map(Composer.V8..Lambda.2.lambdaFactory$()).flatMap(Composer.V8..Lambda.3.lambdaFactory$(paramAttributeStream, paramAttributeStream1, paramAttributeStream2, paramAttributeStream3, paramAttributeStream4, paramAttributeStream5, paramAttributeStream6, paramAttributeStream7, paramFactory));
    }
    
    @FunctionalInterface
    public static abstract interface Factory<T0, T1, T2, T3, T4, T5, T6, T7, R>
    {
      public abstract R create(String paramString, T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5, T6 paramT6, T7 paramT7);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/rxjava/Composer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */