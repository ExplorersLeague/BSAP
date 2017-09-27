package com.blizzard.messenger.views.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog.Builder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.FriendRequest;
import com.blizzard.messenger.data.model.friends.FriendRequest.Builder;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.profile.Profile;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.utils.AnalyticsUtils;
import com.blizzard.messenger.utils.StringUtils;
import javax.inject.Inject;
import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

public class FriendRequestDialogFragment
  extends DialogFragment
  implements View.OnClickListener
{
  private static final String ARG_FRIEND_ID = "com.blizzard.messenger.FRIEND_REQUEST_ID";
  private static final String ARG_FRIEND_REQUEST = "com.blizzard.messenger.FRIEND_REQUEST";
  private static final String ARG_FRIEND_REQUEST_ASSOCIATION = "com.blizzard.messenger.FRIEND_REQUEST_ASSOCIATION";
  private CompositeSubscription allSubscriptions;
  private String association;
  private TextView battletagTextView1;
  private TextView battletagTextView2;
  private String friendId;
  private FriendRequest friendRequest;
  private final PublishSubject<Completable> friendRequestAcceptedSubject = PublishSubject.create();
  private final PublishSubject<Void> friendRequestCancelledSubject = PublishSubject.create();
  private final PublishSubject<Void> friendRequestConfirmedSubject = PublishSubject.create();
  private final PublishSubject<Completable> friendRequestSendSubject = PublishSubject.create();
  @Inject
  FriendsModel friendsModel;
  @Inject
  ProfileModel profileModel;
  private TextView realIdTextView;
  
  private void acceptFriendRequest()
  {
    if (!TextUtils.isEmpty(this.association))
    {
      Telemetry.friendRequestAccepted(this.friendRequest.getAccountId(), this.association);
      getDialog().dismiss();
      FriendRequest localFriendRequest = new FriendRequest.Builder(this.friendRequest).setAssociation(this.association).build();
      this.friendRequestAcceptedSubject.onNext(MessengerProvider.getInstance().acceptFriendRequest(localFriendRequest));
      MessengerProvider.getInstance().clearSuggestedFriends();
      this.friendRequestAcceptedSubject.onCompleted();
    }
  }
  
  private void handleRequest()
  {
    if (!TextUtils.isEmpty(this.friendId)) {
      sendFriendRequest();
    }
    for (;;)
    {
      this.friendRequestConfirmedSubject.onCompleted();
      return;
      acceptFriendRequest();
    }
  }
  
  public static FriendRequestDialogFragment newReceiveInstance(@NonNull FriendRequest paramFriendRequest)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.blizzard.messenger.FRIEND_REQUEST", paramFriendRequest);
    paramFriendRequest = new FriendRequestDialogFragment();
    paramFriendRequest.setArguments(localBundle);
    return paramFriendRequest;
  }
  
  public static FriendRequestDialogFragment newSendInstance(@NonNull String paramString1, @NonNull String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.blizzard.messenger.FRIEND_REQUEST_ID", paramString1);
    localBundle.putString("com.blizzard.messenger.FRIEND_REQUEST_ASSOCIATION", paramString2);
    paramString1 = new FriendRequestDialogFragment();
    paramString1.setArguments(localBundle);
    return paramString1;
  }
  
  private void sendFriendRequest()
  {
    if (!TextUtils.isEmpty(this.association))
    {
      getDialog().dismiss();
      this.friendRequestSendSubject.onNext(MessengerProvider.getInstance().addFriend(this.friendId, this.association));
      this.friendRequestSendSubject.onCompleted();
    }
  }
  
  private void updateProfile(@NonNull Profile paramProfile)
  {
    String str = StringUtils.getBattleTagName(paramProfile.getBattleTag());
    paramProfile = StringUtils.getRealId(paramProfile);
    this.battletagTextView1.setText(str);
    this.battletagTextView2.setText(str);
    this.realIdTextView.setVisibility(0);
    this.realIdTextView.setText(paramProfile);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131820796: 
      getDialog().dismiss();
      return;
    }
    handleRequest();
  }
  
  @NonNull
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    ((MessengerApplication)getActivity().getApplication()).getModelComponent().inject(this);
    trackScreen();
    paramBundle = getArguments();
    this.friendRequest = ((FriendRequest)paramBundle.getParcelable("com.blizzard.messenger.FRIEND_REQUEST"));
    AlertDialog.Builder localBuilder;
    View localView1;
    Object localObject;
    label108:
    View localView2;
    View localView3;
    TextView localTextView2;
    Button localButton1;
    Button localButton2;
    if (this.friendRequest != null)
    {
      this.association = this.friendRequest.getAssociation();
      localBuilder = new AlertDialog.Builder(getActivity(), 2131558626);
      localView1 = getActivity().getLayoutInflater().inflate(2130968642, null);
      localObject = "";
      if (TextUtils.isEmpty(this.friendId)) {
        break label383;
      }
      paramBundle = this.friendId;
      localObject = (TextView)localView1.findViewById(2131820791);
      localView2 = localView1.findViewById(2131820794);
      localView3 = localView1.findViewById(2131820795);
      this.battletagTextView1 = ((TextView)localView2.findViewById(2131820741));
      this.battletagTextView2 = ((TextView)localView3.findViewById(2131820741));
      this.realIdTextView = ((TextView)localView3.findViewById(2131820742));
      TextView localTextView1 = (TextView)localView1.findViewById(2131820792);
      localTextView2 = (TextView)localView1.findViewById(2131820793);
      localButton1 = (Button)localView1.findViewById(2131820796);
      localButton2 = (Button)localView1.findViewById(2131820797);
      if (TextUtils.isEmpty(this.friendId)) {
        break label471;
      }
      ((TextView)localObject).setText(getString(2131362028));
      localTextView2.setText(getString(2131362027));
      localButton2.setText(getString(2131361928));
      label282:
      localTextView1.setText(paramBundle);
      if (!this.association.equals("BattleTag")) {
        break label516;
      }
      localView2.setBackgroundResource(2130837606);
    }
    for (;;)
    {
      localView2.setOnClickListener(FriendRequestDialogFragment..Lambda.1.lambdaFactory$(this, localView2, localView3));
      localView3.setOnClickListener(FriendRequestDialogFragment..Lambda.2.lambdaFactory$(this, localView2, localView3));
      localButton1.setOnClickListener(this);
      localButton2.setOnClickListener(this);
      localBuilder.setView(localView1);
      return localBuilder.create();
      this.friendId = paramBundle.getString("com.blizzard.messenger.FRIEND_REQUEST_ID");
      this.association = FriendRequest.toAssociation(paramBundle.getString("com.blizzard.messenger.FRIEND_REQUEST_ASSOCIATION"));
      break;
      label383:
      paramBundle = (Bundle)localObject;
      if (this.friendRequest == null) {
        break label108;
      }
      if (!TextUtils.isEmpty(this.friendRequest.getBattletag())) {
        localObject = StringUtils.getBattleTagName(this.friendRequest.getBattletag());
      }
      paramBundle = (Bundle)localObject;
      if (TextUtils.isEmpty(this.friendRequest.getFullName())) {
        break label108;
      }
      paramBundle = (String)localObject + " (" + this.friendRequest.getFullName() + ")";
      break label108;
      label471:
      if (this.friendRequest == null) {
        break label282;
      }
      ((TextView)localObject).setText(getString(2131361832));
      localTextView2.setText(getString(2131361831));
      localButton2.setText(getString(2131361925));
      break label282;
      label516:
      if (this.association.equals("Email")) {
        localView3.setBackgroundResource(2130837606);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this.friendRequestCancelledSubject.onCompleted();
  }
  
  public Single<Completable> onFriendRequestAccepted()
  {
    return this.friendRequestAcceptedSubject.toSingle();
  }
  
  public Completable onFriendRequestCancelled()
  {
    return this.friendRequestCancelledSubject.toCompletable();
  }
  
  public Completable onFriendRequestConfirmed()
  {
    return this.friendRequestConfirmedSubject.toCompletable();
  }
  
  public Single<Completable> onFriendRequestSent()
  {
    return this.friendRequestSendSubject.toSingle();
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
    this.allSubscriptions.add(this.profileModel.onProfileUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(FriendRequestDialogFragment..Lambda.3.lambdaFactory$(this)));
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  protected void trackScreen()
  {
    AnalyticsUtils.trackScreenView(((MessengerApplication)getActivity().getApplication()).getDefaultTracker(), getActivity(), getClass().getSimpleName());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/views/dialog/FriendRequestDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */