package com.blizzard.telemetry.sdk.tools;

import com.google.protobuf.ByteString;
import java.io.PrintStream;

public class Dbg
{
  public static void dumpHex(ByteString paramByteString)
  {
    dumpHex(paramByteString.toByteArray());
  }
  
  public static void dumpHex(byte[] paramArrayOfByte)
  {
    dumpHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static void dumpHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    String str2 = "";
    int i = 0;
    while (i < paramInt2)
    {
      Object localObject = String.format("%1$04X: ", new Object[] { Integer.valueOf(paramInt1 + i) });
      int j = 0;
      if (j < 16)
      {
        if ((i + j < paramInt2) && (paramInt1 + i + j < paramArrayOfByte.length)) {}
        for (str1 = (String)localObject + String.format("%1$02X", new Object[] { Byte.valueOf(paramArrayOfByte[(paramInt1 + i + j)]) });; str1 = (String)localObject + String.format("%1$c%1$c", new Object[] { Integer.valueOf(222) }))
        {
          localObject = str1;
          if ((i + j) % 4 == 3) {
            localObject = str1 + " ";
          }
          j += 1;
          break;
        }
      }
      String str1 = (String)localObject + " |";
      j = 0;
      if (j < 16)
      {
        if ((i + j < paramInt2) && (paramInt1 + i + j < paramArrayOfByte.length))
        {
          byte b = paramArrayOfByte[(paramInt1 + i + j)];
          if ((32 <= b) && (b <= Byte.MAX_VALUE)) {
            str1 = str1 + String.format("%1$c", new Object[] { Byte.valueOf(b) });
          }
        }
        for (;;)
        {
          j += 1;
          break;
          str1 = str1 + String.format("%1$c", new Object[] { Integer.valueOf(191) });
          continue;
          str1 = str1 + String.format("%1$c", new Object[] { Integer.valueOf(254) });
        }
      }
      str1 = str1 + "|";
      str2 = str2 + str1 + "\r\n";
      i += 16;
    }
    System.out.println(str2);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/tools/Dbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */