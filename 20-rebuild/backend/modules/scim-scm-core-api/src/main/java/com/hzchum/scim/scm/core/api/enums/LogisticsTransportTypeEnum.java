package com.hzchum.scim.scm.core.api.enums;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum LogisticsTransportTypeEnum {
   FREIGHT(1, "货运"),
   POST(2, "邮递");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   LogisticsTransportTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<LogisticsTransportTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      switch (type) {
         case 1:
            return FREIGHT.getName();
         case 2:
            return POST.getName();
         default:
            throw new BusinessException("当前运输方式错误");
      }
   }
}
