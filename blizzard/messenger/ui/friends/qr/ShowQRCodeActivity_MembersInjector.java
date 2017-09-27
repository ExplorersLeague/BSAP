package com.blizzard.messenger.ui.friends.qr;

import com.blizzard.messenger.data.model.profile.ProfileModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ShowQRCodeActivity_MembersInjector
  implements MembersInjector<ShowQRCodeActivity>
{
  private final Provider<ProfileModel> profileModelProvider;
  
  static
  {
    if (!ShowQRCodeActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ShowQRCodeActivity_MembersInjector(Provider<ProfileModel> paramProvider)
  {
    assert (paramProvider != null);
    this.profileModelProvider = paramProvider;
  }
  
  public static MembersInjector<ShowQRCodeActivity> create(Provider<ProfileModel> paramProvider)
  {
    return new ShowQRCodeActivity_MembersInjector(paramProvider);
  }
  
  public static void injectProfileModel(ShowQRCodeActivity paramShowQRCodeActivity, Provider<ProfileModel> paramProvider)
  {
    paramShowQRCodeActivity.profileModel = ((ProfileModel)paramProvider.get());
  }
  
  public void injectMembers(ShowQRCodeActivity paramShowQRCodeActivity)
  {
    if (paramShowQRCodeActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramShowQRCodeActivity.profileModel = ((ProfileModel)this.profileModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/friends/qr/ShowQRCodeActivity_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */