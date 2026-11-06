package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProjectSubjectStatusEnum {
   UNDERWAY(0, "进行中"),
   COMPLETED(1, "已完成"),
   ABANDON(2, "已废弃");

   private Integer type;
   private String name;

   ProjectSubjectStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ProjectSubjectStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
