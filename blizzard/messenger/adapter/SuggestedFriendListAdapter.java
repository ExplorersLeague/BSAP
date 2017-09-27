package com.blizzard.messenger.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.blizzard.messenger.application.MessengerApplication;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriend;
import com.blizzard.messenger.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.subjects.PublishSubject;

public final class SuggestedFriendListAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private static final int EMPTY_VIEW_COUNT = 10;
  private static final int EMPTY_VIEW_TYPE = 45;
  private final PublishSubject<SuggestedFriend> acceptClickedSubject = PublishSubject.create();
  @Inject
  FriendsModel friendsModel;
  private Resources resources;
  private List<SuggestedFriend> suggestedFriends = new ArrayList();
  
  public SuggestedFriendListAdapter(Context paramContext)
  {
    ((MessengerApplication)paramContext.getApplicationContext()).getModelComponent().inject(this);
    this.resources = paramContext.getResources();
  }
  
  public int getItemCount()
  {
    if (this.suggestedFriends.size() > 0) {
      return this.suggestedFriends.size();
    }
    return 10;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.suggestedFriends.size() == 0) {
      return 45;
    }
    return super.getItemViewType(paramInt);
  }
  
  public Observable<SuggestedFriend> onAcceptClicked()
  {
    return this.acceptClickedSubject;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    SuggestedFriend localSuggestedFriend;
    if ((paramViewHolder instanceof FriendRequestViewHolder))
    {
      paramViewHolder = (FriendRequestViewHolder)paramViewHolder;
      localSuggestedFriend = (SuggestedFriend)this.suggestedFriends.get(paramInt);
      Object localObject = localSuggestedFriend.getBattleTag();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramViewHolder.battleTagTextView.setText(StringUtils.getBattleTagName((String)localObject));
      }
      if (TextUtils.isEmpty(localSuggestedFriend.getFullName())) {
        break label217;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label180;
      }
      paramViewHolder.realIdTextView.setText(localSuggestedFriend.getFullName());
      paramViewHolder.realIdTextView.setVisibility(0);
      label89:
      localObject = localSuggestedFriend.getMutualFriends();
      if (localObject == null) {
        break label229;
      }
      paramViewHolder.descriptionTextView.setText(String.format(this.resources.getString(2131361955), new Object[] { Integer.valueOf(((List)localObject).size()) }));
      label136:
      if (this.friendsModel.findFriendById(localSuggestedFriend.getAccountId()) != null) {
        break label241;
      }
      paramViewHolder.acceptButton.setVisibility(0);
    }
    for (;;)
    {
      paramViewHolder.acceptButton.setBackgroundResource(2130837675);
      paramViewHolder.acceptButton.setOnClickListener(SuggestedFriendListAdapter..Lambda.1.lambdaFactory$(this, localSuggestedFriend));
      return;
      label180:
      paramViewHolder.realIdTextView.setText("(" + localSuggestedFriend.getFullName() + ")");
      break;
      label217:
      paramViewHolder.realIdTextView.setVisibility(8);
      break label89;
      label229:
      paramViewHolder.descriptionTextView.setVisibility(8);
      break label136;
      label241:
      paramViewHolder.acceptButton.setVisibility(4);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 45) {
      return new EmptyViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968645, paramViewGroup, false));
    }
    return new FriendRequestViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968644, paramViewGroup, false));
  }
  
  public void setSuggestedFriends(@NonNull List<SuggestedFriend> paramList)
  {
    this.suggestedFriends = paramList;
    notifyDataSetChanged();
  }
  
  private class EmptyViewHolder
    extends RecyclerView.ViewHolder
  {
    EmptyViewHolder(View paramView)
    {
      super();
    }
  }
  
  private class FriendRequestViewHolder
    extends RecyclerView.ViewHolder
  {
    final Button acceptButton;
    final TextView battleTagTextView;
    final TextView descriptionTextView;
    final ImageView gameIconImageView;
    final TextView realIdTextView;
    
    FriendRequestViewHolder(View paramView)
    {
      super();
      this.gameIconImageView = ((ImageView)paramView.findViewById(2131820737));
      this.battleTagTextView = ((TextView)paramView.findViewById(2131820798));
      this.realIdTextView = ((TextView)paramView.findViewById(2131820742));
      this.descriptionTextView = ((TextView)paramView.findViewById(2131820799));
      this.acceptButton = ((Button)paramView.findViewById(2131820800));
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/SuggestedFriendListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */