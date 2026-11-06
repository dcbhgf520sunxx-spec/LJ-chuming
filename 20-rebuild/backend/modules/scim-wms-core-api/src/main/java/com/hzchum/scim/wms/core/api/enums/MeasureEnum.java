package com.hzchum.scim.wms.core.api.enums;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum MeasureEnum {
   THEORY(1, "理计"),
   POUND(2, "磅计"),
   MIXTURE(4, "混合计");

   private final Integer type;
   private final String name;

   MeasureEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static boolean isExist(Integer type) {
      Optional<MeasureEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      switch (type) {
         case 1:
            return THEORY.getName();
         case 2:
            return POUND.getName();
         case 3:
         default:
            throw new BusinessException("当前计量方式错误");
         case 4:
            return MIXTURE.getName();
      }
   }
}
