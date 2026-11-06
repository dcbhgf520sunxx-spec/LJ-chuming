package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum OutStaffStatusEnum {
   WAIT_AUDIT(1, "待审核"),
   PASS(2, "审核通过"),
   UN_PASS(4, "审核不通过");

   private int type;
   private String name;

   OutStaffStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<OutStaffStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
