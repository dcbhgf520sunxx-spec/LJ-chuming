package com.hzchum.scim.contract.core.api.enums;

public enum ProjectAddressTypeEnum {
   PROJECT_ADDRESS(1, "项目地址"),
   CUSTOMER_ADDRESS(2, "客户单位地址");

   private Integer type;
   private String name;

   public static Boolean isExist(Integer type) {
      for (ProjectAddressTypeEnum addressTypeEnum : values()) {
         if (addressTypeEnum.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProjectAddressTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
