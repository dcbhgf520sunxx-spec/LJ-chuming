package com.hzchum.scim.contract.core.api.common;

import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapConstants {
   private static final ConcurrentMap<Long, ContractProject> PROJECT_MAP = new ConcurrentHashMap<>();
   private static final ConcurrentMap<String, String> STRING_CONSTANTS_MAP = new ConcurrentHashMap<>();

   private MapConstants() {
   }

   public static ConcurrentMap<Long, ContractProject> getProjectMap() {
      return PROJECT_MAP;
   }

   public static ConcurrentMap<String, String> getStringConstantsMap() {
      return STRING_CONSTANTS_MAP;
   }
}
