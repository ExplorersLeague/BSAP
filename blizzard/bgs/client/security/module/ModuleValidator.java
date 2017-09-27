package com.blizzard.bgs.client.security.module;

import com.blizzard.bgs.client.exception.ModuleValidateException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;

public class ModuleValidator
{
  public static final int FOOTER_LENGTH = MODULE_MAGIC.length + 256;
  private static final BigInteger KEY_EXPONENT;
  private static final BigInteger KEY_MODULUS = fromArray(new int[] { 53, 255, 23, 231, 51, 196, 211, 212, 240, 55, 164, 181, 124, 27, 240, 78, 49, 232, 255, 179, 12, 30, 136, 16, 77, 175, 19, 11, 88, 86, 88, 25, 88, 55, 21, 249, 235, 236, 152, 203, 157, 204, 253, 24, 241, 71, 9, 27, 227, 123, 56, 40, 158, 14, 155, 31, 159, 149, 218, 157, 97, 117, 242, 31, 160, 61, 162, 153, 189, 178, 29, 14, 105, 202, 188, 115, 27, 229, 235, 15, 231, 251, 43, 123, 178, 53, 5, 143, 245, 181, 154, 59, 18, 173, 161, 164, 140, 247, 144, 102, 136, 23, 214, 31, 147, 132, 16, 174, 242, 239, 42, 122, 95, 65, 123, 92, 128, 210, 94, 26, 253, 219, 16, 118, 147, 188, 139, 213, 230, 178, 80, 245, 81, 155, 3, 226, 83, 155, 168, 176, 177, 55, 213, 37, 102, 69, 8, 129, 32, 15, 136, 97, 174, 187, 245, 68, 245, 132, 158, 118, 39, 21, 116, 23, 198, 183, 143, 224, 45, 55, 92, 248, 82, 49, 50, 63, 250, 68, 127, 239, 36, 61, 91, 89, 249, 253, 80, 80, 202, 160, 54, 77, 98, 217, 68, 13, 105, 166, 239, 43, 206, 204, 194, 163, 188, 245, 162, 28, 238, 119, 69, 228, 51, 240, 87, 32, 191, 46, 7, 134, 43, 149, 187, 58, 252, 4, 60, 69, 63, 0, 52, 11, 54, 187, 75, 193, 15, 149, 24, 195, 217, 250, 54, 66, 202, 150, 170, 236, 122, 46, 136, 130, 60, 29, 152, 148 });
  private static final byte[] MODULE_MAGIC;
  private static final int SIGNATURE_LENGTH = 256;
  private final String moduleName;
  private final Signature signature;
  
  static
  {
    KEY_EXPONENT = fromArray(new int[] { 1, 0, 1, 0 });
    MODULE_MAGIC = new byte[] { 78, 71, 73, 83 };
  }
  
  public ModuleValidator(String paramString)
    throws GeneralSecurityException
  {
    this.moduleName = paramString;
    paramString = new RSAPublicKeySpec(KEY_MODULUS, KEY_EXPONENT);
    paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
    this.signature = Signature.getInstance("SHA256withRSA");
    this.signature.initVerify(paramString);
  }
  
  private static BigInteger fromArray(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfByte[i] = ((byte)paramArrayOfInt[(paramArrayOfInt.length - i - 1)]);
      i += 1;
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  private static void toBigEndian(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < paramArrayOfByte.length / 2)
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[(paramArrayOfByte.length - j - 1)];
      paramArrayOfByte[(paramArrayOfByte.length - j - 1)] = i;
      j += 1;
    }
  }
  
  public void update(byte paramByte)
  {
    try
    {
      this.signature.update(paramByte);
      return;
    }
    catch (SignatureException localSignatureException)
    {
      throw new RuntimeException("internal module validator error", localSignatureException);
    }
  }
  
  public void update(byte[] paramArrayOfByte)
  {
    try
    {
      this.signature.update(paramArrayOfByte);
      return;
    }
    catch (SignatureException paramArrayOfByte)
    {
      throw new RuntimeException("internal module validator error", paramArrayOfByte);
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.signature.update(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (SignatureException paramArrayOfByte)
    {
      throw new RuntimeException("internal module validator error", paramArrayOfByte);
    }
  }
  
  public void validate(InputStream paramInputStream)
    throws IOException
  {
    update(this.moduleName.getBytes());
    byte[] arrayOfByte = new byte[MODULE_MAGIC.length];
    if (paramInputStream.read(arrayOfByte) != MODULE_MAGIC.length) {
      throw new IOException("cannot read magic");
    }
    if (!Arrays.equals(MODULE_MAGIC, arrayOfByte)) {
      throw new ModuleValidateException("invalid magic");
    }
    arrayOfByte = new byte['Ā'];
    if (paramInputStream.read(arrayOfByte) != 256) {
      throw new IOException("cannot read signature");
    }
    toBigEndian(arrayOfByte);
    try
    {
      if (!this.signature.verify(arrayOfByte)) {
        throw new ModuleValidateException("invalid signature");
      }
    }
    catch (SignatureException paramInputStream)
    {
      throw new RuntimeException("internal module validator error", paramInputStream);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/security/module/ModuleValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */