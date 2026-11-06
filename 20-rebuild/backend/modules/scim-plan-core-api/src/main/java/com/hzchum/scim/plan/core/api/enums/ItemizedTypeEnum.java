package com.hzchum.scim.plan.core.api.enums;

public enum ItemizedTypeEnum {
   ARTIFACT(1, "结构分项"),
   ENCLOSURE(8, "围护分项"),
   PAINTING(16, "涂装分项"),
   WINDOWS(32, "门窗分项"),
   OTHER(64, "其他分项");

   private final Integer type;
   private final String name;

   public static String getEnum(Integer type) {
      for (ItemizedTypeEnum itemizedTypeEnum : values()) {
         if (itemizedTypeEnum.getType().equals(type)) {
            return itemizedTypeEnum.getName();
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

   ItemizedTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
