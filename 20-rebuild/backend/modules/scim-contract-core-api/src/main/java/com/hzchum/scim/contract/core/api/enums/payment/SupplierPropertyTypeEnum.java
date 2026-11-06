package com.hzchum.scim.contract.core.api.enums.payment;

public enum SupplierPropertyTypeEnum {
   MATERIAL_PURCHASE_FEE(1, "原材料-采购费"),
   TRANSPORT_FEE(2, "物流-运输费"),
   PURCHASE_FEE(4, "制成品-采购费"),
   SUB_FEE(8, "分包费"),
   RECYCLE_FINISHED_FEE(16, "制成品回收费");

   private final Integer type;
   private final String name;

   public static Boolean isExist(Integer type) {
      for (SupplierPropertyTypeEnum supplierPropertyTypeEnum : values()) {
         if (supplierPropertyTypeEnum.getType().equals(type)) {
            return true;
         }
      }

      return false;
   }

   public static String getNameByType(Integer type) {
      SupplierPropertyTypeEnum[] values = values();

      for (SupplierPropertyTypeEnum propertyEnum : values) {
         if (propertyEnum.getType().equals(type)) {
            return propertyEnum.getName();
         }
      }

      return null;
   }

   SupplierPropertyTypeEnum(final Integer type, final String name) {
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
