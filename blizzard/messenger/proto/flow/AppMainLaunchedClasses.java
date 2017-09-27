package com.blizzard.messenger.proto.flow;

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

public final class AppMainLaunchedClasses
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class AppMainLaunched
    extends GeneratedMessageLite<AppMainLaunched, Builder>
    implements AppMainLaunchedClasses.AppMainLaunchedOrBuilder
  {
    private static final AppMainLaunched DEFAULT_INSTANCE = new AppMainLaunched();
    public static final int ELAPSED_TIME_FIELD_NUMBER = 2;
    private static volatile Parser<AppMainLaunched> PARSER;
    public static final int USER_INTERACTED_FIELD_NUMBER = 3;
    private int bitField0_;
    private long elapsedTime_;
    private boolean userInteracted_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearElapsedTime()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.elapsedTime_ = 0L;
    }
    
    private void clearUserInteracted()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.userInteracted_ = false;
    }
    
    public static AppMainLaunched getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AppMainLaunched paramAppMainLaunched)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAppMainLaunched);
    }
    
    public static AppMainLaunched parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (AppMainLaunched)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static AppMainLaunched parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (AppMainLaunched)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static AppMainLaunched parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (AppMainLaunched)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static AppMainLaunched parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (AppMainLaunched)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static AppMainLaunched parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (AppMainLaunched)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static AppMainLaunched parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (AppMainLaunched)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static AppMainLaunched parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (AppMainLaunched)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static AppMainLaunched parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (AppMainLaunched)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static AppMainLaunched parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (AppMainLaunched)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static AppMainLaunched parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (AppMainLaunched)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<AppMainLaunched> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setElapsedTime(long paramLong)
    {
      this.bitField0_ |= 0x1;
      this.elapsedTime_ = paramLong;
    }
    
    private void setUserInteracted(boolean paramBoolean)
    {
      this.bitField0_ |= 0x2;
      this.userInteracted_ = paramBoolean;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 139	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 145	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+327->335, 8:+331->339
      //   56: new 147	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 148	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched
      //   67: dup
      //   68: invokespecial 33	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 35	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 151	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched$Builder:<init>	(Lcom/blizzard/messenger/proto/flow/AppMainLaunchedClasses$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 153	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 157	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:hasElapsedTime	()Z
      //   105: aload_0
      //   106: getfield 67	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:elapsedTime_	J
      //   109: aload_3
      //   110: invokevirtual 157	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:hasElapsedTime	()Z
      //   113: aload_3
      //   114: getfield 67	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:elapsedTime_	J
      //   117: invokeinterface 161 7 0
      //   122: putfield 67	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:elapsedTime_	J
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 164	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:hasUserInteracted	()Z
      //   131: aload_0
      //   132: getfield 69	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:userInteracted_	Z
      //   135: aload_3
      //   136: invokevirtual 164	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:hasUserInteracted	()Z
      //   139: aload_3
      //   140: getfield 69	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:userInteracted_	Z
      //   143: invokeinterface 168 5 0
      //   148: putfield 69	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:userInteracted_	Z
      //   151: aload_0
      //   152: astore_1
      //   153: aload_2
      //   154: getstatic 174	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   157: if_acmpne -85 -> 72
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 65	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:bitField0_	I
      //   165: aload_3
      //   166: getfield 65	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:bitField0_	I
      //   169: ior
      //   170: putfield 65	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:bitField0_	I
      //   173: aload_0
      //   174: areturn
      //   175: aload_2
      //   176: checkcast 176	com/google/protobuf/CodedInputStream
      //   179: astore_1
      //   180: aload_3
      //   181: checkcast 178	com/google/protobuf/ExtensionRegistryLite
      //   184: astore_2
      //   185: iconst_0
      //   186: istore 4
      //   188: iload 4
      //   190: ifne +145 -> 335
      //   193: aload_1
      //   194: invokevirtual 181	com/google/protobuf/CodedInputStream:readTag	()I
      //   197: istore 5
      //   199: iload 5
      //   201: lookupswitch	default:+179->380, 0:+182->383, 16:+51->252, 24:+89->290
      //   236: aload_0
      //   237: iload 5
      //   239: aload_1
      //   240: invokevirtual 185	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -55 -> 188
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -61 -> 188
      //   252: aload_0
      //   253: aload_0
      //   254: getfield 65	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:bitField0_	I
      //   257: iconst_1
      //   258: ior
      //   259: putfield 65	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:bitField0_	I
      //   262: aload_0
      //   263: aload_1
      //   264: invokevirtual 189	com/google/protobuf/CodedInputStream:readInt64	()J
      //   267: putfield 67	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:elapsedTime_	J
      //   270: goto -82 -> 188
      //   273: astore_1
      //   274: new 191	java/lang/RuntimeException
      //   277: dup
      //   278: aload_1
      //   279: aload_0
      //   280: invokevirtual 195	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   283: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   286: athrow
      //   287: astore_1
      //   288: aload_1
      //   289: athrow
      //   290: aload_0
      //   291: aload_0
      //   292: getfield 65	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:bitField0_	I
      //   295: iconst_2
      //   296: ior
      //   297: putfield 65	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:bitField0_	I
      //   300: aload_0
      //   301: aload_1
      //   302: invokevirtual 201	com/google/protobuf/CodedInputStream:readBool	()Z
      //   305: putfield 69	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:userInteracted_	Z
      //   308: goto -120 -> 188
      //   311: astore_1
      //   312: new 191	java/lang/RuntimeException
      //   315: dup
      //   316: new 97	com/google/protobuf/InvalidProtocolBufferException
      //   319: dup
      //   320: aload_1
      //   321: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
      //   324: invokespecial 208	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   327: aload_0
      //   328: invokevirtual 195	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   331: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   334: athrow
      //   335: getstatic 35	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched;
      //   338: areturn
      //   339: getstatic 210	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:PARSER	Lcom/google/protobuf/Parser;
      //   342: ifnonnull +28 -> 370
      //   345: ldc 2
      //   347: monitorenter
      //   348: getstatic 210	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:PARSER	Lcom/google/protobuf/Parser;
      //   351: ifnonnull +16 -> 367
      //   354: new 212	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   357: dup
      //   358: getstatic 35	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched;
      //   361: invokespecial 215	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   364: putstatic 210	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:PARSER	Lcom/google/protobuf/Parser;
      //   367: ldc 2
      //   369: monitorexit
      //   370: getstatic 210	com/blizzard/messenger/proto/flow/AppMainLaunchedClasses$AppMainLaunched:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	389	0	this	AppMainLaunched
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
    
    public long getElapsedTime()
    {
      return this.elapsedTime_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeInt64Size(2, this.elapsedTime_);
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeBoolSize(3, this.userInteracted_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean getUserInteracted()
    {
      return this.userInteracted_;
    }
    
    public boolean hasElapsedTime()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasUserInteracted()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeInt64(2, this.elapsedTime_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeBool(3, this.userInteracted_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<AppMainLaunchedClasses.AppMainLaunched, Builder>
      implements AppMainLaunchedClasses.AppMainLaunchedOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearElapsedTime()
      {
        copyOnWrite();
        ((AppMainLaunchedClasses.AppMainLaunched)this.instance).clearElapsedTime();
        return this;
      }
      
      public Builder clearUserInteracted()
      {
        copyOnWrite();
        ((AppMainLaunchedClasses.AppMainLaunched)this.instance).clearUserInteracted();
        return this;
      }
      
      public long getElapsedTime()
      {
        return ((AppMainLaunchedClasses.AppMainLaunched)this.instance).getElapsedTime();
      }
      
      public boolean getUserInteracted()
      {
        return ((AppMainLaunchedClasses.AppMainLaunched)this.instance).getUserInteracted();
      }
      
      public boolean hasElapsedTime()
      {
        return ((AppMainLaunchedClasses.AppMainLaunched)this.instance).hasElapsedTime();
      }
      
      public boolean hasUserInteracted()
      {
        return ((AppMainLaunchedClasses.AppMainLaunched)this.instance).hasUserInteracted();
      }
      
      public Builder setElapsedTime(long paramLong)
      {
        copyOnWrite();
        ((AppMainLaunchedClasses.AppMainLaunched)this.instance).setElapsedTime(paramLong);
        return this;
      }
      
      public Builder setUserInteracted(boolean paramBoolean)
      {
        copyOnWrite();
        ((AppMainLaunchedClasses.AppMainLaunched)this.instance).setUserInteracted(paramBoolean);
        return this;
      }
    }
  }
  
  public static abstract interface AppMainLaunchedOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract long getElapsedTime();
    
    public abstract boolean getUserInteracted();
    
    public abstract boolean hasElapsedTime();
    
    public abstract boolean hasUserInteracted();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/proto/flow/AppMainLaunchedClasses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */