package com.hzchum.scim.contract.core.api.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ExpenseTypeCategoryEnum {
   OTHER_CATEGORY(1, "其他类"),
   WAGE_CATEGORY(2, "工资类");

   private final int type;
   private final String name;
   private static final Map<Integer, ExpenseTypeCategoryEnum> enumMap = Stream.of(values())
      .collect(Collectors.toMap(ExpenseTypeCategoryEnum::getType, Function.identity()));

   public static String getNameByType(Integer type) {
      ExpenseTypeCategoryEnum e = enumMap.get(type);
      return e == null ? null : e.getName();
   }

   public static Boolean isExist(Integer type) {
      return enumMap.get(type) != null;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ExpenseTypeCategoryEnum(final int type, final String name) {
      this.type = type;
      this.name = name;
   }
}
