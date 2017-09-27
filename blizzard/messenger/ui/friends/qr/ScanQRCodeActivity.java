package com.blizzard.messenger.ui.friends.qr;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.blizzard.messenger.databinding.ScanQrCodeActivityBinding;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.ui.friends.management.CameraPermissionDeniedActivity;
import com.blizzard.messenger.utils.PermissionUtils;
import com.blizzard.messenger.utils.StringUtils;
import com.blizzard.messenger.utils.ToastMaster;
import com.blizzard.messenger.views.dialog.FriendRequestDialogFragment;
import com.blizzard.messenger.views.scannerview.BlizzardZXingScannerView;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.zxing.Result;
import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler;
import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;

public class ScanQRCodeActivity
  extends BaseActivity
  implements ZXingScannerView.ResultHandler
{
  private ScanQrCodeActivityBinding binding;
  private ZXingScannerView scannerView;
  
  private void restartCamera()
  {
    this.scannerView.stopCamera();
    this.scannerView.setResultHandler(this);
    this.scannerView.startCamera();
  }
  
  private void showCameraPermissionDeniedActivity()
  {
    startActivity(new Intent(this, CameraPermissionDeniedActivity.class));
    finish();
  }
  
  public void handleResult(Result paramResult)
  {
    this.scannerView.stopCamera();
    if ((TextUtils.isEmpty(paramResult.getText())) || (!StringUtils.isValidBattletag(paramResult.getText())))
    {
      new ToastMaster(this).showErrorToast(getString(2131361997));
      restartCamera();
      return;
    }
    paramResult = FriendRequestDialogFragment.newSendInstance(paramResult.getText(), "BattleTag");
    paramResult.onFriendRequestConfirmed().observeOn(AndroidSchedulers.mainThread()).subscribe(ScanQRCodeActivity..Lambda.2.lambdaFactory$(this));
    paramResult.onFriendRequestCancelled().observeOn(AndroidSchedulers.mainThread()).subscribe(ScanQRCodeActivity..Lambda.3.lambdaFactory$(this));
    paramResult.onFriendRequestSent().subscribe(ScanQRCodeActivity..Lambda.4.lambdaFactory$(this));
    paramResult.show(getSupportFragmentManager(), "FriendRequestDialogFragment");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.friends.qr.ScanQRCodeActivity");
    super.onCreate(paramBundle);
    this.binding = ((ScanQrCodeActivityBinding)DataBindingUtil.setContentView(this, 2130968696));
    setSupportActionBar(this.binding.toolbar);
    setTitle(getString(2131362023));
    setDisplayHomeAsUpEnabled(true);
    this.scannerView = new ZXingScannerView(this)
    {
      protected IViewFinder createViewFinderView(Context paramAnonymousContext)
      {
        return new BlizzardZXingScannerView(paramAnonymousContext);
      }
    };
    this.binding.parent.addView(this.scannerView);
  }
  
  public void onPause()
  {
    super.onPause();
    this.scannerView.stopCamera();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (PermissionUtils.isPermissionGranted(paramInt, paramArrayOfString, paramArrayOfInt))
    {
      restartCamera();
      return;
    }
    showCameraPermissionDeniedActivity();
  }
  
  public void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.friends.qr.ScanQRCodeActivity");
    super.onResume();
    PermissionUtils.requestPermission(this, 500, "android.permission.CAMERA").subscribeOn(AndroidSchedulers.mainThread()).subscribe(ScanQRCodeActivity..Lambda.1.lambdaFactory$(this));
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.friends.qr.ScanQRCodeActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/qr/ScanQRCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */