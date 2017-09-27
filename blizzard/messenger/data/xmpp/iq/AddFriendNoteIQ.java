package com.blizzard.messenger.data.xmpp.iq;

import com.blizzard.messenger.data.utils.StringFormatUtils;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class AddFriendNoteIQ
  extends IQ
{
  private static final String TAG = AddFriendNoteIQ.class.getSimpleName();
  private String jabberId;
  private String note;
  
  public AddFriendNoteIQ(String paramString1, String paramString2)
  {
    super("query", "blz:roster:item:meta");
    this.jabberId = paramString1;
    this.note = paramString2;
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    paramIQChildElementXmlStringBuilder.element("jid", this.jabberId);
    paramIQChildElementXmlStringBuilder.element("note", StringFormatUtils.formatMessageBody(this.note));
    return paramIQChildElementXmlStringBuilder;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/AddFriendNoteIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */