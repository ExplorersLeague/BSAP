package com.blizzard.messenger.proto.settings;

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

public final class SettingsFriendsListSortByActivityUpdatedClasses
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class SettingsFriendsListSortByActivityUpdated
    extends GeneratedMessageLite<SettingsFriendsListSortByActivityUpdated, Builder>
    implements SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdatedOrBuilder
  {
    private static final SettingsFriendsListSortByActivityUpdated DEFAULT_INSTANCE = new SettingsFriendsListSortByActivityUpdated();
    private static volatile Parser<SettingsFriendsListSortByActivityUpdated> PARSER;
    public static final int SORT_ENABLED_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean sortEnabled_;
    
    static
    {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearSortEnabled()
    {
      this.bitField0_ &= 0xFFFFFFFE;
      this.sortEnabled_ = false;
    }
    
    public static SettingsFriendsListSortByActivityUpdated getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder()
    {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(SettingsFriendsListSortByActivityUpdated paramSettingsFriendsListSortByActivityUpdated)
    {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramSettingsFriendsListSortByActivityUpdated);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (SettingsFriendsListSortByActivityUpdated)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (SettingsFriendsListSortByActivityUpdated)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (SettingsFriendsListSortByActivityUpdated)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (SettingsFriendsListSortByActivityUpdated)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (SettingsFriendsListSortByActivityUpdated)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (SettingsFriendsListSortByActivityUpdated)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (SettingsFriendsListSortByActivityUpdated)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (SettingsFriendsListSortByActivityUpdated)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (SettingsFriendsListSortByActivityUpdated)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte);
    }
    
    public static SettingsFriendsListSortByActivityUpdated parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (SettingsFriendsListSortByActivityUpdated)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfByte, paramExtensionRegistryLite);
    }
    
    public static Parser<SettingsFriendsListSortByActivityUpdated> parser()
    {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setSortEnabled(boolean paramBoolean)
    {
      this.bitField0_ |= 0x1;
      this.sortEnabled_ = paramBoolean;
    }
    
    /* Error */
    protected final Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 123	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$1:$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke	[I
      //   3: aload_1
      //   4: invokevirtual 129	com/google/protobuf/GeneratedMessageLite$MethodToInvoke:ordinal	()I
      //   7: iaload
      //   8: tableswitch	default:+48->56, 1:+56->64, 2:+66->74, 3:+70->78, 4:+72->80, 5:+81->89, 6:+141->149, 7:+270->278, 8:+274->282
      //   56: new 131	java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial 132	java/lang/UnsupportedOperationException:<init>	()V
      //   63: athrow
      //   64: new 2	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated
      //   67: dup
      //   68: invokespecial 29	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:<init>	()V
      //   71: astore_1
      //   72: aload_1
      //   73: areturn
      //   74: getstatic 31	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated;
      //   77: areturn
      //   78: aconst_null
      //   79: areturn
      //   80: new 12	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated$Builder
      //   83: dup
      //   84: aconst_null
      //   85: invokespecial 135	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated$Builder:<init>	(Lcom/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$1;)V
      //   88: areturn
      //   89: aload_2
      //   90: checkcast 137	com/google/protobuf/GeneratedMessageLite$Visitor
      //   93: astore_2
      //   94: aload_3
      //   95: checkcast 2	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated
      //   98: astore_3
      //   99: aload_0
      //   100: aload_2
      //   101: aload_0
      //   102: invokevirtual 141	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:hasSortEnabled	()Z
      //   105: aload_0
      //   106: getfield 53	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:sortEnabled_	Z
      //   109: aload_3
      //   110: invokevirtual 141	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:hasSortEnabled	()Z
      //   113: aload_3
      //   114: getfield 53	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:sortEnabled_	Z
      //   117: invokeinterface 145 5 0
      //   122: putfield 53	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:sortEnabled_	Z
      //   125: aload_0
      //   126: astore_1
      //   127: aload_2
      //   128: getstatic 151	com/google/protobuf/GeneratedMessageLite$MergeFromVisitor:INSTANCE	Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   131: if_acmpne -59 -> 72
      //   134: aload_0
      //   135: aload_0
      //   136: getfield 51	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:bitField0_	I
      //   139: aload_3
      //   140: getfield 51	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:bitField0_	I
      //   143: ior
      //   144: putfield 51	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:bitField0_	I
      //   147: aload_0
      //   148: areturn
      //   149: aload_2
      //   150: checkcast 153	com/google/protobuf/CodedInputStream
      //   153: astore_1
      //   154: aload_3
      //   155: checkcast 155	com/google/protobuf/ExtensionRegistryLite
      //   158: astore_2
      //   159: iconst_0
      //   160: istore 4
      //   162: iload 4
      //   164: ifne +114 -> 278
      //   167: aload_1
      //   168: invokevirtual 158	com/google/protobuf/CodedInputStream:readTag	()I
      //   171: istore 5
      //   173: iload 5
      //   175: lookupswitch	default:+148->323, 0:+151->326, 8:+41->216
      //   200: aload_0
      //   201: iload 5
      //   203: aload_1
      //   204: invokevirtual 162	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:parseUnknownField	(ILcom/google/protobuf/CodedInputStream;)Z
      //   207: ifne -45 -> 162
      //   210: iconst_1
      //   211: istore 4
      //   213: goto -51 -> 162
      //   216: aload_0
      //   217: aload_0
      //   218: getfield 51	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:bitField0_	I
      //   221: iconst_1
      //   222: ior
      //   223: putfield 51	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:bitField0_	I
      //   226: aload_0
      //   227: aload_1
      //   228: invokevirtual 165	com/google/protobuf/CodedInputStream:readBool	()Z
      //   231: putfield 53	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:sortEnabled_	Z
      //   234: goto -72 -> 162
      //   237: astore_1
      //   238: new 167	java/lang/RuntimeException
      //   241: dup
      //   242: aload_1
      //   243: aload_0
      //   244: invokevirtual 171	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   247: invokespecial 174	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   250: athrow
      //   251: astore_1
      //   252: aload_1
      //   253: athrow
      //   254: astore_1
      //   255: new 167	java/lang/RuntimeException
      //   258: dup
      //   259: new 81	com/google/protobuf/InvalidProtocolBufferException
      //   262: dup
      //   263: aload_1
      //   264: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
      //   267: invokespecial 181	com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   270: aload_0
      //   271: invokevirtual 171	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   274: invokespecial 174	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   277: athrow
      //   278: getstatic 31	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated;
      //   281: areturn
      //   282: getstatic 183	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:PARSER	Lcom/google/protobuf/Parser;
      //   285: ifnonnull +28 -> 313
      //   288: ldc 2
      //   290: monitorenter
      //   291: getstatic 183	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:PARSER	Lcom/google/protobuf/Parser;
      //   294: ifnonnull +16 -> 310
      //   297: new 185	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   300: dup
      //   301: getstatic 31	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:DEFAULT_INSTANCE	Lcom/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated;
      //   304: invokespecial 188	com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser:<init>	(Lcom/google/protobuf/GeneratedMessageLite;)V
      //   307: putstatic 183	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:PARSER	Lcom/google/protobuf/Parser;
      //   310: ldc 2
      //   312: monitorexit
      //   313: getstatic 183	com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses$SettingsFriendsListSortByActivityUpdated:PARSER	Lcom/google/protobuf/Parser;
      //   316: areturn
      //   317: astore_1
      //   318: ldc 2
      //   320: monitorexit
      //   321: aload_1
      //   322: athrow
      //   323: goto -123 -> 200
      //   326: iconst_1
      //   327: istore 4
      //   329: goto -167 -> 162
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	332	0	this	SettingsFriendsListSortByActivityUpdated
      //   0	332	1	paramMethodToInvoke	com.google.protobuf.GeneratedMessageLite.MethodToInvoke
      //   0	332	2	paramObject1	Object
      //   0	332	3	paramObject2	Object
      //   160	168	4	i	int
      //   171	31	5	j	int
      // Exception table:
      //   from	to	target	type
      //   167	173	237	com/google/protobuf/InvalidProtocolBufferException
      //   200	210	237	com/google/protobuf/InvalidProtocolBufferException
      //   216	234	237	com/google/protobuf/InvalidProtocolBufferException
      //   167	173	251	finally
      //   200	210	251	finally
      //   216	234	251	finally
      //   238	251	251	finally
      //   255	278	251	finally
      //   167	173	254	java/io/IOException
      //   200	210	254	java/io/IOException
      //   216	234	254	java/io/IOException
      //   291	310	317	finally
      //   310	313	317	finally
      //   318	321	317	finally
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeBoolSize(1, this.sortEnabled_);
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean getSortEnabled()
    {
      return this.sortEnabled_;
    }
    
    public boolean hasSortEnabled()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeBool(1, this.sortEnabled_);
      }
      this.unknownFields.writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdated, Builder>
      implements SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdatedOrBuilder
    {
      private Builder()
      {
        super();
      }
      
      public Builder clearSortEnabled()
      {
        copyOnWrite();
        ((SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdated)this.instance).clearSortEnabled();
        return this;
      }
      
      public boolean getSortEnabled()
      {
        return ((SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdated)this.instance).getSortEnabled();
      }
      
      public boolean hasSortEnabled()
      {
        return ((SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdated)this.instance).hasSortEnabled();
      }
      
      public Builder setSortEnabled(boolean paramBoolean)
      {
        copyOnWrite();
        ((SettingsFriendsListSortByActivityUpdatedClasses.SettingsFriendsListSortByActivityUpdated)this.instance).setSortEnabled(paramBoolean);
        return this;
      }
    }
  }
  
  public static abstract interface SettingsFriendsListSortByActivityUpdatedOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract boolean getSortEnabled();
    
    public abstract boolean hasSortEnabled();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/proto/settings/SettingsFriendsListSortByActivityUpdatedClasses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */