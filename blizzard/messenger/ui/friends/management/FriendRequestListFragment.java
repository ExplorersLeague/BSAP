package com.blizzard.messenger.ui.friends.management;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blizzard.messenger.adapter.FriendRequestListAdapter;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.FriendRequest;
import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.databinding.FriendRequestListFragmentBinding;
import com.blizzard.messenger.helper.NotificationHelper;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.friends.DenyRequestBottomSheetFragment;
import com.blizzard.messenger.utils.StringUtils;
import com.blizzard.messenger.utils.ViewUtils;
import com.blizzard.messenger.views.dialog.FriendRequestDialogFragment;
import com.blizzard.messenger.views.dialog.MessengerDialogFragment;
import java.util.List;
import javax.inject.Inject;
import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public final class FriendRequestListFragment
  extends Fragment
{
  private final String TAG = FriendRequestListFragment.class.getSimpleName();
  private CompositeSubscription allSubscriptions;
  private FriendRequestListFragmentBinding binding;
  private FriendRequestListAdapter friendRequestListAdapter;
  @Inject
  FriendRequestModel friendRequestModel;
  
  private void blockFriend(String paramString)
  {
    Completable localCompletable = MessengerProvider.getInstance().blockFriend(paramString);
    ViewUtils.reportSuccessOrFailure(getActivity(), localCompletable, getString(2131361921));
    Telemetry.userBlocked(paramString, "friend_request");
  }
  
  private static FriendRequestListAdapter createAdapter(@NonNull Context paramContext, @NonNull FriendRequestModel paramFriendRequestModel)
  {
    return new FriendRequestListAdapter(paramContext, paramFriendRequestModel.getFriendRequests());
  }
  
  private void declineFriendRequest(FriendRequest paramFriendRequest)
  {
    ViewUtils.reportSuccessOrFailure(getActivity(), MessengerProvider.getInstance().declineFriendRequest(paramFriendRequest), getString(2131362018));
    Telemetry.friendRequestDeclined(paramFriendRequest.getAccountId());
  }
  
  private void handleAcceptClicked(FriendRequest paramFriendRequest)
  {
    Log.w(this.TAG, paramFriendRequest.toString());
    if (paramFriendRequest.getRequestType().equals("upgrade"))
    {
      ViewUtils.reportSuccessOrFailure(getActivity(), MessengerProvider.getInstance().acceptFriendRequest(paramFriendRequest), getString(2131362017));
      Telemetry.friendRequestAccepted(paramFriendRequest.getAccountId(), "Email");
      return;
    }
    if (paramFriendRequest.getAssociation().equals("Email"))
    {
      FriendRequestDialogFragment localFriendRequestDialogFragment = FriendRequestDialogFragment.newReceiveInstance(paramFriendRequest);
      localFriendRequestDialogFragment.onFriendRequestAccepted().subscribe(FriendRequestListFragment..Lambda.7.lambdaFactory$(this, paramFriendRequest));
      localFriendRequestDialogFragment.show(getActivity().getSupportFragmentManager(), "FriendRequestDialogFragment");
      return;
    }
    ViewUtils.reportSuccessOrFailure(getActivity(), MessengerProvider.getInstance().acceptFriendRequest(paramFriendRequest), getString(2131362017));
    Telemetry.friendRequestAccepted(paramFriendRequest.getAccountId(), paramFriendRequest.getRequestType());
  }
  
  private void handleDeclineClicked(FriendRequest paramFriendRequest)
  {
    DenyRequestBottomSheetFragment localDenyRequestBottomSheetFragment = new DenyRequestBottomSheetFragment();
    localDenyRequestBottomSheetFragment.onBlockClicked().subscribeOn(AndroidSchedulers.mainThread()).subscribe(FriendRequestListFragment..Lambda.8.lambdaFactory$(this, paramFriendRequest));
    localDenyRequestBottomSheetFragment.onDenyClicked().subscribeOn(AndroidSchedulers.mainThread()).subscribe(FriendRequestListFragment..Lambda.9.lambdaFactory$(this, paramFriendRequest));
    localDenyRequestBottomSheetFragment.onReportClicked().subscribeOn(AndroidSchedulers.mainThread()).subscribe(FriendRequestListFragment..Lambda.10.lambdaFactory$(this, paramFriendRequest));
    localDenyRequestBottomSheetFragment.show(getActivity().getSupportFragmentManager(), localDenyRequestBottomSheetFragment.getTag());
  }
  
  public static FriendRequestListFragment newInstance()
  {
    return new FriendRequestListFragment();
  }
  
  private static void setupRecyclerView(@NonNull Context paramContext, @NonNull FriendRequestListAdapter paramFriendRequestListAdapter, @NonNull RecyclerView paramRecyclerView)
  {
    Object localObject = new LinearLayoutManager(paramContext);
    ((LinearLayoutManager)localObject).setOrientation(1);
    paramRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    paramRecyclerView.setHasFixedSize(true);
    localObject = new DividerItemDecoration(paramRecyclerView.getContext(), ((LinearLayoutManager)localObject).getOrientation());
    ((DividerItemDecoration)localObject).setDrawable(ContextCompat.getDrawable(paramContext, 2130837739));
    paramRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    paramRecyclerView.setAdapter(paramFriendRequestListAdapter);
  }
  
  private void showBlockDialog(FriendRequest paramFriendRequest)
  {
    if (paramFriendRequest != null) {
      if (TextUtils.isEmpty(paramFriendRequest.getFullName())) {
        break label150;
      }
    }
    label150:
    for (Object localObject = paramFriendRequest.getFullName();; localObject = StringUtils.getBattleTagName(paramFriendRequest.getBattletag()))
    {
      Bundle localBundle = new Bundle();
      localObject = String.format(getString(2131361895), new Object[] { localObject });
      localBundle.putString("PositiveButton", getString(2131361864));
      localBundle.putString("NegativeButton", getString(2131361886));
      localBundle.putString("Message", (String)localObject);
      localBundle.putString("Title", getString(2131361896));
      localObject = MessengerDialogFragment.newInstance(localBundle);
      if (localObject != null)
      {
        ((MessengerDialogFragment)localObject).onPositiveButtonClicked().observeOn(AndroidSchedulers.mainThread()).subscribe(FriendRequestListFragment..Lambda.11.lambdaFactory$(this, paramFriendRequest));
        paramFriendRequest = getActivity().getSupportFragmentManager().beginTransaction();
        paramFriendRequest.add((Fragment)localObject, "BlockFriendFragment");
        paramFriendRequest.commitAllowingStateLoss();
      }
      return;
    }
  }
  
  private void showReportScreen(FriendRequest paramFriendRequest)
  {
    if (!TextUtils.isEmpty(paramFriendRequest.getFullName())) {}
    for (String str = StringUtils.getBattleTagName(paramFriendRequest.getBattletag()) + " (" + paramFriendRequest.getFullName() + ")";; str = StringUtils.getBattleTagName(paramFriendRequest.getBattletag()))
    {
      startActivity(ReportUserActivity.newDeclineFriendRequestIntent(getActivity(), paramFriendRequest.getAccountId(), str, "friend_request", paramFriendRequest));
      return;
    }
  }
  
  private void updateFriendRequests(@NonNull List<FriendRequest> paramList)
  {
    this.friendRequestListAdapter.setFriendRequests(paramList);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((MessengerApplication)getActivity().getApplicationContext()).getModelComponent().inject(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.binding = ((FriendRequestListFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968646, paramViewGroup, false));
    this.friendRequestListAdapter = createAdapter(getActivity(), this.friendRequestModel);
    setupRecyclerView(getActivity(), this.friendRequestListAdapter, this.binding.recyclerView);
    this.friendRequestListAdapter.onAcceptClicked().subscribeOn(AndroidSchedulers.mainThread()).subscribe(FriendRequestListFragment..Lambda.1.lambdaFactory$(this), FriendRequestListFragment..Lambda.2.lambdaFactory$());
    this.friendRequestListAdapter.onDeclineClicked().subscribeOn(AndroidSchedulers.mainThread()).subscribe(FriendRequestListFragment..Lambda.3.lambdaFactory$(this), FriendRequestListFragment..Lambda.4.lambdaFactory$());
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
    new NotificationHelper(getContext()).dismissFriendRequestNotifications();
    this.allSubscriptions = new CompositeSubscription();
    this.allSubscriptions.add(this.friendRequestModel.onFriendRequestsUpdated().observeOn(AndroidSchedulers.mainThread()).subscribe(FriendRequestListFragment..Lambda.5.lambdaFactory$(this), FriendRequestListFragment..Lambda.6.lambdaFactory$()));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/management/FriendRequestListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */