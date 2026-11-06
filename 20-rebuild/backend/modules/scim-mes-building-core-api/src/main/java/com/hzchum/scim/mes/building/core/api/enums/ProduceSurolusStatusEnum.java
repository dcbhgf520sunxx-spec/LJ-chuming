package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProduceSurolusStatusEnum {
   UN_RECTIFIED(1, "未处理"),
   SCRAP(2, "已整改"),
   SECONDARY_UTILIZATION(4, "二次利用");

   private int type;
   private String name;

   ProduceSurolusStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ProduceSurolusStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
