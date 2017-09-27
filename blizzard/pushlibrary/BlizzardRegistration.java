package com.blizzard.pushlibrary;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.blizzard.pushlibrary.rest.BlizzardPushApiService;
import com.blizzard.pushlibrary.rest.model.Authentication;
import com.blizzard.pushlibrary.rest.model.RegisterRequestBody;
import com.blizzard.pushlibrary.rest.model.RegisterResponse;
import java.io.IOException;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class BlizzardRegistration
{
  private static final String REGISTRATION_SERVER_BASE_URL = "https://us.battle.net";
  private final String TAG = BlizzardRegistration.class.getSimpleName();
  Context context;
  String platform;
  PushConfig pushConfig;
  RegisterRequestBody registerRequestBody;
  String registrationId;
  Retrofit retrofit;
  BlizzardPushApiService service;
  
  public BlizzardRegistration(Context paramContext, String paramString1, String paramString2, Authentication paramAuthentication) {}
  
  public BlizzardRegistration(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.context = paramContext;
    this.platform = paramString1;
    this.registrationId = paramString2;
    this.pushConfig = BlizzardPush.getPushConfigFromPreferences(paramContext);
    paramContext = new HttpLoggingInterceptor();
    paramContext.setLevel(HttpLoggingInterceptor.Level.BASIC);
    paramContext = new OkHttpClient.Builder().addInterceptor(paramContext).build();
    this.retrofit = new Retrofit.Builder().baseUrl("https://us.battle.net").client(paramContext).addConverterFactory(GsonConverterFactory.create()).build();
    this.service = ((BlizzardPushApiService)this.retrofit.create(BlizzardPushApiService.class));
    this.registerRequestBody = new RegisterRequestBody(this.pushConfig.getSNSAppName(), paramString1, paramString2, this.pushConfig.getRegion(), this.pushConfig.getLocale(), paramString3, paramString4, this.pushConfig.getAppAccountId());
  }
  
  private void sendRegistrationToBlizzardAsync()
  {
    if (BuildConfig.DEBUG) {
      Log.d(this.TAG, "Sending to BPNS asynchronously");
    }
    this.service.register(this.registerRequestBody, new Callback()
    {
      public void onFailure(Call<RegisterResponse> paramAnonymousCall, Throwable paramAnonymousThrowable)
      {
        BlizzardRegistration.this.handleFailureResponse(paramAnonymousThrowable);
      }
      
      public void onResponse(Call<RegisterResponse> paramAnonymousCall, Response<RegisterResponse> paramAnonymousResponse)
      {
        BlizzardRegistration.this.handleSuccessResponse((RegisterResponse)paramAnonymousResponse.body());
      }
    });
  }
  
  private void sendRegistrationToBlizzardSync()
  {
    if (BuildConfig.DEBUG) {
      Log.d(this.TAG, "Sending to BPNS synchronously");
    }
    Call localCall = this.service.register(this.registerRequestBody);
    try
    {
      handleSuccessResponse((RegisterResponse)localCall.execute().body());
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  protected void handleFailureResponse(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      BlizzardPush.latchNeedBPNSSync(this.context);
      Log.e(this.TAG, "API/Network error: " + paramThrowable.getMessage());
    }
  }
  
  protected void handleSuccessResponse(RegisterResponse paramRegisterResponse)
  {
    if ((paramRegisterResponse != null) && (paramRegisterResponse.error == null))
    {
      paramRegisterResponse = new BnetAccount(paramRegisterResponse.accountRegion, paramRegisterResponse.accountId);
      BlizzardPush.handleBnetAccountChange(this.context, paramRegisterResponse);
      BlizzardPush.clearNeedBPNSSync(this.context);
      return;
    }
    BlizzardPush.latchNeedBPNSSync(this.context);
    Log.e(this.TAG, "API error");
  }
  
  protected boolean isBPNSOverride()
  {
    return (this.pushConfig == null) || (TextUtils.isEmpty(this.pushConfig.getSNSAppName()));
  }
  
  public void sendRegistrationToBlizzard()
  {
    if (isBPNSOverride())
    {
      BlizzardPush.clearNeedBPNSSync(this.context);
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      sendRegistrationToBlizzardAsync();
      return;
    }
    sendRegistrationToBlizzardSync();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/BlizzardRegistration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */