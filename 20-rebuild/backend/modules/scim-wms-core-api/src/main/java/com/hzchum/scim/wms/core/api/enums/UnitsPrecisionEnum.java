package com.hzchum.scim.wms.core.api.enums;

import java.math.BigDecimal;

public enum UnitsPrecisionEnum {
   LG_KM("千米", new BigDecimal("1000000")),
   LG_M("米", new BigDecimal("1000")),
   LG_DM("分米", new BigDecimal("100")),
   LG_CM("厘米", new BigDecimal("10")),
   LG_MM("毫米", new BigDecimal("1")),
   EG_T("吨", new BigDecimal("1000000")),
   EG_KG("千克", new BigDecimal("1000")),
   EG_G("克", new BigDecimal("1")),
   AG_KM("平方千米", new BigDecimal("1000000000000")),
   AG_HM("公顷", new BigDecimal("10000000000")),
   AG_M("平方米", new BigDecimal("1000000")),
   AG_DM("平方分米", new BigDecimal("10000")),
   AG_CM("平方厘米", new BigDecimal("100")),
   AG_MM("平方毫米", new BigDecimal("1")),
   VG_M("立方米", new BigDecimal("1000000000")),
   VG_DM("立方分米", new BigDecimal("1000000")),
   VG_CM("立方厘米", new BigDecimal("1000")),
   VG_MM("立方毫米", new BigDecimal("1")),
   L("升", new BigDecimal("1000000")),
   DL("分升", new BigDecimal("10000")),
   CL("厘升", new BigDecimal("1000")),
   ML("毫升", new BigDecimal("100")),
   MIL("微升", new BigDecimal("1"));

   private final String name;
   private final BigDecimal rate;

   UnitsPrecisionEnum(String name, BigDecimal rate) {
      this.name = name;
      this.rate = rate;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   public String getName() {
      return this.name;
   }

   public static BigDecimal getByName(String name) {
      BigDecimal values = null;

      for (UnitsPrecisionEnum value : values()) {
         if (value.getName().equals(name)) {
            values = value.getRate();
         }
      }

      return values == null ? BigDecimal.ONE : values;
   }
}
