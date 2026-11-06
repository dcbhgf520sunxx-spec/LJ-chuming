package com.hzchum.scim.crm.core.api.enums;

public enum CrmPersonTemplateEnum {
   BIDDING_METHOD_HEAD(1, "商务标负责人"),
   SETTLEMENT_METHOD_HEAD(2, "技术标负责人"),
   STRUCTURAL_DESIGN_TARGET_HEAD(4, "结构设计标负责人"),
   DEPTH_DESIGN_TARGET_HEAD(5, "深度设计标负责人"),
   SPECIAL_SCHEME_RECEIVER(6, "专项方案接收人");

   private final Integer type;
   private final String name;
   public static final Integer[] VALUES = new Integer[]{
      BIDDING_METHOD_HEAD.getType(),
      SETTLEMENT_METHOD_HEAD.getType(),
      STRUCTURAL_DESIGN_TARGET_HEAD.getType(),
      DEPTH_DESIGN_TARGET_HEAD.getType(),
      SPECIAL_SCHEME_RECEIVER.getType()
   };

   CrmPersonTemplateEnum(final Integer type, final String name) {
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
