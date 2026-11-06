package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;

public enum TaxEnum {
   NO_TAX(0, "不含税"),
   HAS_TAX(1, "含税");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      TaxEnum taxEnum = Arrays.stream(values()).filter(em -> em.getType().equals(type)).findFirst().orElse(null);
      return taxEnum != null ? taxEnum.getName() : null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   TaxEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
