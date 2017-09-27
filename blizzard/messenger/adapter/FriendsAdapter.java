package com.blizzard.messenger.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.data.utils.SharedPrefsUtils;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.utils.PresenceUtils;
import com.blizzard.messenger.utils.StringUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.subjects.PublishSubject;

public class FriendsAdapter
  extends RecyclerView.Adapter<FriendViewHolder>
{
  private final Context context;
  private final PublishSubject<Friend> friendClickedSubject = PublishSubject.create();
  private final PublishSubject<FriendOption> friendOptionClickedSubject = PublishSubject.create();
  private final List<Friend> friends = new ArrayList();
  private MenuPopupHelper menuHelper;
  private final boolean showOverflowMenu;
  
  public FriendsAdapter(@NonNull Context paramContext, boolean paramBoolean)
  {
    this.context = paramContext;
    this.showOverflowMenu = paramBoolean;
  }
  
  private void onFriendClicked(Friend paramFriend)
  {
    this.friendClickedSubject.onNext(paramFriend);
  }
  
  private void onOptionsClicked(ImageButton paramImageButton, Friend paramFriend)
  {
    PopupMenu localPopupMenu = new PopupMenu(this.context, paramImageButton);
    localPopupMenu.inflate(2131886084);
    localPopupMenu.setOnMenuItemClickListener(FriendsAdapter..Lambda.3.lambdaFactory$(this, paramFriend));
    this.menuHelper = new MenuPopupHelper(this.context, (MenuBuilder)localPopupMenu.getMenu(), paramImageButton);
    this.menuHelper.setForceShowIcon(true);
    this.menuHelper.show();
    Telemetry.friendContextMenuInvoked(paramFriend.getId());
  }
  
  public void closePopup()
  {
    if ((this.menuHelper != null) && (this.menuHelper.isShowing())) {
      this.menuHelper.dismiss();
    }
  }
  
  public int getItemCount()
  {
    return this.friends.size();
  }
  
  public long getItemId(int paramInt)
  {
    return Long.valueOf(((Friend)this.friends.get(paramInt)).getId()).longValue();
  }
  
  public void onBindViewHolder(FriendViewHolder paramFriendViewHolder, int paramInt)
  {
    Friend localFriend = (Friend)this.friends.get(paramInt);
    if (SharedPrefsUtils.isSortedShowingBattleTagAndRealId(this.context)) {
      if (!TextUtils.isEmpty(localFriend.getFullName()))
      {
        paramFriendViewHolder.battletagTextView.setText(StringUtils.getBattleTagName(localFriend.getBattleTag()) + " (" + localFriend.getFullName() + ")");
        paramFriendViewHolder.presenceTextView.setText(PresenceUtils.getPresenceUiString(this.context, localFriend));
        paramInt = PresenceUtils.getPresenceStatusIconResId(localFriend.getStatus());
        if (paramInt == 0) {
          break label275;
        }
        paramFriendViewHolder.presenceIconImageView.setImageResource(paramInt);
        label113:
        paramInt = PresenceUtils.getGameIconResId(localFriend.getGame());
        if (paramInt != 0) {
          Picasso.with(this.context).load(paramInt).into(paramFriendViewHolder.gameIconImageView);
        }
        if (!localFriend.isFavorite()) {
          break label288;
        }
        paramFriendViewHolder.favoriteImageView.setVisibility(0);
        label158:
        if (!this.showOverflowMenu) {
          break label300;
        }
        paramFriendViewHolder.optionsButton.setVisibility(0);
        paramFriendViewHolder.optionsButton.setOnClickListener(FriendsAdapter..Lambda.1.lambdaFactory$(this, paramFriendViewHolder, localFriend));
        label186:
        if (TextUtils.isEmpty(localFriend.getNote())) {
          break label312;
        }
        paramFriendViewHolder.friendNoteImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      paramFriendViewHolder.parent.setOnClickListener(FriendsAdapter..Lambda.2.lambdaFactory$(this, localFriend));
      return;
      paramFriendViewHolder.battletagTextView.setText(StringUtils.getBattleTagName(localFriend.getBattleTag()));
      break;
      if (!TextUtils.isEmpty(localFriend.getFullName()))
      {
        paramFriendViewHolder.battletagTextView.setText(localFriend.getFullName());
        break;
      }
      paramFriendViewHolder.battletagTextView.setText(StringUtils.getBattleTagName(localFriend.getBattleTag()));
      break;
      label275:
      paramFriendViewHolder.presenceIconImageView.setImageResource(2130837712);
      break label113;
      label288:
      paramFriendViewHolder.favoriteImageView.setVisibility(8);
      break label158;
      label300:
      paramFriendViewHolder.optionsButton.setVisibility(8);
      break label186;
      label312:
      paramFriendViewHolder.friendNoteImageView.setVisibility(8);
    }
  }
  
  public FriendViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new FriendViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968640, paramViewGroup, false));
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView) {}
  
  public Observable<Friend> onFriendClicked()
  {
    return this.friendClickedSubject;
  }
  
  public Observable<FriendOption> onFriendOptionClicked()
  {
    return this.friendOptionClickedSubject;
  }
  
  public void setFriends(@NonNull List<Friend> paramList)
  {
    this.friends.clear();
    this.friends.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public class FriendOption
  {
    private final Friend friend;
    private final String friendOptionType;
    
    public FriendOption(Friend paramFriend, String paramString)
    {
      this.friend = paramFriend;
      this.friendOptionType = paramString;
    }
    
    public Friend getFriend()
    {
      return this.friend;
    }
    
    public String getType()
    {
      return this.friendOptionType;
    }
  }
  
  class FriendViewHolder
    extends RecyclerView.ViewHolder
  {
    final TextView battletagTextView;
    final ImageView favoriteImageView;
    final ImageView friendNoteImageView;
    final ImageView gameIconImageView;
    final ImageButton optionsButton;
    final RelativeLayout parent;
    final ImageView presenceIconImageView;
    final TextView presenceTextView;
    
    FriendViewHolder(View paramView)
    {
      super();
      this.battletagTextView = ((TextView)paramView.findViewById(2131820741));
      this.parent = ((RelativeLayout)paramView.findViewById(2131820566));
      this.favoriteImageView = ((ImageView)paramView.findViewById(2131820780));
      this.friendNoteImageView = ((ImageView)paramView.findViewById(2131820781));
      this.gameIconImageView = ((ImageView)paramView.findViewById(2131820737));
      this.optionsButton = ((ImageButton)paramView.findViewById(2131820779));
      this.presenceIconImageView = ((ImageView)paramView.findViewById(2131820778));
      this.presenceTextView = ((TextView)paramView.findViewById(2131820782));
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/FriendsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */