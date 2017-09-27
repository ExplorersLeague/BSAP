package com.blizzard.telemetry.proto.standard.process;

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

public final class Finish
  extends GeneratedMessageLite<Finish, Builder>
  implements FinishOrBuilder
{
  private static final Finish DEFAULT_INSTANCE = new Finish();
  public static final int EXIT_CODE_FIELD_NUMBER = 2;
  private static volatile Parser<Finish> PARSER;
  public static final int PID_FIELD_NUMBER = 1;
  private int bitField0_;
  private int exitCode_;
  private int pid_;
  
  static
  {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearExitCode()
  {
    this.bitField0_ &= 0xFFFFFFFD;
    this.exitCode_ = 0;
  }
  
  private void clearPid()
  {
    this.bitField0_ &= 0xFFFFFFFE;
    this.pid_ = 0;
  }
  
  public static Finish getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder()
  {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Finish paramFinish)
  {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFinish);
  }
  
  public static Finish parseDelimitedFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Finish)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Finish parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Finish)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Finish parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return (Finish)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Finish parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Finish)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Finish parseFrom(CodedInputStream paramCodedInputStream)
    throws IOException
  {
    return (Finish)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Finish parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Finish)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Finish parseFrom(InputStream paramInputStream)
    throws IOException
  {
    return (Finish)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Finish parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException
  {
    return (Finish)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Finish parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return (Finish)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
  }
  
  public static Finish parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return (Finish)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public static Parser<Finish> parser()
  {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setExitCode(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.exitCode_ = paramInt;
  }
  
  private void setPid(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.pid_ = paramInt;
  }
  
  /* Error */
  protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 132	com/blizzard/telemetry/proto/standard/process/Finish$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
    //   3: aload_1
    //   4: invokevirtual 138	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+327->335, 8:+331->339
    //   56: new 140	java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial 141	java/lang/UnsupportedOperationException:<init>	()V
    //   63: athrow
    //   64: new 2	com/blizzard/telemetry/proto/standard/process/Finish
    //   67: dup
    //   68: invokespecial 30	com/blizzard/telemetry/proto/standard/process/Finish:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 32	com/blizzard/telemetry/proto/standard/process/Finish:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/process/Finish;
    //   77: areturn
    //   78: aconst_null
    //   79: areturn
    //   80: new 11	com/blizzard/telemetry/proto/standard/process/Finish$Builder
    //   83: dup
    //   84: aconst_null
    //   85: invokespecial 144	com/blizzard/telemetry/proto/standard/process/Finish$Builder:<init>	(Lcom/blizzard/telemetry/proto/standard/process/Finish$1;)V
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 146	com/google/protobuf/GeneratedMessageLite$Visitor
    //   93: astore_2
    //   94: aload_3
    //   95: checkcast 2	com/blizzard/telemetry/proto/standard/process/Finish
    //   98: astore_3
    //   99: aload_0
    //   100: aload_2
    //   101: aload_0
    //   102: invokevirtual 150	com/blizzard/telemetry/proto/standard/process/Finish:hasPid	()Z
    //   105: aload_0
    //   106: getfield 64	com/blizzard/telemetry/proto/standard/process/Finish:pid_	I
    //   109: aload_3
    //   110: invokevirtual 150	com/blizzard/telemetry/proto/standard/process/Finish:hasPid	()Z
    //   113: aload_3
    //   114: getfield 64	com/blizzard/telemetry/proto/standard/process/Finish:pid_	I
    //   117: invokeinterface 154 5 0
    //   122: putfield 64	com/blizzard/telemetry/proto/standard/process/Finish:pid_	I
    //   125: aload_0
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 157	com/blizzard/telemetry/proto/standard/process/Finish:hasExitCode	()Z
    //   131: aload_0
    //   132: getfield 62	com/blizzard/telemetry/proto/standard/process/Finish:exitCode_	I
    //   135: aload_3
    //   136: invokevirtual 157	com/blizzard/telemetry/proto/standard/process/Finish:hasExitCode	()Z
    //   139: aload_3
    //   140: getfield 62	com/blizzard/telemetry/proto/standard/process/Finish:exitCode_	I
    //   143: invokeinterface 154 5 0
    //   148: putfield 62	com/blizzard/telemetry/proto/standard/process/Finish:exitCode_	I
    //   151: aload_0
    //   152: astore_1
    //   153: aload_2
    //   154: getstatic 163	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   157: if_acmpne -85 -> 72
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 60	com/blizzard/telemetry/proto/standard/process/Finish:bitField0_	I
    //   165: aload_3
    //   166: getfield 60	com/blizzard/telemetry/proto/standard/process/Finish:bitField0_	I
    //   169: ior
    //   170: putfield 60	com/blizzard/telemetry/proto/standard/process/Finish:bitField0_	I
    //   173: aload_0
    //   174: areturn
    //   175: aload_2
    //   176: checkcast 165	com/google/protobuf/CodedInputStream
    //   179: astore_1
    //   180: aload_3
    //   181: checkcast 167	com/google/protobuf/ExtensionRegistryLite
    //   184: astore_2
    //   185: iconst_0
    //   186: istore 4
    //   188: iload 4
    //   190: ifne +145 -> 335
    //   193: aload_1
    //   194: invokevirtual 170	com/google/protobuf/CodedInputStream:readTag	()I
    //   197: istore 5
    //   199: iload 5
    //   201: lookupswitch	default:+179->380, 0:+182->383, 8:+51->252, 16:+89->290
    //   236: aload_0
    //   237: iload 5
    //   239: aload_1
    //   240: invokevirtual 174	com/blizzard/telemetry/proto/standard/process/Finish:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
    //   243: ifne -55 -> 188
    //   246: iconst_1
    //   247: istore 4
    //   249: goto -61 -> 188
    //   252: aload_0
    //   253: aload_0
    //   254: getfield 60	com/blizzard/telemetry/proto/standard/process/Finish:bitField0_	I
    //   257: iconst_1
    //   258: ior
    //   259: putfield 60	com/blizzard/telemetry/proto/standard/process/Finish:bitField0_	I
    //   262: aload_0
    //   263: aload_1
    //   264: invokevirtual 177	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   267: putfield 64	com/blizzard/telemetry/proto/standard/process/Finish:pid_	I
    //   270: goto -82 -> 188
    //   273: astore_1
    //   274: new 179	java/lang/RuntimeException
    //   277: dup
    //   278: aload_1
    //   279: aload_0
    //   280: invokevirtual 183	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   283: invokespecial 186	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   286: athrow
    //   287: astore_1
    //   288: aload_1
    //   289: athrow
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 60	com/blizzard/telemetry/proto/standard/process/Finish:bitField0_	I
    //   295: iconst_2
    //   296: ior
    //   297: putfield 60	com/blizzard/telemetry/proto/standard/process/Finish:bitField0_	I
    //   300: aload_0
    //   301: aload_1
    //   302: invokevirtual 177	com/google/protobuf/CodedInputStream:readUInt32	()I
    //   305: putfield 62	com/blizzard/telemetry/proto/standard/process/Finish:exitCode_	I
    //   308: goto -120 -> 188
    //   311: astore_1
    //   312: new 179	java/lang/RuntimeException
    //   315: dup
    //   316: new 92	com/google/protobuf/InvalidProtocolBufferException
    //   319: dup
    //   320: aload_1
    //   321: invokevirtual 190	java/io/IOException:getMessage	()Ljava/lang/String;
    //   324: invokespecial 193	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   327: aload_0
    //   328: invokevirtual 183	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   331: invokespecial 186	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   334: athrow
    //   335: getstatic 32	com/blizzard/telemetry/proto/standard/process/Finish:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/process/Finish;
    //   338: areturn
    //   339: getstatic 195	com/blizzard/telemetry/proto/standard/process/Finish:PARSER	Lcom/google/protobuf/Parser;
    //   342: ifnonnull +28 -> 370
    //   345: ldc 2
    //   347: monitorenter
    //   348: getstatic 195	com/blizzard/telemetry/proto/standard/process/Finish:PARSER	Lcom/google/protobuf/Parser;
    //   351: ifnonnull +16 -> 367
    //   354: new 197	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   357: dup
    //   358: getstatic 32	com/blizzard/telemetry/proto/standard/process/Finish:DEFAULT_INSTANCE	Lcom/blizzard/telemetry/proto/standard/process/Finish;
    //   361: invokespecial 200	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
    //   364: putstatic 195	com/blizzard/telemetry/proto/standard/process/Finish:PARSER	Lcom/google/protobuf/Parser;
    //   367: ldc 2
    //   369: monitorexit
    //   370: getstatic 195	com/blizzard/telemetry/proto/standard/process/Finish:PARSER	Lcom/google/protobuf/Parser;
    //   373: areturn
    //   374: astore_1
    //   375: ldc 2
    //   377: monitorexit
    //   378: aload_1
    //   379: athrow
    //   380: goto -144 -> 236
    //   383: iconst_1
    //   384: istore 4
    //   386: goto -198 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	Finish
    //   0	389	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
    //   0	389	2	paramObject1	Object
    //   0	389	3	paramObject2	Object
    //   186	199	4	i	int
    //   197	41	5	j	int
    // Exception table:
    //   from	to	target	type
    //   193	199	273	com/google/protobuf/InvalidProtocolBufferException
    //   236	246	273	com/google/protobuf/InvalidProtocolBufferException
    //   252	270	273	com/google/protobuf/InvalidProtocolBufferException
    //   290	308	273	com/google/protobuf/InvalidProtocolBufferException
    //   193	199	287	finally
    //   236	246	287	finally
    //   252	270	287	finally
    //   274	287	287	finally
    //   290	308	287	finally
    //   312	335	287	finally
    //   193	199	311	java/io/IOException
    //   236	246	311	java/io/IOException
    //   252	270	311	java/io/IOException
    //   290	308	311	java/io/IOException
    //   348	367	374	finally
    //   367	370	374	finally
    //   375	378	374	finally
  }
  
  public int getExitCode()
  {
    return this.exitCode_;
  }
  
  public int getPid()
  {
    return this.pid_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      i = 0 + CodedOutputStream.computeUInt32Size(1, this.pid_);
    }
    int j = i;
    if ((this.bitField0_ & 0x2) == 2) {
      j = i + CodedOutputStream.computeUInt32Size(2, this.exitCode_);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasExitCode()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasPid()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeUInt32(1, this.pid_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeUInt32(2, this.exitCode_);
    }
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder
    extends GeneratedMessageLite.Builder<Finish, Builder>
    implements FinishOrBuilder
  {
    private Builder()
    {
      super();
    }
    
    public Builder clearExitCode()
    {
      copyOnWrite();
      ((Finish)this.instance).clearExitCode();
      return this;
    }
    
    public Builder clearPid()
    {
      copyOnWrite();
      ((Finish)this.instance).clearPid();
      return this;
    }
    
    public int getExitCode()
    {
      return ((Finish)this.instance).getExitCode();
    }
    
    public int getPid()
    {
      return ((Finish)this.instance).getPid();
    }
    
    public boolean hasExitCode()
    {
      return ((Finish)this.instance).hasExitCode();
    }
    
    public boolean hasPid()
    {
      return ((Finish)this.instance).hasPid();
    }
    
    public Builder setExitCode(int paramInt)
    {
      copyOnWrite();
      ((Finish)this.instance).setExitCode(paramInt);
      return this;
    }
    
    public Builder setPid(int paramInt)
    {
      copyOnWrite();
      ((Finish)this.instance).setPid(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/process/Finish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */