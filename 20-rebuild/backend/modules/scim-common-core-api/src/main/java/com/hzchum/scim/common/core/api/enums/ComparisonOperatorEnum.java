package com.hzchum.scim.common.core.api.enums;

public enum ComparisonOperatorEnum {
   LESS_THAN(1, "<", "小于"),
   LESS_THAN_EQUAL(2, "≤", "小于等于"),
   GREATER_THAN(3, ">", "大于"),
   GREATER_THAN_EQUAL(4, "≥", "大于等于"),
   EQUAL(5, "=", "等于");

   private final Integer type;
   private final String symbol;
   private final String name;

   public static ComparisonOperatorEnum getEnum(Integer type) {
      for (ComparisonOperatorEnum e : values()) {
         if (e.getType().equals(type)) {
            return e;
         }
      }

      return null;
   }

   public static String getNameByType(Integer type) {
      for (ComparisonOperatorEnum e : values()) {
         if (e.getType().equals(type)) {
            return e.getName();
         }
      }

      return null;
   }

   public static String getSymbolByType(Integer type) {
      for (ComparisonOperatorEnum e : values()) {
         if (e.getType().equals(type)) {
            return e.getSymbol();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      for (ComparisonOperatorEnum e : values()) {
         if (e.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public Integer getType() {
      return this.type;
   }

   public String getSymbol() {
      return this.symbol;
   }

   public String getName() {
      return this.name;
   }

   ComparisonOperatorEnum(final Integer type, final String symbol, final String name) {
      this.type = type;
      this.symbol = symbol;
      this.name = name;
   }
}
