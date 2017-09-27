package com.blizzard.messenger.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.blizzard.messenger.exceptions.AccountMutedException;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.error.AccountMuteActivity;
import java.util.concurrent.TimeUnit;
import rx.Completable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class LoginActivity
  extends AppCompatActivity
{
  private static final String TAG = LoginActivity.class.getSimpleName();
  private long lastLoginTime;
  private Subscription loginSubscription;
  private Subscription queueSubscription;
  
  private void cancelQueue()
  {
    if (this.queueSubscription != null)
    {
      this.queueSubscription.unsubscribe();
      this.queueSubscription = null;
    }
  }
  
  private long getLoginDelay()
  {
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    if (this.lastLoginTime == 0L) {}
    for (;;)
    {
      this.lastLoginTime = l2;
      return l1;
      l1 = Math.max(0L, 5000L - (l2 - this.lastLoginTime));
    }
  }
  
  private void handleLoginError(Throwable paramThrowable)
  {
    Log.d(TAG, "handleLoginError throwable = " + paramThrowable, paramThrowable);
    Telemetry.loginFailed();
    if ((paramThrowable instanceof AccountMutedException))
    {
      showAccountMuteActivity();
      return;
    }
    startLogin(true);
  }
  
  private void handleLoginSuccess()
  {
    Log.d(TAG, "handleLoginSuccess");
    Telemetry.loginSucceeded();
    onLoginSuccess();
  }
  
  private void showAccountMuteActivity()
  {
    Log.d(TAG, "showAccountMuteActivity");
    startActivity(new Intent(this, AccountMuteActivity.class));
    finish();
  }
  
  private void showLoginQueueActivity()
  {
    Log.d(TAG, "showLoginQueueActivity");
    startActivity(new Intent(this, LoginQueueActivity.class));
  }
  
  private void startQueue()
  {
    cancelQueue();
    this.queueSubscription = Completable.timer(20000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(LoginActivity..Lambda.3.lambdaFactory$(this));
  }
  
  protected void cancelLogin()
  {
    if (this.loginSubscription != null)
    {
      Log.d(TAG, "cancelLogin");
      this.loginSubscription.unsubscribe();
      this.loginSubscription = null;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cancelLogin();
  }
  
  protected abstract void onLoginSuccess();
  
  public void onPause()
  {
    super.onPause();
    cancelQueue();
  }
  
  public void onResume()
  {
    super.onResume();
    startQueue();
  }
  
  protected void startLogin(boolean paramBoolean)
  {
    cancelLogin();
    if (paramBoolean) {}
    for (long l = 0L;; l = getLoginDelay())
    {
      Log.d(TAG, "startLogin startInErrorState=" + paramBoolean + ", delay=" + l);
      this.loginSubscription = Completable.timer(l, TimeUnit.MILLISECONDS).concatWith(MessengerProvider.getInstance().login(this, paramBoolean)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(LoginActivity..Lambda.1.lambdaFactory$(this), LoginActivity..Lambda.2.lambdaFactory$(this));
      return;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/login/LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */