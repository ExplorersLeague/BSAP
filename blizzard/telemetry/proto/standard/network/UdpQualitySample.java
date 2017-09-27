package com.blizzard.telemetry.proto.standard.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;

public final class UdpQualitySample
  extends GeneratedMessageLite<UdpQualitySample, Builder>
  implements UdpQualitySampleOrBuilder
{
  public static final int ADDRESS4_FIELD_NUMBER = 2;
  public static final int ADDRESS6_FIELD_NUMBER = 5;
  public static final int BANDWIDTH_DOWN_BPS_FIELD_NUMBER = 113;
  public static final int BANDWIDTH_UP_BPS_FIELD_NUMBER = 112;
  public static final int BYTES_RECEIVED_FIELD_NUMBER = 102;
  public static final int BYTES_SENT_FIELD_NUMBER = 101;
  private static final UdpQualitySample DEFAULT_INSTANCE = new UdpQualitySample();
  public static final int FIXED_INTERPOLATION_DELAY_MS_FIELD_NUMBER = 110;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int OUT_OF_ORDER_OR_DUPLICATE_PACKETS_RECEIVED_FIELD_NUMBER = 109;
  public static final int PACKETS_LOST_RECEIVE_FIELD_NUMBER = 108;
  public static final int PACKETS_LOST_SEND_FIELD_NUMBER = 107;
  public static final int PACKETS_RECEIVED_FIELD_NUMBER = 106;
  public static final int PACKETS_SENT_FIELD_NUMBER = 105;
  private static volatile Parser<UdpQualitySample> PARSER;
  public static final int PING_MS_FIELD_NUMBER = 114;
  public static final int PORT_FIELD_NUMBER = 3;
  public static final int ROUNDTRIP_TIME_SMOOTHED_MS_FIELD_NUMBER = 103;
  public static final int ROUNDTRIP_TIME_VARIANCE_ESTIMATE_FIELD_NUMBER = 104;
  public static final int SAMPLE_TIME_MS_FIELD_NUMBER = 100;
  public static final int SESSION_ID_FIELD_NUMBER = 4;
  public static final int TIME_SINCE_PREV_PACKET_MS_FIELD_NUMBER = 111;
  private String address4_ = "";
  private String address6_ = "";
  private float bandwidthDownBps_;
  private float bandwidthUpBps_;
  private int bitField0_;
  private long bytesReceived_;
  private long bytesSent_;
  private float fixedInterpolationDelayMs_;
  private String name_ = "";
  private int outOfOrderOrDuplicatePacketsReceived_;
  private int packetsLostReceive_;
  private int packetsLostSend_;
  private int packetsReceived_;
  private int packetsSent_;
  private Metric pingMs_;
  private int port_;
  private float roundtripTimeSmoothedMs_;
  private float roundtripTimeVarianceEstimate_;
  private float sampleTimeMs_;
  private long sessionId_;
  private Metric timeSincePrevPacketMs_;
  
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
  
  private void clearBandwidthDownBps()
  {
    this.bitField0_ &= 0xFFFBFFFF;
    this.bandwidthDownBps_ = 0.0F;
  }
  
  private void clearBandwidthUpBps()
  {
    this.bitField0_ &= 0xFFFDFFFF;
    this.bandwidthUpBps_ = 0.0F;
  }
  
  private void clearBytesReceived()
  {
    this.bitField0_ &= 0xFF7F;
    this.bytesReceived_ = 0L;
  }
  
  private void clearBytesSent()
  {
    this.bitField0_ &= 0xFFFFFFBF;
    this.bytesSent_ = 0L;
  }
  
  private void clearFixedInterpolationDelayMs()
  {
    this.bitField0_ &= 0xFFFF7FFF;
    this.fixedInterpolationDelayMs_ = 0.0F;
  }
  
  private void clearName()
  {
    this.bitField0_ &= 0xFFFFFFFE;
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOutOfOrderOrDuplicatePacketsReceived()
  {
    this.bitField0_ &= 0xBFFF;
    this.outOfOrderOrDuplicatePacketsReceived_ = 0;
  }
  
  private void clearPacketsLostReceive()
  {
    this.bitField0_ &= 0xDFFF;
    this.packetsLostReceive_ = 0;
  }
  
  private void clearPacketsLostSend()
  {
    this.bitField0_ &= 0xEFFF;
    this.packetsLostSend_ = 0;
  }
  
  private void clearPacketsReceived()
  {
    this.bitField0_ &= 0xF7FF;
    this.packetsReceived_ = 0;
  }
  
  private void clearPacketsSent()
  {
    this.bitField0_ &= 0xFBFF;
    this.packetsSent_ = 0;
  }
  
  private void clearPingMs()
  {
    this.pingMs_ = null;
    this.bitField0_ &= 0xFFF7FFFF;
  }
  
  private void clearPort()
  {
    this.bitField0_ &= 0xFFFFFFF7;
    this.port_ = 0;
  }
  
  private void clearRoundtripTimeSmoothedMs()
  {
    this.bitField0_ &= 0xFEFF;
    this.roundtripTimeSmoothedMs_ = 0.0F;
  }
  
  private void clearRoundtripTimeVarianceEstimate()
  {
    this.bitField0_ &= 0xFDFF;
    this.roundtripTimeVarianceEstimate_ = 0.0F;
  }
  
  private void clearSampleTimeMs()
  {
    this.bitField0_ &= 0xFFFFFFDF;
    this.sampleTimeMs_ = 0.0F;
  }
  
  private void clearSessionId()
  {
    this.bitField0_ &= 0xFFFFFFEF;
    this.sessionId_ = 0L;
  }
  
  private void clearTimeSincePrevPacketMs()
  {
    this.timeSincePrevPacketMs_ = null;
    this.bitField0_ &= 0xFFFEFFFF;
  }
  
  public static UdpQualitySample getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private void mergePingMs(Metric paramMetric)
  {
    if ((this.pingMs_ != null) && (this.pingMs_ != Metric.getDefaultInstance())) {}
    for (this.pingMs_ = ((Metric)((UdpQualitySample.Metric.Builder)Metric.newBuilder(this.pingMs_).mergeFrom(paramMetric)).buildPartial());; this.pingMs_ = paramMetric)
    {
      this.bitField0_ |= 0x80000;
      return;
    }
  }
  
  private void mergeTimeSincePrevPacketMs(Metric paramMetric)
  {
    if ((this.timeSincePrevPacketMs_ != null) && (this.timeSincePrevPacketMs_ != Metric.getDefaultInstance())) {}
    for (this.timeSincePrevPacketMs_ = ((Metric)((UdpQualitySample.Metric.Builder)Metric.newBuilder(this.timeSincePrevPacketMs_).mergeFrom(paramMetric)).buildPartial());; this.timeSincePrevPacketMs_ = paramMetric)
    {
      this.bitField0_ |= 0x10000;
      return;
    }
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(UdpQualitySample paramUdpQualitySample)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramUdpQualitySample);
  }
  
  public static UdpQualitySample parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (UdpQualitySample)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UdpQualitySample parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (UdpQualitySample)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UdpQualitySample parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (UdpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static UdpQualitySample parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (UdpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static UdpQualitySample parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (UdpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static UdpQualitySample parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (UdpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static UdpQualitySample parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (UdpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UdpQualitySample parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (UdpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UdpQualitySample parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (UdpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static UdpQualitySample parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (UdpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<UdpQualitySample> parser()
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
  
  private void setBandwidthDownBps(float paramFloat)
  {
    this.bitField0_ |= 0x40000;
    this.bandwidthDownBps_ = paramFloat;
  }
  
  private void setBandwidthUpBps(float paramFloat)
  {
    this.bitField0_ |= 0x20000;
    this.bandwidthUpBps_ = paramFloat;
  }
  
  private void setBytesReceived(long paramLong)
  {
    this.bitField0_ |= 0x80;
    this.bytesReceived_ = paramLong;
  }
  
  private void setBytesSent(long paramLong)
  {
    this.bitField0_ |= 0x40;
    this.bytesSent_ = paramLong;
  }
  
  private void setFixedInterpolationDelayMs(float paramFloat)
  {
    this.bitField0_ |= 0x8000;
    this.fixedInterpolationDelayMs_ = paramFloat;
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
  
  private void setOutOfOrderOrDuplicatePacketsReceived(int paramInt)
  {
    this.bitField0_ |= 0x4000;
    this.outOfOrderOrDuplicatePacketsReceived_ = paramInt;
  }
  
  private void setPacketsLostReceive(int paramInt)
  {
    this.bitField0_ |= 0x2000;
    this.packetsLostReceive_ = paramInt;
  }
  
  private void setPacketsLostSend(int paramInt)
  {
    this.bitField0_ |= 0x1000;
    this.packetsLostSend_ = paramInt;
  }
  
  private void setPacketsReceived(int paramInt)
  {
    this.bitField0_ |= 0x800;
    this.packetsReceived_ = paramInt;
  }
  
  private void setPacketsSent(int paramInt)
  {
    this.bitField0_ |= 0x400;
    this.packetsSent_ = paramInt;
  }
  
  private void setPingMs(UdpQualitySample.Metric.Builder paramBuilder)
  {
    this.pingMs_ = ((Metric)paramBuilder.build());
    this.bitField0_ |= 0x80000;
  }
  
  private void setPingMs(Metric paramMetric)
  {
    if (paramMetric == null) {
      throw new NullPointerException();
    }
    this.pingMs_ = paramMetric;
    this.bitField0_ |= 0x80000;
  }
  
  private void setPort(int paramInt)
  {
    this.bitField0_ |= 0x8;
    this.port_ = paramInt;
  }
  
  private void setRoundtripTimeSmoothedMs(float paramFloat)
  {
    this.bitField0_ |= 0x100;
    this.roundtripTimeSmoothedMs_ = paramFloat;
  }
  
  private void setRoundtripTimeVarianceEstimate(float paramFloat)
  {
    this.bitField0_ |= 0x200;
    this.roundtripTimeVarianceEstimate_ = paramFloat;
  }
  
  private void setSampleTimeMs(float paramFloat)
  {
    this.bitField0_ |= 0x20;
    this.sampleTimeMs_ = paramFloat;
  }
  
  private void setSessionId(long paramLong)
  {
    this.bitField0_ |= 0x10;
    this.sessionId_ = paramLong;
  }
  
  private void setTimeSincePrevPacketMs(UdpQualitySample.Metric.Builder paramBuilder)
  {
    this.timeSincePrevPacketMs_ = ((Metric)paramBuilder.build());
    this.bitField0_ |= 0x10000;
  }
  
  private void setTimeSincePrevPacketMs(Metric paramMetric)
  {
    if (paramMetric == null) {
      throw new NullPointerException();
    }
    this.timeSincePrevPacketMs_ = paramMetric;
    this.bitField0_ |= 0x10000;
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 462	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 468	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+625->633, 7:+1457->1465, 8:+1461->1469
    //   56: new 470	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 471	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/blizzard/telemetry/proto/standard/network/UdpQualitySample
    //   67: dup
    //   68: invokespecial 96	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 98	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 474	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 476	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/blizzard/telemetry/proto/standard/network/UdpQualitySample
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 480	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasName	()Z
    //   105: aload_0
    //   106: getfield 107	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:name_	Ljava/lang/String;
    //   109: aload_3
    //   110: invokevirtual 480	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasName	()Z
    //   113: aload_3
    //   114: getfield 107	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:name_	Ljava/lang/String;
    //   117: invokeinterface 484 5 0
    //   122: putfield 107	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:name_	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 487	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasAddress4	()Z
    //   131: aload_0
    //   132: getfield 109	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:address4_	Ljava/lang/String;
    //   135: aload_3
    //   136: invokevirtual 487	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasAddress4	()Z
    //   139: aload_3
    //   140: getfield 109	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:address4_	Ljava/lang/String;
    //   143: invokeinterface 484 5 0
    //   148: putfield 109	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:address4_	Ljava/lang/String;
    //   151: aload_0
    //   152: aload_2
    //   153: aload_0
    //   154: invokevirtual 490	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasAddress6	()Z
    //   157: aload_0
    //   158: getfield 111	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:address6_	Ljava/lang/String;
    //   161: aload_3
    //   162: invokevirtual 490	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasAddress6	()Z
    //   165: aload_3
    //   166: getfield 111	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:address6_	Ljava/lang/String;
    //   169: invokeinterface 484 5 0
    //   174: putfield 111	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:address6_	Ljava/lang/String;
    //   177: aload_0
    //   178: aload_2
    //   179: aload_0
    //   180: invokevirtual 493	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPort	()Z
    //   183: aload_0
    //   184: getfield 357	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:port_	I
    //   187: aload_3
    //   188: invokevirtual 493	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPort	()Z
    //   191: aload_3
    //   192: getfield 357	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:port_	I
    //   195: invokeinterface 497 5 0
    //   200: putfield 357	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:port_	I
    //   203: aload_0
    //   204: aload_2
    //   205: aload_0
    //   206: invokevirtual 500	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasSessionId	()Z
    //   209: aload_0
    //   210: getfield 365	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:sessionId_	J
    //   213: aload_3
    //   214: invokevirtual 500	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasSessionId	()Z
    //   217: aload_3
    //   218: getfield 365	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:sessionId_	J
    //   221: invokeinterface 504 7 0
    //   226: putfield 365	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:sessionId_	J
    //   229: aload_0
    //   230: aload_2
    //   231: aload_0
    //   232: invokevirtual 507	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasSampleTimeMs	()Z
    //   235: aload_0
    //   236: getfield 363	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:sampleTimeMs_	F
    //   239: aload_3
    //   240: invokevirtual 507	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasSampleTimeMs	()Z
    //   243: aload_3
    //   244: getfield 363	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:sampleTimeMs_	F
    //   247: invokeinterface 511 5 0
    //   252: putfield 363	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:sampleTimeMs_	F
    //   255: aload_0
    //   256: aload_2
    //   257: aload_0
    //   258: invokevirtual 514	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasBytesSent	()Z
    //   261: aload_0
    //   262: getfield 336	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bytesSent_	J
    //   265: aload_3
    //   266: invokevirtual 514	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasBytesSent	()Z
    //   269: aload_3
    //   270: getfield 336	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bytesSent_	J
    //   273: invokeinterface 504 7 0
    //   278: putfield 336	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bytesSent_	J
    //   281: aload_0
    //   282: aload_2
    //   283: aload_0
    //   284: invokevirtual 517	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasBytesReceived	()Z
    //   287: aload_0
    //   288: getfield 334	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bytesReceived_	J
    //   291: aload_3
    //   292: invokevirtual 517	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasBytesReceived	()Z
    //   295: aload_3
    //   296: getfield 334	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bytesReceived_	J
    //   299: invokeinterface 504 7 0
    //   304: putfield 334	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bytesReceived_	J
    //   307: aload_0
    //   308: aload_2
    //   309: aload_0
    //   310: invokevirtual 520	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasRoundtripTimeSmoothedMs	()Z
    //   313: aload_0
    //   314: getfield 359	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:roundtripTimeSmoothedMs_	F
    //   317: aload_3
    //   318: invokevirtual 520	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasRoundtripTimeSmoothedMs	()Z
    //   321: aload_3
    //   322: getfield 359	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:roundtripTimeSmoothedMs_	F
    //   325: invokeinterface 511 5 0
    //   330: putfield 359	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:roundtripTimeSmoothedMs_	F
    //   333: aload_0
    //   334: aload_2
    //   335: aload_0
    //   336: invokevirtual 523	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasRoundtripTimeVarianceEstimate	()Z
    //   339: aload_0
    //   340: getfield 361	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:roundtripTimeVarianceEstimate_	F
    //   343: aload_3
    //   344: invokevirtual 523	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasRoundtripTimeVarianceEstimate	()Z
    //   347: aload_3
    //   348: getfield 361	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:roundtripTimeVarianceEstimate_	F
    //   351: invokeinterface 511 5 0
    //   356: putfield 361	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:roundtripTimeVarianceEstimate_	F
    //   359: aload_0
    //   360: aload_2
    //   361: aload_0
    //   362: invokevirtual 526	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPacketsSent	()Z
    //   365: aload_0
    //   366: getfield 352	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsSent_	I
    //   369: aload_3
    //   370: invokevirtual 526	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPacketsSent	()Z
    //   373: aload_3
    //   374: getfield 352	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsSent_	I
    //   377: invokeinterface 497 5 0
    //   382: putfield 352	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsSent_	I
    //   385: aload_0
    //   386: aload_2
    //   387: aload_0
    //   388: invokevirtual 529	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPacketsReceived	()Z
    //   391: aload_0
    //   392: getfield 350	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsReceived_	I
    //   395: aload_3
    //   396: invokevirtual 529	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPacketsReceived	()Z
    //   399: aload_3
    //   400: getfield 350	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsReceived_	I
    //   403: invokeinterface 497 5 0
    //   408: putfield 350	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsReceived_	I
    //   411: aload_0
    //   412: aload_2
    //   413: aload_0
    //   414: invokevirtual 532	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPacketsLostSend	()Z
    //   417: aload_0
    //   418: getfield 348	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsLostSend_	I
    //   421: aload_3
    //   422: invokevirtual 532	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPacketsLostSend	()Z
    //   425: aload_3
    //   426: getfield 348	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsLostSend_	I
    //   429: invokeinterface 497 5 0
    //   434: putfield 348	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsLostSend_	I
    //   437: aload_0
    //   438: aload_2
    //   439: aload_0
    //   440: invokevirtual 535	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPacketsLostReceive	()Z
    //   443: aload_0
    //   444: getfield 346	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsLostReceive_	I
    //   447: aload_3
    //   448: invokevirtual 535	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasPacketsLostReceive	()Z
    //   451: aload_3
    //   452: getfield 346	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsLostReceive_	I
    //   455: invokeinterface 497 5 0
    //   460: putfield 346	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsLostReceive_	I
    //   463: aload_0
    //   464: aload_2
    //   465: aload_0
    //   466: invokevirtual 538	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasOutOfOrderOrDuplicatePacketsReceived	()Z
    //   469: aload_0
    //   470: getfield 344	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:outOfOrderOrDuplicatePacketsReceived_	I
    //   473: aload_3
    //   474: invokevirtual 538	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasOutOfOrderOrDuplicatePacketsReceived	()Z
    //   477: aload_3
    //   478: getfield 344	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:outOfOrderOrDuplicatePacketsReceived_	I
    //   481: invokeinterface 497 5 0
    //   486: putfield 344	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:outOfOrderOrDuplicatePacketsReceived_	I
    //   489: aload_0
    //   490: aload_2
    //   491: aload_0
    //   492: invokevirtual 541	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasFixedInterpolationDelayMs	()Z
    //   495: aload_0
    //   496: getfield 339	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:fixedInterpolationDelayMs_	F
    //   499: aload_3
    //   500: invokevirtual 541	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasFixedInterpolationDelayMs	()Z
    //   503: aload_3
    //   504: getfield 339	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:fixedInterpolationDelayMs_	F
    //   507: invokeinterface 511 5 0
    //   512: putfield 339	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:fixedInterpolationDelayMs_	F
    //   515: aload_0
    //   516: aload_2
    //   517: aload_0
    //   518: getfield 367	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:timeSincePrevPacketMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   521: aload_3
    //   522: getfield 367	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:timeSincePrevPacketMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   525: invokeinterface 545 3 0
    //   530: checkcast 14	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric
    //   533: putfield 367	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:timeSincePrevPacketMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   536: aload_0
    //   537: aload_2
    //   538: aload_0
    //   539: invokevirtual 548	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasBandwidthUpBps	()Z
    //   542: aload_0
    //   543: getfield 332	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bandwidthUpBps_	F
    //   546: aload_3
    //   547: invokevirtual 548	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasBandwidthUpBps	()Z
    //   550: aload_3
    //   551: getfield 332	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bandwidthUpBps_	F
    //   554: invokeinterface 511 5 0
    //   559: putfield 332	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bandwidthUpBps_	F
    //   562: aload_0
    //   563: aload_2
    //   564: aload_0
    //   565: invokevirtual 551	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasBandwidthDownBps	()Z
    //   568: aload_0
    //   569: getfield 329	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bandwidthDownBps_	F
    //   572: aload_3
    //   573: invokevirtual 551	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:hasBandwidthDownBps	()Z
    //   576: aload_3
    //   577: getfield 329	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bandwidthDownBps_	F
    //   580: invokeinterface 511 5 0
    //   585: putfield 329	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bandwidthDownBps_	F
    //   588: aload_0
    //   589: aload_2
    //   590: aload_0
    //   591: getfield 354	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   594: aload_3
    //   595: getfield 354	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   598: invokeinterface 545 3 0
    //   603: checkcast 14	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric
    //   606: putfield 354	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   609: aload_0
    //   610: astore_1
    //   611: aload_2
    //   612: getstatic 557	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   615: if_acmpne -543 -> 72
    //   618: aload_0
    //   619: aload_0
    //   620: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   623: aload_3
    //   624: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   627: ior
    //   628: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   631: aload_0
    //   632: areturn
    //   633: aload_2
    //   634: checkcast 559	com/google/protobuf/CodedInputStream
    //   637: astore_2
    //   638: aload_3
    //   639: checkcast 561	com/google/protobuf/ExtensionRegistryLite
    //   642: astore_3
    //   643: iconst_0
    //   644: istore 4
    //   646: iload 4
    //   648: ifne +817 -> 1465
    //   651: aload_2
    //   652: invokevirtual 564	com/google/protobuf/CodedInputStream:readTag	()I
    //   655: istore 5
    //   657: iload 5
    //   659: lookupswitch	default:+851->1510, 0:+854->1513, 10:+193->852, 18:+233->892, 24:+280->939, 32:+302->961, 42:+324->983, 805:+347->1006, 808:+369->1028, 816:+391->1050, 829:+414->1073, 837:+437->1096, 840:+460->1119, 848:+483->1142, 856:+506->1165, 864:+529->1188, 872:+552->1211, 885:+575->1234, 890:+598->1257, 901:+679->1338, 909:+702->1361, 914:+725->1384
    //   836: aload_0
    //   837: iload 5
    //   839: aload_2
    //   840: invokevirtual 568	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   843: ifne -197 -> 646
    //   846: iconst_1
    //   847: istore 4
    //   849: goto -203 -> 646
    //   852: aload_2
    //   853: invokevirtual 571	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   856: astore_1
    //   857: aload_0
    //   858: aload_0
    //   859: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   862: iconst_1
    //   863: ior
    //   864: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   867: aload_0
    //   868: aload_1
    //   869: putfield 107	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:name_	Ljava/lang/String;
    //   872: goto -226 -> 646
    //   875: astore_1
    //   876: new 573	java/lang/RuntimeException
    //   879: dup
    //   880: aload_1
    //   881: aload_0
    //   882: invokevirtual 577	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   885: invokespecial 580	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   888: athrow
    //   889: astore_1
    //   890: aload_1
    //   891: athrow
    //   892: aload_2
    //   893: invokevirtual 571	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   896: astore_1
    //   897: aload_0
    //   898: aload_0
    //   899: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   902: iconst_2
    //   903: ior
    //   904: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   907: aload_0
    //   908: aload_1
    //   909: putfield 109	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:address4_	Ljava/lang/String;
    //   912: goto -266 -> 646
    //   915: astore_1
    //   916: new 573	java/lang/RuntimeException
    //   919: dup
    //   920: new 408	com/google/protobuf/InvalidProtocolBufferException
    //   923: dup
    //   924: aload_1
    //   925: invokevirtual 583	java/io/IOException:getMessage	()Ljava/lang/String;
    //   928: invokespecial 585	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   931: aload_0
    //   932: invokevirtual 577	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   935: invokespecial 580	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   938: athrow
    //   939: aload_0
    //   940: aload_0
    //   941: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   944: bipush 8
    //   946: ior
    //   947: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   950: aload_0
    //   951: aload_2
    //   952: invokevirtual 588	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   955: putfield 357	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:port_	I
    //   958: goto -312 -> 646
    //   961: aload_0
    //   962: aload_0
    //   963: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   966: bipush 16
    //   968: ior
    //   969: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   972: aload_0
    //   973: aload_2
    //   974: invokevirtual 592	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   977: putfield 365	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:sessionId_	J
    //   980: goto -334 -> 646
    //   983: aload_2
    //   984: invokevirtual 571	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   987: astore_1
    //   988: aload_0
    //   989: aload_0
    //   990: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   993: iconst_4
    //   994: ior
    //   995: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   998: aload_0
    //   999: aload_1
    //   1000: putfield 111	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:address6_	Ljava/lang/String;
    //   1003: goto -357 -> 646
    //   1006: aload_0
    //   1007: aload_0
    //   1008: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1011: bipush 32
    //   1013: ior
    //   1014: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1017: aload_0
    //   1018: aload_2
    //   1019: invokevirtual 596	com/google/protobuf/CodedInputStream:readFloat	()F
    //   1022: putfield 363	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:sampleTimeMs_	F
    //   1025: goto -379 -> 646
    //   1028: aload_0
    //   1029: aload_0
    //   1030: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1033: bipush 64
    //   1035: ior
    //   1036: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1039: aload_0
    //   1040: aload_2
    //   1041: invokevirtual 592	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   1044: putfield 336	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bytesSent_	J
    //   1047: goto -401 -> 646
    //   1050: aload_0
    //   1051: aload_0
    //   1052: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1055: sipush 128
    //   1058: ior
    //   1059: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1062: aload_0
    //   1063: aload_2
    //   1064: invokevirtual 592	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   1067: putfield 334	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bytesReceived_	J
    //   1070: goto -424 -> 646
    //   1073: aload_0
    //   1074: aload_0
    //   1075: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1078: sipush 256
    //   1081: ior
    //   1082: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1085: aload_0
    //   1086: aload_2
    //   1087: invokevirtual 596	com/google/protobuf/CodedInputStream:readFloat	()F
    //   1090: putfield 359	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:roundtripTimeSmoothedMs_	F
    //   1093: goto -447 -> 646
    //   1096: aload_0
    //   1097: aload_0
    //   1098: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1101: sipush 512
    //   1104: ior
    //   1105: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1108: aload_0
    //   1109: aload_2
    //   1110: invokevirtual 596	com/google/protobuf/CodedInputStream:readFloat	()F
    //   1113: putfield 361	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:roundtripTimeVarianceEstimate_	F
    //   1116: goto -470 -> 646
    //   1119: aload_0
    //   1120: aload_0
    //   1121: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1124: sipush 1024
    //   1127: ior
    //   1128: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1131: aload_0
    //   1132: aload_2
    //   1133: invokevirtual 588	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   1136: putfield 352	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsSent_	I
    //   1139: goto -493 -> 646
    //   1142: aload_0
    //   1143: aload_0
    //   1144: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1147: sipush 2048
    //   1150: ior
    //   1151: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1154: aload_0
    //   1155: aload_2
    //   1156: invokevirtual 588	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   1159: putfield 350	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsReceived_	I
    //   1162: goto -516 -> 646
    //   1165: aload_0
    //   1166: aload_0
    //   1167: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1170: sipush 4096
    //   1173: ior
    //   1174: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1177: aload_0
    //   1178: aload_2
    //   1179: invokevirtual 588	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   1182: putfield 348	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsLostSend_	I
    //   1185: goto -539 -> 646
    //   1188: aload_0
    //   1189: aload_0
    //   1190: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1193: sipush 8192
    //   1196: ior
    //   1197: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1200: aload_0
    //   1201: aload_2
    //   1202: invokevirtual 588	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   1205: putfield 346	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:packetsLostReceive_	I
    //   1208: goto -562 -> 646
    //   1211: aload_0
    //   1212: aload_0
    //   1213: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1216: sipush 16384
    //   1219: ior
    //   1220: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1223: aload_0
    //   1224: aload_2
    //   1225: invokevirtual 588	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   1228: putfield 344	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:outOfOrderOrDuplicatePacketsReceived_	I
    //   1231: goto -585 -> 646
    //   1234: aload_0
    //   1235: aload_0
    //   1236: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1239: ldc_w 453
    //   1242: ior
    //   1243: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1246: aload_0
    //   1247: aload_2
    //   1248: invokevirtual 596	com/google/protobuf/CodedInputStream:readFloat	()F
    //   1251: putfield 339	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:fixedInterpolationDelayMs_	F
    //   1254: goto -608 -> 646
    //   1257: aconst_null
    //   1258: astore_1
    //   1259: aload_0
    //   1260: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1263: ldc_w 385
    //   1266: iand
    //   1267: ldc_w 385
    //   1270: if_icmpne +14 -> 1284
    //   1273: aload_0
    //   1274: getfield 367	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:timeSincePrevPacketMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   1277: invokevirtual 597	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1280: checkcast 17	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric$Builder
    //   1283: astore_1
    //   1284: aload_0
    //   1285: aload_2
    //   1286: invokestatic 599	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:parser	()Lcom/google/protobuf/Parser;
    //   1289: aload_3
    //   1290: invokevirtual 603	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1293: checkcast 14	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric
    //   1296: putfield 367	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:timeSincePrevPacketMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   1299: aload_1
    //   1300: ifnull +23 -> 1323
    //   1303: aload_1
    //   1304: aload_0
    //   1305: getfield 367	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:timeSincePrevPacketMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   1308: invokevirtual 379	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1311: pop
    //   1312: aload_0
    //   1313: aload_1
    //   1314: invokevirtual 383	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   1317: checkcast 14	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric
    //   1320: putfield 367	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:timeSincePrevPacketMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   1323: aload_0
    //   1324: aload_0
    //   1325: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1328: ldc_w 385
    //   1331: ior
    //   1332: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1335: goto -689 -> 646
    //   1338: aload_0
    //   1339: aload_0
    //   1340: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1343: ldc_w 452
    //   1346: ior
    //   1347: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1350: aload_0
    //   1351: aload_2
    //   1352: invokevirtual 596	com/google/protobuf/CodedInputStream:readFloat	()F
    //   1355: putfield 332	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bandwidthUpBps_	F
    //   1358: goto -712 -> 646
    //   1361: aload_0
    //   1362: aload_0
    //   1363: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1366: ldc_w 451
    //   1369: ior
    //   1370: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1373: aload_0
    //   1374: aload_2
    //   1375: invokevirtual 596	com/google/protobuf/CodedInputStream:readFloat	()F
    //   1378: putfield 329	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bandwidthDownBps_	F
    //   1381: goto -735 -> 646
    //   1384: aconst_null
    //   1385: astore_1
    //   1386: aload_0
    //   1387: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1390: ldc_w 384
    //   1393: iand
    //   1394: ldc_w 384
    //   1397: if_icmpne +14 -> 1411
    //   1400: aload_0
    //   1401: getfield 354	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   1404: invokevirtual 597	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1407: checkcast 17	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric$Builder
    //   1410: astore_1
    //   1411: aload_0
    //   1412: aload_2
    //   1413: invokestatic 599	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:parser	()Lcom/google/protobuf/Parser;
    //   1416: aload_3
    //   1417: invokevirtual 603	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1420: checkcast 14	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric
    //   1423: putfield 354	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   1426: aload_1
    //   1427: ifnull +23 -> 1450
    //   1430: aload_1
    //   1431: aload_0
    //   1432: getfield 354	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   1435: invokevirtual 379	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1438: pop
    //   1439: aload_0
    //   1440: aload_1
    //   1441: invokevirtual 383	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   1444: checkcast 14	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric
    //   1447: putfield 354	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
    //   1450: aload_0
    //   1451: aload_0
    //   1452: getfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1455: ldc_w 384
    //   1458: ior
    //   1459: putfield 316	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:bitField0_	I
    //   1462: goto -816 -> 646
    //   1465: getstatic 98	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample;
    //   1468: areturn
    //   1469: getstatic 605	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:PARSER	Lcom/google/protobuf/Parser;
    //   1472: ifnonnull +28 -> 1500
    //   1475: ldc 2
    //   1477: monitorenter
    //   1478: getstatic 605	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:PARSER	Lcom/google/protobuf/Parser;
    //   1481: ifnonnull +16 -> 1497
    //   1484: new 607	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   1487: dup
    //   1488: getstatic 98	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample;
    //   1491: invokespecial 610	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   1494: putstatic 605	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:PARSER	Lcom/google/protobuf/Parser;
    //   1497: ldc 2
    //   1499: monitorexit
    //   1500: getstatic 605	com/blizzard/telemetry/proto/standard/network/UdpQualitySample:PARSER	Lcom/google/protobuf/Parser;
    //   1503: areturn
    //   1504: astore_1
    //   1505: ldc 2
    //   1507: monitorexit
    //   1508: aload_1
    //   1509: athrow
    //   1510: goto -674 -> 836
    //   1513: iconst_1
    //   1514: istore 4
    //   1516: goto -870 -> 646
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1519	0	this	UdpQualitySample
    //   0	1519	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	1519	2	paramObject1	Object
    //   0	1519	3	paramObject2	Object
    //   644	871	4	i	int
    //   655	183	5	j	int
    // Exception table:
    //   from	to	target	type
    //   651	657	875	com/google/protobuf/InvalidProtocolBufferException
    //   836	846	875	com/google/protobuf/InvalidProtocolBufferException
    //   852	872	875	com/google/protobuf/InvalidProtocolBufferException
    //   892	912	875	com/google/protobuf/InvalidProtocolBufferException
    //   939	958	875	com/google/protobuf/InvalidProtocolBufferException
    //   961	980	875	com/google/protobuf/InvalidProtocolBufferException
    //   983	1003	875	com/google/protobuf/InvalidProtocolBufferException
    //   1006	1025	875	com/google/protobuf/InvalidProtocolBufferException
    //   1028	1047	875	com/google/protobuf/InvalidProtocolBufferException
    //   1050	1070	875	com/google/protobuf/InvalidProtocolBufferException
    //   1073	1093	875	com/google/protobuf/InvalidProtocolBufferException
    //   1096	1116	875	com/google/protobuf/InvalidProtocolBufferException
    //   1119	1139	875	com/google/protobuf/InvalidProtocolBufferException
    //   1142	1162	875	com/google/protobuf/InvalidProtocolBufferException
    //   1165	1185	875	com/google/protobuf/InvalidProtocolBufferException
    //   1188	1208	875	com/google/protobuf/InvalidProtocolBufferException
    //   1211	1231	875	com/google/protobuf/InvalidProtocolBufferException
    //   1234	1254	875	com/google/protobuf/InvalidProtocolBufferException
    //   1259	1284	875	com/google/protobuf/InvalidProtocolBufferException
    //   1284	1299	875	com/google/protobuf/InvalidProtocolBufferException
    //   1303	1323	875	com/google/protobuf/InvalidProtocolBufferException
    //   1323	1335	875	com/google/protobuf/InvalidProtocolBufferException
    //   1338	1358	875	com/google/protobuf/InvalidProtocolBufferException
    //   1361	1381	875	com/google/protobuf/InvalidProtocolBufferException
    //   1386	1411	875	com/google/protobuf/InvalidProtocolBufferException
    //   1411	1426	875	com/google/protobuf/InvalidProtocolBufferException
    //   1430	1450	875	com/google/protobuf/InvalidProtocolBufferException
    //   1450	1462	875	com/google/protobuf/InvalidProtocolBufferException
    //   651	657	889	finally
    //   836	846	889	finally
    //   852	872	889	finally
    //   876	889	889	finally
    //   892	912	889	finally
    //   916	939	889	finally
    //   939	958	889	finally
    //   961	980	889	finally
    //   983	1003	889	finally
    //   1006	1025	889	finally
    //   1028	1047	889	finally
    //   1050	1070	889	finally
    //   1073	1093	889	finally
    //   1096	1116	889	finally
    //   1119	1139	889	finally
    //   1142	1162	889	finally
    //   1165	1185	889	finally
    //   1188	1208	889	finally
    //   1211	1231	889	finally
    //   1234	1254	889	finally
    //   1259	1284	889	finally
    //   1284	1299	889	finally
    //   1303	1323	889	finally
    //   1323	1335	889	finally
    //   1338	1358	889	finally
    //   1361	1381	889	finally
    //   1386	1411	889	finally
    //   1411	1426	889	finally
    //   1430	1450	889	finally
    //   1450	1462	889	finally
    //   651	657	915	java/io/IOException
    //   836	846	915	java/io/IOException
    //   852	872	915	java/io/IOException
    //   892	912	915	java/io/IOException
    //   939	958	915	java/io/IOException
    //   961	980	915	java/io/IOException
    //   983	1003	915	java/io/IOException
    //   1006	1025	915	java/io/IOException
    //   1028	1047	915	java/io/IOException
    //   1050	1070	915	java/io/IOException
    //   1073	1093	915	java/io/IOException
    //   1096	1116	915	java/io/IOException
    //   1119	1139	915	java/io/IOException
    //   1142	1162	915	java/io/IOException
    //   1165	1185	915	java/io/IOException
    //   1188	1208	915	java/io/IOException
    //   1211	1231	915	java/io/IOException
    //   1234	1254	915	java/io/IOException
    //   1259	1284	915	java/io/IOException
    //   1284	1299	915	java/io/IOException
    //   1303	1323	915	java/io/IOException
    //   1323	1335	915	java/io/IOException
    //   1338	1358	915	java/io/IOException
    //   1361	1381	915	java/io/IOException
    //   1386	1411	915	java/io/IOException
    //   1411	1426	915	java/io/IOException
    //   1430	1450	915	java/io/IOException
    //   1450	1462	915	java/io/IOException
    //   1478	1497	1504	finally
    //   1497	1500	1504	finally
    //   1505	1508	1504	finally
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
  
  public float getBandwidthDownBps()
  {
    return this.bandwidthDownBps_;
  }
  
  public float getBandwidthUpBps()
  {
    return this.bandwidthUpBps_;
  }
  
  public long getBytesReceived()
  {
    return this.bytesReceived_;
  }
  
  public long getBytesSent()
  {
    return this.bytesSent_;
  }
  
  public float getFixedInterpolationDelayMs()
  {
    return this.fixedInterpolationDelayMs_;
  }
  
  public String getName()
  {
    return this.name_;
  }
  
  public ByteString getNameBytes()
  {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getOutOfOrderOrDuplicatePacketsReceived()
  {
    return this.outOfOrderOrDuplicatePacketsReceived_;
  }
  
  public int getPacketsLostReceive()
  {
    return this.packetsLostReceive_;
  }
  
  public int getPacketsLostSend()
  {
    return this.packetsLostSend_;
  }
  
  public int getPacketsReceived()
  {
    return this.packetsReceived_;
  }
  
  public int getPacketsSent()
  {
    return this.packetsSent_;
  }
  
  public Metric getPingMs()
  {
    if (this.pingMs_ == null) {
      return Metric.getDefaultInstance();
    }
    return this.pingMs_;
  }
  
  public int getPort()
  {
    return this.port_;
  }
  
  public float getRoundtripTimeSmoothedMs()
  {
    return this.roundtripTimeSmoothedMs_;
  }
  
  public float getRoundtripTimeVarianceEstimate()
  {
    return this.roundtripTimeVarianceEstimate_;
  }
  
  public float getSampleTimeMs()
  {
    return this.sampleTimeMs_;
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
    if ((this.bitField0_ & 0x8) == 8) {
      j = i + CodedOutputStream.computeUInt32Size(3, this.port_);
    }
    i = j;
    if ((this.bitField0_ & 0x10) == 16) {
      i = j + CodedOutputStream.computeUInt64Size(4, this.sessionId_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeStringSize(5, getAddress6());
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + CodedOutputStream.computeFloatSize(100, this.sampleTimeMs_);
    }
    j = i;
    if ((this.bitField0_ & 0x40) == 64) {
      j = i + CodedOutputStream.computeUInt64Size(101, this.bytesSent_);
    }
    i = j;
    if ((this.bitField0_ & 0x80) == 128) {
      i = j + CodedOutputStream.computeUInt64Size(102, this.bytesReceived_);
    }
    j = i;
    if ((this.bitField0_ & 0x100) == 256) {
      j = i + CodedOutputStream.computeFloatSize(103, this.roundtripTimeSmoothedMs_);
    }
    i = j;
    if ((this.bitField0_ & 0x200) == 512) {
      i = j + CodedOutputStream.computeFloatSize(104, this.roundtripTimeVarianceEstimate_);
    }
    j = i;
    if ((this.bitField0_ & 0x400) == 1024) {
      j = i + CodedOutputStream.computeUInt32Size(105, this.packetsSent_);
    }
    i = j;
    if ((this.bitField0_ & 0x800) == 2048) {
      i = j + CodedOutputStream.computeUInt32Size(106, this.packetsReceived_);
    }
    j = i;
    if ((this.bitField0_ & 0x1000) == 4096) {
      j = i + CodedOutputStream.computeUInt32Size(107, this.packetsLostSend_);
    }
    i = j;
    if ((this.bitField0_ & 0x2000) == 8192) {
      i = j + CodedOutputStream.computeUInt32Size(108, this.packetsLostReceive_);
    }
    j = i;
    if ((this.bitField0_ & 0x4000) == 16384) {
      j = i + CodedOutputStream.computeUInt32Size(109, this.outOfOrderOrDuplicatePacketsReceived_);
    }
    i = j;
    if ((this.bitField0_ & 0x8000) == 32768) {
      i = j + CodedOutputStream.computeFloatSize(110, this.fixedInterpolationDelayMs_);
    }
    j = i;
    if ((this.bitField0_ & 0x10000) == 65536) {
      j = i + CodedOutputStream.computeMessageSize(111, getTimeSincePrevPacketMs());
    }
    i = j;
    if ((this.bitField0_ & 0x20000) == 131072) {
      i = j + CodedOutputStream.computeFloatSize(112, this.bandwidthUpBps_);
    }
    j = i;
    if ((this.bitField0_ & 0x40000) == 262144) {
      j = i + CodedOutputStream.computeFloatSize(113, this.bandwidthDownBps_);
    }
    i = j;
    if ((this.bitField0_ & 0x80000) == 524288) {
      i = j + CodedOutputStream.computeMessageSize(114, getPingMs());
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public long getSessionId()
  {
    return this.sessionId_;
  }
  
  public Metric getTimeSincePrevPacketMs()
  {
    if (this.timeSincePrevPacketMs_ == null) {
      return Metric.getDefaultInstance();
    }
    return this.timeSincePrevPacketMs_;
  }
  
  public boolean hasAddress4()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasAddress6()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasBandwidthDownBps()
  {
    return (this.bitField0_ & 0x40000) == 262144;
  }
  
  public boolean hasBandwidthUpBps()
  {
    return (this.bitField0_ & 0x20000) == 131072;
  }
  
  public boolean hasBytesReceived()
  {
    return (this.bitField0_ & 0x80) == 128;
  }
  
  public boolean hasBytesSent()
  {
    return (this.bitField0_ & 0x40) == 64;
  }
  
  public boolean hasFixedInterpolationDelayMs()
  {
    return (this.bitField0_ & 0x8000) == 32768;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasOutOfOrderOrDuplicatePacketsReceived()
  {
    return (this.bitField0_ & 0x4000) == 16384;
  }
  
  public boolean hasPacketsLostReceive()
  {
    return (this.bitField0_ & 0x2000) == 8192;
  }
  
  public boolean hasPacketsLostSend()
  {
    return (this.bitField0_ & 0x1000) == 4096;
  }
  
  public boolean hasPacketsReceived()
  {
    return (this.bitField0_ & 0x800) == 2048;
  }
  
  public boolean hasPacketsSent()
  {
    return (this.bitField0_ & 0x400) == 1024;
  }
  
  public boolean hasPingMs()
  {
    return (this.bitField0_ & 0x80000) == 524288;
  }
  
  public boolean hasPort()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasRoundtripTimeSmoothedMs()
  {
    return (this.bitField0_ & 0x100) == 256;
  }
  
  public boolean hasRoundtripTimeVarianceEstimate()
  {
    return (this.bitField0_ & 0x200) == 512;
  }
  
  public boolean hasSampleTimeMs()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasSessionId()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasTimeSincePrevPacketMs()
  {
    return (this.bitField0_ & 0x10000) == 65536;
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
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeUInt32(3, this.port_);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeUInt64(4, this.sessionId_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeString(5, getAddress6());
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeFloat(100, this.sampleTimeMs_);
    }
    if ((this.bitField0_ & 0x40) == 64) {
      paramCodedOutputStream.writeUInt64(101, this.bytesSent_);
    }
    if ((this.bitField0_ & 0x80) == 128) {
      paramCodedOutputStream.writeUInt64(102, this.bytesReceived_);
    }
    if ((this.bitField0_ & 0x100) == 256) {
      paramCodedOutputStream.writeFloat(103, this.roundtripTimeSmoothedMs_);
    }
    if ((this.bitField0_ & 0x200) == 512) {
      paramCodedOutputStream.writeFloat(104, this.roundtripTimeVarianceEstimate_);
    }
    if ((this.bitField0_ & 0x400) == 1024) {
      paramCodedOutputStream.writeUInt32(105, this.packetsSent_);
    }
    if ((this.bitField0_ & 0x800) == 2048) {
      paramCodedOutputStream.writeUInt32(106, this.packetsReceived_);
    }
    if ((this.bitField0_ & 0x1000) == 4096) {
      paramCodedOutputStream.writeUInt32(107, this.packetsLostSend_);
    }
    if ((this.bitField0_ & 0x2000) == 8192) {
      paramCodedOutputStream.writeUInt32(108, this.packetsLostReceive_);
    }
    if ((this.bitField0_ & 0x4000) == 16384) {
      paramCodedOutputStream.writeUInt32(109, this.outOfOrderOrDuplicatePacketsReceived_);
    }
    if ((this.bitField0_ & 0x8000) == 32768) {
      paramCodedOutputStream.writeFloat(110, this.fixedInterpolationDelayMs_);
    }
    if ((this.bitField0_ & 0x10000) == 65536) {
      paramCodedOutputStream.writeMessage(111, getTimeSincePrevPacketMs());
    }
    if ((this.bitField0_ & 0x20000) == 131072) {
      paramCodedOutputStream.writeFloat(112, this.bandwidthUpBps_);
    }
    if ((this.bitField0_ & 0x40000) == 262144) {
      paramCodedOutputStream.writeFloat(113, this.bandwidthDownBps_);
    }
    if ((this.bitField0_ & 0x80000) == 524288) {
      paramCodedOutputStream.writeMessage(114, getPingMs());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<UdpQualitySample, Builder>
    implements UdpQualitySampleOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearAddress4()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearAddress4();
      return this;
    }
    
    public Builder clearAddress6()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearAddress6();
      return this;
    }
    
    public Builder clearBandwidthDownBps()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearBandwidthDownBps();
      return this;
    }
    
    public Builder clearBandwidthUpBps()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearBandwidthUpBps();
      return this;
    }
    
    public Builder clearBytesReceived()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearBytesReceived();
      return this;
    }
    
    public Builder clearBytesSent()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearBytesSent();
      return this;
    }
    
    public Builder clearFixedInterpolationDelayMs()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearFixedInterpolationDelayMs();
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearName();
      return this;
    }
    
    public Builder clearOutOfOrderOrDuplicatePacketsReceived()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearOutOfOrderOrDuplicatePacketsReceived();
      return this;
    }
    
    public Builder clearPacketsLostReceive()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearPacketsLostReceive();
      return this;
    }
    
    public Builder clearPacketsLostSend()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearPacketsLostSend();
      return this;
    }
    
    public Builder clearPacketsReceived()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearPacketsReceived();
      return this;
    }
    
    public Builder clearPacketsSent()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearPacketsSent();
      return this;
    }
    
    public Builder clearPingMs()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearPingMs();
      return this;
    }
    
    public Builder clearPort()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearPort();
      return this;
    }
    
    public Builder clearRoundtripTimeSmoothedMs()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearRoundtripTimeSmoothedMs();
      return this;
    }
    
    public Builder clearRoundtripTimeVarianceEstimate()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearRoundtripTimeVarianceEstimate();
      return this;
    }
    
    public Builder clearSampleTimeMs()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearSampleTimeMs();
      return this;
    }
    
    public Builder clearSessionId()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearSessionId();
      return this;
    }
    
    public Builder clearTimeSincePrevPacketMs()
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).clearTimeSincePrevPacketMs();
      return this;
    }
    
    public String getAddress4()
    {
      return ((UdpQualitySample)this.instance).getAddress4();
    }
    
    public ByteString getAddress4Bytes()
    {
      return ((UdpQualitySample)this.instance).getAddress4Bytes();
    }
    
    public String getAddress6()
    {
      return ((UdpQualitySample)this.instance).getAddress6();
    }
    
    public ByteString getAddress6Bytes()
    {
      return ((UdpQualitySample)this.instance).getAddress6Bytes();
    }
    
    public float getBandwidthDownBps()
    {
      return ((UdpQualitySample)this.instance).getBandwidthDownBps();
    }
    
    public float getBandwidthUpBps()
    {
      return ((UdpQualitySample)this.instance).getBandwidthUpBps();
    }
    
    public long getBytesReceived()
    {
      return ((UdpQualitySample)this.instance).getBytesReceived();
    }
    
    public long getBytesSent()
    {
      return ((UdpQualitySample)this.instance).getBytesSent();
    }
    
    public float getFixedInterpolationDelayMs()
    {
      return ((UdpQualitySample)this.instance).getFixedInterpolationDelayMs();
    }
    
    public String getName()
    {
      return ((UdpQualitySample)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((UdpQualitySample)this.instance).getNameBytes();
    }
    
    public int getOutOfOrderOrDuplicatePacketsReceived()
    {
      return ((UdpQualitySample)this.instance).getOutOfOrderOrDuplicatePacketsReceived();
    }
    
    public int getPacketsLostReceive()
    {
      return ((UdpQualitySample)this.instance).getPacketsLostReceive();
    }
    
    public int getPacketsLostSend()
    {
      return ((UdpQualitySample)this.instance).getPacketsLostSend();
    }
    
    public int getPacketsReceived()
    {
      return ((UdpQualitySample)this.instance).getPacketsReceived();
    }
    
    public int getPacketsSent()
    {
      return ((UdpQualitySample)this.instance).getPacketsSent();
    }
    
    public UdpQualitySample.Metric getPingMs()
    {
      return ((UdpQualitySample)this.instance).getPingMs();
    }
    
    public int getPort()
    {
      return ((UdpQualitySample)this.instance).getPort();
    }
    
    public float getRoundtripTimeSmoothedMs()
    {
      return ((UdpQualitySample)this.instance).getRoundtripTimeSmoothedMs();
    }
    
    public float getRoundtripTimeVarianceEstimate()
    {
      return ((UdpQualitySample)this.instance).getRoundtripTimeVarianceEstimate();
    }
    
    public float getSampleTimeMs()
    {
      return ((UdpQualitySample)this.instance).getSampleTimeMs();
    }
    
    public long getSessionId()
    {
      return ((UdpQualitySample)this.instance).getSessionId();
    }
    
    public UdpQualitySample.Metric getTimeSincePrevPacketMs()
    {
      return ((UdpQualitySample)this.instance).getTimeSincePrevPacketMs();
    }
    
    public boolean hasAddress4()
    {
      return ((UdpQualitySample)this.instance).hasAddress4();
    }
    
    public boolean hasAddress6()
    {
      return ((UdpQualitySample)this.instance).hasAddress6();
    }
    
    public boolean hasBandwidthDownBps()
    {
      return ((UdpQualitySample)this.instance).hasBandwidthDownBps();
    }
    
    public boolean hasBandwidthUpBps()
    {
      return ((UdpQualitySample)this.instance).hasBandwidthUpBps();
    }
    
    public boolean hasBytesReceived()
    {
      return ((UdpQualitySample)this.instance).hasBytesReceived();
    }
    
    public boolean hasBytesSent()
    {
      return ((UdpQualitySample)this.instance).hasBytesSent();
    }
    
    public boolean hasFixedInterpolationDelayMs()
    {
      return ((UdpQualitySample)this.instance).hasFixedInterpolationDelayMs();
    }
    
    public boolean hasName()
    {
      return ((UdpQualitySample)this.instance).hasName();
    }
    
    public boolean hasOutOfOrderOrDuplicatePacketsReceived()
    {
      return ((UdpQualitySample)this.instance).hasOutOfOrderOrDuplicatePacketsReceived();
    }
    
    public boolean hasPacketsLostReceive()
    {
      return ((UdpQualitySample)this.instance).hasPacketsLostReceive();
    }
    
    public boolean hasPacketsLostSend()
    {
      return ((UdpQualitySample)this.instance).hasPacketsLostSend();
    }
    
    public boolean hasPacketsReceived()
    {
      return ((UdpQualitySample)this.instance).hasPacketsReceived();
    }
    
    public boolean hasPacketsSent()
    {
      return ((UdpQualitySample)this.instance).hasPacketsSent();
    }
    
    public boolean hasPingMs()
    {
      return ((UdpQualitySample)this.instance).hasPingMs();
    }
    
    public boolean hasPort()
    {
      return ((UdpQualitySample)this.instance).hasPort();
    }
    
    public boolean hasRoundtripTimeSmoothedMs()
    {
      return ((UdpQualitySample)this.instance).hasRoundtripTimeSmoothedMs();
    }
    
    public boolean hasRoundtripTimeVarianceEstimate()
    {
      return ((UdpQualitySample)this.instance).hasRoundtripTimeVarianceEstimate();
    }
    
    public boolean hasSampleTimeMs()
    {
      return ((UdpQualitySample)this.instance).hasSampleTimeMs();
    }
    
    public boolean hasSessionId()
    {
      return ((UdpQualitySample)this.instance).hasSessionId();
    }
    
    public boolean hasTimeSincePrevPacketMs()
    {
      return ((UdpQualitySample)this.instance).hasTimeSincePrevPacketMs();
    }
    
    public Builder mergePingMs(UdpQualitySample.Metric paramMetric)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).mergePingMs(paramMetric);
      return this;
    }
    
    public Builder mergeTimeSincePrevPacketMs(UdpQualitySample.Metric paramMetric)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).mergeTimeSincePrevPacketMs(paramMetric);
      return this;
    }
    
    public Builder setAddress4(String paramString)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setAddress4(paramString);
      return this;
    }
    
    public Builder setAddress4Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setAddress4Bytes(paramByteString);
      return this;
    }
    
    public Builder setAddress6(String paramString)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setAddress6(paramString);
      return this;
    }
    
    public Builder setAddress6Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setAddress6Bytes(paramByteString);
      return this;
    }
    
    public Builder setBandwidthDownBps(float paramFloat)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setBandwidthDownBps(paramFloat);
      return this;
    }
    
    public Builder setBandwidthUpBps(float paramFloat)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setBandwidthUpBps(paramFloat);
      return this;
    }
    
    public Builder setBytesReceived(long paramLong)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setBytesReceived(paramLong);
      return this;
    }
    
    public Builder setBytesSent(long paramLong)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setBytesSent(paramLong);
      return this;
    }
    
    public Builder setFixedInterpolationDelayMs(float paramFloat)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setFixedInterpolationDelayMs(paramFloat);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setOutOfOrderOrDuplicatePacketsReceived(int paramInt)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setOutOfOrderOrDuplicatePacketsReceived(paramInt);
      return this;
    }
    
    public Builder setPacketsLostReceive(int paramInt)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setPacketsLostReceive(paramInt);
      return this;
    }
    
    public Builder setPacketsLostSend(int paramInt)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setPacketsLostSend(paramInt);
      return this;
    }
    
    public Builder setPacketsReceived(int paramInt)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setPacketsReceived(paramInt);
      return this;
    }
    
    public Builder setPacketsSent(int paramInt)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setPacketsSent(paramInt);
      return this;
    }
    
    public Builder setPingMs(UdpQualitySample.Metric.Builder paramBuilder)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setPingMs(paramBuilder);
      return this;
    }
    
    public Builder setPingMs(UdpQualitySample.Metric paramMetric)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setPingMs(paramMetric);
      return this;
    }
    
    public Builder setPort(int paramInt)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setPort(paramInt);
      return this;
    }
    
    public Builder setRoundtripTimeSmoothedMs(float paramFloat)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setRoundtripTimeSmoothedMs(paramFloat);
      return this;
    }
    
    public Builder setRoundtripTimeVarianceEstimate(float paramFloat)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setRoundtripTimeVarianceEstimate(paramFloat);
      return this;
    }
    
    public Builder setSampleTimeMs(float paramFloat)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setSampleTimeMs(paramFloat);
      return this;
    }
    
    public Builder setSessionId(long paramLong)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setSessionId(paramLong);
      return this;
    }
    
    public Builder setTimeSincePrevPacketMs(UdpQualitySample.Metric.Builder paramBuilder)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setTimeSincePrevPacketMs(paramBuilder);
      return this;
    }
    
    public Builder setTimeSincePrevPacketMs(UdpQualitySample.Metric paramMetric)
    {
      copyOnWrite();
      ((UdpQualitySample)this.instance).setTimeSincePrevPacketMs(paramMetric);
      return this;
    }
  }
  
  public static final class Metric
    extends GeneratedMessageLite<Metric, Builder>
    implements UdpQualitySample.MetricOrBuilder
  {
    public static final int AVG_FIELD_NUMBER = 2;
    private static final Metric DEFAULT_INSTANCE = new Metric();
    public static final int MAX_FIELD_NUMBER = 3;
    public static final int MIN_FIELD_NUMBER = 1;
    private static volatile Parser<Metric> PARSER;
    public static final int STD_DEV_FIELD_NUMBER = 4;
    private float avg_;
    private int bitField0_;
    private float max_;
    private float min_;
    private float stdDev_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAvg()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.avg_ = 0.0F;
    }
    
    private void clearMax()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.max_ = 0.0F;
    }
    
    private void clearMin()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.min_ = 0.0F;
    }
    
    private void clearStdDev()
    {
      this.bitField0_ &= 0xFFFFFFF7;
      this.stdDev_ = 0.0F;
    }
    
    public static Metric getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Metric paramMetric)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMetric);
    }
    
    public static Metric parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Metric)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Metric parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Metric)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Metric parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (Metric)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static Metric parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Metric)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static Metric parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (Metric)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static Metric parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Metric)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static Metric parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (Metric)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static Metric parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (Metric)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static Metric parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (Metric)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static Metric parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (Metric)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<Metric> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAvg(float paramFloat)
    {
      this.bitField0_ |= 0x2;
      this.avg_ = paramFloat;
    }
    
    private void setMax(float paramFloat)
    {
      this.bitField0_ |= 0x4;
      this.max_ = paramFloat;
    }
    
    private void setMin(float paramFloat)
    {
      this.bitField0_ |= 0x1;
      this.min_ = paramFloat;
    }
    
    private void setStdDev(float paramFloat)
    {
      this.bitField0_ |= 0x8;
      this.stdDev_ = paramFloat;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 162	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 168	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+219->227, 7:+438->446, 8:+442->450
      //   56: new 170	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 171	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric
      //   67: dup
      //   68: invokespecial 38	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 40	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 174	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 176	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 180	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:hasMin	()Z
      //   105: aload_0
      //   106: getfield 90	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:min_	F
      //   109: aload_3
      //   110: invokevirtual 180	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:hasMin	()Z
      //   113: aload_3
      //   114: getfield 90	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:min_	F
      //   117: invokeinterface 184 5 0
      //   122: putfield 90	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:min_	F
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 187	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:hasAvg	()Z
      //   131: aload_0
      //   132: getfield 86	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:avg_	F
      //   135: aload_3
      //   136: invokevirtual 187	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:hasAvg	()Z
      //   139: aload_3
      //   140: getfield 86	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:avg_	F
      //   143: invokeinterface 184 5 0
      //   148: putfield 86	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:avg_	F
      //   151: aload_0
      //   152: aload_2
      //   153: aload_0
      //   154: invokevirtual 190	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:hasMax	()Z
      //   157: aload_0
      //   158: getfield 88	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:max_	F
      //   161: aload_3
      //   162: invokevirtual 190	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:hasMax	()Z
      //   165: aload_3
      //   166: getfield 88	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:max_	F
      //   169: invokeinterface 184 5 0
      //   174: putfield 88	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:max_	F
      //   177: aload_0
      //   178: aload_2
      //   179: aload_0
      //   180: invokevirtual 193	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:hasStdDev	()Z
      //   183: aload_0
      //   184: getfield 92	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:stdDev_	F
      //   187: aload_3
      //   188: invokevirtual 193	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:hasStdDev	()Z
      //   191: aload_3
      //   192: getfield 92	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:stdDev_	F
      //   195: invokeinterface 184 5 0
      //   200: putfield 92	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:stdDev_	F
      //   203: aload_0
      //   204: astore_1
      //   205: aload_2
      //   206: getstatic 199	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   209: if_acmpne -137 -> 72
      //   212: aload_0
      //   213: aload_0
      //   214: getfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   217: aload_3
      //   218: getfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   221: ior
      //   222: putfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   225: aload_0
      //   226: areturn
      //   227: aload_2
      //   228: checkcast 201	com/google/protobuf/CodedInputStream
      //   231: astore_1
      //   232: aload_3
      //   233: checkcast 203	com/google/protobuf/ExtensionRegistryLite
      //   236: astore_2
      //   237: iconst_0
      //   238: istore 4
      //   240: iload 4
      //   242: ifne +204 -> 446
      //   245: aload_1
      //   246: invokevirtual 206	com/google/protobuf/CodedInputStream:readTag	()I
      //   249: istore 5
      //   251: iload 5
      //   253: lookupswitch	default:+238->491, 0:+241->494, 13:+67->320, 21:+105->358, 29:+150->403, 37:+171->424
      //   304: aload_0
      //   305: iload 5
      //   307: aload_1
      //   308: invokevirtual 210	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   311: ifne -71 -> 240
      //   314: iconst_1
      //   315: istore 4
      //   317: goto -77 -> 240
      //   320: aload_0
      //   321: aload_0
      //   322: getfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   325: iconst_1
      //   326: ior
      //   327: putfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   330: aload_0
      //   331: aload_1
      //   332: invokevirtual 214	com/google/protobuf/CodedInputStream:readFloat	()F
      //   335: putfield 90	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:min_	F
      //   338: goto -98 -> 240
      //   341: astore_1
      //   342: new 216	java/lang/RuntimeException
      //   345: dup
      //   346: aload_1
      //   347: aload_0
      //   348: invokevirtual 220	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   351: invokespecial 223	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   354: athrow
      //   355: astore_1
      //   356: aload_1
      //   357: athrow
      //   358: aload_0
      //   359: aload_0
      //   360: getfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   363: iconst_2
      //   364: ior
      //   365: putfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   368: aload_0
      //   369: aload_1
      //   370: invokevirtual 214	com/google/protobuf/CodedInputStream:readFloat	()F
      //   373: putfield 86	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:avg_	F
      //   376: goto -136 -> 240
      //   379: astore_1
      //   380: new 216	java/lang/RuntimeException
      //   383: dup
      //   384: new 120	com/google/protobuf/InvalidProtocolBufferException
      //   387: dup
      //   388: aload_1
      //   389: invokevirtual 227	java/io/IOException:getMessage	()Ljava/lang/String;
      //   392: invokespecial 230	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   395: aload_0
      //   396: invokevirtual 220	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   399: invokespecial 223	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   402: athrow
      //   403: aload_0
      //   404: aload_0
      //   405: getfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   408: iconst_4
      //   409: ior
      //   410: putfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   413: aload_0
      //   414: aload_1
      //   415: invokevirtual 214	com/google/protobuf/CodedInputStream:readFloat	()F
      //   418: putfield 88	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:max_	F
      //   421: goto -181 -> 240
      //   424: aload_0
      //   425: aload_0
      //   426: getfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   429: bipush 8
      //   431: ior
      //   432: putfield 84	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:bitField0_	I
      //   435: aload_0
      //   436: aload_1
      //   437: invokevirtual 214	com/google/protobuf/CodedInputStream:readFloat	()F
      //   440: putfield 92	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:stdDev_	F
      //   443: goto -203 -> 240
      //   446: getstatic 40	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
      //   449: areturn
      //   450: getstatic 232	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:PARSER	Lcom/google/protobuf/Parser;
      //   453: ifnonnull +28 -> 481
      //   456: ldc 2
      //   458: monitorenter
      //   459: getstatic 232	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:PARSER	Lcom/google/protobuf/Parser;
      //   462: ifnonnull +16 -> 478
      //   465: new 234	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   468: dup
      //   469: getstatic 40	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric;
      //   472: invokespecial 237	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   475: putstatic 232	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:PARSER	Lcom/google/protobuf/Parser;
      //   478: ldc 2
      //   480: monitorexit
      //   481: getstatic 232	com/blizzard/telemetry/proto/standard/network/UdpQualitySample$Metric:PARSER	Lcom/google/protobuf/Parser;
      //   484: areturn
      //   485: astore_1
      //   486: ldc 2
      //   488: monitorexit
      //   489: aload_1
      //   490: athrow
      //   491: goto -187 -> 304
      //   494: iconst_1
      //   495: istore 4
      //   497: goto -257 -> 240
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	500	0	this	Metric
      //   0	500	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	500	2	paramObject1	Object
      //   0	500	3	paramObject2	Object
      //   238	258	4	i	int
      //   249	57	5	j	int
      // Exception table:
      //   from	to	target	type
      //   245	251	341	com/google/protobuf/InvalidProtocolBufferException
      //   304	314	341	com/google/protobuf/InvalidProtocolBufferException
      //   320	338	341	com/google/protobuf/InvalidProtocolBufferException
      //   358	376	341	com/google/protobuf/InvalidProtocolBufferException
      //   403	421	341	com/google/protobuf/InvalidProtocolBufferException
      //   424	443	341	com/google/protobuf/InvalidProtocolBufferException
      //   245	251	355	finally
      //   304	314	355	finally
      //   320	338	355	finally
      //   342	355	355	finally
      //   358	376	355	finally
      //   380	403	355	finally
      //   403	421	355	finally
      //   424	443	355	finally
      //   245	251	379	java/io/IOException
      //   304	314	379	java/io/IOException
      //   320	338	379	java/io/IOException
      //   358	376	379	java/io/IOException
      //   403	421	379	java/io/IOException
      //   424	443	379	java/io/IOException
      //   459	478	485	finally
      //   478	481	485	finally
      //   486	489	485	finally
    }
    
    public float getAvg()
    {
      return this.avg_;
    }
    
    public float getMax()
    {
      return this.max_;
    }
    
    public float getMin()
    {
      return this.min_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeFloatSize(1, this.min_);
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeFloatSize(2, this.avg_);
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeFloatSize(3, this.max_);
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeFloatSize(4, this.stdDev_);
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public float getStdDev()
    {
      return this.stdDev_;
    }
    
    public boolean hasAvg()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasMax()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasMin()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasStdDev()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeFloat(1, this.min_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeFloat(2, this.avg_);
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeFloat(3, this.max_);
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeFloat(4, this.stdDev_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<UdpQualitySample.Metric, Builder>
      implements UdpQualitySample.MetricOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearAvg()
      {
        copyOnWrite();
        ((UdpQualitySample.Metric)this.instance).clearAvg();
        return this;
      }
      
      public Builder clearMax()
      {
        copyOnWrite();
        ((UdpQualitySample.Metric)this.instance).clearMax();
        return this;
      }
      
      public Builder clearMin()
      {
        copyOnWrite();
        ((UdpQualitySample.Metric)this.instance).clearMin();
        return this;
      }
      
      public Builder clearStdDev()
      {
        copyOnWrite();
        ((UdpQualitySample.Metric)this.instance).clearStdDev();
        return this;
      }
      
      public float getAvg()
      {
        return ((UdpQualitySample.Metric)this.instance).getAvg();
      }
      
      public float getMax()
      {
        return ((UdpQualitySample.Metric)this.instance).getMax();
      }
      
      public float getMin()
      {
        return ((UdpQualitySample.Metric)this.instance).getMin();
      }
      
      public float getStdDev()
      {
        return ((UdpQualitySample.Metric)this.instance).getStdDev();
      }
      
      public boolean hasAvg()
      {
        return ((UdpQualitySample.Metric)this.instance).hasAvg();
      }
      
      public boolean hasMax()
      {
        return ((UdpQualitySample.Metric)this.instance).hasMax();
      }
      
      public boolean hasMin()
      {
        return ((UdpQualitySample.Metric)this.instance).hasMin();
      }
      
      public boolean hasStdDev()
      {
        return ((UdpQualitySample.Metric)this.instance).hasStdDev();
      }
      
      public Builder setAvg(float paramFloat)
      {
        copyOnWrite();
        ((UdpQualitySample.Metric)this.instance).setAvg(paramFloat);
        return this;
      }
      
      public Builder setMax(float paramFloat)
      {
        copyOnWrite();
        ((UdpQualitySample.Metric)this.instance).setMax(paramFloat);
        return this;
      }
      
      public Builder setMin(float paramFloat)
      {
        copyOnWrite();
        ((UdpQualitySample.Metric)this.instance).setMin(paramFloat);
        return this;
      }
      
      public Builder setStdDev(float paramFloat)
      {
        copyOnWrite();
        ((UdpQualitySample.Metric)this.instance).setStdDev(paramFloat);
        return this;
      }
    }
  }
  
  public static abstract interface MetricOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract float getAvg();
    
    public abstract float getMax();
    
    public abstract float getMin();
    
    public abstract float getStdDev();
    
    public abstract boolean hasAvg();
    
    public abstract boolean hasMax();
    
    public abstract boolean hasMin();
    
    public abstract boolean hasStdDev();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/network/UdpQualitySample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */