package com.blizzard.bgs.client.security.module;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

public class StreamFactory
{
  public static InputStream create(InputStream paramInputStream, String paramString)
    throws GeneralSecurityException, IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    int i;
    for (;;)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i < 0)
      {
        paramInputStream = localByteArrayOutputStream.toByteArray();
        i = paramInputStream.length - ModuleValidator.FOOTER_LENGTH;
        if (i > 0) {
          break;
        }
        throw new IOException("cert bundle module too small for footer");
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramString = new ModuleValidator(paramString);
    paramString.update(paramInputStream, 0, i);
    paramString.validate(new ByteArrayInputStream(paramInputStream, i, ModuleValidator.FOOTER_LENGTH));
    return new ByteArrayInputStream(paramInputStream, 0, i);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/security/module/StreamFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */