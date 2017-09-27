package com.blizzard.telemetry.sdk.android;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Process;
import android.provider.Settings.Secure;
import com.blizzard.telemetry.sdk.implementation.PlatformBase;
import com.blizzard.telemetry.sdk.interfaces.Platform;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class AndroidPlatform
  extends PlatformBase
  implements Platform
{
  private static final String mavenSdkClassifier = "protoc310";
  private static final String mavenSdkDate = "2017-02-07 21:17";
  private static final String mavenSdkName = "telemetry-sdk-java-android";
  private static final String mavenSdkVersion = "2.0.20";
  private Context context;
  private SharedPreferences prefs;
  
  public AndroidPlatform(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    this.prefs = paramSharedPreferences;
    this.context = paramContext;
  }
  
  public String ReadPersistentStorage(String paramString, boolean paramBoolean)
  {
    return this.prefs.getString(paramString, "");
  }
  
  /* Error */
  public String ReadTextFileAsString(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 49	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 56	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aload_3
    //   17: areturn
    //   18: new 58	java/io/BufferedReader
    //   21: dup
    //   22: new 60	java/io/FileReader
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 61	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   30: invokespecial 64	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore 4
    //   35: new 66	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   42: astore_2
    //   43: ldc 69
    //   45: invokestatic 74	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 5
    //   50: aload 4
    //   52: invokevirtual 78	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 6
    //   57: aload 6
    //   59: ifnull +195 -> 254
    //   62: aload_2
    //   63: aload 6
    //   65: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: aload 5
    //   72: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -26 -> 50
    //   79: astore_2
    //   80: getstatic 86	java/lang/System:err	Ljava/io/PrintStream;
    //   83: new 66	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   90: ldc 88
    //   92: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 90
    //   101: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   108: invokevirtual 101	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   111: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 103
    //   116: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_2
    //   120: invokevirtual 106	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokevirtual 114	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   132: aload 4
    //   134: ifnull -118 -> 16
    //   137: aload 4
    //   139: invokevirtual 117	java/io/BufferedReader:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_2
    //   145: getstatic 86	java/lang/System:err	Ljava/io/PrintStream;
    //   148: new 66	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   155: ldc 88
    //   157: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 119
    //   166: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_2
    //   170: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   173: invokevirtual 101	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   176: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc 103
    //   181: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 106	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokevirtual 114	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   197: aconst_null
    //   198: areturn
    //   199: astore_2
    //   200: getstatic 86	java/lang/System:err	Ljava/io/PrintStream;
    //   203: new 66	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   210: ldc 88
    //   212: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 90
    //   221: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_2
    //   225: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   228: invokevirtual 101	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   231: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc 103
    //   236: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 106	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   243: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokevirtual 114	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   252: aconst_null
    //   253: areturn
    //   254: aload_2
    //   255: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_2
    //   259: aload_2
    //   260: astore_3
    //   261: aload 4
    //   263: ifnull -247 -> 16
    //   266: aload 4
    //   268: invokevirtual 117	java/io/BufferedReader:close	()V
    //   271: aload_2
    //   272: areturn
    //   273: astore_3
    //   274: getstatic 86	java/lang/System:err	Ljava/io/PrintStream;
    //   277: new 66	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   284: ldc 88
    //   286: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_1
    //   290: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc 119
    //   295: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_3
    //   299: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   302: invokevirtual 101	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   305: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 103
    //   310: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_3
    //   314: invokevirtual 106	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   317: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokevirtual 114	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   326: aload_2
    //   327: areturn
    //   328: astore_2
    //   329: aload 4
    //   331: ifnull +8 -> 339
    //   334: aload 4
    //   336: invokevirtual 117	java/io/BufferedReader:close	()V
    //   339: aload_2
    //   340: athrow
    //   341: astore_3
    //   342: getstatic 86	java/lang/System:err	Ljava/io/PrintStream;
    //   345: new 66	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   352: ldc 88
    //   354: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_1
    //   358: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 119
    //   363: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_3
    //   367: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   370: invokevirtual 101	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   373: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 103
    //   378: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_3
    //   382: invokevirtual 106	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokevirtual 114	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   394: goto -55 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	AndroidPlatform
    //   0	397	1	paramString	String
    //   42	28	2	localStringBuilder	StringBuilder
    //   79	41	2	localException1	Exception
    //   144	41	2	localException2	Exception
    //   199	56	2	localException3	Exception
    //   258	69	2	str1	String
    //   328	12	2	localObject1	Object
    //   1	260	3	localObject2	Object
    //   273	41	3	localException4	Exception
    //   341	41	3	localException5	Exception
    //   33	302	4	localBufferedReader	java.io.BufferedReader
    //   48	23	5	str2	String
    //   55	9	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   50	57	79	java/lang/Exception
    //   62	76	79	java/lang/Exception
    //   254	259	79	java/lang/Exception
    //   137	142	144	java/lang/Exception
    //   18	35	199	java/lang/Exception
    //   266	271	273	java/lang/Exception
    //   50	57	328	finally
    //   62	76	328	finally
    //   80	132	328	finally
    //   254	259	328	finally
    //   334	339	341	java/lang/Exception
  }
  
  public void WritePersistentStorage(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.prefs.edit().putString(paramString1, paramString2);
  }
  
  /* Error */
  public void WriteStringAsTextFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 137	java/io/BufferedWriter
    //   8: dup
    //   9: new 139	java/io/FileWriter
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 140	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 143	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   20: astore 4
    //   22: aload 4
    //   24: aload_2
    //   25: invokevirtual 146	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   28: aload 4
    //   30: ifnull +8 -> 38
    //   33: aload 4
    //   35: invokevirtual 147	java/io/BufferedWriter:close	()V
    //   38: return
    //   39: astore_1
    //   40: return
    //   41: astore 4
    //   43: aload 5
    //   45: astore_2
    //   46: aload_2
    //   47: astore_3
    //   48: getstatic 86	java/lang/System:err	Ljava/io/PrintStream;
    //   51: new 66	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   58: ldc -107
    //   60: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 90
    //   69: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   77: invokevirtual 101	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   80: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 103
    //   85: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload 4
    //   90: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 114	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   102: aload_2
    //   103: ifnull -65 -> 38
    //   106: aload_2
    //   107: invokevirtual 147	java/io/BufferedWriter:close	()V
    //   110: return
    //   111: astore_1
    //   112: return
    //   113: astore_1
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 147	java/io/BufferedWriter:close	()V
    //   122: aload_1
    //   123: athrow
    //   124: astore_2
    //   125: goto -3 -> 122
    //   128: astore_1
    //   129: aload 4
    //   131: astore_3
    //   132: goto -18 -> 114
    //   135: astore_3
    //   136: aload 4
    //   138: astore_2
    //   139: aload_3
    //   140: astore 4
    //   142: goto -96 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	AndroidPlatform
    //   0	145	1	paramString1	String
    //   0	145	2	paramString2	String
    //   1	131	3	localObject1	Object
    //   135	5	3	localIOException1	IOException
    //   20	14	4	localBufferedWriter	java.io.BufferedWriter
    //   41	96	4	localIOException2	IOException
    //   140	1	4	localIOException3	IOException
    //   3	41	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	38	39	java/io/IOException
    //   5	22	41	java/io/IOException
    //   106	110	111	java/io/IOException
    //   5	22	113	finally
    //   48	102	113	finally
    //   118	122	124	java/io/IOException
    //   22	28	128	finally
    //   22	28	135	java/io/IOException
  }
  
  public String getCanonicalPath(String paramString)
  {
    try
    {
      String str = new File(paramString).getCanonicalPath();
      return str;
    }
    catch (IOException localIOException) {}
    return paramString;
  }
  
  public String getDataFolder(String paramString, boolean paramBoolean)
  {
    Object localObject = this.context.getFilesDir().getAbsolutePath();
    String str = (String)localObject + "/Battle.net/Telemetry";
    localObject = str;
    if (paramString != null)
    {
      localObject = str;
      if (!paramString.isEmpty()) {
        localObject = str + "/" + paramString;
      }
    }
    return getCanonicalPath((String)localObject);
  }
  
  public String getDeviceId()
  {
    return Settings.Secure.getString(this.context.getContentResolver(), "android_id");
  }
  
  public String getHostName()
  {
    try
    {
      Object localObject = Build.class.getDeclaredMethod("getString", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      localObject = ((Method)localObject).invoke(null, new Object[] { "net.hostname" }).toString();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public int getProcessId()
  {
    return Process.myPid();
  }
  
  public String getProcessName()
  {
    int j = 1;
    int k = Process.myPid();
    for (;;)
    {
      try
      {
        Object localObject = (ActivityManager)this.context.getSystemService("activity");
        if (localObject != null)
        {
          localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
          if (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if ((localRunningAppProcessInfo == null) || (localRunningAppProcessInfo.pid != k)) {
              continue;
            }
            if (localRunningAppProcessInfo.processName == null) {
              break label164;
            }
            i = 1;
            if (localRunningAppProcessInfo.processName.isEmpty()) {
              break label169;
            }
            if ((j & i) != 0) {
              return localRunningAppProcessInfo.processName;
            }
            return String.valueOf(k);
          }
        }
      }
      catch (Exception localException)
      {
        System.err.println("getProcessName: threw exception: " + localException.getClass().getSimpleName() + ": " + localException.getMessage());
      }
      return String.valueOf(k);
      label164:
      int i = 0;
      continue;
      label169:
      j = 0;
    }
  }
  
  public String getProcessVersion()
  {
    return null;
  }
  
  public String platformName()
  {
    return "android";
  }
  
  public String sdkDate()
  {
    if (("2017-02-07 21:17" == null) || ("2017-02-07 21:17".isEmpty())) {
      return "never";
    }
    return "2017-02-07 21:17";
  }
  
  public String sdkName()
  {
    if (("telemetry-sdk-java-android" == null) || ("telemetry-sdk-java-android".isEmpty())) {
      return "android";
    }
    return "telemetry-sdk-java-android";
  }
  
  public String sdkVersion()
  {
    Object localObject2 = "2.0.20";
    if ("2.0.20" != null)
    {
      localObject1 = localObject2;
      if (!"2.0.20".isEmpty()) {}
    }
    else
    {
      Package localPackage = Package.getPackage("com.blizzard.telemetry.sdk");
      localObject1 = localObject2;
      if (localPackage != null) {
        localObject1 = localPackage.getImplementationVersion();
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).isEmpty()) {}
    }
    else
    {
      localObject2 = "2.0";
    }
    Object localObject1 = localObject2;
    if ("protoc310" != null)
    {
      localObject1 = localObject2;
      if (!"protoc310".isEmpty()) {
        localObject1 = (String)localObject2 + "-protoc310";
      }
    }
    return (String)localObject1;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/android/AndroidPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */