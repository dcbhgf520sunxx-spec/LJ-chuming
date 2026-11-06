package com.hzchum.scim.mes.building.core.api.enums;

public enum TeamOrgTypeEnum {
   TEAM_OUT(0, "编制外"),
   TEAM_IN(1, "编制内");

   private Integer type;
   private String name;

   TeamOrgTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
