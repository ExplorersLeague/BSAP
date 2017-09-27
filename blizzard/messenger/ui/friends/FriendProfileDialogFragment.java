package com.blizzard.messenger.ui.friends;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.PopupMenu;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.databinding.FriendProfileDialogFragmentBinding;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.ui.chat.ConversationActivity;
import com.blizzard.messenger.ui.friends.management.ReportUserActivity;
import com.blizzard.messenger.ui.friends.management.UpdateFriendNoteActivity;
import com.blizzard.messenger.utils.AnalyticsUtils;
import com.blizzard.messenger.utils.FriendUtils;
import com.blizzard.messenger.utils.PresenceUtils;
import com.blizzard.messenger.utils.StringUtils;
import com.blizzard.messenger.utils.ViewUtils;
import com.blizzard.messenger.views.dialog.MessengerDialogFragment;
import com.blizzard.messenger.views.transformation.RoundedTransformation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.inject.Inject;
import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

public class FriendProfileDialogFragment
  extends DialogFragment
  implements View.OnClickListener
{
  private static final String FRIEND_ID_EXTRA = "com.blizzard.messenger.friend_profile.FRIEND_EXTRA";
  private static final int REPORT_AND_BLOCK_FRIEND = 1;
  private CompositeSubscription allSubscriptions;
  private FriendProfileDialogFragmentBinding binding;
  private boolean favorite;
  private final PublishSubject<Completable> friendBlockSendSubject = PublishSubject.create();
  private String friendId;
  private final PublishSubject<Completable> friendRemoveSendSubject = PublishSubject.create();
  private final PublishSubject<Completable> friendRequestSendSubject = PublishSubject.create();
  private final PublishSubject<Completable> friendUpgradeSendSubject = PublishSubject.create();
  @Inject
  FriendsModel friendsModel;
  private MessengerProvider messengerProvider;
  
  private void addFriend()
  {
    this.friendRequestSendSubject.onNext(this.messengerProvider.addFriend(this.friendId, "BattleTag"));
    this.friendRequestSendSubject.onCompleted();
  }
  
  private void blockFriend()
  {
    this.friendBlockSendSubject.onNext(this.messengerProvider.blockFriend(this.friendId));
    this.friendBlockSendSubject.onCompleted();
    Telemetry.userBlocked(this.friendId, "friend_profile");
    getDialog().dismiss();
  }
  
  private void initialize()
  {
    this.messengerProvider = MessengerProvider.getInstance();
    this.binding.friendFavoriteImageView.setOnClickListener(this);
    this.binding.friendNoteImageView.setOnClickListener(this);
    this.binding.friendOptionsImageView.setOnClickListener(this);
    this.binding.mainActionLinearLayout.setOnClickListener(this);
  }
  
  public static FriendProfileDialogFragment newInstance(@NonNull String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.blizzard.messenger.friend_profile.FRIEND_EXTRA", paramString);
    paramString = new FriendProfileDialogFragment();
    paramString.setArguments(localBundle);
    return paramString;
  }
  
  private void removeFriend()
  {
    this.friendRemoveSendSubject.onNext(this.messengerProvider.removeFriend(this.friendId));
    this.friendRemoveSendSubject.onCompleted();
    Telemetry.friendRemoved(this.friendId);
    getDialog().dismiss();
  }
  
  public static void setForceShowIcon(PopupMenu paramPopupMenu)
  {
    int i = 0;
    try
    {
      Field[] arrayOfField = paramPopupMenu.getClass().getDeclaredFields();
      int j = arrayOfField.length;
      for (;;)
      {
        if (i < j)
        {
          Field localField = arrayOfField[i];
          if ("mPopup".equals(localField.getName()))
          {
            localField.setAccessible(true);
            paramPopupMenu = localField.get(paramPopupMenu);
            Class.forName(paramPopupMenu.getClass().getName()).getMethod("setForceShowIcon", new Class[] { Boolean.TYPE }).invoke(paramPopupMenu, new Object[] { Boolean.valueOf(true) });
          }
        }
        else
        {
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramPopupMenu)
    {
      paramPopupMenu.printStackTrace();
    }
  }
  
  private void showBlockDialog()
  {
    Object localObject1 = this.friendsModel.findFriendById(this.friendId);
    if (localObject1 != null) {
      if (TextUtils.isEmpty(((Friend)localObject1).getFullName())) {
        break label157;
      }
    }
    label157:
    for (localObject1 = ((Friend)localObject1).getFullName();; localObject1 = StringUtils.getBattleTagName(((Friend)localObject1).getBattleTag()))
    {
      Object localObject2 = new Bundle();
      localObject1 = String.format(getString(2131361895), new Object[] { localObject1 });
      ((Bundle)localObject2).putString("PositiveButton", getString(2131361864));
      ((Bundle)localObject2).putString("NegativeButton", getString(2131361886));
      ((Bundle)localObject2).putString("Message", (String)localObject1);
      ((Bundle)localObject2).putString("Title", getString(2131361896));
      localObject1 = MessengerDialogFragment.newInstance((Bundle)localObject2);
      if (localObject1 != null)
      {
        ((MessengerDialogFragment)localObject1).onPositiveButtonClicked().observeOn(AndroidSchedulers.mainThread()).subscribe(FriendProfileDialogFragment..Lambda.5.lambdaFactory$(this));
        localObject2 = getActivity().getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction)localObject2).add((Fragment)localObject1, "BlockFriendFragment");
        ((FragmentTransaction)localObject2).commitAllowingStateLoss();
      }
      return;
    }
  }
  
  private void showFriendsOfFriends()
  {
    String str2 = "";
    Friend localFriend = this.friendsModel.findFriendById(this.friendId);
    String str1;
    if ((localFriend != null) && (!TextUtils.isEmpty(localFriend.getFullName()))) {
      str1 = localFriend.getFullName();
    }
    for (;;)
    {
      startActivity(ViewFriendsActivity.newIntent(getContext(), this.friendId, str1));
      return;
      str1 = str2;
      if (localFriend != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(localFriend.getBattleTag())) {
          str1 = StringUtils.getBattleTagName(localFriend.getBattleTag());
        }
      }
    }
  }
  
  private void showOptionsPopupMenu()
  {
    PopupMenu localPopupMenu = new PopupMenu(new ContextThemeWrapper(getContext(), 2131558666), this.binding.friendOptionsImageView);
    localPopupMenu.setGravity(8388613);
    localPopupMenu.inflate(2131886083);
    Menu localMenu = localPopupMenu.getMenu();
    if (this.binding.realIdTextView.getVisibility() == 8) {
      localMenu.findItem(2131820903).setVisible(true);
    }
    for (;;)
    {
      localPopupMenu.setOnMenuItemClickListener(FriendProfileDialogFragment..Lambda.6.lambdaFactory$(this));
      setForceShowIcon(localPopupMenu);
      localPopupMenu.show();
      return;
      localMenu.findItem(2131820903).setVisible(false);
    }
  }
  
  private void showRemoveFriendDialog(Friend paramFriend)
  {
    if (paramFriend == null)
    {
      ViewUtils.showUnavailableActionMessage(getActivity());
      return;
    }
    if (!TextUtils.isEmpty(paramFriend.getFullName())) {}
    for (paramFriend = paramFriend.getFullName();; paramFriend = StringUtils.getBattleTagName(paramFriend.getBattleTag()))
    {
      Object localObject = new Bundle();
      paramFriend = String.format(getResources().getString(2131362001), new Object[] { paramFriend });
      ((Bundle)localObject).putString("PositiveButton", getString(2131361999));
      ((Bundle)localObject).putString("NegativeButton", getString(2131361886));
      ((Bundle)localObject).putString("Message", paramFriend);
      ((Bundle)localObject).putString("Title", getString(2131362002));
      paramFriend = MessengerDialogFragment.newInstance((Bundle)localObject);
      if (paramFriend == null) {
        break;
      }
      paramFriend.onPositiveButtonClicked().observeOn(AndroidSchedulers.mainThread()).subscribe(FriendProfileDialogFragment..Lambda.4.lambdaFactory$(this));
      localObject = getActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(paramFriend, "RemoveFriendFragment");
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
  }
  
  private void showReportActivity()
  {
    Object localObject = this.friendsModel.findFriendById(this.friendId);
    if (localObject != null) {
      if (TextUtils.isEmpty(((Friend)localObject).getFullName())) {
        break label86;
      }
    }
    label86:
    for (localObject = StringUtils.getBattleTagName(((Friend)localObject).getBattleTag()) + " (" + ((Friend)localObject).getFullName() + ")";; localObject = StringUtils.getBattleTagName(((Friend)localObject).getBattleTag()))
    {
      startActivityForResult(ReportUserActivity.newIntent(getContext(), this.friendId, (String)localObject, "friend_profile"), 1);
      return;
    }
  }
  
  private void startChatWithFriend()
  {
    if (!(getContext() instanceof ConversationActivity)) {
      startActivity(ConversationActivity.newIntent(getActivity(), this.friendId), ActivityOptions.makeSceneTransitionAnimation(getActivity(), new Pair[0]).toBundle());
    }
    getDialog().dismiss();
  }
  
  private void startFriendNoteActivity()
  {
    Intent localIntent = new Intent(getContext(), UpdateFriendNoteActivity.class);
    localIntent.putExtra("com.blizzard.messenger.friend_profile.FRIEND_EXTRA", this.friendId);
    startActivity(localIntent);
    getDialog().dismiss();
  }
  
  private void startMainAction(Friend paramFriend)
  {
    if (!TextUtils.isEmpty(paramFriend.getLastOnline()))
    {
      startChatWithFriend();
      return;
    }
    addFriend();
  }
  
  private void updateDialogUi(@NonNull Friend paramFriend)
  {
    this.binding.battletagTextView.setText(paramFriend.getBattleTag());
    label75:
    int i;
    if (!TextUtils.isEmpty(paramFriend.getFullName()))
    {
      this.binding.realIdTextView.setText(paramFriend.getFullName());
      if ((TextUtils.isEmpty(paramFriend.getRichPresence())) || (paramFriend.getGame().equals("App"))) {
        break label247;
      }
      this.binding.presenceTextView.setText(paramFriend.getRichPresence());
      i = PresenceUtils.getPresenceStatusIconResId(paramFriend.getStatus());
      if (i == 0) {
        break label276;
      }
      this.binding.presenceStatusImageView.setImageResource(i);
      label98:
      i = PresenceUtils.getGameIconResId(paramFriend.getGame());
      if (i != 0) {
        Picasso.with(getContext()).load(i).into(this.binding.presenceGameImageView);
      }
      i = PresenceUtils.getGameBackgroundResId(paramFriend.getGame());
      if (i != 0) {
        Picasso.with(getContext()).load(i).transform(new RoundedTransformation(15, 0, true, false)).into(this.binding.avatarBackgroundImageView);
      }
      String str = paramFriend.getNote();
      if (TextUtils.isEmpty(str)) {
        break label292;
      }
      this.binding.friendNoteTextView.setText(str);
      this.binding.friendNoteLinearLayout.setVisibility(0);
      this.binding.friendNoteImageView.setImageResource(2130837703);
    }
    for (;;)
    {
      updateMainAction(paramFriend);
      return;
      this.binding.realIdTextView.setVisibility(8);
      break;
      label247:
      i = PresenceUtils.getPresenceStatusStringResId(paramFriend.getStatus());
      this.binding.presenceTextView.setText(getResources().getString(i));
      break label75;
      label276:
      this.binding.presenceStatusImageView.setImageResource(2130837712);
      break label98;
      label292:
      this.binding.friendNoteLinearLayout.setVisibility(8);
      this.binding.friendNoteImageView.setImageResource(2130837702);
      i = (int)ViewUtils.convertDpToPixel(10.0F, getContext());
      this.binding.friendNoteImageView.setPadding(i, i, i, i);
    }
  }
  
  private void updateFavoriteUi()
  {
    int i = FriendUtils.getFavoriteIconResId(this.favorite);
    this.binding.friendFavoriteImageView.setImageResource(i);
  }
  
  private void updateFriend(Friend paramFriend)
  {
    if (paramFriend != null)
    {
      this.favorite = paramFriend.isFavorite();
      updateDialogUi(paramFriend);
      updateFavoriteUi();
    }
  }
  
  private void updateMainAction(@NonNull Friend paramFriend)
  {
    if (!TextUtils.isEmpty(paramFriend.getLastOnline()))
    {
      this.binding.mainActionImageView.setImageResource(2130837700);
      DrawableCompat.setTint(this.binding.mainActionImageView.getDrawable(), ContextCompat.getColor(getContext(), 17170443));
      this.binding.mainActionTextView.setText(getString(2131362029));
      return;
    }
    this.binding.mainActionImageView.setImageResource(2130837672);
    this.binding.mainActionTextView.setText(getString(2131361876));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131820785: 
      startMainAction(this.friendsModel.findFriendById(this.friendId));
      return;
    case 2131820788: 
      if (!this.favorite) {}
      for (boolean bool = true;; bool = false)
      {
        this.favorite = bool;
        ViewUtils.reportError(getActivity(), this.messengerProvider.setFavoriteStatus(this.friendId, this.favorite));
        updateFavoriteUi();
        return;
      }
    case 2131820781: 
      startFriendNoteActivity();
      return;
    }
    showOptionsPopupMenu();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ((MessengerApplication)getActivity().getApplication()).getModelComponent().inject(this);
    this.binding = ((FriendProfileDialogFragmentBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968641, paramViewGroup, false));
    paramLayoutInflater = getDialog().getWindow();
    paramLayoutInflater.setBackgroundDrawableResource(17170445);
    paramLayoutInflater.getAttributes().windowAnimations = 2131558740;
    this.friendId = getArguments().getString("com.blizzard.messenger.friend_profile.FRIEND_EXTRA");
    initialize();
    AnalyticsUtils.trackScreenView(((MessengerApplication)getActivity().getApplication()).getDefaultTracker(), getActivity(), getClass().getSimpleName());
    return this.binding.getRoot();
  }
  
  public Single<Completable> onFriendBlockSent()
  {
    return this.friendBlockSendSubject.toSingle();
  }
  
  public Single<Completable> onFriendRemoveSent()
  {
    return this.friendRemoveSendSubject.toSingle();
  }
  
  public Single<Completable> onFriendRequestSent()
  {
    return this.friendRequestSendSubject.toSingle();
  }
  
  public Single<Completable> onFriendUpgradeSent()
  {
    return this.friendUpgradeSendSubject.toSingle();
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
    this.allSubscriptions.add(this.friendsModel.onFriendUpdated().filter(FriendProfileDialogFragment..Lambda.1.lambdaFactory$(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(FriendProfileDialogFragment..Lambda.2.lambdaFactory$(this), FriendProfileDialogFragment..Lambda.3.lambdaFactory$()));
    updateFriend(this.friendsModel.findFriendById(this.friendId));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/FriendProfileDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */