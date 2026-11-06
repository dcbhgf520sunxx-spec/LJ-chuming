package com.hzchum.scim.contract.core.api.enums;

public enum ProjectBoolArrearsEnum {
   TRUE(true, "欠款"),
   FALSE(false, "不欠款");

   private final Boolean type;
   private final String name;

   ProjectBoolArrearsEnum(final Boolean type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Boolean getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
