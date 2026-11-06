package com.hzchum.scim.business.core.api.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PricingUnitTypeEnum {
   KG(1, "千克", NewPricingMannerEnum.WEIGHT.getType()),
   DUN(2, "吨", NewPricingMannerEnum.WEIGHT.getType()),
   METRE(4, "米", NewPricingMannerEnum.LENGTH.getType()),
   SQUARE_METER(8, "平方米", NewPricingMannerEnum.AREA.getType()),
   JIAN(16, "件", NewPricingMannerEnum.QUANTITY.getType()),
   ZHANG(32, "张", NewPricingMannerEnum.QUANTITY.getType());

   private final Integer type;
   private final String name;
   private final Integer newPricingMannerEnum;

   public static String getNameByType(Integer type) {
      PricingUnitTypeEnum pricingUnitTypeEnum = Arrays.stream(values()).filter(e -> e.getType().equals(type)).findFirst().orElse(null);
      return pricingUnitTypeEnum != null ? pricingUnitTypeEnum.getName() : null;
   }

   public static List<Integer> listUnitTypeByPricingMannerEnum(Integer newPricingMannerEnum) {
      return Arrays.stream(values())
         .filter(em -> em.getNewPricingMannerEnum().equals(newPricingMannerEnum))
         .map(PricingUnitTypeEnum::getType)
         .collect(Collectors.toList());
   }

   PricingUnitTypeEnum(final Integer type, final String name, final Integer newPricingMannerEnum) {
      this.type = type;
      this.name = name;
      this.newPricingMannerEnum = newPricingMannerEnum;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public Integer getNewPricingMannerEnum() {
      return this.newPricingMannerEnum;
   }
}
