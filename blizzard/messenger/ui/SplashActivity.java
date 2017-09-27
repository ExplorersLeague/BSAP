package com.blizzard.messenger.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.TextView;
import com.blizzard.messenger.data.listeners.ConnectivityListener;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.databinding.SplashActivityBinding;
import com.blizzard.messenger.helper.SettingsHelper;
import com.blizzard.messenger.receivers.RegionInfoReceiver;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.friends.management.AddFriendActivity;
import com.blizzard.messenger.ui.friends.qr.ScanQRCodeActivity;
import com.blizzard.messenger.ui.friends.qr.ShowQRCodeActivity;
import com.blizzard.messenger.ui.login.LoginActivity;
import com.blizzard.messenger.ui.main.MainActivity;
import com.blizzard.messenger.ui.welcome.WelcomeActivity;
import com.blizzard.messenger.utils.NotificationUtils;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.util.concurrent.TimeUnit;
import rx.Completable;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class SplashActivity
  extends LoginActivity
{
  private static String EXTRA_SUPPRESS_WELCOME = "com.blizzard.messenger.ui.SplashActivity.SUPPRESS_WELCOME";
  private SplashActivityBinding binding;
  private Bundle extras;
  private boolean firstResume = true;
  private String intentAction;
  private Subscription regionChangedSubscription;
  private Subscription showConnectingTextSubscription;
  private boolean wasWebAuthLaunched = false;
  
  private void checkForAuthToken()
  {
    Object localObject = getIntent().getData();
    if (localObject != null)
    {
      localObject = ((Uri)localObject).getQueryParameter("ST");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        SharedPrefsUtils.setWebAuthToken(this, (String)localObject);
      }
    }
  }
  
  private void hideConnectingText()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.binding.flavorTextView, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.start();
  }
  
  private void initialize()
  {
    this.regionChangedSubscription = RegionInfoReceiver.onRegionInfoChanged().subscribe(SplashActivity..Lambda.1.lambdaFactory$(this));
    getWindow().setBackgroundDrawableResource(2130837754);
    this.binding = ((SplashActivityBinding)DataBindingUtil.setContentView(this, 2130968709));
  }
  
  public static Intent newIntent(Context paramContext, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra(EXTRA_SUPPRESS_WELCOME, paramBoolean);
    return paramContext;
  }
  
  public static Intent newIntent(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra(EXTRA_SUPPRESS_WELCOME, paramBoolean);
    paramContext.setAction(paramString);
    return paramContext;
  }
  
  private void showConnectingText()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.binding.flavorTextView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.start();
  }
  
  private void showWelcomeScreens()
  {
    startActivity(new Intent(this, WelcomeActivity.class));
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001) {
      this.wasWebAuthLaunched = true;
    }
    switch (paramInt2)
    {
    case -1: 
    default: 
      return;
    case 0: 
    case 20001: 
      showWelcomeScreens();
      return;
    }
    if (!ConnectivityListener.isNetworkAvailable()) {}
    for (;;)
    {
      startLogin(bool);
      return;
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.SplashActivity");
    super.onCreate(paramBundle);
    this.extras = getIntent().getExtras();
    this.intentAction = getIntent().getAction();
    initialize();
    checkForAuthToken();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.regionChangedSubscription.unsubscribe();
  }
  
  protected void onLoginSuccess()
  {
    Telemetry.appMainLaunched(System.currentTimeMillis() - Telemetry.getStartTime(), this.wasWebAuthLaunched);
    new SettingsHelper(this).updateLocale();
    if (!TextUtils.isEmpty(this.intentAction))
    {
      String str = this.intentAction;
      int i = -1;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          startActivity(MainActivity.newIntent(this));
          finish();
          return;
          if (str.equals("com.blizzard.messenger.LOGIN_RESTART"))
          {
            i = 0;
            continue;
            if (str.equals("com.blizzard.messenger.ACTION_NOTIFICATION_FRIEND_REQUEST"))
            {
              i = 1;
              continue;
              if (str.equals("com.blizzard.messenger.ACTION_NOTIFICATION_WHISPER"))
              {
                i = 2;
                continue;
                if (str.equals("com.blizzard.messenger.ADD_FRIEND"))
                {
                  i = 3;
                  continue;
                  if (str.equals("com.blizzard.messenger.SCAN_QR_CODE"))
                  {
                    i = 4;
                    continue;
                    if (str.equals("com.blizzard.messenger.SHOW_QR_CODE")) {
                      i = 5;
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      finish();
      return;
      NotificationUtils.handleFriendRequestDeeplink(this);
      return;
      NotificationUtils.handleWhisperDeeplink(this, this.extras);
      return;
      startActivity(new Intent(this, AddFriendActivity.class));
      finish();
      return;
      startActivity(new Intent(this, ScanQRCodeActivity.class));
      finish();
      return;
      startActivity(new Intent(this, ShowQRCodeActivity.class));
      finish();
      return;
    }
    startActivity(MainActivity.newIntent(this));
    finish();
  }
  
  public void onPause()
  {
    super.onPause();
    this.showConnectingTextSubscription.unsubscribe();
    if (this.binding.flavorTextView.getAlpha() == 1.0F) {
      hideConnectingText();
    }
  }
  
  public void onResume()
  {
    boolean bool = false;
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.SplashActivity");
    super.onResume();
    this.showConnectingTextSubscription = Completable.timer(4000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(SplashActivity..Lambda.2.lambdaFactory$(this));
    if (this.firstResume)
    {
      this.firstResume = false;
      if ((TextUtils.isEmpty(SharedPrefsUtils.getWebAuthToken(this))) && (!getIntent().getBooleanExtra(EXTRA_SUPPRESS_WELCOME, false))) {
        showWelcomeScreens();
      }
    }
    else
    {
      return;
    }
    if (!ConnectivityListener.isNetworkAvailable()) {
      bool = true;
    }
    startLogin(bool);
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.SplashActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */