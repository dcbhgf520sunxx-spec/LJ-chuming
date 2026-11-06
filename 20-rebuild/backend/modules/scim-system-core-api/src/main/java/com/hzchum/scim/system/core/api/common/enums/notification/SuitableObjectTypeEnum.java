package com.hzchum.scim.system.core.api.common.enums.notification;

public enum SuitableObjectTypeEnum {
   SYS_DEFAULT(0, "系统默认固定"),
   PERSONAGE(1, "个人类型"),
   JOB(2, "岗位类型"),
   DEPT(3, "部门类型");

   private int type;
   private String name;

   SuitableObjectTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
