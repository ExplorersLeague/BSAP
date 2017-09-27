package com.blizzard.login.bgs;

import android.content.Context;
import com.blizzard.bgs.client.security.CertificateBundle;
import com.blizzard.bgs.client.security.CertificateBundleDownloader;
import com.blizzard.bgs.client.security.CertificateBundleDownloader.Builder;
import com.blizzard.login.logger.Logger;
import java.io.InputStream;
import rx.Completable;
import rx.Single;

class BundleFileManager
{
  private static final String TAG = BundleFileManager.class.getSimpleName();
  
  static Completable downloadBundle(Context paramContext, int paramInt)
  {
    Logger.debug(TAG, "downloading certificate bundle from network");
    return new CertificateBundleDownloader.Builder().timeout(paramInt).build().downloadCertificateBundle().flatMapCompletable(BundleFileManager..Lambda.3.lambdaFactory$(paramContext));
  }
  
  static boolean isDownloadedBundlePresent(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = paramContext.fileList();
    int j = paramContext.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramContext[i].equals("key_bundle_downloaded.bpk")) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  static Single<CertificateBundle> loadBundle(Context paramContext)
  {
    return Single.create(BundleFileManager..Lambda.1.lambdaFactory$(paramContext)).flatMap(BundleFileManager..Lambda.2.lambdaFactory$());
  }
  
  private static Completable saveBundle(Context paramContext, InputStream paramInputStream)
  {
    Logger.debug(TAG, "saving downloaded certificate bundle");
    return Completable.create(BundleFileManager..Lambda.4.lambdaFactory$(paramContext, paramInputStream));
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/bgs/BundleFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */