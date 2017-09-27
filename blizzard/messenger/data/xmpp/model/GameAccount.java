package com.blizzard.messenger.data.xmpp.model;

public class GameAccount
{
  private double awayTime;
  private double lastOnline;
  private String name;
  private String richPresence;
  private double richPresenceTime;
  private int status;
  
  public double getAwayTime()
  {
    return this.awayTime;
  }
  
  public double getLastOnline()
  {
    return this.lastOnline;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getRichPresence()
  {
    return this.richPresence;
  }
  
  public double getRichPresenceTime()
  {
    return this.richPresenceTime;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setAwayTime(double paramDouble)
  {
    this.awayTime = paramDouble;
  }
  
  public void setLastOnline(double paramDouble)
  {
    this.lastOnline = paramDouble;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setRichPresence(String paramString)
  {
    this.richPresence = paramString;
  }
  
  public void setRichPresenceTime(double paramDouble)
  {
    this.richPresenceTime = paramDouble;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public String toString()
  {
    String str = "" + "Name: " + this.name;
    str = str + " Last Online: " + this.lastOnline;
    str = str + " Status: " + this.status;
    str = str + " Rich Presence: " + this.richPresence;
    str = str + " Time: " + this.richPresenceTime;
    return str + " Away Time: " + this.awayTime;
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/data/xmpp/model/GameAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */