package com.hzchum.scim.plan.core.api.enums;

public enum ProjectPlanProductCategoryEnum {
   ARTIFACT(2, "结构制品"),
   ENCLOSURE(4, "围护制品"),
   ACCESSORY(8, "配套制品");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProjectPlanProductCategoryEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
