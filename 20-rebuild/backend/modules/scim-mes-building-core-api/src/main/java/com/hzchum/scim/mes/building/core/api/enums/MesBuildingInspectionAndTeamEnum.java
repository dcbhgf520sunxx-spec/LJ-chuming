package com.hzchum.scim.mes.building.core.api.enums;

public enum MesBuildingInspectionAndTeamEnum {
   Team(1, "班组"),
   Inspection(2, "质检");

   private Integer type;
   private String name;

   MesBuildingInspectionAndTeamEnum(Integer type, String name) {
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
