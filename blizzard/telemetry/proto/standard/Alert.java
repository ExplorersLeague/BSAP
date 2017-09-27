package com.blizzard.telemetry.proto.standard;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSetLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Alert
  extends GeneratedMessageLite<Alert, Builder>
  implements AlertOrBuilder
{
  public static final int AGENT_FIELD_NUMBER = 7;
  public static final int CONDITION_ID_FIELD_NUMBER = 1;
  private static final Alert DEFAULT_INSTANCE = new Alert();
  public static final int DESCRIPTION_FIELD_NUMBER = 4;
  public static final int ENVIRONMENTS_FIELD_NUMBER = 8;
  public static final int HOSTNAMES_FIELD_NUMBER = 9;
  private static volatile Parser<Alert> PARSER;
  public static final int PAYLOAD_FIELD_NUMBER = 10;
  public static final int QUALIFIER_FIELD_NUMBER = 2;
  public static final int REGIONS_FIELD_NUMBER = 11;
  public static final int SERVICES_FIELD_NUMBER = 12;
  public static final int SEVERITY_FIELD_NUMBER = 6;
  public static final int SITES_FIELD_NUMBER = 13;
  public static final int SUMMARY_FIELD_NUMBER = 3;
  public static final int TIMESTAMP_UTC_FIELD_NUMBER = 5;
  private String agent_ = "";
  private int bitField0_;
  private String conditionId_ = "";
  private String description_ = "";
  private Internal.ProtobufList<String> environments_ = GeneratedMessageLite.emptyProtobufList();
  private Internal.ProtobufList<String> hostnames_ = GeneratedMessageLite.emptyProtobufList();
  private String payload_ = "";
  private String qualifier_ = "";
  private Internal.ProtobufList<String> regions_ = GeneratedMessageLite.emptyProtobufList();
  private Internal.ProtobufList<String> services_ = GeneratedMessageLite.emptyProtobufList();
  private int severity_;
  private Internal.ProtobufList<String> sites_ = GeneratedMessageLite.emptyProtobufList();
  private String summary_ = "";
  private long timestampUtc_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllEnvironments(Iterable<String> paramIterable)
  {
    ensureEnvironmentsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.environments_);
  }
  
  private void addAllHostnames(Iterable<String> paramIterable)
  {
    ensureHostnamesIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.hostnames_);
  }
  
  private void addAllRegions(Iterable<String> paramIterable)
  {
    ensureRegionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.regions_);
  }
  
  private void addAllServices(Iterable<String> paramIterable)
  {
    ensureServicesIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.services_);
  }
  
  private void addAllSites(Iterable<String> paramIterable)
  {
    ensureSitesIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.sites_);
  }
  
  private void addEnvironments(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureEnvironmentsIsMutable();
    this.environments_.add(paramString);
  }
  
  private void addEnvironmentsBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    ensureEnvironmentsIsMutable();
    this.environments_.add(paramByteString.toStringUtf8());
  }
  
  private void addHostnames(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureHostnamesIsMutable();
    this.hostnames_.add(paramString);
  }
  
  private void addHostnamesBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    ensureHostnamesIsMutable();
    this.hostnames_.add(paramByteString.toStringUtf8());
  }
  
  private void addRegions(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureRegionsIsMutable();
    this.regions_.add(paramString);
  }
  
  private void addRegionsBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    ensureRegionsIsMutable();
    this.regions_.add(paramByteString.toStringUtf8());
  }
  
  private void addServices(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureServicesIsMutable();
    this.services_.add(paramString);
  }
  
  private void addServicesBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    ensureServicesIsMutable();
    this.services_.add(paramByteString.toStringUtf8());
  }
  
  private void addSites(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureSitesIsMutable();
    this.sites_.add(paramString);
  }
  
  private void addSitesBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    ensureSitesIsMutable();
    this.sites_.add(paramByteString.toStringUtf8());
  }
  
  private void clearAgent()
  {
    this.bitField0_ &= 0xFFFFFFBF;
    this.agent_ = getDefaultInstance().getAgent();
  }
  
  private void clearConditionId()
  {
    this.bitField0_ &= 0xFFFFFFFE;
    this.conditionId_ = getDefaultInstance().getConditionId();
  }
  
  private void clearDescription()
  {
    this.bitField0_ &= 0xFFFFFFF7;
    this.description_ = getDefaultInstance().getDescription();
  }
  
  private void clearEnvironments()
  {
    this.environments_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearHostnames()
  {
    this.hostnames_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearPayload()
  {
    this.bitField0_ &= 0xFF7F;
    this.payload_ = getDefaultInstance().getPayload();
  }
  
  private void clearQualifier()
  {
    this.bitField0_ &= 0xFFFFFFFD;
    this.qualifier_ = getDefaultInstance().getQualifier();
  }
  
  private void clearRegions()
  {
    this.regions_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearServices()
  {
    this.services_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearSeverity()
  {
    this.bitField0_ &= 0xFFFFFFDF;
    this.severity_ = 0;
  }
  
  private void clearSites()
  {
    this.sites_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearSummary()
  {
    this.bitField0_ &= 0xFFFFFFFB;
    this.summary_ = getDefaultInstance().getSummary();
  }
  
  private void clearTimestampUtc()
  {
    this.bitField0_ &= 0xFFFFFFEF;
    this.timestampUtc_ = 0L;
  }
  
  private void ensureEnvironmentsIsMutable()
  {
    if (!this.environments_.isModifiable()) {
      this.environments_ = GeneratedMessageLite.mutableCopy(this.environments_);
    }
  }
  
  private void ensureHostnamesIsMutable()
  {
    if (!this.hostnames_.isModifiable()) {
      this.hostnames_ = GeneratedMessageLite.mutableCopy(this.hostnames_);
    }
  }
  
  private void ensureRegionsIsMutable()
  {
    if (!this.regions_.isModifiable()) {
      this.regions_ = GeneratedMessageLite.mutableCopy(this.regions_);
    }
  }
  
  private void ensureServicesIsMutable()
  {
    if (!this.services_.isModifiable()) {
      this.services_ = GeneratedMessageLite.mutableCopy(this.services_);
    }
  }
  
  private void ensureSitesIsMutable()
  {
    if (!this.sites_.isModifiable()) {
      this.sites_ = GeneratedMessageLite.mutableCopy(this.sites_);
    }
  }
  
  public static Alert getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Alert paramAlert)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAlert);
  }
  
  public static Alert parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Alert)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Alert parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Alert)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Alert parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Alert)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Alert parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Alert)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Alert parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Alert)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Alert parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Alert)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Alert parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Alert)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Alert parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Alert)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Alert parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Alert)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Alert parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Alert)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Alert> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAgent(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x40;
    this.agent_ = paramString;
  }
  
  private void setAgentBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x40;
    this.agent_ = paramByteString.toStringUtf8();
  }
  
  private void setConditionId(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x1;
    this.conditionId_ = paramString;
  }
  
  private void setConditionIdBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x1;
    this.conditionId_ = paramByteString.toStringUtf8();
  }
  
  private void setDescription(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x8;
    this.description_ = paramString;
  }
  
  private void setDescriptionBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x8;
    this.description_ = paramByteString.toStringUtf8();
  }
  
  private void setEnvironments(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureEnvironmentsIsMutable();
    this.environments_.set(paramInt, paramString);
  }
  
  private void setHostnames(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureHostnamesIsMutable();
    this.hostnames_.set(paramInt, paramString);
  }
  
  private void setPayload(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x80;
    this.payload_ = paramString;
  }
  
  private void setPayloadBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x80;
    this.payload_ = paramByteString.toStringUtf8();
  }
  
  private void setQualifier(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x2;
    this.qualifier_ = paramString;
  }
  
  private void setQualifierBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x2;
    this.qualifier_ = paramByteString.toStringUtf8();
  }
  
  private void setRegions(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureRegionsIsMutable();
    this.regions_.set(paramInt, paramString);
  }
  
  private void setServices(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureServicesIsMutable();
    this.services_.set(paramInt, paramString);
  }
  
  private void setSeverity(int paramInt)
  {
    this.bitField0_ |= 0x20;
    this.severity_ = paramInt;
  }
  
  private void setSites(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    ensureSitesIsMutable();
    this.sites_.set(paramInt, paramString);
  }
  
  private void setSummary(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x4;
    this.summary_ = paramString;
  }
  
  private void setSummaryBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x4;
    this.summary_ = paramByteString.toStringUtf8();
  }
  
  private void setTimestampUtc(long paramLong)
  {
    this.bitField0_ |= 0x10;
    this.timestampUtc_ = paramLong;
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 448	com/blizzard/telemetry/proto/standard/Alert$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 454	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+117->125, 5:+126->134, 6:+458->466, 7:+1061->1069, 8:+1065->1073
    //   56: new 456	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 457	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/blizzard/telemetry/proto/standard/Alert
    //   67: dup
    //   68: invokespecial 67	com/blizzard/telemetry/proto/standard/Alert:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 69	com/blizzard/telemetry/proto/standard/Alert:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/Alert;
    //   77: areturn
    //   78: aload_0
    //   79: getfield 92	com/blizzard/telemetry/proto/standard/Alert:environments_	Lcom/google/protobuf/Internal$ProtobufList;
    //   82: invokeinterface 458 1 0
    //   87: aload_0
    //   88: getfield 94	com/blizzard/telemetry/proto/standard/Alert:hostnames_	Lcom/google/protobuf/Internal$ProtobufList;
    //   91: invokeinterface 458 1 0
    //   96: aload_0
    //   97: getfield 98	com/blizzard/telemetry/proto/standard/Alert:regions_	Lcom/google/protobuf/Internal$ProtobufList;
    //   100: invokeinterface 458 1 0
    //   105: aload_0
    //   106: getfield 100	com/blizzard/telemetry/proto/standard/Alert:services_	Lcom/google/protobuf/Internal$ProtobufList;
    //   109: invokeinterface 458 1 0
    //   114: aload_0
    //   115: getfield 102	com/blizzard/telemetry/proto/standard/Alert:sites_	Lcom/google/protobuf/Internal$ProtobufList;
    //   118: invokeinterface 458 1 0
    //   123: aconst_null
    //   124: areturn
    //   125: new 11	com/blizzard/telemetry/proto/standard/Alert$Builder
    //   128: dup
    //   129: aconst_null
    //   130: invokespecial 461	com/blizzard/telemetry/proto/standard/Alert$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/Alert$1;)V
    //   133: areturn
    //   134: aload_2
    //   135: checkcast 463	com/google/protobuf/GeneratedMessageLite$Visitor
    //   138: astore_2
    //   139: aload_3
    //   140: checkcast 2	com/blizzard/telemetry/proto/standard/Alert
    //   143: astore_3
    //   144: aload_0
    //   145: aload_2
    //   146: aload_0
    //   147: invokevirtual 466	com/blizzard/telemetry/proto/standard/Alert:hasConditionId	()Z
    //   150: aload_0
    //   151: getfield 78	com/blizzard/telemetry/proto/standard/Alert:conditionId_	Ljava/lang/String;
    //   154: aload_3
    //   155: invokevirtual 466	com/blizzard/telemetry/proto/standard/Alert:hasConditionId	()Z
    //   158: aload_3
    //   159: getfield 78	com/blizzard/telemetry/proto/standard/Alert:conditionId_	Ljava/lang/String;
    //   162: invokeinterface 470 5 0
    //   167: putfield 78	com/blizzard/telemetry/proto/standard/Alert:conditionId_	Ljava/lang/String;
    //   170: aload_0
    //   171: aload_2
    //   172: aload_0
    //   173: invokevirtual 473	com/blizzard/telemetry/proto/standard/Alert:hasQualifier	()Z
    //   176: aload_0
    //   177: getfield 80	com/blizzard/telemetry/proto/standard/Alert:qualifier_	Ljava/lang/String;
    //   180: aload_3
    //   181: invokevirtual 473	com/blizzard/telemetry/proto/standard/Alert:hasQualifier	()Z
    //   184: aload_3
    //   185: getfield 80	com/blizzard/telemetry/proto/standard/Alert:qualifier_	Ljava/lang/String;
    //   188: invokeinterface 470 5 0
    //   193: putfield 80	com/blizzard/telemetry/proto/standard/Alert:qualifier_	Ljava/lang/String;
    //   196: aload_0
    //   197: aload_2
    //   198: aload_0
    //   199: invokevirtual 476	com/blizzard/telemetry/proto/standard/Alert:hasSummary	()Z
    //   202: aload_0
    //   203: getfield 82	com/blizzard/telemetry/proto/standard/Alert:summary_	Ljava/lang/String;
    //   206: aload_3
    //   207: invokevirtual 476	com/blizzard/telemetry/proto/standard/Alert:hasSummary	()Z
    //   210: aload_3
    //   211: getfield 82	com/blizzard/telemetry/proto/standard/Alert:summary_	Ljava/lang/String;
    //   214: invokeinterface 470 5 0
    //   219: putfield 82	com/blizzard/telemetry/proto/standard/Alert:summary_	Ljava/lang/String;
    //   222: aload_0
    //   223: aload_2
    //   224: aload_0
    //   225: invokevirtual 479	com/blizzard/telemetry/proto/standard/Alert:hasDescription	()Z
    //   228: aload_0
    //   229: getfield 84	com/blizzard/telemetry/proto/standard/Alert:description_	Ljava/lang/String;
    //   232: aload_3
    //   233: invokevirtual 479	com/blizzard/telemetry/proto/standard/Alert:hasDescription	()Z
    //   236: aload_3
    //   237: getfield 84	com/blizzard/telemetry/proto/standard/Alert:description_	Ljava/lang/String;
    //   240: invokeinterface 470 5 0
    //   245: putfield 84	com/blizzard/telemetry/proto/standard/Alert:description_	Ljava/lang/String;
    //   248: aload_0
    //   249: aload_2
    //   250: aload_0
    //   251: invokevirtual 482	com/blizzard/telemetry/proto/standard/Alert:hasTimestampUtc	()Z
    //   254: aload_0
    //   255: getfield 370	com/blizzard/telemetry/proto/standard/Alert:timestampUtc_	J
    //   258: aload_3
    //   259: invokevirtual 482	com/blizzard/telemetry/proto/standard/Alert:hasTimestampUtc	()Z
    //   262: aload_3
    //   263: getfield 370	com/blizzard/telemetry/proto/standard/Alert:timestampUtc_	J
    //   266: invokeinterface 486 7 0
    //   271: putfield 370	com/blizzard/telemetry/proto/standard/Alert:timestampUtc_	J
    //   274: aload_0
    //   275: aload_2
    //   276: aload_0
    //   277: invokevirtual 489	com/blizzard/telemetry/proto/standard/Alert:hasSeverity	()Z
    //   280: aload_0
    //   281: getfield 365	com/blizzard/telemetry/proto/standard/Alert:severity_	I
    //   284: aload_3
    //   285: invokevirtual 489	com/blizzard/telemetry/proto/standard/Alert:hasSeverity	()Z
    //   288: aload_3
    //   289: getfield 365	com/blizzard/telemetry/proto/standard/Alert:severity_	I
    //   292: invokeinterface 493 5 0
    //   297: putfield 365	com/blizzard/telemetry/proto/standard/Alert:severity_	I
    //   300: aload_0
    //   301: aload_2
    //   302: aload_0
    //   303: invokevirtual 496	com/blizzard/telemetry/proto/standard/Alert:hasAgent	()Z
    //   306: aload_0
    //   307: getfield 86	com/blizzard/telemetry/proto/standard/Alert:agent_	Ljava/lang/String;
    //   310: aload_3
    //   311: invokevirtual 496	com/blizzard/telemetry/proto/standard/Alert:hasAgent	()Z
    //   314: aload_3
    //   315: getfield 86	com/blizzard/telemetry/proto/standard/Alert:agent_	Ljava/lang/String;
    //   318: invokeinterface 470 5 0
    //   323: putfield 86	com/blizzard/telemetry/proto/standard/Alert:agent_	Ljava/lang/String;
    //   326: aload_0
    //   327: aload_2
    //   328: aload_0
    //   329: getfield 92	com/blizzard/telemetry/proto/standard/Alert:environments_	Lcom/google/protobuf/Internal$ProtobufList;
    //   332: aload_3
    //   333: getfield 92	com/blizzard/telemetry/proto/standard/Alert:environments_	Lcom/google/protobuf/Internal$ProtobufList;
    //   336: invokeinterface 500 3 0
    //   341: putfield 92	com/blizzard/telemetry/proto/standard/Alert:environments_	Lcom/google/protobuf/Internal$ProtobufList;
    //   344: aload_0
    //   345: aload_2
    //   346: aload_0
    //   347: getfield 94	com/blizzard/telemetry/proto/standard/Alert:hostnames_	Lcom/google/protobuf/Internal$ProtobufList;
    //   350: aload_3
    //   351: getfield 94	com/blizzard/telemetry/proto/standard/Alert:hostnames_	Lcom/google/protobuf/Internal$ProtobufList;
    //   354: invokeinterface 500 3 0
    //   359: putfield 94	com/blizzard/telemetry/proto/standard/Alert:hostnames_	Lcom/google/protobuf/Internal$ProtobufList;
    //   362: aload_0
    //   363: aload_2
    //   364: aload_0
    //   365: invokevirtual 503	com/blizzard/telemetry/proto/standard/Alert:hasPayload	()Z
    //   368: aload_0
    //   369: getfield 96	com/blizzard/telemetry/proto/standard/Alert:payload_	Ljava/lang/String;
    //   372: aload_3
    //   373: invokevirtual 503	com/blizzard/telemetry/proto/standard/Alert:hasPayload	()Z
    //   376: aload_3
    //   377: getfield 96	com/blizzard/telemetry/proto/standard/Alert:payload_	Ljava/lang/String;
    //   380: invokeinterface 470 5 0
    //   385: putfield 96	com/blizzard/telemetry/proto/standard/Alert:payload_	Ljava/lang/String;
    //   388: aload_0
    //   389: aload_2
    //   390: aload_0
    //   391: getfield 98	com/blizzard/telemetry/proto/standard/Alert:regions_	Lcom/google/protobuf/Internal$ProtobufList;
    //   394: aload_3
    //   395: getfield 98	com/blizzard/telemetry/proto/standard/Alert:regions_	Lcom/google/protobuf/Internal$ProtobufList;
    //   398: invokeinterface 500 3 0
    //   403: putfield 98	com/blizzard/telemetry/proto/standard/Alert:regions_	Lcom/google/protobuf/Internal$ProtobufList;
    //   406: aload_0
    //   407: aload_2
    //   408: aload_0
    //   409: getfield 100	com/blizzard/telemetry/proto/standard/Alert:services_	Lcom/google/protobuf/Internal$ProtobufList;
    //   412: aload_3
    //   413: getfield 100	com/blizzard/telemetry/proto/standard/Alert:services_	Lcom/google/protobuf/Internal$ProtobufList;
    //   416: invokeinterface 500 3 0
    //   421: putfield 100	com/blizzard/telemetry/proto/standard/Alert:services_	Lcom/google/protobuf/Internal$ProtobufList;
    //   424: aload_0
    //   425: aload_2
    //   426: aload_0
    //   427: getfield 102	com/blizzard/telemetry/proto/standard/Alert:sites_	Lcom/google/protobuf/Internal$ProtobufList;
    //   430: aload_3
    //   431: getfield 102	com/blizzard/telemetry/proto/standard/Alert:sites_	Lcom/google/protobuf/Internal$ProtobufList;
    //   434: invokeinterface 500 3 0
    //   439: putfield 102	com/blizzard/telemetry/proto/standard/Alert:sites_	Lcom/google/protobuf/Internal$ProtobufList;
    //   442: aload_0
    //   443: astore_1
    //   444: aload_2
    //   445: getstatic 509	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   448: if_acmpne -376 -> 72
    //   451: aload_0
    //   452: aload_0
    //   453: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   456: aload_3
    //   457: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   460: ior
    //   461: putfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   464: aload_0
    //   465: areturn
    //   466: aload_2
    //   467: checkcast 511	com/google/protobuf/CodedInputStream
    //   470: astore_1
    //   471: aload_3
    //   472: checkcast 513	com/google/protobuf/ExtensionRegistryLite
    //   475: astore_2
    //   476: iconst_0
    //   477: istore 4
    //   479: iload 4
    //   481: ifne +588 -> 1069
    //   484: aload_1
    //   485: invokevirtual 516	com/google/protobuf/CodedInputStream:readTag	()I
    //   488: istore 5
    //   490: iload 5
    //   492: lookupswitch	default:+622->1114, 0:+625->1117, 10:+140->632, 18:+180->672, 26:+227->719, 34:+250->742, 40:+274->766, 48:+296->788, 58:+318->810, 66:+342->834, 74:+384->876, 82:+426->918, 90:+451->943, 98:+493->985, 106:+535->1027
    //   616: aload_0
    //   617: iload 5
    //   619: aload_1
    //   620: invokevirtual 520	com/blizzard/telemetry/proto/standard/Alert:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   623: ifne -144 -> 479
    //   626: iconst_1
    //   627: istore 4
    //   629: goto -150 -> 479
    //   632: aload_1
    //   633: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   636: astore_2
    //   637: aload_0
    //   638: aload_0
    //   639: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   642: iconst_1
    //   643: ior
    //   644: putfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   647: aload_0
    //   648: aload_2
    //   649: putfield 78	com/blizzard/telemetry/proto/standard/Alert:conditionId_	Ljava/lang/String;
    //   652: goto -173 -> 479
    //   655: astore_1
    //   656: new 525	java/lang/RuntimeException
    //   659: dup
    //   660: aload_1
    //   661: aload_0
    //   662: invokevirtual 529	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   665: invokespecial 532	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   668: athrow
    //   669: astore_1
    //   670: aload_1
    //   671: athrow
    //   672: aload_1
    //   673: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   676: astore_2
    //   677: aload_0
    //   678: aload_0
    //   679: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   682: iconst_2
    //   683: ior
    //   684: putfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   687: aload_0
    //   688: aload_2
    //   689: putfield 80	com/blizzard/telemetry/proto/standard/Alert:qualifier_	Ljava/lang/String;
    //   692: goto -213 -> 479
    //   695: astore_1
    //   696: new 525	java/lang/RuntimeException
    //   699: dup
    //   700: new 405	com/google/protobuf/InvalidProtocolBufferException
    //   703: dup
    //   704: aload_1
    //   705: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   708: invokespecial 537	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   711: aload_0
    //   712: invokevirtual 529	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   715: invokespecial 532	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   718: athrow
    //   719: aload_1
    //   720: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   723: astore_2
    //   724: aload_0
    //   725: aload_0
    //   726: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   729: iconst_4
    //   730: ior
    //   731: putfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   734: aload_0
    //   735: aload_2
    //   736: putfield 82	com/blizzard/telemetry/proto/standard/Alert:summary_	Ljava/lang/String;
    //   739: goto -260 -> 479
    //   742: aload_1
    //   743: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   746: astore_2
    //   747: aload_0
    //   748: aload_0
    //   749: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   752: bipush 8
    //   754: ior
    //   755: putfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   758: aload_0
    //   759: aload_2
    //   760: putfield 84	com/blizzard/telemetry/proto/standard/Alert:description_	Ljava/lang/String;
    //   763: goto -284 -> 479
    //   766: aload_0
    //   767: aload_0
    //   768: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   771: bipush 16
    //   773: ior
    //   774: putfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   777: aload_0
    //   778: aload_1
    //   779: invokevirtual 541	com/google/protobuf/CodedInputStream:readUInt64	()J
    //   782: putfield 370	com/blizzard/telemetry/proto/standard/Alert:timestampUtc_	J
    //   785: goto -306 -> 479
    //   788: aload_0
    //   789: aload_0
    //   790: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   793: bipush 32
    //   795: ior
    //   796: putfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   799: aload_0
    //   800: aload_1
    //   801: invokevirtual 544	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   804: putfield 365	com/blizzard/telemetry/proto/standard/Alert:severity_	I
    //   807: goto -328 -> 479
    //   810: aload_1
    //   811: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   814: astore_2
    //   815: aload_0
    //   816: aload_0
    //   817: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   820: bipush 64
    //   822: ior
    //   823: putfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   826: aload_0
    //   827: aload_2
    //   828: putfield 86	com/blizzard/telemetry/proto/standard/Alert:agent_	Ljava/lang/String;
    //   831: goto -352 -> 479
    //   834: aload_1
    //   835: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   838: astore_2
    //   839: aload_0
    //   840: getfield 92	com/blizzard/telemetry/proto/standard/Alert:environments_	Lcom/google/protobuf/Internal$ProtobufList;
    //   843: invokeinterface 374 1 0
    //   848: ifne +14 -> 862
    //   851: aload_0
    //   852: aload_0
    //   853: getfield 92	com/blizzard/telemetry/proto/standard/Alert:environments_	Lcom/google/protobuf/Internal$ProtobufList;
    //   856: invokestatic 378	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   859: putfield 92	com/blizzard/telemetry/proto/standard/Alert:environments_	Lcom/google/protobuf/Internal$ProtobufList;
    //   862: aload_0
    //   863: getfield 92	com/blizzard/telemetry/proto/standard/Alert:environments_	Lcom/google/protobuf/Internal$ProtobufList;
    //   866: aload_2
    //   867: invokeinterface 337 2 0
    //   872: pop
    //   873: goto -394 -> 479
    //   876: aload_1
    //   877: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   880: astore_2
    //   881: aload_0
    //   882: getfield 94	com/blizzard/telemetry/proto/standard/Alert:hostnames_	Lcom/google/protobuf/Internal$ProtobufList;
    //   885: invokeinterface 374 1 0
    //   890: ifne +14 -> 904
    //   893: aload_0
    //   894: aload_0
    //   895: getfield 94	com/blizzard/telemetry/proto/standard/Alert:hostnames_	Lcom/google/protobuf/Internal$ProtobufList;
    //   898: invokestatic 378	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   901: putfield 94	com/blizzard/telemetry/proto/standard/Alert:hostnames_	Lcom/google/protobuf/Internal$ProtobufList;
    //   904: aload_0
    //   905: getfield 94	com/blizzard/telemetry/proto/standard/Alert:hostnames_	Lcom/google/protobuf/Internal$ProtobufList;
    //   908: aload_2
    //   909: invokeinterface 337 2 0
    //   914: pop
    //   915: goto -436 -> 479
    //   918: aload_1
    //   919: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   922: astore_2
    //   923: aload_0
    //   924: aload_0
    //   925: getfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   928: sipush 128
    //   931: ior
    //   932: putfield 345	com/blizzard/telemetry/proto/standard/Alert:bitField0_	I
    //   935: aload_0
    //   936: aload_2
    //   937: putfield 96	com/blizzard/telemetry/proto/standard/Alert:payload_	Ljava/lang/String;
    //   940: goto -461 -> 479
    //   943: aload_1
    //   944: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   947: astore_2
    //   948: aload_0
    //   949: getfield 98	com/blizzard/telemetry/proto/standard/Alert:regions_	Lcom/google/protobuf/Internal$ProtobufList;
    //   952: invokeinterface 374 1 0
    //   957: ifne +14 -> 971
    //   960: aload_0
    //   961: aload_0
    //   962: getfield 98	com/blizzard/telemetry/proto/standard/Alert:regions_	Lcom/google/protobuf/Internal$ProtobufList;
    //   965: invokestatic 378	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   968: putfield 98	com/blizzard/telemetry/proto/standard/Alert:regions_	Lcom/google/protobuf/Internal$ProtobufList;
    //   971: aload_0
    //   972: getfield 98	com/blizzard/telemetry/proto/standard/Alert:regions_	Lcom/google/protobuf/Internal$ProtobufList;
    //   975: aload_2
    //   976: invokeinterface 337 2 0
    //   981: pop
    //   982: goto -503 -> 479
    //   985: aload_1
    //   986: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   989: astore_2
    //   990: aload_0
    //   991: getfield 100	com/blizzard/telemetry/proto/standard/Alert:services_	Lcom/google/protobuf/Internal$ProtobufList;
    //   994: invokeinterface 374 1 0
    //   999: ifne +14 -> 1013
    //   1002: aload_0
    //   1003: aload_0
    //   1004: getfield 100	com/blizzard/telemetry/proto/standard/Alert:services_	Lcom/google/protobuf/Internal$ProtobufList;
    //   1007: invokestatic 378	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   1010: putfield 100	com/blizzard/telemetry/proto/standard/Alert:services_	Lcom/google/protobuf/Internal$ProtobufList;
    //   1013: aload_0
    //   1014: getfield 100	com/blizzard/telemetry/proto/standard/Alert:services_	Lcom/google/protobuf/Internal$ProtobufList;
    //   1017: aload_2
    //   1018: invokeinterface 337 2 0
    //   1023: pop
    //   1024: goto -545 -> 479
    //   1027: aload_1
    //   1028: invokevirtual 523	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   1031: astore_2
    //   1032: aload_0
    //   1033: getfield 102	com/blizzard/telemetry/proto/standard/Alert:sites_	Lcom/google/protobuf/Internal$ProtobufList;
    //   1036: invokeinterface 374 1 0
    //   1041: ifne +14 -> 1055
    //   1044: aload_0
    //   1045: aload_0
    //   1046: getfield 102	com/blizzard/telemetry/proto/standard/Alert:sites_	Lcom/google/protobuf/Internal$ProtobufList;
    //   1049: invokestatic 378	com/google/protobuf/GeneratedMessageLite:mutableCopy	(Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   1052: putfield 102	com/blizzard/telemetry/proto/standard/Alert:sites_	Lcom/google/protobuf/Internal$ProtobufList;
    //   1055: aload_0
    //   1056: getfield 102	com/blizzard/telemetry/proto/standard/Alert:sites_	Lcom/google/protobuf/Internal$ProtobufList;
    //   1059: aload_2
    //   1060: invokeinterface 337 2 0
    //   1065: pop
    //   1066: goto -587 -> 479
    //   1069: getstatic 69	com/blizzard/telemetry/proto/standard/Alert:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/Alert;
    //   1072: areturn
    //   1073: getstatic 546	com/blizzard/telemetry/proto/standard/Alert:PARSER	Lcom/google/protobuf/Parser;
    //   1076: ifnonnull +28 -> 1104
    //   1079: ldc 2
    //   1081: monitorenter
    //   1082: getstatic 546	com/blizzard/telemetry/proto/standard/Alert:PARSER	Lcom/google/protobuf/Parser;
    //   1085: ifnonnull +16 -> 1101
    //   1088: new 548	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   1091: dup
    //   1092: getstatic 69	com/blizzard/telemetry/proto/standard/Alert:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/Alert;
    //   1095: invokespecial 551	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   1098: putstatic 546	com/blizzard/telemetry/proto/standard/Alert:PARSER	Lcom/google/protobuf/Parser;
    //   1101: ldc 2
    //   1103: monitorexit
    //   1104: getstatic 546	com/blizzard/telemetry/proto/standard/Alert:PARSER	Lcom/google/protobuf/Parser;
    //   1107: areturn
    //   1108: astore_1
    //   1109: ldc 2
    //   1111: monitorexit
    //   1112: aload_1
    //   1113: athrow
    //   1114: goto -498 -> 616
    //   1117: iconst_1
    //   1118: istore 4
    //   1120: goto -641 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1123	0	this	Alert
    //   0	1123	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	1123	2	paramObject1	Object
    //   0	1123	3	paramObject2	Object
    //   477	642	4	i	int
    //   488	130	5	j	int
    // Exception table:
    //   from	to	target	type
    //   484	490	655	com/google/protobuf/InvalidProtocolBufferException
    //   616	626	655	com/google/protobuf/InvalidProtocolBufferException
    //   632	652	655	com/google/protobuf/InvalidProtocolBufferException
    //   672	692	655	com/google/protobuf/InvalidProtocolBufferException
    //   719	739	655	com/google/protobuf/InvalidProtocolBufferException
    //   742	763	655	com/google/protobuf/InvalidProtocolBufferException
    //   766	785	655	com/google/protobuf/InvalidProtocolBufferException
    //   788	807	655	com/google/protobuf/InvalidProtocolBufferException
    //   810	831	655	com/google/protobuf/InvalidProtocolBufferException
    //   834	862	655	com/google/protobuf/InvalidProtocolBufferException
    //   862	873	655	com/google/protobuf/InvalidProtocolBufferException
    //   876	904	655	com/google/protobuf/InvalidProtocolBufferException
    //   904	915	655	com/google/protobuf/InvalidProtocolBufferException
    //   918	940	655	com/google/protobuf/InvalidProtocolBufferException
    //   943	971	655	com/google/protobuf/InvalidProtocolBufferException
    //   971	982	655	com/google/protobuf/InvalidProtocolBufferException
    //   985	1013	655	com/google/protobuf/InvalidProtocolBufferException
    //   1013	1024	655	com/google/protobuf/InvalidProtocolBufferException
    //   1027	1055	655	com/google/protobuf/InvalidProtocolBufferException
    //   1055	1066	655	com/google/protobuf/InvalidProtocolBufferException
    //   484	490	669	finally
    //   616	626	669	finally
    //   632	652	669	finally
    //   656	669	669	finally
    //   672	692	669	finally
    //   696	719	669	finally
    //   719	739	669	finally
    //   742	763	669	finally
    //   766	785	669	finally
    //   788	807	669	finally
    //   810	831	669	finally
    //   834	862	669	finally
    //   862	873	669	finally
    //   876	904	669	finally
    //   904	915	669	finally
    //   918	940	669	finally
    //   943	971	669	finally
    //   971	982	669	finally
    //   985	1013	669	finally
    //   1013	1024	669	finally
    //   1027	1055	669	finally
    //   1055	1066	669	finally
    //   484	490	695	java/io/IOException
    //   616	626	695	java/io/IOException
    //   632	652	695	java/io/IOException
    //   672	692	695	java/io/IOException
    //   719	739	695	java/io/IOException
    //   742	763	695	java/io/IOException
    //   766	785	695	java/io/IOException
    //   788	807	695	java/io/IOException
    //   810	831	695	java/io/IOException
    //   834	862	695	java/io/IOException
    //   862	873	695	java/io/IOException
    //   876	904	695	java/io/IOException
    //   904	915	695	java/io/IOException
    //   918	940	695	java/io/IOException
    //   943	971	695	java/io/IOException
    //   971	982	695	java/io/IOException
    //   985	1013	695	java/io/IOException
    //   1013	1024	695	java/io/IOException
    //   1027	1055	695	java/io/IOException
    //   1055	1066	695	java/io/IOException
    //   1082	1101	1108	finally
    //   1101	1104	1108	finally
    //   1109	1112	1108	finally
  }
  
  public String getAgent()
  {
    return this.agent_;
  }
  
  public ByteString getAgentBytes()
  {
    return ByteString.copyFromUtf8(this.agent_);
  }
  
  public String getConditionId()
  {
    return this.conditionId_;
  }
  
  public ByteString getConditionIdBytes()
  {
    return ByteString.copyFromUtf8(this.conditionId_);
  }
  
  public String getDescription()
  {
    return this.description_;
  }
  
  public ByteString getDescriptionBytes()
  {
    return ByteString.copyFromUtf8(this.description_);
  }
  
  public String getEnvironments(int paramInt)
  {
    return (String)this.environments_.get(paramInt);
  }
  
  public ByteString getEnvironmentsBytes(int paramInt)
  {
    return ByteString.copyFromUtf8((String)this.environments_.get(paramInt));
  }
  
  public int getEnvironmentsCount()
  {
    return this.environments_.size();
  }
  
  public List<String> getEnvironmentsList()
  {
    return this.environments_;
  }
  
  public String getHostnames(int paramInt)
  {
    return (String)this.hostnames_.get(paramInt);
  }
  
  public ByteString getHostnamesBytes(int paramInt)
  {
    return ByteString.copyFromUtf8((String)this.hostnames_.get(paramInt));
  }
  
  public int getHostnamesCount()
  {
    return this.hostnames_.size();
  }
  
  public List<String> getHostnamesList()
  {
    return this.hostnames_;
  }
  
  public String getPayload()
  {
    return this.payload_;
  }
  
  public ByteString getPayloadBytes()
  {
    return ByteString.copyFromUtf8(this.payload_);
  }
  
  public String getQualifier()
  {
    return this.qualifier_;
  }
  
  public ByteString getQualifierBytes()
  {
    return ByteString.copyFromUtf8(this.qualifier_);
  }
  
  public String getRegions(int paramInt)
  {
    return (String)this.regions_.get(paramInt);
  }
  
  public ByteString getRegionsBytes(int paramInt)
  {
    return ByteString.copyFromUtf8((String)this.regions_.get(paramInt));
  }
  
  public int getRegionsCount()
  {
    return this.regions_.size();
  }
  
  public List<String> getRegionsList()
  {
    return this.regions_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = 0 + CodedOutputStream.computeStringSize(1, getConditionId());
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeStringSize(2, getQualifier());
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeStringSize(3, getSummary());
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeStringSize(4, getDescription());
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeUInt64Size(5, this.timestampUtc_);
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + CodedOutputStream.computeUInt32Size(6, this.severity_);
    }
    j = i;
    if ((this.bitField0_ & 0x40) == 64) {
      j = i + CodedOutputStream.computeStringSize(7, getAgent());
    }
    i = 0;
    int k = 0;
    while (k < this.environments_.size())
    {
      i += CodedOutputStream.computeStringSizeNoTag((String)this.environments_.get(k));
      k += 1;
    }
    int n = getEnvironmentsList().size();
    int m = 0;
    k = 0;
    while (k < this.hostnames_.size())
    {
      m += CodedOutputStream.computeStringSizeNoTag((String)this.hostnames_.get(k));
      k += 1;
    }
    j = j + i + n * 1 + m + getHostnamesList().size() * 1;
    i = j;
    if ((this.bitField0_ & 0x80) == 128) {
      i = j + CodedOutputStream.computeStringSize(10, getPayload());
    }
    j = 0;
    k = 0;
    while (k < this.regions_.size())
    {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.regions_.get(k));
      k += 1;
    }
    int i1 = getRegionsList().size();
    k = 0;
    m = 0;
    while (m < this.services_.size())
    {
      k += CodedOutputStream.computeStringSizeNoTag((String)this.services_.get(m));
      m += 1;
    }
    int i2 = getServicesList().size();
    n = 0;
    m = 0;
    while (m < this.sites_.size())
    {
      n += CodedOutputStream.computeStringSizeNoTag((String)this.sites_.get(m));
      m += 1;
    }
    i = i + j + i1 * 1 + k + i2 * 1 + n + getSitesList().size() * 1 + this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getServices(int paramInt)
  {
    return (String)this.services_.get(paramInt);
  }
  
  public ByteString getServicesBytes(int paramInt)
  {
    return ByteString.copyFromUtf8((String)this.services_.get(paramInt));
  }
  
  public int getServicesCount()
  {
    return this.services_.size();
  }
  
  public List<String> getServicesList()
  {
    return this.services_;
  }
  
  public int getSeverity()
  {
    return this.severity_;
  }
  
  public String getSites(int paramInt)
  {
    return (String)this.sites_.get(paramInt);
  }
  
  public ByteString getSitesBytes(int paramInt)
  {
    return ByteString.copyFromUtf8((String)this.sites_.get(paramInt));
  }
  
  public int getSitesCount()
  {
    return this.sites_.size();
  }
  
  public List<String> getSitesList()
  {
    return this.sites_;
  }
  
  public String getSummary()
  {
    return this.summary_;
  }
  
  public ByteString getSummaryBytes()
  {
    return ByteString.copyFromUtf8(this.summary_);
  }
  
  public long getTimestampUtc()
  {
    return this.timestampUtc_;
  }
  
  public boolean hasAgent()
  {
    return (this.bitField0_ & 0x40) == 64;
  }
  
  public boolean hasConditionId()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasDescription()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasPayload()
  {
    return (this.bitField0_ & 0x80) == 128;
  }
  
  public boolean hasQualifier()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasSeverity()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasSummary()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasTimestampUtc()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeString(1, getConditionId());
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeString(2, getQualifier());
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeString(3, getSummary());
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeString(4, getDescription());
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeUInt64(5, this.timestampUtc_);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeUInt32(6, this.severity_);
    }
    if ((this.bitField0_ & 0x40) == 64) {
      paramCodedOutputStream.writeString(7, getAgent());
    }
    int i = 0;
    while (i < this.environments_.size())
    {
      paramCodedOutputStream.writeString(8, (String)this.environments_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.hostnames_.size())
    {
      paramCodedOutputStream.writeString(9, (String)this.hostnames_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x80) == 128) {
      paramCodedOutputStream.writeString(10, getPayload());
    }
    i = 0;
    while (i < this.regions_.size())
    {
      paramCodedOutputStream.writeString(11, (String)this.regions_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.services_.size())
    {
      paramCodedOutputStream.writeString(12, (String)this.services_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.sites_.size())
    {
      paramCodedOutputStream.writeString(13, (String)this.sites_.get(i));
      i += 1;
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Alert, Builder>
    implements AlertOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder addAllEnvironments(Iterable<String> paramIterable)
    {
      copyOnWrite();
      ((Alert)this.instance).addAllEnvironments(paramIterable);
      return this;
    }
    
    public Builder addAllHostnames(Iterable<String> paramIterable)
    {
      copyOnWrite();
      ((Alert)this.instance).addAllHostnames(paramIterable);
      return this;
    }
    
    public Builder addAllRegions(Iterable<String> paramIterable)
    {
      copyOnWrite();
      ((Alert)this.instance).addAllRegions(paramIterable);
      return this;
    }
    
    public Builder addAllServices(Iterable<String> paramIterable)
    {
      copyOnWrite();
      ((Alert)this.instance).addAllServices(paramIterable);
      return this;
    }
    
    public Builder addAllSites(Iterable<String> paramIterable)
    {
      copyOnWrite();
      ((Alert)this.instance).addAllSites(paramIterable);
      return this;
    }
    
    public Builder addEnvironments(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).addEnvironments(paramString);
      return this;
    }
    
    public Builder addEnvironmentsBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).addEnvironmentsBytes(paramByteString);
      return this;
    }
    
    public Builder addHostnames(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).addHostnames(paramString);
      return this;
    }
    
    public Builder addHostnamesBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).addHostnamesBytes(paramByteString);
      return this;
    }
    
    public Builder addRegions(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).addRegions(paramString);
      return this;
    }
    
    public Builder addRegionsBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).addRegionsBytes(paramByteString);
      return this;
    }
    
    public Builder addServices(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).addServices(paramString);
      return this;
    }
    
    public Builder addServicesBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).addServicesBytes(paramByteString);
      return this;
    }
    
    public Builder addSites(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).addSites(paramString);
      return this;
    }
    
    public Builder addSitesBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).addSitesBytes(paramByteString);
      return this;
    }
    
    public Builder clearAgent()
    {
      copyOnWrite();
      ((Alert)this.instance).clearAgent();
      return this;
    }
    
    public Builder clearConditionId()
    {
      copyOnWrite();
      ((Alert)this.instance).clearConditionId();
      return this;
    }
    
    public Builder clearDescription()
    {
      copyOnWrite();
      ((Alert)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearEnvironments()
    {
      copyOnWrite();
      ((Alert)this.instance).clearEnvironments();
      return this;
    }
    
    public Builder clearHostnames()
    {
      copyOnWrite();
      ((Alert)this.instance).clearHostnames();
      return this;
    }
    
    public Builder clearPayload()
    {
      copyOnWrite();
      ((Alert)this.instance).clearPayload();
      return this;
    }
    
    public Builder clearQualifier()
    {
      copyOnWrite();
      ((Alert)this.instance).clearQualifier();
      return this;
    }
    
    public Builder clearRegions()
    {
      copyOnWrite();
      ((Alert)this.instance).clearRegions();
      return this;
    }
    
    public Builder clearServices()
    {
      copyOnWrite();
      ((Alert)this.instance).clearServices();
      return this;
    }
    
    public Builder clearSeverity()
    {
      copyOnWrite();
      ((Alert)this.instance).clearSeverity();
      return this;
    }
    
    public Builder clearSites()
    {
      copyOnWrite();
      ((Alert)this.instance).clearSites();
      return this;
    }
    
    public Builder clearSummary()
    {
      copyOnWrite();
      ((Alert)this.instance).clearSummary();
      return this;
    }
    
    public Builder clearTimestampUtc()
    {
      copyOnWrite();
      ((Alert)this.instance).clearTimestampUtc();
      return this;
    }
    
    public String getAgent()
    {
      return ((Alert)this.instance).getAgent();
    }
    
    public ByteString getAgentBytes()
    {
      return ((Alert)this.instance).getAgentBytes();
    }
    
    public String getConditionId()
    {
      return ((Alert)this.instance).getConditionId();
    }
    
    public ByteString getConditionIdBytes()
    {
      return ((Alert)this.instance).getConditionIdBytes();
    }
    
    public String getDescription()
    {
      return ((Alert)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes()
    {
      return ((Alert)this.instance).getDescriptionBytes();
    }
    
    public String getEnvironments(int paramInt)
    {
      return ((Alert)this.instance).getEnvironments(paramInt);
    }
    
    public ByteString getEnvironmentsBytes(int paramInt)
    {
      return ((Alert)this.instance).getEnvironmentsBytes(paramInt);
    }
    
    public int getEnvironmentsCount()
    {
      return ((Alert)this.instance).getEnvironmentsCount();
    }
    
    public List<String> getEnvironmentsList()
    {
      return Collections.unmodifiableList(((Alert)this.instance).getEnvironmentsList());
    }
    
    public String getHostnames(int paramInt)
    {
      return ((Alert)this.instance).getHostnames(paramInt);
    }
    
    public ByteString getHostnamesBytes(int paramInt)
    {
      return ((Alert)this.instance).getHostnamesBytes(paramInt);
    }
    
    public int getHostnamesCount()
    {
      return ((Alert)this.instance).getHostnamesCount();
    }
    
    public List<String> getHostnamesList()
    {
      return Collections.unmodifiableList(((Alert)this.instance).getHostnamesList());
    }
    
    public String getPayload()
    {
      return ((Alert)this.instance).getPayload();
    }
    
    public ByteString getPayloadBytes()
    {
      return ((Alert)this.instance).getPayloadBytes();
    }
    
    public String getQualifier()
    {
      return ((Alert)this.instance).getQualifier();
    }
    
    public ByteString getQualifierBytes()
    {
      return ((Alert)this.instance).getQualifierBytes();
    }
    
    public String getRegions(int paramInt)
    {
      return ((Alert)this.instance).getRegions(paramInt);
    }
    
    public ByteString getRegionsBytes(int paramInt)
    {
      return ((Alert)this.instance).getRegionsBytes(paramInt);
    }
    
    public int getRegionsCount()
    {
      return ((Alert)this.instance).getRegionsCount();
    }
    
    public List<String> getRegionsList()
    {
      return Collections.unmodifiableList(((Alert)this.instance).getRegionsList());
    }
    
    public String getServices(int paramInt)
    {
      return ((Alert)this.instance).getServices(paramInt);
    }
    
    public ByteString getServicesBytes(int paramInt)
    {
      return ((Alert)this.instance).getServicesBytes(paramInt);
    }
    
    public int getServicesCount()
    {
      return ((Alert)this.instance).getServicesCount();
    }
    
    public List<String> getServicesList()
    {
      return Collections.unmodifiableList(((Alert)this.instance).getServicesList());
    }
    
    public int getSeverity()
    {
      return ((Alert)this.instance).getSeverity();
    }
    
    public String getSites(int paramInt)
    {
      return ((Alert)this.instance).getSites(paramInt);
    }
    
    public ByteString getSitesBytes(int paramInt)
    {
      return ((Alert)this.instance).getSitesBytes(paramInt);
    }
    
    public int getSitesCount()
    {
      return ((Alert)this.instance).getSitesCount();
    }
    
    public List<String> getSitesList()
    {
      return Collections.unmodifiableList(((Alert)this.instance).getSitesList());
    }
    
    public String getSummary()
    {
      return ((Alert)this.instance).getSummary();
    }
    
    public ByteString getSummaryBytes()
    {
      return ((Alert)this.instance).getSummaryBytes();
    }
    
    public long getTimestampUtc()
    {
      return ((Alert)this.instance).getTimestampUtc();
    }
    
    public boolean hasAgent()
    {
      return ((Alert)this.instance).hasAgent();
    }
    
    public boolean hasConditionId()
    {
      return ((Alert)this.instance).hasConditionId();
    }
    
    public boolean hasDescription()
    {
      return ((Alert)this.instance).hasDescription();
    }
    
    public boolean hasPayload()
    {
      return ((Alert)this.instance).hasPayload();
    }
    
    public boolean hasQualifier()
    {
      return ((Alert)this.instance).hasQualifier();
    }
    
    public boolean hasSeverity()
    {
      return ((Alert)this.instance).hasSeverity();
    }
    
    public boolean hasSummary()
    {
      return ((Alert)this.instance).hasSummary();
    }
    
    public boolean hasTimestampUtc()
    {
      return ((Alert)this.instance).hasTimestampUtc();
    }
    
    public Builder setAgent(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setAgent(paramString);
      return this;
    }
    
    public Builder setAgentBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).setAgentBytes(paramByteString);
      return this;
    }
    
    public Builder setConditionId(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setConditionId(paramString);
      return this;
    }
    
    public Builder setConditionIdBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).setConditionIdBytes(paramByteString);
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setDescription(paramString);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).setDescriptionBytes(paramByteString);
      return this;
    }
    
    public Builder setEnvironments(int paramInt, String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setEnvironments(paramInt, paramString);
      return this;
    }
    
    public Builder setHostnames(int paramInt, String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setHostnames(paramInt, paramString);
      return this;
    }
    
    public Builder setPayload(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setPayload(paramString);
      return this;
    }
    
    public Builder setPayloadBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).setPayloadBytes(paramByteString);
      return this;
    }
    
    public Builder setQualifier(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setQualifier(paramString);
      return this;
    }
    
    public Builder setQualifierBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).setQualifierBytes(paramByteString);
      return this;
    }
    
    public Builder setRegions(int paramInt, String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setRegions(paramInt, paramString);
      return this;
    }
    
    public Builder setServices(int paramInt, String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setServices(paramInt, paramString);
      return this;
    }
    
    public Builder setSeverity(int paramInt)
    {
      copyOnWrite();
      ((Alert)this.instance).setSeverity(paramInt);
      return this;
    }
    
    public Builder setSites(int paramInt, String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setSites(paramInt, paramString);
      return this;
    }
    
    public Builder setSummary(String paramString)
    {
      copyOnWrite();
      ((Alert)this.instance).setSummary(paramString);
      return this;
    }
    
    public Builder setSummaryBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Alert)this.instance).setSummaryBytes(paramByteString);
      return this;
    }
    
    public Builder setTimestampUtc(long paramLong)
    {
      copyOnWrite();
      ((Alert)this.instance).setTimestampUtc(paramLong);
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/Alert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */