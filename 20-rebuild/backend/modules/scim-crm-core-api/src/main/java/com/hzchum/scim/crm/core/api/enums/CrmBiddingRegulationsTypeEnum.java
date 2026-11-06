package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmBiddingRegulationsTypeEnum {
   CLEARLY_MARKED(1, "明标"),
   DARK_MARK(2, "暗标");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmBiddingRegulationsTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(CrmBiddingRegulationsTypeEnum::getName).orElse(null);
   }

   CrmBiddingRegulationsTypeEnum(final Integer type, final String name) {
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
