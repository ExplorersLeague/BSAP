package com.blizzard.messenger.ui.friends.management;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.FriendRequest;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.utils.StringFormatUtils;
import com.blizzard.messenger.databinding.ReportFriendActivityBinding;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.utils.ColorUtils;
import com.blizzard.messenger.utils.ViewUtils;
import com.google.firebase.perf.metrics.AppStartTrace;
import javax.inject.Inject;
import rx.Completable;

public class ReportUserActivity
  extends BaseActivity
{
  private static final String EXTRA_ACCOUNT_ID = "com.blizzard.messenger.EXTRA_ACCOUNT_ID";
  private static final String EXTRA_DECLINE_REQUEST = "com.blizzard.messenger.EXTRA_DECLINE_REQUEST";
  private static final String EXTRA_DISPLAY_NAME = "com.blizzard.messenger.EXTRA_DISPLAY_NAME";
  private static final String EXTRA_UI_CONTEXT = "com.blizzard.messenger.EXTRA_UI_CONTEXT";
  private String accountId;
  private ReportFriendActivityBinding binding;
  private FriendRequest declineRequest;
  private String displayName;
  @Inject
  FriendsModel friendsModel;
  private Menu menu;
  private String uiContext;
  
  private String getReportType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "com.blizzard.messenger.reporttype.SPAM";
    case 0: 
      return "com.blizzard.messenger.reporttype.SPAM";
    case 1: 
      return "com.blizzard.messenger.reporttype.HARASSMENT";
    }
    return "com.blizzard.messenger.reporttype.INAPPROPRIATE_NAME";
  }
  
  private void highlightReasonSpinner()
  {
    ((TextView)this.binding.reportTypeSpinner.getChildAt(0)).setTextColor(ColorUtils.getTextColorError(this));
    this.binding.reportTypePrompt.setTextColor(ColorUtils.getTextColorError(this));
  }
  
  private void initialize()
  {
    this.binding.reportTitleTextView.setText(String.format(getString(2131362005), new Object[] { this.displayName }));
    this.binding.reasonDescriptionTextView.setText(String.format(getString(2131362011), new Object[] { this.displayName }));
    initializeSpinner();
  }
  
  private void initializeSpinner()
  {
    String[] arrayOfString = getResources().getStringArray(2131755018);
    ArrayAdapter local1 = new ArrayAdapter(this, 17367048, arrayOfString)
    {
      public int getCount()
      {
        return this.val$selectableElements;
      }
    };
    local1.setDropDownViewResource(2130968708);
    this.binding.reportTypeSpinner.setAdapter(local1);
    this.binding.reportTypeSpinner.setSelection(arrayOfString.length - 1);
    this.binding.reportTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (ReportUserActivity.this.isReasonSelected())
        {
          ReportUserActivity.this.unhighlightReasonSpinner();
          ReportUserActivity.this.updateMenuItemColor(true);
        }
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
  }
  
  private boolean isReasonSelected()
  {
    return this.binding.reportTypeSpinner.getSelectedItemPosition() < this.binding.reportTypeSpinner.getCount();
  }
  
  public static Intent newDeclineFriendRequestIntent(Context paramContext, String paramString1, String paramString2, String paramString3, FriendRequest paramFriendRequest)
  {
    paramContext = newIntent(paramContext, paramString1, paramString2, paramString3);
    paramString1 = paramContext.getExtras();
    paramString1.putParcelable("com.blizzard.messenger.EXTRA_DECLINE_REQUEST", paramFriendRequest);
    paramContext.putExtras(paramString1);
    return paramContext;
  }
  
  public static Intent newIntent(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("accountId cannot be empty");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("displayName cannot be empty");
    }
    if (TextUtils.isEmpty(paramString3)) {
      throw new IllegalArgumentException("uiContext cannot be empty");
    }
    paramContext = new Intent(paramContext, ReportUserActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.blizzard.messenger.EXTRA_ACCOUNT_ID", paramString1);
    localBundle.putString("com.blizzard.messenger.EXTRA_DISPLAY_NAME", paramString2);
    localBundle.putString("com.blizzard.messenger.EXTRA_UI_CONTEXT", paramString3);
    paramContext.putExtras(localBundle);
    return paramContext;
  }
  
  private void reportFriend()
  {
    int j = 0;
    if (!isReasonSelected())
    {
      highlightReasonSpinner();
      return;
    }
    int k = this.binding.reportTypeSpinner.getSelectedItemPosition();
    boolean bool = this.binding.blockSwitch.isChecked();
    Object localObject = StringFormatUtils.formatMessageBody(this.binding.reportEditText.getText().toString());
    int i;
    Completable localCompletable;
    if ((!bool) && (this.declineRequest != null))
    {
      i = 1;
      localCompletable = MessengerProvider.getInstance().reportFriend(this.accountId, getReportType(k), (String)localObject, bool);
      if (i == 0) {
        break label170;
      }
    }
    label170:
    for (localObject = MessengerProvider.getInstance().declineFriendRequest(this.declineRequest);; localObject = Completable.complete())
    {
      ViewUtils.reportSuccessOrFailure(this, localCompletable.concatWith((Completable)localObject), getString(2131362012));
      Telemetry.userReported(this.accountId, this.uiContext);
      localObject = new Intent();
      i = j;
      if (bool) {
        i = -1;
      }
      setResult(i, (Intent)localObject);
      finish();
      return;
      i = 0;
      break;
    }
  }
  
  private void unhighlightReasonSpinner()
  {
    ((TextView)this.binding.reportTypeSpinner.getChildAt(0)).setTextColor(ColorUtils.getTextColorPrimary(this));
    this.binding.reportTypePrompt.setTextColor(ColorUtils.getTextColorPrimary(this));
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
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.friends.management.ReportUserActivity");
    super.onCreate(paramBundle);
    ((MessengerApplication)getApplication()).getModelComponent().inject(this);
    this.binding = ((ReportFriendActivityBinding)DataBindingUtil.setContentView(this, 2130968694));
    this.binding.toolbar.setTitle(2131362003);
    setSupportActionBar(this.binding.toolbar);
    setDisplayHomeAsUpEnabled(true);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.accountId = paramBundle.getString("com.blizzard.messenger.EXTRA_ACCOUNT_ID");
      this.displayName = paramBundle.getString("com.blizzard.messenger.EXTRA_DISPLAY_NAME");
      this.uiContext = paramBundle.getString("com.blizzard.messenger.EXTRA_UI_CONTEXT");
      if (paramBundle.containsKey("com.blizzard.messenger.EXTRA_DECLINE_REQUEST")) {
        this.declineRequest = ((FriendRequest)paramBundle.getParcelable("com.blizzard.messenger.EXTRA_DECLINE_REQUEST"));
      }
    }
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
      finish();
      return true;
      reportFriend();
    }
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.friends.management.ReportUserActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.friends.management.ReportUserActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/ReportUserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */