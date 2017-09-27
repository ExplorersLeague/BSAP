package com.blizzard.telemetry.proto.standard;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public abstract interface AlertOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract String getAgent();
  
  public abstract ByteString getAgentBytes();
  
  public abstract String getConditionId();
  
  public abstract ByteString getConditionIdBytes();
  
  public abstract String getDescription();
  
  public abstract ByteString getDescriptionBytes();
  
  public abstract String getEnvironments(int paramInt);
  
  public abstract ByteString getEnvironmentsBytes(int paramInt);
  
  public abstract int getEnvironmentsCount();
  
  public abstract List<String> getEnvironmentsList();
  
  public abstract String getHostnames(int paramInt);
  
  public abstract ByteString getHostnamesBytes(int paramInt);
  
  public abstract int getHostnamesCount();
  
  public abstract List<String> getHostnamesList();
  
  public abstract String getPayload();
  
  public abstract ByteString getPayloadBytes();
  
  public abstract String getQualifier();
  
  public abstract ByteString getQualifierBytes();
  
  public abstract String getRegions(int paramInt);
  
  public abstract ByteString getRegionsBytes(int paramInt);
  
  public abstract int getRegionsCount();
  
  public abstract List<String> getRegionsList();
  
  public abstract String getServices(int paramInt);
  
  public abstract ByteString getServicesBytes(int paramInt);
  
  public abstract int getServicesCount();
  
  public abstract List<String> getServicesList();
  
  public abstract int getSeverity();
  
  public abstract String getSites(int paramInt);
  
  public abstract ByteString getSitesBytes(int paramInt);
  
  public abstract int getSitesCount();
  
  public abstract List<String> getSitesList();
  
  public abstract String getSummary();
  
  public abstract ByteString getSummaryBytes();
  
  public abstract long getTimestampUtc();
  
  public abstract boolean hasAgent();
  
  public abstract boolean hasConditionId();
  
  public abstract boolean hasDescription();
  
  public abstract boolean hasPayload();
  
  public abstract boolean hasQualifier();
  
  public abstract boolean hasSeverity();
  
  public abstract boolean hasSummary();
  
  public abstract boolean hasTimestampUtc();
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/telemetry/proto/standard/AlertOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */