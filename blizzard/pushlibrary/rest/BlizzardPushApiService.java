package com.blizzard.pushlibrary.rest;

import com.blizzard.pushlibrary.rest.model.LogoutRequestBody;
import com.blizzard.pushlibrary.rest.model.LogoutResponse;
import com.blizzard.pushlibrary.rest.model.RegisterRequestBody;
import com.blizzard.pushlibrary.rest.model.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public abstract interface BlizzardPushApiService
{
  @Headers({"Accept: application/json"})
  @POST("/push/pub/logout")
  public abstract void logout(@Body LogoutRequestBody paramLogoutRequestBody, Callback<LogoutResponse> paramCallback);
  
  @Headers({"Accept: application/json"})
  @POST("/push/pub/register")
  public abstract Call<RegisterResponse> register(@Body RegisterRequestBody paramRegisterRequestBody);
  
  @Headers({"Accept: application/json"})
  @POST("/push/pub/register")
  public abstract void register(@Body RegisterRequestBody paramRegisterRequestBody, Callback<RegisterResponse> paramCallback);
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/pushlibrary/rest/BlizzardPushApiService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */