package com.blizzard.messenger.data.utils;

public class StringFormatUtils
{
  public static String formatMessageBody(String paramString)
  {
    String str = "";
    int n = 0;
    int m = 0;
    if (m < paramString.length())
    {
      int j = paramString.charAt(m);
      char c;
      int k;
      if (j == 39)
      {
        c = '’';
        k = n;
      }
      for (;;)
      {
        str = str + c;
        m += 1;
        n = k;
        break;
        int i;
        if (j == 38)
        {
          i = 65286;
          k = n;
        }
        else if (j == 34)
        {
          if (n != 0)
          {
            k = 0;
            i = 8221;
          }
          else
          {
            k = 1;
            i = 8220;
          }
        }
        else if (j == 60)
        {
          i = 12296;
          k = n;
        }
        else
        {
          i = j;
          k = n;
          if (j == 62)
          {
            i = 12297;
            k = n;
          }
        }
      }
    }
    return str;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/utils/StringFormatUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */