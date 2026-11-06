package com.hzchum.scim.crm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CrmTenderRequestConfigEnum {
   BIDDING_METHOD(1, "招标方式"),
   BID_EVALUATION_METHOD(2, "评标方法"),
   TENDER_SUBMISSION_METHOD(3, "标书提交方式"),
   SETTLEMENT_METHOD(4, "结算方式"),
   TYPE_OF_PERFORMANCE_BOND(5, "履约保证金类型"),
   JOB_DESCRIPTION(6, "工作内容");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<CrmTenderRequestConfigEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   CrmTenderRequestConfigEnum(final Integer type, final String name) {
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
