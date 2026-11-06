package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmCheckStatusEnum {
   PENDING(1, "待审核"),
   PASS(2, "通过"),
   FAIL(4, "不通过"),
   TEMPORARY_STORAGE(5, "暂存"),
   TO_BE_CLAIMED(6, "待领取");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmCheckStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(CrmCheckStatusEnum::getName).orElse(null);
   }

   CrmCheckStatusEnum(final Integer type, final String name) {
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
