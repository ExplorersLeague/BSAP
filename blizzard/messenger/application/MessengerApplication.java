package com.blizzard.messenger.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.blizzard.messenger.dagger.AppModule;
import com.blizzard.messenger.dagger.DaggerMessengerComponent;
import com.blizzard.messenger.dagger.DaggerMessengerComponent.Builder;
import com.blizzard.messenger.dagger.MessengerComponent;
import com.blizzard.messenger.dagger.ModelModule;
import com.blizzard.messenger.data.listeners.ConnectivityListener;
import com.blizzard.messenger.data.model.chat.NewestMessageModel;
import com.blizzard.messenger.data.model.chat.UnseenConversationModel;
import com.blizzard.messenger.data.model.friends.FriendRequestModel;
import com.blizzard.messenger.data.model.friends.FriendsModel;
import com.blizzard.messenger.data.model.friends.suggestions.SuggestedFriendsModel;
import com.blizzard.messenger.data.model.profile.ProfileModel;
import com.blizzard.messenger.data.model.push.PushNotificationModel;
import com.blizzard.messenger.data.model.settings.SettingsModel;
import com.blizzard.messenger.providers.MessengerProvider;
import com.blizzard.messenger.telemetry.Telemetry;
import com.blizzard.messenger.utils.ApplicationMonitor;
import com.blizzard.messenger.utils.NotificationUtils;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;

public class MessengerApplication
  extends Application
{
  private MessengerComponent modelComponent;
  private Tracker tracker;
  
  private MessengerComponent createModelComponent()
  {
    return DaggerMessengerComponent.builder().appModule(new AppModule(new ApplicationMonitor(this))).modelModule(new ModelModule(new FriendsModel(this), new FriendRequestModel(), new ProfileModel(), new NewestMessageModel(), new UnseenConversationModel(), new SettingsModel(), new SuggestedFriendsModel(), new PushNotificationModel())).build();
  }
  
  private Tracker getTracker()
  {
    try
    {
      Tracker localTracker = GoogleAnalytics.getInstance(this).newTracker("UA-50249600-35");
      return localTracker;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    MultiDex.install(this);
  }
  
  public Tracker getDefaultTracker()
  {
    if (this.tracker == null) {
      this.tracker = getTracker();
    }
    return this.tracker;
  }
  
  public MessengerComponent getModelComponent()
  {
    return this.modelComponent;
  }
  
  protected void initializeLibraries()
  {
    Fabric.with(this, new Kit[] { new Crashlytics() });
    Telemetry.initialize(this);
    ConnectivityListener.initialize(this);
  }
  
  public void onCreate()
  {
    super.onCreate();
    initializeLibraries();
    Telemetry.programStarted();
    NotificationUtils.setNotificationCategories(this);
    this.modelComponent = createModelComponent();
    MessengerProvider.getInstance().initialize(this);
  }
  
  public void onTerminate()
  {
    Telemetry.programFinished();
    terminateLibraries();
    super.onTerminate();
  }
  
  protected void terminateLibraries()
  {
    Telemetry.terminate();
    MessengerProvider.getInstance().terminate();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/application/MessengerApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */