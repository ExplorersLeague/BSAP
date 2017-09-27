package com.blizzard.messenger.data.datastores;

import android.database.sqlite.SQLiteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.blizzard.messenger.data.providers.ConversationProvider;
import com.orm.SugarRecord;
import java.util.Iterator;
import rx.Completable;
import rx.Emitter.BackpressureMode;
import rx.Observable;
import rx.schedulers.Schedulers;

public class UnsentChatTextDatastore
{
  private static final String FIELD_CONVERSATION_ID = "conversation_id";
  private static final String TAG = UnsentChatTextDatastore.class.getSimpleName();
  
  private void deleteUnsentText(Void paramVoid)
  {
    try
    {
      UnsentChatText.deleteAll(UnsentChatText.class);
      return;
    }
    catch (SQLiteException paramVoid)
    {
      Log.e(TAG, "deleteUnsentText error: " + paramVoid.getMessage());
    }
  }
  
  private UnsentChatText findUnsentChatText(String paramString)
  {
    paramString = UnsentChatText.findAsIterator(UnsentChatText.class, "conversation_id=?", new String[] { paramString });
    if (paramString.hasNext()) {
      return (UnsentChatText)paramString.next();
    }
    return null;
  }
  
  public void deleteUnsentText(String paramString)
  {
    try
    {
      UnsentChatText localUnsentChatText = findUnsentChatText(paramString);
      if (localUnsentChatText != null) {
        localUnsentChatText.delete();
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e(TAG, "deleteUnsentText conversationId=" + paramString + " error: " + localSQLiteException.getMessage());
    }
  }
  
  public Observable<String> getUnsentChatText(String paramString)
  {
    return Observable.create(UnsentChatTextDatastore..Lambda.4.lambdaFactory$(this, paramString), Emitter.BackpressureMode.BUFFER);
  }
  
  public void setProvider(ConversationProvider paramConversationProvider)
  {
    paramConversationProvider.onConversationsDeleted().subscribeOn(Schedulers.io()).subscribe(UnsentChatTextDatastore..Lambda.1.lambdaFactory$(this));
    paramConversationProvider.onConversationHidden().subscribeOn(Schedulers.io()).subscribe(UnsentChatTextDatastore..Lambda.2.lambdaFactory$(this));
    paramConversationProvider.onMessageCreated().subscribeOn(Schedulers.io()).subscribe(UnsentChatTextDatastore..Lambda.3.lambdaFactory$(this));
  }
  
  public Completable setUnsentChatText(String paramString1, String paramString2)
  {
    return Completable.create(UnsentChatTextDatastore..Lambda.5.lambdaFactory$(this, paramString1, paramString2));
  }
  
  public static class UnsentChatText
    extends SugarRecord
  {
    private String conversationId;
    private String text;
    
    public UnsentChatText() {}
    
    UnsentChatText(@NonNull String paramString)
    {
      this.conversationId = paramString;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/datastores/UnsentChatTextDatastore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */