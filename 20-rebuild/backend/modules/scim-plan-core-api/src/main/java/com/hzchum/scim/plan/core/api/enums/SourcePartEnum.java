package com.hzchum.scim.plan.core.api.enums;

public enum SourcePartEnum {
   DIRECTLY_IMPORT(1, "直接导入"),
   COMPONENT_DISASSEMBLY(2, "部件拆分"),
   COMPONENT_COMBINATION(4, "部件组合");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SourcePartEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
