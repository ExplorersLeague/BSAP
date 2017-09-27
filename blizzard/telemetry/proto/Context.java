package com.blizzard.telemetry.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Context
  extends GeneratedMessageLite<Context, Builder>
  implements ContextOrBuilder
{
  public static final int ACCOUNT_FIELD_NUMBER = 8;
  public static final int BNET_ID_FIELD_NUMBER = 9;
  private static final Context DEFAULT_INSTANCE = new Context();
  public static final int HOST_FIELD_NUMBER = 4;
  private static volatile Parser<Context> PARSER;
  public static final int PROGRAM_FIELD_NUMBER = 1;
  public static final int RETRY_COUNT_FIELD_NUMBER = 7;
  public static final int SESSION_ID_FIELD_NUMBER = 6;
  public static final int SOURCE_TIME_FIELD_NUMBER = 2;
  public static final int TIME_OFFSET_FIELD_NUMBER = 3;
  public static final int TRACE_FIELD_NUMBER = 5;
  private long account_;
  private int bitField0_;
  private long bnetId_;
  private HostInfo host_;
  private ProgramInfo program_;
  private int retryCount_;
  private String sessionId_ = "";
  private long sourceTime_;
  private long timeOffset_;
  private TraceInfo trace_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAccount()
  {
    this.bitField0_ &= 0xFF7F;
    this.account_ = 0L;
  }
  
  private void clearBnetId()
  {
    this.bitField0_ &= 0xFEFF;
    this.bnetId_ = 0L;
  }
  
  private void clearHost()
  {
    this.host_ = null;
    this.bitField0_ &= 0xFFFFFFF7;
  }
  
  private void clearProgram()
  {
    this.program_ = null;
    this.bitField0_ &= 0xFFFFFFFE;
  }
  
  private void clearRetryCount()
  {
    this.bitField0_ &= 0xFFFFFFBF;
    this.retryCount_ = 0;
  }
  
  private void clearSessionId()
  {
    this.bitField0_ &= 0xFFFFFFDF;
    this.sessionId_ = getDefaultInstance().getSessionId();
  }
  
  private void clearSourceTime()
  {
    this.bitField0_ &= 0xFFFFFFFD;
    this.sourceTime_ = 0L;
  }
  
  private void clearTimeOffset()
  {
    this.bitField0_ &= 0xFFFFFFFB;
    this.timeOffset_ = 0L;
  }
  
  private void clearTrace()
  {
    this.trace_ = null;
    this.bitField0_ &= 0xFFFFFFEF;
  }
  
  public static Context getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeHost(HostInfo paramHostInfo)
  {
    if ((this.host_ != null) && (this.host_ != HostInfo.getDefaultInstance())) {}
    for (this.host_ = ((HostInfo)((Context.HostInfo.Builder)HostInfo.newBuilder(this.host_).mergeFrom(paramHostInfo)).buildPartial());; this.host_ = paramHostInfo)
    {
      this.bitField0_ |= 0x8;
      return;
    }
  }
  
  private void mergeProgram(ProgramInfo paramProgramInfo)
  {
    if ((this.program_ != null) && (this.program_ != ProgramInfo.getDefaultInstance())) {}
    for (this.program_ = ((ProgramInfo)((Context.ProgramInfo.Builder)ProgramInfo.newBuilder(this.program_).mergeFrom(paramProgramInfo)).buildPartial());; this.program_ = paramProgramInfo)
    {
      this.bitField0_ |= 0x1;
      return;
    }
  }
  
  private void mergeTrace(TraceInfo paramTraceInfo)
  {
    if ((this.trace_ != null) && (this.trace_ != TraceInfo.getDefaultInstance())) {}
    for (this.trace_ = ((TraceInfo)((Context.TraceInfo.Builder)TraceInfo.newBuilder(this.trace_).mergeFrom(paramTraceInfo)).buildPartial());; this.trace_ = paramTraceInfo)
    {
      this.bitField0_ |= 0x10;
      return;
    }
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Context paramContext)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramContext);
  }
  
  public static Context parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Context)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Context parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Context)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Context parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Context)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Context parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Context)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Context parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Context)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Context parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Context)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Context parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Context)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Context parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Context)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Context parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Context)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Context parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Context)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Context> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAccount(long paramLong)
  {
    this.bitField0_ |= 0x80;
    this.account_ = paramLong;
  }
  
  private void setBnetId(long paramLong)
  {
    this.bitField0_ |= 0x100;
    this.bnetId_ = paramLong;
  }
  
  private void setHost(Context.HostInfo.Builder paramBuilder)
  {
    this.host_ = ((HostInfo)paramBuilder.build());
    this.bitField0_ |= 0x8;
  }
  
  private void setHost(HostInfo paramHostInfo)
  {
    if (paramHostInfo == null) {
      throw new NullPointerException();
    }
    this.host_ = paramHostInfo;
    this.bitField0_ |= 0x8;
  }
  
  private void setProgram(Context.ProgramInfo.Builder paramBuilder)
  {
    this.program_ = ((ProgramInfo)paramBuilder.build());
    this.bitField0_ |= 0x1;
  }
  
  private void setProgram(ProgramInfo paramProgramInfo)
  {
    if (paramProgramInfo == null) {
      throw new NullPointerException();
    }
    this.program_ = paramProgramInfo;
    this.bitField0_ |= 0x1;
  }
  
  private void setRetryCount(int paramInt)
  {
    this.bitField0_ |= 0x40;
    this.retryCount_ = paramInt;
  }
  
  private void setSessionId(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x20;
    this.sessionId_ = paramString;
  }
  
  private void setSessionIdBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x20;
    this.sessionId_ = paramByteString.toStringUtf8();
  }
  
  private void setSourceTime(long paramLong)
  {
    this.bitField0_ |= 0x2;
    this.sourceTime_ = paramLong;
  }
  
  private void setTimeOffset(long paramLong)
  {
    this.bitField0_ |= 0x4;
    this.timeOffset_ = paramLong;
  }
  
  private void setTrace(Context.TraceInfo.Builder paramBuilder)
  {
    this.trace_ = ((TraceInfo)paramBuilder.build());
    this.bitField0_ |= 0x10;
  }
  
  private void setTrace(TraceInfo paramTraceInfo)
  {
    if (paramTraceInfo == null) {
      throw new NullPointerException();
    }
    this.trace_ = paramTraceInfo;
    this.bitField0_ |= 0x10;
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 351	com/blizzard/telemetry/proto/Context$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 357	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+334->342, 7:+874->882, 8:+878->886
    //   56: new 359	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 360	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/blizzard/telemetry/proto/Context
    //   67: dup
    //   68: invokespecial 88	com/blizzard/telemetry/proto/Context:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 90	com/blizzard/telemetry/proto/Context:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/blizzard/telemetry/proto/Context$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 363	com/blizzard/telemetry/proto/Context$Builder:<init>	(Lcom/blizzard/telemetry/proto/Context$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 365	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/blizzard/telemetry/proto/Context
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: getfield 229	com/blizzard/telemetry/proto/Context:program_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
    //   105: aload_3
    //   106: getfield 229	com/blizzard/telemetry/proto/Context:program_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
    //   109: invokeinterface 369 3 0
    //   114: checkcast 22	com/blizzard/telemetry/proto/Context$ProgramInfo
    //   117: putfield 229	com/blizzard/telemetry/proto/Context:program_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
    //   120: aload_0
    //   121: aload_2
    //   122: aload_0
    //   123: invokevirtual 373	com/blizzard/telemetry/proto/Context:hasSourceTime	()Z
    //   126: aload_0
    //   127: getfield 240	com/blizzard/telemetry/proto/Context:sourceTime_	J
    //   130: aload_3
    //   131: invokevirtual 373	com/blizzard/telemetry/proto/Context:hasSourceTime	()Z
    //   134: aload_3
    //   135: getfield 240	com/blizzard/telemetry/proto/Context:sourceTime_	J
    //   138: invokeinterface 377 7 0
    //   143: putfield 240	com/blizzard/telemetry/proto/Context:sourceTime_	J
    //   146: aload_0
    //   147: aload_2
    //   148: aload_0
    //   149: invokevirtual 380	com/blizzard/telemetry/proto/Context:hasTimeOffset	()Z
    //   152: aload_0
    //   153: getfield 242	com/blizzard/telemetry/proto/Context:timeOffset_	J
    //   156: aload_3
    //   157: invokevirtual 380	com/blizzard/telemetry/proto/Context:hasTimeOffset	()Z
    //   160: aload_3
    //   161: getfield 242	com/blizzard/telemetry/proto/Context:timeOffset_	J
    //   164: invokeinterface 377 7 0
    //   169: putfield 242	com/blizzard/telemetry/proto/Context:timeOffset_	J
    //   172: aload_0
    //   173: aload_2
    //   174: aload_0
    //   175: getfield 227	com/blizzard/telemetry/proto/Context:host_	Lcom/blizzard/telemetry/proto/Context$HostInfo;
    //   178: aload_3
    //   179: getfield 227	com/blizzard/telemetry/proto/Context:host_	Lcom/blizzard/telemetry/proto/Context$HostInfo;
    //   182: invokeinterface 369 3 0
    //   187: checkcast 14	com/blizzard/telemetry/proto/Context$HostInfo
    //   190: putfield 227	com/blizzard/telemetry/proto/Context:host_	Lcom/blizzard/telemetry/proto/Context$HostInfo;
    //   193: aload_0
    //   194: aload_2
    //   195: aload_0
    //   196: getfield 244	com/blizzard/telemetry/proto/Context:trace_	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
    //   199: aload_3
    //   200: getfield 244	com/blizzard/telemetry/proto/Context:trace_	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
    //   203: invokeinterface 369 3 0
    //   208: checkcast 38	com/blizzard/telemetry/proto/Context$TraceInfo
    //   211: putfield 244	com/blizzard/telemetry/proto/Context:trace_	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
    //   214: aload_0
    //   215: aload_2
    //   216: aload_0
    //   217: invokevirtual 383	com/blizzard/telemetry/proto/Context:hasSessionId	()Z
    //   220: aload_0
    //   221: getfield 99	com/blizzard/telemetry/proto/Context:sessionId_	Ljava/lang/String;
    //   224: aload_3
    //   225: invokevirtual 383	com/blizzard/telemetry/proto/Context:hasSessionId	()Z
    //   228: aload_3
    //   229: getfield 99	com/blizzard/telemetry/proto/Context:sessionId_	Ljava/lang/String;
    //   232: invokeinterface 387 5 0
    //   237: putfield 99	com/blizzard/telemetry/proto/Context:sessionId_	Ljava/lang/String;
    //   240: aload_0
    //   241: aload_2
    //   242: aload_0
    //   243: invokevirtual 390	com/blizzard/telemetry/proto/Context:hasRetryCount	()Z
    //   246: aload_0
    //   247: getfield 231	com/blizzard/telemetry/proto/Context:retryCount_	I
    //   250: aload_3
    //   251: invokevirtual 390	com/blizzard/telemetry/proto/Context:hasRetryCount	()Z
    //   254: aload_3
    //   255: getfield 231	com/blizzard/telemetry/proto/Context:retryCount_	I
    //   258: invokeinterface 394 5 0
    //   263: putfield 231	com/blizzard/telemetry/proto/Context:retryCount_	I
    //   266: aload_0
    //   267: aload_2
    //   268: aload_0
    //   269: invokevirtual 397	com/blizzard/telemetry/proto/Context:hasAccount	()Z
    //   272: aload_0
    //   273: getfield 223	com/blizzard/telemetry/proto/Context:account_	J
    //   276: aload_3
    //   277: invokevirtual 397	com/blizzard/telemetry/proto/Context:hasAccount	()Z
    //   280: aload_3
    //   281: getfield 223	com/blizzard/telemetry/proto/Context:account_	J
    //   284: invokeinterface 377 7 0
    //   289: putfield 223	com/blizzard/telemetry/proto/Context:account_	J
    //   292: aload_0
    //   293: aload_2
    //   294: aload_0
    //   295: invokevirtual 400	com/blizzard/telemetry/proto/Context:hasBnetId	()Z
    //   298: aload_0
    //   299: getfield 225	com/blizzard/telemetry/proto/Context:bnetId_	J
    //   302: aload_3
    //   303: invokevirtual 400	com/blizzard/telemetry/proto/Context:hasBnetId	()Z
    //   306: aload_3
    //   307: getfield 225	com/blizzard/telemetry/proto/Context:bnetId_	J
    //   310: invokeinterface 377 7 0
    //   315: putfield 225	com/blizzard/telemetry/proto/Context:bnetId_	J
    //   318: aload_0
    //   319: astore_1
    //   320: aload_2
    //   321: getstatic 406	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   324: if_acmpne -252 -> 72
    //   327: aload_0
    //   328: aload_0
    //   329: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   332: aload_3
    //   333: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   336: ior
    //   337: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   340: aload_0
    //   341: areturn
    //   342: aload_2
    //   343: checkcast 408	com/google/protobuf/CodedInputStream
    //   346: astore_2
    //   347: aload_3
    //   348: checkcast 410	com/google/protobuf/ExtensionRegistryLite
    //   351: astore_3
    //   352: iconst_0
    //   353: istore 4
    //   355: iload 4
    //   357: ifne +525 -> 882
    //   360: aload_2
    //   361: invokevirtual 413	com/google/protobuf/CodedInputStream:readTag	()I
    //   364: istore 5
    //   366: iload 5
    //   368: lookupswitch	default:+559->927, 0:+562->930, 10:+108->476, 16:+200->568, 24:+245->613, 34:+266->634, 42:+344->712, 50:+422->790, 56:+446->814, 64:+468->836, 72:+491->859
    //   460: aload_0
    //   461: iload 5
    //   463: aload_2
    //   464: invokevirtual 417	com/blizzard/telemetry/proto/Context:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   467: ifne -112 -> 355
    //   470: iconst_1
    //   471: istore 4
    //   473: goto -118 -> 355
    //   476: aconst_null
    //   477: astore_1
    //   478: aload_0
    //   479: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   482: iconst_1
    //   483: iand
    //   484: iconst_1
    //   485: if_icmpne +14 -> 499
    //   488: aload_0
    //   489: getfield 229	com/blizzard/telemetry/proto/Context:program_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
    //   492: invokevirtual 418	com/blizzard/telemetry/proto/Context$ProgramInfo:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   495: checkcast 25	com/blizzard/telemetry/proto/Context$ProgramInfo$Builder
    //   498: astore_1
    //   499: aload_0
    //   500: aload_2
    //   501: invokestatic 420	com/blizzard/telemetry/proto/Context$ProgramInfo:parser	()Lcom/google/protobuf/Parser;
    //   504: aload_3
    //   505: invokevirtual 424	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   508: checkcast 22	com/blizzard/telemetry/proto/Context$ProgramInfo
    //   511: putfield 229	com/blizzard/telemetry/proto/Context:program_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
    //   514: aload_1
    //   515: ifnull +23 -> 538
    //   518: aload_1
    //   519: aload_0
    //   520: getfield 229	com/blizzard/telemetry/proto/Context:program_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
    //   523: invokevirtual 266	com/blizzard/telemetry/proto/Context$ProgramInfo$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   526: pop
    //   527: aload_0
    //   528: aload_1
    //   529: invokevirtual 267	com/blizzard/telemetry/proto/Context$ProgramInfo$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   532: checkcast 22	com/blizzard/telemetry/proto/Context$ProgramInfo
    //   535: putfield 229	com/blizzard/telemetry/proto/Context:program_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
    //   538: aload_0
    //   539: aload_0
    //   540: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   543: iconst_1
    //   544: ior
    //   545: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   548: goto -193 -> 355
    //   551: astore_1
    //   552: new 426	java/lang/RuntimeException
    //   555: dup
    //   556: aload_1
    //   557: aload_0
    //   558: invokevirtual 430	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   561: invokespecial 433	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   564: athrow
    //   565: astore_1
    //   566: aload_1
    //   567: athrow
    //   568: aload_0
    //   569: aload_0
    //   570: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   573: iconst_2
    //   574: ior
    //   575: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   578: aload_0
    //   579: aload_2
    //   580: invokevirtual 437	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   583: putfield 240	com/blizzard/telemetry/proto/Context:sourceTime_	J
    //   586: goto -231 -> 355
    //   589: astore_1
    //   590: new 426	java/lang/RuntimeException
    //   593: dup
    //   594: new 298	com/google/protobuf/InvalidProtocolBufferException
    //   597: dup
    //   598: aload_1
    //   599: invokevirtual 440	java/io/IOException:getMessage	()Ljava/lang/String;
    //   602: invokespecial 442	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   605: aload_0
    //   606: invokevirtual 430	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   609: invokespecial 433	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   612: athrow
    //   613: aload_0
    //   614: aload_0
    //   615: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   618: iconst_4
    //   619: ior
    //   620: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   623: aload_0
    //   624: aload_2
    //   625: invokevirtual 445	com/google/protobuf/CodedInputStream:readInt64	()J
    //   628: putfield 242	com/blizzard/telemetry/proto/Context:timeOffset_	J
    //   631: goto -276 -> 355
    //   634: aconst_null
    //   635: astore_1
    //   636: aload_0
    //   637: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   640: bipush 8
    //   642: iand
    //   643: bipush 8
    //   645: if_icmpne +14 -> 659
    //   648: aload_0
    //   649: getfield 227	com/blizzard/telemetry/proto/Context:host_	Lcom/blizzard/telemetry/proto/Context$HostInfo;
    //   652: invokevirtual 446	com/blizzard/telemetry/proto/Context$HostInfo:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   655: checkcast 17	com/blizzard/telemetry/proto/Context$HostInfo$Builder
    //   658: astore_1
    //   659: aload_0
    //   660: aload_2
    //   661: invokestatic 447	com/blizzard/telemetry/proto/Context$HostInfo:parser	()Lcom/google/protobuf/Parser;
    //   664: aload_3
    //   665: invokevirtual 424	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   668: checkcast 14	com/blizzard/telemetry/proto/Context$HostInfo
    //   671: putfield 227	com/blizzard/telemetry/proto/Context:host_	Lcom/blizzard/telemetry/proto/Context$HostInfo;
    //   674: aload_1
    //   675: ifnull +23 -> 698
    //   678: aload_1
    //   679: aload_0
    //   680: getfield 227	com/blizzard/telemetry/proto/Context:host_	Lcom/blizzard/telemetry/proto/Context$HostInfo;
    //   683: invokevirtual 255	com/blizzard/telemetry/proto/Context$HostInfo$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   686: pop
    //   687: aload_0
    //   688: aload_1
    //   689: invokevirtual 259	com/blizzard/telemetry/proto/Context$HostInfo$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   692: checkcast 14	com/blizzard/telemetry/proto/Context$HostInfo
    //   695: putfield 227	com/blizzard/telemetry/proto/Context:host_	Lcom/blizzard/telemetry/proto/Context$HostInfo;
    //   698: aload_0
    //   699: aload_0
    //   700: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   703: bipush 8
    //   705: ior
    //   706: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   709: goto -354 -> 355
    //   712: aconst_null
    //   713: astore_1
    //   714: aload_0
    //   715: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   718: bipush 16
    //   720: iand
    //   721: bipush 16
    //   723: if_icmpne +14 -> 737
    //   726: aload_0
    //   727: getfield 244	com/blizzard/telemetry/proto/Context:trace_	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
    //   730: invokevirtual 448	com/blizzard/telemetry/proto/Context$TraceInfo:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   733: checkcast 41	com/blizzard/telemetry/proto/Context$TraceInfo$Builder
    //   736: astore_1
    //   737: aload_0
    //   738: aload_2
    //   739: invokestatic 449	com/blizzard/telemetry/proto/Context$TraceInfo:parser	()Lcom/google/protobuf/Parser;
    //   742: aload_3
    //   743: invokevirtual 424	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   746: checkcast 38	com/blizzard/telemetry/proto/Context$TraceInfo
    //   749: putfield 244	com/blizzard/telemetry/proto/Context:trace_	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
    //   752: aload_1
    //   753: ifnull +23 -> 776
    //   756: aload_1
    //   757: aload_0
    //   758: getfield 244	com/blizzard/telemetry/proto/Context:trace_	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
    //   761: invokevirtual 274	com/blizzard/telemetry/proto/Context$TraceInfo$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   764: pop
    //   765: aload_0
    //   766: aload_1
    //   767: invokevirtual 275	com/blizzard/telemetry/proto/Context$TraceInfo$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
    //   770: checkcast 38	com/blizzard/telemetry/proto/Context$TraceInfo
    //   773: putfield 244	com/blizzard/telemetry/proto/Context:trace_	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
    //   776: aload_0
    //   777: aload_0
    //   778: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   781: bipush 16
    //   783: ior
    //   784: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   787: goto -432 -> 355
    //   790: aload_2
    //   791: invokevirtual 452	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   794: astore_1
    //   795: aload_0
    //   796: aload_0
    //   797: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   800: bipush 32
    //   802: ior
    //   803: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   806: aload_0
    //   807: aload_1
    //   808: putfield 99	com/blizzard/telemetry/proto/Context:sessionId_	Ljava/lang/String;
    //   811: goto -456 -> 355
    //   814: aload_0
    //   815: aload_0
    //   816: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   819: bipush 64
    //   821: ior
    //   822: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   825: aload_0
    //   826: aload_2
    //   827: invokevirtual 455	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   830: putfield 231	com/blizzard/telemetry/proto/Context:retryCount_	I
    //   833: goto -478 -> 355
    //   836: aload_0
    //   837: aload_0
    //   838: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   841: sipush 128
    //   844: ior
    //   845: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   848: aload_0
    //   849: aload_2
    //   850: invokevirtual 437	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   853: putfield 223	com/blizzard/telemetry/proto/Context:account_	J
    //   856: goto -501 -> 355
    //   859: aload_0
    //   860: aload_0
    //   861: getfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   864: sipush 256
    //   867: ior
    //   868: putfield 221	com/blizzard/telemetry/proto/Context:bitField0_	I
    //   871: aload_0
    //   872: aload_2
    //   873: invokevirtual 437	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   876: putfield 225	com/blizzard/telemetry/proto/Context:bnetId_	J
    //   879: goto -524 -> 355
    //   882: getstatic 90	com/blizzard/telemetry/proto/Context:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context;
    //   885: areturn
    //   886: getstatic 457	com/blizzard/telemetry/proto/Context:PARSER	Lcom/google/protobuf/Parser;
    //   889: ifnonnull +28 -> 917
    //   892: ldc 2
    //   894: monitorenter
    //   895: getstatic 457	com/blizzard/telemetry/proto/Context:PARSER	Lcom/google/protobuf/Parser;
    //   898: ifnonnull +16 -> 914
    //   901: new 459	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   904: dup
    //   905: getstatic 90	com/blizzard/telemetry/proto/Context:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context;
    //   908: invokespecial 462	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   911: putstatic 457	com/blizzard/telemetry/proto/Context:PARSER	Lcom/google/protobuf/Parser;
    //   914: ldc 2
    //   916: monitorexit
    //   917: getstatic 457	com/blizzard/telemetry/proto/Context:PARSER	Lcom/google/protobuf/Parser;
    //   920: areturn
    //   921: astore_1
    //   922: ldc 2
    //   924: monitorexit
    //   925: aload_1
    //   926: athrow
    //   927: goto -467 -> 460
    //   930: iconst_1
    //   931: istore 4
    //   933: goto -578 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	936	0	this	Context
    //   0	936	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	936	2	paramObject1	Object
    //   0	936	3	paramObject2	Object
    //   353	579	4	i	int
    //   364	98	5	j	int
    // Exception table:
    //   from	to	target	type
    //   360	366	551	com/google/protobuf/InvalidProtocolBufferException
    //   460	470	551	com/google/protobuf/InvalidProtocolBufferException
    //   478	499	551	com/google/protobuf/InvalidProtocolBufferException
    //   499	514	551	com/google/protobuf/InvalidProtocolBufferException
    //   518	538	551	com/google/protobuf/InvalidProtocolBufferException
    //   538	548	551	com/google/protobuf/InvalidProtocolBufferException
    //   568	586	551	com/google/protobuf/InvalidProtocolBufferException
    //   613	631	551	com/google/protobuf/InvalidProtocolBufferException
    //   636	659	551	com/google/protobuf/InvalidProtocolBufferException
    //   659	674	551	com/google/protobuf/InvalidProtocolBufferException
    //   678	698	551	com/google/protobuf/InvalidProtocolBufferException
    //   698	709	551	com/google/protobuf/InvalidProtocolBufferException
    //   714	737	551	com/google/protobuf/InvalidProtocolBufferException
    //   737	752	551	com/google/protobuf/InvalidProtocolBufferException
    //   756	776	551	com/google/protobuf/InvalidProtocolBufferException
    //   776	787	551	com/google/protobuf/InvalidProtocolBufferException
    //   790	811	551	com/google/protobuf/InvalidProtocolBufferException
    //   814	833	551	com/google/protobuf/InvalidProtocolBufferException
    //   836	856	551	com/google/protobuf/InvalidProtocolBufferException
    //   859	879	551	com/google/protobuf/InvalidProtocolBufferException
    //   360	366	565	finally
    //   460	470	565	finally
    //   478	499	565	finally
    //   499	514	565	finally
    //   518	538	565	finally
    //   538	548	565	finally
    //   552	565	565	finally
    //   568	586	565	finally
    //   590	613	565	finally
    //   613	631	565	finally
    //   636	659	565	finally
    //   659	674	565	finally
    //   678	698	565	finally
    //   698	709	565	finally
    //   714	737	565	finally
    //   737	752	565	finally
    //   756	776	565	finally
    //   776	787	565	finally
    //   790	811	565	finally
    //   814	833	565	finally
    //   836	856	565	finally
    //   859	879	565	finally
    //   360	366	589	java/io/IOException
    //   460	470	589	java/io/IOException
    //   478	499	589	java/io/IOException
    //   499	514	589	java/io/IOException
    //   518	538	589	java/io/IOException
    //   538	548	589	java/io/IOException
    //   568	586	589	java/io/IOException
    //   613	631	589	java/io/IOException
    //   636	659	589	java/io/IOException
    //   659	674	589	java/io/IOException
    //   678	698	589	java/io/IOException
    //   698	709	589	java/io/IOException
    //   714	737	589	java/io/IOException
    //   737	752	589	java/io/IOException
    //   756	776	589	java/io/IOException
    //   776	787	589	java/io/IOException
    //   790	811	589	java/io/IOException
    //   814	833	589	java/io/IOException
    //   836	856	589	java/io/IOException
    //   859	879	589	java/io/IOException
    //   895	914	921	finally
    //   914	917	921	finally
    //   922	925	921	finally
  }
  
  public long getAccount()
  {
    return this.account_;
  }
  
  public long getBnetId()
  {
    return this.bnetId_;
  }
  
  public HostInfo getHost()
  {
    if (this.host_ == null) {
      return HostInfo.getDefaultInstance();
    }
    return this.host_;
  }
  
  public ProgramInfo getProgram()
  {
    if (this.program_ == null) {
      return ProgramInfo.getDefaultInstance();
    }
    return this.program_;
  }
  
  public int getRetryCount()
  {
    return this.retryCount_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = 0 + CodedOutputStream.computeMessageSize(1, getProgram());
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeUInt64Size(2, this.sourceTime_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeInt64Size(3, this.timeOffset_);
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeMessageSize(4, getHost());
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeMessageSize(5, getTrace());
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + CodedOutputStream.computeStringSize(6, getSessionId());
    }
    j = i;
    if ((this.bitField0_ & 0x40) == 64) {
      j = i + CodedOutputStream.computeUInt32Size(7, this.retryCount_);
    }
    i = j;
    if ((this.bitField0_ & 0x80) == 128) {
      i = j + CodedOutputStream.computeUInt64Size(8, this.account_);
    }
    j = i;
    if ((this.bitField0_ & 0x100) == 256) {
      j = i + CodedOutputStream.computeUInt64Size(9, this.bnetId_);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getSessionId()
  {
    return this.sessionId_;
  }
  
  public ByteString getSessionIdBytes()
  {
    return ByteString.copyFromUtf8(this.sessionId_);
  }
  
  public long getSourceTime()
  {
    return this.sourceTime_;
  }
  
  public long getTimeOffset()
  {
    return this.timeOffset_;
  }
  
  public TraceInfo getTrace()
  {
    if (this.trace_ == null) {
      return TraceInfo.getDefaultInstance();
    }
    return this.trace_;
  }
  
  public boolean hasAccount()
  {
    return (this.bitField0_ & 0x80) == 128;
  }
  
  public boolean hasBnetId()
  {
    return (this.bitField0_ & 0x100) == 256;
  }
  
  public boolean hasHost()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasProgram()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasRetryCount()
  {
    return (this.bitField0_ & 0x40) == 64;
  }
  
  public boolean hasSessionId()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasSourceTime()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasTimeOffset()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasTrace()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeMessage(1, getProgram());
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeUInt64(2, this.sourceTime_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeInt64(3, this.timeOffset_);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeMessage(4, getHost());
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeMessage(5, getTrace());
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeString(6, getSessionId());
    }
    if ((this.bitField0_ & 0x40) == 64) {
      paramCodedOutputStream.writeUInt32(7, this.retryCount_);
    }
    if ((this.bitField0_ & 0x80) == 128) {
      paramCodedOutputStream.writeUInt64(8, this.account_);
    }
    if ((this.bitField0_ & 0x100) == 256) {
      paramCodedOutputStream.writeUInt64(9, this.bnetId_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Context, Builder>
    implements ContextOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearAccount()
    {
      copyOnWrite();
      ((Context)this.instance).clearAccount();
      return this;
    }
    
    public Builder clearBnetId()
    {
      copyOnWrite();
      ((Context)this.instance).clearBnetId();
      return this;
    }
    
    public Builder clearHost()
    {
      copyOnWrite();
      ((Context)this.instance).clearHost();
      return this;
    }
    
    public Builder clearProgram()
    {
      copyOnWrite();
      ((Context)this.instance).clearProgram();
      return this;
    }
    
    public Builder clearRetryCount()
    {
      copyOnWrite();
      ((Context)this.instance).clearRetryCount();
      return this;
    }
    
    public Builder clearSessionId()
    {
      copyOnWrite();
      ((Context)this.instance).clearSessionId();
      return this;
    }
    
    public Builder clearSourceTime()
    {
      copyOnWrite();
      ((Context)this.instance).clearSourceTime();
      return this;
    }
    
    public Builder clearTimeOffset()
    {
      copyOnWrite();
      ((Context)this.instance).clearTimeOffset();
      return this;
    }
    
    public Builder clearTrace()
    {
      copyOnWrite();
      ((Context)this.instance).clearTrace();
      return this;
    }
    
    public long getAccount()
    {
      return ((Context)this.instance).getAccount();
    }
    
    public long getBnetId()
    {
      return ((Context)this.instance).getBnetId();
    }
    
    public Context.HostInfo getHost()
    {
      return ((Context)this.instance).getHost();
    }
    
    public Context.ProgramInfo getProgram()
    {
      return ((Context)this.instance).getProgram();
    }
    
    public int getRetryCount()
    {
      return ((Context)this.instance).getRetryCount();
    }
    
    public String getSessionId()
    {
      return ((Context)this.instance).getSessionId();
    }
    
    public ByteString getSessionIdBytes()
    {
      return ((Context)this.instance).getSessionIdBytes();
    }
    
    public long getSourceTime()
    {
      return ((Context)this.instance).getSourceTime();
    }
    
    public long getTimeOffset()
    {
      return ((Context)this.instance).getTimeOffset();
    }
    
    public Context.TraceInfo getTrace()
    {
      return ((Context)this.instance).getTrace();
    }
    
    public boolean hasAccount()
    {
      return ((Context)this.instance).hasAccount();
    }
    
    public boolean hasBnetId()
    {
      return ((Context)this.instance).hasBnetId();
    }
    
    public boolean hasHost()
    {
      return ((Context)this.instance).hasHost();
    }
    
    public boolean hasProgram()
    {
      return ((Context)this.instance).hasProgram();
    }
    
    public boolean hasRetryCount()
    {
      return ((Context)this.instance).hasRetryCount();
    }
    
    public boolean hasSessionId()
    {
      return ((Context)this.instance).hasSessionId();
    }
    
    public boolean hasSourceTime()
    {
      return ((Context)this.instance).hasSourceTime();
    }
    
    public boolean hasTimeOffset()
    {
      return ((Context)this.instance).hasTimeOffset();
    }
    
    public boolean hasTrace()
    {
      return ((Context)this.instance).hasTrace();
    }
    
    public Builder mergeHost(Context.HostInfo paramHostInfo)
    {
      copyOnWrite();
      ((Context)this.instance).mergeHost(paramHostInfo);
      return this;
    }
    
    public Builder mergeProgram(Context.ProgramInfo paramProgramInfo)
    {
      copyOnWrite();
      ((Context)this.instance).mergeProgram(paramProgramInfo);
      return this;
    }
    
    public Builder mergeTrace(Context.TraceInfo paramTraceInfo)
    {
      copyOnWrite();
      ((Context)this.instance).mergeTrace(paramTraceInfo);
      return this;
    }
    
    public Builder setAccount(long paramLong)
    {
      copyOnWrite();
      ((Context)this.instance).setAccount(paramLong);
      return this;
    }
    
    public Builder setBnetId(long paramLong)
    {
      copyOnWrite();
      ((Context)this.instance).setBnetId(paramLong);
      return this;
    }
    
    public Builder setHost(Context.HostInfo.Builder paramBuilder)
    {
      copyOnWrite();
      ((Context)this.instance).setHost(paramBuilder);
      return this;
    }
    
    public Builder setHost(Context.HostInfo paramHostInfo)
    {
      copyOnWrite();
      ((Context)this.instance).setHost(paramHostInfo);
      return this;
    }
    
    public Builder setProgram(Context.ProgramInfo.Builder paramBuilder)
    {
      copyOnWrite();
      ((Context)this.instance).setProgram(paramBuilder);
      return this;
    }
    
    public Builder setProgram(Context.ProgramInfo paramProgramInfo)
    {
      copyOnWrite();
      ((Context)this.instance).setProgram(paramProgramInfo);
      return this;
    }
    
    public Builder setRetryCount(int paramInt)
    {
      copyOnWrite();
      ((Context)this.instance).setRetryCount(paramInt);
      return this;
    }
    
    public Builder setSessionId(String paramString)
    {
      copyOnWrite();
      ((Context)this.instance).setSessionId(paramString);
      return this;
    }
    
    public Builder setSessionIdBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Context)this.instance).setSessionIdBytes(paramByteString);
      return this;
    }
    
    public Builder setSourceTime(long paramLong)
    {
      copyOnWrite();
      ((Context)this.instance).setSourceTime(paramLong);
      return this;
    }
    
    public Builder setTimeOffset(long paramLong)
    {
      copyOnWrite();
      ((Context)this.instance).setTimeOffset(paramLong);
      return this;
    }
    
    public Builder setTrace(Context.TraceInfo.Builder paramBuilder)
    {
      copyOnWrite();
      ((Context)this.instance).setTrace(paramBuilder);
      return this;
    }
    
    public Builder setTrace(Context.TraceInfo paramTraceInfo)
    {
      copyOnWrite();
      ((Context)this.instance).setTrace(paramTraceInfo);
      return this;
    }
  }
  
  public static final class HostInfo
    extends GeneratedMessageLite<HostInfo, Builder>
    implements Context.HostInfoOrBuilder
  {
    public static final int ARCH_FIELD_NUMBER = 10;
    private static final HostInfo DEFAULT_INSTANCE = new HostInfo();
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int OS_NAME_FIELD_NUMBER = 20;
    public static final int OS_VERSION_FIELD_NUMBER = 21;
    private static volatile Parser<HostInfo> PARSER;
    public static final int PLATFORM_FIELD_NUMBER = 5;
    public static final int SITE_FIELD_NUMBER = 4;
    public static final int TAG_FIELD_NUMBER = 100;
    public static final int TYPE_FIELD_NUMBER = 3;
    private String arch_ = "";
    private int bitField0_;
    private String id_ = "";
    private String name_ = "";
    private String osName_ = "";
    private String osVersion_ = "";
    private String platform_ = "";
    private String site_ = "";
    private Internal.ProtobufList<String> tag_ = GeneratedMessageLite.emptyProtobufList();
    private String type_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllTag(Iterable<String> paramIterable)
    {
      ensureTagIsMutable();
      AbstractMessageLite.addAll(paramIterable, this.tag_);
    }
    
    private void addTag(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      ensureTagIsMutable();
      this.tag_.add(paramString);
    }
    
    private void addTagBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      ensureTagIsMutable();
      this.tag_.add(paramByteString.toStringUtf8());
    }
    
    private void clearArch()
    {
      this.bitField0_ &= 0xFFFFFFDF;
      this.arch_ = getDefaultInstance().getArch();
    }
    
    private void clearId()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.id_ = getDefaultInstance().getId();
    }
    
    private void clearName()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.name_ = getDefaultInstance().getName();
    }
    
    private void clearOsName()
    {
      this.bitField0_ &= 0xFFFFFFBF;
      this.osName_ = getDefaultInstance().getOsName();
    }
    
    private void clearOsVersion()
    {
      this.bitField0_ &= 0xFF7F;
      this.osVersion_ = getDefaultInstance().getOsVersion();
    }
    
    private void clearPlatform()
    {
      this.bitField0_ &= 0xFFFFFFEF;
      this.platform_ = getDefaultInstance().getPlatform();
    }
    
    private void clearSite()
    {
      this.bitField0_ &= 0xFFFFFFF7;
      this.site_ = getDefaultInstance().getSite();
    }
    
    private void clearTag()
    {
      this.tag_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void clearType()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.type_ = getDefaultInstance().getType();
    }
    
    private void ensureTagIsMutable()
    {
      if (!this.tag_.isModifiable()) {
        this.tag_ = GeneratedMessageLite.mutableCopy(this.tag_);
      }
    }
    
    public static HostInfo getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(HostInfo paramHostInfo)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramHostInfo);
    }
    
    public static HostInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (HostInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static HostInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (HostInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static HostInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (HostInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static HostInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (HostInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static HostInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (HostInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static HostInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (HostInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static HostInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (HostInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static HostInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (HostInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static HostInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (HostInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static HostInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (HostInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<HostInfo> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setArch(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x20;
      this.arch_ = paramString;
    }
    
    private void setArchBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x20;
      this.arch_ = paramByteString.toStringUtf8();
    }
    
    private void setId(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.id_ = paramString;
    }
    
    private void setIdBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.id_ = paramByteString.toStringUtf8();
    }
    
    private void setName(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.name_ = paramString;
    }
    
    private void setNameBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.name_ = paramByteString.toStringUtf8();
    }
    
    private void setOsName(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x40;
      this.osName_ = paramString;
    }
    
    private void setOsNameBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x40;
      this.osName_ = paramByteString.toStringUtf8();
    }
    
    private void setOsVersion(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x80;
      this.osVersion_ = paramString;
    }
    
    private void setOsVersionBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x80;
      this.osVersion_ = paramByteString.toStringUtf8();
    }
    
    private void setPlatform(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x10;
      this.platform_ = paramString;
    }
    
    private void setPlatformBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x10;
      this.platform_ = paramByteString.toStringUtf8();
    }
    
    private void setSite(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x8;
      this.site_ = paramString;
    }
    
    private void setSiteBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x8;
      this.site_ = paramByteString.toStringUtf8();
    }
    
    private void setTag(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      ensureTagIsMutable();
      this.tag_.set(paramInt, paramString);
    }
    
    private void setType(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.type_ = paramString;
    }
    
    private void setTypeBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.type_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 348	com/blizzard/telemetry/proto/Context$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 354	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+81->89, 5:+90->98, 6:+350->358, 7:+757->765, 8:+761->769
      //   56: new 356	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 357	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/telemetry/proto/Context$HostInfo
      //   67: dup
      //   68: invokespecial 55	com/blizzard/telemetry/proto/Context$HostInfo:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 57	com/blizzard/telemetry/proto/Context$HostInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$HostInfo;
      //   77: areturn
      //   78: aload_0
      //   79: getfield 86	com/blizzard/telemetry/proto/Context$HostInfo:tag_	Lcom/google/protobuf/Internal$ProtobufList;
      //   82: invokeinterface 358 1 0
      //   87: aconst_null
      //   88: areturn
      //   89: new 12	com/blizzard/telemetry/proto/Context$HostInfo$Builder
      //   92: dup
      //   93: aconst_null
      //   94: invokespecial 361	com/blizzard/telemetry/proto/Context$HostInfo$Builder:<init>	(Lcom/blizzard/telemetry/proto/Context$1;)V
      //   97: areturn
      //   98: aload_2
      //   99: checkcast 363	com/google/protobuf/GeneratedMessageLite$Visitor
      //   102: astore_2
      //   103: aload_3
      //   104: checkcast 2	com/blizzard/telemetry/proto/Context$HostInfo
      //   107: astore_3
      //   108: aload_0
      //   109: aload_2
      //   110: aload_0
      //   111: invokevirtual 366	com/blizzard/telemetry/proto/Context$HostInfo:hasId	()Z
      //   114: aload_0
      //   115: getfield 66	com/blizzard/telemetry/proto/Context$HostInfo:id_	Ljava/lang/String;
      //   118: aload_3
      //   119: invokevirtual 366	com/blizzard/telemetry/proto/Context$HostInfo:hasId	()Z
      //   122: aload_3
      //   123: getfield 66	com/blizzard/telemetry/proto/Context$HostInfo:id_	Ljava/lang/String;
      //   126: invokeinterface 370 5 0
      //   131: putfield 66	com/blizzard/telemetry/proto/Context$HostInfo:id_	Ljava/lang/String;
      //   134: aload_0
      //   135: aload_2
      //   136: aload_0
      //   137: invokevirtual 373	com/blizzard/telemetry/proto/Context$HostInfo:hasName	()Z
      //   140: aload_0
      //   141: getfield 68	com/blizzard/telemetry/proto/Context$HostInfo:name_	Ljava/lang/String;
      //   144: aload_3
      //   145: invokevirtual 373	com/blizzard/telemetry/proto/Context$HostInfo:hasName	()Z
      //   148: aload_3
      //   149: getfield 68	com/blizzard/telemetry/proto/Context$HostInfo:name_	Ljava/lang/String;
      //   152: invokeinterface 370 5 0
      //   157: putfield 68	com/blizzard/telemetry/proto/Context$HostInfo:name_	Ljava/lang/String;
      //   160: aload_0
      //   161: aload_2
      //   162: aload_0
      //   163: invokevirtual 376	com/blizzard/telemetry/proto/Context$HostInfo:hasType	()Z
      //   166: aload_0
      //   167: getfield 70	com/blizzard/telemetry/proto/Context$HostInfo:type_	Ljava/lang/String;
      //   170: aload_3
      //   171: invokevirtual 376	com/blizzard/telemetry/proto/Context$HostInfo:hasType	()Z
      //   174: aload_3
      //   175: getfield 70	com/blizzard/telemetry/proto/Context$HostInfo:type_	Ljava/lang/String;
      //   178: invokeinterface 370 5 0
      //   183: putfield 70	com/blizzard/telemetry/proto/Context$HostInfo:type_	Ljava/lang/String;
      //   186: aload_0
      //   187: aload_2
      //   188: aload_0
      //   189: invokevirtual 379	com/blizzard/telemetry/proto/Context$HostInfo:hasSite	()Z
      //   192: aload_0
      //   193: getfield 72	com/blizzard/telemetry/proto/Context$HostInfo:site_	Ljava/lang/String;
      //   196: aload_3
      //   197: invokevirtual 379	com/blizzard/telemetry/proto/Context$HostInfo:hasSite	()Z
      //   200: aload_3
      //   201: getfield 72	com/blizzard/telemetry/proto/Context$HostInfo:site_	Ljava/lang/String;
      //   204: invokeinterface 370 5 0
      //   209: putfield 72	com/blizzard/telemetry/proto/Context$HostInfo:site_	Ljava/lang/String;
      //   212: aload_0
      //   213: aload_2
      //   214: aload_0
      //   215: invokevirtual 382	com/blizzard/telemetry/proto/Context$HostInfo:hasPlatform	()Z
      //   218: aload_0
      //   219: getfield 74	com/blizzard/telemetry/proto/Context$HostInfo:platform_	Ljava/lang/String;
      //   222: aload_3
      //   223: invokevirtual 382	com/blizzard/telemetry/proto/Context$HostInfo:hasPlatform	()Z
      //   226: aload_3
      //   227: getfield 74	com/blizzard/telemetry/proto/Context$HostInfo:platform_	Ljava/lang/String;
      //   230: invokeinterface 370 5 0
      //   235: putfield 74	com/blizzard/telemetry/proto/Context$HostInfo:platform_	Ljava/lang/String;
      //   238: aload_0
      //   239: aload_2
      //   240: aload_0
      //   241: invokevirtual 385	com/blizzard/telemetry/proto/Context$HostInfo:hasArch	()Z
      //   244: aload_0
      //   245: getfield 76	com/blizzard/telemetry/proto/Context$HostInfo:arch_	Ljava/lang/String;
      //   248: aload_3
      //   249: invokevirtual 385	com/blizzard/telemetry/proto/Context$HostInfo:hasArch	()Z
      //   252: aload_3
      //   253: getfield 76	com/blizzard/telemetry/proto/Context$HostInfo:arch_	Ljava/lang/String;
      //   256: invokeinterface 370 5 0
      //   261: putfield 76	com/blizzard/telemetry/proto/Context$HostInfo:arch_	Ljava/lang/String;
      //   264: aload_0
      //   265: aload_2
      //   266: aload_0
      //   267: invokevirtual 388	com/blizzard/telemetry/proto/Context$HostInfo:hasOsName	()Z
      //   270: aload_0
      //   271: getfield 78	com/blizzard/telemetry/proto/Context$HostInfo:osName_	Ljava/lang/String;
      //   274: aload_3
      //   275: invokevirtual 388	com/blizzard/telemetry/proto/Context$HostInfo:hasOsName	()Z
      //   278: aload_3
      //   279: getfield 78	com/blizzard/telemetry/proto/Context$HostInfo:osName_	Ljava/lang/String;
      //   282: invokeinterface 370 5 0
      //   287: putfield 78	com/blizzard/telemetry/proto/Context$HostInfo:osName_	Ljava/lang/String;
      //   290: aload_0
      //   291: aload_2
      //   292: aload_0
      //   293: invokevirtual 391	com/blizzard/telemetry/proto/Context$HostInfo:hasOsVersion	()Z
      //   296: aload_0
      //   297: getfield 80	com/blizzard/telemetry/proto/Context$HostInfo:osVersion_	Ljava/lang/String;
      //   300: aload_3
      //   301: invokevirtual 391	com/blizzard/telemetry/proto/Context$HostInfo:hasOsVersion	()Z
      //   304: aload_3
      //   305: getfield 80	com/blizzard/telemetry/proto/Context$HostInfo:osVersion_	Ljava/lang/String;
      //   308: invokeinterface 370 5 0
      //   313: putfield 80	com/blizzard/telemetry/proto/Context$HostInfo:osVersion_	Ljava/lang/String;
      //   316: aload_0
      //   317: aload_2
      //   318: aload_0
      //   319: getfield 86	com/blizzard/telemetry/proto/Context$HostInfo:tag_	Lcom/google/protobuf/Internal$ProtobufList;
      //   322: aload_3
      //   323: getfield 86	com/blizzard/telemetry/proto/Context$HostInfo:tag_	Lcom/google/protobuf/Internal$ProtobufList;
      //   326: invokeinterface 395 3 0
      //   331: putfield 86	com/blizzard/telemetry/proto/Context$HostInfo:tag_	Lcom/google/protobuf/Internal$ProtobufList;
      //   334: aload_0
      //   335: astore_1
      //   336: aload_2
      //   337: getstatic 401	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   340: if_acmpne -268 -> 72
      //   343: aload_0
      //   344: aload_0
      //   345: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   348: aload_3
      //   349: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   352: ior
      //   353: putfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   356: aload_0
      //   357: areturn
      //   358: aload_2
      //   359: checkcast 403	com/google/protobuf/CodedInputStream
      //   362: astore_1
      //   363: aload_3
      //   364: checkcast 405	com/google/protobuf/ExtensionRegistryLite
      //   367: astore_2
      //   368: iconst_0
      //   369: istore 4
      //   371: iload 4
      //   373: ifne +392 -> 765
      //   376: aload_1
      //   377: invokevirtual 408	com/google/protobuf/CodedInputStream:readTag	()I
      //   380: istore 5
      //   382: iload 5
      //   384: lookupswitch	default:+426->810, 0:+429->813, 10:+108->492, 18:+148->532, 26:+195->579, 34:+218->602, 42:+242->626, 82:+266->650, 162:+290->674, 170:+314->698, 802:+339->723
      //   476: aload_0
      //   477: iload 5
      //   479: aload_1
      //   480: invokevirtual 412	com/blizzard/telemetry/proto/Context$HostInfo:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   483: ifne -112 -> 371
      //   486: iconst_1
      //   487: istore 4
      //   489: goto -118 -> 371
      //   492: aload_1
      //   493: invokevirtual 415	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   496: astore_2
      //   497: aload_0
      //   498: aload_0
      //   499: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   502: iconst_1
      //   503: ior
      //   504: putfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   507: aload_0
      //   508: aload_2
      //   509: putfield 66	com/blizzard/telemetry/proto/Context$HostInfo:id_	Ljava/lang/String;
      //   512: goto -141 -> 371
      //   515: astore_1
      //   516: new 417	java/lang/RuntimeException
      //   519: dup
      //   520: aload_1
      //   521: aload_0
      //   522: invokevirtual 421	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   525: invokespecial 424	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   528: athrow
      //   529: astore_1
      //   530: aload_1
      //   531: athrow
      //   532: aload_1
      //   533: invokevirtual 415	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   536: astore_2
      //   537: aload_0
      //   538: aload_0
      //   539: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   542: iconst_2
      //   543: ior
      //   544: putfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   547: aload_0
      //   548: aload_2
      //   549: putfield 68	com/blizzard/telemetry/proto/Context$HostInfo:name_	Ljava/lang/String;
      //   552: goto -181 -> 371
      //   555: astore_1
      //   556: new 417	java/lang/RuntimeException
      //   559: dup
      //   560: new 303	com/google/protobuf/InvalidProtocolBufferException
      //   563: dup
      //   564: aload_1
      //   565: invokevirtual 427	java/io/IOException:getMessage	()Ljava/lang/String;
      //   568: invokespecial 429	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   571: aload_0
      //   572: invokevirtual 421	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   575: invokespecial 424	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   578: athrow
      //   579: aload_1
      //   580: invokevirtual 415	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   583: astore_2
      //   584: aload_0
      //   585: aload_0
      //   586: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   589: iconst_4
      //   590: ior
      //   591: putfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   594: aload_0
      //   595: aload_2
      //   596: putfield 70	com/blizzard/telemetry/proto/Context$HostInfo:type_	Ljava/lang/String;
      //   599: goto -228 -> 371
      //   602: aload_1
      //   603: invokevirtual 415	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   606: astore_2
      //   607: aload_0
      //   608: aload_0
      //   609: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   612: bipush 8
      //   614: ior
      //   615: putfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   618: aload_0
      //   619: aload_2
      //   620: putfield 72	com/blizzard/telemetry/proto/Context$HostInfo:site_	Ljava/lang/String;
      //   623: goto -252 -> 371
      //   626: aload_1
      //   627: invokevirtual 415	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   630: astore_2
      //   631: aload_0
      //   632: aload_0
      //   633: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   636: bipush 16
      //   638: ior
      //   639: putfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   642: aload_0
      //   643: aload_2
      //   644: putfield 74	com/blizzard/telemetry/proto/Context$HostInfo:platform_	Ljava/lang/String;
      //   647: goto -276 -> 371
      //   650: aload_1
      //   651: invokevirtual 415	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   654: astore_2
      //   655: aload_0
      //   656: aload_0
      //   657: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   660: bipush 32
      //   662: ior
      //   663: putfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   666: aload_0
      //   667: aload_2
      //   668: putfield 76	com/blizzard/telemetry/proto/Context$HostInfo:arch_	Ljava/lang/String;
      //   671: goto -300 -> 371
      //   674: aload_1
      //   675: invokevirtual 415	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   678: astore_2
      //   679: aload_0
      //   680: aload_0
      //   681: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   684: bipush 64
      //   686: ior
      //   687: putfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   690: aload_0
      //   691: aload_2
      //   692: putfield 78	com/blizzard/telemetry/proto/Context$HostInfo:osName_	Ljava/lang/String;
      //   695: goto -324 -> 371
      //   698: aload_1
      //   699: invokevirtual 415	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   702: astore_2
      //   703: aload_0
      //   704: aload_0
      //   705: getfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   708: sipush 128
      //   711: ior
      //   712: putfield 241	com/blizzard/telemetry/proto/Context$HostInfo:bitField0_	I
      //   715: aload_0
      //   716: aload_2
      //   717: putfield 80	com/blizzard/telemetry/proto/Context$HostInfo:osVersion_	Ljava/lang/String;
      //   720: goto -349 -> 371
      //   723: aload_1
      //   724: invokevirtual 415	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   727: astore_2
      //   728: aload_0
      //   729: getfield 86	com/blizzard/telemetry/proto/Context$HostInfo:tag_	Lcom/google/protobuf/Internal$ProtobufList;
      //   732: invokeinterface 272 1 0
      //   737: ifne +14 -> 751
      //   740: aload_0
      //   741: aload_0
      //   742: getfield 86	com/blizzard/telemetry/proto/Context$HostInfo:tag_	Lcom/google/protobuf/Internal$ProtobufList;
      //   745: invokestatic 276	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   748: putfield 86	com/blizzard/telemetry/proto/Context$HostInfo:tag_	Lcom/google/protobuf/Internal$ProtobufList;
      //   751: aload_0
      //   752: getfield 86	com/blizzard/telemetry/proto/Context$HostInfo:tag_	Lcom/google/protobuf/Internal$ProtobufList;
      //   755: aload_2
      //   756: invokeinterface 233 2 0
      //   761: pop
      //   762: goto -391 -> 371
      //   765: getstatic 57	com/blizzard/telemetry/proto/Context$HostInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$HostInfo;
      //   768: areturn
      //   769: getstatic 431	com/blizzard/telemetry/proto/Context$HostInfo:PARSER	Lcom/google/protobuf/Parser;
      //   772: ifnonnull +28 -> 800
      //   775: ldc 2
      //   777: monitorenter
      //   778: getstatic 431	com/blizzard/telemetry/proto/Context$HostInfo:PARSER	Lcom/google/protobuf/Parser;
      //   781: ifnonnull +16 -> 797
      //   784: new 433	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   787: dup
      //   788: getstatic 57	com/blizzard/telemetry/proto/Context$HostInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$HostInfo;
      //   791: invokespecial 436	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   794: putstatic 431	com/blizzard/telemetry/proto/Context$HostInfo:PARSER	Lcom/google/protobuf/Parser;
      //   797: ldc 2
      //   799: monitorexit
      //   800: getstatic 431	com/blizzard/telemetry/proto/Context$HostInfo:PARSER	Lcom/google/protobuf/Parser;
      //   803: areturn
      //   804: astore_1
      //   805: ldc 2
      //   807: monitorexit
      //   808: aload_1
      //   809: athrow
      //   810: goto -334 -> 476
      //   813: iconst_1
      //   814: istore 4
      //   816: goto -445 -> 371
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	819	0	this	HostInfo
      //   0	819	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	819	2	paramObject1	Object
      //   0	819	3	paramObject2	Object
      //   369	446	4	i	int
      //   380	98	5	j	int
      // Exception table:
      //   from	to	target	type
      //   376	382	515	com/google/protobuf/InvalidProtocolBufferException
      //   476	486	515	com/google/protobuf/InvalidProtocolBufferException
      //   492	512	515	com/google/protobuf/InvalidProtocolBufferException
      //   532	552	515	com/google/protobuf/InvalidProtocolBufferException
      //   579	599	515	com/google/protobuf/InvalidProtocolBufferException
      //   602	623	515	com/google/protobuf/InvalidProtocolBufferException
      //   626	647	515	com/google/protobuf/InvalidProtocolBufferException
      //   650	671	515	com/google/protobuf/InvalidProtocolBufferException
      //   674	695	515	com/google/protobuf/InvalidProtocolBufferException
      //   698	720	515	com/google/protobuf/InvalidProtocolBufferException
      //   723	751	515	com/google/protobuf/InvalidProtocolBufferException
      //   751	762	515	com/google/protobuf/InvalidProtocolBufferException
      //   376	382	529	finally
      //   476	486	529	finally
      //   492	512	529	finally
      //   516	529	529	finally
      //   532	552	529	finally
      //   556	579	529	finally
      //   579	599	529	finally
      //   602	623	529	finally
      //   626	647	529	finally
      //   650	671	529	finally
      //   674	695	529	finally
      //   698	720	529	finally
      //   723	751	529	finally
      //   751	762	529	finally
      //   376	382	555	java/io/IOException
      //   476	486	555	java/io/IOException
      //   492	512	555	java/io/IOException
      //   532	552	555	java/io/IOException
      //   579	599	555	java/io/IOException
      //   602	623	555	java/io/IOException
      //   626	647	555	java/io/IOException
      //   650	671	555	java/io/IOException
      //   674	695	555	java/io/IOException
      //   698	720	555	java/io/IOException
      //   723	751	555	java/io/IOException
      //   751	762	555	java/io/IOException
      //   778	797	804	finally
      //   797	800	804	finally
      //   805	808	804	finally
    }
    
    public String getArch()
    {
      return this.arch_;
    }
    
    public ByteString getArchBytes()
    {
      return ByteString.copyFromUtf8(this.arch_);
    }
    
    public String getId()
    {
      return this.id_;
    }
    
    public ByteString getIdBytes()
    {
      return ByteString.copyFromUtf8(this.id_);
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public ByteString getNameBytes()
    {
      return ByteString.copyFromUtf8(this.name_);
    }
    
    public String getOsName()
    {
      return this.osName_;
    }
    
    public ByteString getOsNameBytes()
    {
      return ByteString.copyFromUtf8(this.osName_);
    }
    
    public String getOsVersion()
    {
      return this.osVersion_;
    }
    
    public ByteString getOsVersionBytes()
    {
      return ByteString.copyFromUtf8(this.osVersion_);
    }
    
    public String getPlatform()
    {
      return this.platform_;
    }
    
    public ByteString getPlatformBytes()
    {
      return ByteString.copyFromUtf8(this.platform_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeStringSize(1, getId());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeStringSize(2, getName());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeStringSize(3, getType());
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeStringSize(4, getSite());
      }
      j = i;
      if ((this.bitField0_ & 0x10) == 16) {
        j = i + CodedOutputStream.computeStringSize(5, getPlatform());
      }
      i = j;
      if ((this.bitField0_ & 0x20) == 32) {
        i = j + CodedOutputStream.computeStringSize(10, getArch());
      }
      j = i;
      if ((this.bitField0_ & 0x40) == 64) {
        j = i + CodedOutputStream.computeStringSize(20, getOsName());
      }
      i = j;
      if ((this.bitField0_ & 0x80) == 128) {
        i = j + CodedOutputStream.computeStringSize(21, getOsVersion());
      }
      int k = 0;
      j = 0;
      while (j < this.tag_.size())
      {
        k += CodedOutputStream.computeStringSizeNoTag((String)this.tag_.get(j));
        j += 1;
      }
      i = i + k + getTagList().size() * 2 + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getSite()
    {
      return this.site_;
    }
    
    public ByteString getSiteBytes()
    {
      return ByteString.copyFromUtf8(this.site_);
    }
    
    public String getTag(int paramInt)
    {
      return (String)this.tag_.get(paramInt);
    }
    
    public ByteString getTagBytes(int paramInt)
    {
      return ByteString.copyFromUtf8((String)this.tag_.get(paramInt));
    }
    
    public int getTagCount()
    {
      return this.tag_.size();
    }
    
    public List<String> getTagList()
    {
      return this.tag_;
    }
    
    public String getType()
    {
      return this.type_;
    }
    
    public ByteString getTypeBytes()
    {
      return ByteString.copyFromUtf8(this.type_);
    }
    
    public boolean hasArch()
    {
      return (this.bitField0_ & 0x20) == 32;
    }
    
    public boolean hasId()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasName()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasOsName()
    {
      return (this.bitField0_ & 0x40) == 64;
    }
    
    public boolean hasOsVersion()
    {
      return (this.bitField0_ & 0x80) == 128;
    }
    
    public boolean hasPlatform()
    {
      return (this.bitField0_ & 0x10) == 16;
    }
    
    public boolean hasSite()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public boolean hasType()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getId());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeString(2, getName());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeString(3, getType());
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeString(4, getSite());
      }
      if ((this.bitField0_ & 0x10) == 16) {
        paramCodedOutputStream.writeString(5, getPlatform());
      }
      if ((this.bitField0_ & 0x20) == 32) {
        paramCodedOutputStream.writeString(10, getArch());
      }
      if ((this.bitField0_ & 0x40) == 64) {
        paramCodedOutputStream.writeString(20, getOsName());
      }
      if ((this.bitField0_ & 0x80) == 128) {
        paramCodedOutputStream.writeString(21, getOsVersion());
      }
      int i = 0;
      while (i < this.tag_.size())
      {
        paramCodedOutputStream.writeString(100, (String)this.tag_.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<Context.HostInfo, Builder>
      implements Context.HostInfoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder addAllTag(Iterable<String> paramIterable)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).addAllTag(paramIterable);
        return this;
      }
      
      public Builder addTag(String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).addTag(paramString);
        return this;
      }
      
      public Builder addTagBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).addTagBytes(paramByteString);
        return this;
      }
      
      public Builder clearArch()
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).clearArch();
        return this;
      }
      
      public Builder clearId()
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).clearId();
        return this;
      }
      
      public Builder clearName()
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).clearName();
        return this;
      }
      
      public Builder clearOsName()
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).clearOsName();
        return this;
      }
      
      public Builder clearOsVersion()
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).clearOsVersion();
        return this;
      }
      
      public Builder clearPlatform()
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).clearPlatform();
        return this;
      }
      
      public Builder clearSite()
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).clearSite();
        return this;
      }
      
      public Builder clearTag()
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).clearTag();
        return this;
      }
      
      public Builder clearType()
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).clearType();
        return this;
      }
      
      public String getArch()
      {
        return ((Context.HostInfo)this.instance).getArch();
      }
      
      public ByteString getArchBytes()
      {
        return ((Context.HostInfo)this.instance).getArchBytes();
      }
      
      public String getId()
      {
        return ((Context.HostInfo)this.instance).getId();
      }
      
      public ByteString getIdBytes()
      {
        return ((Context.HostInfo)this.instance).getIdBytes();
      }
      
      public String getName()
      {
        return ((Context.HostInfo)this.instance).getName();
      }
      
      public ByteString getNameBytes()
      {
        return ((Context.HostInfo)this.instance).getNameBytes();
      }
      
      public String getOsName()
      {
        return ((Context.HostInfo)this.instance).getOsName();
      }
      
      public ByteString getOsNameBytes()
      {
        return ((Context.HostInfo)this.instance).getOsNameBytes();
      }
      
      public String getOsVersion()
      {
        return ((Context.HostInfo)this.instance).getOsVersion();
      }
      
      public ByteString getOsVersionBytes()
      {
        return ((Context.HostInfo)this.instance).getOsVersionBytes();
      }
      
      public String getPlatform()
      {
        return ((Context.HostInfo)this.instance).getPlatform();
      }
      
      public ByteString getPlatformBytes()
      {
        return ((Context.HostInfo)this.instance).getPlatformBytes();
      }
      
      public String getSite()
      {
        return ((Context.HostInfo)this.instance).getSite();
      }
      
      public ByteString getSiteBytes()
      {
        return ((Context.HostInfo)this.instance).getSiteBytes();
      }
      
      public String getTag(int paramInt)
      {
        return ((Context.HostInfo)this.instance).getTag(paramInt);
      }
      
      public ByteString getTagBytes(int paramInt)
      {
        return ((Context.HostInfo)this.instance).getTagBytes(paramInt);
      }
      
      public int getTagCount()
      {
        return ((Context.HostInfo)this.instance).getTagCount();
      }
      
      public List<String> getTagList()
      {
        return Collections.unmodifiableList(((Context.HostInfo)this.instance).getTagList());
      }
      
      public String getType()
      {
        return ((Context.HostInfo)this.instance).getType();
      }
      
      public ByteString getTypeBytes()
      {
        return ((Context.HostInfo)this.instance).getTypeBytes();
      }
      
      public boolean hasArch()
      {
        return ((Context.HostInfo)this.instance).hasArch();
      }
      
      public boolean hasId()
      {
        return ((Context.HostInfo)this.instance).hasId();
      }
      
      public boolean hasName()
      {
        return ((Context.HostInfo)this.instance).hasName();
      }
      
      public boolean hasOsName()
      {
        return ((Context.HostInfo)this.instance).hasOsName();
      }
      
      public boolean hasOsVersion()
      {
        return ((Context.HostInfo)this.instance).hasOsVersion();
      }
      
      public boolean hasPlatform()
      {
        return ((Context.HostInfo)this.instance).hasPlatform();
      }
      
      public boolean hasSite()
      {
        return ((Context.HostInfo)this.instance).hasSite();
      }
      
      public boolean hasType()
      {
        return ((Context.HostInfo)this.instance).hasType();
      }
      
      public Builder setArch(String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setArch(paramString);
        return this;
      }
      
      public Builder setArchBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setArchBytes(paramByteString);
        return this;
      }
      
      public Builder setId(String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setId(paramString);
        return this;
      }
      
      public Builder setIdBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setIdBytes(paramByteString);
        return this;
      }
      
      public Builder setName(String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setName(paramString);
        return this;
      }
      
      public Builder setNameBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setNameBytes(paramByteString);
        return this;
      }
      
      public Builder setOsName(String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setOsName(paramString);
        return this;
      }
      
      public Builder setOsNameBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setOsNameBytes(paramByteString);
        return this;
      }
      
      public Builder setOsVersion(String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setOsVersion(paramString);
        return this;
      }
      
      public Builder setOsVersionBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setOsVersionBytes(paramByteString);
        return this;
      }
      
      public Builder setPlatform(String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setPlatform(paramString);
        return this;
      }
      
      public Builder setPlatformBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setPlatformBytes(paramByteString);
        return this;
      }
      
      public Builder setSite(String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setSite(paramString);
        return this;
      }
      
      public Builder setSiteBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setSiteBytes(paramByteString);
        return this;
      }
      
      public Builder setTag(int paramInt, String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setTag(paramInt, paramString);
        return this;
      }
      
      public Builder setType(String paramString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setType(paramString);
        return this;
      }
      
      public Builder setTypeBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.HostInfo)this.instance).setTypeBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface HostInfoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getArch();
    
    public abstract ByteString getArchBytes();
    
    public abstract String getId();
    
    public abstract ByteString getIdBytes();
    
    public abstract String getName();
    
    public abstract ByteString getNameBytes();
    
    public abstract String getOsName();
    
    public abstract ByteString getOsNameBytes();
    
    public abstract String getOsVersion();
    
    public abstract ByteString getOsVersionBytes();
    
    public abstract String getPlatform();
    
    public abstract ByteString getPlatformBytes();
    
    public abstract String getSite();
    
    public abstract ByteString getSiteBytes();
    
    public abstract String getTag(int paramInt);
    
    public abstract ByteString getTagBytes(int paramInt);
    
    public abstract int getTagCount();
    
    public abstract List<String> getTagList();
    
    public abstract String getType();
    
    public abstract ByteString getTypeBytes();
    
    public abstract boolean hasArch();
    
    public abstract boolean hasId();
    
    public abstract boolean hasName();
    
    public abstract boolean hasOsName();
    
    public abstract boolean hasOsVersion();
    
    public abstract boolean hasPlatform();
    
    public abstract boolean hasSite();
    
    public abstract boolean hasType();
  }
  
  public static final class ProgramInfo
    extends GeneratedMessageLite<ProgramInfo, Builder>
    implements Context.ProgramInfoOrBuilder
  {
    private static final ProgramInfo DEFAULT_INSTANCE = new ProgramInfo();
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile Parser<ProgramInfo> PARSER;
    public static final int SDK_FIELD_NUMBER = 100;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int bitField0_;
    private String id_ = "";
    private String name_ = "";
    private SdkInfo sdk_;
    private String version_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearId()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.id_ = getDefaultInstance().getId();
    }
    
    private void clearName()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.name_ = getDefaultInstance().getName();
    }
    
    private void clearSdk()
    {
      this.sdk_ = null;
      this.bitField0_ &= 0xFFFFFFF7;
    }
    
    private void clearVersion()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.version_ = getDefaultInstance().getVersion();
    }
    
    public static ProgramInfo getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeSdk(SdkInfo paramSdkInfo)
    {
      if ((this.sdk_ != null) && (this.sdk_ != SdkInfo.getDefaultInstance())) {}
      for (this.sdk_ = ((SdkInfo)((Context.ProgramInfo.SdkInfo.Builder)SdkInfo.newBuilder(this.sdk_).mergeFrom(paramSdkInfo)).buildPartial());; this.sdk_ = paramSdkInfo)
      {
        this.bitField0_ |= 0x8;
        return;
      }
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ProgramInfo paramProgramInfo)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramProgramInfo);
    }
    
    public static ProgramInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ProgramInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ProgramInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ProgramInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ProgramInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ProgramInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static ProgramInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ProgramInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static ProgramInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ProgramInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static ProgramInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ProgramInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ProgramInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ProgramInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static ProgramInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ProgramInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ProgramInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ProgramInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static ProgramInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ProgramInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<ProgramInfo> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setId(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.id_ = paramString;
    }
    
    private void setIdBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.id_ = paramByteString.toStringUtf8();
    }
    
    private void setName(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.name_ = paramString;
    }
    
    private void setNameBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.name_ = paramByteString.toStringUtf8();
    }
    
    private void setSdk(Context.ProgramInfo.SdkInfo.Builder paramBuilder)
    {
      this.sdk_ = ((SdkInfo)paramBuilder.build());
      this.bitField0_ |= 0x8;
    }
    
    private void setSdk(SdkInfo paramSdkInfo)
    {
      if (paramSdkInfo == null) {
        throw new NullPointerException();
      }
      this.sdk_ = paramSdkInfo;
      this.bitField0_ |= 0x8;
    }
    
    private void setVersion(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.version_ = paramString;
    }
    
    private void setVersionBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.version_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 232	com/blizzard/telemetry/proto/Context$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 238	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+214->222, 7:+496->504, 8:+500->508
      //   56: new 240	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 241	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/telemetry/proto/Context$ProgramInfo
      //   67: dup
      //   68: invokespecial 47	com/blizzard/telemetry/proto/Context$ProgramInfo:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 49	com/blizzard/telemetry/proto/Context$ProgramInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/blizzard/telemetry/proto/Context$ProgramInfo$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 244	com/blizzard/telemetry/proto/Context$ProgramInfo$Builder:<init>	(Lcom/blizzard/telemetry/proto/Context$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 246	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/blizzard/telemetry/proto/Context$ProgramInfo
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 250	com/blizzard/telemetry/proto/Context$ProgramInfo:hasId	()Z
      //   105: aload_0
      //   106: getfield 58	com/blizzard/telemetry/proto/Context$ProgramInfo:id_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 250	com/blizzard/telemetry/proto/Context$ProgramInfo:hasId	()Z
      //   113: aload_3
      //   114: getfield 58	com/blizzard/telemetry/proto/Context$ProgramInfo:id_	Ljava/lang/String;
      //   117: invokeinterface 254 5 0
      //   122: putfield 58	com/blizzard/telemetry/proto/Context$ProgramInfo:id_	Ljava/lang/String;
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 257	com/blizzard/telemetry/proto/Context$ProgramInfo:hasName	()Z
      //   131: aload_0
      //   132: getfield 60	com/blizzard/telemetry/proto/Context$ProgramInfo:name_	Ljava/lang/String;
      //   135: aload_3
      //   136: invokevirtual 257	com/blizzard/telemetry/proto/Context$ProgramInfo:hasName	()Z
      //   139: aload_3
      //   140: getfield 60	com/blizzard/telemetry/proto/Context$ProgramInfo:name_	Ljava/lang/String;
      //   143: invokeinterface 254 5 0
      //   148: putfield 60	com/blizzard/telemetry/proto/Context$ProgramInfo:name_	Ljava/lang/String;
      //   151: aload_0
      //   152: aload_2
      //   153: aload_0
      //   154: invokevirtual 260	com/blizzard/telemetry/proto/Context$ProgramInfo:hasVersion	()Z
      //   157: aload_0
      //   158: getfield 62	com/blizzard/telemetry/proto/Context$ProgramInfo:version_	Ljava/lang/String;
      //   161: aload_3
      //   162: invokevirtual 260	com/blizzard/telemetry/proto/Context$ProgramInfo:hasVersion	()Z
      //   165: aload_3
      //   166: getfield 62	com/blizzard/telemetry/proto/Context$ProgramInfo:version_	Ljava/lang/String;
      //   169: invokeinterface 254 5 0
      //   174: putfield 62	com/blizzard/telemetry/proto/Context$ProgramInfo:version_	Ljava/lang/String;
      //   177: aload_0
      //   178: aload_2
      //   179: aload_0
      //   180: getfield 138	com/blizzard/telemetry/proto/Context$ProgramInfo:sdk_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
      //   183: aload_3
      //   184: getfield 138	com/blizzard/telemetry/proto/Context$ProgramInfo:sdk_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
      //   187: invokeinterface 264 3 0
      //   192: checkcast 15	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo
      //   195: putfield 138	com/blizzard/telemetry/proto/Context$ProgramInfo:sdk_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
      //   198: aload_0
      //   199: astore_1
      //   200: aload_2
      //   201: getstatic 270	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   204: if_acmpne -132 -> 72
      //   207: aload_0
      //   208: aload_0
      //   209: getfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   212: aload_3
      //   213: getfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   216: ior
      //   217: putfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   220: aload_0
      //   221: areturn
      //   222: aload_2
      //   223: checkcast 272	com/google/protobuf/CodedInputStream
      //   226: astore_2
      //   227: aload_3
      //   228: checkcast 274	com/google/protobuf/ExtensionRegistryLite
      //   231: astore_3
      //   232: iconst_0
      //   233: istore 4
      //   235: iload 4
      //   237: ifne +267 -> 504
      //   240: aload_2
      //   241: invokevirtual 277	com/google/protobuf/CodedInputStream:readTag	()I
      //   244: istore 5
      //   246: iload 5
      //   248: lookupswitch	default:+301->549, 0:+304->552, 10:+68->316, 18:+108->356, 26:+155->403, 802:+178->426
      //   300: aload_0
      //   301: iload 5
      //   303: aload_2
      //   304: invokevirtual 281	com/blizzard/telemetry/proto/Context$ProgramInfo:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   307: ifne -72 -> 235
      //   310: iconst_1
      //   311: istore 4
      //   313: goto -78 -> 235
      //   316: aload_2
      //   317: invokevirtual 284	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   320: astore_1
      //   321: aload_0
      //   322: aload_0
      //   323: getfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   326: iconst_1
      //   327: ior
      //   328: putfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   331: aload_0
      //   332: aload_1
      //   333: putfield 58	com/blizzard/telemetry/proto/Context$ProgramInfo:id_	Ljava/lang/String;
      //   336: goto -101 -> 235
      //   339: astore_1
      //   340: new 286	java/lang/RuntimeException
      //   343: dup
      //   344: aload_1
      //   345: aload_0
      //   346: invokevirtual 290	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   349: invokespecial 293	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   352: athrow
      //   353: astore_1
      //   354: aload_1
      //   355: athrow
      //   356: aload_2
      //   357: invokevirtual 284	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   360: astore_1
      //   361: aload_0
      //   362: aload_0
      //   363: getfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   366: iconst_2
      //   367: ior
      //   368: putfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   371: aload_0
      //   372: aload_1
      //   373: putfield 60	com/blizzard/telemetry/proto/Context$ProgramInfo:name_	Ljava/lang/String;
      //   376: goto -141 -> 235
      //   379: astore_1
      //   380: new 286	java/lang/RuntimeException
      //   383: dup
      //   384: new 179	com/google/protobuf/InvalidProtocolBufferException
      //   387: dup
      //   388: aload_1
      //   389: invokevirtual 296	java/io/IOException:getMessage	()Ljava/lang/String;
      //   392: invokespecial 298	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   395: aload_0
      //   396: invokevirtual 290	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   399: invokespecial 293	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   402: athrow
      //   403: aload_2
      //   404: invokevirtual 284	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   407: astore_1
      //   408: aload_0
      //   409: aload_0
      //   410: getfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   413: iconst_4
      //   414: ior
      //   415: putfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   418: aload_0
      //   419: aload_1
      //   420: putfield 62	com/blizzard/telemetry/proto/Context$ProgramInfo:version_	Ljava/lang/String;
      //   423: goto -188 -> 235
      //   426: aconst_null
      //   427: astore_1
      //   428: aload_0
      //   429: getfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   432: bipush 8
      //   434: iand
      //   435: bipush 8
      //   437: if_icmpne +14 -> 451
      //   440: aload_0
      //   441: getfield 138	com/blizzard/telemetry/proto/Context$ProgramInfo:sdk_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
      //   444: invokevirtual 299	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:toBuilder	()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   447: checkcast 18	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo$Builder
      //   450: astore_1
      //   451: aload_0
      //   452: aload_2
      //   453: invokestatic 301	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:parser	()Lcom/google/protobuf/Parser;
      //   456: aload_3
      //   457: invokevirtual 305	com/google/protobuf/CodedInputStream:readMessage	(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   460: checkcast 15	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo
      //   463: putfield 138	com/blizzard/telemetry/proto/Context$ProgramInfo:sdk_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
      //   466: aload_1
      //   467: ifnull +23 -> 490
      //   470: aload_1
      //   471: aload_0
      //   472: getfield 138	com/blizzard/telemetry/proto/Context$ProgramInfo:sdk_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
      //   475: invokevirtual 152	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo$Builder:mergeFrom	(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   478: pop
      //   479: aload_0
      //   480: aload_1
      //   481: invokevirtual 156	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo$Builder:buildPartial	()Lcom/google/protobuf/GeneratedMessageLite;
      //   484: checkcast 15	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo
      //   487: putfield 138	com/blizzard/telemetry/proto/Context$ProgramInfo:sdk_	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
      //   490: aload_0
      //   491: aload_0
      //   492: getfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   495: bipush 8
      //   497: ior
      //   498: putfield 126	com/blizzard/telemetry/proto/Context$ProgramInfo:bitField0_	I
      //   501: goto -266 -> 235
      //   504: getstatic 49	com/blizzard/telemetry/proto/Context$ProgramInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
      //   507: areturn
      //   508: getstatic 307	com/blizzard/telemetry/proto/Context$ProgramInfo:PARSER	Lcom/google/protobuf/Parser;
      //   511: ifnonnull +28 -> 539
      //   514: ldc 2
      //   516: monitorenter
      //   517: getstatic 307	com/blizzard/telemetry/proto/Context$ProgramInfo:PARSER	Lcom/google/protobuf/Parser;
      //   520: ifnonnull +16 -> 536
      //   523: new 309	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   526: dup
      //   527: getstatic 49	com/blizzard/telemetry/proto/Context$ProgramInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$ProgramInfo;
      //   530: invokespecial 312	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   533: putstatic 307	com/blizzard/telemetry/proto/Context$ProgramInfo:PARSER	Lcom/google/protobuf/Parser;
      //   536: ldc 2
      //   538: monitorexit
      //   539: getstatic 307	com/blizzard/telemetry/proto/Context$ProgramInfo:PARSER	Lcom/google/protobuf/Parser;
      //   542: areturn
      //   543: astore_1
      //   544: ldc 2
      //   546: monitorexit
      //   547: aload_1
      //   548: athrow
      //   549: goto -249 -> 300
      //   552: iconst_1
      //   553: istore 4
      //   555: goto -320 -> 235
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	558	0	this	ProgramInfo
      //   0	558	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	558	2	paramObject1	Object
      //   0	558	3	paramObject2	Object
      //   233	321	4	i	int
      //   244	58	5	j	int
      // Exception table:
      //   from	to	target	type
      //   240	246	339	com/google/protobuf/InvalidProtocolBufferException
      //   300	310	339	com/google/protobuf/InvalidProtocolBufferException
      //   316	336	339	com/google/protobuf/InvalidProtocolBufferException
      //   356	376	339	com/google/protobuf/InvalidProtocolBufferException
      //   403	423	339	com/google/protobuf/InvalidProtocolBufferException
      //   428	451	339	com/google/protobuf/InvalidProtocolBufferException
      //   451	466	339	com/google/protobuf/InvalidProtocolBufferException
      //   470	490	339	com/google/protobuf/InvalidProtocolBufferException
      //   490	501	339	com/google/protobuf/InvalidProtocolBufferException
      //   240	246	353	finally
      //   300	310	353	finally
      //   316	336	353	finally
      //   340	353	353	finally
      //   356	376	353	finally
      //   380	403	353	finally
      //   403	423	353	finally
      //   428	451	353	finally
      //   451	466	353	finally
      //   470	490	353	finally
      //   490	501	353	finally
      //   240	246	379	java/io/IOException
      //   300	310	379	java/io/IOException
      //   316	336	379	java/io/IOException
      //   356	376	379	java/io/IOException
      //   403	423	379	java/io/IOException
      //   428	451	379	java/io/IOException
      //   451	466	379	java/io/IOException
      //   470	490	379	java/io/IOException
      //   490	501	379	java/io/IOException
      //   517	536	543	finally
      //   536	539	543	finally
      //   544	547	543	finally
    }
    
    public String getId()
    {
      return this.id_;
    }
    
    public ByteString getIdBytes()
    {
      return ByteString.copyFromUtf8(this.id_);
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public ByteString getNameBytes()
    {
      return ByteString.copyFromUtf8(this.name_);
    }
    
    public SdkInfo getSdk()
    {
      if (this.sdk_ == null) {
        return SdkInfo.getDefaultInstance();
      }
      return this.sdk_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeStringSize(1, getId());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeStringSize(2, getName());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeStringSize(3, getVersion());
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + CodedOutputStream.computeMessageSize(100, getSdk());
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getVersion()
    {
      return this.version_;
    }
    
    public ByteString getVersionBytes()
    {
      return ByteString.copyFromUtf8(this.version_);
    }
    
    public boolean hasId()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasName()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasSdk()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public boolean hasVersion()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getId());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeString(2, getName());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeString(3, getVersion());
      }
      if ((this.bitField0_ & 0x8) == 8) {
        paramCodedOutputStream.writeMessage(100, getSdk());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<Context.ProgramInfo, Builder>
      implements Context.ProgramInfoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearId()
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).clearId();
        return this;
      }
      
      public Builder clearName()
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).clearName();
        return this;
      }
      
      public Builder clearSdk()
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).clearSdk();
        return this;
      }
      
      public Builder clearVersion()
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).clearVersion();
        return this;
      }
      
      public String getId()
      {
        return ((Context.ProgramInfo)this.instance).getId();
      }
      
      public ByteString getIdBytes()
      {
        return ((Context.ProgramInfo)this.instance).getIdBytes();
      }
      
      public String getName()
      {
        return ((Context.ProgramInfo)this.instance).getName();
      }
      
      public ByteString getNameBytes()
      {
        return ((Context.ProgramInfo)this.instance).getNameBytes();
      }
      
      public Context.ProgramInfo.SdkInfo getSdk()
      {
        return ((Context.ProgramInfo)this.instance).getSdk();
      }
      
      public String getVersion()
      {
        return ((Context.ProgramInfo)this.instance).getVersion();
      }
      
      public ByteString getVersionBytes()
      {
        return ((Context.ProgramInfo)this.instance).getVersionBytes();
      }
      
      public boolean hasId()
      {
        return ((Context.ProgramInfo)this.instance).hasId();
      }
      
      public boolean hasName()
      {
        return ((Context.ProgramInfo)this.instance).hasName();
      }
      
      public boolean hasSdk()
      {
        return ((Context.ProgramInfo)this.instance).hasSdk();
      }
      
      public boolean hasVersion()
      {
        return ((Context.ProgramInfo)this.instance).hasVersion();
      }
      
      public Builder mergeSdk(Context.ProgramInfo.SdkInfo paramSdkInfo)
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).mergeSdk(paramSdkInfo);
        return this;
      }
      
      public Builder setId(String paramString)
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).setId(paramString);
        return this;
      }
      
      public Builder setIdBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).setIdBytes(paramByteString);
        return this;
      }
      
      public Builder setName(String paramString)
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).setName(paramString);
        return this;
      }
      
      public Builder setNameBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).setNameBytes(paramByteString);
        return this;
      }
      
      public Builder setSdk(Context.ProgramInfo.SdkInfo.Builder paramBuilder)
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).setSdk(paramBuilder);
        return this;
      }
      
      public Builder setSdk(Context.ProgramInfo.SdkInfo paramSdkInfo)
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).setSdk(paramSdkInfo);
        return this;
      }
      
      public Builder setVersion(String paramString)
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).setVersion(paramString);
        return this;
      }
      
      public Builder setVersionBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.ProgramInfo)this.instance).setVersionBytes(paramByteString);
        return this;
      }
    }
    
    public static final class SdkInfo
      extends GeneratedMessageLite<SdkInfo, Builder>
      implements Context.ProgramInfo.SdkInfoOrBuilder
    {
      private static final SdkInfo DEFAULT_INSTANCE = new SdkInfo();
      public static final int NAME_FIELD_NUMBER = 1;
      private static volatile Parser<SdkInfo> PARSER;
      public static final int VERSION_FIELD_NUMBER = 2;
      private int bitField0_;
      private String name_ = "";
      private String version_ = "";
      
      static
      {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearName()
      {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = getDefaultInstance().getName();
      }
      
      private void clearVersion()
      {
        this.bitField0_ &= 0xFFFFFFFD;
        this.version_ = getDefaultInstance().getVersion();
      }
      
      public static SdkInfo getDefaultInstance()
      {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder()
      {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(SdkInfo paramSdkInfo)
      {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramSdkInfo);
      }
      
      public static SdkInfo parseDelimitedFrom(InputStream paramInputStream)
        throws IOException
      {
        return (SdkInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
      }
      
      public static SdkInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return (SdkInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
      }
      
      public static SdkInfo parseFrom(ByteString paramByteString)
        throws InvalidProtocolBufferException
      {
        return (SdkInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
      }
      
      public static SdkInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        return (SdkInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
      }
      
      public static SdkInfo parseFrom(CodedInputStream paramCodedInputStream)
        throws IOException
      {
        return (SdkInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
      }
      
      public static SdkInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return (SdkInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
      }
      
      public static SdkInfo parseFrom(InputStream paramInputStream)
        throws IOException
      {
        return (SdkInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
      }
      
      public static SdkInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return (SdkInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
      }
      
      public static SdkInfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferException
      {
        return (SdkInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
      }
      
      public static SdkInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        return (SdkInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
      }
      
      public static Parser<SdkInfo> parser()
      {
        return DEFAULT_INSTANCE.getParserForType();
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
      
      private void setVersion(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.version_ = paramString;
      }
      
      private void setVersionBytes(ByteString paramByteString)
      {
        if (paramByteString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.version_ = paramByteString.toStringUtf8();
      }
      
      /* Error */
      protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
      {
        // Byte code:
        //   0: getstatic 168	com/blizzard/telemetry/proto/Context$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
        //   3: aload_1
        //   4: invokevirtual 174	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
        //   7: iaload
        //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+331->339, 8:+335->343
        //   56: new 176	java/lang/UnsupportedOperationException
        //   59: dup
        //   60: invokespecial 177	java/lang/UnsupportedOperationException:<init>	()V
        //   63: athrow
        //   64: new 2	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo
        //   67: dup
        //   68: invokespecial 35	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:<init>	()V
        //   71: astore_1
        //   72: aload_1
        //   73: areturn
        //   74: getstatic 37	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
        //   77: areturn
        //   78: aconst_null
        //   79: areturn
        //   80: new 15	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo$Builder
        //   83: dup
        //   84: aconst_null
        //   85: invokespecial 180	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo$Builder:<init>	(Lcom/blizzard/telemetry/proto/Context$1;)V
        //   88: areturn
        //   89: aload_2
        //   90: checkcast 182	com/google/protobuf/GeneratedMessageLite$Visitor
        //   93: astore_2
        //   94: aload_3
        //   95: checkcast 2	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo
        //   98: astore_3
        //   99: aload_0
        //   100: aload_2
        //   101: aload_0
        //   102: invokevirtual 186	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:hasName	()Z
        //   105: aload_0
        //   106: getfield 46	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:name_	Ljava/lang/String;
        //   109: aload_3
        //   110: invokevirtual 186	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:hasName	()Z
        //   113: aload_3
        //   114: getfield 46	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:name_	Ljava/lang/String;
        //   117: invokeinterface 190 5 0
        //   122: putfield 46	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:name_	Ljava/lang/String;
        //   125: aload_0
        //   126: aload_2
        //   127: aload_0
        //   128: invokevirtual 193	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:hasVersion	()Z
        //   131: aload_0
        //   132: getfield 48	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:version_	Ljava/lang/String;
        //   135: aload_3
        //   136: invokevirtual 193	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:hasVersion	()Z
        //   139: aload_3
        //   140: getfield 48	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:version_	Ljava/lang/String;
        //   143: invokeinterface 190 5 0
        //   148: putfield 48	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:version_	Ljava/lang/String;
        //   151: aload_0
        //   152: astore_1
        //   153: aload_2
        //   154: getstatic 199	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   157: if_acmpne -85 -> 72
        //   160: aload_0
        //   161: aload_0
        //   162: getfield 81	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:bitField0_	I
        //   165: aload_3
        //   166: getfield 81	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:bitField0_	I
        //   169: ior
        //   170: putfield 81	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:bitField0_	I
        //   173: aload_0
        //   174: areturn
        //   175: aload_2
        //   176: checkcast 201	com/google/protobuf/CodedInputStream
        //   179: astore_1
        //   180: aload_3
        //   181: checkcast 203	com/google/protobuf/ExtensionRegistryLite
        //   184: astore_2
        //   185: iconst_0
        //   186: istore 4
        //   188: iload 4
        //   190: ifne +149 -> 339
        //   193: aload_1
        //   194: invokevirtual 206	com/google/protobuf/CodedInputStream:readTag	()I
        //   197: istore 5
        //   199: iload 5
        //   201: lookupswitch	default:+183->384, 0:+186->387, 10:+51->252, 18:+91->292
        //   236: aload_0
        //   237: iload 5
        //   239: aload_1
        //   240: invokevirtual 210	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
        //   243: ifne -55 -> 188
        //   246: iconst_1
        //   247: istore 4
        //   249: goto -61 -> 188
        //   252: aload_1
        //   253: invokevirtual 213	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
        //   256: astore_2
        //   257: aload_0
        //   258: aload_0
        //   259: getfield 81	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:bitField0_	I
        //   262: iconst_1
        //   263: ior
        //   264: putfield 81	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:bitField0_	I
        //   267: aload_0
        //   268: aload_2
        //   269: putfield 46	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:name_	Ljava/lang/String;
        //   272: goto -84 -> 188
        //   275: astore_1
        //   276: new 215	java/lang/RuntimeException
        //   279: dup
        //   280: aload_1
        //   281: aload_0
        //   282: invokevirtual 219	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   285: invokespecial 222	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
        //   288: athrow
        //   289: astore_1
        //   290: aload_1
        //   291: athrow
        //   292: aload_1
        //   293: invokevirtual 213	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
        //   296: astore_2
        //   297: aload_0
        //   298: aload_0
        //   299: getfield 81	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:bitField0_	I
        //   302: iconst_2
        //   303: ior
        //   304: putfield 81	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:bitField0_	I
        //   307: aload_0
        //   308: aload_2
        //   309: putfield 48	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:version_	Ljava/lang/String;
        //   312: goto -124 -> 188
        //   315: astore_1
        //   316: new 215	java/lang/RuntimeException
        //   319: dup
        //   320: new 118	com/google/protobuf/InvalidProtocolBufferException
        //   323: dup
        //   324: aload_1
        //   325: invokevirtual 225	java/io/IOException:getMessage	()Ljava/lang/String;
        //   328: invokespecial 227	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
        //   331: aload_0
        //   332: invokevirtual 219	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   335: invokespecial 222	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
        //   338: athrow
        //   339: getstatic 37	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
        //   342: areturn
        //   343: getstatic 229	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:PARSER	Lcom/google/protobuf/Parser;
        //   346: ifnonnull +28 -> 374
        //   349: ldc 2
        //   351: monitorenter
        //   352: getstatic 229	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:PARSER	Lcom/google/protobuf/Parser;
        //   355: ifnonnull +16 -> 371
        //   358: new 231	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   361: dup
        //   362: getstatic 37	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo;
        //   365: invokespecial 234	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
        //   368: putstatic 229	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:PARSER	Lcom/google/protobuf/Parser;
        //   371: ldc 2
        //   373: monitorexit
        //   374: getstatic 229	com/blizzard/telemetry/proto/Context$ProgramInfo$SdkInfo:PARSER	Lcom/google/protobuf/Parser;
        //   377: areturn
        //   378: astore_1
        //   379: ldc 2
        //   381: monitorexit
        //   382: aload_1
        //   383: athrow
        //   384: goto -148 -> 236
        //   387: iconst_1
        //   388: istore 4
        //   390: goto -202 -> 188
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	393	0	this	SdkInfo
        //   0	393	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
        //   0	393	2	paramObject1	Object
        //   0	393	3	paramObject2	Object
        //   186	203	4	i	int
        //   197	41	5	j	int
        // Exception table:
        //   from	to	target	type
        //   193	199	275	com/google/protobuf/InvalidProtocolBufferException
        //   236	246	275	com/google/protobuf/InvalidProtocolBufferException
        //   252	272	275	com/google/protobuf/InvalidProtocolBufferException
        //   292	312	275	com/google/protobuf/InvalidProtocolBufferException
        //   193	199	289	finally
        //   236	246	289	finally
        //   252	272	289	finally
        //   276	289	289	finally
        //   292	312	289	finally
        //   316	339	289	finally
        //   193	199	315	java/io/IOException
        //   236	246	315	java/io/IOException
        //   252	272	315	java/io/IOException
        //   292	312	315	java/io/IOException
        //   352	371	378	finally
        //   371	374	378	finally
        //   379	382	378	finally
      }
      
      public String getName()
      {
        return this.name_;
      }
      
      public ByteString getNameBytes()
      {
        return ByteString.copyFromUtf8(this.name_);
      }
      
      public int getSerializedSize()
      {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
          return i;
        }
        i = 0;
        if ((this.bitField0_ & 0x1) == 1) {
          i = 0 + CodedOutputStream.computeStringSize(1, getName());
        }
        int j = i;
        if ((this.bitField0_ & 0x2) == 2) {
          j = i + CodedOutputStream.computeStringSize(2, getVersion());
        }
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public String getVersion()
      {
        return this.version_;
      }
      
      public ByteString getVersionBytes()
      {
        return ByteString.copyFromUtf8(this.version_);
      }
      
      public boolean hasName()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public boolean hasVersion()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public void writeTo(CodedOutputStream paramCodedOutputStream)
        throws IOException
      {
        if ((this.bitField0_ & 0x1) == 1) {
          paramCodedOutputStream.writeString(1, getName());
        }
        if ((this.bitField0_ & 0x2) == 2) {
          paramCodedOutputStream.writeString(2, getVersion());
        }
        this.unknownFields.writeTo(paramCodedOutputStream);
      }
      
      public static final class Builder
        extends GeneratedMessageLite.Builder<Context.ProgramInfo.SdkInfo, Builder>
        implements Context.ProgramInfo.SdkInfoOrBuilder
      {
        private Builder()
        {
          super();
        }
        
        public Builder clearName()
        {
          copyOnWrite();
          ((Context.ProgramInfo.SdkInfo)this.instance).clearName();
          return this;
        }
        
        public Builder clearVersion()
        {
          copyOnWrite();
          ((Context.ProgramInfo.SdkInfo)this.instance).clearVersion();
          return this;
        }
        
        public String getName()
        {
          return ((Context.ProgramInfo.SdkInfo)this.instance).getName();
        }
        
        public ByteString getNameBytes()
        {
          return ((Context.ProgramInfo.SdkInfo)this.instance).getNameBytes();
        }
        
        public String getVersion()
        {
          return ((Context.ProgramInfo.SdkInfo)this.instance).getVersion();
        }
        
        public ByteString getVersionBytes()
        {
          return ((Context.ProgramInfo.SdkInfo)this.instance).getVersionBytes();
        }
        
        public boolean hasName()
        {
          return ((Context.ProgramInfo.SdkInfo)this.instance).hasName();
        }
        
        public boolean hasVersion()
        {
          return ((Context.ProgramInfo.SdkInfo)this.instance).hasVersion();
        }
        
        public Builder setName(String paramString)
        {
          copyOnWrite();
          ((Context.ProgramInfo.SdkInfo)this.instance).setName(paramString);
          return this;
        }
        
        public Builder setNameBytes(ByteString paramByteString)
        {
          copyOnWrite();
          ((Context.ProgramInfo.SdkInfo)this.instance).setNameBytes(paramByteString);
          return this;
        }
        
        public Builder setVersion(String paramString)
        {
          copyOnWrite();
          ((Context.ProgramInfo.SdkInfo)this.instance).setVersion(paramString);
          return this;
        }
        
        public Builder setVersionBytes(ByteString paramByteString)
        {
          copyOnWrite();
          ((Context.ProgramInfo.SdkInfo)this.instance).setVersionBytes(paramByteString);
          return this;
        }
      }
    }
    
    public static abstract interface SdkInfoOrBuilder
      extends MessageLiteOrBuilder
    {
      public abstract String getName();
      
      public abstract ByteString getNameBytes();
      
      public abstract String getVersion();
      
      public abstract ByteString getVersionBytes();
      
      public abstract boolean hasName();
      
      public abstract boolean hasVersion();
    }
  }
  
  public static abstract interface ProgramInfoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getId();
    
    public abstract ByteString getIdBytes();
    
    public abstract String getName();
    
    public abstract ByteString getNameBytes();
    
    public abstract Context.ProgramInfo.SdkInfo getSdk();
    
    public abstract String getVersion();
    
    public abstract ByteString getVersionBytes();
    
    public abstract boolean hasId();
    
    public abstract boolean hasName();
    
    public abstract boolean hasSdk();
    
    public abstract boolean hasVersion();
  }
  
  public static final class TraceInfo
    extends GeneratedMessageLite<TraceInfo, Builder>
    implements Context.TraceInfoOrBuilder
  {
    private static final TraceInfo DEFAULT_INSTANCE = new TraceInfo();
    public static final int PARENT_SPAN_ID_FIELD_NUMBER = 3;
    private static volatile Parser<TraceInfo> PARSER;
    public static final int SPAN_ID_FIELD_NUMBER = 2;
    public static final int TRACE_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private String parentSpanId_ = "";
    private String spanId_ = "";
    private String traceId_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearParentSpanId()
    {
      this.bitField0_ &= 0xFFFFFFFB;
      this.parentSpanId_ = getDefaultInstance().getParentSpanId();
    }
    
    private void clearSpanId()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.spanId_ = getDefaultInstance().getSpanId();
    }
    
    private void clearTraceId()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.traceId_ = getDefaultInstance().getTraceId();
    }
    
    public static TraceInfo getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(TraceInfo paramTraceInfo)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTraceInfo);
    }
    
    public static TraceInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TraceInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TraceInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TraceInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TraceInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (TraceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static TraceInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TraceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static TraceInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (TraceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static TraceInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TraceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static TraceInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (TraceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static TraceInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (TraceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static TraceInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (TraceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static TraceInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (TraceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<TraceInfo> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setParentSpanId(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.parentSpanId_ = paramString;
    }
    
    private void setParentSpanIdBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x4;
      this.parentSpanId_ = paramByteString.toStringUtf8();
    }
    
    private void setSpanId(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.spanId_ = paramString;
    }
    
    private void setSpanIdBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.spanId_ = paramByteString.toStringUtf8();
    }
    
    private void setTraceId(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.traceId_ = paramString;
    }
    
    private void setTraceIdBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.traceId_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 185	com/blizzard/telemetry/proto/Context$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 191	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+193->201, 7:+386->394, 8:+390->398
      //   56: new 193	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 194	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/telemetry/proto/Context$TraceInfo
      //   67: dup
      //   68: invokespecial 35	com/blizzard/telemetry/proto/Context$TraceInfo:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 37	com/blizzard/telemetry/proto/Context$TraceInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/blizzard/telemetry/proto/Context$TraceInfo$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 197	com/blizzard/telemetry/proto/Context$TraceInfo$Builder:<init>	(Lcom/blizzard/telemetry/proto/Context$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 199	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/blizzard/telemetry/proto/Context$TraceInfo
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 203	com/blizzard/telemetry/proto/Context$TraceInfo:hasTraceId	()Z
      //   105: aload_0
      //   106: getfield 46	com/blizzard/telemetry/proto/Context$TraceInfo:traceId_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 203	com/blizzard/telemetry/proto/Context$TraceInfo:hasTraceId	()Z
      //   113: aload_3
      //   114: getfield 46	com/blizzard/telemetry/proto/Context$TraceInfo:traceId_	Ljava/lang/String;
      //   117: invokeinterface 207 5 0
      //   122: putfield 46	com/blizzard/telemetry/proto/Context$TraceInfo:traceId_	Ljava/lang/String;
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 210	com/blizzard/telemetry/proto/Context$TraceInfo:hasSpanId	()Z
      //   131: aload_0
      //   132: getfield 48	com/blizzard/telemetry/proto/Context$TraceInfo:spanId_	Ljava/lang/String;
      //   135: aload_3
      //   136: invokevirtual 210	com/blizzard/telemetry/proto/Context$TraceInfo:hasSpanId	()Z
      //   139: aload_3
      //   140: getfield 48	com/blizzard/telemetry/proto/Context$TraceInfo:spanId_	Ljava/lang/String;
      //   143: invokeinterface 207 5 0
      //   148: putfield 48	com/blizzard/telemetry/proto/Context$TraceInfo:spanId_	Ljava/lang/String;
      //   151: aload_0
      //   152: aload_2
      //   153: aload_0
      //   154: invokevirtual 213	com/blizzard/telemetry/proto/Context$TraceInfo:hasParentSpanId	()Z
      //   157: aload_0
      //   158: getfield 50	com/blizzard/telemetry/proto/Context$TraceInfo:parentSpanId_	Ljava/lang/String;
      //   161: aload_3
      //   162: invokevirtual 213	com/blizzard/telemetry/proto/Context$TraceInfo:hasParentSpanId	()Z
      //   165: aload_3
      //   166: getfield 50	com/blizzard/telemetry/proto/Context$TraceInfo:parentSpanId_	Ljava/lang/String;
      //   169: invokeinterface 207 5 0
      //   174: putfield 50	com/blizzard/telemetry/proto/Context$TraceInfo:parentSpanId_	Ljava/lang/String;
      //   177: aload_0
      //   178: astore_1
      //   179: aload_2
      //   180: getstatic 219	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   183: if_acmpne -111 -> 72
      //   186: aload_0
      //   187: aload_0
      //   188: getfield 95	com/blizzard/telemetry/proto/Context$TraceInfo:bitField0_	I
      //   191: aload_3
      //   192: getfield 95	com/blizzard/telemetry/proto/Context$TraceInfo:bitField0_	I
      //   195: ior
      //   196: putfield 95	com/blizzard/telemetry/proto/Context$TraceInfo:bitField0_	I
      //   199: aload_0
      //   200: areturn
      //   201: aload_2
      //   202: checkcast 221	com/google/protobuf/CodedInputStream
      //   205: astore_1
      //   206: aload_3
      //   207: checkcast 223	com/google/protobuf/ExtensionRegistryLite
      //   210: astore_2
      //   211: iconst_0
      //   212: istore 4
      //   214: iload 4
      //   216: ifne +178 -> 394
      //   219: aload_1
      //   220: invokevirtual 226	com/google/protobuf/CodedInputStream:readTag	()I
      //   223: istore 5
      //   225: iload 5
      //   227: lookupswitch	default:+212->439, 0:+215->442, 10:+57->284, 18:+97->324, 26:+144->371
      //   268: aload_0
      //   269: iload 5
      //   271: aload_1
      //   272: invokevirtual 230	com/blizzard/telemetry/proto/Context$TraceInfo:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   275: ifne -61 -> 214
      //   278: iconst_1
      //   279: istore 4
      //   281: goto -67 -> 214
      //   284: aload_1
      //   285: invokevirtual 233	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   288: astore_2
      //   289: aload_0
      //   290: aload_0
      //   291: getfield 95	com/blizzard/telemetry/proto/Context$TraceInfo:bitField0_	I
      //   294: iconst_1
      //   295: ior
      //   296: putfield 95	com/blizzard/telemetry/proto/Context$TraceInfo:bitField0_	I
      //   299: aload_0
      //   300: aload_2
      //   301: putfield 46	com/blizzard/telemetry/proto/Context$TraceInfo:traceId_	Ljava/lang/String;
      //   304: goto -90 -> 214
      //   307: astore_1
      //   308: new 235	java/lang/RuntimeException
      //   311: dup
      //   312: aload_1
      //   313: aload_0
      //   314: invokevirtual 239	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   317: invokespecial 242	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   320: athrow
      //   321: astore_1
      //   322: aload_1
      //   323: athrow
      //   324: aload_1
      //   325: invokevirtual 233	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   328: astore_2
      //   329: aload_0
      //   330: aload_0
      //   331: getfield 95	com/blizzard/telemetry/proto/Context$TraceInfo:bitField0_	I
      //   334: iconst_2
      //   335: ior
      //   336: putfield 95	com/blizzard/telemetry/proto/Context$TraceInfo:bitField0_	I
      //   339: aload_0
      //   340: aload_2
      //   341: putfield 48	com/blizzard/telemetry/proto/Context$TraceInfo:spanId_	Ljava/lang/String;
      //   344: goto -130 -> 214
      //   347: astore_1
      //   348: new 235	java/lang/RuntimeException
      //   351: dup
      //   352: new 135	com/google/protobuf/InvalidProtocolBufferException
      //   355: dup
      //   356: aload_1
      //   357: invokevirtual 245	java/io/IOException:getMessage	()Ljava/lang/String;
      //   360: invokespecial 247	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   363: aload_0
      //   364: invokevirtual 239	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   367: invokespecial 242	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   370: athrow
      //   371: aload_1
      //   372: invokevirtual 233	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   375: astore_2
      //   376: aload_0
      //   377: aload_0
      //   378: getfield 95	com/blizzard/telemetry/proto/Context$TraceInfo:bitField0_	I
      //   381: iconst_4
      //   382: ior
      //   383: putfield 95	com/blizzard/telemetry/proto/Context$TraceInfo:bitField0_	I
      //   386: aload_0
      //   387: aload_2
      //   388: putfield 50	com/blizzard/telemetry/proto/Context$TraceInfo:parentSpanId_	Ljava/lang/String;
      //   391: goto -177 -> 214
      //   394: getstatic 37	com/blizzard/telemetry/proto/Context$TraceInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
      //   397: areturn
      //   398: getstatic 249	com/blizzard/telemetry/proto/Context$TraceInfo:PARSER	Lcom/google/protobuf/Parser;
      //   401: ifnonnull +28 -> 429
      //   404: ldc 2
      //   406: monitorenter
      //   407: getstatic 249	com/blizzard/telemetry/proto/Context$TraceInfo:PARSER	Lcom/google/protobuf/Parser;
      //   410: ifnonnull +16 -> 426
      //   413: new 251	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   416: dup
      //   417: getstatic 37	com/blizzard/telemetry/proto/Context$TraceInfo:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/Context$TraceInfo;
      //   420: invokespecial 254	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   423: putstatic 249	com/blizzard/telemetry/proto/Context$TraceInfo:PARSER	Lcom/google/protobuf/Parser;
      //   426: ldc 2
      //   428: monitorexit
      //   429: getstatic 249	com/blizzard/telemetry/proto/Context$TraceInfo:PARSER	Lcom/google/protobuf/Parser;
      //   432: areturn
      //   433: astore_1
      //   434: ldc 2
      //   436: monitorexit
      //   437: aload_1
      //   438: athrow
      //   439: goto -171 -> 268
      //   442: iconst_1
      //   443: istore 4
      //   445: goto -231 -> 214
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	448	0	this	TraceInfo
      //   0	448	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	448	2	paramObject1	Object
      //   0	448	3	paramObject2	Object
      //   212	232	4	i	int
      //   223	47	5	j	int
      // Exception table:
      //   from	to	target	type
      //   219	225	307	com/google/protobuf/InvalidProtocolBufferException
      //   268	278	307	com/google/protobuf/InvalidProtocolBufferException
      //   284	304	307	com/google/protobuf/InvalidProtocolBufferException
      //   324	344	307	com/google/protobuf/InvalidProtocolBufferException
      //   371	391	307	com/google/protobuf/InvalidProtocolBufferException
      //   219	225	321	finally
      //   268	278	321	finally
      //   284	304	321	finally
      //   308	321	321	finally
      //   324	344	321	finally
      //   348	371	321	finally
      //   371	391	321	finally
      //   219	225	347	java/io/IOException
      //   268	278	347	java/io/IOException
      //   284	304	347	java/io/IOException
      //   324	344	347	java/io/IOException
      //   371	391	347	java/io/IOException
      //   407	426	433	finally
      //   426	429	433	finally
      //   434	437	433	finally
    }
    
    public String getParentSpanId()
    {
      return this.parentSpanId_;
    }
    
    public ByteString getParentSpanIdBytes()
    {
      return ByteString.copyFromUtf8(this.parentSpanId_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = 0 + CodedOutputStream.computeStringSize(1, getTraceId());
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + CodedOutputStream.computeStringSize(2, getSpanId());
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + CodedOutputStream.computeStringSize(3, getParentSpanId());
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getSpanId()
    {
      return this.spanId_;
    }
    
    public ByteString getSpanIdBytes()
    {
      return ByteString.copyFromUtf8(this.spanId_);
    }
    
    public String getTraceId()
    {
      return this.traceId_;
    }
    
    public ByteString getTraceIdBytes()
    {
      return ByteString.copyFromUtf8(this.traceId_);
    }
    
    public boolean hasParentSpanId()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public boolean hasSpanId()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasTraceId()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getTraceId());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeString(2, getSpanId());
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramCodedOutputStream.writeString(3, getParentSpanId());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<Context.TraceInfo, Builder>
      implements Context.TraceInfoOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearParentSpanId()
      {
        copyOnWrite();
        ((Context.TraceInfo)this.instance).clearParentSpanId();
        return this;
      }
      
      public Builder clearSpanId()
      {
        copyOnWrite();
        ((Context.TraceInfo)this.instance).clearSpanId();
        return this;
      }
      
      public Builder clearTraceId()
      {
        copyOnWrite();
        ((Context.TraceInfo)this.instance).clearTraceId();
        return this;
      }
      
      public String getParentSpanId()
      {
        return ((Context.TraceInfo)this.instance).getParentSpanId();
      }
      
      public ByteString getParentSpanIdBytes()
      {
        return ((Context.TraceInfo)this.instance).getParentSpanIdBytes();
      }
      
      public String getSpanId()
      {
        return ((Context.TraceInfo)this.instance).getSpanId();
      }
      
      public ByteString getSpanIdBytes()
      {
        return ((Context.TraceInfo)this.instance).getSpanIdBytes();
      }
      
      public String getTraceId()
      {
        return ((Context.TraceInfo)this.instance).getTraceId();
      }
      
      public ByteString getTraceIdBytes()
      {
        return ((Context.TraceInfo)this.instance).getTraceIdBytes();
      }
      
      public boolean hasParentSpanId()
      {
        return ((Context.TraceInfo)this.instance).hasParentSpanId();
      }
      
      public boolean hasSpanId()
      {
        return ((Context.TraceInfo)this.instance).hasSpanId();
      }
      
      public boolean hasTraceId()
      {
        return ((Context.TraceInfo)this.instance).hasTraceId();
      }
      
      public Builder setParentSpanId(String paramString)
      {
        copyOnWrite();
        ((Context.TraceInfo)this.instance).setParentSpanId(paramString);
        return this;
      }
      
      public Builder setParentSpanIdBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.TraceInfo)this.instance).setParentSpanIdBytes(paramByteString);
        return this;
      }
      
      public Builder setSpanId(String paramString)
      {
        copyOnWrite();
        ((Context.TraceInfo)this.instance).setSpanId(paramString);
        return this;
      }
      
      public Builder setSpanIdBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.TraceInfo)this.instance).setSpanIdBytes(paramByteString);
        return this;
      }
      
      public Builder setTraceId(String paramString)
      {
        copyOnWrite();
        ((Context.TraceInfo)this.instance).setTraceId(paramString);
        return this;
      }
      
      public Builder setTraceIdBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((Context.TraceInfo)this.instance).setTraceIdBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface TraceInfoOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getParentSpanId();
    
    public abstract ByteString getParentSpanIdBytes();
    
    public abstract String getSpanId();
    
    public abstract ByteString getSpanIdBytes();
    
    public abstract String getTraceId();
    
    public abstract ByteString getTraceIdBytes();
    
    public abstract boolean hasParentSpanId();
    
    public abstract boolean hasSpanId();
    
    public abstract boolean hasTraceId();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/Context.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */