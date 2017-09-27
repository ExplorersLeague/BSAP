package com.blizzard.messenger.data.xmpp.impl;

import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.IQReplyFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import rx.Completable;
import rx.Single;

public final class IncomingStanzaInterceptor
{
  private static boolean testFailResponses = false;
  private static boolean testTimeoutResponses = false;
  
  public static Completable listenForResponse(@NonNull IQ paramIQ, @NonNull XMPPConnection paramXMPPConnection)
  {
    if (testFailResponses) {
      return Completable.error(new RuntimeException("Simulated Error"));
    }
    if (testTimeoutResponses) {
      return Completable.never().timeout(30000L, TimeUnit.MILLISECONDS);
    }
    return listenForStanza(new IQReplyFilter(paramIQ, paramXMPPConnection), paramXMPPConnection).map(IncomingStanzaInterceptor..Lambda.2.lambdaFactory$()).toCompletable().timeout(30000L, TimeUnit.MILLISECONDS);
  }
  
  public static Single<Stanza> listenForStanza(@NonNull StanzaFilter paramStanzaFilter, @NonNull XMPPConnection paramXMPPConnection)
  {
    return Single.create(IncomingStanzaInterceptor..Lambda.1.lambdaFactory$(paramXMPPConnection, paramStanzaFilter));
  }
  
  public static void setTestFailResponses(boolean paramBoolean)
  {
    testFailResponses = paramBoolean;
  }
  
  public static void setTestTimeoutResponses(boolean paramBoolean)
  {
    testTimeoutResponses = paramBoolean;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/impl/IncomingStanzaInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */