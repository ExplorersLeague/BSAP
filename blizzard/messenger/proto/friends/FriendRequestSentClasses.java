package com.blizzard.messenger.proto.friends;

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

public final class FriendRequestSentClasses
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class FriendRequestSent
    extends GeneratedMessageLite<FriendRequestSent, Builder>
    implements FriendRequestSentClasses.FriendRequestSentOrBuilder
  {
    private static final FriendRequestSent DEFAULT_INSTANCE = new FriendRequestSent();
    public static final int FRIEND_ID_FIELD_NUMBER = 1;
    private static volatile Parser<FriendRequestSent> PARSER;
    public static final int REQUEST_LEVEL_FIELD_NUMBER = 2;
    private int bitField0_;
    private String friendId_ = "";
    private String requestLevel_ = "";
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearFriendId()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.friendId_ = getDefaultInstance().getFriendId();
    }
    
    private void clearRequestLevel()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.requestLevel_ = getDefaultInstance().getRequestLevel();
    }
    
    public static FriendRequestSent getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FriendRequestSent paramFriendRequestSent)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFriendRequestSent);
    }
    
    public static FriendRequestSent parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (FriendRequestSent)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static FriendRequestSent parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (FriendRequestSent)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static FriendRequestSent parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (FriendRequestSent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static FriendRequestSent parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (FriendRequestSent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static FriendRequestSent parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (FriendRequestSent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static FriendRequestSent parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (FriendRequestSent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static FriendRequestSent parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (FriendRequestSent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static FriendRequestSent parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (FriendRequestSent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static FriendRequestSent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (FriendRequestSent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static FriendRequestSent parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (FriendRequestSent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<FriendRequestSent> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setFriendId(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.friendId_ = paramString;
    }
    
    private void setFriendIdBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x1;
      this.friendId_ = paramByteString.toStringUtf8();
    }
    
    private void setRequestLevel(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.requestLevel_ = paramString;
    }
    
    private void setRequestLevelBytes(ByteString paramByteString)
    {
      if (paramByteString == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.requestLevel_ = paramByteString.toStringUtf8();
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 165	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 171	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+331->339, 8:+335->343
      //   56: new 173	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 174	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent
      //   67: dup
      //   68: invokespecial 32	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 34	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 177	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent$Builder:<init>	(Lcom/blizzard/messenger/proto/friends/FriendRequestSentClasses$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 179	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 183	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:hasFriendId	()Z
      //   105: aload_0
      //   106: getfield 43	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:friendId_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 183	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:hasFriendId	()Z
      //   113: aload_3
      //   114: getfield 43	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:friendId_	Ljava/lang/String;
      //   117: invokeinterface 187 5 0
      //   122: putfield 43	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:friendId_	Ljava/lang/String;
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 190	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:hasRequestLevel	()Z
      //   131: aload_0
      //   132: getfield 45	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:requestLevel_	Ljava/lang/String;
      //   135: aload_3
      //   136: invokevirtual 190	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:hasRequestLevel	()Z
      //   139: aload_3
      //   140: getfield 45	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:requestLevel_	Ljava/lang/String;
      //   143: invokeinterface 187 5 0
      //   148: putfield 45	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:requestLevel_	Ljava/lang/String;
      //   151: aload_0
      //   152: astore_1
      //   153: aload_2
      //   154: getstatic 196	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   157: if_acmpne -85 -> 72
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 78	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:bitField0_	I
      //   165: aload_3
      //   166: getfield 78	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:bitField0_	I
      //   169: ior
      //   170: putfield 78	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:bitField0_	I
      //   173: aload_0
      //   174: areturn
      //   175: aload_2
      //   176: checkcast 198	com/google/protobuf/CodedInputStream
      //   179: astore_1
      //   180: aload_3
      //   181: checkcast 200	com/google/protobuf/ExtensionRegistryLite
      //   184: astore_2
      //   185: iconst_0
      //   186: istore 4
      //   188: iload 4
      //   190: ifne +149 -> 339
      //   193: aload_1
      //   194: invokevirtual 203	com/google/protobuf/CodedInputStream:readTag	()I
      //   197: istore 5
      //   199: iload 5
      //   201: lookupswitch	default:+183->384, 0:+186->387, 10:+51->252, 18:+91->292
      //   236: aload_0
      //   237: iload 5
      //   239: aload_1
      //   240: invokevirtual 207	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -55 -> 188
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -61 -> 188
      //   252: aload_1
      //   253: invokevirtual 210	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   256: astore_2
      //   257: aload_0
      //   258: aload_0
      //   259: getfield 78	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:bitField0_	I
      //   262: iconst_1
      //   263: ior
      //   264: putfield 78	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:bitField0_	I
      //   267: aload_0
      //   268: aload_2
      //   269: putfield 43	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:friendId_	Ljava/lang/String;
      //   272: goto -84 -> 188
      //   275: astore_1
      //   276: new 212	java/lang/RuntimeException
      //   279: dup
      //   280: aload_1
      //   281: aload_0
      //   282: invokevirtual 216	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   285: invokespecial 219	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   288: athrow
      //   289: astore_1
      //   290: aload_1
      //   291: athrow
      //   292: aload_1
      //   293: invokevirtual 210	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   296: astore_2
      //   297: aload_0
      //   298: aload_0
      //   299: getfield 78	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:bitField0_	I
      //   302: iconst_2
      //   303: ior
      //   304: putfield 78	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:bitField0_	I
      //   307: aload_0
      //   308: aload_2
      //   309: putfield 45	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:requestLevel_	Ljava/lang/String;
      //   312: goto -124 -> 188
      //   315: astore_1
      //   316: new 212	java/lang/RuntimeException
      //   319: dup
      //   320: new 115	com/google/protobuf/InvalidProtocolBufferException
      //   323: dup
      //   324: aload_1
      //   325: invokevirtual 222	java/io/IOException:getMessage	()Ljava/lang/String;
      //   328: invokespecial 224	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   331: aload_0
      //   332: invokevirtual 216	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   335: invokespecial 219	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   338: athrow
      //   339: getstatic 34	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent;
      //   342: areturn
      //   343: getstatic 226	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:PARSER	Lcom/google/protobuf/Parser;
      //   346: ifnonnull +28 -> 374
      //   349: ldc 2
      //   351: monitorenter
      //   352: getstatic 226	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:PARSER	Lcom/google/protobuf/Parser;
      //   355: ifnonnull +16 -> 371
      //   358: new 228	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   361: dup
      //   362: getstatic 34	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent;
      //   365: invokespecial 231	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   368: putstatic 226	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:PARSER	Lcom/google/protobuf/Parser;
      //   371: ldc 2
      //   373: monitorexit
      //   374: getstatic 226	com/blizzard/messenger/proto/friends/FriendRequestSentClasses$FriendRequestSent:PARSER	Lcom/google/protobuf/Parser;
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
      //   0	393	0	this	FriendRequestSent
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
    
    public String getFriendId()
    {
      return this.friendId_;
    }
    
    public ByteString getFriendIdBytes()
    {
      return ByteString.copyFromUtf8(this.friendId_);
    }
    
    public String getRequestLevel()
    {
      return this.requestLevel_;
    }
    
    public ByteString getRequestLevelBytes()
    {
      return ByteString.copyFromUtf8(this.requestLevel_);
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeStringSize(1, getFriendId());
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeStringSize(2, getRequestLevel());
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasFriendId()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasRequestLevel()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeString(1, getFriendId());
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeString(2, getRequestLevel());
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<FriendRequestSentClasses.FriendRequestSent, Builder>
      implements FriendRequestSentClasses.FriendRequestSentOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearFriendId()
      {
        copyOnWrite();
        ((FriendRequestSentClasses.FriendRequestSent)this.instance).clearFriendId();
        return this;
      }
      
      public Builder clearRequestLevel()
      {
        copyOnWrite();
        ((FriendRequestSentClasses.FriendRequestSent)this.instance).clearRequestLevel();
        return this;
      }
      
      public String getFriendId()
      {
        return ((FriendRequestSentClasses.FriendRequestSent)this.instance).getFriendId();
      }
      
      public ByteString getFriendIdBytes()
      {
        return ((FriendRequestSentClasses.FriendRequestSent)this.instance).getFriendIdBytes();
      }
      
      public String getRequestLevel()
      {
        return ((FriendRequestSentClasses.FriendRequestSent)this.instance).getRequestLevel();
      }
      
      public ByteString getRequestLevelBytes()
      {
        return ((FriendRequestSentClasses.FriendRequestSent)this.instance).getRequestLevelBytes();
      }
      
      public boolean hasFriendId()
      {
        return ((FriendRequestSentClasses.FriendRequestSent)this.instance).hasFriendId();
      }
      
      public boolean hasRequestLevel()
      {
        return ((FriendRequestSentClasses.FriendRequestSent)this.instance).hasRequestLevel();
      }
      
      public Builder setFriendId(String paramString)
      {
        copyOnWrite();
        ((FriendRequestSentClasses.FriendRequestSent)this.instance).setFriendId(paramString);
        return this;
      }
      
      public Builder setFriendIdBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((FriendRequestSentClasses.FriendRequestSent)this.instance).setFriendIdBytes(paramByteString);
        return this;
      }
      
      public Builder setRequestLevel(String paramString)
      {
        copyOnWrite();
        ((FriendRequestSentClasses.FriendRequestSent)this.instance).setRequestLevel(paramString);
        return this;
      }
      
      public Builder setRequestLevelBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((FriendRequestSentClasses.FriendRequestSent)this.instance).setRequestLevelBytes(paramByteString);
        return this;
      }
    }
  }
  
  public static abstract interface FriendRequestSentOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getFriendId();
    
    public abstract ByteString getFriendIdBytes();
    
    public abstract String getRequestLevel();
    
    public abstract ByteString getRequestLevelBytes();
    
    public abstract boolean hasFriendId();
    
    public abstract boolean hasRequestLevel();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/proto/friends/FriendRequestSentClasses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */