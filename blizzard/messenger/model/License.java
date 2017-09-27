package com.blizzard.messenger.model;

public class License
{
  private final String libraryAuthor;
  private final String libraryName;
  private final String licenseType;
  
  public License(String paramString1, String paramString2, String paramString3)
  {
    this.libraryName = paramString1;
    this.libraryAuthor = paramString2;
    this.licenseType = paramString3;
  }
  
  public String getLibraryAuthor()
  {
    return this.libraryAuthor;
  }
  
  public String getLibraryName()
  {
    return this.libraryName;
  }
  
  public String getLicenseType()
  {
    return this.licenseType;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/model/License.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */