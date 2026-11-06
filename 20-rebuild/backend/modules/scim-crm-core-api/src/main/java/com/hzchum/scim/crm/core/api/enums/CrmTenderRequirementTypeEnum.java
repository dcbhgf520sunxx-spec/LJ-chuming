package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmTenderRequirementTypeEnum {
   BIDDING_METHOD(1, "商务标"),
   SETTLEMENT_METHOD(2, "技术标"),
   TYPE_OF_PERFORMANCE_BOND(3, "设计标"),
   STRUCTURAL_DESIGN_TARGET(4, "结构设计标"),
   DEEPENING_THE_DESIGN_STANDARD(5, "深化设计标");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmTenderRequirementTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmTenderRequirementTypeEnum(final Integer type, final String name) {
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
