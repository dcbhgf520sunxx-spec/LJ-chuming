package com.hzchum.pangu.common.enums;

import java.util.Arrays;
import java.util.Optional;

public enum InterceptedTableListEnum {
   ALL_TABLE("ALL"),
   PROJECT("contract_project");

   private final String table;

   public static boolean isExist(String table) {
      Optional<InterceptedTableListEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getTable().equals(table)).findFirst();
      return optional.isPresent();
   }

   InterceptedTableListEnum(final String table) {
      this.table = table;
   }

   public String getTable() {
      return this.table;
   }
}
