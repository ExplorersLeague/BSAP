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

public final class ConnectFail
  extends GeneratedMessageLite<ConnectFail, Builder>
  implements ConnectFailOrBuilder
{
  public static final int ADDRESS4_FIELD_NUMBER = 2;
  public static final int ADDRESS6_FIELD_NUMBER = 6;
  private static final ConnectFail DEFAULT_INSTANCE = new ConnectFail();
  public static final int HOST_FIELD_NUMBER = 102;
  public static final int LATENCY_MS_FIELD_NUMBER = 4;
  public static final int NAME_FIELD_NUMBER = 1;
  private static volatile Parser<ConnectFail> PARSER;
  public static final int PORT_FIELD_NUMBER = 3;
  public static final int REASON_FIELD_NUMBER = 5;
  private String address4_ = "";
  private String address6_ = "";
  private int bitField0_;
  private String host_ = "";
  private int latencyMs_;
  private String name_ = "";
  private int port_;
  private String reason_ = "";
  
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
  
  private void clearReason()
  {
    this.bitField0_ &= 0xFFFFFFBF;
    this.reason_ = getDefaultInstance().getReason();
  }
  
  public static ConnectFail getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ConnectFail paramConnectFail)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramConnectFail);
  }
  
  public static ConnectFail parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (ConnectFail)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ConnectFail parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (ConnectFail)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ConnectFail parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (ConnectFail)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ConnectFail parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (ConnectFail)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ConnectFail parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (ConnectFail)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ConnectFail parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (ConnectFail)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ConnectFail parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (ConnectFail)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ConnectFail parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (ConnectFail)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ConnectFail parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (ConnectFail)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static ConnectFail parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (ConnectFail)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<ConnectFail> parser()
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
  
  private void setReason(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x40;
    this.reason_ = paramString;
  }
  
  private void setReasonBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x40;
    this.reason_ = paramByteString.toStringUtf8();
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 250	com/blizzard/telemetry/proto/standard/network/ConnectFail$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 256	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+297->305, 7:+614->622, 8:+618->626
    //   56: new 258	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 259	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/blizzard/telemetry/proto/standard/network/ConnectFail
    //   67: dup
    //   68: invokespecial 46	com/blizzard/telemetry/proto/standard/network/ConnectFail:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 48	com/blizzard/telemetry/proto/standard/network/ConnectFail:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/ConnectFail;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/blizzard/telemetry/proto/standard/network/ConnectFail$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 262	com/blizzard/telemetry/proto/standard/network/ConnectFail$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/network/ConnectFail$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 264	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/blizzard/telemetry/proto/standard/network/ConnectFail
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 268	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasName	()Z
    //   105: aload_0
    //   106: getfield 57	com/blizzard/telemetry/proto/standard/network/ConnectFail:name_	Ljava/lang/String;
    //   109: aload_3
    //   110: invokevirtual 268	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasName	()Z
    //   113: aload_3
    //   114: getfield 57	com/blizzard/telemetry/proto/standard/network/ConnectFail:name_	Ljava/lang/String;
    //   117: invokeinterface 272 5 0
    //   122: putfield 57	com/blizzard/telemetry/proto/standard/network/ConnectFail:name_	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 275	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasAddress4	()Z
    //   131: aload_0
    //   132: getfield 59	com/blizzard/telemetry/proto/standard/network/ConnectFail:address4_	Ljava/lang/String;
    //   135: aload_3
    //   136: invokevirtual 275	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasAddress4	()Z
    //   139: aload_3
    //   140: getfield 59	com/blizzard/telemetry/proto/standard/network/ConnectFail:address4_	Ljava/lang/String;
    //   143: invokeinterface 272 5 0
    //   148: putfield 59	com/blizzard/telemetry/proto/standard/network/ConnectFail:address4_	Ljava/lang/String;
    //   151: aload_0
    //   152: aload_2
    //   153: aload_0
    //   154: invokevirtual 278	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasAddress6	()Z
    //   157: aload_0
    //   158: getfield 61	com/blizzard/telemetry/proto/standard/network/ConnectFail:address6_	Ljava/lang/String;
    //   161: aload_3
    //   162: invokevirtual 278	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasAddress6	()Z
    //   165: aload_3
    //   166: getfield 61	com/blizzard/telemetry/proto/standard/network/ConnectFail:address6_	Ljava/lang/String;
    //   169: invokeinterface 272 5 0
    //   174: putfield 61	com/blizzard/telemetry/proto/standard/network/ConnectFail:address6_	Ljava/lang/String;
    //   177: aload_0
    //   178: aload_2
    //   179: aload_0
    //   180: invokevirtual 281	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasHost	()Z
    //   183: aload_0
    //   184: getfield 63	com/blizzard/telemetry/proto/standard/network/ConnectFail:host_	Ljava/lang/String;
    //   187: aload_3
    //   188: invokevirtual 281	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasHost	()Z
    //   191: aload_3
    //   192: getfield 63	com/blizzard/telemetry/proto/standard/network/ConnectFail:host_	Ljava/lang/String;
    //   195: invokeinterface 272 5 0
    //   200: putfield 63	com/blizzard/telemetry/proto/standard/network/ConnectFail:host_	Ljava/lang/String;
    //   203: aload_0
    //   204: aload_2
    //   205: aload_0
    //   206: invokevirtual 284	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasPort	()Z
    //   209: aload_0
    //   210: getfield 172	com/blizzard/telemetry/proto/standard/network/ConnectFail:port_	I
    //   213: aload_3
    //   214: invokevirtual 284	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasPort	()Z
    //   217: aload_3
    //   218: getfield 172	com/blizzard/telemetry/proto/standard/network/ConnectFail:port_	I
    //   221: invokeinterface 288 5 0
    //   226: putfield 172	com/blizzard/telemetry/proto/standard/network/ConnectFail:port_	I
    //   229: aload_0
    //   230: aload_2
    //   231: aload_0
    //   232: invokevirtual 291	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasLatencyMs	()Z
    //   235: aload_0
    //   236: getfield 167	com/blizzard/telemetry/proto/standard/network/ConnectFail:latencyMs_	I
    //   239: aload_3
    //   240: invokevirtual 291	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasLatencyMs	()Z
    //   243: aload_3
    //   244: getfield 167	com/blizzard/telemetry/proto/standard/network/ConnectFail:latencyMs_	I
    //   247: invokeinterface 288 5 0
    //   252: putfield 167	com/blizzard/telemetry/proto/standard/network/ConnectFail:latencyMs_	I
    //   255: aload_0
    //   256: aload_2
    //   257: aload_0
    //   258: invokevirtual 294	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasReason	()Z
    //   261: aload_0
    //   262: getfield 65	com/blizzard/telemetry/proto/standard/network/ConnectFail:reason_	Ljava/lang/String;
    //   265: aload_3
    //   266: invokevirtual 294	com/blizzard/telemetry/proto/standard/network/ConnectFail:hasReason	()Z
    //   269: aload_3
    //   270: getfield 65	com/blizzard/telemetry/proto/standard/network/ConnectFail:reason_	Ljava/lang/String;
    //   273: invokeinterface 272 5 0
    //   278: putfield 65	com/blizzard/telemetry/proto/standard/network/ConnectFail:reason_	Ljava/lang/String;
    //   281: aload_0
    //   282: astore_1
    //   283: aload_2
    //   284: getstatic 300	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   287: if_acmpne -215 -> 72
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   295: aload_3
    //   296: getfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   299: ior
    //   300: putfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   303: aload_0
    //   304: areturn
    //   305: aload_2
    //   306: checkcast 302	com/google/protobuf/CodedInputStream
    //   309: astore_1
    //   310: aload_3
    //   311: checkcast 304	com/google/protobuf/ExtensionRegistryLite
    //   314: astore_2
    //   315: iconst_0
    //   316: istore 4
    //   318: iload 4
    //   320: ifne +302 -> 622
    //   323: aload_1
    //   324: invokevirtual 307	com/google/protobuf/CodedInputStream:readTag	()I
    //   327: istore 5
    //   329: iload 5
    //   331: lookupswitch	default:+336->667, 0:+339->670, 10:+89->420, 18:+129->460, 24:+176->507, 32:+198->529, 42:+220->551, 50:+244->575, 818:+267->598
    //   404: aload_0
    //   405: iload 5
    //   407: aload_1
    //   408: invokevirtual 311	com/blizzard/telemetry/proto/standard/network/ConnectFail:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   411: ifne -93 -> 318
    //   414: iconst_1
    //   415: istore 4
    //   417: goto -99 -> 318
    //   420: aload_1
    //   421: invokevirtual 314	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   424: astore_2
    //   425: aload_0
    //   426: aload_0
    //   427: getfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   430: iconst_1
    //   431: ior
    //   432: putfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   435: aload_0
    //   436: aload_2
    //   437: putfield 57	com/blizzard/telemetry/proto/standard/network/ConnectFail:name_	Ljava/lang/String;
    //   440: goto -122 -> 318
    //   443: astore_1
    //   444: new 316	java/lang/RuntimeException
    //   447: dup
    //   448: aload_1
    //   449: aload_0
    //   450: invokevirtual 320	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   453: invokespecial 323	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   456: athrow
    //   457: astore_1
    //   458: aload_1
    //   459: athrow
    //   460: aload_1
    //   461: invokevirtual 314	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   464: astore_2
    //   465: aload_0
    //   466: aload_0
    //   467: getfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   470: iconst_2
    //   471: ior
    //   472: putfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   475: aload_0
    //   476: aload_2
    //   477: putfield 59	com/blizzard/telemetry/proto/standard/network/ConnectFail:address4_	Ljava/lang/String;
    //   480: goto -162 -> 318
    //   483: astore_1
    //   484: new 316	java/lang/RuntimeException
    //   487: dup
    //   488: new 202	com/google/protobuf/InvalidProtocolBufferException
    //   491: dup
    //   492: aload_1
    //   493: invokevirtual 326	java/io/IOException:getMessage	()Ljava/lang/String;
    //   496: invokespecial 328	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   499: aload_0
    //   500: invokevirtual 320	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   503: invokespecial 323	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   506: athrow
    //   507: aload_0
    //   508: aload_0
    //   509: getfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   512: bipush 16
    //   514: ior
    //   515: putfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   518: aload_0
    //   519: aload_1
    //   520: invokevirtual 331	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   523: putfield 172	com/blizzard/telemetry/proto/standard/network/ConnectFail:port_	I
    //   526: goto -208 -> 318
    //   529: aload_0
    //   530: aload_0
    //   531: getfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   534: bipush 32
    //   536: ior
    //   537: putfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   540: aload_0
    //   541: aload_1
    //   542: invokevirtual 331	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   545: putfield 167	com/blizzard/telemetry/proto/standard/network/ConnectFail:latencyMs_	I
    //   548: goto -230 -> 318
    //   551: aload_1
    //   552: invokevirtual 314	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   555: astore_2
    //   556: aload_0
    //   557: aload_0
    //   558: getfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   561: bipush 64
    //   563: ior
    //   564: putfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   567: aload_0
    //   568: aload_2
    //   569: putfield 65	com/blizzard/telemetry/proto/standard/network/ConnectFail:reason_	Ljava/lang/String;
    //   572: goto -254 -> 318
    //   575: aload_1
    //   576: invokevirtual 314	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   579: astore_2
    //   580: aload_0
    //   581: aload_0
    //   582: getfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   585: iconst_4
    //   586: ior
    //   587: putfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   590: aload_0
    //   591: aload_2
    //   592: putfield 61	com/blizzard/telemetry/proto/standard/network/ConnectFail:address6_	Ljava/lang/String;
    //   595: goto -277 -> 318
    //   598: aload_1
    //   599: invokevirtual 314	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   602: astore_2
    //   603: aload_0
    //   604: aload_0
    //   605: getfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   608: bipush 8
    //   610: ior
    //   611: putfield 152	com/blizzard/telemetry/proto/standard/network/ConnectFail:bitField0_	I
    //   614: aload_0
    //   615: aload_2
    //   616: putfield 63	com/blizzard/telemetry/proto/standard/network/ConnectFail:host_	Ljava/lang/String;
    //   619: goto -301 -> 318
    //   622: getstatic 48	com/blizzard/telemetry/proto/standard/network/ConnectFail:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/ConnectFail;
    //   625: areturn
    //   626: getstatic 333	com/blizzard/telemetry/proto/standard/network/ConnectFail:PARSER	Lcom/google/protobuf/Parser;
    //   629: ifnonnull +28 -> 657
    //   632: ldc 2
    //   634: monitorenter
    //   635: getstatic 333	com/blizzard/telemetry/proto/standard/network/ConnectFail:PARSER	Lcom/google/protobuf/Parser;
    //   638: ifnonnull +16 -> 654
    //   641: new 335	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   644: dup
    //   645: getstatic 48	com/blizzard/telemetry/proto/standard/network/ConnectFail:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/ConnectFail;
    //   648: invokespecial 338	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   651: putstatic 333	com/blizzard/telemetry/proto/standard/network/ConnectFail:PARSER	Lcom/google/protobuf/Parser;
    //   654: ldc 2
    //   656: monitorexit
    //   657: getstatic 333	com/blizzard/telemetry/proto/standard/network/ConnectFail:PARSER	Lcom/google/protobuf/Parser;
    //   660: areturn
    //   661: astore_1
    //   662: ldc 2
    //   664: monitorexit
    //   665: aload_1
    //   666: athrow
    //   667: goto -263 -> 404
    //   670: iconst_1
    //   671: istore 4
    //   673: goto -355 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	676	0	this	ConnectFail
    //   0	676	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	676	2	paramObject1	Object
    //   0	676	3	paramObject2	Object
    //   316	356	4	i	int
    //   327	79	5	j	int
    // Exception table:
    //   from	to	target	type
    //   323	329	443	com/google/protobuf/InvalidProtocolBufferException
    //   404	414	443	com/google/protobuf/InvalidProtocolBufferException
    //   420	440	443	com/google/protobuf/InvalidProtocolBufferException
    //   460	480	443	com/google/protobuf/InvalidProtocolBufferException
    //   507	526	443	com/google/protobuf/InvalidProtocolBufferException
    //   529	548	443	com/google/protobuf/InvalidProtocolBufferException
    //   551	572	443	com/google/protobuf/InvalidProtocolBufferException
    //   575	595	443	com/google/protobuf/InvalidProtocolBufferException
    //   598	619	443	com/google/protobuf/InvalidProtocolBufferException
    //   323	329	457	finally
    //   404	414	457	finally
    //   420	440	457	finally
    //   444	457	457	finally
    //   460	480	457	finally
    //   484	507	457	finally
    //   507	526	457	finally
    //   529	548	457	finally
    //   551	572	457	finally
    //   575	595	457	finally
    //   598	619	457	finally
    //   323	329	483	java/io/IOException
    //   404	414	483	java/io/IOException
    //   420	440	483	java/io/IOException
    //   460	480	483	java/io/IOException
    //   507	526	483	java/io/IOException
    //   529	548	483	java/io/IOException
    //   551	572	483	java/io/IOException
    //   575	595	483	java/io/IOException
    //   598	619	483	java/io/IOException
    //   635	654	661	finally
    //   654	657	661	finally
    //   662	665	661	finally
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
  
  public String getReason()
  {
    return this.reason_;
  }
  
  public ByteString getReasonBytes()
  {
    return ByteString.copyFromUtf8(this.reason_);
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
    if ((this.bitField0_ & 0x40) == 64) {
      j = i + CodedOutputStream.computeStringSize(5, getReason());
    }
    i = j;
    if ((this.bitField0_ & 0x4) == 4) {
      i = j + CodedOutputStream.computeStringSize(6, getAddress6());
    }
    j = i;
    if ((this.bitField0_ & 0x8) == 8) {
      j = i + CodedOutputStream.computeStringSize(102, getHost());
    }
    i = j + this.unknownFields.getSerializedSize();
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
  
  public boolean hasReason()
  {
    return (this.bitField0_ & 0x40) == 64;
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
    if ((this.bitField0_ & 0x40) == 64) {
      paramCodedOutputStream.writeString(5, getReason());
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeString(6, getAddress6());
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeString(102, getHost());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<ConnectFail, Builder>
    implements ConnectFailOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearAddress4()
    {
      copyOnWrite();
      ((ConnectFail)this.instance).clearAddress4();
      return this;
    }
    
    public Builder clearAddress6()
    {
      copyOnWrite();
      ((ConnectFail)this.instance).clearAddress6();
      return this;
    }
    
    public Builder clearHost()
    {
      copyOnWrite();
      ((ConnectFail)this.instance).clearHost();
      return this;
    }
    
    public Builder clearLatencyMs()
    {
      copyOnWrite();
      ((ConnectFail)this.instance).clearLatencyMs();
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((ConnectFail)this.instance).clearName();
      return this;
    }
    
    public Builder clearPort()
    {
      copyOnWrite();
      ((ConnectFail)this.instance).clearPort();
      return this;
    }
    
    public Builder clearReason()
    {
      copyOnWrite();
      ((ConnectFail)this.instance).clearReason();
      return this;
    }
    
    public String getAddress4()
    {
      return ((ConnectFail)this.instance).getAddress4();
    }
    
    public ByteString getAddress4Bytes()
    {
      return ((ConnectFail)this.instance).getAddress4Bytes();
    }
    
    public String getAddress6()
    {
      return ((ConnectFail)this.instance).getAddress6();
    }
    
    public ByteString getAddress6Bytes()
    {
      return ((ConnectFail)this.instance).getAddress6Bytes();
    }
    
    public String getHost()
    {
      return ((ConnectFail)this.instance).getHost();
    }
    
    public ByteString getHostBytes()
    {
      return ((ConnectFail)this.instance).getHostBytes();
    }
    
    public int getLatencyMs()
    {
      return ((ConnectFail)this.instance).getLatencyMs();
    }
    
    public String getName()
    {
      return ((ConnectFail)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((ConnectFail)this.instance).getNameBytes();
    }
    
    public int getPort()
    {
      return ((ConnectFail)this.instance).getPort();
    }
    
    public String getReason()
    {
      return ((ConnectFail)this.instance).getReason();
    }
    
    public ByteString getReasonBytes()
    {
      return ((ConnectFail)this.instance).getReasonBytes();
    }
    
    public boolean hasAddress4()
    {
      return ((ConnectFail)this.instance).hasAddress4();
    }
    
    public boolean hasAddress6()
    {
      return ((ConnectFail)this.instance).hasAddress6();
    }
    
    public boolean hasHost()
    {
      return ((ConnectFail)this.instance).hasHost();
    }
    
    public boolean hasLatencyMs()
    {
      return ((ConnectFail)this.instance).hasLatencyMs();
    }
    
    public boolean hasName()
    {
      return ((ConnectFail)this.instance).hasName();
    }
    
    public boolean hasPort()
    {
      return ((ConnectFail)this.instance).hasPort();
    }
    
    public boolean hasReason()
    {
      return ((ConnectFail)this.instance).hasReason();
    }
    
    public Builder setAddress4(String paramString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setAddress4(paramString);
      return this;
    }
    
    public Builder setAddress4Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setAddress4Bytes(paramByteString);
      return this;
    }
    
    public Builder setAddress6(String paramString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setAddress6(paramString);
      return this;
    }
    
    public Builder setAddress6Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setAddress6Bytes(paramByteString);
      return this;
    }
    
    public Builder setHost(String paramString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setHost(paramString);
      return this;
    }
    
    public Builder setHostBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setHostBytes(paramByteString);
      return this;
    }
    
    public Builder setLatencyMs(int paramInt)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setLatencyMs(paramInt);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setPort(int paramInt)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setPort(paramInt);
      return this;
    }
    
    public Builder setReason(String paramString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setReason(paramString);
      return this;
    }
    
    public Builder setReasonBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((ConnectFail)this.instance).setReasonBytes(paramByteString);
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/network/ConnectFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */