package com.blizzard.messenger.ui.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.utils.AnalyticsUtils;

public class BaseFragment
  extends Fragment
{
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    AnalyticsUtils.trackScreenView(((MessengerApplication)getActivity().getApplication()).getDefaultTracker(), getActivity(), getClass().getSimpleName());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/base/BaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */