package com.blizzard.bgs.client.service.base;

public class GameAccountEntityId
  extends EntityId
{
  private static final long REGION_MASK = 4294967295L;
  private static final int REGION_POSITION = 32;
  
  public GameAccountEntityId()
  {
    super(2);
  }
  
  public GameAccountEntityId(int paramInt1, int paramInt2, int paramInt3)
  {
    this();
    setRegion(paramInt1);
    setProgram(paramInt2);
    setAccountId(paramInt3);
  }
  
  public long getAccountId()
  {
    return getLowWord();
  }
  
  public int getProgram()
  {
    return (int)(getHighWord() & 0xFFFFFFFF);
  }
  
  public int getRegion()
  {
    return (int)(getHighWord() >> 32);
  }
  
  public void setAccountId(long paramLong)
  {
    setLowWord(paramLong);
  }
  
  public void setProgram(int paramInt)
  {
    setHighWord(getRegion() << 32 | paramInt);
  }
  
  public void setRegion(int paramInt)
  {
    setHighWord(paramInt << 32 | getProgram());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/base/GameAccountEntityId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */