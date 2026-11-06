package com.hzchum.scim.contract.core.api.enums.finance;

public enum WmsBasicClassEnum {
   MAIN_MATERIAL(7, "主材"),
   GENERAL_MATERIAL(8, "生产辅材"),
   GAS(16, "气体");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   WmsBasicClassEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
