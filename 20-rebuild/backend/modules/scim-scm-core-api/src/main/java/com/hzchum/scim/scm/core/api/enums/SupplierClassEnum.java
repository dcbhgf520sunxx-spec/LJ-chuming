package com.hzchum.scim.scm.core.api.enums;

import java.util.ArrayList;
import java.util.List;

public enum SupplierClassEnum {
   STEEL_PATE(1, "钢板"),
   SECTION_STEEL(2, "型材"),
   STEEL_COIL(4, "钢卷"),
   MATERIAL(8, "辅材"),
   GAS(16, "气体"),
   STRUC_MANUFACTURED(32, "结构制品"),
   ENCL_MANUFACTURED(64, "围护制品"),
   OTHER(128, "办公用品"),
   OTHER_STEEL_MATERIALS(256, "其它钢材"),
   AUX_MANUFACTURED(512, "配套制品"),
   LOGISTICS(1024, "物流"),
   PRO_SUB(32768, "专业分包"),
   LABOR_SUB(65536, "劳务分包"),
   CONSTRUCTION(131072, "施工措施"),
   QUALITY_TEST(262144, "质量检测"),
   RENTAL_SERVICE(524288, "租赁服务");

   private final Integer type;
   private final String name;

   SupplierClassEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static Boolean checkMaterial(Integer value) {
      return (
            STEEL_PATE.getType() & value
               | STEEL_COIL.getType() & value
               | SECTION_STEEL.getType() & value
               | MATERIAL.getType() & value
               | GAS.getType() & value
               | OTHER_STEEL_MATERIALS.getType() & value
         )
         != 0;
   }

   public static Boolean checkManufactured(Integer value) {
      return (STRUC_MANUFACTURED.getType() & value | ENCL_MANUFACTURED.getType() & value) != 0;
   }

   public static Boolean checkPurchaseSupplier(Integer type) {
      return checkMaterial(type) || checkManufactured(type);
   }

   public static Boolean checkSubSupplier(Integer type) {
      Integer subClass = PRO_SUB.getType() | LABOR_SUB.getType() | CONSTRUCTION.getType() | QUALITY_TEST.getType() | RENTAL_SERVICE.getType();
      return (type & subClass) > 0;
   }

   public static List<String> getAllName() {
      List<String> list = new ArrayList<>();

      for (SupplierClassEnum e : values()) {
         list.add(e.getName());
      }

      return list;
   }

   public static Integer getTypeByName(String name) {
      SupplierClassEnum[] enums = values();

      for (SupplierClassEnum anEnum : enums) {
         if (anEnum.getName().equals(name)) {
            return anEnum.getType();
         }
      }

      return 0;
   }
}
