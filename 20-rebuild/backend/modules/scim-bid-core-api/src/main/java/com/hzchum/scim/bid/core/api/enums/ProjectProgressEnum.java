package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProjectProgressEnum {
   UNAUDITED(0, "待审核"),
   NOT_PASS(1, "审核未通过"),
   RELEASED(2, "未开标"),
   NOT_START(3, "开标中"),
   IS_START(4, "已暂停"),
   OBSOLETE(5, "已结束"),
   PAUSED(6, "已废标"),
   PAST_DUE(7, "已过期");

   private Integer type;
   private String name;

   ProjectProgressEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ProjectProgressEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      Optional<ProjectProgressEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
