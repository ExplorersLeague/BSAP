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

public final class TcpQualitySample
  extends GeneratedMessageLite<TcpQualitySample, Builder>
  implements TcpQualitySampleOrBuilder
{
  public static final int ADDRESS4_FIELD_NUMBER = 2;
  public static final int ADDRESS6_FIELD_NUMBER = 5;
  public static final int BYTES_RECEIVED_FIELD_NUMBER = 102;
  public static final int BYTES_SENT_FIELD_NUMBER = 101;
  private static final TcpQualitySample DEFAULT_INSTANCE = new TcpQualitySample();
  public static final int MESSAGES_RECEIVED_FIELD_NUMBER = 106;
  public static final int MESSAGES_SENT_FIELD_NUMBER = 105;
  public static final int NAME_FIELD_NUMBER = 1;
  private static volatile Parser<TcpQualitySample> PARSER;
  public static final int PING_MS_FIELD_NUMBER = 114;
  public static final int PORT_FIELD_NUMBER = 3;
  public static final int SAMPLE_TIME_MS_FIELD_NUMBER = 100;
  public static final int SESSION_ID_FIELD_NUMBER = 4;
  public static final int TIME_SINCE_PREV_MESSAGE_MS_FIELD_NUMBER = 111;
  private String address4_ = "";
  private String address6_ = "";
  private int bitField0_;
  private long bytesReceived_;
  private long bytesSent_;
  private int messagesReceived_;
  private int messagesSent_;
  private String name_ = "";
  private Metric pingMs_;
  private int port_;
  private float sampleTimeMs_;
  private long sessionId_;
  private Metric timeSincePrevMessageMs_;
  
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
  
  private void clearMessagesReceived()
  {
    this.bitField0_ &= 0xFDFF;
    this.messagesReceived_ = 0;
  }
  
  private void clearMessagesSent()
  {
    this.bitField0_ &= 0xFEFF;
    this.messagesSent_ = 0;
  }
  
  private void clearName()
  {
    this.bitField0_ &= 0xFFFFFFFE;
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearPingMs()
  {
    this.pingMs_ = null;
    this.bitField0_ &= 0xF7FF;
  }
  
  private void clearPort()
  {
    this.bitField0_ &= 0xFFFFFFF7;
    this.port_ = 0;
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
  
  private void clearTimeSincePrevMessageMs()
  {
    this.timeSincePrevMessageMs_ = null;
    this.bitField0_ &= 0xFBFF;
  }
  
  public static TcpQualitySample getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private void mergePingMs(Metric paramMetric)
  {
    if ((this.pingMs_ != null) && (this.pingMs_ != Metric.getDefaultInstance())) {}
    for (this.pingMs_ = ((Metric)((TcpQualitySample.Metric.Builder)Metric.newBuilder(this.pingMs_).mergeFrom(paramMetric)).buildPartial());; this.pingMs_ = paramMetric)
    {
      this.bitField0_ |= 0x800;
      return;
    }
  }
  
  private void mergeTimeSincePrevMessageMs(Metric paramMetric)
  {
    if ((this.timeSincePrevMessageMs_ != null) && (this.timeSincePrevMessageMs_ != Metric.getDefaultInstance())) {}
    for (this.timeSincePrevMessageMs_ = ((Metric)((TcpQualitySample.Metric.Builder)Metric.newBuilder(this.timeSincePrevMessageMs_).mergeFrom(paramMetric)).buildPartial());; this.timeSincePrevMessageMs_ = paramMetric)
    {
      this.bitField0_ |= 0x400;
      return;
    }
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(TcpQualitySample paramTcpQualitySample)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTcpQualitySample);
  }
  
  public static TcpQualitySample parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (TcpQualitySample)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TcpQualitySample parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (TcpQualitySample)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TcpQualitySample parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (TcpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static TcpQualitySample parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (TcpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static TcpQualitySample parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (TcpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static TcpQualitySample parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (TcpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static TcpQualitySample parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (TcpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TcpQualitySample parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (TcpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TcpQualitySample parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (TcpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static TcpQualitySample parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (TcpQualitySample)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<TcpQualitySample> parser()
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
  
  private void setMessagesReceived(int paramInt)
  {
    this.bitField0_ |= 0x200;
    this.messagesReceived_ = paramInt;
  }
  
  private void setMessagesSent(int paramInt)
  {
    this.bitField0_ |= 0x100;
    this.messagesSent_ = paramInt;
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
  
  private void setPingMs(TcpQualitySample.Metric.Builder paramBuilder)
  {
    this.pingMs_ = ((Metric)paramBuilder.build());
    this.bitField0_ |= 0x800;
  }
  
  private void setPingMs(Metric paramMetric)
  {
    if (paramMetric == null) {
      throw new NullPointerException();
    }
    this.pingMs_ = paramMetric;
    this.bitField0_ |= 0x800;
  }
  
  private void setPort(int paramInt)
  {
    this.bitField0_ |= 0x8;
    this.port_ = paramInt;
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
  
  private void setTimeSincePrevMessageMs(TcpQualitySample.Metric.Builder paramBuilder)
  {
    this.timeSincePrevMessageMs_ = ((Metric)paramBuilder.build());
    this.bitField0_ |= 0x400;
  }
  
  private void setTimeSincePrevMessageMs(Metric paramMetric)
  {
    if (paramMetric == null) {
      throw new NullPointerException();
    }
    this.timeSincePrevMessageMs_ = paramMetric;
    this.bitField0_ |= 0x400;
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 348	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 354	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+417->425, 7:+1001->1009, 8:+1005->1013
    //   56: new 356	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 357	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/blizzard/telemetry/proto/standard/network/TcpQualitySample
    //   67: dup
    //   68: invokespecial 72	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 74	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 360	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 362	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/blizzard/telemetry/proto/standard/network/TcpQualitySample
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 366	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasName	()Z
    //   105: aload_0
    //   106: getfield 83	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:name_	Ljava/lang/String;
    //   109: aload_3
    //   110: invokevirtual 366	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasName	()Z
    //   113: aload_3
    //   114: getfield 83	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:name_	Ljava/lang/String;
    //   117: invokeinterface 370 5 0
    //   122: putfield 83	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:name_	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 373	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasAddress4	()Z
    //   131: aload_0
    //   132: getfield 85	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:address4_	Ljava/lang/String;
    //   135: aload_3
    //   136: invokevirtual 373	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasAddress4	()Z
    //   139: aload_3
    //   140: getfield 85	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:address4_	Ljava/lang/String;
    //   143: invokeinterface 370 5 0
    //   148: putfield 85	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:address4_	Ljava/lang/String;
    //   151: aload_0
    //   152: aload_2
    //   153: aload_0
    //   154: invokevirtual 376	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasAddress6	()Z
    //   157: aload_0
    //   158: getfield 87	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:address6_	Ljava/lang/String;
    //   161: aload_3
    //   162: invokevirtual 376	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasAddress6	()Z
    //   165: aload_3
    //   166: getfield 87	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:address6_	Ljava/lang/String;
    //   169: invokeinterface 370 5 0
    //   174: putfield 87	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:address6_	Ljava/lang/String;
    //   177: aload_0
    //   178: aload_2
    //   179: aload_0
    //   180: invokevirtual 379	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasPort	()Z
    //   183: aload_0
    //   184: getfield 253	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:port_	I
    //   187: aload_3
    //   188: invokevirtual 379	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasPort	()Z
    //   191: aload_3
    //   192: getfield 253	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:port_	I
    //   195: invokeinterface 383 5 0
    //   200: putfield 253	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:port_	I
    //   203: aload_0
    //   204: aload_2
    //   205: aload_0
    //   206: invokevirtual 386	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasSessionId	()Z
    //   209: aload_0
    //   210: getfield 257	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:sessionId_	J
    //   213: aload_3
    //   214: invokevirtual 386	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasSessionId	()Z
    //   217: aload_3
    //   218: getfield 257	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:sessionId_	J
    //   221: invokeinterface 390 7 0
    //   226: putfield 257	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:sessionId_	J
    //   229: aload_0
    //   230: aload_2
    //   231: aload_0
    //   232: invokevirtual 393	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasSampleTimeMs	()Z
    //   235: aload_0
    //   236: getfield 255	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:sampleTimeMs_	F
    //   239: aload_3
    //   240: invokevirtual 393	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasSampleTimeMs	()Z
    //   243: aload_3
    //   244: getfield 255	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:sampleTimeMs_	F
    //   247: invokeinterface 397 5 0
    //   252: putfield 255	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:sampleTimeMs_	F
    //   255: aload_0
    //   256: aload_2
    //   257: aload_0
    //   258: invokevirtual 400	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasBytesSent	()Z
    //   261: aload_0
    //   262: getfield 242	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bytesSent_	J
    //   265: aload_3
    //   266: invokevirtual 400	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasBytesSent	()Z
    //   269: aload_3
    //   270: getfield 242	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bytesSent_	J
    //   273: invokeinterface 390 7 0
    //   278: putfield 242	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bytesSent_	J
    //   281: aload_0
    //   282: aload_2
    //   283: aload_0
    //   284: invokevirtual 403	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasBytesReceived	()Z
    //   287: aload_0
    //   288: getfield 240	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bytesReceived_	J
    //   291: aload_3
    //   292: invokevirtual 403	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasBytesReceived	()Z
    //   295: aload_3
    //   296: getfield 240	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bytesReceived_	J
    //   299: invokeinterface 390 7 0
    //   304: putfield 240	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bytesReceived_	J
    //   307: aload_0
    //   308: aload_2
    //   309: aload_0
    //   310: invokevirtual 406	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasMessagesSent	()Z
    //   313: aload_0
    //   314: getfield 246	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:messagesSent_	I
    //   317: aload_3
    //   318: invokevirtual 406	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasMessagesSent	()Z
    //   321: aload_3
    //   322: getfield 246	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:messagesSent_	I
    //   325: invokeinterface 383 5 0
    //   330: putfield 246	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:messagesSent_	I
    //   333: aload_0
    //   334: aload_2
    //   335: aload_0
    //   336: invokevirtual 409	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasMessagesReceived	()Z
    //   339: aload_0
    //   340: getfield 244	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:messagesReceived_	I
    //   343: aload_3
    //   344: invokevirtual 409	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:hasMessagesReceived	()Z
    //   347: aload_3
    //   348: getfield 244	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:messagesReceived_	I
    //   351: invokeinterface 383 5 0
    //   356: putfield 244	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:messagesReceived_	I
    //   359: aload_0
    //   360: aload_2
    //   361: aload_0
    //   362: getfield 259	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:timeSincePrevMessageMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   365: aload_3
    //   366: getfield 259	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:timeSincePrevMessageMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   369: invokeinterface 413 3 0
    //   374: checkcast 14	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric
    //   377: putfield 259	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:timeSincePrevMessageMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   380: aload_0
    //   381: aload_2
    //   382: aload_0
    //   383: getfield 251	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   386: aload_3
    //   387: getfield 251	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   390: invokeinterface 413 3 0
    //   395: checkcast 14	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric
    //   398: putfield 251	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   401: aload_0
    //   402: astore_1
    //   403: aload_2
    //   404: getstatic 419	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   407: if_acmpne -335 -> 72
    //   410: aload_0
    //   411: aload_0
    //   412: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   415: aload_3
    //   416: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   419: ior
    //   420: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   423: aload_0
    //   424: areturn
    //   425: aload_2
    //   426: checkcast 421	com/google/protobuf/CodedInputStream
    //   429: astore_2
    //   430: aload_3
    //   431: checkcast 423	com/google/protobuf/ExtensionRegistryLite
    //   434: astore_3
    //   435: iconst_0
    //   436: istore 4
    //   438: iload 4
    //   440: ifne +569 -> 1009
    //   443: aload_2
    //   444: invokevirtual 426	com/google/protobuf/CodedInputStream:readTag	()I
    //   447: istore 5
    //   449: iload 5
    //   451: lookupswitch	default:+603->1054, 0:+606->1057, 10:+129->580, 18:+169->620, 24:+216->667, 32:+238->689, 42:+260->711, 805:+283->734, 808:+305->756, 816:+327->778, 840:+350->801, 848:+373->824, 890:+396->847, 914:+477->928
    //   564: aload_0
    //   565: iload 5
    //   567: aload_2
    //   568: invokevirtual 430	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   571: ifne -133 -> 438
    //   574: iconst_1
    //   575: istore 4
    //   577: goto -139 -> 438
    //   580: aload_2
    //   581: invokevirtual 433	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   584: astore_1
    //   585: aload_0
    //   586: aload_0
    //   587: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   590: iconst_1
    //   591: ior
    //   592: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   595: aload_0
    //   596: aload_1
    //   597: putfield 83	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:name_	Ljava/lang/String;
    //   600: goto -162 -> 438
    //   603: astore_1
    //   604: new 435	java/lang/RuntimeException
    //   607: dup
    //   608: aload_1
    //   609: aload_0
    //   610: invokevirtual 439	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   613: invokespecial 442	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   616: athrow
    //   617: astore_1
    //   618: aload_1
    //   619: athrow
    //   620: aload_2
    //   621: invokevirtual 433	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   624: astore_1
    //   625: aload_0
    //   626: aload_0
    //   627: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   630: iconst_2
    //   631: ior
    //   632: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   635: aload_0
    //   636: aload_1
    //   637: putfield 85	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:address4_	Ljava/lang/String;
    //   640: goto -202 -> 438
    //   643: astore_1
    //   644: new 435	java/lang/RuntimeException
    //   647: dup
    //   648: new 297	com/google/protobuf/InvalidProtocolBufferException
    //   651: dup
    //   652: aload_1
    //   653: invokevirtual 445	java/io/IOException:getMessage	()Ljava/lang/String;
    //   656: invokespecial 447	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   659: aload_0
    //   660: invokevirtual 439	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   663: invokespecial 442	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   666: athrow
    //   667: aload_0
    //   668: aload_0
    //   669: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   672: bipush 8
    //   674: ior
    //   675: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   678: aload_0
    //   679: aload_2
    //   680: invokevirtual 450	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   683: putfield 253	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:port_	I
    //   686: goto -248 -> 438
    //   689: aload_0
    //   690: aload_0
    //   691: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   694: bipush 16
    //   696: ior
    //   697: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   700: aload_0
    //   701: aload_2
    //   702: invokevirtual 454	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   705: putfield 257	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:sessionId_	J
    //   708: goto -270 -> 438
    //   711: aload_2
    //   712: invokevirtual 433	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   715: astore_1
    //   716: aload_0
    //   717: aload_0
    //   718: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   721: iconst_4
    //   722: ior
    //   723: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   726: aload_0
    //   727: aload_1
    //   728: putfield 87	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:address6_	Ljava/lang/String;
    //   731: goto -293 -> 438
    //   734: aload_0
    //   735: aload_0
    //   736: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   739: bipush 32
    //   741: ior
    //   742: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   745: aload_0
    //   746: aload_2
    //   747: invokevirtual 458	com/google/protobuf/CodedInputStream:readFloat	()F
    //   750: putfield 255	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:sampleTimeMs_	F
    //   753: goto -315 -> 438
    //   756: aload_0
    //   757: aload_0
    //   758: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   761: bipush 64
    //   763: ior
    //   764: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   767: aload_0
    //   768: aload_2
    //   769: invokevirtual 454	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   772: putfield 242	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bytesSent_	J
    //   775: goto -337 -> 438
    //   778: aload_0
    //   779: aload_0
    //   780: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   783: sipush 128
    //   786: ior
    //   787: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   790: aload_0
    //   791: aload_2
    //   792: invokevirtual 454	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   795: putfield 240	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bytesReceived_	J
    //   798: goto -360 -> 438
    //   801: aload_0
    //   802: aload_0
    //   803: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   806: sipush 256
    //   809: ior
    //   810: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   813: aload_0
    //   814: aload_2
    //   815: invokevirtual 450	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   818: putfield 246	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:messagesSent_	I
    //   821: goto -383 -> 438
    //   824: aload_0
    //   825: aload_0
    //   826: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   829: sipush 512
    //   832: ior
    //   833: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   836: aload_0
    //   837: aload_2
    //   838: invokevirtual 450	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   841: putfield 244	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:messagesReceived_	I
    //   844: goto -406 -> 438
    //   847: aconst_null
    //   848: astore_1
    //   849: aload_0
    //   850: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   853: sipush 1024
    //   856: iand
    //   857: sipush 1024
    //   860: if_icmpne +14 -> 874
    //   863: aload_0
    //   864: getfield 259	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:timeSincePrevMessageMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   867: invokevirtual 459	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   870: checkcast 17	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric$Builder
    //   873: astore_1
    //   874: aload_0
    //   875: aload_2
    //   876: invokestatic 461	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:parser	()Lcom/google/protobuf/Parser;
    //   879: aload_3
    //   880: invokevirtual 465	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   883: checkcast 14	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric
    //   886: putfield 259	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:timeSincePrevMessageMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   889: aload_1
    //   890: ifnull +23 -> 913
    //   893: aload_1
    //   894: aload_0
    //   895: getfield 259	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:timeSincePrevMessageMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   898: invokevirtual 270	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   901: pop
    //   902: aload_0
    //   903: aload_1
    //   904: invokevirtual 274	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   907: checkcast 14	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric
    //   910: putfield 259	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:timeSincePrevMessageMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   913: aload_0
    //   914: aload_0
    //   915: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   918: sipush 1024
    //   921: ior
    //   922: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   925: goto -487 -> 438
    //   928: aconst_null
    //   929: astore_1
    //   930: aload_0
    //   931: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   934: sipush 2048
    //   937: iand
    //   938: sipush 2048
    //   941: if_icmpne +14 -> 955
    //   944: aload_0
    //   945: getfield 251	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   948: invokevirtual 459	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   951: checkcast 17	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric$Builder
    //   954: astore_1
    //   955: aload_0
    //   956: aload_2
    //   957: invokestatic 461	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:parser	()Lcom/google/protobuf/Parser;
    //   960: aload_3
    //   961: invokevirtual 465	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   964: checkcast 14	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric
    //   967: putfield 251	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   970: aload_1
    //   971: ifnull +23 -> 994
    //   974: aload_1
    //   975: aload_0
    //   976: getfield 251	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   979: invokevirtual 270	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   982: pop
    //   983: aload_0
    //   984: aload_1
    //   985: invokevirtual 274	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   988: checkcast 14	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric
    //   991: putfield 251	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:pingMs_	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
    //   994: aload_0
    //   995: aload_0
    //   996: getfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   999: sipush 2048
    //   1002: ior
    //   1003: putfield 228	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:bitField0_	I
    //   1006: goto -568 -> 438
    //   1009: getstatic 74	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample;
    //   1012: areturn
    //   1013: getstatic 467	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:PARSER	Lcom/google/protobuf/Parser;
    //   1016: ifnonnull +28 -> 1044
    //   1019: ldc 2
    //   1021: monitorenter
    //   1022: getstatic 467	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:PARSER	Lcom/google/protobuf/Parser;
    //   1025: ifnonnull +16 -> 1041
    //   1028: new 469	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   1031: dup
    //   1032: getstatic 74	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample;
    //   1035: invokespecial 472	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   1038: putstatic 467	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:PARSER	Lcom/google/protobuf/Parser;
    //   1041: ldc 2
    //   1043: monitorexit
    //   1044: getstatic 467	com/blizzard/telemetry/proto/standard/network/TcpQualitySample:PARSER	Lcom/google/protobuf/Parser;
    //   1047: areturn
    //   1048: astore_1
    //   1049: ldc 2
    //   1051: monitorexit
    //   1052: aload_1
    //   1053: athrow
    //   1054: goto -490 -> 564
    //   1057: iconst_1
    //   1058: istore 4
    //   1060: goto -622 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1063	0	this	TcpQualitySample
    //   0	1063	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	1063	2	paramObject1	Object
    //   0	1063	3	paramObject2	Object
    //   436	623	4	i	int
    //   447	119	5	j	int
    // Exception table:
    //   from	to	target	type
    //   443	449	603	com/google/protobuf/InvalidProtocolBufferException
    //   564	574	603	com/google/protobuf/InvalidProtocolBufferException
    //   580	600	603	com/google/protobuf/InvalidProtocolBufferException
    //   620	640	603	com/google/protobuf/InvalidProtocolBufferException
    //   667	686	603	com/google/protobuf/InvalidProtocolBufferException
    //   689	708	603	com/google/protobuf/InvalidProtocolBufferException
    //   711	731	603	com/google/protobuf/InvalidProtocolBufferException
    //   734	753	603	com/google/protobuf/InvalidProtocolBufferException
    //   756	775	603	com/google/protobuf/InvalidProtocolBufferException
    //   778	798	603	com/google/protobuf/InvalidProtocolBufferException
    //   801	821	603	com/google/protobuf/InvalidProtocolBufferException
    //   824	844	603	com/google/protobuf/InvalidProtocolBufferException
    //   849	874	603	com/google/protobuf/InvalidProtocolBufferException
    //   874	889	603	com/google/protobuf/InvalidProtocolBufferException
    //   893	913	603	com/google/protobuf/InvalidProtocolBufferException
    //   913	925	603	com/google/protobuf/InvalidProtocolBufferException
    //   930	955	603	com/google/protobuf/InvalidProtocolBufferException
    //   955	970	603	com/google/protobuf/InvalidProtocolBufferException
    //   974	994	603	com/google/protobuf/InvalidProtocolBufferException
    //   994	1006	603	com/google/protobuf/InvalidProtocolBufferException
    //   443	449	617	finally
    //   564	574	617	finally
    //   580	600	617	finally
    //   604	617	617	finally
    //   620	640	617	finally
    //   644	667	617	finally
    //   667	686	617	finally
    //   689	708	617	finally
    //   711	731	617	finally
    //   734	753	617	finally
    //   756	775	617	finally
    //   778	798	617	finally
    //   801	821	617	finally
    //   824	844	617	finally
    //   849	874	617	finally
    //   874	889	617	finally
    //   893	913	617	finally
    //   913	925	617	finally
    //   930	955	617	finally
    //   955	970	617	finally
    //   974	994	617	finally
    //   994	1006	617	finally
    //   443	449	643	java/io/IOException
    //   564	574	643	java/io/IOException
    //   580	600	643	java/io/IOException
    //   620	640	643	java/io/IOException
    //   667	686	643	java/io/IOException
    //   689	708	643	java/io/IOException
    //   711	731	643	java/io/IOException
    //   734	753	643	java/io/IOException
    //   756	775	643	java/io/IOException
    //   778	798	643	java/io/IOException
    //   801	821	643	java/io/IOException
    //   824	844	643	java/io/IOException
    //   849	874	643	java/io/IOException
    //   874	889	643	java/io/IOException
    //   893	913	643	java/io/IOException
    //   913	925	643	java/io/IOException
    //   930	955	643	java/io/IOException
    //   955	970	643	java/io/IOException
    //   974	994	643	java/io/IOException
    //   994	1006	643	java/io/IOException
    //   1022	1041	1048	finally
    //   1041	1044	1048	finally
    //   1049	1052	1048	finally
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
  
  public long getBytesReceived()
  {
    return this.bytesReceived_;
  }
  
  public long getBytesSent()
  {
    return this.bytesSent_;
  }
  
  public int getMessagesReceived()
  {
    return this.messagesReceived_;
  }
  
  public int getMessagesSent()
  {
    return this.messagesSent_;
  }
  
  public String getName()
  {
    return this.name_;
  }
  
  public ByteString getNameBytes()
  {
    return ByteString.copyFromUtf8(this.name_);
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
      j = i + CodedOutputStream.computeUInt32Size(105, this.messagesSent_);
    }
    i = j;
    if ((this.bitField0_ & 0x200) == 512) {
      i = j + CodedOutputStream.computeUInt32Size(106, this.messagesReceived_);
    }
    j = i;
    if ((this.bitField0_ & 0x400) == 1024) {
      j = i + CodedOutputStream.computeMessageSize(111, getTimeSincePrevMessageMs());
    }
    i = j;
    if ((this.bitField0_ & 0x800) == 2048) {
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
  
  public Metric getTimeSincePrevMessageMs()
  {
    if (this.timeSincePrevMessageMs_ == null) {
      return Metric.getDefaultInstance();
    }
    return this.timeSincePrevMessageMs_;
  }
  
  public boolean hasAddress4()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasAddress6()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasBytesReceived()
  {
    return (this.bitField0_ & 0x80) == 128;
  }
  
  public boolean hasBytesSent()
  {
    return (this.bitField0_ & 0x40) == 64;
  }
  
  public boolean hasMessagesReceived()
  {
    return (this.bitField0_ & 0x200) == 512;
  }
  
  public boolean hasMessagesSent()
  {
    return (this.bitField0_ & 0x100) == 256;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasPingMs()
  {
    return (this.bitField0_ & 0x800) == 2048;
  }
  
  public boolean hasPort()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasSampleTimeMs()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasSessionId()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasTimeSincePrevMessageMs()
  {
    return (this.bitField0_ & 0x400) == 1024;
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
      paramCodedOutputStream.writeUInt32(105, this.messagesSent_);
    }
    if ((this.bitField0_ & 0x200) == 512) {
      paramCodedOutputStream.writeUInt32(106, this.messagesReceived_);
    }
    if ((this.bitField0_ & 0x400) == 1024) {
      paramCodedOutputStream.writeMessage(111, getTimeSincePrevMessageMs());
    }
    if ((this.bitField0_ & 0x800) == 2048) {
      paramCodedOutputStream.writeMessage(114, getPingMs());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<TcpQualitySample, Builder>
    implements TcpQualitySampleOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearAddress4()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearAddress4();
      return this;
    }
    
    public Builder clearAddress6()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearAddress6();
      return this;
    }
    
    public Builder clearBytesReceived()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearBytesReceived();
      return this;
    }
    
    public Builder clearBytesSent()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearBytesSent();
      return this;
    }
    
    public Builder clearMessagesReceived()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearMessagesReceived();
      return this;
    }
    
    public Builder clearMessagesSent()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearMessagesSent();
      return this;
    }
    
    public Builder clearName()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearName();
      return this;
    }
    
    public Builder clearPingMs()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearPingMs();
      return this;
    }
    
    public Builder clearPort()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearPort();
      return this;
    }
    
    public Builder clearSampleTimeMs()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearSampleTimeMs();
      return this;
    }
    
    public Builder clearSessionId()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearSessionId();
      return this;
    }
    
    public Builder clearTimeSincePrevMessageMs()
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).clearTimeSincePrevMessageMs();
      return this;
    }
    
    public String getAddress4()
    {
      return ((TcpQualitySample)this.instance).getAddress4();
    }
    
    public ByteString getAddress4Bytes()
    {
      return ((TcpQualitySample)this.instance).getAddress4Bytes();
    }
    
    public String getAddress6()
    {
      return ((TcpQualitySample)this.instance).getAddress6();
    }
    
    public ByteString getAddress6Bytes()
    {
      return ((TcpQualitySample)this.instance).getAddress6Bytes();
    }
    
    public long getBytesReceived()
    {
      return ((TcpQualitySample)this.instance).getBytesReceived();
    }
    
    public long getBytesSent()
    {
      return ((TcpQualitySample)this.instance).getBytesSent();
    }
    
    public int getMessagesReceived()
    {
      return ((TcpQualitySample)this.instance).getMessagesReceived();
    }
    
    public int getMessagesSent()
    {
      return ((TcpQualitySample)this.instance).getMessagesSent();
    }
    
    public String getName()
    {
      return ((TcpQualitySample)this.instance).getName();
    }
    
    public ByteString getNameBytes()
    {
      return ((TcpQualitySample)this.instance).getNameBytes();
    }
    
    public TcpQualitySample.Metric getPingMs()
    {
      return ((TcpQualitySample)this.instance).getPingMs();
    }
    
    public int getPort()
    {
      return ((TcpQualitySample)this.instance).getPort();
    }
    
    public float getSampleTimeMs()
    {
      return ((TcpQualitySample)this.instance).getSampleTimeMs();
    }
    
    public long getSessionId()
    {
      return ((TcpQualitySample)this.instance).getSessionId();
    }
    
    public TcpQualitySample.Metric getTimeSincePrevMessageMs()
    {
      return ((TcpQualitySample)this.instance).getTimeSincePrevMessageMs();
    }
    
    public boolean hasAddress4()
    {
      return ((TcpQualitySample)this.instance).hasAddress4();
    }
    
    public boolean hasAddress6()
    {
      return ((TcpQualitySample)this.instance).hasAddress6();
    }
    
    public boolean hasBytesReceived()
    {
      return ((TcpQualitySample)this.instance).hasBytesReceived();
    }
    
    public boolean hasBytesSent()
    {
      return ((TcpQualitySample)this.instance).hasBytesSent();
    }
    
    public boolean hasMessagesReceived()
    {
      return ((TcpQualitySample)this.instance).hasMessagesReceived();
    }
    
    public boolean hasMessagesSent()
    {
      return ((TcpQualitySample)this.instance).hasMessagesSent();
    }
    
    public boolean hasName()
    {
      return ((TcpQualitySample)this.instance).hasName();
    }
    
    public boolean hasPingMs()
    {
      return ((TcpQualitySample)this.instance).hasPingMs();
    }
    
    public boolean hasPort()
    {
      return ((TcpQualitySample)this.instance).hasPort();
    }
    
    public boolean hasSampleTimeMs()
    {
      return ((TcpQualitySample)this.instance).hasSampleTimeMs();
    }
    
    public boolean hasSessionId()
    {
      return ((TcpQualitySample)this.instance).hasSessionId();
    }
    
    public boolean hasTimeSincePrevMessageMs()
    {
      return ((TcpQualitySample)this.instance).hasTimeSincePrevMessageMs();
    }
    
    public Builder mergePingMs(TcpQualitySample.Metric paramMetric)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).mergePingMs(paramMetric);
      return this;
    }
    
    public Builder mergeTimeSincePrevMessageMs(TcpQualitySample.Metric paramMetric)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).mergeTimeSincePrevMessageMs(paramMetric);
      return this;
    }
    
    public Builder setAddress4(String paramString)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setAddress4(paramString);
      return this;
    }
    
    public Builder setAddress4Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setAddress4Bytes(paramByteString);
      return this;
    }
    
    public Builder setAddress6(String paramString)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setAddress6(paramString);
      return this;
    }
    
    public Builder setAddress6Bytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setAddress6Bytes(paramByteString);
      return this;
    }
    
    public Builder setBytesReceived(long paramLong)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setBytesReceived(paramLong);
      return this;
    }
    
    public Builder setBytesSent(long paramLong)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setBytesSent(paramLong);
      return this;
    }
    
    public Builder setMessagesReceived(int paramInt)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setMessagesReceived(paramInt);
      return this;
    }
    
    public Builder setMessagesSent(int paramInt)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setMessagesSent(paramInt);
      return this;
    }
    
    public Builder setName(String paramString)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setName(paramString);
      return this;
    }
    
    public Builder setNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setNameBytes(paramByteString);
      return this;
    }
    
    public Builder setPingMs(TcpQualitySample.Metric.Builder paramBuilder)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setPingMs(paramBuilder);
      return this;
    }
    
    public Builder setPingMs(TcpQualitySample.Metric paramMetric)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setPingMs(paramMetric);
      return this;
    }
    
    public Builder setPort(int paramInt)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setPort(paramInt);
      return this;
    }
    
    public Builder setSampleTimeMs(float paramFloat)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setSampleTimeMs(paramFloat);
      return this;
    }
    
    public Builder setSessionId(long paramLong)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setSessionId(paramLong);
      return this;
    }
    
    public Builder setTimeSincePrevMessageMs(TcpQualitySample.Metric.Builder paramBuilder)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setTimeSincePrevMessageMs(paramBuilder);
      return this;
    }
    
    public Builder setTimeSincePrevMessageMs(TcpQualitySample.Metric paramMetric)
    {
      copyOnWrite();
      ((TcpQualitySample)this.instance).setTimeSincePrevMessageMs(paramMetric);
      return this;
    }
  }
  
  public static final class Metric
    extends GeneratedMessageLite<Metric, Builder>
    implements TcpQualitySample.MetricOrBuilder
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
      //   0: getstatic 162	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 168	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+219->227, 7:+438->446, 8:+442->450
      //   56: new 170	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 171	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric
      //   67: dup
      //   68: invokespecial 38	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 40	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 174	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 176	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 180	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:hasMin	()Z
      //   105: aload_0
      //   106: getfield 90	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:min_	F
      //   109: aload_3
      //   110: invokevirtual 180	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:hasMin	()Z
      //   113: aload_3
      //   114: getfield 90	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:min_	F
      //   117: invokeinterface 184 5 0
      //   122: putfield 90	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:min_	F
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 187	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:hasAvg	()Z
      //   131: aload_0
      //   132: getfield 86	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:avg_	F
      //   135: aload_3
      //   136: invokevirtual 187	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:hasAvg	()Z
      //   139: aload_3
      //   140: getfield 86	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:avg_	F
      //   143: invokeinterface 184 5 0
      //   148: putfield 86	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:avg_	F
      //   151: aload_0
      //   152: aload_2
      //   153: aload_0
      //   154: invokevirtual 190	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:hasMax	()Z
      //   157: aload_0
      //   158: getfield 88	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:max_	F
      //   161: aload_3
      //   162: invokevirtual 190	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:hasMax	()Z
      //   165: aload_3
      //   166: getfield 88	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:max_	F
      //   169: invokeinterface 184 5 0
      //   174: putfield 88	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:max_	F
      //   177: aload_0
      //   178: aload_2
      //   179: aload_0
      //   180: invokevirtual 193	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:hasStdDev	()Z
      //   183: aload_0
      //   184: getfield 92	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:stdDev_	F
      //   187: aload_3
      //   188: invokevirtual 193	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:hasStdDev	()Z
      //   191: aload_3
      //   192: getfield 92	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:stdDev_	F
      //   195: invokeinterface 184 5 0
      //   200: putfield 92	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:stdDev_	F
      //   203: aload_0
      //   204: astore_1
      //   205: aload_2
      //   206: getstatic 199	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   209: if_acmpne -137 -> 72
      //   212: aload_0
      //   213: aload_0
      //   214: getfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   217: aload_3
      //   218: getfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   221: ior
      //   222: putfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
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
      //   308: invokevirtual 210	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   311: ifne -71 -> 240
      //   314: iconst_1
      //   315: istore 4
      //   317: goto -77 -> 240
      //   320: aload_0
      //   321: aload_0
      //   322: getfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   325: iconst_1
      //   326: ior
      //   327: putfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   330: aload_0
      //   331: aload_1
      //   332: invokevirtual 214	com/google/protobuf/CodedInputStream:readFloat	()F
      //   335: putfield 90	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:min_	F
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
      //   360: getfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   363: iconst_2
      //   364: ior
      //   365: putfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   368: aload_0
      //   369: aload_1
      //   370: invokevirtual 214	com/google/protobuf/CodedInputStream:readFloat	()F
      //   373: putfield 86	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:avg_	F
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
      //   405: getfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   408: iconst_4
      //   409: ior
      //   410: putfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   413: aload_0
      //   414: aload_1
      //   415: invokevirtual 214	com/google/protobuf/CodedInputStream:readFloat	()F
      //   418: putfield 88	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:max_	F
      //   421: goto -181 -> 240
      //   424: aload_0
      //   425: aload_0
      //   426: getfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   429: bipush 8
      //   431: ior
      //   432: putfield 84	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:bitField0_	I
      //   435: aload_0
      //   436: aload_1
      //   437: invokevirtual 214	com/google/protobuf/CodedInputStream:readFloat	()F
      //   440: putfield 92	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:stdDev_	F
      //   443: goto -203 -> 240
      //   446: getstatic 40	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
      //   449: areturn
      //   450: getstatic 232	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:PARSER	Lcom/google/protobuf/Parser;
      //   453: ifnonnull +28 -> 481
      //   456: ldc 2
      //   458: monitorenter
      //   459: getstatic 232	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:PARSER	Lcom/google/protobuf/Parser;
      //   462: ifnonnull +16 -> 478
      //   465: new 234	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   468: dup
      //   469: getstatic 40	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric;
      //   472: invokespecial 237	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   475: putstatic 232	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:PARSER	Lcom/google/protobuf/Parser;
      //   478: ldc 2
      //   480: monitorexit
      //   481: getstatic 232	com/blizzard/telemetry/proto/standard/network/TcpQualitySample$Metric:PARSER	Lcom/google/protobuf/Parser;
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
      extends GeneratedMessageLite.Builder<TcpQualitySample.Metric, Builder>
      implements TcpQualitySample.MetricOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearAvg()
      {
        copyOnWrite();
        ((TcpQualitySample.Metric)this.instance).clearAvg();
        return this;
      }
      
      public Builder clearMax()
      {
        copyOnWrite();
        ((TcpQualitySample.Metric)this.instance).clearMax();
        return this;
      }
      
      public Builder clearMin()
      {
        copyOnWrite();
        ((TcpQualitySample.Metric)this.instance).clearMin();
        return this;
      }
      
      public Builder clearStdDev()
      {
        copyOnWrite();
        ((TcpQualitySample.Metric)this.instance).clearStdDev();
        return this;
      }
      
      public float getAvg()
      {
        return ((TcpQualitySample.Metric)this.instance).getAvg();
      }
      
      public float getMax()
      {
        return ((TcpQualitySample.Metric)this.instance).getMax();
      }
      
      public float getMin()
      {
        return ((TcpQualitySample.Metric)this.instance).getMin();
      }
      
      public float getStdDev()
      {
        return ((TcpQualitySample.Metric)this.instance).getStdDev();
      }
      
      public boolean hasAvg()
      {
        return ((TcpQualitySample.Metric)this.instance).hasAvg();
      }
      
      public boolean hasMax()
      {
        return ((TcpQualitySample.Metric)this.instance).hasMax();
      }
      
      public boolean hasMin()
      {
        return ((TcpQualitySample.Metric)this.instance).hasMin();
      }
      
      public boolean hasStdDev()
      {
        return ((TcpQualitySample.Metric)this.instance).hasStdDev();
      }
      
      public Builder setAvg(float paramFloat)
      {
        copyOnWrite();
        ((TcpQualitySample.Metric)this.instance).setAvg(paramFloat);
        return this;
      }
      
      public Builder setMax(float paramFloat)
      {
        copyOnWrite();
        ((TcpQualitySample.Metric)this.instance).setMax(paramFloat);
        return this;
      }
      
      public Builder setMin(float paramFloat)
      {
        copyOnWrite();
        ((TcpQualitySample.Metric)this.instance).setMin(paramFloat);
        return this;
      }
      
      public Builder setStdDev(float paramFloat)
      {
        copyOnWrite();
        ((TcpQualitySample.Metric)this.instance).setStdDev(paramFloat);
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


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/network/TcpQualitySample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */