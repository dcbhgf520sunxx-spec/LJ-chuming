package com.hzchum.scim.mes.building.core.api.enums.task;

import java.util.Objects;
import java.util.stream.Stream;

public enum IssuedToNestingSoftwareStatusEnum {
   NOT_ISSUED_YET(1, "未下发"),
   ISSUED_IN_PROGRESS(2, "下发中"),
   ISSUED(4, "已下发"),
   ISSUANCE_FAILED(8, "下发失败");

   private final int type;
   private final String name;

   public static boolean isExists(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   IssuedToNestingSoftwareStatusEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
