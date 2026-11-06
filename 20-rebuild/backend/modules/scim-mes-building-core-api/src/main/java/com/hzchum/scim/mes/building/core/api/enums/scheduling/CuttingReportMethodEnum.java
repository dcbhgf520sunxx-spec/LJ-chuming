package com.hzchum.scim.mes.building.core.api.enums.scheduling;

public enum CuttingReportMethodEnum {
   APP(1, "APP"),
   DEVICE_COLLECTION(2, "设备采集");

   private final int code;
   private final String value;

   CuttingReportMethodEnum(int code, String value) {
      this.code = code;
      this.value = value;
   }

   public int getCode() {
      return this.code;
   }

   public String getValue() {
      return this.value;
   }

   public static CuttingReportMethodEnum fromCode(int code) {
      for (CuttingReportMethodEnum type : values()) {
         if (type.getCode() == code) {
            return type;
         }
      }

      throw new IllegalArgumentException("Invalid code: " + code);
   }

   @Override
   public String toString() {
      return this.code + ": " + this.value;
   }
}
