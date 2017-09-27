package com.blizzard.messenger.data.xmpp.provider;

import com.blizzard.messenger.data.model.friends.suggestions.MutualFriend.Builder;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriend.Builder;
import com.blizzard.messenger.data.xmpp.iq.GetSuggestedFriendsIQ;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SuggestedFriendsPacketProvider
  extends IQProvider<GetSuggestedFriendsIQ>
{
  private static final String TAG_ACCOUNT_ID = "accountId";
  private static final String TAG_BATTLETAG = "battleTag";
  private static final String TAG_FULL_NAME = "fullName";
  private static final String TAG_MUTUAL_FRIEND = "mutualFriend";
  private static final String TAG_QUERY = "query";
  private static final String TAG_SUGGESTION = "suggestion";
  
  public GetSuggestedFriendsIQ parse(XmlPullParser paramXmlPullParser, int paramInt)
    throws XmlPullParserException, IOException, SmackException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    SuggestedFriend.Builder localBuilder1 = new SuggestedFriend.Builder();
    MutualFriend.Builder localBuilder = null;
    String str = "";
    paramInt = 0;
    while (paramInt == 0)
    {
      int i = paramXmlPullParser.next();
      if (i == 2)
      {
        if ("mutualFriend".equals(paramXmlPullParser.getName()))
        {
          localBuilder = new MutualFriend.Builder();
        }
        else if ("suggestion".equals(paramXmlPullParser.getName()))
        {
          localBuilder1 = new SuggestedFriend.Builder();
          localArrayList1 = new ArrayList();
        }
      }
      else if (i == 3)
      {
        if ("accountId".equals(paramXmlPullParser.getName()))
        {
          if (localBuilder != null) {
            localBuilder.setAccountId(str);
          } else {
            localBuilder1.setAccountId(str);
          }
        }
        else if ("battleTag".equals(paramXmlPullParser.getName()))
        {
          if (localBuilder != null) {
            localBuilder.setBattleTag(str);
          } else {
            localBuilder1.setBattleTag(str);
          }
        }
        else if ("fullName".equals(paramXmlPullParser.getName()))
        {
          if (localBuilder != null) {
            localBuilder.setFullName(str);
          } else {
            localBuilder1.setFullName(str);
          }
        }
        else if ("mutualFriend".equals(paramXmlPullParser.getName()))
        {
          localArrayList1.add(localBuilder.build());
          localBuilder = null;
        }
        else if ("suggestion".equals(paramXmlPullParser.getName()))
        {
          localBuilder1.setMutualFriends(localArrayList1);
          localArrayList2.add(localBuilder1.build());
        }
        else if ("query".equals(paramXmlPullParser.getName()))
        {
          paramInt = 1;
        }
      }
      else if (i == 4) {
        str = paramXmlPullParser.getText();
      }
    }
    paramXmlPullParser = new GetSuggestedFriendsIQ();
    paramXmlPullParser.setSuggestedFriends(localArrayList2);
    return paramXmlPullParser;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/provider/SuggestedFriendsPacketProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */