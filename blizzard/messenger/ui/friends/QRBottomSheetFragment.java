package com.blizzard.messenger.ui.friends;

import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import rx.Observable;
import rx.subjects.PublishSubject;

public class QRBottomSheetFragment
  extends BottomSheetDialogFragment
  implements View.OnClickListener
{
  private final PublishSubject<Void> scanCodeSubject = PublishSubject.create();
  private final PublishSubject<Void> showCodeSubject = PublishSubject.create();
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131820705: 
      this.showCodeSubject.onNext(null);
      getDialog().dismiss();
      return;
    }
    this.scanCodeSubject.onNext(null);
    getDialog().dismiss();
  }
  
  public Observable<Void> onScanCodeClicked()
  {
    return this.scanCodeSubject;
  }
  
  public Observable<Void> onShowCodeClicked()
  {
    return this.showCodeSubject;
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt)
  {
    super.setupDialog(paramDialog, paramInt);
    View localView = View.inflate(getActivity(), 2130968607, null);
    paramDialog.setContentView(localView);
    localView.findViewById(2131820704).setOnClickListener(this);
    localView.findViewById(2131820705).setOnClickListener(this);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/QRBottomSheetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */