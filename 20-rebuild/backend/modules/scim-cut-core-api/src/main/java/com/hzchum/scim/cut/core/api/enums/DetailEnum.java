package com.hzchum.scim.cut.core.api.enums;

public enum DetailEnum {
   UNASSIGNED("0", "未分配"),
   ASSIGNED("1", "已分配"),
   ISSUED("2", "已下发"),
   CUTTING("3", "切割中"),
   CUT("4", "切割完成"),
   SUSPEND("5", "暂停"),
   TARMINATION("6", "终止");

   private final String code;
   private final String msg;

   public String getCode() {
      return this.code;
   }

   public String getMsg() {
      return this.msg;
   }

   DetailEnum(final String code, final String msg) {
      this.code = code;
      this.msg = msg;
   }
}
