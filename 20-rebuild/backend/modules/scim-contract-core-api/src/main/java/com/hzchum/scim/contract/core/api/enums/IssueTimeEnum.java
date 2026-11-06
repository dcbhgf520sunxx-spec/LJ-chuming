package com.hzchum.scim.contract.core.api.enums;

public enum IssueTimeEnum {
   NOT_RECOVERY(0, "未回收"),
   ONE_MONTH(1, "一月发"),
   TWO_MONTH(2, "二月发"),
   THREE_MONTH(3, "三月发"),
   FOUR_MONTH(4, "四月发"),
   FIVE_MONTH(5, "五月发"),
   SIX_MONTH(6, "六月发"),
   SEVEN_MONTH(7, "七月发"),
   EIGHT_MONTH(8, "八月发"),
   NINE_MONTH(9, "九月发"),
   TEN_MONTH(10, "十月发"),
   ELEVEN_MONTH(11, "十一月发"),
   TWELVE_MONTH(12, "十二月发");

   private Integer type;
   private String name;

   IssueTimeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(Integer type) {
      for (IssueTimeEnum issueTimeEnum : values()) {
         if (issueTimeEnum.getType().equals(type)) {
            return issueTimeEnum.getName();
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
}
