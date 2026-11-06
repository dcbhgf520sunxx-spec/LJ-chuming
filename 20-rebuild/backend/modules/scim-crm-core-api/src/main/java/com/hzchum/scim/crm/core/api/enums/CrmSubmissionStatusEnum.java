package com.hzchum.scim.crm.core.api.enums;

public enum CrmSubmissionStatusEnum {
   REPORTED(1, "已提报"),
   NO_REPORTED(2, "未提报"),
   PARTIAL_SUBMISSION(3, "部份提报");

   private final Integer type;
   private final String name;

   CrmSubmissionStatusEnum(final Integer type, final String name) {
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
