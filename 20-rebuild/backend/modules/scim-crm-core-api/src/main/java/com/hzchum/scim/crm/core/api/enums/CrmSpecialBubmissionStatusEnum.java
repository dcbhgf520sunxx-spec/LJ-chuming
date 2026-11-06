package com.hzchum.scim.crm.core.api.enums;

public enum CrmSpecialBubmissionStatusEnum {
   SPECIAL_PROGRAMS(1, "专项方案"),
   BID_ALLOCATION(2, "投标分配"),
   CONSTRUCTION_ORGANIZATION_DESIGN(3, "施工组织设计"),
   LIVE_SUPPORT_SERVICE(4, "技术支持服务"),
   CONSTRUCTION_VERIFICATION(5, "施工验算"),
   ANIMATION_SET_EFFECT(6, "可视化"),
   TECHNOLOGY_INNOVATION(7, "科技创新");

   private final Integer type;
   private final String name;

   CrmSpecialBubmissionStatusEnum(final Integer type, final String name) {
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
