package com.blizzard.messenger.data.utils;

import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import com.blizzard.messenger.data.exceptions.XmppException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XMPPError;
import rx.Single;
import rx.SingleSubscriber;

public class TransactionManager<Payload, Context>
{
  private final ErrorAction<Payload, Context> errorAction;
  private final Map<String, Pair<SingleSubscriber<? super Payload>, Context>> requestMap = new HashMap();
  private final StartAction<Context> startAction;
  
  public TransactionManager(@NonNull StartAction<Context> paramStartAction)
  {
    this(paramStartAction, TransactionManager..Lambda.1.lambdaFactory$());
  }
  
  public TransactionManager(@NonNull StartAction<Context> paramStartAction, @NonNull ErrorAction<Payload, Context> paramErrorAction)
  {
    this.startAction = paramStartAction;
    this.errorAction = paramErrorAction;
  }
  
  private void addRequest(String paramString, SingleSubscriber<? super Payload> paramSingleSubscriber, Context paramContext)
  {
    synchronized (this.requestMap)
    {
      this.requestMap.put(paramString, Pair.create(paramSingleSubscriber, paramContext));
      return;
    }
  }
  
  private boolean handleError(SingleSubscriber<? super Payload> paramSingleSubscriber, Throwable paramThrowable, String paramString, Stanza paramStanza, Context paramContext)
  {
    removeRequest(paramString);
    paramString = this.errorAction.call(paramThrowable, paramString, paramStanza, paramContext);
    if (paramString != null)
    {
      paramSingleSubscriber.onSuccess(paramString);
      return true;
    }
    paramSingleSubscriber.onError(paramThrowable);
    return false;
  }
  
  private Pair<SingleSubscriber<? super Payload>, Context> removeRequest(String paramString)
  {
    synchronized (this.requestMap)
    {
      paramString = (Pair)this.requestMap.remove(paramString);
      return paramString;
    }
  }
  
  public boolean completeTransaction(String paramString, Stanza paramStanza, Payload paramPayload)
  {
    boolean bool = false;
    Pair localPair = removeRequest(paramString);
    if (localPair != null)
    {
      XMPPError localXMPPError = paramStanza.getError();
      if (localXMPPError != null) {
        bool = handleError((SingleSubscriber)localPair.first, new XmppException(localXMPPError), paramString, paramStanza, localPair.second);
      }
    }
    else
    {
      return bool;
    }
    ((SingleSubscriber)localPair.first).onSuccess(paramPayload);
    return true;
  }
  
  public boolean completeTransaction(Stanza paramStanza, Payload paramPayload)
  {
    return completeTransaction(paramStanza.getStanzaId(), paramStanza, paramPayload);
  }
  
  public Context getContext(String paramString)
  {
    synchronized (this.requestMap)
    {
      paramString = (Pair)this.requestMap.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.second;
        return paramString;
      }
      return null;
    }
  }
  
  public Single<Payload> startTransaction(Stanza paramStanza, Context paramContext)
  {
    return startTransaction(paramStanza, paramContext, 30000L, TimeUnit.MILLISECONDS);
  }
  
  public Single<Payload> startTransaction(Stanza paramStanza, Context paramContext, long paramLong, TimeUnit paramTimeUnit)
  {
    return Single.create(TransactionManager..Lambda.2.lambdaFactory$(this, paramStanza, paramContext)).timeout(paramLong, paramTimeUnit);
  }
  
  public static abstract interface ErrorAction<Payload, Context>
  {
    public abstract Payload call(Throwable paramThrowable, String paramString, Stanza paramStanza, Context paramContext);
  }
  
  public static abstract interface StartAction<Context>
  {
    public abstract void call(Stanza paramStanza, Context paramContext)
      throws Exception;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/TransactionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */