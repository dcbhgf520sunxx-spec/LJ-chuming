package com.hzchum.scim.plan.core.api.enums;

public enum BindStatusEnum {
   UN_BIND(1, "未绑定文件"),
   BIND_CURRENT(2, "绑定当前文件"),
   BIND_OTHER(4, "绑定其他文件");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   BindStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
