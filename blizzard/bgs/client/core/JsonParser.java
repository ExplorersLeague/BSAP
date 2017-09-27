package com.blizzard.bgs.client.core;

import com.blizzard.bgs.client.exception.InvalidBgsMessageException;
import com.blizzard.bgs.client.websocket.WebSocketMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import okio.ByteString;

public class JsonParser
{
  private static final Gson gson = new GsonBuilder().disableHtmlEscaping().excludeFieldsWithoutExposeAnnotation().registerTypeAdapterFactory(new RequiredTypeAdapterFactory()).create();
  private static final com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
  
  public static Gson getGson()
  {
    return gson;
  }
  
  public static com.google.gson.JsonParser getJsonParser()
  {
    return jsonParser;
  }
  
  public static JsonObject[] toJsonObjects(WebSocketMessage paramWebSocketMessage)
  {
    return toJsonObjects(toJsonString(paramWebSocketMessage));
  }
  
  public static JsonObject[] toJsonObjects(String paramString)
  {
    try
    {
      JsonArray localJsonArray = jsonParser.parse(paramString).getAsJsonArray();
      if (localJsonArray.size() < 1) {
        throw new InvalidBgsMessageException(paramString);
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new InvalidBgsMessageException("invalid JSON: " + paramString);
      JsonObject localJsonObject2 = localIllegalStateException.get(0).getAsJsonObject();
      JsonObject localJsonObject1;
      if (localIllegalStateException.size() >= 2) {
        localJsonObject1 = localIllegalStateException.get(1).getAsJsonObject();
      }
      for (paramString = localJsonObject1;; paramString = null) {
        return new JsonObject[] { localJsonObject2, paramString };
      }
    }
    catch (JsonParseException localJsonParseException)
    {
      for (;;) {}
    }
  }
  
  public static String toJsonString(WebSocketMessage paramWebSocketMessage)
  {
    String str = paramWebSocketMessage.getText();
    if (str != null) {
      return str;
    }
    paramWebSocketMessage = paramWebSocketMessage.getBinary();
    if (paramWebSocketMessage != null) {
      return paramWebSocketMessage.utf8();
    }
    throw new InvalidBgsMessageException("null message");
  }
  
  public static String toJsonString(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      throw new IllegalArgumentException("null BGS RPC header");
    }
    paramObject1 = gson.toJson(paramObject1);
    if (paramObject2 == null) {
      return "[" + (String)paramObject1 + "]";
    }
    paramObject2 = gson.toJson(paramObject2);
    return "[" + (String)paramObject1 + ", " + (String)paramObject2 + "]";
  }
  
  public static <T> T toObject(JsonObject paramJsonObject, Class<T> paramClass)
  {
    try
    {
      Object localObject = gson.fromJson(paramJsonObject, paramClass);
      return (T)localObject;
    }
    catch (JsonParseException localJsonParseException)
    {
      throw new InvalidBgsMessageException("JSON does not represent class " + paramClass.getName() + ": " + paramJsonObject);
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/bgs/client/core/JsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */