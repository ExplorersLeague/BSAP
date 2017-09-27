package com.blizzard.messenger.ui.friends.management;

import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.blizzard.messenger.databinding.AddFriendActivityBinding;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.utils.ColorUtils;
import com.blizzard.messenger.utils.ImageUtils;
import com.blizzard.messenger.utils.StringUtils;
import com.blizzard.messenger.utils.ViewUtils;
import com.blizzard.messenger.views.dialog.FriendRequestDialogFragment;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.lang.reflect.Field;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

public class AddFriendActivity
  extends BaseActivity
{
  private CompositeSubscription allSubscriptions;
  private AddFriendActivityBinding binding;
  private final PublishSubject<Boolean> canSendSubject = PublishSubject.create();
  private Menu menu;
  
  private void addFriend()
  {
    String str = this.binding.friendNameEditText.getText().toString();
    if ((StringUtils.isValidEmail(str)) || (StringUtils.isValidBattletag(str)))
    {
      showFriendRequestDialog(str);
      resetColors();
      return;
    }
    if (str.toLowerCase().trim().equals(getString(2131361954).toLowerCase()))
    {
      MediaPlayer.create(this, 2131296257).start();
      this.binding.friendNameEditText.setText("");
      resetColors();
      return;
    }
    showErrorUi();
  }
  
  private void initialize()
  {
    this.binding.friendNameEditText.requestFocus();
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.binding.friendNameEditText, 1);
    getWindow().setSoftInputMode(4);
    this.binding.backgroundImageView.setImageResource(ImageUtils.getAddFriendImageResourceId());
    this.binding.friendNameEditText.setOnEditorActionListener(AddFriendActivity..Lambda.2.lambdaFactory$(this));
    this.binding.friendNameEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        PublishSubject localPublishSubject = AddFriendActivity.this.canSendSubject;
        if (paramAnonymousEditable.length() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          localPublishSubject.onNext(Boolean.valueOf(bool));
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void resetColors()
  {
    this.binding.helpTextView.setTextColor(ColorUtils.getTextColorPrimaryDark(this));
    this.binding.friendNameEditText.getBackground().clearColorFilter();
    setInputTextLayoutColor(ColorUtils.getColorAccent(this));
  }
  
  private void setInputTextLayoutColor(@ColorInt int paramInt)
  {
    try
    {
      Field localField = TextInputLayout.class.getDeclaredField("mDefaultTextColor");
      localField.setAccessible(true);
      localField.set(this.binding.friendNameTextInputLayout, new ColorStateList(new int[][] { { 0 } }, new int[] { paramInt }));
      localField = TextInputLayout.class.getDeclaredField("mFocusedTextColor");
      localField.setAccessible(true);
      localField.set(this.binding.friendNameTextInputLayout, new ColorStateList(new int[][] { { 0 } }, new int[] { paramInt }));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void showErrorUi()
  {
    this.binding.helpTextView.setTextColor(ColorUtils.getTextColorError(this));
    this.binding.friendNameEditText.getBackground().setColorFilter(ColorUtils.getTextColorError(this), PorterDuff.Mode.SRC_IN);
    setInputTextLayoutColor(ColorUtils.getTextColorError(this));
    this.binding.friendNameEditText.setText(this.binding.friendNameEditText.getText());
    this.binding.friendNameEditText.setSelection(this.binding.friendNameEditText.length());
  }
  
  private void showFriendRequestDialog(@NonNull String paramString)
  {
    if (StringUtils.isValidEmail(paramString)) {}
    for (String str = "Email";; str = "BattleTag")
    {
      paramString = FriendRequestDialogFragment.newSendInstance(paramString, str);
      paramString.onFriendRequestSent().subscribe(AddFriendActivity..Lambda.3.lambdaFactory$(this));
      paramString.show(getSupportFragmentManager(), "FriendRequestDialogFragment");
      this.binding.friendNameEditText.setText("");
      return;
    }
  }
  
  private void updateMenuItemColor(boolean paramBoolean)
  {
    if ((this.menu != null) && (this.menu.getItem(0) != null))
    {
      if (paramBoolean) {
        ViewUtils.tintMenuIcon(this, this.menu.getItem(0), 2131689473);
      }
    }
    else {
      return;
    }
    ViewUtils.tintMenuIcon(this, this.menu.getItem(0), 17170443);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.friends.management.AddFriendActivity");
    super.onCreate(paramBundle);
    this.binding = ((AddFriendActivityBinding)DataBindingUtil.setContentView(this, 2130968606));
    setSupportActionBar(this.binding.toolbar);
    setTitle(getString(2131361876));
    setDisplayHomeAsUpEnabled(true);
    initialize();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131886087, paramMenu);
    this.menu = paramMenu;
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      NavUtils.navigateUpFromSameTask(this);
      return true;
      addFriend();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.friends.management.AddFriendActivity");
    super.onResume();
    this.allSubscriptions = new CompositeSubscription();
    this.allSubscriptions.add(this.canSendSubject.startWith(Boolean.valueOf(false)).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(AddFriendActivity..Lambda.1.lambdaFactory$(this)));
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.friends.management.AddFriendActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/AddFriendActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */