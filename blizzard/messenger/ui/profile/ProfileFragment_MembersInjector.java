package com.blizzard.messenger.ui.profile;

import com.blizzard.messenger.data.model.profile.ProfileModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ProfileFragment_MembersInjector
  implements MembersInjector<ProfileFragment>
{
  private final Provider<ProfileModel> profileModelProvider;
  
  static
  {
    if (!ProfileFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ProfileFragment_MembersInjector(Provider<ProfileModel> paramProvider)
  {
    assert (paramProvider != null);
    this.profileModelProvider = paramProvider;
  }
  
  public static MembersInjector<ProfileFragment> create(Provider<ProfileModel> paramProvider)
  {
    return new ProfileFragment_MembersInjector(paramProvider);
  }
  
  public static void injectProfileModel(ProfileFragment paramProfileFragment, Provider<ProfileModel> paramProvider)
  {
    paramProfileFragment.profileModel = ((ProfileModel)paramProvider.get());
  }
  
  public void injectMembers(ProfileFragment paramProfileFragment)
  {
    if (paramProfileFragment == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramProfileFragment.profileModel = ((ProfileModel)this.profileModelProvider.get());
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/profile/ProfileFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */