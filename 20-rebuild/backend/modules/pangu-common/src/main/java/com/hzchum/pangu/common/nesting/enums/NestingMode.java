package com.hzchum.pangu.common.nesting.enums;

public enum NestingMode {
   LOSS_LESS(1),
   LOSS(2);

   private final Integer type;

   NestingMode(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
