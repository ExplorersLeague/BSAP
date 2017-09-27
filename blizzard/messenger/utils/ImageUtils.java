package com.blizzard.messenger.utils;

import android.content.Context;
import android.graphics.Bitmap;
import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.image.ImageType;

public class ImageUtils
{
  private static final int QR_CODE_SIZE_IN_DP = 175;
  private static int[] addFriendResIds = { 2130837587, 2130837588, 2130837589, 2130837590, 2130837591, 2130837592 };
  
  public static int getAddFriendImageResourceId()
  {
    return addFriendResIds[new java.util.Random().nextInt(addFriendResIds.length)];
  }
  
  public static Bitmap getQrCode(Context paramContext, String paramString)
  {
    int i = (int)ViewUtils.convertDpToPixel(175.0F, paramContext);
    return QRCode.from(paramString).withSize(i, i).withCharset("UTF-8").withColor(-16777216, 0).to(ImageType.PNG).bitmap();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/utils/ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */