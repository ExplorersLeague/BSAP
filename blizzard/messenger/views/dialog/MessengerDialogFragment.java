package com.blizzard.messenger.views.dialog;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.messenger.model.ExceptionText;
import com.blizzard.messenger.utils.ExceptionUtils;
import rx.Observable;
import rx.subjects.PublishSubject;

public class MessengerDialogFragment
  extends DialogFragment
{
  public static final String ARG_MESSAGE = "Message";
  public static final String ARG_NEGATIVE_BUTTON = "NegativeButton";
  public static final String ARG_POSITIVE_BUTTON = "PositiveButton";
  public static final String ARG_TITLE = "Title";
  private final PublishSubject<Void> negativeButtonClickedSubject = PublishSubject.create();
  private final PublishSubject<Void> positiveButtonClickedSubject = PublishSubject.create();
  
  public static MessengerDialogFragment newInstance(Context paramContext, Throwable paramThrowable)
  {
    paramThrowable = ExceptionUtils.getExceptionText(paramThrowable);
    if ((paramThrowable.getMessageResId() != 0) && (paramThrowable.getTitleResId() != 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("Message", paramContext.getString(paramThrowable.getMessageResId()));
      localBundle.putString("Title", paramContext.getString(paramThrowable.getTitleResId()));
      localBundle.putString("PositiveButton", paramContext.getString(2131362020));
      localBundle.putString("NegativeButton", paramContext.getString(2131361918));
      return newInstance(localBundle);
    }
    return null;
  }
  
  public static MessengerDialogFragment newInstance(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      Log.w("DialogFragment", "No bundle, no dialog created");
      return null;
    }
    MessengerDialogFragment localMessengerDialogFragment = new MessengerDialogFragment();
    localMessengerDialogFragment.setArguments(paramBundle);
    return localMessengerDialogFragment;
  }
  
  @NonNull
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity(), 2131558626);
    paramBundle = getArguments();
    String str2 = paramBundle.getString("Message");
    String str3 = paramBundle.getString("Title");
    String str1 = paramBundle.getString("PositiveButton");
    String str4 = paramBundle.getString("NegativeButton");
    paramBundle = str1;
    if (TextUtils.isEmpty(str1)) {
      paramBundle = getString(2131361960);
    }
    if (str2 != null) {
      localBuilder.setMessage(str2);
    }
    if (str3 != null) {
      localBuilder.setTitle(str3);
    }
    localBuilder.setPositiveButton(paramBundle, MessengerDialogFragment..Lambda.1.lambdaFactory$(this));
    if (str4 != null) {
      localBuilder.setNegativeButton(str4, MessengerDialogFragment..Lambda.2.lambdaFactory$(this));
    }
    return localBuilder.create();
  }
  
  public Observable<Void> onNegativeButtonClicked()
  {
    return this.negativeButtonClickedSubject;
  }
  
  public Observable<Void> onPositiveButtonClicked()
  {
    return this.positiveButtonClickedSubject;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/views/dialog/MessengerDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */