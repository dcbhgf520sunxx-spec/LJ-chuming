package com.hzchum.scim.common.core.api.enums;

public enum ApproveObjectTypeEnum {
   DEPARTMENT(1, "部门"),
   JOB(2, "岗位"),
   PERSON(3, "个人"),
   COMPANY(4, "公司");

   private Integer type;
   private String name;

   ApproveObjectTypeEnum(int type, String name) {
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
