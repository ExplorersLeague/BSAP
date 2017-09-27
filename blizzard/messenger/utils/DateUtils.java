package com.blizzard.messenger.utils;

import com.blizzard.messenger.data.utils.ErrorUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils
{
  private static final int DAY_MILLIS = 86400000;
  
  public static long getEpochTimeForDay(double paramDouble)
  {
    Object localObject = new Date(Double.valueOf(paramDouble).longValue());
    localObject = new SimpleDateFormat("MMM dd yyyy", Locale.getDefault()).format((Date)localObject);
    localObject = (String)localObject + " 00:00:00.000 UTC";
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz", Locale.getDefault());
    try
    {
      long l = localSimpleDateFormat.parse((String)localObject).getTime();
      return l;
    }
    catch (ParseException localParseException)
    {
      ErrorUtils.handleError(localParseException);
    }
    return 0L;
  }
  
  public static boolean isDifferentDay(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1 > 86400000L;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/DateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */