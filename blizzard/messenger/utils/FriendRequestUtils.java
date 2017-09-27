package com.blizzard.messenger.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import com.blizzard.messenger.data.model.friends.FriendRequest;

public final class FriendRequestUtils
{
  public static String getAssociationText(@NonNull Context paramContext, @NonNull FriendRequest paramFriendRequest)
  {
    paramFriendRequest = paramFriendRequest.getAssociation();
    int i = -1;
    switch (paramFriendRequest.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "";
        if (paramFriendRequest.equals("BattleTag"))
        {
          i = 0;
          continue;
          if (paramFriendRequest.equals("Email")) {
            i = 1;
          }
        }
        break;
      }
    }
    return paramContext.getResources().getString(2131361926);
    return paramContext.getResources().getString(2131361927);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/FriendRequestUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */