package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmProjectBidStatusEnum {
   NOT_APPOINTED(1, "未任命"),
   ONGOING(2, "进行中"),
   DONE(3, "已完成"),
   PAUSE(4, "已暂停");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmProjectBidStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmProjectBidStatusEnum(final Integer type, final String name) {
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
