package com.blizzard.telemetry.sdk.interfaces;

import java.util.List;

public abstract interface Platform
{
  public static final boolean isAndroid;
  public static final boolean isMac;
  public static final boolean isNix;
  public static final boolean isPs4;
  public static final boolean isSolaris;
  public static final boolean isWindows;
  public static final boolean isXbox;
  public static final String systemType;
  public static final String systemVersion;
  
  static
  {
    boolean bool2 = true;
    systemType = System.getProperty("os.name");
    systemVersion = System.getProperty("os.version");
    if (systemType.toLowerCase().indexOf("win") >= 0)
    {
      bool1 = true;
      isWindows = bool1;
      if (systemType.toLowerCase().indexOf("mac") < 0) {
        break label189;
      }
      bool1 = true;
      label54:
      isMac = bool1;
      if ((systemType.toLowerCase().indexOf("nix") < 0) && (systemType.toLowerCase().indexOf("nux") < 0) && (systemType.indexOf("aix") <= 0)) {
        break label194;
      }
      bool1 = true;
      label99:
      isNix = bool1;
      if (systemType.toLowerCase().indexOf("ps4") < 0) {
        break label199;
      }
      bool1 = true;
      label119:
      isPs4 = bool1;
      if (systemType.toLowerCase().indexOf("xbox") < 0) {
        break label204;
      }
      bool1 = true;
      label139:
      isXbox = bool1;
      if (systemType.toLowerCase().indexOf("and") < 0) {
        break label209;
      }
      bool1 = true;
      label159:
      isAndroid = bool1;
      if (systemType.toLowerCase().indexOf("sunos") < 0) {
        break label214;
      }
    }
    label189:
    label194:
    label199:
    label204:
    label209:
    label214:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      isSolaris = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label54;
      bool1 = false;
      break label99;
      bool1 = false;
      break label119;
      bool1 = false;
      break label139;
      bool1 = false;
      break label159;
    }
  }
  
  public abstract String ReadPersistentStorage(String paramString);
  
  public abstract String ReadPersistentStorage(String paramString, boolean paramBoolean);
  
  public abstract String[] ReadTextFileAsLines(String paramString);
  
  public abstract String ReadTextFileAsString(String paramString);
  
  public abstract void WriteLinesAsTextFile(String paramString, List<String> paramList);
  
  public abstract void WritePersistentStorage(String paramString1, String paramString2);
  
  public abstract void WritePersistentStorage(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void WriteStringAsTextFile(String paramString1, String paramString2);
  
  public abstract String getCanonicalPath(String paramString);
  
  public abstract String getCanonicalPath(String paramString1, String paramString2);
  
  public abstract String getDataFolder();
  
  public abstract String getDataFolder(String paramString);
  
  public abstract String getDataFolder(String paramString, boolean paramBoolean);
  
  public abstract String getDataFolder(boolean paramBoolean);
  
  public abstract String getDeviceId();
  
  public abstract String getHostName();
  
  public abstract int getProcessId();
  
  public abstract String getProcessName();
  
  public abstract String getProcessVersion();
  
  public abstract String getSystemUserName();
  
  public abstract String platformName();
  
  public abstract String sdkDate();
  
  public abstract String sdkName();
  
  public abstract String sdkVersion();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/interfaces/Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */