package com.hzchum.scim.project.core.api.enums;

public enum SourceTypeEnum {
   SELF_SOURCE(1, "自制产品"),
   OUT_SOURCE(2, "外购产品");

   private Integer type;
   private String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SourceTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
