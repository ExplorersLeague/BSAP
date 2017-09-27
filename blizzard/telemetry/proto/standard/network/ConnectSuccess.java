package com.blizzard.telemetry.proto.standard.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;

public final class ConnectSuccess
  extends GeneratedMessageLite<ConnectSuccess, Builder>
  implements ConnectSuccessOrBuilder
{
  public static final int ADDRESS4_FIELD_NUMBER = 2;
  public static final int ADDRESS6_FIELD_NUMBER = 5;
  private static final ConnectSuccess DEFAULT_INSTANCE = new ConnectSuccess();
  public static final int HOST_FIELD_NUMBER = 102;
  public static final int LATENCY_MS_FIELD_NUMBER = 4;
  public static final int NAME_FIELD_NUMBER = 1;
  private static volatile Parser<ConnectSuccess> PARSER;
  public static final int PORT_FIELD_NUMBER = 3;
  private String address4_ = "";
  private String address6_ = "";
  private int bitField0_;
  private String host_ = "";
  private int latencyMs_;
  private String name_ = "";
  private int port_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAddress4()
  {
    this.bitField0_ &= 0xFFFFFFFD;
    this.address4_ = getDefaultInstance().getAddress4();
  }
  
  private void clearAddress6()
  {
    this.bitField0_ &= 0xFFFFFFFB;
    this.address6_ = getDefaultInstance().getAddress6();
  }
  
  private void clearHost()
  {
    this.bitField0_ &= 0xFFFFFFF7;
    this.host_ = getDefaultInstance().getHost();
  }
  
  private void clearLatencyMs()
  {
    this.bitField0_ &= 0xFFFFFFDF;
    this.latencyMs_ = 0;
  }
  
  private void clearName()
  {
    this.bitField0_ &= 0xFFFFFFFE;
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearPort()
  {
    this.bitField0_ &= 0xFFFFFFEF;
    this.port_ = 0;
  }
  
  public static ConnectSuccess getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ConnectSuccess paramConnectSuccess)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramConnectSuccess);
  }
  
  public static ConnectSuccess parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (ConnectSuccess)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ConnectSuccess parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (ConnectSuccess)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ConnectSuccess parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (ConnectSuccess)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ConnectSuccess parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (ConnectSuccess)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ConnectSuccess parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (ConnectSuccess)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ConnectSuccess parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (ConnectSuccess)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ConnectSuccess parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (ConnectSuccess)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ConnectSuccess parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (ConnectSuccess)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ConnectSuccess parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (ConnectSuccess)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static ConnectSuccess parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (ConnectSuccess)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<ConnectSuccess> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAddress4(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x2;
    this.address4_ = paramString;
  }
  
  private void setAddress4Bytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x2;
    this.address4_ = paramByteString.toStringUtf8();
  }
  
  private void setAddress6(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x4;
    this.address6_ = paramString;
  }
  
  private void setAddress6Bytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x4;
    this.address6_ = paramByteString.toStringUtf8();
  }
  
  private void setHost(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x8;
    this.host_ = paramString;
  }
  
  private void setHostBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x8;
    this.host_ = paramByteString.toStringUtf8();
  }
  
  private void setLatencyMs(int paramInt)
  {
    this.bitField0_ |= 0x20;
    this.latencyMs_ = paramInt;
  }
  
  private void setName(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x1;
    this.name_ = paramString;
  }
  
  private void setNameBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x1;
    this.name_ = paramByteString.toStringUtf8();
  }
  
  private void setPort(int paramInt)
  {
    this.bitField0_ |= 0x10;
    this.port_ = paramInt;
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 230	com/blizzard/telemetry/proto/standard/network/ConnectSuccess$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 236	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+271->279, 7:+558->566, 8:+562->570
    //   56: new 238	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 239	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/blizzard/telemetry/proto/standard/network/ConnectSuccess
    //   67: dup
    //   68: invokespecial 43	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 45	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/ConnectSuccess;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/blizzard/telemetry/proto/standard/network/ConnectSuccess$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 242	com/blizzard/telemetry/proto/standard/network/ConnectSuccess$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/network/ConnectSuccess$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 244	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/blizzard/telemetry/proto/standard/network/ConnectSuccess
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 248	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasName	()Z
    //   105: aload_0
    //   106: getfield 54	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:name_	Ljava/lang/String;
    //   109: aload_3
    //   110: invokevirtual 248	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasName	()Z
    //   113: aload_3
    //   114: getfield 54	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:name_	Ljava/lang/String;
    //   117: invokeinterface 252 5 0
    //   122: putfield 54	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:name_	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 255	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasAddress4	()Z
    //   131: aload_0
    //   132: getfield 56	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:address4_	Ljava/lang/String;
    //   135: aload_3
    //   136: invokevirtual 255	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasAddress4	()Z
    //   139: aload_3
    //   140: getfield 56	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:address4_	Ljava/lang/String;
    //   143: invokeinterface 252 5 0
    //   148: putfield 56	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:address4_	Ljava/lang/String;
    //   151: aload_0
    //   152: aload_2
    //   153: aload_0
    //   154: invokevirtual 258	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasAddress6	()Z
    //   157: aload_0
    //   158: getfield 58	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:address6_	Ljava/lang/String;
    //   161: aload_3
    //   162: invokevirtual 258	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasAddress6	()Z
    //   165: aload_3
    //   166: getfield 58	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:address6_	Ljava/lang/String;
    //   169: invokeinterface 252 5 0
    //   174: putfield 58	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:address6_	Ljava/lang/String;
    //   177: aload_0
    //   178: aload_2
    //   179: aload_0
    //   180: invokevirtual 261	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasHost	()Z
    //   183: aload_0
    //   184: getfield 60	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:host_	Ljava/lang/String;
    //   187: aload_3
    //   188: invokevirtual 261	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasHost	()Z
    //   191: aload_3
    //   192: getfield 60	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:host_	Ljava/lang/String;
    //   195: invokeinterface 252 5 0
    //   200: putfield 60	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:host_	Ljava/lang/String;
    //   203: aload_0
    //   204: aload_2
    //   205: aload_0
    //   206: invokevirtual 264	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasPort	()Z
    //   209: aload_0
    //   210: getfield 155	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:port_	I
    //   213: aload_3
    //   214: invokevirtual 264	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasPort	()Z
    //   217: aload_3
    //   218: getfield 155	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:port_	I
    //   221: invokeinterface 268 5 0
    //   226: putfield 155	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:port_	I
    //   229: aload_0
    //   230: aload_2
    //   231: aload_0
    //   232: invokevirtual 271	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasLatencyMs	()Z
    //   235: aload_0
    //   236: getfield 150	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:latencyMs_	I
    //   239: aload_3
    //   240: invokevirtual 271	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:hasLatencyMs	()Z
    //   243: aload_3
    //   244: getfield 150	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:latencyMs_	I
    //   247: invokeinterface 268 5 0
    //   252: putfield 150	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:latencyMs_	I
    //   255: aload_0
    //   256: astore_1
    //   257: aload_2
    //   258: getstatic 277	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   261: if_acmpne -189 -> 72
    //   264: aload_0
    //   265: aload_0
    //   266: getfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   269: aload_3
    //   270: getfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   273: ior
    //   274: putfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   277: aload_0
    //   278: areturn
    //   279: aload_2
    //   280: checkcast 279	com/google/protobuf/CodedInputStream
    //   283: astore_1
    //   284: aload_3
    //   285: checkcast 281	com/google/protobuf/ExtensionRegistryLite
    //   288: astore_2
    //   289: iconst_0
    //   290: istore 4
    //   292: iload 4
    //   294: ifne +272 -> 566
    //   297: aload_1
    //   298: invokevirtual 284	com/google/protobuf/CodedInputStream:readTag	()I
    //   301: istore 5
    //   303: iload 5
    //   305: lookupswitch	default:+306->611, 0:+309->614, 10:+83->388, 18:+123->428, 24:+170->475, 32:+192->497, 42:+214->519, 818:+237->542
    //   372: aload_0
    //   373: iload 5
    //   375: aload_1
    //   376: invokevirtual 288	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   379: ifne -87 -> 292
    //   382: iconst_1
    //   383: istore 4
    //   385: goto -93 -> 292
    //   388: aload_1
    //   389: invokevirtual 291	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   392: astore_2
    //   393: aload_0
    //   394: aload_0
    //   395: getfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   398: iconst_1
    //   399: ior
    //   400: putfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   403: aload_0
    //   404: aload_2
    //   405: putfield 54	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:name_	Ljava/lang/String;
    //   408: goto -116 -> 292
    //   411: astore_1
    //   412: new 293	java/lang/RuntimeException
    //   415: dup
    //   416: aload_1
    //   417: aload_0
    //   418: invokevirtual 297	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   421: invokespecial 300	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   424: athrow
    //   425: astore_1
    //   426: aload_1
    //   427: athrow
    //   428: aload_1
    //   429: invokevirtual 291	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   432: astore_2
    //   433: aload_0
    //   434: aload_0
    //   435: getfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   438: iconst_2
    //   439: ior
    //   440: putfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   443: aload_0
    //   444: aload_2
    //   445: putfield 56	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:address4_	Ljava/lang/String;
    //   448: goto -156 -> 292
    //   451: astore_1
    //   452: new 293	java/lang/RuntimeException
    //   455: dup
    //   456: new 182	com/google/protobuf/InvalidProtocolBufferException
    //   459: dup
    //   460: aload_1
    //   461: invokevirtual 303	java/io/IOException:getMessage	()Ljava/lang/String;
    //   464: invokespecial 305	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   467: aload_0
    //   468: invokevirtual 297	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   471: invokespecial 300	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   474: athrow
    //   475: aload_0
    //   476: aload_0
    //   477: getfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   480: bipush 16
    //   482: ior
    //   483: putfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   486: aload_0
    //   487: aload_1
    //   488: invokevirtual 308	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   491: putfield 155	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:port_	I
    //   494: goto -202 -> 292
    //   497: aload_0
    //   498: aload_0
    //   499: getfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   502: bipush 32
    //   504: ior
    //   505: putfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   508: aload_0
    //   509: aload_1
    //   510: invokevirtual 308	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   513: putfield 150	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:latencyMs_	I
    //   516: goto -224 -> 292
    //   519: aload_1
    //   520: invokevirtual 291	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   523: astore_2
    //   524: aload_0
    //   525: aload_0
    //   526: getfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   529: iconst_4
    //   530: ior
    //   531: putfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   534: aload_0
    //   535: aload_2
    //   536: putfield 58	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:address6_	Ljava/lang/String;
    //   539: goto -247 -> 292
    //   542: aload_1
    //   543: invokevirtual 291	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   546: astore_2
    //   547: aload_0
    //   548: aload_0
    //   549: getfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   552: bipush 8
    //   554: ior
    //   555: putfield 135	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:bitField0_	I
    //   558: aload_0
    //   559: aload_2
    //   560: putfield 60	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:host_	Ljava/lang/String;
    //   563: goto -271 -> 292
    //   566: getstatic 45	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/ConnectSuccess;
    //   569: areturn
    //   570: getstatic 310	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:PARSER	Lcom/google/protobuf/Parser;
    //   573: ifnonnull +28 -> 601
    //   576: ldc 2
    //   578: monitorenter
    //   579: getstatic 310	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:PARSER	Lcom/google/protobuf/Parser;
    //   582: ifnonnull +16 -> 598
    //   585: new 312	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   588: dup
    //   589: getstatic 45	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/ConnectSuccess;
    //   592: invokespecial 315	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   595: putstatic 310	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:PARSER	Lcom/google/protobuf/Parser;
    //   598: ldc 2
    //   600: monitorexit
    //   601: getstatic 310	com/blizzard/telemetry/proto/standard/network/ConnectSuccess:PARSER	Lcom/google/protobuf/Parser;
    //   604: areturn
    //   605: astore_1
    //   606: ldc 2
    //   608: monitorexit
    //   609: aload_1
    //   610: athrow
    //   611: goto -239 -> 372
    //   614: iconst_1
    //   615: istore 4
    //   617: goto -325 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	620	0	this	ConnectSuccess
    //   0	620	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	620	2	paramObject1	Object
    //   0	620	3	paramObject2	Object
    //   290	326	4	i	int
    //   301	73	5	j	int
    // Exception table:
    //   from	to	target	type
    //   297	303	411	com/google/protobuf/InvalidProtocolBufferException
    //   372	382	411	com/google/protobuf/InvalidProtocolBufferException
    //   388	408	411	com/google/protobuf/InvalidProtocolBufferException
    //   428	448	411	com/google/protobuf/InvalidProtocolBufferException
    //   475	494	411	com/google/protobuf/InvalidProtocolBufferException
    //   497	516	411	com/google/protobuf/InvalidProtocolBufferException
    //   519	539	411	com/google/protobuf/InvalidProtocolBufferException
    //   542	563	411	com/google/protobuf/InvalidProtocolBufferException
    //   297	303	425	finally
    //   372	382	425	finally
    //   388	408	425	finally
    //   412	425	425	finally
    //   428	448	425	finally
    //   452	475	425	finally
    //   475	494	425	finally
    //   497	516	425	finally
    //   519	539	425	finally
    //   542	563	425	finally
    //   297	303	451	java/io/IOException
    //   372	382	451	java/io/IOException
    //   388	408	451	java/io/IOException
    //   428	448	451	java/io/IOException
    //   475	494	451	java/io/IOException
    //   497	516	451	java/io/IOException
    //   519	539	451	java/io/IOException
    //   542	563	451	java/io/IOException
    //   579	598	605	finally
    //   598	601	605	finally
    //   606	609	605	finally
  }
  
  public String getAddress4()
  {
    return this.address4_;
  }
  
  public ByteString getAddress4Bytes()
  {
    return ByteString.copyFromUtf8(this.address4_);
  }
  
  public String getAddress6()
  {
    return this.address6_;
  }
  
  public ByteString getAddress6Bytes()
  {
    return ByteString.copyFromUtf8(this.address6_);
  }
  
  public String getHost()
  {
    return this.host_;
  }
  
  public ByteString getHostBytes()
  {
    return ByteString.copyFromUtf8(this.host_);
  }
  
  public int getLatencyMs()
  {
    return this.latencyMs_;
  }
  
  public String getName()
  {
    return this.name_;
  }
  
  public ByteString getNameBytes()
  {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getPort()
  {
    return this.port_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = 0 + CodedOutputStream.computeStringSize(1, getName());
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeStringSize(2, getAddress4());
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeUInt32Size(3, this.port_);
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + CodedOutputStream.computeUInt32Size(4, this.latencyMs_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeStringSize(5, getAddress6());
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeStringSize(102, getHost());
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasAddress4()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasAddress6()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasHost()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasLatencyMs()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasPort()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeString(1, getName());
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeString(2, getAddress4());
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeUInt32(3, this.port_);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeUInt32(4, this.latencyMs_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeString(5, getAddress6());
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeString(102, getHost());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<ConnectSuccess, Builder>
    implements ConnectSuccessOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearAddress4()
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).clearAddress4();
      return this;
    }
    
    public Builder clearAddress6()
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).clearAddress6();
      return this;
    }
    
    public Builder clearHost()
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).clearHost();
      return this;
    }
    
    public Builder clearLatencyMs()
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).clearLatencyMs();
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).clearName();
      return this;
    }
    
    public Builder clearPort()
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).clearPort();
      return this;
    }
    
    public String getAddress4()
    {
      return ((ConnectSuccess)this.instance).getAddress4();
    }
    
    public ByteString getAddress4Bytes()
    {
      return ((ConnectSuccess)this.instance).getAddress4Bytes();
    }
    
    public String getAddress6()
    {
      return ((ConnectSuccess)this.instance).getAddress6();
    }
    
    public ByteString getAddress6Bytes()
    {
      return ((ConnectSuccess)this.instance).getAddress6Bytes();
    }
    
    public String getHost()
    {
      return ((ConnectSuccess)this.instance).getHost();
    }
    
    public ByteString getHostBytes()
    {
      return ((ConnectSuccess)this.instance).getHostBytes();
    }
    
    public int getLatencyMs()
    {
      return ((ConnectSuccess)this.instance).getLatencyMs();
    }
    
    public String getName()
    {
      return ((ConnectSuccess)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((ConnectSuccess)this.instance).getNameBytes();
    }
    
    public int getPort()
    {
      return ((ConnectSuccess)this.instance).getPort();
    }
    
    public boolean hasAddress4()
    {
      return ((ConnectSuccess)this.instance).hasAddress4();
    }
    
    public boolean hasAddress6()
    {
      return ((ConnectSuccess)this.instance).hasAddress6();
    }
    
    public boolean hasHost()
    {
      return ((ConnectSuccess)this.instance).hasHost();
    }
    
    public boolean hasLatencyMs()
    {
      return ((ConnectSuccess)this.instance).hasLatencyMs();
    }
    
    public boolean hasName()
    {
      return ((ConnectSuccess)this.instance).hasName();
    }
    
    public boolean hasPort()
    {
      return ((ConnectSuccess)this.instance).hasPort();
    }
    
    public Builder setAddress4(String paramString)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setAddress4(paramString);
      return this;
    }
    
    public Builder setAddress4Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setAddress4Bytes(paramByteString);
      return this;
    }
    
    public Builder setAddress6(String paramString)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setAddress6(paramString);
      return this;
    }
    
    public Builder setAddress6Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setAddress6Bytes(paramByteString);
      return this;
    }
    
    public Builder setHost(String paramString)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setHost(paramString);
      return this;
    }
    
    public Builder setHostBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setHostBytes(paramByteString);
      return this;
    }
    
    public Builder setLatencyMs(int paramInt)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setLatencyMs(paramInt);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setPort(int paramInt)
    {
      copyOnWrite();
      ((ConnectSuccess)this.instance).setPort(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/network/ConnectSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */