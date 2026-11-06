package com.hzchum.scim.crm.core.api.constants;

public class CrmRedisConstants {
   public static final String CRM_INQUIRE_INTERVAL = "CRM_INQUIRE_INTERVAL:";

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmRedisConstants)) {
         return false;
      }

      CrmRedisConstants other = (CrmRedisConstants)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmRedisConstants;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "CrmRedisConstants()";
   }
}
