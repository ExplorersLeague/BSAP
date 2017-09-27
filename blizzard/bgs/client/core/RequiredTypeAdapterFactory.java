package com.blizzard.bgs.client.core;

import com.blizzard.bgs.client.annotation.Required;
import com.blizzard.bgs.client.exception.RequiredFieldNullException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class RequiredTypeAdapterFactory
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    new TypeAdapter()
    {
      private void validate(T paramAnonymousT)
      {
        if (paramAnonymousT != null)
        {
          Field[] arrayOfField = paramAnonymousT.getClass().getDeclaredFields();
          int j = arrayOfField.length;
          int i = 0;
          while (i < j)
          {
            Field localField = arrayOfField[i];
            if (localField.isAnnotationPresent(Required.class)) {
              validateNullField(paramAnonymousT, localField);
            }
            i += 1;
          }
        }
      }
      
      private void validateNullField(T paramAnonymousT, Field paramAnonymousField)
      {
        paramAnonymousField.setAccessible(true);
        if (paramAnonymousField.getType().isPrimitive()) {
          throw new IllegalArgumentException("Required field " + paramAnonymousField + "cannot be a primitive type");
        }
        try
        {
          paramAnonymousT = paramAnonymousField.get(paramAnonymousT);
          if (paramAnonymousT == null) {
            throw new RequiredFieldNullException("Required field " + paramAnonymousField + " is null, rejecting");
          }
        }
        catch (IllegalAccessException paramAnonymousT)
        {
          throw new IllegalArgumentException("Required field " + paramAnonymousField + " cannot be accessed", paramAnonymousT);
        }
      }
      
      public T read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        paramAnonymousJsonReader = this.val$delegate.read(paramAnonymousJsonReader);
        validate(paramAnonymousJsonReader);
        return paramAnonymousJsonReader;
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, T paramAnonymousT)
        throws IOException
      {
        validate(paramAnonymousT);
        this.val$delegate.write(paramAnonymousJsonWriter, paramAnonymousT);
      }
    };
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/RequiredTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */