package com.blizzard.login.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.blizzard.login.logger.Logger;
import com.google.firebase.perf.metrics.AppStartTrace;

public class AuthSuccessActivity
  extends AppCompatActivity
{
  private static final String TAG = AuthSuccessActivity.class.getSimpleName();
  
  private void completeLogin(String paramString)
  {
    Logger.info(TAG, "completeLogin");
    Logger.info(TAG, "authToken: " + paramString);
    Intent localIntent = new Intent();
    localIntent.setAction("com.blizzard.loginsdk.OAUTH_TOKEN");
    localIntent.putExtra("com.blizzard.loginsdk.OAUTH_TOKEN", paramString);
    sendBroadcast(localIntent);
    finish();
  }
  
  private String getAuthToken()
  {
    return getIntent().getData().getQueryParameter("ST");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.login.ui.AuthSuccessActivity");
    Logger.info(TAG, "onCreate");
    super.onCreate(paramBundle);
    completeLogin(getAuthToken());
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.login.ui.AuthSuccessActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.login.ui.AuthSuccessActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/ui/AuthSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */