package com.hzchum.scim.plan.core.api.enums;

public enum ArtifactChangeTypeEnum {
   UPDATE(1, "修改(二次利用)"),
   DEL(2, "删除"),
   UPDATE_BASIC(4, "修改(基础信息)");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ArtifactChangeTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
