package com.hzchum.scim.contract.core.api.enums.logistics;

public enum LogisticsTypeEnum {
   RAW_MATERIALS(1),
   MANUFACTURES(2),
   LOGISTICS(4),
   person(8);

   private final Integer type;

   public static Boolean isExist(Integer type) {
      if (type == null) {
         return Boolean.FALSE;
      }

      for (LogisticsTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   LogisticsTypeEnum(final Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
