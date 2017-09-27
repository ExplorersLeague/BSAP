package com.blizzard.messenger.ui.friends.management;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.databinding.UpdateFriendNoteActivityBinding;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.utils.ColorUtils;
import com.blizzard.messenger.utils.StringUtils;
import com.blizzard.messenger.utils.ViewUtils;
import com.blizzard.messenger.views.dialog.MessengerDialogFragment;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.lang.reflect.Field;
import javax.inject.Inject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class UpdateFriendNoteActivity
  extends BaseActivity
{
  public static final String FRIEND_ID_EXTRA = "com.blizzard.messenger.friend_profile.FRIEND_EXTRA";
  private static final int FRIEND_NOTE_SIZE = 127;
  private CompositeSubscription allSubscriptions;
  private UpdateFriendNoteActivityBinding binding;
  private String friendId;
  @Inject
  FriendsModel friendsModel;
  
  private void hideKeyboard()
  {
    View localView = getCurrentFocus();
    if (localView != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  private void initialize()
  {
    Friend localFriend = this.friendsModel.findFriendById(this.friendId);
    String str;
    if (localFriend != null)
    {
      if (TextUtils.isEmpty(localFriend.getFullName())) {
        break label192;
      }
      str = localFriend.getFullName();
      str = String.format(getString(2131361878), new Object[] { str });
      this.binding.friendNoteTextInputLayout.setHint(str);
      if (!TextUtils.isEmpty(localFriend.getNote())) {
        this.binding.friendNoteEditText.setText(localFriend.getNote());
      }
      if (localFriend.getNote() == null) {
        break label203;
      }
      this.binding.counterTextView.setText(localFriend.getNote().length() + " / " + 127);
    }
    for (;;)
    {
      this.binding.saveTextView.setOnClickListener(UpdateFriendNoteActivity..Lambda.1.lambdaFactory$(this));
      this.binding.deleteNoteTextView.setOnClickListener(UpdateFriendNoteActivity..Lambda.2.lambdaFactory$(this));
      this.binding.friendNoteEditText.setOnEditorActionListener(UpdateFriendNoteActivity..Lambda.3.lambdaFactory$(this));
      this.binding.friendNoteEditText.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          int i = paramAnonymousEditable.length() - 1;
          while (i >= 0)
          {
            if (paramAnonymousEditable.charAt(i) == '\n')
            {
              paramAnonymousEditable.delete(i, i + 1);
              return;
            }
            i -= 1;
          }
          if (paramAnonymousEditable.length() > 127) {
            UpdateFriendNoteActivity.this.showErrorUi();
          }
          for (;;)
          {
            UpdateFriendNoteActivity.this.binding.counterTextView.setText(paramAnonymousEditable.length() + " / " + 127);
            return;
            UpdateFriendNoteActivity.this.resetColors();
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      return;
      label192:
      str = StringUtils.getBattleTagName(localFriend.getBattleTag());
      break;
      label203:
      this.binding.counterTextView.setText(getString(2131362064));
    }
  }
  
  private void resetColors()
  {
    this.binding.counterTextView.setTextColor(ColorUtils.getTextColorPrimaryDark(this));
    this.binding.friendNoteEditText.getBackground().clearColorFilter();
    setInputTextLayoutColor(ColorUtils.getColorAccent(this));
  }
  
  private void setInputTextLayoutColor(@ColorInt int paramInt)
  {
    try
    {
      Field localField = TextInputLayout.class.getDeclaredField("mDefaultTextColor");
      localField.setAccessible(true);
      localField.set(this.binding.friendNoteTextInputLayout, new ColorStateList(new int[][] { { 0 } }, new int[] { paramInt }));
      localField = TextInputLayout.class.getDeclaredField("mFocusedTextColor");
      localField.setAccessible(true);
      localField.set(this.binding.friendNoteTextInputLayout, new ColorStateList(new int[][] { { 0 } }, new int[] { paramInt }));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void showDeleteNoteDialog()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("Title", getString(2131361893));
    ((Bundle)localObject).putString("Message", getString(2131361892));
    ((Bundle)localObject).putString("PositiveButton", getString(2131362079));
    ((Bundle)localObject).putString("NegativeButton", getString(2131361958));
    localObject = MessengerDialogFragment.newInstance((Bundle)localObject);
    if (localObject != null)
    {
      ((MessengerDialogFragment)localObject).onPositiveButtonClicked().observeOn(AndroidSchedulers.mainThread()).subscribe(UpdateFriendNoteActivity..Lambda.4.lambdaFactory$(this));
      ((MessengerDialogFragment)localObject).show(getSupportFragmentManager(), "DeleteNoteFragment");
    }
  }
  
  private void showErrorUi()
  {
    this.binding.counterTextView.setTextColor(ColorUtils.getTextColorError(this));
    this.binding.friendNoteEditText.getBackground().setColorFilter(ColorUtils.getTextColorError(this), PorterDuff.Mode.SRC_IN);
    setInputTextLayoutColor(ColorUtils.getTextColorError(this));
  }
  
  private void updateNote()
  {
    String str = this.binding.friendNoteEditText.getText().toString();
    if (str.length() <= 127)
    {
      ViewUtils.reportError(this, MessengerProvider.getInstance().updateFriendNote(this.friendId, str));
      Telemetry.friendNoteUpdated(this.friendId);
      hideKeyboard();
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.friends.management.UpdateFriendNoteActivity");
    super.onCreate(paramBundle);
    ((MessengerApplication)getApplication()).getModelComponent().inject(this);
    this.binding = ((UpdateFriendNoteActivityBinding)DataBindingUtil.setContentView(this, 2130968712));
    this.binding.toolbar.setTitleTextColor(ColorUtils.getTextColorActionBarTitle(this));
    setSupportActionBar(this.binding.toolbar);
    setTitle(getString(2131361879));
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getWindow().setSoftInputMode(3);
    this.friendId = getIntent().getExtras().getString("com.blizzard.messenger.friend_profile.FRIEND_EXTRA");
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    onBackPressed();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    this.allSubscriptions.unsubscribe();
    this.allSubscriptions = null;
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.friends.management.UpdateFriendNoteActivity");
    super.onResume();
    initialize();
    this.allSubscriptions = new CompositeSubscription();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.friends.management.UpdateFriendNoteActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/UpdateFriendNoteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */