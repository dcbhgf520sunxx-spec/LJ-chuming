package com.hzchum.scim.contract.core.api.enums.finance;

import java.util.Arrays;

public enum AmountTypeEnum {
   SECURITY_DEPOSIT(1, "保证金"),
   MANAGEMENT_COST(2, "管理费");

   private Integer type;
   private String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static String getByName(Integer type) {
      AmountTypeEnum moneyTypeEnum = Arrays.stream(values())
         .filter(e -> e.type.equals(type))
         .findFirst()
         .orElseThrow(() -> new IllegalArgumentException("没有找到匹配的元素"));
      return moneyTypeEnum.name;
   }

   AmountTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   AmountTypeEnum() {
   }
}
