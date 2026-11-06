package com.hzchum.scim.plan.core.api.enums;

public enum InventoryReviewedEnum {
   FIXUP_RECORD(1, "待确认"),
   UNAUDITED(2, "未审核"),
   FAIL(4, "未通过"),
   PASSED(8, "已通过"),
   REVOKED(16, "已撤销");

   private Integer type;
   private String name;

   InventoryReviewedEnum(final Integer type, final String name) {
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
