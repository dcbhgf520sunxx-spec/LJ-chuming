package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum QueryTypeEnum {
   DAY("天", "day"),
   MONTH("月", "month"),
   LAST_MONTH("上月", "last_month"),
   YEAY("年", "year");

   private final String type;
   private final String typeEn;

   public static boolean isExist(String name) {
      Optional<QueryTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(name)).findFirst();
      return optional.isPresent();
   }

   public static boolean checkName(String name) {
      for (QueryTypeEnum ele : values()) {
         if (ele.getType().equals(name)) {
            return true;
         }
      }

      return false;
   }

   public String getType() {
      return this.type;
   }

   public String getTypeEn() {
      return this.typeEn;
   }

   QueryTypeEnum(final String type, final String typeEn) {
      this.type = type;
      this.typeEn = typeEn;
   }
}
