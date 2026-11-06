package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AbnormalTypeEnum {
   TASK_ABNORMAL(1, "排产异常"),
   PRODUCTION_ABNORMAL(2, "生产异常"),
   MACHINE_PART_EDITING(4, "零件编辑");

   private final int type;
   private String name;

   AbnormalTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<AbnormalTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
