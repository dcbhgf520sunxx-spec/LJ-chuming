package com.hzchum.scim.contract.core.api.enums;

public enum InfoSourceEnum {
   SALESMAN_WITH_MANAGER(1, "销售员信息项目经理配合"),
   MANAGER_WITH_SALESMAN(2, "项目经理信息销售员配合"),
   SALESMAN(3, "销售员信息");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (InfoSourceEnum infoSourceEnum : values()) {
         if (infoSourceEnum.getType().equals(type)) {
            return infoSourceEnum.name;
         }
      }

      return null;
   }

   InfoSourceEnum(final Integer type, final String name) {
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
