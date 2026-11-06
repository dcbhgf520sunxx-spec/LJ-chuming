package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MesEnclosureTypesettingStatusEnum {
   UNCONFIRMED(1, "待确认"),
   COMPLETE(2, "套料完成"),
   EXPIRED(4, "已过期"),
   ISSUED(8, "已下发"),
   PRODUCTION(16, "生产中"),
   FINISHED(32, "已完成");

   private Integer type;
   private String name;

   MesEnclosureTypesettingStatusEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<MesEnclosureTypesettingStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static Integer getTypeToNoIssued() {
      return UNCONFIRMED.getType() | COMPLETE.getType() | EXPIRED.getType();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
