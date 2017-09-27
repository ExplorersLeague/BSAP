package com.blizzard.messenger.ui.profile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.airbnb.lottie.LottieAnimationView;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.profile.Profile;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.databinding.ProfileFragmentBinding;
import com.blizzard.messenger.databinding.ProfileSettingRowBinding;
import com.blizzard.messenger.databinding.ProfileSettingRowNoIconBinding;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.SplashActivity;
import com.blizzard.messenger.ui.base.BaseFragment;
import com.blizzard.messenger.ui.settings.AboutActivity;
import com.blizzard.messenger.ui.settings.SettingsActivity;
import com.blizzard.messenger.utils.ColorUtils;
import com.blizzard.messenger.utils.PresenceUtils;
import com.blizzard.messenger.utils.ViewUtils;
import com.blizzard.messenger.views.dialog.MessengerDialogFragment;
import javax.inject.Inject;
import rx.Completable;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

public class ProfileFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private static final String TAG = ProfileFragment.class.getSimpleName();
  private CompositeSubscription allSubscriptions;
  private ProfileFragmentBinding binding;
  @Inject
  ProfileModel profileModel;
  private final PublishSubject<Integer> statusSubject = PublishSubject.create();
  
  private void cleanUp()
  {
    Log.d(TAG, "cleanUp()");
    Intent localIntent = SplashActivity.newIntent(getContext(), false);
    localIntent.addFlags(268468224);
    getActivity().startActivity(localIntent);
  }
  
  private void initialize()
  {
    this.binding.statusOnlineLinearLayout.setOnClickListener(this);
    this.binding.statusAwayLinearLayout.setOnClickListener(this);
    this.binding.statusBusyLinearLayout.setOnClickListener(this);
    this.statusSubject.observeOn(AndroidSchedulers.mainThread()).distinctUntilChanged().subscribe(ProfileFragment..Lambda.4.lambdaFactory$(this));
    setupSettingsViews();
  }
  
  private void logout()
  {
    MessengerProvider.getInstance().attemptLogout(getActivity()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(ProfileFragment..Lambda.14.lambdaFactory$()).doOnCompleted(ProfileFragment..Lambda.15.lambdaFactory$()).doOnError(ProfileFragment..Lambda.16.lambdaFactory$()).subscribe(ProfileFragment..Lambda.17.lambdaFactory$(this), ProfileFragment..Lambda.18.lambdaFactory$());
  }
  
  private void setupSettingsViews()
  {
    this.binding.about.titleTextView.setText(getString(2131361830));
    this.binding.about.parent.setOnClickListener(ProfileFragment..Lambda.5.lambdaFactory$(this));
    this.binding.accessibility.parent.setOnClickListener(ProfileFragment..Lambda.6.lambdaFactory$(this));
    this.binding.accessibility.imageView.setImageResource(2130837664);
    this.binding.accessibility.titleTextView.setText(2131362030);
    this.binding.appSettings.parent.setOnClickListener(ProfileFragment..Lambda.7.lambdaFactory$(this));
    this.binding.appSettings.imageView.setImageResource(2130837677);
    this.binding.appSettings.titleTextView.setText(2131362032);
    this.binding.deviceSettings.parent.setOnClickListener(ProfileFragment..Lambda.8.lambdaFactory$(this));
    this.binding.deviceSettings.imageView.setImageResource(2130837687);
    this.binding.deviceSettings.titleTextView.setText(2131362033);
    this.binding.deviceSettings.externalLinkImageView.setVisibility(0);
    this.binding.developerSettings.parent.setOnClickListener(ProfileFragment..Lambda.9.lambdaFactory$(this));
    this.binding.developerSettings.titleTextView.setText(getString(2131361894));
    this.binding.logOut.setOnClickListener(ProfileFragment..Lambda.10.lambdaFactory$(this));
    this.binding.notifications.parent.setOnClickListener(ProfileFragment..Lambda.11.lambdaFactory$(this));
    this.binding.notifications.imageView.setImageResource(2130837704);
    this.binding.notifications.titleTextView.setText(2131362035);
    this.binding.support.parent.setOnClickListener(ProfileFragment..Lambda.12.lambdaFactory$(this));
    this.binding.support.titleTextView.setText(2131362036);
    this.binding.developerSettings.getRoot().setVisibility(8);
  }
  
  private void showAboutActivity()
  {
    startActivity(new Intent(getActivity(), AboutActivity.class));
  }
  
  private void showLogoutDialog()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("Message", getString(2131361899));
    ((Bundle)localObject).putString("NegativeButton", getString(2131361958));
    ((Bundle)localObject).putString("PositiveButton", getString(2131362034));
    ((Bundle)localObject).putString("Title", getString(2131361900));
    localObject = MessengerDialogFragment.newInstance((Bundle)localObject);
    if (localObject != null)
    {
      ((MessengerDialogFragment)localObject).onPositiveButtonClicked().subscribe(ProfileFragment..Lambda.13.lambdaFactory$(this));
      ((MessengerDialogFragment)localObject).show(getActivity().getSupportFragmentManager(), "LogoutFragment");
    }
  }
  
  private void showSettings(String paramString)
  {
    Intent localIntent = new Intent(getActivity(), SettingsActivity.class);
    localIntent.putExtra("com.blizzard.messenger.EXTRA_SETTING_TYPE", paramString);
    startActivity(localIntent);
  }
  
  private void updatePresence(int paramInt)
  {
    Telemetry.profileStatusChanged(paramInt);
    ViewUtils.reportError(getActivity(), MessengerProvider.getInstance().setPresenceStatus(paramInt));
  }
  
  private void updatePresenceGame(String paramString)
  {
    this.binding.presenceGameImageView.setImageResource(PresenceUtils.getGameIconResId(paramString));
    this.binding.avatarBackgroundImageView.setImageResource(PresenceUtils.getGameBackgroundResId(paramString));
  }
  
  private void updatePresenceStatus(int paramInt)
  {
    if (paramInt == 1)
    {
      this.binding.statusOnlineImageView.playAnimation();
      this.binding.statusOnlineImageView.setAlpha(1.0F);
      this.binding.statusAwayImageView.cancelAnimation();
      this.binding.statusAwayImageView.setProgress(0.0F);
      this.binding.statusAwayImageView.setAlpha(0.35F);
      this.binding.statusBusyImageView.cancelAnimation();
      this.binding.statusBusyImageView.setProgress(0.0F);
      this.binding.statusBusyImageView.setAlpha(0.35F);
    }
    for (;;)
    {
      this.binding.presenceStatusImageView.setImageResource(PresenceUtils.getPresenceStatusIconResId(paramInt));
      return;
      if (paramInt == 3)
      {
        this.binding.statusOnlineImageView.cancelAnimation();
        this.binding.statusOnlineImageView.setProgress(0.0F);
        this.binding.statusOnlineImageView.setAlpha(0.35F);
        this.binding.statusAwayImageView.playAnimation();
        this.binding.statusAwayImageView.setAlpha(1.0F);
        this.binding.statusBusyImageView.cancelAnimation();
        this.binding.statusBusyImageView.setProgress(0.0F);
        this.binding.statusBusyImageView.setAlpha(0.35F);
      }
      else if (paramInt == 4)
      {
        this.binding.statusOnlineImageView.cancelAnimation();
        this.binding.statusOnlineImageView.setProgress(0.0F);
        this.binding.statusOnlineImageView.setAlpha(0.35F);
        this.binding.statusAwayImageView.cancelAnimation();
        this.binding.statusAwayImageView.setProgress(0.0F);
        this.binding.statusAwayImageView.setAlpha(0.35F);
        this.binding.statusBusyImageView.playAnimation();
        this.binding.statusBusyImageView.setAlpha(1.0F);
      }
      else
      {
        this.binding.statusOnlineImageView.cancelAnimation();
        this.binding.statusOnlineImageView.setProgress(0.0F);
        this.binding.statusOnlineImageView.setAlpha(0.35F);
        this.binding.statusAwayImageView.cancelAnimation();
        this.binding.statusAwayImageView.setProgress(0.0F);
        this.binding.statusAwayImageView.setAlpha(0.35F);
        this.binding.statusBusyImageView.cancelAnimation();
        this.binding.statusBusyImageView.setProgress(0.0F);
        this.binding.statusBusyImageView.setAlpha(0.35F);
      }
    }
  }
  
  private void updateProfile(@NonNull Profile paramProfile)
  {
    if (paramProfile.getStatus() == 5) {
      this.binding.appearingOfflineBar.setVisibility(0);
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Object localObject = paramProfile.getBattleTag().split("#");
      SpannableString localSpannableString = new SpannableString(localObject[0]);
      localSpannableString.setSpan(new ForegroundColorSpan(ColorUtils.getTextColorPrimary(getContext())), 0, localSpannableString.length(), 0);
      localSpannableStringBuilder.append(localSpannableString);
      localObject = new SpannableString("#" + localObject[1]);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(ColorUtils.getTextColorPrimaryDark(getContext())), 0, ((SpannableString)localObject).length(), 0);
      localSpannableStringBuilder.append((CharSequence)localObject);
      this.binding.nameTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
      updatePresenceStatus(paramProfile.getStatus());
      updatePresenceGame(paramProfile.getGame());
      return;
      this.binding.appearingOfflineBar.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131820850: 
    case 2131820852: 
    default: 
      return;
    case 2131820849: 
      this.statusSubject.onNext(Integer.valueOf(1));
      return;
    case 2131820851: 
      this.statusSubject.onNext(Integer.valueOf(3));
      return;
    }
    this.statusSubject.onNext(Integer.valueOf(4));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ((MessengerApplication)getActivity().getApplication()).getModelComponent().inject(this);
    super.onCreate(paramBundle);
    MessengerProvider.getInstance().retrieveProfile();
    setHasOptionsMenu(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.binding = ((ProfileFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968689, paramViewGroup, false));
    initialize();
    return this.binding.getRoot();
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
  }
  
  public void onResume()
  {
    super.onResume();
    this.allSubscriptions = new CompositeSubscription();
    this.allSubscriptions.add(this.profileModel.onProfileUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(ProfileFragment..Lambda.1.lambdaFactory$(this)));
    this.allSubscriptions.add(this.profileModel.onProfileUpdated().observeOn(AndroidSchedulers.mainThread()).map(ProfileFragment..Lambda.2.lambdaFactory$()).mergeWith(this.statusSubject).distinctUntilChanged().subscribe(ProfileFragment..Lambda.3.lambdaFactory$(this)));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/profile/ProfileFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */