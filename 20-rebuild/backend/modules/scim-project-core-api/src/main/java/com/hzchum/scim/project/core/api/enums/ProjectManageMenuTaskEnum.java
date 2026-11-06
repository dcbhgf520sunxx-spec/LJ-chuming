package com.hzchum.scim.project.core.api.enums;

public enum ProjectManageMenuTaskEnum {
   INSTALL(1, "安装"),
   ATTENDANCE(2, "考勤"),
   SAFETY(4, "质安"),
   INSTALL_AUDIT(8, "安装审核"),
   VISA_AUDIT(16, "签证审核"),
   OVER(32, "加班通知");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProjectManageMenuTaskEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
