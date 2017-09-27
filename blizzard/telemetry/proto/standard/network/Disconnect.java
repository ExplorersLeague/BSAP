package com.blizzard.telemetry.proto.standard.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;

public final class Disconnect
  extends GeneratedMessageLite<Disconnect, Builder>
  implements DisconnectOrBuilder
{
  public static final int ADDRESS4_FIELD_NUMBER = 2;
  public static final int ADDRESS6_FIELD_NUMBER = 6;
  private static final Disconnect DEFAULT_INSTANCE = new Disconnect();
  public static final int DESCRIPTION_FIELD_NUMBER = 7;
  public static final int DURATION_MS_FIELD_NUMBER = 5;
  public static final int HOST_FIELD_NUMBER = 102;
  public static final int NAME_FIELD_NUMBER = 1;
  private static volatile Parser<Disconnect> PARSER;
  public static final int PORT_FIELD_NUMBER = 3;
  public static final int REASON_FIELD_NUMBER = 4;
  private String address4_ = "";
  private String address6_ = "";
  private int bitField0_;
  private String description_ = "";
  private long durationMs_;
  private String host_ = "";
  private String name_ = "";
  private int port_;
  private int reason_;
  
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
  
  private void clearDescription()
  {
    this.bitField0_ &= 0xFF7F;
    this.description_ = getDefaultInstance().getDescription();
  }
  
  private void clearDurationMs()
  {
    this.bitField0_ &= 0xFFFFFFBF;
    this.durationMs_ = 0L;
  }
  
  private void clearHost()
  {
    this.bitField0_ &= 0xFFFFFFF7;
    this.host_ = getDefaultInstance().getHost();
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
    this.bitField0_ &= 0xFFFFFFDF;
    this.reason_ = 0;
  }
  
  public static Disconnect getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Disconnect paramDisconnect)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDisconnect);
  }
  
  public static Disconnect parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Disconnect)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Disconnect parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Disconnect)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Disconnect parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Disconnect)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Disconnect parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Disconnect)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Disconnect parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Disconnect)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Disconnect parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Disconnect)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Disconnect parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Disconnect)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Disconnect parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Disconnect)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Disconnect parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Disconnect)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Disconnect parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Disconnect)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Disconnect> parser()
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
  
  private void setDescription(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x80;
    this.description_ = paramString;
  }
  
  private void setDescriptionBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x80;
    this.description_ = paramByteString.toStringUtf8();
  }
  
  private void setDurationMs(long paramLong)
  {
    this.bitField0_ |= 0x40;
    this.durationMs_ = paramLong;
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
  
  private void setReason(Reason paramReason)
  {
    if (paramReason == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x20;
    this.reason_ = paramReason.getNumber();
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 277	com/blizzard/telemetry/proto/standard/network/Disconnect$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 282	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+323->331, 7:+695->703, 8:+699->707
    //   56: new 284	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 285	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/blizzard/telemetry/proto/standard/network/Disconnect
    //   67: dup
    //   68: invokespecial 55	com/blizzard/telemetry/proto/standard/network/Disconnect:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 57	com/blizzard/telemetry/proto/standard/network/Disconnect:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/Disconnect;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/blizzard/telemetry/proto/standard/network/Disconnect$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 288	com/blizzard/telemetry/proto/standard/network/Disconnect$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/network/Disconnect$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 290	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/blizzard/telemetry/proto/standard/network/Disconnect
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 294	com/blizzard/telemetry/proto/standard/network/Disconnect:hasName	()Z
    //   105: aload_0
    //   106: getfield 66	com/blizzard/telemetry/proto/standard/network/Disconnect:name_	Ljava/lang/String;
    //   109: aload_3
    //   110: invokevirtual 294	com/blizzard/telemetry/proto/standard/network/Disconnect:hasName	()Z
    //   113: aload_3
    //   114: getfield 66	com/blizzard/telemetry/proto/standard/network/Disconnect:name_	Ljava/lang/String;
    //   117: invokeinterface 298 5 0
    //   122: putfield 66	com/blizzard/telemetry/proto/standard/network/Disconnect:name_	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 301	com/blizzard/telemetry/proto/standard/network/Disconnect:hasAddress4	()Z
    //   131: aload_0
    //   132: getfield 68	com/blizzard/telemetry/proto/standard/network/Disconnect:address4_	Ljava/lang/String;
    //   135: aload_3
    //   136: invokevirtual 301	com/blizzard/telemetry/proto/standard/network/Disconnect:hasAddress4	()Z
    //   139: aload_3
    //   140: getfield 68	com/blizzard/telemetry/proto/standard/network/Disconnect:address4_	Ljava/lang/String;
    //   143: invokeinterface 298 5 0
    //   148: putfield 68	com/blizzard/telemetry/proto/standard/network/Disconnect:address4_	Ljava/lang/String;
    //   151: aload_0
    //   152: aload_2
    //   153: aload_0
    //   154: invokevirtual 304	com/blizzard/telemetry/proto/standard/network/Disconnect:hasAddress6	()Z
    //   157: aload_0
    //   158: getfield 70	com/blizzard/telemetry/proto/standard/network/Disconnect:address6_	Ljava/lang/String;
    //   161: aload_3
    //   162: invokevirtual 304	com/blizzard/telemetry/proto/standard/network/Disconnect:hasAddress6	()Z
    //   165: aload_3
    //   166: getfield 70	com/blizzard/telemetry/proto/standard/network/Disconnect:address6_	Ljava/lang/String;
    //   169: invokeinterface 298 5 0
    //   174: putfield 70	com/blizzard/telemetry/proto/standard/network/Disconnect:address6_	Ljava/lang/String;
    //   177: aload_0
    //   178: aload_2
    //   179: aload_0
    //   180: invokevirtual 307	com/blizzard/telemetry/proto/standard/network/Disconnect:hasHost	()Z
    //   183: aload_0
    //   184: getfield 72	com/blizzard/telemetry/proto/standard/network/Disconnect:host_	Ljava/lang/String;
    //   187: aload_3
    //   188: invokevirtual 307	com/blizzard/telemetry/proto/standard/network/Disconnect:hasHost	()Z
    //   191: aload_3
    //   192: getfield 72	com/blizzard/telemetry/proto/standard/network/Disconnect:host_	Ljava/lang/String;
    //   195: invokeinterface 298 5 0
    //   200: putfield 72	com/blizzard/telemetry/proto/standard/network/Disconnect:host_	Ljava/lang/String;
    //   203: aload_0
    //   204: aload_2
    //   205: aload_0
    //   206: invokevirtual 310	com/blizzard/telemetry/proto/standard/network/Disconnect:hasPort	()Z
    //   209: aload_0
    //   210: getfield 196	com/blizzard/telemetry/proto/standard/network/Disconnect:port_	I
    //   213: aload_3
    //   214: invokevirtual 310	com/blizzard/telemetry/proto/standard/network/Disconnect:hasPort	()Z
    //   217: aload_3
    //   218: getfield 196	com/blizzard/telemetry/proto/standard/network/Disconnect:port_	I
    //   221: invokeinterface 314 5 0
    //   226: putfield 196	com/blizzard/telemetry/proto/standard/network/Disconnect:port_	I
    //   229: aload_0
    //   230: aload_2
    //   231: aload_0
    //   232: invokevirtual 317	com/blizzard/telemetry/proto/standard/network/Disconnect:hasReason	()Z
    //   235: aload_0
    //   236: getfield 198	com/blizzard/telemetry/proto/standard/network/Disconnect:reason_	I
    //   239: aload_3
    //   240: invokevirtual 317	com/blizzard/telemetry/proto/standard/network/Disconnect:hasReason	()Z
    //   243: aload_3
    //   244: getfield 198	com/blizzard/telemetry/proto/standard/network/Disconnect:reason_	I
    //   247: invokeinterface 314 5 0
    //   252: putfield 198	com/blizzard/telemetry/proto/standard/network/Disconnect:reason_	I
    //   255: aload_0
    //   256: aload_2
    //   257: aload_0
    //   258: invokevirtual 320	com/blizzard/telemetry/proto/standard/network/Disconnect:hasDurationMs	()Z
    //   261: aload_0
    //   262: getfield 188	com/blizzard/telemetry/proto/standard/network/Disconnect:durationMs_	J
    //   265: aload_3
    //   266: invokevirtual 320	com/blizzard/telemetry/proto/standard/network/Disconnect:hasDurationMs	()Z
    //   269: aload_3
    //   270: getfield 188	com/blizzard/telemetry/proto/standard/network/Disconnect:durationMs_	J
    //   273: invokeinterface 324 7 0
    //   278: putfield 188	com/blizzard/telemetry/proto/standard/network/Disconnect:durationMs_	J
    //   281: aload_0
    //   282: aload_2
    //   283: aload_0
    //   284: invokevirtual 327	com/blizzard/telemetry/proto/standard/network/Disconnect:hasDescription	()Z
    //   287: aload_0
    //   288: getfield 74	com/blizzard/telemetry/proto/standard/network/Disconnect:description_	Ljava/lang/String;
    //   291: aload_3
    //   292: invokevirtual 327	com/blizzard/telemetry/proto/standard/network/Disconnect:hasDescription	()Z
    //   295: aload_3
    //   296: getfield 74	com/blizzard/telemetry/proto/standard/network/Disconnect:description_	Ljava/lang/String;
    //   299: invokeinterface 298 5 0
    //   304: putfield 74	com/blizzard/telemetry/proto/standard/network/Disconnect:description_	Ljava/lang/String;
    //   307: aload_0
    //   308: astore_1
    //   309: aload_2
    //   310: getstatic 333	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   313: if_acmpne -241 -> 72
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   321: aload_3
    //   322: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   325: ior
    //   326: putfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   329: aload_0
    //   330: areturn
    //   331: aload_2
    //   332: checkcast 335	com/google/protobuf/CodedInputStream
    //   335: astore_1
    //   336: aload_3
    //   337: checkcast 337	com/google/protobuf/ExtensionRegistryLite
    //   340: astore_2
    //   341: iconst_0
    //   342: istore 4
    //   344: iload 4
    //   346: ifne +357 -> 703
    //   349: aload_1
    //   350: invokevirtual 340	com/google/protobuf/CodedInputStream:readTag	()I
    //   353: istore 5
    //   355: iload 5
    //   357: lookupswitch	default:+391->748, 0:+394->751, 10:+99->456, 18:+139->496, 24:+186->543, 32:+208->565, 40:+252->609, 50:+274->631, 58:+297->654, 818:+322->679
    //   440: aload_0
    //   441: iload 5
    //   443: aload_1
    //   444: invokevirtual 344	com/blizzard/telemetry/proto/standard/network/Disconnect:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   447: ifne -103 -> 344
    //   450: iconst_1
    //   451: istore 4
    //   453: goto -109 -> 344
    //   456: aload_1
    //   457: invokevirtual 347	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   460: astore_2
    //   461: aload_0
    //   462: aload_0
    //   463: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   466: iconst_1
    //   467: ior
    //   468: putfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   471: aload_0
    //   472: aload_2
    //   473: putfield 66	com/blizzard/telemetry/proto/standard/network/Disconnect:name_	Ljava/lang/String;
    //   476: goto -132 -> 344
    //   479: astore_1
    //   480: new 349	java/lang/RuntimeException
    //   483: dup
    //   484: aload_1
    //   485: aload_0
    //   486: invokevirtual 353	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   489: invokespecial 356	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   492: athrow
    //   493: astore_1
    //   494: aload_1
    //   495: athrow
    //   496: aload_1
    //   497: invokevirtual 347	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   500: astore_2
    //   501: aload_0
    //   502: aload_0
    //   503: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   506: iconst_2
    //   507: ior
    //   508: putfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   511: aload_0
    //   512: aload_2
    //   513: putfield 68	com/blizzard/telemetry/proto/standard/network/Disconnect:address4_	Ljava/lang/String;
    //   516: goto -172 -> 344
    //   519: astore_1
    //   520: new 349	java/lang/RuntimeException
    //   523: dup
    //   524: new 225	com/google/protobuf/InvalidProtocolBufferException
    //   527: dup
    //   528: aload_1
    //   529: invokevirtual 359	java/io/IOException:getMessage	()Ljava/lang/String;
    //   532: invokespecial 361	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   535: aload_0
    //   536: invokevirtual 353	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   539: invokespecial 356	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   542: athrow
    //   543: aload_0
    //   544: aload_0
    //   545: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   548: bipush 16
    //   550: ior
    //   551: putfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   554: aload_0
    //   555: aload_1
    //   556: invokevirtual 364	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   559: putfield 196	com/blizzard/telemetry/proto/standard/network/Disconnect:port_	I
    //   562: goto -218 -> 344
    //   565: aload_1
    //   566: invokevirtual 367	com/google/protobuf/CodedInputStream:readEnum	()I
    //   569: istore 5
    //   571: iload 5
    //   573: invokestatic 371	com/blizzard/telemetry/proto/standard/network/Disconnect$Reason:forNumber	(I)Lcom/blizzard/telemetry/proto/standard/network/Disconnect$Reason;
    //   576: ifnonnull +13 -> 589
    //   579: aload_0
    //   580: iconst_4
    //   581: iload 5
    //   583: invokespecial 375	com/google/protobuf/GeneratedMessageLite:mergeVarintField	(II)V
    //   586: goto -242 -> 344
    //   589: aload_0
    //   590: aload_0
    //   591: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   594: bipush 32
    //   596: ior
    //   597: putfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   600: aload_0
    //   601: iload 5
    //   603: putfield 198	com/blizzard/telemetry/proto/standard/network/Disconnect:reason_	I
    //   606: goto -262 -> 344
    //   609: aload_0
    //   610: aload_0
    //   611: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   614: bipush 64
    //   616: ior
    //   617: putfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   620: aload_0
    //   621: aload_1
    //   622: invokevirtual 379	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   625: putfield 188	com/blizzard/telemetry/proto/standard/network/Disconnect:durationMs_	J
    //   628: goto -284 -> 344
    //   631: aload_1
    //   632: invokevirtual 347	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   635: astore_2
    //   636: aload_0
    //   637: aload_0
    //   638: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   641: iconst_4
    //   642: ior
    //   643: putfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   646: aload_0
    //   647: aload_2
    //   648: putfield 70	com/blizzard/telemetry/proto/standard/network/Disconnect:address6_	Ljava/lang/String;
    //   651: goto -307 -> 344
    //   654: aload_1
    //   655: invokevirtual 347	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   658: astore_2
    //   659: aload_0
    //   660: aload_0
    //   661: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   664: sipush 128
    //   667: ior
    //   668: putfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   671: aload_0
    //   672: aload_2
    //   673: putfield 74	com/blizzard/telemetry/proto/standard/network/Disconnect:description_	Ljava/lang/String;
    //   676: goto -332 -> 344
    //   679: aload_1
    //   680: invokevirtual 347	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   683: astore_2
    //   684: aload_0
    //   685: aload_0
    //   686: getfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   689: bipush 8
    //   691: ior
    //   692: putfield 173	com/blizzard/telemetry/proto/standard/network/Disconnect:bitField0_	I
    //   695: aload_0
    //   696: aload_2
    //   697: putfield 72	com/blizzard/telemetry/proto/standard/network/Disconnect:host_	Ljava/lang/String;
    //   700: goto -356 -> 344
    //   703: getstatic 57	com/blizzard/telemetry/proto/standard/network/Disconnect:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/Disconnect;
    //   706: areturn
    //   707: getstatic 381	com/blizzard/telemetry/proto/standard/network/Disconnect:PARSER	Lcom/google/protobuf/Parser;
    //   710: ifnonnull +28 -> 738
    //   713: ldc 2
    //   715: monitorenter
    //   716: getstatic 381	com/blizzard/telemetry/proto/standard/network/Disconnect:PARSER	Lcom/google/protobuf/Parser;
    //   719: ifnonnull +16 -> 735
    //   722: new 383	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   725: dup
    //   726: getstatic 57	com/blizzard/telemetry/proto/standard/network/Disconnect:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/Disconnect;
    //   729: invokespecial 386	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   732: putstatic 381	com/blizzard/telemetry/proto/standard/network/Disconnect:PARSER	Lcom/google/protobuf/Parser;
    //   735: ldc 2
    //   737: monitorexit
    //   738: getstatic 381	com/blizzard/telemetry/proto/standard/network/Disconnect:PARSER	Lcom/google/protobuf/Parser;
    //   741: areturn
    //   742: astore_1
    //   743: ldc 2
    //   745: monitorexit
    //   746: aload_1
    //   747: athrow
    //   748: goto -308 -> 440
    //   751: iconst_1
    //   752: istore 4
    //   754: goto -410 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	757	0	this	Disconnect
    //   0	757	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	757	2	paramObject1	Object
    //   0	757	3	paramObject2	Object
    //   342	411	4	i	int
    //   353	249	5	j	int
    // Exception table:
    //   from	to	target	type
    //   349	355	479	com/google/protobuf/InvalidProtocolBufferException
    //   440	450	479	com/google/protobuf/InvalidProtocolBufferException
    //   456	476	479	com/google/protobuf/InvalidProtocolBufferException
    //   496	516	479	com/google/protobuf/InvalidProtocolBufferException
    //   543	562	479	com/google/protobuf/InvalidProtocolBufferException
    //   565	586	479	com/google/protobuf/InvalidProtocolBufferException
    //   589	606	479	com/google/protobuf/InvalidProtocolBufferException
    //   609	628	479	com/google/protobuf/InvalidProtocolBufferException
    //   631	651	479	com/google/protobuf/InvalidProtocolBufferException
    //   654	676	479	com/google/protobuf/InvalidProtocolBufferException
    //   679	700	479	com/google/protobuf/InvalidProtocolBufferException
    //   349	355	493	finally
    //   440	450	493	finally
    //   456	476	493	finally
    //   480	493	493	finally
    //   496	516	493	finally
    //   520	543	493	finally
    //   543	562	493	finally
    //   565	586	493	finally
    //   589	606	493	finally
    //   609	628	493	finally
    //   631	651	493	finally
    //   654	676	493	finally
    //   679	700	493	finally
    //   349	355	519	java/io/IOException
    //   440	450	519	java/io/IOException
    //   456	476	519	java/io/IOException
    //   496	516	519	java/io/IOException
    //   543	562	519	java/io/IOException
    //   565	586	519	java/io/IOException
    //   589	606	519	java/io/IOException
    //   609	628	519	java/io/IOException
    //   631	651	519	java/io/IOException
    //   654	676	519	java/io/IOException
    //   679	700	519	java/io/IOException
    //   716	735	742	finally
    //   735	738	742	finally
    //   743	746	742	finally
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
  
  public String getDescription()
  {
    return this.description_;
  }
  
  public ByteString getDescriptionBytes()
  {
    return ByteString.copyFromUtf8(this.description_);
  }
  
  public long getDurationMs()
  {
    return this.durationMs_;
  }
  
  public String getHost()
  {
    return this.host_;
  }
  
  public ByteString getHostBytes()
  {
    return ByteString.copyFromUtf8(this.host_);
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
  
  public Reason getReason()
  {
    Reason localReason2 = Reason.forNumber(this.reason_);
    Reason localReason1 = localReason2;
    if (localReason2 == null) {
      localReason1 = Reason.LOCAL;
    }
    return localReason1;
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
      i = j + CodedOutputStream.computeEnumSize(4, this.reason_);
    }
    j = i;
    if ((this.bitField0_ & 0x40) == 64) {
      j = i + CodedOutputStream.computeUInt64Size(5, this.durationMs_);
    }
    i = j;
    if ((this.bitField0_ & 0x4) == 4) {
      i = j + CodedOutputStream.computeStringSize(6, getAddress6());
    }
    j = i;
    if ((this.bitField0_ & 0x80) == 128) {
      j = i + CodedOutputStream.computeStringSize(7, getDescription());
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
  
  public boolean hasDescription()
  {
    return (this.bitField0_ & 0x80) == 128;
  }
  
  public boolean hasDurationMs()
  {
    return (this.bitField0_ & 0x40) == 64;
  }
  
  public boolean hasHost()
  {
    return (this.bitField0_ & 0x8) == 8;
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
    return (this.bitField0_ & 0x20) == 32;
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
      paramCodedOutputStream.writeEnum(4, this.reason_);
    }
    if ((this.bitField0_ & 0x40) == 64) {
      paramCodedOutputStream.writeUInt64(5, this.durationMs_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeString(6, getAddress6());
    }
    if ((this.bitField0_ & 0x80) == 128) {
      paramCodedOutputStream.writeString(7, getDescription());
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeString(102, getHost());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Disconnect, Builder>
    implements DisconnectOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearAddress4()
    {
      copyOnWrite();
      ((Disconnect)this.instance).clearAddress4();
      return this;
    }
    
    public Builder clearAddress6()
    {
      copyOnWrite();
      ((Disconnect)this.instance).clearAddress6();
      return this;
    }
    
    public Builder clearDescription()
    {
      copyOnWrite();
      ((Disconnect)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearDurationMs()
    {
      copyOnWrite();
      ((Disconnect)this.instance).clearDurationMs();
      return this;
    }
    
    public Builder clearHost()
    {
      copyOnWrite();
      ((Disconnect)this.instance).clearHost();
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((Disconnect)this.instance).clearName();
      return this;
    }
    
    public Builder clearPort()
    {
      copyOnWrite();
      ((Disconnect)this.instance).clearPort();
      return this;
    }
    
    public Builder clearReason()
    {
      copyOnWrite();
      ((Disconnect)this.instance).clearReason();
      return this;
    }
    
    public String getAddress4()
    {
      return ((Disconnect)this.instance).getAddress4();
    }
    
    public ByteString getAddress4Bytes()
    {
      return ((Disconnect)this.instance).getAddress4Bytes();
    }
    
    public String getAddress6()
    {
      return ((Disconnect)this.instance).getAddress6();
    }
    
    public ByteString getAddress6Bytes()
    {
      return ((Disconnect)this.instance).getAddress6Bytes();
    }
    
    public String getDescription()
    {
      return ((Disconnect)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes()
    {
      return ((Disconnect)this.instance).getDescriptionBytes();
    }
    
    public long getDurationMs()
    {
      return ((Disconnect)this.instance).getDurationMs();
    }
    
    public String getHost()
    {
      return ((Disconnect)this.instance).getHost();
    }
    
    public ByteString getHostBytes()
    {
      return ((Disconnect)this.instance).getHostBytes();
    }
    
    public String getName()
    {
      return ((Disconnect)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((Disconnect)this.instance).getNameBytes();
    }
    
    public int getPort()
    {
      return ((Disconnect)this.instance).getPort();
    }
    
    public Disconnect.Reason getReason()
    {
      return ((Disconnect)this.instance).getReason();
    }
    
    public boolean hasAddress4()
    {
      return ((Disconnect)this.instance).hasAddress4();
    }
    
    public boolean hasAddress6()
    {
      return ((Disconnect)this.instance).hasAddress6();
    }
    
    public boolean hasDescription()
    {
      return ((Disconnect)this.instance).hasDescription();
    }
    
    public boolean hasDurationMs()
    {
      return ((Disconnect)this.instance).hasDurationMs();
    }
    
    public boolean hasHost()
    {
      return ((Disconnect)this.instance).hasHost();
    }
    
    public boolean hasName()
    {
      return ((Disconnect)this.instance).hasName();
    }
    
    public boolean hasPort()
    {
      return ((Disconnect)this.instance).hasPort();
    }
    
    public boolean hasReason()
    {
      return ((Disconnect)this.instance).hasReason();
    }
    
    public Builder setAddress4(String paramString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setAddress4(paramString);
      return this;
    }
    
    public Builder setAddress4Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setAddress4Bytes(paramByteString);
      return this;
    }
    
    public Builder setAddress6(String paramString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setAddress6(paramString);
      return this;
    }
    
    public Builder setAddress6Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setAddress6Bytes(paramByteString);
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setDescription(paramString);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setDescriptionBytes(paramByteString);
      return this;
    }
    
    public Builder setDurationMs(long paramLong)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setDurationMs(paramLong);
      return this;
    }
    
    public Builder setHost(String paramString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setHost(paramString);
      return this;
    }
    
    public Builder setHostBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setHostBytes(paramByteString);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setPort(int paramInt)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setPort(paramInt);
      return this;
    }
    
    public Builder setReason(Disconnect.Reason paramReason)
    {
      copyOnWrite();
      ((Disconnect)this.instance).setReason(paramReason);
      return this;
    }
  }
  
  public static enum Reason
    implements Internal.EnumLite
  {
    LOCAL(0),  REMOTE(1),  TIMEOUT(2);
    
    public static final int LOCAL_VALUE = 0;
    public static final int REMOTE_VALUE = 1;
    public static final int TIMEOUT_VALUE = 2;
    private static final Internal.EnumLiteMap<Reason> internalValueMap = new Internal.EnumLiteMap()
    {
      public Disconnect.Reason findValueByNumber(int paramAnonymousInt)
      {
        return Disconnect.Reason.forNumber(paramAnonymousInt);
      }
    };
    private final int value;
    
    private Reason(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static Reason forNumber(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return LOCAL;
      case 1: 
        return REMOTE;
      }
      return TIMEOUT;
    }
    
    public static Internal.EnumLiteMap<Reason> internalGetValueMap()
    {
      return internalValueMap;
    }
    
    @Deprecated
    public static Reason valueOf(int paramInt)
    {
      return forNumber(paramInt);
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/network/Disconnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */