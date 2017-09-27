package com.blizzard.messenger.ui.settings;

import android.os.Bundle;
import com.blizzard.messenger.ui.base.BasePreferenceFragment;

public class AccessibilityFragment
  extends BasePreferenceFragment
{
  public static AccessibilityFragment getInstance()
  {
    return new AccessibilityFragment();
  }
  
  public void onCreatePreferences(Bundle paramBundle, String paramString)
  {
    addPreferencesFromResource(2131230720);
    super.onCreatePreferences(paramBundle, paramString);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/AccessibilityFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */