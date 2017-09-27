package com.blizzard.messenger.adapter;

import android.content.Context;
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
import com.blizzard.messenger.data.model.friends.FriendRequest;
import com.blizzard.messenger.utils.FriendRequestUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.subjects.PublishSubject;

public final class FriendRequestListAdapter
  extends RecyclerView.Adapter<FriendRequestViewHolder>
{
  private final PublishSubject<FriendRequest> acceptClickedSubject = PublishSubject.create();
  private final Context context;
  private final PublishSubject<FriendRequest> declinedClickedSubject = PublishSubject.create();
  private List<FriendRequest> friendRequests = new ArrayList();
  
  public FriendRequestListAdapter(@NonNull Context paramContext, @NonNull List<FriendRequest> paramList)
  {
    this.context = paramContext;
    setFriendRequests(paramList);
  }
  
  private void setupAddFriendRequestView(FriendRequestViewHolder paramFriendRequestViewHolder, FriendRequest paramFriendRequest)
  {
    if (!TextUtils.isEmpty(paramFriendRequest.getFullName())) {}
    for (String str = paramFriendRequest.getBattletag() + " (" + paramFriendRequest.getFullName() + ")";; str = paramFriendRequest.getBattletag())
    {
      paramFriendRequest = FriendRequestUtils.getAssociationText(this.context, paramFriendRequest);
      paramFriendRequestViewHolder.nameTextView.setText(str);
      paramFriendRequestViewHolder.descriptionTextView.setText(paramFriendRequest);
      return;
    }
  }
  
  private void setupUpgradeRequestView(FriendRequestViewHolder paramFriendRequestViewHolder, FriendRequest paramFriendRequest)
  {
    paramFriendRequestViewHolder.nameTextView.setText(paramFriendRequest.getFullName());
    paramFriendRequestViewHolder.descriptionTextView.setText(this.context.getString(2131362070));
  }
  
  public int getItemCount()
  {
    return this.friendRequests.size();
  }
  
  public Observable<FriendRequest> onAcceptClicked()
  {
    return this.acceptClickedSubject;
  }
  
  public void onBindViewHolder(FriendRequestViewHolder paramFriendRequestViewHolder, int paramInt)
  {
    FriendRequest localFriendRequest = (FriendRequest)this.friendRequests.get(paramInt);
    if (localFriendRequest.getRequestType().equals("upgrade")) {
      setupUpgradeRequestView(paramFriendRequestViewHolder, localFriendRequest);
    }
    for (;;)
    {
      paramFriendRequestViewHolder.acceptButton.setOnClickListener(FriendRequestListAdapter..Lambda.1.lambdaFactory$(this, localFriendRequest));
      paramFriendRequestViewHolder.declineButton.setOnClickListener(FriendRequestListAdapter..Lambda.2.lambdaFactory$(this, localFriendRequest));
      return;
      if (localFriendRequest.getRequestType().equals("add")) {
        setupAddFriendRequestView(paramFriendRequestViewHolder, localFriendRequest);
      }
    }
  }
  
  public FriendRequestViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new FriendRequestViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968644, paramViewGroup, false));
  }
  
  public Observable<FriendRequest> onDeclineClicked()
  {
    return this.declinedClickedSubject;
  }
  
  public void setFriendRequests(@NonNull List<FriendRequest> paramList)
  {
    this.friendRequests = paramList;
    notifyDataSetChanged();
  }
  
  class FriendRequestViewHolder
    extends RecyclerView.ViewHolder
  {
    final Button acceptButton;
    final Button declineButton;
    final TextView descriptionTextView;
    final ImageView gameIconImageView;
    final TextView nameTextView;
    
    FriendRequestViewHolder(View paramView)
    {
      super();
      this.gameIconImageView = ((ImageView)paramView.findViewById(2131820737));
      this.nameTextView = ((TextView)paramView.findViewById(2131820798));
      this.descriptionTextView = ((TextView)paramView.findViewById(2131820799));
      this.acceptButton = ((Button)paramView.findViewById(2131820800));
      this.acceptButton.setBackgroundResource(2130837663);
      this.declineButton = ((Button)paramView.findViewById(2131820801));
      this.declineButton.setVisibility(0);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/FriendRequestListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */