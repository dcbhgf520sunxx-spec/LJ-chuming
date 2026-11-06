package com.hzchum.scim.mes.building.core.api.enums.scheduling;

public enum CutSendEnum {
   NOT_DISPATCHED(0, "未下发"),
   DISPATCHED(1, "已下发");

   private final int code;
   private final String description;

   CutSendEnum(int code, String description) {
      this.code = code;
      this.description = description;
   }

   public int getCode() {
      return this.code;
   }

   public String getDescription() {
      return this.description;
   }

   public static CutSendEnum fromCode(int code) {
      for (CutSendEnum status : values()) {
         if (status.code == code) {
            return status;
         }
      }

      throw new IllegalArgumentException("No enum constant with code " + code);
   }

   public static CutSendEnum fromDescription(String description) {
      for (CutSendEnum status : values()) {
         if (status.description.equalsIgnoreCase(description)) {
            return status;
         }
      }

      throw new IllegalArgumentException("No enum constant with description " + description);
   }
}
