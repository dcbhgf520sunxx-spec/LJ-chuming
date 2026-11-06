package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum QhseStatusEnum {
   UN_RECTIFIED(1, "未整改"),
   RECTIFIED(2, "已整改"),
   ADOPT(4, "整改通过"),
   UN_ADOPT(8, "整改未通过");

   private int type;
   private String name;

   QhseStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<QhseStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
