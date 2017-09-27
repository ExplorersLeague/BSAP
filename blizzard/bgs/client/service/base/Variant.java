package com.blizzard.bgs.client.service.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;

public class Variant
{
  @Expose
  @SerializedName("blob_value")
  private String blobValue;
  @Expose
  @SerializedName("bool_value")
  private Boolean booleanValue;
  @Expose
  @SerializedName("entity_id_value")
  private EntityId entityIdValue;
  @Expose
  @SerializedName("float_value")
  private Float floatValue;
  @Expose
  @SerializedName("fourcc_value")
  private String fourccValue;
  @Expose
  @SerializedName("int_value")
  private Long longValue;
  @Expose
  @SerializedName("message_value")
  private String messageValue;
  @Expose
  @SerializedName("string_value")
  private String stringValue;
  @Expose
  @SerializedName("uint_value")
  private BigInteger ulongValue;
  
  public static Variant fromBlob(String paramString)
  {
    Variant localVariant = new Variant();
    localVariant.blobValue = paramString;
    return localVariant;
  }
  
  public static Variant fromBoolean(Boolean paramBoolean)
  {
    Variant localVariant = new Variant();
    localVariant.booleanValue = paramBoolean;
    return localVariant;
  }
  
  public static Variant fromEntityId(EntityId paramEntityId)
  {
    Variant localVariant = new Variant();
    localVariant.entityIdValue = paramEntityId;
    return localVariant;
  }
  
  public static Variant fromFloat(Float paramFloat)
  {
    Variant localVariant = new Variant();
    localVariant.floatValue = paramFloat;
    return localVariant;
  }
  
  public static Variant fromFourcc(String paramString)
  {
    Variant localVariant = new Variant();
    localVariant.fourccValue = paramString;
    return localVariant;
  }
  
  public static Variant fromLong(Long paramLong)
  {
    Variant localVariant = new Variant();
    localVariant.longValue = paramLong;
    return localVariant;
  }
  
  public static Variant fromMessage(String paramString)
  {
    Variant localVariant = new Variant();
    localVariant.messageValue = paramString;
    return localVariant;
  }
  
  public static Variant fromString(String paramString)
  {
    Variant localVariant = new Variant();
    localVariant.stringValue = paramString;
    return localVariant;
  }
  
  public static Variant fromUlong(BigInteger paramBigInteger)
  {
    Variant localVariant = new Variant();
    localVariant.ulongValue = paramBigInteger;
    return localVariant;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label88:
    label112:
    label136:
    label160:
    label184:
    label208:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        bool1 = bool3;
                      } while (paramObject == null);
                      bool1 = bool3;
                    } while (getClass() != paramObject.getClass());
                    paramObject = (Variant)paramObject;
                    if (this.booleanValue == null) {
                      break;
                    }
                    bool1 = bool3;
                  } while (!this.booleanValue.equals(((Variant)paramObject).booleanValue));
                  if (this.longValue == null) {
                    break label262;
                  }
                  bool1 = bool3;
                } while (!this.longValue.equals(((Variant)paramObject).longValue));
                if (this.floatValue == null) {
                  break label271;
                }
                bool1 = bool3;
              } while (!this.floatValue.equals(((Variant)paramObject).floatValue));
              if (this.stringValue == null) {
                break label280;
              }
              bool1 = bool3;
            } while (!this.stringValue.equals(((Variant)paramObject).stringValue));
            if (this.blobValue == null) {
              break label289;
            }
            bool1 = bool3;
          } while (!this.blobValue.equals(((Variant)paramObject).blobValue));
          if (this.messageValue == null) {
            break label298;
          }
          bool1 = bool3;
        } while (!this.messageValue.equals(((Variant)paramObject).messageValue));
        if (this.fourccValue == null) {
          break label307;
        }
        bool1 = bool3;
      } while (!this.fourccValue.equals(((Variant)paramObject).fourccValue));
      if (this.ulongValue == null) {
        break label316;
      }
      bool1 = bool3;
    } while (!this.ulongValue.equals(((Variant)paramObject).ulongValue));
    label232:
    if (this.entityIdValue != null) {
      bool1 = this.entityIdValue.equals(((Variant)paramObject).entityIdValue);
    }
    for (;;)
    {
      return bool1;
      if (((Variant)paramObject).booleanValue == null) {
        break;
      }
      return false;
      label262:
      if (((Variant)paramObject).longValue == null) {
        break label88;
      }
      return false;
      label271:
      if (((Variant)paramObject).floatValue == null) {
        break label112;
      }
      return false;
      label280:
      if (((Variant)paramObject).stringValue == null) {
        break label136;
      }
      return false;
      label289:
      if (((Variant)paramObject).blobValue == null) {
        break label160;
      }
      return false;
      label298:
      if (((Variant)paramObject).messageValue == null) {
        break label184;
      }
      return false;
      label307:
      if (((Variant)paramObject).fourccValue == null) {
        break label208;
      }
      return false;
      label316:
      if (((Variant)paramObject).ulongValue == null) {
        break label232;
      }
      return false;
      bool1 = bool2;
      if (((Variant)paramObject).entityIdValue != null) {
        bool1 = false;
      }
    }
  }
  
  public String getBlobValue()
  {
    return this.blobValue;
  }
  
  public Boolean getBooleanValue()
  {
    return this.booleanValue;
  }
  
  public EntityId getEntityIdValue()
  {
    return this.entityIdValue;
  }
  
  public Float getFloatValue()
  {
    return this.floatValue;
  }
  
  public String getFourccValue()
  {
    return this.fourccValue;
  }
  
  public Long getLongValue()
  {
    return this.longValue;
  }
  
  public String getMessageValue()
  {
    return this.messageValue;
  }
  
  public String getStringValue()
  {
    return this.stringValue;
  }
  
  public BigInteger getUlongValue()
  {
    return this.ulongValue;
  }
  
  public int hashCode()
  {
    int i4 = 0;
    int i;
    int j;
    label33:
    int k;
    label48:
    int m;
    label64:
    int n;
    label80:
    int i1;
    label96:
    int i2;
    if (this.booleanValue != null)
    {
      i = this.booleanValue.hashCode();
      if (this.longValue == null) {
        break label197;
      }
      j = this.longValue.hashCode();
      if (this.floatValue == null) {
        break label202;
      }
      k = this.floatValue.hashCode();
      if (this.stringValue == null) {
        break label207;
      }
      m = this.stringValue.hashCode();
      if (this.blobValue == null) {
        break label213;
      }
      n = this.blobValue.hashCode();
      if (this.messageValue == null) {
        break label219;
      }
      i1 = this.messageValue.hashCode();
      if (this.fourccValue == null) {
        break label225;
      }
      i2 = this.fourccValue.hashCode();
      label112:
      if (this.ulongValue == null) {
        break label231;
      }
    }
    label197:
    label202:
    label207:
    label213:
    label219:
    label225:
    label231:
    for (int i3 = this.ulongValue.hashCode();; i3 = 0)
    {
      if (this.entityIdValue != null) {
        i4 = this.entityIdValue.hashCode();
      }
      return (((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4;
      i = 0;
      break;
      j = 0;
      break label33;
      k = 0;
      break label48;
      m = 0;
      break label64;
      n = 0;
      break label80;
      i1 = 0;
      break label96;
      i2 = 0;
      break label112;
    }
  }
  
  public String toString()
  {
    if (this.booleanValue != null) {
      return this.booleanValue.toString();
    }
    if (this.longValue != null) {
      return this.longValue.toString();
    }
    if (this.floatValue != null) {
      return this.floatValue.toString();
    }
    if (this.stringValue != null) {
      return this.stringValue;
    }
    if (this.blobValue != null) {
      return this.blobValue;
    }
    if (this.messageValue != null) {
      return this.messageValue;
    }
    if (this.fourccValue != null) {
      return this.fourccValue;
    }
    if (this.ulongValue != null) {
      return this.ulongValue.toString();
    }
    if (this.entityIdValue != null) {
      return this.entityIdValue.toString();
    }
    return "(null)";
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/service/base/Variant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */