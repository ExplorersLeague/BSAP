package com.blizzard.login.config;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blizzard.login.R.color;
import com.blizzard.login.R.layout;
import com.blizzard.login.R.string;

public class LoginUIConfig
  implements Parcelable
{
  public static final Parcelable.Creator<LoginUIConfig> CREATOR = new Parcelable.Creator()
  {
    public LoginUIConfig createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LoginUIConfig(paramAnonymousParcel, null);
    }
    
    public LoginUIConfig[] newArray(int paramAnonymousInt)
    {
      return new LoginUIConfig[paramAnonymousInt];
    }
  };
  private int actionBarTextColor;
  private int actionBarTitle;
  private String appPackageName;
  private int background;
  private int colorPrimary;
  private int colorPrimaryDark;
  private int errorLayout;
  private int loadingLayout;
  private Context resourceContext;
  
  private LoginUIConfig(Parcel paramParcel)
  {
    this.appPackageName = paramParcel.readString();
    this.actionBarTextColor = paramParcel.readInt();
    this.colorPrimary = paramParcel.readInt();
    this.colorPrimaryDark = paramParcel.readInt();
    this.actionBarTitle = paramParcel.readInt();
    this.background = paramParcel.readInt();
    this.errorLayout = paramParcel.readInt();
    this.loadingLayout = paramParcel.readInt();
  }
  
  private LoginUIConfig(Builder paramBuilder)
  {
    this.appPackageName = paramBuilder.appPackageName;
    if (paramBuilder.actionBarTextColor != 0)
    {
      this.actionBarTextColor = paramBuilder.actionBarTextColor;
      if (paramBuilder.colorPrimary == 0) {
        break label120;
      }
      this.colorPrimary = paramBuilder.colorPrimary;
      label42:
      if (paramBuilder.colorPrimaryDark == 0) {
        break label130;
      }
      this.colorPrimaryDark = paramBuilder.colorPrimaryDark;
      label57:
      if (paramBuilder.actionBarTitle == 0) {
        break label140;
      }
      this.actionBarTitle = paramBuilder.actionBarTitle;
      label72:
      this.background = paramBuilder.background;
      if (paramBuilder.errorLayout == 0) {
        break label150;
      }
    }
    label120:
    label130:
    label140:
    label150:
    for (this.errorLayout = paramBuilder.errorLayout;; this.errorLayout = R.layout.default_error_view)
    {
      if (paramBuilder.loadingLayout == 0) {
        break label160;
      }
      this.loadingLayout = paramBuilder.loadingLayout;
      return;
      this.actionBarTextColor = 17170443;
      break;
      this.colorPrimary = R.color.color_primary_blizzcon;
      break label42;
      this.colorPrimaryDark = R.color.color_primary_dark_blizzcon;
      break label57;
      this.actionBarTitle = R.string.login_default_action_bar_text;
      break label72;
    }
    label160:
    this.loadingLayout = R.layout.default_loading_view;
  }
  
  private Context getResourceContext(Context paramContext)
  {
    if (this.resourceContext == null)
    {
      if (!TextUtils.isEmpty(this.appPackageName)) {
        break label27;
      }
      this.resourceContext = paramContext;
    }
    for (;;)
    {
      return this.resourceContext;
      try
      {
        label27:
        this.resourceContext = paramContext.createPackageContext(this.appPackageName, 1);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        throw new IllegalArgumentException("Invalid package name " + this.appPackageName, paramContext);
      }
      catch (SecurityException paramContext)
      {
        throw new IllegalArgumentException("Cannot load code from package " + this.appPackageName, paramContext);
      }
    }
  }
  
  private Resources getResources(Context paramContext)
  {
    return getResourceContext(paramContext).getResources();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getActionBarTextColor(Context paramContext)
  {
    return getResources(paramContext).getColor(this.actionBarTextColor);
  }
  
  public String getActionBarTitle(Context paramContext)
  {
    return getResources(paramContext).getString(this.actionBarTitle);
  }
  
  public Drawable getBackground(Context paramContext)
  {
    if (this.background == 0) {
      return null;
    }
    return getResources(paramContext).getDrawable(this.background);
  }
  
  public int getColorPrimary(Context paramContext)
  {
    return getResources(paramContext).getColor(this.colorPrimary);
  }
  
  public int getColorPrimaryDark(Context paramContext)
  {
    return getResources(paramContext).getColor(this.colorPrimaryDark);
  }
  
  public View loadErrorLayout(Context paramContext, @NonNull ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(getResourceContext(paramContext)).inflate(this.errorLayout, paramViewGroup);
  }
  
  public View loadLoadingLayout(Context paramContext, @NonNull ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(getResourceContext(paramContext)).inflate(this.loadingLayout, paramViewGroup);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appPackageName);
    paramParcel.writeInt(this.actionBarTextColor);
    paramParcel.writeInt(this.colorPrimary);
    paramParcel.writeInt(this.colorPrimaryDark);
    paramParcel.writeInt(this.actionBarTitle);
    paramParcel.writeInt(this.background);
    paramParcel.writeInt(this.errorLayout);
    paramParcel.writeInt(this.loadingLayout);
  }
  
  public static class Builder
  {
    private int actionBarTextColor;
    private int actionBarTitle;
    private String appPackageName;
    private int background;
    private int colorPrimary;
    private int colorPrimaryDark;
    private int errorLayout;
    private int loadingLayout;
    
    public LoginUIConfig build()
    {
      return new LoginUIConfig(this, null);
    }
    
    public Builder setActionBarTextColor(@ColorRes int paramInt)
    {
      this.actionBarTextColor = paramInt;
      return this;
    }
    
    public Builder setActionBarTitle(@StringRes int paramInt)
    {
      this.actionBarTitle = paramInt;
      return this;
    }
    
    public Builder setAppPackageName(String paramString)
    {
      this.appPackageName = paramString;
      return this;
    }
    
    public Builder setBackground(@DrawableRes int paramInt)
    {
      this.background = paramInt;
      return this;
    }
    
    public Builder setColorPrimary(@ColorRes int paramInt)
    {
      this.colorPrimary = paramInt;
      return this;
    }
    
    public Builder setColorPrimaryDark(@ColorRes int paramInt)
    {
      this.colorPrimaryDark = paramInt;
      return this;
    }
    
    public Builder setErrorLayout(@LayoutRes int paramInt)
    {
      this.errorLayout = paramInt;
      return this;
    }
    
    public Builder setLoadingLayout(@LayoutRes int paramInt)
    {
      this.loadingLayout = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/login/config/LoginUIConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */