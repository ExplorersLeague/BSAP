package com.blizzard.telemetry.sdk.implementation;

import com.blizzard.telemetry.sdk.interfaces.Platform;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public abstract class PlatformBase
  implements Platform
{
  public String ReadPersistentStorage(String paramString)
  {
    return ReadPersistentStorage(paramString, false);
  }
  
  public String[] ReadTextFileAsLines(String paramString)
  {
    paramString = ReadTextFileAsString(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.split(System.getProperty("line.separator"));
  }
  
  public void WriteLinesAsTextFile(String paramString, List<String> paramList)
  {
    String str1 = "";
    String str2 = System.getProperty("line.separator");
    Iterator localIterator = paramList.iterator();
    for (paramList = str1; localIterator.hasNext(); paramList = paramList + str1 + str2) {
      str1 = (String)localIterator.next();
    }
    WriteStringAsTextFile(paramString, paramList);
  }
  
  public void WritePersistentStorage(String paramString1, String paramString2)
  {
    WritePersistentStorage(paramString1, paramString2, false);
  }
  
  public String getCanonicalPath(String paramString1, String paramString2)
  {
    return getCanonicalPath(paramString1 + File.separator + paramString2);
  }
  
  public String getDataFolder()
  {
    return getDataFolder("", false);
  }
  
  public String getDataFolder(String paramString)
  {
    return getDataFolder(paramString, false);
  }
  
  public String getDataFolder(boolean paramBoolean)
  {
    return getDataFolder("", paramBoolean);
  }
  
  public String getSystemUserName()
  {
    return System.getProperty("user.name");
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/PlatformBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */