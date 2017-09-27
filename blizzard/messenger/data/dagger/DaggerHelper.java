package com.blizzard.messenger.data.dagger;

public class DaggerHelper
{
  private static DaggerHelper instance;
  private MessengerSDKComponent component;
  
  private MessengerSDKComponent createMessengerSdkComponent()
  {
    return DaggerMessengerSDKComponent.builder().friendsModule(new FriendsModule()).presenceModule(new PresenceModule()).connectionModule(new ConnectionModule()).chatModule(new ChatModule()).chatHistoryModule(new ChatHistoryModule()).settingsModule(new SettingsModule()).pushNotificationModule(new PushNotificationModule()).profileModule(new ProfileModule()).suggestedFriendsModule(new SuggestedFriendsModule()).build();
  }
  
  public static DaggerHelper getInstance()
  {
    if (instance == null) {
      instance = new DaggerHelper();
    }
    return instance;
  }
  
  public MessengerSDKComponent getMessengerSDKComponent()
  {
    return this.component;
  }
  
  public void initialize()
  {
    this.component = createMessengerSdkComponent();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/dagger/DaggerHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */