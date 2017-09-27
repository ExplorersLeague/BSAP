package com.blizzard.login.constants;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.util.Collection;
import java.util.List;

public class Urls
{
  private static final String PATH_SEGMENT_DIALOG = "dialog";
  private static final String PATH_SEGMENT_OAUTH = "oauth";
  private static final String URL_ERROR = "http://something.invalid";
  private static final String URL_HOST_FACEBOOK = "facebook";
  private static final String URL_HOST_LOCALHOST = "localhost";
  private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
  
  public static String[] fromString(String paramString)
  {
    try
    {
      paramString = (String[])gson.fromJson(paramString, String[].class);
      return paramString;
    }
    catch (JsonSyntaxException paramString) {}
    return null;
  }
  
  public static String getErrorUrl()
  {
    return "http://something.invalid";
  }
  
  public static boolean isBlizzardLoginUrl(String paramString)
  {
    paramString = Uri.parse(paramString);
    if (paramString != null) {
      return paramString.getScheme().equals("blizzard-login");
    }
    return false;
  }
  
  public static boolean isErrorUrl(String paramString)
  {
    return paramString.equals("http://something.invalid");
  }
  
  public static boolean isFacebookLoginUrl(String paramString)
  {
    boolean bool2 = false;
    Object localObject = Uri.parse(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = ((Uri)localObject).getHost();
      localObject = ((Uri)localObject).getPathSegments();
      bool1 = bool2;
      if (paramString.contains("facebook"))
      {
        bool1 = bool2;
        if (((List)localObject).contains("dialog"))
        {
          bool1 = bool2;
          if (((List)localObject).contains("oauth")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isLocalHostUrl(String paramString)
  {
    paramString = Uri.parse(paramString);
    if (paramString != null) {
      return paramString.getHost().contains("localhost");
    }
    return false;
  }
  
  public static String toString(Collection<String> paramCollection)
  {
    return gson.toJson(paramCollection);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/constants/Urls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */