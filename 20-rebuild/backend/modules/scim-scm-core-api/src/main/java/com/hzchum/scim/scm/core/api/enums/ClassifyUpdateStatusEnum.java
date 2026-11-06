package com.hzchum.scim.scm.core.api.enums;

public enum ClassifyUpdateStatusEnum {
   ALL_UPDATE(1, "全部可以更改"),
   ONLY_NAME_UPDATE(2, "只可以更改名称"),
   ALL_CANNOT_UPDATE(3, "全部不可以更改");

   private final Integer type;
   private final String name;

   ClassifyUpdateStatusEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
