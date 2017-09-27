package com.blizzard.pushlibrary.util;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.Iterator;
import java.util.Set;

public class Utils
{
  private static final String TAG = LogUtils.generateLogTag(Utils.class);
  
  public static void dumpExtrasUtility(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      Iterator localIterator = paramIntent.keySet().iterator();
      Log.e(TAG, "Dumping Intent start");
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Log.e(TAG, "[" + str + "=" + paramIntent.get(str) + "]");
      }
      Log.e(TAG, "Dumping Intent end");
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/util/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */