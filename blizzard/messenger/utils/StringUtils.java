package com.blizzard.messenger.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import com.blizzard.messenger.data.model.chat.ChatMessage;
import com.blizzard.messenger.data.model.profile.Profile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils
{
  private static final long DAY_MILLIS = 86400000L;
  private static final Pattern FORMAT_SEQUENCE = Pattern.compile("%([0-9]+\\$|<?)([^a-zA-z%]*)([[a-zA-Z%]&&[^tT]]|[tT][a-zA-Z])");
  private static final long HOUR_MILLIS = 3600000L;
  private static final long MINUTE_MILLIS = 60000L;
  private static final long MONTH_MILLIS = 2592000000L;
  private static final long SECOND_MILLIS = 1000L;
  private static final Pattern VALID_BATTLETAG = Pattern.compile("^[(\\p{L})(\\p{N})]+#[0-9]{2,8}");
  private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^(\\S+)@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)+$", 2);
  private static final int VALID_EMAIL_LENGTH = 256;
  private static final long YEAR_MILLIS = 31536000000L;
  
  public static void copyToClipboard(Context paramContext, String paramString)
  {
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("copy", paramString));
  }
  
  public static SpannedString format(CharSequence paramCharSequence, Object... paramVarArgs)
  {
    return format(Locale.getDefault(), paramCharSequence, paramVarArgs);
  }
  
  private static SpannedString format(Locale paramLocale, CharSequence paramCharSequence, Object... paramVarArgs)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    int j = 0;
    int i = -1;
    if (j < localSpannableStringBuilder.length())
    {
      localObject2 = FORMAT_SEQUENCE.matcher(localSpannableStringBuilder);
      if (((Matcher)localObject2).find(j)) {}
    }
    else
    {
      return new SpannedString(localSpannableStringBuilder);
    }
    int k = ((Matcher)localObject2).start();
    int m = ((Matcher)localObject2).end();
    Object localObject1 = ((Matcher)localObject2).group(1);
    paramCharSequence = ((Matcher)localObject2).group(2);
    Object localObject2 = ((Matcher)localObject2).group(3);
    if (((String)localObject2).equals("%")) {
      paramCharSequence = "%";
    }
    for (;;)
    {
      localSpannableStringBuilder.replace(k, m, paramCharSequence);
      j = k + paramCharSequence.length();
      break;
      if (((String)localObject2).equals("n"))
      {
        paramCharSequence = "\n";
      }
      else
      {
        if (((String)localObject1).equals(""))
        {
          i += 1;
          j = i;
        }
        for (;;)
        {
          localObject1 = paramVarArgs[j];
          if ((!((String)localObject2).equals("s")) || (!(localObject1 instanceof Spanned))) {
            break label235;
          }
          paramCharSequence = (Spanned)localObject1;
          break;
          if (((String)localObject1).equals("<")) {
            j = i;
          } else {
            j = Integer.parseInt(((String)localObject1).substring(0, ((String)localObject1).length() - 1)) - 1;
          }
        }
        label235:
        paramCharSequence = String.format(paramLocale, "%" + paramCharSequence + (String)localObject2, new Object[] { localObject1 });
      }
    }
  }
  
  public static String getBattleTagName(@Nullable String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.contains("#"));
    return paramString.split("#")[0];
  }
  
  public static String getBattleTagNumber(@Nullable String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace(getBattleTagName(paramString), "");
  }
  
  public static String getBattletag(Profile paramProfile)
  {
    return paramProfile.getBattleTag();
  }
  
  private static String getChatMessageHeaderFormat(Context paramContext)
  {
    return DateFormat.getBestDateTimePattern(getCurrentLocale(paramContext), "EEEE, MMM d, yyyy");
  }
  
  public static String getChatMessageHeaderTimestamp(Context paramContext, double paramDouble)
  {
    paramContext = new SimpleDateFormat(getChatMessageHeaderFormat(paramContext));
    paramContext.setTimeZone(TimeZone.getTimeZone("UTC"));
    return paramContext.format(new Date(Double.valueOf(paramDouble).longValue()));
  }
  
  public static String getChatMessageTimestamp(Context paramContext, double paramDouble)
  {
    if (new Date().getTime() - paramDouble > 8.64E7D) {}
    for (boolean bool = true;; bool = false) {
      return new SimpleDateFormat(getChatMessageTimestampFormat(paramContext, bool)).format(new Date(Double.valueOf(paramDouble).longValue()));
    }
  }
  
  private static String getChatMessageTimestampFormat(Context paramContext, boolean paramBoolean)
  {
    boolean bool = DateFormat.is24HourFormat(paramContext);
    paramContext = getCurrentLocale(paramContext);
    if (paramBoolean)
    {
      if (bool) {
        return DateFormat.getBestDateTimePattern(paramContext, "MMM d, HH:mm");
      }
      return DateFormat.getBestDateTimePattern(paramContext, "MMM d, hh:mm a");
    }
    if (bool) {
      return DateFormat.getBestDateTimePattern(paramContext, "HH:mm");
    }
    return DateFormat.getBestDateTimePattern(paramContext, "hh:mm a");
  }
  
  private static Locale getCurrentLocale(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.getResources().getConfiguration().getLocales().get(0);
    }
    return paramContext.getResources().getConfiguration().locale;
  }
  
  private static String getMonthAndDayString(Context paramContext, double paramDouble)
  {
    return new SimpleDateFormat(DateFormat.getBestDateTimePattern(getCurrentLocale(paramContext), "MMM d")).format(new Date(Double.valueOf(paramDouble).longValue()));
  }
  
  public static String getOfflineTime(Context paramContext, String paramString)
  {
    long l1 = ChatMessage.createTimestamp();
    if (paramString == null) {
      return "";
    }
    long l2;
    try
    {
      l2 = Double.valueOf(paramString).longValue();
      if (l2 <= 0L) {
        return "";
      }
    }
    catch (NumberFormatException paramContext)
    {
      paramContext.printStackTrace();
      return "";
    }
    l1 -= l2;
    paramContext = paramContext.getResources();
    if (l1 < 60000L) {
      return paramContext.getString(2131362050);
    }
    if (l1 < 120000L) {
      return paramContext.getString(2131362047);
    }
    if (l1 < 3600000L) {
      return String.format(paramContext.getString(2131362051), new Object[] { Long.valueOf(l1 / 60000L) });
    }
    if (l1 < 86400000L) {
      return String.format(paramContext.getString(2131362049), new Object[] { Long.valueOf(l1 / 3600000L) });
    }
    if (l1 < 2592000000L) {
      return String.format(paramContext.getString(2131362048), new Object[] { Long.valueOf(l1 / 86400000L) });
    }
    if (l1 < 31536000000L) {
      return String.format(paramContext.getString(2131362052), new Object[] { Long.valueOf(l1 / 2592000000L) });
    }
    return String.format(paramContext.getString(2131362053), new Object[] { Long.valueOf(l1 / 31536000000L) });
  }
  
  public static String getRealId(Profile paramProfile)
  {
    return "(" + paramProfile.getFullName() + ")";
  }
  
  public static String getTimeAgo(double paramDouble, Context paramContext)
  {
    long l = ChatMessage.createTimestamp();
    if (paramDouble <= 0.0D) {
      return null;
    }
    l = Double.valueOf(l - paramDouble).longValue();
    Resources localResources = paramContext.getResources();
    if (l < 3600000L) {
      return String.format(localResources.getString(2131361953), new Object[] { Long.valueOf(l / 60000L) });
    }
    if (messageFromToday(l)) {
      return getChatMessageTimestamp(paramContext, paramDouble);
    }
    return getMonthAndDayString(paramContext, paramDouble);
  }
  
  public static boolean isOfflineLongerThanThirtyDays(String paramString)
  {
    try
    {
      d = Double.parseDouble(paramString);
      l = ChatMessage.createTimestamp();
      if (d <= 0.0D) {
        return false;
      }
    }
    catch (NumberFormatException paramString)
    {
      double d;
      long l;
      do
      {
        for (;;)
        {
          d = 0.0D;
        }
      } while (Double.valueOf(l - d).longValue() <= 2592000000L);
      return true;
    }
    catch (NullPointerException paramString)
    {
      for (;;) {}
    }
  }
  
  public static boolean isValidBattletag(String paramString)
  {
    return VALID_BATTLETAG.matcher(paramString).find();
  }
  
  public static boolean isValidEmail(String paramString)
  {
    if (paramString.length() > 256) {
      return false;
    }
    return VALID_EMAIL_ADDRESS_REGEX.matcher(paramString).find();
  }
  
  private static boolean messageFromToday(long paramLong)
  {
    return DateUtils.isToday(paramLong);
  }
  
  private static double parseDouble(@NonNull String paramString, double paramDouble)
  {
    try
    {
      double d = Double.valueOf(paramString).doubleValue();
      return d;
    }
    catch (Exception paramString) {}
    return paramDouble;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */