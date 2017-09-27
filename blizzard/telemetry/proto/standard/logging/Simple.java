package com.blizzard.telemetry.proto.standard.logging;

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

public final class Simple
  extends GeneratedMessageLite<Simple, Builder>
  implements SimpleOrBuilder
{
  private static final Simple DEFAULT_INSTANCE = new Simple();
  public static final int MESSAGE_FIELD_NUMBER = 1;
  private static volatile Parser<Simple> PARSER;
  public static final int SEVERITY_FIELD_NUMBER = 2;
  public static final int SEVERITY_NAME_FIELD_NUMBER = 3;
  private int bitField0_;
  private String message_ = "";
  private String severityName_ = "";
  private int severity_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearMessage()
  {
    this.bitField0_ &= 0xFFFFFFFE;
    this.message_ = getDefaultInstance().getMessage();
  }
  
  private void clearSeverity()
  {
    this.bitField0_ &= 0xFFFFFFFD;
    this.severity_ = 0;
  }
  
  private void clearSeverityName()
  {
    this.bitField0_ &= 0xFFFFFFFB;
    this.severityName_ = getDefaultInstance().getSeverityName();
  }
  
  public static Simple getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Simple paramSimple)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramSimple);
  }
  
  public static Simple parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Simple)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Simple parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Simple)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Simple parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Simple)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Simple parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Simple)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Simple parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Simple)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Simple parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Simple)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Simple parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Simple)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Simple parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Simple)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Simple parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Simple)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Simple parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Simple)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Simple> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setMessage(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x1;
    this.message_ = paramString;
  }
  
  private void setMessageBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x1;
    this.message_ = paramByteString.toStringUtf8();
  }
  
  private void setSeverity(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.severity_ = paramInt;
  }
  
  private void setSeverityName(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x4;
    this.severityName_ = paramString;
  }
  
  private void setSeverityNameBytes(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new NullPointerException();
    }
    this.bitField0_ |= 0x4;
    this.severityName_ = paramByteString.toStringUtf8();
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 177	com/blizzard/telemetry/proto/standard/logging/Simple$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 183	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+193->201, 7:+384->392, 8:+388->396
    //   56: new 185	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 186	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/blizzard/telemetry/proto/standard/logging/Simple
    //   67: dup
    //   68: invokespecial 34	com/blizzard/telemetry/proto/standard/logging/Simple:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 36	com/blizzard/telemetry/proto/standard/logging/Simple:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/logging/Simple;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/blizzard/telemetry/proto/standard/logging/Simple$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 189	com/blizzard/telemetry/proto/standard/logging/Simple$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/logging/Simple$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 191	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/blizzard/telemetry/proto/standard/logging/Simple
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 195	com/blizzard/telemetry/proto/standard/logging/Simple:hasMessage	()Z
    //   105: aload_0
    //   106: getfield 45	com/blizzard/telemetry/proto/standard/logging/Simple:message_	Ljava/lang/String;
    //   109: aload_3
    //   110: invokevirtual 195	com/blizzard/telemetry/proto/standard/logging/Simple:hasMessage	()Z
    //   113: aload_3
    //   114: getfield 45	com/blizzard/telemetry/proto/standard/logging/Simple:message_	Ljava/lang/String;
    //   117: invokeinterface 199 5 0
    //   122: putfield 45	com/blizzard/telemetry/proto/standard/logging/Simple:message_	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 202	com/blizzard/telemetry/proto/standard/logging/Simple:hasSeverity	()Z
    //   131: aload_0
    //   132: getfield 99	com/blizzard/telemetry/proto/standard/logging/Simple:severity_	I
    //   135: aload_3
    //   136: invokevirtual 202	com/blizzard/telemetry/proto/standard/logging/Simple:hasSeverity	()Z
    //   139: aload_3
    //   140: getfield 99	com/blizzard/telemetry/proto/standard/logging/Simple:severity_	I
    //   143: invokeinterface 206 5 0
    //   148: putfield 99	com/blizzard/telemetry/proto/standard/logging/Simple:severity_	I
    //   151: aload_0
    //   152: aload_2
    //   153: aload_0
    //   154: invokevirtual 209	com/blizzard/telemetry/proto/standard/logging/Simple:hasSeverityName	()Z
    //   157: aload_0
    //   158: getfield 47	com/blizzard/telemetry/proto/standard/logging/Simple:severityName_	Ljava/lang/String;
    //   161: aload_3
    //   162: invokevirtual 209	com/blizzard/telemetry/proto/standard/logging/Simple:hasSeverityName	()Z
    //   165: aload_3
    //   166: getfield 47	com/blizzard/telemetry/proto/standard/logging/Simple:severityName_	Ljava/lang/String;
    //   169: invokeinterface 199 5 0
    //   174: putfield 47	com/blizzard/telemetry/proto/standard/logging/Simple:severityName_	Ljava/lang/String;
    //   177: aload_0
    //   178: astore_1
    //   179: aload_2
    //   180: getstatic 215	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   183: if_acmpne -111 -> 72
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 90	com/blizzard/telemetry/proto/standard/logging/Simple:bitField0_	I
    //   191: aload_3
    //   192: getfield 90	com/blizzard/telemetry/proto/standard/logging/Simple:bitField0_	I
    //   195: ior
    //   196: putfield 90	com/blizzard/telemetry/proto/standard/logging/Simple:bitField0_	I
    //   199: aload_0
    //   200: areturn
    //   201: aload_2
    //   202: checkcast 217	com/google/protobuf/CodedInputStream
    //   205: astore_1
    //   206: aload_3
    //   207: checkcast 219	com/google/protobuf/ExtensionRegistryLite
    //   210: astore_2
    //   211: iconst_0
    //   212: istore 4
    //   214: iload 4
    //   216: ifne +176 -> 392
    //   219: aload_1
    //   220: invokevirtual 222	com/google/protobuf/CodedInputStream:readTag	()I
    //   223: istore 5
    //   225: iload 5
    //   227: lookupswitch	default:+210->437, 0:+213->440, 10:+57->284, 16:+97->324, 26:+142->369
    //   268: aload_0
    //   269: iload 5
    //   271: aload_1
    //   272: invokevirtual 226	com/blizzard/telemetry/proto/standard/logging/Simple:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   275: ifne -61 -> 214
    //   278: iconst_1
    //   279: istore 4
    //   281: goto -67 -> 214
    //   284: aload_1
    //   285: invokevirtual 229	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   288: astore_2
    //   289: aload_0
    //   290: aload_0
    //   291: getfield 90	com/blizzard/telemetry/proto/standard/logging/Simple:bitField0_	I
    //   294: iconst_1
    //   295: ior
    //   296: putfield 90	com/blizzard/telemetry/proto/standard/logging/Simple:bitField0_	I
    //   299: aload_0
    //   300: aload_2
    //   301: putfield 45	com/blizzard/telemetry/proto/standard/logging/Simple:message_	Ljava/lang/String;
    //   304: goto -90 -> 214
    //   307: astore_1
    //   308: new 231	java/lang/RuntimeException
    //   311: dup
    //   312: aload_1
    //   313: aload_0
    //   314: invokevirtual 235	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   317: invokespecial 238	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   320: athrow
    //   321: astore_1
    //   322: aload_1
    //   323: athrow
    //   324: aload_0
    //   325: aload_0
    //   326: getfield 90	com/blizzard/telemetry/proto/standard/logging/Simple:bitField0_	I
    //   329: iconst_2
    //   330: ior
    //   331: putfield 90	com/blizzard/telemetry/proto/standard/logging/Simple:bitField0_	I
    //   334: aload_0
    //   335: aload_1
    //   336: invokevirtual 241	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   339: putfield 99	com/blizzard/telemetry/proto/standard/logging/Simple:severity_	I
    //   342: goto -128 -> 214
    //   345: astore_1
    //   346: new 231	java/lang/RuntimeException
    //   349: dup
    //   350: new 129	com/google/protobuf/InvalidProtocolBufferException
    //   353: dup
    //   354: aload_1
    //   355: invokevirtual 242	java/io/IOException:getMessage	()Ljava/lang/String;
    //   358: invokespecial 244	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   361: aload_0
    //   362: invokevirtual 235	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   365: invokespecial 238	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   368: athrow
    //   369: aload_1
    //   370: invokevirtual 229	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
    //   373: astore_2
    //   374: aload_0
    //   375: aload_0
    //   376: getfield 90	com/blizzard/telemetry/proto/standard/logging/Simple:bitField0_	I
    //   379: iconst_4
    //   380: ior
    //   381: putfield 90	com/blizzard/telemetry/proto/standard/logging/Simple:bitField0_	I
    //   384: aload_0
    //   385: aload_2
    //   386: putfield 47	com/blizzard/telemetry/proto/standard/logging/Simple:severityName_	Ljava/lang/String;
    //   389: goto -175 -> 214
    //   392: getstatic 36	com/blizzard/telemetry/proto/standard/logging/Simple:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/logging/Simple;
    //   395: areturn
    //   396: getstatic 246	com/blizzard/telemetry/proto/standard/logging/Simple:PARSER	Lcom/google/protobuf/Parser;
    //   399: ifnonnull +28 -> 427
    //   402: ldc 2
    //   404: monitorenter
    //   405: getstatic 246	com/blizzard/telemetry/proto/standard/logging/Simple:PARSER	Lcom/google/protobuf/Parser;
    //   408: ifnonnull +16 -> 424
    //   411: new 248	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   414: dup
    //   415: getstatic 36	com/blizzard/telemetry/proto/standard/logging/Simple:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/logging/Simple;
    //   418: invokespecial 251	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   421: putstatic 246	com/blizzard/telemetry/proto/standard/logging/Simple:PARSER	Lcom/google/protobuf/Parser;
    //   424: ldc 2
    //   426: monitorexit
    //   427: getstatic 246	com/blizzard/telemetry/proto/standard/logging/Simple:PARSER	Lcom/google/protobuf/Parser;
    //   430: areturn
    //   431: astore_1
    //   432: ldc 2
    //   434: monitorexit
    //   435: aload_1
    //   436: athrow
    //   437: goto -169 -> 268
    //   440: iconst_1
    //   441: istore 4
    //   443: goto -229 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	this	Simple
    //   0	446	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	446	2	paramObject1	Object
    //   0	446	3	paramObject2	Object
    //   212	230	4	i	int
    //   223	47	5	j	int
    // Exception table:
    //   from	to	target	type
    //   219	225	307	com/google/protobuf/InvalidProtocolBufferException
    //   268	278	307	com/google/protobuf/InvalidProtocolBufferException
    //   284	304	307	com/google/protobuf/InvalidProtocolBufferException
    //   324	342	307	com/google/protobuf/InvalidProtocolBufferException
    //   369	389	307	com/google/protobuf/InvalidProtocolBufferException
    //   219	225	321	finally
    //   268	278	321	finally
    //   284	304	321	finally
    //   308	321	321	finally
    //   324	342	321	finally
    //   346	369	321	finally
    //   369	389	321	finally
    //   219	225	345	java/io/IOException
    //   268	278	345	java/io/IOException
    //   284	304	345	java/io/IOException
    //   324	342	345	java/io/IOException
    //   369	389	345	java/io/IOException
    //   405	424	431	finally
    //   424	427	431	finally
    //   432	435	431	finally
  }
  
  public String getMessage()
  {
    return this.message_;
  }
  
  public ByteString getMessageBytes()
  {
    return ByteString.copyFromUtf8(this.message_);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = 0 + CodedOutputStream.computeStringSize(1, getMessage());
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeUInt32Size(2, this.severity_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeStringSize(3, getSeverityName());
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int getSeverity()
  {
    return this.severity_;
  }
  
  public String getSeverityName()
  {
    return this.severityName_;
  }
  
  public ByteString getSeverityNameBytes()
  {
    return ByteString.copyFromUtf8(this.severityName_);
  }
  
  public boolean hasMessage()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasSeverity()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasSeverityName()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeString(1, getMessage());
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeUInt32(2, this.severity_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeString(3, getSeverityName());
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Simple, Builder>
    implements SimpleOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearMessage()
    {
      copyOnWrite();
      ((Simple)this.instance).clearMessage();
      return this;
    }
    
    public Builder clearSeverity()
    {
      copyOnWrite();
      ((Simple)this.instance).clearSeverity();
      return this;
    }
    
    public Builder clearSeverityName()
    {
      copyOnWrite();
      ((Simple)this.instance).clearSeverityName();
      return this;
    }
    
    public String getMessage()
    {
      return ((Simple)this.instance).getMessage();
    }
    
    public ByteString getMessageBytes()
    {
      return ((Simple)this.instance).getMessageBytes();
    }
    
    public int getSeverity()
    {
      return ((Simple)this.instance).getSeverity();
    }
    
    public String getSeverityName()
    {
      return ((Simple)this.instance).getSeverityName();
    }
    
    public ByteString getSeverityNameBytes()
    {
      return ((Simple)this.instance).getSeverityNameBytes();
    }
    
    public boolean hasMessage()
    {
      return ((Simple)this.instance).hasMessage();
    }
    
    public boolean hasSeverity()
    {
      return ((Simple)this.instance).hasSeverity();
    }
    
    public boolean hasSeverityName()
    {
      return ((Simple)this.instance).hasSeverityName();
    }
    
    public Builder setMessage(String paramString)
    {
      copyOnWrite();
      ((Simple)this.instance).setMessage(paramString);
      return this;
    }
    
    public Builder setMessageBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Simple)this.instance).setMessageBytes(paramByteString);
      return this;
    }
    
    public Builder setSeverity(int paramInt)
    {
      copyOnWrite();
      ((Simple)this.instance).setSeverity(paramInt);
      return this;
    }
    
    public Builder setSeverityName(String paramString)
    {
      copyOnWrite();
      ((Simple)this.instance).setSeverityName(paramString);
      return this;
    }
    
    public Builder setSeverityNameBytes(ByteString paramByteString)
    {
      copyOnWrite();
      ((Simple)this.instance).setSeverityNameBytes(paramByteString);
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/logging/Simple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */