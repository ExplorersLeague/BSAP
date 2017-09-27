package com.blizzard.bgs.client.service.base;

public class AccountEntityId
  extends EntityId
{
  public AccountEntityId()
  {
    super(1);
  }
  
  public AccountEntityId(long paramLong)
  {
    this();
    setAccountId(paramLong);
  }
  
  public long getAccountId()
  {
    return getLowWord();
  }
  
  public void setAccountId(long paramLong)
  {
    setLowWord(paramLong);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/base/AccountEntityId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */