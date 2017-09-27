package com.blizzard.messenger.utils;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.TypedValue;

public class ColorUtils
{
  public static int getChatBubbleMine(Context paramContext)
  {
    return getImageResourceId(paramContext, 2130771992);
  }
  
  public static int getChatBubbleMineNoTail(Context paramContext)
  {
    return getImageResourceId(paramContext, 2130771993);
  }
  
  public static int getChatBubbleRecipient(Context paramContext)
  {
    return getImageResourceId(paramContext, 2130771994);
  }
  
  public static int getChatBubbleRecipientNoTail(Context paramContext)
  {
    return getImageResourceId(paramContext, 2130771995);
  }
  
  private static int getColor(Context paramContext, int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return localTypedValue.data;
  }
  
  public static int getColorAccent(Context paramContext)
  {
    return getColor(paramContext, 2130772180);
  }
  
  public static int getColorFabInactive(Context paramContext)
  {
    return getColor(paramContext, 2130771971);
  }
  
  public static int getColorPrimary(Context paramContext)
  {
    return getColor(paramContext, 2130772178);
  }
  
  public static int getColorPrimaryDark(Context paramContext)
  {
    return getColor(paramContext, 2130772179);
  }
  
  public static int getIconFabInactive(Context paramContext)
  {
    return getImageResourceId(paramContext, 2130771996);
  }
  
  private static int getImageResourceId(Context paramContext, int paramInt)
  {
    return paramContext.getTheme().obtainStyledAttributes(new int[] { paramInt }).getResourceId(0, -1);
  }
  
  public static int getTextColorActionBarTitle(Context paramContext)
  {
    return getColor(paramContext, 2130772043);
  }
  
  public static int getTextColorConversationMine(Context paramContext)
  {
    return getColor(paramContext, 2130772044);
  }
  
  public static int getTextColorConversationRecipient(Context paramContext)
  {
    return getColor(paramContext, 2130772045);
  }
  
  public static int getTextColorError(Context paramContext)
  {
    return getColor(paramContext, 2130771986);
  }
  
  public static int getTextColorPrimary(Context paramContext)
  {
    return getColor(paramContext, 16842806);
  }
  
  public static int getTextColorPrimaryDark(Context paramContext)
  {
    return getColor(paramContext, 2130772048);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/ColorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */