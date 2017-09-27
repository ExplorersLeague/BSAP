package com.blizzard.messenger.ui.welcome;

import android.databinding.DataBindingUtil;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.LinearLayout;
import com.blizzard.messenger.adapter.WelcomeFragmentAdapter;
import com.blizzard.messenger.databinding.WelcomeActivityBinding;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.ui.SplashActivity;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.io.IOException;
import me.relex.circleindicator.CircleIndicator;
import rx.Observable;
import rx.Subscription;

public class WelcomeActivity
  extends AppCompatActivity
  implements TextureView.SurfaceTextureListener
{
  private WelcomeActivityBinding binding;
  private Subscription loginStateChangedSubscription;
  private MediaPlayer mediaPlayer;
  private int stopPosition = 0;
  
  private void startLogin()
  {
    startLoginAttempt();
  }
  
  private void startLoginAttempt()
  {
    startActivity(SplashActivity.newIntent(this, true));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.welcome.WelcomeActivity");
    super.onCreate(paramBundle);
    this.binding = ((WelcomeActivityBinding)DataBindingUtil.setContentView(this, 2130968714));
    this.binding.loginLinearLayout.setOnClickListener(WelcomeActivity..Lambda.1.lambdaFactory$(this));
    this.binding.videoView.setSurfaceTextureListener(this);
    this.loginStateChangedSubscription = MessengerProvider.getInstance().onLoginStateChanged().filter(WelcomeActivity..Lambda.2.lambdaFactory$()).subscribe(WelcomeActivity..Lambda.3.lambdaFactory$(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.loginStateChangedSubscription != null) {
      this.loginStateChangedSubscription.unsubscribe();
    }
    if (this.mediaPlayer != null)
    {
      this.mediaPlayer.release();
      this.mediaPlayer = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.mediaPlayer != null) && (this.mediaPlayer.isPlaying()))
    {
      this.stopPosition = this.mediaPlayer.getCurrentPosition();
      this.mediaPlayer.pause();
    }
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.welcome.WelcomeActivity");
    super.onResume();
    this.binding.viewPager.setAdapter(new WelcomeFragmentAdapter(getSupportFragmentManager()));
    this.binding.indicator.setViewPager(this.binding.viewPager);
    if ((this.mediaPlayer != null) && (!this.mediaPlayer.isPlaying()))
    {
      this.mediaPlayer.seekTo(this.stopPosition);
      this.mediaPlayer.start();
    }
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.welcome.WelcomeActivity");
    super.onStart();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = new Surface(paramSurfaceTexture);
    Uri localUri = Uri.parse("android.resource://" + getPackageName() + "/" + 2131296259);
    if (this.mediaPlayer == null) {
      try
      {
        this.mediaPlayer = new MediaPlayer();
        this.mediaPlayer.setDataSource(this, localUri);
        this.mediaPlayer.setSurface(paramSurfaceTexture);
        this.mediaPlayer.prepare();
        this.mediaPlayer.setLooping(true);
        this.mediaPlayer.start();
        return;
      }
      catch (IOException paramSurfaceTexture)
      {
        paramSurfaceTexture.printStackTrace();
        return;
      }
    }
    this.mediaPlayer.setSurface(paramSurfaceTexture);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/welcome/WelcomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */