package com.hzchum.scim.common.core.api.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalSageUtils {
   public static final BigDecimal G_TO_KG_CONVERSION = BigDecimal.valueOf(1000L);
   public static final BigDecimal KG_TO_TON_CONVERSION = BigDecimal.valueOf(1000L);

   public static BigDecimal divideSafe(BigDecimal dividend, BigDecimal divisor, int scale, RoundingMode roundingMode) {
      return divisor != null && divisor.compareTo(BigDecimal.ZERO) != 0 ? dividend.divide(divisor, scale, roundingMode) : BigDecimal.ZERO;
   }
}
