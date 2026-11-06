package com.hzchum.scim.mes.building.core.api.enums.scheduling;

public enum CutStatusEnum {
   NOT_CUT(0, "未切割"),
   CUTTING(1, "切割中"),
   CUT_COMPLETED(2, "切割完毕");

   private final int code;
   private final String description;

   CutStatusEnum(int code, String description) {
      this.code = code;
      this.description = description;
   }

   public int getCode() {
      return this.code;
   }

   public String getDescription() {
      return this.description;
   }

   public static CutStatusEnum fromCode(int code) {
      for (CutStatusEnum status : values()) {
         if (status.code == code) {
            return status;
         }
      }

      throw new IllegalArgumentException("No enum constant with code " + code);
   }
}
