package com.blizzard.messenger.views.transformation;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.squareup.picasso.Transformation;

public class RoundedTransformation
  implements Transformation
{
  private final String KEY;
  private boolean bottomCorners = true;
  private final int margin;
  private final int radius;
  private boolean topCorners = true;
  
  private RoundedTransformation(int paramInt1, int paramInt2)
  {
    this.radius = paramInt1;
    this.margin = paramInt2;
    this.KEY = ("rounded_" + paramInt1 + paramInt2);
  }
  
  public RoundedTransformation(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramInt1, paramInt2);
  }
  
  private static Path RoundedRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Path localPath = new Path();
    float f1 = paramFloat5;
    if (paramFloat5 < 0.0F) {
      f1 = 0.0F;
    }
    paramFloat5 = paramFloat6;
    if (paramFloat6 < 0.0F) {
      paramFloat5 = 0.0F;
    }
    paramFloat6 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    paramFloat1 = f1;
    if (f1 > paramFloat6 / 2.0F) {
      paramFloat1 = paramFloat6 / 2.0F;
    }
    paramFloat4 = paramFloat5;
    if (paramFloat5 > f2 / 2.0F) {
      paramFloat4 = f2 / 2.0F;
    }
    paramFloat5 = paramFloat6 - 2.0F * paramFloat1;
    paramFloat6 = f2 - 2.0F * paramFloat4;
    localPath.moveTo(paramFloat3, paramFloat2 + paramFloat4);
    if (paramBoolean2)
    {
      localPath.rQuadTo(0.0F, -paramFloat4, -paramFloat1, -paramFloat4);
      localPath.rLineTo(-paramFloat5, 0.0F);
      if (!paramBoolean1) {
        break label231;
      }
      localPath.rQuadTo(-paramFloat1, 0.0F, -paramFloat1, paramFloat4);
      label150:
      localPath.rLineTo(0.0F, paramFloat6);
      if (!paramBoolean4) {
        break label249;
      }
      localPath.rQuadTo(0.0F, paramFloat4, paramFloat1, paramFloat4);
      label172:
      localPath.rLineTo(paramFloat5, 0.0F);
      if (!paramBoolean3) {
        break label266;
      }
      localPath.rQuadTo(paramFloat1, 0.0F, paramFloat1, -paramFloat4);
    }
    for (;;)
    {
      localPath.rLineTo(0.0F, -paramFloat6);
      localPath.close();
      return localPath;
      localPath.rLineTo(0.0F, -paramFloat4);
      localPath.rLineTo(-paramFloat1, 0.0F);
      break;
      label231:
      localPath.rLineTo(-paramFloat1, 0.0F);
      localPath.rLineTo(0.0F, paramFloat4);
      break label150;
      label249:
      localPath.rLineTo(0.0F, paramFloat4);
      localPath.rLineTo(paramFloat1, 0.0F);
      break label172;
      label266:
      localPath.rLineTo(paramFloat1, 0.0F);
      localPath.rLineTo(0.0F, -paramFloat4);
    }
  }
  
  public String key()
  {
    return this.KEY;
  }
  
  public Bitmap transform(Bitmap paramBitmap)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setShader(new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    if ((this.topCorners) && (this.bottomCorners)) {
      localCanvas.drawRoundRect(new RectF(this.margin, this.margin, paramBitmap.getWidth() - this.margin, paramBitmap.getHeight() - this.margin), this.radius, this.radius, localPaint);
    }
    for (;;)
    {
      if (paramBitmap != localBitmap) {
        paramBitmap.recycle();
      }
      return localBitmap;
      localCanvas.drawPath(RoundedRect(this.margin, this.margin, paramBitmap.getWidth() - this.margin, paramBitmap.getHeight() - this.margin, this.radius, this.radius, this.topCorners, this.topCorners, this.bottomCorners, this.bottomCorners), localPaint);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/views/transformation/RoundedTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */