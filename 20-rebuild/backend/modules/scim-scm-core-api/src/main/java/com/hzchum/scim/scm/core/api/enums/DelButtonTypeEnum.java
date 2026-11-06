package com.hzchum.scim.scm.core.api.enums;

public enum DelButtonTypeEnum {
   BU_ZHAN_SHI(0, "不展示"),
   CHE_XIAO(1, "撤销"),
   SHAN_CHU(2, "删除"),
   CHE_XIAO_SHAN_CHU(3, "撤销删除"),
   CHE_XIAO_BIAN_JI(4, "撤销编辑");

   private final Integer type;
   private final String name;

   DelButtonTypeEnum(Integer type, String name) {
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
