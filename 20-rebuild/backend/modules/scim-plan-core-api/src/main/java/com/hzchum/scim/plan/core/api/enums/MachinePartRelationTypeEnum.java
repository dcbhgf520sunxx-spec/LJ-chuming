package com.hzchum.scim.plan.core.api.enums;

public enum MachinePartRelationTypeEnum {
   FOR_ARTIFACT(2, "普通零件"),
   EQUALS_AUXILIARY(8, "配套件"),
   FOR_ASSEMBLE(16, "翼腹板"),
   EQUALS_ASSEMBLE(18, "焊接部件(单元件)"),
   FOR_ASSEMBLE_TYPESETTING(32, "母件-翼腹板"),
   SPACER_PARALLEL(64, "垫块");

   private final Integer type;
   private final String desc;

   MachinePartRelationTypeEnum(final Integer type, final String desc) {
      this.type = type;
      this.desc = desc;
   }

   public Integer getType() {
      return this.type;
   }

   public String getDesc() {
      return this.desc;
   }
}
