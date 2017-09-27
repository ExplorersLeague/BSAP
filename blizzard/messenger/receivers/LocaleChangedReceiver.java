package com.blizzard.messenger.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import com.blizzard.messenger.helper.SettingsHelper;
import com.blizzard.messenger.providers.MessengerProvider;
import javax.inject.Inject;

public class LocaleChangedReceiver
  extends BroadcastReceiver
{
  private static final String TAG = LocaleChangedReceiver.class.getSimpleName();
  @Inject
  SettingsModel settingsModel;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d(TAG, "onReceive()");
    if (paramIntent.getAction().equals("android.intent.action.LOCALE_CHANGED"))
    {
      ((MessengerApplication)paramContext.getApplicationContext()).getModelComponent().inject(this);
      if (MessengerProvider.getInstance().isConnected()) {
        new SettingsHelper(paramContext).updateLocale();
      }
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/receivers/LocaleChangedReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */