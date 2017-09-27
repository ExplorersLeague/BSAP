package com.blizzard.messenger.views.scannerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import me.dm7.barcodescanner.core.IViewFinder;

public class BlizzardZXingScannerView
  extends View
  implements IViewFinder
{
  private static final long ANIMATION_DELAY = 80L;
  private static final float LANDSCAPE_HEIGHT_RATIO = 0.625F;
  private static final float LANDSCAPE_WIDTH_HEIGHT_RATIO = 1.0F;
  private static final int MIN_DIMENSION_DIFF = 50;
  private static final int POINT_SIZE = 10;
  private static final float PORTRAIT_WIDTH_HEIGHT_RATIO = 1.0F;
  private static final float PORTRAIT_WIDTH_RATIO = 0.75F;
  private static final int[] SCANNER_ALPHA = { 0, 64, 128, 192, 255, 192, 128, 64 };
  private static final float SQUARE_DIMENSION_RATIO = 0.625F;
  private Rect framingRect;
  private int mBorderLineLength;
  private Paint mBorderPaint;
  private final int mDefaultBorderLineLength = getResources().getInteger(2131492864);
  private final int mDefaultBorderStrokeWidth = getResources().getInteger(2131492865);
  private final int mDefaultLaserColor = getResources().getColor(17170445);
  private final int mDefaultMaskColor = getResources().getColor(2131689639);
  private Paint mFinderMaskPaint;
  private Paint mLaserPaint;
  private int scannerAlpha;
  
  public BlizzardZXingScannerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BlizzardZXingScannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void drawViewFinderBorder(Canvas paramCanvas)
  {
    Rect localRect = getFramingRect();
    paramCanvas.drawLine(localRect.left - 1, localRect.top - 1, localRect.left - 1, localRect.top - 1 + this.mBorderLineLength, this.mBorderPaint);
    paramCanvas.drawLine(localRect.left - 1, localRect.top - 1, localRect.left - 1 + this.mBorderLineLength, localRect.top - 1, this.mBorderPaint);
    paramCanvas.drawLine(localRect.left - 1, localRect.bottom + 1, localRect.left - 1, localRect.bottom + 1 - this.mBorderLineLength, this.mBorderPaint);
    paramCanvas.drawLine(localRect.left - 1, localRect.bottom + 1, localRect.left - 1 + this.mBorderLineLength, localRect.bottom + 1, this.mBorderPaint);
    paramCanvas.drawLine(localRect.right + 1, localRect.top - 1, localRect.right + 1, localRect.top - 1 + this.mBorderLineLength, this.mBorderPaint);
    paramCanvas.drawLine(localRect.right + 1, localRect.top - 1, localRect.right + 1 - this.mBorderLineLength, localRect.top - 1, this.mBorderPaint);
    paramCanvas.drawLine(localRect.right + 1, localRect.bottom + 1, localRect.right + 1, localRect.bottom + 1 - this.mBorderLineLength, this.mBorderPaint);
    paramCanvas.drawLine(localRect.right + 1, localRect.bottom + 1, localRect.right + 1 - this.mBorderLineLength, localRect.bottom + 1, this.mBorderPaint);
  }
  
  private void drawViewFinderMask(Canvas paramCanvas)
  {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    Rect localRect = getFramingRect();
    paramCanvas.drawRect(0.0F, 0.0F, i, localRect.top, this.mFinderMaskPaint);
    paramCanvas.drawRect(0.0F, localRect.top, localRect.left, localRect.bottom + 1, this.mFinderMaskPaint);
    paramCanvas.drawRect(localRect.right + 1, localRect.top, i, localRect.bottom + 1, this.mFinderMaskPaint);
    paramCanvas.drawRect(0.0F, localRect.bottom + 1, i, j, this.mFinderMaskPaint);
  }
  
  private void init()
  {
    int i = getResources().getColor(2131689473);
    this.mLaserPaint = new Paint();
    this.mLaserPaint.setColor(this.mDefaultLaserColor);
    this.mLaserPaint.setStyle(Paint.Style.FILL);
    this.mFinderMaskPaint = new Paint();
    this.mFinderMaskPaint.setColor(this.mDefaultMaskColor);
    this.mBorderPaint = new Paint();
    this.mBorderPaint.setColor(i);
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
    this.mBorderPaint.setStrokeWidth(this.mDefaultBorderStrokeWidth);
    this.mBorderLineLength = this.mDefaultBorderLineLength;
  }
  
  /* Error */
  private void updateFramingRect()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 152	android/graphics/Point
    //   5: dup
    //   6: aload_0
    //   7: invokevirtual 153	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:getWidth	()I
    //   10: aload_0
    //   11: invokevirtual 154	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:getHeight	()I
    //   14: invokespecial 157	android/graphics/Point:<init>	(II)V
    //   17: astore 5
    //   19: aload_0
    //   20: invokevirtual 161	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:getContext	()Landroid/content/Context;
    //   23: invokestatic 167	me/dm7/barcodescanner/core/DisplayUtils:getScreenOrientation	(Landroid/content/Context;)I
    //   26: iconst_1
    //   27: if_icmpeq +100 -> 127
    //   30: aload_0
    //   31: invokevirtual 154	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:getHeight	()I
    //   34: i2f
    //   35: ldc 13
    //   37: fmul
    //   38: f2i
    //   39: istore_1
    //   40: iload_1
    //   41: i2f
    //   42: fconst_1
    //   43: fmul
    //   44: f2i
    //   45: istore_2
    //   46: iload_2
    //   47: istore_3
    //   48: iload_2
    //   49: aload_0
    //   50: invokevirtual 153	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:getWidth	()I
    //   53: if_icmple +11 -> 64
    //   56: aload_0
    //   57: invokevirtual 153	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:getWidth	()I
    //   60: bipush 50
    //   62: isub
    //   63: istore_3
    //   64: iload_1
    //   65: istore_2
    //   66: iload_1
    //   67: aload_0
    //   68: invokevirtual 154	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:getHeight	()I
    //   71: if_icmple +11 -> 82
    //   74: aload_0
    //   75: invokevirtual 154	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:getHeight	()I
    //   78: bipush 50
    //   80: isub
    //   81: istore_2
    //   82: aload 5
    //   84: getfield 170	android/graphics/Point:x	I
    //   87: iload_3
    //   88: isub
    //   89: iconst_2
    //   90: idiv
    //   91: istore_1
    //   92: aload 5
    //   94: getfield 173	android/graphics/Point:y	I
    //   97: iload_2
    //   98: isub
    //   99: iconst_2
    //   100: idiv
    //   101: istore 4
    //   103: aload_0
    //   104: new 86	android/graphics/Rect
    //   107: dup
    //   108: iload_1
    //   109: iload 4
    //   111: iload_1
    //   112: iload_3
    //   113: iadd
    //   114: iload 4
    //   116: iload_2
    //   117: iadd
    //   118: invokespecial 176	android/graphics/Rect:<init>	(IIII)V
    //   121: putfield 178	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:framingRect	Landroid/graphics/Rect;
    //   124: aload_0
    //   125: monitorexit
    //   126: return
    //   127: aload_0
    //   128: invokevirtual 153	com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView:getWidth	()I
    //   131: istore_1
    //   132: iload_1
    //   133: i2f
    //   134: ldc 23
    //   136: fmul
    //   137: f2i
    //   138: istore_2
    //   139: iload_2
    //   140: i2f
    //   141: fconst_1
    //   142: fmul
    //   143: f2i
    //   144: istore_1
    //   145: goto -99 -> 46
    //   148: astore 5
    //   150: aload_0
    //   151: monitorexit
    //   152: aload 5
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	BlizzardZXingScannerView
    //   39	106	1	i	int
    //   45	95	2	j	int
    //   47	67	3	k	int
    //   101	17	4	m	int
    //   17	76	5	localPoint	android.graphics.Point
    //   148	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	148	finally
    //   48	64	148	finally
    //   66	82	148	finally
    //   82	124	148	finally
    //   127	132	148	finally
  }
  
  public Rect getFramingRect()
  {
    return this.framingRect;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (getFramingRect() == null) {
      return;
    }
    drawViewFinderMask(paramCanvas);
    drawViewFinderBorder(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    updateFramingRect();
  }
  
  public void setupViewFinder()
  {
    updateFramingRect();
    invalidate();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/views/scannerview/BlizzardZXingScannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */