package com.blizzard.login.config;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.blizzard.login.region.RegionInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginOverridesConfig
  implements Parcelable
{
  public static final Parcelable.Creator<LoginOverridesConfig> CREATOR = new Parcelable.Creator()
  {
    public LoginOverridesConfig createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LoginOverridesConfig(paramAnonymousParcel);
    }
    
    public LoginOverridesConfig[] newArray(int paramAnonymousInt)
    {
      return new LoginOverridesConfig[paramAnonymousInt];
    }
  };
  private String appName;
  private int defaultRegion;
  private String externalLoginScheme;
  private boolean hideRegionPicker;
  private HashMap<String, Integer> isoRegionMap;
  private String loginUrl;
  private ArrayList<RegionInfo> regionInfoList;
  private int selectedRegion;
  
  protected LoginOverridesConfig(Parcel paramParcel)
  {
    this.appName = paramParcel.readString();
    this.loginUrl = paramParcel.readString();
    this.externalLoginScheme = paramParcel.readString();
    this.hideRegionPicker = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader())).booleanValue();
    this.selectedRegion = paramParcel.readInt();
    this.defaultRegion = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readTypedList(localArrayList, RegionInfo.CREATOR);
    if (!localArrayList.isEmpty()) {
      this.regionInfoList = localArrayList;
    }
    this.isoRegionMap = ((HashMap)paramParcel.readSerializable());
  }
  
  private LoginOverridesConfig(Builder paramBuilder)
  {
    this.externalLoginScheme = paramBuilder.externalLoginScheme;
    this.loginUrl = paramBuilder.loginUrl;
    this.hideRegionPicker = paramBuilder.hideRegionPicker;
    this.selectedRegion = paramBuilder.selectedRegion;
    this.defaultRegion = paramBuilder.defaultRegion;
    this.regionInfoList = paramBuilder.regionInfoList;
    this.isoRegionMap = paramBuilder.isoRegionMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDefaultRegion()
  {
    return this.defaultRegion;
  }
  
  public String getExternalLoginScheme()
  {
    return this.externalLoginScheme;
  }
  
  public Map<String, Integer> getIsoRegionMap()
  {
    return this.isoRegionMap;
  }
  
  public String getLoginUrl()
  {
    return this.loginUrl;
  }
  
  public List<RegionInfo> getRegionInfoList()
  {
    return this.regionInfoList;
  }
  
  public int getSelectedRegion()
  {
    return this.selectedRegion;
  }
  
  public boolean isRegionPickerHidden()
  {
    return this.hideRegionPicker;
  }
  
  public void setLoginUrl(String paramString)
  {
    this.loginUrl = paramString;
  }
  
  public void setSelectedRegion(int paramInt)
  {
    this.selectedRegion = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.loginUrl);
    paramParcel.writeString(this.externalLoginScheme);
    paramParcel.writeValue(Boolean.valueOf(this.hideRegionPicker));
    paramParcel.writeInt(this.selectedRegion);
    paramParcel.writeInt(this.defaultRegion);
    paramParcel.writeTypedList(this.regionInfoList);
    paramParcel.writeSerializable(this.isoRegionMap);
  }
  
  public static class Builder
  {
    private int defaultRegion = -1;
    private String externalLoginScheme = "blizzard-armory";
    private boolean hideRegionPicker = false;
    private HashMap<String, Integer> isoRegionMap;
    private String loginUrl = getDefaultLoginUrl(paramString);
    private ArrayList<RegionInfo> regionInfoList;
    private int selectedRegion = -1;
    
    public Builder(String paramString) {}
    
    private String getDefaultLoginUrl(String paramString)
    {
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("https").authority("login-live-us.web.blizzard.net").appendPath("login").appendQueryParameter("app", paramString);
      return localBuilder.build().toString();
    }
    
    public Builder addIsoRegion(String paramString, int paramInt)
    {
      if (this.isoRegionMap == null) {
        this.isoRegionMap = new HashMap();
      }
      this.isoRegionMap.put(paramString, Integer.valueOf(paramInt));
      return this;
    }
    
    public Builder addRegionInfo(RegionInfo paramRegionInfo)
    {
      if (this.regionInfoList == null) {
        this.regionInfoList = new ArrayList();
      }
      this.regionInfoList.add(paramRegionInfo);
      return this;
    }
    
    public LoginOverridesConfig build()
    {
      return new LoginOverridesConfig(this, null);
    }
    
    public Builder setDefaultRegion(int paramInt)
    {
      this.defaultRegion = paramInt;
      return this;
    }
    
    public Builder setExternalLoginSchemeHeader(String paramString)
    {
      this.externalLoginScheme = paramString;
      return this;
    }
    
    public Builder setHideRegionPicker(boolean paramBoolean)
    {
      this.hideRegionPicker = paramBoolean;
      return this;
    }
    
    public Builder setLoginUrl(String paramString)
    {
      this.loginUrl = paramString;
      return this;
    }
    
    public Builder setSelectedRegion(int paramInt)
    {
      this.selectedRegion = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/config/LoginOverridesConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */