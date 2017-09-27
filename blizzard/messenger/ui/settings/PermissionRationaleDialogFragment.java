package com.blizzard.messenger.ui.settings;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import rx.Completable;
import rx.subjects.PublishSubject;

public final class PermissionRationaleDialogFragment
  extends DialogFragment
{
  private final PublishSubject<Void> acceptedSubject = PublishSubject.create();
  
  public static PermissionRationaleDialogFragment newInstance()
  {
    return new PermissionRationaleDialogFragment();
  }
  
  public Completable onAccepted()
  {
    return this.acceptedSubject.toCompletable();
  }
  
  @NonNull
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity(), 2131558626);
    View localView = getActivity().getLayoutInflater().inflate(2130968672, null);
    ((TextView)localView.findViewById(2131820843)).setOnClickListener(PermissionRationaleDialogFragment..Lambda.1.lambdaFactory$(this));
    return paramBundle.setView(localView).create();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/PermissionRationaleDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */