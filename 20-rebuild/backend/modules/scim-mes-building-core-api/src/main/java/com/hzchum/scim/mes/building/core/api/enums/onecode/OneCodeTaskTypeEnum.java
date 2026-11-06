package com.hzchum.scim.mes.building.core.api.enums.onecode;

import java.util.Arrays;
import java.util.Optional;

public enum OneCodeTaskTypeEnum {
   UN_SCHEDULING(1, "未排产"),
   UN_TASK(2, "未下发"),
   COMPLETE(4, "已完成"),
   PACKAGE(8, "已打包"),
   CARGOLIST(16, "已发运"),
   ALL_SEND_DIRECTLY(32, "直发檩条");

   private final int type;
   private String name;

   OneCodeTaskTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<OneCodeTaskTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
