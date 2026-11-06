package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum QhseSimpleStatusEnum {
   TO_BE_INSPECTED(1, "待质检"),
   TO_BE_RECTIFIED(2, "待整改"),
   PASSED(4, "通过"),
   CONCESSION_ACCEPTED(8, "让步接收");

   private int type;
   private String name;

   QhseSimpleStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<QhseStatusEnum> optional = Arrays.stream(QhseStatusEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
