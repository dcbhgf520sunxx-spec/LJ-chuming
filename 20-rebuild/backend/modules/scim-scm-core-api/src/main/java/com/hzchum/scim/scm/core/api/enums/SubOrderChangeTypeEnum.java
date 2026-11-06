package com.hzchum.scim.scm.core.api.enums;

import java.util.Arrays;

public enum SubOrderChangeTypeEnum {
   ADD(1, "新增"),
   UPDATE(2, "修改"),
   DEL(4, "删除");

   private final Integer type;
   private final String name;

   public static boolean boolExist(Integer type) {
      return Arrays.stream(values()).anyMatch(em -> em.getType().equals(type));
   }

   SubOrderChangeTypeEnum(final Integer type, final String name) {
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
