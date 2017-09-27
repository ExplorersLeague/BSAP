package com.blizzard.bgs.client.core;

import okio.ByteString;

public class Base64
{
  public static byte[] decodeToBytes(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return ByteString.decodeBase64(paramString).toByteArray();
  }
  
  public static String decodeToString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return ByteString.decodeBase64(paramString).utf8();
  }
  
  public static String encode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return ByteString.encodeUtf8(paramString).base64();
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return ByteString.of(paramArrayOfByte).base64();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */