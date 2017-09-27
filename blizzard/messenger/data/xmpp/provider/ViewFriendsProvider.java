package com.blizzard.messenger.data.xmpp.provider;

import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriend.Builder;
import com.blizzard.messenger.data.xmpp.iq.ViewFriendsIQ;
import com.blizzard.messenger.data.xmpp.iq.ViewFriendsIQ.Builder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ViewFriendsProvider
  extends IQProvider<ViewFriendsIQ>
{
  private static final String TAG_ACCOUNT_ID = "accountId";
  private static final String TAG_BATTLETAG = "battleTag";
  private static final String TAG_FRIEND = "friend";
  private static final String TAG_FRIEND_ACCOUNT_ID = "friendAccountId";
  private static final String TAG_FULL_NAME = "fullName";
  private static final String TAG_QUERY = "query";
  private static final String TAG_RELATION = "relation";
  
  public ViewFriendsIQ parse(XmlPullParser paramXmlPullParser, int paramInt)
    throws XmlPullParserException, IOException, SmackException
  {
    ArrayList localArrayList = new ArrayList();
    SuggestedFriend.Builder localBuilder = new SuggestedFriend.Builder();
    Object localObject = null;
    String str = "";
    paramInt = 0;
    while (paramInt == 0)
    {
      int i = paramXmlPullParser.next();
      if (i == 2)
      {
        if ("friend".equals(paramXmlPullParser.getName())) {
          localBuilder = new SuggestedFriend.Builder();
        }
      }
      else if (i == 3)
      {
        if (("accountId".equals(paramXmlPullParser.getName())) && (localBuilder != null))
        {
          localBuilder.setAccountId(str);
        }
        else if ("friendAccountId".equals(paramXmlPullParser.getName()))
        {
          localObject = str;
        }
        else if (("battleTag".equals(paramXmlPullParser.getName())) && (localBuilder != null))
        {
          localBuilder.setBattleTag(str);
        }
        else if ("friend".equals(paramXmlPullParser.getName()))
        {
          localArrayList.add(localBuilder.build());
          localBuilder = null;
        }
        else if (("fullName".equals(paramXmlPullParser.getName())) && (localBuilder != null))
        {
          localBuilder.setFullName(str);
        }
        else if ("query".equals(paramXmlPullParser.getName()))
        {
          paramInt = 1;
        }
        else if (("relation".equals(paramXmlPullParser.getName())) && (localBuilder != null))
        {
          localBuilder.setRelation(str);
        }
      }
      else if (i == 4) {
        str = paramXmlPullParser.getText();
      }
    }
    paramXmlPullParser = new ViewFriendsIQ.Builder((String)localObject);
    paramXmlPullParser.setFriendsOfFriends(localArrayList);
    return paramXmlPullParser.build();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/provider/ViewFriendsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */