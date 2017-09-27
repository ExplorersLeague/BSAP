package com.blizzard.messenger.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
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
import com.blizzard.messenger.data.model.chat.ChatMessage;
import com.blizzard.messenger.data.model.chat.TextChatMessage;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.Friend;
import com.blizzard.messenger.utils.PresenceUtils;
import com.blizzard.messenger.utils.StringUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

public class ChatListAdapter
  extends RecyclerView.Adapter<ChatListViewHolder>
{
  private static final String TAG = ChatListAdapter.class.getSimpleName();
  private final MostRecentTimeComparator comparator = new MostRecentTimeComparator(null);
  private final Context context;
  private final PublishSubject<String> conversationClickedSubject = PublishSubject.create();
  private final Map<String, Friend> friendsMap = new HashMap();
  private final List<TextChatMessage> lastMessages = new ArrayList();
  private MenuPopupHelper menuHelper;
  private final PublishSubject<ChatOption> onOptionSelectedSubject = PublishSubject.create();
  private final UnseenConversationModel unseenConversationModel;
  
  public ChatListAdapter(@NonNull Context paramContext, @NonNull UnseenConversationModel paramUnseenConversationModel, @NonNull List<TextChatMessage> paramList, @NonNull List<Friend> paramList1)
  {
    this.context = paramContext;
    this.unseenConversationModel = paramUnseenConversationModel;
    if (paramList != null)
    {
      this.lastMessages.addAll(paramList);
      Collections.sort(this.lastMessages, this.comparator);
    }
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    setFriends(paramList1);
  }
  
  private int getConversationIndex(@NonNull String paramString)
  {
    int i = 0;
    Iterator localIterator = this.lastMessages.iterator();
    for (;;)
    {
      if ((!localIterator.hasNext()) || (((TextChatMessage)localIterator.next()).getConversationId().equals(paramString))) {
        return i;
      }
      i += 1;
    }
  }
  
  private void onConversationClicked(String paramString)
  {
    this.conversationClickedSubject.onNext(paramString);
  }
  
  private void onOptionsClicked(ImageButton paramImageButton, String paramString)
  {
    PopupMenu localPopupMenu = new PopupMenu(this.context, paramImageButton);
    localPopupMenu.inflate(2131886082);
    localPopupMenu.setOnMenuItemClickListener(ChatListAdapter..Lambda.1.lambdaFactory$(this, paramString));
    this.menuHelper = new MenuPopupHelper(this.context, (MenuBuilder)localPopupMenu.getMenu(), paramImageButton);
    this.menuHelper.setForceShowIcon(true);
    this.menuHelper.show();
  }
  
  private static final void showUnseenMessageBadge(@NonNull View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      paramView.setVisibility(i);
      return;
    }
  }
  
  public void closePopup()
  {
    if ((this.menuHelper != null) && (this.menuHelper.isShowing())) {
      this.menuHelper.dismiss();
    }
  }
  
  public int getItemCount()
  {
    return this.lastMessages.size();
  }
  
  public void onBindViewHolder(ChatListViewHolder paramChatListViewHolder, int paramInt)
  {
    TextChatMessage localTextChatMessage = (TextChatMessage)this.lastMessages.get(paramInt);
    if (localTextChatMessage == null) {}
    String str3;
    do
    {
      return;
      str3 = localTextChatMessage.getConversationId();
    } while (str3.equals(paramChatListViewHolder.conversationId));
    if (paramChatListViewHolder.badgeSubscription != null)
    {
      paramChatListViewHolder.badgeSubscription.unsubscribe();
      paramChatListViewHolder.badgeSubscription = null;
    }
    Friend localFriend = (Friend)this.friendsMap.get(str3);
    String str2 = "";
    String str1 = "";
    if (localFriend != null)
    {
      paramInt = PresenceUtils.getGameIconResId(localFriend.getGame());
      str1 = StringUtils.getBattleTagName(localFriend.getBattleTag());
      str2 = localFriend.getFullName();
      if (paramInt != 0) {
        Picasso.with(this.context).load(paramInt).into(paramChatListViewHolder.gameIconImageView);
      }
      if (!TextUtils.isEmpty(str1)) {
        paramChatListViewHolder.battletagTextView.setText(str1);
      }
      if (TextUtils.isEmpty(str2)) {
        break label375;
      }
      paramChatListViewHolder.realIdTextView.setText("(" + str2 + ")");
      paramChatListViewHolder.realIdTextView.setVisibility(0);
      label203:
      if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
        paramChatListViewHolder.battletagTextView.setText(this.context.getString(2131362062));
      }
      str1 = StringUtils.getTimeAgo(localTextChatMessage.getTimestamp(), this.context);
      paramChatListViewHolder.timeTextView.setText(str1);
      if (!localTextChatMessage.isMine()) {
        break label387;
      }
      paramChatListViewHolder.messageTextView.setText(this.context.getString(2131362080) + " " + localTextChatMessage.getBody());
    }
    for (;;)
    {
      paramChatListViewHolder.optionsButton.setOnClickListener(ChatListAdapter..Lambda.2.lambdaFactory$(this, paramChatListViewHolder, str3));
      paramChatListViewHolder.itemView.setOnClickListener(ChatListAdapter..Lambda.3.lambdaFactory$(this, str3));
      paramChatListViewHolder.badgeSubscription = this.unseenConversationModel.onConversationUnseen(str3).observeOn(AndroidSchedulers.mainThread()).subscribe(ChatListAdapter..Lambda.4.lambdaFactory$(paramChatListViewHolder), ChatListAdapter..Lambda.5.lambdaFactory$());
      return;
      paramInt = PresenceUtils.getGameIconResId("App");
      break;
      label375:
      paramChatListViewHolder.realIdTextView.setVisibility(8);
      break label203;
      label387:
      paramChatListViewHolder.messageTextView.setText(localTextChatMessage.getBody());
    }
  }
  
  public Observable<String> onConversationClicked()
  {
    return this.conversationClickedSubject;
  }
  
  public ChatListViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ChatListViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968615, null));
  }
  
  public Observable<ChatOption> onOptionSelected()
  {
    return this.onOptionSelectedSubject;
  }
  
  public void removeConversation(String paramString)
  {
    Iterator localIterator = this.lastMessages.iterator();
    while (localIterator.hasNext())
    {
      TextChatMessage localTextChatMessage = (TextChatMessage)localIterator.next();
      if (localTextChatMessage.getConversationId().equals(paramString)) {
        this.lastMessages.remove(localTextChatMessage);
      }
    }
    notifyDataSetChanged();
  }
  
  public void setFriends(@NonNull List<Friend> paramList)
  {
    this.friendsMap.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Friend localFriend = (Friend)paramList.next();
      this.friendsMap.put(localFriend.getId(), localFriend);
    }
    notifyDataSetChanged();
  }
  
  public void updateConversation(TextChatMessage paramTextChatMessage)
  {
    if (paramTextChatMessage != null)
    {
      int i = getConversationIndex(paramTextChatMessage.getConversationId());
      if (i >= this.lastMessages.size()) {
        break label54;
      }
      this.lastMessages.set(i, paramTextChatMessage);
    }
    for (;;)
    {
      Collections.sort(this.lastMessages, this.comparator);
      notifyDataSetChanged();
      return;
      label54:
      this.lastMessages.add(paramTextChatMessage);
    }
  }
  
  class ChatListViewHolder
    extends RecyclerView.ViewHolder
  {
    final RelativeLayout badgeLayout;
    Subscription badgeSubscription;
    final TextView battletagTextView;
    String conversationId;
    final ImageView gameIconImageView;
    final TextView messageTextView;
    final ImageButton optionsButton;
    final TextView realIdTextView;
    final TextView timeTextView;
    
    ChatListViewHolder(View paramView)
    {
      super();
      this.gameIconImageView = ((ImageView)paramView.findViewById(2131820737));
      this.badgeLayout = ((RelativeLayout)paramView.findViewById(2131820738));
      this.battletagTextView = ((TextView)paramView.findViewById(2131820741));
      this.realIdTextView = ((TextView)paramView.findViewById(2131820742));
      this.timeTextView = ((TextView)paramView.findViewById(2131820740));
      this.messageTextView = ((TextView)paramView.findViewById(2131820714));
      this.optionsButton = ((ImageButton)paramView.findViewById(2131820739));
    }
  }
  
  public class ChatOption
  {
    private final String conversationId;
    private final String conversationOption;
    
    ChatOption(String paramString1, String paramString2)
    {
      this.conversationOption = paramString1;
      this.conversationId = paramString2;
    }
    
    public String getConversationId()
    {
      return this.conversationId;
    }
    
    public String getType()
    {
      return this.conversationOption;
    }
  }
  
  private static class MostRecentTimeComparator
    implements Comparator<ChatMessage>
  {
    public int compare(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
    {
      int i = Double.compare(paramChatMessage1.getTimestamp(), paramChatMessage2.getTimestamp());
      if (i != 0) {
        return -i;
      }
      return paramChatMessage1.getMessageId().compareTo(paramChatMessage2.getMessageId());
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/ChatListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */