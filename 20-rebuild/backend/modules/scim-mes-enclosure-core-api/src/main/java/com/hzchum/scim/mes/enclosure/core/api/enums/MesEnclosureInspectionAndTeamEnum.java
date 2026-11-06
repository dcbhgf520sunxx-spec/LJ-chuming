package com.hzchum.scim.mes.enclosure.core.api.enums;

public enum MesEnclosureInspectionAndTeamEnum {
   Team(1, "班组"),
   Inspection(2, "质检");

   private Integer type;
   private String name;

   MesEnclosureInspectionAndTeamEnum(Integer type, String name) {
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
