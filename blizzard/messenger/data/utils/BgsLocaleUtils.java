package com.blizzard.messenger.data.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BgsLocaleUtils
{
  private static String defaultLocale;
  private static Map<String, CountryCodes> languageMap;
  private static Lock languageMapLock = new ReentrantLock();
  
  private static void buildLocaleTable()
  {
    if (languageMap == null) {
      languageMapLock.lock();
    }
    try
    {
      if (languageMap == null)
      {
        defaultLocale = "enUS";
        languageMap = new HashMap();
        languageMap.put("en", new CountryCodes("US", new String[] { "GB", "SG" }, null));
        languageMap.put("es", new CountryCodes("ES", new String[] { "MX" }, null));
        languageMap.put("ja", new CountryCodes("JP", new String[0], null));
        languageMap.put("de", new CountryCodes("DE", new String[0], null));
        languageMap.put("fr", new CountryCodes("FR", new String[0], null));
        languageMap.put("it", new CountryCodes("IT", new String[0], null));
        languageMap.put("ko", new CountryCodes("KR", new String[0], null));
        languageMap.put("pl", new CountryCodes("PL", new String[0], null));
        languageMap.put("pt", new CountryCodes("BR", new String[] { "PT" }, null));
        languageMap.put("ru", new CountryCodes("RU", new String[0], null));
        languageMap.put("zh", new CountryCodes("CN", new String[] { "TW" }, null));
        languageMap.put("th", new CountryCodes("TH", new String[0], null));
      }
      return;
    }
    finally
    {
      languageMapLock.unlock();
    }
  }
  
  public static String getMappedLocale(Locale paramLocale)
  {
    buildLocaleTable();
    String str = paramLocale.getLanguage();
    paramLocale = paramLocale.getCountry();
    CountryCodes localCountryCodes = (CountryCodes)languageMap.get(str);
    if (localCountryCodes != null) {
      return str + localCountryCodes.getMappedCountryCode(paramLocale);
    }
    return defaultLocale;
  }
  
  private static class CountryCodes
  {
    private final Set<String> countryCodes;
    private final String defaultCountryCode;
    
    private CountryCodes(String paramString, String... paramVarArgs)
    {
      this.defaultCountryCode = paramString;
      this.countryCodes = new HashSet(Arrays.asList(paramVarArgs));
    }
    
    private String getMappedCountryCode(String paramString)
    {
      if (this.countryCodes.contains(paramString)) {
        return paramString;
      }
      return this.defaultCountryCode;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/BgsLocaleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */