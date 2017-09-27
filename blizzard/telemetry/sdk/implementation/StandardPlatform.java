package com.blizzard.telemetry.sdk.implementation;

import com.blizzard.telemetry.sdk.interfaces.Platform;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.UUID;
import java.util.prefs.Preferences;

public class StandardPlatform
  extends PlatformBase
  implements Platform
{
  private static final String mavenSdkClassifier = "protoc310";
  private static final String mavenSdkDate = "2017-02-07 21:16";
  private static final String mavenSdkName = "telemetry-sdk-java";
  private static final String mavenSdkVersion = "2.0.20";
  private static final Preferences prefs = Preferences.userRoot().node("/com/blizzard/telemetry");
  
  public String ReadPersistentStorage(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(getDataFolder(paramBoolean) + File.separator + paramString);
    try
    {
      localObject = ReadTextFileAsString(((File)localObject).getAbsolutePath());
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        System.err.println("warning: ReadPersistentStorage('" + paramString + "'): ReadTextFileAsString threw " + localException.getClass().getName() + ": " + localException.getMessage() + ", using Preferences");
        paramString = prefs.get(paramString, "");
      }
    }
    if (paramString == null) {
      return null;
    }
    return paramString.trim();
  }
  
  /* Error */
  public String ReadTextFileAsString(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 47	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 123	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aload_3
    //   17: areturn
    //   18: new 125	java/io/BufferedReader
    //   21: dup
    //   22: new 127	java/io/FileReader
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 128	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   30: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore 4
    //   35: new 49	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   42: astore_2
    //   43: ldc -123
    //   45: invokestatic 136	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 5
    //   50: aload 4
    //   52: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 6
    //   57: aload 6
    //   59: ifnull +195 -> 254
    //   62: aload_2
    //   63: aload 6
    //   65: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: aload 5
    //   72: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -26 -> 50
    //   79: astore_2
    //   80: getstatic 81	java/lang/System:err	Ljava/io/PrintStream;
    //   83: new 49	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   90: ldc -115
    //   92: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc -113
    //   101: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   108: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   111: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 98
    //   116: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_2
    //   120: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokevirtual 108	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   132: aload 4
    //   134: ifnull -118 -> 16
    //   137: aload 4
    //   139: invokevirtual 146	java/io/BufferedReader:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_2
    //   145: getstatic 81	java/lang/System:err	Ljava/io/PrintStream;
    //   148: new 49	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   155: ldc -115
    //   157: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc -108
    //   166: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_2
    //   170: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   173: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   176: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc 98
    //   181: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokevirtual 108	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   197: aconst_null
    //   198: areturn
    //   199: astore_2
    //   200: getstatic 81	java/lang/System:err	Ljava/io/PrintStream;
    //   203: new 49	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   210: ldc -115
    //   212: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc -113
    //   221: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_2
    //   225: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   228: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   231: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc 98
    //   236: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   243: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokevirtual 108	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   252: aconst_null
    //   253: areturn
    //   254: aload_2
    //   255: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_2
    //   259: aload_2
    //   260: astore_3
    //   261: aload 4
    //   263: ifnull -247 -> 16
    //   266: aload 4
    //   268: invokevirtual 146	java/io/BufferedReader:close	()V
    //   271: aload_2
    //   272: areturn
    //   273: astore_3
    //   274: getstatic 81	java/lang/System:err	Ljava/io/PrintStream;
    //   277: new 49	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   284: ldc -115
    //   286: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_1
    //   290: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc -108
    //   295: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_3
    //   299: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   302: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   305: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 98
    //   310: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_3
    //   314: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   317: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokevirtual 108	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   326: aload_2
    //   327: areturn
    //   328: astore_2
    //   329: aload 4
    //   331: ifnull +8 -> 339
    //   334: aload 4
    //   336: invokevirtual 146	java/io/BufferedReader:close	()V
    //   339: aload_2
    //   340: athrow
    //   341: astore_3
    //   342: getstatic 81	java/lang/System:err	Ljava/io/PrintStream;
    //   345: new 49	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   352: ldc -115
    //   354: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_1
    //   358: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc -108
    //   363: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_3
    //   367: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   370: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   373: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 98
    //   378: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_3
    //   382: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokevirtual 108	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   394: goto -55 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	StandardPlatform
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
    File localFile = new File(getDataFolder(paramBoolean) + File.separator + paramString1);
    if (paramString2 == null) {}
    try
    {
      localFile.delete();
      return;
    }
    catch (Exception localException)
    {
      System.err.println("warning: WritePersistentStorage('" + paramString1 + "',...): WriteStringAsTextFile threw " + localException.getClass().getName() + ": " + localException.getMessage() + "; using Preferences");
      if (paramString2 != null) {
        break label132;
      }
      prefs.remove(paramString1);
      return;
      label132:
      prefs.put(paramString1, paramString2);
    }
    WriteStringAsTextFile(localFile.getAbsolutePath(), paramString2);
    return;
  }
  
  /* Error */
  public void WriteStringAsTextFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 173	java/io/BufferedWriter
    //   8: dup
    //   9: new 175	java/io/FileWriter
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 176	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 179	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   20: astore 4
    //   22: aload 4
    //   24: aload_2
    //   25: invokevirtual 182	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   28: aload 4
    //   30: ifnull +8 -> 38
    //   33: aload 4
    //   35: invokevirtual 183	java/io/BufferedWriter:close	()V
    //   38: return
    //   39: astore_2
    //   40: getstatic 81	java/lang/System:err	Ljava/io/PrintStream;
    //   43: new 49	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   50: ldc -71
    //   52: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc -69
    //   61: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   68: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   71: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 98
    //   76: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_2
    //   80: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   83: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokevirtual 108	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   92: return
    //   93: astore 4
    //   95: aload 5
    //   97: astore_2
    //   98: aload_2
    //   99: astore_3
    //   100: getstatic 81	java/lang/System:err	Ljava/io/PrintStream;
    //   103: new 49	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   110: ldc -71
    //   112: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc -67
    //   121: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 4
    //   126: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   129: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   132: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 98
    //   137: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 4
    //   142: invokevirtual 190	java/io/IOException:getMessage	()Ljava/lang/String;
    //   145: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 108	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   154: aload_2
    //   155: ifnull -117 -> 38
    //   158: aload_2
    //   159: invokevirtual 183	java/io/BufferedWriter:close	()V
    //   162: return
    //   163: astore_2
    //   164: getstatic 81	java/lang/System:err	Ljava/io/PrintStream;
    //   167: new 49	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   174: ldc -71
    //   176: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc -69
    //   185: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_2
    //   189: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   192: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   195: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 98
    //   200: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_2
    //   204: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   207: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokevirtual 108	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   216: return
    //   217: astore_2
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 183	java/io/BufferedWriter:close	()V
    //   226: aload_2
    //   227: athrow
    //   228: astore_3
    //   229: getstatic 81	java/lang/System:err	Ljava/io/PrintStream;
    //   232: new 49	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   239: ldc -71
    //   241: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc -69
    //   250: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_3
    //   254: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   257: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   260: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 98
    //   265: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_3
    //   269: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 108	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   281: goto -55 -> 226
    //   284: astore_2
    //   285: aload 4
    //   287: astore_3
    //   288: goto -70 -> 218
    //   291: astore_3
    //   292: aload 4
    //   294: astore_2
    //   295: aload_3
    //   296: astore 4
    //   298: goto -200 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	StandardPlatform
    //   0	301	1	paramString1	String
    //   0	301	2	paramString2	String
    //   1	222	3	str	String
    //   228	41	3	localException	Exception
    //   287	1	3	localObject1	Object
    //   291	5	3	localIOException1	IOException
    //   20	14	4	localBufferedWriter	java.io.BufferedWriter
    //   93	200	4	localIOException2	IOException
    //   296	1	4	localIOException3	IOException
    //   3	93	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	38	39	java/lang/Exception
    //   5	22	93	java/io/IOException
    //   158	162	163	java/lang/Exception
    //   5	22	217	finally
    //   100	154	217	finally
    //   222	226	228	java/lang/Exception
    //   22	28	284	finally
    //   22	28	291	java/io/IOException
  }
  
  public String getCanonicalPath(String paramString)
  {
    try
    {
      String str = new File(paramString).getAbsolutePath();
      paramString = str;
      return paramString;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        try
        {
          str = new File(paramString).getCanonicalPath();
          return str;
        }
        catch (IOException localIOException)
        {
          System.err.println("warning: getCanonicalPath('" + paramString + "'): threw " + localIOException.getClass().getName() + ": " + localIOException.getMessage());
          return paramString;
        }
        catch (Exception localException2)
        {
          System.err.println("warning: getCanonicalPath('" + paramString + "'): threw " + localException2.getClass().getName() + ": " + localException2.getMessage());
        }
        localSecurityException = localSecurityException;
        System.err.println("warning: getCanonicalPath('" + paramString + "'): threw " + localSecurityException.getClass().getName() + ": " + localSecurityException.getMessage());
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        System.err.println("warning: getCanonicalPath('" + paramString + "'): threw " + localException1.getClass().getName() + ": " + localException1.getMessage());
      }
    }
  }
  
  public String getDataFolder(String paramString, boolean paramBoolean)
  {
    String str2 = File.separator;
    Object localObject = str2 + "tmp";
    if (isWindows) {
      if (paramBoolean) {
        localObject = (String)System.getenv().get("ALLUSERSPROFILE");
      }
    }
    for (;;)
    {
      String str1 = (String)localObject + str2 + "Battle.net" + str2 + "Telemetry";
      localObject = str1;
      if (paramString != null)
      {
        localObject = str1;
        if (!paramString.isEmpty()) {
          localObject = str1 + str2 + paramString;
        }
      }
      return getCanonicalPath((String)localObject);
      localObject = (String)System.getenv().get("APPDATA");
      continue;
      if (isPs4)
      {
        localObject = str2 + "temp0";
      }
      else if (isXbox)
      {
        localObject = "T:";
      }
      else if (isMac)
      {
        str1 = System.getenv("TMPDIR");
        if (str1 != null)
        {
          localObject = str1;
          if (!str1.isEmpty()) {}
        }
        else
        {
          localObject = str2 + "tmp";
        }
      }
      else if (isNix)
      {
        str1 = System.getenv("TMPDIR");
        if (str1 != null)
        {
          localObject = str1;
          if (!str1.isEmpty()) {}
        }
        else
        {
          localObject = str2 + "tmp";
        }
      }
    }
  }
  
  public String getDeviceId()
  {
    String str2 = ReadPersistentStorage("source_id");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.isEmpty()) {}
    }
    else
    {
      str1 = UUID.randomUUID().toString();
      WritePersistentStorage("source_id", str1);
    }
    return str1;
  }
  
  public String getHostName()
  {
    Object localObject = System.getenv();
    if (((Map)localObject).containsKey("COMPUTERNAME")) {
      return (String)((Map)localObject).get("COMPUTERNAME");
    }
    if (((Map)localObject).containsKey("HOSTNAME")) {
      return (String)((Map)localObject).get("HOSTNAME");
    }
    if (((Map)localObject).containsKey("SESSION_MANAGER"))
    {
      localObject = (String)((Map)localObject).get("SESSION_MANAGER");
      if ((localObject != null) && (((String)localObject).contains("/")))
      {
        localObject = ((String)localObject).split("/");
        if (localObject.length > 1)
        {
          localObject = localObject[1];
          if (((String)localObject).contains(":"))
          {
            localObject = ((String)localObject).split(":");
            if (localObject.length > 0)
            {
              localObject = localObject[0];
              if ((localObject != null) && (!((String)localObject).isEmpty())) {
                return (String)localObject;
              }
            }
          }
        }
      }
    }
    try
    {
      localObject = InetAddress.getLocalHost().getHostName();
      return (String)localObject;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      localUnknownHostException.printStackTrace();
    }
    return "";
  }
  
  public int getProcessId()
  {
    return Integer.valueOf(getProcessName().split("@")[0]).intValue();
  }
  
  public String getProcessName()
  {
    return ManagementFactory.getRuntimeMXBean().getName();
  }
  
  public String getProcessVersion()
  {
    return ManagementFactory.getRuntimeMXBean().getVmVersion();
  }
  
  public String platformName()
  {
    return "java";
  }
  
  public String sdkDate()
  {
    if (("2017-02-07 21:16" == null) || ("2017-02-07 21:16".isEmpty())) {
      return "never";
    }
    return "2017-02-07 21:16";
  }
  
  public String sdkName()
  {
    if (("telemetry-sdk-java" == null) || ("telemetry-sdk-java".isEmpty())) {
      return "java";
    }
    return "telemetry-sdk-java";
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/StandardPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */