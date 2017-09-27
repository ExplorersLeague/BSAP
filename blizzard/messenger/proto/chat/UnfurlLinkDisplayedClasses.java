package com.blizzard.messenger.proto.chat;

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

public final class UnfurlLinkDisplayedClasses
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class UnfurlLinkDisplayed
    extends GeneratedMessageLite<UnfurlLinkDisplayed, Builder>
    implements UnfurlLinkDisplayedClasses.UnfurlLinkDisplayedOrBuilder
  {
    private static final UnfurlLinkDisplayed DEFAULT_INSTANCE = new UnfurlLinkDisplayed();
    private static volatile Parser<UnfurlLinkDisplayed> PARSER;
    public static final int URL_FIELD_NUMBER = 1;
    private int bitField0_;
    private String url_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearUrl()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.url_ = getDefaultInstance().getUrl();
    }
    
    public static UnfurlLinkDisplayed getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(UnfurlLinkDisplayed paramUnfurlLinkDisplayed)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramUnfurlLinkDisplayed);
    }
    
    public static UnfurlLinkDisplayed parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (UnfurlLinkDisplayed)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static UnfurlLinkDisplayed parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (UnfurlLinkDisplayed)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static UnfurlLinkDisplayed parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (UnfurlLinkDisplayed)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static UnfurlLinkDisplayed parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (UnfurlLinkDisplayed)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static UnfurlLinkDisplayed parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (UnfurlLinkDisplayed)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static UnfurlLinkDisplayed parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (UnfurlLinkDisplayed)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static UnfurlLinkDisplayed parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (UnfurlLinkDisplayed)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static UnfurlLinkDisplayed parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (UnfurlLinkDisplayed)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static UnfurlLinkDisplayed parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (UnfurlLinkDisplayed)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static UnfurlLinkDisplayed parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (UnfurlLinkDisplayed)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<UnfurlLinkDisplayed> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setUrl(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.url_ = paramString;
    }
    
    private void setUrlBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.url_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 145	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 151	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+141->149, 7:+272->280, 8:+276->284
      //   56: new 153	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 154	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed
      //   67: dup
      //   68: invokespecial 29	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 157	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed$Builder:<init>	(Lcom/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 159	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 163	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:hasUrl	()Z
      //   105: aload_0
      //   106: getfield 40	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:url_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 163	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:hasUrl	()Z
      //   113: aload_3
      //   114: getfield 40	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:url_	Ljava/lang/String;
      //   117: invokeinterface 167 5 0
      //   122: putfield 40	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:url_	Ljava/lang/String;
      //   125: aload_0
      //   126: astore_1
      //   127: aload_2
      //   128: getstatic 173	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   131: if_acmpne -59 -> 72
      //   134: aload_0
      //   135: aload_0
      //   136: getfield 61	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:bitField0_	I
      //   139: aload_3
      //   140: getfield 61	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:bitField0_	I
      //   143: ior
      //   144: putfield 61	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:bitField0_	I
      //   147: aload_0
      //   148: areturn
      //   149: aload_2
      //   150: checkcast 175	com/google/protobuf/CodedInputStream
      //   153: astore_1
      //   154: aload_3
      //   155: checkcast 177	com/google/protobuf/ExtensionRegistryLite
      //   158: astore_2
      //   159: iconst_0
      //   160: istore 4
      //   162: iload 4
      //   164: ifne +116 -> 280
      //   167: aload_1
      //   168: invokevirtual 180	com/google/protobuf/CodedInputStream:readTag	()I
      //   171: istore 5
      //   173: iload 5
      //   175: lookupswitch	default:+150->325, 0:+153->328, 10:+41->216
      //   200: aload_0
      //   201: iload 5
      //   203: aload_1
      //   204: invokevirtual 184	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   207: ifne -45 -> 162
      //   210: iconst_1
      //   211: istore 4
      //   213: goto -51 -> 162
      //   216: aload_1
      //   217: invokevirtual 187	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   220: astore_2
      //   221: aload_0
      //   222: aload_0
      //   223: getfield 61	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:bitField0_	I
      //   226: iconst_1
      //   227: ior
      //   228: putfield 61	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:bitField0_	I
      //   231: aload_0
      //   232: aload_2
      //   233: putfield 40	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:url_	Ljava/lang/String;
      //   236: goto -74 -> 162
      //   239: astore_1
      //   240: new 189	java/lang/RuntimeException
      //   243: dup
      //   244: aload_1
      //   245: aload_0
      //   246: invokevirtual 193	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   249: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   252: athrow
      //   253: astore_1
      //   254: aload_1
      //   255: athrow
      //   256: astore_1
      //   257: new 189	java/lang/RuntimeException
      //   260: dup
      //   261: new 95	com/google/protobuf/InvalidProtocolBufferException
      //   264: dup
      //   265: aload_1
      //   266: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
      //   269: invokespecial 201	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   272: aload_0
      //   273: invokevirtual 193	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   276: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   279: athrow
      //   280: getstatic 31	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed;
      //   283: areturn
      //   284: getstatic 203	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:PARSER	Lcom/google/protobuf/Parser;
      //   287: ifnonnull +28 -> 315
      //   290: ldc 2
      //   292: monitorenter
      //   293: getstatic 203	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:PARSER	Lcom/google/protobuf/Parser;
      //   296: ifnonnull +16 -> 312
      //   299: new 205	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   302: dup
      //   303: getstatic 31	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed;
      //   306: invokespecial 208	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   309: putstatic 203	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:PARSER	Lcom/google/protobuf/Parser;
      //   312: ldc 2
      //   314: monitorexit
      //   315: getstatic 203	com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses$UnfurlLinkDisplayed:PARSER	Lcom/google/protobuf/Parser;
      //   318: areturn
      //   319: astore_1
      //   320: ldc 2
      //   322: monitorexit
      //   323: aload_1
      //   324: athrow
      //   325: goto -125 -> 200
      //   328: iconst_1
      //   329: istore 4
      //   331: goto -169 -> 162
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	334	0	this	UnfurlLinkDisplayed
      //   0	334	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	334	2	paramObject1	Object
      //   0	334	3	paramObject2	Object
      //   160	170	4	i	int
      //   171	31	5	j	int
      // Exception table:
      //   from	to	target	type
      //   167	173	239	com/google/protobuf/InvalidProtocolBufferException
      //   200	210	239	com/google/protobuf/InvalidProtocolBufferException
      //   216	236	239	com/google/protobuf/InvalidProtocolBufferException
      //   167	173	253	finally
      //   200	210	253	finally
      //   216	236	253	finally
      //   240	253	253	finally
      //   257	280	253	finally
      //   167	173	256	java/io/IOException
      //   200	210	256	java/io/IOException
      //   216	236	256	java/io/IOException
      //   293	312	319	finally
      //   312	315	319	finally
      //   320	323	319	finally
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeStringSize(1, getUrl());
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getUrl()
    {
      return this.url_;
    }
    
    public ByteString getUrlBytes()
    {
      return ByteString.copyFromUtf8(this.url_);
    }
    
    public boolean hasUrl()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getUrl());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed, Builder>
      implements UnfurlLinkDisplayedClasses.UnfurlLinkDisplayedOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearUrl()
      {
        copyOnWrite();
        ((UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed)this.instance).clearUrl();
        return this;
      }
      
      public String getUrl()
      {
        return ((UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed)this.instance).getUrl();
      }
      
      public ByteString getUrlBytes()
      {
        return ((UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed)this.instance).getUrlBytes();
      }
      
      public boolean hasUrl()
      {
        return ((UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed)this.instance).hasUrl();
      }
      
      public Builder setUrl(String paramString)
      {
        copyOnWrite();
        ((UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed)this.instance).setUrl(paramString);
        return this;
      }
      
      public Builder setUrlBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((UnfurlLinkDisplayedClasses.UnfurlLinkDisplayed)this.instance).setUrlBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface UnfurlLinkDisplayedOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getUrl();
    
    public abstract ByteString getUrlBytes();
    
    public abstract boolean hasUrl();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/proto/chat/UnfurlLinkDisplayedClasses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */