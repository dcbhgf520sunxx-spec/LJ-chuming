package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProjectBidStatusEnum {
   UNAUDITED(0, "未审核"),
   NOT_PASS(1, "未通过"),
   RELEASED(2, "已通过");

   private Integer type;
   private String name;

   ProjectBidStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ProjectBidStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
