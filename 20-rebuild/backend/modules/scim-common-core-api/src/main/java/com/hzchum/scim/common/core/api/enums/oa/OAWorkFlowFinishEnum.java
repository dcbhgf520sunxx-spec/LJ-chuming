package com.hzchum.scim.common.core.api.enums.oa;

public enum OAWorkFlowFinishEnum {
   YES("0", "是"),
   NO("1", "否");

   private String type;
   private String name;

   OAWorkFlowFinishEnum(String type, String name) {
      this.type = type;
      this.name = name;
   }

   public String getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
