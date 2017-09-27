package com.blizzard.messenger.ui.friends;

import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import rx.Observable;
import rx.subjects.PublishSubject;

public class DenyRequestBottomSheetFragment
  extends BottomSheetDialogFragment
  implements View.OnClickListener
{
  private final PublishSubject<Void> blockSubject = PublishSubject.create();
  private final PublishSubject<Void> denySubject = PublishSubject.create();
  private final PublishSubject<Void> reportSubject = PublishSubject.create();
  
  public Observable<Void> onBlockClicked()
  {
    return this.blockSubject;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131820748: 
      this.denySubject.onNext(null);
      this.denySubject.onCompleted();
      dismiss();
      return;
    case 2131820749: 
      this.blockSubject.onNext(null);
      this.blockSubject.onCompleted();
      dismiss();
      return;
    }
    this.reportSubject.onNext(null);
    this.reportSubject.onCompleted();
    dismiss();
  }
  
  public Observable<Void> onDenyClicked()
  {
    return this.denySubject;
  }
  
  public Observable<Void> onReportClicked()
  {
    return this.reportSubject;
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt)
  {
    super.setupDialog(paramDialog, paramInt);
    View localView = View.inflate(getActivity(), 2130968621, null);
    paramDialog.setContentView(localView);
    localView.findViewById(2131820748).setOnClickListener(this);
    localView.findViewById(2131820749).setOnClickListener(this);
    localView.findViewById(2131820750).setOnClickListener(this);
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/DenyRequestBottomSheetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */