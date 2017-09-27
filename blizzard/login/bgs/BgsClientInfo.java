package com.blizzard.login.bgs;

import com.blizzard.bgs.client.service.authentication.message.v1.LogonResult;
import java.util.Map;

public abstract interface BgsClientInfo
{
  public abstract Map<String, String> getClientResponse();
  
  public abstract LogonResult getUserProperties();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/bgs/BgsClientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */