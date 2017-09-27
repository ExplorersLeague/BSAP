package com.blizzard.messenger.model;

public class ExceptionText
{
  private final int messageResId;
  private final int titleResId;
  
  public ExceptionText(int paramInt1, int paramInt2)
  {
    this.titleResId = paramInt1;
    this.messageResId = paramInt2;
  }
  
  public int getMessageResId()
  {
    return this.messageResId;
  }
  
  public int getTitleResId()
  {
    return this.titleResId;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/model/ExceptionText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */