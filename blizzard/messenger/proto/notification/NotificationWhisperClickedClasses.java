package com.blizzard.messenger.proto.notification;

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

public final class NotificationWhisperClickedClasses
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class NotificationWhisperClicked
    extends GeneratedMessageLite<NotificationWhisperClicked, Builder>
    implements NotificationWhisperClickedClasses.NotificationWhisperClickedOrBuilder
  {
    private static final NotificationWhisperClicked DEFAULT_INSTANCE = new NotificationWhisperClicked();
    public static final int FRIEND_ID_FIELD_NUMBER = 1;
    public static final int IS_IN_APP_FIELD_NUMBER = 2;
    private static volatile Parser<NotificationWhisperClicked> PARSER;
    private int bitField0_;
    private String friendId_ = "";
    private boolean isInApp_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearFriendId()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.friendId_ = getDefaultInstance().getFriendId();
    }
    
    private void clearIsInApp()
    {
      this.bitField0_ &= 0xFFFFFFFD;
      this.isInApp_ = false;
    }
    
    public static NotificationWhisperClicked getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(NotificationWhisperClicked paramNotificationWhisperClicked)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramNotificationWhisperClicked);
    }
    
    public static NotificationWhisperClicked parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (NotificationWhisperClicked)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static NotificationWhisperClicked parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (NotificationWhisperClicked)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static NotificationWhisperClicked parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (NotificationWhisperClicked)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static NotificationWhisperClicked parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (NotificationWhisperClicked)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static NotificationWhisperClicked parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (NotificationWhisperClicked)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static NotificationWhisperClicked parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (NotificationWhisperClicked)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static NotificationWhisperClicked parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (NotificationWhisperClicked)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static NotificationWhisperClicked parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (NotificationWhisperClicked)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static NotificationWhisperClicked parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (NotificationWhisperClicked)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static NotificationWhisperClicked parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (NotificationWhisperClicked)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<NotificationWhisperClicked> parser()
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
    
    private void setIsInApp(boolean paramBoolean)
    {
      this.bitField0_ |= 0x2;
      this.isInApp_ = paramBoolean;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 161	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 167	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+167->175, 7:+329->337, 8:+333->341
      //   56: new 169	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 170	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked
      //   67: dup
      //   68: invokespecial 33	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 35	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 173	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked$Builder:<init>	(Lcom/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 175	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 179	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:hasFriendId	()Z
      //   105: aload_0
      //   106: getfield 44	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:friendId_	Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 179	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:hasFriendId	()Z
      //   113: aload_3
      //   114: getfield 44	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:friendId_	Ljava/lang/String;
      //   117: invokeinterface 183 5 0
      //   122: putfield 44	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:friendId_	Ljava/lang/String;
      //   125: aload_0
      //   126: aload_2
      //   127: aload_0
      //   128: invokevirtual 186	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:hasIsInApp	()Z
      //   131: aload_0
      //   132: getfield 84	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:isInApp_	Z
      //   135: aload_3
      //   136: invokevirtual 186	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:hasIsInApp	()Z
      //   139: aload_3
      //   140: getfield 84	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:isInApp_	Z
      //   143: invokeinterface 190 5 0
      //   148: putfield 84	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:isInApp_	Z
      //   151: aload_0
      //   152: astore_1
      //   153: aload_2
      //   154: getstatic 196	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   157: if_acmpne -85 -> 72
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 75	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:bitField0_	I
      //   165: aload_3
      //   166: getfield 75	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:bitField0_	I
      //   169: ior
      //   170: putfield 75	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:bitField0_	I
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
      //   190: ifne +147 -> 337
      //   193: aload_1
      //   194: invokevirtual 203	com/google/protobuf/CodedInputStream:readTag	()I
      //   197: istore 5
      //   199: iload 5
      //   201: lookupswitch	default:+181->382, 0:+184->385, 10:+51->252, 16:+91->292
      //   236: aload_0
      //   237: iload 5
      //   239: aload_1
      //   240: invokevirtual 207	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   243: ifne -55 -> 188
      //   246: iconst_1
      //   247: istore 4
      //   249: goto -61 -> 188
      //   252: aload_1
      //   253: invokevirtual 210	com/google/protobuf/CodedInputStream:readString	()Ljava/lang/String;
      //   256: astore_2
      //   257: aload_0
      //   258: aload_0
      //   259: getfield 75	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:bitField0_	I
      //   262: iconst_1
      //   263: ior
      //   264: putfield 75	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:bitField0_	I
      //   267: aload_0
      //   268: aload_2
      //   269: putfield 44	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:friendId_	Ljava/lang/String;
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
      //   292: aload_0
      //   293: aload_0
      //   294: getfield 75	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:bitField0_	I
      //   297: iconst_2
      //   298: ior
      //   299: putfield 75	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:bitField0_	I
      //   302: aload_0
      //   303: aload_1
      //   304: invokevirtual 222	com/google/protobuf/CodedInputStream:readBool	()Z
      //   307: putfield 84	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:isInApp_	Z
      //   310: goto -122 -> 188
      //   313: astore_1
      //   314: new 212	java/lang/RuntimeException
      //   317: dup
      //   318: new 111	com/google/protobuf/InvalidProtocolBufferException
      //   321: dup
      //   322: aload_1
      //   323: invokevirtual 225	java/io/IOException:getMessage	()Ljava/lang/String;
      //   326: invokespecial 227	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   329: aload_0
      //   330: invokevirtual 216	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   333: invokespecial 219	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   336: athrow
      //   337: getstatic 35	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked;
      //   340: areturn
      //   341: getstatic 229	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:PARSER	Lcom/google/protobuf/Parser;
      //   344: ifnonnull +28 -> 372
      //   347: ldc 2
      //   349: monitorenter
      //   350: getstatic 229	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:PARSER	Lcom/google/protobuf/Parser;
      //   353: ifnonnull +16 -> 369
      //   356: new 231	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   359: dup
      //   360: getstatic 35	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked;
      //   363: invokespecial 234	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   366: putstatic 229	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:PARSER	Lcom/google/protobuf/Parser;
      //   369: ldc 2
      //   371: monitorexit
      //   372: getstatic 229	com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses$NotificationWhisperClicked:PARSER	Lcom/google/protobuf/Parser;
      //   375: areturn
      //   376: astore_1
      //   377: ldc 2
      //   379: monitorexit
      //   380: aload_1
      //   381: athrow
      //   382: goto -146 -> 236
      //   385: iconst_1
      //   386: istore 4
      //   388: goto -200 -> 188
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	391	0	this	NotificationWhisperClicked
      //   0	391	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	391	2	paramObject1	Object
      //   0	391	3	paramObject2	Object
      //   186	201	4	i	int
      //   197	41	5	j	int
      // Exception table:
      //   from	to	target	type
      //   193	199	275	com/google/protobuf/InvalidProtocolBufferException
      //   236	246	275	com/google/protobuf/InvalidProtocolBufferException
      //   252	272	275	com/google/protobuf/InvalidProtocolBufferException
      //   292	310	275	com/google/protobuf/InvalidProtocolBufferException
      //   193	199	289	finally
      //   236	246	289	finally
      //   252	272	289	finally
      //   276	289	289	finally
      //   292	310	289	finally
      //   314	337	289	finally
      //   193	199	313	java/io/IOException
      //   236	246	313	java/io/IOException
      //   252	272	313	java/io/IOException
      //   292	310	313	java/io/IOException
      //   350	369	376	finally
      //   369	372	376	finally
      //   377	380	376	finally
    }
    
    public String getFriendId()
    {
      return this.friendId_;
    }
    
    public ByteString getFriendIdBytes()
    {
      return ByteString.copyFromUtf8(this.friendId_);
    }
    
    public boolean getIsInApp()
    {
      return this.isInApp_;
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
        j = i + CodedOutputStream.computeBoolSize(2, this.isInApp_);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasFriendId()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public boolean hasIsInApp()
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
        paramCodedOutputStream.writeBool(2, this.isInApp_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<NotificationWhisperClickedClasses.NotificationWhisperClicked, Builder>
      implements NotificationWhisperClickedClasses.NotificationWhisperClickedOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearFriendId()
      {
        copyOnWrite();
        ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).clearFriendId();
        return this;
      }
      
      public Builder clearIsInApp()
      {
        copyOnWrite();
        ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).clearIsInApp();
        return this;
      }
      
      public String getFriendId()
      {
        return ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).getFriendId();
      }
      
      public ByteString getFriendIdBytes()
      {
        return ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).getFriendIdBytes();
      }
      
      public boolean getIsInApp()
      {
        return ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).getIsInApp();
      }
      
      public boolean hasFriendId()
      {
        return ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).hasFriendId();
      }
      
      public boolean hasIsInApp()
      {
        return ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).hasIsInApp();
      }
      
      public Builder setFriendId(String paramString)
      {
        copyOnWrite();
        ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).setFriendId(paramString);
        return this;
      }
      
      public Builder setFriendIdBytes(ByteString paramByteString)
      {
        copyOnWrite();
        ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).setFriendIdBytes(paramByteString);
        return this;
      }
      
      public Builder setIsInApp(boolean paramBoolean)
      {
        copyOnWrite();
        ((NotificationWhisperClickedClasses.NotificationWhisperClicked)this.instance).setIsInApp(paramBoolean);
        return this;
      }
    }
  }
  
  public static abstract interface NotificationWhisperClickedOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract String getFriendId();
    
    public abstract ByteString getFriendIdBytes();
    
    public abstract boolean getIsInApp();
    
    public abstract boolean hasFriendId();
    
    public abstract boolean hasIsInApp();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/proto/notification/NotificationWhisperClickedClasses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */