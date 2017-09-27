package com.blizzard.pushlibrary;

import java.util.Locale;

public class PushConfig
{
  String SNSAppName;
  String appAccountId;
  String locale;
  String region;
  String senderId;
  
  public PushConfig()
  {
    this("", "", "", "", "");
  }
  
  public PushConfig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.SNSAppName = paramString1;
    this.senderId = paramString2;
    if (paramString3 != null)
    {
      this.region = paramString3;
      if ((paramString4 != null) && (!paramString4.isEmpty())) {
        break label59;
      }
    }
    label59:
    for (this.locale = Locale.getDefault().toString();; this.locale = paramString4)
    {
      this.appAccountId = paramString5;
      return;
      paramString3 = "";
      break;
    }
  }
  
  public void clearAccount()
  {
    this.appAccountId = null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    label88:
    label112:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool3;
              } while (paramObject == null);
              bool1 = bool3;
            } while (getClass() != paramObject.getClass());
            paramObject = (PushConfig)paramObject;
            if (this.SNSAppName == null) {
              break;
            }
            bool1 = bool3;
          } while (!this.SNSAppName.equals(((PushConfig)paramObject).SNSAppName));
          if (this.senderId == null) {
            break label172;
          }
          bool1 = bool3;
        } while (!this.senderId.equals(((PushConfig)paramObject).senderId));
        if (this.region == null) {
          break label181;
        }
        bool1 = bool3;
      } while (!this.region.equals(((PushConfig)paramObject).region));
      if (this.locale == null) {
        break label190;
      }
      bool1 = bool3;
    } while (!this.locale.equals(((PushConfig)paramObject).locale));
    label136:
    if (this.appAccountId != null)
    {
      bool1 = bool2;
      if (this.appAccountId.equals(((PushConfig)paramObject).appAccountId)) {}
    }
    label159:
    for (boolean bool1 = false;; bool1 = bool2)
    {
      return bool1;
      if (((PushConfig)paramObject).SNSAppName == null) {
        break;
      }
      return false;
      label172:
      if (((PushConfig)paramObject).senderId == null) {
        break label88;
      }
      return false;
      label181:
      if (((PushConfig)paramObject).region == null) {
        break label112;
      }
      return false;
      label190:
      if (((PushConfig)paramObject).locale == null) {
        break label136;
      }
      return false;
      if (((PushConfig)paramObject).appAccountId != null) {
        break label159;
      }
    }
  }
  
  public String getAppAccountId()
  {
    return this.appAccountId;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getRegion()
  {
    return this.region;
  }
  
  public String getSNSAppName()
  {
    return this.SNSAppName;
  }
  
  public String getSenderId()
  {
    return this.senderId;
  }
  
  public int hashCode()
  {
    int n = 0;
    int i;
    int j;
    label33:
    int k;
    if (this.SNSAppName != null)
    {
      i = this.SNSAppName.hashCode();
      if (this.senderId == null) {
        break label109;
      }
      j = this.senderId.hashCode();
      if (this.region == null) {
        break label114;
      }
      k = this.region.hashCode();
      label48:
      if (this.locale == null) {
        break label119;
      }
    }
    label109:
    label114:
    label119:
    for (int m = this.locale.hashCode();; m = 0)
    {
      if (this.appAccountId != null) {
        n = this.appAccountId.hashCode();
      }
      return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label33;
      k = 0;
      break label48;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/PushConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */