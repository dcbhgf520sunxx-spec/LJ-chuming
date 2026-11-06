package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;

public enum HandleStatusEnum {
   UN(1, "未处理"),
   PASS(2, "处理通过"),
   REJECT(4, "处理驳回");

   private final Integer type;
   private final String name;

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(s -> s.type.equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   HandleStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
