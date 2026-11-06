package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AbnormalStatusTypeEnum {
   PENDING(1, "待处理"),
   PROCESSING(2, "处理中"),
   PROCESSING_COMPLETE(4, "处理完成"),
   CANCEL(8, "已取消");

   private final int type;
   private String name;

   AbnormalStatusTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<AbnormalStatusTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
