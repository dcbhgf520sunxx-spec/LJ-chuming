package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public enum ReviewStatusEnum {
   UN_REVIEWED(1, "待审核"),
   REVIEWED(2, "审核通过"),
   RETURNED(4, "审核退回"),
   CANCEL(8, "撤销"),
   AUDITING(16, "审核中"),
   INVOLUNTARY_INTERRUPT(32, "意外中断"),
   NOT_SUBMITTED(64, "未提交");

   private Integer type;
   private String name;

   ReviewStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ReviewStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer reviewStatus) {
      for (ReviewStatusEnum r : values()) {
         if (r.getType().equals(reviewStatus)) {
            return r.name;
         }
      }

      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static String getName(Integer type) {
      return Stream.of(values())
         .filter(e -> Objects.equals(e.getType(), type))
         .map(ReviewStatusEnum::getName)
         .findFirst()
         .orElseThrow(() -> new IllegalArgumentException("审批状态不存在"));
   }
}
