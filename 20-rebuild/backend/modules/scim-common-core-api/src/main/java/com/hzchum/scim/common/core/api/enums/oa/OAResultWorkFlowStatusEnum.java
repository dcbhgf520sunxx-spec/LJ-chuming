package com.hzchum.scim.common.core.api.enums.oa;

public enum OAResultWorkFlowStatusEnum {
   PASS("1", "通过"),
   REJECT("2", "驳回");

   private String type;
   private String name;

   OAResultWorkFlowStatusEnum(String type, String name) {
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
