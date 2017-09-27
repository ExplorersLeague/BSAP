package com.blizzard.messenger.ui.common;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import rx.Observable;
import rx.subjects.PublishSubject;

public final class KeyboardAwareEditText
  extends AppCompatEditText
  implements View.OnClickListener, View.OnFocusChangeListener
{
  private boolean isKeyboardOpen = false;
  private final PublishSubject<Boolean> keyboardOpenSubject = PublishSubject.create();
  
  public KeyboardAwareEditText(Context paramContext)
  {
    super(paramContext);
    setOnClickListener(this);
    setOnFocusChangeListener(this);
  }
  
  public KeyboardAwareEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnClickListener(this);
    setOnFocusChangeListener(this);
  }
  
  public KeyboardAwareEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnClickListener(this);
    setOnFocusChangeListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (!this.isKeyboardOpen)
    {
      this.isKeyboardOpen = true;
      this.keyboardOpenSubject.onNext(Boolean.valueOf(true));
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.isKeyboardOpen))
    {
      this.isKeyboardOpen = true;
      this.keyboardOpenSubject.onNext(Boolean.valueOf(true));
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.isKeyboardOpen))
    {
      this.isKeyboardOpen = false;
      this.keyboardOpenSubject.onNext(Boolean.valueOf(false));
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public Observable<Boolean> onKeyboardOpen()
  {
    return this.keyboardOpenSubject;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/common/KeyboardAwareEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */