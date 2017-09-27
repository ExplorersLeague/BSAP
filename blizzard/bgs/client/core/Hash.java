package com.blizzard.bgs.client.core;

public class Hash
{
  private static final int PRIME = 16777619;
  private static final int SEED = -2128831035;
  private int hash;
  
  public Hash(String paramString)
  {
    this.hash = getHash(paramString);
  }
  
  public static int getHash(String paramString)
  {
    int j = -2128831035;
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int i = 0;
    while (i < k)
    {
      j = (j ^ paramString[i]) * 16777619 & 0xFFFFFFFF;
      i += 1;
    }
    return j;
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
      paramObject = (Hash)paramObject;
    } while (this.hash == ((Hash)paramObject).hash);
    return false;
  }
  
  public int get()
  {
    return this.hash;
  }
  
  public int hashCode()
  {
    return this.hash;
  }
  
  public String toString()
  {
    return String.valueOf(this.hash);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/Hash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */