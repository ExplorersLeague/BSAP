package com.blizzard.login.provider;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CookieProvider
{
  public static final String[] COOKIE_WHITELIST = { "^web\\.id$", "^bnet\\.extra$", "^auth\\.permit\\.[^.]+$", "^remember\\.auth\\.permit\\.[^.]+$" };
  
  public static void clearCookies(@NonNull Context paramContext, WhiteList[] paramArrayOfWhiteList)
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    paramArrayOfWhiteList = loadCookies(localCookieManager, paramArrayOfWhiteList);
    if (Build.VERSION.SDK_INT >= 22)
    {
      localCookieManager.removeAllCookies(null);
      saveCookies(localCookieManager, paramArrayOfWhiteList);
      localCookieManager.flush();
      return;
    }
    paramContext = CookieSyncManager.createInstance(paramContext);
    paramContext.startSync();
    localCookieManager.removeAllCookie();
    localCookieManager.removeSessionCookie();
    saveCookies(localCookieManager, paramArrayOfWhiteList);
    paramContext.stopSync();
    paramContext.sync();
  }
  
  public static String getCookie(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = CookieManager.getInstance().getCookie(paramString1);
    paramString1 = (String)localObject1;
    int j;
    int i;
    if (localObject2 != null)
    {
      localObject2 = ((String)localObject2).split(";");
      j = localObject2.length;
      i = 0;
    }
    for (;;)
    {
      paramString1 = (String)localObject1;
      if (i < j)
      {
        paramString1 = localObject2[i];
        if (paramString1.contains(paramString2)) {
          paramString1 = paramString1.split("=")[1];
        }
      }
      else
      {
        return paramString1;
      }
      i += 1;
    }
  }
  
  public static List<Pair<String, String>> getCookies(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = CookieManager.getInstance().getCookie(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split(";");
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        paramString = arrayOfString[i].split("=");
        String str;
        if (paramString.length > 0)
        {
          str = paramString[0].trim();
          if (paramString.length <= 1) {
            break label98;
          }
        }
        label98:
        for (paramString = paramString[1].trim();; paramString = null)
        {
          localArrayList.add(Pair.create(str, paramString));
          i += 1;
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private static Map<String, List<String>> loadCookies(CookieManager paramCookieManager, WhiteList[] paramArrayOfWhiteList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayOfWhiteList != null)
    {
      int m = paramArrayOfWhiteList.length;
      int i = 0;
      while (i < m)
      {
        WhiteList localWhiteList = paramArrayOfWhiteList[i];
        Object localObject2 = paramCookieManager.getCookie(localWhiteList.getDomain());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          Object localObject1 = null;
          String[] arrayOfString1 = ((String)localObject2).split(";");
          int n = arrayOfString1.length;
          int j = 0;
          if (j < n)
          {
            Object localObject3 = arrayOfString1[j].split("=");
            localObject2 = localObject1;
            String str;
            String[] arrayOfString2;
            int i1;
            int k;
            if (localObject3.length > 1)
            {
              str = localObject3[0].trim();
              localObject3 = localObject3[1].trim();
              arrayOfString2 = localWhiteList.getWhiteList();
              i1 = arrayOfString2.length;
              k = 0;
            }
            for (;;)
            {
              localObject2 = localObject1;
              if (k < i1)
              {
                if (str.matches(arrayOfString2[k]))
                {
                  localObject2 = localObject1;
                  if (localObject1 == null)
                  {
                    localObject2 = new ArrayList();
                    localHashMap.put(localWhiteList.getDomain(), localObject2);
                  }
                  ((List)localObject2).add(str + "=" + (String)localObject3 + ";");
                }
              }
              else
              {
                j += 1;
                localObject1 = localObject2;
                break;
              }
              k += 1;
            }
          }
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  private static void saveCookies(CookieManager paramCookieManager, Map<String, List<String>> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Iterator localIterator = ((List)localEntry.getValue()).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramCookieManager.setCookie((String)localEntry.getKey(), str);
      }
    }
  }
  
  public static void setAcceptCookies(WebView paramWebView, boolean paramBoolean)
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(paramBoolean);
    if (Build.VERSION.SDK_INT >= 21) {
      localCookieManager.setAcceptThirdPartyCookies(paramWebView, paramBoolean);
    }
  }
  
  public static abstract interface WhiteList
  {
    public abstract String getDomain();
    
    public abstract String[] getWhiteList();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/provider/CookieProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */