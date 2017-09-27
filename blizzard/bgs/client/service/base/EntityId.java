package com.blizzard.bgs.client.service.base;

import com.blizzard.bgs.client.annotation.Required;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityId
{
  public static final int KIND_ACCOUNT = 1;
  public static final int KIND_CHANNEL_ID = 6;
  public static final int KIND_GAME_ACCOUNT = 2;
  public static final int KIND_INVALID = 0;
  private static final long KIND_MASK = 72057594037927935L;
  private static final int KIND_POSITION = 56;
  public static final int KIND_SERVICE = 5;
  private static Pattern PATTERN = Pattern.compile("(\\d+):(\\d+):(\\d+)");
  @Required
  @Expose
  @SerializedName("high")
  private Long highWord = Long.valueOf(0L);
  @Required
  @Expose
  @SerializedName("low")
  private Long lowWord = Long.valueOf(0L);
  
  public EntityId()
  {
    this(0);
  }
  
  public EntityId(int paramInt)
  {
    setKind(paramInt);
  }
  
  public EntityId(int paramInt, long paramLong1, long paramLong2)
  {
    this(paramInt);
    setHighWord(paramLong1);
    setLowWord(paramLong2);
  }
  
  public static EntityId from(String paramString)
  {
    paramString = PATTERN.matcher(paramString);
    if (paramString.find()) {
      return new EntityId(Integer.valueOf(paramString.group(1)).intValue(), Long.valueOf(paramString.group(2)).longValue(), Long.valueOf(paramString.group(3)).longValue());
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (EntityId)paramObject;
      bool1 = bool2;
    } while (!this.highWord.equals(((EntityId)paramObject).highWord));
    return this.lowWord.equals(((EntityId)paramObject).lowWord);
  }
  
  public long getHighWord()
  {
    return this.highWord.longValue() & 0xFFFFFFFFFFFFFF;
  }
  
  public int getKind()
  {
    return (int)(this.highWord.longValue() >> 56);
  }
  
  public long getLowWord()
  {
    return this.lowWord.longValue();
  }
  
  public int hashCode()
  {
    return this.highWord.hashCode() * 31 + this.lowWord.hashCode();
  }
  
  public boolean isKind(int paramInt)
  {
    return getKind() == paramInt;
  }
  
  public boolean isKind(int... paramVarArgs)
  {
    boolean bool2 = false;
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (isKind(paramVarArgs[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void setHighWord(long paramLong)
  {
    if ((paramLong & 0xFFFFFFFFFFFFFF) != paramLong) {
      throw new IllegalArgumentException("high word value too large");
    }
    this.highWord = Long.valueOf(getKind() << 56 | paramLong & 0xFFFFFFFFFFFFFF);
  }
  
  public void setKind(int paramInt)
  {
    if (paramInt << 56 >> 56 != paramInt) {
      throw new IllegalArgumentException("kind value too large");
    }
    this.highWord = Long.valueOf(paramInt << 56 | getHighWord());
  }
  
  public void setLowWord(long paramLong)
  {
    this.lowWord = Long.valueOf(paramLong);
  }
  
  public String toString()
  {
    return "" + getKind() + ":" + getHighWord() + ":" + getLowWord();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/base/EntityId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */