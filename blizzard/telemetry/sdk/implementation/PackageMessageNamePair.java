package com.blizzard.telemetry.sdk.implementation;

public class PackageMessageNamePair
{
  private String messageName;
  private String packageName;
  
  public PackageMessageNamePair()
  {
    this.packageName = "";
    this.messageName = "";
  }
  
  public PackageMessageNamePair(String paramString1, String paramString2)
  {
    this.packageName = paramString1;
    this.messageName = paramString2;
  }
  
  public String getMessageName()
  {
    return this.messageName;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public PackageMessageNamePair setMessageName(String paramString)
  {
    this.messageName = paramString;
    return this;
  }
  
  public PackageMessageNamePair setPackageName(String paramString)
  {
    this.packageName = paramString;
    return this;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/sdk/implementation/PackageMessageNamePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */