package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum PayTypeEnum {
   PUBLIC_TRANSFER(1, "对公转账"),
   PRIVATE_TRANSFER(2, "对私转账"),
   OTHER(4, "其他"),
   ACCEPTANCE_DRAFT(8, "承兑汇票"),
   TRANSFER_CHECK(16, "转账支票"),
   CASH(32, "现金"),
   ALLOT_ACCOUNT(64, "调账"),
   GIVE_UP_PROFIT(128, "让利"),
   EXCHANGE_ACCOUNT(256, "兑账");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<PayTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(PayTypeEnum::getName).orElse(null);
   }

   PayTypeEnum(final Integer type, final String name) {
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
