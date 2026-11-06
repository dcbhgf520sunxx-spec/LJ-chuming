package com.hzchum.scim.common.core.api.pojo.common;

import java.math.BigDecimal;

public class CommonValue {
   public static final BigDecimal ORDINARY_STEEL = new BigDecimal("7.85");
   public static final BigDecimal STAINLESS_STEEL = new BigDecimal("7.93");

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommonValue)) {
         return false;
      }

      CommonValue other = (CommonValue)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CommonValue;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "CommonValue()";
   }
}
