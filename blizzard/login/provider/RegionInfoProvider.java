package com.blizzard.login.provider;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.blizzard.login.R.array;
import com.blizzard.login.config.LoginOverridesConfig;
import com.blizzard.login.exception.IllegalRegionConfigException;
import com.blizzard.login.region.RegionInfo;
import com.blizzard.login.region.RegionInfo.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RegionInfoProvider
{
  private final RegionInfo defaultRegionInfo = initDefaultRegionInfo(paramLoginOverridesConfig);
  private final Map<String, Integer> isoRegionMap = initIsoRegionMap(paramContext, paramLoginOverridesConfig);
  private final List<RegionInfo> regionInfoList = initRegionInfoList(paramContext, paramLoginOverridesConfig);
  private final Map<Integer, RegionInfo> regionInfoMap = initRegionInfoMap();
  private final RegionInfo selectedRegionInfo = initSelectedRegionInfo(paramLoginOverridesConfig);
  
  public RegionInfoProvider(Context paramContext, LoginOverridesConfig paramLoginOverridesConfig) {}
  
  private String[] getArray(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().obtainTypedArray(paramInt);
    String[] arrayOfString = new String[paramContext.length()];
    int i = 0;
    while (i < paramContext.length())
    {
      String str = paramContext.getString(i);
      if (str == null) {
        throw new IllegalRegionConfigException("Malformed string array for resource ID " + paramInt);
      }
      arrayOfString[i] = str;
      i += 1;
    }
    paramContext.recycle();
    return arrayOfString;
  }
  
  private RegionInfo initDefaultRegionInfo(LoginOverridesConfig paramLoginOverridesConfig)
  {
    int j = paramLoginOverridesConfig.getDefaultRegion();
    int i = j;
    if (j == -1) {
      i = 0;
    }
    paramLoginOverridesConfig = getRegionInfo(i);
    if (paramLoginOverridesConfig == null) {
      throw new IllegalRegionConfigException("Default region code (0) has no server URL mapping");
    }
    return paramLoginOverridesConfig;
  }
  
  private Map<String, Integer> initIsoRegionMap(Context paramContext, LoginOverridesConfig paramLoginOverridesConfig)
  {
    paramContext = paramContext.getResources().obtainTypedArray(R.array.iso_regions);
    HashMap localHashMap = new HashMap(paramContext.getIndexCount());
    int i = 0;
    while (i < paramContext.length())
    {
      String str = paramContext.getString(i);
      if (str == null) {
        throw new IllegalRegionConfigException("Malformed local_regions string array resource");
      }
      String[] arrayOfString = str.split("\\W");
      if (arrayOfString.length != 2) {
        throw new IllegalRegionConfigException("Illegal region mapping: '" + str + '\'');
      }
      localHashMap.put(arrayOfString[0], Integer.valueOf(arrayOfString[1]));
      i += 1;
    }
    paramContext.recycle();
    if (paramLoginOverridesConfig.getIsoRegionMap() != null) {
      localHashMap.putAll(paramLoginOverridesConfig.getIsoRegionMap());
    }
    return localHashMap;
  }
  
  private List<RegionInfo> initRegionInfoList(Context paramContext, LoginOverridesConfig paramLoginOverridesConfig)
  {
    Object localObject = getArray(paramContext, R.array.login_bgs_region_codes);
    String[] arrayOfString1 = getArray(paramContext, R.array.login_bgs_region_servers);
    String[] arrayOfString2 = getArray(paramContext, R.array.login_bgs_region_display_names);
    String[] arrayOfString3 = getArray(paramContext, R.array.login_bgs_region_server_subprotocols);
    if ((arrayOfString1.length != localObject.length) || (arrayOfString2.length != localObject.length) || (arrayOfString3.length != localObject.length)) {
      throw new IllegalRegionConfigException("Region array length mismatch");
    }
    paramContext = new ArrayList(localObject.length);
    RegionInfo.Builder localBuilder = new RegionInfo.Builder();
    int i = 0;
    while (i < localObject.length)
    {
      localBuilder.regionCode(Integer.valueOf(localObject[i]).intValue());
      localBuilder.displayName(arrayOfString2[i]);
      localBuilder.serverUrl(arrayOfString1[i]);
      localBuilder.subProtocol(arrayOfString3[i]);
      paramContext.add(localBuilder.build());
      i += 1;
    }
    if (paramLoginOverridesConfig.getRegionInfoList() != null)
    {
      paramLoginOverridesConfig = paramLoginOverridesConfig.getRegionInfoList().iterator();
      if (paramLoginOverridesConfig.hasNext())
      {
        localObject = (RegionInfo)paramLoginOverridesConfig.next();
        i = 0;
        for (;;)
        {
          if (i < paramContext.size())
          {
            if (((RegionInfo)localObject).getRegionCode() == ((RegionInfo)paramContext.get(i)).getRegionCode()) {
              paramContext.set(i, localObject);
            }
          }
          else
          {
            if (i != paramContext.size()) {
              break;
            }
            paramContext.add(localObject);
            break;
          }
          i += 1;
        }
      }
    }
    return paramContext;
  }
  
  private Map<Integer, RegionInfo> initRegionInfoMap()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.regionInfoList.iterator();
    while (localIterator.hasNext())
    {
      RegionInfo localRegionInfo = (RegionInfo)localIterator.next();
      localHashMap.put(Integer.valueOf(localRegionInfo.getRegionCode()), localRegionInfo);
    }
    return localHashMap;
  }
  
  private RegionInfo initSelectedRegionInfo(LoginOverridesConfig paramLoginOverridesConfig)
  {
    RegionInfo localRegionInfo = getRegionInfo(paramLoginOverridesConfig.getSelectedRegion());
    paramLoginOverridesConfig = localRegionInfo;
    if (localRegionInfo == null)
    {
      localRegionInfo = getRegionInfo(Locale.getDefault().getCountry());
      paramLoginOverridesConfig = localRegionInfo;
      if (localRegionInfo == null) {
        paramLoginOverridesConfig = this.defaultRegionInfo;
      }
    }
    return paramLoginOverridesConfig;
  }
  
  public RegionInfo getRegionInfo(int paramInt)
  {
    return (RegionInfo)this.regionInfoMap.get(Integer.valueOf(paramInt));
  }
  
  public RegionInfo getRegionInfo(String paramString)
  {
    paramString = (Integer)this.isoRegionMap.get(paramString);
    if (paramString == null) {
      return this.defaultRegionInfo;
    }
    return getRegionInfo(paramString.intValue());
  }
  
  public List<RegionInfo> getRegionInfoList()
  {
    return this.regionInfoList;
  }
  
  public RegionInfo getSelectedRegionInfo()
  {
    return this.selectedRegionInfo;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/provider/RegionInfoProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */