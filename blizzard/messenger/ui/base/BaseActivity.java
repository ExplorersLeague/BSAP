package com.blizzard.messenger.ui.base;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.renderscript.RSInvalidStateException;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.helper.ReconnectHelper;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.utils.AnalyticsUtils;
import com.blizzard.messenger.utils.ColorUtils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseActivity
  extends AppCompatActivity
{
  private ActionBar actionBar;
  private CompositeSubscription allSubscriptions;
  private ReconnectHelper reconnectHelper;
  private Snackbar reconnectingSnackbar;
  private boolean showSnackbar = true;
  protected Toolbar toolbar;
  
  private void checkSnackbarState(String paramString)
  {
    if (paramString.equals("com.blizzard.messenger.CONNECTING")) {
      if (this.showSnackbar) {
        this.reconnectingSnackbar.show();
      }
    }
    while ((!paramString.equals("com.blizzard.messenger.CONNECTED")) || (!this.reconnectingSnackbar.isShown())) {
      return;
    }
    this.reconnectingSnackbar.dismiss();
  }
  
  private void setupSnackbar()
  {
    this.reconnectingSnackbar = Snackbar.make(getWindow().getDecorView().findViewById(16908290), getString(2131361998), -2);
    this.reconnectingSnackbar.setAction(2131361901, BaseActivity..Lambda.4.lambdaFactory$(this));
    this.reconnectingSnackbar.getView().setBackgroundColor(ColorUtils.getColorPrimary(this));
  }
  
  protected final void navigateUp()
  {
    navigateUp(null);
  }
  
  protected final void navigateUp(@Nullable Bundle paramBundle)
  {
    Intent localIntent = NavUtils.getParentActivityIntent(this);
    localIntent.setFlags(603979776);
    if (paramBundle != null) {
      localIntent.replaceExtras(paramBundle);
    }
    if ((NavUtils.shouldUpRecreateTask(this, localIntent)) || (isTaskRoot()))
    {
      TaskStackBuilder.create(this).addNextIntentWithParentStack(localIntent).startActivities();
      return;
    }
    NavUtils.navigateUpTo(this, localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (SharedPrefsUtils.isLightThemeEnabled(this)) {
      setTheme(2131558662);
    }
    super.onCreate(paramBundle);
    trackScreen();
    this.reconnectHelper = new ReconnectHelper(this);
  }
  
  public void onPause()
  {
    super.onPause();
    this.reconnectHelper.stop();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
  }
  
  public void onResume()
  {
    super.onResume();
    this.allSubscriptions = new CompositeSubscription();
    setupSnackbar();
    this.allSubscriptions.add(MessengerProvider.getInstance().onConnectionStateChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(BaseActivity..Lambda.1.lambdaFactory$(this), BaseActivity..Lambda.2.lambdaFactory$()));
    this.allSubscriptions.add(this.reconnectHelper.onLoginRequired().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(BaseActivity..Lambda.3.lambdaFactory$(this)));
    this.reconnectHelper.start();
  }
  
  protected final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (this.actionBar == null) {
      throw new RSInvalidStateException("Action Bar not initialized");
    }
    this.actionBar.setDisplayHomeAsUpEnabled(paramBoolean);
  }
  
  protected final void setHomeButtonEnabled(boolean paramBoolean)
  {
    if (this.actionBar == null) {
      throw new RSInvalidStateException("Action Bar not initialized");
    }
    this.actionBar.setHomeButtonEnabled(paramBoolean);
  }
  
  public void setShowSnackbar(boolean paramBoolean)
  {
    this.showSnackbar = paramBoolean;
  }
  
  protected final void setStatusBarColor(int paramInt)
  {
    if (Build.VERSION.SDK_INT > 21)
    {
      Window localWindow = getWindow();
      localWindow.clearFlags(67108864);
      localWindow.addFlags(Integer.MIN_VALUE);
      localWindow.setStatusBarColor(paramInt);
    }
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    super.setSupportActionBar((Toolbar)findViewById(2131820684));
    this.actionBar = getSupportActionBar();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.actionBar == null) {
      throw new RSInvalidStateException("Action Bar not initialized");
    }
    this.actionBar.setTitle(paramCharSequence);
  }
  
  protected void trackScreen()
  {
    AnalyticsUtils.trackScreenView(((MessengerApplication)getApplication()).getDefaultTracker(), this);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/base/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */