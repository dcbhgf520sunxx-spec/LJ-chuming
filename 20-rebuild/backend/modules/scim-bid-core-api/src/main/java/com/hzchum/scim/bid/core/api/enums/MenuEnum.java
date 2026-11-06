package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MenuEnum {
   ALL(0, "招标列表"),
   RESPONSIVE(1, "应标中"),
   BID_OPENING(2, "开标中"),
   FINISH(3, "已结束");

   private Integer type;
   private String name;

   MenuEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<MenuEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
