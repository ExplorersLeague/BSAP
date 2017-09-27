package com.blizzard.messenger.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.blizzard.login.region.RegionInfo;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import rx.Observable;
import rx.subjects.PublishSubject;

public class RegionInfoReceiver
  extends BroadcastReceiver
{
  private static final PublishSubject<RegionInfo> regionInfoChangedSubject = ;
  
  public static Observable<RegionInfo> onRegionInfoChanged()
  {
    return regionInfoChangedSubject.distinctUntilChanged().onBackpressureLatest();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = (RegionInfo)paramIntent.getParcelableExtra("com.blizzard.loginsdk.REGION_INFO");
    if (paramIntent != null)
    {
      SharedPrefsUtils.setBgsRegionCode(paramContext, paramIntent.getRegionCode());
      regionInfoChangedSubject.onNext(paramIntent);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/receivers/RegionInfoReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */