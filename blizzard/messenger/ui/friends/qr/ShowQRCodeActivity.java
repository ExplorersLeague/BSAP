package com.blizzard.messenger.ui.friends.qr;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.profile.Profile;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.databinding.ShowQrCodeActivityBinding;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.utils.ImageUtils;
import com.google.firebase.perf.metrics.AppStartTrace;
import javax.inject.Inject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class ShowQRCodeActivity
  extends BaseActivity
{
  private CompositeSubscription allSubscriptions;
  private ShowQrCodeActivityBinding binding;
  @Inject
  ProfileModel profileModel;
  
  private void updateProfile(@NonNull Profile paramProfile)
  {
    this.binding.nameTextView.setText(paramProfile.getBattleTag());
    this.binding.qrCodeImageView.setImageBitmap(ImageUtils.getQrCode(this, paramProfile.getBattleTag()));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.friends.qr.ShowQRCodeActivity");
    super.onCreate(paramBundle);
    ((MessengerApplication)getApplication()).getModelComponent().inject(this);
    this.binding = ((ShowQrCodeActivityBinding)DataBindingUtil.setContentView(this, 2130968707));
    setSupportActionBar(this.binding.toolbar);
    setTitle(getString(2131362038));
    setDisplayHomeAsUpEnabled(true);
    this.binding.backgroundImageView.setImageResource(ImageUtils.getAddFriendImageResourceId());
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.friends.qr.ShowQRCodeActivity");
    super.onResume();
    this.allSubscriptions = new CompositeSubscription();
    this.allSubscriptions.add(this.profileModel.onProfileUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(ShowQRCodeActivity..Lambda.1.lambdaFactory$(this)));
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.friends.qr.ShowQRCodeActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/qr/ShowQRCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */