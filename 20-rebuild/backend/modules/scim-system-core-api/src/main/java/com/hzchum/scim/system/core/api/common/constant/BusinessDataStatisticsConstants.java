package com.hzchum.scim.system.core.api.common.constant;

public class BusinessDataStatisticsConstants {
   public static final String BIM_MODEL_CONVERT_RESTRICT = "BIM_MODEL_CONVERT_RESTRICT";
   public static final String TOTAL_QUANTITY = "TOTAL_QUANTITY";
   public static final String FILE_SIZE = "FILE_SIZE";

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessDataStatisticsConstants)) {
         return false;
      }

      BusinessDataStatisticsConstants other = (BusinessDataStatisticsConstants)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessDataStatisticsConstants;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "BusinessDataStatisticsConstants()";
   }
}
