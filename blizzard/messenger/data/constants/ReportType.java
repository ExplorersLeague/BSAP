package com.blizzard.messenger.data.constants;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ReportType
{
  public static final String HARASSMENT = "com.blizzard.messenger.reporttype.HARASSMENT";
  public static final String INAPPROPRIATE_NAME = "com.blizzard.messenger.reporttype.INAPPROPRIATE_NAME";
  public static final String SPAM = "com.blizzard.messenger.reporttype.SPAM";
  public final String state;
  
  public ReportType(String paramString)
  {
    this.state = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ReportMessageTypeDef {}
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/constants/ReportType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */