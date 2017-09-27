package com.blizzard.login.region;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RegionInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RegionInfo> CREATOR = new Parcelable.Creator()
  {
    public RegionInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RegionInfo(paramAnonymousParcel, null);
    }
    
    public RegionInfo[] newArray(int paramAnonymousInt)
    {
      return new RegionInfo[paramAnonymousInt];
    }
  };
  private static final String DELIM = "|";
  private final String displayName;
  private final int regionCode;
  private final String serverUrl;
  private final String subProtocol;
  
  private RegionInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("displayName cannot be null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("serverUrl cannot be null");
    }
    this.regionCode = paramInt;
    this.displayName = paramString1;
    this.serverUrl = paramString2;
    this.subProtocol = paramString3;
  }
  
  private RegionInfo(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
  }
  
  private RegionInfo(Builder paramBuilder)
  {
    this(paramBuilder.regionCode, paramBuilder.displayName, paramBuilder.serverUrl, paramBuilder.subProtocol);
  }
  
  /* Error */
  public static RegionInfo from(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 90
    //   3: invokevirtual 96	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   6: astore_1
    //   7: new 10	com/blizzard/login/region/RegionInfo$Builder
    //   10: dup
    //   11: invokespecial 97	com/blizzard/login/region/RegionInfo$Builder:<init>	()V
    //   14: aload_1
    //   15: iconst_0
    //   16: aaload
    //   17: invokestatic 103	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   20: invokevirtual 106	java/lang/Integer:intValue	()I
    //   23: invokevirtual 109	com/blizzard/login/region/RegionInfo$Builder:regionCode	(I)Lcom/blizzard/login/region/RegionInfo$Builder;
    //   26: aload_1
    //   27: iconst_1
    //   28: aaload
    //   29: invokevirtual 112	com/blizzard/login/region/RegionInfo$Builder:displayName	(Ljava/lang/String;)Lcom/blizzard/login/region/RegionInfo$Builder;
    //   32: aload_1
    //   33: iconst_2
    //   34: aaload
    //   35: invokevirtual 114	com/blizzard/login/region/RegionInfo$Builder:serverUrl	(Ljava/lang/String;)Lcom/blizzard/login/region/RegionInfo$Builder;
    //   38: astore_2
    //   39: aload_1
    //   40: arraylength
    //   41: iconst_4
    //   42: if_icmplt +18 -> 60
    //   45: aload_1
    //   46: iconst_3
    //   47: aaload
    //   48: astore_1
    //   49: aload_2
    //   50: aload_1
    //   51: invokevirtual 116	com/blizzard/login/region/RegionInfo$Builder:subProtocol	(Ljava/lang/String;)Lcom/blizzard/login/region/RegionInfo$Builder;
    //   54: invokevirtual 120	com/blizzard/login/region/RegionInfo$Builder:build	()Lcom/blizzard/login/region/RegionInfo;
    //   57: astore_1
    //   58: aload_1
    //   59: areturn
    //   60: aconst_null
    //   61: astore_1
    //   62: goto -13 -> 49
    //   65: astore_1
    //   66: new 122	com/blizzard/login/exception/RegionInfoFormatException
    //   69: dup
    //   70: new 124	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   77: ldc 127
    //   79: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc -123
    //   88: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: aload_1
    //   95: invokespecial 139	com/blizzard/login/exception/RegionInfoFormatException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramString	String
    //   6	56	1	localObject	Object
    //   65	30	1	localRuntimeException	RuntimeException
    //   38	12	2	localBuilder	Builder
    // Exception table:
    //   from	to	target	type
    //   0	45	65	java/lang/RuntimeException
    //   49	58	65	java/lang/RuntimeException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
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
          do
          {
            do
            {
              return bool1;
              bool1 = bool3;
            } while (paramObject == null);
            bool1 = bool3;
          } while (getClass() != paramObject.getClass());
          paramObject = (RegionInfo)paramObject;
          bool1 = bool3;
        } while (this.regionCode != ((RegionInfo)paramObject).regionCode);
        bool1 = bool3;
      } while (!this.displayName.equals(((RegionInfo)paramObject).displayName));
      bool1 = bool3;
    } while (!this.serverUrl.equals(((RegionInfo)paramObject).serverUrl));
    if (this.subProtocol != null) {
      bool1 = this.subProtocol.equals(((RegionInfo)paramObject).subProtocol);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (((RegionInfo)paramObject).subProtocol != null) {
        bool1 = false;
      }
    }
  }
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public int getRegionCode()
  {
    return this.regionCode;
  }
  
  public String getServerUrl()
  {
    return this.serverUrl;
  }
  
  public String getSubProtocol()
  {
    return this.subProtocol;
  }
  
  public int hashCode()
  {
    int j = this.regionCode;
    int k = this.displayName.hashCode();
    int m = this.serverUrl.hashCode();
    if (this.subProtocol != null) {}
    for (int i = this.subProtocol.hashCode();; i = 0) {
      return ((j * 31 + k) * 31 + m) * 31 + i;
    }
  }
  
  public String toString()
  {
    return "" + this.regionCode + "|" + this.displayName + "|" + this.serverUrl + "|" + this.subProtocol;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.regionCode);
    paramParcel.writeString(this.displayName);
    paramParcel.writeString(this.serverUrl);
    paramParcel.writeString(this.subProtocol);
  }
  
  public static class Builder
  {
    private String displayName;
    private int regionCode;
    private String serverUrl;
    private String subProtocol;
    
    public RegionInfo build()
    {
      return new RegionInfo(this, null);
    }
    
    public Builder displayName(String paramString)
    {
      this.displayName = paramString;
      return this;
    }
    
    public Builder regionCode(int paramInt)
    {
      this.regionCode = paramInt;
      return this;
    }
    
    public Builder serverUrl(String paramString)
    {
      this.serverUrl = paramString;
      return this;
    }
    
    public Builder subProtocol(String paramString)
    {
      this.subProtocol = paramString;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/region/RegionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */