package com.blizzard.messenger.data.xmpp.iq;

import android.text.TextUtils;
import android.util.Log;
import com.blizzard.messenger.data.push.PushRegistration;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;

public class PushEnrollmentIQ
  extends IQ
{
  private static final String CHILD_ELEMENT = "query";
  private static final String CHILD_ELEMENT_NAMESPACE = "blz:push:enroll";
  private static final String ELEMENT_APPLICATION_ID = "application";
  private static final String ELEMENT_AUTH_TOKEN = "authToken";
  private static final String ELEMENT_LOCALE = "locale";
  private static final String ELEMENT_NEW_TOKEN = "token";
  private static final String ELEMENT_OLD_TOKEN = "oldToken";
  private static final String ELEMENT_PLATFORM = "platform";
  private static final String TAG = PushEnrollmentIQ.class.getSimpleName();
  private final String applicationId;
  private final String authToken;
  private final String locale;
  private final String newToken;
  private final String oldToken;
  private final String platform;
  
  public PushEnrollmentIQ(PushRegistration paramPushRegistration)
  {
    super("query", "blz:push:enroll");
    Log.d(TAG, paramPushRegistration.toString());
    this.applicationId = paramPushRegistration.getApplicationId();
    this.authToken = paramPushRegistration.getAuthToken();
    this.newToken = paramPushRegistration.getNewToken();
    this.platform = paramPushRegistration.getPlatform();
    this.locale = paramPushRegistration.getLocale();
    if (!TextUtils.isEmpty(paramPushRegistration.getOldToken()))
    {
      this.oldToken = paramPushRegistration.getOldToken();
      return;
    }
    this.oldToken = "";
  }
  
  protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder paramIQChildElementXmlStringBuilder)
  {
    paramIQChildElementXmlStringBuilder.rightAngleBracket();
    paramIQChildElementXmlStringBuilder.element("application", this.applicationId);
    paramIQChildElementXmlStringBuilder.element("authToken", this.authToken);
    paramIQChildElementXmlStringBuilder.element("platform", this.platform);
    paramIQChildElementXmlStringBuilder.element("oldToken", this.oldToken);
    paramIQChildElementXmlStringBuilder.element("token", this.newToken);
    paramIQChildElementXmlStringBuilder.element("locale", this.locale);
    return paramIQChildElementXmlStringBuilder;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/iq/PushEnrollmentIQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */