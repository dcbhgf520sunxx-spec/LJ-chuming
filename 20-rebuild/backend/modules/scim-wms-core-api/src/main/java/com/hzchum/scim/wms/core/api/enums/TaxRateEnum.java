package com.hzchum.scim.wms.core.api.enums;

public enum TaxRateEnum {
   STEEL_PLATE(1, "钢板"),
   SECTION_STEEL(2, "型材"),
   STEEL_COIL(4, "钢卷"),
   MATERIAL(8, "辅材"),
   GAS(16, "气体"),
   STRUC_MANUFACTURED(32, "成品构件"),
   ENCL_MANUFACTURED(64, "成品围护"),
   OTHER(128, "其他"),
   OTHER_STEEL(256, "其他钢材"),
   LOGISTICS(1024, "物流"),
   CONTRACT(2048, "合同");

   private final Integer type;
   private final String name;

   TaxRateEnum(Integer type, String name) {
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
