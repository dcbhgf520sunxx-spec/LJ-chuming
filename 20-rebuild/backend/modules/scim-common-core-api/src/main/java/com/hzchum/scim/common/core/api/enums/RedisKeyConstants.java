package com.hzchum.scim.common.core.api.enums;

public class RedisKeyConstants {
   public static final String SUBJECT = "wms-subject";
   public static final String HASH_CLASSIFICATION_ALL = "wms-hash-classification-all";
   public static final String SUBJECT_MEASURE_DTO = "subjectMeasureDTO";
   public static final String PROGRAM_NAME_SERIAL_NO = "program_name_serial_no";
   public static final String FORGET_THE_PASSWORD = "forget_the_password";
   public static final String HASH_STEEL_DENSITY_CONFIG = "wms-hash-steel-density";
   public static final String INSTANT_MESSAGE_HINT = "instant_message_hint";
   public static final String WAREHOUSE_LAST_MONTH_INVENTORY_AMOUNT = "warehouse_last_month_inventory_amount";
   public static final String WAREHOUSE_INVENTORY_RATIO = "warehouse_inventory_ratio";
   public static final String WAREHOUSE_INBOUND_AND_OUTBOUND_DATA = "warehouse_inbound_and_outbound_data";
   public static final String WAREHOUSE_STEEL_STOCK_TURNOVER = "warehouse_steel_stock_turnover";
   public static final String WAREHOUSE_PROJECT_STEEL_COUNT = "warehouse_project_steel_count";
   public static final String WAREHOUSE_MONTH_REALTIME_INVENTORY_AMOUNT = "warehouse_month_realtime_inventory_amount";

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RedisKeyConstants)) {
         return false;
      }

      RedisKeyConstants other = (RedisKeyConstants)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RedisKeyConstants;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "RedisKeyConstants()";
   }
}
