package com.blizzard.pushlibrary;

public class BnetAccount
{
  protected Long accountId;
  protected String accountRegion;
  
  public BnetAccount() {}
  
  public BnetAccount(String paramString, Long paramLong)
  {
    this.accountRegion = paramString;
    setAccountId(paramLong);
  }
  
  public void clear()
  {
    setAccountRegion(null);
    setAccountId(null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (BnetAccount)paramObject;
      if (this.accountRegion != null)
      {
        if (this.accountRegion.equals(((BnetAccount)paramObject).accountRegion)) {}
      }
      else {
        while (((BnetAccount)paramObject).accountRegion != null) {
          return false;
        }
      }
      if (this.accountId == null) {
        break;
      }
    } while (this.accountId.equals(((BnetAccount)paramObject).accountId));
    for (;;)
    {
      return false;
      if (((BnetAccount)paramObject).accountId == null) {
        break;
      }
    }
  }
  
  public Long getAccountId()
  {
    return this.accountId;
  }
  
  public String getAccountRegion()
  {
    return this.accountRegion;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.accountRegion != null) {}
    for (int i = this.accountRegion.hashCode();; i = 0)
    {
      if (this.accountId != null) {
        j = this.accountId.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public boolean isClear()
  {
    return (this.accountId == null) || (this.accountRegion == null) || (this.accountRegion.length() == 0);
  }
  
  public void setAccountId(Long paramLong)
  {
    Long localLong;
    if (paramLong != null)
    {
      localLong = paramLong;
      if (paramLong.longValue() != 0L) {}
    }
    else
    {
      localLong = null;
    }
    this.accountId = localLong;
  }
  
  public void setAccountRegion(String paramString)
  {
    this.accountRegion = paramString;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/BnetAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */