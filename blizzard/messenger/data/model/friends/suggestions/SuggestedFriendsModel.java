package com.blizzard.messenger.data.model.friends.suggestions;

import android.support.annotation.NonNull;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.providers.SuggestedFriendsProvider;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.subjects.PublishSubject;

public class SuggestedFriendsModel
{
  private List<SuggestedFriend> suggestedFriends;
  private final PublishSubject<List<SuggestedFriend>> suggestedFriendsUpdatedSubject = PublishSubject.create();
  
  private void clearSuggestedFriends()
  {
    try
    {
      this.suggestedFriends = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void updateSuggestedFriends(@NonNull List<SuggestedFriend> paramList)
  {
    this.suggestedFriends = Collections.unmodifiableList(paramList);
    this.suggestedFriendsUpdatedSubject.onNext(this.suggestedFriends);
  }
  
  /* Error */
  public boolean hasValue()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/blizzard/messenger/data/model/friends/suggestions/SuggestedFriendsModel:suggestedFriends	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	SuggestedFriendsModel
    //   12	7	1	bool	boolean
    //   6	2	2	localList	List
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public Observable<List<SuggestedFriend>> onSuggestedFriendsUpdated()
  {
    if (this.suggestedFriends != null) {
      return Observable.just(this.suggestedFriends).concatWith(this.suggestedFriendsUpdatedSubject).onBackpressureLatest();
    }
    return this.suggestedFriendsUpdatedSubject.onBackpressureLatest();
  }
  
  public void setFriendsModel(@NonNull FriendsModel paramFriendsModel)
  {
    paramFriendsModel.onFriendAdded().mergeWith(paramFriendsModel.onFriendRemoved()).subscribe(SuggestedFriendsModel..Lambda.3.lambdaFactory$(this));
  }
  
  public void setSuggestedFriendsProvider(@NonNull SuggestedFriendsProvider paramSuggestedFriendsProvider)
  {
    paramSuggestedFriendsProvider.onSuggestedFriendsReceived().subscribe(SuggestedFriendsModel..Lambda.1.lambdaFactory$(this));
    paramSuggestedFriendsProvider.onSuggestedFriendsCleared().subscribe(SuggestedFriendsModel..Lambda.2.lambdaFactory$(this));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/model/friends/suggestions/SuggestedFriendsModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */