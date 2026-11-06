package com.hzchum.scim.plan.core.api.enums;

public enum ArtifactProcessTypeEnum {
   WELDING(1, "焊接工艺"),
   ASSEMBLY(2, "装配工艺"),
   COATING(4, "涂装工艺");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ArtifactProcessTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
