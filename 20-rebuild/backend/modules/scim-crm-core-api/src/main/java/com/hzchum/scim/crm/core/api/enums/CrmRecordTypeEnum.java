package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmRecordTypeEnum {
   UN_RECORD(1, "未认领"),
   RECORD(2, "已认领");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmRecordTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmRecordTypeEnum(final Integer type, final String name) {
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
