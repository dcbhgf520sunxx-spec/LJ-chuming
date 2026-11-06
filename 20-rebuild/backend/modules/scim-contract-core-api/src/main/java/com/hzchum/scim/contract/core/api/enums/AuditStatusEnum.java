package com.hzchum.scim.contract.core.api.enums;

public enum AuditStatusEnum {
   AUDITING(1, "未审核"),
   SUCCEED(2, "审核通过"),
   FAILED(4, "已驳回"),
   CANCEL(8, "撤销");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      AuditStatusEnum[] values = values();

      for (AuditStatusEnum statusEnum : values) {
         if (statusEnum.getType().equals(type)) {
            return statusEnum.getName();
         }
      }

      return null;
   }

   AuditStatusEnum(final Integer type, final String name) {
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
